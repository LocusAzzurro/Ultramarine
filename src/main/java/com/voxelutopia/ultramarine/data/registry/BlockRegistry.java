package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.ContainerType;
import com.voxelutopia.ultramarine.data.ModFoods;
import com.voxelutopia.ultramarine.world.block.*;
import com.voxelutopia.ultramarine.world.block.HangingLantern;
import net.minecraft.core.Direction;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ultramarine.MOD_ID);

    /**
     *  BUILDING BLOCKS
     */

    // BRICKS

    public static final RegistryObject<Block> CYAN_BRICKS = BLOCKS.register("cyan_bricks", BaseBlock::new);
    public static final RegistryObject<Block> CYAN_BRICK_SLAB = BLOCKS.register("cyan_brick_slab", () -> new BaseSlab((BaseBlock) CYAN_BRICKS.get()));
    public static final RegistryObject<Block> CYAN_BRICK_STAIRS = BLOCKS.register("cyan_brick_stairs", () -> new BaseStairs((BaseBlock) CYAN_BRICKS.get()));
    public static final RegistryObject<Block> CYAN_BRICK_WALL = BLOCKS.register("cyan_brick_wall", () -> new BaseWall((BaseBlock) CYAN_BRICKS.get()));
    public static final RegistryObject<Block> BLACK_BRICKS = BLOCKS.register("black_bricks", BaseBlock::new);
    public static final RegistryObject<Block> BLACK_BRICK_SLAB = BLOCKS.register("black_brick_slab", () -> new BaseSlab((BaseBlock) BLACK_BRICKS.get()));
    public static final RegistryObject<Block> BLACK_BRICK_STAIRS = BLOCKS.register("black_brick_stairs", () -> new BaseStairs((BaseBlock) BLACK_BRICKS.get()));
    public static final RegistryObject<Block> BLACK_BRICK_WALL = BLOCKS.register("black_brick_wall", () -> new BaseWall((BaseBlock) BLACK_BRICKS.get()));
    public static final RegistryObject<Block> BROWNISH_RED_STONE_BRICKS = BLOCKS.register("brownish_red_stone_bricks", BaseBlock::new);
    public static final RegistryObject<Block> BROWNISH_RED_STONE_BRICK_SLAB = BLOCKS.register("brownish_red_stone_brick_slab", () -> new BaseSlab((BaseBlock) BROWNISH_RED_STONE_BRICKS.get()));
    public static final RegistryObject<Block> BROWNISH_RED_STONE_BRICK_STAIRS = BLOCKS.register("brownish_red_stone_brick_stairs", () -> new BaseStairs((BaseBlock) BROWNISH_RED_STONE_BRICKS.get()));
    public static final RegistryObject<Block> BROWNISH_RED_STONE_BRICK_WALL = BLOCKS.register("brownish_red_stone_brick_wall", () -> new BaseWall((BaseBlock) BROWNISH_RED_STONE_BRICKS.get()));
    public static final RegistryObject<Block> WHITE_AND_PINK_MIXED_BRICKS = BLOCKS.register("white_and_pink_mixed_bricks", () -> new BaseBlock(BaseBlockProperty.STONE));
    public static final RegistryObject<Block> GREEN_WEATHERED_BRICKS = BLOCKS.register("green_weathered_bricks", () -> new BaseBlock(BaseBlockProperty.STONE));

    // STONES

    public static final RegistryObject<Block> PALE_YELLOW_STONE = BLOCKS.register("pale_yellow_stone", BaseBlock::new);
    public static final RegistryObject<Block> PALE_YELLOW_STONE_SLAB = BLOCKS.register("pale_yellow_stone_slab", () -> new BaseSlab((BaseBlock) PALE_YELLOW_STONE.get()));
    public static final RegistryObject<Block> PALE_YELLOW_STONE_STAIRS = BLOCKS.register("pale_yellow_stone_stairs", () -> new BaseStairs((BaseBlock) PALE_YELLOW_STONE.get()));
    public static final RegistryObject<Block> VARIEGATED_ROCKS = BLOCKS.register("variegated_rocks", BaseBlock::new);
    public static final RegistryObject<Block> VARIEGATED_ROCK_SLAB = BLOCKS.register("variegated_rock_slab", () -> new BaseSlab((BaseBlock) VARIEGATED_ROCKS.get()));
    public static final RegistryObject<Block> VARIEGATED_ROCK_STAIRS = BLOCKS.register("variegated_rock_stairs", () -> new BaseStairs((BaseBlock) VARIEGATED_ROCKS.get()));
    public static final RegistryObject<Block> WEATHERED_STONE = BLOCKS.register("weathered_stone", BaseBlock::new);
    public static final RegistryObject<Block> WEATHERED_STONE_SLAB = BLOCKS.register("weathered_stone_slab", () -> new BaseSlab((BaseBlock) WEATHERED_STONE.get()));
    public static final RegistryObject<Block> WEATHERED_STONE_STAIRS = BLOCKS.register("weathered_stone_stairs", () -> new BaseStairs((BaseBlock) WEATHERED_STONE.get()));
    public static final RegistryObject<Block> POLISHED_WEATHERED_STONE = BLOCKS.register("polished_weathered_stone", BaseBlock::new);
    public static final RegistryObject<Block> POLISHED_WEATHERED_STONE_SLAB = BLOCKS.register("polished_weathered_stone_slab", () -> new BaseSlab((BaseBlock) POLISHED_WEATHERED_STONE.get()));
    public static final RegistryObject<Block> POLISHED_WEATHERED_STONE_STAIRS = BLOCKS.register("polished_weathered_stone_stairs", () -> new BaseStairs((BaseBlock) POLISHED_WEATHERED_STONE.get()));
    public static final RegistryObject<Block> POLISHED_WEATHERED_STONE_WALL = BLOCKS.register("polished_weathered_stone_wall", () -> new BaseWall((BaseBlock) POLISHED_WEATHERED_STONE.get()));
    public static final RegistryObject<Block> GREEN_WEATHERED_STONE = BLOCKS.register("green_weathered_stone", () -> new BaseBlock(BaseBlockProperty.STONE));

    // FLOOR TILES

    public static final RegistryObject<Block> LIGHT_CYAN_FLOOR_TILE = BLOCKS.register("light_cyan_floor_tile", () -> new BaseBlock(BaseBlockProperty.TILE));
    public static final RegistryObject<Block> LIGHT_CYAN_FLOOR_TILE_SLAB = BLOCKS.register("light_cyan_floor_tile_slab", () -> new BaseSlab((BaseBlock) LIGHT_CYAN_FLOOR_TILE.get()));
    public static final RegistryObject<Block> LIGHT_CYAN_FLOOR_TILE_STAIRS = BLOCKS.register("light_cyan_floor_tile_stairs", () -> new BaseStairs((BaseBlock) LIGHT_CYAN_FLOOR_TILE.get()));
    public static final RegistryObject<Block> LIGHT_CYAN_FLOOR_TILE_WALL = BLOCKS.register("light_cyan_floor_tile_wall", () -> new BaseWall((BaseBlock) LIGHT_CYAN_FLOOR_TILE.get()));
    public static final RegistryObject<Block> CYAN_FLOOR_TILE = BLOCKS.register("cyan_floor_tile", () -> new BaseBlock(BaseBlockProperty.TILE));
    public static final RegistryObject<Block> CYAN_FLOOR_TILE_SLAB = BLOCKS.register("cyan_floor_tile_slab", () -> new BaseSlab((BaseBlock) CYAN_FLOOR_TILE.get()));
    public static final RegistryObject<Block> CYAN_FLOOR_TILE_STAIRS = BLOCKS.register("cyan_floor_tile_stairs", () -> new BaseStairs((BaseBlock) CYAN_FLOOR_TILE.get()));
    public static final RegistryObject<Block> CYAN_FLOOR_TILE_WALL = BLOCKS.register("cyan_floor_tile_wall", () -> new BaseWall((BaseBlock) CYAN_FLOOR_TILE.get()));
    public static final RegistryObject<Block> DARK_CYAN_FLOOR_TILE = BLOCKS.register("dark_cyan_floor_tile", () -> new BaseBlock(BaseBlockProperty.STONE));
    public static final RegistryObject<Block> LAYERED_CYAN_FLOOR_TILES = BLOCKS.register("layered_cyan_floor_tiles", () -> new BaseHorizontalDirectionalBlock(BaseBlockProperty.STONE));
    public static final RegistryObject<Block> VERTICAL_CYAN_FLOOR_TILES = BLOCKS.register("vertical_cyan_floor_tiles", () -> new BaseHorizontalDirectionalBlock(BaseBlockProperty.STONE));
    public static final RegistryObject<Block> MIXED_CYAN_FLOOR_TILES = BLOCKS.register("mixed_cyan_floor_tiles", () -> new BaseHorizontalDirectionalBlock(BaseBlockProperty.STONE));
    public static final RegistryObject<Block> CHISELED_CYAN_FLOOR_TILE = BLOCKS.register("chiseled_cyan_floor_tile", () -> new BaseBlock(BaseBlockProperty.STONE));
    public static final RegistryObject<Block> CUT_CYAN_FLOOR_TILES = BLOCKS.register("cut_cyan_floor_tiles", () -> new BaseBlock(BaseBlockProperty.STONE));
    public static final RegistryObject<Block> WEATHERED_RED_STONE_TILE = BLOCKS.register("weathered_red_stone_tile", () -> new BaseBlock(BaseBlockProperty.STONE));
    public static final RegistryObject<Block> BLUE_AND_BLACK_TILE = BLOCKS.register("blue_and_black_tile", () -> new BaseBlock(BaseBlockProperty.STONE));
    public static final RegistryObject<Block> GREEN_GLAZED_TILES = BLOCKS.register("green_glazed_tiles", () -> new BaseBlock(BaseBlockProperty.GLAZED));
    public static final RegistryObject<Block> GREEN_GLAZED_TILE_SLAB = BLOCKS.register("green_glazed_tile_slab", () -> new BaseSlab((BaseBlock) GREEN_GLAZED_TILES.get()));
    public static final RegistryObject<Block> GREEN_GLAZED_TILE_STAIRS = BLOCKS.register("green_glazed_tile_stairs", () -> new BaseStairs((BaseBlock) GREEN_GLAZED_TILES.get()));
    public static final RegistryObject<Block> BLACK_FLOOR_TILES = BLOCKS.register("black_floor_tiles", () -> new BaseBlock(BaseBlockProperty.STONE));
    public static final RegistryObject<Block> BLACK_FLOOR_TILES_LITTLE_MOSSY = BLOCKS.register("black_floor_tiles_little_mossy", () -> new BaseHorizontalDirectionalBlock(BaseBlockProperty.STONE));
    public static final RegistryObject<Block> BLACK_FLOOR_TILES_MODERATE_MOSSY = BLOCKS.register("black_floor_tiles_moderate_mossy", () -> new BaseHorizontalDirectionalBlock(BaseBlockProperty.STONE));
    public static final RegistryObject<Block> BLACK_FLOOR_TILES_VERY_MOSSY = BLOCKS.register("black_floor_tiles_very_mossy", () -> new BaseHorizontalDirectionalBlock(BaseBlockProperty.STONE));

    // WOODEN

    public static final RegistryObject<Block> ROSEWOOD_PLANKS = BLOCKS.register("rosewood_planks", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> ROSEWOOD_SLAB = BLOCKS.register("rosewood_slab", () -> new BaseSlab((BaseBlock) ROSEWOOD_PLANKS.get()));
    public static final RegistryObject<Block> ROSEWOOD_STAIRS = BLOCKS.register("rosewood_stairs", () -> new BaseStairs((BaseBlock) ROSEWOOD_PLANKS.get()));
    public static final RegistryObject<Block> ROSEWOOD_FENCE = BLOCKS.register("rosewood_fence", () -> new BaseFence((BaseBlock) ROSEWOOD_PLANKS.get()));
    public static final RegistryObject<Block> BAMBOO_MAT = BLOCKS.register("bamboo_mat", () -> new BaseBlock(BaseBlockProperty.BAMBOO_WOOD));
    public static final RegistryObject<Block> BAMBOO_MAT_SLAB = BLOCKS.register("bamboo_mat_slab", () -> new BaseSlab((BaseBlock) BAMBOO_MAT.get()));
    public static final RegistryObject<Block> BAMBOO_MAT_STAIRS = BLOCKS.register("bamboo_mat_stairs", () -> new BaseStairs((BaseBlock) BAMBOO_MAT.get()));

    // ROOF TILES

    public static final RegistryObject<Block> GRAY_ROOF_TILES = BLOCKS.register("gray_roof_tiles", () -> new RoofTiles(DyeColor.GRAY, RoofTiles.RoofTileType.NORMAL));
    public static final RegistryObject<Block> GRAY_ROOF_TILE_STAIRS = BLOCKS.register("gray_roof_tile_stairs", () -> new RoofTiles(DyeColor.GRAY, RoofTiles.RoofTileType.STAIRS));
    public static final RegistryObject<Block> GRAY_ROOF_TILE_EDGE = BLOCKS.register("gray_roof_tile_edge", () -> new RoofTiles(DyeColor.GRAY, RoofTiles.RoofTileType.EDGE));
    public static final RegistryObject<Block> YELLOW_ROOF_TILES = BLOCKS.register("yellow_roof_tiles", () -> new RoofTiles(DyeColor.YELLOW, RoofTiles.RoofTileType.NORMAL));
    public static final RegistryObject<Block> YELLOW_ROOF_TILE_STAIRS = BLOCKS.register("yellow_roof_tile_stairs", () -> new RoofTiles(DyeColor.YELLOW, RoofTiles.RoofTileType.STAIRS));
    public static final RegistryObject<Block> YELLOW_ROOF_TILE_EDGE = BLOCKS.register("yellow_roof_tile_edge", () -> new RoofTiles(DyeColor.YELLOW, RoofTiles.RoofTileType.EDGE));
    public static final RegistryObject<Block> GREEN_ROOF_TILES = BLOCKS.register("green_roof_tiles", () -> new RoofTiles(DyeColor.GREEN, RoofTiles.RoofTileType.NORMAL));
    public static final RegistryObject<Block> GREEN_ROOF_TILE_STAIRS = BLOCKS.register("green_roof_tile_stairs", () -> new RoofTiles(DyeColor.GREEN, RoofTiles.RoofTileType.STAIRS));
    public static final RegistryObject<Block> GREEN_ROOF_TILE_EDGE = BLOCKS.register("green_roof_tile_edge", () -> new RoofTiles(DyeColor.GREEN, RoofTiles.RoofTileType.EDGE));
    public static final RegistryObject<Block> BLUE_ROOF_TILES = BLOCKS.register("blue_roof_tiles", () -> new RoofTiles(DyeColor.BLUE, RoofTiles.RoofTileType.NORMAL));
    public static final RegistryObject<Block> BLUE_ROOF_TILE_STAIRS = BLOCKS.register("blue_roof_tile_stairs", () -> new RoofTiles(DyeColor.BLUE, RoofTiles.RoofTileType.STAIRS));
    public static final RegistryObject<Block> BLUE_ROOF_TILE_EDGE = BLOCKS.register("blue_roof_tile_edge", () -> new RoofTiles(DyeColor.BLUE, RoofTiles.RoofTileType.EDGE));
    public static final RegistryObject<Block> CYAN_ROOF_TILES = BLOCKS.register("cyan_roof_tiles", () -> new RoofTiles(DyeColor.CYAN, RoofTiles.RoofTileType.NORMAL));
    public static final RegistryObject<Block> CYAN_ROOF_TILE_STAIRS = BLOCKS.register("cyan_roof_tile_stairs", () -> new RoofTiles(DyeColor.CYAN, RoofTiles.RoofTileType.STAIRS));
    public static final RegistryObject<Block> CYAN_ROOF_TILE_EDGE = BLOCKS.register("cyan_roof_tile_edge", () -> new RoofTiles(DyeColor.CYAN, RoofTiles.RoofTileType.EDGE));
    public static final RegistryObject<Block> BLACK_ROOF_TILES = BLOCKS.register("black_roof_tiles", () -> new RoofTiles(DyeColor.BLACK, RoofTiles.RoofTileType.NORMAL));
    public static final RegistryObject<Block> BLACK_ROOF_TILE_STAIRS = BLOCKS.register("black_roof_tile_stairs", () -> new RoofTiles(DyeColor.BLACK, RoofTiles.RoofTileType.STAIRS));
    public static final RegistryObject<Block> BLACK_ROOF_TILE_EDGE = BLOCKS.register("black_roof_tile_edge", () -> new RoofTiles(DyeColor.BLACK, RoofTiles.RoofTileType.EDGE));

    // ROOF RIDGE

    public static final RegistryObject<Block> BLACK_ROOF_RIDGE_UPPER = BLOCKS.register("black_roof_ridge_upper", () -> new RoofRidge(DyeColor.BLACK, RoofRidge.RoofRidgeType.UPPER));
    public static final RegistryObject<Block> BLACK_ROOF_RIDGE_LOWER = BLOCKS.register("black_roof_ridge_lower", () -> new RoofRidge(DyeColor.BLACK, RoofRidge.RoofRidgeType.LOWER));
    public static final RegistryObject<Block> BLACK_ROOF_RIDGE_CONNECTION = BLOCKS.register("black_roof_ridge_connection", () -> new RoofRidgeConnection(DyeColor.BLACK, SnowRoofRidge.RoofRidgeType.CONNECTION));
    public static final RegistryObject<Block> BLACK_MAIN_ROOF_RIDGE_CONNECTION = BLOCKS.register("black_main_roof_ridge_connection", () -> new RoofMainRidgeConnection(DyeColor.BLACK, SnowRoofRidge.RoofRidgeType.MAIN_CONNECTION));
    public static final RegistryObject<Block> BLACK_ROOF_RIDGE_UPPER_SLAB = BLOCKS.register("black_roof_ridge_upper_slab", () -> new BaseSlab(BaseBlockProperty.STONE));
    public static final RegistryObject<Block> BLACK_MAIN_ROOF_RIDGE_SLAB = BLOCKS.register("black_main_roof_ridge_slab", () -> new BaseHorizontalDirectionalSlab(BaseBlockProperty.STONE));
    public static final RegistryObject<Block> BLACK_MAIN_ROOF_RIDGE_PANEL = BLOCKS.register("black_main_roof_ridge_panel", () -> new RoofRidgePanel(BaseBlockProperty.STONE));
    public static final RegistryObject<Block> BLACK_MAIN_ROOF_RIDGE_PLATE = BLOCKS.register("black_main_roof_ridge_plate", () -> new RoofRidgePlate(BaseBlockProperty.STONE));
    public static final RegistryObject<Block> BLACK_MAIN_ROOF_RIDGE_STAIRS = BLOCKS.register("black_main_roof_ridge_stairs", () -> new StraightStairBlock(BaseBlockProperty.STONE));

    public static final RegistryObject<Block> YELLOW_ROOF_RIDGE_UPPER = BLOCKS.register("yellow_roof_ridge_upper", () -> new RoofRidge(DyeColor.YELLOW, RoofRidge.RoofRidgeType.UPPER));
    public static final RegistryObject<Block> YELLOW_ROOF_RIDGE_LOWER = BLOCKS.register("yellow_roof_ridge_lower", () -> new RoofRidge(DyeColor.YELLOW, RoofRidge.RoofRidgeType.LOWER));
    public static final RegistryObject<Block> YELLOW_ROOF_RIDGE_CONNECTION = BLOCKS.register("yellow_roof_ridge_connection", () -> new RoofRidgeConnection(DyeColor.YELLOW, SnowRoofRidge.RoofRidgeType.CONNECTION));
    public static final RegistryObject<Block> YELLOW_MAIN_ROOF_RIDGE_CONNECTION = BLOCKS.register("yellow_main_roof_ridge_connection", () -> new RoofMainRidgeConnection(DyeColor.YELLOW, SnowRoofRidge.RoofRidgeType.MAIN_CONNECTION));
    public static final RegistryObject<Block> YELLOW_ROOF_RIDGE_UPPER_SLAB = BLOCKS.register("yellow_roof_ridge_upper_slab", () -> new BaseSlab(BaseBlockProperty.STONE));
    public static final RegistryObject<Block> YELLOW_MAIN_ROOF_RIDGE_SLAB = BLOCKS.register("yellow_main_roof_ridge_slab", () -> new BaseHorizontalDirectionalSlab(BaseBlockProperty.STONE));
    public static final RegistryObject<Block> YELLOW_MAIN_ROOF_RIDGE_PANEL = BLOCKS.register("yellow_main_roof_ridge_panel", () -> new RoofRidgePanel(BaseBlockProperty.STONE));
    public static final RegistryObject<Block> YELLOW_MAIN_ROOF_RIDGE_PLATE = BLOCKS.register("yellow_main_roof_ridge_plate", () -> new RoofRidgePlate(BaseBlockProperty.STONE));
    public static final RegistryObject<Block> YELLOW_MAIN_ROOF_RIDGE_STAIRS = BLOCKS.register("yellow_main_roof_ridge_stairs", () -> new StraightStairBlock(BaseBlockProperty.STONE));

    /**
     *  DECORATIVE BLOCKS
     */

    // SIMPLE CARVED WOOD

    public static final RegistryObject<Block> RED_CARVED_WOOD = BLOCKS.register("red_carved_wood", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> RED_CARVED_WOODEN_SLAB = BLOCKS.register("red_carved_wooden_slab", () -> new BaseSlab(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> RED_CARVED_WOODEN_STAIRS = BLOCKS.register("red_carved_wooden_stairs", () -> new StraightStairBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_CARVED_WOOD = BLOCKS.register("blue_carved_wood", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_CARVED_WOODEN_SLAB = BLOCKS.register("blue_carved_wooden_slab", () -> new BaseSlab(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_CARVED_WOODEN_STAIRS = BLOCKS.register("blue_carved_wooden_stairs", () -> new StraightStairBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_CARVED_WOODEN_BRACKET_STAIRS = BLOCKS.register("blue_carved_wooden_bracket_stairs", () -> new StraightStairBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_CARVED_WOODEN_BRACKET = BLOCKS.register("blue_carved_wooden_bracket", () -> new Bracket(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> CYAN_CARVED_WOOD = BLOCKS.register("cyan_carved_wood", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> CYAN_CARVED_WOODEN_SLAB = BLOCKS.register("cyan_carved_wooden_slab", () -> new BaseSlab(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> CYAN_CARVED_WOODEN_STAIRS = BLOCKS.register("cyan_carved_wooden_stairs", () -> new StraightStairBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> CYAN_CARVED_WOODEN_BRACKET = BLOCKS.register("cyan_carved_wooden_bracket", () -> new Bracket(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GREEN_CARVED_WOOD = BLOCKS.register("green_carved_wood", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GREEN_CARVED_WOODEN_SLAB = BLOCKS.register("green_carved_wooden_slab", () -> new BaseSlab(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GREEN_CARVED_WOODEN_STAIRS = BLOCKS.register("green_carved_wooden_stairs", () -> new StraightStairBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GREEN_CARVED_WOODEN_BRACKET = BLOCKS.register("green_carved_wooden_bracket", () -> new Bracket(BaseBlockProperty.WOOD));

    // MIXED CARVED WOOD

    public static final RegistryObject<Block> ORANGE_AND_BLUE_CARVED_WOOD = BLOCKS.register("orange_and_blue_carved_wood", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> ORANGE_AND_GREEN_CARVED_WOOD = BLOCKS.register("orange_and_green_carved_wood", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GREEN_AND_BLUE_CARVED_WOOD = BLOCKS.register("green_and_blue_carved_wood", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> DARK_GREEN_AND_DARK_BLUE_CARVED_WOOD = BLOCKS.register("dark_green_and_dark_blue_carved_wood", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> DARK_BLUE_AND_DARK_GREEN_CARVED_WOOD = BLOCKS.register("dark_blue_and_dark_green_carved_wood", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLACK_WHITE_GREEN_CARVED_WOOD = BLOCKS.register("black_white_green_carved_wood", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLACK_WHITE_BLUE_CARVED_WOOD = BLOCKS.register("black_white_blue_carved_wood", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> RED_AND_GREEN_CARVED_WOOD = BLOCKS.register("red_and_green_carved_wood", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_AND_RED_CARVED_WOOD = BLOCKS.register("blue_and_red_carved_wood", () -> new BaseBlock(BaseBlockProperty.WOOD));

    public static final RegistryObject<Block> BLUE_WHITE_RED_CARVED_WOOD = BLOCKS.register("blue_white_red_carved_wood", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GREEN_WHITE_RED_CARVED_WOOD = BLOCKS.register("green_white_red_carved_wood", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1 = BLOCKS.register("blue_and_yellow_carved_wood_variant_1", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2 = BLOCKS.register("blue_and_yellow_carved_wood_variant_2", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3 = BLOCKS.register("blue_and_yellow_carved_wood_variant_3", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> YELLOW_AND_GREEN_CARVED_WOOD = BLOCKS.register("yellow_and_green_carved_wood", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> YELLOW_GREEN_BLUE_CARVED_WOOD = BLOCKS.register("yellow_green_blue_carved_wood", () -> new BaseBlock(BaseBlockProperty.WOOD));

    // DARK OAK

    public static final RegistryObject<Block> CARVED_DARK_OAK_BEAM = BLOCKS.register("carved_dark_oak_beam", () -> new ChiralDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> CARVED_DARK_OAK_BEAM_EDGE = BLOCKS.register("carved_dark_oak_beam_edge", () -> new ChiralDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GILDED_DARK_OAK = BLOCKS.register("gilded_dark_oak", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> CHISELED_GILDED_DARK_OAK = BLOCKS.register("chiseled_gilded_dark_oak", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GILDED_DARK_OAK_SLAB = BLOCKS.register("gilded_dark_oak_slab", () -> new BaseSlab(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GILDED_DARK_OAK_STAIRS = BLOCKS.register("gilded_dark_oak_stairs", () -> new StraightStairBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GILDED_DARK_OAK_BRACKET = BLOCKS.register("gilded_dark_oak_bracket", () -> new Bracket(BaseBlockProperty.WOOD));

    // PILLARS

    public static final RegistryObject<Block> CARVED_RED_PILLAR = BLOCKS.register("carved_red_pillar", () -> new BaseBlock(BaseBlockProperty.TERRACOTTA));
    public static final RegistryObject<Block> CARVED_RED_PILLAR_BASE = BLOCKS.register("carved_red_pillar_base", () -> new BaseBlock(BaseBlockProperty.TERRACOTTA));
    public static final RegistryObject<Block> CARVED_RED_PILLAR_HEAD = BLOCKS.register("carved_red_pillar_head", () -> new BaseDirectionalBlock(BaseBlockProperty.TERRACOTTA));
    public static final RegistryObject<Block> SPRUCE_PILLAR_BASE = BLOCKS.register("spruce_pillar_base", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> STRIPPED_DARK_OAK_PILLAR_BASE = BLOCKS.register("stripped_dark_oak_pillar_base", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_1 = BLOCKS.register("gilded_dark_oak_pillar_head_variant_1", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_2 = BLOCKS.register("gilded_dark_oak_pillar_head_variant_2", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_3 = BLOCKS.register("gilded_dark_oak_pillar_head_variant_3", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_4 = BLOCKS.register("gilded_dark_oak_pillar_head_variant_4", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_5 = BLOCKS.register("gilded_dark_oak_pillar_head_variant_5", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> CYAN_AND_WHITE_PILLAR_BASE = BLOCKS.register("cyan_and_white_pillar_base", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> CYAN_AND_WHITE_DECORATED_PILLAR = BLOCKS.register("cyan_and_white_decorated_pillar", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> CYAN_AND_WHITE_PILLAR_HEAD = BLOCKS.register("cyan_and_white_pillar_head", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> STONE_PILLAR_BASE = BLOCKS.register("stone_pillar_base", () -> new BaseBlock(BaseBlockProperty.WOOD));

    // FANGXIN

    public static final RegistryObject<Block> GREEN_FANGXIN = BLOCKS.register("green_fangxin", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GREEN_FANGXIN_EDGE = BLOCKS.register("green_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_FANGXIN = BLOCKS.register("blue_fangxin", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_FANGXIN_EDGE = BLOCKS.register("blue_fangxin_edge", () -> new ChiralDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> CYAN_AND_BLUE_FANGXIN = BLOCKS.register("cyan_and_blue_fangxin", () -> new BasePillarBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> CYAN_AND_BLUE_FANGXIN_EDGE = BLOCKS.register("cyan_and_blue_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> CYAN_AND_BLUE_FANGXIN_EDGE_VARIANT = BLOCKS.register("cyan_and_blue_fangxin_edge_variant", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> CYAN_BLUE_WHITE_FANGXIN = BLOCKS.register("cyan_blue_white_fangxin", () -> new BasePillarBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> CYAN_BLUE_WHITE_FANGXIN_EDGE = BLOCKS.register("cyan_blue_white_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_AND_GREEN_FANGXIN_EDGE = BLOCKS.register("blue_and_green_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> YELLOW_AND_GREEN_FANGXIN_EDGE = BLOCKS.register("yellow_and_green_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> DARK_BLUE_FANGXIN = BLOCKS.register("dark_blue_fangxin", () -> new BasePillarBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> DARK_BLUE_FANGXIN_EDGE = BLOCKS.register("dark_blue_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_AND_WHITE_FANGXIN = BLOCKS.register("blue_and_white_fangxin", () -> new BasePillarBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GREEN_AND_DARK_BLUE_FANGXIN = BLOCKS.register("green_and_dark_blue_fangxin", () -> new BasePillarBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> WHITE_AND_CYAN_FANGXIN = BLOCKS.register("white_and_cyan_fangxin", () -> new BasePillarBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> WHITE_AND_CYAN_FANGXIN_EDGE = BLOCKS.register("white_and_cyan_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> WHITE_AND_BLUE_FANGXIN = BLOCKS.register("white_and_blue_fangxin", () -> new BasePillarBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> WHITE_AND_BLUE_FANGXIN_EDGE = BLOCKS.register("white_and_blue_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> RED_CYAN_BLUE_FANGXIN = BLOCKS.register("red_cyan_blue_fangxin", () -> new ChiralDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> RED_CYAN_BLUE_FANGXIN_EDGE = BLOCKS.register("red_cyan_blue_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_CYAN_BLUE_FANGXIN_EDGE = BLOCKS.register("blue_cyan_blue_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_CYAN_RED_FANGXIN = BLOCKS.register("blue_cyan_red_fangxin", () -> new ChiralDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_CYAN_RED_FANGXIN_EDGE = BLOCKS.register("blue_cyan_red_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> CYAN_BLUE_CYAN_FANGXIN = BLOCKS.register("cyan_blue_cyan_fangxin", () -> new ChiralDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> RED_BLUE_RED_FANGXIN = BLOCKS.register("red_blue_red_fangxin", () -> new ChiralDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> CYAN_AND_YELLOW_FANGXIN_EDGE = BLOCKS.register("cyan_and_yellow_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));

    // ZHAOTOU

    public static final RegistryObject<Block> BLUE_ZHAOTOU_EDGE = BLOCKS.register("blue_zhaotou_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GREEN_AND_BLUE_ZHAOTOU = BLOCKS.register("green_and_blue_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_AND_GREEN_ZHAOTOU = BLOCKS.register("blue_and_green_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_AND_GREEN_DOUBLE_LAYERED_ZHAOTOU = BLOCKS.register("blue_and_green_double_layered_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> CYAN_AND_RED_ZHAOTOU = BLOCKS.register("cyan_and_red_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> CYAN_AND_BLUE_ZHAOTOU = BLOCKS.register("cyan_and_blue_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GRAY_BLACK_RED_ZHAOTOU = BLOCKS.register("gray_black_red_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_GREEN_RED_ZHAOTOU = BLOCKS.register("blue_green_red_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> RED_AND_BLUE_ZHAOTOU = BLOCKS.register("red_and_blue_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GREEN_AND_YELLOW_ZHAOTOU = BLOCKS.register("green_and_yellow_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> RED_GREEN_BLUE_ZHAOTOU = BLOCKS.register("red_green_blue_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> WHITE_BLUE_GREEN_ZHAOTOU = BLOCKS.register("white_blue_green_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));

    // GUTOU

    public static final RegistryObject<Block> GREEN_BLUE_BLACK_GUTOU = BLOCKS.register("green_blue_black_gutou", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_GREEN_YELLOW_GUTOU = BLOCKS.register("blue_green_yellow_gutou", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_AND_YELLOW_GUTOU = BLOCKS.register("blue_and_yellow_gutou", () -> new BaseDirectionalBlock(BaseBlockProperty.WOOD));

    // RAFTERS

    public static final RegistryObject<Block> GILDED_DARK_OAK_RAFTER = BLOCKS.register("gilded_dark_oak_rafter", () -> new Rafter(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GILDED_DARK_OAK_RAFTER_END = BLOCKS.register("gilded_dark_oak_rafter_end", () -> new RafterEnd(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> DARK_OAK_RAFTER = BLOCKS.register("dark_oak_rafter", () -> new Rafter(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> DARK_OAK_RAFTER_END = BLOCKS.register("dark_oak_rafter_end", () -> new RafterEnd(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_TIGER_EYE_RAFTER = BLOCKS.register("blue_tiger_eye_rafter", () -> new Rafter(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_TIGER_EYE_RAFTER_END = BLOCKS.register("blue_tiger_eye_rafter_end", () -> new RafterEnd(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_CARVED_TIGER_EYE_RAFTER = BLOCKS.register("blue_carved_tiger_eye_rafter", () -> new Rafter(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BLUE_CARVED_TIGER_EYE_RAFTER_END = BLOCKS.register("blue_carved_tiger_eye_rafter_end", () -> new RafterEnd(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GREEN_CARVED_TIGER_EYE_RAFTER = BLOCKS.register("green_tiger_eye_rafter", () -> new Rafter(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GREEN_CARVED_TIGER_EYE_RAFTER_END = BLOCKS.register("green_tiger_eye_rafter_end", () -> new RafterEnd(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GREEN_WANZI_RAFTER = BLOCKS.register("green_wanzi_rafter", () -> new Rafter(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GREEN_WANZI_RAFTER_END = BLOCKS.register("green_wanzi_rafter_end", () -> new RafterEnd(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GREEN_CARVED_WANZI_RAFTER = BLOCKS.register("green_carved_wanzi_rafter", () -> new Rafter(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> GREEN_CARVED_WANZI_RAFTER_END = BLOCKS.register("green_carved_wanzi_rafter_end", () -> new RafterEnd(BaseBlockProperty.WOOD));

    // BEAM HEAD

    public static final RegistryObject<Block> GILDED_DARK_OAK_BEAM_HEAD = BLOCKS.register("gilded_dark_oak_beam_head", () -> new BeamHead(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> QING_GREEN_BEAM_HEAD = BLOCKS.register("qing_green_beam_head", () -> new WallSideBlock(BaseBlockProperty.WOOD, 14));

    // ARCHITRAVE

    public static final RegistryObject<Block> RED_AND_CYAN_CARVED_ARCHITRAVE = BLOCKS.register("red_and_cyan_carved_architrave", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> RED_AND_CYAN_CARVED_ARCHITRAVE_SLAB = BLOCKS.register("red_and_cyan_carved_architrave_slab", () -> new BaseSlab(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> RED_AND_BLUE_CARVED_ARCHITRAVE = BLOCKS.register("red_and_blue_carved_architrave", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> RED_AND_BLUE_CARVED_ARCHITRAVE_SLAB = BLOCKS.register("red_and_blue_carved_architrave_slab", () -> new BaseSlab(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> EMPTY_TUANHUA_SLAB = BLOCKS.register("empty_tuanhua_slab", () -> new BaseSlab(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> FULL_TUANHUA_SLAB = BLOCKS.register("full_tuanhua_slab", () -> new BaseSlab(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> RED_AND_CYAN_TUANHUA_SLAB = BLOCKS.register("red_and_cyan_tuanhua_slab", () -> new BaseSlab(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> RED_CARVED_ARCHITRAVE = BLOCKS.register("red_carved_architrave", () -> new BaseSlab(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> WHITE_AND_RED_SLAB = BLOCKS.register("white_and_red_slab", () -> new BaseSlab(BaseBlockProperty.WOOD));

    // QUETI

    public static final RegistryObject<Block> LONG_GILDED_DARK_OAK_QUETI = BLOCKS.register("long_gilded_dark_oak_queti", () -> new WallSideBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> LONG_GILDED_DARK_OAK_QUETI_EDGE = BLOCKS.register("long_gilded_dark_oak_queti_edge", () -> new OrientableWallSideBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> HORIZONTAL_GILDED_DARK_OAK_QUETI = BLOCKS.register("horizontal_gilded_dark_oak_queti", () -> new SideAxialBlock(BaseBlockProperty.WOOD, 4));
    public static final RegistryObject<Block> CENTRAL_GILDED_DARK_OAK_QUETI = BLOCKS.register("central_gilded_dark_oak_queti", () -> new CentralAxialBlock(BaseBlockProperty.WOOD, 4));
    public static final RegistryObject<Block> VERTICAL_GILDED_DARK_OAK_QUETI = BLOCKS.register("vertical_gilded_dark_oak_queti", () -> new SideAxialBlock(BaseBlockProperty.WOOD, 4));
    public static final RegistryObject<Block> WOODEN_QUETI = BLOCKS.register("wooden_queti", () -> new WallSideBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> WOODEN_QUETI_EDGE = BLOCKS.register("wooden_queti_edge", () -> new OrientableWallSideBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> TALL_WOODEN_QUETI_EDGE = BLOCKS.register("tall_wooden_queti_edge", () -> new OrientableWallSideBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> LARGE_WOODEN_QUETI_EDGE = BLOCKS.register("large_wooden_queti_edge", () -> new OrientableWallSideBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> SHORT_GLAZED_QUETI = BLOCKS.register("short_glazed_queti", () -> new OrientableWallSideBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> THICK_CARVED_QUETI = BLOCKS.register("thick_carved_queti", () -> new SideAxialBlock(BaseBlockProperty.WOOD, 4));
    public static final RegistryObject<Block> SHORT_THICK_GLAZED_QUETI = BLOCKS.register("short_thick_glazed_queti", () -> new SideAxialBlock(BaseBlockProperty.WOOD, 8));
    public static final RegistryObject<Block> WOODEN_GUALUO = BLOCKS.register("wooden_gualuo", () -> new WallSideBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> LARGE_WOODEN_GUALUO = BLOCKS.register("large_wooden_gualuo", () -> new WallSideBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> LARGE_WOODEN_GUALUO_EDGE = BLOCKS.register("large_wooden_gualuo_edge", () -> new OrientableWallSideBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> CARVED_STONE_PANEL = BLOCKS.register("carved_stone_panel", () -> new CentralAxialBlock(BaseBlockProperty.STONE, 8));
    public static final RegistryObject<Block> CARVED_STONE_PANEL_EDGE = BLOCKS.register("carved_stone_panel_edge", () -> new SideAxialBlock(BaseBlockProperty.STONE, 8));
    public static final RegistryObject<Block> CARVED_STONE_PANEL_CENTER = BLOCKS.register("carved_stone_panel_center", () -> new CentralAxialBlock(BaseBlockProperty.STONE, 8));
    public static final RegistryObject<Block> CARVED_STONE_QUETI_PART = BLOCKS.register("carved_stone_queti_part", () -> new SideAxialBlock(BaseBlockProperty.STONE, 8));
    public static final RegistryObject<Block> CARVED_STONE_BEAM = BLOCKS.register("carved_stone_beam", () -> new SideAxialBlock(BaseBlockProperty.STONE, 8));
    public static final RegistryObject<Block> CARVED_STONE_QUETI = BLOCKS.register("carved_stone_queti", () -> new SideAxialBlock(BaseBlockProperty.STONE, 8));

    // PATTERNS

    public static final RegistryObject<Block> YELLOW_CARVED_PATTERN = BLOCKS.register("yellow_carved_pattern", () -> new WallSideBlock(BaseBlockProperty.DYE));
    public static final RegistryObject<Block> CIRCULAR_YELLOW_CARVED_PATTERN = BLOCKS.register("circular_yellow_carved_pattern", () -> new SixSideBlock(BaseBlockProperty.DYE));
    public static final RegistryObject<Block> YELLOW_CARVED_FANGXIN_EDGE_PATTERN = BLOCKS.register("yellow_carved_fangxin_edge_pattern", () -> new OrientableSixSideBlock(BaseBlockProperty.DYE));
    public static final RegistryObject<Block> YELLOW_CARVED_FANGXIN_PATTERN = BLOCKS.register("yellow_carved_fangxin_pattern", () -> new OrientableSixSideBlock(BaseBlockProperty.DYE));
    public static final RegistryObject<Block> LARGE_YELLOW_CARVED_PATTERN = BLOCKS.register("large_yellow_carved_pattern", () -> new SixSideBlock(BaseBlockProperty.DYE));
    public static final RegistryObject<Block> MEDIUM_YELLOW_CARVED_PATTERN = BLOCKS.register("medium_yellow_carved_pattern", () -> new OrientableSixSideBlock(BaseBlockProperty.DYE));
    public static final RegistryObject<Block> YELLOW_CARVED_ZHAOTOU_PATTERN = BLOCKS.register("yellow_carved_zhaotou_pattern", () -> new OrientableSixSideBlock(BaseBlockProperty.DYE));
    public static final RegistryObject<Block> LONG_YELLOW_CARVED_ZHAOTOU_PATTERN = BLOCKS.register("long_yellow_carved_zhaotou_pattern", () -> new OrientableSixSideBlock(BaseBlockProperty.DYE));
    public static final RegistryObject<Block> CARVED_ZHAOTOU_PATTERN = BLOCKS.register("carved_zhaotou_pattern", () -> new OrientableSixSideBlock(BaseBlockProperty.DYE));
    public static final RegistryObject<Block> FLAME_ARCH_WALL_PATTERN = BLOCKS.register("flame_arch_wall_pattern", () -> new WallSideBlock(BaseBlockProperty.DYE));
    public static final RegistryObject<Block> GOLDEN_DRAGON_FANGXIN_PATTERN = BLOCKS.register("golden_dragon_fangxin_pattern", () -> new WallSideBlock(BaseBlockProperty.DYE));
    public static final RegistryObject<Block> BLUE_FANGXIN_PATTERN = BLOCKS.register("blue_fangxin_pattern", () -> new OrientableSixSideBlock(BaseBlockProperty.DYE));
    public static final RegistryObject<Block> BLUE_FANGXIN_PATTERN_EDGE = BLOCKS.register("blue_fangxin_pattern_edge", () -> new OrientableSixSideBlock(BaseBlockProperty.DYE));
    public static final RegistryObject<Block> GREEN_FANGXIN_PATTERN = BLOCKS.register("green_fangxin_pattern", () -> new OrientableSixSideBlock(BaseBlockProperty.DYE));
    public static final RegistryObject<Block> GREEN_FANGXIN_PATTERN_EDGE = BLOCKS.register("green_fangxin_pattern_edge", () -> new OrientableSixSideBlock(BaseBlockProperty.DYE));
    public static final RegistryObject<Block> LIGHT_BLUE_SU_STYLE_CAIHUA = BLOCKS.register("light_blue_su_style_caihua", () -> new WallSideBlock(BaseBlockProperty.DYE));
    public static final RegistryObject<Block> YELLOW_SU_STYLE_CAIHUA = BLOCKS.register("yellow_su_style_caihua", () -> new WallSideBlock(BaseBlockProperty.DYE));
    public static final RegistryObject<Block> LIGHT_YELLOW_SU_STYLE_CAIHUA = BLOCKS.register("light_yellow_su_style_caihua", () -> new WallSideBlock(BaseBlockProperty.DYE));
    public static final RegistryObject<Block> MEDIUM_SU_STYLE_CAIHUA = BLOCKS.register("medium_su_style_caihua", () -> new WallSideBlock(BaseBlockProperty.DYE));
    public static final RegistryObject<Block> LARGE_WHITE_SU_STYLE_CAIHUA = BLOCKS.register("large_white_su_style_caihua", () -> new WallSideBlock(BaseBlockProperty.DYE));
    public static final RegistryObject<Block> LARGE_GREEN_SU_STYLE_CAIHUA = BLOCKS.register("large_green_su_style_caihua", () -> new WallSideBlock(BaseBlockProperty.DYE));
    public static final RegistryObject<Block> LARGE_GRAY_SU_STYLE_CAIHUA = BLOCKS.register("large_gray_su_style_caihua", () -> new WallSideBlock(BaseBlockProperty.DYE));

    // CHUIHUA

    public static final RegistryObject<Block> BLUE_AND_GREEN_CHUIHUA = BLOCKS.register("blue_and_green_chuihua",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).diagonallyPlaceable().build());
    public static final RegistryObject<Block> CYAN_AND_YELLOW_CHUIHUA = BLOCKS.register("cyan_and_yellow_chuihua",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).build());
    public static final RegistryObject<Block> GILDED_DARK_OAK_CHUIHUA = BLOCKS.register("gilded_dark_oak_chuihua", () -> new SixSideBlock(BaseBlockProperty.WOOD, 14, true));

    // ROOF CHARM

    public static final RegistryObject<Block> GOLDEN_GLAZED_ROOF_CHARM = BLOCKS.register("golden_glazed_roof_charm",
            () -> DecorativeBlock.with(BaseBlockProperty.GLAZED).directional().build());
    public static final RegistryObject<Block> GOLDEN_GLAZED_ROOF_CHARM_ACCESSORY = BLOCKS.register("golden_glazed_roof_charm_accessory", () -> new WallSideBlock(BaseBlockProperty.GLAZED, 4));
    public static final RegistryObject<Block> GREEN_GLAZED_ROOF_CHARM = BLOCKS.register("green_glazed_roof_charm",
            () -> DecorativeBlock.with(BaseBlockProperty.GLAZED).directional().build());

    // CEILING

    public static final RegistryObject<Block> QING_GOLDEN_DRAGON_CEILING = BLOCKS.register("qing_golden_dragon_ceiling",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.HALF_BLOCK).build());

    // RAILING

    public static final RegistryObject<Block> WHITE_MARBLE_RAILING = BLOCKS.register("white_marble_railing", () -> new RailingBlock(BaseBlockProperty.MARBLE, RailingBlock.MARBLE_SHAPES));
    public static final RegistryObject<Block> WHITE_MARBLE_RAILING_SLANT = BLOCKS.register("white_marble_railing_slant", () -> new RailingSlant(BaseBlockProperty.MARBLE, 4));
    public static final RegistryObject<Block> CARVED_WOODEN_RAILING = BLOCKS.register("carved_wooden_railing", () -> new RailingBlock(BaseBlockProperty.WOOD, RailingBlock.WOODEN_SHAPES));
    public static final RegistryObject<Block> RED_WOODEN_RAILING = BLOCKS.register("red_wooden_railing", () -> new CentralAxialBlock(BaseBlockProperty.WOOD, 2, 15));
    public static final RegistryObject<Block> RED_WOODEN_RAILING_EDGE = BLOCKS.register("red_wooden_railing_edge", () -> new CentralAxialBlock(BaseBlockProperty.WOOD, 2, 15));
    public static final RegistryObject<Block> WOODEN_RAILING = BLOCKS.register("wooden_railing", () -> new CentralAxialBlock(BaseBlockProperty.WOOD, 2, 15));
    public static final RegistryObject<Block> WOODEN_RAILING_VARIANT = BLOCKS.register("wooden_railing_variant", () -> new CentralAxialBlock(BaseBlockProperty.WOOD, 2, 15));

    // GUARDIAN LION

    public static final RegistryObject<Block> SMALL_WOODEN_GUARDIAN_LION = BLOCKS.register("small_wooden_guardian_lion",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_BLOCK).directional().noOcclusion().noFenceConnect().build());
    public static final RegistryObject<Block> SMALL_STONE_GUARDIAN_LION = BLOCKS.register("small_stone_guardian_lion",
            () -> DecorativeBlock.with(BaseBlockProperty.STONE).shaped(DecorativeBlock.FULL_BLOCK).directional().noOcclusion().noFenceConnect().build());
    public static final RegistryObject<Block> SMALL_JADE_GUARDIAN_LION = BLOCKS.register("small_jade_guardian_lion",
            () -> DecorativeBlock.with(BaseBlockProperty.JADE).shaped(DecorativeBlock.FULL_BLOCK).directional().noOcclusion().noFenceConnect().build());
    public static final RegistryObject<Block> SMALL_YELLOW_GLAZED_GUARDIAN_LION = BLOCKS.register("small_yellow_glazed_guardian_lion",
            () -> DecorativeBlock.with(BaseBlockProperty.GLAZED).shaped(DecorativeBlock.FULL_BLOCK).directional().noOcclusion().noFenceConnect().build());
    public static final RegistryObject<Block> SMALL_GREEN_GLAZED_GUARDIAN_LION = BLOCKS.register("small_green_glazed_guardian_lion",
            () -> DecorativeBlock.with(BaseBlockProperty.GLAZED).shaped(DecorativeBlock.FULL_BLOCK).directional().noOcclusion().noFenceConnect().build());
    public static final RegistryObject<Block> XUMI_STONE_MONOLITH = BLOCKS.register("xumi_stone_monolith",
            () -> DecorativeBlock.with(BaseBlockProperty.STONE).shaped(DecorativeBlock.FULL_BLOCK).directional().noOcclusion().noFenceConnect().build());

    // MISC DECORATIONS

    public static final RegistryObject<Block> CABBAGE_BASKET = BLOCKS.register("cabbage_basket", () -> new StackableHalfBlock(BaseBlockProperty.CROP));
    public static final RegistryObject<Block> CELERY_BASKET = BLOCKS.register("celery_basket", () -> new StackableHalfBlock(BaseBlockProperty.CROP));
    public static final RegistryObject<Block> ORANGE_BASKET = BLOCKS.register("orange_basket", () -> new StackableHalfBlock(BaseBlockProperty.CROP));
    public static final RegistryObject<Block> APPLE_BASKET = BLOCKS.register("apple_basket", () -> new StackableHalfBlock(BaseBlockProperty.CROP));
    public static final RegistryObject<Block> EGGPLANT_BASKET = BLOCKS.register("eggplant_basket", () -> new StackableHalfBlock(BaseBlockProperty.CROP));
    public static final RegistryObject<Block> PEAR_BASKET = BLOCKS.register("pear_basket", () -> new StackableHalfBlock(BaseBlockProperty.CROP));
    public static final RegistryObject<Block> BOOKSHELF = BLOCKS.register("bookshelf", () -> new BaseHorizontalDirectionalBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BOOKSHELF_VARIANT = BLOCKS.register("bookshelf_variant", () -> new BaseHorizontalDirectionalBlock(BaseBlockProperty.WOOD));

    /**
     *  DECORATIONS
     */

    // STUDY

    public static final RegistryObject<Block> ABACUS = BLOCKS.register("abacus",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.DOUBLE_FLAT_14).directional().diagonallyPlaceable().noCollision().build());
    public static final RegistryObject<Block> BRUSH_TOOLS = BLOCKS.register("brush_tools",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_14).directional().diagonallyPlaceable().noCollision().build());
    public static final RegistryObject<Block> BRUSH_AND_INKSTONE = BLOCKS.register("brush_and_inkstone",
            () -> DecorativeBlock.with(BaseBlockProperty.PAPER).shaped(DecorativeBlock.QUARTER_16).directional().noCollision().noOcclusion().build());
    public static final RegistryObject<Block> RULER = BLOCKS.register("ruler",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FLAT_16).directional().diagonallyPlaceable().noCollision().build());
    public static final RegistryObject<Block> PAINTING_SCROLL = BLOCKS.register("painting_scroll",
            () -> DecorativeBlock.with(BaseBlockProperty.PAPER).shaped(DecorativeBlock.QUARTER_16).directional().diagonallyPlaceable().noCollision().build());
    public static final RegistryObject<Block> BOOK_STACK = BLOCKS.register("book_stack",
            () -> DecorativeBlock.with(BaseBlockProperty.PAPER).shaped(DecorativeBlock.QUARTER_16).directional().noOcclusion().build());
    public static final RegistryObject<Block> PAPER = BLOCKS.register("paper",
            () -> DecorativeBlock.with(BaseBlockProperty.PAPER).shaped(DecorativeBlock.FLAT_16).directional().diagonallyPlaceable().noOcclusion().noCollision().build());
    public static final RegistryObject<Block> BLUE_BOOK = BLOCKS.register("blue_book",
            () -> DecorativeBlock.with(BaseBlockProperty.PAPER).shaped(DecorativeBlock.QUARTER_16).directional().noOcclusion().noCollision().build());
    public static final RegistryObject<Block> BAMBOO_SLIPS = BLOCKS.register("bamboo_slips",
            () -> DecorativeBlock.with(BaseBlockProperty.SILK).shaped(DecorativeBlock.HALF_14).directional().diagonallyPlaceable().noCollision().build());

    // ROOM DECO

    public static final RegistryObject<Block> BACK_CUSHION = BLOCKS.register("back_cushion",
            () -> DecorativeBlock.with(BaseBlockProperty.SILK).shaped(DecorativeBlock.FULL_BLOCK).directional().noCollision().noOcclusion().noFenceConnect().build());
    public static final RegistryObject<Block> CHESSBOARD = BLOCKS.register("chessboard",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FLAT_16).directional().diagonallyPlaceable().noCollision().noOcclusion().build());
    public static final RegistryObject<Block> BLUE_AND_WHITE_PORCELAIN_VASE = BLOCKS.register("blue_and_white_porcelain_vase",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.VASE).diagonallyPlaceable().build());
    public static final RegistryObject<Block> LARGE_BLUE_AND_WHITE_PORCELAIN_VASE = BLOCKS.register("large_blue_and_white_porcelain_vase",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_14).directional().build());
    public static final RegistryObject<Block> SHORT_BLUE_AND_WHITE_PORCELAIN_POT = BLOCKS.register("short_blue_and_white_porcelain_pot",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.HALF_12).build());
    public static final RegistryObject<Block> TALL_BLUE_AND_WHITE_PORCELAIN_POT = BLOCKS.register("tall_blue_and_white_porcelain_pot",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_6).directional().diagonallyPlaceable().build());
    public static final RegistryObject<Block> BLUE_AND_WHITE_PORCELAIN_BOWL = BLOCKS.register("blue_and_white_porcelain_bowl",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.HALF_12).diagonallyPlaceable().build());
    public static final RegistryObject<Block> BRONZE_MIRROR = BLOCKS.register("bronze_mirror",
            () -> DecorativeBlock.with(BaseBlockProperty.BRONZE).shaped(DecorativeBlock.FULL_14).directional().build());
    public static final RegistryObject<Block> MEMORIAL_TABLET = BLOCKS.register("memorial_tablet",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_14).directional().diagonallyPlaceable().noCollision().noFenceConnect().build());
    public static final RegistryObject<Block> BRONZE_CENSER = BLOCKS.register("bronze_censer",
            () -> new Censer(DecorativeBlock.with(BaseBlockProperty.BRONZE).shaped(DecorativeBlock.HALF_12).directional().diagonallyPlaceable().luminous(), new Vec3(0.5, 0.7, 0.5)));
    public static final RegistryObject<Block> ROYAL_CENSER = BLOCKS.register("royal_censer",
            () -> new Censer(DecorativeBlock.with(BaseBlockProperty.BRONZE).shaped(DecorativeBlock.FULL_10).directional().luminous(), new Vec3(0.5, 0.5, 0.5)));
    public static final RegistryObject<Block> PORCELAIN_TEAPOT = BLOCKS.register("porcelain_teapot",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.HALF_12).directional().build());
    public static final RegistryObject<Block> BOOTS = BLOCKS.register("boots",
            () -> DecorativeBlock.with(BaseBlockProperty.SILK).shaped(DecorativeBlock.FULL_14).directional().build());
    public static final RegistryObject<Block> JADE_PENDANT = BLOCKS.register("jade_pendant",
            () -> DecorativeBlock.with(BaseBlockProperty.JADE).shaped(DecorativeBlock.FULL_6).directional().diagonallyPlaceable().build());
    public static final RegistryObject<Block> IMPERIAL_JADE_SEAL = BLOCKS.register("imperial_jade_seal",
            () -> DecorativeBlock.with(BaseBlockProperty.JADE).shaped(DecorativeBlock.FULL_6).directional().build());
    public static final RegistryObject<Block> LONG_PILLOW = BLOCKS.register("long_pillow",
            () -> DecorativeBlock.with(BaseBlockProperty.SILK).shaped(DecorativeBlock.QUARTER_12).directional().diagonallyPlaceable().build());

    // MISC OBJECTS

    public static final RegistryObject<Block> RED_SILK_FABRIC_ROLL = BLOCKS.register("red_silk_fabric_roll",
            () -> DecorativeBlock.with(BaseBlockProperty.SILK).shaped(DecorativeBlock.QUARTER_12).directional().diagonallyPlaceable().build());
    public static final RegistryObject<Block> GREEN_SILK_FABRIC_ROLL = BLOCKS.register("green_silk_fabric_roll",
            () -> DecorativeBlock.with(BaseBlockProperty.SILK).shaped(DecorativeBlock.QUARTER_12).directional().diagonallyPlaceable().build());
    public static final RegistryObject<Block> PURPLE_SILK_FABRIC_ROLL = BLOCKS.register("purple_silk_fabric_roll",
            () -> DecorativeBlock.with(BaseBlockProperty.SILK).shaped(DecorativeBlock.QUARTER_12).directional().diagonallyPlaceable().build());
    public static final RegistryObject<Block> CLAY_DOLL_MALE = BLOCKS.register("clay_doll_male",
            () -> DecorativeBlock.with(BaseBlockProperty.TERRACOTTA).shaped(DecorativeBlock.FULL_10).directional().diagonallyPlaceable().noCollision().build());
    public static final RegistryObject<Block> CLAY_DOLL_FEMALE = BLOCKS.register("clay_doll_female",
            () -> DecorativeBlock.with(BaseBlockProperty.TERRACOTTA).shaped(DecorativeBlock.FULL_10).directional().diagonallyPlaceable().noCollision().build());
    public static final RegistryObject<Block> BOTTLE_GOURD = BLOCKS.register("bottle_gourd",
            () -> new BottleGourd(DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(BottleGourd.GOURD).directional().diagonallyPlaceable()));

    // FLOWER POTS

    public static final RegistryObject<Block> BLUE_AND_WHITE_PORCELAIN_FLOWERPOT = BLOCKS.register("blue_and_white_porcelain_flowerpot",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_6).diagonallyPlaceable().build());
    public static final RegistryObject<Block> TERRACOTTA_FLOWERPOT = BLOCKS.register("terracotta_flowerpot",
            () -> DecorativeBlock.with(BaseBlockProperty.TERRACOTTA).shaped(DecorativeBlock.VASE).diagonallyPlaceable().build());
    public static final RegistryObject<Block> BLACK_IRON_FLOWERPOT = BLOCKS.register("black_iron_flowerpot",
            () -> DecorativeBlock.with(BaseBlockProperty.IRON).shaped(DecorativeBlock.VASE).directional().build());
    public static final RegistryObject<Block> BLUE_PORCELAIN_FLOWERPOT = BLOCKS.register("blue_porcelain_flowerpot",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_14).directional().build());

    // COURTYARD

    public static final RegistryObject<Block> SACK = BLOCKS.register("sack",
            () -> ContainerDecorativeBlock.with(BaseBlockProperty.SILK).content(ContainerType.COMMON_SMALL).shaped(DecorativeBlock.HALF_6).directional().noCollision().build());
    public static final RegistryObject<Block> BAMBOO_TEA_BASKET = BLOCKS.register("bamboo_tea_basket",
            () -> ContainerDecorativeBlock.with(BaseBlockProperty.BAMBOO_WOOD).content(ContainerType.FOOD_REGULAR).shaped(DecorativeBlock.FULL_14).directional().diagonallyPlaceable().build());
    public static final RegistryObject<Block> EMPTY_BAMBOO_TEA_BASKET = BLOCKS.register("empty_bamboo_tea_basket",
            () -> ContainerDecorativeBlock.with(BaseBlockProperty.BAMBOO_WOOD).content(ContainerType.FOOD_REGULAR).shaped(DecorativeBlock.FULL_14).directional().diagonallyPlaceable().build());
    public static final RegistryObject<Block> STRAW_HAT = BLOCKS.register("straw_hat",
            () -> DecorativeBlock.with(BaseBlockProperty.FLAX).shaped(DecorativeBlock.QUARTER_16).diagonallyPlaceable().noCollision().noOcclusion().build());
    public static final RegistryObject<Block> KNIFE = BLOCKS.register("knife",
            () -> DecorativeBlock.with(BaseBlockProperty.IRON).shaped(DecorativeBlock.FLAT_16).directional().diagonallyPlaceable().noCollision().noOcclusion().build());
    public static final RegistryObject<Block> SUNDIAL = BLOCKS.register("sundial",
            () -> DecorativeBlock.with(BaseBlockProperty.STONE).shaped(DecorativeBlock.FULL_14).directional().build());
    public static final RegistryObject<Block> BROOM = BLOCKS.register("broom",
            () -> DecorativeBlock.with(BaseBlockProperty.STONE).shaped(DecorativeBlock.FULL_8).directional().build());
    public static final RegistryObject<Block> STONE_PEDESTAL = BLOCKS.register("stone_pedestal",
            () -> DecorativeBlock.with(BaseBlockProperty.STONE).shaped(DecorativeBlock.HALF_BLOCK).diagonallyPlaceable().noOcclusion().build());
    public static final RegistryObject<Block> TERRACOTTA_POT = BLOCKS.register("terracotta_pot",
            () -> DecorativeBlock.with(BaseBlockProperty.TERRACOTTA).shaped(DecorativeBlock.FULL_14).directional().build());
    public static final RegistryObject<Block> CHINESE_HERBS_BAG = BLOCKS.register("chinese_herbs_bag",
            () -> DecorativeBlock.with(BaseBlockProperty.SILK).shaped(DecorativeBlock.HALF_BLOCK).directional().build());
    public static final RegistryObject<Block> FRUIT_BOX = BLOCKS.register("fruit_box",
            () -> ContainerDecorativeBlock.with(BaseBlockProperty.WOOD).content(ContainerType.FOOD_REGULAR).shaped(DecorativeBlock.FULL_14).directional().diagonallyPlaceable().build());
    public static final RegistryObject<Block> WOODEN_CRATE = BLOCKS.register("wooden_crate",
            () -> ContainerDecorativeBlock.with(BaseBlockProperty.WOOD).content(ContainerType.COMMON_REGULAR).shaped(DecorativeBlock.FULL_BLOCK).build());
    public static final RegistryObject<Block> GUNNY_SACK = BLOCKS.register("gunny_sack",
            () -> ContainerDecorativeBlock.with(BaseBlockProperty.FLAX).content(ContainerType.COMMON_REGULAR).shaped(DecorativeBlock.FULL_14).directional().build());
    public static final RegistryObject<Block> BRONZE_DING = BLOCKS.register("bronze_ding",
            () -> DecorativeBlock.with(BaseBlockProperty.BRONZE).shaped(DecorativeBlock.FULL_BLOCK).placeOffset(Direction.UP).directional().noOcclusion().build());
    public static final RegistryObject<Block> CARRIAGE = BLOCKS.register("carriage",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_BLOCK).directional().noOcclusion().build());
    public static final RegistryObject<Block> WOODEN_POLES = BLOCKS.register("wooden_poles",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_BLOCK).directional().noOcclusion().build());
    public static final RegistryObject<Block> TEAHOUSE_FLAG = BLOCKS.register("teahouse_flag",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_6).placeOffset(Direction.UP).directional().noOcclusion().build());
    public static final RegistryObject<Block> KNIFE_REST = BLOCKS.register("knife_rest",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_BLOCK).directional().noOcclusion().build());

    // WALL HANGING

    public static final RegistryObject<Block> LONG_HANGING_PAINTING = BLOCKS.register("long_hanging_painting",
            () -> new WallSideBlock(BaseBlockProperty.PAPER));
    public static final RegistryObject<Block> WHITE_LANDSCAPE_PAINTING = BLOCKS.register("white_landscape_painting",
            () -> new WallSideBlock(BaseBlockProperty.PAPER));
    public static final RegistryObject<Block> HORIZONTAL_OLD_LANDSCAPE_PAINTING = BLOCKS.register("horizontal_old_landscape_painting",
            () -> new WallSideBlock(BaseBlockProperty.PAPER));
    public static final RegistryObject<Block> HORIZONTAL_CALLIGRAPHY = BLOCKS.register("horizontal_calligraphy",
            () -> new WallSideBlock(BaseBlockProperty.PAPER));
    public static final RegistryObject<Block> HORIZONTAL_LANDSCAPE_PAINTING = BLOCKS.register("horizontal_landscape_painting",
            () -> new WallSideBlock(BaseBlockProperty.PAPER));
    public static final RegistryObject<Block> LONG_YELLOW_HANGING_PAINTING = BLOCKS.register("long_yellow_hanging_painting",
            () -> new WallSideBlock(BaseBlockProperty.PAPER));
    public static final RegistryObject<Block> DAMAGED_LANDSCAPE_PAINTING = BLOCKS.register("damaged_landscape_painting",
            () -> new WallSideBlock(BaseBlockProperty.PAPER));
    public static final RegistryObject<Block> PORTRAIT = BLOCKS.register("portrait",
            () -> new WallSideBlock(BaseBlockProperty.PAPER));
    public static final RegistryObject<Block> HANGING_PAINTING_FAN = BLOCKS.register("hanging_painting_fan",
            () -> new WallSideBlock(BaseBlockProperty.PAPER));
    public static final RegistryObject<Block> SINCERE_CALLIGRAPHY = BLOCKS.register("sincere_calligraphy",
            () -> new WallSideBlock(BaseBlockProperty.PAPER));

    // FOOD

    public static final RegistryObject<Block> FOOD_HAMPER = BLOCKS.register("food_hamper",
            () -> ContainerDecorativeBlock.with(BaseBlockProperty.WOOD).content(ContainerType.FOOD_LARGE).shaped(DecorativeBlock.FULL_6).directional().diagonallyPlaceable().build());
    public static final RegistryObject<Block> PLATED_MOONCAKES = BLOCKS.register("plated_mooncakes", //todo change stone slab plate to actual block
            () -> ConsumableDecorativeBlock.with(BaseBlockProperty.PORCELAIN).bites(4).platedWith(Blocks.STONE_SLAB).food(ModFoods.MOONCAKE).shaped(DecorativeBlock.FLAT_16).directional().build());
    public static final RegistryObject<Block> PLATED_MUNG_BEAN_CAKES = BLOCKS.register("plated_mung_bean_cakes",
            () -> ConsumableDecorativeBlock.with(BaseBlockProperty.GLAZED).bites(7).platedWith(Blocks.STONE_SLAB).food(ModFoods.MUNG_BEAN_CAKE).shaped(DecorativeBlock.FLAT_16).directional().noOcclusion().build());
    public static final RegistryObject<Block> PLATED_HAM = BLOCKS.register("plated_ham",
            () -> ConsumableDecorativeBlock.with(BaseBlockProperty.WOOD).bites(4).platedWith(ItemRegistry.POLISHED_OAK_PLANK).food(ModFoods.COOKED_MEAT).shaped(DecorativeBlock.FLAT_16).directional().noOcclusion().build());
    public static final RegistryObject<Block> PLATED_FISH = BLOCKS.register("plated_fish",
            () -> ConsumableDecorativeBlock.with(BaseBlockProperty.WOOD).bites(3).platedWith(ItemRegistry.POLISHED_OAK_PLANK).food(ModFoods.FISH).shaped(DecorativeBlock.FLAT_16).directional().noOcclusion().build());
    public static final RegistryObject<Block> SCATTERED_CARROTS = BLOCKS.register("scattered_carrots",
            () -> ConsumableDecorativeBlock.with(BaseBlockProperty.CROP).bites(2).platedWith(ItemRegistry.POLISHED_OAK_PLANK).food(Foods.CARROT)
                    .whenFinished((pState, pLevel, pPos, pPlayer) -> {pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL); pLevel.gameEvent(pPlayer, GameEvent.BLOCK_DESTROY, pPos);})
                    .shaped(DecorativeBlock.QUARTER_16).directional().noOcclusion().build());
    public static final RegistryObject<Block> WINE_POT = BLOCKS.register("wine_pot",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_6).directional().build());
    public static final RegistryObject<Block> XIAOLONGBAO = BLOCKS.register("xiaolongbao", //TODO xiaolongbao 8 bites in one block, return 2 containers
            () -> ConsumableDecorativeBlock.with(BaseBlockProperty.BAMBOO).bites(8).platedWith(ItemRegistry.POLISHED_OAK_PLANK).food(ModFoods.BAOZI)
                    .whenFinished((pState, pLevel, pPos, pPlayer) -> {pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL); pLevel.gameEvent(pPlayer, GameEvent.BLOCK_DESTROY, pPos);})
                    .shaped(DecorativeBlock.FULL_BLOCK).noOcclusion().directional().build());

    // ICE

    public static final RegistryObject<Block> ICICLE = BLOCKS.register("icicle", () -> new Icicle(3));
    public static final RegistryObject<Block> LARGE_ICICLE = BLOCKS.register("large_icicle", () -> new Icicle(2));

    // CELEBRATION

    public static final RegistryObject<Block> COUPLET = BLOCKS.register("couplet", () -> new OrientableWallSideBlock(BaseBlockProperty.PAPER));
    public static final RegistryObject<Block> COUPLET_TOP = BLOCKS.register("couplet_top", () -> new WallSideBlock(BaseBlockProperty.PAPER));
    public static final RegistryObject<Block> FU_MARK = BLOCKS.register("fu_mark", () -> new WallSideBlock(BaseBlockProperty.PAPER));

    /**
     *  FURNITURE
     */

    // CABINET

    public static final RegistryObject<Block> OAK_CABINET = BLOCKS.register("oak_cabinet",
            () -> ContainerDecorativeBlock.with(BaseBlockProperty.WOOD).content(ContainerType.COMMON_REGULAR).shaped(DecorativeBlock.FULL_BLOCK).directional().noFenceConnect().build());
    public static final RegistryObject<Block> WARPED_CABINET = BLOCKS.register("warped_cabinet",
            () -> ContainerDecorativeBlock.with(BaseBlockProperty.WOOD).content(ContainerType.COMMON_REGULAR).shaped(DecorativeBlock.FULL_BLOCK).directional().noFenceConnect().build());
    public static final RegistryObject<Block> EBONY_CABINET = BLOCKS.register("ebony_cabinet",
            () -> ContainerDecorativeBlock.with(BaseBlockProperty.WOOD).content(ContainerType.COMMON_LARGE).shaped(DecorativeBlock.FULL_BLOCK).directional().noFenceConnect().build());

    // TABLE

    public static final RegistryObject<Block> LARGE_TEA_TABLE = BLOCKS.register("large_tea_table",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.HALF_BLOCK).directional().build());
    public static final RegistryObject<Block> CHESS_TABLE = BLOCKS.register("chess_table",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.QUARTER_16).directional().diagonallyPlaceable().build());
    public static final RegistryObject<Block> HIGH_TABLE_WITH_WHITE_TOP = BLOCKS.register("high_table_with_white_top",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_14).directional().build());
    public static final RegistryObject<Block> CENSER_TABLE = BLOCKS.register("censer_table",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_14).directional().diagonallyPlaceable().build());
    public static final RegistryObject<Block> PORCELAIN_INLAID_TABLE = BLOCKS.register("porcelain_inlaid_table",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_BLOCK).directional().noFenceConnect().build());
    public static final RegistryObject<Block> SMALL_TABLE = BLOCKS.register("small_table",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_14).directional().diagonallyPlaceable().build());
    public static final RegistryObject<Block> SMALL_EBONY_TABLE = BLOCKS.register("small_ebony_table",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_14).directional().build());
    public static final RegistryObject<Block> LARGE_TABLE = BLOCKS.register("large_table",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_BLOCK).directional().build());

    // CHAIR

    public static final RegistryObject<Block> EBONY_CHAIR = BLOCKS.register("ebony_chair",
            () -> SeatDecorativeBlock.with(BaseBlockProperty.WOOD).seatOffset(new Vec3(0.0f, -0.1f, 0.0f)).shaped(DecorativeBlock.HALF_12).directional().diagonallyPlaceable().build());
    public static final RegistryObject<Block> CHAIR_WITH_YELLOW_CUSHION = BLOCKS.register("chair_with_yellow_cushion",
            () -> SeatDecorativeBlock.with(BaseBlockProperty.WOOD).seatOffset(new Vec3(0.0f, -0.1f, 0.0f)).shaped(DecorativeBlock.HALF_BLOCK).directional().build());
    public static final RegistryObject<Block> PAINTED_CHAIR = BLOCKS.register("painted_chair",
            () -> SeatDecorativeBlock.with(BaseBlockProperty.WOOD).seatOffset(new Vec3(0.0f, -0.1f, 0.0f)).shaped(DecorativeBlock.HALF_BLOCK).directional().build());
    public static final RegistryObject<Block> WOODEN_STOOL = BLOCKS.register("wooden_stool",
            () -> SeatDecorativeBlock.with(BaseBlockProperty.WOOD).seatOffset(new Vec3(0.0f, -0.1f, 0.0f)).shaped(DecorativeBlock.HALF_12).directional().build());
    public static final RegistryObject<Block> PORCELAIN_INLAID_GRAND_CHAIR = BLOCKS.register("porcelain_inlaid_grand_chair",
            () -> SeatDecorativeBlock.with(BaseBlockProperty.WOOD).seatOffset(new Vec3(0.0f, -0.1f, 0.0f)).shaped(DecorativeBlock.HALF_14).directional().build());
    public static final RegistryObject<Block> YELLOW_CUSHION = BLOCKS.register("yellow_cushion",
            () -> SeatDecorativeBlock.with(BaseBlockProperty.SILK).seatOffset(new Vec3(0.0f, -0.5f, 0.0f)).shaped(DecorativeBlock.QUARTER_12).directional().diagonallyPlaceable().build());
    public static final RegistryObject<Block> OAK_BED = BLOCKS.register("oak_bed",
            () -> SeatDecorativeBlock.with(BaseBlockProperty.WOOD).seatOffset(new Vec3(0.0f, -0.1f, 0.0f)).shaped(DecorativeBlock.HALF_BLOCK).directional().build());

    // SCREEN

    public static final RegistryObject<Block> LARGE_LANDSCAPE_PAINTING_SCREEN = BLOCKS.register("large_landscape_painting_screen",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(OpeningBlock.MIDDLE_AXIAL).placeOffset(Direction.UP).directional().build());
    public static final RegistryObject<Block> PAINTED_SCREEN = BLOCKS.register("painted_screen",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(OpeningBlock.MIDDLE_AXIAL).placeOffset(Direction.UP).directional().build());

    /**
     *  DOOR AND WINDOW
     */

    // DOOR

    public static final RegistryObject<Block> CARVED_WOODEN_DOOR = BLOCKS.register("carved_wooden_door",
            () -> new OpeningBlock(DecorativeBlock.with(BaseBlockProperty.WOOD).directional().noOcclusion()));
    public static final RegistryObject<Block> SONG_WOODEN_DOOR = BLOCKS.register("song_wooden_door",
            () -> new OpeningBlock(DecorativeBlock.with(BaseBlockProperty.WOOD).directional().noOcclusion()));

    // WINDOW

    public static final RegistryObject<Block> SONG_WOODEN_WINDOW = BLOCKS.register("song_wooden_window",
            () -> new OpeningBlock(DecorativeBlock.with(BaseBlockProperty.WOOD).directional().noOcclusion()));
    public static final RegistryObject<Block> ROYAL_ROSEWOOD_WINDOW = BLOCKS.register("royal_rosewood_window",
            () -> new OpeningBlock(DecorativeBlock.with(BaseBlockProperty.WOOD).directional().noOcclusion()));
    public static final RegistryObject<Block> TALL_ROYAL_ROSEWOOD_WINDOW = BLOCKS.register("tall_royal_rosewood_window",
            () -> new OpeningBlock(DecorativeBlock.with(BaseBlockProperty.WOOD).directional().noOcclusion()));
    public static final RegistryObject<Block> GLAZED_TILE_GRID_WINDOW = BLOCKS.register("glazed_tile_grid_window",
            () -> new DecorativeBlock(DecorativeBlock.with(BaseBlockProperty.GLAZED).shaped(DecorativeBlock.FULL_BLOCK).directional().noOcclusion()));
    public static final RegistryObject<Block> STONE_FLOWER_WINDOW = BLOCKS.register("stone_flower_window", () -> new BaseBlock(BaseBlockProperty.IRON));

    // DOOR DECO

    public static final RegistryObject<Block> KNOCKER = BLOCKS.register("knocker",
            () -> new WallSideBlock(BaseBlockProperty.COPPER));
    public static final RegistryObject<Block> ROSEWOOD_PANEL = BLOCKS.register("rosewood_panel",
            () -> new SixSideBlock(BaseBlockProperty.WOOD, 3));
    public static final RegistryObject<Block> ROSEWOOD_DOOR_PANEL = BLOCKS.register("rosewood_door_panel",
            () -> new SixSideBlock(BaseBlockProperty.WOOD, 3));
    public static final RegistryObject<Block> LARGE_ROSEWOOD_PANEL = BLOCKS.register("large_rosewood_panel",
            () -> new OrientableSixSideBlock(BaseBlockProperty.WOOD, 3));
    public static final RegistryObject<Block> LARGE_ROSEWOOD_PANEL_EDGE = BLOCKS.register("large_rosewood_panel_edge",
            () -> new OrientableSixSideBlock(BaseBlockProperty.WOOD, 3));
    public static final RegistryObject<Block> CARVED_WOODEN_DOOR_PANEL = BLOCKS.register("carved_wooden_door_panel",
            () -> new OpeningBlock(DecorativeBlock.with(BaseBlockProperty.WOOD).directional().noOcclusion()));
    public static final RegistryObject<Block> PLAQUE = BLOCKS.register("plaque",
            () -> new DecorativeBlock(DecorativeBlock.with(BaseBlockProperty.WOOD).directional().noOcclusion()));
    public static final RegistryObject<Block> PAPER_STRIP_SEAL = BLOCKS.register("paper_strip_seal",
            () -> new WallSideBlock(BaseBlockProperty.PAPER));

    // WINDOW DECO

    public static final RegistryObject<Block> LARGE_BLUE_CURTAIN = BLOCKS.register("large_blue_curtain",
            () -> new WallSideBlock(BaseBlockProperty.SILK));
    public static final RegistryObject<Block> MEDIUM_BLUE_CURTAIN = BLOCKS.register("medium_blue_curtain",
            () -> new WallSideBlock(BaseBlockProperty.SILK));
    public static final RegistryObject<Block> SMALL_BLUE_CURTAIN = BLOCKS.register("small_blue_curtain",
            () -> new WallSideBlock(BaseBlockProperty.SILK));
    public static final RegistryObject<Block> RED_CURTAIN = BLOCKS.register("red_curtain",
            () -> new OrientableWallSideBlock(BaseBlockProperty.SILK));
    public static final RegistryObject<Block> RED_CURTAIN_CORNER = BLOCKS.register("red_curtain_corner",
            () -> new OrientableWallSideBlock(BaseBlockProperty.SILK));
    public static final RegistryObject<Block> BAMBOO_CURTAIN = BLOCKS.register("bamboo_curtain",
            () -> new DecorativeBlock(DecorativeBlock.with(BaseBlockProperty.BAMBOO_WOOD).shaped(OpeningBlock.MIDDLE_AXIAL).directional().noOcclusion()));

    /**
     *  PLANTS
     */

    // LOTUS


    public static final RegistryObject<Block> SMALL_LOTUS_LEAF = BLOCKS.register("small_lotus_leaf",
            () -> new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.LILY).shaped(DecorativeBlock.FLAT_16).directional().diagonallyPlaceable().noCollision().noOcclusion()));
    public static final RegistryObject<Block> SMALL_DARK_GREEN_LOTUS_LEAF = BLOCKS.register("small_dark_green_lotus_leaf",
            () -> new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.LILY).shaped(DecorativeBlock.FLAT_16).directional().diagonallyPlaceable().noCollision().noOcclusion()));
    public static final RegistryObject<Block> MEDIUM_LOTUS_LEAF = BLOCKS.register("medium_lotus_leaf",
            () -> new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.LILY).shaped(DecorativeBlock.FLAT_16).directional().diagonallyPlaceable().noCollision().noOcclusion()));
    public static final RegistryObject<Block> LARGE_LOTUS_LEAF = BLOCKS.register("large_lotus_leaf",
            () -> new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.LILY).shaped(DecorativeBlock.FLAT_16).directional().diagonallyPlaceable().noCollision().noOcclusion()));
    public static final RegistryObject<Block> TILTED_LOTUS_LEAF = BLOCKS.register("tilted_lotus_leaf",
            () -> new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.LILY).shaped(DecorativeBlock.HALF_BLOCK).directional().noCollision().noOcclusion()));
    public static final RegistryObject<Block> SMALL_LOTUS_LEAF_CLUSTER = BLOCKS.register("small_lotus_leaf_cluster",
            () -> new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.LILY).shaped(DecorativeBlock.FLAT_16).directional().diagonallyPlaceable().noCollision().noOcclusion()));
    public static final RegistryObject<Block> MEDIUM_LOTUS_LEAF_CLUSTER = BLOCKS.register("medium_lotus_leaf_cluster",
            () -> new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.LILY).shaped(DecorativeBlock.FLAT_16).directional().diagonallyPlaceable().noCollision().noOcclusion()));
    public static final RegistryObject<Block> LOTUS_BUD = BLOCKS.register("lotus_bud",
            () -> new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.LILY).shaped(DecorativeBlock.FULL_8).directional().noCollision().noOcclusion()));
    public static final RegistryObject<Block> MEDIUM_LOTUS = BLOCKS.register("medium_lotus",
            () -> new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.LILY).shaped(DecorativeBlock.FULL_BLOCK).directional().noCollision().noOcclusion()));

    // IVY

    public static final RegistryObject<Block> SMALL_RED_IVY = BLOCKS.register("small_red_ivy",
            () -> new WallSideBlock(BaseBlockProperty.PLANT));
    public static final RegistryObject<Block> MEDIUM_RED_IVY = BLOCKS.register("medium_red_ivy",
            () -> new WallSideBlock(BaseBlockProperty.PLANT));
    public static final RegistryObject<Block> LARGE_RED_IVY = BLOCKS.register("large_red_ivy",
            () -> new WallSideBlock(BaseBlockProperty.PLANT));
    public static final RegistryObject<Block> SMALL_YELLOW_IVY = BLOCKS.register("small_yellow_ivy",
            () -> new WallSideBlock(BaseBlockProperty.PLANT));
    public static final RegistryObject<Block> MEDIUM_YELLOW_IVY = BLOCKS.register("medium_yellow_ivy",
            () -> new WallSideBlock(BaseBlockProperty.PLANT));
    public static final RegistryObject<Block> LARGE_YELLOW_IVY = BLOCKS.register("large_yellow_ivy",
            () -> new WallSideBlock(BaseBlockProperty.PLANT));
    public static final RegistryObject<Block> SMALL_GREEN_IVY = BLOCKS.register("small_green_ivy",
            () -> new WallSideBlock(BaseBlockProperty.PLANT));
    public static final RegistryObject<Block> MEDIUM_GREEN_IVY = BLOCKS.register("medium_green_ivy",
            () -> new WallSideBlock(BaseBlockProperty.PLANT));
    public static final RegistryObject<Block> LARGE_GREEN_IVY = BLOCKS.register("large_green_ivy",
            () -> new WallSideBlock(BaseBlockProperty.PLANT));

    // LEAVES

    public static final RegistryObject<Block> SMALL_LEAF_PILE = BLOCKS.register("small_leaf_pile",
            () -> DecorativeBlock.with(BaseBlockProperty.PLANT).shaped(DecorativeBlock.FLAT_16).directional().noCollision().noOcclusion().build());
    public static final RegistryObject<Block> MEDIUM_LEAF_PILE = BLOCKS.register("medium_leaf_pile",
            () -> DecorativeBlock.with(BaseBlockProperty.PLANT).shaped(DecorativeBlock.FLAT_16).directional().noCollision().noOcclusion().build());
    public static final RegistryObject<Block> LARGE_LEAF_PILE = BLOCKS.register("large_leaf_pile",
            () -> DecorativeBlock.with(BaseBlockProperty.PLANT).shaped(DecorativeBlock.FLAT_16).directional().noCollision().noOcclusion().build());

    // BONSAI

    public static final RegistryObject<Block> SMALL_GREETING_PINE_BONSAI = BLOCKS.register("small_greeting_pine_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_12).directional().noCollision().build());
    public static final RegistryObject<Block> MEDIUM_GREETING_PINE_BONSAI = BLOCKS.register("medium_greeting_pine_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_14).directional().noCollision().noOcclusion().build());
    public static final RegistryObject<Block> LARGE_GREETING_PINE_BONSAI = BLOCKS.register("large_greeting_pine_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_14).directional().placeOffset(Direction.UP).noCollision().noOcclusion().build());
    public static final RegistryObject<Block> SMALL_WHITE_PORCELAIN_VASE_BONSAI = BLOCKS.register("small_white_porcelain_vase_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_10).directional().diagonallyPlaceable().noCollision().build());
    public static final RegistryObject<Block> MEDIUM_WHITE_PORCELAIN_VASE_BONSAI = BLOCKS.register("medium_white_porcelain_vase_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_14).directional().diagonallyPlaceable().noCollision().build());
    public static final RegistryObject<Block> LARGE_WHITE_PORCELAIN_VASE_BONSAI = BLOCKS.register("large_white_porcelain_vase_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_14).directional().diagonallyPlaceable().noCollision().noOcclusion().build());
    public static final RegistryObject<Block> SMALL_GREEN_PORCELAIN_VASE_BONSAI = BLOCKS.register("small_green_porcelain_vase_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_10).directional().noCollision().build());
    public static final RegistryObject<Block> GREEN_PORCELAIN_VASE_BONSAI = BLOCKS.register("green_porcelain_vase_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_10).directional().diagonallyPlaceable().noCollision().build());
    public static final RegistryObject<Block> RED_CORAL_BONSAI = BLOCKS.register("red_coral_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_14).directional().noCollision().build());
    public static final RegistryObject<Block> RED_PLUM_BONSAI = BLOCKS.register("red_plum_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_12).directional().noCollision().build());
    public static final RegistryObject<Block> BAMBOO_BONSAI = BLOCKS.register("bamboo_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_14).directional().noCollision().noOcclusion().build());
    public static final RegistryObject<Block> TALL_BLUE_VASE_BONSAI = BLOCKS.register("tall_blue_vase_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_12).directional().diagonallyPlaceable().placeOffset(Direction.UP).noCollision().build());
    public static final RegistryObject<Block> TALL_BLUE_AND_WHITE_PORCELAIN_BONSAI = BLOCKS.register("tall_blue_and_white_porcelain_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.FULL_10).directional().diagonallyPlaceable().noCollision().noOcclusion().build());
    public static final RegistryObject<Block> MEDIUM_BONSAI = BLOCKS.register("medium_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.TERRACOTTA).shaped(DecorativeBlock.FULL_12).directional().diagonallyPlaceable().noCollision().noOcclusion().build());
    public static final RegistryObject<Block> LARGE_BONSAI = BLOCKS.register("large_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.TERRACOTTA).shaped(DecorativeBlock.FULL_14).directional().diagonallyPlaceable().noCollision().noOcclusion().build());

    /**
     *  LAMPS
     */

    //LANTERN

    public static final RegistryObject<Block> OCTAGONAL_PALACE_LANTERN = BLOCKS.register("octagonal_palace_lantern",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_BLOCK).luminous().noOcclusion().placeOffset(Direction.DOWN).build());
    public static final RegistryObject<Block> SQUARE_PALACE_LANTERN = BLOCKS.register("square_palace_lantern",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_BLOCK).diagonallyPlaceable().luminous().noOcclusion().build());
    public static final RegistryObject<Block> SMALL_RED_LANTERN = BLOCKS.register("small_red_lantern",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_BLOCK).diagonallyPlaceable().luminous().build());
    public static final RegistryObject<Block> WHITE_SKY_LANTERN = BLOCKS.register("white_sky_lantern",
            () -> DecorativeBlock.with(BaseBlockProperty.BAMBOO).luminous().build());
    public static final RegistryObject<Block> RED_SKY_LANTERN = BLOCKS.register("red_sky_lantern",
            () -> DecorativeBlock.with(BaseBlockProperty.BAMBOO).luminous().build());
    public static final RegistryObject<Block> YELLOW_SKY_LANTERN = BLOCKS.register("yellow_sky_lantern",
            () -> DecorativeBlock.with(BaseBlockProperty.BAMBOO).luminous().build());

    // LAMP

    public static final RegistryObject<Block> STANDING_LAMP = BLOCKS.register("standing_lamp",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_6).diagonallyPlaceable().luminous().noOcclusion().build());
    public static final RegistryObject<Block> SMALL_STANDING_LAMP = BLOCKS.register("small_standing_lamp",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_6).diagonallyPlaceable().luminous().build());
    public static final RegistryObject<Block> STONE_LAMP = BLOCKS.register("stone_lamp",
            () -> DecorativeBlock.with(BaseBlockProperty.STONE).luminous().build());

    // STREETLIGHT

    public static final RegistryObject<Block> RED_LANTERN_STREETLIGHT = BLOCKS.register("red_lantern_streetlight",
            () -> new HangingLantern(HangingLantern.HangingLanternType.POLE));
    public static final RegistryObject<Block> HANGING_RED_LANTERN_STREETLIGHT = BLOCKS.register("hanging_red_lantern_streetlight",
            () -> new HangingLantern(HangingLantern.HangingLanternType.HANGING));
    public static final RegistryObject<Block> STREETLIGHT_POLE = BLOCKS.register("streetlight_pole",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(HangingLantern.POLE_ONLY).directional().noOcclusion().build());

    // CANDLESTICK

    public static final RegistryObject<Block> RED_CANDLE = BLOCKS.register("red_candle",
            () -> new CandleStick(DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_4).directional().diagonallyPlaceable().luminous(), new Vec3(0.5,1.1,0.5)));
    public static final RegistryObject<Block> TRICOLOR_CANDLESTICK = BLOCKS.register("tricolor_candlestick",
            () -> new CandleStick(DecorativeBlock.with(BaseBlockProperty.IRON).shaped(DecorativeBlock.FULL_10).directional().diagonallyPlaceable().luminous(), new Vec3(0.5,1.25,0.5)));
    public static final RegistryObject<Block> JADE_CANDLESTICK = BLOCKS.register("jade_candlestick",
            () -> new CandleStick(DecorativeBlock.with(BaseBlockProperty.JADE).shaped(DecorativeBlock.FULL_6).directional().diagonallyPlaceable().luminous(), new Vec3(0.5,1.3,0.5)));

    /**
     *  MATERIALS
     */

    public static final RegistryObject<Block> JADE_ORE = BLOCKS.register("jade_ore", () -> new BaseOreBlock(2, 5));
    public static final RegistryObject<Block> DEEPSLATE_JADE_ORE = BLOCKS.register("deepslate_jade_ore", () -> new BaseOreBlock(2, 5));
    public static final RegistryObject<Block> MAGNESITE_ORE = BLOCKS.register("magnesite_ore", () -> new BaseOreBlock(2, 5));
    public static final RegistryObject<Block> DEEPSLATE_MAGNESITE_ORE = BLOCKS.register("deepslate_magnesite_ore", () -> new BaseOreBlock(2, 5));
    public static final RegistryObject<Block> HEMATITE_ORE = BLOCKS.register("hematite_ore", () -> new BaseOreBlock(1, 3));
    public static final RegistryObject<Block> DEEPSLATE_HEMATITE_ORE = BLOCKS.register("deepslate_hematite_ore", () -> new BaseOreBlock(1, 3));
    public static final RegistryObject<Block> NETHER_COBALT_ORE = BLOCKS.register("nether_cobalt_ore", () -> new BaseOreBlock(2, 5));

    /**
     *  TOOLS
     */

    public static final RegistryObject<Block> WOODWORKING_WORKBENCH = BLOCKS.register("woodworking_workbench", WoodworkingWorkBench::new);
    public static final RegistryObject<Block> BRICK_KILN = BLOCKS.register("brick_kiln", BrickKiln::new);
    public static final RegistryObject<Block> CHISEL_TABLE = BLOCKS.register("chisel_table", ChiselTableMedium::new);

    private static RegistryObject<Block> simpleBlock(String name, Material material) {
        return BLOCKS.register(name, () -> new Block(BlockBehaviour.Properties.of(material)));
    }
}
