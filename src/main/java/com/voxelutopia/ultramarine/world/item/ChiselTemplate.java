package com.voxelutopia.ultramarine.world.item;

import com.voxelutopia.ultramarine.data.CreativeTabDefinitions;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ChiselTemplate extends Item {

    public ChiselTemplate() {
        super(new Item.Properties().tab(CreativeTabDefinitions.MATERIALS));
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
