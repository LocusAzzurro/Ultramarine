package com.voxelutopia.ultramarine.world.item;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;

public class DyePowder extends Item {

    private final DyeColor color;

    public DyePowder(DyeColor color) {
        super(new Properties());
        this.color = color;
    }

    public DyeColor getColor() {
        return color;
    }
}
