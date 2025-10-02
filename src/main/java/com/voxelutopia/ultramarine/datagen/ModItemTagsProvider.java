package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.ModItemTags;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.world.item.ChiselTemplate;
import com.voxelutopia.ultramarine.world.item.DyePowder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.voxelutopia.ultramarine.datagen.DataGenerators.MOD_ID;

public class ModItemTagsProvider extends ItemTagsProvider {


    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookup, blockTags, MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
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
                .add(ItemRegistry.POLISHED_MANGROVE_PLANK.get())
                .add(ItemRegistry.POLISHED_CHERRY_PLANK.get())
                .add(ItemRegistry.POLISHED_ROSEWOOD_PLANK.get())
                .add(ItemRegistry.POLISHED_EBONY_PLANK.get());
        tag(ModItemTags.DYE_POWDER).add(ItemRegistry.ITEMS.getEntries().stream().filter(reg -> reg.get() instanceof DyePowder)
                .map(DeferredHolder::get).toList().toArray(new Item[0]));
        tag(ModItemTags.CHISEL_TEMPLATES).add(ItemRegistry.ITEMS.getEntries().stream().filter(reg -> reg.get() instanceof ChiselTemplate)
                .map(DeferredHolder::get).toList().toArray(new Item[0]));
        tag(ModItemTags.PARTS)
                .add(ItemRegistry.WOODEN_PARTS.get())
                .add(ItemRegistry.PORCELAIN_PARTS.get())
                .add(ItemRegistry.JADE_PARTS.get())
                .add(ItemRegistry.GOLD_PARTS.get());
        tag(ModItemTags.PAINTING_SCROLL_ITEMS)
                .add(ItemRegistry.LONG_HANGING_PAINTING.get())
                .add(ItemRegistry.WHITE_LANDSCAPE_PAINTING.get())
                .add(ItemRegistry.HORIZONTAL_OLD_LANDSCAPE_PAINTING.get())
                .add(ItemRegistry.HORIZONTAL_CALLIGRAPHY.get())
                .add(ItemRegistry.HORIZONTAL_LANDSCAPE_PAINTING.get())
                .add(ItemRegistry.LONG_YELLOW_HANGING_PAINTING.get())
                .add(ItemRegistry.PORTRAIT.get())
                .add(ItemRegistry.SINCERE_CALLIGRAPHY.get());
        tag(ModItemTags.PAINTING_SCROLL_ITEMS)
                .add(ItemRegistry.LONG_HANGING_PAINTING.get())
                .add(ItemRegistry.WHITE_LANDSCAPE_PAINTING.get())
                .add(ItemRegistry.HORIZONTAL_OLD_LANDSCAPE_PAINTING.get())
                .add(ItemRegistry.HORIZONTAL_CALLIGRAPHY.get())
                .add(ItemRegistry.HORIZONTAL_LANDSCAPE_PAINTING.get())
                .add(ItemRegistry.LONG_YELLOW_HANGING_PAINTING.get())
                .add(ItemRegistry.PORTRAIT.get())
                .add(ItemRegistry.SINCERE_CALLIGRAPHY.get());


    }
    @NotNull
    @Override
    public String getName() {
        return DataGenerators.MOD_ID + " Item Tags";
    }
}