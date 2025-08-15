package com.voxelutopia.ultramarine.client.integration.jade;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.world.block.entity.BrickKilnBlockEntity;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.wrapper.CombinedInvWrapper;
import snownee.jade.addon.vanilla.FurnaceProvider;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.ui.IElementHelper;

public enum BrickKilnComponent implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    INSTANCE;

    public static final ResourceLocation BRICK_KILN = ResourceLocation.fromNamespaceAndPath(Ultramarine.MOD_ID, "brick_kiln");

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        CompoundTag data = blockAccessor.getServerData();
        if (data.contains("CookTime")) {
            int progress = data.getInt("CookTime");
            ListTag items = data.getList("Items", 10);
            NonNullList<ItemStack> inventory = NonNullList.withSize(4, ItemStack.EMPTY);
            for (int i = 0; i < items.size(); ++i) {
                inventory.set(i, ItemStack.of(items.getCompound(i)));
            }
            IElementHelper helper = IElementHelper.get();
            int total = data.getInt("CookTimeTotal");
            tooltip.add(helper.item(inventory.get(0)));
            tooltip.append(helper.item(inventory.get(1)));
            tooltip.append(helper.item(inventory.get(2)));
            tooltip.append(helper.progress((float) progress / (float) total));
            tooltip.append(helper.item(inventory.get(3)));
        }
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, BlockAccessor blockAccessor) {
        BrickKilnBlockEntity kiln = (BrickKilnBlockEntity) blockAccessor.getBlockEntity();
        CombinedInvWrapper inv = kiln.wrapHandlers();
        ItemStack primary = inv.getStackInSlot(BrickKilnBlockEntity.SLOT_INPUT_PRIMARY);
        ItemStack secondary = inv.getStackInSlot(BrickKilnBlockEntity.SLOT_INPUT_SECONDARY);
        ItemStack fuel = inv.getStackInSlot(BrickKilnBlockEntity.SLOT_FUEL);
        ItemStack result = inv.getStackInSlot(BrickKilnBlockEntity.SLOT_RESULT);
        if (primary.isEmpty() && secondary.isEmpty() && fuel.isEmpty() && result.isEmpty()) return;
        ListTag items = new ListTag();
        items.add(primary.save(new CompoundTag()));
        items.add(secondary.save(new CompoundTag()));
        items.add(fuel.save(new CompoundTag()));
        items.add(result.save(new CompoundTag()));
        compoundTag.put("Items", items);
        CompoundTag kilnTag = kiln.saveWithoutMetadata();
        compoundTag.putInt("CookTime", kilnTag.getInt("CookTime"));
        compoundTag.putInt("CookTimeTotal", kilnTag.getInt("CookTimeTotal"));
    }

    @Override
    public ResourceLocation getUid() {
        return BRICK_KILN;
    }
}
