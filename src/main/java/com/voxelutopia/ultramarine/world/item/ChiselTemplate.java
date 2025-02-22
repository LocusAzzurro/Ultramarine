package com.voxelutopia.ultramarine.world.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ChiselTemplate extends Item {

    public ChiselTemplate() {
        super(new Item.Properties());
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        return itemStack;
    }
}
