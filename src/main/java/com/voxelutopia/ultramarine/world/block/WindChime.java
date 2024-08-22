package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.shape.RawVoxelShape;
import com.voxelutopia.ultramarine.data.shape.ShapeFunction;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class WindChime extends DecorativeBlock{

    public WindChime() {
        super(DecorativeBlock.with(BaseBlockProperty.BRONZE).shaped(ShapeFunction.simpleShape(new RawVoxelShape(5,-5,5,11,16,11))).noCollision().noOcclusion());
    }

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return true;
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, Random pRandom) {
        float rainLevel = pLevel.getRainLevel(0.1f);
        if ((pRandom.nextFloat() * rainLevel) > 0.2f){
            playSound(pLevel, pPos, pRandom);
            if (pRandom.nextFloat() > 0.5f){
                pLevel.scheduleTick(pPos, this, pRandom.nextInt(3));
            }
        }
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, Random pRandom) {
        playSound(pLevel, pPos, pRandom);
    }

    private void playSound(ServerLevel pLevel, BlockPos pPos, Random pRandom){
        pLevel.playSound(null, pPos, SoundEvents.NOTE_BLOCK_CHIME, SoundSource.BLOCKS, 1.5F, 2.0f - pRandom.nextFloat() * 0.15f);
    }
}
