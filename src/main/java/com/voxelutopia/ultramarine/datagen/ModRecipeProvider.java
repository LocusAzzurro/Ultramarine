package com.voxelutopia.ultramarine.datagen;

import com.google.common.collect.ImmutableSet;
import com.voxelutopia.ultramarine.data.ModItemTags;
import com.voxelutopia.ultramarine.datagen.recipe.ChiselTableRecipeBuilder;
import com.voxelutopia.ultramarine.datagen.recipe.CompositeSmeltingRecipeBuilder;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeSerializerRegistry;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
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

    private static void categoryBuildingBlocks(@NotNull Consumer<FinishedRecipe> recipeConsumer) {

        //BRICKS
        quadComposeRecipe(ItemRegistry.CYAN_BRICK.get(), ItemRegistry.CYAN_BRICKS.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.CYAN_BRICKS.get(), ItemRegistry.CYAN_BRICK_SLAB.get(), ItemRegistry.CYAN_BRICK_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.CYAN_BRICKS.get(), ItemRegistry.CYAN_BRICK_WALL.get(), recipeConsumer);

        quadComposeRecipe(ItemRegistry.BLACK_BRICK.get(), ItemRegistry.BLACK_BRICKS.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.BLACK_BRICKS.get(), ItemRegistry.BLACK_BRICK_SLAB.get(), ItemRegistry.BLACK_BRICK_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.BLACK_BRICKS.get(), ItemRegistry.BLACK_BRICK_WALL.get(), recipeConsumer);

        quadComposeRecipe(ItemRegistry.BROWNISH_RED_STONE_BRICK.get(), ItemRegistry.BROWNISH_RED_STONE_BRICKS.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.BROWNISH_RED_STONE_BRICKS.get(), ItemRegistry.BROWNISH_RED_STONE_BRICK_SLAB.get(), ItemRegistry.BROWNISH_RED_STONE_BRICK_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.BROWNISH_RED_STONE_BRICKS.get(), ItemRegistry.BROWNISH_RED_STONE_BRICK_WALL.get(), recipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.WHITE_AND_PINK_MIXED_BRICKS.get(), 4)
                .define('V', ItemRegistry.VARIEGATED_ROCKS.get())
                .define('Y', ItemRegistry.PALE_YELLOW_STONE.get())
                .pattern("VY").pattern("YV")
                .unlockedBy("has_" + ItemRegistry.VARIEGATED_ROCKS.get(), InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.VARIEGATED_ROCKS.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.GREEN_WEATHERED_BRICKS.get(), 4)
                .define('S', ItemRegistry.GREEN_WEATHERED_STONE.get())
                .pattern("SS").pattern("SS")
                .unlockedBy("has_" + ItemRegistry.GREEN_WEATHERED_STONE.get(), InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.GREEN_WEATHERED_STONE.get()))
                .save(recipeConsumer);

        //STONES
        ShapelessRecipeBuilder.shapeless(ItemRegistry.PALE_YELLOW_STONE.get(), 2).requires(Items.STONE).requires(Items.SAND)
                .unlockedBy(itemUnlockName(Items.STONE), itemCriterion(Items.STONE)).save(recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.PALE_YELLOW_STONE.get(), ItemRegistry.PALE_YELLOW_STONE_SLAB.get(), ItemRegistry.PALE_YELLOW_STONE_STAIRS.get(), recipeConsumer);

        ShapelessRecipeBuilder.shapeless(ItemRegistry.VARIEGATED_ROCKS.get(), 4).requires(Items.COBBLESTONE).requires(Items.GRANITE).requires(Items.DIORITE).requires(Items.ANDESITE)
                .unlockedBy(itemUnlockName(Items.COBBLESTONE), itemCriterion(Items.COBBLESTONE)).save(recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.VARIEGATED_ROCKS.get(), ItemRegistry.VARIEGATED_ROCK_SLAB.get(), ItemRegistry.VARIEGATED_ROCK_STAIRS.get(), recipeConsumer);

        ShapelessRecipeBuilder.shapeless(ItemRegistry.WEATHERED_STONE.get(), 2).requires(Items.STONE).requires(Items.GRAVEL)
                .unlockedBy(itemUnlockName(Items.STONE), itemCriterion(Items.STONE)).save(recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.WEATHERED_STONE.get(), ItemRegistry.WEATHERED_STONE_SLAB.get(), ItemRegistry.WEATHERED_STONE_STAIRS.get(), recipeConsumer);

        stonePolishing(ItemRegistry.WEATHERED_STONE.get(), ItemRegistry.POLISHED_WEATHERED_STONE.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.POLISHED_WEATHERED_STONE.get(), ItemRegistry.POLISHED_WEATHERED_STONE_SLAB.get(), ItemRegistry.POLISHED_WEATHERED_STONE_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.POLISHED_WEATHERED_STONE.get(), ItemRegistry.POLISHED_WEATHERED_STONE_WALL.get(), recipeConsumer);

        blockTransform(ItemRegistry.WEATHERED_STONE.get(), ModItemTags.FORGE_GREEN_DYE, ItemRegistry.GREEN_WEATHERED_STONE.get(), recipeConsumer);

        // FLOOR TILES
        blockTransform(Items.SMOOTH_STONE, ModItemTags.FORGE_CYAN_DYE, ItemRegistry.CYAN_FLOOR_TILE.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.CYAN_FLOOR_TILE.get(), ItemRegistry.CYAN_FLOOR_TILE_SLAB.get(), ItemRegistry.CYAN_FLOOR_TILE_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.CYAN_FLOOR_TILE.get(), ItemRegistry.CYAN_FLOOR_TILE_WALL.get(), recipeConsumer);

        blockTransform(ItemRegistry.CYAN_FLOOR_TILE.get(), ModItemTags.FORGE_WHITE_DYE, ItemRegistry.LIGHT_CYAN_FLOOR_TILE.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.LIGHT_CYAN_FLOOR_TILE.get(), ItemRegistry.LIGHT_CYAN_FLOOR_TILE_SLAB.get(), ItemRegistry.LIGHT_CYAN_FLOOR_TILE_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.LIGHT_CYAN_FLOOR_TILE.get(), ItemRegistry.LIGHT_CYAN_FLOOR_TILE_WALL.get(), recipeConsumer);

        blockTransform(ItemRegistry.CYAN_FLOOR_TILE.get(), Items.BLACK_DYE, ItemRegistry.DARK_CYAN_FLOOR_TILE.get(), recipeConsumer);
        simpleStonecutting(ItemRegistry.CYAN_FLOOR_TILE.get(), ItemRegistry.LAYERED_CYAN_FLOOR_TILES.get(), recipeConsumer);
        simpleStonecutting(ItemRegistry.CYAN_FLOOR_TILE.get(), ItemRegistry.VERTICAL_CYAN_FLOOR_TILES.get(), recipeConsumer);
        simpleStonecutting(ItemRegistry.CYAN_FLOOR_TILE.get(), ItemRegistry.MIXED_CYAN_FLOOR_TILES.get(), recipeConsumer);
        simpleStonecutting(ItemRegistry.CYAN_FLOOR_TILE.get(), ItemRegistry.CHISELED_CYAN_FLOOR_TILE.get(), recipeConsumer);
        simpleStonecutting(ItemRegistry.CYAN_FLOOR_TILE.get(), ItemRegistry.CUT_CYAN_FLOOR_TILES.get(), recipeConsumer);

        blockTransform(ItemRegistry.POLISHED_WEATHERED_STONE.get(), ModItemTags.FORGE_RED_DYE, ItemRegistry.WEATHERED_RED_STONE_TILE.get(), recipeConsumer);
        blockTransform(ItemRegistry.DARK_CYAN_FLOOR_TILE.get(), ModItemTags.FORGE_BLUE_DYE, ItemRegistry.BLUE_AND_BLACK_TILE.get(), recipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.GREEN_GLAZED_TILES.get(), 2)
                .define('B', Items.GREEN_GLAZED_TERRACOTTA).define('T', ItemRegistry.GREEN_ROOF_TILE.get())
                .pattern(" T ").pattern("TBT").pattern(" T ")
                .unlockedBy(itemUnlockName(Items.GREEN_GLAZED_TERRACOTTA), itemCriterion(Items.GREEN_GLAZED_TERRACOTTA))
                .save(recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.GREEN_GLAZED_TILES.get(), ItemRegistry.GREEN_GLAZED_TILE_SLAB.get(), ItemRegistry.GREEN_GLAZED_TILE_STAIRS.get(), recipeConsumer);

        ShapelessRecipeBuilder.shapeless(ItemRegistry.BLACK_FLOOR_TILES.get(), 2).requires(Items.COBBLED_DEEPSLATE).requires(ItemRegistry.BLACK_BRICKS.get())
                .unlockedBy(itemUnlockName(ItemRegistry.BLACK_BRICKS.get()), itemCriterion(ItemRegistry.BLACK_BRICKS.get())).save(recipeConsumer);
        blockTransform(ItemRegistry.BLACK_FLOOR_TILES.get(), Items.MOSS_BLOCK, ItemRegistry.BLACK_FLOOR_TILES_LITTLE_MOSSY.get(), recipeConsumer);
        blockTransform(ItemRegistry.BLACK_FLOOR_TILES_LITTLE_MOSSY.get(), Items.MOSS_BLOCK, ItemRegistry.BLACK_FLOOR_TILES_MODERATE_MOSSY.get(), recipeConsumer);
        blockTransform(ItemRegistry.BLACK_FLOOR_TILES_MODERATE_MOSSY.get(), Items.MOSS_BLOCK, ItemRegistry.BLACK_FLOOR_TILES_VERY_MOSSY.get(), recipeConsumer);

        //WOODEN

        smeltingAndBlasting(Items.CRIMSON_PLANKS, ItemRegistry.ROSEWOOD_PLANKS.get(), recipeConsumer);
        woodSlabAndStairsRecipe(ItemRegistry.ROSEWOOD_PLANKS.get(), ItemRegistry.ROSEWOOD_SLAB.get(), ItemRegistry.ROSEWOOD_STAIRS.get(), recipeConsumer);
        fenceRecipe(ItemRegistry.ROSEWOOD_PLANKS.get(), ItemRegistry.ROSEWOOD_FENCE.get(), recipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.BAMBOO_MAT.get(), 4)
                .define('B', Items.BAMBOO).define('S', Items.STRING)
                .pattern("BSB").pattern("BSB").pattern("BSB")
                .unlockedBy("has_" + Items.BAMBOO, InventoryChangeTrigger.TriggerInstance.hasItems(Items.BAMBOO))
                .save(recipeConsumer);
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

    private static void categoryDecorativeBlocks(@NotNull Consumer<FinishedRecipe> recipeConsumer) {

        // SIMPLE CARVED WOOD

        carvedWood(ItemRegistry.RED_CARVED_WOOD.get(), new Ingredient[]{Ingredient.of(ModItemTags.FORGE_RED_DYE), Ingredient.of(ModItemTags.FORGE_RED_DYE)}, recipeConsumer);
        woodSlabAndStairsRecipe(ItemRegistry.RED_CARVED_WOOD.get(), ItemRegistry.RED_CARVED_WOODEN_SLAB.get(), ItemRegistry.RED_CARVED_WOODEN_STAIRS.get(), recipeConsumer);
        carvedWood(ItemRegistry.BLUE_CARVED_WOOD.get(), new Ingredient[]{Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE)}, recipeConsumer);
        woodSlabAndStairsRecipe(ItemRegistry.BLUE_CARVED_WOOD.get(), ItemRegistry.BLUE_CARVED_WOODEN_SLAB.get(), ItemRegistry.BLUE_CARVED_WOODEN_STAIRS.get(), recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.BLUE_CARVED_WOODEN_BRACKET.get(), 2)
                .define('T', ItemRegistry.GREEN_CARVED_WOODEN_SLAB.get())
                .define('B', ItemRegistry.BLUE_CARVED_WOODEN_STAIRS.get())
                .pattern("T").pattern("B")
                .unlockedBy(itemUnlockName(ItemRegistry.BLUE_CARVED_WOODEN_STAIRS.get()), itemCriterion(ItemRegistry.BLUE_CARVED_WOODEN_STAIRS.get()))
                .save(recipeConsumer);
        ShapelessRecipeBuilder.shapeless(ItemRegistry.BLUE_CARVED_WOODEN_BRACKET_STAIRS.get())
                .requires(ItemRegistry.BLUE_CARVED_WOODEN_STAIRS.get()).requires(ItemRegistry.YELLOW_DYE_POWDER.get())
                .unlockedBy(itemUnlockName(ItemRegistry.BLUE_CARVED_WOODEN_STAIRS.get()), itemCriterion(ItemRegistry.BLUE_CARVED_WOODEN_STAIRS.get()))
                .save(recipeConsumer);
        carvedWood(ItemRegistry.CYAN_CARVED_WOOD.get(), new Ingredient[]{Ingredient.of(ModItemTags.FORGE_CYAN_DYE), Ingredient.of(ModItemTags.FORGE_CYAN_DYE)}, recipeConsumer);
        woodSlabAndStairsRecipe(ItemRegistry.CYAN_CARVED_WOOD.get(), ItemRegistry.CYAN_CARVED_WOODEN_SLAB.get(), ItemRegistry.CYAN_CARVED_WOODEN_STAIRS.get(), recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.CYAN_CARVED_WOODEN_BRACKET.get(), 2)
                .define('T', ItemRegistry.CYAN_CARVED_WOODEN_SLAB.get())
                .define('B', ItemRegistry.RED_CARVED_WOODEN_STAIRS.get())
                .pattern("T").pattern("B")
                .unlockedBy(itemUnlockName(ItemRegistry.CYAN_CARVED_WOODEN_SLAB.get()), itemCriterion(ItemRegistry.CYAN_CARVED_WOODEN_SLAB.get()))
                .save(recipeConsumer);
        carvedWood(ItemRegistry.GREEN_CARVED_WOOD.get(), new Ingredient[]{Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE)}, recipeConsumer);
        woodSlabAndStairsRecipe(ItemRegistry.GREEN_CARVED_WOOD.get(), ItemRegistry.GREEN_CARVED_WOODEN_SLAB.get(), ItemRegistry.GREEN_CARVED_WOODEN_STAIRS.get(), recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.GREEN_CARVED_WOODEN_BRACKET.get(), 2)
                .define('T', ItemRegistry.BLUE_CARVED_WOODEN_SLAB.get())
                .define('B', ItemRegistry.GREEN_CARVED_WOODEN_STAIRS.get())
                .pattern("T").pattern("B")
                .unlockedBy(itemUnlockName(ItemRegistry.GREEN_CARVED_WOODEN_STAIRS.get()), itemCriterion(ItemRegistry.GREEN_CARVED_WOODEN_STAIRS.get()))
                .save(recipeConsumer);

        // MIXED CARVED WOOD

        carvedWood(ItemRegistry.ORANGE_AND_BLUE_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_ORANGE_DYE), Ingredient.of(ModItemTags.FORGE_LIGHT_BLUE_DYE)}, recipeConsumer);
        carvedWood(ItemRegistry.ORANGE_AND_GREEN_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_ORANGE_DYE), Ingredient.of(ModItemTags.FORGE_LIME_DYE)}, recipeConsumer);
        carvedWood(ItemRegistry.GREEN_AND_BLUE_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_LIME_DYE), Ingredient.of(ModItemTags.FORGE_LIGHT_BLUE_DYE)}, recipeConsumer);
        carvedWood(ItemRegistry.DARK_GREEN_AND_DARK_BLUE_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ItemRegistry.LIME_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_BLUE_DYE)}, recipeConsumer);
        carvedWood(ItemRegistry.DARK_BLUE_AND_DARK_GREEN_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_GREEN_DYE)}, recipeConsumer);
        carvedWood(ItemRegistry.BLACK_WHITE_GREEN_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_BLACK_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_GREEN_DYE)}, recipeConsumer);
        carvedWood(ItemRegistry.BLACK_WHITE_BLUE_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_BLACK_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_BLUE_DYE)}, recipeConsumer);
        carvedWood(ItemRegistry.RED_AND_GREEN_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_RED_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE)}, recipeConsumer);
        carvedWood(ItemRegistry.BLUE_AND_RED_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_RED_DYE)}, recipeConsumer);
        carvedWood(ItemRegistry.BLUE_WHITE_RED_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()),
                Ingredient.of(ModItemTags.FORGE_RED_DYE), Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get())}, recipeConsumer);
        carvedWood(ItemRegistry.GREEN_WHITE_RED_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get()), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()),
                Ingredient.of(ModItemTags.FORGE_RED_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get())}, recipeConsumer);
        carvedWood(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE),
                Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE)}, recipeConsumer);
        woodworking(Ingredient.of(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1.get()), ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2.get())
                .unlockedBy(itemUnlockName(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1.get()), itemCriterion(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1.get()))
                .save(recipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, "blue_and_yellow_carved_wood_1_to_2"));
        woodworking(Ingredient.of(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1.get()), ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3.get())
                .unlockedBy(itemUnlockName(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1.get()), itemCriterion(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1.get()))
                .save(recipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, "blue_and_yellow_carved_wood_1_to_3"));
        woodworking(Ingredient.of(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2.get()), ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1.get())
                .unlockedBy(itemUnlockName(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2.get()), itemCriterion(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2.get()))
                .save(recipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, "blue_and_yellow_carved_wood_2_to_1"));
        woodworking(Ingredient.of(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2.get()), ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3.get())
                .unlockedBy(itemUnlockName(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2.get()), itemCriterion(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2.get()))
                .save(recipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, "blue_and_yellow_carved_wood_2_to_3"));
        woodworking(Ingredient.of(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3.get()), ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1.get())
                .unlockedBy(itemUnlockName(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3.get()), itemCriterion(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3.get()))
                .save(recipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, "blue_and_yellow_carved_wood_3_to_1"));
        woodworking(Ingredient.of(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3.get()), ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2.get())
                .unlockedBy(itemUnlockName(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3.get()), itemCriterion(ItemRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3.get()))
                .save(recipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, "blue_and_yellow_carved_wood_3_to_2"));
        carvedWood(ItemRegistry.YELLOW_AND_GREEN_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE)}, recipeConsumer);
        carvedWood(ItemRegistry.YELLOW_GREEN_BLUE_CARVED_WOOD.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE)}, recipeConsumer);

        // DARK OAK

        woodworking(Ingredient.of(Items.STRIPPED_DARK_OAK_LOG), ItemRegistry.CARVED_DARK_OAK_BEAM.get())
                .unlockedBy(itemUnlockName(Items.STRIPPED_DARK_OAK_LOG), itemCriterion(Items.STRIPPED_DARK_OAK_LOG)).save(recipeConsumer);
        woodworking(Ingredient.of(Items.STRIPPED_DARK_OAK_LOG), ItemRegistry.CARVED_DARK_OAK_BEAM_EDGE.get())
                .unlockedBy(itemUnlockName(Items.STRIPPED_DARK_OAK_LOG), itemCriterion(Items.STRIPPED_DARK_OAK_LOG)).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.GILDED_DARK_OAK.get(), 1)
                .define('O', Items.STRIPPED_DARK_OAK_WOOD)
                .define('G', ItemRegistry.GOLD_PARTS.get())
                .pattern(" G ").pattern("GOG").pattern(" G ")
                .unlockedBy(itemUnlockName(Items.STRIPPED_DARK_OAK_WOOD), itemCriterion(Items.STRIPPED_DARK_OAK_WOOD))
                .save(recipeConsumer);
        woodworking(Ingredient.of(ItemRegistry.GILDED_DARK_OAK.get()), ItemRegistry.CHISELED_GILDED_DARK_OAK.get())
                .unlockedBy(itemUnlockName(ItemRegistry.GILDED_DARK_OAK.get()), itemCriterion(ItemRegistry.GILDED_DARK_OAK.get())).save(recipeConsumer);
        woodSlabAndStairsRecipe(ItemRegistry.GILDED_DARK_OAK.get(), ItemRegistry.GILDED_DARK_OAK_SLAB.get(), ItemRegistry.GILDED_DARK_OAK_STAIRS.get(), recipeConsumer);
        woodworking(Ingredient.of(ItemRegistry.GILDED_DARK_OAK.get()), ItemRegistry.GILDED_DARK_OAK_BRACKET.get())
                .unlockedBy(itemUnlockName(ItemRegistry.GILDED_DARK_OAK.get()), itemCriterion(ItemRegistry.GILDED_DARK_OAK.get())).save(recipeConsumer);

        // PILLARS

        carvedWood(ItemRegistry.CARVED_RED_PILLAR.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_RED_DYE), Ingredient.of(ModItemTags.FORGE_RED_DYE)}, recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.CARVED_RED_PILLAR_BASE.get(), 1)
                .define('P', ItemRegistry.CARVED_RED_PILLAR.get())
                .define('S', Items.SMOOTH_STONE_SLAB)
                .pattern("P").pattern("S")
                .unlockedBy(itemUnlockName(ItemRegistry.CARVED_RED_PILLAR.get()), itemCriterion(ItemRegistry.CARVED_RED_PILLAR.get()))
                .save(recipeConsumer);
        zhaotouWood(ItemRegistry.CARVED_RED_PILLAR_HEAD.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_RED_DYE), Ingredient.of(ModItemTags.FORGE_WHITE_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE)},
                recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.SPRUCE_PILLAR_BASE.get(), 1)
                .define('P', Items.SPRUCE_LOG)
                .define('S', Items.SMOOTH_STONE_SLAB)
                .pattern("P").pattern("S")
                .unlockedBy(itemUnlockName(Items.SPRUCE_LOG), itemCriterion(Items.SPRUCE_LOG))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.STRIPPED_DARK_OAK_PILLAR_BASE.get(), 1)
                .define('P', Items.STRIPPED_DARK_OAK_LOG)
                .define('S', Items.SMOOTH_STONE_SLAB)
                .pattern("P").pattern("S")
                .unlockedBy(itemUnlockName(Items.STRIPPED_DARK_OAK_LOG), itemCriterion(Items.STRIPPED_DARK_OAK_LOG))
                .save(recipeConsumer);
        woodworking(Ingredient.of(ItemRegistry.GILDED_DARK_OAK.get()), ItemRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_1.get())
                .unlockedBy(itemUnlockName(ItemRegistry.GILDED_DARK_OAK.get()), itemCriterion(ItemRegistry.GILDED_DARK_OAK.get())).save(recipeConsumer);
        woodworking(Ingredient.of(ItemRegistry.GILDED_DARK_OAK.get()), ItemRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_2.get())
                .unlockedBy(itemUnlockName(ItemRegistry.GILDED_DARK_OAK.get()), itemCriterion(ItemRegistry.GILDED_DARK_OAK.get())).save(recipeConsumer);
        woodworking(Ingredient.of(ItemRegistry.GILDED_DARK_OAK.get()), ItemRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_3.get())
                .unlockedBy(itemUnlockName(ItemRegistry.GILDED_DARK_OAK.get()), itemCriterion(ItemRegistry.GILDED_DARK_OAK.get())).save(recipeConsumer);
        woodworking(Ingredient.of(ItemRegistry.GILDED_DARK_OAK.get()), ItemRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_4.get())
                .unlockedBy(itemUnlockName(ItemRegistry.GILDED_DARK_OAK.get()), itemCriterion(ItemRegistry.GILDED_DARK_OAK.get())).save(recipeConsumer);
        woodworking(Ingredient.of(ItemRegistry.GILDED_DARK_OAK.get()), ItemRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_5.get())
                .unlockedBy(itemUnlockName(ItemRegistry.GILDED_DARK_OAK.get()), itemCriterion(ItemRegistry.GILDED_DARK_OAK.get())).save(recipeConsumer);

        zhaotouWood(ItemRegistry.CYAN_AND_WHITE_PILLAR_BASE.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_RED_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_WHITE_DYE), Ingredient.of(ItemRegistry.BLACK_DYE_POWDER.get())},
                recipeConsumer);
        zhaotouWood(ItemRegistry.CYAN_AND_WHITE_DECORATED_PILLAR.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_RED_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_WHITE_DYE), Ingredient.of(ModItemTags.FORGE_BLACK_DYE)},
                recipeConsumer);
        zhaotouWood(ItemRegistry.CYAN_AND_WHITE_PILLAR_HEAD.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_RED_DYE), Ingredient.of(ModItemTags.FORGE_BLACK_DYE), Ingredient.of(ModItemTags.FORGE_WHITE_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE)},
                recipeConsumer);
        simpleStonecutting(Items.CHISELED_STONE_BRICKS, ItemRegistry.STONE_PILLAR_BASE.get(), recipeConsumer);

        // FANGXIN

        fangxinWood(ItemRegistry.GREEN_FANGXIN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE)},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.GREEN_FANGXIN_EDGE.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get())},
                recipeConsumer);
        fangxinWood(ItemRegistry.BLUE_FANGXIN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.BLUE_FANGXIN_EDGE.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())},
                recipeConsumer);
        fangxinWood(ItemRegistry.CYAN_AND_BLUE_FANGXIN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_CYAN_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get()), Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get())},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.CYAN_AND_BLUE_FANGXIN_EDGE.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_CYAN_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get())},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.CYAN_AND_BLUE_FANGXIN_EDGE_VARIANT.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_CYAN_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE)},
                recipeConsumer);
        fangxinWood(ItemRegistry.CYAN_BLUE_WHITE_FANGXIN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_CYAN_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_GREEN_DYE)},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.CYAN_BLUE_WHITE_FANGXIN_EDGE.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_CYAN_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_GREEN_DYE)},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.BLUE_AND_GREEN_FANGXIN_EDGE.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE)},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.YELLOW_AND_GREEN_FANGXIN_EDGE.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_YELLOW_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE)},
                recipeConsumer);
        fangxinWood(ItemRegistry.DARK_BLUE_FANGXIN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE)},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.DARK_BLUE_FANGXIN_EDGE.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE)},
                recipeConsumer);
        fangxinWood(ItemRegistry.BLUE_AND_WHITE_FANGXIN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get())},
                recipeConsumer);
        fangxinWood(ItemRegistry.GREEN_AND_DARK_BLUE_FANGXIN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get())},
                recipeConsumer);
        fangxinWood(ItemRegistry.WHITE_AND_CYAN_FANGXIN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_WHITE_DYE), Ingredient.of(ModItemTags.FORGE_CYAN_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get())},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.WHITE_AND_CYAN_FANGXIN_EDGE.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_WHITE_DYE), Ingredient.of(ModItemTags.FORGE_CYAN_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get())},
                recipeConsumer);
        fangxinWood(ItemRegistry.WHITE_AND_BLUE_FANGXIN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_WHITE_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE)},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.WHITE_AND_BLUE_FANGXIN_EDGE.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.CYAN_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_WHITE_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE)},
                recipeConsumer);
        fangxinWood(ItemRegistry.RED_CYAN_BLUE_FANGXIN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_RED_DYE), Ingredient.of(ModItemTags.FORGE_CYAN_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ItemRegistry.RED_DYE_POWDER.get())},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.RED_CYAN_BLUE_FANGXIN_EDGE.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_RED_DYE), Ingredient.of(ModItemTags.FORGE_CYAN_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get())},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.BLUE_CYAN_BLUE_FANGXIN_EDGE.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_CYAN_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get())},
                recipeConsumer);
        fangxinWood(ItemRegistry.BLUE_CYAN_RED_FANGXIN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_CYAN_DYE), Ingredient.of(ModItemTags.FORGE_RED_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get())},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.BLUE_CYAN_RED_FANGXIN_EDGE.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_CYAN_DYE), Ingredient.of(ModItemTags.FORGE_RED_DYE), Ingredient.of(ItemRegistry.RED_DYE_POWDER.get())},
                recipeConsumer);
        fangxinWood(ItemRegistry.CYAN_BLUE_CYAN_FANGXIN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_CYAN_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_CYAN_DYE)},
                recipeConsumer);
        fangxinWood(ItemRegistry.RED_BLUE_RED_FANGXIN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_RED_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_RED_DYE)},
                recipeConsumer);
        fangxinEdgeWood(ItemRegistry.CYAN_AND_YELLOW_FANGXIN_EDGE.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_CYAN_DYE), Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get())},
                recipeConsumer);

        // ZHAOTOU

        zhaotouWood(ItemRegistry.BLUE_ZHAOTOU_EDGE.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ItemRegistry.RED_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_BLUE_DYE)},
                recipeConsumer);
        zhaotouWood(ItemRegistry.GREEN_AND_BLUE_ZHAOTOU.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get())},
                recipeConsumer);
        zhaotouWood(ItemRegistry.BLUE_AND_GREEN_ZHAOTOU.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get())},
                recipeConsumer);
        zhaotouWood(ItemRegistry.BLUE_AND_GREEN_DOUBLE_LAYERED_ZHAOTOU.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get())},
                recipeConsumer);
        zhaotouWood(ItemRegistry.CYAN_AND_RED_ZHAOTOU.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_CYAN_DYE), Ingredient.of(ModItemTags.FORGE_RED_DYE), Ingredient.of(ModItemTags.FORGE_CYAN_DYE)},
                recipeConsumer);
        zhaotouWood(ItemRegistry.CYAN_AND_BLUE_ZHAOTOU.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_CYAN_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_CYAN_DYE)},
                recipeConsumer);
        zhaotouWood(ItemRegistry.GRAY_BLACK_RED_ZHAOTOU.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_GRAY_DYE), Ingredient.of(ItemRegistry.BLACK_DYE_POWDER.get()), Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_RED_DYE)},
                recipeConsumer);
        zhaotouWood(ItemRegistry.BLUE_GREEN_RED_ZHAOTOU.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_RED_DYE), Ingredient.of(ItemRegistry.CYAN_DYE_POWDER.get())},
                recipeConsumer);
        zhaotouWood(ItemRegistry.RED_AND_BLUE_ZHAOTOU.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_RED_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_BLUE_DYE)},
                recipeConsumer);
        zhaotouWood(ItemRegistry.GREEN_AND_YELLOW_ZHAOTOU.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE)},
                recipeConsumer);
        zhaotouWood(ItemRegistry.RED_GREEN_BLUE_ZHAOTOU.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE), Ingredient.of(ItemRegistry.RED_DYE_POWDER.get())},
                recipeConsumer);
        zhaotouWood(ItemRegistry.WHITE_BLUE_GREEN_ZHAOTOU.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_WHITE_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE)},
                recipeConsumer);

        // GUTOU

        gutouWood(ItemRegistry.GREEN_BLUE_BLACK_GUTOU.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BLACK_DYE_POWDER.get())},
                recipeConsumer);
        gutouWood(ItemRegistry.BLUE_GREEN_YELLOW_GUTOU.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE)},
                recipeConsumer);
        gutouWood(ItemRegistry.BLUE_AND_YELLOW_GUTOU.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE)},
                recipeConsumer);

        // RAFTERS

        woodworking(Ingredient.of(Items.STRIPPED_DARK_OAK_LOG), ItemRegistry.DARK_OAK_RAFTER.get())
                .unlockedBy(itemUnlockName(Items.STRIPPED_DARK_OAK_LOG), itemCriterion(Items.STRIPPED_DARK_OAK_LOG)).save(recipeConsumer);
        woodworking(Ingredient.of(Items.STRIPPED_DARK_OAK_LOG), ItemRegistry.DARK_OAK_RAFTER_END.get())
                .unlockedBy(itemUnlockName(Items.STRIPPED_DARK_OAK_LOG), itemCriterion(Items.STRIPPED_DARK_OAK_LOG)).save(recipeConsumer);
        ShapelessRecipeBuilder.shapeless(ItemRegistry.GILDED_DARK_OAK_RAFTER.get())
                .requires(ItemRegistry.DARK_OAK_RAFTER.get()).requires(ItemRegistry.GOLD_PARTS.get())
                .unlockedBy(itemUnlockName(ItemRegistry.DARK_OAK_RAFTER.get()), itemCriterion(ItemRegistry.DARK_OAK_RAFTER.get())).save(recipeConsumer);
        ShapelessRecipeBuilder.shapeless(ItemRegistry.GILDED_DARK_OAK_RAFTER_END.get())
                .requires(ItemRegistry.DARK_OAK_RAFTER_END.get()).requires(ItemRegistry.GOLD_PARTS.get())
                .unlockedBy(itemUnlockName(ItemRegistry.DARK_OAK_RAFTER_END.get()), itemCriterion(ItemRegistry.DARK_OAK_RAFTER_END.get())).save(recipeConsumer);
        rafter(ItemRegistry.BLUE_TIGER_EYE_RAFTER.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())
        }, recipeConsumer);
        rafterEnd(ItemRegistry.BLUE_TIGER_EYE_RAFTER_END.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())
        }, recipeConsumer);
        rafter(ItemRegistry.BLUE_CARVED_TIGER_EYE_RAFTER.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())
        }, recipeConsumer);
        rafterEnd(ItemRegistry.BLUE_CARVED_TIGER_EYE_RAFTER_END.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_BLUE_DYE), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())
        }, recipeConsumer);
        rafter(ItemRegistry.GREEN_CARVED_TIGER_EYE_RAFTER.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())
        }, recipeConsumer);
        rafterEnd(ItemRegistry.GREEN_CARVED_TIGER_EYE_RAFTER_END.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())
        }, recipeConsumer);
        rafter(ItemRegistry.GREEN_WANZI_RAFTER.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())
        }, recipeConsumer);
        rafterEnd(ItemRegistry.GREEN_WANZI_RAFTER_END.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())
        }, recipeConsumer);
        rafter(ItemRegistry.GREEN_CARVED_WANZI_RAFTER.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())
        }, recipeConsumer);
        rafterEnd(ItemRegistry.GREEN_CARVED_WANZI_RAFTER_END.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE), Ingredient.of(ItemRegistry.GOLD_DYE_POWDER.get())
        }, recipeConsumer);

        // BEAM HEAD

        woodworking(Ingredient.of(ItemRegistry.GILDED_DARK_OAK.get()), ItemRegistry.GILDED_DARK_OAK_BEAM_HEAD.get())
                .unlockedBy(itemUnlockName(ItemRegistry.GILDED_DARK_OAK.get()), itemCriterion(ItemRegistry.GILDED_DARK_OAK.get())).save(recipeConsumer);
        woodworking(Ingredient.of(ItemRegistry.GREEN_CARVED_WOOD.get()), ItemRegistry.QING_GREEN_BEAM_HEAD.get())
                .unlockedBy(itemUnlockName(ItemRegistry.GREEN_CARVED_WOOD.get()), itemCriterion(ItemRegistry.GREEN_CARVED_WOOD.get())).save(recipeConsumer);

        // ARCHITRAVE

        architrave(ItemRegistry.RED_AND_CYAN_CARVED_ARCHITRAVE.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_RED_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_CYAN_DYE)
        }, recipeConsumer);
        woodworking(ItemRegistry.RED_AND_CYAN_CARVED_ARCHITRAVE.get(), ItemRegistry.RED_AND_CYAN_CARVED_ARCHITRAVE_SLAB.get(), 2, recipeConsumer);
        architrave(ItemRegistry.RED_AND_BLUE_CARVED_ARCHITRAVE.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_RED_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_BLUE_DYE)
        }, recipeConsumer);
        woodworking(ItemRegistry.RED_AND_BLUE_CARVED_ARCHITRAVE.get(), ItemRegistry.RED_AND_BLUE_CARVED_ARCHITRAVE_SLAB.get(), 2, recipeConsumer);
        architrave(ItemRegistry.EMPTY_TUANHUA_SLAB.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_CYAN_DYE), Ingredient.of(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get())
        }, recipeConsumer);
        architrave(ItemRegistry.FULL_TUANHUA_SLAB.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_CYAN_DYE), Ingredient.of(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ItemRegistry.CYAN_DYE_POWDER.get())
        }, recipeConsumer);
        architrave(ItemRegistry.RED_AND_CYAN_TUANHUA_SLAB.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_CYAN_DYE), Ingredient.of(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.RED_DYE_POWDER.get()), Ingredient.of(ItemRegistry.CYAN_DYE_POWDER.get())
        }, recipeConsumer);
        architrave(ItemRegistry.RED_CARVED_ARCHITRAVE.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_RED_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_RED_DYE)
        }, recipeConsumer);
        architrave(ItemRegistry.WHITE_AND_RED_SLAB.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_RED_DYE), Ingredient.of(ModItemTags.FORGE_RED_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get())
        }, recipeConsumer);

        // QUETI

        woodworking(ItemRegistry.GILDED_DARK_OAK.get(), ItemRegistry.LONG_GILDED_DARK_OAK_QUETI.get(), 1, recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.LONG_GILDED_DARK_OAK_QUETI_EDGE.get()).define('C', ItemRegistry.LONG_GILDED_DARK_OAK_QUETI.get()).pattern("CC")
                .unlockedBy(itemUnlockName(ItemRegistry.LONG_GILDED_DARK_OAK_QUETI.get()), itemCriterion(ItemRegistry.LONG_GILDED_DARK_OAK_QUETI.get())).save(recipeConsumer);
        woodworking(ItemRegistry.GILDED_DARK_OAK.get(), ItemRegistry.HORIZONTAL_GILDED_DARK_OAK_QUETI.get(), 1, recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.CENTRAL_GILDED_DARK_OAK_QUETI.get()).define('C', ItemRegistry.HORIZONTAL_GILDED_DARK_OAK_QUETI.get()).pattern("CC")
                .unlockedBy(itemUnlockName(ItemRegistry.HORIZONTAL_GILDED_DARK_OAK_QUETI.get()), itemCriterion(ItemRegistry.HORIZONTAL_GILDED_DARK_OAK_QUETI.get())).save(recipeConsumer);
        woodworking(ItemRegistry.GILDED_DARK_OAK.get(), ItemRegistry.VERTICAL_GILDED_DARK_OAK_QUETI.get(), 1, recipeConsumer);
        woodworking(Ingredient.of(ItemTags.PLANKS), ItemRegistry.WOODEN_QUETI.get(), 2).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        woodworking(Ingredient.of(ItemTags.PLANKS), ItemRegistry.WOODEN_QUETI_EDGE.get(), 2).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        woodworking(Ingredient.of(ItemTags.PLANKS), ItemRegistry.TALL_WOODEN_QUETI_EDGE.get(), 1).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        woodworking(Ingredient.of(ItemTags.PLANKS), ItemRegistry.LARGE_WOODEN_QUETI_EDGE.get(), 1).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GREEN_GLAZED_TILES.get()), ItemRegistry.SHORT_GLAZED_QUETI.get(), 4)
                .unlockedBy(itemUnlockName(ItemRegistry.GREEN_GLAZED_TILES.get()), itemCriterion(ItemRegistry.GREEN_GLAZED_TILES.get())).save(recipeConsumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GREEN_GLAZED_TILES.get()), ItemRegistry.THICK_CARVED_QUETI.get(), 2)
                .unlockedBy(itemUnlockName(ItemRegistry.GREEN_GLAZED_TILES.get()), itemCriterion(ItemRegistry.GREEN_GLAZED_TILES.get())).save(recipeConsumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.GREEN_GLAZED_TILES.get()), ItemRegistry.SHORT_THICK_GLAZED_QUETI.get(), 1)
                .unlockedBy(itemUnlockName(ItemRegistry.GREEN_GLAZED_TILES.get()), itemCriterion(ItemRegistry.GREEN_GLAZED_TILES.get())).save(recipeConsumer);
        woodworking(Ingredient.of(ItemTags.PLANKS), ItemRegistry.WOODEN_GUALUO.get(), 1).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        woodworking(Ingredient.of(ItemTags.PLANKS), ItemRegistry.LARGE_WOODEN_GUALUO.get(), 1).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        woodworking(Ingredient.of(ItemTags.PLANKS), ItemRegistry.LARGE_WOODEN_GUALUO_EDGE.get(), 1).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.STONE), ItemRegistry.CARVED_STONE_PANEL.get(), 1)
                .unlockedBy(itemUnlockName(Items.STONE), itemCriterion(Items.STONE)).save(recipeConsumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.STONE), ItemRegistry.CARVED_STONE_PANEL_EDGE.get(), 1)
                .unlockedBy(itemUnlockName(Items.STONE), itemCriterion(Items.STONE)).save(recipeConsumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.STONE), ItemRegistry.CARVED_STONE_PANEL_CENTER.get(), 1)
                .unlockedBy(itemUnlockName(Items.STONE), itemCriterion(Items.STONE)).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.CARVED_STONE_QUETI_PART.get())
                .define('E', ItemRegistry.CARVED_STONE_PANEL_EDGE.get())
                .define('C', ItemRegistry.CARVED_STONE_PANEL_CENTER.get())
                .pattern("EC")
                .unlockedBy(itemUnlockName(ItemRegistry.CARVED_STONE_PANEL.get()), itemCriterion(ItemRegistry.CARVED_STONE_PANEL.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.CARVED_STONE_BEAM.get())
                .define('C', ItemRegistry.CARVED_STONE_PANEL.get())
                .pattern("CCC")
                .unlockedBy(itemUnlockName(ItemRegistry.CARVED_STONE_PANEL.get()), itemCriterion(ItemRegistry.CARVED_STONE_PANEL.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.CARVED_STONE_QUETI.get())
                .define('E', ItemRegistry.CARVED_STONE_PANEL_EDGE.get())
                .pattern("E").pattern("E")
                .unlockedBy(itemUnlockName(ItemRegistry.CARVED_STONE_PANEL.get()), itemCriterion(ItemRegistry.CARVED_STONE_PANEL.get())).save(recipeConsumer);

        // PATTERNS

        caihua(ItemRegistry.YELLOW_CARVED_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_YELLOW_DYE), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE)
        }, recipeConsumer);
        caihua(ItemRegistry.CIRCULAR_YELLOW_CARVED_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE), Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get())
        }, recipeConsumer);
        fangxinEdgePattern(ItemRegistry.YELLOW_CARVED_FANGXIN_EDGE_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_YELLOW_DYE), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE)
        }, recipeConsumer);
        fangxinPattern(ItemRegistry.YELLOW_CARVED_FANGXIN_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_YELLOW_DYE), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE)
        }, recipeConsumer);
        caihua(ItemRegistry.LARGE_YELLOW_CARVED_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_YELLOW_DYE), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE)
        }, recipeConsumer);
        caihua(ItemRegistry.MEDIUM_YELLOW_CARVED_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE), Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get())
        }, recipeConsumer);
        zhaotouPattern(ItemRegistry.YELLOW_CARVED_ZHAOTOU_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_YELLOW_DYE), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE)
        }, recipeConsumer);
        zhaotouPattern(ItemRegistry.LONG_YELLOW_CARVED_ZHAOTOU_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_YELLOW_DYE), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE), Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get())
        }, recipeConsumer);
        zhaotouPattern(ItemRegistry.CARVED_ZHAOTOU_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_YELLOW_DYE), Ingredient.of(ModItemTags.FORGE_WHITE_DYE)
        }, recipeConsumer);
        caihua(ItemRegistry.FLAME_ARCH_WALL_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ModItemTags.FORGE_ORANGE_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get())
        }, recipeConsumer);
        fangxinPattern(ItemRegistry.BLUE_FANGXIN_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.BLACK_DYE_POWDER.get()), Ingredient.of(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BROWN_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_BLUE_DYE)
        }, recipeConsumer);
        fangxinEdgePattern(ItemRegistry.BLUE_FANGXIN_PATTERN_EDGE.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.BLACK_DYE_POWDER.get()), Ingredient.of(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BROWN_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_BLUE_DYE)
        }, recipeConsumer);
        fangxinPattern(ItemRegistry.GREEN_FANGXIN_PATTERN.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.BLACK_DYE_POWDER.get()), Ingredient.of(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BROWN_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_GREEN_DYE)
        }, recipeConsumer);
        fangxinEdgePattern(ItemRegistry.GREEN_FANGXIN_PATTERN_EDGE.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.BLACK_DYE_POWDER.get()), Ingredient.of(ItemRegistry.LIGHT_BLUE_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BROWN_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_GREEN_DYE)
        }, recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.GOLDEN_DRAGON_FANGXIN_PATTERN.get())
                .define('C', ItemRegistry.BLUE_FANGXIN_PATTERN.get())
                .define('E', ItemRegistry.BLUE_FANGXIN_PATTERN_EDGE.get())
                .define('G', ItemRegistry.GOLD_DYE_POWDER.get())
                .pattern("GGG").pattern("ECE")
                .unlockedBy(itemUnlockName(ItemRegistry.BLUE_FANGXIN_PATTERN.get()), itemCriterion(ItemRegistry.BLUE_FANGXIN_PATTERN.get()))
                .save(recipeConsumer);
        caihua(ItemRegistry.LIGHT_BLUE_SU_STYLE_CAIHUA.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get()), Ingredient.of(ItemRegistry.RED_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_LIGHT_BLUE_DYE)
        }, recipeConsumer);
        caihua(ItemRegistry.YELLOW_SU_STYLE_CAIHUA.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get()), Ingredient.of(ItemRegistry.RED_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE)
        }, recipeConsumer);
        caihua(ItemRegistry.LIGHT_YELLOW_SU_STYLE_CAIHUA.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get()), Ingredient.of(ItemRegistry.RED_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_YELLOW_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get())
        }, recipeConsumer);
        caihua(ItemRegistry.MEDIUM_SU_STYLE_CAIHUA.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ItemRegistry.WHITE_DYE_POWDER.get())
        }, recipeConsumer);
        caihua(ItemRegistry.LARGE_WHITE_SU_STYLE_CAIHUA.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_WHITE_DYE), Ingredient.of(ModItemTags.FORGE_WHITE_DYE)
        }, recipeConsumer);
        caihua(ItemRegistry.LARGE_GREEN_SU_STYLE_CAIHUA.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_GREEN_DYE), Ingredient.of(ModItemTags.FORGE_GREEN_DYE)
        }, recipeConsumer);
        caihua(ItemRegistry.LARGE_GRAY_SU_STYLE_CAIHUA.get(), new Ingredient[]{
                Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()), Ingredient.of(ModItemTags.FORGE_GRAY_DYE), Ingredient.of(ModItemTags.FORGE_GRAY_DYE)
        }, recipeConsumer);

        // CHUIHUA

        ShapedRecipeBuilder.shaped(ItemRegistry.BLUE_AND_GREEN_CHUIHUA.get())
                .define('R', ItemRegistry.RED_CARVED_WOODEN_SLAB.get())
                .define('B', ItemRegistry.BLUE_CARVED_WOODEN_SLAB.get())
                .define('G', ItemRegistry.GREEN_CARVED_WOODEN_SLAB.get())
                .pattern("R").pattern("B").pattern("G")
                .unlockedBy(itemUnlockName(ItemRegistry.BLUE_CARVED_WOODEN_SLAB.get()), itemCriterion(ItemRegistry.BLUE_CARVED_WOODEN_SLAB.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.CYAN_AND_YELLOW_CHUIHUA.get())
                .define('C', ItemRegistry.CYAN_CARVED_WOODEN_SLAB.get())
                .define('O', ItemRegistry.BLUE_AND_RED_CARVED_WOOD.get())
                .define('G', ItemRegistry.YELLOW_AND_GREEN_CARVED_WOOD.get())
                .pattern("C").pattern("O").pattern("G")
                .unlockedBy(itemUnlockName(ItemRegistry.CYAN_CARVED_WOODEN_SLAB.get()), itemCriterion(ItemRegistry.CYAN_CARVED_WOODEN_SLAB.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.GILDED_DARK_OAK_CHUIHUA.get())
                .define('S', ItemRegistry.GILDED_DARK_OAK_SLAB.get())
                .define('B', ItemRegistry.GILDED_DARK_OAK.get())
                .define('P', ItemRegistry.GOLD_PARTS.get())
                .pattern("S").pattern("B").pattern("P")
                .unlockedBy(itemUnlockName(ItemRegistry.GILDED_DARK_OAK.get()), itemCriterion(ItemRegistry.GILDED_DARK_OAK.get()))
                .save(recipeConsumer);

        // ROOF CHARM

        ShapedRecipeBuilder.shaped(ItemRegistry.GOLDEN_GLAZED_ROOF_CHARM.get())
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
        simpleStonecutting(Items.YELLOW_GLAZED_TERRACOTTA, ItemRegistry.GOLDEN_GLAZED_ROOF_CHARM_ACCESSORY.get(), recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.GREEN_GLAZED_ROOF_CHARM.get())
                .define('G', Items.GREEN_GLAZED_TERRACOTTA)
                .define('R', ItemRegistry.BLACK_ROOF_RIDGE_CONNECTION.get())
                .define('P', ItemRegistry.GOLD_PARTS.get())
                .define('S', ItemRegistry.GRAY_ROOF_TILE_STAIRS.get())
                .pattern(" SP")
                .pattern(" PG")
                .pattern("RRG")
                .unlockedBy(itemUnlockName(Items.GREEN_GLAZED_TERRACOTTA), itemCriterion(Items.GREEN_GLAZED_TERRACOTTA))
                .save(recipeConsumer);

        // CEILING

        ShapedRecipeBuilder.shaped(ItemRegistry.QING_GOLDEN_DRAGON_CEILING.get())
                .define('G', ItemRegistry.GREEN_CARVED_WOOD.get())
                .define('B', ModItemTags.FORGE_BLUE_DYE)
                .define('D', ItemRegistry.GOLD_DYE_POWDER.get())
                .pattern("G").pattern("B").pattern("D")
                .unlockedBy(itemUnlockName(ItemRegistry.GREEN_CARVED_WOOD.get()), itemCriterion(ItemRegistry.GREEN_CARVED_WOOD.get()))
                .save(recipeConsumer);

        // RAILING

        simpleStonecutting(Items.QUARTZ_BLOCK, ItemRegistry.WHITE_MARBLE_RAILING.get(), recipeConsumer);
        simpleStonecutting(Items.QUARTZ_BLOCK, ItemRegistry.WHITE_MARBLE_RAILING_SLANT.get(), recipeConsumer);
        woodworking(Ingredient.of(ItemTags.PLANKS), ItemRegistry.CARVED_WOODEN_RAILING.get(), 1).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        woodworking(Ingredient.of(ItemTags.PLANKS), ItemRegistry.WOODEN_RAILING.get(), 1).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        woodworking(Ingredient.of(ItemTags.PLANKS), ItemRegistry.WOODEN_RAILING_VARIANT.get(), 1).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        blockTransform(ItemRegistry.WOODEN_RAILING.get(), ModItemTags.FORGE_RED_DYE, ItemRegistry.RED_WOODEN_RAILING_EDGE.get(), recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.RED_WOODEN_RAILING.get(), 2).define('C', ItemRegistry.RED_WOODEN_RAILING_EDGE.get()).pattern("CC")
                .unlockedBy(itemUnlockName(ItemRegistry.RED_WOODEN_RAILING_EDGE.get()), itemCriterion(ItemRegistry.RED_WOODEN_RAILING_EDGE.get())).save(recipeConsumer);

        // GUARDIAN LION

        woodworking(Ingredient.of(ItemTags.LOGS), ItemRegistry.SMALL_WOODEN_GUARDIAN_LION.get(), 1).unlockedBy("has_log", tagUnlock(ItemTags.LOGS)).save(recipeConsumer);
        simpleStonecutting(Items.STONE, ItemRegistry.SMALL_STONE_GUARDIAN_LION.get(), recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.SMALL_JADE_GUARDIAN_LION.get())
                .define('L', ItemRegistry.SMALL_STONE_GUARDIAN_LION.get())
                .define('J', ItemRegistry.JADE.get())
                .define('P', ItemRegistry.JADE_PARTS.get())
                .pattern("PJP")
                .pattern("JLJ")
                .pattern("PJP")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_STONE_GUARDIAN_LION.get()), itemCriterion(ItemRegistry.SMALL_STONE_GUARDIAN_LION.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.SMALL_YELLOW_GLAZED_GUARDIAN_LION.get())
                .define('L', ItemRegistry.SMALL_STONE_GUARDIAN_LION.get())
                .define('G', Items.YELLOW_GLAZED_TERRACOTTA)
                .define('P', ItemRegistry.GOLD_PARTS.get())
                .define('D', ItemRegistry.GOLD_DYE_POWDER.get())
                .pattern("DGD")
                .pattern("GLG")
                .pattern("PGP")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_STONE_GUARDIAN_LION.get()), itemCriterion(ItemRegistry.SMALL_STONE_GUARDIAN_LION.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.SMALL_GREEN_GLAZED_GUARDIAN_LION.get())
                .define('L', ItemRegistry.SMALL_STONE_GUARDIAN_LION.get())
                .define('G', ItemRegistry.GREEN_GLAZED_TILES.get())
                .define('P', ItemRegistry.PORCELAIN_PARTS.get())
                .pattern("PGP")
                .pattern("GLG")
                .pattern("PGP")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_STONE_GUARDIAN_LION.get()), itemCriterion(ItemRegistry.SMALL_STONE_GUARDIAN_LION.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.XUMI_STONE_MONOLITH.get())
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
        woodworking(Items.BOOKSHELF, ItemRegistry.BOOKSHELF.get(), 1, recipeConsumer);
        woodworking(Items.BOOKSHELF, ItemRegistry.BOOKSHELF_VARIANT.get(), 1, recipeConsumer);

    }

    private static void categoryDecorations(@NotNull Consumer<FinishedRecipe> recipeConsumer){

        // STUDY

        ShapedRecipeBuilder.shaped(ItemRegistry.ABACUS.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('P', ItemRegistry.WOODEN_PARTS.get())
                .define('S', Items.STICK)
                .pattern("PFP")
                .pattern("SSS")
                .pattern("PFP")
                .unlockedBy(itemUnlockName(ItemRegistry.WOODEN_PARTS.get()), itemCriterion(ItemRegistry.WOODEN_PARTS.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.BRUSH_TOOLS.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('P', ItemRegistry.WOODEN_PARTS.get())
                .define('S', Items.STICK)
                .pattern("SSS")
                .pattern("S S")
                .pattern("PFP")
                .unlockedBy(itemUnlockName(ItemRegistry.WOODEN_PARTS.get()), itemCriterion(ItemRegistry.WOODEN_PARTS.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.BRUSH_AND_INKSTONE.get())
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
        ShapedRecipeBuilder.shaped(ItemRegistry.RULER.get())
                .define('S', Items.STICK)
                .define('P', ItemRegistry.WOODEN_PARTS.get())
                .pattern("SPS")
                .unlockedBy(itemUnlockName(ItemRegistry.WOODEN_PARTS.get()), itemCriterion(ItemRegistry.WOODEN_PARTS.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.BOOK_STACK.get())
                .define('B', Items.BOOK)
                .define('D', ItemRegistry.BLUE_DYE_POWDER.get())
                .pattern("BD").pattern("BD").pattern("BD")
                .unlockedBy(itemUnlockName(Items.BOOK), itemCriterion(Items.BOOK))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.PAPER.get(), 2)
                .define('P', ItemRegistry.XUAN_PAPER.get())
                .pattern("PP")
                .unlockedBy(itemUnlockName(ItemRegistry.XUAN_PAPER.get()), itemCriterion(ItemRegistry.XUAN_PAPER.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.BLUE_BOOK.get())
                .define('B', Items.BOOK)
                .define('D', ItemRegistry.BLUE_DYE_POWDER.get())
                .pattern("BD")
                .unlockedBy(itemUnlockName(Items.BOOK), itemCriterion(Items.BOOK))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.BAMBOO_SLIPS.get())
                .define('S', Items.STRING)
                .define('B', Items.BAMBOO)
                .pattern("BBS").pattern("BBS").pattern("BBS")
                .unlockedBy(itemUnlockName(Items.BAMBOO), itemCriterion(Items.BAMBOO))
                .save(recipeConsumer);

        // ROOM DECO

        ShapedRecipeBuilder.shaped(ItemRegistry.BACK_CUSHION.get())
                .define('W', Items.YELLOW_WOOL)
                .define('S', ItemRegistry.SILK.get())
                .pattern("WS")
                .pattern("WS")
                .unlockedBy(itemUnlockName(ItemRegistry.SILK.get()), itemCriterion(ItemRegistry.SILK.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.CHESSBOARD.get())
                .define('P', ModItemTags.POLISHED_PLANKS)
                .define('B', Items.POLISHED_BLACKSTONE)
                .define('W', Items.SMOOTH_QUARTZ)
                .pattern("BW")
                .pattern("PP")
                .unlockedBy("has_polished_plank", tagUnlock(ModItemTags.POLISHED_PLANKS))
                .save(recipeConsumer);
        /* todo
            BLUE_AND_WHITE_PORCELAIN_VASE
            LARGE_BLUE_AND_WHITE_PORCELAIN_VASE
            SHORT_BLUE_AND_WHITE_PORCELAIN_POT
            TALL_BLUE_AND_WHITE_PORCELAIN_POT
            BLUE_AND_WHITE_PORCELAIN_BOWL
         */
        ShapedRecipeBuilder.shaped(ItemRegistry.BRONZE_MIRROR.get())
                .define('I', ItemRegistry.BRONZE_INGOT.get())
                .define('P', ItemRegistry.BRONZE_PARTS.get())
                .define('C', Items.COPPER_INGOT)
                .pattern("PIP")
                .pattern("CIC")
                .unlockedBy(itemUnlockName(ItemRegistry.BRONZE_INGOT.get()), itemCriterion(ItemRegistry.BRONZE_INGOT.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.MEMORIAL_TABLET.get())
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
        ShapedRecipeBuilder.shaped(ItemRegistry.BRONZE_CENSER.get())
                .define('I', ItemRegistry.BRONZE_INGOT.get())
                .define('P', ItemRegistry.BRONZE_PARTS.get())
                .pattern("PIP")
                .pattern("III")
                .unlockedBy(itemUnlockName(ItemRegistry.BRONZE_INGOT.get()), itemCriterion(ItemRegistry.BRONZE_INGOT.get()))
                .save(recipeConsumer);
        CompositeSmeltingRecipeBuilder.compositeSmelting(Ingredient.of(ItemRegistry.BRONZE_CENSER.get()), Ingredient.of(ModItemTags.FORGE_CYAN_DYE),
                ItemRegistry.ROYAL_CENSER.get(), 0.5f, 200)
                .unlockedBy(itemUnlockName(ItemRegistry.BRONZE_CENSER.get()), itemCriterion(ItemRegistry.BRONZE_CENSER.get()))
                .save(recipeConsumer);
        //todo PORCELAIN_TEAPOT
        ShapedRecipeBuilder.shaped(ItemRegistry.BOOTS.get())
                .define('B', Items.LEATHER_BOOTS)
                .define('S', ItemRegistry.SILK.get())
                .define('D', ItemRegistry.BLACK_DYE_POWDER.get())
                .pattern("D D")
                .pattern("SBS")
                .pattern("SSS")
                .unlockedBy(itemUnlockName(ItemRegistry.SILK.get()), itemCriterion(ItemRegistry.SILK.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.JADE_PENDANT.get())
                .define('J', ItemRegistry.JADE.get())
                .define('S', Items.STRING)
                .define('R', ItemRegistry.RED_DYE_POWDER.get())
                .pattern("J")
                .pattern("S")
                .pattern("R")
                .unlockedBy(itemUnlockName(ItemRegistry.JADE.get()), itemCriterion(ItemRegistry.JADE.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.IMPERIAL_JADE_SEAL.get())
                .define('J', ItemRegistry.JADE.get())
                .define('G', Items.ENCHANTED_GOLDEN_APPLE)
                .define('P', ItemRegistry.GOLD_PARTS.get())
                .pattern("PG")
                .pattern("JJ")
                .pattern("JJ")
                .unlockedBy(itemUnlockName(ItemRegistry.JADE.get()), itemCriterion(ItemRegistry.JADE.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.LONG_PILLOW.get())
                .define('Y', Items.YELLOW_WOOL)
                .define('R', Items.RED_WOOL)
                .define('S', ItemRegistry.SILK.get())
                .pattern("SSS")
                .pattern("YRY")
                .unlockedBy(itemUnlockName(ItemRegistry.SILK.get()), itemCriterion(ItemRegistry.SILK.get()))
                .save(recipeConsumer);

        // MISC OBJECTS
        // Fabric rolls and dolls sold by special trader
        // Bottle Gourd sold by Cook

        // FLOWER POTS
        // todo flowerpot items

        // COURTYARD

        ShapedRecipeBuilder.shaped(ItemRegistry.SACK.get())
                .define('T', Items.STRING)
                .define('S', ItemRegistry.SILK.get())
                .pattern(" T ")
                .pattern("SSS")
                .unlockedBy(itemUnlockName(ItemRegistry.SILK.get()), itemCriterion(ItemRegistry.SILK.get()))
                .save(recipeConsumer);
        // tea basket todo tea item
        ShapedRecipeBuilder.shaped(ItemRegistry.STRAW_HAT.get())
                .define('W', Items.WHEAT)
                .define('S', ItemRegistry.SILK.get())
                .define('R', ItemRegistry.RED_DYE_POWDER.get())
                .pattern("RSR")
                .pattern("WWW")
                .unlockedBy(itemUnlockName(ItemRegistry.SILK.get()), itemCriterion(ItemRegistry.SILK.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.KNIFE.get())
                .define('S', Items.IRON_SWORD)
                .define('B', ItemRegistry.BRONZE_PARTS.get())
                .pattern("S ")
                .pattern(" B")
                .unlockedBy(itemUnlockName(ItemRegistry.BRONZE_PARTS.get()), itemCriterion(ItemRegistry.BRONZE_PARTS.get()))
                .save(recipeConsumer);
        // sundial sold by cleric todo time showing
        ShapedRecipeBuilder.shaped(ItemRegistry.BROOM.get())
                .define('S', Items.STICK)
                .define('H', Items.HAY_BLOCK)
                .pattern("S")
                .pattern("H")
                .unlockedBy(itemUnlockName(Items.HAY_BLOCK), itemCriterion(Items.HAY_BLOCK))
                .save(recipeConsumer);
        simpleStonecutting(ItemRegistry.PALE_YELLOW_STONE.get(), ItemRegistry.STONE_PEDESTAL.get(), recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.TERRACOTTA_POT.get())
                .define('T', Items.CYAN_TERRACOTTA)
                .pattern("T T")
                .pattern("TTT")
                .unlockedBy(itemUnlockName(Items.CYAN_TERRACOTTA), itemCriterion(Items.CYAN_TERRACOTTA))
                .save(recipeConsumer);
        // Chinese herbs bag sold by special trader
        ShapedRecipeBuilder.shaped(ItemRegistry.FRUIT_BOX.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('P', ModItemTags.POLISHED_PLANKS)
                .define('A', Items.APPLE)
                .pattern("PAP")
                .pattern("PFP")
                .unlockedBy(itemUnlockName(Items.APPLE), itemCriterion(Items.APPLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.WOODEN_CRATE.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('P', ModItemTags.POLISHED_PLANKS)
                .pattern("PPP")
                .pattern("PFP")
                .pattern("PPP")
                .unlockedBy("has_polished_plank", tagUnlock(ModItemTags.POLISHED_PLANKS))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.GUNNY_SACK.get())
                .define('S', ItemRegistry.SILK.get())
                .pattern("S S")
                .pattern("S S")
                .pattern("SSS")
                .unlockedBy(itemUnlockName(ItemRegistry.SILK.get()), itemCriterion(ItemRegistry.SILK.get()))
                .save(recipeConsumer);
        // bronze ding only from special loot
        // carriage from toolsmith
        ShapedRecipeBuilder.shaped(ItemRegistry.WOODEN_POLES.get())
                .define('F', ItemTags.WOODEN_FENCES)
                .pattern("F F")
                .pattern("F F")
                .pattern("F F")
                .unlockedBy("has_fence", tagUnlock(ItemTags.WOODEN_FENCES))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.TEAHOUSE_FLAG.get())
                .define('F', ItemTags.WOODEN_FENCES)
                .define('P', ItemRegistry.WOODEN_PARTS.get())
                .define('B', ItemTags.BANNERS)
                .pattern("PFP")
                .pattern(" B ")
                .pattern(" F ")
                .unlockedBy("has_banner", tagUnlock(ItemTags.BANNERS))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.KNIFE_REST.get())
                .define('F', ItemTags.WOODEN_FENCES)
                .define('P', ItemTags.PLANKS)
                .pattern("FFF")
                .pattern("PPP")
                .pattern("FFF")
                .unlockedBy("has_fence", tagUnlock(ItemTags.WOODEN_FENCES))
                .save(recipeConsumer);

        // FOOD

        ShapedRecipeBuilder.shaped(ItemRegistry.FOOD_HAMPER.get())
                .define('C', Items.CHEST)
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('P', ModItemTags.POLISHED_PLANKS)
                .define('B', Items.BREAD)
                .pattern("FBF")
                .pattern("PCP")
                .pattern("PCP")
                .unlockedBy(itemUnlockName(Items.CHEST), itemCriterion(Items.CHEST))
                .save(recipeConsumer);

        // ICE

        simpleStonecutting(Items.ICE, ItemRegistry.ICICLE.get(), recipeConsumer);
        simpleStonecutting(Items.ICE, ItemRegistry.LARGE_ICICLE.get(), recipeConsumer);

        // CELEBRATIONS

        ShapedRecipeBuilder.shaped(ItemRegistry.COUPLET.get(), 2)
                .define('P', ItemRegistry.XUAN_PAPER.get())
                .define('R', ItemRegistry.RED_DYE_POWDER.get())
                .define('I', Items.INK_SAC)
                .pattern("PRP")
                .pattern("PIP")
                .pattern("PRP")
                .unlockedBy(itemUnlockName(ItemRegistry.XUAN_PAPER.get()), itemCriterion(ItemRegistry.XUAN_PAPER.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.COUPLET_TOP.get())
                .define('P', ItemRegistry.XUAN_PAPER.get())
                .define('R', ItemRegistry.RED_DYE_POWDER.get())
                .define('I', Items.INK_SAC)
                .pattern("PPP")
                .pattern("RIR")
                .unlockedBy(itemUnlockName(ItemRegistry.XUAN_PAPER.get()), itemCriterion(ItemRegistry.XUAN_PAPER.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.FU_MARK.get())
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

    private static void categoryPlants(@NotNull Consumer<FinishedRecipe> recipeConsumer){

        // LOTUS

        ShapelessRecipeBuilder.shapeless(ItemRegistry.SMALL_LOTUS_LEAF.get(), 2).requires(Items.LILY_PAD).requires(Items.BIG_DRIPLEAF)
                .unlockedBy(itemUnlockName(Items.BIG_DRIPLEAF), itemCriterion(Items.LILY_PAD, Items.BIG_DRIPLEAF)).save(recipeConsumer);
        ShapelessRecipeBuilder.shapeless(ItemRegistry.SMALL_DARK_GREEN_LOTUS_LEAF.get(), 1).requires(ItemRegistry.SMALL_LOTUS_LEAF.get())
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_LOTUS_LEAF.get()), itemCriterion(ItemRegistry.SMALL_LOTUS_LEAF.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.MEDIUM_LOTUS_LEAF.get(), 1)
                .define('L', ItemRegistry.SMALL_LOTUS_LEAF.get()).pattern("LL")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_LOTUS_LEAF.get()), itemCriterion(ItemRegistry.SMALL_LOTUS_LEAF.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.LARGE_LOTUS_LEAF.get(), 1)
                .define('L', ItemRegistry.SMALL_LOTUS_LEAF.get()).pattern("LLL")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_LOTUS_LEAF.get()), itemCriterion(ItemRegistry.SMALL_LOTUS_LEAF.get())).save(recipeConsumer);
        ShapelessRecipeBuilder.shapeless(ItemRegistry.TILTED_LOTUS_LEAF.get(), 1).requires(ItemRegistry.LARGE_LOTUS_LEAF.get())
                .unlockedBy(itemUnlockName(ItemRegistry.LARGE_LOTUS_LEAF.get()), itemCriterion(ItemRegistry.LARGE_LOTUS_LEAF.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.SMALL_LOTUS_LEAF_CLUSTER.get(), 2)
                .define('L', ItemRegistry.SMALL_LOTUS_LEAF.get()).pattern("L ").pattern(" L")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_LOTUS_LEAF.get()), itemCriterion(ItemRegistry.SMALL_LOTUS_LEAF.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.MEDIUM_LOTUS_LEAF_CLUSTER.get(), 2)
                .define('L', ItemRegistry.MEDIUM_LOTUS_LEAF.get()).pattern("L ").pattern(" L")
                .unlockedBy(itemUnlockName(ItemRegistry.MEDIUM_LOTUS_LEAF.get()), itemCriterion(ItemRegistry.MEDIUM_LOTUS_LEAF.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.LOTUS_BUD.get(), 1)
                .define('L', Items.BIG_DRIPLEAF)
                .define('F', Items.SPORE_BLOSSOM)
                .pattern("F").pattern("L")
                .unlockedBy(itemUnlockName(Items.SPORE_BLOSSOM), itemCriterion(Items.SPORE_BLOSSOM)).save(recipeConsumer);
        ShapelessRecipeBuilder.shapeless(ItemRegistry.MEDIUM_LOTUS.get(), 1).requires(ItemRegistry.LOTUS_BUD.get()).requires(Items.BONE_MEAL)
                .unlockedBy(itemUnlockName(ItemRegistry.LOTUS_BUD.get()), itemCriterion(ItemRegistry.LOTUS_BUD.get())).save(recipeConsumer);

        // IVY

        blockTransform(Items.VINE, ModItemTags.FORGE_RED_DYE, ItemRegistry.SMALL_RED_IVY.get(), recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.MEDIUM_RED_IVY.get(), 1)
                .define('I', ItemRegistry.SMALL_RED_IVY.get())
                .pattern("I").pattern("I")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_RED_IVY.get()), itemCriterion(ItemRegistry.SMALL_RED_IVY.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.LARGE_RED_IVY.get(), 1)
                .define('I', ItemRegistry.SMALL_RED_IVY.get())
                .pattern("I").pattern("I").pattern("I")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_RED_IVY.get()), itemCriterion(ItemRegistry.SMALL_RED_IVY.get())).save(recipeConsumer);
        blockTransform(Items.VINE, ModItemTags.FORGE_YELLOW_DYE, ItemRegistry.SMALL_YELLOW_IVY.get(), recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.MEDIUM_YELLOW_IVY.get(), 1)
                .define('I', ItemRegistry.SMALL_YELLOW_IVY.get())
                .pattern("I").pattern("I")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_YELLOW_IVY.get()), itemCriterion(ItemRegistry.SMALL_YELLOW_IVY.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.LARGE_YELLOW_IVY.get(), 1)
                .define('I', ItemRegistry.SMALL_YELLOW_IVY.get())
                .pattern("I").pattern("I").pattern("I")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_YELLOW_IVY.get()), itemCriterion(ItemRegistry.SMALL_YELLOW_IVY.get())).save(recipeConsumer);
        blockTransform(Items.VINE, ModItemTags.FORGE_GREEN_DYE, ItemRegistry.SMALL_GREEN_IVY.get(), recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.MEDIUM_GREEN_IVY.get(), 1)
                .define('I', ItemRegistry.SMALL_GREEN_IVY.get())
                .pattern("I").pattern("I")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_GREEN_IVY.get()), itemCriterion(ItemRegistry.SMALL_GREEN_IVY.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.LARGE_GREEN_IVY.get(), 1)
                .define('I', ItemRegistry.SMALL_RED_IVY.get())
                .pattern("I").pattern("I").pattern("I")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_GREEN_IVY.get()), itemCriterion(ItemRegistry.SMALL_GREEN_IVY.get())).save(recipeConsumer);

        // LEAVES

        woodworking(Ingredient.of(ItemTags.LEAVES), ItemRegistry.SMALL_LEAF_PILE.get(), 8)
                .unlockedBy("has_leaves", tagUnlock(ItemTags.LEAVES)).save(recipeConsumer);
        woodworking(Ingredient.of(ItemTags.LEAVES), ItemRegistry.MEDIUM_LEAF_PILE.get(), 5)
                .unlockedBy("has_leaves", tagUnlock(ItemTags.LEAVES)).save(recipeConsumer);
        woodworking(Ingredient.of(ItemTags.LEAVES), ItemRegistry.LARGE_LEAF_PILE.get(), 3)
                .unlockedBy("has_leaves", tagUnlock(ItemTags.LEAVES)).save(recipeConsumer);


    }

    private static void categoryFurniture(@NotNull Consumer<FinishedRecipe> recipeConsumer){

        // CABINET

        ShapedRecipeBuilder.shaped(ItemRegistry.OAK_CABINET.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('W', ItemRegistry.POLISHED_OAK_PLANK.get())
                .define('C', Items.CHEST)
                .pattern("WWW")
                .pattern("WCW")
                .pattern("WFW")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_OAK_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_OAK_PLANK.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.WARPED_CABINET.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('W', ItemRegistry.POLISHED_WARPED_PLANK.get())
                .define('P', Items.WARPED_PLANKS)
                .define('C', Items.CHEST)
                .pattern("WWW")
                .pattern("WCW")
                .pattern("PFP")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_WARPED_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_WARPED_PLANK.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.EBONY_CABINET.get())
                .define('W', ItemRegistry.POLISHED_EBONY_PLANK.get())
                .define('G', ItemRegistry.GOLD_PARTS.get())
                .define('C', Items.CHEST)
                .pattern("GWG")
                .pattern("WCW")
                .pattern("WCW")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_WARPED_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_WARPED_PLANK.get()))
                .save(recipeConsumer);

        // TABLE

        ShapedRecipeBuilder.shaped(ItemRegistry.LARGE_TEA_TABLE.get())
                .define('P', Items.SPRUCE_PLANKS)
                .define('W', ItemRegistry.POLISHED_SPRUCE_PLANK.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('S', Items.STICK)
                .pattern("WWW")
                .pattern("PPP")
                .pattern("SFS")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_SPRUCE_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_SPRUCE_PLANK.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.CHESS_TABLE.get())
                .define('P', ItemTags.PLANKS)
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('S', Items.STICK)
                .define('B', ItemRegistry.CHESSBOARD.get())
                .pattern(" B ")
                .pattern("PPP")
                .pattern("SFS")
                .unlockedBy(itemUnlockName(ItemRegistry.CHESSBOARD.get()), itemCriterion(ItemRegistry.CHESSBOARD.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.HIGH_TABLE_WITH_WHITE_TOP.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('S', Items.STICK)
                .define('W', ItemRegistry.POLISHED_BIRCH_PLANK.get())
                .pattern(" W ")
                .pattern("SFS")
                .pattern("S S")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_BIRCH_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_BIRCH_PLANK.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.CENSER_TABLE.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('S', Items.STICK)
                .define('W', ItemRegistry.POLISHED_SPRUCE_PLANK.get())
                .define('G', ItemRegistry.GOLD_PARTS.get())
                .pattern("GWG")
                .pattern("SFS")
                .pattern("SWS")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_SPRUCE_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_SPRUCE_PLANK.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.PORCELAIN_INLAID_TABLE.get())
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

        ShapedRecipeBuilder.shaped(ItemRegistry.SMALL_TABLE.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('S', Items.STICK)
                .define('W', ModItemTags.POLISHED_PLANKS)
                .pattern(" W ")
                .pattern("SFS")
                .unlockedBy("has_polished_plank", tagUnlock(ModItemTags.POLISHED_PLANKS))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.SMALL_EBONY_TABLE.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('S', Items.STICK)
                .define('W', ItemRegistry.POLISHED_EBONY_PLANK.get())
                .pattern(" W ")
                .pattern("SFS")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_EBONY_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_EBONY_PLANK.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.LARGE_TABLE.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('S', Items.STICK)
                .define('P', ItemTags.PLANKS)
                .pattern("PPP")
                .pattern("PPP")
                .pattern("SFS")
                .unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS))
                .save(recipeConsumer);

        // CHAIR

        ShapedRecipeBuilder.shaped(ItemRegistry.EBONY_CHAIR.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('S', Items.STICK)
                .define('W', ItemRegistry.POLISHED_EBONY_PLANK.get())
                .pattern("FW ")
                .pattern("SFS")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_EBONY_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_EBONY_PLANK.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.CHAIR_WITH_YELLOW_CUSHION.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('S', Items.STICK)
                .define('C', ItemRegistry.YELLOW_CUSHION.get())
                .pattern("FC ")
                .pattern("SFS")
                .unlockedBy(itemUnlockName(ItemRegistry.YELLOW_CUSHION.get()), itemCriterion(ItemRegistry.YELLOW_CUSHION.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.PAINTED_CHAIR.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('W', ModItemTags.POLISHED_PLANKS)
                .define('A', ItemRegistry.WOODEN_PARTS.get())
                .define('P', ModItemTags.PAINTING_SCROLL_ITEMS)
                .pattern("P  ")
                .pattern("FWA")
                .pattern("WFW")
                .unlockedBy("has_painting", tagUnlock(ModItemTags.PAINTING_SCROLL_ITEMS))
                .save(recipeConsumer);

        woodworking(Ingredient.of(ItemTags.LOGS), ItemRegistry.WOODEN_STOOL.get(), 1).unlockedBy("has_log", tagUnlock(ItemTags.LOGS)).save(recipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.PORCELAIN_INLAID_GRAND_CHAIR.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('W', ItemRegistry.POLISHED_ROSEWOOD_PLANK.get())
                .define('A', ItemRegistry.WOODEN_PARTS.get())
                .define('I', ItemRegistry.PORCELAIN_PARTS.get())
                .pattern("FIA")
                .pattern("WIA")
                .pattern("WFW")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_ROSEWOOD_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_ROSEWOOD_PLANK.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.YELLOW_CUSHION.get())
                .define('W', Items.YELLOW_WOOL)
                .define('S', ItemRegistry.SILK.get())
                .pattern("SS")
                .pattern("WW")
                .unlockedBy(itemUnlockName(ItemRegistry.SILK.get()), itemCriterion(ItemRegistry.SILK.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.OAK_BED.get())
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('W', ItemRegistry.POLISHED_OAK_PLANK.get())
                .define('A', ItemRegistry.WOODEN_PARTS.get())
                .pattern("FAF")
                .pattern("WWW")
                .pattern("WFW")
                .unlockedBy(itemUnlockName(ItemRegistry.POLISHED_OAK_PLANK.get()), itemCriterion(ItemRegistry.POLISHED_OAK_PLANK.get()))
                .save(recipeConsumer);

        // SCREEN

        ShapedRecipeBuilder.shaped(ItemRegistry.LARGE_LANDSCAPE_PAINTING_SCREEN.get())
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

        ShapedRecipeBuilder.shaped(ItemRegistry.PAINTED_SCREEN.get())
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

    private static void categoryLamps(@NotNull Consumer<FinishedRecipe> recipeConsumer) {

        ShapedRecipeBuilder.shaped(Items.WHITE_CANDLE, 1)
                .define('S', Items.STRING)
                .define('G', ItemRegistry.GREASE.get())
                .pattern("S")
                .pattern("G")
                .unlockedBy(itemUnlockName(ItemRegistry.GREASE.get()), itemCriterion(ItemRegistry.GREASE.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.OCTAGONAL_PALACE_LANTERN.get(), 1)
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('P', ModItemTags.POLISHED_PLANKS)
                .define('C', ItemTags.CANDLES)
                .pattern("FPF")
                .pattern("PCP")
                .pattern("FPF")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.SQUARE_PALACE_LANTERN.get(), 1)
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .define('C', ItemTags.CANDLES)
                .pattern(" F ")
                .pattern("FCF")
                .pattern(" F ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.STANDING_LAMP.get(), 1)
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
        ShapedRecipeBuilder.shaped(ItemRegistry.SMALL_STANDING_LAMP.get(), 1)
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
        ShapedRecipeBuilder.shaped(ItemRegistry.WHITE_SKY_LANTERN.get(), 1)
                .define('X', ItemRegistry.XUAN_PAPER.get())
                .define('C', ItemTags.CANDLES)
                .define('D', Items.WHITE_DYE)
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .pattern("XDX")
                .pattern("XCX")
                .pattern(" F ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.YELLOW_SKY_LANTERN.get(), 1)
                .define('X', ItemRegistry.XUAN_PAPER.get())
                .define('C', ItemTags.CANDLES)
                .define('D', Items.YELLOW_DYE)
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .pattern("XDX")
                .pattern("XCX")
                .pattern(" F ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.RED_SKY_LANTERN.get(), 1)
                .define('X', ItemRegistry.XUAN_PAPER.get())
                .define('C', ItemTags.CANDLES)
                .define('D', Items.RED_DYE)
                .define('F', ItemRegistry.WOODEN_FRAME.get())
                .pattern("XDX")
                .pattern("XCX")
                .pattern(" F ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.SMALL_RED_LANTERN.get(), 1)
                .define('S', Items.STICK)
                .define('C', ItemTags.CANDLES)
                .define('D', Items.RED_DYE)
                .define('P', Items.PAPER)
                .pattern(" S ")
                .pattern("PCP")
                .pattern("DPD")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.STONE_LAMP.get(), 1)
                .define('S', Items.STONE)
                .define('C', ItemTags.CANDLES)
                .define('W', Items.COBBLESTONE_WALL)
                .define('T', Items.STONE_SLAB)
                .pattern(" T ")
                .pattern("WCW")
                .pattern(" S ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.RED_CANDLE.get(), 1)
                .define('C', Items.RED_CANDLE)
                .define('P', ItemRegistry.WOODEN_PARTS.get())
                .pattern("C")
                .pattern("P")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.TRICOLOR_CANDLESTICK.get(), 1)
                .define('C', Items.WHITE_CANDLE)
                .define('P', ItemRegistry.PORCELAIN_PARTS.get())
                .pattern("C")
                .pattern("P")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.JADE_CANDLESTICK.get(), 1)
                .define('C', Items.WHITE_CANDLE)
                .define('P', ItemRegistry.JADE_PARTS.get())
                .pattern("C")
                .pattern("P")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.RED_LANTERN_STREETLIGHT.get())
                .define('L', ItemTags.LOGS)
                .define('P', ItemTags.PLANKS)
                .define('R', ItemRegistry.SMALL_RED_LANTERN.get())
                .pattern("PP")
                .pattern("LR")
                .pattern("L ")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_RED_LANTERN.get()), itemCriterion(ItemRegistry.SMALL_RED_LANTERN.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.HANGING_RED_LANTERN_STREETLIGHT.get())
                .define('P', ItemTags.PLANKS)
                .define('R', ItemRegistry.SMALL_RED_LANTERN.get())
                .pattern("PPP")
                .pattern(" R ")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_RED_LANTERN.get()), itemCriterion(ItemRegistry.SMALL_RED_LANTERN.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.STREETLIGHT_POLE.get())
                .define('L', ItemTags.LOGS)
                .define('P', ItemTags.PLANKS)
                .pattern("P")
                .pattern("L")
                .pattern("L")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_RED_LANTERN.get()), itemCriterion(ItemRegistry.SMALL_RED_LANTERN.get()))
                .save(recipeConsumer);

    }

    private static void categoryWindowsDoors(@NotNull Consumer<FinishedRecipe> recipeConsumer){

        // DOOR

        woodworking(Ingredient.of(ItemTags.LOGS), ItemRegistry.CARVED_WOODEN_DOOR.get(), 1).unlockedBy("has_log", tagUnlock(ItemTags.LOGS)).save(recipeConsumer);
        woodworking(Ingredient.of(ItemTags.LOGS), ItemRegistry.SONG_WOODEN_DOOR.get(), 1).unlockedBy("has_log", tagUnlock(ItemTags.LOGS)).save(recipeConsumer);

        // WINDOW

        woodworking(Ingredient.of(ItemTags.PLANKS), ItemRegistry.SONG_WOODEN_WINDOW.get(), 1).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        woodworking(Ingredient.of(ItemRegistry.ROSEWOOD_PLANKS.get()), ItemRegistry.ROYAL_ROSEWOOD_WINDOW.get(), 1)
                .unlockedBy(itemUnlockName(ItemRegistry.ROSEWOOD_PLANKS.get()), itemCriterion(ItemRegistry.ROSEWOOD_PLANKS.get())).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.TALL_ROYAL_ROSEWOOD_WINDOW.get(), 1)
                .define('W', ItemRegistry.ROYAL_ROSEWOOD_WINDOW.get())
                .pattern("W").pattern("W")
                .unlockedBy(itemUnlockName(ItemRegistry.ROYAL_ROSEWOOD_WINDOW.get()), itemCriterion(ItemRegistry.ROYAL_ROSEWOOD_WINDOW.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.GLAZED_TILE_GRID_WINDOW.get())
                .define('G', ItemRegistry.GREEN_GLAZED_TILES.get())
                .define('I', Items.IRON_BARS)
                .pattern("GGG")
                .pattern("GIG")
                .pattern("GGG")
                .unlockedBy(itemUnlockName(ItemRegistry.GREEN_GLAZED_TILES.get()), itemCriterion(ItemRegistry.GREEN_GLAZED_TILES.get()))
                .save(recipeConsumer);
        simpleStonecutting(Items.CHISELED_STONE_BRICKS, ItemRegistry.STONE_FLOWER_WINDOW.get(), recipeConsumer);

        // DOOR DECO

        ShapedRecipeBuilder.shaped(ItemRegistry.KNOCKER.get())
                .define('I', ItemRegistry.BRONZE_INGOT.get())
                .define('P', ItemRegistry.BRONZE_PARTS.get())
                .pattern("IP")
                .unlockedBy(itemUnlockName(ItemRegistry.BRONZE_INGOT.get()), itemCriterion(ItemRegistry.BRONZE_INGOT.get()))
                .save(recipeConsumer);
        woodworking(Ingredient.of(ItemRegistry.ROSEWOOD_PLANKS.get()), ItemRegistry.ROSEWOOD_PANEL.get(), 1)
                .unlockedBy(itemUnlockName(ItemRegistry.ROSEWOOD_PLANKS.get()), itemCriterion(ItemRegistry.ROSEWOOD_PLANKS.get())).save(recipeConsumer);
        woodworking(Ingredient.of(ItemRegistry.ROSEWOOD_PLANKS.get()), ItemRegistry.ROSEWOOD_DOOR_PANEL.get(), 1)
                .unlockedBy(itemUnlockName(ItemRegistry.ROSEWOOD_PLANKS.get()), itemCriterion(ItemRegistry.ROSEWOOD_PLANKS.get())).save(recipeConsumer);
        woodworking(Ingredient.of(ItemRegistry.ROSEWOOD_PLANKS.get()), ItemRegistry.LARGE_ROSEWOOD_PANEL.get(), 1)
                .unlockedBy(itemUnlockName(ItemRegistry.ROSEWOOD_PLANKS.get()), itemCriterion(ItemRegistry.ROSEWOOD_PLANKS.get())).save(recipeConsumer);
        woodworking(Ingredient.of(ItemRegistry.ROSEWOOD_PLANKS.get()), ItemRegistry.LARGE_ROSEWOOD_PANEL_EDGE.get(), 1)
                .unlockedBy(itemUnlockName(ItemRegistry.ROSEWOOD_PLANKS.get()), itemCriterion(ItemRegistry.ROSEWOOD_PLANKS.get())).save(recipeConsumer);
        woodworking(Ingredient.of(ItemTags.PLANKS), ItemRegistry.CARVED_WOODEN_DOOR_PANEL.get(), 1).unlockedBy("has_plank", tagUnlock(ItemTags.PLANKS)).save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.PLAQUE.get())
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
        ShapedRecipeBuilder.shaped(ItemRegistry.PAPER_STRIP_SEAL.get(), 2)
                .define('P', ItemRegistry.XUAN_PAPER.get())
                .define('I', Items.INK_SAC)
                .pattern("P P")
                .pattern(" I ")
                .pattern("P P")
                .unlockedBy(itemUnlockName(ItemRegistry.XUAN_PAPER.get()), itemCriterion(ItemRegistry.XUAN_PAPER.get()))
                .save(recipeConsumer);

        // WINDOW DECO

        ShapedRecipeBuilder.shaped(ItemRegistry.SMALL_BLUE_CURTAIN.get(), 2)
                .define('S', ItemRegistry.SILK.get())
                .define('D', ItemRegistry.BLUE_DYE_POWDER.get())
                .pattern("SSS")
                .pattern("DDD")
                .unlockedBy(itemUnlockName(ItemRegistry.SILK.get()), itemCriterion(ItemRegistry.SILK.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.MEDIUM_BLUE_CURTAIN.get(), 1)
                .define('C', ItemRegistry.SMALL_BLUE_CURTAIN.get())
                .pattern("CC")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_BLUE_CURTAIN.get()), itemCriterion(ItemRegistry.SMALL_BLUE_CURTAIN.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.LARGE_BLUE_CURTAIN.get(), 1)
                .define('C', ItemRegistry.SMALL_BLUE_CURTAIN.get())
                .pattern("CCC")
                .unlockedBy(itemUnlockName(ItemRegistry.SMALL_BLUE_CURTAIN.get()), itemCriterion(ItemRegistry.SMALL_BLUE_CURTAIN.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.RED_CURTAIN.get())
                .define('S', ItemRegistry.SILK.get())
                .define('D', ItemRegistry.RED_DYE_POWDER.get())
                .define('G', ItemRegistry.GOLD_PARTS.get())
                .pattern("SSS")
                .pattern("DDD")
                .pattern(" G ")
                .unlockedBy(itemUnlockName(ItemRegistry.SILK.get()), itemCriterion(ItemRegistry.SILK.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.RED_CURTAIN_CORNER.get())
                .define('C', ItemRegistry.RED_CURTAIN.get())
                .pattern("C ")
                .pattern(" C")
                .unlockedBy(itemUnlockName(ItemRegistry.RED_CURTAIN.get()), itemCriterion(ItemRegistry.RED_CURTAIN.get()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.BAMBOO_CURTAIN.get())
                .define('B', Items.BAMBOO)
                .define('S', Items.STRING)
                .pattern("BBB")
                .pattern("SSS")
                .pattern("BBB")
                .unlockedBy(itemUnlockName(Items.BAMBOO), itemCriterion(Items.BAMBOO))
                .save(recipeConsumer);

    }

    private static void categoryMaterials(@NotNull Consumer<FinishedRecipe> recipeConsumer) {

        //BRICK

        smeltingAndBlasting(ItemRegistry.UNFIRED_RAW_CYAN_BRICK.get(), ItemRegistry.CYAN_BRICK.get(), recipeConsumer);
        smeltingAndBlasting(ItemRegistry.UNFIRED_BLACK_BRICK.get(), ItemRegistry.BLACK_BRICK.get(), recipeConsumer);
        smeltingAndBlasting(ItemRegistry.UNFIRED_RAW_BROWNISH_RED_STONE_BRICK.get(), ItemRegistry.BROWNISH_RED_STONE_BRICK.get(), recipeConsumer);

        //BRICK MATERIAL

        ShapedRecipeBuilder.shaped(ItemRegistry.UNFIRED_CLAY_BRICK.get(), 3)
                .define('C', Items.CLAY_BALL).pattern("CCC")
                .unlockedBy(itemUnlockName(Items.CLAY_BALL), itemCriterion(Items.CLAY_BALL))
                .save(recipeConsumer);
        brickMixture(ItemRegistry.UNFIRED_CLAY_BRICK.get(), 6, ItemRegistry.PRISMARINE_DUST.get(), ItemRegistry.UNFIRED_RAW_CYAN_BRICK.get(), recipeConsumer);
        brickMixture(ItemRegistry.UNFIRED_CLAY_BRICK.get(), 6, ItemRegistry.HEMATITE_DUST.get(), ItemRegistry.UNFIRED_BLACK_BRICK.get(), recipeConsumer);
        brickMixture(ItemRegistry.UNFIRED_CLAY_BRICK.get(), 6, ItemRegistry.MAGNESITE_DUST.get(), ItemRegistry.UNFIRED_RAW_BROWNISH_RED_STONE_BRICK.get(), recipeConsumer);
        smeltingAndBlasting(ItemRegistry.UNFIRED_CLAY_BRICK.get(), ItemRegistry.FIRED_BRICK.get(), recipeConsumer);
        ShapelessRecipeBuilder.shapeless(Items.BRICK, 1).requires(ItemRegistry.FIRED_BRICK.get())
                .unlockedBy("has_" + ItemRegistry.FIRED_BRICK.get(), InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.FIRED_BRICK.get())).save(recipeConsumer);

        //DUST

        dust(ItemRegistry.RAW_HEMATITE.get(), ItemRegistry.HEMATITE_DUST.get(), recipeConsumer);
        dust(ItemRegistry.MAGNESITE.get(), ItemRegistry.MAGNESITE_DUST.get(), recipeConsumer);
        dust(ItemRegistry.RAW_COBALT.get(), ItemRegistry.COBALT_DUST.get(), recipeConsumer);
        dust(Items.PRISMARINE_SHARD, ItemRegistry.PRISMARINE_DUST.get(), recipeConsumer);

        //ROOF TILE

        ShapedRecipeBuilder.shaped(ItemRegistry.UNFIRED_ROOF_TILE.get(), 2)
                .define('C', Items.CLAY_BALL).pattern("C ").pattern(" C")
                .unlockedBy(itemUnlockName(Items.CLAY_BALL), itemCriterion(Items.CLAY_BALL))
                .save(recipeConsumer);
        CompositeSmeltingRecipeBuilder.compositeSmelting(Ingredient.of(ItemRegistry.UNFIRED_ROOF_TILE.get()), Ingredient.of(ItemRegistry.GRAY_DYE_POWDER.get()),
                        ItemRegistry.GRAY_ROOF_TILE.get(), 0.05f, 20)
                .unlockedBy(itemUnlockName(ItemRegistry.UNFIRED_ROOF_TILE.get()), itemCriterion(ItemRegistry.UNFIRED_ROOF_TILE.get())).save(recipeConsumer);
        CompositeSmeltingRecipeBuilder.compositeSmelting(Ingredient.of(ItemRegistry.UNFIRED_ROOF_TILE.get()), Ingredient.of(ItemRegistry.YELLOW_DYE_POWDER.get()),
                        ItemRegistry.YELLOW_ROOF_TILE.get(), 0.05f, 20)
                .unlockedBy(itemUnlockName(ItemRegistry.UNFIRED_ROOF_TILE.get()), itemCriterion(ItemRegistry.UNFIRED_ROOF_TILE.get())).save(recipeConsumer);
        CompositeSmeltingRecipeBuilder.compositeSmelting(Ingredient.of(ItemRegistry.UNFIRED_ROOF_TILE.get()), Ingredient.of(ItemRegistry.GREEN_DYE_POWDER.get()),
                        ItemRegistry.GREEN_ROOF_TILE.get(), 0.05f, 20)
                .unlockedBy(itemUnlockName(ItemRegistry.UNFIRED_ROOF_TILE.get()), itemCriterion(ItemRegistry.UNFIRED_ROOF_TILE.get())).save(recipeConsumer);
        CompositeSmeltingRecipeBuilder.compositeSmelting(Ingredient.of(ItemRegistry.UNFIRED_ROOF_TILE.get()), Ingredient.of(ItemRegistry.BLUE_DYE_POWDER.get()),
                        ItemRegistry.BLUE_ROOF_TILE.get(), 0.05f, 20)
                .unlockedBy(itemUnlockName(ItemRegistry.UNFIRED_ROOF_TILE.get()), itemCriterion(ItemRegistry.UNFIRED_ROOF_TILE.get())).save(recipeConsumer);
        CompositeSmeltingRecipeBuilder.compositeSmelting(Ingredient.of(ItemRegistry.UNFIRED_ROOF_TILE.get()), Ingredient.of(ItemRegistry.CYAN_DYE_POWDER.get()),
                        ItemRegistry.CYAN_ROOF_TILE.get(), 0.05f, 20)
                .unlockedBy(itemUnlockName(ItemRegistry.UNFIRED_ROOF_TILE.get()), itemCriterion(ItemRegistry.UNFIRED_ROOF_TILE.get())).save(recipeConsumer);
        CompositeSmeltingRecipeBuilder.compositeSmelting(Ingredient.of(ItemRegistry.UNFIRED_ROOF_TILE.get()), Ingredient.of(ItemRegistry.BLACK_DYE_POWDER.get()),
                        ItemRegistry.BLACK_ROOF_TILE.get(), 0.05f, 20)
                .unlockedBy(itemUnlockName(ItemRegistry.UNFIRED_ROOF_TILE.get()), itemCriterion(ItemRegistry.UNFIRED_ROOF_TILE.get())).save(recipeConsumer);

        // POLISHED PLANK

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
        woodworking(Ingredient.of(ItemTags.PLANKS), ItemRegistry.WOODEN_FRAME.get(), 2, Items.OAK_PLANKS, recipeConsumer);

        // PORCELAIN dropped by porcelain blocks

        // PARTS

        woodworking(Ingredient.of(ItemTags.PLANKS), ItemRegistry.WOODEN_PARTS.get(), 2, Items.OAK_PLANKS, recipeConsumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.GOLD_INGOT), ItemRegistry.GOLD_PARTS.get(), 2)
                .unlockedBy(itemUnlockName(Items.GOLD_INGOT), itemCriterion(Items.GOLD_INGOT))
                .save(recipeConsumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.JADE.get()), ItemRegistry.JADE_PARTS.get(), 2)
                .unlockedBy(itemUnlockName(ItemRegistry.JADE.get()), itemCriterion(ItemRegistry.JADE.get()))
                .save(recipeConsumer);
        simpleStonecutting(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE.get(), ItemRegistry.PORCELAIN_PARTS.get(), recipeConsumer); //todo add porcelain variants
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.BRONZE_INGOT.get()), ItemRegistry.BRONZE_PARTS.get(), 2)
                .unlockedBy(itemUnlockName(ItemRegistry.BRONZE_INGOT.get()), itemCriterion(ItemRegistry.BRONZE_INGOT.get()))
                .save(recipeConsumer);

        // DYE POWDERS

        dyePowder(ModItemTags.FORGE_WHITE_DYE, ItemRegistry.WHITE_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.FORGE_ORANGE_DYE, ItemRegistry.ORANGE_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.FORGE_MAGENTA_DYE, ItemRegistry.MAGENTA_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.FORGE_LIGHT_BLUE_DYE, ItemRegistry.LIGHT_BLUE_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.FORGE_YELLOW_DYE, ItemRegistry.YELLOW_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.FORGE_LIME_DYE, ItemRegistry.LIME_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.FORGE_PINK_DYE, ItemRegistry.PINK_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.FORGE_GRAY_DYE, ItemRegistry.GRAY_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.FORGE_LIGHT_GRAY_DYE, ItemRegistry.LIGHT_GRAY_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.FORGE_CYAN_DYE, ItemRegistry.CYAN_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.FORGE_PURPLE_DYE, ItemRegistry.PURPLE_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.FORGE_BLUE_DYE, ItemRegistry.BLUE_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.FORGE_BROWN_DYE, ItemRegistry.BROWN_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.FORGE_GREEN_DYE, ItemRegistry.GREEN_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.FORGE_RED_DYE, ItemRegistry.RED_DYE_POWDER.get(), recipeConsumer);
        dyePowder(ModItemTags.FORGE_BLACK_DYE, ItemRegistry.BLACK_DYE_POWDER.get(), recipeConsumer);
        simpleStonecutting(Items.GOLD_NUGGET, ItemRegistry.GOLD_DYE_POWDER.get(), recipeConsumer);

        // TEMPLATES

        simpleStonecutting(Items.POLISHED_BLACKSTONE, ItemRegistry.CARVED_WOOD_TEMPLATE.get(), recipeConsumer);
        simpleStonecutting(Items.POLISHED_BLACKSTONE, ItemRegistry.FANGXIN_TEMPLATE.get(), recipeConsumer);
        simpleStonecutting(Items.POLISHED_BLACKSTONE, ItemRegistry.FANGXIN_EDGE_TEMPLATE.get(), recipeConsumer);
        simpleStonecutting(Items.POLISHED_BLACKSTONE, ItemRegistry.ZHAOTOU_TEMPLATE.get(), recipeConsumer);
        simpleStonecutting(Items.POLISHED_BLACKSTONE, ItemRegistry.GUTOU_TEMPLATE.get(), recipeConsumer);
        simpleStonecutting(Items.POLISHED_BLACKSTONE, ItemRegistry.RAFTER_TEMPLATE.get(), recipeConsumer);
        simpleStonecutting(Items.POLISHED_BLACKSTONE, ItemRegistry.RAFTER_END_TEMPLATE.get(), recipeConsumer);
        simpleStonecutting(Items.POLISHED_BLACKSTONE, ItemRegistry.ARCHITRAVE_TEMPLATE.get(), recipeConsumer);
        simpleStonecutting(Items.POLISHED_BLACKSTONE, ItemRegistry.CAIHUA_TEMPLATE.get(), recipeConsumer);

        // MATERIALS

        dust(ItemRegistry.BRONZE_INGOT.get(), ItemRegistry.BRONZE_DUST.get(), recipeConsumer);

    }

    private static void categoryTools(@NotNull Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(ItemRegistry.WOODEN_MALLET.get(), 1)
                .define('S', ItemTags.WOODEN_FENCES)
                .define('W', ItemTags.PLANKS)
                .pattern("WWW")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_fence", tagUnlock(ItemTags.FENCES))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.WOODWORKING_WORKBENCH.get(), 1)
                .define('P', ItemTags.PLANKS)
                .define('C', Items.CRAFTING_TABLE)
                .pattern("P")
                .pattern("C")
                .unlockedBy(itemUnlockName(Items.CRAFTING_TABLE), itemCriterion(Items.CRAFTING_TABLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.BRICK_KILN.get(), 1)
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
    private static InventoryChangeTrigger.TriggerInstance itemCriterion(ItemLike... item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
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

    private static void stonePolishing(Item raw, Item polished, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        String rawPath = Objects.requireNonNull(raw.getRegistryName()).getPath();
        String polishedPath = Objects.requireNonNull(polished.getRegistryName()).getPath();
        ShapedRecipeBuilder.shaped(polished, 4)
                .define('A', raw)
                .pattern("AA")
                .pattern("AA")
                .unlockedBy("has_" + rawPath, InventoryChangeTrigger.TriggerInstance.hasItems(raw))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, polishedPath + "_from_crafting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(raw), polished)
                .unlockedBy("has_" + rawPath, InventoryChangeTrigger.TriggerInstance.hasItems(raw))
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, polishedPath + "_from_stonecutting"));
    }

    private static void blockTransform(Item block, TagKey<Item> dye, Item output, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        String blockPath = Objects.requireNonNull(block.getRegistryName()).getPath();
        String outputPath = Objects.requireNonNull(output.getRegistryName()).getPath();
        ShapelessRecipeBuilder.shapeless(output).requires(block).requires(dye)
                .unlockedBy("has_" + blockPath, InventoryChangeTrigger.TriggerInstance.hasItems(block))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, outputPath));
        ShapedRecipeBuilder.shaped(output, 8)
                .define('B', block)
                .define('D', dye)
                .pattern("BBB")
                .pattern("BDB")
                .pattern("BBB")
                .unlockedBy("has_" + blockPath, InventoryChangeTrigger.TriggerInstance.hasItems(block))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, outputPath + "_batch"));
    }

    private static void blockTransform(Item block, ItemLike dye, Item output, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        String blockPath = Objects.requireNonNull(block.getRegistryName()).getPath();
        String outputPath = Objects.requireNonNull(output.getRegistryName()).getPath();
        ShapelessRecipeBuilder.shapeless(output).requires(block).requires(dye)
                .unlockedBy("has_" + blockPath, InventoryChangeTrigger.TriggerInstance.hasItems(block))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, outputPath));
        ShapedRecipeBuilder.shaped(output, 8)
                .define('B', block)
                .define('D', dye)
                .pattern("BBB")
                .pattern("BDB")
                .pattern("BBB")
                .unlockedBy("has_" + blockPath, InventoryChangeTrigger.TriggerInstance.hasItems(block))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, outputPath + "_batch"));
    }

    private static void dust(Item input, Item output, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), output)
                .unlockedBy("has_" + name(input), InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, name(output)));
    }

    private static void brickMixture(Item brick, int brickAmount, Item additive, Item output, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        String brickPath = Objects.requireNonNull(brick.getRegistryName()).getPath();
        String additivePath = Objects.requireNonNull(additive.getRegistryName()).getPath();
        String outputPath = Objects.requireNonNull(output.getRegistryName()).getPath();
        ShapelessRecipeBuilder.shapeless(output, brickAmount).requires(brick, brickAmount).requires(additive)
                .unlockedBy("has_" + brickPath, InventoryChangeTrigger.TriggerInstance.hasItems(brick))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, outputPath));
    }

    private static void smeltingAndBlasting(Item input, Item output, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        smeltingAndBlasting(input, output, 0.1f, pFinishedRecipeConsumer);
    }

    private static void smeltingAndBlasting(Item input, Item output, float exp, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), output, exp, 200)
                .unlockedBy(itemUnlockName(input), itemCriterion(input)).save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, name(output) + "_from_smelting"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(input), output, exp/2, 100)
                .unlockedBy(itemUnlockName(input), itemCriterion(input)).save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, name(output) + "_from_blasting"));
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

    private static void simpleStonecutting(Item input, Item output, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), output)
                .unlockedBy(itemUnlockName(input), itemCriterion(output))
                .save(pFinishedRecipeConsumer);
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
                .unlockedBy(itemUnlockName(planks), InventoryChangeTrigger.TriggerInstance.hasItems(planks))
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

    private static void roofTileRidgesRecipe(String color, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        IForgeRegistry<Item> ITEMS = ForgeRegistries.ITEMS;
        Item ridgeBlock, tileItem;
        tileItem = ITEMS.getValue(new ResourceLocation(DataGenerators.MOD_ID, color + "_roof_tile"));
        assert (tileItem != null);

        ridgeBlock = ITEMS.getValue(new ResourceLocation(DataGenerators.MOD_ID, color + "_roof_ridge_upper"));
        assert (ridgeBlock != null);
        ShapedRecipeBuilder.shaped(ridgeBlock, 1)
                .define('T', tileItem)
                .pattern("TTT")
                .pattern("T T")
                .unlockedBy("has_" + color + "_roof_tile", InventoryChangeTrigger.TriggerInstance.hasItems(tileItem))
                .save(pFinishedRecipeConsumer);

        Item ridgeSlabBlock = ITEMS.getValue(new ResourceLocation(DataGenerators.MOD_ID, color + "_roof_ridge_upper_slab"));
        assert (ridgeSlabBlock != null);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ridgeBlock), ridgeSlabBlock, 2)
                .unlockedBy(itemUnlockName(ridgeBlock), itemCriterion(ridgeBlock))
                .save(pFinishedRecipeConsumer);

        ridgeBlock = ITEMS.getValue(new ResourceLocation(DataGenerators.MOD_ID, color + "_roof_ridge_lower"));
        assert (ridgeBlock != null);
        ShapedRecipeBuilder.shaped(ridgeBlock, 1)
                .define('T', tileItem)
                .pattern("T T")
                .pattern("TTT")
                .unlockedBy("has_" + color + "_roof_tile", InventoryChangeTrigger.TriggerInstance.hasItems(tileItem))
                .save(pFinishedRecipeConsumer);

        ridgeBlock = ITEMS.getValue(new ResourceLocation(DataGenerators.MOD_ID, color + "_roof_ridge_connection"));
        assert (ridgeBlock != null);
        ShapedRecipeBuilder.shaped(ridgeBlock, 1)
                .define('T', tileItem)
                .pattern("TTT")
                .pattern("TTT")
                .unlockedBy("has_" + color + "_roof_tile", InventoryChangeTrigger.TriggerInstance.hasItems(tileItem))
                .save(pFinishedRecipeConsumer);

        Item ridgeMainBlock = ITEMS.getValue(new ResourceLocation(DataGenerators.MOD_ID, color + "_main_roof_ridge_connection"));
        assert (ridgeMainBlock != null);
        ShapedRecipeBuilder.shaped(ridgeMainBlock, 3)
                .define('R', ridgeBlock)
                .define('T', tileItem)
                .pattern("TTT")
                .pattern("RRR")
                .unlockedBy(itemUnlockName(ridgeBlock), InventoryChangeTrigger.TriggerInstance.hasItems(ridgeBlock))
                .save(pFinishedRecipeConsumer);

        Item ridgeMainSlabBlock = ITEMS.getValue(new ResourceLocation(DataGenerators.MOD_ID, color + "_main_roof_ridge_slab"));
        assert (ridgeMainSlabBlock != null);
        Item ridgeMainStairBlock = ITEMS.getValue(new ResourceLocation(DataGenerators.MOD_ID, color + "_main_roof_ridge_stairs"));
        assert (ridgeMainStairBlock != null);
        stoneSlabAndStairsRecipe(ridgeMainBlock, ridgeMainSlabBlock, ridgeMainStairBlock, pFinishedRecipeConsumer);

        Item ridgeMainPanelBlock = ITEMS.getValue(new ResourceLocation(DataGenerators.MOD_ID, color + "_main_roof_ridge_panel"));
        assert (ridgeMainPanelBlock != null);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ridgeMainSlabBlock), ridgeMainPanelBlock, 2)
                .unlockedBy(itemUnlockName(ridgeMainSlabBlock), itemCriterion(ridgeMainSlabBlock))
                .save(pFinishedRecipeConsumer);

        Item ridgeMainPlateBlock = ITEMS.getValue(new ResourceLocation(DataGenerators.MOD_ID, color + "_main_roof_ridge_plate"));
        assert (ridgeMainPlateBlock != null);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ridgeMainPanelBlock), ridgeMainPlateBlock, 2)
                .unlockedBy(itemUnlockName(ridgeMainPanelBlock), itemCriterion(ridgeMainPanelBlock))
                .save(pFinishedRecipeConsumer);

    }

    public static void dyePowder(TagKey<Item> dye, ItemLike powder, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        ShapelessRecipeBuilder.shapeless(powder, 4).requires(dye).unlockedBy("has_dye", InventoryChangeTrigger.TriggerInstance.hasItems(
                new ItemPredicate(dye, ImmutableSet.of(),
                        MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY,
                        EnchantmentPredicate.NONE, EnchantmentPredicate.NONE, null, NbtPredicate.ANY)))
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
            recipe.unlockedBy(itemUnlockName(input), itemCriterion(input))
                .save(pFinishedRecipeConsumer);
    }

    public static void woodworking(Ingredient ingredient, ItemLike pResult, int pCount, Item unlockItem, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        var recipe = new SingleItemRecipeBuilder(RecipeSerializerRegistry.WOODWORKING_SERIALIZER.get(), ingredient, pResult, pCount);
        recipe.unlockedBy(itemUnlockName(unlockItem), itemCriterion(unlockItem))
                .save(pFinishedRecipeConsumer);
    }

    public static void carvedWood(Item result, Ingredient[] dye, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ItemTags.LOGS), Ingredient.of(ItemRegistry.CARVED_WOOD_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.CARVED_WOOD_TEMPLATE.get()), itemCriterion(ItemRegistry.CARVED_WOOD_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    public static void fangxinWood(Item result, Ingredient[] dye, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ItemTags.LOGS), Ingredient.of(ItemRegistry.FANGXIN_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.FANGXIN_TEMPLATE.get()), itemCriterion(ItemRegistry.FANGXIN_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    public static void fangxinEdgeWood(Item result, Ingredient[] dye, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ItemTags.LOGS), Ingredient.of(ItemRegistry.FANGXIN_EDGE_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.FANGXIN_EDGE_TEMPLATE.get()), itemCriterion(ItemRegistry.FANGXIN_EDGE_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    public static void zhaotouWood(Item result, Ingredient[] dye, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ItemTags.LOGS), Ingredient.of(ItemRegistry.ZHAOTOU_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.ZHAOTOU_TEMPLATE.get()), itemCriterion(ItemRegistry.ZHAOTOU_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    public static void gutouWood(Item result, Ingredient[] dye, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ItemTags.LOGS), Ingredient.of(ItemRegistry.GUTOU_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.GUTOU_TEMPLATE.get()), itemCriterion(ItemRegistry.GUTOU_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    public static void rafter(Item result, Ingredient[] dye, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ItemTags.LOGS), Ingredient.of(ItemRegistry.RAFTER_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.RAFTER_TEMPLATE.get()), itemCriterion(ItemRegistry.RAFTER_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    public static void rafterEnd(Item result, Ingredient[] dye, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ItemTags.LOGS), Ingredient.of(ItemRegistry.RAFTER_END_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.RAFTER_END_TEMPLATE.get()), itemCriterion(ItemRegistry.RAFTER_END_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    public static void architrave(Item result, Ingredient[] dye, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ItemTags.LOGS), Ingredient.of(ItemRegistry.ARCHITRAVE_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.ARCHITRAVE_TEMPLATE.get()), itemCriterion(ItemRegistry.ARCHITRAVE_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    public static void caihua(Item result, Ingredient[] dye, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ModItemTags.POLISHED_PLANKS), Ingredient.of(ItemRegistry.CAIHUA_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.CAIHUA_TEMPLATE.get()), itemCriterion(ItemRegistry.CAIHUA_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    public static void fangxinPattern(Item result, Ingredient[] dye, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ModItemTags.POLISHED_PLANKS), Ingredient.of(ItemRegistry.FANGXIN_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.FANGXIN_TEMPLATE.get()), itemCriterion(ItemRegistry.FANGXIN_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    public static void fangxinEdgePattern(Item result, Ingredient[] dye, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ModItemTags.POLISHED_PLANKS), Ingredient.of(ItemRegistry.FANGXIN_EDGE_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.FANGXIN_EDGE_TEMPLATE.get()), itemCriterion(ItemRegistry.FANGXIN_EDGE_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    public static void zhaotouPattern(Item result, Ingredient[] dye, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ModItemTags.POLISHED_PLANKS), Ingredient.of(ItemRegistry.ZHAOTOU_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.ZHAOTOU_TEMPLATE.get()), itemCriterion(ItemRegistry.ZHAOTOU_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }


    public static CriterionTriggerInstance tagUnlock(TagKey<Item> tag){
        return InventoryChangeTrigger.TriggerInstance.hasItems(new ItemPredicate(tag, ImmutableSet.of(),
                MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY,
                EnchantmentPredicate.NONE, EnchantmentPredicate.NONE, null, NbtPredicate.ANY));
    }

    private static String name(Item item){
        return Objects.requireNonNull(item.getRegistryName()).getPath();
    }


}
