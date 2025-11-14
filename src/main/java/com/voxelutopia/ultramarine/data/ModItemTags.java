package com.voxelutopia.ultramarine.data;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {

    public static final TagKey<Item> POLISHED_PLANKS = modTag("polished_planks");
    public static final TagKey<Item> DYE_POWDER = modTag("dye_powder");
    public static final TagKey<Item> PARTS = modTag("parts");
    public static final TagKey<Item> CHISEL_TEMPLATES = modTag("chisel_templates");
    public static final TagKey<Item> PAINTING_SCROLL_ITEMS = modTag("painting_scroll_items");

    public static final TagKey<Item> COMMON_WHITE_DYE = commonTag("dyes/white");
    public static final TagKey<Item> COMMON_ORANGE_DYE = commonTag("dyes/orange");
    public static final TagKey<Item> COMMON_MAGENTA_DYE = commonTag("dyes/magenta");
    public static final TagKey<Item> COMMON_LIGHT_BLUE_DYE = commonTag("dyes/light_blue");
    public static final TagKey<Item> COMMON_YELLOW_DYE = commonTag("dyes/yellow");
    public static final TagKey<Item> COMMON_LIME_DYE = commonTag("dyes/lime");
    public static final TagKey<Item> COMMON_PINK_DYE = commonTag("dyes/pink");
    public static final TagKey<Item> COMMON_GRAY_DYE = commonTag("dyes/gray");
    public static final TagKey<Item> COMMON_LIGHT_GRAY_DYE = commonTag("dyes/light_gray");
    public static final TagKey<Item> COMMON_CYAN_DYE = commonTag("dyes/cyan");
    public static final TagKey<Item> COMMON_PURPLE_DYE = commonTag("dyes/purple");
    public static final TagKey<Item> COMMON_BLUE_DYE = commonTag("dyes/blue");
    public static final TagKey<Item> COMMON_BROWN_DYE = commonTag("dyes/brown");
    public static final TagKey<Item> COMMON_GREEN_DYE = commonTag("dyes/green");
    public static final TagKey<Item> COMMON_RED_DYE = commonTag("dyes/red");
    public static final TagKey<Item> COMMON_BLACK_DYE = commonTag("dyes/black");
    public static final TagKey<Item> COMMON_DYES = commonTag("dyes");

    public static final TagKey<Item> COMMON_BRONZE_INGOT = commonTag("ingots/bronze");

    private static TagKey<Item> commonTag(String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
    }

    private static TagKey<Item> modTag(String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Ultramarine.MOD_ID, path));
    }
}
