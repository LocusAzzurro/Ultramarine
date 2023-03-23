package com.voxelutopia.ultramarine.world.block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public enum BaseBlockProperty {
    STONE(BlockBehaviour.Properties.of(Material.STONE)
            .sound(SoundType.STONE)
            .strength(1.5F, 6.0F)
            .requiresCorrectToolForDrops()),
    WOOD(BlockBehaviour.Properties.of(Material.WOOD)
            .sound(SoundType.WOOD)
            .strength(2.0F, 3.0F)),
    GLAZED(BlockBehaviour.Properties.of(Material.STONE)
            .sound(SoundType.GLASS)
            .strength(1.5F, 6.0F)
            .requiresCorrectToolForDrops());

    BlockBehaviour.Properties properties;

    BaseBlockProperty(BlockBehaviour.Properties properties){
        this.properties = properties;
    }

    public BlockBehaviour.Properties noCollision(){
        return this.properties.noCollission();
    }
}
