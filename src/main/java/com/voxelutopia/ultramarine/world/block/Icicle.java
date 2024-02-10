package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

public class Icicle extends WallSideBlock{

    public static final IntegerProperty VARIANT = ModBlockStateProperties.VARIANT;
    private final int numVariants;

    public Icicle(int numVariants) {
        super(BaseBlockProperty.ICE);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(VARIANT, 0));
        this.numVariants = numVariants;
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        int variant = pLevel.random.nextInt(3);
        BlockState newState = pState.setValue(VARIANT, variant);
        pLevel.setBlockAndUpdate(pPos, newState);
    }

    public int getNumVariants() {
        return numVariants;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState state = super.getStateForPlacement(pContext);
        if (state == null) return null;
        return state.setValue(VARIANT, 0);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(VARIANT);
    }

}
