package com.voxelutopia.ultramarine.init.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.common.block.*;
import com.voxelutopia.ultramarine.init.data.ContainerType;
import com.voxelutopia.ultramarine.init.data.ModFoods;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.Vec3;

@SuppressWarnings("unused")
public class BlockRegistry {


    /**
     *  BUILDING BLOCKS
     */

    // BRICKS

    public static final Block CYAN_BRICKS = registerBlock("cyan_bricks", new BaseBlock());
    public static final Block CYAN_BRICK_SLAB = registerBlock("cyan_brick_slab", new BaseSlab((BaseBlock) CYAN_BRICKS));
    public static final Block CYAN_BRICK_STAIRS = registerBlock("cyan_brick_stairs", new BaseStairs((BaseBlock) CYAN_BRICKS));
    public static final Block CYAN_BRICK_WALL = registerBlock("cyan_brick_wall", new BaseWall((BaseBlock) CYAN_BRICKS));
    public static final Block BLACK_BRICKS = registerBlock("black_bricks", new BaseBlock());
    public static final Block BLACK_BRICK_SLAB = registerBlock("black_brick_slab", new BaseSlab((BaseBlock) BLACK_BRICKS));
    public static final Block BLACK_BRICK_STAIRS = registerBlock("black_brick_stairs", new BaseStairs((BaseBlock) BLACK_BRICKS));
    public static final Block BLACK_BRICK_WALL = registerBlock("black_brick_wall", new BaseWall((BaseBlock) BLACK_BRICKS));
    public static final Block BROWNISH_RED_STONE_BRICKS = registerBlock("brownish_red_stone_bricks", new BaseBlock());
    public static final Block BROWNISH_RED_STONE_BRICK_SLAB = registerBlock("brownish_red_stone_brick_slab", new BaseSlab((BaseBlock) BROWNISH_RED_STONE_BRICKS));
    public static final Block BROWNISH_RED_STONE_BRICK_STAIRS = registerBlock("brownish_red_stone_brick_stairs", new BaseStairs((BaseBlock) BROWNISH_RED_STONE_BRICKS));
    public static final Block BROWNISH_RED_STONE_BRICK_WALL = registerBlock("brownish_red_stone_brick_wall", new BaseWall((BaseBlock) BROWNISH_RED_STONE_BRICKS));
    public static final Block WHITE_AMD_PINK_MIXED_BRICKS = registerBlock("white_and_pink_mixed_bricks", new BaseBlock(BaseBlockProperty.STONE));
    public static final Block GREEN_WEATHERED_BRICKS = registerBlock("green_weathered_bricks", new BaseBlock(BaseBlockProperty.STONE));

    // STONES

    public static final Block PALE_YELLOW_STONE = registerBlock("pale_yellow_stone", new BaseBlock());
    public static final Block PALE_YELLOW_STONE_SLAB = registerBlock("pale_yellow_stone_slab", new BaseSlab((BaseBlock) PALE_YELLOW_STONE));
    public static final Block PALE_YELLOW_STONE_STAIRS = registerBlock("pale_yellow_stone_stairs", new BaseStairs((BaseBlock) PALE_YELLOW_STONE));
    public static final Block VARIEGATED_ROCKS = registerBlock("variegated_rocks", new BaseBlock());
    public static final Block VARIEGATED_ROCK_SLAB = registerBlock("variegated_rock_slab", new BaseSlab((BaseBlock) VARIEGATED_ROCKS));
    public static final Block VARIEGATED_ROCK_STAIRS = registerBlock("variegated_rock_stairs", new BaseStairs((BaseBlock) VARIEGATED_ROCKS));
    public static final Block WEATHERED_STONE = registerBlock("weathered_stone", new BaseBlock());
    public static final Block WEATHERED_STONE_SLAB = registerBlock("weathered_stone_slab", new BaseSlab((BaseBlock) WEATHERED_STONE));
    public static final Block WEATHERED_STONE_STAIRS = registerBlock("weathered_stone_stairs", new BaseStairs((BaseBlock) WEATHERED_STONE));
    public static final Block POLISHED_WEATHERED_STONE = registerBlock("polished_weathered_stone", new BaseBlock());
    public static final Block POLISHED_WEATHERED_STONE_SLAB = registerBlock("polished_weathered_stone_slab", new BaseSlab((BaseBlock) POLISHED_WEATHERED_STONE));
    public static final Block POLISHED_WEATHERED_STONE_STAIRS = registerBlock("polished_weathered_stone_stairs", new BaseStairs((BaseBlock) POLISHED_WEATHERED_STONE));
    public static final Block POLISHED_WEATHERED_STONE_WALL = registerBlock("polished_weathered_stone_wall", new BaseWall((BaseBlock) POLISHED_WEATHERED_STONE));
    public static final Block GREEN_WEATHERED_STONE = registerBlock("green_weathered_stone", new BaseBlock(BaseBlockProperty.STONE));

    // FLOOR TILES

    public static final Block LIGHT_CYAN_FLOOR_TILE = registerBlock("light_cyan_floor_tile", new BaseBlock(BaseBlockProperty.TILE));
    public static final Block LIGHT_CYAN_FLOOR_TILE_SLAB = registerBlock("light_cyan_floor_tile_slab", new BaseSlab((BaseBlock) LIGHT_CYAN_FLOOR_TILE));
    public static final Block LIGHT_CYAN_FLOOR_TILE_STAIRS = registerBlock("light_cyan_floor_tile_stairs", new BaseStairs((BaseBlock) LIGHT_CYAN_FLOOR_TILE));
    public static final Block LIGHT_CYAN_FLOOR_TILE_WALL = registerBlock("light_cyan_floor_tile_wall", new BaseWall((BaseBlock) LIGHT_CYAN_FLOOR_TILE));
    public static final Block CYAN_FLOOR_TILE = registerBlock("cyan_floor_tile", new BaseBlock(BaseBlockProperty.TILE));
    public static final Block CYAN_FLOOR_TILE_SLAB = registerBlock("cyan_floor_tile_slab", new BaseSlab((BaseBlock) CYAN_FLOOR_TILE));
    public static final Block CYAN_FLOOR_TILE_STAIRS = registerBlock("cyan_floor_tile_stairs", new BaseStairs((BaseBlock) CYAN_FLOOR_TILE));
    public static final Block CYAN_FLOOR_TILE_WALL = registerBlock("cyan_floor_tile_wall", new BaseWall((BaseBlock) CYAN_FLOOR_TILE));
    public static final Block DARK_CYAN_FLOOR_TILE = registerBlock("dark_cyan_floor_tile", new BaseBlock(BaseBlockProperty.STONE));
    public static final Block LAYERED_CYAN_FLOOR_TILES = registerBlock("layered_cyan_floor_tiles", new BaseHorizontalDirectionalBlock(BaseBlockProperty.STONE));
    public static final Block VERTICAL_CYAN_FLOOR_TILES = registerBlock("vertical_cyan_floor_tiles", new BaseHorizontalDirectionalBlock(BaseBlockProperty.STONE));
    public static final Block MIXED_CYAN_FLOOR_TILES = registerBlock("mixed_cyan_floor_tiles", new BaseHorizontalDirectionalBlock(BaseBlockProperty.STONE));
    public static final Block CHISELED_CYAN_FLOOR_TILE = registerBlock("chiseled_cyan_floor_tile", new BaseBlock(BaseBlockProperty.STONE));
    public static final Block CUT_CYAN_FLOOR_TILES = registerBlock("cut_cyan_floor_tiles", new BaseBlock(BaseBlockProperty.STONE));
    public static final Block WEATHERED_RED_STONE_TILE = registerBlock("weathered_red_stone_tile", new BaseBlock(BaseBlockProperty.STONE));
    public static final Block BLUE_AND_BLACK_TILE = registerBlock("blue_and_black_tile", new BaseBlock(BaseBlockProperty.STONE));
    public static final Block GREEN_GLAZED_TILES = registerBlock("green_glazed_tiles", new BaseBlock(BaseBlockProperty.GLAZED));
    public static final Block GREEN_GLAZED_TILE_SLAB = registerBlock("green_glazed_tile_slab", new BaseSlab((BaseBlock) GREEN_GLAZED_TILES));
    public static final Block GREEN_GLAZED_TILE_STAIRS = registerBlock("green_glazed_tile_stairs", new BaseStairs((BaseBlock) GREEN_GLAZED_TILES));
    public static final Block BLACK_FLOOR_TILES = registerBlock("black_floor_tiles", new BaseBlock(BaseBlockProperty.STONE));
    public static final Block BLACK_FLOOR_TILES_LITTLE_MOSSY = registerBlock("black_floor_tiles_little_mossy", new BaseHorizontalDirectionalBlock(BaseBlockProperty.STONE));
    public static final Block BLACK_FLOOR_TILES_MODERATE_MOSSY = registerBlock("black_floor_tiles_moderate_mossy", new BaseHorizontalDirectionalBlock(BaseBlockProperty.STONE));
    public static final Block BLACK_FLOOR_TILES_VERY_MOSSY = registerBlock("black_floor_tiles_very_mossy", new BaseHorizontalDirectionalBlock(BaseBlockProperty.STONE));

    // WOODEN

    public static final Block ROSEWOOD_PLANKS = registerBlock("rosewood_planks", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block ROSEWOOD_SLAB = registerBlock("rosewood_slab", new BaseSlab((BaseBlock) ROSEWOOD_PLANKS));
    public static final Block ROSEWOOD_STAIRS = registerBlock("rosewood_stairs", new BaseStairs((BaseBlock) ROSEWOOD_PLANKS));
    public static final Block ROSEWOOD_FENCE = registerBlock("rosewood_fence", new BaseFence((BaseBlock) ROSEWOOD_PLANKS));
    public static final Block BAMBOO_MAT = registerBlock("bamboo_mat", new BaseBlock(BaseBlockProperty.BAMBOO_WOOD));
    public static final Block BAMBOO_MAT_SLAB = registerBlock("bamboo_mat_slab", new BaseSlab((BaseBlock) BAMBOO_MAT));
    public static final Block BAMBOO_MAT_STAIRS = registerBlock("bamboo_mat_stairs", new BaseStairs((BaseBlock) BAMBOO_MAT));

    // ROOF TILES

    public static final Block GRAY_ROOF_TILES = registerBlock("gray_roof_tiles", new RoofTiles());
    public static final Block GRAY_ROOF_TILE_STAIRS = registerBlock("gray_roof_tile_stairs",  new RoofTiles());
    public static final Block GRAY_ROOF_TILE_EDGE = registerBlock("gray_roof_tile_edge",  new RoofTiles());
    public static final Block YELLOW_ROOF_TILES = registerBlock("yellow_roof_tiles",  new RoofTiles());
    public static final Block YELLOW_ROOF_TILE_STAIRS = registerBlock("yellow_roof_tile_stairs",  new RoofTiles());
    public static final Block YELLOW_ROOF_TILE_EDGE = registerBlock("yellow_roof_tile_edge",  new RoofTiles());
    public static final Block GREEN_ROOF_TILES = registerBlock("green_roof_tiles",  new RoofTiles());
    public static final Block GREEN_ROOF_TILE_STAIRS = registerBlock("green_roof_tile_stairs",  new RoofTiles());
    public static final Block GREEN_ROOF_TILE_EDGE = registerBlock("green_roof_tile_edge",  new RoofTiles());
    public static final Block BLUE_ROOF_TILES = registerBlock("blue_roof_tiles",  new RoofTiles());
    public static final Block BLUE_ROOF_TILE_STAIRS = registerBlock("blue_roof_tile_stairs",  new RoofTiles());
    public static final Block BLUE_ROOF_TILE_EDGE = registerBlock("blue_roof_tile_edge",  new RoofTiles());
    public static final Block CYAN_ROOF_TILES = registerBlock("cyan_roof_tiles",  new RoofTiles());
    public static final Block CYAN_ROOF_TILE_STAIRS = registerBlock("cyan_roof_tile_stairs",  new RoofTiles());
    public static final Block CYAN_ROOF_TILE_EDGE = registerBlock("cyan_roof_tile_edge",  new RoofTiles());
    public static final Block BLACK_ROOF_TILES = registerBlock("black_roof_tiles",  new RoofTiles());
    public static final Block BLACK_ROOF_TILE_STAIRS = registerBlock("black_roof_tile_stairs",  new RoofTiles());
    public static final Block BLACK_ROOF_TILE_EDGE = registerBlock("black_roof_tile_edge",  new RoofTiles());

    // ROOF RIDGE

    public static final Block BLACK_ROOF_RIDGE_UPPER = registerBlock("black_roof_ridge_upper", new BaseBlock(BaseBlockProperty.STONE));
    public static final Block BLACK_ROOF_RIDGE_LOWER = registerBlock("black_roof_ridge_lower", new BaseBlock(BaseBlockProperty.STONE));
    public static final Block BLACK_ROOF_RIDGE_CONNECTION = registerBlock("black_roof_ridge_connection", new BaseAxialBlock(BaseBlockProperty.STONE));
    public static final Block BLACK_MAIN_ROOF_RIDGE_CONNECTION = registerBlock("black_main_roof_ridge_connection", new BaseHorizontalDirectionalBlock(BaseBlockProperty.STONE));
    public static final Block BLACK_ROOF_RIDGE_UPPER_SLAB = registerBlock("black_roof_ridge_upper_slab", new BaseSlab(BaseBlockProperty.STONE));
    public static final Block BLACK_MAIN_ROOF_RIDGE_SLAB = registerBlock("black_main_roof_ridge_slab", new BaseHorizontalDirectionalSlab(BaseBlockProperty.STONE));
    public static final Block BLACK_MAIN_ROOF_RIDGE_PANEL = registerBlock("black_main_roof_ridge_panel", new RoofRidgePanel(BaseBlockProperty.STONE));
    public static final Block BLACK_MAIN_ROOF_RIDGE_PLATE = registerBlock("black_main_roof_ridge_plate", new RoofRidgePlate(BaseBlockProperty.STONE));
    public static final Block BLACK_MAIN_ROOF_RIDGE_STAIRS = registerBlock("black_main_roof_ridge_stairs", new StraightStairBlock(BaseBlockProperty.STONE));
    public static final Block YELLOW_ROOF_RIDGE_UPPER = registerBlock("yellow_roof_ridge_upper", new BaseBlock(BaseBlockProperty.STONE));
    public static final Block YELLOW_ROOF_RIDGE_LOWER = registerBlock("yellow_roof_ridge_lower", new BaseBlock(BaseBlockProperty.STONE));
    public static final Block YELLOW_ROOF_RIDGE_CONNECTION = registerBlock("yellow_roof_ridge_connection", new BaseAxialBlock(BaseBlockProperty.STONE));
    public static final Block YELLOW_MAIN_ROOF_RIDGE_CONNECTION = registerBlock("yellow_main_roof_ridge_connection", new BaseHorizontalDirectionalBlock(BaseBlockProperty.STONE));
    public static final Block YELLOW_ROOF_RIDGE_UPPER_SLAB = registerBlock("yellow_roof_ridge_upper_slab", new BaseSlab(BaseBlockProperty.STONE));
    public static final Block YELLOW_MAIN_ROOF_RIDGE_SLAB = registerBlock("yellow_main_roof_ridge_slab", new BaseHorizontalDirectionalSlab(BaseBlockProperty.STONE));
    public static final Block YELLOW_MAIN_ROOF_RIDGE_PANEL = registerBlock("yellow_main_roof_ridge_panel", new RoofRidgePanel(BaseBlockProperty.STONE));
    public static final Block YELLOW_MAIN_ROOF_RIDGE_PLATE = registerBlock("yellow_main_roof_ridge_plate", new RoofRidgePlate(BaseBlockProperty.STONE));
    public static final Block YELLOW_MAIN_ROOF_RIDGE_STAIRS = registerBlock("yellow_main_roof_ridge_stairs", new StraightStairBlock(BaseBlockProperty.STONE));

    /**
     *  DECORATIVE BLOCKS
     */

    // SIMPLE CARVED WOOD

    public static final Block RED_CARVED_WOOD = registerBlock("red_carved_wood", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block RED_CARVED_WOODEN_SLAB = registerBlock("red_carved_wooden_slab", new BaseSlab(BaseBlockProperty.WOOD));
    public static final Block RED_CARVED_WOODEN_STAIRS = registerBlock("red_carved_wooden_stairs", new StraightStairBlock(BaseBlockProperty.WOOD));
    public static final Block BLUE_CARVED_WOOD = registerBlock("blue_carved_wood", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block BLUE_CARVED_WOODEN_SLAB = registerBlock("blue_carved_wooden_slab", new BaseSlab(BaseBlockProperty.WOOD));
    public static final Block BLUE_CARVED_WOODEN_STAIRS = registerBlock("blue_carved_wooden_stairs", new StraightStairBlock(BaseBlockProperty.WOOD));
    public static final Block BLUE_CARVED_WOODEN_BRACKET_STAIRS = registerBlock("blue_carved_wooden_bracket_stairs", new StraightStairBlock(BaseBlockProperty.WOOD));
    public static final Block BLUE_CARVED_WOODEN_BRACKET = registerBlock("blue_carved_wooden_bracket", new Bracket(BaseBlockProperty.WOOD));
    public static final Block CYAN_CARVED_WOOD = registerBlock("cyan_carved_wood", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block CYAN_CARVED_WOODEN_SLAB = registerBlock("cyan_carved_wooden_slab", new BaseSlab(BaseBlockProperty.WOOD));
    public static final Block CYAN_CARVED_WOODEN_STAIRS = registerBlock("cyan_carved_wooden_stairs", new StraightStairBlock(BaseBlockProperty.WOOD));
    public static final Block CYAN_CARVED_WOODEN_BRACKET = registerBlock("cyan_carved_wooden_bracket", new Bracket(BaseBlockProperty.WOOD));
    public static final Block GREEN_CARVED_WOOD = registerBlock("green_carved_wood", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block GREEN_CARVED_WOODEN_SLAB = registerBlock("green_carved_wooden_slab", new BaseSlab(BaseBlockProperty.WOOD));
    public static final Block GREEN_CARVED_WOODEN_STAIRS = registerBlock("green_carved_wooden_stairs", new StraightStairBlock(BaseBlockProperty.WOOD));
    public static final Block GREEN_CARVED_WOODEN_BRACKET = registerBlock("green_carved_wooden_bracket", new Bracket(BaseBlockProperty.WOOD));

    // MIXED CARVED WOOD

    public static final Block ORANGE_AND_BLUE_CARVED_WOOD = registerBlock("orange_and_blue_carved_wood", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block ORANGE_AND_GREEN_CARVED_WOOD = registerBlock("orange_and_green_carved_wood", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block GREEN_AND_BLUE_CARVED_WOOD = registerBlock("green_and_blue_carved_wood", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block DARK_GREEN_AND_DARK_BLUE_CARVED_WOOD = registerBlock("dark_green_and_dark_blue_carved_wood", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block DARK_BLUE_AND_DARK_GREEN_CARVED_WOOD = registerBlock("dark_blue_and_dark_green_carved_wood", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block BLACK_WHITE_GREEN_CARVED_WOOD = registerBlock("black_white_green_carved_wood", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block BLACK_WHITE_BLUE_CARVED_WOOD = registerBlock("black_white_blue_carved_wood", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block RED_AND_GREEN_CARVED_WOOD = registerBlock("red_and_green_carved_wood", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block BLUE_AND_WHITE_CARVED_WOOD = registerBlock("blue_and_white_carved_wood", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block BLUE_WHITE_RED_CARVED_WOOD = registerBlock("blue_white_red_carved_wood", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block GREEN_WHITE_RED_CARVED_WOOD = registerBlock("green_white_red_carved_wood", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1 = registerBlock("blue_and_yellow_carved_wood_variant_1", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2 = registerBlock("blue_and_yellow_carved_wood_variant_2", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3 = registerBlock("blue_and_yellow_carved_wood_variant_3", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block YELLOW_AND_GREEN_CARVED_WOOD = registerBlock("yellow_and_green_carved_wood", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block YELLOW_GREEN_BLUE_CARVED_WOOD = registerBlock("yellow_green_blue_carved_wood", new BaseBlock(BaseBlockProperty.WOOD));

    // DARK OAK

    public static final Block CARVED_DARK_OAK_BEAM = registerBlock("carved_dark_oak_beam", new ChiralDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block CARVED_DARK_OAK_BEAM_EDGE = registerBlock("carved_dark_oak_beam_edge", new ChiralDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block GILDED_DARK_OAK = registerBlock("gilded_dark_oak", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block CHISELED_GILDED_DARK_OAK = registerBlock("chiseled_gilded_dark_oak", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block GILDED_DARK_OAK_SLAB = registerBlock("gilded_dark_oak_slab", new BaseSlab(BaseBlockProperty.WOOD));
    public static final Block GILDED_DARK_OAK_STAIRS = registerBlock("gilded_dark_oak_stairs", new StraightStairBlock(BaseBlockProperty.WOOD));
    public static final Block GILDED_DARK_OAK_BRACKET = registerBlock("gilded_dark_oak_bracket", new Bracket(BaseBlockProperty.WOOD));

    // PILLARS

    public static final Block CARVED_RED_PILLAR = registerBlock("carved_red_pillar", new BaseBlock(BaseBlockProperty.TERRACOTTA));
    public static final Block CARVED_RED_PILLAR_BASE = registerBlock("carved_red_pillar_base", new BaseBlock(BaseBlockProperty.TERRACOTTA));
    public static final Block CARVED_RED_PILLAR_HEAD = registerBlock("carved_red_pillar_head", new BaseDirectionalBlock(BaseBlockProperty.TERRACOTTA));
    public static final Block SPRUCE_PILLAR_BASE = registerBlock("spruce_pillar_base", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block STRIPPED_DARK_OAK_PILLAR_BASE = registerBlock("stripped_dark_oak_pillar_base", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_1 = registerBlock("gilded_dark_oak_pillar_head_variant_1", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_2 = registerBlock("gilded_dark_oak_pillar_head_variant_2", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_3 = registerBlock("gilded_dark_oak_pillar_head_variant_3", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_4 = registerBlock("gilded_dark_oak_pillar_head_variant_4", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_5 = registerBlock("gilded_dark_oak_pillar_head_variant_5", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block CYAN_AND_WHITE_PILLAR_BASE = registerBlock("cyan_and_white_pillar_base", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block CYAN_AND_WHITE_DECORATED_PILLAR = registerBlock("cyan_and_white_decorated_pillar", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block CYAN_AND_WHITE_PILLAR_HEAD = registerBlock("cyan_and_white_pillar_head", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block STONE_PILLAR_BASE = registerBlock("stone_pillar_base", new BaseBlock(BaseBlockProperty.WOOD));

    // FANGXIN

    public static final Block GREEN_FANGXIN = registerBlock("green_fangxin", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block GREEN_FANGXIN_EDGE = registerBlock("green_fangxin_edge", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block BLUE_FANGXIN = registerBlock("blue_fangxin", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block BLUE_FANGXIN_EDGE = registerBlock("blue_fangxin_edge", new ChiralDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block CYAN_AND_BLUE_FANGXIN = registerBlock("cyan_and_blue_fangxin", new BasePillarBlock(BaseBlockProperty.WOOD));
    public static final Block CYAN_AND_BLUE_FANGXIN_EDGE = registerBlock("cyan_and_blue_fangxin_edge", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block CYAN_AND_BLUE_FANGXIN_EDGE_VARIANT = registerBlock("cyan_and_blue_fangxin_edge_variant", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block CYAN_BLUE_WHITE_FANGXIN = registerBlock("cyan_blue_white_fangxin", new BasePillarBlock(BaseBlockProperty.WOOD));
    public static final Block CYAN_BLUE_WHITE_FANGXIN_EDGE = registerBlock("cyan_blue_white_fangxin_edge", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block BLUE_AND_GREEN_FANGXIN_EDGE = registerBlock("blue_and_green_fangxin_edge", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block YELLOW_AND_GREEN_FANGXIN_EDGE = registerBlock("yellow_and_green_fangxin_edge", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block DARK_BLUE_FANGXIN = registerBlock("dark_blue_fangxin", new BasePillarBlock(BaseBlockProperty.WOOD));
    public static final Block DARK_BLUE_FANGXIN_EDGE = registerBlock("dark_blue_fangxin_edge", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block BLUE_AND_WHITE_FANGXIN = registerBlock("blue_and_white_fangxin", new BasePillarBlock(BaseBlockProperty.WOOD));
    public static final Block GREEN_AND_DARK_BLUE_FANGXIN = registerBlock("green_and_dark_blue_fangxin", new BasePillarBlock(BaseBlockProperty.WOOD));
    public static final Block WHITE_AND_CYAN_FANGXIN = registerBlock("white_and_cyan_fangxin", new BasePillarBlock(BaseBlockProperty.WOOD));
    public static final Block WHITE_AND_CYAN_FANGXIN_EDGE = registerBlock("white_and_cyan_fangxin_edge", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block WHITE_AND_BLUE_FANGXIN = registerBlock("white_and_blue_fangxin", new BasePillarBlock(BaseBlockProperty.WOOD));
    public static final Block WHITE_AND_BLUE_FANGXIN_EDGE = registerBlock("white_and_blue_fangxin_edge", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block RED_CYAN_BLUE_FANGXIN = registerBlock("red_cyan_blue_fangxin", new ChiralDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block RED_CYAN_BLUE_FANGXIN_EDGE = registerBlock("red_cyan_blue_fangxin_edge", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block BLUE_CYAN_BLUE_FANGXIN_EDGE = registerBlock("blue_cyan_blue_fangxin_edge", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block BLUE_CYAN_RED_FANGXIN = registerBlock("blue_cyan_red_fangxin", new ChiralDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block BLUE_CYAN_RED_FANGXIN_EDGE = registerBlock("blue_cyan_red_fangxin_edge", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block CYAN_BLUE_CYAN_FANGXIN = registerBlock("cyan_blue_cyan_fangxin", new ChiralDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block RED_BLUE_RED_FANGXIN = registerBlock("red_blue_red_fangxin", new ChiralDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block CYAN_AND_YELLOW_FANGXIN_EDGE = registerBlock("cyan_and_yellow_fangxin_edge", new BaseDirectionalBlock(BaseBlockProperty.WOOD));

    // ZHAOTOU

    public static final Block BLUE_ZHAOTOU_EDGE = registerBlock("blue_zhaotou_edge", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block GREEN_AND_BLUE_ZHAOTOU = registerBlock("green_and_blue_zhaotou", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block BLUE_AND_GREEN_ZHAOTOU = registerBlock("blue_and_green_zhaotou", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block blue_and_green_double_layered_zhaotou = registerBlock("blue_and_green_double_layered_zhaotou", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block CYAN_AND_RED_ZHAOTOU = registerBlock("cyan_and_red_zhaotou", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block CYAN_AND_BLUE_ZHAOTOU = registerBlock("cyan_and_blue_zhaotou", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block GRAY_BLACK_RED_ZHAOTOU = registerBlock("gray_black_red_zhaotou", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block BLUE_GREEN_RED_ZHAOTOU = registerBlock("blue_green_red_zhaotou", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block RED_AND_BLUE_ZHAOTOU = registerBlock("red_and_blue_zhaotou", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block GREEN_AND_YELLOW_ZHAOTOU = registerBlock("green_and_yellow_zhaotou", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block RED_GREEN_BLUE_ZHAOTOU = registerBlock("red_green_blue_zhaotou", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block WHITE_BLUE_GREEN_ZHAOTOU = registerBlock("white_blue_green_zhaotou", new BaseDirectionalBlock(BaseBlockProperty.WOOD));

    // GUTOU

    public static final Block GREEN_BLUE_BLACK_GUTOU = registerBlock("green_blue_black_gutou", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block BLUE_GREEN_YELLOW_GUTOU = registerBlock("blue_green_yellow_gutou", new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block BLUE_AND_YELLOW_GUTOU = registerBlock("blue_and_yellow_gutou", new BaseDirectionalBlock(BaseBlockProperty.WOOD));

    // RAFTERS

    public static final Block GILDED_DARK_OAK_RAFTER = registerBlock("gilded_dark_oak_rafter", new Rafter(BaseBlockProperty.WOOD));
    public static final Block GILDED_DARK_OAK_RAFTER_END = registerBlock("gilded_dark_oak_rafter_end", new RafterEnd(BaseBlockProperty.WOOD));
    public static final Block DARK_OAK_RAFTER = registerBlock("dark_oak_rafter", new Rafter(BaseBlockProperty.WOOD));
    public static final Block DARK_OAK_RAFTER_END = registerBlock("dark_oak_rafter_end", new RafterEnd(BaseBlockProperty.WOOD));
    public static final Block BLUE_TIGER_EYE_RAFTER = registerBlock("blue_tiger_eye_rafter", new Rafter(BaseBlockProperty.WOOD));
    public static final Block BLUE_TIGER_EYE_RAFTER_END = registerBlock("blue_tiger_eye_rafter_end", new RafterEnd(BaseBlockProperty.WOOD));
    public static final Block BLUE_CARVED_TIGER_EYE_RAFTER = registerBlock("blue_carved_tiger_eye_rafter", new Rafter(BaseBlockProperty.WOOD));
    public static final Block BLUE_CARVED_TIGER_EYE_RAFTER_END = registerBlock("blue_carved_tiger_eye_rafter_end", new RafterEnd(BaseBlockProperty.WOOD));
    public static final Block GREEN_CARVED_TIGER_EYE_RAFTER = registerBlock("green_tiger_eye_rafter", new Rafter(BaseBlockProperty.WOOD));
    public static final Block GREEN_CARVED_TIGER_EYE_RAFTER_END = registerBlock("green_tiger_eye_rafter_end", new RafterEnd(BaseBlockProperty.WOOD));
    public static final Block GREEN_WANZI_RAFTER = registerBlock("green_wanzi_rafter", new Rafter(BaseBlockProperty.WOOD));
    public static final Block GREEN_WANZI_RAFTER_END = registerBlock("green_wanzi_rafter_end", new RafterEnd(BaseBlockProperty.WOOD));
    public static final Block GREEN_CARVED_WANZI_RAFTER = registerBlock("green_carved_wanzi_rafter", new Rafter(BaseBlockProperty.WOOD));
    public static final Block GREEN_CARVED_WANZI_RAFTER_END = registerBlock("green_carved_wanzi_rafter_end", new RafterEnd(BaseBlockProperty.WOOD));

    // BEAM HEAD

    public static final Block GILDED_DARK_OAK_BEAM_HEAD = registerBlock("gilded_dark_oak_beam_head", new BeamHead(BaseBlockProperty.WOOD));
    public static final Block QING_GREEN_BEAM_HEAD = registerBlock("qing_green_beam_head", new WallSideBlock(BaseBlockProperty.WOOD, 14));

    // ARCHITRAVE

    public static final Block RED_AND_CYAN_CARVED_ARCHITRAVE = registerBlock("red_and_cyan_carved_architrave", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block RED_AND_CYAN_CARVED_ARCHITRAVE_SLAB = registerBlock("red_and_cyan_carved_architrave_slab", new BaseSlab(BaseBlockProperty.WOOD));
    public static final Block RED_AND_BLUE_CARVED_ARCHITRAVE = registerBlock("red_and_blue_carved_architrave", new BaseBlock(BaseBlockProperty.WOOD));
    public static final Block RED_AND_BLUE_CARVED_ARCHITRAVE_SLAB = registerBlock("red_and_blue_carved_architrave_slab", new BaseSlab(BaseBlockProperty.WOOD));
    public static final Block EMPTY_TUANHUA_SLAB = registerBlock("empty_tuanhua_slab", new BaseSlab(BaseBlockProperty.WOOD));
    public static final Block FULL_TUANHUA_SLAB = registerBlock("full_tuanhua_slab", new BaseSlab(BaseBlockProperty.WOOD));
    public static final Block RED_AND_CYAN_TUANHUA_SLAB = registerBlock("red_and_cyan_tuanhua_slab", new BaseSlab(BaseBlockProperty.WOOD));
    public static final Block RED_CARVED_ARCHITRAVE = registerBlock("red_carved_architrave", new BaseSlab(BaseBlockProperty.WOOD));
    public static final Block WHITE_AND_RED_SLAB = registerBlock("white_and_red_slab", new BaseSlab(BaseBlockProperty.WOOD));

    // QUETI

    public static final Block LONG_GILDED_DARK_OAK_QUETI = registerBlock("long_gilded_dark_oak_queti", new WallSideBlock(BaseBlockProperty.WOOD));
    public static final Block LONG_GILDED_DARK_OAK_QUETI_EDGE = registerBlock("long_gilded_dark_oak_queti_edge", new OrientableWallSideBlock(BaseBlockProperty.WOOD));
    public static final Block HORIZONTAL_GILDED_DARK_OAK_QUETI = registerBlock("horizontal_gilded_dark_oak_queti", new SideAxialBlock(BaseBlockProperty.WOOD, 4));
    public static final Block CENTRAL_GILDED_DARK_OAK_QUETI = registerBlock("central_gilded_dark_oak_queti", new CentralAxialBlock(BaseBlockProperty.WOOD, 4));
    public static final Block VERTICAL_GILDED_DARK_OAK_QUETI = registerBlock("vertical_gilded_dark_oak_queti", new SideAxialBlock(BaseBlockProperty.WOOD, 4));
    public static final Block WOODEN_QUETI = registerBlock("wooden_queti", new WallSideBlock(BaseBlockProperty.WOOD));
    public static final Block WOODEN_QUETI_EDGE = registerBlock("wooden_queti_edge", new OrientableWallSideBlock(BaseBlockProperty.WOOD));
    public static final Block TALL_WOODEN_QUETI_EDGE = registerBlock("tall_wooden_queti_edge", new OrientableWallSideBlock(BaseBlockProperty.WOOD));
    public static final Block LARGE_WOODEN_QUETI_EDGE = registerBlock("large_wooden_queti_edge", new OrientableWallSideBlock(BaseBlockProperty.WOOD));
    public static final Block SHORT_GLAZED_QUETI = registerBlock("short_glazed_queti", new OrientableWallSideBlock(BaseBlockProperty.WOOD));
    public static final Block THICK_CARVED_QUETI = registerBlock("thick_carved_queti", new SideAxialBlock(BaseBlockProperty.WOOD, 4));
    public static final Block SHORT_THICK_GLAZED_QUETI = registerBlock("short_thick_glazed_queti", new SideAxialBlock(BaseBlockProperty.WOOD, 8));
    public static final Block WOODEN_GUALUO = registerBlock("wooden_gualuo", new WallSideBlock(BaseBlockProperty.WOOD));
    public static final Block LARGE_WOODEN_GUALUO = registerBlock("large_wooden_gualuo", new WallSideBlock(BaseBlockProperty.WOOD));
    public static final Block LARGE_WOODEN_GUALUO_EDGE = registerBlock("large_wooden_gualuo_edge", new OrientableWallSideBlock(BaseBlockProperty.WOOD));
    public static final Block CARVED_STONE_PANEL = registerBlock("carved_stone_panel", new CentralAxialBlock(BaseBlockProperty.STONE, 8));
    public static final Block CARVED_STONE_PANEL_EDGE = registerBlock("carved_stone_panel_edge", new SideAxialBlock(BaseBlockProperty.STONE, 8));
    public static final Block CARVED_STONE_PANEL_CENTER = registerBlock("carved_stone_panel_center", new CentralAxialBlock(BaseBlockProperty.STONE, 8));
    public static final Block CARVED_STONE_QUETI_PART = registerBlock("carved_stone_queti_part", new SideAxialBlock(BaseBlockProperty.STONE, 8));
    public static final Block CARVED_STONE_BEAM = registerBlock("carved_stone_beam", new SideAxialBlock(BaseBlockProperty.STONE, 8));
    public static final Block CARVED_STONE_QUETI = registerBlock("carved_stone_queti", new SideAxialBlock(BaseBlockProperty.STONE, 8));

    // PATTERNS

    public static final Block YELLOW_CARVED_PATTERN = registerBlock("yellow_carved_pattern", new WallSideBlock(BaseBlockProperty.DYE));
    public static final Block CIRCULAR_YELLOW_CARVED_PATTERN = registerBlock("circular_yellow_carved_pattern", new SixSideBlock(BaseBlockProperty.DYE));
    public static final Block YELLOW_CARVED_FANGXIN_EDGE_PATTERN = registerBlock("yellow_carved_fangxin_edge_pattern", new OrientableSixSideBlock(BaseBlockProperty.DYE));
    public static final Block YELLOW_CARVED_FANGXIN_PATTERN = registerBlock("yellow_carved_fangxin_pattern", new OrientableSixSideBlock(BaseBlockProperty.DYE));
    public static final Block LARGE_YELLOW_CARVED_PATTERN = registerBlock("large_yellow_carved_pattern", new SixSideBlock(BaseBlockProperty.DYE));
    public static final Block MEDIUM_YELLOW_CARVED_PATTERN = registerBlock("medium_yellow_carved_pattern", new OrientableSixSideBlock(BaseBlockProperty.DYE));
    public static final Block YELLOW_CARVED_ZHAOTOU_PATTERN = registerBlock("yellow_carved_zhaotou_pattern", new OrientableSixSideBlock(BaseBlockProperty.DYE));
    public static final Block LONG_YELLOW_CARVED_ZHAOTOU_PATTERN = registerBlock("long_yellow_carved_zhaotou_pattern", new OrientableSixSideBlock(BaseBlockProperty.DYE));
    public static final Block CARVED_ZHAOTOU_PATTERN = registerBlock("carved_zhaotou_pattern", new OrientableSixSideBlock(BaseBlockProperty.DYE));
    public static final Block FLAME_ARCH_WALL_PATTERN = registerBlock("flame_arch_wall_pattern", new WallSideBlock(BaseBlockProperty.DYE));
    public static final Block GOLDEN_DRAGON_FANGXIN_PATTERN = registerBlock("golden_dragon_fangxin_pattern", new WallSideBlock(BaseBlockProperty.DYE));
    public static final Block BLUE_FANGXIN_PATTERN = registerBlock("blue_fangxin_pattern", new OrientableSixSideBlock(BaseBlockProperty.DYE));
    public static final Block BLUE_FANGXIN_PATTERN_EDGE = registerBlock("blue_fangxin_pattern_edge", new OrientableSixSideBlock(BaseBlockProperty.DYE));
    public static final Block GREEN_FANGXIN_PATTERN = registerBlock("green_fangxin_pattern", new OrientableSixSideBlock(BaseBlockProperty.DYE));
    public static final Block GREEN_FANGXIN_PATTERN_EDGE = registerBlock("green_fangxin_pattern_edge", new OrientableSixSideBlock(BaseBlockProperty.DYE));
    public static final Block LIGHT_BLUE_SU_STYLE_CAIHUA = registerBlock("light_blue_su_style_caihua", new WallSideBlock(BaseBlockProperty.DYE));
    public static final Block YELLOW_SU_STYLE_CAIHUA = registerBlock("yellow_su_style_caihua", new WallSideBlock(BaseBlockProperty.DYE));
    public static final Block LIGHT_YELLOW_SU_STYLE_CAIHUA = registerBlock("light_yellow_su_style_caihua", new WallSideBlock(BaseBlockProperty.DYE));
    public static final Block MEDIUM_SU_STYLE_CAIHUA = registerBlock("medium_su_style_caihua", new WallSideBlock(BaseBlockProperty.DYE));
    public static final Block LARGE_WHITE_SU_STYLE_CAIHUA = registerBlock("large_white_su_style_caihua", new WallSideBlock(BaseBlockProperty.DYE));
    public static final Block LARGE_GREEN_SU_STYLE_CAIHUA = registerBlock("large_green_su_style_caihua", new WallSideBlock(BaseBlockProperty.DYE));
    public static final Block LARGE_GRAY_SU_STYLE_CAIHUA = registerBlock("large_gray_su_style_caihua", new WallSideBlock(BaseBlockProperty.DYE));

    // CHUIHUA

    public static final Block BLUE_AND_GREEN_CHUIHUA = registerBlock("blue_and_green_chuihua",
            DecorativeBlock.with(BaseBlockProperty.WOOD).diagonallyPlaceable().build());
    public static final Block CYAN_AND_YELLOW_CHUIHUA = registerBlock("cyan_and_yellow_chuihua",
            DecorativeBlock.with(BaseBlockProperty.WOOD).build());
    public static final Block GILDED_DARK_OAK_CHUIHUA = registerBlock("gilded_dark_oak_chuihua", new SixSideBlock(BaseBlockProperty.WOOD, 14, true));

    // ROOF CHARM

    public static final Block GOLDEN_GLAZED_ROOF_CHARM = registerBlock("golden_glazed_roof_charm",
            DecorativeBlock.with(BaseBlockProperty.GLAZED).directional().build());
    public static final Block GOLDEN_GLAZED_ROOF_CHARM_ACCESSORY = registerBlock("golden_glazed_roof_charm_accessory", new WallSideBlock(BaseBlockProperty.GLAZED, 4));
    public static final Block GREEN_GLAZED_ROOF_CHARM = registerBlock("green_glazed_roof_charm",
            DecorativeBlock.with(BaseBlockProperty.GLAZED).directional().build());

    // CEILING

    public static final Block QING_GOLDEN_DRAGON_CEILING = registerBlock("qing_golden_dragon_ceiling",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.HALF_BLOCK).build());

    // RAILING

    public static final Block WHITE_MARBLE_RAILING = registerBlock("white_marble_railing", new RailingBlock(BaseBlockProperty.MARBLE, RailingBlock.MARBLE_SHAPES));
    public static final Block WHITE_MARBLE_RAILING_SLANT = registerBlock("white_marble_railing_slant", new RailingSlant(BaseBlockProperty.MARBLE, 4));
    public static final Block CARVED_WOODEN_RAILING = registerBlock("carved_wooden_railing", new RailingBlock(BaseBlockProperty.WOOD, RailingBlock.WOODEN_SHAPES));
    public static final Block RED_WOODEN_RAILING = registerBlock("red_wooden_railing", new CentralAxialBlock(BaseBlockProperty.WOOD, 2, 15));
    public static final Block RED_WOODEN_RAILING_EDGE = registerBlock("red_wooden_railing_edge", new CentralAxialBlock(BaseBlockProperty.WOOD, 2, 15));
    public static final Block WOODEN_RAILING = registerBlock("wooden_railing", new CentralAxialBlock(BaseBlockProperty.WOOD, 2, 15));
    public static final Block WOODEN_RAILING_VARIANT = registerBlock("wooden_railing_variant", new CentralAxialBlock(BaseBlockProperty.WOOD, 2, 15));

    // GUARDIAN LION

    public static final Block SMALL_WOODEN_GUARDIAN_LION = registerBlock("small_wooden_guardian_lion",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_BLOCK).directional().noOcclusion().noFenceConnect().build());
    public static final Block SMALL_STONE_GUARDIAN_LION = registerBlock("small_stone_guardian_lion",
            DecorativeBlock.with(BaseBlockProperty.STONE).shaped(DecorativeBlock.FULL_BLOCK).directional().noOcclusion().noFenceConnect().build());
    public static final Block SMALL_JADE_GUARDIAN_LION = registerBlock("small_jade_guardian_lion",
            DecorativeBlock.with(BaseBlockProperty.JADE).shaped(DecorativeBlock.FULL_BLOCK).directional().noOcclusion().noFenceConnect().build());
    public static final Block SMALL_YELLOW_GLAZED_GUARDIAN_LION = registerBlock("small_yellow_glazed_guardian_lion",
            DecorativeBlock.with(BaseBlockProperty.GLAZED).shaped(DecorativeBlock.FULL_BLOCK).directional().noOcclusion().noFenceConnect().build());
    public static final Block SMALL_GREEN_GLAZED_GUARDIAN_LION = registerBlock("small_green_glazed_guardian_lion",
            DecorativeBlock.with(BaseBlockProperty.GLAZED).shaped(DecorativeBlock.FULL_BLOCK).directional().noOcclusion().noFenceConnect().build());
    public static final Block XUMI_STONE_MONOLITH = registerBlock("xumi_stone_monolith",
            DecorativeBlock.with(BaseBlockProperty.STONE).shaped(DecorativeBlock.FULL_BLOCK).directional().noOcclusion().noFenceConnect().build());

    // MISC DECORATIONS

    public static final Block CABBAGE_BASKET = registerBlock("cabbage_basket", new StackableHalfBlock(BaseBlockProperty.CROP));
    public static final Block CELERY_BASKET = registerBlock("celery_basket", new StackableHalfBlock(BaseBlockProperty.CROP));
    public static final Block ORANGE_BASKET = registerBlock("orange_basket", new StackableHalfBlock(BaseBlockProperty.CROP));
    public static final Block APPLE_BASKET = registerBlock("apple_basket", new StackableHalfBlock(BaseBlockProperty.CROP));
    public static final Block EGGPLANT_BASKET = registerBlock("eggplant_basket", new StackableHalfBlock(BaseBlockProperty.CROP));
    public static final Block PEAR_BASKET = registerBlock("pear_basket", new StackableHalfBlock(BaseBlockProperty.CROP));
    public static final Block BOOKSHELF = registerBlock("bookshelf", new BaseHorizontalDirectionalBlock(BaseBlockProperty.WOOD));
    public static final Block BOOKSHELF_VARIANT = registerBlock("bookshelf_variant", new BaseHorizontalDirectionalBlock(BaseBlockProperty.WOOD));

    /**
     *  DECORATIONS
     */

    // STUDY

    public static final Block ABACUS = registerBlock("abacus",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.DOUBLE_FLAT_14).directional().diagonallyPlaceable().noCollision().build());
    public static final Block BRUSH_TOOLS = registerBlock("brush_tools",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_14).directional().diagonallyPlaceable().noCollision().build());
    public static final Block BRUSH_AND_INKSTONE = registerBlock("brush_and_inkstone",
            DecorativeBlock.with(BaseBlockProperty.PAPER).shaped(DecorativeBlock.QUARTER_16).directional().noCollision().noOcclusion().build());
    public static final Block RULER = registerBlock("ruler",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FLAT_16).directional().diagonallyPlaceable().noCollision().build());
    public static final Block PAINTING_SCROLL = registerBlock("painting_scroll",
            DecorativeBlock.with(BaseBlockProperty.PAPER).shaped(DecorativeBlock.QUARTER_16).directional().diagonallyPlaceable().noCollision().build());
    public static final Block BOOK_STACK = registerBlock("book_stack",
            DecorativeBlock.with(BaseBlockProperty.PAPER).shaped(DecorativeBlock.QUARTER_16).directional().noOcclusion().build());
    public static final Block PAPER = registerBlock("paper",
            DecorativeBlock.with(BaseBlockProperty.PAPER).shaped(DecorativeBlock.FLAT_16).directional().diagonallyPlaceable().noOcclusion().noCollision().build());
    public static final Block BLUE_BOOK = registerBlock("blue_book",
            DecorativeBlock.with(BaseBlockProperty.PAPER).shaped(DecorativeBlock.QUARTER_16).directional().noOcclusion().noCollision().build());
    public static final Block BAMBOO_SLIPS = registerBlock("bamboo_slips",
            DecorativeBlock.with(BaseBlockProperty.SILK).shaped(DecorativeBlock.HALF_14).directional().diagonallyPlaceable().noCollision().build());

    // ROOM DECO

    public static final Block BACK_CUSHION = registerBlock("back_cushion",
            DecorativeBlock.with(BaseBlockProperty.SILK).shaped(DecorativeBlock.FULL_BLOCK).directional().noCollision().noOcclusion().noFenceConnect().build());
    public static final Block CHESSBOARD = registerBlock("chessboard",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FLAT_16).directional().diagonallyPlaceable().noCollision().noOcclusion().build());
    public static final Block BLUE_AND_WHITE_PORCELAIN_VASE = registerBlock("blue_and_white_porcelain_vase",
            DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.VASE).diagonallyPlaceable().build());
    public static final Block LARGE_BLUE_AND_WHITE_PORCELAIN_VASE = registerBlock("large_blue_and_white_porcelain_vase",
            DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_14).directional().build());
    public static final Block SHORT_BLUE_AND_WHITE_PORCELAIN_POT = registerBlock("short_blue_and_white_porcelain_pot",
            DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.HALF_12).build());
    public static final Block TALL_BLUE_AND_WHITE_PORCELAIN_POT = registerBlock("tall_blue_and_white_porcelain_pot",
            DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_6).directional().diagonallyPlaceable().build());
    public static final Block BLUE_AND_WHITE_PORCELAIN_BOWL = registerBlock("blue_and_white_porcelain_bowl",
            DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.HALF_12).diagonallyPlaceable().build());
    public static final Block BRONZE_MIRROR = registerBlock("bronze_mirror",
            DecorativeBlock.with(BaseBlockProperty.BRONZE).shaped(DecorativeBlock.FULL_14).directional().build());
    public static final Block MEMORIAL_TABLET = registerBlock("memorial_tablet",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_14).directional().diagonallyPlaceable().noCollision().noFenceConnect().build());
    public static final Block BRONZE_CENSER = registerBlock("bronze_censer",
             new Censer(DecorativeBlock.with(BaseBlockProperty.BRONZE).shaped(DecorativeBlock.HALF_12).directional().diagonallyPlaceable().luminous(), new Vec3(0.5, 0.7, 0.5)));
    public static final Block ROYAL_CENSER = registerBlock("royal_censer",
             new Censer(DecorativeBlock.with(BaseBlockProperty.BRONZE).shaped(DecorativeBlock.FULL_10).directional().luminous(), new Vec3(0.5, 0.5, 0.5)));
    public static final Block PORCELAIN_TEAPOT = registerBlock("porcelain_teapot",
            DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.HALF_12).directional().build());
    public static final Block BOOTS = registerBlock("boots",
            DecorativeBlock.with(BaseBlockProperty.SILK).shaped(DecorativeBlock.FULL_14).directional().build());
    public static final Block JADE_PENDANT = registerBlock("jade_pendant",
            DecorativeBlock.with(BaseBlockProperty.JADE).shaped(DecorativeBlock.FULL_6).directional().diagonallyPlaceable().build());
    public static final Block IMPERIAL_JADE_SEAL = registerBlock("imperial_jade_seal",
            DecorativeBlock.with(BaseBlockProperty.JADE).shaped(DecorativeBlock.FULL_6).directional().build());
    public static final Block LONG_PILLOW = registerBlock("long_pillow",
            DecorativeBlock.with(BaseBlockProperty.SILK).shaped(DecorativeBlock.QUARTER_12).directional().diagonallyPlaceable().build());

    // MISC OBJECTS

    public static final Block RED_SILK_FABRIC_ROLL = registerBlock("red_silk_fabric_roll",
            DecorativeBlock.with(BaseBlockProperty.SILK).shaped(DecorativeBlock.QUARTER_12).directional().diagonallyPlaceable().build());
    public static final Block GREEN_SILK_FABRIC_ROLL = registerBlock("green_silk_fabric_roll",
            DecorativeBlock.with(BaseBlockProperty.SILK).shaped(DecorativeBlock.QUARTER_12).directional().diagonallyPlaceable().build());
    public static final Block PURPLE_SILK_FABRIC_ROLL = registerBlock("purple_silk_fabric_roll",
            DecorativeBlock.with(BaseBlockProperty.SILK).shaped(DecorativeBlock.QUARTER_12).directional().diagonallyPlaceable().build());
    public static final Block CLAY_DOLL_MALE = registerBlock("clay_doll_male",
            DecorativeBlock.with(BaseBlockProperty.TERRACOTTA).shaped(DecorativeBlock.FULL_10).directional().diagonallyPlaceable().noCollision().build());
    public static final Block CLAY_DOLL_FEMALE = registerBlock("clay_doll_female",
            DecorativeBlock.with(BaseBlockProperty.TERRACOTTA).shaped(DecorativeBlock.FULL_10).directional().diagonallyPlaceable().noCollision().build());
    public static final Block BOTTLE_GOURD = registerBlock("bottle_gourd",
             new BottleGourd(DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(BottleGourd.GOURD).directional().diagonallyPlaceable()));

    // FLOWER POTS

    public static final Block BLUE_AND_WHITE_PORCELAIN_FLOWERPOT = registerBlock("blue_and_white_porcelain_flowerpot",
            DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_6).diagonallyPlaceable().build());
    public static final Block TERRACOTTA_FLOWERPOT = registerBlock("terracotta_flowerpot",
            DecorativeBlock.with(BaseBlockProperty.TERRACOTTA).shaped(DecorativeBlock.VASE).diagonallyPlaceable().build());
    public static final Block BLACK_IRON_FLOWERPOT = registerBlock("black_iron_flowerpot",
            DecorativeBlock.with(BaseBlockProperty.IRON).shaped(DecorativeBlock.VASE).directional().build());
    public static final Block BLUE_PORCELAIN_FLOWERPOT = registerBlock("blue_porcelain_flowerpot",
            DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_14).directional().build());

    // COURTYARD

    public static final Block SACK = registerBlock("sack",
             ContainerDecorativeBlock.with(BaseBlockProperty.SILK).content(ContainerType.COMMON_SMALL).shaped(DecorativeBlock.HALF_6).directional().noCollision().pushReaction(PushReaction.BLOCK).build());
    public static final Block BAMBOO_TEA_BASKET = registerBlock("bamboo_tea_basket",
             ContainerDecorativeBlock.with(BaseBlockProperty.BAMBOO_WOOD).content(ContainerType.FOOD_REGULAR).shaped(DecorativeBlock.FULL_14).directional().diagonallyPlaceable().pushReaction(PushReaction.BLOCK).build());
    public static final Block EMPTY_BAMBOO_TEA_BASKET = registerBlock("empty_bamboo_tea_basket",
             ContainerDecorativeBlock.with(BaseBlockProperty.BAMBOO_WOOD).content(ContainerType.FOOD_REGULAR).shaped(DecorativeBlock.FULL_14).directional().diagonallyPlaceable().pushReaction(PushReaction.BLOCK).build());
    public static final Block STRAW_HAT = registerBlock("straw_hat",
            DecorativeBlock.with(BaseBlockProperty.FLAX).shaped(DecorativeBlock.QUARTER_16).diagonallyPlaceable().noCollision().noOcclusion().build());
    public static final Block KNIFE = registerBlock("knife",
            DecorativeBlock.with(BaseBlockProperty.IRON).shaped(DecorativeBlock.FLAT_16).directional().diagonallyPlaceable().noCollision().noOcclusion().build());
    public static final Block SUNDIAL = registerBlock("sundial",
            DecorativeBlock.with(BaseBlockProperty.STONE).shaped(DecorativeBlock.FULL_14).directional().build());
    public static final Block BROOM = registerBlock("broom",
            DecorativeBlock.with(BaseBlockProperty.STONE).shaped(DecorativeBlock.FULL_8).directional().build());
    public static final Block STONE_PEDESTAL = registerBlock("stone_pedestal",
            DecorativeBlock.with(BaseBlockProperty.STONE).shaped(DecorativeBlock.HALF_BLOCK).diagonallyPlaceable().noOcclusion().build());
    public static final Block TERRACOTTA_POT = registerBlock("terracotta_pot",
            DecorativeBlock.with(BaseBlockProperty.TERRACOTTA).shaped(DecorativeBlock.FULL_14).directional().build());
    public static final Block CHINESE_HERBS_BAG = registerBlock("chinese_herbs_bag",
            DecorativeBlock.with(BaseBlockProperty.SILK).shaped(DecorativeBlock.HALF_BLOCK).directional().build());
    public static final Block FRUIT_BOX = registerBlock("fruit_box",
             ContainerDecorativeBlock.with(BaseBlockProperty.WOOD).content(ContainerType.FOOD_REGULAR).shaped(DecorativeBlock.FULL_14).directional().diagonallyPlaceable().pushReaction(PushReaction.BLOCK).build());
    public static final Block WOODEN_CRATE = registerBlock("wooden_crate",
             ContainerDecorativeBlock.with(BaseBlockProperty.WOOD).content(ContainerType.COMMON_REGULAR).shaped(DecorativeBlock.FULL_BLOCK).pushReaction(PushReaction.BLOCK).build());
    public static final Block GUNNY_SACK = registerBlock("gunny_sack",
             ContainerDecorativeBlock.with(BaseBlockProperty.FLAX).content(ContainerType.COMMON_REGULAR).shaped(DecorativeBlock.FULL_14).directional().pushReaction(PushReaction.BLOCK).build());
    public static final Block BRONZE_DING = registerBlock("bronze_ding",
            DecorativeBlock.with(BaseBlockProperty.BRONZE).shaped(DecorativeBlock.FULL_BLOCK).placeOffset(Direction.UP).directional().noOcclusion().build());
    public static final Block CARRIAGE = registerBlock("carriage",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_BLOCK).directional().noOcclusion().build());
    public static final Block WOODEN_POLES = registerBlock("wooden_poles",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_BLOCK).directional().noOcclusion().build());
    public static final Block TEAHOUSE_FLAG = registerBlock("teahouse_flag",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_6).placeOffset(Direction.UP).directional().noOcclusion().build());
    public static final Block KNIFE_REST = registerBlock("knife_rest",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_BLOCK).directional().noOcclusion().build());

    // WALL HANGING

    public static final Block LONG_HANGING_PAINTING = registerBlock("long_hanging_painting",
            new WallSideBlock(BaseBlockProperty.PAPER));
    public static final Block WHITE_LANDSCAPE_PAINTING = registerBlock("white_landscape_painting",
            new WallSideBlock(BaseBlockProperty.PAPER));
    public static final Block HORIZONTAL_OLD_LANDSCAPE_PAINTING = registerBlock("horizontal_old_landscape_painting",
            new WallSideBlock(BaseBlockProperty.PAPER));
    public static final Block HORIZONTAL_CALLIGRAPHY = registerBlock("horizontal_calligraphy",
            new WallSideBlock(BaseBlockProperty.PAPER));
    public static final Block HORIZONTAL_LANDSCAPE_PAINTING = registerBlock("horizontal_landscape_painting",
            new WallSideBlock(BaseBlockProperty.PAPER));
    public static final Block LONG_YELLOW_HANGING_PAINTING = registerBlock("long_yellow_hanging_painting",
            new WallSideBlock(BaseBlockProperty.PAPER));
    public static final Block DAMAGED_LANDSCAPE_PAINTING = registerBlock("damaged_landscape_painting",
            new WallSideBlock(BaseBlockProperty.PAPER));
    public static final Block PORTRAIT = registerBlock("portrait",
            new WallSideBlock(BaseBlockProperty.PAPER));
    public static final Block HANGING_PAINTING_FAN = registerBlock("hanging_painting_fan",
            new WallSideBlock(BaseBlockProperty.PAPER));
    public static final Block SINCERE_CALLIGRAPHY = registerBlock("sincere_calligraphy",
            new WallSideBlock(BaseBlockProperty.PAPER));

    // FOOD

    public static final Block FOOD_HAMPER = registerBlock("food_hamper",
             ContainerDecorativeBlock.with(BaseBlockProperty.WOOD).content(ContainerType.FOOD_LARGE).shaped(DecorativeBlock.FULL_6).directional().diagonallyPlaceable().pushReaction(PushReaction.BLOCK).build());
    public static final Block PLATED_MOONCAKES = registerBlock("plated_mooncakes", //todo change stone slab plate to actual block
             ConsumableDecorativeBlock.with(BaseBlockProperty.PORCELAIN).bites(4).platedWith(Blocks.STONE_SLAB).food(ModFoods.MOONCAKE).shaped(DecorativeBlock.FLAT_16).directional().build());
    public static final Block PLATED_MUNG_BEAN_CAKES = registerBlock("plated_mung_bean_cakes",
             ConsumableDecorativeBlock.with(BaseBlockProperty.GLAZED).bites(7).platedWith(Blocks.STONE_SLAB).food(ModFoods.MUNG_BEAN_CAKE).shaped(DecorativeBlock.FLAT_16).directional().noOcclusion().build());
    public static final Block PLATED_HAM = registerBlock("plated_ham",
             ConsumableDecorativeBlock.with(BaseBlockProperty.WOOD).bites(4).platedWith(() -> ItemRegistry.POLISHED_OAK_PLANK).food(ModFoods.COOKED_MEAT).shaped(DecorativeBlock.FLAT_16).directional().noOcclusion().build());
    public static final Block PLATED_FISH = registerBlock("plated_fish",
             ConsumableDecorativeBlock.with(BaseBlockProperty.WOOD).bites(3).platedWith(() -> ItemRegistry.POLISHED_OAK_PLANK).food(ModFoods.FISH).shaped(DecorativeBlock.FLAT_16).directional().noOcclusion().build());
    public static final Block SCATTERED_CARROTS = registerBlock("scattered_carrots",
             ConsumableDecorativeBlock.with(BaseBlockProperty.CROP).bites(2).platedWith(() -> ItemRegistry.POLISHED_OAK_PLANK).food(Foods.CARROT)
                    .whenFinished((pState, pLevel, pPos, pPlayer) -> {pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL); pLevel.gameEvent(pPlayer, GameEvent.BLOCK_DESTROY, pPos);})
                    .shaped(DecorativeBlock.QUARTER_16).directional().noOcclusion().build());
    public static final Block WINE_POT = registerBlock("wine_pot",
            DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_6).directional().build());
    public static final Block XIAOLONGBAO = registerBlock("xiaolongbao", //TODO xiaolongbao 8 bites in one block, return 2 containers
             ConsumableDecorativeBlock.with(BaseBlockProperty.BAMBOO).bites(8).platedWith(() -> ItemRegistry.POLISHED_OAK_PLANK).food(ModFoods.BAOZI)
                    .whenFinished((pState, pLevel, pPos, pPlayer) -> {pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL); pLevel.gameEvent(pPlayer, GameEvent.BLOCK_DESTROY, pPos);})
                    .shaped(DecorativeBlock.FULL_BLOCK).directional().build());

    /**
     *  FURNITURE
     */

    // CABINET

    public static final Block OAK_CABINET = registerBlock("oak_cabinet",
             ContainerDecorativeBlock.with(BaseBlockProperty.WOOD).content(ContainerType.COMMON_REGULAR).shaped(DecorativeBlock.FULL_BLOCK).directional().noFenceConnect().pushReaction(PushReaction.BLOCK).build());
    public static final Block WARPED_CABINET = registerBlock("warped_cabinet",
             ContainerDecorativeBlock.with(BaseBlockProperty.WOOD).content(ContainerType.COMMON_REGULAR).shaped(DecorativeBlock.FULL_BLOCK).directional().noFenceConnect().pushReaction(PushReaction.BLOCK).build());
    public static final Block EBONY_CABINET = registerBlock("ebony_cabinet",
             ContainerDecorativeBlock.with(BaseBlockProperty.WOOD).content(ContainerType.COMMON_LARGE).shaped(DecorativeBlock.FULL_BLOCK).directional().noFenceConnect().pushReaction(PushReaction.BLOCK).build());

    // TABLE

    public static final Block LARGE_TEA_TABLE = registerBlock("large_tea_table",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.HALF_BLOCK).directional().build());
    public static final Block CHESS_TABLE = registerBlock("chess_table",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.QUARTER_16).directional().diagonallyPlaceable().build());
    public static final Block HIGH_TABLE_WITH_WHITE_TOP = registerBlock("high_table_with_white_top",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_14).directional().build());
    public static final Block CENSER_TABLE = registerBlock("censer_table",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_14).directional().diagonallyPlaceable().build());
    public static final Block PORCELAIN_INLAID_TABLE = registerBlock("porcelain_inlaid_table",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_BLOCK).directional().noFenceConnect().build());
    public static final Block SMALL_TABLE = registerBlock("small_table",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_14).directional().diagonallyPlaceable().build());
    public static final Block SMALL_EBONY_TABLE = registerBlock("small_ebony_table",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_14).directional().build());
    public static final Block LARGE_TABLE = registerBlock("large_table",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_BLOCK).directional().build());

    // CHAIR

    public static final Block EBONY_CHAIR = registerBlock("ebony_chair",
             SeatDecorativeBlock.with(BaseBlockProperty.WOOD).seatOffset(new Vec3(0.0f, -0.1f, 0.0f)).shaped(DecorativeBlock.HALF_12).directional().diagonallyPlaceable().build());
    public static final Block CHAIR_WITH_YELLOW_CUSHION = registerBlock("chair_with_yellow_cushion",
             SeatDecorativeBlock.with(BaseBlockProperty.WOOD).seatOffset(new Vec3(0.0f, -0.1f, 0.0f)).shaped(DecorativeBlock.HALF_BLOCK).directional().build());
    public static final Block PAINTED_CHAIR = registerBlock("painted_chair",
             SeatDecorativeBlock.with(BaseBlockProperty.WOOD).seatOffset(new Vec3(0.0f, -0.1f, 0.0f)).shaped(DecorativeBlock.HALF_BLOCK).directional().build());
    public static final Block WOODEN_STOOL = registerBlock("wooden_stool",
             SeatDecorativeBlock.with(BaseBlockProperty.WOOD).seatOffset(new Vec3(0.0f, -0.1f, 0.0f)).shaped(DecorativeBlock.HALF_12).directional().build());
    public static final Block PORCELAIN_INLAID_GRAND_CHAIR = registerBlock("porcelain_inlaid_grand_chair",
             SeatDecorativeBlock.with(BaseBlockProperty.WOOD).seatOffset(new Vec3(0.0f, -0.1f, 0.0f)).shaped(DecorativeBlock.HALF_14).directional().build());
    public static final Block YELLOW_CUSHION = registerBlock("yellow_cushion",
             SeatDecorativeBlock.with(BaseBlockProperty.SILK).seatOffset(new Vec3(0.0f, -0.5f, 0.0f)).shaped(DecorativeBlock.QUARTER_12).directional().diagonallyPlaceable().build());
    public static final Block OAK_BED = registerBlock("oak_bed",
             SeatDecorativeBlock.with(BaseBlockProperty.WOOD).seatOffset(new Vec3(0.0f, -0.1f, 0.0f)).shaped(DecorativeBlock.HALF_BLOCK).directional().build());

    // SCREEN

    public static final Block LARGE_LANDSCAPE_PAINTING_SCREEN = registerBlock("large_landscape_painting_screen",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(OpeningBlock.MIDDLE_AXIAL).placeOffset(Direction.UP).directional().build());
    public static final Block PAINTED_SCREEN = registerBlock("painted_screen",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(OpeningBlock.MIDDLE_AXIAL).placeOffset(Direction.UP).directional().build());

    /**
     *  DOOR AND WINDOW
     */

    // DOOR

    public static final Block CARVED_WOODEN_DOOR = registerBlock("carved_wooden_door",
            new OpeningBlock(DecorativeBlock.with(BaseBlockProperty.WOOD).directional().noOcclusion()));
    public static final Block SONG_WOODEN_DOOR = registerBlock("song_wooden_door",
            new OpeningBlock(DecorativeBlock.with(BaseBlockProperty.WOOD).directional().noOcclusion()));

    // WINDOW

    public static final Block SONG_WOODEN_WINDOW = registerBlock("song_wooden_window",
            new OpeningBlock(DecorativeBlock.with(BaseBlockProperty.WOOD).directional().noOcclusion()));
    public static final Block ROYAL_ROSEWOOD_WINDOW = registerBlock("royal_rosewood_window",
            new OpeningBlock(DecorativeBlock.with(BaseBlockProperty.WOOD).directional().noOcclusion()));
    public static final Block TALL_ROYAL_ROSEWOOD_WINDOW = registerBlock("tall_royal_rosewood_window",
            new OpeningBlock(DecorativeBlock.with(BaseBlockProperty.WOOD).directional().noOcclusion()));
    public static final Block GLAZED_TILE_GRID_WINDOW = registerBlock("glazed_tile_grid_window",
             new DecorativeBlock(DecorativeBlock.with(BaseBlockProperty.GLAZED).shaped(DecorativeBlock.FULL_BLOCK).directional().noOcclusion()));
    public static final Block STONE_FLOWER_WINDOW = registerBlock("stone_flower_window", new BaseBlock(BaseBlockProperty.IRON));

    // DOOR DECO

    public static final Block KNOCKER = registerBlock("knocker",
            new WallSideBlock(BaseBlockProperty.COPPER));
    public static final Block ROSEWOOD_PANEL = registerBlock("rosewood_panel",
             new SixSideBlock(BaseBlockProperty.WOOD, 3));
    public static final Block ROSEWOOD_DOOR_PANEL = registerBlock("rosewood_door_panel",
             new SixSideBlock(BaseBlockProperty.WOOD, 3));
    public static final Block LARGE_ROSEWOOD_PANEL = registerBlock("large_rosewood_panel",
             new OrientableSixSideBlock(BaseBlockProperty.WOOD, 3));
    public static final Block LARGE_ROSEWOOD_PANEL_EDGE = registerBlock("large_rosewood_panel_edge",
             new OrientableSixSideBlock(BaseBlockProperty.WOOD, 3));
    public static final Block CARVED_WOODEN_DOOR_PANEL = registerBlock("carved_wooden_door_panel",
            new OpeningBlock(DecorativeBlock.with(BaseBlockProperty.WOOD).directional().noOcclusion()));
    public static final Block PLAQUE = registerBlock("plaque",
             new DecorativeBlock(DecorativeBlock.with(BaseBlockProperty.WOOD).directional().noOcclusion()));
    public static final Block PAPER_STRIP_SEAL = registerBlock("paper_strip_seal",
            new WallSideBlock(BaseBlockProperty.PAPER));

    // WINDOW DECO

    public static final Block LARGE_BLUE_CURTAIN = registerBlock("large_blue_curtain",
            new WallSideBlock(BaseBlockProperty.SILK));
    public static final Block MEDIUM_BLUE_CURTAIN = registerBlock("medium_blue_curtain",
            new WallSideBlock(BaseBlockProperty.SILK));
    public static final Block SMALL_BLUE_CURTAIN = registerBlock("small_blue_curtain",
            new WallSideBlock(BaseBlockProperty.SILK));
    public static final Block RED_CURTAIN = registerBlock("red_curtain",
             new OrientableWallSideBlock(BaseBlockProperty.SILK));
    public static final Block RED_CURTAIN_CORNER = registerBlock("red_curtain_corner",
             new OrientableWallSideBlock(BaseBlockProperty.SILK));
    public static final Block BAMBOO_CURTAIN = registerBlock("bamboo_curtain",
             new DecorativeBlock(DecorativeBlock.with(BaseBlockProperty.BAMBOO_WOOD).shaped(OpeningBlock.MIDDLE_AXIAL).directional().noOcclusion()));

    /**
     *  PLANTS
     */

    // LOTUS


    public static final Block SMALL_LOTUS_LEAF = registerBlock("small_lotus_leaf",
             new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.LILY).shaped(DecorativeBlock.FLAT_16).directional().diagonallyPlaceable().noCollision().noOcclusion()));
    public static final Block SMALL_DARK_GREEN_LOTUS_LEAF = registerBlock("small_dark_green_lotus_leaf",
             new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.LILY).shaped(DecorativeBlock.FLAT_16).directional().diagonallyPlaceable().noCollision().noOcclusion()));
    public static final Block MEDIUM_LOTUS_LEAF = registerBlock("medium_lotus_leaf",
             new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.LILY).shaped(DecorativeBlock.FLAT_16).directional().diagonallyPlaceable().noCollision().noOcclusion()));
    public static final Block LARGE_LOTUS_LEAF = registerBlock("large_lotus_leaf",
             new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.LILY).shaped(DecorativeBlock.FLAT_16).directional().diagonallyPlaceable().noCollision().noOcclusion()));
    public static final Block TILTED_LOTUS_LEAF = registerBlock("tilted_lotus_leaf",
             new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.LILY).shaped(DecorativeBlock.HALF_BLOCK).directional().noCollision().noOcclusion()));
    public static final Block SMALL_LOTUS_LEAF_CLUSTER = registerBlock("small_lotus_leaf_cluster",
             new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.LILY).shaped(DecorativeBlock.FLAT_16).directional().diagonallyPlaceable().noCollision().noOcclusion()));
    public static final Block MEDIUM_LOTUS_LEAF_CLUSTER = registerBlock("medium_lotus_leaf_cluster",
             new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.LILY).shaped(DecorativeBlock.FLAT_16).directional().diagonallyPlaceable().noCollision().noOcclusion()));
    public static final Block LOTUS_BUD = registerBlock("lotus_bud",
             new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.LILY).shaped(DecorativeBlock.FULL_8).directional().noCollision().noOcclusion()));
    public static final Block MEDIUM_LOTUS = registerBlock("medium_lotus",
             new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.LILY).shaped(DecorativeBlock.FULL_BLOCK).directional().noCollision().noOcclusion()));

    // IVY

    public static final Block SMALL_RED_IVY = registerBlock("small_red_ivy",
            new WallSideBlock(BaseBlockProperty.PLANT));
    public static final Block MEDIUM_RED_IVY = registerBlock("medium_red_ivy",
            new WallSideBlock(BaseBlockProperty.PLANT));
    public static final Block LARGE_RED_IVY = registerBlock("large_red_ivy",
            new WallSideBlock(BaseBlockProperty.PLANT));
    public static final Block SMALL_YELLOW_IVY = registerBlock("small_yellow_ivy",
            new WallSideBlock(BaseBlockProperty.PLANT));
    public static final Block MEDIUM_YELLOW_IVY = registerBlock("medium_yellow_ivy",
            new WallSideBlock(BaseBlockProperty.PLANT));
    public static final Block LARGE_YELLOW_IVY = registerBlock("large_yellow_ivy",
            new WallSideBlock(BaseBlockProperty.PLANT));
    public static final Block SMALL_GREEN_IVY = registerBlock("small_green_ivy",
            new WallSideBlock(BaseBlockProperty.PLANT));
    public static final Block MEDIUM_GREEN_IVY = registerBlock("medium_green_ivy",
            new WallSideBlock(BaseBlockProperty.PLANT));
    public static final Block LARGE_GREEN_IVY = registerBlock("large_green_ivy",
            new WallSideBlock(BaseBlockProperty.PLANT));

    // LEAVES

    public static final Block SMALL_LEAF_PILE = registerBlock("small_leaf_pile",
            DecorativeBlock.with(BaseBlockProperty.PLANT).shaped(DecorativeBlock.FLAT_16).directional().noCollision().noOcclusion().build());
    public static final Block MEDIUM_LEAF_PILE = registerBlock("medium_leaf_pile",
            DecorativeBlock.with(BaseBlockProperty.PLANT).shaped(DecorativeBlock.FLAT_16).directional().noCollision().noOcclusion().build());
    public static final Block LARGE_LEAF_PILE = registerBlock("large_leaf_pile",
            DecorativeBlock.with(BaseBlockProperty.PLANT).shaped(DecorativeBlock.FLAT_16).directional().noCollision().noOcclusion().build());

    // BONSAI

    public static final Block SMALL_GREETING_PINE_BONSAI = registerBlock("small_greeting_pine_bonsai",
            DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_12).directional().noCollision().build());
    public static final Block MEDIUM_GREETING_PINE_BONSAI = registerBlock("medium_greeting_pine_bonsai",
            DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_14).directional().noCollision().noOcclusion().build());
    public static final Block LARGE_GREETING_PINE_BONSAI = registerBlock("large_greeting_pine_bonsai",
            DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_14).directional().placeOffset(Direction.UP).noCollision().noOcclusion().build());
    public static final Block SMALL_WHITE_PORCELAIN_VASE_BONSAI = registerBlock("small_white_porcelain_vase_bonsai",
            DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_10).directional().diagonallyPlaceable().noCollision().build());
    public static final Block MEDIUM_WHITE_PORCELAIN_VASE_BONSAI = registerBlock("medium_white_porcelain_vase_bonsai",
            DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_14).directional().diagonallyPlaceable().noCollision().build());
    public static final Block LARGE_WHITE_PORCELAIN_VASE_BONSAI = registerBlock("large_white_porcelain_vase_bonsai",
            DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_14).directional().diagonallyPlaceable().noCollision().noOcclusion().build());
    public static final Block SMALL_GREEN_PORCELAIN_VASE_BONSAI = registerBlock("small_green_porcelain_vase_bonsai",
            DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_10).directional().noCollision().build());
    public static final Block GREEN_PORCELAIN_VASE_BONSAI = registerBlock("green_porcelain_vase_bonsai",
            DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_10).directional().diagonallyPlaceable().noCollision().build());
    public static final Block RED_CORAL_BONSAI = registerBlock("red_coral_bonsai",
            DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_14).directional().noCollision().build());
    public static final Block RED_PLUM_BONSAI = registerBlock("red_plum_bonsai",
            DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_12).directional().noCollision().build());
    public static final Block BAMBOO_BONSAI = registerBlock("bamboo_bonsai",
            DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_14).directional().noCollision().noOcclusion().build());
    public static final Block TALL_BLUE_VASE_BONSAI = registerBlock("tall_blue_vase_bonsai",
            DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_12).directional().diagonallyPlaceable().placeOffset(Direction.UP).noCollision().build());
    public static final Block TALL_BLUE_AND_WHITE_PORCELAIN_BONSAI = registerBlock("tall_blue_and_white_porcelain_bonsai",
            DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_10).directional().diagonallyPlaceable().noCollision().noOcclusion().build());
    public static final Block MEDIUM_BONSAI = registerBlock("medium_bonsai",
            DecorativeBlock.with(BaseBlockProperty.TERRACOTTA).shaped(DecorativeBlock.FULL_12).directional().diagonallyPlaceable().noCollision().noOcclusion().build());
    public static final Block LARGE_BONSAI = registerBlock("large_bonsai",
            DecorativeBlock.with(BaseBlockProperty.TERRACOTTA).shaped(DecorativeBlock.FULL_14).directional().diagonallyPlaceable().noCollision().noOcclusion().build());

    /**
     *  LAMPS
     */

    //LANTERN

    public static final Block OCTAGONAL_PALACE_LANTERN = registerBlock("octagonal_palace_lantern",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_BLOCK).luminous().noOcclusion().placeOffset(Direction.DOWN).build());
    public static final Block SQUARE_PALACE_LANTERN = registerBlock("square_palace_lantern",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_BLOCK).diagonallyPlaceable().luminous().noOcclusion().build());
    public static final Block SMALL_RED_LANTERN = registerBlock("small_red_lantern",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_BLOCK).diagonallyPlaceable().luminous().build());
    public static final Block WHITE_SKY_LANTERN = registerBlock("white_sky_lantern",
            DecorativeBlock.with(BaseBlockProperty.BAMBOO).luminous().build());
    public static final Block RED_SKY_LANTERN = registerBlock("red_sky_lantern",
            DecorativeBlock.with(BaseBlockProperty.BAMBOO).luminous().build());
    public static final Block YELLOW_SKY_LANTERN = registerBlock("yellow_sky_lantern",
            DecorativeBlock.with(BaseBlockProperty.BAMBOO).luminous().build());

    // LAMP

    public static final Block STANDING_LAMP = registerBlock("standing_lamp",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_6).diagonallyPlaceable().luminous().noOcclusion().build());
    public static final Block SMALL_STANDING_LAMP = registerBlock("small_standing_lamp",
            DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_6).diagonallyPlaceable().luminous().build());
    public static final Block STONE_LAMP = registerBlock("stone_lamp",
            DecorativeBlock.with(BaseBlockProperty.STONE).luminous().build());

    // CANDLESTICK

    public static final Block RED_CANDLE = registerBlock("red_candle",
             new CandleStick(DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_4).directional().diagonallyPlaceable().luminous(), new Vec3(0.5,1.1,0.5)));
    public static final Block TRICOLOR_CANDLESTICK = registerBlock("tricolor_candlestick",
             new CandleStick(DecorativeBlock.with(BaseBlockProperty.IRON).shaped(DecorativeBlock.FULL_10).directional().diagonallyPlaceable().luminous(), new Vec3(0.5,1.25,0.5)));
    public static final Block JADE_CANDLESTICK = registerBlock("jade_candlestick",
             new CandleStick(DecorativeBlock.with(BaseBlockProperty.JADE).shaped(DecorativeBlock.FULL_6).directional().diagonallyPlaceable().luminous(), new Vec3(0.5,1.3,0.5)));

    /**
     *  MATERIALS
     */

    public static final Block JADE_ORE = registerBlock("jade_ore", new BaseOreBlock(2, 5));
    public static final Block MAGNESITE_ORE = registerBlock("magnesite_ore", new BaseOreBlock(2, 5));
    public static final Block HEMATITE_ORE = registerBlock("hematite_ore", new BaseOreBlock(1, 3));

    /**
     *  TOOLS
     */

    public static final Block WOODWORKING_WORKBENCH = registerBlock("woodworking_workbench", new WoodworkingWorkBench());
    

    public static Block registerBlock(String name, Block block) {
        //registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Ultramarine.MOD_ID, name), block);
    }

    public static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Ultramarine.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Ultramarine.info("Registering Mod Blocks for " + Ultramarine.MOD_ID);
    }
}
