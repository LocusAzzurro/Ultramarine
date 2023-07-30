package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.ModItemTags;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, TagsProvider<Block> blockTagProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTagProvider.contentsGetter(), DataGenerators.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookupProvider) {
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
    @NotNull
    @Override
    public String getName() {
        return DataGenerators.MOD_ID + " Item Tags";
    }
}