package com.voxelutopia.ultramarine.data;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModItemTags {

    public static final ITag.INamedTag<Item> POLISHED_PLANKS = modTag("polished_planks");

    private static ITag.INamedTag<Item> forgeTag(String path) {
        return ItemTags.createOptional(new ResourceLocation("forge", path));
    }

    private static ITag.INamedTag<Item> modTag(String path) {
        return ItemTags.createOptional(new ResourceLocation(Ultramarine.MOD_ID, path));
    }
}
