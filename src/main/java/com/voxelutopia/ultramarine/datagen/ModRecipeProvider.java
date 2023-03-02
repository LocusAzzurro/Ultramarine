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
        slabAndStairsRecipe(ItemRegistry.CYAN_BRICKS.get(), ItemRegistry.CYAN_BRICK_SLAB.get(), ItemRegistry.CYAN_BRICK_STAIRS.get(), pFinishedRecipeConsumer);
        slabAndStairsRecipe(ItemRegistry.PALE_YELLOW_STONE.get(), ItemRegistry.PALE_YELLOW_STONE_SLAB.get(), ItemRegistry.PALE_YELLOW_STONE_STAIRS.get(), pFinishedRecipeConsumer);
        roofTileBlocksRecipe("gray", pFinishedRecipeConsumer);
        roofTileBlocksRecipe("yellow", pFinishedRecipeConsumer);
        roofTileBlocksRecipe("green", pFinishedRecipeConsumer);
    }

    private void slabAndStairsRecipe(Item baseBlock, Item slabBlock, Item stairBlock, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        String baseBlockAdvancement = "has_" + baseBlock.getRegistryName();
        InventoryChangeTrigger.TriggerInstance trigger = InventoryChangeTrigger.TriggerInstance.hasItems(baseBlock);
        ShapedRecipeBuilder.shaped(stairBlock, 1)
                .define('B', baseBlock)
                .pattern("B  ")
                .pattern("BB ")
                .pattern("BBB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer, stairBlock.getRegistryName().getPath() + "_from_crafting");
        ShapedRecipeBuilder.shaped(slabBlock, 6)
                .define('B', baseBlock)
                .pattern("BBB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer, slabBlock.getRegistryName().getPath() + "_from_crafting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(baseBlock), stairBlock)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer, stairBlock.getRegistryName().getPath() + "_from_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(baseBlock), slabBlock, 2)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer, slabBlock.getRegistryName().getPath() + "_from_stonecutting");
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
