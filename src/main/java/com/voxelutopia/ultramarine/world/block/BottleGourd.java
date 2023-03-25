package com.voxelutopia.ultramarine.world.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BottleGourd extends DecorativeBlock{

    public static final VoxelShape GOURD = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 14.0D, 11.0D);

    public BottleGourd() {
        super(BaseBlockProperty.WOOD, GOURD, true, true);
    }
}
