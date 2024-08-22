package com.voxelutopia.ultramarine.world.block.state;

import net.minecraft.util.StringRepresentable;

public enum StackableBlockType implements StringRepresentable {
    SINGLE("single"),
    DOUBLE("double");

    private final String name;

    StackableBlockType(String name){
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}
