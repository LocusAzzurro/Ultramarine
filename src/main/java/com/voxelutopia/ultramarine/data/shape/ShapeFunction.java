package com.voxelutopia.ultramarine.data.shape;

import net.minecraft.Util;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import java.util.function.Function;

public final class ShapeFunction {

    public static Function<BlockState, VoxelShape> cardinalRotations(RawVoxelShape northShape){
        return Util.memoize(
        state -> {
            Direction direction = state.getValue(HorizontalDirectionalBlock.FACING);
            return switch (direction){
                case DOWN, UP -> null;
                case NORTH -> northShape.copy().toVoxelShape();
                case SOUTH -> northShape.copy().rotateY(180).toVoxelShape();
                case WEST -> northShape.copy().rotateY(90).toVoxelShape();
                case EAST -> northShape.copy().rotateY(270).toVoxelShape();
            };
        });
    }

    public static Function<BlockState, VoxelShape> simpleShape(VoxelShape shape){
        return state -> shape;
    }


}
