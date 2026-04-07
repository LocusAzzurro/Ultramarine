package com.voxelutopia.ultramarine.client.integration.jade;

import com.voxelutopia.ultramarine.world.block.entity.CenserBlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IServerDataProvider;

public enum CenserDataProvider implements IServerDataProvider<BlockAccessor> {
    INSTANCE;

    @Override
    public void appendServerData(CompoundTag compoundTag, BlockAccessor blockAccessor) {
        if (blockAccessor.getBlockEntity() instanceof CenserBlockEntity censer) {
            compoundTag.putInt("BurnTime", censer.getRemainingTime());
        }
    }

    @Override
    public Identifier getUid() {
        return CenserComponent.CENSER_BURN_TIME;
    }
}

