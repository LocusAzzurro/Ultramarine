package com.voxelutopia.ultramarine.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

public class AquaticPlantBlock extends DecorativeBlock {

    public AquaticPlantBlock(Builder builder) {
        super(builder);
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        return !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        var belowPos = pos.below();
        var belowState = level.getBlockState(belowPos);
        var sustainResult = belowState.canSustainPlant(level, belowPos, Direction.UP, state);
        if (!sustainResult.isDefault()) {
            return sustainResult.isTrue();
        }
        return this.mayPlaceOn(belowState, level, belowPos);
    }

    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        var fluid = level.getFluidState(pos);
        var fluidUpper = level.getFluidState(pos.above());
        return (fluid.getType() == Fluids.WATER || state.getBlock() instanceof IceBlock)
                && fluidUpper.isEmpty();
    }
}
