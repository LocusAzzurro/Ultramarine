package com.voxelutopia.ultramarine.world.feature;

import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.List;

public class ModConfiguredFeatures {

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_JADE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockRegistry.JADE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockRegistry.DEEPSLATE_JADE_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_MAGNESITE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockRegistry.MAGNESITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockRegistry.DEEPSLATE_MAGNESITE_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_HEMATITE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockRegistry.HEMATITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockRegistry.DEEPSLATE_HEMATITE_ORE.get().defaultBlockState()));

    public static final List<OreConfiguration.TargetBlockState> NETHER_COBALT_ORES = List.of(
            OreConfiguration.target(OreFeatures.NETHERRACK, BlockRegistry.NETHER_COBALT_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> JADE_ORE = FeatureUtils.register("jade_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_JADE_ORES, 4));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> MAGNESITE_ORE = FeatureUtils.register("magnesite_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_MAGNESITE_ORES, 7));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> HEMATITE_ORE = FeatureUtils.register("hematite_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_HEMATITE_ORES, 9));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> COBALT_ORE = FeatureUtils.register("cobalt_ore",
            Feature.ORE, new OreConfiguration(NETHER_COBALT_ORES, 6));
}
