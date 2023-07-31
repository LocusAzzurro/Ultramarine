package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.ModItemTags;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeSerializerRegistry;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
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

    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> recipeConsumer) {

        //BUILDING BLOCKS
        quadComposeRecipe(ItemRegistry.CYAN_BRICK.get(), ItemRegistry.CYAN_BRICKS.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.CYAN_BRICKS.get(), ItemRegistry.CYAN_BRICK_SLAB.get(), ItemRegistry.CYAN_BRICK_STAIRS.get(), recipeConsumer);
        quadComposeRecipe(ItemRegistry.BLACK_BRICK.get(), ItemRegistry.BLACK_BRICKS.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.BLACK_BRICKS.get(), ItemRegistry.BLACK_BRICK_SLAB.get(), ItemRegistry.BLACK_BRICK_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.BLACK_BRICKS.get(), ItemRegistry.BLACK_BRICK_WALL.get(), recipeConsumer);
        quadComposeRecipe(ItemRegistry.BROWNISH_RED_STONE_BRICK.get(), ItemRegistry.BROWNISH_RED_STONE_BRICKS.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.BROWNISH_RED_STONE_BRICKS.get(), ItemRegistry.BROWNISH_RED_STONE_BRICK_SLAB.get(), ItemRegistry.BROWNISH_RED_STONE_BRICK_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.BROWNISH_RED_STONE_BRICKS.get(), ItemRegistry.BROWNISH_RED_STONE_BRICK_WALL.get(), recipeConsumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.PALE_YELLOW_STONE.get(), 2).requires(Items.STONE).requires(Items.SAND)
                .unlockedBy("has_" + Items.STONE, InventoryChangeTrigger.TriggerInstance.hasItems(Items.STONE)).save(recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.PALE_YELLOW_STONE.get(), ItemRegistry.PALE_YELLOW_STONE_SLAB.get(), ItemRegistry.PALE_YELLOW_STONE_STAIRS.get(), recipeConsumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.VARIEGATED_ROCKS.get(), 4).requires(Items.COBBLESTONE).requires(Items.GRANITE).requires(Items.DIORITE).requires(Items.ANDESITE)
                .unlockedBy("has_" + Items.COBBLESTONE, InventoryChangeTrigger.TriggerInstance.hasItems(Items.STONE)).save(recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.VARIEGATED_ROCKS.get(), ItemRegistry.VARIEGATED_ROCK_SLAB.get(), ItemRegistry.VARIEGATED_ROCK_STAIRS.get(), recipeConsumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.WEATHERED_STONE.get(), 2).requires(Items.STONE).requires(Items.GRAVEL)
                .unlockedBy("has_" + Items.STONE, InventoryChangeTrigger.TriggerInstance.hasItems(Items.STONE)).save(recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.WEATHERED_STONE.get(), ItemRegistry.WEATHERED_STONE_SLAB.get(), ItemRegistry.WEATHERED_STONE_STAIRS.get(), recipeConsumer);
        stonePolishing(ItemRegistry.WEATHERED_STONE.get(), ItemRegistry.POLISHED_WEATHERED_STONE.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.POLISHED_WEATHERED_STONE.get(), ItemRegistry.POLISHED_WEATHERED_STONE_SLAB.get(), ItemRegistry.POLISHED_WEATHERED_STONE_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.POLISHED_WEATHERED_STONE.get(), ItemRegistry.POLISHED_WEATHERED_STONE_WALL.get(), recipeConsumer);
        blockDyeing(Items.SMOOTH_STONE, Items.CYAN_DYE, ItemRegistry.CYAN_FLOOR_TILE.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.CYAN_FLOOR_TILE.get(), ItemRegistry.CYAN_FLOOR_TILE_SLAB.get(), ItemRegistry.CYAN_FLOOR_TILE_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.CYAN_FLOOR_TILE.get(), ItemRegistry.CYAN_FLOOR_TILE_WALL.get(), recipeConsumer);
        blockDyeing(ItemRegistry.CYAN_FLOOR_TILE.get(), Items.WHITE_DYE, ItemRegistry.LIGHT_CYAN_FLOOR_TILE.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.LIGHT_CYAN_FLOOR_TILE.get(), ItemRegistry.LIGHT_CYAN_FLOOR_TILE_SLAB.get(), ItemRegistry.LIGHT_CYAN_FLOOR_TILE_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.LIGHT_CYAN_FLOOR_TILE.get(), ItemRegistry.LIGHT_CYAN_FLOOR_TILE_WALL.get(), recipeConsumer);
        roofTileBlocksRecipe("gray", recipeConsumer);
        roofTileBlocksRecipe("yellow", recipeConsumer);
        roofTileBlocksRecipe("green", recipeConsumer);
        roofTileBlocksRecipe("blue", recipeConsumer);
        roofTileBlocksRecipe("cyan", recipeConsumer);
        roofTileBlocksRecipe("black", recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.GREEN_GLAZED_TILES.get(), 2)
                .define('B', Items.GREEN_GLAZED_TERRACOTTA).define('T', ItemRegistry.GREEN_ROOF_TILE.get())
                .pattern(" T ").pattern("TBT").pattern(" T ")
                .unlockedBy("has_" + Items.GREEN_GLAZED_TERRACOTTA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.GREEN_GLAZED_TERRACOTTA))
                .save(recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.GREEN_GLAZED_TILES.get(), ItemRegistry.GREEN_GLAZED_TILE_SLAB.get(), ItemRegistry.GREEN_GLAZED_TILE_STAIRS.get(), recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ItemRegistry.BAMBOO_MAT.get(), 4)
                .define('B', Items.BAMBOO).define('S', Items.STRING)
                .pattern("BSB").pattern("BSB").pattern("BSB")
                .unlockedBy("has_" + Items.BAMBOO, InventoryChangeTrigger.TriggerInstance.hasItems(Items.BAMBOO))
                .save(recipeConsumer);
        woodSlabAndStairsRecipe(ItemRegistry.BAMBOO_MAT.get(), ItemRegistry.BAMBOO_MAT_SLAB.get(), ItemRegistry.BAMBOO_MAT_STAIRS.get(), recipeConsumer);
        woodSlabAndStairsRecipe(ItemRegistry.ROSEWOOD_PLANKS.get(), ItemRegistry.ROSEWOOD_SLAB.get(), ItemRegistry.ROSEWOOD_STAIRS.get(), recipeConsumer);
        fenceRecipe(ItemRegistry.ROSEWOOD_PLANKS.get(), ItemRegistry.ROSEWOOD_FENCE.get(), recipeConsumer);

        //MATERIALS
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
        dust(ItemRegistry.RAW_HEMATITE.get(), ItemRegistry.HEMATITE_DUST.get(), recipeConsumer);
        dust(ItemRegistry.MAGNESITE.get(), ItemRegistry.MAGNESITE_DUST.get(), recipeConsumer);
        dust(Items.PRISMARINE_SHARD, ItemRegistry.PRISMARINE_DUST.get(), recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.RAW_CLAY_BRICK.get(), 3)
                .define('C', Items.CLAY_BALL).pattern("CCC")
                .unlockedBy(itemUnlockName(Items.CLAY_BALL), itemCriterion(Items.CLAY_BALL))
                .save(recipeConsumer);
        brickMixture(ItemRegistry.RAW_CLAY_BRICK.get(), 6, ItemRegistry.PRISMARINE_DUST.get(), ItemRegistry.RAW_CYAN_BRICK.get(), recipeConsumer);
        brickMixture(ItemRegistry.RAW_CLAY_BRICK.get(), 6, ItemRegistry.HEMATITE_DUST.get(), ItemRegistry.RAW_BLACK_BRICK.get(), recipeConsumer);
        brickMixture(ItemRegistry.RAW_CLAY_BRICK.get(), 6, Items.NETHER_WART, ItemRegistry.RAW_BROWNISH_RED_STONE_BRICK.get(), recipeConsumer);
        smeltingAndBlasting(ItemRegistry.RAW_CLAY_BRICK.get(), ItemRegistry.FRESH_BRICK.get(), recipeConsumer);
        smeltingAndBlasting(ItemRegistry.RAW_CYAN_BRICK.get(), ItemRegistry.CYAN_BRICK.get(), recipeConsumer);
        smeltingAndBlasting(ItemRegistry.RAW_BLACK_BRICK.get(), ItemRegistry.BLACK_BRICK.get(), recipeConsumer);
        smeltingAndBlasting(ItemRegistry.RAW_BROWNISH_RED_STONE_BRICK.get(), ItemRegistry.BROWNISH_RED_STONE_BRICK.get(), recipeConsumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BRICK).requires(ItemRegistry.FRESH_BRICK.get())
                .unlockedBy(itemUnlockName(ItemRegistry.FRESH_BRICK.get()), itemCriterion(ItemRegistry.FRESH_BRICK.get())).save(recipeConsumer);


        //LAMPS
        generateLampRecipes(recipeConsumer);
    }

    private static void generateLampRecipes(@NotNull Consumer<FinishedRecipe> recipeConsumer) {
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
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, combined, 1)
                .define('A', part)
                .pattern("AA")
                .pattern("AA")
                .unlockedBy("has_" + name(part), InventoryChangeTrigger.TriggerInstance.hasItems(part))
                .save(pFinishedRecipeConsumer);
    }

    private static void quadDecomposeRecipe(Item part, Item combined, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, part, 4).requires(combined)
                .unlockedBy("has_" + name(combined), InventoryChangeTrigger.TriggerInstance.hasItems(combined))
                .save(pFinishedRecipeConsumer);
    }

    private static void stonePolishing(Item raw, Item polished, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        String rawPath = name(raw);
        String polishedPath = name(polished);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, polished, 4)
                .define('A', raw)
                .pattern("AA")
                .pattern("AA")
                .unlockedBy("has_" + rawPath, InventoryChangeTrigger.TriggerInstance.hasItems(raw))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, polishedPath + "_from_crafting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(raw), RecipeCategory.BUILDING_BLOCKS, polished)
                .unlockedBy("has_" + rawPath, InventoryChangeTrigger.TriggerInstance.hasItems(raw))
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, polishedPath + "_from_stonecutting"));
    }

    private static void blockDyeing(Item block, Item dye, Item output, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        String blockPath = name(block);
        String dyePath = name(dye);
        String outputPath = name(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, output).requires(block).requires(dye)
                .unlockedBy("has_" + blockPath, InventoryChangeTrigger.TriggerInstance.hasItems(block))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, outputPath));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 8)
                .define('B', block)
                .define('D', dye)
                .pattern("BBB")
                .pattern("BDB")
                .pattern("BBB")
                .unlockedBy("has_" + blockPath, InventoryChangeTrigger.TriggerInstance.hasItems(block))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, outputPath + "_batch"));
    }

    private static void dust(Item input, Item output, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), RecipeCategory.MISC, output)
                .unlockedBy("has_" + name(input), InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, name(output)));
    }

    private static void brickMixture(Item brick, int brickAmount, Item additive, Item output, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        String brickPath = name(brick);
        String additivePath = name(additive);
        String outputPath = name(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output, brickAmount).requires(brick, brickAmount).requires(additive)
                .unlockedBy("has_" + brickPath, InventoryChangeTrigger.TriggerInstance.hasItems(brick))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, outputPath));
    }

    private static void smeltingAndBlasting(Item input, Item output, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.MISC, output, 0.1F, 200)
                .unlockedBy(itemUnlockName(input), itemCriterion(input)).save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, name(output) + "_from_smelting"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(input), RecipeCategory.MISC, output, 0.05F, 100)
                .unlockedBy(itemUnlockName(input), itemCriterion(input)).save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, name(output) + "_from_blasting"));
    }

    private static void stoneSlabAndStairsRecipe(Item baseBlock, Item slabBlock, Item stairBlock, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        String baseBlockPath = name(baseBlock);
        String stairsBlockPath = name(stairBlock);
        String slabBlockPath = name(slabBlock);
        String baseBlockAdvancement = "has_" + baseBlockPath;
        InventoryChangeTrigger.TriggerInstance trigger = InventoryChangeTrigger.TriggerInstance.hasItems(baseBlock);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stairBlock, 4)
                .define('B', baseBlock)
                .pattern("B  ")
                .pattern("BB ")
                .pattern("BBB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, stairsBlockPath + "_from_crafting"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, slabBlock, 6)
                .define('B', baseBlock)
                .pattern("BBB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, slabBlockPath + "_from_crafting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(baseBlock), RecipeCategory.BUILDING_BLOCKS, stairBlock)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, stairsBlockPath + "_from_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(baseBlock), RecipeCategory.BUILDING_BLOCKS, slabBlock, 2)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, slabBlockPath + "_from_stonecutting"));
    }

    private static void woodSlabAndStairsRecipe(Item baseBlock, Item slabBlock, Item stairBlock, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        String baseBlockPath = name(baseBlock);
        String stairsBlockPath = name(stairBlock);
        String slabBlockPath = name(slabBlock);
        String baseBlockAdvancement = "has_" + baseBlockPath;
        InventoryChangeTrigger.TriggerInstance trigger = InventoryChangeTrigger.TriggerInstance.hasItems(baseBlock);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stairBlock, 4)
                .define('B', baseBlock)
                .pattern("B  ")
                .pattern("BB ")
                .pattern("BBB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, stairsBlockPath + "_from_crafting"));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, slabBlock, 6)
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
        String baseBlockPath = name(baseBlock);
        String wallBlockPath = name(wallBlock);
        String baseBlockAdvancement = "has_" + baseBlockPath;
        InventoryChangeTrigger.TriggerInstance trigger = InventoryChangeTrigger.TriggerInstance.hasItems(baseBlock);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, wallBlock, 6)
                .define('B', baseBlock)
                .pattern("BBB")
                .pattern("BBB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID,wallBlockPath + "_from_crafting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(baseBlock), RecipeCategory.BUILDING_BLOCKS, wallBlock)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID,wallBlockPath + "_from_stonecutting"));
    }

    private static void fenceRecipe(Item baseBlock, Item fenceBlock, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        String baseBlockPath = name(baseBlock);
        String fenceBlockPath = name(fenceBlock);
        String baseBlockAdvancement = "has_" + baseBlockPath;
        InventoryChangeTrigger.TriggerInstance trigger = InventoryChangeTrigger.TriggerInstance.hasItems(baseBlock);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, fenceBlock, 3)
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
                .unlockedBy("has_" + name(planks), InventoryChangeTrigger.TriggerInstance.hasItems(planks))
                .save(pFinishedRecipeConsumer);
    }

    private static void roofTileBlocksRecipe(String color, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        IForgeRegistry<Item> ITEMS = ForgeRegistries.ITEMS;
        Item tileBlock, tileItem;
        tileItem = ITEMS.getValue(new ResourceLocation(DataGenerators.MOD_ID, color + "_roof_tile"));
        assert (tileItem != null);

        tileBlock = ITEMS.getValue(new ResourceLocation(DataGenerators.MOD_ID, color + "_roof_tiles"));
        assert (tileBlock != null);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, tileBlock, 1)
                .define('T', tileItem)
                .pattern("TTT")
                .unlockedBy("has_" + color + "_roof_tile", InventoryChangeTrigger.TriggerInstance.hasItems(tileItem))
                .save(pFinishedRecipeConsumer);

        tileBlock = ITEMS.getValue(new ResourceLocation(DataGenerators.MOD_ID, color + "_roof_tile_stairs"));
        assert (tileBlock != null);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, tileBlock, 1)
                .define('T', tileItem)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .unlockedBy("has_" + color + "_roof_tile", InventoryChangeTrigger.TriggerInstance.hasItems(tileItem))
                .save(pFinishedRecipeConsumer);

        tileBlock = ITEMS.getValue(new ResourceLocation(DataGenerators.MOD_ID, color + "_roof_tile_edge"));
        assert (tileBlock != null);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, tileBlock, 1)
                .define('T', tileItem)
                .pattern("T  ")
                .pattern("TTT")
                .unlockedBy("has_" + color + "_roof_tile", InventoryChangeTrigger.TriggerInstance.hasItems(tileItem))
                .save(pFinishedRecipeConsumer);
    }

    public static SingleItemRecipeBuilder woodworking(Ingredient pIngredient, ItemLike pResult) {
        return new SingleItemRecipeBuilder(RecipeCategory.BUILDING_BLOCKS, RecipeSerializerRegistry.WOODWORKING_SERIALIZER.get(), pIngredient, pResult, 1);
    }

    public static SingleItemRecipeBuilder woodworking(Ingredient pIngredient, ItemLike pResult, int pCount) {
        return new SingleItemRecipeBuilder(RecipeCategory.BUILDING_BLOCKS, RecipeSerializerRegistry.WOODWORKING_SERIALIZER.get(), pIngredient, pResult, pCount);
    }

    public static void woodworking(Item input, ItemLike pResult, int pCount, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
            var recipe = new SingleItemRecipeBuilder(RecipeCategory.BUILDING_BLOCKS, RecipeSerializerRegistry.WOODWORKING_SERIALIZER.get(), Ingredient.of(input), pResult, pCount);
            recipe.unlockedBy("has_" + name(input), InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(pFinishedRecipeConsumer);
    }

    public static void woodworking(Ingredient ingredient, ItemLike pResult, int pCount, Item unlockItem, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        var recipe = new SingleItemRecipeBuilder(RecipeCategory.BUILDING_BLOCKS, RecipeSerializerRegistry.WOODWORKING_SERIALIZER.get(), ingredient, pResult, pCount);
        recipe.unlockedBy("has_" + name(unlockItem), InventoryChangeTrigger.TriggerInstance.hasItems(unlockItem))
                .save(pFinishedRecipeConsumer);
    }

    private static String name(Item item){
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
    }

}
