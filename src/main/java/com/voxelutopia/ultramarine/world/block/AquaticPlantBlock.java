package com.voxelutopia.ultramarine.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

public class AquaticPlantBlock extends DecorativeBlock {

    public AquaticPlantBlock(Builder builder) {
        super(builder);
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        return !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
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
