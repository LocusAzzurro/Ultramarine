package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class FeatureRegistry {

    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(ForgeRegistries.FEATURES, Ultramarine.MOD_ID);

    public static final RegistryObject<OreFeature> OVERWORLD_JADE_ORE_PLACED_FEATURE = FEATURES.register("overworld_jade_ore",
            () -> new OreFeature(OreConfiguration.CODEC));
    /*
    public static final RegistryObject<OreFeature> OVERWORLD_JADE_ORE_PLACED_FEATURE = FEATURES.register("overworld_jade_ore",
            () -> new PlacedFeature(ConfiguredFeatureRegistry.OVERWORLD_JADE_ORE.getHolder().get(),
                    commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))
                    )));

     */


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
