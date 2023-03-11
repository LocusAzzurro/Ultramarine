package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.ModBlockStateProperties;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.NotNull;

public interface DiagonallyPlaceable {
    BooleanProperty DIAGONAL = ModBlockStateProperties.DIAGONAL;

    boolean isDiagonallyPlaceable();

    default boolean getDiagonalStateFromRotation(@NotNull BlockPlaceContext pContext){
        return Math.round((pContext.getRotation() + 180.0F ) / 45.0F) % 2 == 1;
    }

    default void defineDiagonalProperty(StateDefinition.Builder<Block, BlockState> pBuilder){
        if (isDiagonallyPlaceable()) {
            pBuilder.add(DIAGONAL);
        }
    }

    default BlockState setDiagonalStateForPlacement(@NotNull BlockState state, BlockPlaceContext pContext){
        return isDiagonallyPlaceable() ? state.setValue(DIAGONAL, getDiagonalStateFromRotation(pContext)) : state;
    }
}
