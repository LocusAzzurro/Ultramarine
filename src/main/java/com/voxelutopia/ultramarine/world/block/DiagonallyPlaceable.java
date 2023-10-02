package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.MathHelper;
import org.apache.commons.lang3.tuple.Pair;

public interface DiagonallyPlaceable {
    BooleanProperty DIAGONAL = ModBlockStateProperties.DIAGONAL;

    boolean isDiagonallyPlaceable();

    default boolean getDiagonalState(BlockItemUseContext pContext) {
        return Math.round((pContext.getRotation() + 180.0F) / 45.0F) % 2 == 1;
    }

    default int getOctaRotationState(BlockItemUseContext pContext) {
        return MathHelper.floor((double) (pContext.getRotation() * 8.0F / 360.0F) + 0.5D) & 7;
    }

    default Pair<Direction, Direction> getMainAndShiftedDirections(BlockItemUseContext pContext) {
        int rotation = getOctaRotationState(pContext);
        switch (rotation) {
            case 1:
                return Pair.of(Direction.NORTH, Direction.EAST);
            case 2:
                return Pair.of(Direction.EAST, Direction.EAST);
            case 3:
                return Pair.of(Direction.EAST, Direction.SOUTH);
            case 4:
                return Pair.of(Direction.SOUTH, Direction.SOUTH);
            case 5:
                return Pair.of(Direction.SOUTH, Direction.WEST);
            case 6:
                return Pair.of(Direction.WEST, Direction.WEST);
            case 7:
                return Pair.of(Direction.WEST, Direction.NORTH);
        }
        ;
        return Pair.of(Direction.NORTH, Direction.NORTH);
    }

    default void defineDiagonalProperty(StateContainer.Builder<Block, BlockState> pBuilder) {
        if (isDiagonallyPlaceable()) {
            pBuilder.add(DIAGONAL);
        }
    }

    default BlockState setDiagonalStateForPlacement(BlockState state, BlockItemUseContext pContext) {
        return isDiagonallyPlaceable() ? state.setValue(DIAGONAL, getDiagonalState(pContext)) : state;
    }
}
