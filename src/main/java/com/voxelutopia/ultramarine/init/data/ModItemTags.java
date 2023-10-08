package com.voxelutopia.ultramarine.init.data;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {

    public static final TagKey<Item> POLISHED_PLANKS = modTag("polished_planks");

    private static TagKey<Item> modTag(String path) {
        return bind(path);
    }

    private static TagKey<Item> bind(String string) {
        return TagKey.create(Registry.ITEM.key(), new ResourceLocation(Ultramarine.MOD_ID, string));
    }
}
