package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.ModItemTags;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(pGenerator, pBlockTagsProvider, DataGenerators.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ItemTags.PLANKS)
                .add(ItemRegistry.ROSEWOOD_PLANKS.get());
        tag(ModItemTags.POLISHED_PLANKS)
                .add(ItemRegistry.POLISHED_OAK_PLANK.get())
                .add(ItemRegistry.POLISHED_BIRCH_PLANK.get())
                .add(ItemRegistry.POLISHED_SPRUCE_PLANK.get())
                .add(ItemRegistry.POLISHED_JUNGLE_PLANK.get())
                .add(ItemRegistry.POLISHED_ACACIA_PLANK.get())
                .add(ItemRegistry.POLISHED_DARK_OAK_PLANK.get())
                .add(ItemRegistry.POLISHED_CRIMSON_PLANK.get())
                .add(ItemRegistry.POLISHED_WARPED_PLANK.get())
                .add(ItemRegistry.POLISHED_ROSEWOOD_PLANK.get())
                .add(ItemRegistry.POLISHED_EBONY_PLANK.get());

    }

    @Override
    public String getName() {
        return DataGenerators.MOD_ID + " Item Tags";
    }
}