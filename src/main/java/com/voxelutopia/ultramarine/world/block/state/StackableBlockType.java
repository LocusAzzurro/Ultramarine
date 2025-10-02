package com.voxelutopia.ultramarine.world.block.state;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum StackableBlockType implements StringRepresentable {
    SINGLE("single"),
    DOUBLE("double");

    private final String name;

    StackableBlockType(String name){
        this.name = name;
    }

    @Override
    public @NotNull String getSerializedName() {
        return name;
    }
}
