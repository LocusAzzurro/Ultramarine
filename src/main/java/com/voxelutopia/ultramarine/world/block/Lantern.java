package com.voxelutopia.ultramarine.world.block;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Lantern extends LuminousBlock implements DiagonallyPlaceable{

    protected StateDefinition<Block, BlockState> stateDefinition;

    protected final boolean diagonallyPlaceable;

    public Lantern(Material material, boolean diagonallyPlaceable) {
        super(material, 14);
        this.diagonallyPlaceable = diagonallyPlaceable;

        var stateDefinationBuilder = new StateDefinition.Builder<Block, BlockState>(this);
        createBlockStateDefinition(stateDefinationBuilder);
        stateDefinition = stateDefinationBuilder.create(Block::defaultBlockState, BlockState::new);

        if (isDiagonallyPlaceable()) {
            this.registerDefaultState(this.getStateDefinition().any().setValue(DIAGONAL, false));
        }
    }

    @Override
    public @NotNull StateDefinition<Block, BlockState> getStateDefinition() {
        return stateDefinition;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext pContext) {
        return setDiagonalStateForPlacement(this.defaultBlockState(), pContext);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        defineDiagonalProperty(pBuilder);
    }

    @Override
    public boolean isDiagonallyPlaceable() {
        return diagonallyPlaceable;
    }
}
