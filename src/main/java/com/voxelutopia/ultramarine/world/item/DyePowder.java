package com.voxelutopia.ultramarine.world.item;

import com.voxelutopia.ultramarine.data.ModCreativeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;

public class DyePowder extends Item {

    private final DyeColor color;

    public DyePowder(DyeColor color) {
        super(new Properties().tab(ModCreativeTab.MATERIALS.getTab()));
        this.color = color;
    }

    public DyeColor getColor() {
        return color;
    }
}
