package com.voxelutopia.ultramarine.world.worldgen;

import com.google.common.base.Suppliers;
import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_JADE_ORE_KEY = key("overworld_jade_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_MAGNESITE_ORE_KEY = key("overworld_magnesite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_HEMATITE_ORE_KEY = key("overworld_hematite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_COBALT_ORE_KEY = key("nether_cobalt_ore");

    private static final RuleTest STONE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    private static final RuleTest DEEPSLATE_ORE_REPLACEABLES = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    private static final RuleTest NETHERRACK = new BlockMatchTest(Blocks.NETHERRACK);

    private static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_JADE_ORE_PLACEMENT = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(STONE_ORE_REPLACEABLES, BlockRegistry.JADE_ORE.get().defaultBlockState()),
            OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, BlockRegistry.DEEPSLATE_JADE_ORE.get().defaultBlockState())));
    private static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_MAGNESITE_ORE_PLACEMENT = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(STONE_ORE_REPLACEABLES, BlockRegistry.MAGNESITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, BlockRegistry.DEEPSLATE_MAGNESITE_ORE.get().defaultBlockState())));
    private static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_HEMATITE_ORE_PLACEMENT = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(STONE_ORE_REPLACEABLES, BlockRegistry.HEMATITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES, BlockRegistry.DEEPSLATE_HEMATITE_ORE.get().defaultBlockState())));
    private static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_COBALT_ORE_PLACEMENT = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(NETHERRACK, BlockRegistry.NETHER_COBALT_ORE.get().defaultBlockState())));

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, OVERWORLD_JADE_ORE_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_JADE_ORE_PLACEMENT.get(), 4));
        register(context, OVERWORLD_MAGNESITE_ORE_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_MAGNESITE_ORE_PLACEMENT.get(), 7));
        register(context, OVERWORLD_HEMATITE_ORE_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_HEMATITE_ORE_PLACEMENT.get(), 9));
        register(context, NETHER_COBALT_ORE_KEY, Feature.ORE, new OreConfiguration(NETHER_COBALT_ORE_PLACEMENT.get(), 6));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> key(String name){
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Ultramarine.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register
            (BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC featureConfiguration){
        context.register(key, new ConfiguredFeature<>(feature, featureConfiguration));
    }

}
