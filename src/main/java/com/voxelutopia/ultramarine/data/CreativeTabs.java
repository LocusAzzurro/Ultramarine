package com.voxelutopia.ultramarine.data;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeTabs {

    public static final CreativeModeTab MATERIALS = new CreativeModeTab(Ultramarine.MOD_ID + ".materials") {
        @Override public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.CYAN_BRICK.get());
        }
    };
    public static final CreativeModeTab TOOLS = new CreativeModeTab(Ultramarine.MOD_ID + ".tools") {
        @Override public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.WOODEN_HAMMER.get());
        }
    };
    public static final CreativeModeTab BUILDING_BLOCKS = new CreativeModeTab(Ultramarine.MOD_ID + ".building_blocks") {
        @Override public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.CYAN_BRICKS.get());
        }
    };
    public static final CreativeModeTab DECORATIVE_BLOCKS = new CreativeModeTab(Ultramarine.MOD_ID + ".decorative_blocks") {
        @Override public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.CYAN_BRICKS.get());
        }
    };
    public static final CreativeModeTab DECORATIONS = new CreativeModeTab(Ultramarine.MOD_ID + ".decorations") {
        @Override public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.BIG_BLUE_AND_WHITE_PORCELAIN_VASE.get());
        }
    };
    public static final CreativeModeTab FURNITURE = new CreativeModeTab(Ultramarine.MOD_ID + ".furniture") {
        @Override public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.OAK_CABINET.get());
        }
    };
    public static final CreativeModeTab LAMPS = new CreativeModeTab(Ultramarine.MOD_ID + ".lamps") {
        @Override public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.OCTAGONAL_PALACE_LANTERN.get());
        }
    };
}
