package com.voxelutopia.ultramarine.init.datagen;

import com.voxelutopia.ultramarine.init.data.ModItemTags;
import com.voxelutopia.ultramarine.init.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataGenerator output) {
        super(output);
    }

    @Override
    protected void generateTags() {
        tag(ItemTags.PLANKS)
                .add(ModItems.ROSEWOOD_PLANKS);
        tag(ModItemTags.POLISHED_PLANKS)
                .add(ModItems.POLISHED_OAK_PLANK)
                .add(ModItems.POLISHED_BIRCH_PLANK)
                .add(ModItems.POLISHED_SPRUCE_PLANK)
                .add(ModItems.POLISHED_JUNGLE_PLANK)
                .add(ModItems.POLISHED_ACACIA_PLANK)
                .add(ModItems.POLISHED_DARK_OAK_PLANK)
                .add(ModItems.POLISHED_CRIMSON_PLANK)
                .add(ModItems.POLISHED_WARPED_PLANK)
                .add(ModItems.POLISHED_ROSEWOOD_PLANK)
                .add(ModItems.POLISHED_EBONY_PLANK);
    }

    @Override
    public @NotNull FabricTagBuilder<Item> tag(@NotNull TagKey<Item> tag) {
        return getOrCreateTagBuilder(tag);
    }

}