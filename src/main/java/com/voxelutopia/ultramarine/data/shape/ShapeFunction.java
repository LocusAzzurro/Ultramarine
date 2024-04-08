package com.voxelutopia.ultramarine.data.shape;

import com.google.common.collect.Maps;
import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import com.voxelutopia.ultramarine.world.block.state.OrientableBlockType;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

public class ShapeFunction implements Function<BlockState, VoxelShape> {

    private static final Map<Pair<Direction, Direction>, Integer> ROTATIONS;
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

    public static ShapeFunction or(ShapeFunction a, ShapeFunction b){
        return new ShapeFunction(state -> Shapes.or(a.apply(state), b.apply(state)));
    }

    public static ShapeFunction or(ShapeFunction a, ShapeFunction... b){
        return Arrays.stream(b).reduce(a, ShapeFunction::or);
    }

    public static ShapeFunction exclude(ShapeFunction a, ShapeFunction b){
        return new ShapeFunction(state -> Shapes.join(a.apply(state), b.apply(state), BooleanOp.ONLY_FIRST));
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
                    case DOWN, UP -> Shapes.empty();
                    case NORTH -> northShape.copy().toVoxelShape();
                    case SOUTH -> northShape.copy().rotateY(180).toVoxelShape();
                    case WEST -> northShape.copy().rotateY(90).toVoxelShape();
                    case EAST -> northShape.copy().rotateY(270).toVoxelShape();
                };
            } else if (ROTATIONS.containsKey(Pair.of(primaryDir, shiftDir))) {
                return northShape.copy().rotateY(ROTATIONS.get((Pair.of(primaryDir, shiftDir))) + diagonalRotationOffset).toVoxelShape();
            }
            else return northShape.copy().toVoxelShape();
        });
    }

    public static ShapeFunction cardinalRotations(RawVoxelShape northShape){
        return new ShapeFunction(
                state -> {
                    Direction direction = state.getValue(HorizontalDirectionalBlock.FACING);
                    return switch (direction){
                        case DOWN, UP -> Shapes.empty();
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
                        case X -> xShape.copy().toVoxelShape();
                        case Y -> Shapes.empty();
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

    public static ShapeFunction sideShape(int thickness){
        return cardinalRotations(new RawVoxelShape(0, 0, 16 - thickness, 16, 16, 16));
    }

    public static ShapeFunction sixSideShape(int thickness){
        return sixSideShape(new RawVoxelShape(0, 0, 16 - thickness, 16, 16, 16), new RawVoxelShape(0, 0, 0, 16, thickness, 16));
    }

    //values from north facing left orientation
    public static ShapeFunction sideOrientedShape(RawVoxelShape northLeftShape){
        return new ShapeFunction(
                state -> {
                    Direction facing = state.getValue(HorizontalDirectionalBlock.FACING);
                    OrientableBlockType direction = state.getValue(ModBlockStateProperties.ORIENTABLE_BLOCK_TYPE);
                    RawVoxelShape northRightShape = northLeftShape.copy().mirrorZ();
                    RawVoxelShape shape = switch (direction){
                        case LEFT -> northLeftShape.copy();
                        case RIGHT -> northRightShape.copy();
                    };
                    return switch (facing){
                        case DOWN, UP -> Shapes.empty();
                        case NORTH -> shape.copy().toVoxelShape();
                        case SOUTH -> shape.copy().rotateY(180).toVoxelShape();
                        case WEST -> shape.copy().rotateY(90).toVoxelShape();
                        case EAST -> shape.copy().rotateY(270).toVoxelShape();
                    };
                });
    }

    public static ShapeFunction sixSideShape(RawVoxelShape northShape, RawVoxelShape topShape){
        return new ShapeFunction(
                state -> {
                    Direction facing = state.getValue(BlockStateProperties.FACING);
                    return switch (facing) {
                        case UP -> topShape.copy().toVoxelShape();
                        case DOWN -> topShape.copy().mirrorY().toVoxelShape();
                        case NORTH -> northShape.copy().toVoxelShape();
                        case SOUTH -> northShape.copy().rotateY(180).toVoxelShape();
                        case WEST -> northShape.copy().rotateY(90).toVoxelShape();
                        case EAST -> northShape.copy().rotateY(270).toVoxelShape();
                    };
                });
    }

    public static ShapeFunction orientedSixSideShape(RawVoxelShape northUpShape, RawVoxelShape topNorthShape){
        return new ShapeFunction(
                state -> {
                    Direction facing = state.getValue(BlockStateProperties.FACING);
                    Direction direction = state.getValue(ModBlockStateProperties.ON_FACE_DIRECTION);
                    RawVoxelShape shape;
                    if (facing == Direction.UP || facing == Direction.DOWN) {
                        shape = topNorthShape.copy();
                        if (facing == Direction.DOWN) shape = topNorthShape.copy().mirrorY();
                        switch (direction) {
                            case NORTH -> shape = shape.copy();
                            case SOUTH -> shape = shape.copy().rotateY(180);
                            case WEST -> shape = shape.copy().rotateY(90);
                            case EAST -> shape = shape.copy().rotateY(270);
                        }
                    }
                    else {
                        shape = northUpShape.copy();
                        if (facing.getClockWise() == direction) shape = shape.copy().rotateZ(-90);
                        else if (facing.getCounterClockWise() == direction) shape = shape.copy().rotateZ(90);
                        else if (direction == Direction.DOWN) shape = shape.copy().mirrorY();
                        switch (facing) {
                            case NORTH -> shape = shape.copy();
                            case SOUTH -> shape = shape.copy().rotateY(180);
                            case WEST -> shape = shape.copy().rotateY(90);
                            case EAST -> shape = shape.copy().rotateY(270);
                        }
                    }
                    return shape.toVoxelShape();
                });
    }

    public static ShapeFunction simpleShape(VoxelShape shape){
        return new ShapeFunction(state -> shape);
    }

    static {
        ROTATIONS = Map.of(
                Pair.of(Direction.NORTH, Direction.EAST), 135,
                Pair.of(Direction.EAST, Direction.NORTH), 135,
                Pair.of(Direction.EAST, Direction.SOUTH), 45,
                Pair.of(Direction.SOUTH, Direction.EAST), 45,
                Pair.of(Direction.SOUTH, Direction.WEST), 315,
                Pair.of(Direction.WEST, Direction.SOUTH), 315,
                Pair.of(Direction.WEST, Direction.NORTH), 225,
                Pair.of(Direction.NORTH, Direction.WEST), 225);
    }

}
