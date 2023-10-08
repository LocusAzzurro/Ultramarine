package com.voxelutopia.ultramarine.init.datagen;

import com.voxelutopia.ultramarine.UltramarineDataGenerators;
import com.voxelutopia.ultramarine.init.data.ModItemTags;
import com.voxelutopia.ultramarine.init.registry.ModItems;
import com.voxelutopia.ultramarine.init.registry.ModRecipeSerializers;
import com.voxelutopia.ultramarine.util.RegistryHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataGenerator pGenerator) {
        super(pGenerator);
    }


    private static void generateLampRecipes(@NotNull Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(Items.WHITE_CANDLE, 1)
                .define('S', Items.STRING)
                .define('G', ModItems.GREASE)
                .pattern("S")
                .pattern("G")
                .unlockedBy(itemUnlockName(ModItems.GREASE), itemCriterion(ModItems.GREASE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.OCTAGONAL_PALACE_LANTERN, 1)
                .define('F', ModItems.WOODEN_FRAME)
                .define('P', ModItemTags.POLISHED_PLANKS)
                .define('C', ItemTags.CANDLES)
                .pattern("FPF")
                .pattern("PCP")
                .pattern("FPF")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.SQUARE_PALACE_LANTERN, 1)
                .define('F', ModItems.WOODEN_FRAME)
                .define('C', ItemTags.CANDLES)
                .pattern(" F ")
                .pattern("FCF")
                .pattern(" F ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.STANDING_LAMP, 1)
                .define('X', ModItems.XUAN_PAPER)
                .define('C', ItemTags.CANDLES)
                .define('W', ItemTags.PLANKS)
                .define('F', ModItems.WOODEN_FRAME)
                .define('P', ModItems.WOODEN_PARTS)
                .pattern("XCX")
                .pattern("PFP")
                .pattern(" W ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.SMALL_STANDING_LAMP, 1)
                .define('X', ModItems.XUAN_PAPER)
                .define('C', ItemTags.CANDLES)
                .define('W', Items.STICK)
                .define('F', ModItems.WOODEN_FRAME)
                .define('P', ModItems.WOODEN_PARTS)
                .pattern("XCX")
                .pattern("PFP")
                .pattern(" W ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.WHITE_SKY_LANTERN, 1)
                .define('X', ModItems.XUAN_PAPER)
                .define('C', ItemTags.CANDLES)
                .define('D', Items.WHITE_DYE)
                .define('F', ModItems.WOODEN_FRAME)
                .pattern("XDX")
                .pattern("XCX")
                .pattern(" F ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.YELLOW_SKY_LANTERN, 1)
                .define('X', ModItems.XUAN_PAPER)
                .define('C', ItemTags.CANDLES)
                .define('D', Items.YELLOW_DYE)
                .define('F', ModItems.WOODEN_FRAME)
                .pattern("XDX")
                .pattern("XCX")
                .pattern(" F ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.RED_SKY_LANTERN, 1)
                .define('X', ModItems.XUAN_PAPER)
                .define('C', ItemTags.CANDLES)
                .define('D', Items.RED_DYE)
                .define('F', ModItems.WOODEN_FRAME)
                .pattern("XDX")
                .pattern("XCX")
                .pattern(" F ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.SMALL_RED_LANTERN, 1)
                .define('S', Items.STICK)
                .define('C', ItemTags.CANDLES)
                .define('D', Items.RED_DYE)
                .define('P', Items.PAPER)
                .pattern(" S ")
                .pattern("PCP")
                .pattern("DPD")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.STONE_LAMP, 1)
                .define('S', Items.STONE)
                .define('C', ItemTags.CANDLES)
                .define('W', Items.COBBLESTONE_WALL)
                .define('T', Items.STONE_SLAB)
                .pattern(" T ")
                .pattern("WCW")
                .pattern(" S ")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.RED_CANDLE, 1)
                .define('C', Items.RED_CANDLE)
                .define('P', ModItems.WOODEN_PARTS)
                .pattern("C")
                .pattern("P")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.TRICOLOR_CANDLESTICK, 1)
                .define('C', Items.WHITE_CANDLE)
                .define('P', ModItems.PORCELAIN_PARTS)
                .pattern("C")
                .pattern("P")
                .unlockedBy(itemUnlockName(Items.CANDLE), itemCriterion(Items.CANDLE))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.JADE_CANDLESTICK, 1)
                .define('C', Items.WHITE_CANDLE)
                .define('P', ModItems.JADE_PARTS)
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
    private static void quadComposeRecipe(Item part, Item combined, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        ShapedRecipeBuilder.shaped(combined, 1)
                .define('A', part)
                .pattern("AA")
                .pattern("AA")
                .unlockedBy("has_" + RegistryHelper.getItemRegistryName(part).getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(part))
                .save(pFinishedRecipeConsumer);
    }

    private static void quadDecomposeRecipe(Item part, Item combined, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        ShapelessRecipeBuilder.shapeless(part, 4).requires(combined)
                .unlockedBy("has_" + RegistryHelper.getItemRegistryName(combined).getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(combined))
                .save(pFinishedRecipeConsumer);
    }

    private static void stonePolishing(Item raw, Item polished, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        String rawPath = Objects.requireNonNull(RegistryHelper.getItemRegistryName(raw)).getPath();
        String polishedPath = Objects.requireNonNull(RegistryHelper.getItemRegistryName(polished)).getPath();
        ShapedRecipeBuilder.shaped(polished, 4)
                .define('A', raw)
                .pattern("AA")
                .pattern("AA")
                .unlockedBy("has_" + rawPath, InventoryChangeTrigger.TriggerInstance.hasItems(raw))
                .save(pFinishedRecipeConsumer, new ResourceLocation(UltramarineDataGenerators.MOD_ID, polishedPath + "_from_crafting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(raw), polished)
                .unlockedBy("has_" + rawPath, InventoryChangeTrigger.TriggerInstance.hasItems(raw))
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(UltramarineDataGenerators.MOD_ID, polishedPath + "_from_stonecutting"));
    }

    private static void blockDyeing(Item block, Item dye, Item output, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        String blockPath = Objects.requireNonNull(RegistryHelper.getItemRegistryName(block)).getPath();
        String dyePath = Objects.requireNonNull(RegistryHelper.getItemRegistryName(dye)).getPath();
        String outputPath = Objects.requireNonNull(RegistryHelper.getItemRegistryName(output)).getPath();
        ShapelessRecipeBuilder.shapeless(output).requires(block).requires(dye)
                .unlockedBy("has_" + blockPath, InventoryChangeTrigger.TriggerInstance.hasItems(block))
                .save(pFinishedRecipeConsumer, new ResourceLocation(UltramarineDataGenerators.MOD_ID, outputPath));
        ShapedRecipeBuilder.shaped(output, 8)
                .define('B', block)
                .define('D', dye)
                .pattern("BBB")
                .pattern("BDB")
                .pattern("BBB")
                .unlockedBy("has_" + blockPath, InventoryChangeTrigger.TriggerInstance.hasItems(block))
                .save(pFinishedRecipeConsumer, new ResourceLocation(UltramarineDataGenerators.MOD_ID, outputPath + "_batch"));
    }

    private static void dust(Item input, Item output, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), output)
                .unlockedBy("has_" + name(input), InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(pFinishedRecipeConsumer, new ResourceLocation(UltramarineDataGenerators.MOD_ID, name(output)));
    }

    private static void brickMixture(Item brick, int brickAmount, Item additive, Item output, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        String brickPath = Objects.requireNonNull(RegistryHelper.getItemRegistryName(brick)).getPath();
        String additivePath = Objects.requireNonNull(RegistryHelper.getItemRegistryName(additive)).getPath();
        String outputPath = Objects.requireNonNull(RegistryHelper.getItemRegistryName(output)).getPath();
        ShapelessRecipeBuilder.shapeless(output, brickAmount).requires(brick, brickAmount).requires(additive)
                .unlockedBy("has_" + brickPath, InventoryChangeTrigger.TriggerInstance.hasItems(brick))
                .save(pFinishedRecipeConsumer, new ResourceLocation(UltramarineDataGenerators.MOD_ID, outputPath));
    }

    private static void smeltingAndBlasting(Item input, Item output, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), output, 0.1F, 200)
                .unlockedBy(itemUnlockName(input), itemCriterion(input)).save(pFinishedRecipeConsumer, new ResourceLocation(UltramarineDataGenerators.MOD_ID, name(output) + "_from_smelting"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(input), output, 0.05F, 100)
                .unlockedBy(itemUnlockName(input), itemCriterion(input)).save(pFinishedRecipeConsumer, new ResourceLocation(UltramarineDataGenerators.MOD_ID, name(output) + "_from_blasting"));
    }

    private static void stoneSlabAndStairsRecipe(Item baseBlock, Item slabBlock, Item stairBlock, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        String baseBlockPath = Objects.requireNonNull(RegistryHelper.getItemRegistryName(baseBlock)).getPath();
        String stairsBlockPath = Objects.requireNonNull(RegistryHelper.getItemRegistryName(stairBlock)).getPath();
        String slabBlockPath = Objects.requireNonNull(RegistryHelper.getItemRegistryName(slabBlock)).getPath();
        String baseBlockAdvancement = "has_" + baseBlockPath;
        InventoryChangeTrigger.TriggerInstance trigger = InventoryChangeTrigger.TriggerInstance.hasItems(baseBlock);

        ShapedRecipeBuilder.shaped(stairBlock, 4)
                .define('B', baseBlock)
                .pattern("B  ")
                .pattern("BB ")
                .pattern("BBB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(UltramarineDataGenerators.MOD_ID, stairsBlockPath + "_from_crafting"));
        ShapedRecipeBuilder.shaped(slabBlock, 6)
                .define('B', baseBlock)
                .pattern("BBB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(UltramarineDataGenerators.MOD_ID, slabBlockPath + "_from_crafting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(baseBlock), stairBlock)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(UltramarineDataGenerators.MOD_ID, stairsBlockPath + "_from_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(baseBlock), slabBlock, 2)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(UltramarineDataGenerators.MOD_ID, slabBlockPath + "_from_stonecutting"));
    }

    private static void woodSlabAndStairsRecipe(Item baseBlock, Item slabBlock, Item stairBlock, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        String baseBlockPath = Objects.requireNonNull(RegistryHelper.getItemRegistryName(baseBlock)).getPath();
        String stairsBlockPath = Objects.requireNonNull(RegistryHelper.getItemRegistryName(stairBlock)).getPath();
        String slabBlockPath = Objects.requireNonNull(RegistryHelper.getItemRegistryName(slabBlock)).getPath();
        String baseBlockAdvancement = "has_" + baseBlockPath;
        InventoryChangeTrigger.TriggerInstance trigger = InventoryChangeTrigger.TriggerInstance.hasItems(baseBlock);

        ShapedRecipeBuilder.shaped(stairBlock, 4)
                .define('B', baseBlock)
                .pattern("B  ")
                .pattern("BB ")
                .pattern("BBB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(UltramarineDataGenerators.MOD_ID, stairsBlockPath + "_from_crafting"));
        ShapedRecipeBuilder.shaped(slabBlock, 6)
                .define('B', baseBlock)
                .pattern("BBB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(UltramarineDataGenerators.MOD_ID, slabBlockPath + "_from_crafting"));
        woodworking(Ingredient.of(baseBlock), stairBlock)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(UltramarineDataGenerators.MOD_ID, stairsBlockPath + "_from_woodworking"));
        woodworking(Ingredient.of(baseBlock), slabBlock, 2)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(UltramarineDataGenerators.MOD_ID, slabBlockPath + "_from_woodworking"));
    }

    private static void wallRecipe(Item baseBlock, Item wallBlock, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        String baseBlockPath = Objects.requireNonNull(RegistryHelper.getItemRegistryName(baseBlock)).getPath();
        String wallBlockPath = Objects.requireNonNull(RegistryHelper.getItemRegistryName(wallBlock)).getPath();
        String baseBlockAdvancement = "has_" + baseBlockPath;
        InventoryChangeTrigger.TriggerInstance trigger = InventoryChangeTrigger.TriggerInstance.hasItems(baseBlock);
        ShapedRecipeBuilder.shaped(wallBlock, 6)
                .define('B', baseBlock)
                .pattern("BBB")
                .pattern("BBB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(UltramarineDataGenerators.MOD_ID, wallBlockPath + "_from_crafting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(baseBlock), wallBlock)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(UltramarineDataGenerators.MOD_ID, wallBlockPath + "_from_stonecutting"));
    }

    private static void fenceRecipe(Item baseBlock, Item fenceBlock, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        String baseBlockPath = Objects.requireNonNull(RegistryHelper.getItemRegistryName(baseBlock)).getPath();
        String fenceBlockPath = Objects.requireNonNull(RegistryHelper.getItemRegistryName(fenceBlock)).getPath();
        String baseBlockAdvancement = "has_" + baseBlockPath;
        InventoryChangeTrigger.TriggerInstance trigger = InventoryChangeTrigger.TriggerInstance.hasItems(baseBlock);
        ShapedRecipeBuilder.shaped(fenceBlock, 3)
                .define('B', baseBlock)
                .define('S', Items.STICK)
                .pattern("BSB")
                .pattern("BSB")
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(UltramarineDataGenerators.MOD_ID, fenceBlockPath + "_from_crafting"));
        woodworking(Ingredient.of(baseBlock), fenceBlock)
                .unlockedBy(baseBlockAdvancement, trigger)
                .save(pFinishedRecipeConsumer,
                        new ResourceLocation(UltramarineDataGenerators.MOD_ID, fenceBlockPath + "_from_woodworking"));
    }

    private static void polishedPlankRecipe(Item planks, Item polishedPlank, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        woodworking(Ingredient.of(planks), polishedPlank, 2)
                .unlockedBy("has_" + RegistryHelper.getItemRegistryName(planks).getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(planks))
                .save(pFinishedRecipeConsumer);
    }

    private static void roofTileBlocksRecipe(String color, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        Item tileBlock, tileItem;
        tileItem = Registry.ITEM.get(new ResourceLocation(UltramarineDataGenerators.MOD_ID, color + "_roof_tile"));
        assert (tileItem != null);

        tileBlock = Registry.ITEM.get(new ResourceLocation(UltramarineDataGenerators.MOD_ID, color + "_roof_tiles"));
        assert (tileBlock != null);
        ShapedRecipeBuilder.shaped(tileBlock, 1)
                .define('T', tileItem)
                .pattern("TTT")
                .unlockedBy("has_" + color + "_roof_tile", InventoryChangeTrigger.TriggerInstance.hasItems(tileItem))
                .save(pFinishedRecipeConsumer);

        tileBlock = Registry.ITEM.get(new ResourceLocation(UltramarineDataGenerators.MOD_ID, color + "_roof_tile_stairs"));
        assert (tileBlock != null);
        ShapedRecipeBuilder.shaped(tileBlock, 1)
                .define('T', tileItem)
                .pattern("T  ")
                .pattern("TT ")
                .pattern("TTT")
                .unlockedBy("has_" + color + "_roof_tile", InventoryChangeTrigger.TriggerInstance.hasItems(tileItem))
                .save(pFinishedRecipeConsumer);

        tileBlock = Registry.ITEM.get(new ResourceLocation(UltramarineDataGenerators.MOD_ID, color + "_roof_tile_edge"));
        assert (tileBlock != null);
        ShapedRecipeBuilder.shaped(tileBlock, 1)
                .define('T', tileItem)
                .pattern("T  ")
                .pattern("TTT")
                .unlockedBy("has_" + color + "_roof_tile", InventoryChangeTrigger.TriggerInstance.hasItems(tileItem))
                .save(pFinishedRecipeConsumer);
    }

    public static SingleItemRecipeBuilder woodworking(Ingredient pIngredient, ItemLike pResult) {
        return new SingleItemRecipeBuilder(ModRecipeSerializers.WOODWORKING_SERIALIZER, pIngredient, pResult, 1);
    }

    public static SingleItemRecipeBuilder woodworking(Ingredient pIngredient, ItemLike pResult, int pCount) {
        return new SingleItemRecipeBuilder(ModRecipeSerializers.WOODWORKING_SERIALIZER, pIngredient, pResult, pCount);
    }

    public static void woodworking(Item input, ItemLike pResult, int pCount, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        var recipe = new SingleItemRecipeBuilder(ModRecipeSerializers.WOODWORKING_SERIALIZER, Ingredient.of(input), pResult, pCount);
        recipe.unlockedBy("has_" + Registry.ITEM.getKey(input).getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(pFinishedRecipeConsumer);
    }

    public static void woodworking(Ingredient ingredient, ItemLike pResult, int pCount, Item unlockItem, Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        var recipe = new SingleItemRecipeBuilder(ModRecipeSerializers.WOODWORKING_SERIALIZER, ingredient, pResult, pCount);
        recipe.unlockedBy("has_" + RegistryHelper.getItemRegistryName(unlockItem).getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(unlockItem))
                .save(pFinishedRecipeConsumer);
    }

    private static String name(Item item) {
        return Objects.requireNonNull(RegistryHelper.getItemRegistryName(item)).getPath();
    }

    @Override
    public void generateRecipes(@NotNull Consumer<FinishedRecipe> recipeConsumer) {

        //BUILDING BLOCKS
        quadComposeRecipe(ModItems.CYAN_BRICK, ModItems.CYAN_BRICKS, recipeConsumer);
        stoneSlabAndStairsRecipe(ModItems.CYAN_BRICKS, ModItems.CYAN_BRICK_SLAB, ModItems.CYAN_BRICK_STAIRS, recipeConsumer);
        quadComposeRecipe(ModItems.BLACK_BRICK, ModItems.BLACK_BRICKS, recipeConsumer);
        stoneSlabAndStairsRecipe(ModItems.BLACK_BRICKS, ModItems.BLACK_BRICK_SLAB, ModItems.BLACK_BRICK_STAIRS, recipeConsumer);
        wallRecipe(ModItems.BLACK_BRICKS, ModItems.BLACK_BRICK_WALL, recipeConsumer);
        quadComposeRecipe(ModItems.BROWNISH_RED_STONE_BRICK, ModItems.BROWNISH_RED_STONE_BRICKS, recipeConsumer);
        stoneSlabAndStairsRecipe(ModItems.BROWNISH_RED_STONE_BRICKS, ModItems.BROWNISH_RED_STONE_BRICK_SLAB, ModItems.BROWNISH_RED_STONE_BRICK_STAIRS, recipeConsumer);
        wallRecipe(ModItems.BROWNISH_RED_STONE_BRICKS, ModItems.BROWNISH_RED_STONE_BRICK_WALL, recipeConsumer);
        ShapelessRecipeBuilder.shapeless(ModItems.PALE_YELLOW_STONE, 2).requires(Items.STONE).requires(Items.SAND)
                .unlockedBy("has_" + Items.STONE, InventoryChangeTrigger.TriggerInstance.hasItems(Items.STONE)).save(recipeConsumer);
        stoneSlabAndStairsRecipe(ModItems.PALE_YELLOW_STONE, ModItems.PALE_YELLOW_STONE_SLAB, ModItems.PALE_YELLOW_STONE_STAIRS, recipeConsumer);
        ShapelessRecipeBuilder.shapeless(ModItems.VARIEGATED_ROCKS, 4).requires(Items.COBBLESTONE).requires(Items.GRANITE).requires(Items.DIORITE).requires(Items.ANDESITE)
                .unlockedBy("has_" + Items.COBBLESTONE, InventoryChangeTrigger.TriggerInstance.hasItems(Items.STONE)).save(recipeConsumer);
        stoneSlabAndStairsRecipe(ModItems.VARIEGATED_ROCKS, ModItems.VARIEGATED_ROCK_SLAB, ModItems.VARIEGATED_ROCK_STAIRS, recipeConsumer);
        ShapelessRecipeBuilder.shapeless(ModItems.WEATHERED_STONE, 2).requires(Items.STONE).requires(Items.GRAVEL)
                .unlockedBy("has_" + Items.STONE, InventoryChangeTrigger.TriggerInstance.hasItems(Items.STONE)).save(recipeConsumer);
        stoneSlabAndStairsRecipe(ModItems.WEATHERED_STONE, ModItems.WEATHERED_STONE_SLAB, ModItems.WEATHERED_STONE_STAIRS, recipeConsumer);
        stonePolishing(ModItems.WEATHERED_STONE, ModItems.POLISHED_WEATHERED_STONE, recipeConsumer);
        stoneSlabAndStairsRecipe(ModItems.POLISHED_WEATHERED_STONE, ModItems.POLISHED_WEATHERED_STONE_SLAB, ModItems.POLISHED_WEATHERED_STONE_STAIRS, recipeConsumer);
        wallRecipe(ModItems.POLISHED_WEATHERED_STONE, ModItems.POLISHED_WEATHERED_STONE_WALL, recipeConsumer);
        blockDyeing(Items.SMOOTH_STONE, Items.CYAN_DYE, ModItems.CYAN_FLOOR_TILE, recipeConsumer);
        stoneSlabAndStairsRecipe(ModItems.CYAN_FLOOR_TILE, ModItems.CYAN_FLOOR_TILE_SLAB, ModItems.CYAN_FLOOR_TILE_STAIRS, recipeConsumer);
        wallRecipe(ModItems.CYAN_FLOOR_TILE, ModItems.CYAN_FLOOR_TILE_WALL, recipeConsumer);
        blockDyeing(ModItems.CYAN_FLOOR_TILE, Items.WHITE_DYE, ModItems.LIGHT_CYAN_FLOOR_TILE, recipeConsumer);
        stoneSlabAndStairsRecipe(ModItems.LIGHT_CYAN_FLOOR_TILE, ModItems.LIGHT_CYAN_FLOOR_TILE_SLAB, ModItems.LIGHT_CYAN_FLOOR_TILE_STAIRS, recipeConsumer);
        wallRecipe(ModItems.LIGHT_CYAN_FLOOR_TILE, ModItems.LIGHT_CYAN_FLOOR_TILE_WALL, recipeConsumer);
        roofTileBlocksRecipe("gray", recipeConsumer);
        roofTileBlocksRecipe("yellow", recipeConsumer);
        roofTileBlocksRecipe("green", recipeConsumer);
        roofTileBlocksRecipe("blue", recipeConsumer);
        roofTileBlocksRecipe("cyan", recipeConsumer);
        roofTileBlocksRecipe("black", recipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.GREEN_GLAZED_TILES, 2)
                .define('B', Items.GREEN_GLAZED_TERRACOTTA).define('T', ModItems.GREEN_ROOF_TILE)
                .pattern(" T ").pattern("TBT").pattern(" T ")
                .unlockedBy("has_" + Items.GREEN_GLAZED_TERRACOTTA, InventoryChangeTrigger.TriggerInstance.hasItems(Items.GREEN_GLAZED_TERRACOTTA))
                .save(recipeConsumer);
        stoneSlabAndStairsRecipe(ModItems.GREEN_GLAZED_TILES, ModItems.GREEN_GLAZED_TILE_SLAB, ModItems.GREEN_GLAZED_TILE_STAIRS, recipeConsumer);

        ShapedRecipeBuilder.shaped(ModItems.BAMBOO_MAT, 4)
                .define('B', Items.BAMBOO).define('S', Items.STRING)
                .pattern("BSB").pattern("BSB").pattern("BSB")
                .unlockedBy("has_" + Items.BAMBOO, InventoryChangeTrigger.TriggerInstance.hasItems(Items.BAMBOO))
                .save(recipeConsumer);
        woodSlabAndStairsRecipe(ModItems.BAMBOO_MAT, ModItems.BAMBOO_MAT_SLAB, ModItems.BAMBOO_MAT_STAIRS, recipeConsumer);
        woodSlabAndStairsRecipe(ModItems.ROSEWOOD_PLANKS, ModItems.ROSEWOOD_SLAB, ModItems.ROSEWOOD_STAIRS, recipeConsumer);
        fenceRecipe(ModItems.ROSEWOOD_PLANKS, ModItems.ROSEWOOD_FENCE, recipeConsumer);

        //MATERIALS
        woodworking(Ingredient.of(ItemTags.PLANKS), ModItems.WOODEN_FRAME, 2, Items.OAK_PLANKS, recipeConsumer);
        polishedPlankRecipe(Items.OAK_PLANKS, ModItems.POLISHED_OAK_PLANK, recipeConsumer);
        polishedPlankRecipe(Items.BIRCH_PLANKS, ModItems.POLISHED_BIRCH_PLANK, recipeConsumer);
        polishedPlankRecipe(Items.SPRUCE_PLANKS, ModItems.POLISHED_SPRUCE_PLANK, recipeConsumer);
        polishedPlankRecipe(Items.JUNGLE_PLANKS, ModItems.POLISHED_JUNGLE_PLANK, recipeConsumer);
        polishedPlankRecipe(Items.ACACIA_PLANKS, ModItems.POLISHED_ACACIA_PLANK, recipeConsumer);
        polishedPlankRecipe(Items.DARK_OAK_PLANKS, ModItems.POLISHED_DARK_OAK_PLANK, recipeConsumer);
        polishedPlankRecipe(Items.CRIMSON_PLANKS, ModItems.POLISHED_CRIMSON_PLANK, recipeConsumer);
        polishedPlankRecipe(Items.WARPED_PLANKS, ModItems.POLISHED_WARPED_PLANK, recipeConsumer);
        polishedPlankRecipe(ModItems.ROSEWOOD_PLANKS, ModItems.POLISHED_ROSEWOOD_PLANK, recipeConsumer);
        //polishedPlankRecipe(ItemRegistry.EBONY_PLANKS, ItemRegistry.POLISHED_EBONY_PLANK, recipeConsumer);
        dust(ModItems.RAW_HEMATITE, ModItems.HEMATITE_DUST, recipeConsumer);
        dust(ModItems.MAGNESITE, ModItems.MAGNESITE_DUST, recipeConsumer);
        dust(Items.PRISMARINE_SHARD, ModItems.PRISMARINE_DUST, recipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.UNFIRED_CLAY_BRICK, 3)
                .define('C', Items.CLAY_BALL).pattern("CCC")
                .unlockedBy(itemUnlockName(Items.CLAY_BALL), itemCriterion(Items.CLAY_BALL))
                .save(recipeConsumer);
        brickMixture(ModItems.UNFIRED_CLAY_BRICK, 6, ModItems.PRISMARINE_DUST, ModItems.UNFIRED_RAW_CYAN_BRICK, recipeConsumer);
        brickMixture(ModItems.UNFIRED_CLAY_BRICK, 6, ModItems.HEMATITE_DUST, ModItems.UNFIRED_BLACK_BRICK, recipeConsumer);
        brickMixture(ModItems.UNFIRED_CLAY_BRICK, 6, Items.NETHER_WART, ModItems.UNFIRED_RAW_BROWNISH_RED_STONE_BRICK, recipeConsumer);
        smeltingAndBlasting(ModItems.UNFIRED_CLAY_BRICK, ModItems.FIRED_BRICK, recipeConsumer);
        smeltingAndBlasting(ModItems.UNFIRED_RAW_CYAN_BRICK, ModItems.CYAN_BRICK, recipeConsumer);
        smeltingAndBlasting(ModItems.UNFIRED_BLACK_BRICK, ModItems.BLACK_BRICK, recipeConsumer);
        smeltingAndBlasting(ModItems.UNFIRED_RAW_BROWNISH_RED_STONE_BRICK, ModItems.BROWNISH_RED_STONE_BRICK, recipeConsumer);
        ShapelessRecipeBuilder.shapeless(Items.BRICK, 1).requires(ModItems.FIRED_BRICK)
                .unlockedBy("has_" + ModItems.FIRED_BRICK, InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.FIRED_BRICK)).save(recipeConsumer);


        //LAMPS
        generateLampRecipes(recipeConsumer);
    }


}
