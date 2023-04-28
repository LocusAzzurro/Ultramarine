package com.voxelutopia.ultramarine.data;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeTabs {

    public static final MaterialsTab MATERIALS = new MaterialsTab();
    public static final ToolsTab TOOLS = new ToolsTab();
    public static final BuildingBlocksTab BUILDING_BLOCKS = new BuildingBlocksTab();
    public static final DecorationsTab DECORATIONS = new DecorationsTab();
    public static final LampsTab LAMPS = new LampsTab();

    public static class MaterialsTab extends CreativeModeTab {

        public MaterialsTab() {
            super(Ultramarine.MOD_ID + ".materials");
        }
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.CYAN_BRICK.get());
        }
    }

    public static class ToolsTab extends CreativeModeTab {

        public ToolsTab() {
            super(Ultramarine.MOD_ID + ".tools");
        }
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.WOODEN_HAMMER.get());
        }
    }

    public static class BuildingBlocksTab extends CreativeModeTab {

        public BuildingBlocksTab() {
            super(Ultramarine.MOD_ID + ".building_blocks");
        }
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.CYAN_BRICKS.get());
        }
    }

    public static class DecorationsTab extends CreativeModeTab {

        public DecorationsTab() {
            super(Ultramarine.MOD_ID + ".decorations");
        }
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.BIG_BLUE_AND_WHITE_PORCELAIN_VASE.get());
        }
    }

    public static class LampsTab extends CreativeModeTab {

        public LampsTab() {
            super(Ultramarine.MOD_ID + ".lamps");
        }
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemRegistry.OCTAGONAL_PALACE_LANTERN.get());
        }
    }
}
