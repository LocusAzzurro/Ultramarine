package com.voxelutopia.ultramarine.data;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CreativeTabDefinitions {

    public static final ItemGroup MATERIALS = new ItemGroup(Ultramarine.MOD_ID + ".materials") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.CYAN_BRICK.get());
        }
    };
    public static final ItemGroup TOOLS = new ItemGroup(Ultramarine.MOD_ID + ".tools") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.WOODEN_HAMMER.get());
        }
    };
    public static final ItemGroup BUILDING_BLOCKS = new ItemGroup(Ultramarine.MOD_ID + ".building_blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.CYAN_BRICKS.get());
        }
    };
    public static final ItemGroup DECORATIVE_BLOCKS = new ItemGroup(Ultramarine.MOD_ID + ".decorative_blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.CARVED_RED_PILLAR_BASE.get());
        }
    };
    public static final ItemGroup DECORATIONS = new ItemGroup(Ultramarine.MOD_ID + ".decorations") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.LARGE_BLUE_AND_WHITE_PORCELAIN_VASE.get());
        }
    };
    public static final ItemGroup FURNITURE = new ItemGroup(Ultramarine.MOD_ID + ".furniture") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.OAK_CABINET.get());
        }
    };
    public static final ItemGroup WINDOWS_AND_DOORS = new ItemGroup(Ultramarine.MOD_ID + ".windows_and_doors") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.CARVED_WOODEN_DOOR.get());
        }
    };

    public static final ItemGroup PLANTS = new ItemGroup(Ultramarine.MOD_ID + ".plants") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.MEDIUM_LOTUS.get());
        }
    };

    public static final ItemGroup LAMPS = new ItemGroup(Ultramarine.MOD_ID + ".lamps") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.OCTAGONAL_PALACE_LANTERN.get());
        }
    };
}
