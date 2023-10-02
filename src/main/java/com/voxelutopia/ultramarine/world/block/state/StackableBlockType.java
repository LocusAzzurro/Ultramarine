package com.voxelutopia.ultramarine.world.block.state;

import net.minecraft.util.IStringSerializable;

public enum StackableBlockType implements IStringSerializable {
    SINGLE("single"),
    DOUBLE("double");

    private final String name;

    StackableBlockType(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}
