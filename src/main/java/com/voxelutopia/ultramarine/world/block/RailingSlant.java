package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;

public class RailingSlant extends SideAxialBlock {

    public static final BooleanProperty SHIFTED = ModBlockStateProperties.SHIFTED;

    public RailingSlant(BaseBlockProperty property, int thickness) {
        super(property, thickness, 16, true);
        BlockState state = this.getStateDefinition().any()
                .setValue(SHIFTED, Boolean.FALSE);
        this.registerDefaultState(state);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(SHIFTED);
    }


}
