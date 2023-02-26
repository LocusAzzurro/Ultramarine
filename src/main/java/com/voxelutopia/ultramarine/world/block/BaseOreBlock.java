package com.voxelutopia.ultramarine.world.block;

import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class BaseOreBlock extends OreBlock {

    public static final BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of(Material.STONE)
            .requiresCorrectToolForDrops().strength(3.0F, 3.0F);
    public BaseOreBlock() {
        super(PROPERTIES);
    }
}
