package com.voxelutopia.ultramarine.init.data;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.init.registry.ItemRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeTabDefinitions {

    public static final CreativeModeTab MATERIALS = FabricItemGroup.builder()
            .title(Component.translatable(Ultramarine.MOD_ID + ".materials"))
            .icon(() -> new ItemStack(ItemRegistry.CYAN_BRICK))
            .build();
    public static final CreativeModeTab TOOLS = FabricItemGroup.builder()
            .title(Component.translatable(Ultramarine.MOD_ID + ".tools"))
            .icon(() -> new ItemStack(ItemRegistry.WOODEN_HAMMER))
            .build();
    public static final CreativeModeTab BUILDING_BLOCKS = FabricItemGroup.builder()
            .title(Component.translatable(Ultramarine.MOD_ID + ".building_blocks"))
            .icon(() -> new ItemStack(ItemRegistry.CYAN_BRICKS))
            .build();
    public static final CreativeModeTab DECORATIVE_BLOCKS = FabricItemGroup.builder()
            .title(Component.translatable(Ultramarine.MOD_ID + ".decorative_blocks"))
            .icon(() -> new ItemStack(ItemRegistry.CARVED_RED_PILLAR_BASE))
            .build();
    public static final CreativeModeTab DECORATIONS = FabricItemGroup.builder()
            .title(Component.translatable(Ultramarine.MOD_ID + ".decorations"))
            .icon(() -> new ItemStack(ItemRegistry.LARGE_BLUE_AND_WHITE_PORCELAIN_VASE))
            .build();
    public static final CreativeModeTab FURNITURE = FabricItemGroup.builder()
            .title(Component.translatable(Ultramarine.MOD_ID + ".furniture"))
            .icon(() -> new ItemStack(ItemRegistry.OAK_CABINET))
            .build();
    public static final CreativeModeTab WINDOWS_AND_DOORS = FabricItemGroup.builder()
            .title(Component.translatable(Ultramarine.MOD_ID + ".windows_and_doors"))
            .icon(() -> new ItemStack(ItemRegistry.CARVED_WOODEN_DOOR))
            .build();
    public static final CreativeModeTab PLANTS = FabricItemGroup.builder()
            .title(Component.translatable(Ultramarine.MOD_ID + ".plants"))
            .icon(() -> new ItemStack(ItemRegistry.MEDIUM_LOTUS))
            .build();
    public static final CreativeModeTab LAMPS = FabricItemGroup.builder()
            .title(Component.translatable(Ultramarine.MOD_ID + ".lamps"))
            .icon(() -> new ItemStack(ItemRegistry.OCTAGONAL_PALACE_LANTERN))
            .build();

}
