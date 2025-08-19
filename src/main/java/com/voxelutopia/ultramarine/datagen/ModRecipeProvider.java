package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.ModItemTags;
import com.voxelutopia.ultramarine.data.recipe.WoodworkingRecipe;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.datagen.recipe.ChiselTableRecipeBuilder;
import com.voxelutopia.ultramarine.datagen.recipe.CompositeSmeltingRecipeBuilder;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
public class ModRecipeProvider extends RecipeProvider {

    ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeConsumer) {

        categoryBuildingBlocks(recipeConsumer);
        categoryDecorativeBlocks(recipeConsumer);
        categoryDecorations(recipeConsumer);
        categoryFurniture(recipeConsumer);
        categoryPlants(recipeConsumer);
        categoryLamps(recipeConsumer);
        categoryWindowsDoors(recipeConsumer);
        categoryMaterials(recipeConsumer);
        categoryTools(recipeConsumer);

        //TESTS
        CompositeSmeltingRecipeBuilder.compositeSmelting(Ingredient.of(ItemRegistry.UNFIRED_CLAY_BRICK.get()), Ingredient.of(ItemRegistry.PRISMARINE_DUST.get()), ItemRegistry.CYAN_BRICK.get(), 0.1f, 40)
                .unlockedBy(itemUnlockName(ItemRegistry.UNFIRED_CLAY_BRICK.get()), itemCriterion(ItemRegistry.UNFIRED_CLAY_BRICK.get())).save(recipeConsumer);
    }

    private static void categoryBuildingBlocks(@NotNull RecipeOutput recipeConsumer) {

        //BRICKS
        quadComposeRecipe(ItemRegistry.CYAN_BRICK.get(), ItemRegistry.CYAN_BRICKS.get(), RecipeCategory.BUILDING_BLOCKS, recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.CYAN_BRICKS.get(), ItemRegistry.CYAN_BRICK_SLAB.get(), ItemRegistry.CYAN_BRICK_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.CYAN_BRICKS.get(), ItemRegistry.CYAN_BRICK_WALL.get(), recipeConsumer);

        quadComposeRecipe(ItemRegistry.BLACK_BRICK.get(), ItemRegistry.BLACK_BRICKS.get(), RecipeCategory.BUILDING_BLOCKS, recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.BLACK_BRICKS.get(), ItemRegistry.BLACK_BRICK_SLAB.get(), ItemRegistry.BLACK_BRICK_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.BLACK_BRICKS.get(), ItemRegistry.BLACK_BRICK_WALL.get(), recipeConsumer);

        quadComposeRecipe(ItemRegistry.BROWNISH_RED_STONE_BRICK.get(), ItemRegistry.BROWNISH_RED_STONE_BRICKS.get(), RecipeCategory.BUILDING_BLOCKS, recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.BROWNISH_RED_STONE_BRICKS.get(), ItemRegistry.BROWNISH_RED_STONE_BRICK_SLAB.get(), ItemRegistry.BROWNISH_RED_STONE_BRICK_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.BROWNISH_RED_STONE_BRICKS.get(), ItemRegistry.BROWNISH_RED_STONE_BRICK_WALL.get(), recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.WHITE_AND_PINK_MIXED_BRICKS.get(), 4)
                .define('V', ItemRegistry.VARIEGATED_ROCKS.get())
                .define('Y', ItemRegistry.PALE_YELLOW_STONE.get())
                .pattern("VY").pattern("YV")
                .unlockedBy("has_" + ItemRegistry.VARIEGATED_ROCKS.get(), InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.VARIEGATED_ROCKS.get()))
                .save(recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.WHITE_AND_PINK_MIXED_BRICKS.get(), ItemRegistry.WHITE_AND_PINK_MIXED_BRICK_SLAB.get(), ItemRegistry.WHITE_AND_PINK_MIXED_BRICK_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.WHITE_AND_PINK_MIXED_BRICKS.get(), ItemRegistry.WHITE_AND_PINK_MIXED_BRICK_WALL.get(), recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.GREEN_WEATHERED_BRICKS.get(), 4)
                .define('S', ItemRegistry.GREEN_WEATHERED_STONE.get())
                .pattern("SS").pattern("SS")
                .unlockedBy("has_" + ItemRegistry.GREEN_WEATHERED_STONE.get(), InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.GREEN_WEATHERED_STONE.get()))
                .save(recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.GREEN_WEATHERED_BRICKS.get(), ItemRegistry.GREEN_WEATHERED_BRICK_SLAB.get(), ItemRegistry.GREEN_WEATHERED_BRICK_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.GREEN_WEATHERED_BRICKS.get(), ItemRegistry.GREEN_WEATHERED_BRICK_WALL.get(), recipeConsumer);

        //STONES
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.PALE_YELLOW_STONE.get(), 2).requires(Items.STONE).requires(Items.SAND)
                .unlockedBy(itemUnlockName(Items.STONE), itemCriterion(Items.STONE)).save(recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.PALE_YELLOW_STONE.get(), ItemRegistry.PALE_YELLOW_STONE_SLAB.get(), ItemRegistry.PALE_YELLOW_STONE_STAIRS.get(), recipeConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.VARIEGATED_ROCKS.get(), 4).requires(Items.COBBLESTONE).requires(Items.GRANITE).requires(Items.DIORITE).requires(Items.ANDESITE)
                .unlockedBy(itemUnlockName(Items.COBBLESTONE), itemCriterion(Items.COBBLESTONE)).save(recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.VARIEGATED_ROCKS.get(), ItemRegistry.VARIEGATED_ROCK_SLAB.get(), ItemRegistry.VARIEGATED_ROCK_STAIRS.get(), recipeConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.WEATHERED_STONE.get(), 2).requires(Items.STONE).requires(Items.GRAVEL)
                .unlockedBy(itemUnlockName(Items.STONE), itemCriterion(Items.STONE)).save(recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.WEATHERED_STONE.get(), ItemRegistry.WEATHERED_STONE_SLAB.get(), ItemRegistry.WEATHERED_STONE_STAIRS.get(), recipeConsumer);

        stonePolishing(ItemRegistry.WEATHERED_STONE.get(), ItemRegistry.POLISHED_WEATHERED_STONE.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.POLISHED_WEATHERED_STONE.get(), ItemRegistry.POLISHED_WEATHERED_STONE_SLAB.get(), ItemRegistry.POLISHED_WEATHERED_STONE_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.POLISHED_WEATHERED_STONE.get(), ItemRegistry.POLISHED_WEATHERED_STONE_WALL.get(), recipeConsumer);

        blockTransform(ItemRegistry.WEATHERED_STONE.get(), ModItemTags.COMMON_GREEN_DYE, ItemRegistry.GREEN_WEATHERED_STONE.get(), RecipeCategory.BUILDING_BLOCKS, recipeConsumer);

        // FLOOR TILES
        blockTransform(Items.SMOOTH_STONE, ModItemTags.COMMON_CYAN_DYE, ItemRegistry.CYAN_FLOOR_TILE.get(), RecipeCategory.BUILDING_BLOCKS, recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.CYAN_FLOOR_TILE.get(), ItemRegistry.CYAN_FLOOR_TILE_SLAB.get(), ItemRegistry.CYAN_FLOOR_TILE_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.CYAN_FLOOR_TILE.get(), ItemRegistry.CYAN_FLOOR_TILE_WALL.get(), recipeConsumer);

        blockTransform(ItemRegistry.CYAN_FLOOR_TILE.get(), ModItemTags.COMMON_WHITE_DYE, ItemRegistry.LIGHT_CYAN_FLOOR_TILE.get(), RecipeCategory.BUILDING_BLOCKS, recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.LIGHT_CYAN_FLOOR_TILE.get(), ItemRegistry.LIGHT_CYAN_FLOOR_TILE_SLAB.get(), ItemRegistry.LIGHT_CYAN_FLOOR_TILE_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.LIGHT_CYAN_FLOOR_TILE.get(), ItemRegistry.LIGHT_CYAN_FLOOR_TILE_WALL.get(), recipeConsumer);

        blockTransform(ItemRegistry.CYAN_FLOOR_TILE.get(), Items.BLACK_DYE, ItemRegistry.DARK_CYAN_FLOOR_TILE.get(), RecipeCategory.BUILDING_BLOCKS, recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.DARK_CYAN_FLOOR_TILE.get(), ItemRegistry.DARK_CYAN_FLOOR_TILE_SLAB.get(), ItemRegistry.DARK_CYAN_FLOOR_TILE_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.DARK_CYAN_FLOOR_TILE.get(), ItemRegistry.DARK_CYAN_FLOOR_TILE_WALL.get(), recipeConsumer);

        simpleStonecutting(ItemRegistry.CYAN_FLOOR_TILE.get(), ItemRegistry.LAYERED_CYAN_FLOOR_TILES.get(), RecipeCategory.BUILDING_BLOCKS, recipeConsumer);
        simpleStonecutting(ItemRegistry.CYAN_FLOOR_TILE.get(), ItemRegistry.VERTICAL_CYAN_FLOOR_TILES.get(), RecipeCategory.BUILDING_BLOCKS, recipeConsumer);
        simpleStonecutting(ItemRegistry.CYAN_FLOOR_TILE.get(), ItemRegistry.MIXED_CYAN_FLOOR_TILES.get(), RecipeCategory.BUILDING_BLOCKS, recipeConsumer);
        simpleStonecutting(ItemRegistry.CYAN_FLOOR_TILE.get(), ItemRegistry.CHISELED_CYAN_FLOOR_TILE.get(), RecipeCategory.BUILDING_BLOCKS, recipeConsumer);
        simpleStonecutting(ItemRegistry.CYAN_FLOOR_TILE.get(), ItemRegistry.CUT_CYAN_FLOOR_TILES.get(), RecipeCategory.BUILDING_BLOCKS, recipeConsumer);

        blockTransform(ItemRegistry.POLISHED_WEATHERED_STONE.get(), ModItemTags.COMMON_RED_DYE, ItemRegistry.WEATHERED_RED_STONE_TILE.get(), RecipeCategory.BUILDING_BLOCKS, recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.WEATHERED_RED_STONE_TILE.get(), ItemRegistry.WEATHERED_RED_STONE_TILE_SLAB.get(), ItemRegistry.WEATHERED_RED_STONE_TILE_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.WEATHERED_RED_STONE_TILE.get(), ItemRegistry.WEATHERED_RED_STONE_TILE_WALL.get(), recipeConsumer);

        blockTransform(ItemRegistry.DARK_CYAN_FLOOR_TILE.get(), ModItemTags.COMMON_BLUE_DYE, ItemRegistry.BLUE_AND_BLACK_TILE.get(), RecipeCategory.BUILDING_BLOCKS, recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.BLUE_AND_BLACK_TILE.get(), ItemRegistry.BLUE_AND_BLACK_TILE_SLAB.get(), ItemRegistry.BLUE_AND_BLACK_TILE_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.BLUE_AND_BLACK_TILE.get(), ItemRegistry.BLUE_AND_BLACK_TILE_WALL.get(), recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.GREEN_GLAZED_TILES.get(), 2)
                .define('B', Items.GREEN_GLAZED_TERRACOTTA).define('T', ItemRegistry.GREEN_ROOF_TILE.get())
                .pattern(" T ").pattern("TBT").pattern(" T ")
                .unlockedBy(itemUnlockName(Items.GREEN_GLAZED_TERRACOTTA), itemCriterion(Items.GREEN_GLAZED_TERRACOTTA))
                .save(recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.GREEN_GLAZED_TILES.get(), ItemRegistry.GREEN_GLAZED_TILE_SLAB.get(), ItemRegistry.GREEN_GLAZED_TILE_STAIRS.get(), recipeConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.BLACK_FLOOR_TILES.get(), 2).requires(Items.COBBLED_DEEPSLATE).requires(ItemRegistry.BLACK_BRICKS.get())
                .unlockedBy(itemUnlockName(ItemRegistry.BLACK_BRICKS.get()), itemCriterion(ItemRegistry.BLACK_BRICKS.get())).save(recipeConsumer);
        blockTransform(ItemRegistry.BLACK_FLOOR_TILES.get(), Items.MOSS_BLOCK, ItemRegistry.BLACK_FLOOR_TILES_LITTLE_MOSSY.get(), RecipeCategory.BUILDING_BLOCKS, recipeConsumer);
        blockTransform(ItemRegistry.BLACK_FLOOR_TILES_LITTLE_MOSSY.get(), Items.MOSS_BLOCK, ItemRegistry.BLACK_FLOOR_TILES_MODERATE_MOSSY.get(), RecipeCategory.BUILDING_BLOCKS, recipeConsumer);
        blockTransform(ItemRegistry.BLACK_FLOOR_TILES_MODERATE_MOSSY.get(), Items.MOSS_BLOCK, ItemRegistry.BLACK_FLOOR_TILES_VERY_MOSSY.get(), RecipeCategory.BUILDING_BLOCKS, recipeConsumer);

        //WOODEN

        smeltingAndBlasting(Items.MANGROVE_PLANKS, ItemRegistry.ROSEWOOD_PLANKS.get(), recipeConsumer);
        woodSlabAndStairsRecipe(ItemRegistry.ROSEWOOD_PLANKS.get(), ItemRegistry.ROSEWOOD_SLAB.get(), ItemRegistry.ROSEWOOD_STAIRS.get(), recipeConsumer);
        fenceRecipe(ItemRegistry.ROSEWOOD_PLANKS.get(), ItemRegistry.ROSEWOOD_FENCE.get(), recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.VARNISHED_ROSEWOOD.get())
                .define('B', ItemRegistry.ROSEWOOD_PLANKS.get())
                .define('P', ItemRegistry.POLISHED_ROSEWOOD_PLANK.get())
                .define('D', ModItemTags.COMMON_RED_DYE)
                .pattern("DPD")
                .pattern("PBP")
                .pattern("DPD")
                .unlockedBy(itemUnlockName(ItemRegistry.ROSEWOOD_PLANKS.get()), itemCriterion(ItemRegistry.ROSEWOOD_PLANKS.get()))
                .save(recipeConsumer);


        woodworking(RecipeCategory.BUILDING_BLOCKS, Items.BAMBOO_MOSAIC, ItemRegistry.BAMBOO_MAT.get(), 1, recipeConsumer);
        woodSlabAndStairsRecipe(ItemRegistry.BAMBOO_MAT.get(), ItemRegistry.BAMBOO_MAT_SLAB.get(), ItemRegistry.BAMBOO_MAT_STAIRS.get(), recipeConsumer);

        // ROOF TILES

        roofTileBlocksRecipe("gray", recipeConsumer);
        roofTileBlocksRecipe("yellow", recipeConsumer);
        roofTileBlocksRecipe("green", recipeConsumer);
        roofTileBlocksRecipe("blue", recipeConsumer);
        roofTileBlocksRecipe("cyan", recipeConsumer);
        roofTileBlocksRecipe("black", recipeConsumer);

        // ROOF RIDGE

        roofTileRidgesRecipe("yellow", recipeConsumer);
        roofTileRidgesRecipe("black", recipeConsumer);
    }

    private static void categoryDecorativeBlocks(@NotNull RecipeOutput recipeConsumer) {

        // SIMPLE WOODEN

        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemTags.OAK_LOGS), ItemRegistry.OAK_BRACKET.get()).unlockedBy("has_wood", tagUnlock(ItemTags.OAK_LOGS)).save(recipeConsumer);
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemTags.SPRUCE_LOGS), ItemRegistry.SPRUCE_BRACKET.get()).unlockedBy("has_wood", tagUnlock(ItemTags.SPRUCE_LOGS)).save(recipeConsumer);
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemTags.BIRCH_LOGS), ItemRegistry.BIRCH_BRACKET.get()).unlockedBy("has_wood", tagUnlock(ItemTags.BIRCH_LOGS)).save(recipeConsumer);
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemTags.JUNGLE_LOGS), ItemRegistry.JUNGLE_BRACKET.get()).unlockedBy("has_wood", tagUnlock(ItemTags.JUNGLE_LOGS)).save(recipeConsumer);
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemTags.ACACIA_LOGS), ItemRegistry.ACACIA_BRACKET.get()).unlockedBy("has_wood", tagUnlock(ItemTags.ACACIA_LOGS)).save(recipeConsumer);
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemTags.DARK_OAK_LOGS), ItemRegistry.DARK_OAK_BRACKET.get()).unlockedBy("has_wood", tagUnlock(ItemTags.DARK_OAK_LOGS)).save(recipeConsumer);
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemTags.CRIMSON_STEMS), ItemRegistry.CRIMSON_BRACKET.get()).unlockedBy("has_wood", tagUnlock(ItemTags.CRIMSON_STEMS)).save(recipeConsumer);
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemTags.WARPED_STEMS), ItemRegistry.WARPED_BRACKET.get()).unlockedBy("has_wood", tagUnlock(ItemTags.WARPED_STEMS)).save(recipeConsumer);
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemTags.MANGROVE_LOGS), ItemRegistry.MANGROVE_BRACKET.get()).unlockedBy("has_wood", tagUnlock(ItemTags.MANGROVE_LOGS)).save(recipeConsumer);
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemTags.CHERRY_LOGS), ItemRegistry.CHERRY_BRACKET.get()).unlockedBy("has_wood", tagUnlock(ItemTags.CHERRY_LOGS)).save(recipeConsumer);
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemRegistry.VARNISHED_ROSEWOOD.get()), ItemRegistry.VARNISHED_ROSEWOOD_BRACKET.get()).unlockedBy("has_wood", itemCriterion(ItemRegistry.VARNISHED_ROSEWOOD.get())).save(recipeConsumer);

        // SIMPLE CARVED WOOD

        carvedWood(ItemRegistry.RED_CARVED_WOOD.get(), new Ingredient[]{Ingredient.of(ModItemTags.COMMON_RED_DYE), Ingredient.of(ModItemTags.COMMON_RED_DYE)}, recipeConsumer);
        woodSlabAndStairsRecipe(ItemRegistry.RED_CARVED_WOOD.get(), ItemRegistry.RED_CARVED_WOODEN_SLAB.get(), ItemRegistry.RED_CARVED_WOODEN_STAIRS.get(), recipeConsumer);
        carvedWood(ItemRegistry.BLUE_CARVED_WOOD.get(), new Ingredient[]{Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE)}, recipeConsumer);
        woodSlabAndStairsRecipe(ItemRegistry.BLUE_CARVED_WOOD.get(), ItemRegistry.BLUE_CARVED_WOODEN_SLAB.get(), ItemRegistry.BLUE_CARVED_WOODEN_STAIRS.get(), recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.BLUE_CARVED_WOODEN_BRACKET.get(), 2)
                .define('T', ItemRegistry.GREEN_CARVED_WOODEN_SLAB.get())
                .define('B', ItemRegistry.BLUE_CARVED_WOODEN_STAIRS.get())
                .pattern("T").pattern("B")
                .unlockedBy(itemUnlockName(ItemRegistry.BLUE_CARVED_WOODEN_STAIRS.get()), itemCriterion(ItemRegistry.BLUE_CARVED_WOODEN_STAIRS.get()))
                .save(recipeConsumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.BLUE_CARVED_WOODEN_BRACKET_STAIRS.get())
                .requires(ItemRegistry.BLUE_CARVED_WOODEN_STAIRS.get()).requires(ItemRegistry.YELLOW_DYE_POWDER.get())
                .unlockedBy(itemUnlockName(ItemRegistry.BLUE_CARVED_WOODEN_STAIRS.get()), itemCriterion(ItemRegistry.BLUE_CARVED_WOODEN_STAIRS.get()))
                .save(recipeConsumer);
        carvedWood(ItemRegistry.CYAN_CARVED_WOOD.get(), new Ingredient[]{Ingredient.of(ModItemTags.COMMON_CYAN_DYE), Ingredient.of(ModItemTags.COMMON_CYAN_DYE)}, recipeConsumer);
        woodSlabAndStairsRecipe(ItemRegistry.CYAN_CARVED_WOOD.get(), ItemRegistry.CYAN_CARVED_WOODEN_SLAB.get(), ItemRegistry.CYAN_CARVED_WOODEN_STAIRS.get(), recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.CYAN_CARVED_WOODEN_BRACKET.get(), 2)
                .define('T', ItemRegistry.CYAN_CARVED_WOODEN_SLAB.get())
                .define('B', ItemRegistry.RED_CARVED_WOODEN_STAIRS.get())
                .pattern("T").pattern("B")
                .unlockedBy(itemUnlockName(ItemRegistry.CYAN_CARVED_WOODEN_SLAB.get()), itemCriterion(ItemRegistry.CYAN_CARVED_WOODEN_SLAB.get()))
                .save(recipeConsumer);
        carvedWood(ItemRegistry.GREEN_CARVED_WOOD.get(), new Ingredient[]{Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE)}, recipeConsumer);
        woodSlabAndStairsRecipe(ItemRegistry.GREEN_CARVED_WOOD.get(), ItemRegistry.GREEN_CARVED_WOODEN_SLAB.get(), ItemRegistry.GREEN_CARVED_WOODEN_STAIRS.get(), recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.GREEN_CARVED_WOODEN_BRACKET.get(), 2)
                .define('T', ItemRegistry.BLUE_CARVED_WOODEN_SLAB.get())
                .define('B', ItemRegistry.GREEN_CARVED_WOODEN_STAIRS.get())
                .pattern("T").pattern("B")
                .unlockedBy(itemUnlockName(ItemRegistry.GREEN_CARVED_WOODEN_STAIRS.get()), itemCriterion(ItemRegistry.GREEN_CARVED_WOODEN_STAIRS.get()))
                .save(recipeConsumer);

        // MIXED CARVED WOOD

        carvedWood(ItemRegistry.ORANGE_AND_BLUE_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_ORANGE_DYE), Ingredient.of(ModItemTags.COMMON_LIGHT_BLUE_DYE)}, recipeConsumer);
        carvedWood(ItemRegistry.ORANGE_AND_GREEN_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_ORANGE_DYE), Ingredient.of(ModItemTags.COMMON_LIME_DYE)}, recipeConsumer);
        carvedWood(ItemRegistry.GREEN_AND_BLUE_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_LIME_DYE), Ingredient.of(ModItemTags.COMMON_LIGHT_BLUE_DYE)}, recipeConsumer);
        carvedWood(ItemRegistry.DARK_GREEN_AND_DARK_BLUE_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ItemRegistry.LIME_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_BLUE_DYE)}, recipeConsumer);
        carvedWood(ItemRegistry.DARK_BLUE_AND_DARK_GREEN_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_GREEN_DYE)}, recipeConsumer);
        carvedWood(ItemRegistry.BLACK_WHITE_GREEN_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_BLACK_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_GREEN_DYE)}, recipeConsumer);
        carvedWood(ItemRegistry.BLACK_WHITE_BLUE_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_BLACK_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_BLUE_DYE)}, recipeConsumer);
        carvedWood(ItemRegistry.RED_AND_GREEN_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_RED_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE)}, recipeConsumer);
        carvedWood(ItemRegistry.BLUE_AND_RED_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_RED_DYE)}, recipeConsumer);
        carvedWood(ItemRegistry.BLUE_WHITE_RED_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()),
                Ingredient.of(ModItemTags.COMMON_RED_DYE), Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get())}, recipeConsumer);
        carvedWood(ItemRegistry.GREEN_WHITE_RED_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get()), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()),
                Ingredient.of(ModItemTags.COMMON_RED_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get())}, recipeConsumer);
        carvedWood(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE),
                Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE)}, recipeConsumer);
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1.get()), ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2.get())
                .unlockedBy(itemUnlockName(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1.get()), itemCriterion(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1.get()))
                .save(recipeConsumer, ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, "blue_and_yellow_carved_wood_1_to_2"));
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1.get()), ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3.get())
                .unlockedBy(itemUnlockName(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1.get()), itemCriterion(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1.get()))
                .save(recipeConsumer, ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, "blue_and_yellow_carved_wood_1_to_3"));
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2.get()), ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1.get())
                .unlockedBy(itemUnlockName(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2.get()), itemCriterion(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2.get()))
                .save(recipeConsumer, ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, "blue_and_yellow_carved_wood_2_to_1"));
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2.get()), ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3.get())
                .unlockedBy(itemUnlockName(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2.get()), itemCriterion(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2.get()))
                .save(recipeConsumer, ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, "blue_and_yellow_carved_wood_2_to_3"));
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3.get()), ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1.get())
                .unlockedBy(itemUnlockName(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3.get()), itemCriterion(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3.get()))
                .save(recipeConsumer, ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, "blue_and_yellow_carved_wood_3_to_1"));
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3.get()), ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2.get())
                .unlockedBy(itemUnlockName(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3.get()), itemCriterion(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3.get()))
                .save(recipeConsumer, ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, "blue_and_yellow_carved_wood_3_to_2"));
        carvedWood(ItemRegistry.YELLOW_AND_GREEN_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE)}, recipeConsumer);
        carvedWood(ItemRegistry.YELLOW_GREEN_BLUE_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE)}, recipeConsumer);

        // DARK OAK

        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(Items.STRIPPED_DARK_OAK_LOG), ItemRegistry.CARVED_DARK_OAK_BEAM.get())
                .unlockedBy(itemUnlockName(Items.STRIPPED_DARK_OAK_LOG), itemCriterion(Items.STRIPPED_DARK_OAK_LOG)).save(recipeConsumer);
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(Items.STRIPPED_DARK_OAK_LOG), ItemRegistry.CARVED_DARK_OAK_BEAM_EDGE.get())
                .unlockedBy(itemUnlockName(Items.STRIPPED_DARK_OAK_LOG), itemCriterion(Items.STRIPPED_DARK_OAK_LOG)).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.GILDED_DARK_OAK.get(), 1)
                .define('O', Items.STRIPPED_DARK_OAK_WOOD)
                .define('G', ItemRegistry.GOLD_PARTS.get())
                .pattern(" G ").pattern("GOG").pattern(" G ")
                .unlockedBy(itemUnlockName(Items.STRIPPED_DARK_OAK_WOOD), itemCriterion(Items.STRIPPED_DARK_OAK_WOOD))
                .save(recipeConsumer);
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemRegistry.GILDED_DARK_OAK.get()), ItemRegistry.CHISELED_GILDED_DARK_OAK.get())
                .unlockedBy(itemUnlockName(ItemRegistry.GILDED_DARK_OAK.get()), itemCriterion(ItemRegistry.GILDED_DARK_OAK.get())).save(recipeConsumer);
        woodSlabAndStairsRecipe(ItemRegistry.GILDED_DARK_OAK.get(), ItemRegistry.GILDED_DARK_OAK_SLAB.get(), ItemRegistry.GILDED_DARK_OAK_STAIRS.get(), recipeConsumer);
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemRegistry.GILDED_DARK_OAK.get()), ItemRegistry.GILDED_DARK_OAK_BRACKET.get())
                .unlockedBy(itemUnlockName(ItemRegistry.GILDED_DARK_OAK.get()), itemCriterion(ItemRegistry.GILDED_DARK_OAK.get())).save(recipeConsumer);

        // PILLARS

        carvedWood(ItemRegistry.CARVED_RED_PILLAR.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_RED_DYE), Ingredient.of(ModItemTags.COMMON_RED_DYE)}, recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.CARVED_RED_PILLAR_BASE.get(), 1)
                .define('P', ItemRegistry.CARVED_RED_PILLAR.get())
                .define('S', Items.SMOOTH_STONE_SLAB)
                .pattern("P").pattern("S")
                .unlockedBy(itemUnlockName(ItemRegistry.CARVED_RED_PILLAR.get()), itemCriterion(ItemRegistry.CARVED_RED_PILLAR.get()))
                .save(recipeConsumer);
        zhaotouWood(ItemRegistry.CARVED_RED_PILLAR_HEAD.get(), new Ingredient[]{
                        Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_RED_DYE), Ingredient.of(ModItemTags.COMMON_WHITE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE)},
                recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.SPRUCE_PILLAR_BASE.get(), 1)
                .define('P', Items.SPRUCE_LOG)
                .define('S', Items.SMOOTH_STONE_SLAB)
                .pattern("P").pattern("S")
                .unlockedBy(itemUnlockName(Items.SPRUCE_LOG), itemCriterion(Items.SPRUCE_LOG))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.STRIPPED_DARK_OAK_PILLAR_BASE.get(), 1)
                .define('P', Items.STRIPPED_DARK_OAK_LOG)
                .define('S', Items.SMOOTH_STONE_SLAB)
                .pattern("P").pattern("S")
                .unlockedBy(itemUnlockName(Items.STRIPPED_DARK_OAK_LOG), itemCriterion(Items.STRIPPED_DARK_OAK_LOG))
                .save(recipeConsumer);
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemRegistry.GILDED_DARK_OAK.get()), ItemRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_1.get())
                .unlockedBy(itemUnlockName(ItemRegistry.GILDED_DARK_OAK.get()), itemCriterion(ItemRegistry.GILDED_DARK_OAK.get())).save(recipeConsumer);
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemRegistry.GILDED_DARK_OAK.get()), ItemRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_2.get())
                .unlockedBy(itemUnlockName(ItemRegistry.GILDED_DARK_OAK.get()), itemCriterion(ItemRegistry.GILDED_DARK_OAK.get())).save(recipeConsumer);
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemRegistry.GILDED_DARK_OAK.get()), ItemRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_3.get())
                .unlockedBy(itemUnlockName(ItemRegistry.GILDED_DARK_OAK.get()), itemCriterion(ItemRegistry.GILDED_DARK_OAK.get())).save(recipeConsumer);
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemRegistry.GILDED_DARK_OAK.get()), ItemRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_4.get())
                .unlockedBy(itemUnlockName(ItemRegistry.GILDED_DARK_OAK.get()), itemCriterion(ItemRegistry.GILDED_DARK_OAK.get())).save(recipeConsumer);
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(ItemRegistry.GILDED_DARK_OAK.get()), ItemRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_5.get())
                .unlockedBy(itemUnlockName(ItemRegistry.GILDED_DARK_OAK.get()), itemCriterion(ItemRegistry.GILDED_DARK_OAK.get())).save(recipeConsumer);

        zhaotouWood(ItemRegistry.CYAN_AND_WHITE_PILLAR_BASE.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_RED_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_WHITE_DYE), Ingredient.of(ItemRegistry.BLACK_DYE_POWDER.get())},
                recipeConsumer);
        zhaotouWood(ItemRegistry.CYAN_AND_WHITE_DECORATED_PILLAR.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_RED_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_WHITE_DYE), Ingredient.of(ModItemTags.COMMON_BLACK_DYE)},
                recipeConsumer);
        zhaotouWood(ItemRegistry.CYAN_AND_WHITE_PILLAR_HEAD.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_RED_DYE), Ingredient.of(ModItemTags.COMMON_BLACK_DYE), Ingredient.of(ModItemTags.COMMON_WHITE_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE)},
                recipeConsumer);
        simpleStonecutting(Items.CHISELED_STONE_BRICKS, ItemRegistry.STONE_PILLAR_BASE.get(), RecipeCategory.DECORATIONS, recipeConsumer);

        // FANGXIN

        fangxinWood(ItemRegistry.GREEN_FANGXIN.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE)},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.GREEN_FANGXIN_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get())},
                recipeConsumer);
        fangxinWood(ItemRegistry.BLUE_FANGXIN.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.BLUE_FANGXIN_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())},
                recipeConsumer);
        fangxinWood(ItemRegistry.CYAN_AND_BLUE_FANGXIN.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_CYAN_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get()), Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get())},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.CYAN_AND_BLUE_FANGXIN_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_CYAN_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get())},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.CYAN_AND_BLUE_FANGXIN_EDGE_VARIANT.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_CYAN_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE)},
                recipeConsumer);
        fangxinWood(ItemRegistry.CYAN_BLUE_WHITE_FANGXIN.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_CYAN_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_GREEN_DYE)},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.CYAN_BLUE_WHITE_FANGXIN_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_CYAN_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_GREEN_DYE)},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.BLUE_AND_GREEN_FANGXIN_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE)},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.YELLOW_AND_GREEN_FANGXIN_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_YELLOW_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE)},
                recipeConsumer);
        fangxinWood(ItemRegistry.DARK_BLUE_FANGXIN.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE)},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.DARK_BLUE_FANGXIN_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE)},
                recipeConsumer);
        fangxinWood(ItemRegistry.BLUE_AND_WHITE_FANGXIN.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get())},
                recipeConsumer);
        fangxinWood(ItemRegistry.GREEN_AND_DARK_BLUE_FANGXIN.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get())},
                recipeConsumer);
        fangxinWood(ItemRegistry.WHITE_AND_CYAN_FANGXIN.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_WHITE_DYE), Ingredient.of(ModItemTags.COMMON_CYAN_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get())},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.WHITE_AND_CYAN_FANGXIN_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_WHITE_DYE), Ingredient.of(ModItemTags.COMMON_CYAN_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get())},
                recipeConsumer);
        fangxinWood(ItemRegistry.WHITE_AND_BLUE_FANGXIN.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_WHITE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE)},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.WHITE_AND_BLUE_FANGXIN_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ItemRegistry.CYAN_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_WHITE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE)},
                recipeConsumer);
        fangxinWood(ItemRegistry.RED_CYAN_BLUE_FANGXIN.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_RED_DYE), Ingredient.of(ModItemTags.COMMON_CYAN_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ItemRegistry.RED_DYE_POWDER.get())},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.RED_CYAN_BLUE_FANGXIN_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_RED_DYE), Ingredient.of(ModItemTags.COMMON_CYAN_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get())},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.BLUE_CYAN_BLUE_FANGXIN_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_CYAN_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get())},
                recipeConsumer);
        fangxinWood(ItemRegistry.BLUE_CYAN_RED_FANGXIN.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_CYAN_DYE), Ingredient.of(ModItemTags.COMMON_RED_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get())},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.BLUE_CYAN_RED_FANGXIN_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_CYAN_DYE), Ingredient.of(ModItemTags.COMMON_RED_DYE), Ingredient.of(ItemRegistry.RED_DYE_POWDER.get())},
                recipeConsumer);
        fangxinWood(ItemRegistry.CYAN_BLUE_CYAN_FANGXIN.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_CYAN_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_CYAN_DYE)},
                recipeConsumer);
        fangxinWood(ItemRegistry.RED_BLUE_RED_FANGXIN.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_RED_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_RED_DYE)},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.CYAN_AND_YELLOW_FANGXIN_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_CYAN_DYE), Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get())},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.MING_BLUE_JINZHUOMO_SHINIANYU_XUANZI_FANGXIN_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE)},
                recipeConsumer);
        fangxinWood(ItemRegistry.MING_BLUE_GILDED_JINZHUOMO_SHINIANYU_XUANZI_FANGXIN.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get()), Ingredient.of(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get())},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.MING_BLUE_GILDED_JINZHUOMO_SHINIANYU_XUANZI_FANGXIN_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())},
                recipeConsumer);
        fangxinWood(ItemRegistry.MING_GREEN_GILDED_JINZHUOMO_SHINIANYU_XUANZI_FANGXIN.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get()), Ingredient.of(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get())},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.MING_GREEN_GILDED_JINZHUOMO_SHINIANYU_XUANZI_FANGXIN_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())},
                recipeConsumer);
        fangxinWood(ItemRegistry.QING_BLUE_PLAIN_JINZHUOMO_SHINIANYU_FANGXIN.get(), new Ingredient[]{
                        Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_LIGHT_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE)},
                recipeConsumer);
        fangxinWood(ItemRegistry.YUAN_NIANYUZHUANG_FANGXIN.get(), new Ingredient[]{
                        Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE)},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.YUAN_NIANYUZHUANG_FANGXIN_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ItemRegistry.CYAN_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE)},
                recipeConsumer);
        fangxinWood(ItemRegistry.YUAN_PATTERNED_NIANYUZHUANG_FANGXIN.get(), new Ingredient[]{
                        Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ItemRegistry.RED_DYE_POWDER.get())},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.YUAN_PATTERNED_NIANYUZHUANG_FANGXIN_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ItemRegistry.CYAN_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ItemRegistry.RED_DYE_POWDER.get())},
                recipeConsumer);
        fangxinWood(ItemRegistry.YUAN_GREEN_NIANYUZHUANG_FANGXIN.get(), new Ingredient[]{
                        Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE)},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.YUAN_GREEN_NIANYUZHUANG_FANGXIN_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ItemRegistry.CYAN_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE)},
                recipeConsumer);
        fangxinWood(ItemRegistry.YUAN_PATTERNED_WUCHAIZHUANG_FANGXIN.get(), new Ingredient[]{
                        Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_CYAN_DYE), Ingredient.of(ItemRegistry.ORANGE_DYE_POWDER.get())},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.YUAN_PATTERNED_WUCHAIZHUANG_FANGXIN_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ItemRegistry.RED_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ItemRegistry.ORANGE_DYE_POWDER.get())},
                recipeConsumer);
        fangxinWood(ItemRegistry.YUAN_GREEN_WUCHAIZHUANG_FANGXIN.get(), new Ingredient[]{
                        Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE)},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.YUAN_GREEN_WUCHAIZHUANG_FANGXIN_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ItemRegistry.RED_DYE_POWDER.get()), Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE)},
                recipeConsumer);

        // ZHAOTOU

        zhaotouWood(ItemRegistry.BLUE_ZHAOTOU_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ItemRegistry.RED_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_BLUE_DYE)},
                recipeConsumer);
        zhaotouWood(ItemRegistry.GREEN_AND_BLUE_ZHAOTOU.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get())},
                recipeConsumer);
        zhaotouWood(ItemRegistry.BLUE_AND_GREEN_ZHAOTOU.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get())},
                recipeConsumer);
        zhaotouWood(ItemRegistry.BLUE_AND_GREEN_DOUBLE_LAYERED_ZHAOTOU.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get())},
                recipeConsumer);
        zhaotouWood(ItemRegistry.CYAN_AND_RED_ZHAOTOU.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_CYAN_DYE), Ingredient.of(ModItemTags.COMMON_RED_DYE), Ingredient.of(ModItemTags.COMMON_CYAN_DYE)},
                recipeConsumer);
        zhaotouWood(ItemRegistry.CYAN_AND_BLUE_ZHAOTOU.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_CYAN_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_CYAN_DYE)},
                recipeConsumer);
        zhaotouWood(ItemRegistry.GRAY_BLACK_RED_ZHAOTOU.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_GRAY_DYE), Ingredient.of(ItemRegistry.BLACK_DYE_POWDER.get()), Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_RED_DYE)},
                recipeConsumer);
        zhaotouWood(ItemRegistry.BLUE_GREEN_RED_ZHAOTOU.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_RED_DYE), Ingredient.of(ItemRegistry.CYAN_DYE_POWDER.get())},
                recipeConsumer);
        zhaotouWood(ItemRegistry.RED_AND_BLUE_ZHAOTOU.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_RED_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_BLUE_DYE)},
                recipeConsumer);
        zhaotouWood(ItemRegistry.GREEN_AND_YELLOW_ZHAOTOU.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE)},
                recipeConsumer);
        zhaotouWood(ItemRegistry.RED_GREEN_BLUE_ZHAOTOU.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE), Ingredient.of(ItemRegistry.RED_DYE_POWDER.get())},
                recipeConsumer);
        zhaotouWood(ItemRegistry.WHITE_BLUE_GREEN_ZHAOTOU.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_WHITE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE)},
                recipeConsumer);
        zhaotouWood(ItemRegistry.MING_YANZHUOMO_SHINIANYU_OUTER_ZHAOTOU.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ItemRegistry.RED_DYE_POWDER.get())},
                recipeConsumer);
        zhaotouWood(ItemRegistry.MING_YANZHUOMO_SHINIANYU_OUTER_ZHAOTOU_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ItemRegistry.RED_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_BLUE_DYE)},
                recipeConsumer);
        zhaotouWood(ItemRegistry.YUAN_NIANYUZHUANG_ZHAOTOU.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE)},
                recipeConsumer);
        zhaotouWood(ItemRegistry.YUAN_NIANYUZHUANG_ZHAOTOU_CONNECTION.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE)},
                recipeConsumer);

        // GUTOU

        gutouWood(ItemRegistry.GREEN_BLUE_BLACK_GUTOU.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BLACK_DYE_POWDER.get())},
                recipeConsumer);
        gutouWood(ItemRegistry.BLUE_GREEN_YELLOW_GUTOU.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE)},
                recipeConsumer);
        gutouWood(ItemRegistry.BLUE_AND_YELLOW_GUTOU.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE)},
                recipeConsumer);
        gutouWood(ItemRegistry.MING_YANZHUOMO_SHINIANYU_OUTER_GUTOU_EDGE.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE)},
                recipeConsumer);
        gutouWood(ItemRegistry.YUAN_NIANYUZHUANG_GUTOU.get(), new Ingredient[]{
                        Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_BROWN_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE)},
                recipeConsumer);

        // RAFTERS

        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(Items.STRIPPED_DARK_OAK_LOG), ItemRegistry.DARK_OAK_RAFTER.get())
                .unlockedBy(itemUnlockName(Items.STRIPPED_DARK_OAK_LOG), itemCriterion(Items.STRIPPED_DARK_OAK_LOG)).save(recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(Items.STRIPPED_DARK_OAK_LOG), ItemRegistry.DARK_OAK_RAFTER_END.get())
                .unlockedBy(itemUnlockName(Items.STRIPPED_DARK_OAK_LOG), itemCriterion(Items.STRIPPED_DARK_OAK_LOG)).save(recipeConsumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ItemRegistry.GILDED_DARK_OAK_RAFTER.get())
                .requires(ItemRegistry.DARK_OAK_RAFTER.get()).requires(ItemRegistry.GOLD_PARTS.get())
                .unlockedBy(itemUnlockName(ItemRegistry.DARK_OAK_RAFTER.get()), itemCriterion(ItemRegistry.DARK_OAK_RAFTER.get())).save(recipeConsumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ItemRegistry.GILDED_DARK_OAK_RAFTER_END.get())
                .requires(ItemRegistry.DARK_OAK_RAFTER_END.get()).requires(ItemRegistry.GOLD_PARTS.get())
                .unlockedBy(itemUnlockName(ItemRegistry.DARK_OAK_RAFTER_END.get()), itemCriterion(ItemRegistry.DARK_OAK_RAFTER_END.get())).save(recipeConsumer);
        rafter(ItemRegistry.BLUE_TIGER_EYE_RAFTER.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())
        }, recipeConsumer);
        rafterEnd(ItemRegistry.BLUE_TIGER_EYE_RAFTER_END.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())
        }, recipeConsumer);
        rafter(ItemRegistry.BLUE_CARVED_TIGER_EYE_RAFTER.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())
        }, recipeConsumer);
        rafterEnd(ItemRegistry.BLUE_CARVED_TIGER_EYE_RAFTER_END.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_BLUE_DYE), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())
        }, recipeConsumer);
        rafter(ItemRegistry.GREEN_CARVED_TIGER_EYE_RAFTER.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())
        }, recipeConsumer);
        rafterEnd(ItemRegistry.GREEN_CARVED_TIGER_EYE_RAFTER_END.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())
        }, recipeConsumer);
        rafter(ItemRegistry.GREEN_WANZI_RAFTER.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())
        }, recipeConsumer);
        rafterEnd(ItemRegistry.GREEN_WANZI_RAFTER_END.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())
        }, recipeConsumer);
        rafter(ItemRegistry.GREEN_CARVED_WANZI_RAFTER.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())
        }, recipeConsumer);
        rafterEnd(ItemRegistry.GREEN_CARVED_WANZI_RAFTER_END.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())
        }, recipeConsumer);

        // BEAM HEAD

        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemRegistry.GILDED_DARK_OAK.get()), ItemRegistry.GILDED_DARK_OAK_BEAM_HEAD.get())
                .unlockedBy(itemUnlockName(ItemRegistry.GILDED_DARK_OAK.get()), itemCriterion(ItemRegistry.GILDED_DARK_OAK.get())).save(recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemRegistry.GREEN_CARVED_WOOD.get()), ItemRegistry.QING_GREEN_BEAM_HEAD.get())
                .unlockedBy(itemUnlockName(ItemRegistry.GREEN_CARVED_WOOD.get()), itemCriterion(ItemRegistry.GREEN_CARVED_WOOD.get())).save(recipeConsumer);

        // ARCHITRAVE

        architrave(ItemRegistry.RED_AND_CYAN_CARVED_ARCHITRAVE.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_RED_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_CYAN_DYE)
        }, recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, ItemRegistry.RED_AND_CYAN_CARVED_ARCHITRAVE.get(), ItemRegistry.RED_AND_CYAN_CARVED_ARCHITRAVE_SLAB.get(), 2, recipeConsumer);
        architrave(ItemRegistry.RED_AND_BLUE_CARVED_ARCHITRAVE.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_RED_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_BLUE_DYE)
        }, recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, ItemRegistry.RED_AND_BLUE_CARVED_ARCHITRAVE.get(), ItemRegistry.RED_AND_BLUE_CARVED_ARCHITRAVE_SLAB.get(), 2, recipeConsumer);
        architrave(ItemRegistry.EMPTY_TUANHUA_SLAB.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_CYAN_DYE), Ingredient.of(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get())
        }, recipeConsumer);
        architrave(ItemRegistry.FULL_TUANHUA_SLAB.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_CYAN_DYE), Ingredient.of(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ItemRegistry.CYAN_DYE_POWDER.get())
        }, recipeConsumer);
        architrave(ItemRegistry.RED_AND_CYAN_TUANHUA_SLAB.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_CYAN_DYE), Ingredient.of(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.RED_DYE_POWDER.get()), Ingredient.of(ItemRegistry.CYAN_DYE_POWDER.get())
        }, recipeConsumer);
        architrave(ItemRegistry.RED_CARVED_ARCHITRAVE.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_RED_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_RED_DYE)
        }, recipeConsumer);
        architrave(ItemRegistry.WHITE_AND_RED_SLAB.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_RED_DYE), Ingredient.of(ModItemTags.COMMON_RED_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get())
        }, recipeConsumer);

        // QUETI

        woodworking(RecipeCategory.DECORATIONS, ItemRegistry.GILDED_DARK_OAK.get(), ItemRegistry.LONG_GILDED_DARK_OAK_QUETI.get(), 1, recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.LONG_GILDED_DARK_OAK_QUETI_EDGE.get()).define('C', ItemRegistry.LONG_GILDED_DARK_OAK_QUETI.get()).pattern("CC")
                .unlockedBy(itemUnlockName(ItemRegistry.LONG_GILDED_DARK_OAK_QUETI.get()), itemCriterion(ItemRegistry.LONG_GILDED_DARK_OAK_QUETI.get())).save(recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, ItemRegistry.GILDED_DARK_OAK.get(), ItemRegistry.HORIZONTAL_GILDED_DARK_OAK_QUETI.get(), 1, recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.CENTRAL_GILDED_DARK_OAK_QUETI.get()).define('C', ItemRegistry.HORIZONTAL_GILDED_DARK_OAK_QUETI.get()).pattern("CC")
                .unlockedBy(itemUnlockName(ItemRegistry.HORIZONTAL_GILDED_DARK_OAK_QUETI.get()), itemCriterion(ItemRegistry.HORIZONTAL_GILDED_DARK_OAK_QUETI.get())).save(recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, ItemRegistry.GILDED_DARK_OAK.get(), ItemRegistry.VERTICAL_GILDED_DARK_OAK_QUETI.get(), 1, recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemTags.PLANKS), ItemRegistry.WOODEN_QUETI.get(), 2).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemTags.PLANKS), ItemRegistry.WOODEN_QUETI_EDGE.get(), 2).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemTags.PLANKS), ItemRegistry.TALL_WOODEN_QUETI_EDGE.get(), 1).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemTags.PLANKS), ItemRegistry.LARGE_WOODEN_QUETI_EDGE.get(), 1).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GREEN_GLAZED_TILES.get()), RecipeCategory.DECORATIONS, ItemRegistry.SHORT_GLAZED_QUETI.get(), 4)
                .unlockedBy(itemUnlockName(ItemRegistry.GREEN_GLAZED_TILES.get()), itemCriterion(ItemRegistry.GREEN_GLAZED_TILES.get())).save(recipeConsumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GREEN_GLAZED_TILES.get()), RecipeCategory.DECORATIONS, ItemRegistry.THICK_CARVED_QUETI.get(), 2)
                .unlockedBy(itemUnlockName(ItemRegistry.GREEN_GLAZED_TILES.get()), itemCriterion(ItemRegistry.GREEN_GLAZED_TILES.get())).save(recipeConsumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GREEN_GLAZED_TILES.get()), RecipeCategory.DECORATIONS, ItemRegistry.SHORT_THICK_GLAZED_QUETI.get(), 1)
                .unlockedBy(itemUnlockName(ItemRegistry.GREEN_GLAZED_TILES.get()), itemCriterion(ItemRegistry.GREEN_GLAZED_TILES.get())).save(recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemTags.PLANKS), ItemRegistry.WOODEN_GUALUO.get(), 1).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemTags.PLANKS), ItemRegistry.LARGE_WOODEN_GUALUO.get(), 1).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemTags.PLANKS), ItemRegistry.LARGE_WOODEN_GUALUO_EDGE.get(), 1).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.STONE), RecipeCategory.DECORATIONS, ItemRegistry.CARVED_STONE_PANEL.get(), 1)
                .unlockedBy(itemUnlockName(Items.STONE), itemCriterion(Items.STONE)).save(recipeConsumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.STONE), RecipeCategory.DECORATIONS, ItemRegistry.CARVED_STONE_PANEL_EDGE.get(), 1)
                .unlockedBy(itemUnlockName(Items.STONE), itemCriterion(Items.STONE)).save(recipeConsumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.STONE), RecipeCategory.DECORATIONS, ItemRegistry.CARVED_STONE_PANEL_CENTER.get(), 1)
                .unlockedBy(itemUnlockName(Items.STONE), itemCriterion(Items.STONE)).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.CARVED_STONE_QUETI_PART.get())
                .define('E', ItemRegistry.CARVED_STONE_PANEL_EDGE.get())
                .define('C', ItemRegistry.CARVED_STONE_PANEL_CENTER.get())
                .pattern("EC")
                .unlockedBy(itemUnlockName(ItemRegistry.CARVED_STONE_PANEL.get()), itemCriterion(ItemRegistry.CARVED_STONE_PANEL.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.CARVED_STONE_BEAM.get())
                .define('C', ItemRegistry.CARVED_STONE_PANEL.get())
                .pattern("CCC")
                .unlockedBy(itemUnlockName(ItemRegistry.CARVED_STONE_PANEL.get()), itemCriterion(ItemRegistry.CARVED_STONE_PANEL.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.CARVED_STONE_QUETI.get())
                .define('E', ItemRegistry.CARVED_STONE_PANEL_EDGE.get())
                .pattern("E").pattern("E")
                .unlockedBy(itemUnlockName(ItemRegistry.CARVED_STONE_PANEL.get()), itemCriterion(ItemRegistry.CARVED_STONE_PANEL.get())).save(recipeConsumer);

        // PATTERNS

        caihua(ItemRegistry.YELLOW_CARVED_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_YELLOW_DYE), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE)
        }, recipeConsumer);
        caihua(ItemRegistry.CIRCULAR_YELLOW_CARVED_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE), Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get())
        }, recipeConsumer);
        fangxinEdgePattern(ItemRegistry.YELLOW_CARVED_FANGXIN_EDGE_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_YELLOW_DYE), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE)
        }, recipeConsumer);
        fangxinPattern(ItemRegistry.YELLOW_CARVED_FANGXIN_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_YELLOW_DYE), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE)
        }, recipeConsumer);
        caihua(ItemRegistry.LARGE_YELLOW_CARVED_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_YELLOW_DYE), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE)
        }, recipeConsumer);
        caihua(ItemRegistry.MEDIUM_YELLOW_CARVED_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE), Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get())
        }, recipeConsumer);
        zhaotouPattern(ItemRegistry.YELLOW_CARVED_ZHAOTOU_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_YELLOW_DYE), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE)
        }, recipeConsumer);
        zhaotouPattern(ItemRegistry.LONG_YELLOW_CARVED_ZHAOTOU_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_YELLOW_DYE), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE), Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get())
        }, recipeConsumer);
        zhaotouPattern(ItemRegistry.CARVED_ZHAOTOU_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_YELLOW_DYE), Ingredient.of(ModItemTags.COMMON_WHITE_DYE)
        }, recipeConsumer);
        caihua(ItemRegistry.FLAME_ARCH_WALL_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.COMMON_ORANGE_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get())
        }, recipeConsumer);
        fangxinPattern(ItemRegistry.BLUE_FANGXIN_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.BLACK_DYE_POWDER.get()), Ingredient.of(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BROWN_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_BLUE_DYE)
        }, recipeConsumer);
        fangxinEdgePattern(ItemRegistry.BLUE_FANGXIN_PATTERN_EDGE.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.BLACK_DYE_POWDER.get()), Ingredient.of(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BROWN_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_BLUE_DYE)
        }, recipeConsumer);
        fangxinPattern(ItemRegistry.GREEN_FANGXIN_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.BLACK_DYE_POWDER.get()), Ingredient.of(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BROWN_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_GREEN_DYE)
        }, recipeConsumer);
        fangxinEdgePattern(ItemRegistry.GREEN_FANGXIN_PATTERN_EDGE.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.BLACK_DYE_POWDER.get()), Ingredient.of(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BROWN_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_GREEN_DYE)
        }, recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.GOLDEN_DRAGON_FANGXIN_PATTERN.get())
                .define('C', ItemRegistry.BLUE_FANGXIN_PATTERN.get())
                .define('E', ItemRegistry.BLUE_FANGXIN_PATTERN_EDGE.get())
                .define('G', ItemRegistry.GOLD_DYE_POWDER.get())
                .pattern("GGG").pattern("ECE")
                .unlockedBy(itemUnlockName(ItemRegistry.BLUE_FANGXIN_PATTERN.get()), itemCriterion(ItemRegistry.BLUE_FANGXIN_PATTERN.get()))
                .save(recipeConsumer);
        caihua(ItemRegistry.LIGHT_BLUE_SU_STYLE_CAIHUA.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get()), Ingredient.of(ItemRegistry.RED_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_LIGHT_BLUE_DYE)
        }, recipeConsumer);
        caihua(ItemRegistry.YELLOW_SU_STYLE_CAIHUA.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get()), Ingredient.of(ItemRegistry.RED_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE)
        }, recipeConsumer);
        caihua(ItemRegistry.LIGHT_YELLOW_SU_STYLE_CAIHUA.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get()), Ingredient.of(ItemRegistry.RED_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_YELLOW_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get())
        }, recipeConsumer);
        caihua(ItemRegistry.MEDIUM_SU_STYLE_CAIHUA.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get())
        }, recipeConsumer);
        caihua(ItemRegistry.LARGE_WHITE_SU_STYLE_CAIHUA.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_WHITE_DYE), Ingredient.of(ModItemTags.COMMON_WHITE_DYE)
        }, recipeConsumer);
        caihua(ItemRegistry.LARGE_GREEN_SU_STYLE_CAIHUA.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_GREEN_DYE), Ingredient.of(ModItemTags.COMMON_GREEN_DYE)
        }, recipeConsumer);
        caihua(ItemRegistry.LARGE_GRAY_SU_STYLE_CAIHUA.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ModItemTags.COMMON_GRAY_DYE), Ingredient.of(ModItemTags.COMMON_GRAY_DYE)
        }, recipeConsumer);

        // CHUIHUA

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.BLUE_AND_GREEN_CHUIHUA.get())
                .define('R', ItemRegistry.RED_CARVED_WOODEN_SLAB.get())
                .define('B', ItemRegistry.BLUE_CARVED_WOODEN_SLAB.get())
                .define('G', ItemRegistry.GREEN_CARVED_WOODEN_SLAB.get())
                .pattern("R").pattern("B").pattern("G")
                .unlockedBy(itemUnlockName(ItemRegistry.BLUE_CARVED_WOODEN_SLAB.get()), itemCriterion(ItemRegistry.BLUE_CARVED_WOODEN_SLAB.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.CYAN_AND_YELLOW_CHUIHUA.get())
                .define('C', ItemRegistry.CYAN_CARVED_WOODEN_SLAB.get())
                .define('O', ItemRegistry.BLUE_AND_RED_CARVED_WOOD.get())
                .define('G', ItemRegistry.YELLOW_AND_GREEN_CARVED_WOOD.get())
                .pattern("C").pattern("O").pattern("G")
                .unlockedBy(itemUnlockName(ItemRegistry.CYAN_CARVED_WOODEN_SLAB.get()), itemCriterion(ItemRegistry.CYAN_CARVED_WOODEN_SLAB.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.GILDED_DARK_OAK_CHUIHUA.get())
                .define('S', ItemRegistry.GILDED_DARK_OAK_SLAB.get())
                .define('B', ItemRegistry.GILDED_DARK_OAK.get())
                .define('P', ItemRegistry.GOLD_PARTS.get())
                .pattern("S").pattern("B").pattern("P")
                .unlockedBy(itemUnlockName(ItemRegistry.GILDED_DARK_OAK.get()), itemCriterion(ItemRegistry.GILDED_DARK_OAK.get()))
                .save(recipeConsumer);

        // ROOF CHARM

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.GOLDEN_GLAZED_ROOF_CHARM.get())
                .define('G', Items.YELLOW_GLAZED_TERRACOTTA)
                .define('R', ItemRegistry.YELLOW_ROOF_RIDGE_CONNECTION.get())
                .define('S', ItemRegistry.YELLOW_ROOF_TILE_STAIRS.get())
                .define('P', ItemRegistry.GOLD_PARTS.get())
                .define('D', ItemRegistry.GOLD_DYE_POWDER.get())
                .pattern(" SP")
                .pattern("DGG")
                .pattern("RGG")
                .unlockedBy(itemUnlockName(Items.YELLOW_GLAZED_TERRACOTTA), itemCriterion(Items.YELLOW_GLAZED_TERRACOTTA))
                .save(recipeConsumer);
        simpleStonecutting(Items.YELLOW_GLAZED_TERRACOTTA, ItemRegistry.GOLDEN_GLAZED_ROOF_CHARM_ACCESSORY.get(), RecipeCategory.DECORATIONS, recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.GREEN_GLAZED_ROOF_CHARM.get())
                .define('G', Items.GREEN_GLAZED_TERRACOTTA)
                .define('R', ItemRegistry.BLACK_ROOF_RIDGE_CONNECTION.get())
                .define('P', ItemRegistry.GOLD_PARTS.get())
                .define('S', ItemRegistry.GRAY_ROOF_TILE_STAIRS.get())
                .pattern(" SP")
                .pattern(" PG")
                .pattern("RRG")
                .unlockedBy(itemUnlockName(Items.GREEN_GLAZED_TERRACOTTA), itemCriterion(Items.GREEN_GLAZED_TERRACOTTA))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.DARK_PRISMARINE_CHIWEI.get())
                .define('B', Items.DARK_PRISMARINE)
                .define('S', Items.DARK_PRISMARINE_STAIRS)
                .define('H', Items.DARK_PRISMARINE_SLAB)
                .pattern("HS")
                .pattern("SB")
                .pattern("BB")
                .unlockedBy(itemUnlockName(Items.GREEN_GLAZED_TERRACOTTA), itemCriterion(Items.GREEN_GLAZED_TERRACOTTA))
                .save(recipeConsumer);

        // CEILING

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.QING_GOLDEN_DRAGON_CEILING.get())
                .define('G', ItemRegistry.GREEN_CARVED_WOOD.get())
                .define('B', ModItemTags.COMMON_BLUE_DYE)
                .define('D', ItemRegistry.GOLD_DYE_POWDER.get())
                .pattern("G").pattern("B").pattern("D")
                .unlockedBy(itemUnlockName(ItemRegistry.GREEN_CARVED_WOOD.get()), itemCriterion(ItemRegistry.GREEN_CARVED_WOOD.get()))
                .save(recipeConsumer);

        // RAILING

        simpleStonecutting(Items.QUARTZ_BLOCK, ItemRegistry.WHITE_MARBLE_RAILING.get(), RecipeCategory.DECORATIONS, recipeConsumer);
        simpleStonecutting(Items.QUARTZ_BLOCK, ItemRegistry.WHITE_MARBLE_RAILING_SLANT.get(), RecipeCategory.DECORATIONS, recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemTags.PLANKS), ItemRegistry.CARVED_WOODEN_RAILING.get(), 1).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemTags.PLANKS), ItemRegistry.WOODEN_RAILING.get(), 1).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemTags.PLANKS), ItemRegistry.WOODEN_RAILING_VARIANT.get(), 1).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        blockTransform(ItemRegistry.WOODEN_RAILING.get(), ModItemTags.COMMON_RED_DYE, ItemRegistry.RED_WOODEN_RAILING_EDGE.get(), RecipeCategory.DECORATIONS, recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.RED_WOODEN_RAILING.get(), 2).define('C', ItemRegistry.RED_WOODEN_RAILING_EDGE.get()).pattern("CC")
                .unlockedBy(itemUnlockName(ItemRegistry.RED_WOODEN_RAILING_EDGE.get()), itemCriterion(ItemRegistry.RED_WOODEN_RAILING_EDGE.get())).save(recipeConsumer);

        // GUARDIAN LION

        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemTags.LOGS), ItemRegistry.SMALL_WOODEN_GUARDIAN_LION.get(), 1).unlockedBy("has_log", tagUnlock(ItemTags.LOGS)).save(recipeConsumer);
        simpleStonecutting(Items.STONE, ItemRegistry.SMALL_STONE_GUARDIAN_LION.get(), RecipeCategory.DECORATIONS, recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.SMALL_JADE_GUARDIAN_LION.get())
                .define('L', ItemRegistry.SMALL_STONE_GUARDIAN_LION.get())
                .define('J', ItemRegistry.JADE.get())
                .define('P', ItemRegistry.JADE_PARTS.get())
                .pattern("PJP")
                .pattern("JLJ")
                .pattern("PJP")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_STONE_GUARDIAN_LION.get()), itemCriterion(ItemRegistry.SMALL_STONE_GUARDIAN_LION.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.SMALL_YELLOW_GLAZED_GUARDIAN_LION.get())
                .define('L', ItemRegistry.SMALL_STONE_GUARDIAN_LION.get())
                .define('G', Items.YELLOW_GLAZED_TERRACOTTA)
                .define('P', ItemRegistry.GOLD_PARTS.get())
                .define('D', ItemRegistry.GOLD_DYE_POWDER.get())
                .pattern("DGD")
                .pattern("GLG")
                .pattern("PGP")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_STONE_GUARDIAN_LION.get()), itemCriterion(ItemRegistry.SMALL_STONE_GUARDIAN_LION.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.SMALL_GREEN_GLAZED_GUARDIAN_LION.get())
                .define('L', ItemRegistry.SMALL_STONE_GUARDIAN_LION.get())
                .define('G', ItemRegistry.GREEN_GLAZED_TILES.get())
                .define('P', ItemRegistry.PORCELAIN_PARTS.get())
                .pattern("PGP")
                .pattern("GLG")
                .pattern("PGP")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_STONE_GUARDIAN_LION.get()), itemCriterion(ItemRegistry.SMALL_STONE_GUARDIAN_LION.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.XUMI_STONE_MONOLITH.get())
                .define('B', ItemRegistry.STONE_PILLAR_BASE.get())
                .define('C', Items.CHISELED_STONE_BRICKS)
                .define('S', Items.STONE)
                .define('H', Items.STONE_SLAB)
                .pattern("HHH")
                .pattern("SCS")
                .pattern("BBB")
                .unlockedBy(itemUnlockName(ItemRegistry.STONE_PILLAR_BASE.get()), itemCriterion(ItemRegistry.STONE_PILLAR_BASE.get()))
                .save(recipeConsumer);

        // MISC DECORATIONS

        // Baskets sold by Cook villager
        woodworking(RecipeCategory.DECORATIONS, Items.BOOKSHELF, ItemRegistry.BOOKSHELF.get(), 1, recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, Items.BOOKSHELF, ItemRegistry.BOOKSHELF_VARIANT.get(), 1, recipeConsumer);

    }

    private static void categoryDecorations(@NotNull RecipeOutput recipeConsumer) {

        // STUDY

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.ABACUS.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('P', ItemRegistry.WOODEN_PARTS.get())
                .define('S', Items.STICK)
                .pattern("PFP")
                .pattern("SSS")
                .pattern("PFP")
                .unlockedBy(itemUnlockName(ItemRegistry.WOODEN_PARTS.get()), itemCriterion(ItemRegistry.WOODEN_PARTS.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.BRUSH_TOOLS.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('P', ItemRegistry.WOODEN_PARTS.get())
                .define('S', Items.STICK)
                .pattern("SSS")
                .pattern("S S")
                .pattern("PFP")
                .unlockedBy(itemUnlockName(ItemRegistry.WOODEN_PARTS.get()), itemCriterion(ItemRegistry.WOODEN_PARTS.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.BRUSH_AND_INKSTONE.get())
                .define('S', Items.STICK)
                .define('F', ItemRegistry.FUR.get())
                .define('R', Items.STONE_SLAB)
                .define('I', Items.INK_SAC)
                .define('P', ItemRegistry.XUAN_PAPER.get())
                .pattern("S ")
                .pattern("FI")
                .pattern("RP")
                .unlockedBy(itemUnlockName(ItemRegistry.XUAN_PAPER.get()), itemCriterion(ItemRegistry.XUAN_PAPER.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.RULER.get())
                .define('S', Items.STICK)
                .define('P', ItemRegistry.WOODEN_PARTS.get())
                .pattern("SPS")
                .unlockedBy(itemUnlockName(ItemRegistry.WOODEN_PARTS.get()), itemCriterion(ItemRegistry.WOODEN_PARTS.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.BOOK_STACK.get())
                .define('B', Items.BOOK)
                .define('D', ItemRegistry.BLUE_DYE_POWDER.get())
                .pattern("BD").pattern("BD").pattern("BD")
                .unlockedBy(itemUnlockName(Items.BOOK), itemCriterion(Items.BOOK))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.PAPER.get(), 2)
                .define('P', ItemRegistry.XUAN_PAPER.get())
                .pattern("PP")
                .unlockedBy(itemUnlockName(ItemRegistry.XUAN_PAPER.get()), itemCriterion(ItemRegistry.XUAN_PAPER.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.BLUE_BOOK.get())
                .define('B', Items.BOOK)
                .define('D', ItemRegistry.BLUE_DYE_POWDER.get())
                .pattern("BD")
                .unlockedBy(itemUnlockName(Items.BOOK), itemCriterion(Items.BOOK))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.BAMBOO_SLIPS.get())
                .define('S', Items.STRING)
                .define('B', Items.BAMBOO)
                .pattern("BBS").pattern("BBS").pattern("BBS")
                .unlockedBy(itemUnlockName(Items.BAMBOO), itemCriterion(Items.BAMBOO))
                .save(recipeConsumer);

        // ROOM DECO

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.BACK_CUSHION.get())
                .define('W', Items.YELLOW_WOOL)
                .define('S', ItemRegistry.SILK.get())
                .pattern("WS")
                .pattern("WS")
                .unlockedBy(itemUnlockName(ItemRegistry.SILK.get()), itemCriterion(ItemRegistry.SILK.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.CHESSBOARD.get())
                .define('P', ModItemTags.POLISHED_PLANKS)
                .define('B', Items.POLISHED_BLACKSTONE)
                .define('W', Items.SMOOTH_QUARTZ)
                .pattern("BW")
                .pattern("PP")
                .unlockedBy("has_polished_plank", tagUnlock(ModItemTags.POLISHED_PLANKS))
                .save(recipeConsumer);
        compositeSmelting(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_VASE.get(), ItemRegistry.MEDIUM_CLAY_VASE.get(), ItemRegistry.BLUE_AND_WHITE_GLAZE_POWDER.get(), 0.1f, 200, recipeConsumer);
        compositeSmelting(ItemRegistry.LARGE_BLUE_AND_WHITE_PORCELAIN_VASE.get(), ItemRegistry.LARGE_CLAY_VASE.get(), ItemRegistry.BLUE_AND_WHITE_GLAZE_POWDER.get(), 0.1f, 200, recipeConsumer);
        compositeSmelting(ItemRegistry.SHORT_BLUE_AND_WHITE_PORCELAIN_POT.get(), ItemRegistry.CLAY_POT.get(), ItemRegistry.BLUE_AND_WHITE_GLAZE_POWDER.get(), 0.1f, 200, recipeConsumer);
        compositeSmelting(ItemRegistry.TALL_BLUE_AND_WHITE_PORCELAIN_POT.get(), ItemRegistry.TALL_CLAY_POT.get(), ItemRegistry.BLUE_AND_WHITE_GLAZE_POWDER.get(), 0.1f, 200, recipeConsumer);
        compositeSmelting(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_BOWL.get(), ItemRegistry.CLAY_BOWL.get(), ItemRegistry.BLUE_AND_WHITE_GLAZE_POWDER.get(), 0.1f, 200, recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.BRONZE_MIRROR.get())
                .define('I', ItemRegistry.BRONZE_INGOT.get())
                .define('P', ItemRegistry.BRONZE_PARTS.get())
                .define('C', Items.COPPER_INGOT)
                .pattern("PIP")
                .pattern("CIC")
                .unlockedBy(itemUnlockName(ItemRegistry.BRONZE_INGOT.get()), itemCriterion(ItemRegistry.BRONZE_INGOT.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.MEMORIAL_TABLET.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('P', ModItemTags.POLISHED_PLANKS)
                .define('E', ItemRegistry.WOODEN_PARTS.get())
                .define('S', ItemRegistry.SILK.get())
                .define('W', Items.BLACK_WOOL)
                .pattern("EWE")
                .pattern("SPS")
                .pattern("EFE")
                .unlockedBy("has_polished_plank", tagUnlock(ModItemTags.POLISHED_PLANKS))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.BRONZE_CENSER.get())
                .define('I', ItemRegistry.BRONZE_INGOT.get())
                .define('P', ItemRegistry.BRONZE_PARTS.get())
                .pattern("PIP")
                .pattern("III")
                .unlockedBy(itemUnlockName(ItemRegistry.BRONZE_INGOT.get()), itemCriterion(ItemRegistry.BRONZE_INGOT.get()))
                .save(recipeConsumer);
        CompositeSmeltingRecipeBuilder.compositeSmelting(Ingredient.of(ItemRegistry.BRONZE_CENSER.get()), Ingredient.of(ModItemTags.COMMON_CYAN_DYE),
                        ItemRegistry.ROYAL_CENSER.get(), 0.5f, 200)
                .unlockedBy(itemUnlockName(ItemRegistry.BRONZE_CENSER.get()), itemCriterion(ItemRegistry.BRONZE_CENSER.get()))
                .save(recipeConsumer);
        // Porcelain Teapot sold by librarian
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.BOOTS.get())
                .define('B', Items.LEATHER_BOOTS)
                .define('S', ItemRegistry.SILK.get())
                .define('D', ItemRegistry.BLACK_DYE_POWDER.get())
                .pattern("D D")
                .pattern("SBS")
                .pattern("SSS")
                .unlockedBy(itemUnlockName(ItemRegistry.SILK.get()), itemCriterion(ItemRegistry.SILK.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.JADE_PENDANT.get())
                .define('J', ItemRegistry.JADE.get())
                .define('S', Items.STRING)
                .define('R', ItemRegistry.RED_DYE_POWDER.get())
                .pattern("J")
                .pattern("S")
                .pattern("R")
                .unlockedBy(itemUnlockName(ItemRegistry.JADE.get()), itemCriterion(ItemRegistry.JADE.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.IMPERIAL_JADE_SEAL.get())
                .define('J', ItemRegistry.JADE.get())
                .define('G', Items.ENCHANTED_GOLDEN_APPLE)
                .define('P', ItemRegistry.GOLD_PARTS.get())
                .pattern("PG")
                .pattern("JJ")
                .pattern("JJ")
                .unlockedBy(itemUnlockName(ItemRegistry.JADE.get()), itemCriterion(ItemRegistry.JADE.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.LONG_PILLOW.get())
                .define('Y', Items.YELLOW_WOOL)
                .define('R', Items.RED_WOOL)
                .define('S', ItemRegistry.SILK.get())
                .pattern("SSS")
                .pattern("YRY")
                .unlockedBy(itemUnlockName(ItemRegistry.SILK.get()), itemCriterion(ItemRegistry.SILK.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.WIND_CHIME.get())
                .define('C', Items.CHAIN)
                .define('B', ItemRegistry.BRONZE_INGOT.get())
                .define('P', ItemRegistry.BRONZE_PARTS.get())
                .pattern("C")
                .pattern("B")
                .pattern("P")
                .unlockedBy(itemUnlockName(ItemRegistry.BRONZE_INGOT.get()), itemCriterion(ItemRegistry.BRONZE_INGOT.get()))
                .save(recipeConsumer);

        // MISC OBJECTS
        // Fabric rolls and dolls sold by special trader
        // Bottle Gourd sold by Cook

        // FLOWER POTS

        compositeSmelting(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_FLOWERPOT.get(), Items.FLOWER_POT, ItemRegistry.BLUE_AND_WHITE_GLAZE_POWDER.get(), 0.1f, 200, recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.TERRACOTTA_FLOWERPOT.get())
                .define('P', Items.FLOWER_POT)
                .define('T', Items.TERRACOTTA)
                .pattern("T T")
                .pattern("TPT")
                .unlockedBy(itemUnlockName(Items.FLOWER_POT), itemCriterion(Items.FLOWER_POT))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.BLACK_IRON_FLOWERPOT.get())
                .define('P', Items.FLOWER_POT)
                .define('I', Items.IRON_INGOT)
                .define('D', Items.BLACK_DYE)
                .pattern("IDI")
                .pattern("IPI")
                .unlockedBy(itemUnlockName(Items.FLOWER_POT), itemCriterion(Items.FLOWER_POT))
                .save(recipeConsumer);
        compositeSmelting(ItemRegistry.BLUE_PORCELAIN_FLOWERPOT.get(), Items.FLOWER_POT, Items.BLUE_DYE, 0.1f, 200, recipeConsumer);

        // COURTYARD

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.SACK.get())
                .define('T', Items.STRING)
                .define('S', ItemRegistry.SILK.get())
                .pattern(" T ")
                .pattern("SSS")
                .unlockedBy(itemUnlockName(ItemRegistry.SILK.get()), itemCriterion(ItemRegistry.SILK.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.EMPTY_BAMBOO_TEA_BASKET.get())
                .define('B', Items.BAMBOO)
                .define('P', ItemTags.PLANKS)
                .define('R', Items.RED_DYE)
                .define('X', ItemRegistry.XUAN_PAPER.get())
                .pattern("BRB")
                .pattern("PXP")
                .pattern("BPB")
                .unlockedBy(itemUnlockName(Items.BAMBOO), itemCriterion(Items.BAMBOO))
                .save(recipeConsumer);
        // Full Tea Basket via Farmer trade
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.STRAW_HAT.get())
                .define('W', Items.WHEAT)
                .define('S', ItemRegistry.SILK.get())
                .define('R', ItemRegistry.RED_DYE_POWDER.get())
                .pattern("RSR")
                .pattern("WWW")
                .unlockedBy(itemUnlockName(ItemRegistry.SILK.get()), itemCriterion(ItemRegistry.SILK.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.KNIFE.get())
                .define('S', Items.IRON_SWORD)
                .define('B', ItemRegistry.BRONZE_PARTS.get())
                .pattern("S ")
                .pattern(" B")
                .unlockedBy(itemUnlockName(ItemRegistry.BRONZE_PARTS.get()), itemCriterion(ItemRegistry.BRONZE_PARTS.get()))
                .save(recipeConsumer);
        // sundial sold by cleric todo time showing
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.BROOM.get())
                .define('S', Items.STICK)
                .define('H', Items.HAY_BLOCK)
                .pattern("S")
                .pattern("H")
                .unlockedBy(itemUnlockName(Items.HAY_BLOCK), itemCriterion(Items.HAY_BLOCK))
                .save(recipeConsumer);
        simpleStonecutting(ItemRegistry.PALE_YELLOW_STONE.get(), ItemRegistry.STONE_PEDESTAL.get(), RecipeCategory.DECORATIONS, recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.TERRACOTTA_POT.get())
                .define('T', Items.CYAN_TERRACOTTA)
                .pattern("T T")
                .pattern("TTT")
                .unlockedBy(itemUnlockName(Items.CYAN_TERRACOTTA), itemCriterion(Items.CYAN_TERRACOTTA))
                .save(recipeConsumer);
        // Chinese herbs bag sold by special trader
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.FRUIT_BOX.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('P', ModItemTags.POLISHED_PLANKS)
                .define('A', Items.APPLE)
                .pattern("PAP")
                .pattern("PFP")
                .unlockedBy(itemUnlockName(Items.APPLE), itemCriterion(Items.APPLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.WOODEN_CRATE.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('P', ModItemTags.POLISHED_PLANKS)
                .pattern("PPP")
                .pattern("PFP")
                .pattern("PPP")
                .unlockedBy("has_polished_plank", tagUnlock(ModItemTags.POLISHED_PLANKS))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.GUNNY_SACK.get())
                .define('S', ItemRegistry.SILK.get())
                .pattern("S S")
                .pattern("S S")
                .pattern("SSS")
                .unlockedBy(itemUnlockName(ItemRegistry.SILK.get()), itemCriterion(ItemRegistry.SILK.get()))
                .save(recipeConsumer);
        // bronze ding only from special loot
        // carriage from toolsmith
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.WOODEN_POLES.get())
                .define('F', ItemTags.WOODEN_FENCES)
                .pattern("F F")
                .pattern("F F")
                .pattern("F F")
                .unlockedBy("has_fence", tagUnlock(ItemTags.WOODEN_FENCES))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.TEAHOUSE_FLAG.get())
                .define('F', ItemTags.WOODEN_FENCES)
                .define('P', ItemRegistry.WOODEN_PARTS.get())
                .define('B', ItemTags.BANNERS)
                .pattern("PFP")
                .pattern(" B ")
                .pattern(" F ")
                .unlockedBy("has_banner", tagUnlock(ItemTags.BANNERS))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.KNIFE_REST.get())
                .define('F', ItemTags.WOODEN_FENCES)
                .define('P', ItemTags.PLANKS)
                .pattern("FFF")
                .pattern("PPP")
                .pattern("FFF")
                .unlockedBy("has_fence", tagUnlock(ItemTags.WOODEN_FENCES))
                .save(recipeConsumer);

        // WALL HANGING

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ItemRegistry.HORIZONTAL_LANDSCAPE_PAINTING.get()), RecipeCategory.DECORATIONS, ItemRegistry.DAMAGED_LANDSCAPE_PAINTING.get(), 0.1f, 400)
                .unlockedBy(itemUnlockName(ItemRegistry.HORIZONTAL_LANDSCAPE_PAINTING.get()), itemCriterion(ItemRegistry.HORIZONTAL_LANDSCAPE_PAINTING.get())).save(recipeConsumer);

        // FOOD

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ItemRegistry.FOOD_HAMPER.get())
                .define('C', Items.CHEST)
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('P', ModItemTags.POLISHED_PLANKS)
                .define('B', Items.BREAD)
                .pattern("FBF")
                .pattern("PCP")
                .pattern("PCP")
                .unlockedBy(itemUnlockName(Items.CHEST), itemCriterion(Items.CHEST))
                .save(recipeConsumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistry.PLATED_MOON_CAKES.get())
                .requires(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PLATE.get())
                .requires(ItemRegistry.MOONCAKE.get(), 4)
                .unlockedBy(itemUnlockName(ItemRegistry.MOONCAKE.get()), itemCriterion(ItemRegistry.MOONCAKE.get()))
                .save(recipeConsumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistry.PLATED_MUNG_BEAN_CAKES.get())
                .requires(ItemRegistry.BLACK_PORCELAIN_PLATE.get())
                .requires(ItemRegistry.MUNG_BEAN_CAKE.get(), 7)
                .unlockedBy(itemUnlockName(ItemRegistry.MUNG_BEAN_CAKE.get()), itemCriterion(ItemRegistry.MUNG_BEAN_CAKE.get()))
                .save(recipeConsumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistry.PLATED_HAM.get())
                .requires(ItemRegistry.POLISHED_OAK_PLANK.get())
                .requires(ItemRegistry.COOKED_MEAT.get(), 4)
                .unlockedBy(itemUnlockName(ItemRegistry.COOKED_MEAT.get()), itemCriterion(ItemRegistry.COOKED_MEAT.get()))
                .save(recipeConsumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistry.PLATED_FISH.get())
                .requires(ItemRegistry.POLISHED_OAK_PLANK.get())
                .requires(Ingredient.of(ItemTags.FISHES), 3)
                .unlockedBy("has_fish", tagUnlock(ItemTags.FISHES))
                .save(recipeConsumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistry.SCATTERED_CARROTS.get())
                .requires(ItemRegistry.POLISHED_OAK_PLANK.get())
                .requires(Items.CARROT, 2)
                .unlockedBy(itemUnlockName(Items.CARROT), itemCriterion(Items.CARROT))
                .save(recipeConsumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ItemRegistry.XIAOLONGBAO.get())
                .requires(ItemRegistry.BAMBOO_MAT_SLAB.get())
                .requires(ItemRegistry.BAOZI.get(), 8)
                .unlockedBy(itemUnlockName(ItemRegistry.BAOZI.get()), itemCriterion(ItemRegistry.BAOZI.get()))
                .save(recipeConsumer);

        // ICE

        simpleStonecutting(Items.ICE, ItemRegistry.ICICLE.get(), RecipeCategory.DECORATIONS, recipeConsumer);
        simpleStonecutting(Items.ICE, ItemRegistry.LARGE_ICICLE.get(), RecipeCategory.DECORATIONS, recipeConsumer);

        // CELEBRATIONS

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.COUPLET.get(), 2)
                .define('P', ItemRegistry.XUAN_PAPER.get())
                .define('R', ItemRegistry.RED_DYE_POWDER.get())
                .define('I', Items.INK_SAC)
                .pattern("PRP")
                .pattern("PIP")
                .pattern("PRP")
                .unlockedBy(itemUnlockName(ItemRegistry.XUAN_PAPER.get()), itemCriterion(ItemRegistry.XUAN_PAPER.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.COUPLET_TOP.get())
                .define('P', ItemRegistry.XUAN_PAPER.get())
                .define('R', ItemRegistry.RED_DYE_POWDER.get())
                .define('I', Items.INK_SAC)
                .pattern("PPP")
                .pattern("RIR")
                .unlockedBy(itemUnlockName(ItemRegistry.XUAN_PAPER.get()), itemCriterion(ItemRegistry.XUAN_PAPER.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.FU_MARK.get())
                .define('P', ItemRegistry.XUAN_PAPER.get())
                .define('R', ItemRegistry.RED_DYE_POWDER.get())
                .define('G', ItemRegistry.GOLD_DYE_POWDER.get())
                .define('I', Items.INK_SAC)
                .pattern("GPR")
                .pattern("PIP")
                .pattern("RPG")
                .unlockedBy(itemUnlockName(ItemRegistry.XUAN_PAPER.get()), itemCriterion(ItemRegistry.XUAN_PAPER.get()))
                .save(recipeConsumer);

    }

    private static void categoryPlants(@NotNull RecipeOutput recipeConsumer) {

        // LOTUS

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ItemRegistry.SMALL_LOTUS_LEAF.get(), 2).requires(Items.LILY_PAD).requires(Items.BIG_DRIPLEAF)
                .unlockedBy(itemUnlockName(Items.BIG_DRIPLEAF), itemCriterion(Items.LILY_PAD, Items.BIG_DRIPLEAF)).save(recipeConsumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ItemRegistry.SMALL_DARK_GREEN_LOTUS_LEAF.get(), 1).requires(ItemRegistry.SMALL_LOTUS_LEAF.get())
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_LOTUS_LEAF.get()), itemCriterion(ItemRegistry.SMALL_LOTUS_LEAF.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.MEDIUM_LOTUS_LEAF.get(), 1)
                .define('L', ItemRegistry.SMALL_LOTUS_LEAF.get()).pattern("LL")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_LOTUS_LEAF.get()), itemCriterion(ItemRegistry.SMALL_LOTUS_LEAF.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.LARGE_LOTUS_LEAF.get(), 1)
                .define('L', ItemRegistry.SMALL_LOTUS_LEAF.get()).pattern("LLL")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_LOTUS_LEAF.get()), itemCriterion(ItemRegistry.SMALL_LOTUS_LEAF.get())).save(recipeConsumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ItemRegistry.TILTED_LOTUS_LEAF.get(), 1).requires(ItemRegistry.LARGE_LOTUS_LEAF.get())
                .unlockedBy(itemUnlockName(ItemRegistry.LARGE_LOTUS_LEAF.get()), itemCriterion(ItemRegistry.LARGE_LOTUS_LEAF.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.SMALL_LOTUS_LEAF_CLUSTER.get(), 2)
                .define('L', ItemRegistry.SMALL_LOTUS_LEAF.get()).pattern("L ").pattern(" L")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_LOTUS_LEAF.get()), itemCriterion(ItemRegistry.SMALL_LOTUS_LEAF.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.MEDIUM_LOTUS_LEAF_CLUSTER.get(), 2)
                .define('L', ItemRegistry.MEDIUM_LOTUS_LEAF.get()).pattern("L ").pattern(" L")
                .unlockedBy(itemUnlockName(ItemRegistry.MEDIUM_LOTUS_LEAF.get()), itemCriterion(ItemRegistry.MEDIUM_LOTUS_LEAF.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.LOTUS_BUD.get(), 1)
                .define('L', Items.BIG_DRIPLEAF)
                .define('F', Items.SPORE_BLOSSOM)
                .pattern("F").pattern("L")
                .unlockedBy(itemUnlockName(Items.SPORE_BLOSSOM), itemCriterion(Items.SPORE_BLOSSOM)).save(recipeConsumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ItemRegistry.MEDIUM_LOTUS.get(), 1).requires(ItemRegistry.LOTUS_BUD.get()).requires(Items.BONE_MEAL)
                .unlockedBy(itemUnlockName(ItemRegistry.LOTUS_BUD.get()), itemCriterion(ItemRegistry.LOTUS_BUD.get())).save(recipeConsumer);

        // IVY

        blockTransform(Items.VINE, ModItemTags.COMMON_RED_DYE, ItemRegistry.SMALL_RED_IVY.get(), RecipeCategory.DECORATIONS, recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.MEDIUM_RED_IVY.get(), 1)
                .define('I', ItemRegistry.SMALL_RED_IVY.get())
                .pattern("I").pattern("I")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_RED_IVY.get()), itemCriterion(ItemRegistry.SMALL_RED_IVY.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.LARGE_RED_IVY.get(), 1)
                .define('I', ItemRegistry.SMALL_RED_IVY.get())
                .pattern("I").pattern("I").pattern("I")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_RED_IVY.get()), itemCriterion(ItemRegistry.SMALL_RED_IVY.get())).save(recipeConsumer);
        blockTransform(Items.VINE, ModItemTags.COMMON_YELLOW_DYE, ItemRegistry.SMALL_YELLOW_IVY.get(), RecipeCategory.DECORATIONS, recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.MEDIUM_YELLOW_IVY.get(), 1)
                .define('I', ItemRegistry.SMALL_YELLOW_IVY.get())
                .pattern("I").pattern("I")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_YELLOW_IVY.get()), itemCriterion(ItemRegistry.SMALL_YELLOW_IVY.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.LARGE_YELLOW_IVY.get(), 1)
                .define('I', ItemRegistry.SMALL_YELLOW_IVY.get())
                .pattern("I").pattern("I").pattern("I")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_YELLOW_IVY.get()), itemCriterion(ItemRegistry.SMALL_YELLOW_IVY.get())).save(recipeConsumer);
        blockTransform(Items.VINE, ModItemTags.COMMON_GREEN_DYE, ItemRegistry.SMALL_GREEN_IVY.get(), RecipeCategory.DECORATIONS, recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.MEDIUM_GREEN_IVY.get(), 1)
                .define('I', ItemRegistry.SMALL_GREEN_IVY.get())
                .pattern("I").pattern("I")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_GREEN_IVY.get()), itemCriterion(ItemRegistry.SMALL_GREEN_IVY.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.LARGE_GREEN_IVY.get(), 1)
                .define('I', ItemRegistry.SMALL_RED_IVY.get())
                .pattern("I").pattern("I").pattern("I")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_GREEN_IVY.get()), itemCriterion(ItemRegistry.SMALL_GREEN_IVY.get())).save(recipeConsumer);

        // LEAVES

        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemTags.LEAVES), ItemRegistry.SMALL_LEAF_PILE.get(), 8)
                .unlockedBy("has_leaves", tagUnlock(ItemTags.LEAVES)).save(recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemTags.LEAVES), ItemRegistry.MEDIUM_LEAF_PILE.get(), 5)
                .unlockedBy("has_leaves", tagUnlock(ItemTags.LEAVES)).save(recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemTags.LEAVES), ItemRegistry.LARGE_LEAF_PILE.get(), 3)
                .unlockedBy("has_leaves", tagUnlock(ItemTags.LEAVES)).save(recipeConsumer);

        // BONSAI

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.SMALL_GREETING_PINE_BONSAI.get(), 1)
                .define('P', Items.FLOWER_POT)
                .define('S', Items.SPRUCE_SAPLING)
                .define('D', Items.BROWN_DYE)
                .pattern("S ")
                .pattern("PD")
                .unlockedBy(itemUnlockName(Items.FLOWER_POT), itemCriterion(Items.FLOWER_POT)).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.MEDIUM_GREETING_PINE_BONSAI.get(), 1)
                .define('P', Items.FLOWER_POT)
                .define('S', Items.SPRUCE_SAPLING)
                .define('D', Items.BLACK_DYE)
                .pattern("SS")
                .pattern("PD")
                .unlockedBy(itemUnlockName(Items.FLOWER_POT), itemCriterion(Items.FLOWER_POT)).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.LARGE_GREETING_PINE_BONSAI.get(), 1)
                .define('P', Items.FLOWER_POT)
                .define('S', Items.SPRUCE_SAPLING)
                .define('D', Items.CYAN_DYE)
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('W', ModItemTags.POLISHED_PLANKS)
                .pattern("SS")
                .pattern("PD")
                .pattern("FW")
                .unlockedBy(itemUnlockName(Items.FLOWER_POT), itemCriterion(Items.FLOWER_POT)).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.SMALL_WHITE_PORCELAIN_VASE_BONSAI.get(), 1)
                .define('V', ItemRegistry.SMALL_WHITE_PORCELAIN_VASE.get())
                .define('S', ItemTags.SAPLINGS)
                .pattern("S").pattern("V")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_WHITE_PORCELAIN_VASE.get()), itemCriterion(ItemRegistry.SMALL_WHITE_PORCELAIN_VASE.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.MEDIUM_WHITE_PORCELAIN_VASE_BONSAI.get(), 1)
                .define('V', ItemRegistry.MEDIUM_WHITE_PORCELAIN_VASE.get())
                .define('S', ItemTags.SAPLINGS)
                .pattern("S").pattern("V")
                .unlockedBy(itemUnlockName(ItemRegistry.MEDIUM_WHITE_PORCELAIN_VASE.get()), itemCriterion(ItemRegistry.MEDIUM_WHITE_PORCELAIN_VASE.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.LARGE_WHITE_PORCELAIN_VASE_BONSAI.get(), 1)
                .define('V', ItemRegistry.LARGE_WHITE_PORCELAIN_VASE.get())
                .define('S', ItemTags.SAPLINGS)
                .pattern("S").pattern("V")
                .unlockedBy(itemUnlockName(ItemRegistry.LARGE_WHITE_PORCELAIN_VASE.get()), itemCriterion(ItemRegistry.LARGE_WHITE_PORCELAIN_VASE.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.SMALL_GREEN_PORCELAIN_VASE_BONSAI.get(), 1)
                .define('V', ItemRegistry.SMALL_GREEN_PORCELAIN_VASE.get())
                .define('S', ItemTags.SAPLINGS)
                .pattern("S").pattern("V")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_GREEN_PORCELAIN_VASE.get()), itemCriterion(ItemRegistry.SMALL_GREEN_PORCELAIN_VASE.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.GREEN_PORCELAIN_VASE_BONSAI.get(), 1)
                .define('V', ItemRegistry.MEDIUM_GREEN_PORCELAIN_VASE.get())
                .define('S', ItemTags.SAPLINGS)
                .pattern("S").pattern("V")
                .unlockedBy(itemUnlockName(ItemRegistry.MEDIUM_GREEN_PORCELAIN_VASE.get()), itemCriterion(ItemRegistry.MEDIUM_GREEN_PORCELAIN_VASE.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.RED_CORAL_BONSAI.get(), 1)
                .define('P', Items.FLOWER_POT)
                .define('C', Items.FIRE_CORAL)
                .define('D', Items.BLACK_DYE)
                .pattern("C ")
                .pattern("PD")
                .unlockedBy(itemUnlockName(Items.FLOWER_POT), itemCriterion(Items.FLOWER_POT)).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.RED_PLUM_BONSAI.get(), 1)
                .define('P', Items.FLOWER_POT)
                .define('C', ItemTags.SAPLINGS)
                .define('D', Items.CYAN_DYE)
                .pattern("C ")
                .pattern("PD")
                .unlockedBy(itemUnlockName(Items.FLOWER_POT), itemCriterion(Items.FLOWER_POT)).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.BAMBOO_BONSAI.get(), 1)
                .define('P', Items.FLOWER_POT)
                .define('C', Items.BAMBOO)
                .define('D', Items.CYAN_DYE)
                .pattern("C ")
                .pattern("PD")
                .unlockedBy(itemUnlockName(Items.FLOWER_POT), itemCriterion(Items.FLOWER_POT)).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.TALL_BLUE_VASE_BONSAI.get(), 1)
                .define('V', ItemRegistry.TALL_BLUE_PORCELAIN_VASE.get())
                .define('S', ItemTags.SAPLINGS)
                .pattern("S").pattern("V")
                .unlockedBy(itemUnlockName(ItemRegistry.TALL_BLUE_PORCELAIN_VASE.get()), itemCriterion(ItemRegistry.TALL_BLUE_PORCELAIN_VASE.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.TALL_BLUE_AND_WHITE_PORCELAIN_BONSAI.get(), 1)
                .define('V', ItemRegistry.TALL_BLUE_AND_WHITE_PORCELAIN_VASE.get())
                .define('S', ItemTags.SAPLINGS)
                .pattern("S").pattern("V")
                .unlockedBy(itemUnlockName(ItemRegistry.TALL_BLUE_AND_WHITE_PORCELAIN_VASE.get()), itemCriterion(ItemRegistry.TALL_BLUE_AND_WHITE_PORCELAIN_VASE.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.MEDIUM_BONSAI.get(), 1)
                .define('P', Items.FLOWER_POT)
                .define('B', Items.BRICK)
                .define('S', ItemTags.SAPLINGS)
                .define('D', Items.CYAN_DYE)
                .pattern(" S ")
                .pattern("DPD")
                .pattern(" B ")
                .unlockedBy(itemUnlockName(Items.FLOWER_POT), itemCriterion(Items.FLOWER_POT)).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.LARGE_BONSAI.get(), 1)
                .define('P', Items.FLOWER_POT)
                .define('B', Items.BRICK)
                .define('S', ItemTags.SAPLINGS)
                .pattern(" S ")
                .pattern("BPB")
                .pattern(" B ")
                .unlockedBy(itemUnlockName(Items.FLOWER_POT), itemCriterion(Items.FLOWER_POT)).save(recipeConsumer);

    }

    private static void categoryFurniture(@NotNull RecipeOutput recipeConsumer) {

        // CABINET

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.OAK_CABINET.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('W', ItemRegistry.POLISHED_OAK_PLANK.get())
                .define('C', Items.CHEST)
                .pattern("WWW")
                .pattern("WCW")
                .pattern("WFW")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_OAK_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_OAK_PLANK.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.WARPED_CABINET.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('W', ItemRegistry.POLISHED_WARPED_PLANK.get())
                .define('P', Items.WARPED_PLANKS)
                .define('C', Items.CHEST)
                .pattern("WWW")
                .pattern("WCW")
                .pattern("PFP")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_WARPED_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_WARPED_PLANK.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.EBONY_CABINET.get())
                .define('W', ItemRegistry.POLISHED_EBONY_PLANK.get())
                .define('G', ItemRegistry.GOLD_PARTS.get())
                .define('C', Items.CHEST)
                .pattern("GWG")
                .pattern("WCW")
                .pattern("WCW")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_WARPED_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_WARPED_PLANK.get()))
                .save(recipeConsumer);

        // TABLE

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.LARGE_TEA_TABLE.get())
                .define('P', Items.SPRUCE_PLANKS)
                .define('W', ItemRegistry.POLISHED_SPRUCE_PLANK.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('S', Items.STICK)
                .pattern("WWW")
                .pattern("PPP")
                .pattern("SFS")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_SPRUCE_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_SPRUCE_PLANK.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.CHESS_TABLE.get())
                .define('P', ItemTags.PLANKS)
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('S', Items.STICK)
                .define('B', ItemRegistry.CHESSBOARD.get())
                .pattern(" B ")
                .pattern("PPP")
                .pattern("SFS")
                .unlockedBy(itemUnlockName(ItemRegistry.CHESSBOARD.get()), itemCriterion(ItemRegistry.CHESSBOARD.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.HIGH_TABLE_WITH_WHITE_TOP.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('S', Items.STICK)
                .define('W', ItemRegistry.POLISHED_BIRCH_PLANK.get())
                .pattern(" W ")
                .pattern("SFS")
                .pattern("S S")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_BIRCH_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_BIRCH_PLANK.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.CENSER_TABLE.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('S', Items.STICK)
                .define('W', ItemRegistry.POLISHED_SPRUCE_PLANK.get())
                .define('G', ItemRegistry.GOLD_PARTS.get())
                .pattern("GWG")
                .pattern("SFS")
                .pattern("SWS")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_SPRUCE_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_SPRUCE_PLANK.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.PORCELAIN_INLAID_TABLE.get())
                .define('P', ItemRegistry.PORCELAIN_PARTS.get())
                .define('W', ItemRegistry.WOODEN_PARTS.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('S', ItemRegistry.POLISHED_ROSEWOOD_PLANK.get())
                .define('L', ItemRegistry.ROSEWOOD_PLANKS.get())
                .pattern(" P ")
                .pattern("WSW")
                .pattern("LFL")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_ROSEWOOD_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_ROSEWOOD_PLANK.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.SMALL_TABLE.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('S', Items.STICK)
                .define('W', ModItemTags.POLISHED_PLANKS)
                .pattern(" W ")
                .pattern("SFS")
                .unlockedBy("has_polished_plank", tagUnlock(ModItemTags.POLISHED_PLANKS))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.SMALL_EBONY_TABLE.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('S', Items.STICK)
                .define('W', ItemRegistry.POLISHED_EBONY_PLANK.get())
                .pattern(" W ")
                .pattern("SFS")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_EBONY_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_EBONY_PLANK.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.LARGE_TABLE.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('S', Items.STICK)
                .define('P', ItemTags.PLANKS)
                .pattern("PPP")
                .pattern("PPP")
                .pattern("SFS")
                .unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.LONG_TABLE.get())
                .define('P', ItemRegistry.ROSEWOOD_PLANKS.get())
                .define('W', ItemRegistry.POLISHED_ROSEWOOD_PLANK.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('S', Items.STICK)
                .pattern("WWW")
                .pattern("PPP")
                .pattern("SFS")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_ROSEWOOD_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_ROSEWOOD_PLANK.get()))
                .save(recipeConsumer);

        // CHAIR

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.EBONY_CHAIR.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('S', Items.STICK)
                .define('W', ItemRegistry.POLISHED_EBONY_PLANK.get())
                .pattern("FW ")
                .pattern("SFS")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_EBONY_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_EBONY_PLANK.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.CHAIR_WITH_YELLOW_CUSHION.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('S', Items.STICK)
                .define('C', ItemRegistry.YELLOW_CUSHION.get())
                .pattern("FC ")
                .pattern("SFS")
                .unlockedBy(itemUnlockName(ItemRegistry.YELLOW_CUSHION.get()), itemCriterion(ItemRegistry.YELLOW_CUSHION.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.PAINTED_CHAIR.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('W', ModItemTags.POLISHED_PLANKS)
                .define('A', ItemRegistry.WOODEN_PARTS.get())
                .define('P', ModItemTags.PAINTING_SCROLL_ITEMS)
                .pattern("P  ")
                .pattern("FWA")
                .pattern("WFW")
                .unlockedBy("has_painting", tagUnlock(ModItemTags.PAINTING_SCROLL_ITEMS))
                .save(recipeConsumer);

        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemTags.LOGS), ItemRegistry.WOODEN_STOOL.get(), 1).unlockedBy("has_log", tagUnlock(ItemTags.LOGS)).save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.PORCELAIN_INLAID_GRAND_CHAIR.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('W', ItemRegistry.POLISHED_ROSEWOOD_PLANK.get())
                .define('A', ItemRegistry.WOODEN_PARTS.get())
                .define('I', ItemRegistry.PORCELAIN_PARTS.get())
                .pattern("FIA")
                .pattern("WIA")
                .pattern("WFW")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_ROSEWOOD_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_ROSEWOOD_PLANK.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.YELLOW_CUSHION.get())
                .define('W', Items.YELLOW_WOOL)
                .define('S', ItemRegistry.SILK.get())
                .pattern("SS")
                .pattern("WW")
                .unlockedBy(itemUnlockName(ItemRegistry.SILK.get()), itemCriterion(ItemRegistry.SILK.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.OAK_BED.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('W', ItemRegistry.POLISHED_OAK_PLANK.get())
                .define('A', ItemRegistry.WOODEN_PARTS.get())
                .pattern("FAF")
                .pattern("WWW")
                .pattern("WFW")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_OAK_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_OAK_PLANK.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.EBONY_BED.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('W', ItemRegistry.POLISHED_OAK_PLANK.get())
                .define('G', ItemRegistry.GILDED_DARK_OAK.get())
                .define('S', ItemRegistry.SILK.get())
                .pattern("FSF")
                .pattern("GWG")
                .pattern("WFW")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_EBONY_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_EBONY_PLANK.get()))
                .save(recipeConsumer);

        // SCREEN

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.LARGE_LANDSCAPE_PAINTING_SCREEN.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('W', ModItemTags.POLISHED_PLANKS)
                .define('B', ItemTags.PLANKS)
                .define('A', ItemRegistry.WOODEN_PARTS.get())
                .define('P', ModItemTags.PAINTING_SCROLL_ITEMS)
                .pattern("AFA")
                .pattern("PPP")
                .pattern("WBW")
                .unlockedBy("has_painting", tagUnlock(ModItemTags.PAINTING_SCROLL_ITEMS))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.PAINTED_SCREEN.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('W', ItemRegistry.POLISHED_ROSEWOOD_PLANK.get())
                .define('B', ItemRegistry.ROSEWOOD_PLANKS.get())
                .define('A', ItemRegistry.WOODEN_PARTS.get())
                .define('P', ModItemTags.PAINTING_SCROLL_ITEMS)
                .pattern("AWA")
                .pattern("FPF")
                .pattern("WBW")
                .unlockedBy("has_painting", tagUnlock(ModItemTags.PAINTING_SCROLL_ITEMS))
                .save(recipeConsumer);


    }

    private static void categoryLamps(@NotNull RecipeOutput recipeConsumer) {

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Items.WHITE_CANDLE, 1)
                .define('S', Items.STRING)
                .define('G', ItemRegistry.GREASE.get())
                .pattern("S")
                .pattern("G")
                .unlockedBy(itemUnlockName(ItemRegistry.GREASE.get()), itemCriterion(ItemRegistry.GREASE.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.OCTAGONAL_PALACE_LANTERN.get(), 1)
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('P', ModItemTags.POLISHED_PLANKS)
                .define('C', ItemTags.CANDLES)
                .pattern("FPF")
                .pattern("PCP")
                .pattern("FPF")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.SQUARE_PALACE_LANTERN.get(), 1)
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('C', ItemTags.CANDLES)
                .pattern(" F ")
                .pattern("FCF")
                .pattern(" F ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.STANDING_LAMP.get(), 1)
                .define('X', ItemRegistry.XUAN_PAPER.get())
                .define('C', ItemTags.CANDLES)
                .define('W', ItemTags.PLANKS)
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('P', ItemRegistry.WOODEN_PARTS.get())
                .pattern("XCX")
                .pattern("PFP")
                .pattern(" W ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.SMALL_STANDING_LAMP.get(), 1)
                .define('X', ItemRegistry.XUAN_PAPER.get())
                .define('C', ItemTags.CANDLES)
                .define('W', Items.STICK)
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('P', ItemRegistry.WOODEN_PARTS.get())
                .pattern("XCX")
                .pattern("PFP")
                .pattern(" W ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.WHITE_SKY_LANTERN.get(), 1)
                .define('X', ItemRegistry.XUAN_PAPER.get())
                .define('C', ItemTags.CANDLES)
                .define('D', Items.WHITE_DYE)
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .pattern("XDX")
                .pattern("XCX")
                .pattern(" F ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.YELLOW_SKY_LANTERN.get(), 1)
                .define('X', ItemRegistry.XUAN_PAPER.get())
                .define('C', ItemTags.CANDLES)
                .define('D', Items.YELLOW_DYE)
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .pattern("XDX")
                .pattern("XCX")
                .pattern(" F ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.RED_SKY_LANTERN.get(), 1)
                .define('X', ItemRegistry.XUAN_PAPER.get())
                .define('C', ItemTags.CANDLES)
                .define('D', Items.RED_DYE)
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .pattern("XDX")
                .pattern("XCX")
                .pattern(" F ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.SMALL_RED_LANTERN.get(), 1)
                .define('S', Items.STICK)
                .define('C', ItemTags.CANDLES)
                .define('D', Items.RED_DYE)
                .define('P', Items.PAPER)
                .pattern(" S ")
                .pattern("PCP")
                .pattern("DPD")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.STONE_LAMP.get(), 1)
                .define('S', Items.STONE)
                .define('C', ItemTags.CANDLES)
                .define('W', Items.COBBLESTONE_WALL)
                .define('T', Items.STONE_SLAB)
                .pattern(" T ")
                .pattern("WCW")
                .pattern(" S ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.RED_CANDLE.get(), 1)
                .define('C', Items.RED_CANDLE)
                .define('P', ItemRegistry.WOODEN_PARTS.get())
                .pattern("C")
                .pattern("P")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.TRICOLOR_CANDLESTICK.get(), 1)
                .define('C', Items.WHITE_CANDLE)
                .define('P', ItemRegistry.PORCELAIN_PARTS.get())
                .pattern("C")
                .pattern("P")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.JADE_CANDLESTICK.get(), 1)
                .define('C', Items.WHITE_CANDLE)
                .define('P', ItemRegistry.JADE_PARTS.get())
                .pattern("C")
                .pattern("P")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.RED_LANTERN_STREETLIGHT.get())
                .define('L', ItemTags.LOGS)
                .define('P', ItemTags.PLANKS)
                .define('R', ItemRegistry.SMALL_RED_LANTERN.get())
                .pattern("PP")
                .pattern("LR")
                .pattern("L ")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_RED_LANTERN.get()), itemCriterion(ItemRegistry.SMALL_RED_LANTERN.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.HANGING_RED_LANTERN_STREETLIGHT.get())
                .define('P', ItemTags.PLANKS)
                .define('R', ItemRegistry.SMALL_RED_LANTERN.get())
                .pattern("PPP")
                .pattern(" R ")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_RED_LANTERN.get()), itemCriterion(ItemRegistry.SMALL_RED_LANTERN.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.STREETLIGHT_POLE.get())
                .define('L', ItemTags.LOGS)
                .define('P', ItemTags.PLANKS)
                .pattern("P")
                .pattern("L")
                .pattern("L")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_RED_LANTERN.get()), itemCriterion(ItemRegistry.SMALL_RED_LANTERN.get()))
                .save(recipeConsumer);

    }

    private static void categoryWindowsDoors(@NotNull RecipeOutput recipeConsumer) {

        // DOOR

        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemTags.LOGS), ItemRegistry.CARVED_WOODEN_DOOR.get(), 1).unlockedBy("has_log", tagUnlock(ItemTags.LOGS)).save(recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemTags.LOGS), ItemRegistry.SONG_WOODEN_DOOR.get(), 1).unlockedBy("has_log", tagUnlock(ItemTags.LOGS)).save(recipeConsumer);

        // WINDOW

        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemTags.PLANKS), ItemRegistry.SONG_WOODEN_WINDOW.get(), 1).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemRegistry.VARNISHED_ROSEWOOD.get()), ItemRegistry.ROYAL_ROSEWOOD_WINDOW.get(), 2)
                .unlockedBy(itemUnlockName(ItemRegistry.VARNISHED_ROSEWOOD.get()), itemCriterion(ItemRegistry.VARNISHED_ROSEWOOD.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.TALL_ROYAL_ROSEWOOD_WINDOW.get(), 1)
                .define('W', ItemRegistry.ROYAL_ROSEWOOD_WINDOW.get())
                .pattern("W").pattern("W")
                .unlockedBy(itemUnlockName(ItemRegistry.ROYAL_ROSEWOOD_WINDOW.get()), itemCriterion(ItemRegistry.ROYAL_ROSEWOOD_WINDOW.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.GLAZED_TILE_GRID_WINDOW.get())
                .define('G', ItemRegistry.GREEN_GLAZED_TILES.get())
                .define('I', Items.IRON_BARS)
                .pattern("GGG")
                .pattern("GIG")
                .pattern("GGG")
                .unlockedBy(itemUnlockName(ItemRegistry.GREEN_GLAZED_TILES.get()), itemCriterion(ItemRegistry.GREEN_GLAZED_TILES.get()))
                .save(recipeConsumer);
        simpleStonecutting(Items.CHISELED_STONE_BRICKS, ItemRegistry.STONE_FLOWER_WINDOW.get(), RecipeCategory.DECORATIONS, recipeConsumer);

        // DOOR DECO

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.KNOCKER.get())
                .define('I', ItemRegistry.BRONZE_INGOT.get())
                .define('P', ItemRegistry.BRONZE_PARTS.get())
                .pattern("IP")
                .unlockedBy(itemUnlockName(ItemRegistry.BRONZE_INGOT.get()), itemCriterion(ItemRegistry.BRONZE_INGOT.get()))
                .save(recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemRegistry.VARNISHED_ROSEWOOD.get()), ItemRegistry.ROSEWOOD_PANEL.get(), 2)
                .unlockedBy(itemUnlockName(ItemRegistry.VARNISHED_ROSEWOOD.get()), itemCriterion(ItemRegistry.VARNISHED_ROSEWOOD.get())).save(recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemRegistry.VARNISHED_ROSEWOOD.get()), ItemRegistry.ROSEWOOD_DOOR_PANEL.get(), 2)
                .unlockedBy(itemUnlockName(ItemRegistry.VARNISHED_ROSEWOOD.get()), itemCriterion(ItemRegistry.VARNISHED_ROSEWOOD.get())).save(recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemRegistry.VARNISHED_ROSEWOOD.get()), ItemRegistry.LARGE_ROSEWOOD_PANEL.get(), 2)
                .unlockedBy(itemUnlockName(ItemRegistry.VARNISHED_ROSEWOOD.get()), itemCriterion(ItemRegistry.VARNISHED_ROSEWOOD.get())).save(recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemRegistry.VARNISHED_ROSEWOOD.get()), ItemRegistry.LARGE_ROSEWOOD_PANEL_EDGE.get(), 2)
                .unlockedBy(itemUnlockName(ItemRegistry.VARNISHED_ROSEWOOD.get()), itemCriterion(ItemRegistry.VARNISHED_ROSEWOOD.get())).save(recipeConsumer);
        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(ItemTags.PLANKS), ItemRegistry.CARVED_WOODEN_DOOR_PANEL.get(), 1).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.PLAQUE.get())
                .define('P', ItemRegistry.XUAN_PAPER.get())
                .define('W', ItemRegistry.WOODEN_PARTS.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('S', ModItemTags.POLISHED_PLANKS)
                .define('I', Items.INK_SAC)
                .pattern("W W")
                .pattern("FSF")
                .pattern("PIP")
                .unlockedBy(itemUnlockName(ItemRegistry.XUAN_PAPER.get()), itemCriterion(ItemRegistry.XUAN_PAPER.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.PAPER_STRIP_SEAL.get(), 2)
                .define('P', ItemRegistry.XUAN_PAPER.get())
                .define('I', Items.INK_SAC)
                .pattern("P P")
                .pattern(" I ")
                .pattern("P P")
                .unlockedBy(itemUnlockName(ItemRegistry.XUAN_PAPER.get()), itemCriterion(ItemRegistry.XUAN_PAPER.get()))
                .save(recipeConsumer);

        // WINDOW DECO

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.SMALL_BLUE_CURTAIN.get(), 2)
                .define('S', ItemRegistry.SILK.get())
                .define('D', ItemRegistry.BLUE_DYE_POWDER.get())
                .pattern("SSS")
                .pattern("DDD")
                .unlockedBy(itemUnlockName(ItemRegistry.SILK.get()), itemCriterion(ItemRegistry.SILK.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.MEDIUM_BLUE_CURTAIN.get(), 1)
                .define('C', ItemRegistry.SMALL_BLUE_CURTAIN.get())
                .pattern("CC")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_BLUE_CURTAIN.get()), itemCriterion(ItemRegistry.SMALL_BLUE_CURTAIN.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.LARGE_BLUE_CURTAIN.get(), 1)
                .define('C', ItemRegistry.SMALL_BLUE_CURTAIN.get())
                .pattern("CCC")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_BLUE_CURTAIN.get()), itemCriterion(ItemRegistry.SMALL_BLUE_CURTAIN.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.RED_CURTAIN.get())
                .define('S', ItemRegistry.SILK.get())
                .define('D', ItemRegistry.RED_DYE_POWDER.get())
                .define('G', ItemRegistry.GOLD_PARTS.get())
                .pattern("SSS")
                .pattern("DDD")
                .pattern(" G ")
                .unlockedBy(itemUnlockName(ItemRegistry.SILK.get()), itemCriterion(ItemRegistry.SILK.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.RED_CURTAIN_CORNER.get())
                .define('C', ItemRegistry.RED_CURTAIN.get())
                .pattern("C ")
                .pattern(" C")
                .unlockedBy(itemUnlockName(ItemRegistry.RED_CURTAIN.get()), itemCriterion(ItemRegistry.RED_CURTAIN.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ItemRegistry.BAMBOO_CURTAIN.get())
                .define('B', Items.BAMBOO)
                .define('S', Items.STRING)
                .pattern("BBB")
                .pattern("SSS")
                .pattern("BBB")
                .unlockedBy(itemUnlockName(Items.BAMBOO), itemCriterion(Items.BAMBOO))
                .save(recipeConsumer);

    }

    private static void categoryMaterials(@NotNull RecipeOutput recipeConsumer) {

        //BRICK

        smeltingAndBlasting(ItemRegistry.UNFIRED_RAW_CYAN_BRICK.get(), ItemRegistry.CYAN_BRICK.get(), recipeConsumer);
        smeltingAndBlasting(ItemRegistry.UNFIRED_BLACK_BRICK.get(), ItemRegistry.BLACK_BRICK.get(), recipeConsumer);
        smeltingAndBlasting(ItemRegistry.UNFIRED_RAW_BROWNISH_RED_STONE_BRICK.get(), ItemRegistry.BROWNISH_RED_STONE_BRICK.get(), recipeConsumer);

        //BRICK MATERIAL

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.UNFIRED_CLAY_BRICK.get(), 3)
                .define('C', Items.CLAY_BALL).pattern("CCC")
                .unlockedBy(itemUnlockName(Items.CLAY_BALL), itemCriterion(Items.CLAY_BALL))
                .save(recipeConsumer);
        brickMixture(ItemRegistry.UNFIRED_CLAY_BRICK.get(), 6, ItemRegistry.PRISMARINE_DUST.get(), ItemRegistry.UNFIRED_RAW_CYAN_BRICK.get(), recipeConsumer);
        brickMixture(ItemRegistry.UNFIRED_CLAY_BRICK.get(), 6, ItemRegistry.HEMATITE_DUST.get(), ItemRegistry.UNFIRED_BLACK_BRICK.get(), recipeConsumer);
        brickMixture(ItemRegistry.UNFIRED_CLAY_BRICK.get(), 6, ItemRegistry.MAGNESITE_DUST.get(), ItemRegistry.UNFIRED_RAW_BROWNISH_RED_STONE_BRICK.get(), recipeConsumer);
        smeltingAndBlasting(ItemRegistry.UNFIRED_CLAY_BRICK.get(), ItemRegistry.FIRED_BRICK.get(), recipeConsumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BRICK, 1).requires(ItemRegistry.FIRED_BRICK.get())
                .unlockedBy("has_" + ItemRegistry.FIRED_BRICK.get(), InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.FIRED_BRICK.get())).save(recipeConsumer);
        dust(Items.PRISMARINE_SHARD, ItemRegistry.PRISMARINE_DUST.get(), recipeConsumer);

        //ORE PRODUCT

        dust(ItemRegistry.RAW_HEMATITE.get(), ItemRegistry.HEMATITE_DUST.get(), recipeConsumer);
        dust(ItemRegistry.MAGNESITE.get(), ItemRegistry.MAGNESITE_DUST.get(), recipeConsumer);
        dust(ItemRegistry.RAW_COBALT.get(), ItemRegistry.COBALT_DUST.get(), recipeConsumer);

        //ORE BLOCKS

        nineBlockStorageRecipes(recipeConsumer, RecipeCategory.MISC, ItemRegistry.JADE.get(), RecipeCategory.MISC, ItemRegistry.JADE_BLOCK.get());
        nineBlockStorageRecipes(recipeConsumer, RecipeCategory.MISC, ItemRegistry.BRONZE_INGOT.get(), RecipeCategory.MISC, ItemRegistry.BRONZE_BLOCK.get());

        //ROOF TILE

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.UNFIRED_ROOF_TILE.get(), 2)
                .define('C', Items.CLAY_BALL).pattern("C ").pattern(" C")
                .unlockedBy(itemUnlockName(Items.CLAY_BALL), itemCriterion(Items.CLAY_BALL))
                .save(recipeConsumer);
        compositeSmelting(ItemRegistry.GRAY_ROOF_TILE.get(), ItemRegistry.UNFIRED_ROOF_TILE.get(), ItemRegistry.GRAY_DYE_POWDER.get(), 0.05f, 20, recipeConsumer);
        compositeSmelting(ItemRegistry.YELLOW_ROOF_TILE.get(), ItemRegistry.UNFIRED_ROOF_TILE.get(), ItemRegistry.YELLOW_DYE_POWDER.get(), 0.05f, 20, recipeConsumer);
        compositeSmelting(ItemRegistry.GREEN_ROOF_TILE.get(), ItemRegistry.UNFIRED_ROOF_TILE.get(), ItemRegistry.GREEN_DYE_POWDER.get(), 0.05f, 20, recipeConsumer);
        compositeSmelting(ItemRegistry.BLUE_ROOF_TILE.get(), ItemRegistry.UNFIRED_ROOF_TILE.get(), ItemRegistry.BLUE_DYE_POWDER.get(), 0.05f, 20, recipeConsumer);
        compositeSmelting(ItemRegistry.CYAN_ROOF_TILE.get(), ItemRegistry.UNFIRED_ROOF_TILE.get(), ItemRegistry.CYAN_DYE_POWDER.get(), 0.05f, 20, recipeConsumer);
        compositeSmelting(ItemRegistry.BLACK_ROOF_TILE.get(), ItemRegistry.UNFIRED_ROOF_TILE.get(), ItemRegistry.BLACK_DYE_POWDER.get(), 0.05f, 20, recipeConsumer);

        // POLISHED PLANK

        polishedPlankRecipe(Items.OAK_PLANKS, ItemRegistry.POLISHED_OAK_PLANK.get(), recipeConsumer);
        polishedPlankRecipe(Items.BIRCH_PLANKS, ItemRegistry.POLISHED_BIRCH_PLANK.get(), recipeConsumer);
        polishedPlankRecipe(Items.SPRUCE_PLANKS, ItemRegistry.POLISHED_SPRUCE_PLANK.get(), recipeConsumer);
        polishedPlankRecipe(Items.JUNGLE_PLANKS, ItemRegistry.POLISHED_JUNGLE_PLANK.get(), recipeConsumer);
        polishedPlankRecipe(Items.ACACIA_PLANKS, ItemRegistry.POLISHED_ACACIA_PLANK.get(), recipeConsumer);
        polishedPlankRecipe(Items.DARK_OAK_PLANKS, ItemRegistry.POLISHED_DARK_OAK_PLANK.get(), recipeConsumer);
        polishedPlankRecipe(Items.CRIMSON_PLANKS, ItemRegistry.POLISHED_CRIMSON_PLANK.get(), recipeConsumer);
        polishedPlankRecipe(Items.WARPED_PLANKS, ItemRegistry.POLISHED_WARPED_PLANK.get(), recipeConsumer);
        polishedPlankRecipe(Items.MANGROVE_PLANKS, ItemRegistry.POLISHED_MANGROVE_PLANK.get(), recipeConsumer);
        polishedPlankRecipe(Items.CHERRY_PLANKS, ItemRegistry.POLISHED_CHERRY_PLANK.get(), recipeConsumer);
        polishedPlankRecipe(ItemRegistry.ROSEWOOD_PLANKS.get(), ItemRegistry.POLISHED_ROSEWOOD_PLANK.get(), recipeConsumer);
        //polishedPlankRecipe(ItemRegistry.EBONY_PLANKS.get(), ItemRegistry.POLISHED_EBONY_PLANK.get(), recipeConsumer);
        woodworking(RecipeCategory.MISC, Ingredient.of(ItemTags.PLANKS), ItemRegistry.WOODEN_FRAME.get(), 2, Items.OAK_PLANKS, recipeConsumer);

        // PORCELAIN MATERIAL

        dust(Items.CALCITE, ItemRegistry.CALCITE_DUST.get(), recipeConsumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistry.BLUE_AND_WHITE_GLAZE_POWDER.get(), 3)
                .requires(ItemRegistry.CALCITE_DUST.get(), 2)
                .requires(ItemRegistry.COBALT_DUST.get())
                .unlockedBy(itemUnlockName(ItemRegistry.COBALT_DUST.get()), itemCriterion(ItemRegistry.COBALT_DUST.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.SMALL_CLAY_VASE.get(), 1)
                .define('o', Items.CLAY_BALL)
                .pattern("o")
                .pattern("o")
                .unlockedBy(itemUnlockName(Items.CLAY), itemCriterion(Items.CLAY))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.MEDIUM_CLAY_VASE.get(), 1)
                .define('O', Items.CLAY)
                .define('o', Items.CLAY_BALL)
                .pattern("o")
                .pattern("O")
                .unlockedBy(itemUnlockName(Items.CLAY), itemCriterion(Items.CLAY))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.LARGE_CLAY_VASE.get(), 1)
                .define('O', Items.CLAY)
                .pattern("O")
                .pattern("O")
                .unlockedBy(itemUnlockName(Items.CLAY), itemCriterion(Items.CLAY))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.TALL_CLAY_VASE.get(), 1)
                .define('O', Items.CLAY)
                .define('o', Items.CLAY_BALL)
                .pattern("o")
                .pattern("o")
                .pattern("O")
                .unlockedBy(itemUnlockName(Items.CLAY), itemCriterion(Items.CLAY))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.CLAY_POT.get(), 1)
                .define('O', Items.CLAY)
                .define('o', Items.CLAY_BALL)
                .pattern("o o")
                .pattern(" O ")
                .unlockedBy(itemUnlockName(Items.CLAY), itemCriterion(Items.CLAY))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.TALL_CLAY_POT.get(), 1)
                .define('O', Items.CLAY)
                .define('o', Items.CLAY_BALL)
                .pattern("o o")
                .pattern("o o")
                .pattern(" O ")
                .unlockedBy(itemUnlockName(Items.CLAY), itemCriterion(Items.CLAY))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.CLAY_PLATE.get(), 1)
                .define('O', Items.CLAY)
                .define('o', Items.CLAY_BALL)
                .pattern("oOo")
                .unlockedBy(itemUnlockName(Items.CLAY), itemCriterion(Items.CLAY))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.CLAY_BOWL.get(), 1)
                .define('o', Items.CLAY_BALL)
                .pattern("o o")
                .pattern(" o ")
                .unlockedBy(itemUnlockName(Items.CLAY), itemCriterion(Items.CLAY))
                .save(recipeConsumer);
        compositeSmelting(ItemRegistry.SMALL_WHITE_PORCELAIN_VASE.get(), ItemRegistry.SMALL_CLAY_VASE.get(), Items.WHITE_DYE, 0.1f, 200, recipeConsumer);
        compositeSmelting(ItemRegistry.MEDIUM_WHITE_PORCELAIN_VASE.get(), ItemRegistry.MEDIUM_CLAY_VASE.get(), Items.WHITE_DYE, 0.1f, 200, recipeConsumer);
        compositeSmelting(ItemRegistry.LARGE_WHITE_PORCELAIN_VASE.get(), ItemRegistry.LARGE_CLAY_VASE.get(), Items.WHITE_DYE, 0.1f, 200, recipeConsumer);
        compositeSmelting(ItemRegistry.SMALL_GREEN_PORCELAIN_VASE.get(), ItemRegistry.SMALL_CLAY_VASE.get(), Items.GREEN_DYE, 0.1f, 200, recipeConsumer);
        compositeSmelting(ItemRegistry.MEDIUM_GREEN_PORCELAIN_VASE.get(), ItemRegistry.MEDIUM_CLAY_VASE.get(), Items.GREEN_DYE, 0.1f, 200, recipeConsumer);
        compositeSmelting(ItemRegistry.TALL_BLUE_PORCELAIN_VASE.get(), ItemRegistry.TALL_CLAY_VASE.get(), Items.BLUE_DYE, 0.1f, 200, recipeConsumer);
        compositeSmelting(ItemRegistry.TALL_BLUE_AND_WHITE_PORCELAIN_VASE.get(), ItemRegistry.TALL_CLAY_VASE.get(), ItemRegistry.BLUE_AND_WHITE_GLAZE_POWDER.get(), 0.1f, 200, recipeConsumer);
        compositeSmelting(ItemRegistry.BLACK_PORCELAIN_PLATE.get(), ItemRegistry.CLAY_PLATE.get(), Items.BLACK_DYE, 0.1f, 200, recipeConsumer);
        compositeSmelting(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PLATE.get(), ItemRegistry.CLAY_PLATE.get(), ItemRegistry.BLUE_AND_WHITE_GLAZE_POWDER.get(), 0.1f, 200, recipeConsumer);

        // PORCELAIN

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.PORCELAIN_PIECE.get()), RecipeCategory.MISC, Items.CLAY_BALL)
                .unlockedBy(itemUnlockName(ItemRegistry.PORCELAIN_PIECE.get()), itemCriterion(ItemRegistry.PORCELAIN_PIECE.get()))
                .save(recipeConsumer, "porcelain_piece_grinding");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE.get()), RecipeCategory.MISC, Items.CLAY_BALL)
                .unlockedBy(itemUnlockName(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE.get()), itemCriterion(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE.get()))
                .save(recipeConsumer, "blue_and_white_porcelain_piece_grinding");

        // PARTS

        woodworking(RecipeCategory.MISC, Ingredient.of(ItemTags.PLANKS), ItemRegistry.WOODEN_PARTS.get(), 2, Items.OAK_PLANKS, recipeConsumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.GOLD_INGOT), RecipeCategory.MISC, ItemRegistry.GOLD_PARTS.get(), 2)
                .unlockedBy(itemUnlockName(Items.GOLD_INGOT), itemCriterion(Items.GOLD_INGOT))
                .save(recipeConsumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.JADE.get()), RecipeCategory.MISC, ItemRegistry.JADE_PARTS.get(), 2)
                .unlockedBy(itemUnlockName(ItemRegistry.JADE.get()), itemCriterion(ItemRegistry.JADE.get()))
                .save(recipeConsumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE.get()), RecipeCategory.MISC, ItemRegistry.PORCELAIN_PARTS.get())
                .unlockedBy(itemUnlockName(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE.get()), itemCriterion(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE.get()))
                .save(recipeConsumer, "porcelain_parts_from_blue_and_white_porcelain_piece");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.PORCELAIN_PIECE.get()), RecipeCategory.MISC, ItemRegistry.PORCELAIN_PARTS.get())
                .unlockedBy(itemUnlockName(ItemRegistry.PORCELAIN_PIECE.get()), itemCriterion(ItemRegistry.PORCELAIN_PIECE.get()))
                .save(recipeConsumer, "porcelain_parts_from_porcelain_piece");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.BRONZE_INGOT.get()), RecipeCategory.MISC, ItemRegistry.BRONZE_PARTS.get(), 2)
                .unlockedBy(itemUnlockName(ItemRegistry.BRONZE_INGOT.get()), itemCriterion(ItemRegistry.BRONZE_INGOT.get()))
                .save(recipeConsumer);

        // DYE POWDERS

        dyePowder(ModItemTags.COMMON_WHITE_DYE, ItemRegistry.WHITE_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.COMMON_ORANGE_DYE, ItemRegistry.ORANGE_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.COMMON_MAGENTA_DYE, ItemRegistry.MAGENTA_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.COMMON_LIGHT_BLUE_DYE, ItemRegistry.LIGHT_BLUE_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.COMMON_YELLOW_DYE, ItemRegistry.YELLOW_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.COMMON_LIME_DYE, ItemRegistry.LIME_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.COMMON_PINK_DYE, ItemRegistry.PINK_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.COMMON_GRAY_DYE, ItemRegistry.GRAY_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.COMMON_LIGHT_GRAY_DYE, ItemRegistry.LIGHT_GRAY_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.COMMON_CYAN_DYE, ItemRegistry.CYAN_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.COMMON_PURPLE_DYE, ItemRegistry.PURPLE_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.COMMON_BLUE_DYE, ItemRegistry.BLUE_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.COMMON_BROWN_DYE, ItemRegistry.BROWN_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.COMMON_GREEN_DYE, ItemRegistry.GREEN_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.COMMON_RED_DYE, ItemRegistry.RED_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.COMMON_BLACK_DYE, ItemRegistry.BLACK_DYE_POWDER.get(), recipeConsumer);
        simpleStonecutting(Items.GOLD_NUGGET, ItemRegistry.GOLD_DYE_POWDER.get(), RecipeCategory.MISC, recipeConsumer);

        // TEMPLATES

        simpleStonecutting(Items.POLISHED_BLACKSTONE, ItemRegistry.CARVED_WOOD_TEMPLATE.get(), RecipeCategory.MISC, recipeConsumer);
        simpleStonecutting(Items.POLISHED_BLACKSTONE, ItemRegistry.FANGXIN_TEMPLATE.get(), RecipeCategory.MISC, recipeConsumer);
        simpleStonecutting(Items.POLISHED_BLACKSTONE, ItemRegistry.FANGXIN_EDGE_TEMPLATE.get(), RecipeCategory.MISC, recipeConsumer);
        simpleStonecutting(Items.POLISHED_BLACKSTONE, ItemRegistry.ZHAOTOU_TEMPLATE.get(), RecipeCategory.MISC, recipeConsumer);
        simpleStonecutting(Items.POLISHED_BLACKSTONE, ItemRegistry.GUTOU_TEMPLATE.get(), RecipeCategory.MISC, recipeConsumer);
        simpleStonecutting(Items.POLISHED_BLACKSTONE, ItemRegistry.RAFTER_TEMPLATE.get(), RecipeCategory.MISC, recipeConsumer);
        simpleStonecutting(Items.POLISHED_BLACKSTONE, ItemRegistry.RAFTER_END_TEMPLATE.get(), RecipeCategory.MISC, recipeConsumer);
        simpleStonecutting(Items.POLISHED_BLACKSTONE, ItemRegistry.ARCHITRAVE_TEMPLATE.get(), RecipeCategory.MISC, recipeConsumer);
        simpleStonecutting(Items.POLISHED_BLACKSTONE, ItemRegistry.CAIHUA_TEMPLATE.get(), RecipeCategory.MISC, recipeConsumer);

        // MATERIALS

        dust(ItemRegistry.BRONZE_INGOT.get(), ItemRegistry.BRONZE_DUST.get(), recipeConsumer);

    }

    private static void categoryTools(@NotNull RecipeOutput recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemRegistry.WOODEN_MALLET.get(), 1)
                .define('S', ItemTags.WOODEN_FENCES)
                .define('W', ItemTags.PLANKS)
                .pattern("WWW")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_fence", tagUnlock(ItemTags.FENCES))
                .save(recipeConsumer);
        blueAndWhitePorcelainUpgrade(Items.GOLDEN_SWORD, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SWORD.get(), RecipeCategory.COMBAT, recipeConsumer);
        blueAndWhitePorcelainUpgrade(Items.GOLDEN_SHOVEL, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHOVEL.get(), RecipeCategory.TOOLS, recipeConsumer);
        blueAndWhitePorcelainUpgrade(Items.GOLDEN_PICKAXE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PICKAXE.get(), RecipeCategory.TOOLS, recipeConsumer);
        blueAndWhitePorcelainUpgrade(Items.GOLDEN_AXE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_AXE.get(), RecipeCategory.TOOLS, recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_UPGRADE_SMITHING_TEMPLATE.get(), 1)
                .define('W', ItemRegistry.PORCELAIN_PIECE.get())
                .define('P', ItemRegistry.PORCELAIN_PARTS.get())
                .define('D', ItemRegistry.BLUE_AND_WHITE_GLAZE_POWDER.get())
                .define('S', ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS.get())
                .pattern("PSP")
                .pattern("PDP")
                .pattern("WWW")
                .unlockedBy("has_shards", itemCriterion(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemRegistry.WOODWORKING_WORKBENCH.get(), 1)
                .define('P', ItemTags.PLANKS)
                .define('C', Items.CRAFTING_TABLE)
                .pattern("P")
                .pattern("C")
                .unlockedBy(itemUnlockName(Items.CRAFTING_TABLE), itemCriterion(Items.CRAFTING_TABLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemRegistry.BRICK_KILN.get(), 1)
                .define('B', ItemRegistry.CYAN_BRICK.get())
                .define('F', Items.FURNACE)
                .pattern("BBB")
                .pattern("BFB")
                .pattern("BBB")
                .unlockedBy(itemUnlockName(ItemRegistry.CYAN_BRICK.get()), itemCriterion(ItemRegistry.CYAN_BRICK.get()))
                .save(recipeConsumer);
    }

    @NotNull
    private static String itemUnlockName(ItemLike item) {
        return "has_" + item;
    }

    @NotNull
    private static Criterion<InventoryChangeTrigger.TriggerInstance> itemCriterion(ItemLike... item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }

    @SuppressWarnings("null")
    private static void quadComposeRecipe(Item part, Item combined, RecipeCategory category, RecipeOutput pFinishedRecipeConsumer) {
        ShapedRecipeBuilder.shaped(category, combined, 1)
                .define('A', part)
                .pattern("AA")
                .pattern("AA")
                .unlockedBy("has_" + name(part), InventoryChangeTrigger.TriggerInstance.hasItems(part))
                .save(pFinishedRecipeConsumer);
    }

    private static void quadDecomposeRecipe(Item part, Item combined, RecipeCategory category, RecipeOutput pFinishedRecipeConsumer) {
        ShapelessRecipeBuilder.shapeless(category, part, 4).requires(combined)
                .unlockedBy("has_" + name(combined), InventoryChangeTrigger.TriggerInstance.hasItems(combined))
                .save(pFinishedRecipeConsumer);
    }

    private static void stonePolishing(Item raw, Item polished, RecipeOutput pFinishedRecipeConsumer) {
        String rawPath = name(raw);
        String polishedPath = name(polished);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, polished, 4)
                .define('A', raw)
                .pattern("AA")
                .pattern("AA")
                .unlockedBy("has_" + rawPath, InventoryChangeTrigger.TriggerInstance.hasItems(raw))
                .save(pFinishedRecipeConsumer, ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, polishedPath + "_from_crafting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(raw), RecipeCategory.BUILDING_BLOCKS, polished)
                .unlockedBy("has_" + rawPath, InventoryChangeTrigger.TriggerInstance.hasItems(raw))
                .save(pFinishedRecipeConsumer,
                        ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, polishedPath + "_from_stonecutting"));
    }

    private static void blockTransform(Item block, TagKey<Item> dye, Item output, RecipeCategory category, RecipeOutput pFinishedRecipeConsumer) {
        String blockPath = name(block);
        String outputPath = name(output);
        ShapelessRecipeBuilder.shapeless(category, output).requires(block).requires(dye)
                .unlockedBy("has_" + blockPath, InventoryChangeTrigger.TriggerInstance.hasItems(block))
                .save(pFinishedRecipeConsumer, ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, outputPath));
        ShapedRecipeBuilder.shaped(category, output, 8)
                .define('B', block)
                .define('D', dye)
                .pattern("BBB")
                .pattern("BDB")
                .pattern("BBB")
                .unlockedBy("has_" + blockPath, InventoryChangeTrigger.TriggerInstance.hasItems(block))
                .save(pFinishedRecipeConsumer, ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, outputPath + "_batch"));
    }

    private static void blockTransform(Item block, ItemLike dye, Item output, RecipeCategory category, RecipeOutput pFinishedRecipeConsumer) {
        String blockPath = name(block);
        String outputPath = name(output);
        ShapelessRecipeBuilder.shapeless(category, output).requires(block).requires(dye)
                .unlockedBy("has_" + blockPath, InventoryChangeTrigger.TriggerInstance.hasItems(block))
                .save(pFinishedRecipeConsumer, ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, outputPath));
        ShapedRecipeBuilder.shaped(category, output, 8)
                .define('B', block)
                .define('D', dye)
                .pattern("BBB")
                .pattern("BDB")
                .pattern("BBB")
                .unlockedBy("has_" + blockPath, InventoryChangeTrigger.TriggerInstance.hasItems(block))
                .save(pFinishedRecipeConsumer, ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, outputPath + "_batch"));
    }

    private static void dust(Item input, Item output, RecipeOutput pFinishedRecipeConsumer) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), RecipeCategory.MISC, output)
                .unlockedBy("has_" + name(input), InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(pFinishedRecipeConsumer, ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, name(output)));
    }

    private static void brickMixture(Item brick, int brickAmount, Item additive, Item output, RecipeOutput pFinishedRecipeConsumer) {
        String brickPath = name(brick);
        String additivePath = name(additive);
        String outputPath = name(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, brickAmount).requires(brick, brickAmount).requires(additive)
                .unlockedBy("has_" + brickPath, InventoryChangeTrigger.TriggerInstance.hasItems(brick))
                .save(pFinishedRecipeConsumer, ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, outputPath));
    }

    private static void smeltingAndBlasting(Item input, Item output, RecipeOutput pFinishedRecipeConsumer) {
        smeltingAndBlasting(input, output, 0.1f, pFinishedRecipeConsumer);
    }

    private static void smeltingAndBlasting(Item input, Item output, float exp, RecipeOutput pFinishedRecipeConsumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.MISC, output, exp, 200)
                .unlockedBy(itemUnlockName(input), itemCriterion(input)).save(pFinishedRecipeConsumer, ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, name(output) + "_from_smelting"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(input), RecipeCategory.MISC, output, exp / 2, 100)
                .unlockedBy(itemUnlockName(input), itemCriterion(input)).save(pFinishedRecipeConsumer, ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, name(output) + "_from_blasting"));
    }

    private static void stoneSlabAndStairsRecipe(Item baseBlock, Item slabBlock, Item stairBlock, RecipeOutput pFinishedRecipeConsumer) {
        String baseBlockPath = name(baseBlock);
        String stairsBlockPath = name(stairBlock);
        String slabBlockPath = name(slabBlock);
        String baseBlockAdvancement = "has_" + baseBlockPath;
        Criterion<InventoryChangeTrigger.TriggerInstance> trigger = InventoryChangeTrigger.TriggerInstance.hasItems(baseBlock);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stairBlock, 4)
                .define('B', baseBlock)
                .pattern("B  ")
                .pattern("BB ")
                .pattern("BBB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, stairsBlockPath + "_from_crafting"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, slabBlock, 6)
                .define('B', baseBlock)
                .pattern("BBB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, slabBlockPath + "_from_crafting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(baseBlock), RecipeCategory.BUILDING_BLOCKS, stairBlock)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, stairsBlockPath + "_from_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(baseBlock), RecipeCategory.BUILDING_BLOCKS, slabBlock, 2)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, slabBlockPath + "_from_stonecutting"));
    }

    private static void simpleStonecutting(Item input, Item output, RecipeCategory category, RecipeOutput pFinishedRecipeConsumer) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), category, output)
                .unlockedBy(itemUnlockName(input), itemCriterion(input))
                .save(pFinishedRecipeConsumer);
    }

    private static void woodSlabAndStairsRecipe(Item baseBlock, Item slabBlock, Item stairBlock, RecipeOutput pFinishedRecipeConsumer) {
        String baseBlockPath = name(baseBlock);
        String stairsBlockPath = name(stairBlock);
        String slabBlockPath = name(slabBlock);
        String baseBlockAdvancement = "has_" + baseBlockPath;
        Criterion<InventoryChangeTrigger.TriggerInstance> trigger = InventoryChangeTrigger.TriggerInstance.hasItems(baseBlock);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stairBlock, 4)
                .define('B', baseBlock)
                .pattern("B  ")
                .pattern("BB ")
                .pattern("BBB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, stairsBlockPath + "_from_crafting"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, slabBlock, 6)
                .define('B', baseBlock)
                .pattern("BBB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, slabBlockPath + "_from_crafting"));
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(baseBlock), stairBlock)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, stairsBlockPath + "_from_woodworking"));
        woodworking(RecipeCategory.BUILDING_BLOCKS, Ingredient.of(baseBlock), slabBlock, 2)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, slabBlockPath + "_from_woodworking"));
    }


    private static void wallRecipe(Item baseBlock, Item wallBlock, RecipeOutput pFinishedRecipeConsumer) {
        String baseBlockPath = name(baseBlock);
        String wallBlockPath = name(wallBlock);
        String baseBlockAdvancement = "has_" + baseBlockPath;
        Criterion<InventoryChangeTrigger.TriggerInstance> trigger = InventoryChangeTrigger.TriggerInstance.hasItems(baseBlock);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, wallBlock, 6)
                .define('B', baseBlock)
                .pattern("BBB")
                .pattern("BBB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, wallBlockPath + "_from_crafting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(baseBlock), RecipeCategory.DECORATIONS, wallBlock)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, wallBlockPath + "_from_stonecutting"));
    }

    private static void fenceRecipe(Item baseBlock, Item fenceBlock, RecipeOutput pFinishedRecipeConsumer) {
        String baseBlockPath = name(baseBlock);
        String fenceBlockPath = name(fenceBlock);
        String baseBlockAdvancement = "has_" + baseBlockPath;
        Criterion<InventoryChangeTrigger.TriggerInstance> trigger = InventoryChangeTrigger.TriggerInstance.hasItems(baseBlock);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, fenceBlock, 3)
                .define('B', baseBlock)
                .define('S', Items.STICK)
                .pattern("BSB")
                .pattern("BSB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, fenceBlockPath + "_from_crafting"));
        woodworking(RecipeCategory.DECORATIONS, Ingredient.of(baseBlock), fenceBlock)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, fenceBlockPath + "_from_woodworking"));
    }

    private static void polishedPlankRecipe(Item planks, Item polishedPlank, RecipeOutput pFinishedRecipeConsumer) {
        woodworking(RecipeCategory.MISC, Ingredient.of(planks), polishedPlank, 2)
                .unlockedBy(itemUnlockName(planks), InventoryChangeTrigger.TriggerInstance.hasItems(planks))
                .save(pFinishedRecipeConsumer);
    }

    private static void roofTileBlocksRecipe(String color, RecipeOutput pFinishedRecipeConsumer) {
        Registry<Item> ITEMS = BuiltInRegistries.ITEM;
        Item tileBlock, tileItem;
        tileItem = ITEMS.get(ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, color + "_roof_tile"));

        tileBlock = ITEMS.get(ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, color + "_roof_tiles"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, tileBlock, 1)
                .define('T', tileItem)
                .pattern("TTT")
                .unlockedBy("has_" + color + "_roof_tile", InventoryChangeTrigger.TriggerInstance.hasItems(tileItem))
                .save(pFinishedRecipeConsumer);

        tileBlock = ITEMS.get(ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, color + "_roof_tile_stairs"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, tileBlock, 1)
                .define('T', tileItem)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .unlockedBy("has_" + color + "_roof_tile", InventoryChangeTrigger.TriggerInstance.hasItems(tileItem))
                .save(pFinishedRecipeConsumer);

        tileBlock = ITEMS.get(ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, color + "_roof_tile_edge"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, tileBlock, 1)
                .define('T', tileItem)
                .pattern("T  ")
                .pattern("TTT")
                .unlockedBy("has_" + color + "_roof_tile", InventoryChangeTrigger.TriggerInstance.hasItems(tileItem))
                .save(pFinishedRecipeConsumer);
    }

    private static void roofTileRidgesRecipe(String color, RecipeOutput pFinishedRecipeConsumer) {
        Registry<Item> ITEMS = BuiltInRegistries.ITEM;
        Item ridgeBlock, tileItem;
        tileItem = ITEMS.get(ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, color + "_roof_tile"));

        ridgeBlock = ITEMS.get(ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, color + "_roof_ridge_upper"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ridgeBlock, 1)
                .define('T', tileItem)
                .pattern("TTT")
                .pattern("T T")
                .unlockedBy("has_" + color + "_roof_tile", InventoryChangeTrigger.TriggerInstance.hasItems(tileItem))
                .save(pFinishedRecipeConsumer);

        Item ridgeSlabBlock = ITEMS.get(ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, color + "_roof_ridge_upper_slab"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ridgeBlock), RecipeCategory.BUILDING_BLOCKS, ridgeSlabBlock, 2)
                .unlockedBy(itemUnlockName(ridgeBlock), itemCriterion(ridgeBlock))
                .save(pFinishedRecipeConsumer);

        ridgeBlock = ITEMS.get(ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, color + "_roof_ridge_lower"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ridgeBlock, 1)
                .define('T', tileItem)
                .pattern("T T")
                .pattern("TTT")
                .unlockedBy("has_" + color + "_roof_tile", InventoryChangeTrigger.TriggerInstance.hasItems(tileItem))
                .save(pFinishedRecipeConsumer);

        ridgeBlock = ITEMS.get(ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, color + "_roof_ridge_connection"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ridgeBlock, 1)
                .define('T', tileItem)
                .pattern("TTT")
                .pattern("TTT")
                .unlockedBy("has_" + color + "_roof_tile", InventoryChangeTrigger.TriggerInstance.hasItems(tileItem))
                .save(pFinishedRecipeConsumer);

        Item ridgeMainBlock = ITEMS.get(ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, color + "_main_roof_ridge_connection"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ridgeMainBlock, 3)
                .define('R', ridgeBlock)
                .define('T', tileItem)
                .pattern("TTT")
                .pattern("RRR")
                .unlockedBy(itemUnlockName(ridgeBlock), InventoryChangeTrigger.TriggerInstance.hasItems(ridgeBlock))
                .save(pFinishedRecipeConsumer);

        Item ridgeMainSlabBlock = ITEMS.get(ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, color + "_main_roof_ridge_slab"));
        Item ridgeMainStairBlock = ITEMS.get(ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, color + "_main_roof_ridge_stairs"));
        stoneSlabAndStairsRecipe(ridgeMainBlock, ridgeMainSlabBlock, ridgeMainStairBlock, pFinishedRecipeConsumer);

        Item ridgeMainPanelBlock = ITEMS.get(ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, color + "_main_roof_ridge_panel"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ridgeMainSlabBlock), RecipeCategory.BUILDING_BLOCKS, ridgeMainPanelBlock, 2)
                .unlockedBy(itemUnlockName(ridgeMainSlabBlock), itemCriterion(ridgeMainSlabBlock))
                .save(pFinishedRecipeConsumer);

        Item ridgeMainPlateBlock = ITEMS.get(ResourceLocation.fromNamespaceAndPath(DataGenerators.MOD_ID, color + "_main_roof_ridge_plate"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ridgeMainPanelBlock), RecipeCategory.BUILDING_BLOCKS, ridgeMainPlateBlock, 2)
                .unlockedBy(itemUnlockName(ridgeMainPanelBlock), itemCriterion(ridgeMainPanelBlock))
                .save(pFinishedRecipeConsumer);

    }

    private static void dyePowder(TagKey<Item> dye, ItemLike powder, RecipeOutput pFinishedRecipeConsumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, powder, 4).requires(dye).unlockedBy("has_dye", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(dye)))
                .save(pFinishedRecipeConsumer);
    }

    private static SingleItemRecipeBuilder woodworking(RecipeCategory category, Ingredient pIngredient, ItemLike pResult) {
        return woodworking(category, pIngredient, pResult, 1);
    }

    private static SingleItemRecipeBuilder woodworking(RecipeCategory category, Ingredient pIngredient, ItemLike pResult, int pCount) {
        return new SingleItemRecipeBuilder(category, WoodworkingRecipe::new, pIngredient, pResult, pCount);
    }

    private static void woodworking(RecipeCategory category, Item input, ItemLike pResult, int pCount, RecipeOutput pFinishedRecipeConsumer) {
        var recipe = new SingleItemRecipeBuilder(category, WoodworkingRecipe::new, Ingredient.of(input), pResult, pCount);
        recipe.unlockedBy(itemUnlockName(input), itemCriterion(input))
                .save(pFinishedRecipeConsumer);
    }

    private static void woodworking(RecipeCategory category, Ingredient ingredient, ItemLike pResult, int pCount, Item unlockItem, RecipeOutput pFinishedRecipeConsumer) {
        var recipe = new SingleItemRecipeBuilder(category, WoodworkingRecipe::new, ingredient, pResult, pCount);
        recipe.unlockedBy(itemUnlockName(unlockItem), itemCriterion(unlockItem))
                .save(pFinishedRecipeConsumer);
    }

    private static void carvedWood(Item result, Ingredient[] dye, RecipeOutput pFinishedRecipeConsumer) {
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ItemTags.LOGS), Ingredient.of(ItemRegistry.CARVED_WOOD_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.CARVED_WOOD_TEMPLATE.get()), itemCriterion(ItemRegistry.CARVED_WOOD_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    private static void fangxinWood(Item result, Ingredient[] dye, RecipeOutput pFinishedRecipeConsumer) {
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ItemTags.LOGS), Ingredient.of(ItemRegistry.FANGXIN_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.FANGXIN_TEMPLATE.get()), itemCriterion(ItemRegistry.FANGXIN_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    private static void fangxinEdgeWood(Item result, Ingredient[] dye, RecipeOutput pFinishedRecipeConsumer) {
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ItemTags.LOGS), Ingredient.of(ItemRegistry.FANGXIN_EDGE_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.FANGXIN_EDGE_TEMPLATE.get()), itemCriterion(ItemRegistry.FANGXIN_EDGE_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    private static void zhaotouWood(Item result, Ingredient[] dye, RecipeOutput pFinishedRecipeConsumer) {
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ItemTags.LOGS), Ingredient.of(ItemRegistry.ZHAOTOU_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.ZHAOTOU_TEMPLATE.get()), itemCriterion(ItemRegistry.ZHAOTOU_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    private static void gutouWood(Item result, Ingredient[] dye, RecipeOutput pFinishedRecipeConsumer) {
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ItemTags.LOGS), Ingredient.of(ItemRegistry.GUTOU_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.GUTOU_TEMPLATE.get()), itemCriterion(ItemRegistry.GUTOU_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    private static void rafter(Item result, Ingredient[] dye, RecipeOutput pFinishedRecipeConsumer) {
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ItemTags.LOGS), Ingredient.of(ItemRegistry.RAFTER_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.RAFTER_TEMPLATE.get()), itemCriterion(ItemRegistry.RAFTER_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    private static void rafterEnd(Item result, Ingredient[] dye, RecipeOutput pFinishedRecipeConsumer) {
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ItemTags.LOGS), Ingredient.of(ItemRegistry.RAFTER_END_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.RAFTER_END_TEMPLATE.get()), itemCriterion(ItemRegistry.RAFTER_END_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    private static void architrave(Item result, Ingredient[] dye, RecipeOutput pFinishedRecipeConsumer) {
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ItemTags.LOGS), Ingredient.of(ItemRegistry.ARCHITRAVE_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.ARCHITRAVE_TEMPLATE.get()), itemCriterion(ItemRegistry.ARCHITRAVE_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    private static void caihua(Item result, Ingredient[] dye, RecipeOutput pFinishedRecipeConsumer) {
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ModItemTags.POLISHED_PLANKS), Ingredient.of(ItemRegistry.CAIHUA_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.CAIHUA_TEMPLATE.get()), itemCriterion(ItemRegistry.CAIHUA_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    private static void fangxinPattern(Item result, Ingredient[] dye, RecipeOutput pFinishedRecipeConsumer) {
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ModItemTags.POLISHED_PLANKS), Ingredient.of(ItemRegistry.FANGXIN_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.FANGXIN_TEMPLATE.get()), itemCriterion(ItemRegistry.FANGXIN_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    private static void fangxinEdgePattern(Item result, Ingredient[] dye, RecipeOutput pFinishedRecipeConsumer) {
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ModItemTags.POLISHED_PLANKS), Ingredient.of(ItemRegistry.FANGXIN_EDGE_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.FANGXIN_EDGE_TEMPLATE.get()), itemCriterion(ItemRegistry.FANGXIN_EDGE_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    private static void zhaotouPattern(Item result, Ingredient[] dye, RecipeOutput pFinishedRecipeConsumer) {
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ModItemTags.POLISHED_PLANKS), Ingredient.of(ItemRegistry.ZHAOTOU_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.ZHAOTOU_TEMPLATE.get()), itemCriterion(ItemRegistry.ZHAOTOU_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    private static void compositeSmelting(Item result, Item primary, Item secondary, float exp, int time, RecipeOutput pFinishedRecipeConsumer) {
        CompositeSmeltingRecipeBuilder.compositeSmelting(Ingredient.of(primary), Ingredient.of(secondary),
                        result, exp, time)
                .unlockedBy(itemUnlockName(primary), itemCriterion(primary)).save(pFinishedRecipeConsumer);
    }

    private static void blueAndWhitePorcelainUpgrade(Item from, Item to, RecipeCategory category, RecipeOutput pFinishedRecipeConsumer) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_UPGRADE_SMITHING_TEMPLATE.get()), Ingredient.of(from), Ingredient.of(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE.get()), category, to)
                .unlocks(itemUnlockName(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE.get()), itemCriterion(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE.get())).save(pFinishedRecipeConsumer, name(to));
    }

    private static Criterion<InventoryChangeTrigger.TriggerInstance> tagUnlock(TagKey<Item> tag) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(tag));
    }

    private static String name(Item item) {
        return Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)).getPath();
    }


}
