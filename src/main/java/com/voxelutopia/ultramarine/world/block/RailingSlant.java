package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class RailingSlant extends SideAxialBlock{

    public static final BooleanProperty SHIFTED = ModBlockStateProperties.SHIFTED;
    public RailingSlant(BaseBlockProperty property, int thickness) {
        super(property, thickness, 16, true);
        BlockState state = this.stateDefinition.any()
                .setValue(SHIFTED, Boolean.FALSE);
        this.registerDefaultState(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(SHIFTED);
    }


}
