package com.voxelutopia.ultramarine.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.PoiTypeTags;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static com.voxelutopia.ultramarine.datagen.DataGenerators.MOD_ID;

public class ModPoiTypeTagsProvider extends PoiTypeTagsProvider {

    public ModPoiTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
        super(output, lookup, MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        ResourceKey<PoiType> cookingPoi = ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, Identifier.fromNamespaceAndPath(MOD_ID, "cooking_poi"));
        tag(PoiTypeTags.ACQUIRABLE_JOB_SITE).addOptional(cookingPoi);
    }
}
