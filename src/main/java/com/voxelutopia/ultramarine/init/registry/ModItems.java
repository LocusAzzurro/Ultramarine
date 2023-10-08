package com.voxelutopia.ultramarine.init.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.common.item.AquaticPlantBlockItem;
import com.voxelutopia.ultramarine.common.item.BaseFood;
import com.voxelutopia.ultramarine.common.item.WoodenHammer;
import com.voxelutopia.ultramarine.init.data.CreativeTabData;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("unused")
public class ModItems {


    /**
     * BUILDING BLOCKS
     */

    // BRICKS

    public static final Item CYAN_BRICKS = fromBlock(ModBlocks.CYAN_BRICKS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item CYAN_BRICK_SLAB = fromBlock(ModBlocks.CYAN_BRICK_SLAB, CreativeTabData.BUILDING_BLOCKS);
    public static final Item CYAN_BRICK_STAIRS = fromBlock(ModBlocks.CYAN_BRICK_STAIRS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item CYAN_BRICK_WALL = fromBlock(ModBlocks.CYAN_BRICK_WALL, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLACK_BRICKS = fromBlock(ModBlocks.BLACK_BRICKS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLACK_BRICK_SLAB = fromBlock(ModBlocks.BLACK_BRICK_SLAB, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLACK_BRICK_STAIRS = fromBlock(ModBlocks.BLACK_BRICK_STAIRS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLACK_BRICK_WALL = fromBlock(ModBlocks.BLACK_BRICK_WALL, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BROWNISH_RED_STONE_BRICKS = fromBlock(ModBlocks.BROWNISH_RED_STONE_BRICKS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BROWNISH_RED_STONE_BRICK_SLAB = fromBlock(ModBlocks.BROWNISH_RED_STONE_BRICK_SLAB, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BROWNISH_RED_STONE_BRICK_STAIRS = fromBlock(ModBlocks.BROWNISH_RED_STONE_BRICK_STAIRS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BROWNISH_RED_STONE_BRICK_WALL = fromBlock(ModBlocks.BROWNISH_RED_STONE_BRICK_WALL, CreativeTabData.BUILDING_BLOCKS);
    public static final Item WHITE_AMD_PINK_MIXED_BRICKS = fromBlock(ModBlocks.WHITE_AMD_PINK_MIXED_BRICKS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item GREEN_WEATHERED_BRICKS = fromBlock(ModBlocks.GREEN_WEATHERED_BRICKS, CreativeTabData.BUILDING_BLOCKS);

    // STONES

    public static final Item PALE_YELLOW_STONE = fromBlock(ModBlocks.PALE_YELLOW_STONE, CreativeTabData.BUILDING_BLOCKS);
    public static final Item PALE_YELLOW_STONE_SLAB = fromBlock(ModBlocks.PALE_YELLOW_STONE_SLAB, CreativeTabData.BUILDING_BLOCKS);
    public static final Item PALE_YELLOW_STONE_STAIRS = fromBlock(ModBlocks.PALE_YELLOW_STONE_STAIRS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item VARIEGATED_ROCKS = fromBlock(ModBlocks.VARIEGATED_ROCKS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item VARIEGATED_ROCK_SLAB = fromBlock(ModBlocks.VARIEGATED_ROCK_SLAB, CreativeTabData.BUILDING_BLOCKS);
    public static final Item VARIEGATED_ROCK_STAIRS = fromBlock(ModBlocks.VARIEGATED_ROCK_STAIRS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item WEATHERED_STONE = fromBlock(ModBlocks.WEATHERED_STONE, CreativeTabData.BUILDING_BLOCKS);
    public static final Item WEATHERED_STONE_SLAB = fromBlock(ModBlocks.WEATHERED_STONE_SLAB, CreativeTabData.BUILDING_BLOCKS);
    public static final Item WEATHERED_STONE_STAIRS = fromBlock(ModBlocks.WEATHERED_STONE_STAIRS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item POLISHED_WEATHERED_STONE = fromBlock(ModBlocks.POLISHED_WEATHERED_STONE, CreativeTabData.BUILDING_BLOCKS);
    public static final Item POLISHED_WEATHERED_STONE_SLAB = fromBlock(ModBlocks.POLISHED_WEATHERED_STONE_SLAB, CreativeTabData.BUILDING_BLOCKS);
    public static final Item POLISHED_WEATHERED_STONE_STAIRS = fromBlock(ModBlocks.POLISHED_WEATHERED_STONE_STAIRS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item POLISHED_WEATHERED_STONE_WALL = fromBlock(ModBlocks.POLISHED_WEATHERED_STONE_WALL, CreativeTabData.BUILDING_BLOCKS);
    public static final Item GREEN_WEATHERED_STONE = fromBlock(ModBlocks.GREEN_WEATHERED_STONE, CreativeTabData.BUILDING_BLOCKS);

    // FLOOR TILES

    public static final Item LIGHT_CYAN_FLOOR_TILE = fromBlock(ModBlocks.LIGHT_CYAN_FLOOR_TILE, CreativeTabData.BUILDING_BLOCKS);
    public static final Item LIGHT_CYAN_FLOOR_TILE_SLAB = fromBlock(ModBlocks.LIGHT_CYAN_FLOOR_TILE_SLAB, CreativeTabData.BUILDING_BLOCKS);
    public static final Item LIGHT_CYAN_FLOOR_TILE_STAIRS = fromBlock(ModBlocks.LIGHT_CYAN_FLOOR_TILE_STAIRS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item LIGHT_CYAN_FLOOR_TILE_WALL = fromBlock(ModBlocks.LIGHT_CYAN_FLOOR_TILE_WALL, CreativeTabData.BUILDING_BLOCKS);
    public static final Item CYAN_FLOOR_TILE = fromBlock(ModBlocks.CYAN_FLOOR_TILE, CreativeTabData.BUILDING_BLOCKS);
    public static final Item CYAN_FLOOR_TILE_SLAB = fromBlock(ModBlocks.CYAN_FLOOR_TILE_SLAB, CreativeTabData.BUILDING_BLOCKS);
    public static final Item CYAN_FLOOR_TILE_STAIRS = fromBlock(ModBlocks.CYAN_FLOOR_TILE_STAIRS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item CYAN_FLOOR_TILE_WALL = fromBlock(ModBlocks.CYAN_FLOOR_TILE_WALL, CreativeTabData.BUILDING_BLOCKS);
    public static final Item DARK_CYAN_FLOOR_TILE = fromBlock(ModBlocks.DARK_CYAN_FLOOR_TILE, CreativeTabData.BUILDING_BLOCKS);
    public static final Item LAYERED_CYAN_FLOOR_TILES = fromBlock(ModBlocks.LAYERED_CYAN_FLOOR_TILES, CreativeTabData.BUILDING_BLOCKS);
    public static final Item VERTICAL_CYAN_FLOOR_TILES = fromBlock(ModBlocks.VERTICAL_CYAN_FLOOR_TILES, CreativeTabData.BUILDING_BLOCKS);
    public static final Item MIXED_CYAN_FLOOR_TILES = fromBlock(ModBlocks.MIXED_CYAN_FLOOR_TILES, CreativeTabData.BUILDING_BLOCKS);
    public static final Item CHISELED_CYAN_FLOOR_TILE = fromBlock(ModBlocks.CHISELED_CYAN_FLOOR_TILE, CreativeTabData.BUILDING_BLOCKS);
    public static final Item CUT_CYAN_FLOOR_TILES = fromBlock(ModBlocks.CUT_CYAN_FLOOR_TILES, CreativeTabData.BUILDING_BLOCKS);
    public static final Item WEATHERED_RED_STONE_TILE = fromBlock(ModBlocks.WEATHERED_RED_STONE_TILE, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLUE_AND_BLACK_TILE = fromBlock(ModBlocks.BLUE_AND_BLACK_TILE, CreativeTabData.BUILDING_BLOCKS);
    public static final Item GREEN_GLAZED_TILES = fromBlock(ModBlocks.GREEN_GLAZED_TILES, CreativeTabData.BUILDING_BLOCKS);
    public static final Item GREEN_GLAZED_TILE_SLAB = fromBlock(ModBlocks.GREEN_GLAZED_TILE_SLAB, CreativeTabData.BUILDING_BLOCKS);
    public static final Item GREEN_GLAZED_TILE_STAIRS = fromBlock(ModBlocks.GREEN_GLAZED_TILE_STAIRS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLACK_FLOOR_TILES = fromBlock(ModBlocks.BLACK_FLOOR_TILES, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLACK_FLOOR_TILES_LITTLE_MOSSY = fromBlock(ModBlocks.BLACK_FLOOR_TILES_LITTLE_MOSSY, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLACK_FLOOR_TILES_MODERATE_MOSSY = fromBlock(ModBlocks.BLACK_FLOOR_TILES_MODERATE_MOSSY, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLACK_FLOOR_TILES_VERY_MOSSY = fromBlock(ModBlocks.BLACK_FLOOR_TILES_VERY_MOSSY, CreativeTabData.BUILDING_BLOCKS);

    // WOODEN

    public static final Item ROSEWOOD_PLANKS = fromBlock(ModBlocks.ROSEWOOD_PLANKS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item ROSEWOOD_SLAB = fromBlock(ModBlocks.ROSEWOOD_SLAB, CreativeTabData.BUILDING_BLOCKS);
    public static final Item ROSEWOOD_STAIRS = fromBlock(ModBlocks.ROSEWOOD_STAIRS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item ROSEWOOD_FENCE = fromBlock(ModBlocks.ROSEWOOD_FENCE, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BAMBOO_MAT = fromBlock(ModBlocks.BAMBOO_MAT, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BAMBOO_MAT_SLAB = fromBlock(ModBlocks.BAMBOO_MAT_SLAB, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BAMBOO_MAT_STAIRS = fromBlock(ModBlocks.BAMBOO_MAT_STAIRS, CreativeTabData.BUILDING_BLOCKS);

    // ROOF TILES

    public static final Item GRAY_ROOF_TILES = fromBlock(ModBlocks.GRAY_ROOF_TILES, CreativeTabData.BUILDING_BLOCKS);
    public static final Item GRAY_ROOF_TILE_STAIRS = fromBlock(ModBlocks.GRAY_ROOF_TILE_STAIRS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item GRAY_ROOF_TILE_EDGE = fromBlock(ModBlocks.GRAY_ROOF_TILE_EDGE, CreativeTabData.BUILDING_BLOCKS);
    public static final Item YELLOW_ROOF_TILES = fromBlock(ModBlocks.YELLOW_ROOF_TILES, CreativeTabData.BUILDING_BLOCKS);
    public static final Item YELLOW_ROOF_TILE_STAIRS = fromBlock(ModBlocks.YELLOW_ROOF_TILE_STAIRS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item YELLOW_ROOF_TILE_EDGE = fromBlock(ModBlocks.YELLOW_ROOF_TILE_EDGE, CreativeTabData.BUILDING_BLOCKS);
    public static final Item GREEN_ROOF_TILES = fromBlock(ModBlocks.GREEN_ROOF_TILES, CreativeTabData.BUILDING_BLOCKS);
    public static final Item GREEN_ROOF_TILE_STAIRS = fromBlock(ModBlocks.GREEN_ROOF_TILE_STAIRS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item GREEN_ROOF_TILE_EDGE = fromBlock(ModBlocks.GREEN_ROOF_TILE_EDGE, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLUE_ROOF_TILES = fromBlock(ModBlocks.BLUE_ROOF_TILES, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLUE_ROOF_TILE_STAIRS = fromBlock(ModBlocks.BLUE_ROOF_TILE_STAIRS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLUE_ROOF_TILE_EDGE = fromBlock(ModBlocks.BLUE_ROOF_TILE_EDGE, CreativeTabData.BUILDING_BLOCKS);
    public static final Item CYAN_ROOF_TILES = fromBlock(ModBlocks.CYAN_ROOF_TILES, CreativeTabData.BUILDING_BLOCKS);
    public static final Item CYAN_ROOF_TILE_STAIRS = fromBlock(ModBlocks.CYAN_ROOF_TILE_STAIRS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item CYAN_ROOF_TILE_EDGE = fromBlock(ModBlocks.CYAN_ROOF_TILE_EDGE, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLACK_ROOF_TILES = fromBlock(ModBlocks.BLACK_ROOF_TILES, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLACK_ROOF_TILE_STAIRS = fromBlock(ModBlocks.BLACK_ROOF_TILE_STAIRS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLACK_ROOF_TILE_EDGE = fromBlock(ModBlocks.BLACK_ROOF_TILE_EDGE, CreativeTabData.BUILDING_BLOCKS);

    // ROOF RIDGE

    public static final Item BLACK_ROOF_RIDGE_UPPER = fromBlock(ModBlocks.BLACK_ROOF_RIDGE_UPPER, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLACK_ROOF_RIDGE_LOWER = fromBlock(ModBlocks.BLACK_ROOF_RIDGE_LOWER, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLACK_ROOF_RIDGE_CONNECTION = fromBlock(ModBlocks.BLACK_ROOF_RIDGE_CONNECTION, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLACK_MAIN_ROOF_RIDGE_CONNECTION = fromBlock(ModBlocks.BLACK_MAIN_ROOF_RIDGE_CONNECTION, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLACK_ROOF_RIDGE_UPPER_SLAB = fromBlock(ModBlocks.BLACK_ROOF_RIDGE_UPPER_SLAB, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLACK_MAIN_ROOF_RIDGE_SLAB = fromBlock(ModBlocks.BLACK_MAIN_ROOF_RIDGE_SLAB, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLACK_MAIN_ROOF_RIDGE_PANEL = fromBlock(ModBlocks.BLACK_MAIN_ROOF_RIDGE_PANEL, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLACK_MAIN_ROOF_RIDGE_PLATE = fromBlock(ModBlocks.BLACK_MAIN_ROOF_RIDGE_PLATE, CreativeTabData.BUILDING_BLOCKS);
    public static final Item BLACK_MAIN_ROOF_RIDGE_STAIRS = fromBlock(ModBlocks.BLACK_MAIN_ROOF_RIDGE_STAIRS, CreativeTabData.BUILDING_BLOCKS);
    public static final Item YELLOW_ROOF_RIDGE_UPPER = fromBlock(ModBlocks.YELLOW_ROOF_RIDGE_UPPER, CreativeTabData.BUILDING_BLOCKS);
    public static final Item YELLOW_ROOF_RIDGE_LOWER = fromBlock(ModBlocks.YELLOW_ROOF_RIDGE_LOWER, CreativeTabData.BUILDING_BLOCKS);
    public static final Item YELLOW_ROOF_RIDGE_CONNECTION = fromBlock(ModBlocks.YELLOW_ROOF_RIDGE_CONNECTION, CreativeTabData.BUILDING_BLOCKS);
    public static final Item YELLOW_MAIN_ROOF_RIDGE_CONNECTION = fromBlock(ModBlocks.YELLOW_MAIN_ROOF_RIDGE_CONNECTION, CreativeTabData.BUILDING_BLOCKS);
    public static final Item YELLOW_ROOF_RIDGE_UPPER_SLAB = fromBlock(ModBlocks.YELLOW_ROOF_RIDGE_UPPER_SLAB, CreativeTabData.BUILDING_BLOCKS);
    public static final Item YELLOW_MAIN_ROOF_RIDGE_SLAB = fromBlock(ModBlocks.YELLOW_MAIN_ROOF_RIDGE_SLAB, CreativeTabData.BUILDING_BLOCKS);
    public static final Item YELLOW_MAIN_ROOF_RIDGE_PANEL = fromBlock(ModBlocks.YELLOW_MAIN_ROOF_RIDGE_PANEL, CreativeTabData.BUILDING_BLOCKS);
    public static final Item YELLOW_MAIN_ROOF_RIDGE_PLATE = fromBlock(ModBlocks.YELLOW_MAIN_ROOF_RIDGE_PLATE, CreativeTabData.BUILDING_BLOCKS);
    public static final Item YELLOW_MAIN_ROOF_RIDGE_STAIRS = fromBlock(ModBlocks.YELLOW_MAIN_ROOF_RIDGE_STAIRS, CreativeTabData.BUILDING_BLOCKS);

    /**
     * DECORATIVE BLOCKS
     */

    // SIMPLE CARVED WOOD

    public static final Item RED_CARVED_WOOD = fromBlock(ModBlocks.RED_CARVED_WOOD, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item RED_CARVED_WOODEN_SLAB = fromBlock(ModBlocks.RED_CARVED_WOODEN_SLAB, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item RED_CARVED_WOODEN_STAIRS = fromBlock(ModBlocks.RED_CARVED_WOODEN_STAIRS, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_CARVED_WOOD = fromBlock(ModBlocks.BLUE_CARVED_WOOD, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_CARVED_WOODEN_SLAB = fromBlock(ModBlocks.BLUE_CARVED_WOODEN_SLAB, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_CARVED_WOODEN_STAIRS = fromBlock(ModBlocks.BLUE_CARVED_WOODEN_STAIRS, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_CARVED_WOODEN_BRACKET = fromBlock(ModBlocks.BLUE_CARVED_WOODEN_BRACKET, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_CARVED_WOODEN_BRACKET_STAIRS = fromBlock(ModBlocks.BLUE_CARVED_WOODEN_BRACKET_STAIRS, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CYAN_CARVED_WOOD = fromBlock(ModBlocks.CYAN_CARVED_WOOD, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CYAN_CARVED_WOODEN_SLAB = fromBlock(ModBlocks.CYAN_CARVED_WOODEN_SLAB, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CYAN_CARVED_WOODEN_STAIRS = fromBlock(ModBlocks.CYAN_CARVED_WOODEN_STAIRS, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CYAN_CARVED_WOODEN_BRACKET = fromBlock(ModBlocks.CYAN_CARVED_WOODEN_BRACKET, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GREEN_CARVED_WOOD = fromBlock(ModBlocks.GREEN_CARVED_WOOD, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GREEN_CARVED_WOODEN_SLAB = fromBlock(ModBlocks.GREEN_CARVED_WOODEN_SLAB, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GREEN_CARVED_WOODEN_STAIRS = fromBlock(ModBlocks.GREEN_CARVED_WOODEN_STAIRS, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GREEN_CARVED_WOODEN_BRACKET = fromBlock(ModBlocks.GREEN_CARVED_WOODEN_BRACKET, CreativeTabData.DECORATIVE_BLOCKS);

    // MIXED CARVED WOOD

    public static final Item ORANGE_AND_BLUE_CARVED_WOOD = fromBlock(ModBlocks.ORANGE_AND_BLUE_CARVED_WOOD, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item ORANGE_AND_GREEN_CARVED_WOOD = fromBlock(ModBlocks.ORANGE_AND_GREEN_CARVED_WOOD, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GREEN_AND_BLUE_CARVED_WOOD = fromBlock(ModBlocks.GREEN_AND_BLUE_CARVED_WOOD, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item DARK_GREEN_AND_DARK_BLUE_CARVED_WOOD = fromBlock(ModBlocks.DARK_GREEN_AND_DARK_BLUE_CARVED_WOOD, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item DARK_BLUE_AND_DARK_GREEN_CARVED_WOOD = fromBlock(ModBlocks.DARK_BLUE_AND_DARK_GREEN_CARVED_WOOD, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLACK_WHITE_GREEN_CARVED_WOOD = fromBlock(ModBlocks.BLACK_WHITE_GREEN_CARVED_WOOD, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLACK_WHITE_BLUE_CARVED_WOOD = fromBlock(ModBlocks.BLACK_WHITE_BLUE_CARVED_WOOD, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item RED_AND_GREEN_CARVED_WOOD = fromBlock(ModBlocks.RED_AND_GREEN_CARVED_WOOD, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_AND_WHITE_CARVED_WOOD = fromBlock(ModBlocks.BLUE_AND_WHITE_CARVED_WOOD, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_WHITE_RED_CARVED_WOOD = fromBlock(ModBlocks.BLUE_WHITE_RED_CARVED_WOOD, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GREEN_WHITE_RED_CARVED_WOOD = fromBlock(ModBlocks.GREEN_WHITE_RED_CARVED_WOOD, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1 = fromBlock(ModBlocks.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2 = fromBlock(ModBlocks.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3 = fromBlock(ModBlocks.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item YELLOW_AND_GREEN_CARVED_WOOD = fromBlock(ModBlocks.YELLOW_AND_GREEN_CARVED_WOOD, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item YELLOW_GREEN_BLUE_CARVED_WOOD = fromBlock(ModBlocks.YELLOW_GREEN_BLUE_CARVED_WOOD, CreativeTabData.DECORATIVE_BLOCKS);

    // DARK OAK

    public static final Item CARVED_DARK_OAK_BEAM = fromBlock(ModBlocks.CARVED_DARK_OAK_BEAM, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CARVED_DARK_OAK_BEAM_EDGE = fromBlock(ModBlocks.CARVED_DARK_OAK_BEAM_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GILDED_DARK_OAK = fromBlock(ModBlocks.GILDED_DARK_OAK, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CHISELED_GILDED_DARK_OAK = fromBlock(ModBlocks.CHISELED_GILDED_DARK_OAK, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GILDED_DARK_OAK_SLAB = fromBlock(ModBlocks.GILDED_DARK_OAK_SLAB, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GILDED_DARK_OAK_STAIRS = fromBlock(ModBlocks.GILDED_DARK_OAK_STAIRS, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GILDED_DARK_OAK_BEAM_BRACKET = fromBlock(ModBlocks.GILDED_DARK_OAK_BRACKET, CreativeTabData.DECORATIVE_BLOCKS);

    // PILLARS

    public static final Item CARVED_RED_PILLAR = fromBlock(ModBlocks.CARVED_RED_PILLAR, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CARVED_RED_PILLAR_BASE = fromBlock(ModBlocks.CARVED_RED_PILLAR_BASE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CARVED_RED_PILLAR_HEAD = fromBlock(ModBlocks.CARVED_RED_PILLAR_HEAD, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item SPRUCE_PILLAR_BASE = fromBlock(ModBlocks.SPRUCE_PILLAR_BASE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item STRIPPED_DARK_OAK_PILLAR_BASE = fromBlock(ModBlocks.STRIPPED_DARK_OAK_PILLAR_BASE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_1 = fromBlock(ModBlocks.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_1, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_2 = fromBlock(ModBlocks.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_2, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_3 = fromBlock(ModBlocks.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_3, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_4 = fromBlock(ModBlocks.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_4, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_5 = fromBlock(ModBlocks.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_5, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CYAN_AND_WHITE_PILLAR_BASE = fromBlock(ModBlocks.CYAN_AND_WHITE_PILLAR_BASE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CYAN_AND_WHITE_DECORATED_PILLAR = fromBlock(ModBlocks.CYAN_AND_WHITE_DECORATED_PILLAR, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CYAN_AND_WHITE_PILLAR_HEAD = fromBlock(ModBlocks.CYAN_AND_WHITE_PILLAR_HEAD, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item STONE_PILLAR_BASE = fromBlock(ModBlocks.STONE_PILLAR_BASE, CreativeTabData.DECORATIVE_BLOCKS);

    // FANGXIN

    public static final Item GREEN_FANGXIN = fromBlock(ModBlocks.GREEN_FANGXIN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GREEN_FANGXIN_EDGE = fromBlock(ModBlocks.GREEN_FANGXIN_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_FANGXIN = fromBlock(ModBlocks.BLUE_FANGXIN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_FANGXIN_EDGE = fromBlock(ModBlocks.BLUE_FANGXIN_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CYAN_AND_BLUE_FANGXIN = fromBlock(ModBlocks.CYAN_AND_BLUE_FANGXIN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CYAN_AND_BLUE_FANGXIN_EDGE = fromBlock(ModBlocks.CYAN_AND_BLUE_FANGXIN_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CYAN_AND_BLUE_FANGXIN_EDGE_VARIANT = fromBlock(ModBlocks.CYAN_AND_BLUE_FANGXIN_EDGE_VARIANT, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CYAN_BLUE_WHITE_FANGXIN = fromBlock(ModBlocks.CYAN_BLUE_WHITE_FANGXIN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CYAN_BLUE_WHITE_FANGXIN_EDGE = fromBlock(ModBlocks.CYAN_BLUE_WHITE_FANGXIN_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_AND_GREEN_FANGXIN_EDGE = fromBlock(ModBlocks.BLUE_AND_GREEN_FANGXIN_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item YELLOW_AND_GREEN_FANGXIN_EDGE = fromBlock(ModBlocks.YELLOW_AND_GREEN_FANGXIN_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item DARK_BLUE_FANGXIN = fromBlock(ModBlocks.DARK_BLUE_FANGXIN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item DARK_BLUE_FANGXIN_EDGE = fromBlock(ModBlocks.DARK_BLUE_FANGXIN_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_AND_WHITE_FANGXIN = fromBlock(ModBlocks.BLUE_AND_WHITE_FANGXIN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GREEN_AND_DARK_BLUE_FANGXIN = fromBlock(ModBlocks.GREEN_AND_DARK_BLUE_FANGXIN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item WHITE_AND_CYAN_FANGXIN = fromBlock(ModBlocks.WHITE_AND_CYAN_FANGXIN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item WHITE_AND_CYAN_FANGXIN_EDGE = fromBlock(ModBlocks.WHITE_AND_CYAN_FANGXIN_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item WHITE_AND_BLUE_FANGXIN = fromBlock(ModBlocks.WHITE_AND_BLUE_FANGXIN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item WHITE_AND_BLUE_FANGXIN_EDGE = fromBlock(ModBlocks.WHITE_AND_BLUE_FANGXIN_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item RED_CYAN_BLUE_FANGXIN = fromBlock(ModBlocks.RED_CYAN_BLUE_FANGXIN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item RED_CYAN_BLUE_FANGXIN_EDGE = fromBlock(ModBlocks.RED_CYAN_BLUE_FANGXIN_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_CYAN_BLUE_FANGXIN_EDGE = fromBlock(ModBlocks.BLUE_CYAN_BLUE_FANGXIN_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_CYAN_RED_FANGXIN = fromBlock(ModBlocks.BLUE_CYAN_RED_FANGXIN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_CYAN_RED_FANGXIN_EDGE = fromBlock(ModBlocks.BLUE_CYAN_RED_FANGXIN_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CYAN_BLUE_CYAN_FANGXIN = fromBlock(ModBlocks.CYAN_BLUE_CYAN_FANGXIN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item RED_BLUE_RED_FANGXIN = fromBlock(ModBlocks.RED_BLUE_RED_FANGXIN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CYAN_AND_YELLOW_FANGXIN_EDGE = fromBlock(ModBlocks.CYAN_AND_YELLOW_FANGXIN_EDGE, CreativeTabData.DECORATIVE_BLOCKS);

    // ZHAOTOU

    public static final Item BLUE_ZHAOTOU_EDGE = fromBlock(ModBlocks.BLUE_ZHAOTOU_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GREEN_AND_BLUE_ZHAOTOU = fromBlock(ModBlocks.GREEN_AND_BLUE_ZHAOTOU, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_AND_GREEN_ZHAOTOU = fromBlock(ModBlocks.BLUE_AND_GREEN_ZHAOTOU, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item blue_and_green_double_layered_zhaotou = fromBlock(ModBlocks.blue_and_green_double_layered_zhaotou, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CYAN_AND_RED_ZHAOTOU = fromBlock(ModBlocks.CYAN_AND_RED_ZHAOTOU, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CYAN_AND_BLUE_ZHAOTOU = fromBlock(ModBlocks.CYAN_AND_BLUE_ZHAOTOU, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GRAY_BLACK_RED_ZHAOTOU = fromBlock(ModBlocks.GRAY_BLACK_RED_ZHAOTOU, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_GREEN_RED_ZHAOTOU = fromBlock(ModBlocks.BLUE_GREEN_RED_ZHAOTOU, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item RED_AND_BLUE_ZHAOTOU = fromBlock(ModBlocks.RED_AND_BLUE_ZHAOTOU, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GREEN_AND_YELLOW_ZHAOTOU = fromBlock(ModBlocks.GREEN_AND_YELLOW_ZHAOTOU, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item RED_GREEN_BLUE_ZHAOTOU = fromBlock(ModBlocks.RED_GREEN_BLUE_ZHAOTOU, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item WHITE_BLUE_GREEN_ZHAOTOU = fromBlock(ModBlocks.WHITE_BLUE_GREEN_ZHAOTOU, CreativeTabData.DECORATIVE_BLOCKS);

    // GUTOU

    public static final Item GREEN_BLUE_BLACK_GUTOU = fromBlock(ModBlocks.GREEN_BLUE_BLACK_GUTOU, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_GREEN_YELLOW_GUTOU = fromBlock(ModBlocks.BLUE_GREEN_YELLOW_GUTOU, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_AND_YELLOW_GUTOU = fromBlock(ModBlocks.BLUE_AND_YELLOW_GUTOU, CreativeTabData.DECORATIVE_BLOCKS);

    // RAFTERS

    public static final Item GILDED_DARK_OAK_RAFTER = fromBlock(ModBlocks.GILDED_DARK_OAK_RAFTER, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GILDED_DARK_OAK_RAFTER_END = fromBlock(ModBlocks.GILDED_DARK_OAK_RAFTER_END, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item DARK_OAK_RAFTER = fromBlock(ModBlocks.DARK_OAK_RAFTER, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item DARK_OAK_RAFTER_END = fromBlock(ModBlocks.DARK_OAK_RAFTER_END, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_TIGER_EYE_RAFTER = fromBlock(ModBlocks.BLUE_TIGER_EYE_RAFTER, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_TIGER_EYE_RAFTER_END = fromBlock(ModBlocks.BLUE_TIGER_EYE_RAFTER_END, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_CARVED_TIGER_EYE_RAFTER = fromBlock(ModBlocks.BLUE_CARVED_TIGER_EYE_RAFTER, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_CARVED_TIGER_EYE_RAFTER_END = fromBlock(ModBlocks.BLUE_CARVED_TIGER_EYE_RAFTER_END, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GREEN_CARVED_TIGER_EYE_RAFTER = fromBlock(ModBlocks.GREEN_CARVED_TIGER_EYE_RAFTER, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GREEN_CARVED_TIGER_EYE_RAFTER_END = fromBlock(ModBlocks.GREEN_CARVED_TIGER_EYE_RAFTER_END, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GREEN_WANZI_RAFTER = fromBlock(ModBlocks.GREEN_WANZI_RAFTER, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GREEN_WANZI_RAFTER_END = fromBlock(ModBlocks.GREEN_WANZI_RAFTER_END, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GREEN_CARVED_WANZI_RAFTER = fromBlock(ModBlocks.GREEN_CARVED_WANZI_RAFTER, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GREEN_CARVED_WANZI_RAFTER_END = fromBlock(ModBlocks.GREEN_CARVED_WANZI_RAFTER_END, CreativeTabData.DECORATIVE_BLOCKS);

    // BEAM HEAD

    public static final Item GILDED_DARK_OAK_BEAM_HEAD = fromBlock(ModBlocks.GILDED_DARK_OAK_BEAM_HEAD, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item QING_GREEN_BEAM_HEAD = fromBlock(ModBlocks.QING_GREEN_BEAM_HEAD, CreativeTabData.DECORATIVE_BLOCKS);

    // ARCHITRAVE

    public static final Item RED_AND_CYAN_CARVED_ARCHITRAVE = fromBlock(ModBlocks.RED_AND_CYAN_CARVED_ARCHITRAVE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item RED_AND_CYAN_CARVED_ARCHITRAVE_SLAB = fromBlock(ModBlocks.RED_AND_CYAN_CARVED_ARCHITRAVE_SLAB, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item RED_AND_BLUE_CARVED_ARCHITRAVE = fromBlock(ModBlocks.RED_AND_BLUE_CARVED_ARCHITRAVE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item RED_AND_BLUE_CARVED_ARCHITRAVE_SLAB = fromBlock(ModBlocks.RED_AND_BLUE_CARVED_ARCHITRAVE_SLAB, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item EMPTY_TUANHUA_SLAB = fromBlock(ModBlocks.EMPTY_TUANHUA_SLAB, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item FULL_TUANHUA_SLAB = fromBlock(ModBlocks.FULL_TUANHUA_SLAB, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item RED_AND_CYAN_TUANHUA_SLAB = fromBlock(ModBlocks.RED_AND_CYAN_TUANHUA_SLAB, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item RED_CARVED_ARCHITRAVE = fromBlock(ModBlocks.RED_CARVED_ARCHITRAVE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item WHITE_AND_RED_SLAB = fromBlock(ModBlocks.WHITE_AND_RED_SLAB, CreativeTabData.DECORATIVE_BLOCKS);

    // QUETI

    public static final Item LONG_GILDED_DARK_OAK_QUETI = fromBlock(ModBlocks.LONG_GILDED_DARK_OAK_QUETI, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item LONG_GILDED_DARK_OAK_QUETI_EDGE = fromBlock(ModBlocks.LONG_GILDED_DARK_OAK_QUETI_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item HORIZONTAL_GILDED_DARK_OAK_QUETI = fromBlock(ModBlocks.HORIZONTAL_GILDED_DARK_OAK_QUETI, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CENTRAL_GILDED_DARK_OAK_QUETI = fromBlock(ModBlocks.CENTRAL_GILDED_DARK_OAK_QUETI, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item VERTICAL_GILDED_DARK_OAK_QUETI = fromBlock(ModBlocks.VERTICAL_GILDED_DARK_OAK_QUETI, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item WOODEN_QUETI = fromBlock(ModBlocks.WOODEN_QUETI, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item WOODEN_QUETI_EDGE = fromBlock(ModBlocks.WOODEN_QUETI_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item TALL_WOODEN_QUETI_EDGE = fromBlock(ModBlocks.TALL_WOODEN_QUETI_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item LARGE_WOODEN_QUETI_EDGE = fromBlock(ModBlocks.LARGE_WOODEN_QUETI_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item SHORT_GLAZED_QUETI = fromBlock(ModBlocks.SHORT_GLAZED_QUETI, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item THICK_CARVED_QUETI = fromBlock(ModBlocks.THICK_CARVED_QUETI, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item SHORT_THICK_GLAZED_QUETI = fromBlock(ModBlocks.SHORT_THICK_GLAZED_QUETI, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item WOODEN_GUALUO = fromBlock(ModBlocks.WOODEN_GUALUO, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item LARGE_WOODEN_GUALUO = fromBlock(ModBlocks.LARGE_WOODEN_GUALUO, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item LARGE_WOODEN_GUALUO_EDGE = fromBlock(ModBlocks.LARGE_WOODEN_GUALUO_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CARVED_STONE_PANEL = fromBlock(ModBlocks.CARVED_STONE_PANEL, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CARVED_STONE_PANEL_EDGE = fromBlock(ModBlocks.CARVED_STONE_PANEL_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CARVED_STONE_PANEL_CENTER = fromBlock(ModBlocks.CARVED_STONE_PANEL_CENTER, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CARVED_STONE_QUETI_PART = fromBlock(ModBlocks.CARVED_STONE_QUETI_PART, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CARVED_STONE_BEAM = fromBlock(ModBlocks.CARVED_STONE_BEAM, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CARVED_STONE_QUETI = fromBlock(ModBlocks.CARVED_STONE_QUETI, CreativeTabData.DECORATIVE_BLOCKS);

    // PATTERNS

    public static final Item YELLOW_CARVED_PATTERN = fromBlock(ModBlocks.YELLOW_CARVED_PATTERN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CIRCULAR_YELLOW_CARVED_PATTERN = fromBlock(ModBlocks.CIRCULAR_YELLOW_CARVED_PATTERN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item YELLOW_CARVED_FANGXIN_EDGE_PATTERN = fromBlock(ModBlocks.YELLOW_CARVED_FANGXIN_EDGE_PATTERN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item YELLOW_CARVED_FANGXIN_PATTERN = fromBlock(ModBlocks.YELLOW_CARVED_FANGXIN_PATTERN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item LARGE_YELLOW_CARVED_PATTERN = fromBlock(ModBlocks.LARGE_YELLOW_CARVED_PATTERN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item MEDIUM_YELLOW_CARVED_PATTERN = fromBlock(ModBlocks.MEDIUM_YELLOW_CARVED_PATTERN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item YELLOW_CARVED_ZHAOTOU_PATTERN = fromBlock(ModBlocks.YELLOW_CARVED_ZHAOTOU_PATTERN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item LONG_YELLOW_CARVED_ZHAOTOU_PATTERN = fromBlock(ModBlocks.LONG_YELLOW_CARVED_ZHAOTOU_PATTERN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CARVED_ZHAOTOU_PATTERN = fromBlock(ModBlocks.CARVED_ZHAOTOU_PATTERN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item FLAME_ARCH_WALL_PATTERN = fromBlock(ModBlocks.FLAME_ARCH_WALL_PATTERN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GOLDEN_DRAGON_FANGXIN_PATTERN = fromBlock(ModBlocks.GOLDEN_DRAGON_FANGXIN_PATTERN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_FANGXIN_PATTERN = fromBlock(ModBlocks.BLUE_FANGXIN_PATTERN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BLUE_FANGXIN_PATTERN_EDGE = fromBlock(ModBlocks.BLUE_FANGXIN_PATTERN_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GREEN_FANGXIN_PATTERN = fromBlock(ModBlocks.GREEN_FANGXIN_PATTERN, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GREEN_FANGXIN_PATTERN_EDGE = fromBlock(ModBlocks.GREEN_FANGXIN_PATTERN_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item LIGHT_BLUE_SU_STYLE_CAIHUA = fromBlock(ModBlocks.LIGHT_BLUE_SU_STYLE_CAIHUA, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item YELLOW_SU_STYLE_CAIHUA = fromBlock(ModBlocks.YELLOW_SU_STYLE_CAIHUA, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item LIGHT_YELLOW_SU_STYLE_CAIHUA = fromBlock(ModBlocks.LIGHT_YELLOW_SU_STYLE_CAIHUA, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item MEDIUM_SU_STYLE_CAIHUA = fromBlock(ModBlocks.MEDIUM_SU_STYLE_CAIHUA, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item LARGE_WHITE_SU_STYLE_CAIHUA = fromBlock(ModBlocks.LARGE_WHITE_SU_STYLE_CAIHUA, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item LARGE_GREEN_SU_STYLE_CAIHUA = fromBlock(ModBlocks.LARGE_GREEN_SU_STYLE_CAIHUA, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item LARGE_GRAY_SU_STYLE_CAIHUA = fromBlock(ModBlocks.LARGE_GRAY_SU_STYLE_CAIHUA, CreativeTabData.DECORATIVE_BLOCKS);

    // CHUIHUA

    public static final Item BLUE_AND_GREEN_CHUIHUA = fromBlock(ModBlocks.BLUE_AND_GREEN_CHUIHUA, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CYAN_AND_YELLOW_CHUIHUA = fromBlock(ModBlocks.CYAN_AND_YELLOW_CHUIHUA, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GILDED_DARK_OAK_CHUIHUA = fromBlock(ModBlocks.GILDED_DARK_OAK_CHUIHUA, CreativeTabData.DECORATIVE_BLOCKS);

    // ROOF CHARM

    public static final Item GOLDEN_GLAZED_ROOF_CHARM = fromBlock(ModBlocks.GOLDEN_GLAZED_ROOF_CHARM, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GOLDEN_GLAZED_ROOF_CHARM_ACCESSORY = fromBlock(ModBlocks.GOLDEN_GLAZED_ROOF_CHARM_ACCESSORY, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item GREEN_GLAZED_ROOF_CHARM = fromBlock(ModBlocks.GREEN_GLAZED_ROOF_CHARM, CreativeTabData.DECORATIVE_BLOCKS);

    // CEILING

    public static final Item QING_GOLDEN_DRAGON_CEILING = fromBlock(ModBlocks.QING_GOLDEN_DRAGON_CEILING, CreativeTabData.DECORATIVE_BLOCKS);

    // RAILING

    public static final Item WHITE_MARBLE_RAILING = fromBlock(ModBlocks.WHITE_MARBLE_RAILING, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item WHITE_MARBLE_RAILING_SLANT = fromBlock(ModBlocks.WHITE_MARBLE_RAILING_SLANT, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CARVED_WOODEN_RAILING = fromBlock(ModBlocks.CARVED_WOODEN_RAILING, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item RED_WOODEN_RAILING = fromBlock(ModBlocks.RED_WOODEN_RAILING, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item RED_WOODEN_RAILING_EDGE = fromBlock(ModBlocks.RED_WOODEN_RAILING_EDGE, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item WOODEN_RAILING = fromBlock(ModBlocks.WOODEN_RAILING, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item WOODEN_RAILING_VARIANT = fromBlock(ModBlocks.WOODEN_RAILING_VARIANT, CreativeTabData.DECORATIVE_BLOCKS);

    // GUARDIAN LION

    public static final Item SMALL_WOODEN_GUARDIAN_LION = fromBlock(ModBlocks.SMALL_WOODEN_GUARDIAN_LION, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item SMALL_STONE_GUARDIAN_LION = fromBlock(ModBlocks.SMALL_STONE_GUARDIAN_LION, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item SMALL_JADE_GUARDIAN_LION = fromBlock(ModBlocks.SMALL_JADE_GUARDIAN_LION, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item SMALL_YELLOW_GLAZED_GUARDIAN_LION = fromBlock(ModBlocks.SMALL_YELLOW_GLAZED_GUARDIAN_LION, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item SMALL_GREEN_GLAZED_GUARDIAN_LION = fromBlock(ModBlocks.SMALL_GREEN_GLAZED_GUARDIAN_LION, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item XUMI_STONE_MONOLITH = fromBlock(ModBlocks.XUMI_STONE_MONOLITH, CreativeTabData.DECORATIVE_BLOCKS);

    // MISC DECORATIONS

    public static final Item CABBAGE_BASKET = fromBlock(ModBlocks.CABBAGE_BASKET, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item CELERY_BASKET = fromBlock(ModBlocks.CELERY_BASKET, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item ORANGE_BASKET = fromBlock(ModBlocks.ORANGE_BASKET, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item APPLE_BASKET = fromBlock(ModBlocks.APPLE_BASKET, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item EGGPLANT_BASKET = fromBlock(ModBlocks.EGGPLANT_BASKET, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item PEAR_BASKET = fromBlock(ModBlocks.PEAR_BASKET, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BOOKSHELF = fromBlock(ModBlocks.BOOKSHELF, CreativeTabData.DECORATIVE_BLOCKS);
    public static final Item BOOKSHELF_VARIANT = fromBlock(ModBlocks.BOOKSHELF_VARIANT, CreativeTabData.DECORATIVE_BLOCKS);

    /**
     * DECORATIONS
     */

    // STUDY

    public static final Item ABACUS = fromBlock(ModBlocks.ABACUS, CreativeTabData.DECORATIONS);
    public static final Item BRUSH_TOOLS = fromBlock(ModBlocks.BRUSH_TOOLS, CreativeTabData.DECORATIONS);
    public static final Item BRUSH_AND_INKSTONE = fromBlock(ModBlocks.BRUSH_AND_INKSTONE, CreativeTabData.DECORATIONS);
    public static final Item RULER = fromBlock(ModBlocks.RULER, CreativeTabData.DECORATIONS);
    public static final Item PAINTING_SCROLL = fromBlock(ModBlocks.PAINTING_SCROLL, CreativeTabData.DECORATIONS);
    public static final Item BOOK_STACK = fromBlock(ModBlocks.BOOK_STACK, CreativeTabData.DECORATIONS);
    public static final Item PAPER = fromBlock(ModBlocks.PAPER, CreativeTabData.DECORATIONS);
    public static final Item BLUE_BOOK = fromBlock(ModBlocks.BLUE_BOOK, CreativeTabData.DECORATIONS);
    public static final Item BAMBOO_SLIPS = fromBlock(ModBlocks.BAMBOO_SLIPS, CreativeTabData.DECORATIONS);

    // ROOM DECO

    public static final Item BACK_CUSHION = fromBlock(ModBlocks.BACK_CUSHION, CreativeTabData.DECORATIONS);
    public static final Item CHESSBOARD = fromBlock(ModBlocks.CHESSBOARD, CreativeTabData.DECORATIONS);
    public static final Item BLUE_AND_WHITE_PORCELAIN_VASE = fromBlock(ModBlocks.BLUE_AND_WHITE_PORCELAIN_VASE, CreativeTabData.DECORATIONS);
    public static final Item LARGE_BLUE_AND_WHITE_PORCELAIN_VASE = fromBlock(ModBlocks.LARGE_BLUE_AND_WHITE_PORCELAIN_VASE, CreativeTabData.DECORATIONS);
    public static final Item SHORT_BLUE_AND_WHITE_PORCELAIN_POT = fromBlock(ModBlocks.SHORT_BLUE_AND_WHITE_PORCELAIN_POT, CreativeTabData.DECORATIONS);
    public static final Item TALL_BLUE_AND_WHITE_PORCELAIN_POT = fromBlock(ModBlocks.TALL_BLUE_AND_WHITE_PORCELAIN_POT, CreativeTabData.DECORATIONS);
    public static final Item BLUE_AND_WHITE_PORCELAIN_BOWL = fromBlock(ModBlocks.BLUE_AND_WHITE_PORCELAIN_BOWL, CreativeTabData.DECORATIONS);
    public static final Item BRONZE_MIRROR = fromBlock(ModBlocks.BRONZE_MIRROR, CreativeTabData.DECORATIONS);
    public static final Item MEMORIAL_TABLET = fromBlock(ModBlocks.MEMORIAL_TABLET, CreativeTabData.DECORATIONS);
    public static final Item BRONZE_CENSER = fromBlock(ModBlocks.BRONZE_CENSER, CreativeTabData.DECORATIONS);
    public static final Item ROYAL_CENSER = fromBlock(ModBlocks.ROYAL_CENSER, CreativeTabData.DECORATIONS);
    public static final Item PORCELAIN_TEAPOT = fromBlock(ModBlocks.PORCELAIN_TEAPOT, CreativeTabData.DECORATIONS);
    public static final Item BOOTS = fromBlock(ModBlocks.BOOTS, CreativeTabData.DECORATIONS);
    public static final Item JADE_PENDANT = fromBlock(ModBlocks.JADE_PENDANT, CreativeTabData.DECORATIONS);
    public static final Item IMPERIAL_JADE_SEAL = fromBlock(ModBlocks.IMPERIAL_JADE_SEAL, CreativeTabData.DECORATIONS);
    public static final Item LONG_PILLOW = fromBlock(ModBlocks.LONG_PILLOW, CreativeTabData.DECORATIONS);

    // MISC OBJECTS

    public static final Item RED_SILK_FABRIC_ROLL = fromBlock(ModBlocks.RED_SILK_FABRIC_ROLL, CreativeTabData.DECORATIONS);
    public static final Item GREEN_SILK_FABRIC_ROLL = fromBlock(ModBlocks.GREEN_SILK_FABRIC_ROLL, CreativeTabData.DECORATIONS);
    public static final Item PURPLE_SILK_FABRIC_ROLL = fromBlock(ModBlocks.PURPLE_SILK_FABRIC_ROLL, CreativeTabData.DECORATIONS);
    public static final Item CLAY_DOLL_MALE = fromBlock(ModBlocks.CLAY_DOLL_MALE, CreativeTabData.DECORATIONS);
    public static final Item CLAY_DOLL_FEMALE = fromBlock(ModBlocks.CLAY_DOLL_FEMALE, CreativeTabData.DECORATIONS);
    public static final Item BOTTLE_GOURD = fromBlock(ModBlocks.BOTTLE_GOURD, CreativeTabData.DECORATIONS);

    // FLOWER POTS

    public static final Item BLUE_AND_WHITE_PORCELAIN_FLOWERPOT = fromBlock(ModBlocks.BLUE_AND_WHITE_PORCELAIN_FLOWERPOT, CreativeTabData.DECORATIONS);
    public static final Item TERRACOTTA_FLOWERPOT = fromBlock(ModBlocks.TERRACOTTA_FLOWERPOT, CreativeTabData.DECORATIONS);
    public static final Item BLACK_IRON_FLOWERPOT = fromBlock(ModBlocks.BLACK_IRON_FLOWERPOT, CreativeTabData.DECORATIONS);
    public static final Item BLUE_PORCELAIN_FLOWERPOT = fromBlock(ModBlocks.BLUE_PORCELAIN_FLOWERPOT, CreativeTabData.DECORATIONS);

    // COURTYARD

    public static final Item SACK = fromBlock(ModBlocks.SACK, CreativeTabData.DECORATIONS);
    public static final Item BAMBOO_TEA_BASKET = fromBlock(ModBlocks.BAMBOO_TEA_BASKET, CreativeTabData.DECORATIONS);
    public static final Item EMPTY_BAMBOO_TEA_BASKET = fromBlock(ModBlocks.EMPTY_BAMBOO_TEA_BASKET, CreativeTabData.DECORATIONS);
    public static final Item STRAW_HAT = fromBlock(ModBlocks.STRAW_HAT, CreativeTabData.DECORATIONS);
    public static final Item KNIFE = fromBlock(ModBlocks.KNIFE, CreativeTabData.DECORATIONS);
    public static final Item SUNDIAL = fromBlock(ModBlocks.SUNDIAL, CreativeTabData.DECORATIONS);
    public static final Item BROOM = fromBlock(ModBlocks.BROOM, CreativeTabData.DECORATIONS);
    public static final Item STONE_PEDESTAL = fromBlock(ModBlocks.STONE_PEDESTAL, CreativeTabData.DECORATIONS);
    public static final Item TERRACOTTA_POT = fromBlock(ModBlocks.TERRACOTTA_POT, CreativeTabData.DECORATIONS);
    public static final Item CHINESE_HERBS_BAG = fromBlock(ModBlocks.CHINESE_HERBS_BAG, CreativeTabData.DECORATIONS);
    public static final Item FRUIT_BOX = fromBlock(ModBlocks.FRUIT_BOX, CreativeTabData.DECORATIONS);
    public static final Item WOODEN_CRATE = fromBlock(ModBlocks.WOODEN_CRATE, CreativeTabData.DECORATIONS);
    public static final Item GUNNY_SACK = fromBlock(ModBlocks.GUNNY_SACK, CreativeTabData.DECORATIONS);
    public static final Item BRONZE_DING = fromBlock(ModBlocks.BRONZE_DING, CreativeTabData.DECORATIONS);
    public static final Item CARRIAGE = fromBlock(ModBlocks.CARRIAGE, CreativeTabData.DECORATIONS);
    public static final Item WOODEN_POLES = fromBlock(ModBlocks.WOODEN_POLES, CreativeTabData.DECORATIONS);
    public static final Item TEAHOUSE_FLAG = fromBlock(ModBlocks.TEAHOUSE_FLAG, CreativeTabData.DECORATIONS);
    public static final Item KNIFE_REST = fromBlock(ModBlocks.KNIFE_REST, CreativeTabData.DECORATIONS);

    // WALL HANGING

    public static final Item LONG_HANGING_PAINTING = fromBlock(ModBlocks.LONG_HANGING_PAINTING, CreativeTabData.DECORATIONS);
    public static final Item WHITE_LANDSCAPE_PAINTING = fromBlock(ModBlocks.WHITE_LANDSCAPE_PAINTING, CreativeTabData.DECORATIONS);
    public static final Item HORIZONTAL_OLD_LANDSCAPE_PAINTING = fromBlock(ModBlocks.HORIZONTAL_OLD_LANDSCAPE_PAINTING, CreativeTabData.DECORATIONS);
    public static final Item HORIZONTAL_CALLIGRAPHY = fromBlock(ModBlocks.HORIZONTAL_CALLIGRAPHY, CreativeTabData.DECORATIONS);
    public static final Item HORIZONTAL_LANDSCAPE_PAINTING = fromBlock(ModBlocks.HORIZONTAL_LANDSCAPE_PAINTING, CreativeTabData.DECORATIONS);
    public static final Item LONG_YELLOW_HANGING_PAINTING = fromBlock(ModBlocks.LONG_YELLOW_HANGING_PAINTING, CreativeTabData.DECORATIONS);
    public static final Item DAMAGED_LANDSCAPE_PAINTING = fromBlock(ModBlocks.DAMAGED_LANDSCAPE_PAINTING, CreativeTabData.DECORATIONS);
    public static final Item PORTRAIT = fromBlock(ModBlocks.PORTRAIT, CreativeTabData.DECORATIONS);
    public static final Item HANGING_PAINTING_FAN = fromBlock(ModBlocks.HANGING_PAINTING_FAN, CreativeTabData.DECORATIONS);
    public static final Item SINCERE_CALLIGRAPHY = fromBlock(ModBlocks.SINCERE_CALLIGRAPHY, CreativeTabData.DECORATIONS);

    // FOOD

    public static final Item FOOD_HAMPER = fromBlock(ModBlocks.FOOD_HAMPER, CreativeTabData.DECORATIONS);
    public static final Item PLATED_MOON_CAKES = fromBlock(ModBlocks.PLATED_MOONCAKES, CreativeTabData.DECORATIONS);
    public static final Item PLATED_MUNG_BEAN_CAKES = fromBlock(ModBlocks.PLATED_MUNG_BEAN_CAKES, CreativeTabData.DECORATIONS);
    public static final Item PLATED_HAM = fromBlock(ModBlocks.PLATED_HAM, CreativeTabData.DECORATIONS);
    public static final Item PLATED_FISH = fromBlock(ModBlocks.PLATED_FISH, CreativeTabData.DECORATIONS);
    public static final Item SCATTERED_CARROTS = fromBlock(ModBlocks.SCATTERED_CARROTS, CreativeTabData.DECORATIONS);
    public static final Item WINE_POT = fromBlock(ModBlocks.WINE_POT, CreativeTabData.DECORATIONS);
    public static final Item XIAOLONGBAO = fromBlock(ModBlocks.XIAOLONGBAO, CreativeTabData.DECORATIONS);

    /**
     * FURNITURE
     */

    // CABINET

    public static final Item OAK_CABINET = fromBlock(ModBlocks.OAK_CABINET, CreativeTabData.FURNITURE);
    public static final Item WARPED_CABINET = fromBlock(ModBlocks.WARPED_CABINET, CreativeTabData.FURNITURE);
    public static final Item EBONY_CABINET = fromBlock(ModBlocks.EBONY_CABINET, CreativeTabData.FURNITURE);

    // TABLE

    public static final Item LARGE_TEA_TABLE = fromBlock(ModBlocks.LARGE_TEA_TABLE, CreativeTabData.FURNITURE);
    public static final Item CHESS_TABLE = fromBlock(ModBlocks.CHESS_TABLE, CreativeTabData.FURNITURE);
    public static final Item HIGH_TABLE_WITH_WHITE_TOP = fromBlock(ModBlocks.HIGH_TABLE_WITH_WHITE_TOP, CreativeTabData.FURNITURE);
    public static final Item CENSER_TABLE = fromBlock(ModBlocks.CENSER_TABLE, CreativeTabData.FURNITURE);
    public static final Item PORCELAIN_INLAID_TABLE = fromBlock(ModBlocks.PORCELAIN_INLAID_TABLE, CreativeTabData.FURNITURE);
    public static final Item SMALL_TABLE = fromBlock(ModBlocks.SMALL_TABLE, CreativeTabData.FURNITURE);
    public static final Item SMALL_EBONY_TABLE = fromBlock(ModBlocks.SMALL_EBONY_TABLE, CreativeTabData.FURNITURE);
    public static final Item LARGE_TABLE = fromBlock(ModBlocks.LARGE_TABLE, CreativeTabData.FURNITURE);

    // CHAIR

    public static final Item EBONY_CHAIR = fromBlock(ModBlocks.EBONY_CHAIR, CreativeTabData.FURNITURE);
    public static final Item CHAIR_WITH_YELLOW_CUSHION = fromBlock(ModBlocks.CHAIR_WITH_YELLOW_CUSHION, CreativeTabData.FURNITURE);
    public static final Item PAINTED_CHAIR = fromBlock(ModBlocks.PAINTED_CHAIR, CreativeTabData.FURNITURE);
    public static final Item WOODEN_STOOL = fromBlock(ModBlocks.WOODEN_STOOL, CreativeTabData.FURNITURE);
    public static final Item PORCELAIN_INLAID_GRAND_CHAIR = fromBlock(ModBlocks.PORCELAIN_INLAID_GRAND_CHAIR, CreativeTabData.FURNITURE);
    public static final Item YELLOW_CUSHION = fromBlock(ModBlocks.YELLOW_CUSHION, CreativeTabData.FURNITURE);
    public static final Item OAK_BED = fromBlock(ModBlocks.OAK_BED, CreativeTabData.FURNITURE);

    // SCREEN

    public static final Item LARGE_LANDSCAPE_PAINTING_SCREEN = fromBlock(ModBlocks.LARGE_LANDSCAPE_PAINTING_SCREEN, CreativeTabData.FURNITURE);
    public static final Item PAINTED_SCREEN = fromBlock(ModBlocks.PAINTED_SCREEN, CreativeTabData.FURNITURE);

    /**
     * DOOR AND WINDOW
     */

    // DOOR

    public static final Item CARVED_WOODEN_DOOR = fromBlock(ModBlocks.CARVED_WOODEN_DOOR, CreativeTabData.WINDOWS_AND_DOORS);
    public static final Item SONG_WOODEN_DOOR = fromBlock(ModBlocks.SONG_WOODEN_DOOR, CreativeTabData.WINDOWS_AND_DOORS);

    // WINDOW

    public static final Item SONG_WOODEN_WINDOW = fromBlock(ModBlocks.SONG_WOODEN_WINDOW, CreativeTabData.WINDOWS_AND_DOORS);
    public static final Item ROYAL_ROSEWOOD_WINDOW = fromBlock(ModBlocks.ROYAL_ROSEWOOD_WINDOW, CreativeTabData.WINDOWS_AND_DOORS);
    public static final Item TALL_ROYAL_ROSEWOOD_WINDOW = fromBlock(ModBlocks.TALL_ROYAL_ROSEWOOD_WINDOW, CreativeTabData.WINDOWS_AND_DOORS);
    public static final Item GLAZED_TILE_GRID_WINDOW = fromBlock(ModBlocks.GLAZED_TILE_GRID_WINDOW, CreativeTabData.WINDOWS_AND_DOORS);
    public static final Item STONE_FLOWER_WINDOW = fromBlock(ModBlocks.STONE_FLOWER_WINDOW, CreativeTabData.WINDOWS_AND_DOORS);

    // DOOR DECO

    public static final Item KNOCKER = fromBlock(ModBlocks.KNOCKER, CreativeTabData.WINDOWS_AND_DOORS);
    public static final Item ROSEWOOD_PANEL = fromBlock(ModBlocks.ROSEWOOD_PANEL, CreativeTabData.WINDOWS_AND_DOORS);
    public static final Item ROSEWOOD_DOOR_PANEL = fromBlock(ModBlocks.ROSEWOOD_DOOR_PANEL, CreativeTabData.WINDOWS_AND_DOORS);
    public static final Item LARGE_ROSEWOOD_PANEL = fromBlock(ModBlocks.LARGE_ROSEWOOD_PANEL, CreativeTabData.WINDOWS_AND_DOORS);
    public static final Item LARGE_ROSEWOOD_PANEL_EDGE = fromBlock(ModBlocks.LARGE_ROSEWOOD_PANEL_EDGE, CreativeTabData.WINDOWS_AND_DOORS);
    public static final Item CARVED_WOODEN_DOOR_PANEL = fromBlock(ModBlocks.CARVED_WOODEN_DOOR_PANEL, CreativeTabData.WINDOWS_AND_DOORS);
    public static final Item PLAQUE = fromBlock(ModBlocks.PLAQUE, CreativeTabData.WINDOWS_AND_DOORS);
    public static final Item PAPER_STRIP_SEAL = fromBlock(ModBlocks.PAPER_STRIP_SEAL, CreativeTabData.WINDOWS_AND_DOORS);

    // WINDOW DECO

    public static final Item LARGE_BLUE_CURTAIN = fromBlock(ModBlocks.LARGE_BLUE_CURTAIN, CreativeTabData.WINDOWS_AND_DOORS);
    public static final Item MEDIUM_BLUE_CURTAIN = fromBlock(ModBlocks.MEDIUM_BLUE_CURTAIN, CreativeTabData.WINDOWS_AND_DOORS);
    public static final Item SMALL_BLUE_CURTAIN = fromBlock(ModBlocks.SMALL_BLUE_CURTAIN, CreativeTabData.WINDOWS_AND_DOORS);
    public static final Item RED_CURTAIN = fromBlock(ModBlocks.RED_CURTAIN, CreativeTabData.WINDOWS_AND_DOORS);
    public static final Item RED_CURTAIN_CORNER = fromBlock(ModBlocks.RED_CURTAIN_CORNER, CreativeTabData.WINDOWS_AND_DOORS);
    public static final Item BAMBOO_CURTAIN = fromBlock(ModBlocks.BAMBOO_CURTAIN, CreativeTabData.WINDOWS_AND_DOORS);

    /**
     * PLANTS
     */

    // LOTUS

    public static final Item SMALL_LOTUS_LEAF = aquaticPlantItem(ModBlocks.SMALL_LOTUS_LEAF, CreativeTabData.PLANTS);
    public static final Item SMALL_DARK_GREEN_LOTUS_LEAF = aquaticPlantItem(ModBlocks.SMALL_DARK_GREEN_LOTUS_LEAF, CreativeTabData.PLANTS);
    public static final Item MEDIUM_LOTUS_LEAF = aquaticPlantItem(ModBlocks.MEDIUM_LOTUS_LEAF, CreativeTabData.PLANTS);
    public static final Item LARGE_LOTUS_LEAF = aquaticPlantItem(ModBlocks.LARGE_LOTUS_LEAF, CreativeTabData.PLANTS);
    public static final Item TILTED_LOTUS_LEAF = aquaticPlantItem(ModBlocks.TILTED_LOTUS_LEAF, CreativeTabData.PLANTS);
    public static final Item SMALL_LOTUS_LEAF_CLUSTER = aquaticPlantItem(ModBlocks.SMALL_LOTUS_LEAF_CLUSTER, CreativeTabData.PLANTS);
    public static final Item MEDIUM_LOTUS_LEAF_CLUSTER = aquaticPlantItem(ModBlocks.MEDIUM_LOTUS_LEAF_CLUSTER, CreativeTabData.PLANTS);
    public static final Item LOTUS_BUD = aquaticPlantItem(ModBlocks.LOTUS_BUD, CreativeTabData.PLANTS);
    public static final Item MEDIUM_LOTUS = aquaticPlantItem(ModBlocks.MEDIUM_LOTUS, CreativeTabData.PLANTS);

    // IVY

    public static final Item SMALL_RED_IVY = fromBlock(ModBlocks.SMALL_RED_IVY, CreativeTabData.PLANTS);
    public static final Item MEDIUM_RED_IVY = fromBlock(ModBlocks.MEDIUM_RED_IVY, CreativeTabData.PLANTS);
    public static final Item LARGE_RED_IVY = fromBlock(ModBlocks.LARGE_RED_IVY, CreativeTabData.PLANTS);
    public static final Item SMALL_YELLOW_IVY = fromBlock(ModBlocks.SMALL_YELLOW_IVY, CreativeTabData.PLANTS);
    public static final Item MEDIUM_YELLOW_IVY = fromBlock(ModBlocks.MEDIUM_YELLOW_IVY, CreativeTabData.PLANTS);
    public static final Item LARGE_YELLOW_IVY = fromBlock(ModBlocks.LARGE_YELLOW_IVY, CreativeTabData.PLANTS);
    public static final Item SMALL_GREEN_IVY = fromBlock(ModBlocks.SMALL_GREEN_IVY, CreativeTabData.PLANTS);
    public static final Item MEDIUM_GREEN_IVY = fromBlock(ModBlocks.MEDIUM_GREEN_IVY, CreativeTabData.PLANTS);
    public static final Item LARGE_GREEN_IVY = fromBlock(ModBlocks.LARGE_GREEN_IVY, CreativeTabData.PLANTS);

    // LEAVES

    public static final Item SMALL_LEAF_PILE = fromBlock(ModBlocks.SMALL_LEAF_PILE, CreativeTabData.PLANTS);
    public static final Item MEDIUM_LEAF_PILE = fromBlock(ModBlocks.MEDIUM_LEAF_PILE, CreativeTabData.PLANTS);
    public static final Item LARGE_LEAF_PILE = fromBlock(ModBlocks.LARGE_LEAF_PILE, CreativeTabData.PLANTS);

    // BONSAI

    public static final Item SMALL_GREETING_PINE_BONSAI = fromBlock(ModBlocks.SMALL_GREETING_PINE_BONSAI, CreativeTabData.PLANTS);
    public static final Item MEDIUM_GREETING_PINE_BONSAI = fromBlock(ModBlocks.MEDIUM_GREETING_PINE_BONSAI, CreativeTabData.PLANTS);
    public static final Item LARGE_GREETING_PINE_BONSAI = fromBlock(ModBlocks.LARGE_GREETING_PINE_BONSAI, CreativeTabData.PLANTS);
    public static final Item SMALL_WHITE_PORCELAIN_VASE_BONSAI = fromBlock(ModBlocks.SMALL_WHITE_PORCELAIN_VASE_BONSAI, CreativeTabData.PLANTS);
    public static final Item MEDIUM_WHITE_PORCELAIN_VASE_BONSAI = fromBlock(ModBlocks.MEDIUM_WHITE_PORCELAIN_VASE_BONSAI, CreativeTabData.PLANTS);
    public static final Item LARGE_WHITE_PORCELAIN_VASE_BONSAI = fromBlock(ModBlocks.LARGE_WHITE_PORCELAIN_VASE_BONSAI, CreativeTabData.PLANTS);
    public static final Item SMALL_GREEN_PORCELAIN_VASE_BONSAI = fromBlock(ModBlocks.SMALL_GREEN_PORCELAIN_VASE_BONSAI, CreativeTabData.PLANTS);
    public static final Item GREEN_PORCELAIN_VASE_BONSAI = fromBlock(ModBlocks.GREEN_PORCELAIN_VASE_BONSAI, CreativeTabData.PLANTS);
    public static final Item RED_CORAL_BONSAI = fromBlock(ModBlocks.RED_CORAL_BONSAI, CreativeTabData.PLANTS);
    public static final Item RED_PLUM_BONSAI = fromBlock(ModBlocks.RED_PLUM_BONSAI, CreativeTabData.PLANTS);
    public static final Item BAMBOO_BONSAI = fromBlock(ModBlocks.BAMBOO_BONSAI, CreativeTabData.PLANTS);
    public static final Item TALL_BLUE_VASE_BONSAI = fromBlock(ModBlocks.TALL_BLUE_VASE_BONSAI, CreativeTabData.PLANTS);
    public static final Item TALL_BLUE_AND_WHITE_PORCELAIN_BONSAI = fromBlock(ModBlocks.TALL_BLUE_AND_WHITE_PORCELAIN_BONSAI, CreativeTabData.PLANTS);
    public static final Item MEDIUM_BONSAI = fromBlock(ModBlocks.MEDIUM_BONSAI, CreativeTabData.PLANTS);
    public static final Item LARGE_BONSAI = fromBlock(ModBlocks.LARGE_BONSAI, CreativeTabData.PLANTS);

    /**
     * LAMPS
     */

    //LANTERN

    public static final Item OCTAGONAL_PALACE_LANTERN = fromBlock(ModBlocks.OCTAGONAL_PALACE_LANTERN, CreativeTabData.LAMPS);
    public static final Item SQUARE_PALACE_LANTERN = fromBlock(ModBlocks.SQUARE_PALACE_LANTERN, CreativeTabData.LAMPS);
    public static final Item SMALL_RED_LANTERN = fromBlock(ModBlocks.SMALL_RED_LANTERN, CreativeTabData.LAMPS);
    public static final Item WHITE_SKY_LANTERN = fromBlock(ModBlocks.WHITE_SKY_LANTERN, CreativeTabData.LAMPS);
    public static final Item RED_SKY_LANTERN = fromBlock(ModBlocks.RED_SKY_LANTERN, CreativeTabData.LAMPS);
    public static final Item YELLOW_SKY_LANTERN = fromBlock(ModBlocks.YELLOW_SKY_LANTERN, CreativeTabData.LAMPS);

    // LAMP

    public static final Item STANDING_LAMP = fromBlock(ModBlocks.STANDING_LAMP, CreativeTabData.LAMPS);
    public static final Item SMALL_STANDING_LAMP = fromBlock(ModBlocks.SMALL_STANDING_LAMP, CreativeTabData.LAMPS);
    public static final Item STONE_LAMP = fromBlock(ModBlocks.STONE_LAMP, CreativeTabData.LAMPS);

    // CANDLESTICK

    public static final Item RED_CANDLE = fromBlock(ModBlocks.RED_CANDLE, CreativeTabData.LAMPS);
    public static final Item TRICOLOR_CANDLESTICK = fromBlock(ModBlocks.TRICOLOR_CANDLESTICK, CreativeTabData.LAMPS);
    public static final Item JADE_CANDLESTICK = fromBlock(ModBlocks.JADE_CANDLESTICK, CreativeTabData.LAMPS);

    /**
     * MATERIALS
     */

    // ORE BLOCK

    public static final Item JADE_ORE = fromBlock(ModBlocks.JADE_ORE, CreativeTabData.MATERIALS);
    public static final Item MAGNESITE_ORE = fromBlock(ModBlocks.MAGNESITE_ORE, CreativeTabData.MATERIALS);
    public static final Item HEMATITE_ORE = fromBlock(ModBlocks.HEMATITE_ORE, CreativeTabData.MATERIALS);

    // ORE PRODUCT

    public static final Item JADE = simpleItem("jade", CreativeTabData.MATERIALS);
    public static final Item MAGNESITE = simpleItem("magnesite", CreativeTabData.MATERIALS);
    public static final Item MAGNESITE_DUST = simpleItem("magnesite_dust", CreativeTabData.MATERIALS);
    public static final Item RAW_HEMATITE = simpleItem("raw_hematite", CreativeTabData.MATERIALS);
    public static final Item HEMATITE_DUST = simpleItem("hematite_dust", CreativeTabData.MATERIALS);

    // BRICK

    public static final Item CYAN_BRICK = simpleItem("cyan_brick", CreativeTabData.MATERIALS);
    public static final Item BLACK_BRICK = simpleItem("black_brick", CreativeTabData.MATERIALS);
    public static final Item BROWNISH_RED_STONE_BRICK = simpleItem("brownish_red_stone_brick", CreativeTabData.MATERIALS);

    // BRICK MATERIAL

    public static final Item UNFIRED_CLAY_BRICK = simpleItem("unfired_clay_brick", CreativeTabData.MATERIALS);
    public static final Item UNFIRED_RAW_CYAN_BRICK = simpleItem("unfired_cyan_brick", CreativeTabData.MATERIALS);
    public static final Item UNFIRED_BLACK_BRICK = simpleItem("unfired_black_brick", CreativeTabData.MATERIALS);
    public static final Item UNFIRED_RAW_BROWNISH_RED_STONE_BRICK = simpleItem("unfired_brownish_red_stone_brick", CreativeTabData.MATERIALS);
    public static final Item FIRED_BRICK = simpleItem("fired_brick", CreativeTabData.MATERIALS);
    public static final Item PRISMARINE_DUST = simpleItem("prismarine_dust", CreativeTabData.MATERIALS);

    // ROOF TILE

    public static final Item GRAY_ROOF_TILE = simpleItem("gray_roof_tile", CreativeTabData.MATERIALS);
    public static final Item YELLOW_ROOF_TILE = simpleItem("yellow_roof_tile", CreativeTabData.MATERIALS);
    public static final Item GREEN_ROOF_TILE = simpleItem("green_roof_tile", CreativeTabData.MATERIALS);
    public static final Item BLUE_ROOF_TILE = simpleItem("blue_roof_tile", CreativeTabData.MATERIALS);
    public static final Item CYAN_ROOF_TILE = simpleItem("cyan_roof_tile", CreativeTabData.MATERIALS);
    public static final Item BLACK_ROOF_TILE = simpleItem("black_roof_tile", CreativeTabData.MATERIALS);

    // POLISHED PLANK

    public static final Item POLISHED_OAK_PLANK = simpleItem("polished_oak_plank", CreativeTabData.MATERIALS);
    public static final Item POLISHED_BIRCH_PLANK = simpleItem("polished_birch_plank", CreativeTabData.MATERIALS);
    public static final Item POLISHED_SPRUCE_PLANK = simpleItem("polished_spruce_plank", CreativeTabData.MATERIALS);
    public static final Item POLISHED_JUNGLE_PLANK = simpleItem("polished_jungle_plank", CreativeTabData.MATERIALS);
    public static final Item POLISHED_ACACIA_PLANK = simpleItem("polished_acacia_plank", CreativeTabData.MATERIALS);
    public static final Item POLISHED_DARK_OAK_PLANK = simpleItem("polished_dark_oak_plank", CreativeTabData.MATERIALS);
    public static final Item POLISHED_WARPED_PLANK = simpleItem("polished_warped_plank", CreativeTabData.MATERIALS);
    public static final Item POLISHED_CRIMSON_PLANK = simpleItem("polished_crimson_plank", CreativeTabData.MATERIALS);
    public static final Item POLISHED_ROSEWOOD_PLANK = simpleItem("polished_rosewood_plank", CreativeTabData.MATERIALS);
    public static final Item POLISHED_EBONY_PLANK = simpleItem("polished_ebony_plank", CreativeTabData.MATERIALS);
    public static final Item WOODEN_FRAME = simpleItem("wooden_frame", CreativeTabData.MATERIALS);

    // PORCELAIN

    public static final Item BLUE_AND_WHITE_PORCELAIN_PIECE = simpleItem("blue_and_white_porcelain_piece", CreativeTabData.MATERIALS);
    public static final Item BLUE_AND_WHITE_PORCELAIN_SHARDS = simpleItem("blue_and_white_porcelain_shards", CreativeTabData.MATERIALS);

    // PARTS

    public static final Item WOODEN_PARTS = simpleItem("wooden_parts", CreativeTabData.MATERIALS);
    public static final Item GOLD_PARTS = simpleItem("gold_parts", CreativeTabData.MATERIALS);
    public static final Item JADE_PARTS = simpleItem("jade_parts", CreativeTabData.MATERIALS);
    public static final Item PORCELAIN_PARTS = simpleItem("porcelain_parts", CreativeTabData.MATERIALS);

    // MATERIALS

    public static final Item INCENSE = simpleItem("incense", CreativeTabData.MATERIALS);
    public static final Item FUR = simpleItem("fur", CreativeTabData.MATERIALS);
    public static final Item GREASE = simpleItem("grease", CreativeTabData.MATERIALS);
    public static final Item SILK = simpleItem("silk", CreativeTabData.MATERIALS);
    public static final Item XUAN_PAPER = simpleItem("xuan_paper", CreativeTabData.MATERIALS);
    public static final Item COPPER_CASH_COIN = simpleItem("copper_cash_coin", CreativeTabData.MATERIALS);

    // FOOD

    public static final Item MOONCAKE = foodItem("mooncake", ModFoods.MOONCAKE);
    public static final Item MUNG_BEAN_CAKE = foodItem("mung_bean_cake", ModFoods.MUNG_BEAN_CAKE);
    public static final Item RAW_MEAT = foodItem("raw_meat", ModFoods.RAW_MEAT);
    public static final Item COOKED_MEAT = foodItem("cooked_meat", ModFoods.COOKED_MEAT);
    public static final Item BAOZI = foodItem("baozi", ModFoods.BAOZI);

    /**
     * TOOLS
     */

    public static final Item WOODEN_HAMMER = registerItem("wooden_hammer", new WoodenHammer());
    public static final Item WOODWORKING_WORKBENCH = fromBlock(ModBlocks.WOODWORKING_WORKBENCH, CreativeTabData.TOOLS);

    private static <B extends Block> Item fromBlock(Block block, CreativeTabData tabDef) {
        Item registryObject = registerItem(Registry.BLOCK.getKey(block).getPath(), new BlockItem(block, new FabricItemSettings().tab(tabDef.getTab())));
        CreativeTabData.putItemInSet(registryObject, tabDef);
        return registryObject;
    }

    private static <B extends Block> Item aquaticPlantItem(Block block, CreativeTabData tabDef) {
        Item registryObject = registerItem(Registry.BLOCK.getKey(block).getPath(), new AquaticPlantBlockItem(block, new FabricItemSettings().tab(tabDef.getTab())));
        CreativeTabData.putItemInSet(registryObject, tabDef);
        return registryObject;
    }

//    private static <B extends Block> Item registerBlockItem(String name, BlockItem blockItem, ModCreativeTab tabDef) {
//        Item registryObject = ITEMS.register(name, () -> blockItem);
//        ModCreativeTab.putItemInSet(registryObject, tabDef);
//        return registryObject;
//    }

    private static Item simpleItem(String name, CreativeTabData tabDef) {
        Item registryObject = registerItem(name, new Item(new FabricItemSettings().tab(tabDef.getTab())));
        CreativeTabData.putItemInSet(registryObject, tabDef);
        return registryObject;
    }

    private static Item foodItem(String name, FoodProperties food) {
        Item registryObject = registerItem(name, new BaseFood(food));
        CreativeTabData.putItemInSet(registryObject, CreativeTabData.MATERIALS);
        return registryObject;
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM,
                new ResourceLocation(Ultramarine.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Ultramarine.info("Registering Mod Items for " + Ultramarine.MOD_ID);
    }

}
