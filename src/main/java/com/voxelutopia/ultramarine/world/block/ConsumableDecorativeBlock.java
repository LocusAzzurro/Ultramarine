package com.voxelutopia.ultramarine.world.block;

import com.mojang.datafixers.util.Pair;
import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;

import java.util.function.Supplier;

public class ConsumableDecorativeBlock extends DecorativeBlock {

    public static final IntegerProperty BITES = ModBlockStateProperties.BITES;
    private final int bites;
    private final ConsumeAction finishedAction;
    private final ConsumeAction eatAction;
    private final Supplier<ItemStack> plate;
    private final Food food;
    public static ConsumeAction DEFAULT_FINISH_ACTION = ((pState, pLevel, pPos, pPlayer) -> {
        pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 3);
        ItemHandlerHelper.giveItemToPlayer(pPlayer, (pState.getBlock() instanceof ConsumableDecorativeBlock) ? ((ConsumableDecorativeBlock) pState.getBlock()).getPlate() : ItemStack.EMPTY);
        //pLevel.gameEvent(pPlayer, GameEvent.BLOCK_DESTROY, pPos);
        // Not implemented in 1.16
    });
    public static ConsumeAction DEFAULT_EAT_ACTION = ((pState, pLevel, pPos, pPlayer) -> {
        if (pState.getBlock() instanceof ConsumableDecorativeBlock) {
            Food food = ((ConsumableDecorativeBlock) pState.getBlock()).getFood();
            pPlayer.getFoodData().eat(food.getNutrition(), food.getSaturationModifier());
            for (Pair<EffectInstance, Float> pair : food.getEffects()) {
                if (!pLevel.isClientSide && pair.getFirst() != null && pLevel.random.nextFloat() < pair.getSecond()) {
                    pPlayer.addEffect(new EffectInstance(pair.getFirst()));
                }
            }
            pLevel.playSound(pPlayer, pPos, SoundEvents.GENERIC_EAT, SoundCategory.PLAYERS, 1, 0.75f);
            // pLevel.gameEvent(pPlayer, GameEvent.EAT, pPos);
            // Not implemented in 1.16
        }
    });

    public ConsumableDecorativeBlock(Builder builder) {
        super(builder);
        this.bites = builder.bites;
        this.finishedAction = builder.finishedAction;
        this.eatAction = builder.eatAction;
        this.plate = builder.plate;
        this.food = builder.food;
        this.registerDefaultState(this.getStateDefinition().any().setValue(BITES, bites));
    }

    public static Builder with(BaseBlockProperty property) {
        return new Builder(property);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        BlockState state = super.getStateForPlacement(pContext);
        return state.hasProperty(BITES) ? state.setValue(BITES, getMaxBites()) : state;
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType use(BlockState pState, World pLevel, BlockPos pPos, PlayerEntity pPlayer, Hand pHand, BlockRayTraceResult pHit) {
        int bitesRemaining = pState.hasProperty(BITES) ? pState.getValue(BITES) : 0;
        if (!pPlayer.canEat(false)) {
            return ActionResultType.PASS;
        }
        if (bitesRemaining > 0) {
            this.eatAction.consume(pState, pLevel, pPos, pPlayer);
            bitesRemaining--;
        }
        if (bitesRemaining <= 0) {
            this.finishedAction.consume(pState, pLevel, pPos, pPlayer);
        } else {
            pLevel.setBlock(pPos, pState.setValue(BITES, bitesRemaining), 3);
        }
        return ActionResultType.sidedSuccess(pLevel.isClientSide());
    }

    public int getMaxBites() {
        return bites;
    }

    public ItemStack getPlate() {
        return plate.get();
    }

    public Food getFood() {
        return food;
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(BITES);
    }

    @SuppressWarnings("unused")
    public static class Builder extends DecorativeBlock.Builder {

        private static final Food DEFAULT_FOOD = new Food.Builder().nutrition(2).saturationMod(0.2f).build();
        private int bites = 4;
        private Supplier<ItemStack> plate = () -> new ItemStack(Blocks.STONE_SLAB);
        private ConsumeAction eatAction = DEFAULT_EAT_ACTION;
        private ConsumeAction finishedAction = DEFAULT_FINISH_ACTION;
        private Food food = DEFAULT_FOOD;


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

        public Builder food(Food food) {
            this.food = food;
            return this;
        }

        public ConsumableDecorativeBlock build() {
            return new ConsumableDecorativeBlock(this);
        }
    }

    @FunctionalInterface
    public interface ConsumeAction {

        void consume(BlockState pState, World pLevel, BlockPos pPos, PlayerEntity pPlayer);
    }
}
