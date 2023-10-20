package com.voxelutopia.ultramarine.world.block;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;

import java.util.Map;

public interface AxialBlock {

    BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    default Map<Direction.Axis, VoxelShape> makeAxialShapes(int thickness, int bottom, int top) {
        VoxelShape XAABB = Block.box(0.0D, bottom, 8 - ((int) ((double) thickness / 2.0d)), 16.0D, top, 8 + ((int) ((double) thickness / 2.0d)));
        VoxelShape ZAABB = Block.box(8 - ((int) ((double) thickness / 2.0d)), bottom, 0.0D, 8 + ((int) ((double) thickness / 2.0d)), top, 16.0D);
        ImmutableMap.Builder<Direction.Axis, VoxelShape> builder = ImmutableMap.builder();
        builder.put(Direction.Axis.X, XAABB).put(Direction.Axis.Z, ZAABB);
        return builder.build();
    }

    default Map<Direction.Axis, VoxelShape> makeAxialShapes(int thickness, int height) {
        return makeAxialShapes(thickness, 0, height);
    }

    default Map<Direction.Axis, VoxelShape> makeAxialShapes(int thickness) {
        return makeAxialShapes(thickness, 16);
    }

    Direction.Axis getAxis(BlockState pState);
}
