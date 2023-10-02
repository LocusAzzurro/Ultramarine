package com.voxelutopia.ultramarine.world.block;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;

import java.util.Map;

public interface SideBlock extends IWaterLoggable {
    default Map<Direction, VoxelShape> faceShapeByDirection(int thickness) {
        ImmutableMap.Builder<Direction, VoxelShape> builder = ImmutableMap.builder();
        builder.put(Direction.UP, Block.box(0, 0, 0, 16, thickness, 16));
        builder.put(Direction.DOWN, Block.box(0, 16 - (double) thickness, 0, 16, 16, 16));
        builder.put(Direction.NORTH, Block.box(0, 0, 16 - (double) thickness, 16, 16, 16));
        builder.put(Direction.SOUTH, Block.box(0, 0, 0, 16, 16, thickness));
        builder.put(Direction.EAST, Block.box(0, 0, 0, thickness, 16, 16));
        builder.put(Direction.WEST, Block.box(16 - (double) thickness, 0, 0, 16, 16, 16));
        return builder.build();
    }

    FluidState getFluidState(BlockState pState);
}
