package com.voxelutopia.ultramarine.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;

public class RoofMainRidgeConnection extends BaseHorizontalDirectionalBlock implements SnowRoofRidge{

    private final DyeColor color;
    private final RoofRidgeType type;

    public RoofMainRidgeConnection(DyeColor color, RoofRidgeType type) {
        super(BaseBlockProperty.STONE);
        this.type = type;
        this.color = color;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(SNOW_LAYERS, 0));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        return SnowRoofRidge.super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(SNOW_LAYERS);
    }

    @Override
    public DyeColor getColor() {
        return color;
    }

    @Override
    public RoofRidgeType getType() {
        return type;
    }

}
