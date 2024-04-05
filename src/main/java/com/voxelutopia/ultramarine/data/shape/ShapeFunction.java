package com.voxelutopia.ultramarine.data.shape;

import com.google.common.collect.Maps;
import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import net.minecraft.Util;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Map;
import java.util.function.Function;

public class ShapeFunction implements Function<BlockState, VoxelShape> {

    static final Map<Pair<Direction, Direction>, Integer> rotations = Map.of(
            Pair.of(Direction.NORTH, Direction.EAST), 135,
            Pair.of(Direction.EAST, Direction.NORTH), 135,
            Pair.of(Direction.EAST, Direction.SOUTH), 45,
            Pair.of(Direction.SOUTH, Direction.EAST), 45,
            Pair.of(Direction.SOUTH, Direction.WEST), 315,
            Pair.of(Direction.WEST, Direction.SOUTH), 315,
            Pair.of(Direction.WEST, Direction.NORTH), 225,
            Pair.of(Direction.NORTH, Direction.WEST), 225);

    private final Function<BlockState, VoxelShape> processFunction;
    private final Map<BlockState, VoxelShape> cache = Maps.newConcurrentMap();

    private ShapeFunction(Function<BlockState, VoxelShape> processFunction){
        this.processFunction = processFunction;
    }

    @Override
    public VoxelShape apply(BlockState state) {
        return this.cache.computeIfAbsent(state, this.processFunction);
    }

    public static ShapeFunction of(Function<BlockState, VoxelShape> processFunction){
        return new ShapeFunction(processFunction);
    }

    public static ShapeFunction compose(ShapeFunction a, ShapeFunction b){
        return new ShapeFunction(state -> Shapes.or(a.apply(state), b.apply(state)));
    }

    public static ShapeFunction eightRotations(RawVoxelShape northShape){
        return eightRotations(northShape, 0);
    }

    public static ShapeFunction eightRotations(RawVoxelShape northShape, float diagonalRotationOffset){
        return new ShapeFunction(
        state -> {
            Direction primaryDir = state.getValue(HorizontalDirectionalBlock.FACING);
            Direction shiftDir = state.getValue(ModBlockStateProperties.HORIZONTAL_FACING_SHIFT);
            if (primaryDir == shiftDir) {
                return switch (primaryDir){
                    case DOWN, UP -> null;
                    case NORTH -> northShape.copy().toVoxelShape();
                    case SOUTH -> northShape.copy().rotateY(180).toVoxelShape();
                    case WEST -> northShape.copy().rotateY(90).toVoxelShape();
                    case EAST -> northShape.copy().rotateY(270).toVoxelShape();
                };
            } else if (rotations.containsKey(Pair.of(primaryDir, shiftDir))) {
                return northShape.copy().rotateY(rotations.get((Pair.of(primaryDir, shiftDir))) + diagonalRotationOffset).toVoxelShape();
            }
            else return northShape.copy().toVoxelShape();
        });
    }

    public static ShapeFunction cardinalRotations(RawVoxelShape northShape){
        return new ShapeFunction(
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

    public static ShapeFunction axialRotations(RawVoxelShape xShape){
        return new ShapeFunction(
                state -> {
                    Direction.Axis axis = state.getValue(BlockStateProperties.HORIZONTAL_AXIS);
                    return switch (axis){
                        case X, Y -> xShape.copy().toVoxelShape();
                        case Z -> xShape.copy().rotateY(90).toVoxelShape();
                    };
                });
    }

    public static ShapeFunction centeredSquare(int side, int height){
        float d = (16f - side) / 2f;
        return simpleShape(Block.box(d, 0, d, 16 - d, height, 16 - d));
    }

    public static ShapeFunction diagonalSquare(int side, int height){
        return new ShapeFunction(
                state -> {
                    boolean diagonal = state.getValue(ModBlockStateProperties.DIAGONAL);
                    float s = diagonal ? side * Mth.SQRT_OF_TWO : side;
                    float d = (16 - s)/2;
                    return Block.box(d, 0, d, 16 - d, height, 16 - d);
                });
    }

    public static ShapeFunction simpleShape(VoxelShape shape){
        return new ShapeFunction(state -> shape);
    }


}
