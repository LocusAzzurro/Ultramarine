package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.ModBlockStateProperties;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.Nullable;

public class DiagonalLantern extends Lantern{

    public static final BooleanProperty DIAGONAL = ModBlockStateProperties.DIAGONAL;

    public DiagonalLantern(Material material) {
        super(material);
        this.registerDefaultState(this.stateDefinition.any().setValue(DIAGONAL, Boolean.FALSE));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(DIAGONAL, Math.round((pContext.getRotation() + 180.0F ) / 45.0F) % 2 == 1);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(DIAGONAL);
        super.createBlockStateDefinition(pBuilder);
    }

}
