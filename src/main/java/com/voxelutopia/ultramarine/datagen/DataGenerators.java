package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Ultramarine.MOD_ID)
public class DataGenerators {

    public static final String MOD_ID = Ultramarine.MOD_ID;

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
//
//        if (event instanceof GatherDataEvent.Client) {
//            event.addProvider(new ModBlockModelProvider(output));
//            event.addProvider(new ModItemModelProvider(output));
//        }

        event.createProvider(ModRecipeProvider.Runner::new);
//            event.addProvider(new ModBlockTagsProvider(output, lookupProvider));
//            event.addProvider(new ModItemTagsProvider(output, lookupProvider));
//            event.addProvider(new ModPoiTypeTagsProvider(output, lookupProvider));
//            event.addProvider(new ModDataMapProvider(output, lookupProvider));
//            event.addProvider(ModLootProvider.create(output, lookupProvider));
//            event.addProvider(new ModGlobalLootModifiersProvider(output, lookupProvider));
//            event.addProvider(new ModWorldGenProvider(output, lookupProvider));
        }


    }
