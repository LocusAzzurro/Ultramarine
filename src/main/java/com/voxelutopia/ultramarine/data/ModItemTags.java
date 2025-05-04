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

    public static final TagKey<Item> FORGE_WHITE_DYE = forgeTag("dyes/white");
    public static final TagKey<Item> FORGE_ORANGE_DYE = forgeTag("dyes/orange");
    public static final TagKey<Item> FORGE_MAGENTA_DYE = forgeTag("dyes/magenta");
    public static final TagKey<Item> FORGE_LIGHT_BLUE_DYE = forgeTag("dyes/light_blue");
    public static final TagKey<Item> FORGE_YELLOW_DYE = forgeTag("dyes/yellow");
    public static final TagKey<Item> FORGE_LIME_DYE = forgeTag("dyes/lime");
    public static final TagKey<Item> FORGE_PINK_DYE = forgeTag("dyes/pink");
    public static final TagKey<Item> FORGE_GRAY_DYE = forgeTag("dyes/gray");
    public static final TagKey<Item> FORGE_LIGHT_GRAY_DYE = forgeTag("dyes/light_gray");
    public static final TagKey<Item> FORGE_CYAN_DYE = forgeTag("dyes/cyan");
    public static final TagKey<Item> FORGE_PURPLE_DYE = forgeTag("dyes/purple");
    public static final TagKey<Item> FORGE_BLUE_DYE = forgeTag("dyes/blue");
    public static final TagKey<Item> FORGE_BROWN_DYE = forgeTag("dyes/brown");
    public static final TagKey<Item> FORGE_GREEN_DYE = forgeTag("dyes/green");
    public static final TagKey<Item> FORGE_RED_DYE = forgeTag("dyes/red");
    public static final TagKey<Item> FORGE_BLACK_DYE = forgeTag("dyes/black");
    public static final TagKey<Item> FORGE_DYES = forgeTag("dyes");

    private static TagKey<Item> forgeTag(String path){
        return ItemTags.create(new ResourceLocation("forge", path));
    }
    private static TagKey<Item> modTag(String path){
        return ItemTags.create(new ResourceLocation(Ultramarine.MOD_ID, path));
    }
}
