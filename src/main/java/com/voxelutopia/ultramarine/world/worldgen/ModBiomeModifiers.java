package com.voxelutopia.ultramarine.world.worldgen;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_JADE_ORE = key("add_overworld_jade_ore");
    public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_MAGNESITE_ORE = key("add_overworld_magnesite_ore");
    public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_HEMATITE_ORE = key("add_overworld_hematite_ore");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_COBALT_ORE = key("add_nether_cobalt_ore");

    public static void bootstrap(BootstapContext<BiomeModifier> context){
        var features = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);
        context.register(ADD_OVERWORLD_JADE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(features.getOrThrow(ModPlacedFeatures.OVERWORLD_JADE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_OVERWORLD_MAGNESITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(features.getOrThrow(ModPlacedFeatures.OVERWORLD_MAGNESITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_OVERWORLD_HEMATITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(features.getOrThrow(ModPlacedFeatures.OVERWORLD_HEMATITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_NETHER_COBALT_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER), HolderSet.direct(features.getOrThrow(ModPlacedFeatures.NETHER_COBALT_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    public static ResourceKey<BiomeModifier> key(String name){
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Ultramarine.MOD_ID, name));
    }
}
