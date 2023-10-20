package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeSerializerRegistry;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Objects;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> recipeConsumer) {

        //BUILDING BLOCKS
        quadComposeRecipe(ItemRegistry.CYAN_BRICK.get(), ItemRegistry.CYAN_BRICKS.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.CYAN_BRICKS.get(), ItemRegistry.CYAN_BRICK_SLAB.get(), ItemRegistry.CYAN_BRICK_STAIRS.get(), recipeConsumer);
        quadComposeRecipe(ItemRegistry.BLACK_BRICK.get(), ItemRegistry.BLACK_BRICKS.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.BLACK_BRICKS.get(), ItemRegistry.BLACK_BRICK_SLAB.get(), ItemRegistry.BLACK_BRICK_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.BLACK_BRICKS.get(), ItemRegistry.BLACK_BRICK_WALL.get(), recipeConsumer);
        quadComposeRecipe(ItemRegistry.BROWNISH_RED_STONE_BRICK.get(), ItemRegistry.BROWNISH_RED_STONE_BRICKS.get(), recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.BROWNISH_RED_STONE_BRICKS.get(), ItemRegistry.BROWNISH_RED_STONE_BRICK_SLAB.get(), ItemRegistry.BROWNISH_RED_STONE_BRICK_STAIRS.get(), recipeConsumer);
        wallRecipe(ItemRegistry.BROWNISH_RED_STONE_BRICKS.get(), ItemRegistry.BROWNISH_RED_STONE_BRICK_WALL.get(), recipeConsumer);
        ShapelessRecipeBuilder.shapeless(ItemRegistry.PALE_YELLOW_STONE.get(), 2).requires(Items.STONE).requires(Items.SAND)
                .unlockedBy("has_" + Items.STONE, InventoryChangeTrigger.Instance.hasItems(Items.STONE)).save(recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.PALE_YELLOW_STONE.get(), ItemRegistry.PALE_YELLOW_STONE_SLAB.get(), ItemRegistry.PALE_YELLOW_STONE_STAIRS.get(), recipeConsumer);
        ShapelessRecipeBuilder.shapeless(ItemRegistry.VARIEGATED_ROCKS.get(), 4).requires(Items.COBBLESTONE).requires(Items.GRANITE).requires(Items.DIORITE).requires(Items.ANDESITE)
                .unlockedBy("has_" + Items.COBBLESTONE, InventoryChangeTrigger.Instance.hasItems(Items.STONE)).save(recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.VARIEGATED_ROCKS.get(), ItemRegistry.VARIEGATED_ROCK_SLAB.get(), ItemRegistry.VARIEGATED_ROCK_STAIRS.get(), recipeConsumer);
        ShapelessRecipeBuilder.shapeless(ItemRegistry.WEATHERED_STONE.get(), 2).requires(Items.STONE).requires(Items.GRAVEL)
                .unlockedBy("has_" + Items.STONE, InventoryChangeTrigger.Instance.hasItems(Items.STONE)).save(recipeConsumer);
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
        ShapedRecipeBuilder.shaped(ItemRegistry.GREEN_GLAZED_TILES.get(), 2)
                .define('B', Items.GREEN_GLAZED_TERRACOTTA).define('T', ItemRegistry.GREEN_ROOF_TILE.get())
                .pattern(" T ").pattern("TBT").pattern(" T ")
                .unlockedBy("has_" + Items.GREEN_GLAZED_TERRACOTTA, InventoryChangeTrigger.Instance.hasItems(Items.GREEN_GLAZED_TERRACOTTA))
                .save(recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.GREEN_GLAZED_TILES.get(), ItemRegistry.GREEN_GLAZED_TILE_SLAB.get(), ItemRegistry.GREEN_GLAZED_TILE_STAIRS.get(), recipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.BAMBOO_MAT.get(), 4)
                .define('B', Items.BAMBOO).define('S', Items.STRING)
                .pattern("BSB").pattern("BSB").pattern("BSB")
                .unlockedBy("has_" + Items.BAMBOO, InventoryChangeTrigger.Instance.hasItems(Items.BAMBOO))
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
        ShapedRecipeBuilder.shaped(ItemRegistry.UNFIRED_CLAY_BRICK.get(), 3)
                .define('C', Items.CLAY_BALL).pattern("CCC")
                .unlockedBy(itemUnlockName(Items.CLAY_BALL), itemCriterion(Items.CLAY_BALL))
                .save(recipeConsumer);
        brickMixture(ItemRegistry.UNFIRED_CLAY_BRICK.get(), 6, ItemRegistry.PRISMARINE_DUST.get(), ItemRegistry.UNFIRED_RAW_CYAN_BRICK.get(), recipeConsumer);
        brickMixture(ItemRegistry.UNFIRED_CLAY_BRICK.get(), 6, ItemRegistry.HEMATITE_DUST.get(), ItemRegistry.UNFIRED_BLACK_BRICK.get(), recipeConsumer);
        brickMixture(ItemRegistry.UNFIRED_CLAY_BRICK.get(), 6, Items.NETHER_WART, ItemRegistry.UNFIRED_RAW_BROWNISH_RED_STONE_BRICK.get(), recipeConsumer);
        smeltingAndBlasting(ItemRegistry.UNFIRED_CLAY_BRICK.get(), ItemRegistry.FIRED_BRICK.get(), recipeConsumer);
        smeltingAndBlasting(ItemRegistry.UNFIRED_RAW_CYAN_BRICK.get(), ItemRegistry.CYAN_BRICK.get(), recipeConsumer);
        smeltingAndBlasting(ItemRegistry.UNFIRED_BLACK_BRICK.get(), ItemRegistry.BLACK_BRICK.get(), recipeConsumer);
        smeltingAndBlasting(ItemRegistry.UNFIRED_RAW_BROWNISH_RED_STONE_BRICK.get(), ItemRegistry.BROWNISH_RED_STONE_BRICK.get(), recipeConsumer);
        ShapelessRecipeBuilder.shapeless(Items.BRICK, 1).requires(ItemRegistry.FIRED_BRICK.get())
                .unlockedBy("has_" + ItemRegistry.FIRED_BRICK.get(), InventoryChangeTrigger.Instance.hasItems(ItemRegistry.FIRED_BRICK.get())).save(recipeConsumer);


        //LAMPS
        generateLampRecipes(recipeConsumer);
    }

    private static void generateLampRecipes(Consumer<IFinishedRecipe> recipeConsumer) {
        //ShapedRecipeBuilder.shaped(Items.WHITE_CANDLE, 1)
        //        .define('S', Items.STRING)
        //        .define('G', ItemRegistry.GREASE.get())
        //        .pattern("S")
        //        .pattern("G")
        //        .unlockedBy(itemUnlockName(ItemRegistry.GREASE.get()), itemCriterion(ItemRegistry.GREASE.get()))
        //        .save(recipeConsumer);
        //ShapedRecipeBuilder.shaped(ItemRegistry.OCTAGONAL_PALACE_LANTERN.get(), 1)
        //        .define('F', ItemRegistry.WOODEN_FRAME.get())
        //        .define('P', ModItemTags.POLISHED_PLANKS)
        //        .define('C', ItemTags.CANDLES)
        //        .pattern("FPF")
        //        .pattern("PCP")
        //        .pattern("FPF")
        //        .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
        //        .save(recipeConsumer);
        //ShapedRecipeBuilder.shaped(ItemRegistry.SQUARE_PALACE_LANTERN.get(), 1)
        //        .define('F', ItemRegistry.WOODEN_FRAME.get())
        //        .define('C', ItemTags.CANDLES)
        //        .pattern(" F ")
        //        .pattern("FCF")
        //        .pattern(" F ")
        //        .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
        //        .save(recipeConsumer);
        //ShapedRecipeBuilder.shaped(ItemRegistry.STANDING_LAMP.get(), 1)
        //        .define('X', ItemRegistry.XUAN_PAPER.get())
        //        .define('C', ItemTags.CANDLES)
        //        .define('W', ItemTags.PLANKS)
        //        .define('F', ItemRegistry.WOODEN_FRAME.get())
        //        .define('P', ItemRegistry.WOODEN_PARTS.get())
        //        .pattern("XCX")
        //        .pattern("PFP")
        //        .pattern(" W ")
        //        .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
        //        .save(recipeConsumer);
        //ShapedRecipeBuilder.shaped(ItemRegistry.SMALL_STANDING_LAMP.get(), 1)
        //        .define('X', ItemRegistry.XUAN_PAPER.get())
        //        .define('C', ItemTags.CANDLES)
        //        .define('W', Items.STICK)
        //        .define('F', ItemRegistry.WOODEN_FRAME.get())
        //        .define('P', ItemRegistry.WOODEN_PARTS.get())
        //        .pattern("XCX")
        //        .pattern("PFP")
        //        .pattern(" W ")
        //        .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
        //        .save(recipeConsumer);
        //ShapedRecipeBuilder.shaped(ItemRegistry.WHITE_SKY_LANTERN.get(), 1)
        //        .define('X', ItemRegistry.XUAN_PAPER.get())
        //        .define('C', ItemTags.CANDLES)
        //        .define('D', Items.WHITE_DYE)
        //        .define('F', ItemRegistry.WOODEN_FRAME.get())
        //        .pattern("XDX")
        //        .pattern("XCX")
        //        .pattern(" F ")
        //        .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
        //        .save(recipeConsumer);
        //ShapedRecipeBuilder.shaped(ItemRegistry.YELLOW_SKY_LANTERN.get(), 1)
        //        .define('X', ItemRegistry.XUAN_PAPER.get())
        //        .define('C', ItemTags.CANDLES)
        //        .define('D', Items.YELLOW_DYE)
        //        .define('F', ItemRegistry.WOODEN_FRAME.get())
        //        .pattern("XDX")
        //        .pattern("XCX")
        //        .pattern(" F ")
        //        .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
        //        .save(recipeConsumer);
        //ShapedRecipeBuilder.shaped(ItemRegistry.RED_SKY_LANTERN.get(), 1)
        //        .define('X', ItemRegistry.XUAN_PAPER.get())
        //        .define('C', ItemTags.CANDLES)
        //        .define('D', Items.RED_DYE)
        //        .define('F', ItemRegistry.WOODEN_FRAME.get())
        //        .pattern("XDX")
        //        .pattern("XCX")
        //        .pattern(" F ")
        //        .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
        //        .save(recipeConsumer);
        //ShapedRecipeBuilder.shaped(ItemRegistry.SMALL_RED_LANTERN.get(), 1)
        //        .define('S', Items.STICK)
        //        .define('C', ItemTags.CANDLES)
        //        .define('D', Items.RED_DYE)
        //        .define('P', Items.PAPER)
        //        .pattern(" S ")
        //        .pattern("PCP")
        //        .pattern("DPD")
        //        .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
        //        .save(recipeConsumer);
        //ShapedRecipeBuilder.shaped(ItemRegistry.STONE_LAMP.get(), 1)
        //        .define('S', Items.STONE)
        //        .define('C', ItemTags.CANDLES)
        //        .define('W', Items.COBBLESTONE_WALL)
        //        .define('T', Items.STONE_SLAB)
        //        .pattern(" T ")
        //        .pattern("WCW")
        //        .pattern(" S ")
        //        .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
        //        .save(recipeConsumer);
        //ShapedRecipeBuilder.shaped(ItemRegistry.RED_CANDLE.get(), 1)
        //        .define('C', Items.RED_CANDLE)
        //        .define('P', ItemRegistry.WOODEN_PARTS.get())
        //        .pattern("C")
        //        .pattern("P")
        //        .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
        //        .save(recipeConsumer);
        //ShapedRecipeBuilder.shaped(ItemRegistry.TRICOLOR_CANDLESTICK.get(), 1)
        //        .define('C', Items.WHITE_CANDLE)
        //        .define('P', ItemRegistry.PORCELAIN_PARTS.get())
        //        .pattern("C")
        //        .pattern("P")
        //        .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
        //        .save(recipeConsumer);
        //ShapedRecipeBuilder.shaped(ItemRegistry.JADE_CANDLESTICK.get(), 1)
        //        .define('C', Items.WHITE_CANDLE)
        //        .define('P', ItemRegistry.JADE_PARTS.get())
        //        .pattern("C")
        //        .pattern("P")
        //        .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
        //        .save(recipeConsumer);
    }


    private static String itemUnlockName(IItemProvider item) {
        return "has_" + item;
    }


    private static InventoryChangeTrigger.Instance itemCriterion(IItemProvider item) {
        return InventoryChangeTrigger.Instance.hasItems(item);
    }

    @SuppressWarnings("null")
    private static void quadComposeRecipe(Item part, Item combined, Consumer<IFinishedRecipe> pFinishedRecipeConsumer) {
        assert part.getRegistryName() != null;
        ShapedRecipeBuilder.shaped(combined, 1)
                .define('A', part)
                .pattern("AA")
                .pattern("AA")
                .unlockedBy("has_" + part.getRegistryName().getPath(), InventoryChangeTrigger.Instance.hasItems(part))
                .save(pFinishedRecipeConsumer);
    }

    private static void quadDecomposeRecipe(Item part, Item combined, Consumer<IFinishedRecipe> pFinishedRecipeConsumer) {
        assert combined.getRegistryName() != null;
        ShapelessRecipeBuilder.shapeless(part, 4).requires(combined)
                .unlockedBy("has_" + combined.getRegistryName().getPath(), InventoryChangeTrigger.Instance.hasItems(combined))
                .save(pFinishedRecipeConsumer);
    }

    private static void stonePolishing(Item raw, Item polished, Consumer<IFinishedRecipe> pFinishedRecipeConsumer) {
        String rawPath = Objects.requireNonNull(raw.getRegistryName()).getPath();
        String polishedPath = Objects.requireNonNull(polished.getRegistryName()).getPath();
        ShapedRecipeBuilder.shaped(polished, 4)
                .define('A', raw)
                .pattern("AA")
                .pattern("AA")
                .unlockedBy("has_" + rawPath, InventoryChangeTrigger.Instance.hasItems(raw))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, polishedPath + "_from_crafting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(raw), polished)
                .unlocks("has_" + rawPath, InventoryChangeTrigger.Instance.hasItems(raw))
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, polishedPath + "_from_stonecutting"));
    }

    private static void blockDyeing(Item block, Item dye, Item output, Consumer<IFinishedRecipe> pFinishedRecipeConsumer) {
        String blockPath = Objects.requireNonNull(block.getRegistryName()).getPath();
        String dyePath = Objects.requireNonNull(dye.getRegistryName()).getPath();
        String outputPath = Objects.requireNonNull(output.getRegistryName()).getPath();
        ShapelessRecipeBuilder.shapeless(output).requires(block).requires(dye)
                .unlockedBy("has_" + blockPath, InventoryChangeTrigger.Instance.hasItems(block))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, outputPath));
        ShapedRecipeBuilder.shaped(output, 8)
                .define('B', block)
                .define('D', dye)
                .pattern("BBB")
                .pattern("BDB")
                .pattern("BBB")
                .unlockedBy("has_" + blockPath, InventoryChangeTrigger.Instance.hasItems(block))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, outputPath + "_batch"));
    }

    private static void dust(Item input, Item output, Consumer<IFinishedRecipe> pFinishedRecipeConsumer) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), output)
                .unlocks("has_" + name(input), InventoryChangeTrigger.Instance.hasItems(input))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, name(output)));
    }

    private static void brickMixture(Item brick, int brickAmount, Item additive, Item output, Consumer<IFinishedRecipe> pFinishedRecipeConsumer) {
        String brickPath = Objects.requireNonNull(brick.getRegistryName()).getPath();
        String additivePath = Objects.requireNonNull(additive.getRegistryName()).getPath();
        String outputPath = Objects.requireNonNull(output.getRegistryName()).getPath();
        ShapelessRecipeBuilder.shapeless(output, brickAmount).requires(brick, brickAmount).requires(additive)
                .unlockedBy("has_" + brickPath, InventoryChangeTrigger.Instance.hasItems(brick))
                .save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, outputPath));
    }

    private static void smeltingAndBlasting(Item input, Item output, Consumer<IFinishedRecipe> pFinishedRecipeConsumer) {
        CookingRecipeBuilder.smelting(Ingredient.of(input), output, 0.1F, 200)
                .unlockedBy(itemUnlockName(input), itemCriterion(input)).save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, name(output) + "_from_smelting"));
        CookingRecipeBuilder.blasting(Ingredient.of(input), output, 0.05F, 100)
                .unlockedBy(itemUnlockName(input), itemCriterion(input)).save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, name(output) + "_from_blasting"));
    }

    private static void stoneSlabAndStairsRecipe(Item baseBlock, Item slabBlock, Item stairBlock, Consumer<IFinishedRecipe> pFinishedRecipeConsumer) {
        String baseBlockPath = Objects.requireNonNull(baseBlock.getRegistryName()).getPath();
        String stairsBlockPath = Objects.requireNonNull(stairBlock.getRegistryName()).getPath();
        String slabBlockPath = Objects.requireNonNull(slabBlock.getRegistryName()).getPath();
        String baseBlockAdvancement = "has_" + baseBlockPath;
        InventoryChangeTrigger.Instance trigger = InventoryChangeTrigger.Instance.hasItems(baseBlock);

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
                .unlocks(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, stairsBlockPath + "_from_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(baseBlock), slabBlock, 2)
                .unlocks(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, slabBlockPath + "_from_stonecutting"));
    }

    private static void woodSlabAndStairsRecipe(Item baseBlock, Item slabBlock, Item stairBlock, Consumer<IFinishedRecipe> pFinishedRecipeConsumer) {
        String baseBlockPath = Objects.requireNonNull(baseBlock.getRegistryName()).getPath();
        String stairsBlockPath = Objects.requireNonNull(stairBlock.getRegistryName()).getPath();
        String slabBlockPath = Objects.requireNonNull(slabBlock.getRegistryName()).getPath();
        String baseBlockAdvancement = "has_" + baseBlockPath;
        InventoryChangeTrigger.Instance trigger = InventoryChangeTrigger.Instance.hasItems(baseBlock);

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
                .unlocks(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, stairsBlockPath + "_from_woodworking"));
        woodworking(Ingredient.of(baseBlock), slabBlock, 2)
                .unlocks(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, slabBlockPath + "_from_woodworking"));
    }


    private static void wallRecipe(Item baseBlock, Item wallBlock, Consumer<IFinishedRecipe> pFinishedRecipeConsumer) {
        String baseBlockPath = Objects.requireNonNull(baseBlock.getRegistryName()).getPath();
        String wallBlockPath = Objects.requireNonNull(wallBlock.getRegistryName()).getPath();
        String baseBlockAdvancement = "has_" + baseBlockPath;
        InventoryChangeTrigger.Instance trigger = InventoryChangeTrigger.Instance.hasItems(baseBlock);
        ShapedRecipeBuilder.shaped(wallBlock, 6)
                .define('B', baseBlock)
                .pattern("BBB")
                .pattern("BBB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, wallBlockPath + "_from_crafting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(baseBlock), wallBlock)
                .unlocks(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, wallBlockPath + "_from_stonecutting"));
    }

    private static void fenceRecipe(Item baseBlock, Item fenceBlock, Consumer<IFinishedRecipe> pFinishedRecipeConsumer) {
        String baseBlockPath = Objects.requireNonNull(baseBlock.getRegistryName()).getPath();
        String fenceBlockPath = Objects.requireNonNull(fenceBlock.getRegistryName()).getPath();
        String baseBlockAdvancement = "has_" + baseBlockPath;
        InventoryChangeTrigger.Instance trigger = InventoryChangeTrigger.Instance.hasItems(baseBlock);
        ShapedRecipeBuilder.shaped(fenceBlock, 3)
                .define('B', baseBlock)
                .define('S', Items.STICK)
                .pattern("BSB")
                .pattern("BSB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, fenceBlockPath + "_from_crafting"));
        woodworking(Ingredient.of(baseBlock), fenceBlock)
                .unlocks(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(DataGenerators.MOD_ID, fenceBlockPath + "_from_woodworking"));
    }

    private static void polishedPlankRecipe(Item planks, Item polishedPlank, Consumer<IFinishedRecipe> pFinishedRecipeConsumer) {
        woodworking(Ingredient.of(planks), polishedPlank, 2)
                .unlocks("has_" + planks.getRegistryName().getPath(), InventoryChangeTrigger.Instance.hasItems(planks));
        //.save(pFinishedRecipeConsumer);
    }

    private static void roofTileBlocksRecipe(String color, Consumer<IFinishedRecipe> pFinishedRecipeConsumer) {
        IForgeRegistry<Item> ITEMS = ForgeRegistries.ITEMS;
        Item tileBlock, tileItem;
        tileItem = ITEMS.getValue(new ResourceLocation(DataGenerators.MOD_ID, color + "_roof_tile"));
        assert (tileItem != null);

        tileBlock = ITEMS.getValue(new ResourceLocation(DataGenerators.MOD_ID, color + "_roof_tiles"));
        assert (tileBlock != null);
        ShapedRecipeBuilder.shaped(tileBlock, 1)
                .define('T', tileItem)
                .pattern("TTT")
                .unlockedBy("has_" + color + "_roof_tile", InventoryChangeTrigger.Instance.hasItems(tileItem))
                .save(pFinishedRecipeConsumer);

        tileBlock = ITEMS.getValue(new ResourceLocation(DataGenerators.MOD_ID, color + "_roof_tile_stairs"));
        assert (tileBlock != null);
        ShapedRecipeBuilder.shaped(tileBlock, 1)
                .define('T', tileItem)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .unlockedBy("has_" + color + "_roof_tile", InventoryChangeTrigger.Instance.hasItems(tileItem))
                .save(pFinishedRecipeConsumer);

        tileBlock = ITEMS.getValue(new ResourceLocation(DataGenerators.MOD_ID, color + "_roof_tile_edge"));
        assert (tileBlock != null);
        ShapedRecipeBuilder.shaped(tileBlock, 1)
                .define('T', tileItem)
                .pattern("T  ")
                .pattern("TTT")
                .unlockedBy("has_" + color + "_roof_tile", InventoryChangeTrigger.Instance.hasItems(tileItem))
                .save(pFinishedRecipeConsumer);
    }

    public static SingleItemRecipeBuilder woodworking(Ingredient pIngredient, IItemProvider pResult) {
        return new SingleItemRecipeBuilder(RecipeSerializerRegistry.WOODWORKING_SERIALIZER.get(), pIngredient, pResult, 1);
    }

    public static SingleItemRecipeBuilder woodworking(Ingredient pIngredient, IItemProvider pResult, int pCount) {
        return new SingleItemRecipeBuilder(RecipeSerializerRegistry.WOODWORKING_SERIALIZER.get(), pIngredient, pResult, pCount);
    }

    public static void woodworking(Item input, IItemProvider pResult, int pCount, Consumer<IFinishedRecipe> pFinishedRecipeConsumer) {
        SingleItemRecipeBuilder recipe = new SingleItemRecipeBuilder(RecipeSerializerRegistry.WOODWORKING_SERIALIZER.get(), Ingredient.of(input), pResult, pCount);
        recipe.unlocks("has_" + input.getRegistryName().getPath(), InventoryChangeTrigger.Instance.hasItems(input));
        //.save(pFinishedRecipeConsumer);
    }

    public static void woodworking(Ingredient ingredient, IItemProvider pResult, int pCount, Item unlockItem, Consumer<IFinishedRecipe> pFinishedRecipeConsumer) {
        SingleItemRecipeBuilder recipe = new SingleItemRecipeBuilder(RecipeSerializerRegistry.WOODWORKING_SERIALIZER.get(), ingredient, pResult, pCount);
        recipe.unlocks("has_" + unlockItem.getRegistryName().getPath(), InventoryChangeTrigger.Instance.hasItems(unlockItem));
        //.save(pFinishedRecipeConsumer);
    }
    // TODO: Commented these saves. Influence?

    private static String name(Item item) {
        return Objects.requireNonNull(item.getRegistryName()).getPath();
    }

}
