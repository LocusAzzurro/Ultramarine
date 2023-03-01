package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.ItemRegistry;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        ShapedRecipeBuilder.shaped(ItemRegistry.CYAN_BRICKS.get(), 1)
                .define('B', ItemRegistry.CYAN_BRICK.get())
                .pattern("BB")
                .pattern("BB")
                .unlockedBy("has_cyan_brick", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.CYAN_BRICK.get()))
                .save(pFinishedRecipeConsumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.CYAN_BRICKS.get()), ItemRegistry.CYAN_BRICK_STAIRS.get())
                .unlockedBy("has_cyan_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.CYAN_BRICKS.get()))
                .save(pFinishedRecipeConsumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.CYAN_BRICKS.get()), ItemRegistry.CYAN_BRICK_SLAB.get(), 2)
                .unlockedBy("has_cyan_bricks", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.CYAN_BRICKS.get()))
                .save(pFinishedRecipeConsumer);
        roofTileBlocksRecipe("gray", pFinishedRecipeConsumer);
        roofTileBlocksRecipe("yellow", pFinishedRecipeConsumer);
        roofTileBlocksRecipe("green", pFinishedRecipeConsumer);
    }

    private void roofTileBlocksRecipe(String color, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        IForgeRegistry<Item> ITEMS = ForgeRegistries.ITEMS;
        Item tileBlock, tileItem;
        tileItem = ITEMS.getValue(new ResourceLocation(DataGenerators.MOD_ID, color + "_roof_tile"));
        assert (tileItem != null);

        tileBlock = ITEMS.getValue(new ResourceLocation(DataGenerators.MOD_ID, color + "_roof_tiles"));
        assert (tileBlock != null);
        ShapedRecipeBuilder.shaped(tileBlock, 1)
                .define('T', tileItem)
                .pattern("TTT")
                .unlockedBy("has_" + color + "_roof_tile", InventoryChangeTrigger.TriggerInstance.hasItems(tileItem))
                .save(pFinishedRecipeConsumer);

        tileBlock = ITEMS.getValue(new ResourceLocation(DataGenerators.MOD_ID, color + "_roof_tile_stairs"));
        assert (tileBlock != null);
        ShapedRecipeBuilder.shaped(tileBlock, 1)
                .define('T', tileItem)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .unlockedBy("has_" + color + "_roof_tile", InventoryChangeTrigger.TriggerInstance.hasItems(tileItem))
                .save(pFinishedRecipeConsumer);

        tileBlock = ITEMS.getValue(new ResourceLocation(DataGenerators.MOD_ID, color + "_roof_tile_edge"));
        assert (tileBlock != null);
        ShapedRecipeBuilder.shaped(tileBlock, 1)
                .define('T', tileItem)
                .pattern("T  ")
                .pattern("TTT")
                .unlockedBy("has_" + color + "_roof_tile", InventoryChangeTrigger.TriggerInstance.hasItems(tileItem))
                .save(pFinishedRecipeConsumer);
    }

}
