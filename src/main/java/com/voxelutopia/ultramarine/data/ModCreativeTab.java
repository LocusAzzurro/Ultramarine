package com.voxelutopia.ultramarine.data;

import com.google.common.collect.Maps;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

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

    final ItemGroup tab;

    static final Map<ModCreativeTab, Set<RegistryObject<Item>>> itemSets = Maps.newHashMap();

    static {
        for (final ModCreativeTab tab : ModCreativeTab.values()) {
            itemSets.put(tab, new HashSet<>());
        }
    }

    ModCreativeTab(ItemGroup tab) {
        this.tab = tab;
    }

    public ItemGroup getTab() {
        return tab;
    }

    public static void putItemInSet(RegistryObject<Item> item, ModCreativeTab tab) {
        itemSets.get(tab).add(item);
    }
}
