package com.voxelutopia.ultramarine.data.registry;

import com.google.common.base.Suppliers;
import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ConfiguredFeatureRegistry {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registries.CONFIGURED_FEATURE, Ultramarine.MOD_ID);

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

    public static final RegistryObject<ConfiguredFeature<?, ?>> OVERWORLD_JADE_ORE = CONFIGURED_FEATURES.register("overworld_jade_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_JADE_ORE_PLACEMENT.get(), 4)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> OVERWORLD_MAGNESITE_ORE = CONFIGURED_FEATURES.register("overworld_magnesite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_MAGNESITE_ORE_PLACEMENT.get(), 7)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> OVERWORLD_HEMATITE_ORE = CONFIGURED_FEATURES.register("overworld_hematite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_HEMATITE_ORE_PLACEMENT.get(), 9)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_COBALT_ORE = CONFIGURED_FEATURES.register("nether_cobalt_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_COBALT_ORE_PLACEMENT.get(), 6)));


}
