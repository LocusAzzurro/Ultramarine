package com.voxelutopia.ultramarine.init.datagen;

import com.voxelutopia.ultramarine.init.data.ModItemTags;
import com.voxelutopia.ultramarine.init.registry.ItemRegistry;
import com.voxelutopia.ultramarine.init.registry.RecipeSerializerRegistry;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
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
    public void buildRecipes(@NotNull Consumer<FinishedRecipe> recipeConsumer) {

        //BUILDING BLOCKS
        quadComposeRecipe(ItemRegistry.CYAN_BRICK, ItemRegistry.CYAN_BRICKS, recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.CYAN_BRICKS, ItemRegistry.CYAN_BRICK_SLAB, ItemRegistry.CYAN_BRICK_STAIRS, recipeConsumer);
        quadComposeRecipe(ItemRegistry.BLACK_BRICK, ItemRegistry.BLACK_BRICKS, recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.BLACK_BRICKS, ItemRegistry.BLACK_BRICK_SLAB, ItemRegistry.BLACK_BRICK_STAIRS, recipeConsumer);
        wallRecipe(ItemRegistry.BLACK_BRICKS, ItemRegistry.BLACK_BRICK_WALL, recipeConsumer);
        quadComposeRecipe(ItemRegistry.BROWNISH_RED_STONE_BRICK, ItemRegistry.BROWNISH_RED_STONE_BRICKS, recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.BROWNISH_RED_STONE_BRICKS, ItemRegistry.BROWNISH_RED_STONE_BRICK_SLAB, ItemRegistry.BROWNISH_RED_STONE_BRICK_STAIRS, recipeConsumer);
        wallRecipe(ItemRegistry.BROWNISH_RED_STONE_BRICKS, ItemRegistry.BROWNISH_RED_STONE_BRICK_WALL, recipeConsumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistry.PALE_YELLOW_STONE, 2).requires(Items.STONE).requires(Items.SAND)
                .unlockedBy("has_" + Items.STONE, InventoryChangeTrigger.TriggerInstance.hasItems(Items.STONE)).save(recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.PALE_YELLOW_STONE, ItemRegistry.PALE_YELLOW_STONE_SLAB, ItemRegistry.PALE_YELLOW_STONE_STAIRS, recipeConsumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ItemRegistry.VARIEGATED_ROCKS, 4).requires(Items.COBBLESTONE).requires(Items.GRANITE).requires(Items.DIORITE).requires(Items.ANDESITE)
                .unlockedBy("has_" + Items.COBBLESTONE, InventoryChangeTrigger.TriggerInstance.hasItems(Items.STONE)).save(recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.VARIEGATED_ROCKS, ItemRegistry.VARIEGATED_ROCK_SLAB, ItemRegistry.VARIEGATED_ROCK_STAIRS, recipeConsumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ItemRegistry.WEATHERED_STONE, 2).requires(Items.STONE).requires(Items.GRAVEL)
                .unlockedBy("has_" + Items.STONE, InventoryChangeTrigger.TriggerInstance.hasItems(Items.STONE)).save(recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.WEATHERED_STONE, ItemRegistry.WEATHERED_STONE_SLAB, ItemRegistry.WEATHERED_STONE_STAIRS, recipeConsumer);
        stonePolishing(ItemRegistry.WEATHERED_STONE, ItemRegistry.POLISHED_WEATHERED_STONE, recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.POLISHED_WEATHERED_STONE, ItemRegistry.POLISHED_WEATHERED_STONE_SLAB, ItemRegistry.POLISHED_WEATHERED_STONE_STAIRS, recipeConsumer);
        wallRecipe(ItemRegistry.POLISHED_WEATHERED_STONE, ItemRegistry.POLISHED_WEATHERED_STONE_WALL, recipeConsumer);
        blockDyeing(Items.SMOOTH_STONE, Items.CYAN_DYE, ItemRegistry.CYAN_FLOOR_TILE, recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.CYAN_FLOOR_TILE, ItemRegistry.CYAN_FLOOR_TILE_SLAB, ItemRegistry.CYAN_FLOOR_TILE_STAIRS, recipeConsumer);
        wallRecipe(ItemRegistry.CYAN_FLOOR_TILE, ItemRegistry.CYAN_FLOOR_TILE_WALL, recipeConsumer);
        blockDyeing(ItemRegistry.CYAN_FLOOR_TILE, Items.WHITE_DYE, ItemRegistry.LIGHT_CYAN_FLOOR_TILE, recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.LIGHT_CYAN_FLOOR_TILE, ItemRegistry.LIGHT_CYAN_FLOOR_TILE_SLAB, ItemRegistry.LIGHT_CYAN_FLOOR_TILE_STAIRS, recipeConsumer);
        wallRecipe(ItemRegistry.LIGHT_CYAN_FLOOR_TILE, ItemRegistry.LIGHT_CYAN_FLOOR_TILE_WALL, recipeConsumer);
        roofTileBlocksRecipe("gray", recipeConsumer);
        roofTileBlocksRecipe("yellow", recipeConsumer);
        roofTileBlocksRecipe("green", recipeConsumer);
        roofTileBlocksRecipe("blue", recipeConsumer);
        roofTileBlocksRecipe("cyan", recipeConsumer);
        roofTileBlocksRecipe("black", recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.GREEN_GLAZED_TILES, 2)
                .define('B', Items.GREEN_GLAZED_TERRACOTTA).define('T', ItemRegistry.GREEN_ROOF_TILE)
                .pattern(" T ").pattern("TBT").pattern(" T ")
                .unlockedBy("has_" + Items.GREEN_GLAZED_TERRACOTTA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.GREEN_GLAZED_TERRACOTTA))
                .save(recipeConsumer);
        stoneSlabAndStairsRecipe(ItemRegistry.GREEN_GLAZED_TILES, ItemRegistry.GREEN_GLAZED_TILE_SLAB, ItemRegistry.GREEN_GLAZED_TILE_STAIRS, recipeConsumer);

        ShapedRecipeBuilder.shaped(ItemRegistry.BAMBOO_MAT, 4)
                .define('B', Items.BAMBOO).define('S', Items.STRING)
                .pattern("BSB").pattern("BSB").pattern("BSB")
                .unlockedBy("has_" + Items.BAMBOO, InventoryChangeTrigger.TriggerInstance.hasItems(Items.BAMBOO))
                .save(recipeConsumer);
        woodSlabAndStairsRecipe(ItemRegistry.BAMBOO_MAT, ItemRegistry.BAMBOO_MAT_SLAB, ItemRegistry.BAMBOO_MAT_STAIRS, recipeConsumer);
        woodSlabAndStairsRecipe(ItemRegistry.ROSEWOOD_PLANKS, ItemRegistry.ROSEWOOD_SLAB, ItemRegistry.ROSEWOOD_STAIRS, recipeConsumer);
        fenceRecipe(ItemRegistry.ROSEWOOD_PLANKS, ItemRegistry.ROSEWOOD_FENCE, recipeConsumer);

        //MATERIALS
        woodworking(Ingredient.of(ItemTags.PLANKS), ItemRegistry.WOODEN_FRAME, 2, Items.OAK_PLANKS, recipeConsumer);
        polishedPlankRecipe(Items.OAK_PLANKS, ItemRegistry.POLISHED_OAK_PLANK, recipeConsumer);
        polishedPlankRecipe(Items.BIRCH_PLANKS, ItemRegistry.POLISHED_BIRCH_PLANK, recipeConsumer);
        polishedPlankRecipe(Items.SPRUCE_PLANKS, ItemRegistry.POLISHED_SPRUCE_PLANK, recipeConsumer);
        polishedPlankRecipe(Items.JUNGLE_PLANKS, ItemRegistry.POLISHED_JUNGLE_PLANK, recipeConsumer);
        polishedPlankRecipe(Items.ACACIA_PLANKS, ItemRegistry.POLISHED_ACACIA_PLANK, recipeConsumer);
        polishedPlankRecipe(Items.DARK_OAK_PLANKS, ItemRegistry.POLISHED_DARK_OAK_PLANK, recipeConsumer);
        polishedPlankRecipe(Items.CRIMSON_PLANKS, ItemRegistry.POLISHED_CRIMSON_PLANK, recipeConsumer);
        polishedPlankRecipe(Items.WARPED_PLANKS, ItemRegistry.POLISHED_WARPED_PLANK, recipeConsumer);
        polishedPlankRecipe(ItemRegistry.ROSEWOOD_PLANKS, ItemRegistry.POLISHED_ROSEWOOD_PLANK, recipeConsumer);
        //polishedPlankRecipe(ItemRegistry.EBONY_PLANKS, ItemRegistry.POLISHED_EBONY_PLANK, recipeConsumer);
        dust(ItemRegistry.RAW_HEMATITE, ItemRegistry.HEMATITE_DUST, recipeConsumer);
        dust(ItemRegistry.MAGNESITE, ItemRegistry.MAGNESITE_DUST, recipeConsumer);
        dust(Items.PRISMARINE_SHARD, ItemRegistry.PRISMARINE_DUST, recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.UNFIRED_CLAY_BRICK, 3)
                .define('C', Items.CLAY_BALL).pattern("CCC")
                .unlockedBy(itemUnlockName(Items.CLAY_BALL), itemCriterion(Items.CLAY_BALL))
                .save(recipeConsumer);
        brickMixture(ItemRegistry.UNFIRED_CLAY_BRICK, 6, ItemRegistry.PRISMARINE_DUST, ItemRegistry.UNFIRED_RAW_CYAN_BRICK, recipeConsumer);
        brickMixture(ItemRegistry.UNFIRED_CLAY_BRICK, 6, ItemRegistry.HEMATITE_DUST, ItemRegistry.UNFIRED_BLACK_BRICK, recipeConsumer);
        brickMixture(ItemRegistry.UNFIRED_CLAY_BRICK, 6, Items.NETHER_WART, ItemRegistry.UNFIRED_RAW_BROWNISH_RED_STONE_BRICK, recipeConsumer);
        smeltingAndBlasting(ItemRegistry.UNFIRED_CLAY_BRICK, ItemRegistry.FIRED_BRICK, recipeConsumer);
        smeltingAndBlasting(ItemRegistry.UNFIRED_RAW_CYAN_BRICK, ItemRegistry.CYAN_BRICK, recipeConsumer);
        smeltingAndBlasting(ItemRegistry.UNFIRED_BLACK_BRICK, ItemRegistry.BLACK_BRICK, recipeConsumer);
        smeltingAndBlasting(ItemRegistry.UNFIRED_RAW_BROWNISH_RED_STONE_BRICK, ItemRegistry.BROWNISH_RED_STONE_BRICK, recipeConsumer);
        ShapelessRecipeBuilder.shapeless(Items.BRICK, 1).requires(ItemRegistry.FIRED_BRICK)
                .unlockedBy("has_" + ItemRegistry.FIRED_BRICK, InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.FIRED_BRICK)).save(recipeConsumer);


        //LAMPS
        generateLampRecipes(recipeConsumer);
    }

    private static void generateLampRecipes(@NotNull Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,Items.WHITE_CANDLE, 1)
                .define('S', Items.STRING)
                .define('G', ItemRegistry.GREASE)
                .pattern("S")
                .pattern("G")
                .unlockedBy(itemUnlockName(ItemRegistry.GREASE), itemCriterion(ItemRegistry.GREASE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ItemRegistry.OCTAGONAL_PALACE_LANTERN, 1)
                .define('F', ItemRegistry.WOODEN_FRAME)
                .define('P', ModItemTags.POLISHED_PLANKS)
                .define('C', ItemTags.CANDLES)
                .pattern("FPF")
                .pattern("PCP")
                .pattern("FPF")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ItemRegistry.SQUARE_PALACE_LANTERN, 1)
                .define('F', ItemRegistry.WOODEN_FRAME)
                .define('C', ItemTags.CANDLES)
                .pattern(" F ")
                .pattern("FCF")
                .pattern(" F ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ItemRegistry.STANDING_LAMP, 1)
                .define('X', ItemRegistry.XUAN_PAPER)
                .define('C', ItemTags.CANDLES)
                .define('W', ItemTags.PLANKS)
                .define('F', ItemRegistry.WOODEN_FRAME)
                .define('P', ItemRegistry.WOODEN_PARTS)
                .pattern("XCX")
                .pattern("PFP")
                .pattern(" W ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.SMALL_STANDING_LAMP, 1)
                .define('X', ItemRegistry.XUAN_PAPER)
                .define('C', ItemTags.CANDLES)
                .define('W', Items.STICK)
                .define('F', ItemRegistry.WOODEN_FRAME)
                .define('P', ItemRegistry.WOODEN_PARTS)
                .pattern("XCX")
                .pattern("PFP")
                .pattern(" W ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.WHITE_SKY_LANTERN, 1)
                .define('X', ItemRegistry.XUAN_PAPER)
                .define('C', ItemTags.CANDLES)
                .define('D', Items.WHITE_DYE)
                .define('F', ItemRegistry.WOODEN_FRAME)
                .pattern("XDX")
                .pattern("XCX")
                .pattern(" F ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.YELLOW_SKY_LANTERN, 1)
                .define('X', ItemRegistry.XUAN_PAPER)
                .define('C', ItemTags.CANDLES)
                .define('D', Items.YELLOW_DYE)
                .define('F', ItemRegistry.WOODEN_FRAME)
                .pattern("XDX")
                .pattern("XCX")
                .pattern(" F ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.RED_SKY_LANTERN, 1)
                .define('X', ItemRegistry.XUAN_PAPER)
                .define('C', ItemTags.CANDLES)
                .define('D', Items.RED_DYE)
                .define('F', ItemRegistry.WOODEN_FRAME)
                .pattern("XDX")
                .pattern("XCX")
                .pattern(" F ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.SMALL_RED_LANTERN, 1)
                .define('S', Items.STICK)
                .define('C', ItemTags.CANDLES)
                .define('D', Items.RED_DYE)
                .define('P', Items.PAPER)
                .pattern(" S ")
                .pattern("PCP")
                .pattern("DPD")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.STONE_LAMP, 1)
                .define('S', Items.STONE)
                .define('C', ItemTags.CANDLES)
                .define('W', Items.COBBLESTONE_WALL)
                .define('T', Items.STONE_SLAB)
                .pattern(" T ")
                .pattern("WCW")
                .pattern(" S ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.RED_CANDLE, 1)
                .define('C', Items.RED_CANDLE)
                .define('P', ItemRegistry.WOODEN_PARTS)
                .pattern("C")
                .pattern("P")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.TRICOLOR_CANDLESTICK, 1)
                .define('C', Items.WHITE_CANDLE)
                .define('P', ItemRegistry.PORCELAIN_PARTS)
                .pattern("C")
                .pattern("P")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ItemRegistry.JADE_CANDLESTICK, 1)
                .define('C', Items.WHITE_CANDLE)
                .define('P', ItemRegistry.JADE_PARTS)
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

    private static void blockDyeing(Item block, Item dye, Item output, Consumer<FinishedRecipe> pFinishedRecipeConsumer){
        String blockPath = Objects.requireNonNull(block.getRegistryName()).getPath();
        String dyePath = Objects.requireNonNull(dye.getRegistryName()).getPath();
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
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), output, 0.1F, 200)
                .unlockedBy(itemUnlockName(input), itemCriterion(input)).save(pFinishedRecipeConsumer, new ResourceLocation(DataGenerators.MOD_ID, name(output) + "_from_smelting"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(input), output, 0.05F, 100)
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
        return new SingleItemRecipeBuilder(RecipeSerializerRegistry.WOODWORKING_SERIALIZER, pIngredient, pResult, 1);
    }

    public static SingleItemRecipeBuilder woodworking(Ingredient pIngredient, ItemLike pResult, int pCount) {
        return new SingleItemRecipeBuilder(RecipeSerializerRegistry.WOODWORKING_SERIALIZER, pIngredient, pResult, pCount);
    }

    public static void woodworking(Item input, ItemLike pResult, int pCount, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
            var recipe = new SingleItemRecipeBuilder(RecipeSerializerRegistry.WOODWORKING_SERIALIZER, Ingredient.of(input), pResult, pCount);
            recipe.unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(input).getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(pFinishedRecipeConsumer);
    }

    public static void woodworking(Ingredient ingredient, ItemLike pResult, int pCount, Item unlockItem, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        var recipe = new SingleItemRecipeBuilder(RecipeSerializerRegistry.WOODWORKING_SERIALIZER, ingredient, pResult, pCount);
        recipe.unlockedBy("has_" + unlockItem.getRegistryName().getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(unlockItem))
                .save(pFinishedRecipeConsumer);
    }

    private static String name(Item item){
        return Objects.requireNonNull(item.getRegistryName()).getPath();
    }


}
