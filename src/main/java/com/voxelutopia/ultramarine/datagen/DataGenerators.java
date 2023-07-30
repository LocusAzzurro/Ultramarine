package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = DataGenerators.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    public static final String MOD_ID = Ultramarine.MOD_ID;

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper fh = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        generator.addProvider(event.includeClient(), new ModBlockModelProvider(output, fh));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(output, fh));

        generator.addProvider(event.includeServer(), new ModRecipeProvider(output));
        //generator.addProvider(event.includeServer(), ModLootTableProvider.create(output)); //fixme
        ModBlockTagProvider blockTags = new ModBlockTagProvider(output, lookupProvider, fh);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new ModItemTagProvider(output, lookupProvider, blockTags, fh));
    }

}
