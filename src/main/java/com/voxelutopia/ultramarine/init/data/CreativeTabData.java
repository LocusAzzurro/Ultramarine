package com.voxelutopia.ultramarine.init.data;

import com.voxelutopia.ultramarine.init.registry.ModCreativeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum CreativeTabData {
    MATERIALS(ModCreativeTabs.MATERIALS),
    TOOLS(ModCreativeTabs.TOOLS),
    BUILDING_BLOCKS(ModCreativeTabs.BUILDING_BLOCKS),
    DECORATIVE_BLOCKS(ModCreativeTabs.DECORATIVE_BLOCKS),
    DECORATIONS(ModCreativeTabs.DECORATIONS),
    FURNITURE(ModCreativeTabs.FURNITURE),
    WINDOWS_AND_DOORS(ModCreativeTabs.WINDOWS_AND_DOORS),
    PLANTS(ModCreativeTabs.PLANTS),
    LAMPS(ModCreativeTabs.LAMPS);

    public static final Map<CreativeTabData, Set<Item>> itemSets = Map.of(
            MATERIALS, new HashSet<>(),
            TOOLS, new HashSet<>(),
            BUILDING_BLOCKS, new HashSet<>(),
            DECORATIVE_BLOCKS, new HashSet<>(),
            DECORATIONS, new HashSet<>(),
            FURNITURE, new HashSet<>(),
            WINDOWS_AND_DOORS, new HashSet<>(),
            PLANTS, new HashSet<>(),
            LAMPS, new HashSet<>()
    );
    final CreativeModeTab tab;

    CreativeTabData(CreativeModeTab tab) {
        this.tab = tab;
    }

    public static void putItemInSet(Item item, CreativeTabData tab) {
        itemSets.get(tab).add(item);
    }

    public CreativeModeTab getTab() {
        return tab;
    }
}
