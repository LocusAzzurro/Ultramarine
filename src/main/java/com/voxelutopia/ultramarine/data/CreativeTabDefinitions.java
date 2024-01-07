package com.voxelutopia.ultramarine.data;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeTabDefinitions {

    public static final CreativeModeTab MATERIALS = new CreativeModeTab(Ultramarine.MOD_ID + ".materials") {
        @Override public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.CYAN_BRICK.get());
        }
    };
    public static final CreativeModeTab TOOLS = new CreativeModeTab(Ultramarine.MOD_ID + ".tools") {
        @Override public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.WOODEN_MALLET.get());
        }
    };
    public static final CreativeModeTab BUILDING_BLOCKS = new CreativeModeTab(Ultramarine.MOD_ID + ".building_blocks") {
        @Override public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.CYAN_BRICKS.get());
        }
    };
    public static final CreativeModeTab DECORATIVE_BLOCKS = new CreativeModeTab(Ultramarine.MOD_ID + ".decorative_blocks") {
        @Override public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.CARVED_RED_PILLAR_BASE.get());
        }
    };
    public static final CreativeModeTab DECORATIONS = new CreativeModeTab(Ultramarine.MOD_ID + ".decorations") {
        @Override public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.LARGE_BLUE_AND_WHITE_PORCELAIN_VASE.get());
        }
    };
    public static final CreativeModeTab FURNITURE = new CreativeModeTab(Ultramarine.MOD_ID + ".furniture") {
        @Override public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.OAK_CABINET.get());
        }
    };
    public static final CreativeModeTab WINDOWS_AND_DOORS = new CreativeModeTab(Ultramarine.MOD_ID + ".windows_and_doors") {
        @Override public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.CARVED_WOODEN_DOOR.get());
        }
    };

    public static final CreativeModeTab PLANTS = new CreativeModeTab(Ultramarine.MOD_ID + ".plants") {
        @Override public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.MEDIUM_LOTUS.get());
        }
    };

    public static final CreativeModeTab LAMPS = new CreativeModeTab(Ultramarine.MOD_ID + ".lamps") {
        @Override public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.OCTAGONAL_PALACE_LANTERN.get());
        }
    };
}
