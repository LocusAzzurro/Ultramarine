package com.voxelutopia.ultramarine.data;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;

public class ModBlockTags {
    public static final ITag.INamedTag<Block> MINEABLE_WITH_SHEARS = modTag("mineable_with_shears");

    private static ITag.INamedTag<Block> modTag(String path) {
        return BlockTags.createOptional(new ResourceLocation(Ultramarine.MOD_ID, path));
    }
}
