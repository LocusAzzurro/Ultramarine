package com.voxelutopia.ultramarine.world.item;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;

public class DyePowder extends Item {

    private final DyeColor color;

    public DyePowder(Item.Properties properties, DyeColor color) {
        super(properties);
        this.color = color;
    }

    public DyeColor getColor() {
        return color;
    }
}
