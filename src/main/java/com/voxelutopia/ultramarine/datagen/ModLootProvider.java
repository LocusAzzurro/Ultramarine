package com.voxelutopia.ultramarine.datagen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class ModLootProvider {

    public static LootTableProvider create(PackOutput output){
        return new LootTableProvider(output, Set.of(), List.of(new LootTableProvider.SubProviderEntry(ModBlockLootProvider::new, LootContextParamSets.BLOCK)));
    }
}
