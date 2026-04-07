package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.ContainerType;
import com.voxelutopia.ultramarine.data.ModFoods;
import com.voxelutopia.ultramarine.data.shape.BlockShapes;
import com.voxelutopia.ultramarine.data.shape.RawVoxelShape;
import com.voxelutopia.ultramarine.data.shape.ShapeFunction;
import com.voxelutopia.ultramarine.util.RegistryIdContext;
import com.voxelutopia.ultramarine.world.block.*;
import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class BlockRegistry {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Ultramarine.MOD_ID);

    /**
     * BUILDING BLOCKS
     */

    // BRICKS

    public static final DeferredHolder<Block, BaseBlock> CYAN_BRICKS = register("cyan_bricks", () -> new BaseBlock());
    public static final DeferredHolder<Block, Block> CYAN_BRICK_SLAB = register("cyan_brick_slab", () -> new BaseSlab(CYAN_BRICKS.get()));
    public static final DeferredHolder<Block, Block> CYAN_BRICK_STAIRS = register("cyan_brick_stairs", () -> new BaseStairs(CYAN_BRICKS.get()));
    public static final DeferredHolder<Block, Block> CYAN_BRICK_WALL = register("cyan_brick_wall", () -> new BaseWall(CYAN_BRICKS.get()));

    public static final DeferredHolder<Block, BaseBlock> BLACK_BRICKS = register("black_bricks", () -> new BaseBlock());
    public static final DeferredHolder<Block, Block> BLACK_BRICK_SLAB = register("black_brick_slab", () -> new BaseSlab(BLACK_BRICKS.get()));
    public static final DeferredHolder<Block, Block> BLACK_BRICK_STAIRS = register("black_brick_stairs", () -> new BaseStairs(BLACK_BRICKS.get()));
    public static final DeferredHolder<Block, Block> BLACK_BRICK_WALL = register("black_brick_wall", () -> new BaseWall(BLACK_BRICKS.get()));

    public static final DeferredHolder<Block, BaseBlock> BROWNISH_RED_STONE_BRICKS = register("brownish_red_stone_bricks", () -> new BaseBlock());
    public static final DeferredHolder<Block, Block> BROWNISH_RED_STONE_BRICK_SLAB = register("brownish_red_stone_brick_slab", () -> new BaseSlab(BROWNISH_RED_STONE_BRICKS.get()));
    public static final DeferredHolder<Block, Block> BROWNISH_RED_STONE_BRICK_STAIRS = register("brownish_red_stone_brick_stairs", () -> new BaseStairs(BROWNISH_RED_STONE_BRICKS.get()));
    public static final DeferredHolder<Block, Block> BROWNISH_RED_STONE_BRICK_WALL = register("brownish_red_stone_brick_wall", () -> new BaseWall(BROWNISH_RED_STONE_BRICKS.get()));

    public static final DeferredHolder<Block, BaseBlock> WHITE_AND_PINK_MIXED_BRICKS = register("white_and_pink_mixed_bricks", () -> new BaseBlock(BaseBlockProperty.stone()));
    public static final DeferredHolder<Block, Block> WHITE_AND_PINK_MIXED_BRICK_SLAB = register("white_and_pink_mixed_brick_slab", () -> new BaseSlab(WHITE_AND_PINK_MIXED_BRICKS.get()));
    public static final DeferredHolder<Block, Block> WHITE_AND_PINK_MIXED_BRICK_STAIRS = register("white_and_pink_mixed_brick_stairs", () -> new BaseStairs(WHITE_AND_PINK_MIXED_BRICKS.get()));
    public static final DeferredHolder<Block, Block> WHITE_AND_PINK_MIXED_BRICK_WALL = register("white_and_pink_mixed_brick_wall", () -> new BaseWall(WHITE_AND_PINK_MIXED_BRICKS.get()));

    public static final DeferredHolder<Block, BaseBlock> GREEN_WEATHERED_BRICKS = register("green_weathered_bricks", () -> new BaseBlock(BaseBlockProperty.stone()));
    public static final DeferredHolder<Block, Block> GREEN_WEATHERED_BRICK_SLAB = register("green_weathered_brick_slab", () -> new BaseSlab(GREEN_WEATHERED_BRICKS.get()));
    public static final DeferredHolder<Block, Block> GREEN_WEATHERED_BRICK_STAIRS = register("green_weathered_brick_stairs", () -> new BaseStairs(GREEN_WEATHERED_BRICKS.get()));
    public static final DeferredHolder<Block, Block> GREEN_WEATHERED_BRICK_WALL = register("green_weathered_brick_wall", () -> new BaseWall(GREEN_WEATHERED_BRICKS.get()));

    // STONES

    public static final DeferredHolder<Block, BaseBlock> PALE_YELLOW_STONE = register("pale_yellow_stone", () -> new BaseBlock());
    public static final DeferredHolder<Block, Block> PALE_YELLOW_STONE_SLAB = register("pale_yellow_stone_slab", () -> new BaseSlab(PALE_YELLOW_STONE.get()));
    public static final DeferredHolder<Block, Block> PALE_YELLOW_STONE_STAIRS = register("pale_yellow_stone_stairs", () -> new BaseStairs(PALE_YELLOW_STONE.get()));
    public static final DeferredHolder<Block, BaseBlock> VARIEGATED_ROCKS = register("variegated_rocks", () -> new BaseBlock());
    public static final DeferredHolder<Block, Block> VARIEGATED_ROCK_SLAB = register("variegated_rock_slab", () -> new BaseSlab(VARIEGATED_ROCKS.get()));
    public static final DeferredHolder<Block, Block> VARIEGATED_ROCK_STAIRS = register("variegated_rock_stairs", () -> new BaseStairs(VARIEGATED_ROCKS.get()));
    public static final DeferredHolder<Block, BaseBlock> WEATHERED_STONE = register("weathered_stone", () -> new BaseBlock());
    public static final DeferredHolder<Block, Block> WEATHERED_STONE_SLAB = register("weathered_stone_slab", () -> new BaseSlab(WEATHERED_STONE.get()));
    public static final DeferredHolder<Block, Block> WEATHERED_STONE_STAIRS = register("weathered_stone_stairs", () -> new BaseStairs(WEATHERED_STONE.get()));
    public static final DeferredHolder<Block, BaseBlock> POLISHED_WEATHERED_STONE = register("polished_weathered_stone", () -> new BaseBlock());
    public static final DeferredHolder<Block, Block> POLISHED_WEATHERED_STONE_SLAB = register("polished_weathered_stone_slab", () -> new BaseSlab(POLISHED_WEATHERED_STONE.get()));
    public static final DeferredHolder<Block, Block> POLISHED_WEATHERED_STONE_STAIRS = register("polished_weathered_stone_stairs", () -> new BaseStairs(POLISHED_WEATHERED_STONE.get()));
    public static final DeferredHolder<Block, Block> POLISHED_WEATHERED_STONE_WALL = register("polished_weathered_stone_wall", () -> new BaseWall(POLISHED_WEATHERED_STONE.get()));
    public static final DeferredHolder<Block, Block> GREEN_WEATHERED_STONE = register("green_weathered_stone", () -> new BaseBlock(BaseBlockProperty.stone()));

    // FLOOR TILES

    public static final DeferredHolder<Block, BaseBlock> LIGHT_CYAN_FLOOR_TILE = register("light_cyan_floor_tile", () -> new BaseBlock(BaseBlockProperty.tile()));
    public static final DeferredHolder<Block, Block> LIGHT_CYAN_FLOOR_TILE_SLAB = register("light_cyan_floor_tile_slab", () -> new BaseSlab(LIGHT_CYAN_FLOOR_TILE.get()));
    public static final DeferredHolder<Block, Block> LIGHT_CYAN_FLOOR_TILE_STAIRS = register("light_cyan_floor_tile_stairs", () -> new BaseStairs(LIGHT_CYAN_FLOOR_TILE.get()));
    public static final DeferredHolder<Block, Block> LIGHT_CYAN_FLOOR_TILE_WALL = register("light_cyan_floor_tile_wall", () -> new BaseWall(LIGHT_CYAN_FLOOR_TILE.get()));
    public static final DeferredHolder<Block, BaseBlock> CYAN_FLOOR_TILE = register("cyan_floor_tile", () -> new BaseBlock(BaseBlockProperty.tile()));
    public static final DeferredHolder<Block, Block> CYAN_FLOOR_TILE_SLAB = register("cyan_floor_tile_slab", () -> new BaseSlab(CYAN_FLOOR_TILE.get()));
    public static final DeferredHolder<Block, Block> CYAN_FLOOR_TILE_STAIRS = register("cyan_floor_tile_stairs", () -> new BaseStairs(CYAN_FLOOR_TILE.get()));
    public static final DeferredHolder<Block, Block> CYAN_FLOOR_TILE_WALL = register("cyan_floor_tile_wall", () -> new BaseWall(CYAN_FLOOR_TILE.get()));
    public static final DeferredHolder<Block, BaseBlock> DARK_CYAN_FLOOR_TILE = register("dark_cyan_floor_tile", () -> new BaseBlock(BaseBlockProperty.stone()));
    public static final DeferredHolder<Block, Block> DARK_CYAN_FLOOR_TILE_SLAB = register("dark_cyan_floor_tile_slab", () -> new BaseSlab(DARK_CYAN_FLOOR_TILE.get()));
    public static final DeferredHolder<Block, Block> DARK_CYAN_FLOOR_TILE_STAIRS = register("dark_cyan_floor_tile_stairs", () -> new BaseStairs(DARK_CYAN_FLOOR_TILE.get()));
    public static final DeferredHolder<Block, Block> DARK_CYAN_FLOOR_TILE_WALL = register("dark_cyan_floor_tile_wall", () -> new BaseWall(DARK_CYAN_FLOOR_TILE.get()));
    public static final DeferredHolder<Block, Block> LAYERED_CYAN_FLOOR_TILES = register("layered_cyan_floor_tiles", () -> new BaseHorizontalDirectionalBlock(BaseBlockProperty.stone()));
    public static final DeferredHolder<Block, Block> VERTICAL_CYAN_FLOOR_TILES = register("vertical_cyan_floor_tiles", () -> new BaseHorizontalDirectionalBlock(BaseBlockProperty.stone()));
    public static final DeferredHolder<Block, Block> MIXED_CYAN_FLOOR_TILES = register("mixed_cyan_floor_tiles", () -> new BaseHorizontalDirectionalBlock(BaseBlockProperty.stone()));
    public static final DeferredHolder<Block, Block> CHISELED_CYAN_FLOOR_TILE = register("chiseled_cyan_floor_tile", () -> new BaseBlock(BaseBlockProperty.stone()));
    public static final DeferredHolder<Block, Block> CUT_CYAN_FLOOR_TILES = register("cut_cyan_floor_tiles", () -> new BaseBlock(BaseBlockProperty.stone()));
    public static final DeferredHolder<Block, Block> WEATHERED_RED_STONE_TILE = register("weathered_red_stone_tile", () -> new BaseBlock(BaseBlockProperty.stone()));
    public static final DeferredHolder<Block, Block> WEATHERED_RED_STONE_TILE_SLAB = register("weathered_red_stone_tile_slab", () -> new BaseSlab(DARK_CYAN_FLOOR_TILE.get()));
    public static final DeferredHolder<Block, Block> WEATHERED_RED_STONE_TILE_STAIRS = register("weathered_red_stone_tile_stairs", () -> new BaseStairs(DARK_CYAN_FLOOR_TILE.get()));
    public static final DeferredHolder<Block, Block> WEATHERED_RED_STONE_TILE_WALL = register("weathered_red_stone_tile_wall", () -> new BaseWall(DARK_CYAN_FLOOR_TILE.get()));
    public static final DeferredHolder<Block, Block> BLUE_AND_BLACK_TILE = register("blue_and_black_tile", () -> new BaseBlock(BaseBlockProperty.stone()));
    public static final DeferredHolder<Block, Block> BLUE_AND_BLACK_TILE_SLAB = register("blue_and_black_tile_slab", () -> new BaseSlab(DARK_CYAN_FLOOR_TILE.get()));
    public static final DeferredHolder<Block, Block> BLUE_AND_BLACK_TILE_STAIRS = register("blue_and_black_tile_stairs", () -> new BaseStairs(DARK_CYAN_FLOOR_TILE.get()));
    public static final DeferredHolder<Block, Block> BLUE_AND_BLACK_TILE_WALL = register("blue_and_black_tile_wall", () -> new BaseWall(DARK_CYAN_FLOOR_TILE.get()));
    public static final DeferredHolder<Block, BaseBlock> GREEN_GLAZED_TILES = register("green_glazed_tiles", () -> new BaseBlock(BaseBlockProperty.glazed()));
    public static final DeferredHolder<Block, Block> GREEN_GLAZED_TILE_SLAB = register("green_glazed_tile_slab", () -> new BaseSlab(GREEN_GLAZED_TILES.get()));
    public static final DeferredHolder<Block, Block> GREEN_GLAZED_TILE_STAIRS = register("green_glazed_tile_stairs", () -> new BaseStairs(GREEN_GLAZED_TILES.get()));
    public static final DeferredHolder<Block, Block> BLACK_FLOOR_TILES = register("black_floor_tiles", () -> new BaseBlock(BaseBlockProperty.stone()));
    public static final DeferredHolder<Block, Block> BLACK_FLOOR_TILES_LITTLE_MOSSY = register("black_floor_tiles_little_mossy", () -> new BaseHorizontalDirectionalBlock(BaseBlockProperty.stone()));
    public static final DeferredHolder<Block, Block> BLACK_FLOOR_TILES_MODERATE_MOSSY = register("black_floor_tiles_moderate_mossy", () -> new BaseHorizontalDirectionalBlock(BaseBlockProperty.stone()));
    public static final DeferredHolder<Block, Block> BLACK_FLOOR_TILES_VERY_MOSSY = register("black_floor_tiles_very_mossy", () -> new BaseHorizontalDirectionalBlock(BaseBlockProperty.stone()));

    // WOODEN

    public static final DeferredHolder<Block, BaseBlock> ROSEWOOD_PLANKS = register("rosewood_planks", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> ROSEWOOD_SLAB = register("rosewood_slab", () -> new BaseSlab(ROSEWOOD_PLANKS.get()));
    public static final DeferredHolder<Block, Block> ROSEWOOD_STAIRS = register("rosewood_stairs", () -> new BaseStairs(ROSEWOOD_PLANKS.get()));
    public static final DeferredHolder<Block, Block> ROSEWOOD_FENCE = register("rosewood_fence", () -> new BaseFence(ROSEWOOD_PLANKS.get()));
    public static final DeferredHolder<Block, Block> VARNISHED_ROSEWOOD = register("varnished_rosewood", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, BaseBlock> BAMBOO_MAT = register("bamboo_mat", () -> new BaseBlock(BaseBlockProperty.bamboo_wood()));
    public static final DeferredHolder<Block, Block> BAMBOO_MAT_SLAB = register("bamboo_mat_slab", () -> new BaseSlab(BAMBOO_MAT.get()));
    public static final DeferredHolder<Block, Block> BAMBOO_MAT_STAIRS = register("bamboo_mat_stairs", () -> new BaseStairs(BAMBOO_MAT.get()));

    // ROOF TILES

    public static final DeferredHolder<Block, Block> GRAY_ROOF_TILES = register("gray_roof_tiles", () -> new RoofTiles(DyeColor.GRAY, RoofTiles.RoofTileType.NORMAL));
    public static final DeferredHolder<Block, Block> GRAY_ROOF_TILE_STAIRS = register("gray_roof_tile_stairs", () -> new RoofTiles(DyeColor.GRAY, RoofTiles.RoofTileType.STAIRS));
    public static final DeferredHolder<Block, Block> GRAY_ROOF_TILE_EDGE = register("gray_roof_tile_edge", () -> new RoofTiles(DyeColor.GRAY, RoofTiles.RoofTileType.EDGE));
    public static final DeferredHolder<Block, Block> YELLOW_ROOF_TILES = register("yellow_roof_tiles", () -> new RoofTiles(DyeColor.YELLOW, RoofTiles.RoofTileType.NORMAL));
    public static final DeferredHolder<Block, Block> YELLOW_ROOF_TILE_STAIRS = register("yellow_roof_tile_stairs", () -> new RoofTiles(DyeColor.YELLOW, RoofTiles.RoofTileType.STAIRS));
    public static final DeferredHolder<Block, Block> YELLOW_ROOF_TILE_EDGE = register("yellow_roof_tile_edge", () -> new RoofTiles(DyeColor.YELLOW, RoofTiles.RoofTileType.EDGE));
    public static final DeferredHolder<Block, Block> GREEN_ROOF_TILES = register("green_roof_tiles", () -> new RoofTiles(DyeColor.GREEN, RoofTiles.RoofTileType.NORMAL));
    public static final DeferredHolder<Block, Block> GREEN_ROOF_TILE_STAIRS = register("green_roof_tile_stairs", () -> new RoofTiles(DyeColor.GREEN, RoofTiles.RoofTileType.STAIRS));
    public static final DeferredHolder<Block, Block> GREEN_ROOF_TILE_EDGE = register("green_roof_tile_edge", () -> new RoofTiles(DyeColor.GREEN, RoofTiles.RoofTileType.EDGE));
    public static final DeferredHolder<Block, Block> BLUE_ROOF_TILES = register("blue_roof_tiles", () -> new RoofTiles(DyeColor.BLUE, RoofTiles.RoofTileType.NORMAL));
    public static final DeferredHolder<Block, Block> BLUE_ROOF_TILE_STAIRS = register("blue_roof_tile_stairs", () -> new RoofTiles(DyeColor.BLUE, RoofTiles.RoofTileType.STAIRS));
    public static final DeferredHolder<Block, Block> BLUE_ROOF_TILE_EDGE = register("blue_roof_tile_edge", () -> new RoofTiles(DyeColor.BLUE, RoofTiles.RoofTileType.EDGE));
    public static final DeferredHolder<Block, Block> CYAN_ROOF_TILES = register("cyan_roof_tiles", () -> new RoofTiles(DyeColor.CYAN, RoofTiles.RoofTileType.NORMAL));
    public static final DeferredHolder<Block, Block> CYAN_ROOF_TILE_STAIRS = register("cyan_roof_tile_stairs", () -> new RoofTiles(DyeColor.CYAN, RoofTiles.RoofTileType.STAIRS));
    public static final DeferredHolder<Block, Block> CYAN_ROOF_TILE_EDGE = register("cyan_roof_tile_edge", () -> new RoofTiles(DyeColor.CYAN, RoofTiles.RoofTileType.EDGE));
    public static final DeferredHolder<Block, Block> BLACK_ROOF_TILES = register("black_roof_tiles", () -> new RoofTiles(DyeColor.BLACK, RoofTiles.RoofTileType.NORMAL));
    public static final DeferredHolder<Block, Block> BLACK_ROOF_TILE_STAIRS = register("black_roof_tile_stairs", () -> new RoofTiles(DyeColor.BLACK, RoofTiles.RoofTileType.STAIRS));
    public static final DeferredHolder<Block, Block> BLACK_ROOF_TILE_EDGE = register("black_roof_tile_edge", () -> new RoofTiles(DyeColor.BLACK, RoofTiles.RoofTileType.EDGE));

    // ROOF RIDGE

    public static final DeferredHolder<Block, Block> BLACK_ROOF_RIDGE_UPPER = register("black_roof_ridge_upper", () -> new RoofRidge(DyeColor.BLACK, RoofRidge.RoofRidgeType.UPPER));
    public static final DeferredHolder<Block, Block> BLACK_ROOF_RIDGE_LOWER = register("black_roof_ridge_lower", () -> new RoofRidge(DyeColor.BLACK, RoofRidge.RoofRidgeType.LOWER));
    public static final DeferredHolder<Block, Block> BLACK_ROOF_RIDGE_CONNECTION = register("black_roof_ridge_connection", () -> new RoofRidgeConnection(DyeColor.BLACK, SnowRoofRidge.RoofRidgeType.CONNECTION));
    public static final DeferredHolder<Block, Block> BLACK_MAIN_ROOF_RIDGE_CONNECTION = register("black_main_roof_ridge_connection", () -> new RoofMainRidgeConnection(DyeColor.BLACK, SnowRoofRidge.RoofRidgeType.MAIN_CONNECTION));
    public static final DeferredHolder<Block, Block> BLACK_ROOF_RIDGE_UPPER_SLAB = register("black_roof_ridge_upper_slab", () -> new BaseSlab(BaseBlockProperty.stone()));
    public static final DeferredHolder<Block, Block> BLACK_MAIN_ROOF_RIDGE_SLAB = register("black_main_roof_ridge_slab", () -> new BaseHorizontalDirectionalSlab(BaseBlockProperty.stone()));
    public static final DeferredHolder<Block, Block> BLACK_MAIN_ROOF_RIDGE_PANEL = register("black_main_roof_ridge_panel", () -> new RoofRidgePanel(BaseBlockProperty.stone()));
    public static final DeferredHolder<Block, Block> BLACK_MAIN_ROOF_RIDGE_PLATE = register("black_main_roof_ridge_plate", () -> new RoofRidgePlate(BaseBlockProperty.stone()));
    public static final DeferredHolder<Block, Block> BLACK_MAIN_ROOF_RIDGE_STAIRS = register("black_main_roof_ridge_stairs", () -> new StraightStairBlock(BaseBlockProperty.stone()));

    public static final DeferredHolder<Block, Block> YELLOW_ROOF_RIDGE_UPPER = register("yellow_roof_ridge_upper", () -> new RoofRidge(DyeColor.YELLOW, RoofRidge.RoofRidgeType.UPPER));
    public static final DeferredHolder<Block, Block> YELLOW_ROOF_RIDGE_LOWER = register("yellow_roof_ridge_lower", () -> new RoofRidge(DyeColor.YELLOW, RoofRidge.RoofRidgeType.LOWER));
    public static final DeferredHolder<Block, Block> YELLOW_ROOF_RIDGE_CONNECTION = register("yellow_roof_ridge_connection", () -> new RoofRidgeConnection(DyeColor.YELLOW, SnowRoofRidge.RoofRidgeType.CONNECTION));
    public static final DeferredHolder<Block, Block> YELLOW_MAIN_ROOF_RIDGE_CONNECTION = register("yellow_main_roof_ridge_connection", () -> new RoofMainRidgeConnection(DyeColor.YELLOW, SnowRoofRidge.RoofRidgeType.MAIN_CONNECTION));
    public static final DeferredHolder<Block, Block> YELLOW_ROOF_RIDGE_UPPER_SLAB = register("yellow_roof_ridge_upper_slab", () -> new BaseSlab(BaseBlockProperty.stone()));
    public static final DeferredHolder<Block, Block> YELLOW_MAIN_ROOF_RIDGE_SLAB = register("yellow_main_roof_ridge_slab", () -> new BaseHorizontalDirectionalSlab(BaseBlockProperty.stone()));
    public static final DeferredHolder<Block, Block> YELLOW_MAIN_ROOF_RIDGE_PANEL = register("yellow_main_roof_ridge_panel", () -> new RoofRidgePanel(BaseBlockProperty.stone()));
    public static final DeferredHolder<Block, Block> YELLOW_MAIN_ROOF_RIDGE_PLATE = register("yellow_main_roof_ridge_plate", () -> new RoofRidgePlate(BaseBlockProperty.stone()));
    public static final DeferredHolder<Block, Block> YELLOW_MAIN_ROOF_RIDGE_STAIRS = register("yellow_main_roof_ridge_stairs", () -> new StraightStairBlock(BaseBlockProperty.stone()));

    /**
     * DECORATIVE BLOCKS
     */

    // SIMPLE WOODEN

    public static final DeferredHolder<Block, Block> OAK_BRACKET = register("oak_bracket", () -> new Bracket(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> SPRUCE_BRACKET = register("spruce_bracket", () -> new Bracket(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BIRCH_BRACKET = register("birch_bracket", () -> new Bracket(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> JUNGLE_BRACKET = register("jungle_bracket", () -> new Bracket(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> ACACIA_BRACKET = register("acacia_bracket", () -> new Bracket(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> DARK_OAK_BRACKET = register("dark_oak_bracket", () -> new Bracket(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> CRIMSON_BRACKET = register("crimson_bracket", () -> new Bracket(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> WARPED_BRACKET = register("warped_bracket", () -> new Bracket(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> MANGROVE_BRACKET = register("mangrove_bracket", () -> new Bracket(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> CHERRY_BRACKET = register("cherry_bracket", () -> new Bracket(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> VARNISHED_ROSEWOOD_BRACKET = register("varnished_rosewood_bracket", () -> new Bracket(BaseBlockProperty.wood()));

    // SIMPLE CARVED WOOD

    public static final DeferredHolder<Block, Block> RED_CARVED_WOOD = register("red_carved_wood", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> RED_CARVED_WOODEN_SLAB = register("red_carved_wooden_slab", () -> new BaseSlab(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> RED_CARVED_WOODEN_STAIRS = register("red_carved_wooden_stairs", () -> new StraightStairBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_CARVED_WOOD = register("blue_carved_wood", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_CARVED_WOODEN_SLAB = register("blue_carved_wooden_slab", () -> new BaseSlab(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_CARVED_WOODEN_STAIRS = register("blue_carved_wooden_stairs", () -> new StraightStairBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_CARVED_WOODEN_BRACKET_STAIRS = register("blue_carved_wooden_bracket_stairs", () -> new StraightStairBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_CARVED_WOODEN_BRACKET = register("blue_carved_wooden_bracket", () -> new Bracket(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> CYAN_CARVED_WOOD = register("cyan_carved_wood", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> CYAN_CARVED_WOODEN_SLAB = register("cyan_carved_wooden_slab", () -> new BaseSlab(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> CYAN_CARVED_WOODEN_STAIRS = register("cyan_carved_wooden_stairs", () -> new StraightStairBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> CYAN_CARVED_WOODEN_BRACKET = register("cyan_carved_wooden_bracket", () -> new Bracket(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GREEN_CARVED_WOOD = register("green_carved_wood", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GREEN_CARVED_WOODEN_SLAB = register("green_carved_wooden_slab", () -> new BaseSlab(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GREEN_CARVED_WOODEN_STAIRS = register("green_carved_wooden_stairs", () -> new StraightStairBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GREEN_CARVED_WOODEN_BRACKET = register("green_carved_wooden_bracket", () -> new Bracket(BaseBlockProperty.wood()));

    // MIXED CARVED WOOD

    public static final DeferredHolder<Block, Block> ORANGE_AND_BLUE_CARVED_WOOD = register("orange_and_blue_carved_wood", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> ORANGE_AND_GREEN_CARVED_WOOD = register("orange_and_green_carved_wood", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GREEN_AND_BLUE_CARVED_WOOD = register("green_and_blue_carved_wood", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> DARK_GREEN_AND_DARK_BLUE_CARVED_WOOD = register("dark_green_and_dark_blue_carved_wood", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> DARK_BLUE_AND_DARK_GREEN_CARVED_WOOD = register("dark_blue_and_dark_green_carved_wood", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLACK_WHITE_GREEN_CARVED_WOOD = register("black_white_green_carved_wood", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLACK_WHITE_BLUE_CARVED_WOOD = register("black_white_blue_carved_wood", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> RED_AND_GREEN_CARVED_WOOD = register("red_and_green_carved_wood", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_AND_RED_CARVED_WOOD = register("blue_and_red_carved_wood", () -> new BaseBlock(BaseBlockProperty.wood()));

    public static final DeferredHolder<Block, Block> BLUE_WHITE_RED_CARVED_WOOD = register("blue_white_red_carved_wood", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GREEN_WHITE_RED_CARVED_WOOD = register("green_white_red_carved_wood", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1 = register("blue_and_yellow_carved_wood_variant_1", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2 = register("blue_and_yellow_carved_wood_variant_2", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3 = register("blue_and_yellow_carved_wood_variant_3", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> YELLOW_AND_GREEN_CARVED_WOOD = register("yellow_and_green_carved_wood", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> YELLOW_GREEN_BLUE_CARVED_WOOD = register("yellow_green_blue_carved_wood", () -> new BaseBlock(BaseBlockProperty.wood()));

    // DARK OAK

    public static final DeferredHolder<Block, Block> CARVED_DARK_OAK_BEAM = register("carved_dark_oak_beam", () -> new ChiralDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> CARVED_DARK_OAK_BEAM_EDGE = register("carved_dark_oak_beam_edge", () -> new ChiralDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GILDED_DARK_OAK = register("gilded_dark_oak", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> CHISELED_GILDED_DARK_OAK = register("chiseled_gilded_dark_oak", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GILDED_DARK_OAK_SLAB = register("gilded_dark_oak_slab", () -> new BaseSlab(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GILDED_DARK_OAK_STAIRS = register("gilded_dark_oak_stairs", () -> new StraightStairBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GILDED_DARK_OAK_BRACKET = register("gilded_dark_oak_bracket", () -> new Bracket(BaseBlockProperty.wood()));

    // CARVED CARPETS

    public static final DeferredHolder<Block, Block> RED_CARVED_CARPET = register("red_carved_carpet", () -> new CarvedCarpet(DyeColor.RED));
    public static final DeferredHolder<Block, Block> BLUE_CARVED_CARPET = register("blue_carved_carpet", () -> new CarvedCarpet(DyeColor.BLUE));

    // PILLARS

    public static final DeferredHolder<Block, Block> CARVED_RED_PILLAR = register("carved_red_pillar", () -> new BaseBlock(BaseBlockProperty.terracotta()));
    public static final DeferredHolder<Block, Block> CARVED_RED_PILLAR_BASE = register("carved_red_pillar_base", () -> new BaseBlock(BaseBlockProperty.terracotta()));
    public static final DeferredHolder<Block, Block> CARVED_RED_PILLAR_HEAD = register("carved_red_pillar_head", () -> new BaseDirectionalBlock(BaseBlockProperty.terracotta()));
    public static final DeferredHolder<Block, Block> SPRUCE_PILLAR_BASE = register("spruce_pillar_base", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> STRIPPED_DARK_OAK_PILLAR_BASE = register("stripped_dark_oak_pillar_base", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_1 = register("gilded_dark_oak_pillar_head_variant_1", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_2 = register("gilded_dark_oak_pillar_head_variant_2", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_3 = register("gilded_dark_oak_pillar_head_variant_3", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_4 = register("gilded_dark_oak_pillar_head_variant_4", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_5 = register("gilded_dark_oak_pillar_head_variant_5", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> CYAN_AND_WHITE_PILLAR_BASE = register("cyan_and_white_pillar_base", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> CYAN_AND_WHITE_DECORATED_PILLAR = register("cyan_and_white_decorated_pillar", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> CYAN_AND_WHITE_PILLAR_HEAD = register("cyan_and_white_pillar_head", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> STONE_PILLAR_BASE = register("stone_pillar_base", () -> new BaseBlock(BaseBlockProperty.stone()));

    // FANGXIN

    public static final DeferredHolder<Block, Block> GREEN_FANGXIN = register("green_fangxin", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GREEN_FANGXIN_EDGE = register("green_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_FANGXIN = register("blue_fangxin", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_FANGXIN_EDGE = register("blue_fangxin_edge", () -> new ChiralDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> CYAN_AND_BLUE_FANGXIN = register("cyan_and_blue_fangxin", () -> new BasePillarBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> CYAN_AND_BLUE_FANGXIN_EDGE = register("cyan_and_blue_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> CYAN_AND_BLUE_FANGXIN_EDGE_VARIANT = register("cyan_and_blue_fangxin_edge_variant", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> CYAN_BLUE_WHITE_FANGXIN = register("cyan_blue_white_fangxin", () -> new BasePillarBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> CYAN_BLUE_WHITE_FANGXIN_EDGE = register("cyan_blue_white_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_AND_GREEN_FANGXIN_EDGE = register("blue_and_green_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> YELLOW_AND_GREEN_FANGXIN_EDGE = register("yellow_and_green_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> DARK_BLUE_FANGXIN = register("dark_blue_fangxin", () -> new BasePillarBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> DARK_BLUE_FANGXIN_EDGE = register("dark_blue_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_AND_WHITE_FANGXIN = register("blue_and_white_fangxin", () -> new BasePillarBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GREEN_AND_DARK_BLUE_FANGXIN = register("green_and_dark_blue_fangxin", () -> new BasePillarBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> WHITE_AND_CYAN_FANGXIN = register("white_and_cyan_fangxin", () -> new BasePillarBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> WHITE_AND_CYAN_FANGXIN_EDGE = register("white_and_cyan_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> WHITE_AND_BLUE_FANGXIN = register("white_and_blue_fangxin", () -> new BasePillarBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> WHITE_AND_BLUE_FANGXIN_EDGE = register("white_and_blue_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> RED_CYAN_BLUE_FANGXIN = register("red_cyan_blue_fangxin", () -> new ChiralDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> RED_CYAN_BLUE_FANGXIN_EDGE = register("red_cyan_blue_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_CYAN_BLUE_FANGXIN_EDGE = register("blue_cyan_blue_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_CYAN_RED_FANGXIN = register("blue_cyan_red_fangxin", () -> new ChiralDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_CYAN_RED_FANGXIN_EDGE = register("blue_cyan_red_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> CYAN_BLUE_CYAN_FANGXIN = register("cyan_blue_cyan_fangxin", () -> new ChiralDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> RED_BLUE_RED_FANGXIN = register("red_blue_red_fangxin", () -> new ChiralDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> CYAN_AND_YELLOW_FANGXIN_EDGE = register("cyan_and_yellow_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> MING_BLUE_JINZHUOMO_SHINIANYU_XUANZI_FANGXIN_EDGE = register("ming_blue_jinzhuomo_shinianyu_xuanzi_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> MING_BLUE_GILDED_JINZHUOMO_SHINIANYU_XUANZI_FANGXIN = register("ming_blue_gilded_jinzhuomo_shinianyu_xuanzi_fangxin",
            () -> new ChiralDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> MING_BLUE_GILDED_JINZHUOMO_SHINIANYU_XUANZI_FANGXIN_EDGE = register("ming_blue_gilded_jinzhuomo_shinianyu_xuanzi_fangxin_edge",
            () -> new ChiralDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> MING_GREEN_GILDED_JINZHUOMO_SHINIANYU_XUANZI_FANGXIN = register("ming_green_gilded_jinzhuomo_shinianyu_xuanzi_fangxin",
            () -> new ChiralDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> MING_GREEN_GILDED_JINZHUOMO_SHINIANYU_XUANZI_FANGXIN_EDGE = register("ming_green_gilded_jinzhuomo_shinianyu_xuanzi_fangxin_edge",
            () -> new ChiralDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> QING_BLUE_PLAIN_JINZHUOMO_SHINIANYU_FANGXIN = register("qing_blue_plain_jinzhuomo_shinianyu_fangxin",
            () -> new ChiralDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> YUAN_NIANYUZHUANG_FANGXIN = register("yuan_nianyuzhuang_fangxin", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> YUAN_NIANYUZHUANG_FANGXIN_EDGE = register("yuan_nianyuzhuang_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> YUAN_PATTERNED_NIANYUZHUANG_FANGXIN = register("yuan_patterned_nianyuzhuang_fangxin", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> YUAN_PATTERNED_NIANYUZHUANG_FANGXIN_EDGE = register("yuan_patterned_nianyuzhuang_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> YUAN_GREEN_NIANYUZHUANG_FANGXIN = register("yuan_green_nianyuzhuang_fangxin", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> YUAN_GREEN_NIANYUZHUANG_FANGXIN_EDGE = register("yuan_green_nianyuzhuang_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> YUAN_PATTERNED_WUCHAIZHUANG_FANGXIN = register("yuan_patterned_wuchaizhuang_fangxin", () -> new ChiralDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> YUAN_PATTERNED_WUCHAIZHUANG_FANGXIN_EDGE = register("yuan_patterned_wuchaizhuang_fangxin_edge", () -> new ChiralDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> YUAN_GREEN_WUCHAIZHUANG_FANGXIN = register("yuan_green_wuchaizhuang_fangxin", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> YUAN_GREEN_WUCHAIZHUANG_FANGXIN_EDGE = register("yuan_green_wuchaizhuang_fangxin_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));

    // ZHAOTOU

    public static final DeferredHolder<Block, Block> BLUE_ZHAOTOU_EDGE = register("blue_zhaotou_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GREEN_AND_BLUE_ZHAOTOU = register("green_and_blue_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_AND_GREEN_ZHAOTOU = register("blue_and_green_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_AND_GREEN_DOUBLE_LAYERED_ZHAOTOU = register("blue_and_green_double_layered_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> CYAN_AND_RED_ZHAOTOU = register("cyan_and_red_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> CYAN_AND_BLUE_ZHAOTOU = register("cyan_and_blue_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GRAY_BLACK_RED_ZHAOTOU = register("gray_black_red_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_GREEN_RED_ZHAOTOU = register("blue_green_red_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> RED_AND_BLUE_ZHAOTOU = register("red_and_blue_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GREEN_AND_YELLOW_ZHAOTOU = register("green_and_yellow_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> RED_GREEN_BLUE_ZHAOTOU = register("red_green_blue_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> WHITE_BLUE_GREEN_ZHAOTOU = register("white_blue_green_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> MING_YANZHUOMO_SHINIANYU_OUTER_ZHAOTOU = register("ming_yanzhuomo_shinianyu_outer_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> MING_YANZHUOMO_SHINIANYU_OUTER_ZHAOTOU_EDGE = register("ming_yanzhuomo_shinianyu_outer_zhaotou_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> YUAN_NIANYUZHUANG_ZHAOTOU = register("yuan_nianyuzhuang_zhaotou", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> YUAN_NIANYUZHUANG_ZHAOTOU_CONNECTION = register("yuan_nianyuzhuang_zhaotou_connection", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));

    // GUTOU

    public static final DeferredHolder<Block, Block> GREEN_BLUE_BLACK_GUTOU = register("green_blue_black_gutou", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_GREEN_YELLOW_GUTOU = register("blue_green_yellow_gutou", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_AND_YELLOW_GUTOU = register("blue_and_yellow_gutou", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> MING_YANZHUOMO_SHINIANYU_OUTER_GUTOU_EDGE = register("ming_yanzhuomo_shinianyu_outer_gutou_edge", () -> new BaseDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> YUAN_NIANYUZHUANG_GUTOU = register("yuan_nianyuzhuang_gutou", () -> new ChiralDirectionalBlock(BaseBlockProperty.wood()));

    // RAFTERS

    public static final DeferredHolder<Block, Block> GILDED_DARK_OAK_RAFTER = register("gilded_dark_oak_rafter", () -> new Rafter(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GILDED_DARK_OAK_RAFTER_END = register("gilded_dark_oak_rafter_end", () -> new RafterEnd(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> DARK_OAK_RAFTER = register("dark_oak_rafter", () -> new Rafter(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> DARK_OAK_RAFTER_END = register("dark_oak_rafter_end", () -> new RafterEnd(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_TIGER_EYE_RAFTER = register("blue_tiger_eye_rafter", () -> new Rafter(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_TIGER_EYE_RAFTER_END = register("blue_tiger_eye_rafter_end", () -> new RafterEnd(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_CARVED_TIGER_EYE_RAFTER = register("blue_carved_tiger_eye_rafter", () -> new Rafter(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BLUE_CARVED_TIGER_EYE_RAFTER_END = register("blue_carved_tiger_eye_rafter_end", () -> new RafterEnd(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GREEN_CARVED_TIGER_EYE_RAFTER = register("green_tiger_eye_rafter", () -> new Rafter(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GREEN_CARVED_TIGER_EYE_RAFTER_END = register("green_tiger_eye_rafter_end", () -> new RafterEnd(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GREEN_WANZI_RAFTER = register("green_wanzi_rafter", () -> new Rafter(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GREEN_WANZI_RAFTER_END = register("green_wanzi_rafter_end", () -> new RafterEnd(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GREEN_CARVED_WANZI_RAFTER = register("green_carved_wanzi_rafter", () -> new Rafter(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> GREEN_CARVED_WANZI_RAFTER_END = register("green_carved_wanzi_rafter_end", () -> new RafterEnd(BaseBlockProperty.wood()));

    // BEAM HEAD

    public static final DeferredHolder<Block, Block> GILDED_DARK_OAK_BEAM_HEAD = register("gilded_dark_oak_beam_head", () -> new BeamHead(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> QING_GREEN_BEAM_HEAD = register("qing_green_beam_head", () -> new WallSideBlock(BaseBlockProperty.wood(), 14));

    // ARCHITRAVE

    public static final DeferredHolder<Block, Block> RED_AND_CYAN_CARVED_ARCHITRAVE = register("red_and_cyan_carved_architrave", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> RED_AND_CYAN_CARVED_ARCHITRAVE_SLAB = register("red_and_cyan_carved_architrave_slab", () -> new BaseSlab(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> RED_AND_BLUE_CARVED_ARCHITRAVE = register("red_and_blue_carved_architrave", () -> new BaseBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> RED_AND_BLUE_CARVED_ARCHITRAVE_SLAB = register("red_and_blue_carved_architrave_slab", () -> new BaseSlab(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> EMPTY_TUANHUA_SLAB = register("empty_tuanhua_slab", () -> new BaseSlab(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> FULL_TUANHUA_SLAB = register("full_tuanhua_slab", () -> new BaseSlab(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> RED_AND_CYAN_TUANHUA_SLAB = register("red_and_cyan_tuanhua_slab", () -> new BaseSlab(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> RED_CARVED_ARCHITRAVE = register("red_carved_architrave", () -> new BaseSlab(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> WHITE_AND_RED_SLAB = register("white_and_red_slab", () -> new BaseSlab(BaseBlockProperty.wood()));

    // QUETI

    public static final DeferredHolder<Block, Block> LONG_GILDED_DARK_OAK_QUETI = register("long_gilded_dark_oak_queti", () -> new WallSideBlock(BaseBlockProperty.wood(), ShapeFunction.cardinalRotations(new RawVoxelShape(0, 4, 13, 16, 16, 15))));
    public static final DeferredHolder<Block, Block> LONG_GILDED_DARK_OAK_QUETI_EDGE = register("long_gilded_dark_oak_queti_edge", () -> new OrientableWallSideBlock(BaseBlockProperty.wood(), ShapeFunction.sideOrientedShape(new RawVoxelShape(0, -4, 12, 32, 16, 16))));
    public static final DeferredHolder<Block, Block> HORIZONTAL_GILDED_DARK_OAK_QUETI = register("horizontal_gilded_dark_oak_queti", () -> new SideAxialBlock(BaseBlockProperty.wood(),
            ShapeFunction.or(ShapeFunction.cardinalRotations(new RawVoxelShape(6, 0, 0, 10, 16, 16)), ShapeFunction.cardinalRotations(new RawVoxelShape(6, 8, -16, 10, 16, 0)))));
    public static final DeferredHolder<Block, Block> CENTRAL_GILDED_DARK_OAK_QUETI = register("central_gilded_dark_oak_queti", () -> new CentralAxialBlock(BaseBlockProperty.wood(),
            ShapeFunction.exclude(ShapeFunction.axialRotations(new RawVoxelShape(-16, 0, 6, 32, 16, 10)), ShapeFunction.axialRotations(new RawVoxelShape(0, 0, 6, 16, 8, 10)))));
    public static final DeferredHolder<Block, Block> VERTICAL_GILDED_DARK_OAK_QUETI = register("vertical_gilded_dark_oak_queti", () -> new SideAxialBlock(BaseBlockProperty.wood(),
            ShapeFunction.or(ShapeFunction.cardinalRotations(new RawVoxelShape(6, 0, 0, 10, 16, 16)), ShapeFunction.cardinalRotations(new RawVoxelShape(6, -16, 8, 10, 0, 16)))));
    public static final DeferredHolder<Block, Block> WOODEN_QUETI = register("wooden_queti", () -> new WallSideBlock(BaseBlockProperty.wood(), ShapeFunction.cardinalRotations(new RawVoxelShape(0, 11, 14, 16, 16, 15))));
    public static final DeferredHolder<Block, Block> WOODEN_QUETI_EDGE = register("wooden_queti_edge", () -> new OrientableWallSideBlock(BaseBlockProperty.wood(), ShapeFunction.cardinalRotations(new RawVoxelShape(0, 0, 14, 16, 16, 15))));
    public static final DeferredHolder<Block, Block> TALL_WOODEN_QUETI_EDGE = register("tall_wooden_queti_edge", () -> new OrientableWallSideBlock(BaseBlockProperty.wood(),
            ShapeFunction.or(ShapeFunction.cardinalRotations(new RawVoxelShape(0, 0, 14, 16, 16, 15)), ShapeFunction.cardinalRotations(new RawVoxelShape(0, -16, 14, 8, 0, 15)))));
    public static final DeferredHolder<Block, Block> LARGE_WOODEN_QUETI_EDGE = register("large_wooden_queti_edge", () -> new OrientableWallSideBlock(BaseBlockProperty.wood(),
            ShapeFunction.or(ShapeFunction.cardinalRotations(new RawVoxelShape(0, 0, 14, 16, 16, 15)), ShapeFunction.cardinalRotations(new RawVoxelShape(0, -16, 14, 8, 0, 15)), ShapeFunction.cardinalRotations(new RawVoxelShape(16, 8, 14, 32, 16, 15)))));
    public static final DeferredHolder<Block, Block> SHORT_GLAZED_QUETI = register("short_glazed_queti", () -> new OrientableWallSideBlock(BaseBlockProperty.wood(), ShapeFunction.sideOrientedShape(new RawVoxelShape(0, 0, 14, 32, 16, 15))));
    public static final DeferredHolder<Block, Block> THICK_CARVED_QUETI = register("thick_carved_queti", () -> new SideAxialBlock(BaseBlockProperty.wood(), ShapeFunction.cardinalRotations(new RawVoxelShape(6, 0, -7, 10, 16, 32))));
    public static final DeferredHolder<Block, Block> SHORT_THICK_GLAZED_QUETI = register("short_thick_glazed_queti", () -> new SideAxialBlock(BaseBlockProperty.wood(), ShapeFunction.cardinalRotations(new RawVoxelShape(4, 0, -16, 12, 16, 16))));
    public static final DeferredHolder<Block, Block> WOODEN_GUALUO = register("wooden_gualuo", () -> new WallSideBlock(BaseBlockProperty.wood(), ShapeFunction.cardinalRotations(new RawVoxelShape(0, 0, 13, 16, 16, 15))));
    public static final DeferredHolder<Block, Block> LARGE_WOODEN_GUALUO = register("large_wooden_gualuo", () -> new WallSideBlock(BaseBlockProperty.wood(), ShapeFunction.cardinalRotations(new RawVoxelShape(0, 0, 13, 16, 16, 15))));
    public static final DeferredHolder<Block, Block> LARGE_WOODEN_GUALUO_EDGE = register("large_wooden_gualuo_edge", () -> new OrientableWallSideBlock(BaseBlockProperty.wood(), ShapeFunction.cardinalRotations(new RawVoxelShape(0, 0, 13, 16, 16, 15))));
    public static final DeferredHolder<Block, Block> CARVED_STONE_PANEL = register("carved_stone_panel", () -> new CentralAxialBlock(BaseBlockProperty.stone(), 8));
    public static final DeferredHolder<Block, Block> CARVED_STONE_PANEL_EDGE = register("carved_stone_panel_edge", () -> new SideAxialBlock(BaseBlockProperty.stone(), 8));
    public static final DeferredHolder<Block, Block> CARVED_STONE_PANEL_CENTER = register("carved_stone_panel_center", () -> new CentralAxialBlock(BaseBlockProperty.stone(), 8));
    public static final DeferredHolder<Block, Block> CARVED_STONE_QUETI_PART = register("carved_stone_queti_part", () -> new SideAxialBlock(BaseBlockProperty.stone(), ShapeFunction.cardinalRotations(new RawVoxelShape(4, 0, -9, 12, 16, 31))));
    public static final DeferredHolder<Block, Block> CARVED_STONE_BEAM = register("carved_stone_beam", () -> new SideAxialBlock(BaseBlockProperty.stone(), ShapeFunction.cardinalRotations(new RawVoxelShape(3.5, 0, -16, 12.5, 16, 32))));
    public static final DeferredHolder<Block, Block> CARVED_STONE_QUETI = register("carved_stone_queti", () -> new SideAxialBlock(BaseBlockProperty.stone(), ShapeFunction.cardinalRotations(new RawVoxelShape(4, -16, 0, 12, 16, 16))));

    // PATTERNS

    public static final DeferredHolder<Block, Block> YELLOW_CARVED_PATTERN = register("yellow_carved_pattern", () -> new WallSideBlock(BaseBlockProperty.dye(), ShapeFunction.cardinalRotations(new RawVoxelShape(-6, 2, 15, 22, 14, 16))));
    public static final DeferredHolder<Block, Block> CIRCULAR_YELLOW_CARVED_PATTERN = register("circular_yellow_carved_pattern", () -> new SixSideBlock(BaseBlockProperty.dye()));
    public static final DeferredHolder<Block, Block> YELLOW_CARVED_FANGXIN_EDGE_PATTERN = register("yellow_carved_fangxin_edge_pattern", () -> new OrientableSixSideBlock(BaseBlockProperty.dye()));
    public static final DeferredHolder<Block, Block> YELLOW_CARVED_FANGXIN_PATTERN = register("yellow_carved_fangxin_pattern", () -> new OrientableSixSideBlock(BaseBlockProperty.dye()));
    public static final DeferredHolder<Block, Block> LARGE_YELLOW_CARVED_PATTERN = register("large_yellow_carved_pattern", () -> new SixSideBlock(BaseBlockProperty.dye(),
            ShapeFunction.sixSideShape(new RawVoxelShape(-16, -16, 15, 32, 32, 16), new RawVoxelShape(-16, 0, -16, 32, 1, 32))));
    public static final DeferredHolder<Block, Block> MEDIUM_YELLOW_CARVED_PATTERN = register("medium_yellow_carved_pattern", () -> new OrientableSixSideBlock(BaseBlockProperty.dye(),
            ShapeFunction.orientedSixSideShape(new RawVoxelShape(-16, 0, 15, 32, 32, 16), new RawVoxelShape(-16, 0, -16, 32, 1, 16))));
    public static final DeferredHolder<Block, Block> YELLOW_CARVED_ZHAOTOU_PATTERN = register("yellow_carved_zhaotou_pattern", () -> new OrientableSixSideBlock(BaseBlockProperty.dye()));
    public static final DeferredHolder<Block, Block> LONG_YELLOW_CARVED_ZHAOTOU_PATTERN = register("long_yellow_carved_zhaotou_pattern", () -> new OrientableSixSideBlock(BaseBlockProperty.dye(),
            ShapeFunction.orientedSixSideShape(new RawVoxelShape(0, 0, 15, 16, 32, 16), new RawVoxelShape(0, 0, -16, 16, 1, 16))));
    public static final DeferredHolder<Block, Block> CARVED_ZHAOTOU_PATTERN = register("carved_zhaotou_pattern", () -> new OrientableSixSideBlock(BaseBlockProperty.dye()));
    public static final DeferredHolder<Block, Block> FLAME_ARCH_WALL_PATTERN = register("flame_arch_wall_pattern", () -> new WallSideBlock(BaseBlockProperty.dye(), ShapeFunction.cardinalRotations(new RawVoxelShape(-4, 0, 15, 20, 16, 16))));
    public static final DeferredHolder<Block, Block> GOLDEN_DRAGON_FANGXIN_PATTERN = register("golden_dragon_fangxin_pattern", () -> new WallSideBlock(BaseBlockProperty.dye(), ShapeFunction.cardinalRotations(new RawVoxelShape(-16, 0, 15, 32, 16, 16))));
    public static final DeferredHolder<Block, Block> BLUE_FANGXIN_PATTERN = register("blue_fangxin_pattern", () -> new OrientableSixSideBlock(BaseBlockProperty.dye()));
    public static final DeferredHolder<Block, Block> BLUE_FANGXIN_PATTERN_EDGE = register("blue_fangxin_pattern_edge", () -> new OrientableSixSideBlock(BaseBlockProperty.dye()));
    public static final DeferredHolder<Block, Block> GREEN_FANGXIN_PATTERN = register("green_fangxin_pattern", () -> new OrientableSixSideBlock(BaseBlockProperty.dye()));
    public static final DeferredHolder<Block, Block> GREEN_FANGXIN_PATTERN_EDGE = register("green_fangxin_pattern_edge", () -> new OrientableSixSideBlock(BaseBlockProperty.dye()));
    public static final DeferredHolder<Block, Block> LIGHT_BLUE_SU_STYLE_CAIHUA = register("light_blue_su_style_caihua", () -> new WallSideBlock(BaseBlockProperty.dye(), ShapeFunction.cardinalRotations(new RawVoxelShape(-9, 0, 15, 23, 16, 16))));
    public static final DeferredHolder<Block, Block> YELLOW_SU_STYLE_CAIHUA = register("yellow_su_style_caihua", () -> new WallSideBlock(BaseBlockProperty.dye(), ShapeFunction.cardinalRotations(new RawVoxelShape(-9, 0, 15, 23, 16, 16))));
    public static final DeferredHolder<Block, Block> LIGHT_YELLOW_SU_STYLE_CAIHUA = register("light_yellow_su_style_caihua", () -> new WallSideBlock(BaseBlockProperty.dye(), ShapeFunction.cardinalRotations(new RawVoxelShape(-9, 0, 15, 23, 16, 16))));
    public static final DeferredHolder<Block, Block> MEDIUM_SU_STYLE_CAIHUA = register("medium_su_style_caihua", () -> new WallSideBlock(BaseBlockProperty.dye(), ShapeFunction.cardinalRotations(new RawVoxelShape(-16, 8, 15, 32, 32, 16))));
    public static final DeferredHolder<Block, Block> LARGE_WHITE_SU_STYLE_CAIHUA = register("large_white_su_style_caihua", () -> new WallSideBlock(BaseBlockProperty.dye(), ShapeFunction.cardinalRotations(new RawVoxelShape(-16, 0, 15, 32, 32, 16))));
    public static final DeferredHolder<Block, Block> LARGE_GREEN_SU_STYLE_CAIHUA = register("large_green_su_style_caihua", () -> new WallSideBlock(BaseBlockProperty.dye(), ShapeFunction.cardinalRotations(new RawVoxelShape(-16, 0, 15, 32, 32, 16))));
    public static final DeferredHolder<Block, Block> LARGE_GRAY_SU_STYLE_CAIHUA = register("large_gray_su_style_caihua", () -> new WallSideBlock(BaseBlockProperty.dye(), ShapeFunction.cardinalRotations(new RawVoxelShape(-16, 0, 15, 32, 32, 16))));

    // CHUIHUA

    public static final DeferredHolder<Block, Block> BLUE_AND_GREEN_CHUIHUA = register("blue_and_green_chuihua",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.diagonal(new RawVoxelShape(2, 2, 2, 14, 16, 14))).diagonallyPlaceable().noOcclusion().build());
    public static final DeferredHolder<Block, Block> CYAN_AND_YELLOW_CHUIHUA = register("cyan_and_yellow_chuihua",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.simpleShape(new RawVoxelShape(0, -16, 0, 16, 16, 16))).noOcclusion().build());
    public static final DeferredHolder<Block, Block> GILDED_DARK_OAK_CHUIHUA = register("gilded_dark_oak_chuihua", () -> new SixSideBlock(BaseBlockProperty.wood(),
            ShapeFunction.sixSideShape(new RawVoxelShape(2, 2, 2, 14, 14, 16), new RawVoxelShape(2, 0, 2, 14, 14, 14)), true));

    // ROOF CHARM

    public static final DeferredHolder<Block, Block> GOLDEN_GLAZED_ROOF_CHARM = register("golden_glazed_roof_charm",
            () -> DecorativeBlock.with(BaseBlockProperty.glazed()).shaped(
                            ShapeFunction.or(ShapeFunction.cardinalRotations(new RawVoxelShape(0, -16, -16, 16, 0, 32)), ShapeFunction.cardinalRotations(new RawVoxelShape(0, 0, -16, 16, 16, 16)),
                                    ShapeFunction.cardinalRotations(new RawVoxelShape(4.5, 16, -7.5, 11.5, 29, -0.5)), ShapeFunction.cardinalRotations(new RawVoxelShape(1, 16, 7, 15, 31, 23))))
                    .directional().noOcclusion().build());
    public static final DeferredHolder<Block, Block> GOLDEN_GLAZED_ROOF_CHARM_ACCESSORY = register("golden_glazed_roof_charm_accessory", () -> new WallSideBlock(BaseBlockProperty.glazed(), ShapeFunction.cardinalRotations(new RawVoxelShape(6, 6, 10, 10, 10, 16))));
    public static final DeferredHolder<Block, Block> GREEN_GLAZED_ROOF_CHARM = register("green_glazed_roof_charm",
            () -> DecorativeBlock.with(BaseBlockProperty.glazed()).shaped(
                            ShapeFunction.or(ShapeFunction.cardinalRotations(new RawVoxelShape(0, -16, 0, 16, 4, 32)), ShapeFunction.cardinalRotations(new RawVoxelShape(0, 0, 0, 16, 16, 16)),
                                    ShapeFunction.cardinalRotations(new RawVoxelShape(0, 16, 0, 16, 22, 20)), ShapeFunction.cardinalRotations(new RawVoxelShape(0, 0, 12, 16, 34, 26))))
                    .directional().build());
    public static final DeferredHolder<Block, Block> DARK_PRISMARINE_CHIWEI = register("dark_prismarine_chiwei", () -> DecorativeBlock.with(BaseBlockProperty.stone())
            .shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(0, -16, -16, 16, 30, 15))).directional().noOcclusion().build());

    // CEILING

    public static final DeferredHolder<Block, Block> QING_GOLDEN_DRAGON_CEILING = register("qing_golden_dragon_ceiling",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(BlockShapes.S16_H8).build());

    // RAILING

    public static final DeferredHolder<Block, Block> WHITE_MARBLE_RAILING = register("white_marble_railing", () -> new RailingBlock(BaseBlockProperty.marble(), RailingBlock.MARBLE_SHAPES));
    public static final DeferredHolder<Block, Block> WHITE_MARBLE_RAILING_SLANT = register("white_marble_railing_slant", () -> new RailingSlant(BaseBlockProperty.marble(), 4));
    public static final DeferredHolder<Block, Block> CARVED_WOODEN_RAILING = register("carved_wooden_railing", () -> new RailingBlock(BaseBlockProperty.wood(), RailingBlock.WOODEN_SHAPES));
    public static final DeferredHolder<Block, Block> RED_WOODEN_RAILING = register("red_wooden_railing", () -> new CentralAxialBlock(BaseBlockProperty.wood(), 2, 15));
    public static final DeferredHolder<Block, Block> RED_WOODEN_RAILING_EDGE = register("red_wooden_railing_edge", () -> new CentralAxialBlock(BaseBlockProperty.wood(), 2, 15));
    public static final DeferredHolder<Block, Block> WOODEN_RAILING = register("wooden_railing", () -> new CentralAxialBlock(BaseBlockProperty.wood(), 2, 15));
    public static final DeferredHolder<Block, Block> WOODEN_RAILING_VARIANT = register("wooden_railing_variant", () -> new CentralAxialBlock(BaseBlockProperty.wood(), 2, 15));

    // GUARDIAN LION

    public static final DeferredHolder<Block, Block> SMALL_WOODEN_GUARDIAN_LION = register("small_wooden_guardian_lion",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(BlockShapes.BACKWARD_3B_L).directional().noOcclusion().noFenceConnect().build());
    public static final DeferredHolder<Block, Block> SMALL_STONE_GUARDIAN_LION = register("small_stone_guardian_lion",
            () -> DecorativeBlock.with(BaseBlockProperty.stone()).shaped(BlockShapes.BACKWARD_3B_L).directional().noOcclusion().noFenceConnect().build());
    public static final DeferredHolder<Block, Block> SMALL_JADE_GUARDIAN_LION = register("small_jade_guardian_lion",
            () -> DecorativeBlock.with(BaseBlockProperty.jade()).shaped(BlockShapes.BACKWARD_3B_L).directional().noOcclusion().noFenceConnect().build());
    public static final DeferredHolder<Block, Block> SMALL_YELLOW_GLAZED_GUARDIAN_LION = register("small_yellow_glazed_guardian_lion",
            () -> DecorativeBlock.with(BaseBlockProperty.glazed()).shaped(BlockShapes.BACKWARD_3B_L).directional().noOcclusion().noFenceConnect().build());
    public static final DeferredHolder<Block, Block> SMALL_GREEN_GLAZED_GUARDIAN_LION = register("small_green_glazed_guardian_lion",
            () -> DecorativeBlock.with(BaseBlockProperty.glazed()).shaped(BlockShapes.BACKWARD_3B_L).directional().noOcclusion().noFenceConnect().build());
    public static final DeferredHolder<Block, Block> XUMI_STONE_MONOLITH = register("xumi_stone_monolith",
            () -> DecorativeBlock.with(BaseBlockProperty.stone()).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(-8, 0, -1, 24, 32, 17))).directional().noOcclusion().noFenceConnect().build());

    // MISC DECORATIONS

    public static final DeferredHolder<Block, Block> CABBAGE_BASKET = register("cabbage_basket", () -> new StackableHalfBlock(BaseBlockProperty.crop()));
    public static final DeferredHolder<Block, Block> CELERY_BASKET = register("celery_basket", () -> new StackableHalfBlock(BaseBlockProperty.crop()));
    public static final DeferredHolder<Block, Block> ORANGE_BASKET = register("orange_basket", () -> new StackableHalfBlock(BaseBlockProperty.crop()));
    public static final DeferredHolder<Block, Block> APPLE_BASKET = register("apple_basket", () -> new StackableHalfBlock(BaseBlockProperty.crop()));
    public static final DeferredHolder<Block, Block> EGGPLANT_BASKET = register("eggplant_basket", () -> new StackableHalfBlock(BaseBlockProperty.crop()));
    public static final DeferredHolder<Block, Block> PEAR_BASKET = register("pear_basket", () -> new StackableHalfBlock(BaseBlockProperty.crop()));
    public static final DeferredHolder<Block, Block> BOOKSHELF = register("bookshelf", () -> new BaseHorizontalDirectionalBlock(BaseBlockProperty.wood()));
    public static final DeferredHolder<Block, Block> BOOKSHELF_VARIANT = register("bookshelf_variant", () -> new BaseHorizontalDirectionalBlock(BaseBlockProperty.wood()));

    /**
     * DECORATIONS
     */

    // STUDY

    public static final DeferredHolder<Block, Block> ABACUS = register("abacus",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.eightRotations(new RawVoxelShape(-1, 0, 3.5, 17, 1.5, 12.5))).directional().diagonallyPlaceable().noOcclusion().noCollision().build());
    public static final DeferredHolder<Block, Block> BRUSH_TOOLS = register("brush_tools",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.eightRotations(new RawVoxelShape(0.5, 0, 4, 15.5, 13, 10))).directional().diagonallyPlaceable().noCollision().build());
    public static final DeferredHolder<Block, Block> BRUSH_AND_INKSTONE = register("brush_and_inkstone",
            () -> DecorativeBlock.with(BaseBlockProperty.paper()).shaped(BlockShapes.S16_H4).directional().noCollision().noOcclusion().build());
    public static final DeferredHolder<Block, Block> RULER = register("ruler",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(BlockShapes.S16_H1).directional().diagonallyPlaceable().noOcclusion().noCollision().build());
    public static final DeferredHolder<Block, Block> PAINTING_SCROLL = register("painting_scroll",
            () -> DecorativeBlock.with(BaseBlockProperty.paper()).shaped(BlockShapes.S16_H4).directional().diagonallyPlaceable().noOcclusion().noCollision().build());
    public static final DeferredHolder<Block, Block> BOOK_STACK = register("book_stack",
            () -> DecorativeBlock.with(BaseBlockProperty.paper()).shaped(BlockShapes.S16_H4).directional().noOcclusion().build());
    public static final DeferredHolder<Block, Block> PAPER = register("paper",
            () -> DecorativeBlock.with(BaseBlockProperty.paper()).shaped(BlockShapes.S16_H1).directional().diagonallyPlaceable().noOcclusion().noCollision().build());
    public static final DeferredHolder<Block, Block> BLUE_BOOK = register("blue_book",
            () -> DecorativeBlock.with(BaseBlockProperty.paper()).shaped(BlockShapes.S16_H2).directional().noOcclusion().noCollision().build());
    public static final DeferredHolder<Block, Block> BAMBOO_SLIPS = register("bamboo_slips",
            () -> DecorativeBlock.with(BaseBlockProperty.silk()).shaped(ShapeFunction.eightRotations(new RawVoxelShape(7, 0, 2, 14, 6, 14))).directional().diagonallyPlaceable().noCollision().noOcclusion().build());

    // ROOM DECO

    public static final DeferredHolder<Block, Block> BACK_CUSHION = register("back_cushion",
            () -> DecorativeBlock.with(BaseBlockProperty.silk()).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(2, 0, 7, 14, 13, 16))).directional().noCollision().noOcclusion().noFenceConnect().build());
    public static final DeferredHolder<Block, Block> CHESSBOARD = register("chessboard",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.diagonalSquare(32, 1)).directional().diagonallyPlaceable().noCollision().noOcclusion().build());
    public static final DeferredHolder<Block, Block> BLUE_AND_WHITE_PORCELAIN_VASE = register("blue_and_white_porcelain_vase",
            () -> DecorativeBlock.with(BaseBlockProperty.porcelain()).shaped(ShapeFunction.or(ShapeFunction.diagonalSquare(8, 7), ShapeFunction.diagonalSquare(5, 14))).diagonallyPlaceable().build());
    public static final DeferredHolder<Block, Block> LARGE_BLUE_AND_WHITE_PORCELAIN_VASE = register("large_blue_and_white_porcelain_vase",
            () -> DecorativeBlock.with(BaseBlockProperty.porcelain()).shaped(ShapeFunction.centeredSquare(12, 28)).directional().build());
    public static final DeferredHolder<Block, Block> SHORT_BLUE_AND_WHITE_PORCELAIN_POT = register("short_blue_and_white_porcelain_pot",
            () -> DecorativeBlock.with(BaseBlockProperty.porcelain()).shaped(ShapeFunction.centeredSquare(10, 10)).build());
    public static final DeferredHolder<Block, Block> TALL_BLUE_AND_WHITE_PORCELAIN_POT = register("tall_blue_and_white_porcelain_pot",
            () -> DecorativeBlock.with(BaseBlockProperty.porcelain()).shaped(ShapeFunction.diagonalSquare(6, 13)).directional().diagonallyPlaceable().build());
    public static final DeferredHolder<Block, Block> BLUE_AND_WHITE_PORCELAIN_BOWL = register("blue_and_white_porcelain_bowl",
            () -> DecorativeBlock.with(BaseBlockProperty.porcelain()).shaped(ShapeFunction.diagonalSquare(10, 6)).diagonallyPlaceable().build());
    public static final DeferredHolder<Block, Block> BRONZE_MIRROR = register("bronze_mirror",
            () -> DecorativeBlock.with(BaseBlockProperty.bronze()).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(0, 0, 11, 16, 18, 13))).directional().build());
    public static final DeferredHolder<Block, Block> MEMORIAL_TABLET = register("memorial_tablet",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.eightRotations(new RawVoxelShape(1, 0, 11, 15, 16, 14), 180)).directional().diagonallyPlaceable().noCollision().noFenceConnect().build());
    public static final DeferredHolder<Block, Block> BRONZE_CENSER = register("bronze_censer",
            () -> new Censer(DecorativeBlock.with(BaseBlockProperty.bronze()).shaped(ShapeFunction.diagonalSquare(10, 8)).directional().diagonallyPlaceable().noOcclusion().luminous(), new Vec3(0.5, 0.7, 0.5)));
    public static final DeferredHolder<Block, Block> ROYAL_CENSER = register("royal_censer",
            () -> new Censer(DecorativeBlock.with(BaseBlockProperty.bronze()).shaped(ShapeFunction.centeredSquare(10, 15)).directional().luminous(), new Vec3(0.5, 0.5, 0.5)));
    public static final DeferredHolder<Block, Block> PORCELAIN_TEAPOT = register("porcelain_teapot",
            () -> DecorativeBlock.with(BaseBlockProperty.porcelain()).shaped(ShapeFunction.centeredSquare(10, 6)).directional().noCollision().build());
    public static final DeferredHolder<Block, Block> BOOTS = register("boots",
            () -> DecorativeBlock.with(BaseBlockProperty.silk()).shaped(ShapeFunction.centeredSquare(14, 8)).directional().noCollision().build());
    public static final DeferredHolder<Block, Block> JADE_PENDANT = register("jade_pendant",
            () -> DecorativeBlock.with(BaseBlockProperty.jade()).shaped(ShapeFunction.diagonalSquare(3, 16)).directional().diagonallyPlaceable().noCollision().build());
    public static final DeferredHolder<Block, Block> IMPERIAL_JADE_SEAL = register("imperial_jade_seal",
            () -> DecorativeBlock.with(BaseBlockProperty.jade()).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(5, 0, 4, 10, 14, 10))).directional().build());
    public static final DeferredHolder<Block, Block> LONG_PILLOW = register("long_pillow",
            () -> DecorativeBlock.with(BaseBlockProperty.silk()).shaped(ShapeFunction.eightRotations(new RawVoxelShape(-4, 0, 4, 20, 8, 12))).directional().diagonallyPlaceable().noOcclusion().build());
    public static final DeferredHolder<Block, Block> WIND_CHIME = register("wind_chime", WindChime::new);

    // MISC OBJECTS

    public static final DeferredHolder<Block, Block> RED_SILK_FABRIC_ROLL = register("red_silk_fabric_roll",
            () -> DecorativeBlock.with(BaseBlockProperty.silk()).shaped(ShapeFunction.eightRotations(new RawVoxelShape(-7, 0, 4, 23, 4, 12))).directional().diagonallyPlaceable().noCollision().noOcclusion().build());
    public static final DeferredHolder<Block, Block> GREEN_SILK_FABRIC_ROLL = register("green_silk_fabric_roll",
            () -> DecorativeBlock.with(BaseBlockProperty.silk()).shaped(ShapeFunction.eightRotations(new RawVoxelShape(-7, 0, 4, 23, 4, 12))).directional().diagonallyPlaceable().noCollision().noOcclusion().build());
    public static final DeferredHolder<Block, Block> PURPLE_SILK_FABRIC_ROLL = register("purple_silk_fabric_roll",
            () -> DecorativeBlock.with(BaseBlockProperty.silk()).shaped(ShapeFunction.eightRotations(new RawVoxelShape(-7, 0, 4, 23, 4, 12))).directional().diagonallyPlaceable().noCollision().noOcclusion().build());
    public static final DeferredHolder<Block, Block> CLAY_DOLL_MALE = register("clay_doll_male",
            () -> DecorativeBlock.with(BaseBlockProperty.terracotta()).shaped(ShapeFunction.diagonalSquare(8, 16)).directional().diagonallyPlaceable().build());
    public static final DeferredHolder<Block, Block> CLAY_DOLL_FEMALE = register("clay_doll_female",
            () -> DecorativeBlock.with(BaseBlockProperty.terracotta()).shaped(ShapeFunction.diagonalSquare(8, 16)).directional().diagonallyPlaceable().build());
    public static final DeferredHolder<Block, Block> BOTTLE_GOURD = register("bottle_gourd",
            () -> new BottleGourd(DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.diagonalSquare(7, 12)).directional().diagonallyPlaceable()));

    // FLOWER POTS

    public static final DeferredHolder<Block, Block> BLUE_AND_WHITE_PORCELAIN_FLOWERPOT = register("blue_and_white_porcelain_flowerpot",
            () -> DecorativeBlock.with(BaseBlockProperty.porcelain()).shaped(ShapeFunction.diagonalSquare(10, 17)).diagonallyPlaceable().build());
    public static final DeferredHolder<Block, Block> TERRACOTTA_FLOWERPOT = register("terracotta_flowerpot",
            () -> DecorativeBlock.with(BaseBlockProperty.terracotta()).shaped(ShapeFunction.diagonalSquare(12, 17)).diagonallyPlaceable().noOcclusion().build());
    public static final DeferredHolder<Block, Block> BLACK_IRON_FLOWERPOT = register("black_iron_flowerpot",
            () -> DecorativeBlock.with(BaseBlockProperty.iron()).shaped(ShapeFunction.centeredSquare(8, 8)).directional().build());
    public static final DeferredHolder<Block, Block> BLUE_PORCELAIN_FLOWERPOT = register("blue_porcelain_flowerpot",
            () -> DecorativeBlock.with(BaseBlockProperty.porcelain()).shaped(ShapeFunction.centeredSquare(12, 17)).directional().build());

    // COURTYARD

    public static final DeferredHolder<Block, Block> SACK = register("sack",
            () -> ContainerDecorativeBlock.with(BaseBlockProperty.silk()).content(ContainerType.COMMON_SMALL).shaped(ShapeFunction.centeredSquare(6, 6)).directional().noCollision().build());
    public static final DeferredHolder<Block, Block> BAMBOO_TEA_BASKET = register("bamboo_tea_basket",
            () -> ContainerDecorativeBlock.with(BaseBlockProperty.bamboo_wood()).content(ContainerType.FOOD_REGULAR).shaped(ShapeFunction.eightRotations(new RawVoxelShape(1, 0, 2, 15, 24, 16))).directional().diagonallyPlaceable().noOcclusion().build());
    public static final DeferredHolder<Block, Block> EMPTY_BAMBOO_TEA_BASKET = register("empty_bamboo_tea_basket",
            () -> ContainerDecorativeBlock.with(BaseBlockProperty.bamboo_wood()).content(ContainerType.FOOD_REGULAR).shaped(ShapeFunction.eightRotations(new RawVoxelShape(1, 0, 2, 15, 24, 16))).directional().diagonallyPlaceable().noOcclusion().build());
    public static final DeferredHolder<Block, Block> STRAW_HAT = register("straw_hat",
            () -> DecorativeBlock.with(BaseBlockProperty.flax()).shaped(ShapeFunction.diagonalSquare(14, 5)).diagonallyPlaceable().noCollision().noOcclusion().build());
    public static final DeferredHolder<Block, Block> KNIFE = register("knife",
            () -> DecorativeBlock.with(BaseBlockProperty.iron()).shaped(ShapeFunction.eightRotations(new RawVoxelShape(6.5, 0, -2.5, 9.5, 1, 18.5))).directional().diagonallyPlaceable().noCollision().noOcclusion().build());
    public static final DeferredHolder<Block, Block> SUNDIAL = register("sundial",
            () -> DecorativeBlock.with(BaseBlockProperty.stone()).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(-3, 0, 4.5, 19, 20, 16))).directional().build());
    public static final DeferredHolder<Block, Block> BROOM = register("broom",
            () -> DecorativeBlock.with(BaseBlockProperty.stone()).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(5, 0, 5, 11, 24, 16.5))).directional().build());
    public static final DeferredHolder<Block, Block> STONE_PEDESTAL = register("stone_pedestal",
            () -> DecorativeBlock.with(BaseBlockProperty.stone()).shaped(ShapeFunction.diagonalSquare(12, 8)).diagonallyPlaceable().noOcclusion().build());
    public static final DeferredHolder<Block, Block> TERRACOTTA_POT = register("terracotta_pot",
            () -> DecorativeBlock.with(BaseBlockProperty.terracotta()).shaped(ShapeFunction.centeredSquare(10, 13)).directional().build());
    public static final DeferredHolder<Block, Block> CHINESE_HERBS_BAG = register("chinese_herbs_bag",
            () -> DecorativeBlock.with(BaseBlockProperty.silk()).shaped(BlockShapes.S16_H8).directional().build());
    public static final DeferredHolder<Block, Block> FRUIT_BOX = register("fruit_box",
            () -> ContainerDecorativeBlock.with(BaseBlockProperty.wood()).content(ContainerType.FOOD_REGULAR).shaped(ShapeFunction.eightRotations(new RawVoxelShape(0, 0, 3, 16, 8, 13))).directional().diagonallyPlaceable().build());
    public static final DeferredHolder<Block, Block> WOODEN_CRATE = register("wooden_crate",
            () -> ContainerDecorativeBlock.with(BaseBlockProperty.wood()).content(ContainerType.COMMON_REGULAR).shaped(BlockShapes.S16_H16).build());
    public static final DeferredHolder<Block, Block> GUNNY_SACK = register("gunny_sack",
            () -> ContainerDecorativeBlock.with(BaseBlockProperty.flax()).content(ContainerType.COMMON_REGULAR).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(3, 0, 2, 15, 13, 14))).directional().build());
    public static final DeferredHolder<Block, Block> BRONZE_DING = register("bronze_ding",
            () -> DecorativeBlock.with(BaseBlockProperty.bronze()).shaped(
                            ShapeFunction.or(ShapeFunction.exclude(ShapeFunction.cardinalRotations(new RawVoxelShape(-7, -3, -7, 23, 16, 23)), ShapeFunction.cardinalRotations(new RawVoxelShape(-4, 1, -4, 20, 16, 20))),/*main shape*/
                                    ShapeFunction.cardinalRotations(new RawVoxelShape(-5, -16, -5, 1, -3, 1)), ShapeFunction.cardinalRotations(new RawVoxelShape(15, -16, -5, 21, -3, 1)),
                                    ShapeFunction.cardinalRotations(new RawVoxelShape(-5, -16, 15, 1, -3, 21)), ShapeFunction.cardinalRotations(new RawVoxelShape(15, -16, 15, 21, -3, 21)), /*legs*/
                                    ShapeFunction.cardinalRotations(new RawVoxelShape(-7, 16, 3, -4, 24, 13)), ShapeFunction.cardinalRotations(new RawVoxelShape(20, 16, 3, 23, 24, 13)))) /*handles*/
                    .placeOffset(Direction.UP).directional().noOcclusion().build());
    public static final DeferredHolder<Block, Block> CARRIAGE = register("carriage",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(
                    ShapeFunction.or(
                            ShapeFunction.cardinalRotations(new RawVoxelShape(-7, 4, 20, 23, 7.5, 16)), ShapeFunction.cardinalRotations(new RawVoxelShape(-7, 5.5, 16, 23, 9, 12)),
                            ShapeFunction.cardinalRotations(new RawVoxelShape(-7, 7, 12, 23, 10.5, 8)), ShapeFunction.cardinalRotations(new RawVoxelShape(-7, 8.5, 8, 23, 12, 4)),
                            ShapeFunction.cardinalRotations(new RawVoxelShape(-7, 10, 4, 23, 13.5, 0)), ShapeFunction.cardinalRotations(new RawVoxelShape(-7, 11.5, 0, 23, 15, -4)),
                            ShapeFunction.cardinalRotations(new RawVoxelShape(-7, 13, -4, 23, 16.5, -8)), ShapeFunction.cardinalRotations(new RawVoxelShape(-7, 14.5, -8, 23, 18, -12)),
                            ShapeFunction.cardinalRotations(new RawVoxelShape(-5, 14.5, -14, 21, 32, -6)),
                            ShapeFunction.cardinalRotations(new RawVoxelShape(19, 4, 20, 21, 21.5, 16)), ShapeFunction.cardinalRotations(new RawVoxelShape(19, 5.5, 16, 21, 23, 12)),
                            ShapeFunction.cardinalRotations(new RawVoxelShape(19, 7, 12, 21, 24.5, 8)), ShapeFunction.cardinalRotations(new RawVoxelShape(19, 8.5, 8, 21, 26, 4)),
                            ShapeFunction.cardinalRotations(new RawVoxelShape(19, 10, 4, 21, 27.5, 0)), ShapeFunction.cardinalRotations(new RawVoxelShape(19, 11.5, 0, 21, 29, -4)),
                            ShapeFunction.cardinalRotations(new RawVoxelShape(19, 13, -4, 21, 30.5, -8)), ShapeFunction.cardinalRotations(new RawVoxelShape(19, 14.5, -8, 21, 32, -12)),
                            ShapeFunction.cardinalRotations(new RawVoxelShape(-5, 4, 20, -3, 21.5, 16)), ShapeFunction.cardinalRotations(new RawVoxelShape(-5, 5.5, 16, -3, 23, 12)),
                            ShapeFunction.cardinalRotations(new RawVoxelShape(-5, 7, 12, -3, 24.5, 8)), ShapeFunction.cardinalRotations(new RawVoxelShape(-5, 8.5, 8, -3, 26, 4)),
                            ShapeFunction.cardinalRotations(new RawVoxelShape(-5, 10, 4, -3, 27.5, 0)), ShapeFunction.cardinalRotations(new RawVoxelShape(-5, 11.5, 0, -3, 29, -4)),
                            ShapeFunction.cardinalRotations(new RawVoxelShape(-5, 13, -4, -3, 30.5, -8)), ShapeFunction.cardinalRotations(new RawVoxelShape(-5, 14.5, -8, -3, 32, -12)),
                            ShapeFunction.cardinalRotations(new RawVoxelShape(-9, 0, -9, -6, 19.5, 12)), ShapeFunction.cardinalRotations(new RawVoxelShape(22, 0, -9, 25, 19.5, 12)))
            ).directional().noOcclusion().build());
    public static final DeferredHolder<Block, Block> WOODEN_POLES = register("wooden_poles",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.or(ShapeFunction.cardinalRotations(new RawVoxelShape(0, -16, 0, 16, 32, 16)), ShapeFunction.cardinalRotations(new RawVoxelShape(0, -16, 16, 16, 0, 32)))).directional().noOcclusion().build());
    public static final DeferredHolder<Block, Block> TEAHOUSE_FLAG = register("teahouse_flag",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.or(ShapeFunction.cardinalRotations(new RawVoxelShape(7, -16, 7, 9, 32, 9)), ShapeFunction.cardinalRotations(new RawVoxelShape(-1.5, 23.5, 6, 17.5, 25, 8)))).placeOffset(Direction.UP).directional().noOcclusion().build());
    public static final DeferredHolder<Block, Block> KNIFE_REST = register("knife_rest",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(-16, 0, 0, 32, 16, 16))).directional().noOcclusion().build());

    // WALL HANGING

    public static final DeferredHolder<Block, Block> LONG_HANGING_PAINTING = register("long_hanging_painting",
            () -> new WallSideBlock(BaseBlockProperty.paper(), ShapeFunction.cardinalRotations(new RawVoxelShape(0, -16, 15, 16, 28, 16))));
    public static final DeferredHolder<Block, Block> WHITE_LANDSCAPE_PAINTING = register("white_landscape_painting",
            () -> new WallSideBlock(BaseBlockProperty.paper(), ShapeFunction.cardinalRotations(new RawVoxelShape(-3, -8, 15, 19, 32, 16))));
    public static final DeferredHolder<Block, Block> HORIZONTAL_OLD_LANDSCAPE_PAINTING = register("horizontal_old_landscape_painting",
            () -> new WallSideBlock(BaseBlockProperty.paper(), ShapeFunction.cardinalRotations(new RawVoxelShape(-12, 0, 15, 28, 16, 16))));
    public static final DeferredHolder<Block, Block> HORIZONTAL_CALLIGRAPHY = register("horizontal_calligraphy",
            () -> new WallSideBlock(BaseBlockProperty.paper(), ShapeFunction.cardinalRotations(new RawVoxelShape(-9, 0, 15, 25, 14, 16))));
    public static final DeferredHolder<Block, Block> HORIZONTAL_LANDSCAPE_PAINTING = register("horizontal_landscape_painting",
            () -> new WallSideBlock(BaseBlockProperty.paper(), ShapeFunction.cardinalRotations(new RawVoxelShape(-16, 0, 14, 32, 32, 16))));
    public static final DeferredHolder<Block, Block> LONG_YELLOW_HANGING_PAINTING = register("long_yellow_hanging_painting",
            () -> new WallSideBlock(BaseBlockProperty.paper(), ShapeFunction.cardinalRotations(new RawVoxelShape(0, -16, 14, 16, 32, 16))));
    public static final DeferredHolder<Block, Block> DAMAGED_LANDSCAPE_PAINTING = register("damaged_landscape_painting",
            () -> new WallSideBlock(BaseBlockProperty.paper(), ShapeFunction.cardinalRotations(new RawVoxelShape(-16, 0, 15, 32, 32, 16))));
    public static final DeferredHolder<Block, Block> PORTRAIT = register("portrait",
            () -> new WallSideBlock(BaseBlockProperty.paper(), ShapeFunction.cardinalRotations(new RawVoxelShape(0, 0, 15, 16, 32, 16))));
    public static final DeferredHolder<Block, Block> HANGING_PAINTING_FAN = register("hanging_painting_fan",
            () -> new WallSideBlock(BaseBlockProperty.paper(), ShapeFunction.cardinalRotations(new RawVoxelShape(-3, 6, 15, 19, 17, 16))));
    public static final DeferredHolder<Block, Block> SINCERE_CALLIGRAPHY = register("sincere_calligraphy",
            () -> new WallSideBlock(BaseBlockProperty.paper(), ShapeFunction.cardinalRotations(new RawVoxelShape(0, 0, 14, 16, 32, 16))));

    // FOOD

    public static final DeferredHolder<Block, Block> FOOD_HAMPER = register("food_hamper",
            () -> ContainerDecorativeBlock.with(BaseBlockProperty.wood()).content(ContainerType.FOOD_LARGE).shaped(ShapeFunction.diagonalSquare(7, 15)).directional().diagonallyPlaceable().build());
    public static final DeferredHolder<Block, Block> PLATED_MOONCAKES = register("plated_mooncakes",
            () -> ConsumableDecorativeBlock.with(BaseBlockProperty.porcelain()).bites(4).platedWith(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PLATE).food(ModFoods.MOONCAKE).shaped(BlockShapes.S16_H1).directional().build());
    public static final DeferredHolder<Block, Block> PLATED_MUNG_BEAN_CAKES = register("plated_mung_bean_cakes",
            () -> ConsumableDecorativeBlock.with(BaseBlockProperty.glazed()).bites(7).platedWith(ItemRegistry.BLACK_PORCELAIN_PLATE).food(ModFoods.MUNG_BEAN_CAKE)
                    .shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(0, 0, 2, 16, 1, 14))).directional().noOcclusion().build());
    public static final DeferredHolder<Block, Block> PLATED_HAM = register("plated_ham",
            () -> ConsumableDecorativeBlock.with(BaseBlockProperty.wood()).bites(4).platedWith(ItemRegistry.POLISHED_OAK_PLANK).food(ModFoods.COOKED_MEAT).shaped(BlockShapes.S16_H1).directional().noOcclusion().build());
    public static final DeferredHolder<Block, Block> PLATED_FISH = register("plated_fish",
            () -> ConsumableDecorativeBlock.with(BaseBlockProperty.wood()).bites(3).platedWith(ItemRegistry.POLISHED_OAK_PLANK).food(ModFoods.FISH).consumable(ModFoods.FISH_CONSUMABLE).shaped(BlockShapes.S16_H1).directional().noOcclusion().build());
    public static final DeferredHolder<Block, Block> SCATTERED_CARROTS = register("scattered_carrots",
            () -> ConsumableDecorativeBlock.with(BaseBlockProperty.crop()).bites(2).platedWith(ItemRegistry.POLISHED_OAK_PLANK).food(Foods.CARROT)
                    .whenFinished((pState, pLevel, pPos, pPlayer) -> {
                        pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                        pLevel.gameEvent(pPlayer, GameEvent.BLOCK_DESTROY, pPos);
                    })
                    .shaped(BlockShapes.S16_H4).directional().noOcclusion().build());
    public static final DeferredHolder<Block, Block> WINE_POT = register("wine_pot",
            () -> DecorativeBlock.with(BaseBlockProperty.porcelain()).shaped(ShapeFunction.centeredSquare(6, 17)).directional().build());
    public static final DeferredHolder<Block, Block> XIAOLONGBAO = register("xiaolongbao",
            () -> ConsumableDecorativeBlock.with(BaseBlockProperty.bamboo()).bites(8).platedWith(ItemRegistry.BAMBOO_MAT_SLAB).food(ModFoods.BAOZI)
                    //.whenFinished((pState, pLevel, pPos, pPlayer) -> {pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL); pLevel.gameEvent(pPlayer, GameEvent.BLOCK_DESTROY, pPos);})
                    .shaped(ShapeFunction.of(state -> state.getValue(ModBlockStateProperties.BITES) <= 4 ? Block.box(0, 0, 0, 16, 8, 16) : BlockShapes.S16_H16.apply(state))).noOcclusion().directional().build());

    // ICE

    public static final DeferredHolder<Block, Block> ICICLE = register("icicle", () -> new Icicle(3));
    public static final DeferredHolder<Block, Block> LARGE_ICICLE = register("large_icicle", () -> new Icicle(2, ShapeFunction.cardinalRotations(new RawVoxelShape(0, 0, 15, 16, 32, 16))));

    // CELEBRATION

    public static final DeferredHolder<Block, Block> COUPLET = register("couplet", () -> new OrientableWallSideBlock(BaseBlockProperty.paper(), ShapeFunction.sideOrientedShape(new RawVoxelShape(2, 0, 15, 8, 32, 16))));
    public static final DeferredHolder<Block, Block> COUPLET_TOP = register("couplet_top", () -> new WallSideBlock(BaseBlockProperty.paper(), ShapeFunction.cardinalRotations(new RawVoxelShape(6, 2, 15, 26, 8, 16))));
    public static final DeferredHolder<Block, Block> FU_MARK = register("fu_mark", () -> new WallSideBlock(BaseBlockProperty.paper(), ShapeFunction.cardinalRotations(new RawVoxelShape(9, 7, 15, 23, 21, 16))));

    /**
     * FURNITURE
     */

    // CABINET

    public static final DeferredHolder<Block, Block> OAK_CABINET = register("oak_cabinet",
            () -> ContainerDecorativeBlock.with(BaseBlockProperty.wood()).content(ContainerType.COMMON_REGULAR).shaped(
                            ShapeFunction.or(ShapeFunction.cardinalRotations(new RawVoxelShape(-1.5, 0, 2, 17.5, 14, 14)), ShapeFunction.cardinalRotations(new RawVoxelShape(-2.5, 14, 1, 18.5, 16, 15))))
                    .directional().noFenceConnect().build());
    public static final DeferredHolder<Block, Block> WARPED_CABINET = register("warped_cabinet",
            () -> ContainerDecorativeBlock.with(BaseBlockProperty.wood()).content(ContainerType.COMMON_REGULAR).shaped(
                            ShapeFunction.or(ShapeFunction.cardinalRotations(new RawVoxelShape(-4.5, 0, 3, 20.5, 14, 13)), ShapeFunction.cardinalRotations(new RawVoxelShape(-8, 14, 1, 24, 16, 15))))
                    .directional().noFenceConnect().build());
    public static final DeferredHolder<Block, Block> EBONY_CABINET = register("ebony_cabinet",
            () -> ContainerDecorativeBlock.with(BaseBlockProperty.wood()).content(ContainerType.COMMON_LARGE).shaped(
                            ShapeFunction.or(ShapeFunction.cardinalRotations(new RawVoxelShape(-6, 0, 0, 22, 30, 16)), ShapeFunction.cardinalRotations(new RawVoxelShape(-7, 30, -1, 23, 32, 17))))
                    .directional().noOcclusion().noFenceConnect().build());

    // TABLE

    public static final DeferredHolder<Block, Block> LARGE_TEA_TABLE = register("large_tea_table",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(-12, 0, -3, 28, 8, 19))).directional().noOcclusion().build());
    public static final DeferredHolder<Block, Block> CHESS_TABLE = register("chess_table",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.centeredSquare(32, 4)).directional().diagonallyPlaceable().build());
    public static final DeferredHolder<Block, Block> HIGH_TABLE_WITH_WHITE_TOP = register("high_table_with_white_top",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.centeredSquare(12, 32)).directional().build());
    public static final DeferredHolder<Block, Block> CENSER_TABLE = register("censer_table",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.or(
                            ShapeFunction.diagonal(new RawVoxelShape(4, 0, 4, 12, 2, 12)), ShapeFunction.diagonal(new RawVoxelShape(2, 2, 2, 14, 28, 14)), ShapeFunction.diagonal(new RawVoxelShape(3, 28, 3, 13, 32, 13))))
                    .directional().diagonallyPlaceable().build());
    public static final DeferredHolder<Block, Block> PORCELAIN_INLAID_TABLE = register("porcelain_inlaid_table",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(BlockShapes.S16_H16).directional().noOcclusion().noFenceConnect().build());
    public static final DeferredHolder<Block, Block> SMALL_TABLE = register("small_table",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.diagonalSquare(11, 16)).directional().diagonallyPlaceable().build());
    public static final DeferredHolder<Block, Block> SMALL_EBONY_TABLE = register("small_ebony_table",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.centeredSquare(13, 16)).directional().build());
    public static final DeferredHolder<Block, Block> LARGE_TABLE = register("large_table",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.centeredSquare(48, 16)).directional().noOcclusion().build());
    public static final DeferredHolder<Block, Block> LONG_TABLE = register("long_table",
            () -> new LongTableBlock(BaseBlockProperty.wood()));

    // CHAIR

    public static final DeferredHolder<Block, Block> EBONY_CHAIR = register("ebony_chair",
            () -> SeatDecorativeBlock.with(BaseBlockProperty.wood()).seatOffset(new Vec3(0.0f, -0.1f, 0.0f)).shaped(ShapeFunction.diagonalSquare(12, 9)).directional().noOcclusion().diagonallyPlaceable().build());
    public static final DeferredHolder<Block, Block> CHAIR_WITH_YELLOW_CUSHION = register("chair_with_yellow_cushion",
            () -> SeatDecorativeBlock.with(BaseBlockProperty.wood()).seatOffset(new Vec3(0.0f, -0.1f, 0.0f)).shaped(ShapeFunction.centeredSquare(13, 8)).directional().build());
    public static final DeferredHolder<Block, Block> PAINTED_CHAIR = register("painted_chair",
            () -> SeatDecorativeBlock.with(BaseBlockProperty.wood()).seatOffset(new Vec3(0.0f, -0.1f, 0.0f)).shaped(ShapeFunction.centeredSquare(18, 10)).directional().build());
    public static final DeferredHolder<Block, Block> WOODEN_STOOL = register("wooden_stool",
            () -> SeatDecorativeBlock.with(BaseBlockProperty.wood()).seatOffset(new Vec3(0.0f, -0.1f, 0.0f)).shaped(ShapeFunction.centeredSquare(16, 12)).directional().noOcclusion().build());
    public static final DeferredHolder<Block, Block> PORCELAIN_INLAID_GRAND_CHAIR = register("porcelain_inlaid_grand_chair",
            () -> SeatDecorativeBlock.with(BaseBlockProperty.wood()).seatOffset(new Vec3(0.0f, -0.1f, 0.0f)).shaped(ShapeFunction.centeredSquare(16, 12)).directional().noOcclusion().build());
    public static final DeferredHolder<Block, Block> YELLOW_CUSHION = register("yellow_cushion",
            () -> SeatDecorativeBlock.with(BaseBlockProperty.silk()).seatOffset(new Vec3(0.0f, -0.5f, 0.0f)).shaped(ShapeFunction.eightRotations(new RawVoxelShape(2, 0, 1.5, 14, 4, 13.5))).directional().diagonallyPlaceable().noOcclusion().build());
    public static final DeferredHolder<Block, Block> OAK_BED = register("oak_bed",
            () -> SeatDecorativeBlock.with(BaseBlockProperty.wood()).seatOffset(new Vec3(0.0f, -0.1f, 0.0f)).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(-8, 0, 0, 24, 8, 16))).directional().noOcclusion().build());
    public static final DeferredHolder<Block, Block> EBONY_BED = register("ebony_bed",
            () -> SeatDecorativeBlock.with(BaseBlockProperty.wood()).seatOffset(new Vec3(0.0f, 0.1f, 0.0f)).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(-15, 0, -1, 31, 13, 17))).directional().build());

    // SCREEN

    public static final DeferredHolder<Block, Block> LARGE_LANDSCAPE_PAINTING_SCREEN = register("large_landscape_painting_screen", //todo texture uv cleanup
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(
                            ShapeFunction.or(ShapeFunction.cardinalRotations(new RawVoxelShape(-16, -16, 6, 32, -9, 10)), ShapeFunction.cardinalRotations(new RawVoxelShape(-13, -16, 3, -9, -9, 13)), ShapeFunction.cardinalRotations(new RawVoxelShape(25, -16, 3, 29, -9, 13)),
                                    ShapeFunction.cardinalRotations(new RawVoxelShape(-12, -9, 7, 28, 13, 9)), ShapeFunction.cardinalRotations(new RawVoxelShape(-15, 13, 7, 31, 19, 9)), ShapeFunction.cardinalRotations(new RawVoxelShape(-10, 19, 7, 26, 26, 9))))
                    .placeOffset(Direction.UP).directional().build());
    public static final DeferredHolder<Block, Block> PAINTED_SCREEN = register("painted_screen",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(
                            ShapeFunction.or(ShapeFunction.cardinalRotations(new RawVoxelShape(-5.5, -16, 0, -2.5, -12, 16)), ShapeFunction.cardinalRotations(new RawVoxelShape(18.5, -16, 0, 21.5, -12, 16)),
                                    ShapeFunction.cardinalRotations(new RawVoxelShape(-6, -12, 7, 22, 5, 9)), ShapeFunction.cardinalRotations(new RawVoxelShape(-3, 5, 7, 19, 32, 9))))
                    .placeOffset(Direction.UP).directional().build());

    /**
     * DOOR AND WINDOW
     */

    // DOOR

    public static final DeferredHolder<Block, Block> CARVED_WOODEN_DOOR = register("carved_wooden_door",
            () -> new OpeningBlock(DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(0, -16, 7, 16, 32, 9))).directional().noOcclusion()));
    public static final DeferredHolder<Block, Block> SONG_WOODEN_DOOR = register("song_wooden_door",
            () -> new OpeningBlock(DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(0, -16, 7, 16, 32, 9))).directional().noOcclusion()));

    // WINDOW

    public static final DeferredHolder<Block, Block> SONG_WOODEN_WINDOW = register("song_wooden_window",
            () -> new OpeningBlock(DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(0, 0, 7, 16, 32, 9))).directional().noOcclusion()));
    public static final DeferredHolder<Block, Block> ROYAL_ROSEWOOD_WINDOW = register("royal_rosewood_window",
            () -> new OpeningBlock(DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(0, 0, 7, 16, 16, 9))).directional().noOcclusion()));
    public static final DeferredHolder<Block, Block> TALL_ROYAL_ROSEWOOD_WINDOW = register("tall_royal_rosewood_window",
            () -> new OpeningBlock(DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(0, 0, 7, 16, 32, 9))).directional().noOcclusion()));
    public static final DeferredHolder<Block, Block> GLAZED_TILE_GRID_WINDOW = register("glazed_tile_grid_window",
            () -> new DecorativeBlock(DecorativeBlock.with(BaseBlockProperty.glazed()).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(-16, -16, -2, 32, 32, 18))).directional().noOcclusion()));
    public static final DeferredHolder<Block, Block> STONE_FLOWER_WINDOW = register("stone_flower_window", () -> new BaseBlock(BaseBlockProperty.iron()));

    // DOOR DECO

    public static final DeferredHolder<Block, Block> KNOCKER = register("knocker",
            () -> new WallSideBlock(BaseBlockProperty.copper(), ShapeFunction.cardinalRotations(new RawVoxelShape(4, 4, 14, 12, 13, 16))));
    public static final DeferredHolder<Block, Block> ROSEWOOD_PANEL = register("rosewood_panel",
            () -> new SixSideBlock(BaseBlockProperty.wood(), 3));
    public static final DeferredHolder<Block, Block> ROSEWOOD_DOOR_PANEL = register("rosewood_door_panel",
            () -> new SixSideBlock(BaseBlockProperty.wood(), 3));
    public static final DeferredHolder<Block, Block> LARGE_ROSEWOOD_PANEL = register("large_rosewood_panel",
            () -> new OrientableSixSideBlock(BaseBlockProperty.wood(), 3));
    public static final DeferredHolder<Block, Block> LARGE_ROSEWOOD_PANEL_EDGE = register("large_rosewood_panel_edge",
            () -> new OrientableSixSideBlock(BaseBlockProperty.wood(), 3));
    public static final DeferredHolder<Block, Block> CARVED_WOODEN_DOOR_PANEL = register("carved_wooden_door_panel",
            () -> new OpeningBlock(DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(0, 0, 7, 16, 16, 9))).directional().noOcclusion()));
    public static final DeferredHolder<Block, Block> PLAQUE = register("plaque",
            () -> new DecorativeBlock(DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(-16, 0, 7, 32, 15, 15))).directional().noOcclusion()));
    public static final DeferredHolder<Block, Block> PAPER_STRIP_SEAL = register("paper_strip_seal",
            () -> new WallSideBlock(BaseBlockProperty.paper(), ShapeFunction.cardinalRotations(new RawVoxelShape(7.5, 1.5, 15, 24.5, 18.5, 16))));

    // WINDOW DECO

    public static final DeferredHolder<Block, Block> LARGE_BLUE_CURTAIN = register("large_blue_curtain",
            () -> new WallSideBlock(BaseBlockProperty.silk(), ShapeFunction.cardinalRotations(new RawVoxelShape(-16, 0, 15, 32, 16, 16))));
    public static final DeferredHolder<Block, Block> MEDIUM_BLUE_CURTAIN = register("medium_blue_curtain",
            () -> new WallSideBlock(BaseBlockProperty.silk(), ShapeFunction.cardinalRotations(new RawVoxelShape(0, 0, 15, 32, 16, 16))));
    public static final DeferredHolder<Block, Block> SMALL_BLUE_CURTAIN = register("small_blue_curtain",
            () -> new WallSideBlock(BaseBlockProperty.silk(), ShapeFunction.cardinalRotations(new RawVoxelShape(0, 0, 15, 16, 16, 16))));
    public static final DeferredHolder<Block, Block> RED_CURTAIN = register("red_curtain",
            () -> new OrientableWallSideBlock(BaseBlockProperty.silk(), ShapeFunction.sideOrientedShape(new RawVoxelShape(0, -16, 14, 32, 16, 15))));
    public static final DeferredHolder<Block, Block> RED_CURTAIN_CORNER = register("red_curtain_corner",
            () -> new OrientableWallSideBlock(BaseBlockProperty.silk(), ShapeFunction.sideOrientedShape(new RawVoxelShape(0, -16, 14, 32, 16, 15))));
    public static final DeferredHolder<Block, Block> BAMBOO_CURTAIN = register("bamboo_curtain",
            () -> new DecorativeBlock(DecorativeBlock.with(BaseBlockProperty.bamboo_wood()).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(0, 2, 7, 16, 16, 9))).directional().noOcclusion()));

    /**
     * PLANTS
     */

    // LOTUS


    public static final DeferredHolder<Block, Block> SMALL_LOTUS_LEAF = register("small_lotus_leaf",
            () -> new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.lily()).shaped(BlockShapes.S16_H1).directional().diagonallyPlaceable().noCollision().noOcclusion()));
    public static final DeferredHolder<Block, Block> SMALL_DARK_GREEN_LOTUS_LEAF = register("small_dark_green_lotus_leaf",
            () -> new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.lily()).shaped(BlockShapes.S16_H1).directional().diagonallyPlaceable().noCollision().noOcclusion()));
    public static final DeferredHolder<Block, Block> MEDIUM_LOTUS_LEAF = register("medium_lotus_leaf",
            () -> new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.lily()).shaped(ShapeFunction.centeredSquare(24, 1)).directional().diagonallyPlaceable().noCollision().noOcclusion()));
    public static final DeferredHolder<Block, Block> LARGE_LOTUS_LEAF = register("large_lotus_leaf",
            () -> new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.lily()).shaped(ShapeFunction.centeredSquare(32, 1)).directional().diagonallyPlaceable().noCollision().noOcclusion()));
    public static final DeferredHolder<Block, Block> TILTED_LOTUS_LEAF = register("tilted_lotus_leaf",
            () -> new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.lily()).shaped(ShapeFunction.centeredSquare(32, 16)).directional().noCollision().noOcclusion()));
    public static final DeferredHolder<Block, Block> SMALL_LOTUS_LEAF_CLUSTER = register("small_lotus_leaf_cluster",
            () -> new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.lily()).shaped(BlockShapes.S16_H1).directional().diagonallyPlaceable().noCollision().noOcclusion()));
    public static final DeferredHolder<Block, Block> MEDIUM_LOTUS_LEAF_CLUSTER = register("medium_lotus_leaf_cluster",
            () -> new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.lily()).shaped(ShapeFunction.centeredSquare(32, 1)).directional().diagonallyPlaceable().noCollision().noOcclusion()));
    public static final DeferredHolder<Block, Block> LOTUS_BUD = register("lotus_bud",
            () -> new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.lily()).shaped(ShapeFunction.centeredSquare(8, 30)).directional().noCollision().noOcclusion()));
    public static final DeferredHolder<Block, Block> MEDIUM_LOTUS = register("medium_lotus",
            () -> new AquaticPlantBlock(DecorativeBlock.with(BaseBlockProperty.lily()).shaped(ShapeFunction.centeredSquare(42, 30)).directional().noCollision().noOcclusion()));

    // IVY

    public static final DeferredHolder<Block, Block> SMALL_RED_IVY = register("small_red_ivy",
            () -> new WallSideBlock(BaseBlockProperty.plant(), ShapeFunction.sideShape(1)));
    public static final DeferredHolder<Block, Block> MEDIUM_RED_IVY = register("medium_red_ivy",
            () -> new WallSideBlock(BaseBlockProperty.plant(), ShapeFunction.cardinalRotations(new RawVoxelShape(0, -16, 15, 16, 16, 16))));
    public static final DeferredHolder<Block, Block> LARGE_RED_IVY = register("large_red_ivy",
            () -> new WallSideBlock(BaseBlockProperty.plant(), ShapeFunction.cardinalRotations(new RawVoxelShape(0, -16, 15, 16, 32, 16))));
    public static final DeferredHolder<Block, Block> SMALL_YELLOW_IVY = register("small_yellow_ivy",
            () -> new WallSideBlock(BaseBlockProperty.plant(), ShapeFunction.sideShape(1)));
    public static final DeferredHolder<Block, Block> MEDIUM_YELLOW_IVY = register("medium_yellow_ivy",
            () -> new WallSideBlock(BaseBlockProperty.plant(), ShapeFunction.cardinalRotations(new RawVoxelShape(0, -16, 15, 16, 16, 16))));
    public static final DeferredHolder<Block, Block> LARGE_YELLOW_IVY = register("large_yellow_ivy",
            () -> new WallSideBlock(BaseBlockProperty.plant(), ShapeFunction.cardinalRotations(new RawVoxelShape(0, -16, 15, 16, 32, 16))));
    public static final DeferredHolder<Block, Block> SMALL_GREEN_IVY = register("small_green_ivy",
            () -> new WallSideBlock(BaseBlockProperty.plant(), ShapeFunction.sideShape(1)));
    public static final DeferredHolder<Block, Block> MEDIUM_GREEN_IVY = register("medium_green_ivy",
            () -> new WallSideBlock(BaseBlockProperty.plant(), ShapeFunction.cardinalRotations(new RawVoxelShape(0, -16, 15, 16, 16, 16))));
    public static final DeferredHolder<Block, Block> LARGE_GREEN_IVY = register("large_green_ivy",
            () -> new WallSideBlock(BaseBlockProperty.plant(), ShapeFunction.cardinalRotations(new RawVoxelShape(0, -16, 15, 16, 32, 16))));

    // LEAVES

    public static final DeferredHolder<Block, Block> SMALL_LEAF_PILE = register("small_leaf_pile",
            () -> DecorativeBlock.with(BaseBlockProperty.plant()).shaped(BlockShapes.S16_H1).directional().noCollision().noOcclusion().build());
    public static final DeferredHolder<Block, Block> MEDIUM_LEAF_PILE = register("medium_leaf_pile",
            () -> DecorativeBlock.with(BaseBlockProperty.plant()).shaped(BlockShapes.S16_H1).directional().noCollision().noOcclusion().build());
    public static final DeferredHolder<Block, Block> LARGE_LEAF_PILE = register("large_leaf_pile",
            () -> DecorativeBlock.with(BaseBlockProperty.plant()).shaped(BlockShapes.S16_H1).directional().noCollision().noOcclusion().build());

    // BONSAI

    public static final DeferredHolder<Block, Block> SMALL_GREETING_PINE_BONSAI = register("small_greeting_pine_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.terracotta()).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(3, 0, 4, 13, 3, 12))).directional().build());
    public static final DeferredHolder<Block, Block> MEDIUM_GREETING_PINE_BONSAI = register("medium_greeting_pine_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.terracotta()).shaped(ShapeFunction.centeredSquare(10, 4)).directional().noOcclusion().build());
    public static final DeferredHolder<Block, Block> LARGE_GREETING_PINE_BONSAI = register("large_greeting_pine_bonsai", //todo model z-fighting
            () -> DecorativeBlock.with(BaseBlockProperty.terracotta()).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(4, -16, 5, 12, 11, 13))).directional().placeOffset(Direction.UP).noOcclusion().build());
    public static final DeferredHolder<Block, Block> SMALL_WHITE_PORCELAIN_VASE_BONSAI = register("small_white_porcelain_vase_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.porcelain()).shaped(ShapeFunction.diagonalSquare(6, 5)).directional().diagonallyPlaceable().build());
    public static final DeferredHolder<Block, Block> MEDIUM_WHITE_PORCELAIN_VASE_BONSAI = register("medium_white_porcelain_vase_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.porcelain()).shaped(ShapeFunction.diagonalSquare(9f, 6.5f)).directional().diagonallyPlaceable().build());
    public static final DeferredHolder<Block, Block> LARGE_WHITE_PORCELAIN_VASE_BONSAI = register("large_white_porcelain_vase_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.porcelain()).shaped(ShapeFunction.or(ShapeFunction.diagonalSquare(9f, 6.5f), ShapeFunction.diagonalSquare(5, 14.5f))).directional().diagonallyPlaceable().noOcclusion().build());
    public static final DeferredHolder<Block, Block> SMALL_GREEN_PORCELAIN_VASE_BONSAI = register("small_green_porcelain_vase_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.porcelain()).shaped(ShapeFunction.centeredSquare(10, 9)).directional().build());
    public static final DeferredHolder<Block, Block> GREEN_PORCELAIN_VASE_BONSAI = register("green_porcelain_vase_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.porcelain()).shaped(ShapeFunction.or(ShapeFunction.diagonalSquare(7, 6), ShapeFunction.diagonalSquare(5, 8), ShapeFunction.diagonalSquare(3.5f, 12.5f))).directional().diagonallyPlaceable().build());
    public static final DeferredHolder<Block, Block> RED_CORAL_BONSAI = register("red_coral_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.terracotta()).shaped(ShapeFunction.centeredSquare(10, 4)).directional().build());
    public static final DeferredHolder<Block, Block> RED_PLUM_BONSAI = register("red_plum_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.terracotta()).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(3, 0, 4, 13, 2, 12))).directional().build());
    public static final DeferredHolder<Block, Block> BAMBOO_BONSAI = register("bamboo_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.terracotta()).shaped(ShapeFunction.cardinalRotations(new RawVoxelShape(2, 0, 4, 14, 3, 12))).directional().noOcclusion().build()); //todo fix z-fighting
    public static final DeferredHolder<Block, Block> TALL_BLUE_VASE_BONSAI = register("tall_blue_vase_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.porcelain()).shaped(
                            ShapeFunction.or(ShapeFunction.diagonal(new RawVoxelShape(4, -16, 4, 12, -13, 12)), ShapeFunction.diagonal(new RawVoxelShape(5.5, -16, 5.5, 10.5, 5, 10.5)),
                                    ShapeFunction.diagonal(new RawVoxelShape(4.5, -16, 4.5, 11.5, 3, 11.5))))
                    .directional().diagonallyPlaceable().placeOffset(Direction.UP).build());
    public static final DeferredHolder<Block, Block> TALL_BLUE_AND_WHITE_PORCELAIN_BONSAI = register("tall_blue_and_white_porcelain_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.porcelain()).shaped(ShapeFunction.or(ShapeFunction.diagonalSquare(6, 6), ShapeFunction.diagonalSquare(4, 7.5f), ShapeFunction.diagonalSquare(3, 12))).directional().diagonallyPlaceable().noOcclusion().build());
    public static final DeferredHolder<Block, Block> MEDIUM_BONSAI = register("medium_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.terracotta()).shaped(ShapeFunction.or(ShapeFunction.diagonal(new RawVoxelShape(5, 0, 5, 11, 6, 11)), ShapeFunction.diagonal(new RawVoxelShape(4, 6, 4, 12, 12, 12)))).directional().diagonallyPlaceable().noOcclusion().build());
    public static final DeferredHolder<Block, Block> LARGE_BONSAI = register("large_bonsai",
            () -> DecorativeBlock.with(BaseBlockProperty.terracotta()).shaped(ShapeFunction.or(ShapeFunction.diagonal(new RawVoxelShape(4, 0, 4, 12, 8, 12)), ShapeFunction.diagonal(new RawVoxelShape(3, 8, 3, 13, 15, 13)))).directional().diagonallyPlaceable().noOcclusion().build());

    /**
     * LAMPS
     */

    //LANTERN

    public static final DeferredHolder<Block, Block> OCTAGONAL_PALACE_LANTERN = register("octagonal_palace_lantern",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(
                            ShapeFunction.or(ShapeFunction.simpleShape(new RawVoxelShape(2.5, 4.5, 2.5, 13.5, 18, 13.5)), ShapeFunction.simpleShape(new RawVoxelShape(0, 18, 0, 16, 25, 16))))
                    .luminous().noOcclusion().placeOffset(Direction.DOWN).build());
    public static final DeferredHolder<Block, Block> SQUARE_PALACE_LANTERN = register("square_palace_lantern",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(
                    ShapeFunction.or(ShapeFunction.diagonal(new RawVoxelShape(2, -8.5, 2, 14, 6, 14)), ShapeFunction.diagonal(new RawVoxelShape(0, 6, 0, 16, 11.5, 16)))).diagonallyPlaceable().luminous().noOcclusion().build());
    public static final DeferredHolder<Block, Block> SMALL_RED_LANTERN = register("small_red_lantern",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.diagonalSquare(10, 10)).diagonallyPlaceable().luminous().build());
    public static final DeferredHolder<Block, Block> WHITE_SKY_LANTERN = register("white_sky_lantern",
            () -> DecorativeBlock.with(BaseBlockProperty.bamboo()).shaped(ShapeFunction.centeredSquare(16, 24)).luminous().noOcclusion().build());
    public static final DeferredHolder<Block, Block> RED_SKY_LANTERN = register("red_sky_lantern",
            () -> DecorativeBlock.with(BaseBlockProperty.bamboo()).shaped(ShapeFunction.centeredSquare(16, 24)).luminous().noOcclusion().build());
    public static final DeferredHolder<Block, Block> YELLOW_SKY_LANTERN = register("yellow_sky_lantern",
            () -> DecorativeBlock.with(BaseBlockProperty.bamboo()).shaped(ShapeFunction.centeredSquare(16, 24)).luminous().noOcclusion().build());

    // LAMP

    public static final DeferredHolder<Block, Block> STANDING_LAMP = register("standing_lamp",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(
                            ShapeFunction.or(ShapeFunction.diagonal(new RawVoxelShape(5, 0, 5, 11, 2, 11)), ShapeFunction.diagonal(new RawVoxelShape(7, 2, 7, 9, 21, 9)), ShapeFunction.diagonal(new RawVoxelShape(4, 21, 4, 12, 32, 12))))
                    .diagonallyPlaceable().luminous().noOcclusion().build());
    public static final DeferredHolder<Block, Block> SMALL_STANDING_LAMP = register("small_standing_lamp",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.or(ShapeFunction.diagonal(new RawVoxelShape(7, 0, 7, 9, 5, 9)), ShapeFunction.diagonal(new RawVoxelShape(6, 5, 6, 10, 12, 10)))).diagonallyPlaceable().luminous().build());
    public static final DeferredHolder<Block, Block> STONE_LAMP = register("stone_lamp",
            () -> DecorativeBlock.with(BaseBlockProperty.stone()).shaped(
                            ShapeFunction.or(ShapeFunction.simpleShape(new RawVoxelShape(4, 0, 4, 12, 7, 12)), ShapeFunction.simpleShape(new RawVoxelShape(2, 7, 2, 14, 9, 14)),
                                    ShapeFunction.simpleShape(new RawVoxelShape(4, 9, 4, 12, 16, 12)), ShapeFunction.simpleShape(new RawVoxelShape(0, 16, 0, 16, 21.5, 16))))
                    .luminous().build());

    // STREETLIGHT //todo rewrite collision logic

    public static final DeferredHolder<Block, Block> RED_LANTERN_STREETLIGHT = register("red_lantern_streetlight",
            () -> new HangingLantern(HangingLantern.HangingLanternType.POLE));
    public static final DeferredHolder<Block, Block> HANGING_RED_LANTERN_STREETLIGHT = register("hanging_red_lantern_streetlight",
            () -> new HangingLantern(HangingLantern.HangingLanternType.HANGING));
    public static final DeferredHolder<Block, Block> STREETLIGHT_POLE = register("streetlight_pole",
            () -> DecorativeBlock.with(BaseBlockProperty.wood()).shaped(HangingLantern.POLE_ONLY).directional().noOcclusion().build());

    // CANDLESTICK

    public static final DeferredHolder<Block, Block> RED_CANDLE = register("red_candle",
            () -> new CandleStick(DecorativeBlock.with(BaseBlockProperty.wood()).shaped(ShapeFunction.or(ShapeFunction.diagonalSquare(3.5f, 4), ShapeFunction.diagonalSquare(1.5f, 16)))
                    .directional().diagonallyPlaceable().luminous(), new Vec3(0.5, 1.1, 0.5)));
    public static final DeferredHolder<Block, Block> TRICOLOR_CANDLESTICK = register("tricolor_candlestick",
            () -> new CandleStick(DecorativeBlock.with(BaseBlockProperty.iron()).shaped(
                            ShapeFunction.or(ShapeFunction.diagonal(new RawVoxelShape(5, 0, 5, 11, 2, 11)), ShapeFunction.diagonal(new RawVoxelShape(4, 2, 4, 12, 4, 12)), ShapeFunction.diagonal(new RawVoxelShape(7, 0, 7, 9, 18, 9)),
                                    ShapeFunction.diagonal(new RawVoxelShape(5.5, 9, 5.5, 10.5, 10, 10.5)), ShapeFunction.diagonal(new RawVoxelShape(6.7, 9, 6.7, 9.3, 13, 9.3))))
                    .directional().diagonallyPlaceable().luminous(), new Vec3(0.5, 1.25, 0.5)));
    public static final DeferredHolder<Block, Block> JADE_CANDLESTICK = register("jade_candlestick",
            () -> new CandleStick(DecorativeBlock.with(BaseBlockProperty.jade()).shaped(
                            ShapeFunction.or(ShapeFunction.diagonal(new RawVoxelShape(6, 0, 6, 10, 2, 10)), ShapeFunction.diagonal(new RawVoxelShape(6.5, 2, 6.5, 9.5, 4, 9.5)), ShapeFunction.diagonal(new RawVoxelShape(7.5, 0, 7.5, 8.5, 20, 8.5)),
                                    ShapeFunction.diagonal(new RawVoxelShape(7, 5.5, 7, 9, 7.5, 9)), ShapeFunction.diagonal(new RawVoxelShape(5.5, 9, 5.5, 10.5, 10.5, 10.5)), ShapeFunction.diagonal(new RawVoxelShape(7, 15, 7, 9, 16, 9))))
                    .directional().diagonallyPlaceable().luminous(), new Vec3(0.5, 1.3, 0.5)));

    /**
     * MATERIALS
     */

    public static final DeferredHolder<Block, Block> JADE_ORE = register("jade_ore", () -> new BaseOreBlock(2, 5));
    public static final DeferredHolder<Block, Block> DEEPSLATE_JADE_ORE = register("deepslate_jade_ore", () -> new BaseOreBlock(2, 5));
    public static final DeferredHolder<Block, Block> MAGNESITE_ORE = register("magnesite_ore", () -> new BaseOreBlock(2, 5));
    public static final DeferredHolder<Block, Block> DEEPSLATE_MAGNESITE_ORE = register("deepslate_magnesite_ore", () -> new BaseOreBlock(2, 5));
    public static final DeferredHolder<Block, Block> HEMATITE_ORE = register("hematite_ore", () -> new BaseOreBlock(1, 3));
    public static final DeferredHolder<Block, Block> DEEPSLATE_HEMATITE_ORE = register("deepslate_hematite_ore", () -> new BaseOreBlock(1, 3));
    public static final DeferredHolder<Block, Block> NETHER_COBALT_ORE = register("nether_cobalt_ore", () -> new BaseOreBlock(2, 5));
    public static final DeferredHolder<Block, Block> JADE_BLOCK = register("jade_block", () -> new BaseBlock());
    public static final DeferredHolder<Block, Block> BRONZE_BLOCK = register("bronze_block", () -> new BaseBlock());

    /**
     * TOOLS
     */

    public static final DeferredHolder<Block, Block> WOODWORKING_WORKBENCH = register("woodworking_workbench", WoodworkingWorkBench::new);
    public static final DeferredHolder<Block, Block> BRICK_KILN = register("brick_kiln", BrickKiln::new);
    public static final DeferredHolder<Block, Block> CHISEL_TABLE = register("chisel_table", ChiselTableMedium::new);

    private static <T extends Block> DeferredBlock<T> register(String name, Supplier<? extends T> supplier) {
        return BLOCKS.register(name, key -> {
            ResourceKey<Block> resourceKey = ResourceKey.create(Registries.BLOCK, key);
            return RegistryIdContext.withBlockId(resourceKey, supplier);
        });
    }
}
