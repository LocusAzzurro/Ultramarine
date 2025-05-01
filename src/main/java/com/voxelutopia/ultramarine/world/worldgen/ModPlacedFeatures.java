package com.voxelutopia.ultramarine.world.worldgen;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> OVERWORLD_JADE_ORE_PLACED_KEY = key("overworld_jade_ore_placed");
    public static final ResourceKey<PlacedFeature> OVERWORLD_MAGNESITE_ORE_PLACED_KEY = key("overworld_magnesite_ore_placed");
    public static final ResourceKey<PlacedFeature> OVERWORLD_HEMATITE_ORE_PLACED_KEY = key("overworld_hematite_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_COBALT_ORE_PLACED_KEY = key("nether_cobalt_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context){
        var lookup = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, OVERWORLD_JADE_ORE_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.OVERWORLD_JADE_ORE_KEY),
                commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80))));
        register(context, OVERWORLD_MAGNESITE_ORE_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.OVERWORLD_MAGNESITE_ORE_KEY),
                commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(60))));
        register(context, OVERWORLD_HEMATITE_ORE_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.OVERWORLD_HEMATITE_ORE_KEY),
                commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
        register(context, NETHER_COBALT_ORE_PLACED_KEY, lookup.getOrThrow(ModConfiguredFeatures.NETHER_COBALT_ORE_KEY),
                commonOrePlacement(8,HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(32))));
    }

    public static List<PlacementModifier> orePlacement(PlacementModifier countPlacementModifier, PlacementModifier heightPlacementModifier) {
        return List.of(countPlacementModifier, InSquarePlacement.spread(), heightPlacementModifier, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int veinsPerChunk, PlacementModifier placementModifier) {
        return orePlacement(CountPlacement.of(veinsPerChunk), placementModifier);
    }

    public static List<PlacementModifier> rareOrePlacement(int rarity, PlacementModifier placementModifier) {
        return orePlacement(RarityFilter.onAverageOnceEvery(rarity), placementModifier);
    }

    public static ResourceKey<PlacedFeature> key(String name){
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Ultramarine.MOD_ID, name));
    }

    private static void register
            (BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuredFeature, List<PlacementModifier> modifiers){
        context.register(key, new PlacedFeature(configuredFeature, List.copyOf(modifiers)));
    }
}
