package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.CreativeTabs;
import com.voxelutopia.ultramarine.data.ModFoods;
import com.voxelutopia.ultramarine.world.item.BaseFood;
import com.voxelutopia.ultramarine.world.item.WoodenHammer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ultramarine.MOD_ID);
    public static final RegistryObject<Item> CYAN_BRICKS = fromBlock(BlockRegistry.CYAN_BRICKS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CYAN_BRICK_SLAB = fromBlock(BlockRegistry.CYAN_BRICK_SLAB, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CYAN_BRICK_STAIRS = fromBlock(BlockRegistry.CYAN_BRICK_STAIRS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CYAN_BRICK_WALL = fromBlock(BlockRegistry.CYAN_BRICK_WALL, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_BRICKS = fromBlock(BlockRegistry.BLACK_BRICKS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_BRICK_SLAB = fromBlock(BlockRegistry.BLACK_BRICK_SLAB, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_BRICK_STAIRS = fromBlock(BlockRegistry.BLACK_BRICK_STAIRS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_BRICK_WALL = fromBlock(BlockRegistry.BLACK_BRICK_WALL, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BROWNISH_RED_STONE_BRICKS = fromBlock(BlockRegistry.BROWNISH_RED_STONE_BRICKS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BROWNISH_RED_STONE_BRICK_SLAB = fromBlock(BlockRegistry.BROWNISH_RED_STONE_BRICK_SLAB, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BROWNISH_RED_STONE_BRICK_STAIRS = fromBlock(BlockRegistry.BROWNISH_RED_STONE_BRICK_STAIRS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BROWNISH_RED_STONE_BRICK_WALL = fromBlock(BlockRegistry.BROWNISH_RED_STONE_BRICK_WALL, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> PALE_YELLOW_STONE = fromBlock(BlockRegistry.PALE_YELLOW_STONE, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> PALE_YELLOW_STONE_SLAB = fromBlock(BlockRegistry.PALE_YELLOW_STONE_SLAB, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> PALE_YELLOW_STONE_STAIRS = fromBlock(BlockRegistry.PALE_YELLOW_STONE_STAIRS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> VARIEGATED_ROCKS = fromBlock(BlockRegistry.VARIEGATED_ROCKS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> VARIEGATED_ROCK_SLAB = fromBlock(BlockRegistry.VARIEGATED_ROCK_SLAB, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> VARIEGATED_ROCK_STAIRS = fromBlock(BlockRegistry.VARIEGATED_ROCK_STAIRS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> WEATHERED_STONE = fromBlock(BlockRegistry.WEATHERED_STONE, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> WEATHERED_STONE_SLAB = fromBlock(BlockRegistry.WEATHERED_STONE_SLAB, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> WEATHERED_STONE_STAIRS = fromBlock(BlockRegistry.WEATHERED_STONE_STAIRS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> POLISHED_WEATHERED_STONE = fromBlock(BlockRegistry.POLISHED_WEATHERED_STONE, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> POLISHED_WEATHERED_STONE_SLAB = fromBlock(BlockRegistry.POLISHED_WEATHERED_STONE_SLAB, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> POLISHED_WEATHERED_STONE_STAIRS = fromBlock(BlockRegistry.POLISHED_WEATHERED_STONE_STAIRS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> POLISHED_WEATHERED_STONE_WALL = fromBlock(BlockRegistry.POLISHED_WEATHERED_STONE_WALL, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> LIGHT_CYAN_FLOOR_TILE = fromBlock(BlockRegistry.LIGHT_CYAN_FLOOR_TILE, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> LIGHT_CYAN_FLOOR_TILE_SLAB = fromBlock(BlockRegistry.LIGHT_CYAN_FLOOR_TILE_SLAB, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> LIGHT_CYAN_FLOOR_TILE_STAIRS = fromBlock(BlockRegistry.LIGHT_CYAN_FLOOR_TILE_STAIRS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> LIGHT_CYAN_FLOOR_TILE_WALL = fromBlock(BlockRegistry.LIGHT_CYAN_FLOOR_TILE_WALL, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CYAN_FLOOR_TILE = fromBlock(BlockRegistry.CYAN_FLOOR_TILE, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CYAN_FLOOR_TILE_SLAB = fromBlock(BlockRegistry.CYAN_FLOOR_TILE_SLAB, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CYAN_FLOOR_TILE_STAIRS = fromBlock(BlockRegistry.CYAN_FLOOR_TILE_STAIRS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CYAN_FLOOR_TILE_WALL = fromBlock(BlockRegistry.CYAN_FLOOR_TILE_WALL, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> GREEN_GLAZED_TILES = fromBlock(BlockRegistry.GREEN_GLAZED_TILES, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> GREEN_GLAZED_TILE_SLAB = fromBlock(BlockRegistry.GREEN_GLAZED_TILE_SLAB, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> GREEN_GLAZED_TILE_STAIRS = fromBlock(BlockRegistry.GREEN_GLAZED_TILE_STAIRS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> ROSEWOOD_PLANKS = fromBlock(BlockRegistry.ROSEWOOD_PLANKS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> ROSEWOOD_SLAB = fromBlock(BlockRegistry.ROSEWOOD_SLAB, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> ROSEWOOD_STAIRS = fromBlock(BlockRegistry.ROSEWOOD_STAIRS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> ROSEWOOD_FENCE = fromBlock(BlockRegistry.ROSEWOOD_FENCE, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BAMBOO_MAT = fromBlock(BlockRegistry.BAMBOO_MAT, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BAMBOO_MAT_SLAB = fromBlock(BlockRegistry.BAMBOO_MAT_SLAB, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BAMBOO_MAT_STAIRS = fromBlock(BlockRegistry.BAMBOO_MAT_STAIRS, CreativeTabs.BUILDING_BLOCKS);

    public static final RegistryObject<Item> CABBAGE_BASKET = fromBlock(BlockRegistry.CABBAGE_BASKET, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CELERY_BASKET = fromBlock(BlockRegistry.CELERY_BASKET, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> ORANGE_BASKET = fromBlock(BlockRegistry.ORANGE_BASKET, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> APPLE_BASKET = fromBlock(BlockRegistry.APPLE_BASKET, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> EGGPLANT_BASKET = fromBlock(BlockRegistry.EGGPLANT_BASKET, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> PEAR_BASKET = fromBlock(BlockRegistry.PEAR_BASKET, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> ENGRAVED_DARK_OAK_BEAM_EDGE = fromBlock(BlockRegistry.ENGRAVED_DARK_OAK_BEAM_EDGE, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> ENGRAVED_DARK_OAK_BEAM = fromBlock(BlockRegistry.ENGRAVED_DARK_OAK_BEAM, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CARVED_RED_PILLAR = fromBlock(BlockRegistry.CARVED_RED_PILLAR, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CARVED_RED_PILLAR_BASE = fromBlock(BlockRegistry.CARVED_RED_PILLAR_BASE, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CARVED_RED_PILLAR_HEAD = fromBlock(BlockRegistry.CARVED_RED_PILLAR_HEAD, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GILDED_DARK_OAK = fromBlock(BlockRegistry.GILDED_DARK_OAK, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CHISELED_GILDED_DARK_OAK = fromBlock(BlockRegistry.CHISELED_GILDED_DARK_OAK, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GILDED_DARK_OAK_SLAB = fromBlock(BlockRegistry.GILDED_DARK_OAK_SLAB, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GILDED_DARK_OAK_STAIRS = fromBlock(BlockRegistry.GILDED_DARK_OAK_STAIRS, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GILDED_DARK_OAK_RAFTER = fromBlock(BlockRegistry.GILDED_DARK_OAK_RAFTER, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GILDED_DARK_OAK_RAFTER_END = fromBlock(BlockRegistry.GILDED_DARK_OAK_RAFTER_END, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GILDED_DARK_OAK_BEAM_HEAD = fromBlock(BlockRegistry.GILDED_DARK_OAK_BEAM_HEAD, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GILDED_DARK_OAK_BEAM_BRACKET = fromBlock(BlockRegistry.GILDED_DARK_OAK_BRACKET, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> WHITE_MARBLE_RAILING = fromBlock(BlockRegistry.WHITE_MARBLE_RAILING, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GREEN_FANGXIN = fromBlock(BlockRegistry.GREEN_FANGXIN, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GREEN_FANGXIN_EDGE = fromBlock(BlockRegistry.GREEN_FANGXIN_EDGE, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_FANGXIN_EDGE = fromBlock(BlockRegistry.BLUE_FANGXIN_EDGE, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CYAN_AND_BLUE_FANGXIN_EDGE = fromBlock(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CYAN_AND_BLUE_FANGXIN_EDGE_VARIANT = fromBlock(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE_VARIANT, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CYAN_BLUE_WHITE_FANGXIN_EDGE = fromBlock(BlockRegistry.CYAN_BLUE_WHITE_FANGXIN_EDGE, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_AND_GREEN_FANGXIN_EDGE = fromBlock(BlockRegistry.BLUE_AND_GREEN_FANGXIN_EDGE, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> YELLOW_AND_GREEN_FANGXIN_EDGE = fromBlock(BlockRegistry.YELLOW_AND_GREEN_FANGXIN_EDGE, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> DARK_BLUE_FANGXIN_EDGE = fromBlock(BlockRegistry.DARK_BLUE_FANGXIN_EDGE, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_FANGXIN = fromBlock(BlockRegistry.BLUE_FANGXIN, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CYAN_AND_BLUE_FANGXIN = fromBlock(BlockRegistry.CYAN_AND_BLUE_FANGXIN, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> CYAN_BLUE_WHITE_FANGXIN = fromBlock(BlockRegistry.CYAN_BLUE_WHITE_FANGXIN, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> BLUE_AND_WHITE_FANGXIN = fromBlock(BlockRegistry.BLUE_AND_WHITE_FANGXIN, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> GREEN_AND_DARK_BLUE_FANGXIN = fromBlock(BlockRegistry.GREEN_AND_DARK_BLUE_FANGXIN, CreativeTabs.DECORATIVE_BLOCKS);
    public static final RegistryObject<Item> DARK_BLUE_FANGXIN = fromBlock(BlockRegistry.DARK_BLUE_FANGXIN, CreativeTabs.DECORATIVE_BLOCKS);


    public static final RegistryObject<Item> WOODEN_HAMMER = ITEMS.register("wooden_hammer", WoodenHammer::new);
    public static final RegistryObject<Item> GRAY_ROOF_TILES = fromBlock(BlockRegistry.GRAY_ROOF_TILES, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> GRAY_ROOF_TILE_STAIRS = fromBlock(BlockRegistry.GRAY_ROOF_TILE_STAIRS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> GRAY_ROOF_TILE_EDGE = fromBlock(BlockRegistry.GRAY_ROOF_TILE_EDGE, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> YELLOW_ROOF_TILES = fromBlock(BlockRegistry.YELLOW_ROOF_TILES, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> YELLOW_ROOF_TILE_STAIRS = fromBlock(BlockRegistry.YELLOW_ROOF_TILE_STAIRS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> YELLOW_ROOF_TILE_EDGE = fromBlock(BlockRegistry.YELLOW_ROOF_TILE_EDGE, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> GREEN_ROOF_TILES = fromBlock(BlockRegistry.GREEN_ROOF_TILES, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> GREEN_ROOF_TILE_STAIRS = fromBlock(BlockRegistry.GREEN_ROOF_TILE_STAIRS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> GREEN_ROOF_TILE_EDGE = fromBlock(BlockRegistry.GREEN_ROOF_TILE_EDGE, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLUE_ROOF_TILES = fromBlock(BlockRegistry.BLUE_ROOF_TILES, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLUE_ROOF_TILE_STAIRS = fromBlock(BlockRegistry.BLUE_ROOF_TILE_STAIRS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLUE_ROOF_TILE_EDGE = fromBlock(BlockRegistry.BLUE_ROOF_TILE_EDGE, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CYAN_ROOF_TILES = fromBlock(BlockRegistry.CYAN_ROOF_TILES, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CYAN_ROOF_TILE_STAIRS = fromBlock(BlockRegistry.CYAN_ROOF_TILE_STAIRS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CYAN_ROOF_TILE_EDGE = fromBlock(BlockRegistry.CYAN_ROOF_TILE_EDGE, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_ROOF_TILES = fromBlock(BlockRegistry.BLACK_ROOF_TILES, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_ROOF_TILE_STAIRS = fromBlock(BlockRegistry.BLACK_ROOF_TILE_STAIRS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BLACK_ROOF_TILE_EDGE = fromBlock(BlockRegistry.BLACK_ROOF_TILE_EDGE, CreativeTabs.BUILDING_BLOCKS);

    public static final RegistryObject<Item> ABACUS = fromBlock(BlockRegistry.ABACUS, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> BRUSH_TOOLS = fromBlock(BlockRegistry.BRUSH_TOOLS, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> BRUSH_AND_INKSTONE = fromBlock(BlockRegistry.BRUSH_AND_INKSTONE, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> SACK = fromBlock(BlockRegistry.SACK, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> BAMBOO_TEA_BASKET = fromBlock(BlockRegistry.BAMBOO_TEA_BASKET, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> EMPTY_BAMBOO_TEA_BASKET = fromBlock(BlockRegistry.EMPTY_BAMBOO_TEA_BASKET, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> STRAW_HAT = fromBlock(BlockRegistry.STRAW_HAT, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> RULER = fromBlock(BlockRegistry.RULER, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> KNIFE = fromBlock(BlockRegistry.KNIFE, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> RED_SILK_FABRIC_ROLL = fromBlock(BlockRegistry.RED_SILK_FABRIC_ROLL, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> GREEN_SILK_FABRIC_ROLL = fromBlock(BlockRegistry.GREEN_SILK_FABRIC_ROLL, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> PURPLE_SILK_FABRIC_ROLL = fromBlock(BlockRegistry.PURPLE_SILK_FABRIC_ROLL, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> CLAY_DOLL_MALE = fromBlock(BlockRegistry.CLAY_DOLL_MALE, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> CLAY_DOLL_FEMALE = fromBlock(BlockRegistry.CLAY_DOLL_FEMALE, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> BOTTLE_GOURD = fromBlock(BlockRegistry.BOTTLE_GOURD, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> BLUE_AND_WHITE_PORCELAIN_FLOWERPOT = fromBlock(BlockRegistry.BLUE_AND_WHITE_PORCELAIN_FLOWERPOT, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> TERRACOTTA_FLOWERPOT = fromBlock(BlockRegistry.TERRACOTTA_FLOWERPOT, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> BLACK_IRON_FLOWERPOT = fromBlock(BlockRegistry.BLACK_IRON_FLOWERPOT, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> BLUE_PORCELAIN_FLOWERPOT = fromBlock(BlockRegistry.BLUE_PORCELAIN_FLOWERPOT, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> PAINTING_SCROLL = fromBlock(BlockRegistry.PAINTING_SCROLL, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> BACK_CUSHION = fromBlock(BlockRegistry.BACK_CUSHION, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> CHESSBOARD = fromBlock(BlockRegistry.CHESSBOARD, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> MEMORIAL_TABLET = fromBlock(BlockRegistry.MEMORIAL_TABLET, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> BLUE_AND_WHITE_PORCELAIN_VASE = fromBlock(BlockRegistry.BLUE_AND_WHITE_PORCELAIN_VASE, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> LARGE_BLUE_AND_WHITE_PORCELAIN_VASE = fromBlock(BlockRegistry.LARGE_BLUE_AND_WHITE_PORCELAIN_VASE, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> SHORT_BLUE_AND_WHITE_PORCELAIN_POT = fromBlock(BlockRegistry.SHORT_BLUE_AND_WHITE_PORCELAIN_POT, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> TALL_BLUE_AND_WHITE_PORCELAIN_POT = fromBlock(BlockRegistry.TALL_BLUE_AND_WHITE_PORCELAIN_POT, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> BLUE_AND_WHITE_PORCELAIN_BOWL = fromBlock(BlockRegistry.BLUE_AND_WHITE_PORCELAIN_BOWL, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> BRONZE_CENSER = fromBlock(BlockRegistry.BRONZE_CENSER, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> ROYAL_CENSER = fromBlock(BlockRegistry.ROYAL_CENSER, CreativeTabs.DECORATIONS);

    public static final RegistryObject<Item> LONG_HANGING_PAINTING = fromBlock(BlockRegistry.LONG_HANGING_PAINTING, CreativeTabs.DECORATIONS);

    public static final RegistryObject<Item> FRUIT_BOX = fromBlock(BlockRegistry.FRUIT_BOX, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> WOODEN_CRATE = fromBlock(BlockRegistry.WOODEN_CRATE, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> GUNNY_SACK = fromBlock(BlockRegistry.GUNNY_SACK, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> FOOD_HAMPER = fromBlock(BlockRegistry.FOOD_HAMPER, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> PLATED_MOON_CAKES = fromBlock(BlockRegistry.PLATED_MOONCAKES, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> PLATED_MUNG_BEAN_CAKES = fromBlock(BlockRegistry.PLATED_MUNG_BEAN_CAKES, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> PLATED_HAM = fromBlock(BlockRegistry.PLATED_HAM, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> PLATED_FISH = fromBlock(BlockRegistry.PLATED_FISH, CreativeTabs.DECORATIONS);

    public static final RegistryObject<Item> OCTAGONAL_PALACE_LANTERN = fromBlock(BlockRegistry.OCTAGONAL_PALACE_LANTERN, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> SQUARE_PALACE_LANTERN = fromBlock(BlockRegistry.SQUARE_PALACE_LANTERN, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> SMALL_RED_LANTERN = fromBlock(BlockRegistry.SMALL_RED_LANTERN, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> STANDING_LAMP = fromBlock(BlockRegistry.STANDING_LAMP, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> SMALL_STANDING_LAMP = fromBlock(BlockRegistry.SMALL_STANDING_LAMP, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> WHITE_SKY_LANTERN = fromBlock(BlockRegistry.WHITE_SKY_LANTERN, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> RED_SKY_LANTERN = fromBlock(BlockRegistry.RED_SKY_LANTERN, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> YELLOW_SKY_LANTERN = fromBlock(BlockRegistry.YELLOW_SKY_LANTERN, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> STONE_LAMP = fromBlock(BlockRegistry.STONE_LAMP, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> RED_CANDLE = fromBlock(BlockRegistry.RED_CANDLE, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> TRICOLOR_CANDLESTICK = fromBlock(BlockRegistry.TRICOLOR_CANDLESTICK, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> JADE_CANDLESTICK = fromBlock(BlockRegistry.JADE_CANDLESTICK, CreativeTabs.LAMPS);

    public static final RegistryObject<Item> OAK_CABINET = fromBlock(BlockRegistry.OAK_CABINET, CreativeTabs.FURNITURE);
    public static final RegistryObject<Item> WARPED_CABINET = fromBlock(BlockRegistry.WARPED_CABINET, CreativeTabs.FURNITURE);
    public static final RegistryObject<Item> EBONY_CABINET = fromBlock(BlockRegistry.EBONY_CABINET, CreativeTabs.FURNITURE);
    public static final RegistryObject<Item> EBONY_CHAIR = fromBlock(BlockRegistry.EBONY_CHAIR, CreativeTabs.FURNITURE);

    public static final RegistryObject<Item> CARVED_WOODEN_DOOR = fromBlock(BlockRegistry.CARVED_WOODEN_DOOR, CreativeTabs.WINDOWS_AND_DOORS);
    public static final RegistryObject<Item> CARVED_WOODEN_DOOR_PANEL = fromBlock(BlockRegistry.CARVED_WOODEN_DOOR_PANEL, CreativeTabs.WINDOWS_AND_DOORS);
    public static final RegistryObject<Item> SONG_WOODEN_DOOR = fromBlock(BlockRegistry.SONG_WOODEN_DOOR, CreativeTabs.WINDOWS_AND_DOORS);
    public static final RegistryObject<Item> SONG_WOODEN_WINDOW = fromBlock(BlockRegistry.SONG_WOODEN_WINDOW, CreativeTabs.WINDOWS_AND_DOORS);

    public static final RegistryObject<Item> CYAN_BRICK = simpleItem("cyan_brick", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> BLACK_BRICK = simpleItem("black_brick", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> BROWNISH_RED_STONE_BRICK = simpleItem("brownish_red_stone_brick", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> GRAY_ROOF_TILE = simpleItem("gray_roof_tile", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> YELLOW_ROOF_TILE = simpleItem("yellow_roof_tile", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> GREEN_ROOF_TILE = simpleItem("green_roof_tile", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> BLUE_ROOF_TILE = simpleItem("blue_roof_tile", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> CYAN_ROOF_TILE = simpleItem("cyan_roof_tile", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> BLACK_ROOF_TILE = simpleItem("black_roof_tile", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> RAW_CLAY_BRICK = simpleItem("raw_clay_brick", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> RAW_CYAN_BRICK = simpleItem("raw_cyan_brick", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> RAW_BLACK_BRICK = simpleItem("raw_black_brick", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> RAW_BROWNISH_RED_STONE_BRICK = simpleItem("raw_brownish_red_stone_brick", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> PRISMARINE_DUST = simpleItem("prismarine_dust", CreativeTabs.MATERIALS);

    public static final RegistryObject<Item> POLISHED_OAK_PLANK = simpleItem("polished_oak_plank", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> POLISHED_BIRCH_PLANK = simpleItem("polished_birch_plank", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> POLISHED_SPRUCE_PLANK = simpleItem("polished_spruce_plank", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> POLISHED_JUNGLE_PLANK = simpleItem("polished_jungle_plank", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> POLISHED_ACACIA_PLANK = simpleItem("polished_acacia_plank", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> POLISHED_DARK_OAK_PLANK = simpleItem("polished_dark_oak_plank", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> POLISHED_WARPED_PLANK = simpleItem("polished_warped_plank", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> POLISHED_CRIMSON_PLANK = simpleItem("polished_crimson_plank", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> POLISHED_ROSEWOOD_PLANK = simpleItem("polished_rosewood_plank", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> POLISHED_EBONY_PLANK = simpleItem("polished_ebony_plank", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> WOODEN_FRAME = simpleItem("wooden_frame", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> BLUE_AND_WHITE_PORCELAIN_PIECE = simpleItem("blue_and_white_porcelain_piece", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> BLUE_AND_WHITE_PORCELAIN_SHARDS = simpleItem("blue_and_white_porcelain_shards", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> WOODEN_PARTS = simpleItem("wooden_parts", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> GOLD_PARTS = simpleItem("gold_parts", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> JADE_PARTS = simpleItem("jade_parts", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> PORCELAIN_PARTS = simpleItem("porcelain_parts", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> INCENSE = simpleItem("incense", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> JADE_ORE = fromBlock(BlockRegistry.JADE_ORE, CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> JADE = simpleItem("jade", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> MAGNESITE_ORE = fromBlock(BlockRegistry.MAGNESITE_ORE, CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> MAGNESITE = simpleItem("magnesite", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> MAGNESITE_DUST = simpleItem("magnesite_dust", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> HEMATITE_ORE = fromBlock(BlockRegistry.HEMATITE_ORE, CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> RAW_HEMATITE = simpleItem("raw_hematite", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> HEMATITE_DUST = simpleItem("hematite_dust", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> MOONCAKE = ITEMS.register("mooncake", () -> new BaseFood(ModFoods.MOONCAKE));
    public static final RegistryObject<Item> MUNG_BEAN_CAKE = ITEMS.register("mung_bean_cake", () -> new BaseFood(ModFoods.MUNG_BEAN_CAKE));
    public static final RegistryObject<Item> RAW_MEAT = ITEMS.register("raw_meat", () -> new BaseFood(ModFoods.RAW_MEAT));
    public static final RegistryObject<Item> COOKED_MEAT = ITEMS.register("cooked_meat", () -> new BaseFood(ModFoods.COOKED_MEAT));
    public static final RegistryObject<Item> BAOZI = ITEMS.register("baozi", () -> new BaseFood(ModFoods.BAOZI));
    public static final RegistryObject<Item> FUR = simpleItem("fur", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> GREASE = simpleItem("grease", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> SILK = simpleItem("silk", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> XUAN_PAPER = simpleItem("xuan_paper", CreativeTabs.MATERIALS);

    public static final RegistryObject<Item> COPPER_CASH_COIN = simpleItem("copper_cash_coin", CreativeTabs.MATERIALS);

    public static final RegistryObject<Item> WOODWORKING_WORKBENCH = fromBlock(BlockRegistry.WOODWORKING_WORKBENCH, CreativeTabs.TOOLS);

    private static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block, CreativeModeTab tab) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    private static RegistryObject<Item> simpleItem(String name, CreativeModeTab tab) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().tab(tab)));
    }

}
