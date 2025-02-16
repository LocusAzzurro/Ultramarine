package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class PlacedFeatureRegistry {

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Ultramarine.MOD_ID);

    public static final RegistryObject<PlacedFeature> OVERWORLD_JADE_ORE_PLACED_FEATURE = PLACED_FEATURES.register("overworld_jade_ore",
            () -> new PlacedFeature(ConfiguredFeatureRegistry.OVERWORLD_JADE_ORE.getHolder().get(),
                    commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))
            )));

    public static final RegistryObject<PlacedFeature> OVERWORLD_MAGNETITE_ORE_PLACED_FEATURE = PLACED_FEATURES.register("overworld_magnetite_ore",
            () -> new PlacedFeature(ConfiguredFeatureRegistry.OVERWORLD_MAGNESITE_ORE.getHolder().get(),
                    commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-40), VerticalAnchor.aboveBottom(60))
                    )));

    public static final RegistryObject<PlacedFeature> OVERWORLD_HEMATITE_ORE_PLACED_FEATURE = PLACED_FEATURES.register("overworld_hematite_ore",
            () -> new PlacedFeature(ConfiguredFeatureRegistry.OVERWORLD_HEMATITE_ORE.getHolder().get(),
                    commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-24), VerticalAnchor.aboveBottom(56))
                    )));

    public static final RegistryObject<PlacedFeature> NETHER_COBALT_ORE_PLACED_FEATURE = PLACED_FEATURES.register("nether_cobalt_ore",
            () -> new PlacedFeature(ConfiguredFeatureRegistry.NETHER_COBALT_ORE.getHolder().get(),
                    commonOrePlacement(8,HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(32))
                    )));


    public static List<PlacementModifier> orePlacement(PlacementModifier countPlacementModifier, PlacementModifier heightPlacementModifier) {
        return List.of(countPlacementModifier, InSquarePlacement.spread(), heightPlacementModifier, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int veinsPerChunk, PlacementModifier placementModifier) {
        return orePlacement(CountPlacement.of(veinsPerChunk), placementModifier);
    }

    public static List<PlacementModifier> rareOrePlacement(int rarity, PlacementModifier placementModifier) {
        return orePlacement(RarityFilter.onAverageOnceEvery(rarity), placementModifier);
    }

}
