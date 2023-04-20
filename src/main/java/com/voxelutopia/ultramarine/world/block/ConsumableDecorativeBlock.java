package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.ModBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
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
import net.minecraftforge.items.ItemHandlerHelper;

public class ConsumableDecorativeBlock extends DecorativeBlock{

    public static final IntegerProperty BITES = ModBlockStateProperties.BITES;
    private final int bites;
    private final BlockConsumedAction consumedAction;
    private final Block plate;

    public ConsumableDecorativeBlock(Builder builder) {
        super(builder);
        this.bites = builder.bites;
        this.consumedAction = builder.consumedAction;
        this.plate = builder.plateBlock;
        this.registerDefaultState(this.stateDefinition.any().setValue(BITES, bites));
    }

    public static ContainerDecorativeBlock.Builder with(BaseBlockProperty property){
        return new ContainerDecorativeBlock.Builder(property);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(BITES, getBites());
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        int bitesRemaining = pState.hasProperty(BITES) ? pState.getValue(BITES) : 0;
        if (bitesRemaining > 0){
            pPlayer.getFoodData().eat(2, 0.1F);
            pLevel.gameEvent(pPlayer, GameEvent.EAT, pPos);
            bitesRemaining--;
        }
        if (bitesRemaining <= 0){
            this.consumedAction.consume(pState, pLevel, pPos, pPlayer);
        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    public int getBites(){
        return bites;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(BITES);
    }

    public static class Builder extends DecorativeBlock.Builder{

        private int bites = 4;
        private Block plateBlock = Blocks.STONE_SLAB;
        private BlockConsumedAction consumedAction = ((pState, pLevel, pPos, pPlayer) -> {
            pLevel.destroyBlock(pPos, false, pPlayer);
            ItemHandlerHelper.giveItemToPlayer(pPlayer, new ItemStack(plateBlock));
            pLevel.gameEvent(pPlayer, GameEvent.BLOCK_DESTROY, pPos);
        });

        public Builder(BaseBlockProperty property) {
            super(property);
        }

        public Builder bites(int charges){
            this.bites = charges;
            return this;
        }

        public Builder whenConsumed(BlockConsumedAction action){
            this.consumedAction = action;
            return this;
        }

        public Builder platedWith(Block plate){
            this.plateBlock = plate;
            return this;
        }

        public ConsumableDecorativeBlock build(){
            return new ConsumableDecorativeBlock(this);
        }
    }

    @FunctionalInterface
    public interface BlockConsumedAction{

        void consume(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer);
    }
}
