package com.voxelutopia.ultramarine.data;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {

    public static final TagKey<Item> POLISHED_PLANKS = modTag("polished_planks");

    private static TagKey<Item> forgeTag(String path){
        return ItemTags.create(new ResourceLocation("forge", path));
    }
    private static TagKey<Item> modTag(String path){
        return ItemTags.create(new ResourceLocation(Ultramarine.MOD_ID, path));
    }
}
