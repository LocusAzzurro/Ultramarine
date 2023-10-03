package com.voxelutopia.ultramarine.init.datagen;

import com.voxelutopia.ultramarine.UltramarineDataGenerators;
import com.voxelutopia.ultramarine.init.data.ModItemTags;
import com.voxelutopia.ultramarine.init.registry.ItemRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        tag(ItemTags.PLANKS)
                .add(ItemRegistry.ROSEWOOD_PLANKS);
        tag(ModItemTags.POLISHED_PLANKS)
                .add(ItemRegistry.POLISHED_OAK_PLANK)
                .add(ItemRegistry.POLISHED_BIRCH_PLANK)
                .add(ItemRegistry.POLISHED_SPRUCE_PLANK)
                .add(ItemRegistry.POLISHED_JUNGLE_PLANK)
                .add(ItemRegistry.POLISHED_ACACIA_PLANK)
                .add(ItemRegistry.POLISHED_DARK_OAK_PLANK)
                .add(ItemRegistry.POLISHED_CRIMSON_PLANK)
                .add(ItemRegistry.POLISHED_WARPED_PLANK)
                .add(ItemRegistry.POLISHED_ROSEWOOD_PLANK)
                .add(ItemRegistry.POLISHED_EBONY_PLANK);
    }
    @Override
    public @NotNull FabricTagBuilder tag(@NotNull TagKey<Item> tag) {
        return getOrCreateTagBuilder(tag);
    }
    @NotNull
    @Override
    public String getName() {
        return UltramarineDataGenerators.MOD_ID + " Item Tags";
    }
}