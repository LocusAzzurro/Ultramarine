package com.voxelutopia.ultramarine.data;

import com.voxelutopia.ultramarine.Ultramarine;
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
    public static final RegistryObject<Item> BAMBOO_MAT = fromBlock(BlockRegistry.BAMBOO_MAT, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BAMBOO_MAT_SLAB = fromBlock(BlockRegistry.BAMBOO_MAT_SLAB, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> BAMBOO_MAT_STAIRS = fromBlock(BlockRegistry.BAMBOO_MAT_STAIRS, CreativeTabs.BUILDING_BLOCKS);


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


    public static final RegistryObject<Item> ABACUS = fromBlock(BlockRegistry.ABACUS, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> BOTTLE_GOURD = fromBlock(BlockRegistry.BOTTLE_GOURD, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> BLUE_AND_WHITE_PORCELAIN_VASE = fromBlock(BlockRegistry.BLUE_AND_WHITE_PORCELAIN_VASE, CreativeTabs.DECORATIONS);
    public static final RegistryObject<Item> BIG_BLUE_AND_WHITE_PORCELAIN_VASE = fromBlock(BlockRegistry.BIG_BLUE_AND_WHITE_PORCELAIN_VASE, CreativeTabs.DECORATIONS);


    public static final RegistryObject<Item> OCTAGONAL_PALACE_LANTERN = fromBlock(BlockRegistry.OCTAGONAL_PALACE_LANTERN, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> SQUARE_PALACE_LANTERN = fromBlock(BlockRegistry.SQUARE_PALACE_LANTERN, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> SMALL_RED_LANTERN = fromBlock(BlockRegistry.SMALL_RED_LANTERN, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> STANDING_LAMP = fromBlock(BlockRegistry.STANDING_LAMP, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> SMALL_STANDING_LAMP = fromBlock(BlockRegistry.SMALL_STANDING_LAMP, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> WHITE_SKY_LANTERN = fromBlock(BlockRegistry.WHITE_SKY_LANTERN, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> RED_SKY_LANTERN = fromBlock(BlockRegistry.RED_SKY_LANTERN, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> YELLOW_SKY_LANTERN = fromBlock(BlockRegistry.YELLOW_SKY_LANTERN, CreativeTabs.LAMPS);

    public static final RegistryObject<Item> CYAN_BRICK = simpleItem("cyan_brick", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> GRAY_ROOF_TILE = simpleItem("gray_roof_tile", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> YELLOW_ROOF_TILE = simpleItem("yellow_roof_tile", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> GREEN_ROOF_TILE = simpleItem("green_roof_tile", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> BLUE_ROOF_TILE = simpleItem("blue_roof_tile", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> CYAN_ROOF_TILE = simpleItem("cyan_roof_tile", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> BLACK_ROOF_TILE = simpleItem("black_roof_tile", CreativeTabs.MATERIALS);

    public static final RegistryObject<Item> BLUE_AND_WHITE_PORCELAIN_PIECE = simpleItem("blue_and_white_porcelain_piece", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> BLUE_AND_WHITE_PORCELAIN_SHARDS = simpleItem("blue_and_white_porcelain_shards", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> JADE_ORE = fromBlock(BlockRegistry.JADE_ORE, CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> JADE = simpleItem("jade", CreativeTabs.MATERIALS);

    private static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block, CreativeModeTab tab) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    private static RegistryObject<Item> simpleItem(String name, CreativeModeTab tab) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().tab(tab)));
    }

}
