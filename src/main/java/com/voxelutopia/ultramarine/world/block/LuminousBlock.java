package com.voxelutopia.ultramarine.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;

public class LuminousBlock extends Block {

    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    private final int LIGHT_LEVEL;
    public LuminousBlock(Material material, int lightLevel) {
        super(BlockBehaviour.Properties.of(material).noOcclusion());
        this.LIGHT_LEVEL = lightLevel;
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, Boolean.TRUE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(LIT);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getValue(LIT) ? LIGHT_LEVEL : 0;
    }
}
