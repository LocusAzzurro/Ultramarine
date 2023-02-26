package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.ItemRegistry;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
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
    }

}
