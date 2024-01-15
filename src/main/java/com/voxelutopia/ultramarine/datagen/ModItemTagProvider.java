package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.ModItemTags;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
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
        tag(ModItemTags.DYE_POWDER)
                .add(ItemRegistry.WHITE_DYE_POWDER.get())
                .add(ItemRegistry.ORANGE_DYE_POWDER.get())
                .add(ItemRegistry.MAGENTA_DYE_POWDER.get())
                .add(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get())
                .add(ItemRegistry.YELLOW_DYE_POWDER.get())
                .add(ItemRegistry.LIME_DYE_POWDER.get())
                .add(ItemRegistry.PINK_DYE_POWDER.get())
                .add(ItemRegistry.GRAY_DYE_POWDER.get())
                .add(ItemRegistry.LIGHT_GRAY_DYE_POWDER.get())
                .add(ItemRegistry.CYAN_DYE_POWDER.get())
                .add(ItemRegistry.PURPLE_DYE_POWDER.get())
                .add(ItemRegistry.BLUE_DYE_POWDER.get())
                .add(ItemRegistry.BROWN_DYE_POWDER.get())
                .add(ItemRegistry.GREEN_DYE_POWDER.get())
                .add(ItemRegistry.RED_DYE_POWDER.get())
                .add(ItemRegistry.BLACK_DYE_POWDER.get());

    }
    @NotNull
    @Override
    public String getName() {
        return DataGenerators.MOD_ID + " Item Tags";
    }
}