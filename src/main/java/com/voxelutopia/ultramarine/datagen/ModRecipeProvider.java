package com.voxelutopia.ultramarine.datagen;

import com.google.common.collect.ImmutableSet;
import com.voxelutopia.ultramarine.data.ModItemTags;
import com.voxelutopia.ultramarine.data.recipe.ChiselTableRecipeBuilder;
import com.voxelutopia.ultramarine.data.recipe.CompositeSmeltingRecipeBuilder;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeSerializerRegistry;
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
        categoryMaterials(recipeConsumer);
        categoryTools(recipeConsumer);
        categoryLamps(recipeConsumer);

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
        brickMixture(ItemRegistry.UNFIRED_CLAY_BRICK.get(), 6, Items.NETHER_WART, ItemRegistry.UNFIRED_RAW_BROWNISH_RED_STONE_BRICK.get(), recipeConsumer);
        smeltingAndBlasting(ItemRegistry.UNFIRED_CLAY_BRICK.get(), ItemRegistry.FIRED_BRICK.get(), recipeConsumer);
        ShapelessRecipeBuilder.shapeless(Items.BRICK, 1).requires(ItemRegistry.FIRED_BRICK.get())
                .unlockedBy("has_" + ItemRegistry.FIRED_BRICK.get(), InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.FIRED_BRICK.get())).save(recipeConsumer);

        dust(ItemRegistry.RAW_HEMATITE.get(), ItemRegistry.HEMATITE_DUST.get(), recipeConsumer);
        dust(ItemRegistry.MAGNESITE.get(), ItemRegistry.MAGNESITE_DUST.get(), recipeConsumer);
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

        // PORCELAIN

        // PARTS

        woodworking(Ingredient.of(ItemTags.PLANKS), ItemRegistry.WOODEN_PARTS.get(), 2, Items.OAK_PLANKS, recipeConsumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.GOLD_INGOT), ItemRegistry.GOLD_PARTS.get(), 2)
                .unlockedBy(itemUnlockName(Items.GOLD_INGOT), itemCriterion(Items.GOLD_INGOT))
                .save(recipeConsumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ItemRegistry.JADE.get()), ItemRegistry.JADE_PARTS.get(), 2)
                .unlockedBy(itemUnlockName(ItemRegistry.JADE.get()), itemCriterion(ItemRegistry.JADE.get()))
                .save(recipeConsumer);
        simpleStonecutting(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE.get(), ItemRegistry.PORCELAIN_PARTS.get(), recipeConsumer); //todo add porcelain variants

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
    }

    private static void categoryTools(@NotNull Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(ItemRegistry.WOODEN_MALLET.get(), 1)
                .define('S', ItemTags.WOODEN_FENCES)
                .define('W', ItemTags.PLANKS)
                .pattern("WWW")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_fence", InventoryChangeTrigger.TriggerInstance.hasItems(
                        new ItemPredicate(ItemTags.WOODEN_FENCES, ImmutableSet.of(),
                                MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY,
                                EnchantmentPredicate.NONE, EnchantmentPredicate.NONE, null, NbtPredicate.ANY)))
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
        ShapedRecipeBuilder.shaped(ItemRegistry.CHISEL_TABLE.get(), 1)
                .define('A', Items.AMETHYST_SHARD)
                .define('C', Items.CRAFTING_TABLE)
                .pattern("A")
                .pattern("C")
                .unlockedBy(itemUnlockName(Items.CRAFTING_TABLE), itemCriterion(Items.CRAFTING_TABLE))
                .save(recipeConsumer);
    }

    @NotNull
    private static String itemUnlockName(ItemLike item) {
        return "has_" + item;
    }

    @NotNull
    private static InventoryChangeTrigger.TriggerInstance itemCriterion(ItemLike item) {
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
        ShapelessRecipeBuilder.shapeless(powder, 8).requires(dye).unlockedBy("has_dye", InventoryChangeTrigger.TriggerInstance.hasItems(
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
            recipe.unlockedBy("has_" + input.getRegistryName().getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(pFinishedRecipeConsumer);
    }

    public static void woodworking(Ingredient ingredient, ItemLike pResult, int pCount, Item unlockItem, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        var recipe = new SingleItemRecipeBuilder(RecipeSerializerRegistry.WOODWORKING_SERIALIZER.get(), ingredient, pResult, pCount);
        recipe.unlockedBy("has_" + unlockItem.getRegistryName().getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(unlockItem))
                .save(pFinishedRecipeConsumer);
    }

    public static void carvedWood(Item result, Ingredient[] dye, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        ChiselTableRecipeBuilder.chiselTableRecipe(Ingredient.of(ItemTags.LOGS), Ingredient.of(ItemRegistry.CHISELED_WOOD_TEMPLATE.get()), dye, result)
                .unlockedBy(itemUnlockName(ItemRegistry.CHISELED_WOOD_TEMPLATE.get()), itemCriterion(ItemRegistry.CHISELED_WOOD_TEMPLATE.get())).save(pFinishedRecipeConsumer);
    }

    private static String name(Item item){
        return Objects.requireNonNull(item.getRegistryName()).getPath();
    }


}
