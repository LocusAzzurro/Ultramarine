package com.voxelutopia.ultramarine.init.datagen;

import com.google.common.collect.ImmutableList;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.Collections;

/**
 * Name: Ultramarine / ModLootTables
 * Author: cnlimiter
 * CreateTime: 2023/10/3 18:13
 * Description:
 */

public class ModLootTables extends LootTableProvider {
    public ModLootTables(PackOutput output) {
        super(output, Collections.emptySet(), ImmutableList.of(
                new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }

}
