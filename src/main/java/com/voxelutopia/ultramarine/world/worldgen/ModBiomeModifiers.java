package com.voxelutopia.ultramarine.world.worldgen;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_JADE_ORE = key("add_overworld_jade_ore");
    public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_MAGNESITE_ORE = key("add_overworld_magnesite_ore");
    public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_HEMATITE_ORE = key("add_overworld_hematite_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_COBALT_ORE = key("add_nether_cobalt_ore");

    public static void bootstrap(BootstrapContext<BiomeModifier> context){
        var features = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);
        context.register(ADD_OVERWORLD_JADE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(features.getOrThrow(ModPlacedFeatures.OVERWORLD_JADE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_OVERWORLD_MAGNESITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(features.getOrThrow(ModPlacedFeatures.OVERWORLD_MAGNESITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_OVERWORLD_HEMATITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(features.getOrThrow(ModPlacedFeatures.OVERWORLD_HEMATITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_NETHER_COBALT_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER), HolderSet.direct(features.getOrThrow(ModPlacedFeatures.NETHER_COBALT_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    public static ResourceKey<BiomeModifier> key(String name){
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Ultramarine.MOD_ID, name));
    }
}
