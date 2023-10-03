package com.voxelutopia.ultramarine.util;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/**
 * Name: Ultramarine / RegistryHelper
 * Author: cnlimiter
 * CreateTime: 2023/10/3 16:43
 * Description:
 */

public class RegistryHelper {

    public static ResourceLocation getBlockRegistryName(Block b) {
        return BuiltInRegistries.BLOCK.getKey(b);
    }

    public static ResourceLocation getItemRegistryName(Item b) {
        return BuiltInRegistries.ITEM.getKey(b);
    }
}
