package com.voxelutopia.ultramarine.data;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum ModCreativeTab {
    MATERIALS(CreativeTabDefinitions.MATERIALS),
    TOOLS(CreativeTabDefinitions.TOOLS),
    BUILDING_BLOCKS(CreativeTabDefinitions.BUILDING_BLOCKS),
    DECORATIVE_BLOCKS(CreativeTabDefinitions.DECORATIVE_BLOCKS),
    DECORATIONS(CreativeTabDefinitions.DECORATIONS),
    FURNITURE(CreativeTabDefinitions.FURNITURE),
    WINDOWS_AND_DOORS(CreativeTabDefinitions.WINDOWS_AND_DOORS),
    PLANTS(CreativeTabDefinitions.PLANTS),
    LAMPS(CreativeTabDefinitions.LAMPS);

    final CreativeModeTab tab;

    static final Map<ModCreativeTab, Set<RegistryObject<Item>>> itemSets = Map.of(
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
    ModCreativeTab(CreativeModeTab tab){
        this.tab = tab;
    }

    public CreativeModeTab getTab() {
        return tab;
    }

    public static void putItemInSet(RegistryObject<Item> item, ModCreativeTab tab){
        itemSets.get(tab).add(item);
    }
}
