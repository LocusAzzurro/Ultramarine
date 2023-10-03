package com.voxelutopia.ultramarine.common.block;

import com.mojang.datafixers.util.Pair;
import com.voxelutopia.ultramarine.common.block.state.ModBlockStateProperties;
import com.voxelutopia.ultramarine.util.ItemHandlerHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ConsumableDecorativeBlock extends DecorativeBlock {

    public static final IntegerProperty BITES = ModBlockStateProperties.BITES;
    public static ConsumeAction DEFAULT_FINISH_ACTION = ((pState, pLevel, pPos, pPlayer) -> {
        pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);

        ItemHandlerHelper.giveItemToPlayer(pPlayer, (pState.getBlock() instanceof ConsumableDecorativeBlock consumable) ? consumable.getPlate() : ItemStack.EMPTY);
        pLevel.gameEvent(pPlayer, GameEvent.BLOCK_DESTROY, pPos);
    });
    public static ConsumeAction DEFAULT_EAT_ACTION = ((pState, pLevel, pPos, pPlayer) -> {
        if (pState.getBlock() instanceof ConsumableDecorativeBlock consumable) {
            var food = consumable.getFood();
            pPlayer.getFoodData().eat(food.getNutrition(), food.getSaturationModifier());
            for (Pair<MobEffectInstance, Float> pair : food.getEffects()) {
                if (!pLevel.isClientSide && pair.getFirst() != null && pLevel.random.nextFloat() < pair.getSecond()) {
                    pPlayer.addEffect(new MobEffectInstance(pair.getFirst()));
                }
            }
            pLevel.playSound(pPlayer, pPos, SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 1, 0.75f);
            pLevel.gameEvent(pPlayer, GameEvent.EAT, pPos);
        }
    });
    private final int bites;
    private final ConsumeAction finishedAction;
    private final ConsumeAction eatAction;
    private final Supplier<ItemStack> plate;
    private final FoodProperties food;

    public ConsumableDecorativeBlock(Builder builder) {
        super(builder);
        this.bites = builder.bites;
        this.finishedAction = builder.finishedAction;
        this.eatAction = builder.eatAction;
        this.plate = builder.plate;
        this.food = builder.food;
        this.registerDefaultState(this.stateDefinition.any().setValue(BITES, bites));
    }

    public static Builder with(BaseBlockProperty property) {
        return new Builder(property);
    }

    @Override
    @NotNull
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState state = super.getStateForPlacement(pContext);
        return state.hasProperty(BITES) ? state.setValue(BITES, getMaxBites()) : state;
    }

    @SuppressWarnings("deprecation")
    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        int bitesRemaining = pState.hasProperty(BITES) ? pState.getValue(BITES) : 0;
        if (!pPlayer.canEat(false)) {
            return InteractionResult.PASS;
        }
        if (bitesRemaining > 0) {
            this.eatAction.consume(pState, pLevel, pPos, pPlayer);
            bitesRemaining--;
        }
        if (bitesRemaining <= 0) {
            this.finishedAction.consume(pState, pLevel, pPos, pPlayer);
        } else {
            pLevel.setBlock(pPos, pState.setValue(BITES, bitesRemaining), Block.UPDATE_ALL);
        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    public int getMaxBites() {
        return bites;
    }

    public ItemStack getPlate() {
        return plate.get();
    }

    public FoodProperties getFood() {
        return food;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(BITES);
    }

    @FunctionalInterface
    public interface ConsumeAction {

        void consume(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer);
    }

    @SuppressWarnings("unused")
    public static class Builder extends DecorativeBlock.Builder {

        private static final FoodProperties DEFAULT_FOOD = new FoodProperties.Builder().nutrition(2).saturationMod(0.2f).build();
        private int bites = 4;
        private Supplier<ItemStack> plate = () -> new ItemStack(Blocks.STONE_SLAB);
        private ConsumeAction eatAction = DEFAULT_EAT_ACTION;
        private ConsumeAction finishedAction = DEFAULT_FINISH_ACTION;
        private FoodProperties food = DEFAULT_FOOD;


        public Builder(BaseBlockProperty property) {
            super(property);
        }

        public Builder bites(int bites) {
            this.bites = bites;
            return this;
        }

        public Builder whenFinished(ConsumeAction action) {
            this.finishedAction = action;
            return this;
        }

        public Builder onEat(ConsumeAction action) {
            this.eatAction = action;
            return this;
        }

        public Builder platedWith(ItemStack plate) {
            this.plate = () -> plate;
            return this;
        }

        public Builder platedWith(Block plate) {
            this.plate = () -> new ItemStack(plate);
            return this;
        }

        public Builder platedWith(Supplier<Item> plate) {
            this.plate = () -> new ItemStack(plate.get());
            return this;
        }

        public Builder food(FoodProperties food) {
            this.food = food;
            return this;
        }

        public ConsumableDecorativeBlock build() {
            return new ConsumableDecorativeBlock(this);
        }
    }
}
