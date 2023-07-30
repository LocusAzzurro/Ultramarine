package com.voxelutopia.ultramarine.data;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;

public enum ModCreativeTab {
    MATERIALS(),
    TOOLS(),
    BUILDING_BLOCKS(),
    DECORATIVE_BLOCKS(),
    DECORATIONS(),
    FURNITURE(),
    WINDOWS_AND_DOORS(),
    LAMPS();


    public static final Map<ModCreativeTab, List<RegistryObject<Item>>> itemSets = Map.of(
            MATERIALS, new ArrayList<>(),
            TOOLS, new ArrayList<>(),
            BUILDING_BLOCKS, new ArrayList<>(),
            DECORATIVE_BLOCKS, new ArrayList<>(),
            DECORATIONS, new ArrayList<>(),
            FURNITURE, new ArrayList<>(),
            WINDOWS_AND_DOORS, new ArrayList<>(),
            LAMPS, new ArrayList<>()
    );

    public static void putItemInSet(RegistryObject<Item> item, ModCreativeTab tab){
        itemSets.get(tab).add(item);
    }
}
