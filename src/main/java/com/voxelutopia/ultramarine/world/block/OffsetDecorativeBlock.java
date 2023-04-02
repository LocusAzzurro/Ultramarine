package com.voxelutopia.ultramarine.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class OffsetDecorativeBlock extends DecorativeBlock{

    public OffsetDecorativeBlock(Builder builder){
        super(builder);
    }

    public static Builder with(BaseBlockProperty property){
        return new Builder(property);
    }

    public static class Builder extends DecorativeBlock.Builder{

        public Builder(BaseBlockProperty property) {
            super(property);
        }

        public OffsetDecorativeBlock build(){
            return new OffsetDecorativeBlock(this);
        }
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
