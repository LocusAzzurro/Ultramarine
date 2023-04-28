package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(pGenerator, pBlockTagsProvider, DataGenerators.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ItemTags.PLANKS)
                .add(ItemRegistry.ROSEWOOD_PLANKS.get());

    }
    @NotNull
    @Override
    public String getName() {
        return DataGenerators.MOD_ID + " Item Tags";
    }
}