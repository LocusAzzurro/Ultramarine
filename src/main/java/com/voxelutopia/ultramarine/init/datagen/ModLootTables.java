//package com.voxelutopia.ultramarine.init.datagen;
//
//import com.google.common.collect.ImmutableList;
//import it.unimi.dsi.fastutil.Pair;
//import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
//import net.minecraft.data.DataGenerator;
//import net.minecraft.data.PackOutput;
//import net.minecraft.data.loot.LootTableProvider;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.level.storage.loot.LootTable;
//import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
//import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.function.BiConsumer;
//import java.util.function.Consumer;
//import java.util.function.Supplier;
//
///**
// * Name: Ultramarine / ModLootTables
// * Author: cnlimiter
// * CreateTime: 2023/10/3 18:13
// * Description:
// */
//
//public class ModLootTables extends FabricBlockLootTableProvider {
//    public ModLootTables(DataGenerator output) {
//        super(output);
//    }
//
//    @Override
//    public @NotNull List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
//        return ImmutableList.of(
//                Pair.of(ModBlockLootTables::new, LootContextParamSets.BLOCK)
//        );
//    }
//}
