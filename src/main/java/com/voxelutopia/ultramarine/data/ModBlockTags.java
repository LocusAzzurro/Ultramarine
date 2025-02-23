package com.voxelutopia.ultramarine.data;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {

    public static final TagKey<Block> MINEABLE_WITH_SHEARS = modTag("mineable_with_shears");

    private static TagKey<Block> modTag(String path) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Ultramarine.MOD_ID, path));
    }
}
