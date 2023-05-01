package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeSerializerRegistry;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> recipeConsumer) {
        quadComposeRecipe(ItemRegistry.CYAN_BRICK.get(), ItemRegistry.CYAN_BRICKS.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.CYAN_BRICKS.get(), ItemRegistry.CYAN_BRICK_SLAB.get(), ItemRegistry.CYAN_BRICK_STAIRS.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.BLACK_BRICKS.get(), ItemRegistry.BLACK_BRICK_SLAB.get(), ItemRegistry.BLACK_BRICK_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.BLACK_BRICKS.get(), ItemRegistry.BLACK_BRICK_WALL.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.BROWNISH_RED_STONE_BRICKS.get(), ItemRegistry.BROWNISH_RED_STONE_BRICK_SLAB.get(), ItemRegistry.BROWNISH_RED_STONE_BRICK_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.BROWNISH_RED_STONE_BRICKS.get(), ItemRegistry.BROWNISH_RED_STONE_BRICK_WALL.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.PALE_YELLOW_STONE.get(), ItemRegistry.PALE_YELLOW_STONE_SLAB.get(), ItemRegistry.PALE_YELLOW_STONE_STAIRS.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.VARIEGATED_ROCKS.get(), ItemRegistry.VARIEGATED_ROCK_SLAB.get(), ItemRegistry.VARIEGATED_ROCK_STAIRS.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.WEATHERED_STONE.get(), ItemRegistry.WEATHERED_STONE_SLAB.get(), ItemRegistry.WEATHERED_STONE_STAIRS.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.POLISHED_WEATHERED_STONE.get(), ItemRegistry.POLISHED_WEATHERED_STONE_SLAB.get(), ItemRegistry.POLISHED_WEATHERED_STONE_STAIRS.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.LIGHT_CYAN_FLOOR_TILE.get(), ItemRegistry.LIGHT_CYAN_FLOOR_TILE_SLAB.get(), ItemRegistry.LIGHT_CYAN_FLOOR_TILE_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.POLISHED_WEATHERED_STONE.get(), ItemRegistry.POLISHED_WEATHERED_STONE_WALL.get(), recipeConsumer);
        woodSlabAndStairsRecipe(ItemRegistry.BAMBOO_MAT.get(), ItemRegistry.BAMBOO_MAT_SLAB.get(), ItemRegistry.BAMBOO_MAT_STAIRS.get(), recipeConsumer);
        woodSlabAndStairsRecipe(ItemRegistry.ROSEWOOD_PLANKS.get(), ItemRegistry.ROSEWOOD_SLAB.get(), ItemRegistry.ROSEWOOD_STAIRS.get(), recipeConsumer);
        fenceRecipe(ItemRegistry.ROSEWOOD_PLANKS.get(), ItemRegistry.ROSEWOOD_FENCE.get(), recipeConsumer);
        roofTileBlocksRecipe("gray", recipeConsumer);
        roofTileBlocksRecipe("yellow", recipeConsumer);
        roofTileBlocksRecipe("green", recipeConsumer);
        roofTileBlocksRecipe("blue", recipeConsumer);
        roofTileBlocksRecipe("cyan", recipeConsumer);
        roofTileBlocksRecipe("black", recipeConsumer);

        woodworking(Ingredient.of(ItemTags.PLANKS), ItemRegistry.WOODEN_FRAME.get(), 2, Items.OAK_PLANKS, recipeConsumer);
        polishedPlankRecipe(Items.OAK_PLANKS, ItemRegistry.POLISHED_OAK_PLANK.get(), recipeConsumer);
        polishedPlankRecipe(Items.BIRCH_PLANKS, ItemRegistry.POLISHED_BIRCH_PLANK.get(), recipeConsumer);
        polishedPlankRecipe(Items.SPRUCE_PLANKS, ItemRegistry.POLISHED_SPRUCE_PLANK.get(), recipeConsumer);
        polishedPlankRecipe(Items.JUNGLE_PLANKS, ItemRegistry.POLISHED_JUNGLE_PLANK.get(), recipeConsumer);
        polishedPlankRecipe(Items.ACACIA_PLANKS, ItemRegistry.POLISHED_ACACIA_PLANK.get(), recipeConsumer);
        polishedPlankRecipe(Items.DARK_OAK_PLANKS, ItemRegistry.POLISHED_DARK_OAK_PLANK.get(), recipeConsumer);
        polishedPlankRecipe(Items.CRIMSON_PLANKS, ItemRegistry.POLISHED_CRIMSON_PLANK.get(), recipeConsumer);
        polishedPlankRecipe(Items.WARPED_PLANKS, ItemRegistry.POLISHED_WARPED_PLANK.get(), recipeConsumer);
        polishedPlankRecipe(ItemRegistry.ROSEWOOD_PLANKS.get(), ItemRegistry.POLISHED_ROSEWOOD_PLANK.get(), recipeConsumer);
        //polishedPlankRecipe(ItemRegistry.EBONY_PLANKS.get(), ItemRegistry.POLISHED_EBONY_PLANK.get(), recipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.SQUARE_PALACE_LANTERN.get(), 1)
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('C', ItemTags.CANDLES)
                .pattern(" F ")
                .pattern("FCF")
                .pattern(" F ")
                .unlockedBy("has_" + Items.CANDLE, InventoryChangeTrigger.TriggerInstance.hasItems(Items.CANDLE))
                .save(recipeConsumer);
    }

    @SuppressWarnings("null")
    private static void quadComposeRecipe(Item part, Item combined, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        assert part.getRegistryName() != null;
        ShapedRecipeBuilder.shaped(combined, 1)
                .define('A', part)
                .pattern("AA")
                .pattern("AA")
                .unlockedBy("has_" + part.getRegistryName().getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(part))
                .save(pFinishedRecipeConsumer);
    }

    private static void quadDecomposeRecipe(Item part, Item combined, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        assert combined.getRegistryName() != null;
        ShapelessRecipeBuilder.shapeless(part, 4).requires(combined)
                .unlockedBy("has_" + combined.getRegistryName().getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(combined))
                .save(pFinishedRecipeConsumer);
    }

    private static void stoneSlabAndStairsRecipe(Item baseBlock, Item slabBlock, Item stairBlock, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        String baseBlockPath = Objects.requireNonNull(baseBlock.getRegistryName()).getPath();
        String stairsBlockPath = Objects.requireNonNull(stairBlock.getRegistryName()).getPath();
        String slabBlockPath = Objects.requireNonNull(slabBlock.getRegistryName()).getPath();
        String baseBlockAdvancement = "has_" + baseBlockPath;
        InventoryChangeTrigger.TriggerInstance trigger = InventoryChangeTrigger.TriggerInstance.hasItems(baseBlock);

        ShapedRecipeBuilder.shaped(stairBlock, 4)
                .define('B', baseBlock)
                .pattern("B  ")
                .pattern("BB ")
                .pattern("BBB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, stairsBlockPath + "_from_crafting"));
        ShapedRecipeBuilder.shaped(slabBlock, 6)
                .define('B', baseBlock)
                .pattern("BBB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, slabBlockPath + "_from_crafting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(baseBlock), stairBlock)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, stairsBlockPath + "_from_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(baseBlock), slabBlock, 2)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, slabBlockPath + "_from_stonecutting"));
    }

    private static void woodSlabAndStairsRecipe(Item baseBlock, Item slabBlock, Item stairBlock, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        String baseBlockPath = Objects.requireNonNull(baseBlock.getRegistryName()).getPath();
        String stairsBlockPath = Objects.requireNonNull(stairBlock.getRegistryName()).getPath();
        String slabBlockPath = Objects.requireNonNull(slabBlock.getRegistryName()).getPath();
        String baseBlockAdvancement = "has_" + baseBlockPath;
        InventoryChangeTrigger.TriggerInstance trigger = InventoryChangeTrigger.TriggerInstance.hasItems(baseBlock);

        ShapedRecipeBuilder.shaped(stairBlock, 4)
                .define('B', baseBlock)
                .pattern("B  ")
                .pattern("BB ")
                .pattern("BBB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, stairsBlockPath + "_from_crafting"));
        ShapedRecipeBuilder.shaped(slabBlock, 6)
                .define('B', baseBlock)
                .pattern("BBB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, slabBlockPath + "_from_crafting"));
        woodworking(Ingredient.of(baseBlock), stairBlock)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, stairsBlockPath + "_from_woodworking"));
        woodworking(Ingredient.of(baseBlock), slabBlock, 2)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, slabBlockPath + "_from_woodworking"));
    }


    private static void wallRecipe(Item baseBlock, Item wallBlock, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        String baseBlockPath = Objects.requireNonNull(baseBlock.getRegistryName()).getPath();
        String wallBlockPath = Objects.requireNonNull(wallBlock.getRegistryName()).getPath();
        String baseBlockAdvancement = "has_" + baseBlockPath;
        InventoryChangeTrigger.TriggerInstance trigger = InventoryChangeTrigger.TriggerInstance.hasItems(baseBlock);
        ShapedRecipeBuilder.shaped(wallBlock, 6)
                .define('B', baseBlock)
                .pattern("BBB")
                .pattern("BBB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID,wallBlockPath + "_from_crafting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(baseBlock), wallBlock)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID,wallBlockPath + "_from_stonecutting"));
    }

    private static void fenceRecipe(Item baseBlock, Item fenceBlock, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        String baseBlockPath = Objects.requireNonNull(baseBlock.getRegistryName()).getPath();
        String fenceBlockPath = Objects.requireNonNull(fenceBlock.getRegistryName()).getPath();
        String baseBlockAdvancement = "has_" + baseBlockPath;
        InventoryChangeTrigger.TriggerInstance trigger = InventoryChangeTrigger.TriggerInstance.hasItems(baseBlock);
        ShapedRecipeBuilder.shaped(fenceBlock, 3)
                .define('B', baseBlock)
                .define('S', Items.STICK)
                .pattern("BSB")
                .pattern("BSB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID,fenceBlockPath + "_from_crafting"));
        woodworking(Ingredient.of(baseBlock), fenceBlock)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID,fenceBlockPath + "_from_woodworking"));
    }

    private static void polishedPlankRecipe(Item planks, Item polishedPlank, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        woodworking(Ingredient.of(planks), polishedPlank, 2)
                .unlockedBy("has_" + planks.getRegistryName().getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(planks))
                .save(pFinishedRecipeConsumer);
    }

    private static void roofTileBlocksRecipe(String color, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
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

    public static SingleItemRecipeBuilder woodworking(Ingredient pIngredient, ItemLike pResult) {
        return new SingleItemRecipeBuilder(RecipeSerializerRegistry.WOODWORKING_SERIALIZER.get(), pIngredient, pResult, 1);
    }

    public static SingleItemRecipeBuilder woodworking(Ingredient pIngredient, ItemLike pResult, int pCount) {
        return new SingleItemRecipeBuilder(RecipeSerializerRegistry.WOODWORKING_SERIALIZER.get(), pIngredient, pResult, pCount);
    }

    public static void woodworking(Item input, ItemLike pResult, int pCount, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
            var recipe = new SingleItemRecipeBuilder(RecipeSerializerRegistry.WOODWORKING_SERIALIZER.get(), Ingredient.of(input), pResult, pCount);
            recipe.unlockedBy("has_" + input.getRegistryName().getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(pFinishedRecipeConsumer);
    }

    public static void woodworking(Ingredient ingredient, ItemLike pResult, int pCount, Item unlockItem, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        var recipe = new SingleItemRecipeBuilder(RecipeSerializerRegistry.WOODWORKING_SERIALIZER.get(), ingredient, pResult, pCount);
        recipe.unlockedBy("has_" + unlockItem.getRegistryName().getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(unlockItem))
                .save(pFinishedRecipeConsumer);
    }

}
