package com.voxelutopia.ultramarine.init.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.init.data.CreativeTabData;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
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
        MATERIALS = register("materials_tab", FabricItemGroup.builder()
                .title(Component.translatable("itemGroup." + Ultramarine.MOD_ID + ".materials"))
                .icon(() -> new ItemStack(ModItems.CYAN_BRICK))
                .displayItems((itemDisplayParameters, output) -> {
                    for (Item item : CreativeTabData.itemSets.get(CreativeTabData.MATERIALS)) {
                        output.accept(item);
                    }
                })
                .build());
        TOOLS = register("tools_tab", FabricItemGroup.builder()
                .title(Component.translatable("itemGroup." + Ultramarine.MOD_ID + ".tools"))
                .icon(() -> new ItemStack(ModItems.WOODEN_HAMMER))
                .displayItems((itemDisplayParameters, output) -> {
                    for (Item item : CreativeTabData.itemSets.get(CreativeTabData.TOOLS)) {
                        output.accept(item);
                    }
                })
                .build());
        BUILDING_BLOCKS = register("building_blocks_tab", FabricItemGroup.builder()
                .title(Component.translatable("itemGroup." + Ultramarine.MOD_ID + ".building_blocks"))
                .icon(() -> new ItemStack(ModItems.CYAN_BRICKS))
                .displayItems((itemDisplayParameters, output) -> {
                    for (Item item : CreativeTabData.itemSets.get(CreativeTabData.BUILDING_BLOCKS)) {
                        output.accept(item);
                    }
                })
                .build());
        DECORATIVE_BLOCKS = register("decorative_blocks_tab", FabricItemGroup.builder()
                .title(Component.translatable("itemGroup." + Ultramarine.MOD_ID + ".decorative_blocks"))
                .icon(() -> new ItemStack(ModItems.CARVED_RED_PILLAR_BASE))
                .displayItems((itemDisplayParameters, output) -> {
                    for (Item item : CreativeTabData.itemSets.get(CreativeTabData.DECORATIVE_BLOCKS)) {
                        output.accept(item);
                    }
                })
                .build());
        DECORATIONS = register("decorations_tab", FabricItemGroup.builder()
                .title(Component.translatable("itemGroup." + Ultramarine.MOD_ID + ".decorations"))
                .icon(() -> new ItemStack(ModItems.LARGE_BLUE_AND_WHITE_PORCELAIN_VASE))
                .displayItems((itemDisplayParameters, output) -> {
                    for (Item item : CreativeTabData.itemSets.get(CreativeTabData.DECORATIONS)) {
                        output.accept(item);
                    }
                })
                .build());
        FURNITURE = register("furniture_tab", FabricItemGroup.builder()
                .title(Component.translatable("itemGroup." + Ultramarine.MOD_ID + ".furniture"))
                .icon(() -> new ItemStack(ModItems.OAK_CABINET))
                .displayItems((itemDisplayParameters, output) -> {
                    for (Item item : CreativeTabData.itemSets.get(CreativeTabData.FURNITURE)) {
                        output.accept(item);
                    }
                })
                .build());
        WINDOWS_AND_DOORS = register("windows_and_doors_tab", FabricItemGroup.builder()
                .title(Component.translatable("itemGroup." + Ultramarine.MOD_ID + ".windows_and_doors"))
                .icon(() -> new ItemStack(ModItems.CARVED_WOODEN_DOOR))
                .displayItems((itemDisplayParameters, output) -> {
                    for (Item item : CreativeTabData.itemSets.get(CreativeTabData.WINDOWS_AND_DOORS)) {
                        output.accept(item);
                    }
                })
                .build());
        PLANTS = register("plants_tab", FabricItemGroup.builder()
                .title(Component.translatable("itemGroup." + Ultramarine.MOD_ID + ".plants"))
                .icon(() -> new ItemStack(ModItems.MEDIUM_LOTUS))
                .displayItems((itemDisplayParameters, output) -> {
                    for (Item item : CreativeTabData.itemSets.get(CreativeTabData.PLANTS)) {
                        output.accept(item);
                    }
                })
                .build());
        LAMPS = register("lamps_tab", FabricItemGroup.builder()
                .title(Component.translatable("itemGroup." + Ultramarine.MOD_ID + ".lamps"))
                .icon(() -> new ItemStack(ModItems.OCTAGONAL_PALACE_LANTERN))
                .displayItems((itemDisplayParameters, output) -> {
                    for (Item item : CreativeTabData.itemSets.get(CreativeTabData.LAMPS)) {
                        output.accept(item);
                    }
                })
                .build());
    }

    private static CreativeModeTab register(String name, CreativeModeTab tab) {
        return Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(Ultramarine.MOD_ID, name), tab);
    }

}
