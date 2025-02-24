package com.voxelutopia.ultramarine.data;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public enum ModCreativeTab {
    MATERIALS,
    TOOLS,
    BUILDING_BLOCKS,
    DECORATIVE_BLOCKS,
    DECORATIONS,
    FURNITURE,
    WINDOWS_AND_DOORS,
    PLANTS,
    LAMPS;

    static final Map<ModCreativeTab, LinkedHashSet<RegistryObject<Item>>> itemSets = Map.of(
            MATERIALS, new LinkedHashSet<>(),
            TOOLS, new LinkedHashSet<>(),
            BUILDING_BLOCKS, new LinkedHashSet<>(),
            DECORATIVE_BLOCKS, new LinkedHashSet<>(),
            DECORATIONS, new LinkedHashSet<>(),
            FURNITURE, new LinkedHashSet<>(),
            WINDOWS_AND_DOORS, new LinkedHashSet<>(),
            PLANTS, new LinkedHashSet<>(),
            LAMPS, new LinkedHashSet<>()
    );

    public static void putItemInSet(RegistryObject<Item> item, ModCreativeTab tab){
        itemSets.get(tab).add(item);
    }

    public static List<RegistryObject<Item>> getItemsFromSet(ModCreativeTab tab){
        return ImmutableList.copyOf(itemSets.get(tab));
    }

}
