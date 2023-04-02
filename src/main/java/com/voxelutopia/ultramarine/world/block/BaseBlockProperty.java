package com.voxelutopia.ultramarine.world.block;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public final class BaseBlockProperty {
    public static BaseBlockProperty STONE = new BaseBlockProperty(BlockBehaviour.Properties.of(Material.STONE)
            .sound(SoundType.STONE)
            .strength(1.5F, 6.0F)
            .requiresCorrectToolForDrops(), BlockTags.MINEABLE_WITH_PICKAXE);
    public static BaseBlockProperty WOOD = new BaseBlockProperty(BlockBehaviour.Properties.of(Material.WOOD)
            .sound(SoundType.WOOD)
            .strength(2.0F, 3.0F), BlockTags.MINEABLE_WITH_AXE);
    public static BaseBlockProperty GLAZED = new BaseBlockProperty(BlockBehaviour.Properties.of(Material.STONE)
            .sound(SoundType.GLASS)
            .strength(1.5F, 6.0F)
            .requiresCorrectToolForDrops(), BlockTags.MINEABLE_WITH_PICKAXE);

    BlockBehaviour.Properties properties;
    TagKey<Block> tool;

    BaseBlockProperty(BlockBehaviour.Properties properties, TagKey<Block> tool){
        this.properties = properties;
        this.tool = tool;
    }

    public TagKey<Block> getTool(){
        return tool;
    }

}
