package com.voxelutopia.ultramarine.world.block.entity;

import com.voxelutopia.ultramarine.data.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import static com.voxelutopia.ultramarine.world.block.DecorativeBlock.LIT;

public class CenserBlockEntity extends BlockEntity{

    private final int BURN_TIME = 1200;
    private int remainingTime = 0;
    private boolean lit = false;
    public CenserBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.CENSER.get(), pos, state);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, CenserBlockEntity pBlockEntity) {
        if (pBlockEntity.remainingTime <= 0){
            if (pBlockEntity.lit)
                pBlockEntity.finishIncense(pLevel, pPos, pState);
        }
        else {
            pBlockEntity.remainingTime--;
            if (pLevel.getGameTime() % 80 == 0){
                pLevel.getEntitiesOfClass(LivingEntity.class, new AABB(pPos).inflate(10))
                        .forEach(e -> e.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 0)));
            }
        }
    }

    public void lightIncense(Level pLevel, BlockPos pPos, BlockState pState){
        this.lit = true;
        this.remainingTime = BURN_TIME;
        pLevel.setBlock(pPos, pState.setValue(LIT, true), Block.UPDATE_ALL);
        this.setChanged();
    }

    public void finishIncense(Level pLevel, BlockPos pPos, BlockState pState){
        this.lit = false;
        this.remainingTime = 0;
        pLevel.setBlock(pPos, pState.setValue(LIT, false), Block.UPDATE_ALL);
        this.setChanged();
    }
    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.remainingTime = pTag.getInt("BurnTime");
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.putInt("BurnTime", remainingTime);
    }
}
