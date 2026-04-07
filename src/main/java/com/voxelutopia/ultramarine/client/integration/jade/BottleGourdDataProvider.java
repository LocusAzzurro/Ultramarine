package com.voxelutopia.ultramarine.client.integration.jade;

import com.voxelutopia.ultramarine.world.block.entity.BottleGourdBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IServerDataProvider;

public enum BottleGourdDataProvider implements IServerDataProvider<BlockAccessor> {
    INSTANCE;

    @Override
    public void appendServerData(CompoundTag tag, BlockAccessor blockAccessor) {
        if (blockAccessor.getBlockEntity() instanceof BottleGourdBlockEntity gourd) {
            if (!gourd.hasCharges()) {
                return;
            }

            CompoundTag compound = new CompoundTag();
            int charges = gourd.getCharges();
            Identifier potionId = BuiltInRegistries.POTION.getKey(gourd.getPotion());

            compound.putInt("Charges", charges);
            compound.putString("Potion", potionId.toString());
            tag.put("BottleGourd", compound);
        }
    }

    @Override
    public Identifier getUid() {
        return BottleGourdComponent.BOTTLE_GOURD;
    }
}

