package com.voxelutopia.ultramarine.world.block;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;
import java.util.function.Function;

public interface SideBlock extends SimpleWaterloggedBlock {

    static Map<Direction, VoxelShape> faceShapeByDirection(int thickness){
        double t = thickness;
        ImmutableMap.Builder<Direction, VoxelShape> builder = ImmutableMap.builder();
        builder.put(Direction.UP, Block.box(0, 0, 0, 16, t, 16));
        builder.put(Direction.DOWN, Block.box(0, 16 - t, 0, 16, 16, 16));
        builder.put(Direction.NORTH, Block.box(0, 0, 16 - t, 16, 16, 16));
        builder.put(Direction.SOUTH, Block.box(0, 0, 0, 16, 16, t));
        builder.put(Direction.EAST, Block.box(0, 0, 0, t, 16, 16));
        builder.put(Direction.WEST, Block.box(16 - t, 0, 0, 16, 16, 16));
        return builder.build();
    }

    FluidState getFluidState(BlockState pState);
}
