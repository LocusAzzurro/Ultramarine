package com.voxelutopia.ultramarine.world.block;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.Nullable;

public class Lantern extends LuminousBlock implements DiagonallyPlaceable{

    public static final BooleanProperty DIAGONAL = DiagonallyPlaceable.DIAGONAL;
    protected final boolean diagonallyPlaceable;

    public Lantern(Material material, boolean diagonallyPlaceable) {
        super(material, 14);
        this.diagonallyPlaceable = diagonallyPlaceable;

        //if (isDiagonallyPlaceable())
            //this.registerDefaultState(this.stateDefinition.any().setValue(DIAGONAL, false));
        /*
        BlockState state = this.stateDefinition.any();
        if (isDiagonallyPlaceable()) state.setValue(DIAGONAL, Boolean.FALSE);
        this.registerDefaultState(state);

         */
    }

    @Override
    public StateDefinition<Block, BlockState> getStateDefinition() {
        if (isDiagonallyPlaceable()) return this.stateDefinition;
        else return super.getStateDefinition();
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return setDiagonalStateForPlacement(this.defaultBlockState(), pContext, isDiagonallyPlaceable());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        if (isDiagonallyPlaceable()) {
            pBuilder.add(DIAGONAL);
        }
        super.createBlockStateDefinition(pBuilder);
    }

    @Override
    public boolean isDiagonallyPlaceable() {
        return diagonallyPlaceable;
    }
}
