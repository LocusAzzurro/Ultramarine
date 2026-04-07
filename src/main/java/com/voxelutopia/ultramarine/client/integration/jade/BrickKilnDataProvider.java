package com.voxelutopia.ultramarine.client.integration.jade;

import com.voxelutopia.ultramarine.world.block.entity.BrickKilnBlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.world.item.ItemStack;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IServerDataProvider;

public enum BrickKilnDataProvider implements IServerDataProvider<BlockAccessor> {
    INSTANCE;

    @Override
    public void appendServerData(CompoundTag data, BlockAccessor accessor) {
        if (!(accessor.getBlockEntity() instanceof BrickKilnBlockEntity kiln)) {
            return;
        }

        if (kiln.getItem(BrickKilnBlockEntity.SLOT_INPUT_PRIMARY).isEmpty()
                && kiln.getItem(BrickKilnBlockEntity.SLOT_INPUT_SECONDARY).isEmpty()
                && kiln.getItem(BrickKilnBlockEntity.SLOT_FUEL).isEmpty()
                && kiln.getItem(BrickKilnBlockEntity.SLOT_RESULT).isEmpty()) {
            return;
        }

        ListTag items = new ListTag();
        var nbtOps = accessor.getLevel().registryAccess().createSerializationContext(NbtOps.INSTANCE);
        ItemStack.OPTIONAL_CODEC.encodeStart(nbtOps, kiln.getItem(BrickKilnBlockEntity.SLOT_INPUT_PRIMARY)).result().ifPresent(items::add);
        ItemStack.OPTIONAL_CODEC.encodeStart(nbtOps, kiln.getItem(BrickKilnBlockEntity.SLOT_INPUT_SECONDARY)).result().ifPresent(items::add);
        ItemStack.OPTIONAL_CODEC.encodeStart(nbtOps, kiln.getItem(BrickKilnBlockEntity.SLOT_FUEL)).result().ifPresent(items::add);
        ItemStack.OPTIONAL_CODEC.encodeStart(nbtOps, kiln.getItem(BrickKilnBlockEntity.SLOT_RESULT)).result().ifPresent(items::add);
        data.put("kiln", items);

        data.putInt("cookProgress", kiln.dataAccess.get(BrickKilnBlockEntity.DATA_COOKING_PROGRESS));
        data.putInt("cookTotal", kiln.dataAccess.get(BrickKilnBlockEntity.DATA_COOKING_TOTAL_TIME));
        data.putInt("litProgress", kiln.dataAccess.get(BrickKilnBlockEntity.DATA_LIT_TIME));
        data.putInt("litTotal", kiln.dataAccess.get(BrickKilnBlockEntity.DATA_LIT_DURATION));
    }

    @Override
    public net.minecraft.resources.Identifier getUid() {
        return BrickKilnComponent.BRICK_KILN;
    }
}

