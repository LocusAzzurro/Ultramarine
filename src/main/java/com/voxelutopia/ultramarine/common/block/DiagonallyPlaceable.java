package com.voxelutopia.ultramarine.common.block;

import com.voxelutopia.ultramarine.common.block.state.ModBlockStateProperties;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;

public interface DiagonallyPlaceable {
    BooleanProperty DIAGONAL = ModBlockStateProperties.DIAGONAL;

    boolean isDiagonallyPlaceable();

    default boolean getDiagonalState(@NotNull BlockPlaceContext pContext){
        return Math.round((pContext.getRotation() + 180.0F ) / 45.0F) % 2 == 1;
    }

    default int getOctaRotationState(BlockPlaceContext pContext){
        return Mth.floor((double) (pContext.getRotation() * 8.0F / 360.0F) + 0.5D) & 7;
    }

    default Pair<Direction, Direction> getMainAndShiftedDirections(BlockPlaceContext pContext){
        int rotation = getOctaRotationState(pContext);
        return switch (rotation) {
            default -> Pair.of(Direction.NORTH, Direction.NORTH);
            case 1 -> Pair.of(Direction.NORTH, Direction.EAST);
            case 2 -> Pair.of(Direction.EAST, Direction.EAST);
            case 3 -> Pair.of(Direction.EAST, Direction.SOUTH);
            case 4 -> Pair.of(Direction.SOUTH, Direction.SOUTH);
            case 5 -> Pair.of(Direction.SOUTH, Direction.WEST);
            case 6 -> Pair.of(Direction.WEST, Direction.WEST);
            case 7 -> Pair.of(Direction.WEST, Direction.NORTH);
        };
    }

    default void defineDiagonalProperty(StateDefinition.Builder<Block, BlockState> pBuilder){
        if (isDiagonallyPlaceable()) {
            pBuilder.add(DIAGONAL);
        }
    }

    default BlockState setDiagonalStateForPlacement(@NotNull BlockState state, BlockPlaceContext pContext){
        return isDiagonallyPlaceable() ? state.setValue(DIAGONAL, getDiagonalState(pContext)) : state;
    }
}
