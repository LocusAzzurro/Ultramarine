package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.ModCreativeTab;
import com.voxelutopia.ultramarine.data.ModFoods;
import com.voxelutopia.ultramarine.world.item.*;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ultramarine.MOD_ID);

    /**
     *  BUILDING BLOCKS
     */

    // BRICKS

    public static final RegistryObject<Item> CYAN_BRICKS = fromBlock(BlockRegistry.CYAN_BRICKS, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CYAN_BRICK_SLAB = fromBlock(BlockRegistry.CYAN_BRICK_SLAB, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CYAN_BRICK_STAIRS = fromBlock(BlockRegistry.CYAN_BRICK_STAIRS, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CYAN_BRICK_WALL = fromBlock(BlockRegistry.CYAN_BRICK_WALL, ModCreativeTab.BUILDING_BLOCKS);

    public static final RegistryObject<Item> BLACK_BRICKS = fromBlock(BlockRegistry.BLACK_BRICKS, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_BRICK_SLAB = fromBlock(BlockRegistry.BLACK_BRICK_SLAB, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_BRICK_STAIRS = fromBlock(BlockRegistry.BLACK_BRICK_STAIRS, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_BRICK_WALL = fromBlock(BlockRegistry.BLACK_BRICK_WALL, ModCreativeTab.BUILDING_BLOCKS);

    public static final RegistryObject<Item> BROWNISH_RED_STONE_BRICKS = fromBlock(BlockRegistry.BROWNISH_RED_STONE_BRICKS, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BROWNISH_RED_STONE_BRICK_SLAB = fromBlock(BlockRegistry.BROWNISH_RED_STONE_BRICK_SLAB, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BROWNISH_RED_STONE_BRICK_STAIRS = fromBlock(BlockRegistry.BROWNISH_RED_STONE_BRICK_STAIRS, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BROWNISH_RED_STONE_BRICK_WALL = fromBlock(BlockRegistry.BROWNISH_RED_STONE_BRICK_WALL, ModCreativeTab.BUILDING_BLOCKS);

    public static final RegistryObject<Item> WHITE_AND_PINK_MIXED_BRICKS = fromBlock(BlockRegistry.WHITE_AND_PINK_MIXED_BRICKS, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> GREEN_WEATHERED_BRICKS = fromBlock(BlockRegistry.GREEN_WEATHERED_BRICKS, ModCreativeTab.BUILDING_BLOCKS);

    // STONES

    public static final RegistryObject<Item> PALE_YELLOW_STONE = fromBlock(BlockRegistry.PALE_YELLOW_STONE, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> PALE_YELLOW_STONE_SLAB = fromBlock(BlockRegistry.PALE_YELLOW_STONE_SLAB, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> PALE_YELLOW_STONE_STAIRS = fromBlock(BlockRegistry.PALE_YELLOW_STONE_STAIRS, ModCreativeTab.BUILDING_BLOCKS);

    public static final RegistryObject<Item> VARIEGATED_ROCKS = fromBlock(BlockRegistry.VARIEGATED_ROCKS, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> VARIEGATED_ROCK_SLAB = fromBlock(BlockRegistry.VARIEGATED_ROCK_SLAB, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> VARIEGATED_ROCK_STAIRS = fromBlock(BlockRegistry.VARIEGATED_ROCK_STAIRS, ModCreativeTab.BUILDING_BLOCKS);

    public static final RegistryObject<Item> WEATHERED_STONE = fromBlock(BlockRegistry.WEATHERED_STONE, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> WEATHERED_STONE_SLAB = fromBlock(BlockRegistry.WEATHERED_STONE_SLAB, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> WEATHERED_STONE_STAIRS = fromBlock(BlockRegistry.WEATHERED_STONE_STAIRS, ModCreativeTab.BUILDING_BLOCKS);

    public static final RegistryObject<Item> POLISHED_WEATHERED_STONE = fromBlock(BlockRegistry.POLISHED_WEATHERED_STONE, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> POLISHED_WEATHERED_STONE_SLAB = fromBlock(BlockRegistry.POLISHED_WEATHERED_STONE_SLAB, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> POLISHED_WEATHERED_STONE_STAIRS = fromBlock(BlockRegistry.POLISHED_WEATHERED_STONE_STAIRS, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> POLISHED_WEATHERED_STONE_WALL = fromBlock(BlockRegistry.POLISHED_WEATHERED_STONE_WALL, ModCreativeTab.BUILDING_BLOCKS);

    public static final RegistryObject<Item> GREEN_WEATHERED_STONE = fromBlock(BlockRegistry.GREEN_WEATHERED_STONE, ModCreativeTab.BUILDING_BLOCKS);

    // FLOOR TILES

    public static final RegistryObject<Item> LIGHT_CYAN_FLOOR_TILE = fromBlock(BlockRegistry.LIGHT_CYAN_FLOOR_TILE, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> LIGHT_CYAN_FLOOR_TILE_SLAB = fromBlock(BlockRegistry.LIGHT_CYAN_FLOOR_TILE_SLAB, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> LIGHT_CYAN_FLOOR_TILE_STAIRS = fromBlock(BlockRegistry.LIGHT_CYAN_FLOOR_TILE_STAIRS, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> LIGHT_CYAN_FLOOR_TILE_WALL = fromBlock(BlockRegistry.LIGHT_CYAN_FLOOR_TILE_WALL, ModCreativeTab.BUILDING_BLOCKS);

    public static final RegistryObject<Item> CYAN_FLOOR_TILE = fromBlock(BlockRegistry.CYAN_FLOOR_TILE, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CYAN_FLOOR_TILE_SLAB = fromBlock(BlockRegistry.CYAN_FLOOR_TILE_SLAB, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CYAN_FLOOR_TILE_STAIRS = fromBlock(BlockRegistry.CYAN_FLOOR_TILE_STAIRS, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CYAN_FLOOR_TILE_WALL = fromBlock(BlockRegistry.CYAN_FLOOR_TILE_WALL, ModCreativeTab.BUILDING_BLOCKS);

    public static final RegistryObject<Item> DARK_CYAN_FLOOR_TILE = fromBlock(BlockRegistry.DARK_CYAN_FLOOR_TILE, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> LAYERED_CYAN_FLOOR_TILES = fromBlock(BlockRegistry.LAYERED_CYAN_FLOOR_TILES, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> VERTICAL_CYAN_FLOOR_TILES = fromBlock(BlockRegistry.VERTICAL_CYAN_FLOOR_TILES, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> MIXED_CYAN_FLOOR_TILES = fromBlock(BlockRegistry.MIXED_CYAN_FLOOR_TILES, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CHISELED_CYAN_FLOOR_TILE = fromBlock(BlockRegistry.CHISELED_CYAN_FLOOR_TILE, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CUT_CYAN_FLOOR_TILES = fromBlock(BlockRegistry.CUT_CYAN_FLOOR_TILES, ModCreativeTab.BUILDING_BLOCKS);

    public static final RegistryObject<Item> WEATHERED_RED_STONE_TILE = fromBlock(BlockRegistry.WEATHERED_RED_STONE_TILE, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLUE_AND_BLACK_TILE = fromBlock(BlockRegistry.BLUE_AND_BLACK_TILE, ModCreativeTab.BUILDING_BLOCKS);

    public static final RegistryObject<Item> GREEN_GLAZED_TILES = fromBlock(BlockRegistry.GREEN_GLAZED_TILES, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> GREEN_GLAZED_TILE_SLAB = fromBlock(BlockRegistry.GREEN_GLAZED_TILE_SLAB, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> GREEN_GLAZED_TILE_STAIRS = fromBlock(BlockRegistry.GREEN_GLAZED_TILE_STAIRS, ModCreativeTab.BUILDING_BLOCKS);

    public static final RegistryObject<Item> BLACK_FLOOR_TILES = fromBlock(BlockRegistry.BLACK_FLOOR_TILES, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_FLOOR_TILES_LITTLE_MOSSY = fromBlock(BlockRegistry.BLACK_FLOOR_TILES_LITTLE_MOSSY, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_FLOOR_TILES_MODERATE_MOSSY = fromBlock(BlockRegistry.BLACK_FLOOR_TILES_MODERATE_MOSSY, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_FLOOR_TILES_VERY_MOSSY = fromBlock(BlockRegistry.BLACK_FLOOR_TILES_VERY_MOSSY, ModCreativeTab.BUILDING_BLOCKS);

    // WOODEN

    public static final RegistryObject<Item> ROSEWOOD_PLANKS = fromBlock(BlockRegistry.ROSEWOOD_PLANKS, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> ROSEWOOD_SLAB = fromBlock(BlockRegistry.ROSEWOOD_SLAB, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> ROSEWOOD_STAIRS = fromBlock(BlockRegistry.ROSEWOOD_STAIRS, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> ROSEWOOD_FENCE = fromBlock(BlockRegistry.ROSEWOOD_FENCE, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BAMBOO_MAT = fromBlock(BlockRegistry.BAMBOO_MAT, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BAMBOO_MAT_SLAB = fromBlock(BlockRegistry.BAMBOO_MAT_SLAB, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BAMBOO_MAT_STAIRS = fromBlock(BlockRegistry.BAMBOO_MAT_STAIRS, ModCreativeTab.BUILDING_BLOCKS);

    // ROOF TILES

    public static final RegistryObject<Item> GRAY_ROOF_TILES = fromBlock(BlockRegistry.GRAY_ROOF_TILES, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> GRAY_ROOF_TILE_STAIRS = fromBlock(BlockRegistry.GRAY_ROOF_TILE_STAIRS, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> GRAY_ROOF_TILE_EDGE = fromBlock(BlockRegistry.GRAY_ROOF_TILE_EDGE, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> YELLOW_ROOF_TILES = fromBlock(BlockRegistry.YELLOW_ROOF_TILES, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> YELLOW_ROOF_TILE_STAIRS = fromBlock(BlockRegistry.YELLOW_ROOF_TILE_STAIRS, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> YELLOW_ROOF_TILE_EDGE = fromBlock(BlockRegistry.YELLOW_ROOF_TILE_EDGE, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> GREEN_ROOF_TILES = fromBlock(BlockRegistry.GREEN_ROOF_TILES, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> GREEN_ROOF_TILE_STAIRS = fromBlock(BlockRegistry.GREEN_ROOF_TILE_STAIRS, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> GREEN_ROOF_TILE_EDGE = fromBlock(BlockRegistry.GREEN_ROOF_TILE_EDGE, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLUE_ROOF_TILES = fromBlock(BlockRegistry.BLUE_ROOF_TILES, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLUE_ROOF_TILE_STAIRS = fromBlock(BlockRegistry.BLUE_ROOF_TILE_STAIRS, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLUE_ROOF_TILE_EDGE = fromBlock(BlockRegistry.BLUE_ROOF_TILE_EDGE, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CYAN_ROOF_TILES = fromBlock(BlockRegistry.CYAN_ROOF_TILES, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CYAN_ROOF_TILE_STAIRS = fromBlock(BlockRegistry.CYAN_ROOF_TILE_STAIRS, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CYAN_ROOF_TILE_EDGE = fromBlock(BlockRegistry.CYAN_ROOF_TILE_EDGE, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_ROOF_TILES = fromBlock(BlockRegistry.BLACK_ROOF_TILES, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_ROOF_TILE_STAIRS = fromBlock(BlockRegistry.BLACK_ROOF_TILE_STAIRS, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_ROOF_TILE_EDGE = fromBlock(BlockRegistry.BLACK_ROOF_TILE_EDGE, ModCreativeTab.BUILDING_BLOCKS);

    // ROOF RIDGE

    public static final RegistryObject<Item> BLACK_ROOF_RIDGE_UPPER = fromBlock(BlockRegistry.BLACK_ROOF_RIDGE_UPPER, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_ROOF_RIDGE_LOWER = fromBlock(BlockRegistry.BLACK_ROOF_RIDGE_LOWER, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_ROOF_RIDGE_CONNECTION = fromBlock(BlockRegistry.BLACK_ROOF_RIDGE_CONNECTION, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_MAIN_ROOF_RIDGE_CONNECTION = fromBlock(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_CONNECTION, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_ROOF_RIDGE_UPPER_SLAB = fromBlock(BlockRegistry.BLACK_ROOF_RIDGE_UPPER_SLAB, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_MAIN_ROOF_RIDGE_SLAB = fromBlock(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_MAIN_ROOF_RIDGE_PANEL = fromBlock(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_PANEL, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_MAIN_ROOF_RIDGE_PLATE = fromBlock(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_PLATE, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_MAIN_ROOF_RIDGE_STAIRS = fromBlock(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_STAIRS, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> YELLOW_ROOF_RIDGE_UPPER = fromBlock(BlockRegistry.YELLOW_ROOF_RIDGE_UPPER, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> YELLOW_ROOF_RIDGE_LOWER = fromBlock(BlockRegistry.YELLOW_ROOF_RIDGE_LOWER, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> YELLOW_ROOF_RIDGE_CONNECTION = fromBlock(BlockRegistry.YELLOW_ROOF_RIDGE_CONNECTION, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> YELLOW_MAIN_ROOF_RIDGE_CONNECTION = fromBlock(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_CONNECTION, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> YELLOW_ROOF_RIDGE_UPPER_SLAB = fromBlock(BlockRegistry.YELLOW_ROOF_RIDGE_UPPER_SLAB, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> YELLOW_MAIN_ROOF_RIDGE_SLAB = fromBlock(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> YELLOW_MAIN_ROOF_RIDGE_PANEL = fromBlock(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_PANEL, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> YELLOW_MAIN_ROOF_RIDGE_PLATE = fromBlock(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_PLATE, ModCreativeTab.BUILDING_BLOCKS);
    public static final RegistryObject<Item> YELLOW_MAIN_ROOF_RIDGE_STAIRS = fromBlock(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_STAIRS, ModCreativeTab.BUILDING_BLOCKS);

    /**
     *  DECORATIVE BLOCKS
     */

    // SIMPLE CARVED WOOD

    public static final RegistryObject<Item> RED_CARVED_WOOD = fromBlock(BlockRegistry.RED_CARVED_WOOD, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> RED_CARVED_WOODEN_SLAB = fromBlock(BlockRegistry.RED_CARVED_WOODEN_SLAB, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> RED_CARVED_WOODEN_STAIRS = fromBlock(BlockRegistry.RED_CARVED_WOODEN_STAIRS, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_CARVED_WOOD = fromBlock(BlockRegistry.BLUE_CARVED_WOOD, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_CARVED_WOODEN_SLAB = fromBlock(BlockRegistry.BLUE_CARVED_WOODEN_SLAB, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_CARVED_WOODEN_STAIRS = fromBlock(BlockRegistry.BLUE_CARVED_WOODEN_STAIRS, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_CARVED_WOODEN_BRACKET = fromBlock(BlockRegistry.BLUE_CARVED_WOODEN_BRACKET, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_CARVED_WOODEN_BRACKET_STAIRS = fromBlock(BlockRegistry.BLUE_CARVED_WOODEN_BRACKET_STAIRS, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CYAN_CARVED_WOOD = fromBlock(BlockRegistry.CYAN_CARVED_WOOD, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CYAN_CARVED_WOODEN_SLAB = fromBlock(BlockRegistry.CYAN_CARVED_WOODEN_SLAB, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CYAN_CARVED_WOODEN_STAIRS = fromBlock(BlockRegistry.CYAN_CARVED_WOODEN_STAIRS, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CYAN_CARVED_WOODEN_BRACKET = fromBlock(BlockRegistry.CYAN_CARVED_WOODEN_BRACKET, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GREEN_CARVED_WOOD = fromBlock(BlockRegistry.GREEN_CARVED_WOOD, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GREEN_CARVED_WOODEN_SLAB = fromBlock(BlockRegistry.GREEN_CARVED_WOODEN_SLAB, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GREEN_CARVED_WOODEN_STAIRS = fromBlock(BlockRegistry.GREEN_CARVED_WOODEN_STAIRS, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GREEN_CARVED_WOODEN_BRACKET = fromBlock(BlockRegistry.GREEN_CARVED_WOODEN_BRACKET, ModCreativeTab.DECORATIVE_BLOCKS);

    // MIXED CARVED WOOD

    public static final RegistryObject<Item> ORANGE_AND_BLUE_CARVED_WOOD = fromBlock(BlockRegistry.ORANGE_AND_BLUE_CARVED_WOOD, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> ORANGE_AND_GREEN_CARVED_WOOD = fromBlock(BlockRegistry.ORANGE_AND_GREEN_CARVED_WOOD, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GREEN_AND_BLUE_CARVED_WOOD = fromBlock(BlockRegistry.GREEN_AND_BLUE_CARVED_WOOD, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> DARK_GREEN_AND_DARK_BLUE_CARVED_WOOD = fromBlock(BlockRegistry.DARK_GREEN_AND_DARK_BLUE_CARVED_WOOD, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> DARK_BLUE_AND_DARK_GREEN_CARVED_WOOD = fromBlock(BlockRegistry.DARK_BLUE_AND_DARK_GREEN_CARVED_WOOD, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLACK_WHITE_GREEN_CARVED_WOOD = fromBlock(BlockRegistry.BLACK_WHITE_GREEN_CARVED_WOOD, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLACK_WHITE_BLUE_CARVED_WOOD = fromBlock(BlockRegistry.BLACK_WHITE_BLUE_CARVED_WOOD, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> RED_AND_GREEN_CARVED_WOOD = fromBlock(BlockRegistry.RED_AND_GREEN_CARVED_WOOD, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_AND_RED_CARVED_WOOD = fromBlock(BlockRegistry.BLUE_AND_RED_CARVED_WOOD, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_WHITE_RED_CARVED_WOOD = fromBlock(BlockRegistry.BLUE_WHITE_RED_CARVED_WOOD, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GREEN_WHITE_RED_CARVED_WOOD = fromBlock(BlockRegistry.GREEN_WHITE_RED_CARVED_WOOD, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1 = fromBlock(BlockRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2 = fromBlock(BlockRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3 = fromBlock(BlockRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> YELLOW_AND_GREEN_CARVED_WOOD = fromBlock(BlockRegistry.YELLOW_AND_GREEN_CARVED_WOOD, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> YELLOW_GREEN_BLUE_CARVED_WOOD = fromBlock(BlockRegistry.YELLOW_GREEN_BLUE_CARVED_WOOD, ModCreativeTab.DECORATIVE_BLOCKS);

    // DARK OAK

    public static final RegistryObject<Item> CARVED_DARK_OAK_BEAM = fromBlock(BlockRegistry.CARVED_DARK_OAK_BEAM, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CARVED_DARK_OAK_BEAM_EDGE = fromBlock(BlockRegistry.CARVED_DARK_OAK_BEAM_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GILDED_DARK_OAK = fromBlock(BlockRegistry.GILDED_DARK_OAK, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CHISELED_GILDED_DARK_OAK = fromBlock(BlockRegistry.CHISELED_GILDED_DARK_OAK, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GILDED_DARK_OAK_SLAB = fromBlock(BlockRegistry.GILDED_DARK_OAK_SLAB, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GILDED_DARK_OAK_STAIRS = fromBlock(BlockRegistry.GILDED_DARK_OAK_STAIRS, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GILDED_DARK_OAK_BRACKET = fromBlock(BlockRegistry.GILDED_DARK_OAK_BRACKET, ModCreativeTab.DECORATIVE_BLOCKS);

    // PILLARS

    public static final RegistryObject<Item> CARVED_RED_PILLAR = fromBlock(BlockRegistry.CARVED_RED_PILLAR, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CARVED_RED_PILLAR_BASE = fromBlock(BlockRegistry.CARVED_RED_PILLAR_BASE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CARVED_RED_PILLAR_HEAD = fromBlock(BlockRegistry.CARVED_RED_PILLAR_HEAD, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> SPRUCE_PILLAR_BASE = fromBlock(BlockRegistry.SPRUCE_PILLAR_BASE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> STRIPPED_DARK_OAK_PILLAR_BASE = fromBlock(BlockRegistry.STRIPPED_DARK_OAK_PILLAR_BASE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_1 = fromBlock(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_1, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_2 = fromBlock(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_2, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_3 = fromBlock(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_3, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_4 = fromBlock(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_4, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_5 = fromBlock(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_5, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CYAN_AND_WHITE_PILLAR_BASE = fromBlock(BlockRegistry.CYAN_AND_WHITE_PILLAR_BASE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CYAN_AND_WHITE_DECORATED_PILLAR = fromBlock(BlockRegistry.CYAN_AND_WHITE_DECORATED_PILLAR, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CYAN_AND_WHITE_PILLAR_HEAD = fromBlock(BlockRegistry.CYAN_AND_WHITE_PILLAR_HEAD, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> STONE_PILLAR_BASE = fromBlock(BlockRegistry.STONE_PILLAR_BASE, ModCreativeTab.DECORATIVE_BLOCKS);

    // FANGXIN

    public static final RegistryObject<Item> GREEN_FANGXIN = fromBlock(BlockRegistry.GREEN_FANGXIN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GREEN_FANGXIN_EDGE = fromBlock(BlockRegistry.GREEN_FANGXIN_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_FANGXIN = fromBlock(BlockRegistry.BLUE_FANGXIN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_FANGXIN_EDGE = fromBlock(BlockRegistry.BLUE_FANGXIN_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CYAN_AND_BLUE_FANGXIN = fromBlock(BlockRegistry.CYAN_AND_BLUE_FANGXIN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CYAN_AND_BLUE_FANGXIN_EDGE = fromBlock(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CYAN_AND_BLUE_FANGXIN_EDGE_VARIANT = fromBlock(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE_VARIANT, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CYAN_BLUE_WHITE_FANGXIN = fromBlock(BlockRegistry.CYAN_BLUE_WHITE_FANGXIN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CYAN_BLUE_WHITE_FANGXIN_EDGE = fromBlock(BlockRegistry.CYAN_BLUE_WHITE_FANGXIN_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_AND_GREEN_FANGXIN_EDGE = fromBlock(BlockRegistry.BLUE_AND_GREEN_FANGXIN_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> YELLOW_AND_GREEN_FANGXIN_EDGE = fromBlock(BlockRegistry.YELLOW_AND_GREEN_FANGXIN_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> DARK_BLUE_FANGXIN = fromBlock(BlockRegistry.DARK_BLUE_FANGXIN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> DARK_BLUE_FANGXIN_EDGE = fromBlock(BlockRegistry.DARK_BLUE_FANGXIN_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_AND_WHITE_FANGXIN = fromBlock(BlockRegistry.BLUE_AND_WHITE_FANGXIN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GREEN_AND_DARK_BLUE_FANGXIN = fromBlock(BlockRegistry.GREEN_AND_DARK_BLUE_FANGXIN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> WHITE_AND_CYAN_FANGXIN = fromBlock(BlockRegistry.WHITE_AND_CYAN_FANGXIN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> WHITE_AND_CYAN_FANGXIN_EDGE = fromBlock(BlockRegistry.WHITE_AND_CYAN_FANGXIN_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> WHITE_AND_BLUE_FANGXIN = fromBlock(BlockRegistry.WHITE_AND_BLUE_FANGXIN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> WHITE_AND_BLUE_FANGXIN_EDGE = fromBlock(BlockRegistry.WHITE_AND_BLUE_FANGXIN_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> RED_CYAN_BLUE_FANGXIN = fromBlock(BlockRegistry.RED_CYAN_BLUE_FANGXIN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> RED_CYAN_BLUE_FANGXIN_EDGE = fromBlock(BlockRegistry.RED_CYAN_BLUE_FANGXIN_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_CYAN_BLUE_FANGXIN_EDGE = fromBlock(BlockRegistry.BLUE_CYAN_BLUE_FANGXIN_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_CYAN_RED_FANGXIN = fromBlock(BlockRegistry.BLUE_CYAN_RED_FANGXIN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_CYAN_RED_FANGXIN_EDGE = fromBlock(BlockRegistry.BLUE_CYAN_RED_FANGXIN_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CYAN_BLUE_CYAN_FANGXIN = fromBlock(BlockRegistry.CYAN_BLUE_CYAN_FANGXIN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> RED_BLUE_RED_FANGXIN = fromBlock(BlockRegistry.RED_BLUE_RED_FANGXIN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CYAN_AND_YELLOW_FANGXIN_EDGE = fromBlock(BlockRegistry.CYAN_AND_YELLOW_FANGXIN_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);

    // ZHAOTOU

    public static final RegistryObject<Item> BLUE_ZHAOTOU_EDGE = fromBlock(BlockRegistry.BLUE_ZHAOTOU_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GREEN_AND_BLUE_ZHAOTOU = fromBlock(BlockRegistry.GREEN_AND_BLUE_ZHAOTOU, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_AND_GREEN_ZHAOTOU = fromBlock(BlockRegistry.BLUE_AND_GREEN_ZHAOTOU, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_AND_GREEN_DOUBLE_LAYERED_ZHAOTOU = fromBlock(BlockRegistry.BLUE_AND_GREEN_DOUBLE_LAYERED_ZHAOTOU, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CYAN_AND_RED_ZHAOTOU = fromBlock(BlockRegistry.CYAN_AND_RED_ZHAOTOU, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CYAN_AND_BLUE_ZHAOTOU = fromBlock(BlockRegistry.CYAN_AND_BLUE_ZHAOTOU, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GRAY_BLACK_RED_ZHAOTOU = fromBlock(BlockRegistry.GRAY_BLACK_RED_ZHAOTOU, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_GREEN_RED_ZHAOTOU = fromBlock(BlockRegistry.BLUE_GREEN_RED_ZHAOTOU, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> RED_AND_BLUE_ZHAOTOU = fromBlock(BlockRegistry.RED_AND_BLUE_ZHAOTOU, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GREEN_AND_YELLOW_ZHAOTOU = fromBlock(BlockRegistry.GREEN_AND_YELLOW_ZHAOTOU, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> RED_GREEN_BLUE_ZHAOTOU = fromBlock(BlockRegistry.RED_GREEN_BLUE_ZHAOTOU, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> WHITE_BLUE_GREEN_ZHAOTOU = fromBlock(BlockRegistry.WHITE_BLUE_GREEN_ZHAOTOU, ModCreativeTab.DECORATIVE_BLOCKS);

    // GUTOU

    public static final RegistryObject<Item> GREEN_BLUE_BLACK_GUTOU = fromBlock(BlockRegistry.GREEN_BLUE_BLACK_GUTOU, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_GREEN_YELLOW_GUTOU = fromBlock(BlockRegistry.BLUE_GREEN_YELLOW_GUTOU, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_AND_YELLOW_GUTOU = fromBlock(BlockRegistry.BLUE_AND_YELLOW_GUTOU, ModCreativeTab.DECORATIVE_BLOCKS);

    // RAFTERS

    public static final RegistryObject<Item> GILDED_DARK_OAK_RAFTER = fromBlock(BlockRegistry.GILDED_DARK_OAK_RAFTER, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GILDED_DARK_OAK_RAFTER_END = fromBlock(BlockRegistry.GILDED_DARK_OAK_RAFTER_END, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> DARK_OAK_RAFTER = fromBlock(BlockRegistry.DARK_OAK_RAFTER, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> DARK_OAK_RAFTER_END = fromBlock(BlockRegistry.DARK_OAK_RAFTER_END, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_TIGER_EYE_RAFTER = fromBlock(BlockRegistry.BLUE_TIGER_EYE_RAFTER, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_TIGER_EYE_RAFTER_END = fromBlock(BlockRegistry.BLUE_TIGER_EYE_RAFTER_END, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_CARVED_TIGER_EYE_RAFTER = fromBlock(BlockRegistry.BLUE_CARVED_TIGER_EYE_RAFTER, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_CARVED_TIGER_EYE_RAFTER_END = fromBlock(BlockRegistry.BLUE_CARVED_TIGER_EYE_RAFTER_END, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GREEN_CARVED_TIGER_EYE_RAFTER = fromBlock(BlockRegistry.GREEN_CARVED_TIGER_EYE_RAFTER, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GREEN_CARVED_TIGER_EYE_RAFTER_END = fromBlock(BlockRegistry.GREEN_CARVED_TIGER_EYE_RAFTER_END, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GREEN_WANZI_RAFTER = fromBlock(BlockRegistry.GREEN_WANZI_RAFTER, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GREEN_WANZI_RAFTER_END = fromBlock(BlockRegistry.GREEN_WANZI_RAFTER_END, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GREEN_CARVED_WANZI_RAFTER = fromBlock(BlockRegistry.GREEN_CARVED_WANZI_RAFTER, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GREEN_CARVED_WANZI_RAFTER_END = fromBlock(BlockRegistry.GREEN_CARVED_WANZI_RAFTER_END, ModCreativeTab.DECORATIVE_BLOCKS);

    // BEAM HEAD

    public static final RegistryObject<Item> GILDED_DARK_OAK_BEAM_HEAD = fromBlock(BlockRegistry.GILDED_DARK_OAK_BEAM_HEAD, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> QING_GREEN_BEAM_HEAD = fromBlock(BlockRegistry.QING_GREEN_BEAM_HEAD, ModCreativeTab.DECORATIVE_BLOCKS);

    // ARCHITRAVE

    public static final RegistryObject<Item> RED_AND_CYAN_CARVED_ARCHITRAVE = fromBlock(BlockRegistry.RED_AND_CYAN_CARVED_ARCHITRAVE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> RED_AND_CYAN_CARVED_ARCHITRAVE_SLAB = fromBlock(BlockRegistry.RED_AND_CYAN_CARVED_ARCHITRAVE_SLAB, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> RED_AND_BLUE_CARVED_ARCHITRAVE = fromBlock(BlockRegistry.RED_AND_BLUE_CARVED_ARCHITRAVE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> RED_AND_BLUE_CARVED_ARCHITRAVE_SLAB = fromBlock(BlockRegistry.RED_AND_BLUE_CARVED_ARCHITRAVE_SLAB, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> EMPTY_TUANHUA_SLAB = fromBlock(BlockRegistry.EMPTY_TUANHUA_SLAB, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> FULL_TUANHUA_SLAB = fromBlock(BlockRegistry.FULL_TUANHUA_SLAB, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> RED_AND_CYAN_TUANHUA_SLAB = fromBlock(BlockRegistry.RED_AND_CYAN_TUANHUA_SLAB, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> RED_CARVED_ARCHITRAVE = fromBlock(BlockRegistry.RED_CARVED_ARCHITRAVE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> WHITE_AND_RED_SLAB = fromBlock(BlockRegistry.WHITE_AND_RED_SLAB, ModCreativeTab.DECORATIVE_BLOCKS);

    // QUETI

    public static final RegistryObject<Item> LONG_GILDED_DARK_OAK_QUETI = fromBlock(BlockRegistry.LONG_GILDED_DARK_OAK_QUETI, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> LONG_GILDED_DARK_OAK_QUETI_EDGE = fromBlock(BlockRegistry.LONG_GILDED_DARK_OAK_QUETI_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> HORIZONTAL_GILDED_DARK_OAK_QUETI = fromBlock(BlockRegistry.HORIZONTAL_GILDED_DARK_OAK_QUETI, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CENTRAL_GILDED_DARK_OAK_QUETI = fromBlock(BlockRegistry.CENTRAL_GILDED_DARK_OAK_QUETI, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> VERTICAL_GILDED_DARK_OAK_QUETI = fromBlock(BlockRegistry.VERTICAL_GILDED_DARK_OAK_QUETI, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> WOODEN_QUETI = fromBlock(BlockRegistry.WOODEN_QUETI, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> WOODEN_QUETI_EDGE = fromBlock(BlockRegistry.WOODEN_QUETI_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> TALL_WOODEN_QUETI_EDGE = fromBlock(BlockRegistry.TALL_WOODEN_QUETI_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> LARGE_WOODEN_QUETI_EDGE = fromBlock(BlockRegistry.LARGE_WOODEN_QUETI_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> SHORT_GLAZED_QUETI = fromBlock(BlockRegistry.SHORT_GLAZED_QUETI, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> THICK_CARVED_QUETI = fromBlock(BlockRegistry.THICK_CARVED_QUETI, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> SHORT_THICK_GLAZED_QUETI = fromBlock(BlockRegistry.SHORT_THICK_GLAZED_QUETI, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> WOODEN_GUALUO = fromBlock(BlockRegistry.WOODEN_GUALUO, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> LARGE_WOODEN_GUALUO = fromBlock(BlockRegistry.LARGE_WOODEN_GUALUO, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> LARGE_WOODEN_GUALUO_EDGE = fromBlock(BlockRegistry.LARGE_WOODEN_GUALUO_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CARVED_STONE_PANEL = fromBlock(BlockRegistry.CARVED_STONE_PANEL, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CARVED_STONE_PANEL_EDGE = fromBlock(BlockRegistry.CARVED_STONE_PANEL_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CARVED_STONE_PANEL_CENTER = fromBlock(BlockRegistry.CARVED_STONE_PANEL_CENTER, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CARVED_STONE_QUETI_PART = fromBlock(BlockRegistry.CARVED_STONE_QUETI_PART, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CARVED_STONE_BEAM = fromBlock(BlockRegistry.CARVED_STONE_BEAM, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CARVED_STONE_QUETI = fromBlock(BlockRegistry.CARVED_STONE_QUETI, ModCreativeTab.DECORATIVE_BLOCKS);

    // PATTERNS

    public static final RegistryObject<Item> YELLOW_CARVED_PATTERN = fromBlock(BlockRegistry.YELLOW_CARVED_PATTERN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CIRCULAR_YELLOW_CARVED_PATTERN = fromBlock(BlockRegistry.CIRCULAR_YELLOW_CARVED_PATTERN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> YELLOW_CARVED_FANGXIN_EDGE_PATTERN = fromBlock(BlockRegistry.YELLOW_CARVED_FANGXIN_EDGE_PATTERN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> YELLOW_CARVED_FANGXIN_PATTERN = fromBlock(BlockRegistry.YELLOW_CARVED_FANGXIN_PATTERN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> LARGE_YELLOW_CARVED_PATTERN = fromBlock(BlockRegistry.LARGE_YELLOW_CARVED_PATTERN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> MEDIUM_YELLOW_CARVED_PATTERN = fromBlock(BlockRegistry.MEDIUM_YELLOW_CARVED_PATTERN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> YELLOW_CARVED_ZHAOTOU_PATTERN = fromBlock(BlockRegistry.YELLOW_CARVED_ZHAOTOU_PATTERN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> LONG_YELLOW_CARVED_ZHAOTOU_PATTERN = fromBlock(BlockRegistry.LONG_YELLOW_CARVED_ZHAOTOU_PATTERN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CARVED_ZHAOTOU_PATTERN = fromBlock(BlockRegistry.CARVED_ZHAOTOU_PATTERN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> FLAME_ARCH_WALL_PATTERN = fromBlock(BlockRegistry.FLAME_ARCH_WALL_PATTERN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GOLDEN_DRAGON_FANGXIN_PATTERN = fromBlock(BlockRegistry.GOLDEN_DRAGON_FANGXIN_PATTERN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_FANGXIN_PATTERN = fromBlock(BlockRegistry.BLUE_FANGXIN_PATTERN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_FANGXIN_PATTERN_EDGE = fromBlock(BlockRegistry.BLUE_FANGXIN_PATTERN_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GREEN_FANGXIN_PATTERN = fromBlock(BlockRegistry.GREEN_FANGXIN_PATTERN, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GREEN_FANGXIN_PATTERN_EDGE = fromBlock(BlockRegistry.GREEN_FANGXIN_PATTERN_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> LIGHT_BLUE_SU_STYLE_CAIHUA = fromBlock(BlockRegistry.LIGHT_BLUE_SU_STYLE_CAIHUA, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> YELLOW_SU_STYLE_CAIHUA = fromBlock(BlockRegistry.YELLOW_SU_STYLE_CAIHUA, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> LIGHT_YELLOW_SU_STYLE_CAIHUA = fromBlock(BlockRegistry.LIGHT_YELLOW_SU_STYLE_CAIHUA, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> MEDIUM_SU_STYLE_CAIHUA = fromBlock(BlockRegistry.MEDIUM_SU_STYLE_CAIHUA, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> LARGE_WHITE_SU_STYLE_CAIHUA = fromBlock(BlockRegistry.LARGE_WHITE_SU_STYLE_CAIHUA, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> LARGE_GREEN_SU_STYLE_CAIHUA = fromBlock(BlockRegistry.LARGE_GREEN_SU_STYLE_CAIHUA, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> LARGE_GRAY_SU_STYLE_CAIHUA = fromBlock(BlockRegistry.LARGE_GRAY_SU_STYLE_CAIHUA, ModCreativeTab.DECORATIVE_BLOCKS);

    // CHUIHUA

    public static final RegistryObject<Item> BLUE_AND_GREEN_CHUIHUA = fromBlock(BlockRegistry.BLUE_AND_GREEN_CHUIHUA, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CYAN_AND_YELLOW_CHUIHUA = fromBlock(BlockRegistry.CYAN_AND_YELLOW_CHUIHUA, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GILDED_DARK_OAK_CHUIHUA = fromBlock(BlockRegistry.GILDED_DARK_OAK_CHUIHUA, ModCreativeTab.DECORATIVE_BLOCKS);

    // ROOF CHARM

    public static final RegistryObject<Item> GOLDEN_GLAZED_ROOF_CHARM = fromBlock(BlockRegistry.GOLDEN_GLAZED_ROOF_CHARM, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GOLDEN_GLAZED_ROOF_CHARM_ACCESSORY = fromBlock(BlockRegistry.GOLDEN_GLAZED_ROOF_CHARM_ACCESSORY, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GREEN_GLAZED_ROOF_CHARM = fromBlock(BlockRegistry.GREEN_GLAZED_ROOF_CHARM, ModCreativeTab.DECORATIVE_BLOCKS);

    // CEILING

    public static final RegistryObject<Item> QING_GOLDEN_DRAGON_CEILING = fromBlock(BlockRegistry.QING_GOLDEN_DRAGON_CEILING, ModCreativeTab.DECORATIVE_BLOCKS);

    // RAILING

    public static final RegistryObject<Item> WHITE_MARBLE_RAILING = fromBlock(BlockRegistry.WHITE_MARBLE_RAILING, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> WHITE_MARBLE_RAILING_SLANT = fromBlock(BlockRegistry.WHITE_MARBLE_RAILING_SLANT, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CARVED_WOODEN_RAILING = fromBlock(BlockRegistry.CARVED_WOODEN_RAILING, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> RED_WOODEN_RAILING = fromBlock(BlockRegistry.RED_WOODEN_RAILING, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> RED_WOODEN_RAILING_EDGE = fromBlock(BlockRegistry.RED_WOODEN_RAILING_EDGE, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> WOODEN_RAILING = fromBlock(BlockRegistry.WOODEN_RAILING, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> WOODEN_RAILING_VARIANT = fromBlock(BlockRegistry.WOODEN_RAILING_VARIANT, ModCreativeTab.DECORATIVE_BLOCKS);

    // GUARDIAN LION

    public static final RegistryObject<Item> SMALL_WOODEN_GUARDIAN_LION = fromBlock(BlockRegistry.SMALL_WOODEN_GUARDIAN_LION, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> SMALL_STONE_GUARDIAN_LION = fromBlock(BlockRegistry.SMALL_STONE_GUARDIAN_LION, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> SMALL_JADE_GUARDIAN_LION = fromBlock(BlockRegistry.SMALL_JADE_GUARDIAN_LION, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> SMALL_YELLOW_GLAZED_GUARDIAN_LION = fromBlock(BlockRegistry.SMALL_YELLOW_GLAZED_GUARDIAN_LION, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> SMALL_GREEN_GLAZED_GUARDIAN_LION = fromBlock(BlockRegistry.SMALL_GREEN_GLAZED_GUARDIAN_LION, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> XUMI_STONE_MONOLITH = fromBlock(BlockRegistry.XUMI_STONE_MONOLITH, ModCreativeTab.DECORATIVE_BLOCKS);

    // MISC DECORATIONS

    public static final RegistryObject<Item> CABBAGE_BASKET = fromBlock(BlockRegistry.CABBAGE_BASKET, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CELERY_BASKET = fromBlock(BlockRegistry.CELERY_BASKET, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> ORANGE_BASKET = fromBlock(BlockRegistry.ORANGE_BASKET, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> APPLE_BASKET = fromBlock(BlockRegistry.APPLE_BASKET, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> EGGPLANT_BASKET = fromBlock(BlockRegistry.EGGPLANT_BASKET, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> PEAR_BASKET = fromBlock(BlockRegistry.PEAR_BASKET, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BOOKSHELF = fromBlock(BlockRegistry.BOOKSHELF, ModCreativeTab.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BOOKSHELF_VARIANT = fromBlock(BlockRegistry.BOOKSHELF_VARIANT, ModCreativeTab.DECORATIVE_BLOCKS);

    /**
     *  DECORATIONS
     */

    // STUDY

    public static final RegistryObject<Item> ABACUS = fromBlock(BlockRegistry.ABACUS, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> BRUSH_TOOLS = fromBlock(BlockRegistry.BRUSH_TOOLS, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> BRUSH_AND_INKSTONE = fromBlock(BlockRegistry.BRUSH_AND_INKSTONE, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> RULER = fromBlock(BlockRegistry.RULER, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> PAINTING_SCROLL = fromBlock(BlockRegistry.PAINTING_SCROLL, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> BOOK_STACK = fromBlock(BlockRegistry.BOOK_STACK, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> PAPER = fromBlock(BlockRegistry.PAPER, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> BLUE_BOOK = fromBlock(BlockRegistry.BLUE_BOOK, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> BAMBOO_SLIPS = fromBlock(BlockRegistry.BAMBOO_SLIPS, ModCreativeTab.DECORATIONS);

    // ROOM DECO

    public static final RegistryObject<Item> BACK_CUSHION = fromBlock(BlockRegistry.BACK_CUSHION, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> CHESSBOARD = fromBlock(BlockRegistry.CHESSBOARD, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> BLUE_AND_WHITE_PORCELAIN_VASE = fromBlock(BlockRegistry.BLUE_AND_WHITE_PORCELAIN_VASE, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> LARGE_BLUE_AND_WHITE_PORCELAIN_VASE = fromBlock(BlockRegistry.LARGE_BLUE_AND_WHITE_PORCELAIN_VASE, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> SHORT_BLUE_AND_WHITE_PORCELAIN_POT = fromBlock(BlockRegistry.SHORT_BLUE_AND_WHITE_PORCELAIN_POT, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> TALL_BLUE_AND_WHITE_PORCELAIN_POT = fromBlock(BlockRegistry.TALL_BLUE_AND_WHITE_PORCELAIN_POT, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> BLUE_AND_WHITE_PORCELAIN_BOWL = fromBlock(BlockRegistry.BLUE_AND_WHITE_PORCELAIN_BOWL, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> BRONZE_MIRROR = fromBlock(BlockRegistry.BRONZE_MIRROR, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> MEMORIAL_TABLET = fromBlock(BlockRegistry.MEMORIAL_TABLET, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> BRONZE_CENSER = fromBlock(BlockRegistry.BRONZE_CENSER, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> ROYAL_CENSER = fromBlock(BlockRegistry.ROYAL_CENSER, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> PORCELAIN_TEAPOT = fromBlock(BlockRegistry.PORCELAIN_TEAPOT, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> BOOTS = fromBlock(BlockRegistry.BOOTS, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> JADE_PENDANT = fromBlock(BlockRegistry.JADE_PENDANT, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> IMPERIAL_JADE_SEAL = fromBlock(BlockRegistry.IMPERIAL_JADE_SEAL, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> LONG_PILLOW = fromBlock(BlockRegistry.LONG_PILLOW, ModCreativeTab.DECORATIONS);

    // MISC OBJECTS

    public static final RegistryObject<Item> RED_SILK_FABRIC_ROLL = fromBlock(BlockRegistry.RED_SILK_FABRIC_ROLL, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> GREEN_SILK_FABRIC_ROLL = fromBlock(BlockRegistry.GREEN_SILK_FABRIC_ROLL, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> PURPLE_SILK_FABRIC_ROLL = fromBlock(BlockRegistry.PURPLE_SILK_FABRIC_ROLL, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> CLAY_DOLL_MALE = fromBlock(BlockRegistry.CLAY_DOLL_MALE, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> CLAY_DOLL_FEMALE = fromBlock(BlockRegistry.CLAY_DOLL_FEMALE, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> BOTTLE_GOURD = fromBlock(BlockRegistry.BOTTLE_GOURD, ModCreativeTab.DECORATIONS);

    // FLOWER POTS

    public static final RegistryObject<Item> BLUE_AND_WHITE_PORCELAIN_FLOWERPOT = fromBlock(BlockRegistry.BLUE_AND_WHITE_PORCELAIN_FLOWERPOT, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> TERRACOTTA_FLOWERPOT = fromBlock(BlockRegistry.TERRACOTTA_FLOWERPOT, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> BLACK_IRON_FLOWERPOT = fromBlock(BlockRegistry.BLACK_IRON_FLOWERPOT, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> BLUE_PORCELAIN_FLOWERPOT = fromBlock(BlockRegistry.BLUE_PORCELAIN_FLOWERPOT, ModCreativeTab.DECORATIONS);

    // COURTYARD

    public static final RegistryObject<Item> SACK = fromBlock(BlockRegistry.SACK, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> BAMBOO_TEA_BASKET = fromBlock(BlockRegistry.BAMBOO_TEA_BASKET, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> EMPTY_BAMBOO_TEA_BASKET = fromBlock(BlockRegistry.EMPTY_BAMBOO_TEA_BASKET, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> STRAW_HAT = fromBlock(BlockRegistry.STRAW_HAT, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> KNIFE = fromBlock(BlockRegistry.KNIFE, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> SUNDIAL = fromBlock(BlockRegistry.SUNDIAL, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> BROOM = fromBlock(BlockRegistry.BROOM, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> STONE_PEDESTAL = fromBlock(BlockRegistry.STONE_PEDESTAL, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> TERRACOTTA_POT = fromBlock(BlockRegistry.TERRACOTTA_POT, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> CHINESE_HERBS_BAG = fromBlock(BlockRegistry.CHINESE_HERBS_BAG, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> FRUIT_BOX = fromBlock(BlockRegistry.FRUIT_BOX, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> WOODEN_CRATE = fromBlock(BlockRegistry.WOODEN_CRATE, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> GUNNY_SACK = fromBlock(BlockRegistry.GUNNY_SACK, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> BRONZE_DING = fromBlock(BlockRegistry.BRONZE_DING, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> CARRIAGE = fromBlock(BlockRegistry.CARRIAGE, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> WOODEN_POLES = fromBlock(BlockRegistry.WOODEN_POLES, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> TEAHOUSE_FLAG = fromBlock(BlockRegistry.TEAHOUSE_FLAG, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> KNIFE_REST = fromBlock(BlockRegistry.KNIFE_REST, ModCreativeTab.DECORATIONS);

    // WALL HANGING

    public static final RegistryObject<Item> LONG_HANGING_PAINTING = fromBlock(BlockRegistry.LONG_HANGING_PAINTING, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> WHITE_LANDSCAPE_PAINTING = fromBlock(BlockRegistry.WHITE_LANDSCAPE_PAINTING, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> HORIZONTAL_OLD_LANDSCAPE_PAINTING = fromBlock(BlockRegistry.HORIZONTAL_OLD_LANDSCAPE_PAINTING, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> HORIZONTAL_CALLIGRAPHY = fromBlock(BlockRegistry.HORIZONTAL_CALLIGRAPHY, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> HORIZONTAL_LANDSCAPE_PAINTING = fromBlock(BlockRegistry.HORIZONTAL_LANDSCAPE_PAINTING, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> LONG_YELLOW_HANGING_PAINTING = fromBlock(BlockRegistry.LONG_YELLOW_HANGING_PAINTING, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> DAMAGED_LANDSCAPE_PAINTING = fromBlock(BlockRegistry.DAMAGED_LANDSCAPE_PAINTING, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> PORTRAIT = fromBlock(BlockRegistry.PORTRAIT, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> HANGING_PAINTING_FAN = fromBlock(BlockRegistry.HANGING_PAINTING_FAN, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> SINCERE_CALLIGRAPHY = fromBlock(BlockRegistry.SINCERE_CALLIGRAPHY, ModCreativeTab.DECORATIONS);

    // FOOD

    public static final RegistryObject<Item> FOOD_HAMPER = fromBlock(BlockRegistry.FOOD_HAMPER, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> PLATED_MOON_CAKES = fromBlock(BlockRegistry.PLATED_MOONCAKES, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> PLATED_MUNG_BEAN_CAKES = fromBlock(BlockRegistry.PLATED_MUNG_BEAN_CAKES, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> PLATED_HAM = fromBlock(BlockRegistry.PLATED_HAM, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> PLATED_FISH = fromBlock(BlockRegistry.PLATED_FISH, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> SCATTERED_CARROTS = fromBlock(BlockRegistry.SCATTERED_CARROTS, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> WINE_POT = fromBlock(BlockRegistry.WINE_POT, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> XIAOLONGBAO = fromBlock(BlockRegistry.XIAOLONGBAO, ModCreativeTab.DECORATIONS);

    // ICE

    public static final RegistryObject<Item> ICICLE = fromBlock(BlockRegistry.ICICLE, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> LARGE_ICICLE = fromBlock(BlockRegistry.LARGE_ICICLE, ModCreativeTab.DECORATIONS);

    // CELEBRATION

    public static final RegistryObject<Item> COUPLET = fromBlock(BlockRegistry.COUPLET, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> COUPLET_TOP = fromBlock(BlockRegistry.COUPLET_TOP, ModCreativeTab.DECORATIONS);
    public static final RegistryObject<Item> FU_MARK = fromBlock(BlockRegistry.FU_MARK, ModCreativeTab.DECORATIONS);

    /**
     *  FURNITURE
     */

    // CABINET

    public static final RegistryObject<Item> OAK_CABINET = fromBlock(BlockRegistry.OAK_CABINET, ModCreativeTab.FURNITURE);
    public static final RegistryObject<Item> WARPED_CABINET = fromBlock(BlockRegistry.WARPED_CABINET, ModCreativeTab.FURNITURE);
    public static final RegistryObject<Item> EBONY_CABINET = fromBlock(BlockRegistry.EBONY_CABINET, ModCreativeTab.FURNITURE);

    // TABLE

    public static final RegistryObject<Item> LARGE_TEA_TABLE = fromBlock(BlockRegistry.LARGE_TEA_TABLE, ModCreativeTab.FURNITURE);
    public static final RegistryObject<Item> CHESS_TABLE = fromBlock(BlockRegistry.CHESS_TABLE, ModCreativeTab.FURNITURE);
    public static final RegistryObject<Item> HIGH_TABLE_WITH_WHITE_TOP = fromBlock(BlockRegistry.HIGH_TABLE_WITH_WHITE_TOP, ModCreativeTab.FURNITURE);
    public static final RegistryObject<Item> CENSER_TABLE = fromBlock(BlockRegistry.CENSER_TABLE, ModCreativeTab.FURNITURE);
    public static final RegistryObject<Item> PORCELAIN_INLAID_TABLE = fromBlock(BlockRegistry.PORCELAIN_INLAID_TABLE, ModCreativeTab.FURNITURE);
    public static final RegistryObject<Item> SMALL_TABLE = fromBlock(BlockRegistry.SMALL_TABLE, ModCreativeTab.FURNITURE);
    public static final RegistryObject<Item> SMALL_EBONY_TABLE = fromBlock(BlockRegistry.SMALL_EBONY_TABLE, ModCreativeTab.FURNITURE);
    public static final RegistryObject<Item> LARGE_TABLE = fromBlock(BlockRegistry.LARGE_TABLE, ModCreativeTab.FURNITURE);

   // CHAIR

    public static final RegistryObject<Item> EBONY_CHAIR = fromBlock(BlockRegistry.EBONY_CHAIR, ModCreativeTab.FURNITURE);
    public static final RegistryObject<Item> CHAIR_WITH_YELLOW_CUSHION = fromBlock(BlockRegistry.CHAIR_WITH_YELLOW_CUSHION, ModCreativeTab.FURNITURE);
    public static final RegistryObject<Item> PAINTED_CHAIR = fromBlock(BlockRegistry.PAINTED_CHAIR, ModCreativeTab.FURNITURE);
    public static final RegistryObject<Item> WOODEN_STOOL = fromBlock(BlockRegistry.WOODEN_STOOL, ModCreativeTab.FURNITURE);
    public static final RegistryObject<Item> PORCELAIN_INLAID_GRAND_CHAIR = fromBlock(BlockRegistry.PORCELAIN_INLAID_GRAND_CHAIR, ModCreativeTab.FURNITURE);
    public static final RegistryObject<Item> YELLOW_CUSHION = fromBlock(BlockRegistry.YELLOW_CUSHION, ModCreativeTab.FURNITURE);
    public static final RegistryObject<Item> OAK_BED = fromBlock(BlockRegistry.OAK_BED, ModCreativeTab.FURNITURE);

    // SCREEN

    public static final RegistryObject<Item> LARGE_LANDSCAPE_PAINTING_SCREEN = fromBlock(BlockRegistry.LARGE_LANDSCAPE_PAINTING_SCREEN, ModCreativeTab.FURNITURE);
    public static final RegistryObject<Item> PAINTED_SCREEN = fromBlock(BlockRegistry.PAINTED_SCREEN, ModCreativeTab.FURNITURE);

    /**
     *  DOOR AND WINDOW
     */

    // DOOR

    public static final RegistryObject<Item> CARVED_WOODEN_DOOR = fromBlock(BlockRegistry.CARVED_WOODEN_DOOR, ModCreativeTab.WINDOWS_AND_DOORS);
    public static final RegistryObject<Item> SONG_WOODEN_DOOR = fromBlock(BlockRegistry.SONG_WOODEN_DOOR, ModCreativeTab.WINDOWS_AND_DOORS);

    // WINDOW

    public static final RegistryObject<Item> SONG_WOODEN_WINDOW = fromBlock(BlockRegistry.SONG_WOODEN_WINDOW, ModCreativeTab.WINDOWS_AND_DOORS);
    public static final RegistryObject<Item> ROYAL_ROSEWOOD_WINDOW = fromBlock(BlockRegistry.ROYAL_ROSEWOOD_WINDOW, ModCreativeTab.WINDOWS_AND_DOORS);
    public static final RegistryObject<Item> TALL_ROYAL_ROSEWOOD_WINDOW = fromBlock(BlockRegistry.TALL_ROYAL_ROSEWOOD_WINDOW, ModCreativeTab.WINDOWS_AND_DOORS);
    public static final RegistryObject<Item> GLAZED_TILE_GRID_WINDOW = fromBlock(BlockRegistry.GLAZED_TILE_GRID_WINDOW, ModCreativeTab.WINDOWS_AND_DOORS);
    public static final RegistryObject<Item> STONE_FLOWER_WINDOW = fromBlock(BlockRegistry.STONE_FLOWER_WINDOW, ModCreativeTab.WINDOWS_AND_DOORS);

    // DOOR DECO

    public static final RegistryObject<Item> KNOCKER = fromBlock(BlockRegistry.KNOCKER, ModCreativeTab.WINDOWS_AND_DOORS);
    public static final RegistryObject<Item> ROSEWOOD_PANEL = fromBlock(BlockRegistry.ROSEWOOD_PANEL, ModCreativeTab.WINDOWS_AND_DOORS);
    public static final RegistryObject<Item> ROSEWOOD_DOOR_PANEL = fromBlock(BlockRegistry.ROSEWOOD_DOOR_PANEL, ModCreativeTab.WINDOWS_AND_DOORS);
    public static final RegistryObject<Item> LARGE_ROSEWOOD_PANEL = fromBlock(BlockRegistry.LARGE_ROSEWOOD_PANEL, ModCreativeTab.WINDOWS_AND_DOORS);
    public static final RegistryObject<Item> LARGE_ROSEWOOD_PANEL_EDGE = fromBlock(BlockRegistry.LARGE_ROSEWOOD_PANEL_EDGE, ModCreativeTab.WINDOWS_AND_DOORS);
    public static final RegistryObject<Item> CARVED_WOODEN_DOOR_PANEL = fromBlock(BlockRegistry.CARVED_WOODEN_DOOR_PANEL, ModCreativeTab.WINDOWS_AND_DOORS);
    public static final RegistryObject<Item> PLAQUE = fromBlock(BlockRegistry.PLAQUE, ModCreativeTab.WINDOWS_AND_DOORS);
    public static final RegistryObject<Item> PAPER_STRIP_SEAL = fromBlock(BlockRegistry.PAPER_STRIP_SEAL, ModCreativeTab.WINDOWS_AND_DOORS);

    // WINDOW DECO

    public static final RegistryObject<Item> LARGE_BLUE_CURTAIN = fromBlock(BlockRegistry.LARGE_BLUE_CURTAIN, ModCreativeTab.WINDOWS_AND_DOORS);
    public static final RegistryObject<Item> MEDIUM_BLUE_CURTAIN = fromBlock(BlockRegistry.MEDIUM_BLUE_CURTAIN, ModCreativeTab.WINDOWS_AND_DOORS);
    public static final RegistryObject<Item> SMALL_BLUE_CURTAIN = fromBlock(BlockRegistry.SMALL_BLUE_CURTAIN, ModCreativeTab.WINDOWS_AND_DOORS);
    public static final RegistryObject<Item> RED_CURTAIN = fromBlock(BlockRegistry.RED_CURTAIN, ModCreativeTab.WINDOWS_AND_DOORS);
    public static final RegistryObject<Item> RED_CURTAIN_CORNER = fromBlock(BlockRegistry.RED_CURTAIN_CORNER, ModCreativeTab.WINDOWS_AND_DOORS);
    public static final RegistryObject<Item> BAMBOO_CURTAIN = fromBlock(BlockRegistry.BAMBOO_CURTAIN, ModCreativeTab.WINDOWS_AND_DOORS);

    /**
     *  PLANTS
     */

    // LOTUS

    public static final RegistryObject<Item> SMALL_LOTUS_LEAF = aquaticPlantItem(BlockRegistry.SMALL_LOTUS_LEAF, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> SMALL_DARK_GREEN_LOTUS_LEAF = aquaticPlantItem(BlockRegistry.SMALL_DARK_GREEN_LOTUS_LEAF, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> MEDIUM_LOTUS_LEAF = aquaticPlantItem(BlockRegistry.MEDIUM_LOTUS_LEAF, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> LARGE_LOTUS_LEAF = aquaticPlantItem(BlockRegistry.LARGE_LOTUS_LEAF, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> TILTED_LOTUS_LEAF = aquaticPlantItem(BlockRegistry.TILTED_LOTUS_LEAF, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> SMALL_LOTUS_LEAF_CLUSTER = aquaticPlantItem(BlockRegistry.SMALL_LOTUS_LEAF_CLUSTER, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> MEDIUM_LOTUS_LEAF_CLUSTER = aquaticPlantItem(BlockRegistry.MEDIUM_LOTUS_LEAF_CLUSTER, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> LOTUS_BUD = aquaticPlantItem(BlockRegistry.LOTUS_BUD, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> MEDIUM_LOTUS = aquaticPlantItem(BlockRegistry.MEDIUM_LOTUS, ModCreativeTab.PLANTS);

    // IVY

    public static final RegistryObject<Item> SMALL_RED_IVY = fromBlock(BlockRegistry.SMALL_RED_IVY, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> MEDIUM_RED_IVY = fromBlock(BlockRegistry.MEDIUM_RED_IVY, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> LARGE_RED_IVY = fromBlock(BlockRegistry.LARGE_RED_IVY, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> SMALL_YELLOW_IVY = fromBlock(BlockRegistry.SMALL_YELLOW_IVY, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> MEDIUM_YELLOW_IVY = fromBlock(BlockRegistry.MEDIUM_YELLOW_IVY, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> LARGE_YELLOW_IVY = fromBlock(BlockRegistry.LARGE_YELLOW_IVY, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> SMALL_GREEN_IVY = fromBlock(BlockRegistry.SMALL_GREEN_IVY, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> MEDIUM_GREEN_IVY = fromBlock(BlockRegistry.MEDIUM_GREEN_IVY, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> LARGE_GREEN_IVY = fromBlock(BlockRegistry.LARGE_GREEN_IVY, ModCreativeTab.PLANTS);

    // LEAVES

    public static final RegistryObject<Item> SMALL_LEAF_PILE = fromBlock(BlockRegistry.SMALL_LEAF_PILE, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> MEDIUM_LEAF_PILE = fromBlock(BlockRegistry.MEDIUM_LEAF_PILE, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> LARGE_LEAF_PILE = fromBlock(BlockRegistry.LARGE_LEAF_PILE, ModCreativeTab.PLANTS);

    // BONSAI

    public static final RegistryObject<Item> SMALL_GREETING_PINE_BONSAI = fromBlock(BlockRegistry.SMALL_GREETING_PINE_BONSAI, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> MEDIUM_GREETING_PINE_BONSAI = fromBlock(BlockRegistry.MEDIUM_GREETING_PINE_BONSAI, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> LARGE_GREETING_PINE_BONSAI = fromBlock(BlockRegistry.LARGE_GREETING_PINE_BONSAI, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> SMALL_WHITE_PORCELAIN_VASE_BONSAI = fromBlock(BlockRegistry.SMALL_WHITE_PORCELAIN_VASE_BONSAI, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> MEDIUM_WHITE_PORCELAIN_VASE_BONSAI = fromBlock(BlockRegistry.MEDIUM_WHITE_PORCELAIN_VASE_BONSAI, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> LARGE_WHITE_PORCELAIN_VASE_BONSAI = fromBlock(BlockRegistry.LARGE_WHITE_PORCELAIN_VASE_BONSAI, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> SMALL_GREEN_PORCELAIN_VASE_BONSAI = fromBlock(BlockRegistry.SMALL_GREEN_PORCELAIN_VASE_BONSAI, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> GREEN_PORCELAIN_VASE_BONSAI = fromBlock(BlockRegistry.GREEN_PORCELAIN_VASE_BONSAI, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> RED_CORAL_BONSAI = fromBlock(BlockRegistry.RED_CORAL_BONSAI, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> RED_PLUM_BONSAI = fromBlock(BlockRegistry.RED_PLUM_BONSAI, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> BAMBOO_BONSAI = fromBlock(BlockRegistry.BAMBOO_BONSAI, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> TALL_BLUE_VASE_BONSAI = fromBlock(BlockRegistry.TALL_BLUE_VASE_BONSAI, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> TALL_BLUE_AND_WHITE_PORCELAIN_BONSAI = fromBlock(BlockRegistry.TALL_BLUE_AND_WHITE_PORCELAIN_BONSAI, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> MEDIUM_BONSAI = fromBlock(BlockRegistry.MEDIUM_BONSAI, ModCreativeTab.PLANTS);
    public static final RegistryObject<Item> LARGE_BONSAI = fromBlock(BlockRegistry.LARGE_BONSAI, ModCreativeTab.PLANTS);

    /**
     *  LAMPS
     */

    //LANTERN

    public static final RegistryObject<Item> OCTAGONAL_PALACE_LANTERN = fromBlock(BlockRegistry.OCTAGONAL_PALACE_LANTERN, ModCreativeTab.LAMPS);
    public static final RegistryObject<Item> SQUARE_PALACE_LANTERN = fromBlock(BlockRegistry.SQUARE_PALACE_LANTERN, ModCreativeTab.LAMPS);
    public static final RegistryObject<Item> SMALL_RED_LANTERN = fromBlock(BlockRegistry.SMALL_RED_LANTERN, ModCreativeTab.LAMPS);
    public static final RegistryObject<Item> WHITE_SKY_LANTERN = fromBlock(BlockRegistry.WHITE_SKY_LANTERN, ModCreativeTab.LAMPS);
    public static final RegistryObject<Item> RED_SKY_LANTERN = fromBlock(BlockRegistry.RED_SKY_LANTERN, ModCreativeTab.LAMPS);
    public static final RegistryObject<Item> YELLOW_SKY_LANTERN = fromBlock(BlockRegistry.YELLOW_SKY_LANTERN, ModCreativeTab.LAMPS);

    // LAMP

    public static final RegistryObject<Item> STANDING_LAMP = fromBlock(BlockRegistry.STANDING_LAMP, ModCreativeTab.LAMPS);
    public static final RegistryObject<Item> SMALL_STANDING_LAMP = fromBlock(BlockRegistry.SMALL_STANDING_LAMP, ModCreativeTab.LAMPS);
    public static final RegistryObject<Item> STONE_LAMP = fromBlock(BlockRegistry.STONE_LAMP, ModCreativeTab.LAMPS);

    // STREETLIGHT

    public static final RegistryObject<Item> RED_LANTERN_STREETLIGHT = fromBlock(BlockRegistry.RED_LANTERN_STREETLIGHT, ModCreativeTab.LAMPS);
    public static final RegistryObject<Item> HANGING_RED_LANTERN_STREETLIGHT = fromBlock(BlockRegistry.HANGING_RED_LANTERN_STREETLIGHT, ModCreativeTab.LAMPS);
    public static final RegistryObject<Item> STREETLIGHT_POLE = fromBlock(BlockRegistry.STREETLIGHT_POLE, ModCreativeTab.LAMPS);

    // CANDLESTICK

    public static final RegistryObject<Item> RED_CANDLE = fromBlock(BlockRegistry.RED_CANDLE, ModCreativeTab.LAMPS);
    public static final RegistryObject<Item> TRICOLOR_CANDLESTICK = fromBlock(BlockRegistry.TRICOLOR_CANDLESTICK, ModCreativeTab.LAMPS);
    public static final RegistryObject<Item> JADE_CANDLESTICK = fromBlock(BlockRegistry.JADE_CANDLESTICK, ModCreativeTab.LAMPS);

    /**
     *  MATERIALS
     */

    // ORE BLOCK

    public static final RegistryObject<Item> JADE_ORE = fromBlock(BlockRegistry.JADE_ORE, ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> DEEPSLATE_JADE_ORE = fromBlock(BlockRegistry.DEEPSLATE_JADE_ORE, ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> MAGNESITE_ORE = fromBlock(BlockRegistry.MAGNESITE_ORE, ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> DEEPSLATE_MAGNESITE_ORE = fromBlock(BlockRegistry.DEEPSLATE_MAGNESITE_ORE, ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> HEMATITE_ORE = fromBlock(BlockRegistry.HEMATITE_ORE, ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> DEEPSLATE_HEMATITE_ORE = fromBlock(BlockRegistry.DEEPSLATE_HEMATITE_ORE, ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> NETHER_COBALT_ORE = fromBlock(BlockRegistry.NETHER_COBALT_ORE, ModCreativeTab.MATERIALS);

    // ORE PRODUCT

    public static final RegistryObject<Item> JADE = simpleItem("jade", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> MAGNESITE = simpleItem("magnesite", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> MAGNESITE_DUST = simpleItem("magnesite_dust", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> RAW_HEMATITE = simpleItem("raw_hematite", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> HEMATITE_DUST = simpleItem("hematite_dust", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> RAW_COBALT = simpleItem("raw_cobalt", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> COBALT_DUST = simpleItem("cobalt_dust", ModCreativeTab.MATERIALS);

    // BRICK

    public static final RegistryObject<Item> CYAN_BRICK = simpleItem("cyan_brick", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> BLACK_BRICK = simpleItem("black_brick", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> BROWNISH_RED_STONE_BRICK = simpleItem("brownish_red_stone_brick", ModCreativeTab.MATERIALS);

    // BRICK MATERIAL

    public static final RegistryObject<Item> UNFIRED_CLAY_BRICK = simpleItem("unfired_clay_brick", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> UNFIRED_RAW_CYAN_BRICK = simpleItem("unfired_cyan_brick", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> UNFIRED_BLACK_BRICK = simpleItem("unfired_black_brick", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> UNFIRED_RAW_BROWNISH_RED_STONE_BRICK = simpleItem("unfired_brownish_red_stone_brick", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> FIRED_BRICK = simpleItem("fired_brick", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> PRISMARINE_DUST = simpleItem("prismarine_dust", ModCreativeTab.MATERIALS);

    // ROOF TILE

    public static final RegistryObject<Item> UNFIRED_ROOF_TILE = simpleItem("unfired_roof_tile", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> GRAY_ROOF_TILE = simpleItem("gray_roof_tile", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> YELLOW_ROOF_TILE = simpleItem("yellow_roof_tile", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> GREEN_ROOF_TILE = simpleItem("green_roof_tile", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> BLUE_ROOF_TILE = simpleItem("blue_roof_tile", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> CYAN_ROOF_TILE = simpleItem("cyan_roof_tile", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> BLACK_ROOF_TILE = simpleItem("black_roof_tile", ModCreativeTab.MATERIALS);

    // POLISHED PLANK

    public static final RegistryObject<Item> POLISHED_OAK_PLANK = simpleItem("polished_oak_plank", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> POLISHED_BIRCH_PLANK = simpleItem("polished_birch_plank", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> POLISHED_SPRUCE_PLANK = simpleItem("polished_spruce_plank", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> POLISHED_JUNGLE_PLANK = simpleItem("polished_jungle_plank", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> POLISHED_ACACIA_PLANK = simpleItem("polished_acacia_plank", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> POLISHED_DARK_OAK_PLANK = simpleItem("polished_dark_oak_plank", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> POLISHED_WARPED_PLANK = simpleItem("polished_warped_plank", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> POLISHED_CRIMSON_PLANK = simpleItem("polished_crimson_plank", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> POLISHED_ROSEWOOD_PLANK = simpleItem("polished_rosewood_plank", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> POLISHED_EBONY_PLANK = simpleItem("polished_ebony_plank", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> WOODEN_FRAME = simpleItem("wooden_frame", ModCreativeTab.MATERIALS);

    // PORCELAIN

    public static final RegistryObject<Item> BLUE_AND_WHITE_PORCELAIN_PIECE = simpleItem("blue_and_white_porcelain_piece", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> BLUE_AND_WHITE_PORCELAIN_SHARDS = simpleItem("blue_and_white_porcelain_shards", ModCreativeTab.MATERIALS);

    // PARTS

    public static final RegistryObject<Item> WOODEN_PARTS = simpleItem("wooden_parts", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> GOLD_PARTS = simpleItem("gold_parts", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> JADE_PARTS = simpleItem("jade_parts", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> PORCELAIN_PARTS = simpleItem("porcelain_parts", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> BRONZE_PARTS = simpleItem("bronze_parts", ModCreativeTab.MATERIALS);

    // DYE POWDERS

    public static final RegistryObject<Item> WHITE_DYE_POWDER = dyePowderItem("white_dye_powder", DyeColor.WHITE);
    public static final RegistryObject<Item> ORANGE_DYE_POWDER = dyePowderItem("orange_dye_powder", DyeColor.ORANGE);
    public static final RegistryObject<Item> MAGENTA_DYE_POWDER = dyePowderItem("magenta_dye_powder", DyeColor.MAGENTA);
    public static final RegistryObject<Item> LIGHT_BLUE_DYE_POWDER = dyePowderItem("light_blue_dye_powder", DyeColor.LIGHT_BLUE);
    public static final RegistryObject<Item> YELLOW_DYE_POWDER = dyePowderItem("yellow_dye_powder", DyeColor.YELLOW);
    public static final RegistryObject<Item> LIME_DYE_POWDER = dyePowderItem("lime_dye_powder", DyeColor.LIME);
    public static final RegistryObject<Item> PINK_DYE_POWDER = dyePowderItem("pink_dye_powder", DyeColor.PINK);
    public static final RegistryObject<Item> GRAY_DYE_POWDER = dyePowderItem("gray_dye_powder", DyeColor.GRAY);
    public static final RegistryObject<Item> LIGHT_GRAY_DYE_POWDER = dyePowderItem("light_gray_dye_powder", DyeColor.LIGHT_GRAY);
    public static final RegistryObject<Item> CYAN_DYE_POWDER = dyePowderItem("cyan_dye_powder", DyeColor.CYAN);
    public static final RegistryObject<Item> PURPLE_DYE_POWDER = dyePowderItem("purple_dye_powder", DyeColor.PURPLE);
    public static final RegistryObject<Item> BLUE_DYE_POWDER = dyePowderItem("blue_dye_powder", DyeColor.BLUE);
    public static final RegistryObject<Item> BROWN_DYE_POWDER = dyePowderItem("brown_dye_powder", DyeColor.BROWN);
    public static final RegistryObject<Item> GREEN_DYE_POWDER = dyePowderItem("green_dye_powder", DyeColor.GREEN);
    public static final RegistryObject<Item> RED_DYE_POWDER = dyePowderItem("red_dye_powder", DyeColor.RED);
    public static final RegistryObject<Item> BLACK_DYE_POWDER = dyePowderItem("black_dye_powder", DyeColor.BLACK);
    public static final RegistryObject<Item> GOLD_DYE_POWDER = dyePowderItem("gold_dye_powder", DyeColor.YELLOW);

    // TEMPLATES

    public static final RegistryObject<Item> CARVED_WOOD_TEMPLATE = ITEMS.register("carved_wood_template", ChiselTemplate::new);
    public static final RegistryObject<Item> FANGXIN_TEMPLATE = ITEMS.register("fangxin_template", ChiselTemplate::new);
    public static final RegistryObject<Item> FANGXIN_EDGE_TEMPLATE = ITEMS.register("fangxin_edge_template", ChiselTemplate::new);
    public static final RegistryObject<Item> ZHAOTOU_TEMPLATE = ITEMS.register("zhaotou_template", ChiselTemplate::new);
    public static final RegistryObject<Item> GUTOU_TEMPLATE = ITEMS.register("gutou_template", ChiselTemplate::new);
    public static final RegistryObject<Item> RAFTER_TEMPLATE = ITEMS.register("rafter_template", ChiselTemplate::new);
    public static final RegistryObject<Item> RAFTER_END_TEMPLATE = ITEMS.register("rafter_end_template", ChiselTemplate::new);
    public static final RegistryObject<Item> ARCHITRAVE_TEMPLATE = ITEMS.register("architrave_template", ChiselTemplate::new);
    public static final RegistryObject<Item> CAIHUA_TEMPLATE = ITEMS.register("caihua_template", ChiselTemplate::new);

    // MATERIALS

    public static final RegistryObject<Item> INCENSE = simpleItem("incense", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> FUR = simpleItem("fur", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> GREASE = simpleItem("grease", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> SILK = simpleItem("silk", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> XUAN_PAPER = simpleItem("xuan_paper", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> COPPER_CASH_COIN = simpleItem("copper_cash_coin", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> BRONZE_INGOT = simpleItem("bronze_ingot", ModCreativeTab.MATERIALS);
    public static final RegistryObject<Item> BRONZE_DUST = simpleItem("bronze_dust", ModCreativeTab.MATERIALS);

    // FOOD

    public static final RegistryObject<Item> MOONCAKE = foodItem("mooncake", ModFoods.MOONCAKE);
    public static final RegistryObject<Item> MUNG_BEAN_CAKE = foodItem("mung_bean_cake",ModFoods.MUNG_BEAN_CAKE);
    public static final RegistryObject<Item> RAW_MEAT = foodItem("raw_meat",ModFoods.RAW_MEAT);
    public static final RegistryObject<Item> COOKED_MEAT = foodItem("cooked_meat",ModFoods.COOKED_MEAT);
    public static final RegistryObject<Item> BAOZI = foodItem("baozi",ModFoods.BAOZI);

    /**
     *  TOOLS
     */

    public static final RegistryObject<Item> WOODEN_MALLET = ITEMS.register("wooden_mallet", WoodenMallet::new);
    public static final RegistryObject<Item> WOODWORKING_WORKBENCH = fromBlock(BlockRegistry.WOODWORKING_WORKBENCH, ModCreativeTab.TOOLS);
    public static final RegistryObject<Item> BRICK_KILN = fromBlock(BlockRegistry.BRICK_KILN, ModCreativeTab.TOOLS);
    public static final RegistryObject<Item> CHISEL_TABLE = fromBlock(BlockRegistry.CHISEL_TABLE, ModCreativeTab.TOOLS);

    private static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block, ModCreativeTab tabDef) {
        RegistryObject<Item> registryObject = ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tabDef.getTab())));
        ModCreativeTab.putItemInSet(registryObject, tabDef);
        return registryObject;
    }

    private static <B extends Block> RegistryObject<Item> aquaticPlantItem(RegistryObject<B> block, ModCreativeTab tabDef) {
        RegistryObject<Item> registryObject = ITEMS.register(block.getId().getPath(), () -> new AquaticPlantBlockItem(block.get(), new Item.Properties().tab(tabDef.getTab())));
        ModCreativeTab.putItemInSet(registryObject, tabDef);
        return registryObject;
    }

    private static <B extends Block> RegistryObject<Item> registerBlockItem(String name, BlockItem blockItem, ModCreativeTab tabDef) {
        RegistryObject<Item> registryObject = ITEMS.register(name, () -> blockItem);
        ModCreativeTab.putItemInSet(registryObject, tabDef);
        return registryObject;
    }

    private static RegistryObject<Item> simpleItem(String name, ModCreativeTab tabDef) {
        RegistryObject<Item> registryObject = ITEMS.register(name, () -> new Item(new Item.Properties().tab(tabDef.getTab())));
        ModCreativeTab.putItemInSet(registryObject, tabDef);
        return registryObject;
    }

    private static RegistryObject<Item> foodItem(String name, FoodProperties food){
        RegistryObject<Item> registryObject = ITEMS.register(name, () -> new BaseFood(food));
        ModCreativeTab.putItemInSet(registryObject, ModCreativeTab.MATERIALS);
        return registryObject;
    }

    private static RegistryObject<Item> dyePowderItem(String name, DyeColor color){
        RegistryObject<Item> registryObject = ITEMS.register(name, () -> new DyePowder(color));
        ModCreativeTab.putItemInSet(registryObject, ModCreativeTab.MATERIALS);
        return registryObject;
    }

}
