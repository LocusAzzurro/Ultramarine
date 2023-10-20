package com.voxelutopia.ultramarine.world.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class RoofRidgePlate extends BaseHorizontalDirectionalBlock {

    public RoofRidgePlate(BaseBlockProperty property) {
        super(property);
    }

    @Override
    public VoxelShape getShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        return Block.box(0, 0, 0, 16, 1, 16);
    }
}
