package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.ModItemTags;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.world.item.ChiselTemplate;
import com.voxelutopia.ultramarine.world.item.DyePowder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
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
        tag(ModItemTags.DYE_POWDER).add(ItemRegistry.ITEMS.getEntries().stream().filter(reg -> reg.get() instanceof DyePowder)
                .map(RegistryObject::get).toList().toArray(new Item[0]));
        tag(ModItemTags.CHISEL_TEMPLATES).add(ItemRegistry.ITEMS.getEntries().stream().filter(reg -> reg.get() instanceof ChiselTemplate)
                .map(RegistryObject::get).toList().toArray(new Item[0]));
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