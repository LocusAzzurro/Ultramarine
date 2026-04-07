package com.voxelutopia.ultramarine.client.integration.jade;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.ui.JadeUI;

public enum BrickKilnComponent implements IBlockComponentProvider {

    INSTANCE;

    public static final Identifier BRICK_KILN = Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "brick_kiln");

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config) {
        CompoundTag data = accessor.getServerData();
        if (!data.contains("cookProgress")) {
            return;
        }

        int cookProgress = data.getInt("cookProgress").orElse(0);
        int cookTotal = data.getInt("cookTotal").orElse(0);
        if (cookTotal <= 0) {
            cookTotal = 1;
        }

        ListTag kilnItems = data.getListOrEmpty("kiln");
        var nbtOps = accessor.getLevel().registryAccess().createSerializationContext(NbtOps.INSTANCE);
        NonNullList<ItemStack> inventory = NonNullList.withSize(4, ItemStack.EMPTY);
        for (int i = 0; i < kilnItems.size(); i++) {
            CompoundTag itemTag = kilnItems.getCompound(i).orElseGet(CompoundTag::new);
            ItemStack itemStack = ItemStack.OPTIONAL_CODEC.parse(nbtOps, itemTag).result().orElse(ItemStack.EMPTY);
            inventory.set(i, itemStack);
        }

        tooltip.add(JadeUI.item(inventory.get(0)));
        tooltip.append(JadeUI.item(inventory.get(1)));
        tooltip.append(JadeUI.spacer(4, 0));
        tooltip.append(JadeUI.progressArrow((float) cookProgress / cookTotal).offset(-2, 0));
        tooltip.append(JadeUI.item(inventory.get(3)));

        if (!inventory.get(2).isEmpty()) {
            tooltip.add(JadeUI.item(inventory.get(2)));
        }
    }

    @Override
    public Identifier getUid() {
        return BRICK_KILN;
    }
}
