package com.voxelutopia.ultramarine.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class OffsetLantern extends Lantern {
    public OffsetLantern(Material material, boolean diagonallyPlaceable) {
        super(material, diagonallyPlaceable);
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        if (!pLevel.getBlockState(pPos.above()).isAir() && pLevel.getBlockState(pPos.below()).isAir()){
            pLevel.removeBlock(pPos, pIsMoving);
            pLevel.setBlock(pPos.below(), this.defaultBlockState(), Block.UPDATE_ALL);
        }
        else pLevel.setBlock(pPos, this.defaultBlockState(), Block.UPDATE_ALL);
    }
}
