package com.voxelutopia.ultramarine.world.block.entity;

import com.voxelutopia.ultramarine.data.registry.BlockEntityRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static com.voxelutopia.ultramarine.world.block.DecorativeBlock.LIT;

public class CenserBlockEntity extends TileEntity implements ITickableTileEntity {

    private final int BURN_TIME = 1200;
    private int remainingTime = 0;
    private boolean lit = false;

    public CenserBlockEntity() {
        super(BlockEntityRegistry.CENSER.get());
    }

    public static void tick(World pLevel, BlockPos pPos, CenserBlockEntity pBlockEntity) {
        if (pLevel == null) return;
        BlockState pState = pLevel.getBlockState(pPos);
        if (pBlockEntity.remainingTime <= 0) {
            if (pBlockEntity.lit)
                pBlockEntity.finishIncense(pLevel, pPos, pState);
        } else {
            pBlockEntity.remainingTime--;
            if (pLevel.getGameTime() % 80 == 0) {
                pLevel.getEntitiesOfClass(LivingEntity.class, new AxisAlignedBB(pPos).inflate(10))
                        .forEach(e -> e.addEffect(new EffectInstance(Effects.REGENERATION, 100, 0)));
            }
        }
    }

    public void lightIncense(World pLevel, BlockPos pPos, BlockState pState) {
        this.lit = true;
        this.remainingTime = BURN_TIME;
        pLevel.setBlock(pPos, pState.setValue(LIT, true), 3);
        this.setChanged();
    }

    public void finishIncense(World pLevel, BlockPos pPos, BlockState pState) {
        this.lit = false;
        this.remainingTime = 0;
        pLevel.setBlock(pPos, pState.setValue(LIT, false), 3);
        this.setChanged();
    }

    @Override
    public void load(BlockState state, CompoundNBT pTag) {
        super.load(state, pTag);
        this.remainingTime = pTag.getInt("BurnTime");
    }

    @Override
    public CompoundNBT save(CompoundNBT pTag) {
        super.save(pTag);
        pTag.putInt("BurnTime", remainingTime);
        return pTag;
    }

    @Override
    public void tick() {
        tick(getLevel(), worldPosition, this);
    }
}
