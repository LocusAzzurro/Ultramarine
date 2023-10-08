package com.voxelutopia.ultramarine.init.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTabs {
    public static CreativeModeTab MATERIALS;
    public static CreativeModeTab TOOLS;
    public static CreativeModeTab BUILDING_BLOCKS;
    public static CreativeModeTab DECORATIVE_BLOCKS;
    public static CreativeModeTab DECORATIONS;
    public static CreativeModeTab FURNITURE;
    public static CreativeModeTab WINDOWS_AND_DOORS;
    public static CreativeModeTab PLANTS;
    public static CreativeModeTab LAMPS;

    public static void registerModGroups() {
        MATERIALS = FabricItemGroupBuilder
                .create(new ResourceLocation(Ultramarine.MOD_ID, "materials"))
                .icon(() -> new ItemStack(ModItems.CYAN_BRICK))
                .build();
        TOOLS = FabricItemGroupBuilder
                .create(new ResourceLocation(Ultramarine.MOD_ID, "tools"))
                .icon(() -> new ItemStack(ModItems.WOODEN_HAMMER))
                .build();
        BUILDING_BLOCKS = FabricItemGroupBuilder
                .create(new ResourceLocation(Ultramarine.MOD_ID, "building_blocks"))
                .icon(() -> new ItemStack(ModItems.CYAN_BRICKS))
                .build();
        DECORATIVE_BLOCKS = FabricItemGroupBuilder
                .create(new ResourceLocation(Ultramarine.MOD_ID, "decorative_blocks"))
                .icon(() -> new ItemStack(ModItems.CARVED_RED_PILLAR_BASE))
                .build();
        DECORATIONS = FabricItemGroupBuilder
                .create(new ResourceLocation(Ultramarine.MOD_ID, "decorations"))
                .icon(() -> new ItemStack(ModItems.LARGE_BLUE_AND_WHITE_PORCELAIN_VASE))
                .build();
        FURNITURE = FabricItemGroupBuilder
                .create(new ResourceLocation(Ultramarine.MOD_ID, "furniture"))
                .icon(() -> new ItemStack(ModItems.OAK_CABINET))
                .build();
        WINDOWS_AND_DOORS = FabricItemGroupBuilder
                .create(new ResourceLocation(Ultramarine.MOD_ID, "windows_and_doors"))
                .icon(() -> new ItemStack(ModItems.CARVED_WOODEN_DOOR))
                .build();
        PLANTS = FabricItemGroupBuilder
                .create(new ResourceLocation(Ultramarine.MOD_ID, "plants"))
                .icon(() -> new ItemStack(ModItems.MEDIUM_LOTUS))
                .build();
        LAMPS = FabricItemGroupBuilder
                .create(new ResourceLocation(Ultramarine.MOD_ID, "lamps"))
                .icon(() -> new ItemStack(ModItems.OCTAGONAL_PALACE_LANTERN))
                .build();
    }


}
