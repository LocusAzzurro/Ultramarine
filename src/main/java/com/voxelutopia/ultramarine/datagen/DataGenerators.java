package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.Ultramarine;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Ultramarine.MOD_ID)
public class DataGenerators {

    public static final String MOD_ID = Ultramarine.MOD_ID;

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        event.createProvider(ModBlockTagsProvider::new);
        event.createProvider(ModItemTagsProvider::new);
        event.createProvider(ModPoiTypeTagsProvider::new);
        event.createProvider(ModRecipeProvider.Runner::new);
        event.createProvider(ModDataMapProvider::new);
        event.createProvider(ModLootProvider::create);
        event.createProvider(ModGlobalLootModifiersProvider::new);
        event.createProvider(ModWorldGenProvider::new);
        event.createProvider(output -> new ModModelResourceProvider());
    }
}
