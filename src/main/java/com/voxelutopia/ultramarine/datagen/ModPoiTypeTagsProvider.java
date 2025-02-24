package com.voxelutopia.ultramarine.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.PoiTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.voxelutopia.ultramarine.datagen.DataGenerators.MOD_ID;

public class ModPoiTypeTagsProvider extends PoiTypeTagsProvider {

    public ModPoiTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookup, MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(PoiTypeTags.ACQUIRABLE_JOB_SITE).addOptional(ResourceLocation.fromNamespaceAndPath(MOD_ID, "cooking_poi"));
    }
}
