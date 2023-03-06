package com.voxelutopia.ultramarine.data;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.world.block.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ultramarine.MOD_ID);
    public static final RegistryObject<Block> CYAN_BRICKS = BLOCKS.register("cyan_bricks", BaseStone::new);
    public static final RegistryObject<Block> CYAN_BRICK_SLAB = BLOCKS.register("cyan_brick_slab", BaseStoneSlab::new);
    public static final RegistryObject<Block> CYAN_BRICK_STAIRS = BLOCKS.register("cyan_brick_stairs", BaseStoneStairs::new);
    public static final RegistryObject<Block> BLACK_BRICKS = BLOCKS.register("black_bricks", BaseStone::new);
    public static final RegistryObject<Block> BLACK_BRICK_SLAB = BLOCKS.register("black_brick_slab", BaseStoneSlab::new);
    public static final RegistryObject<Block> BLACK_BRICK_STAIRS = BLOCKS.register("black_brick_stairs", BaseStoneStairs::new);
    public static final RegistryObject<Block> PALE_YELLOW_STONE = BLOCKS.register("pale_yellow_stone", BaseStone::new);
    public static final RegistryObject<Block> PALE_YELLOW_STONE_SLAB = BLOCKS.register("pale_yellow_stone_slab", BaseStoneSlab::new);
    public static final RegistryObject<Block> PALE_YELLOW_STONE_STAIRS = BLOCKS.register("pale_yellow_stone_stairs", BaseStoneStairs::new);
    public static final RegistryObject<Block> WEATHERED_STONE = BLOCKS.register("weathered_stone", BaseStone::new);
    public static final RegistryObject<Block> WEATHERED_STONE_SLAB = BLOCKS.register("weathered_stone_slab", BaseStoneSlab::new);
    public static final RegistryObject<Block> WEATHERED_STONE_STAIRS = BLOCKS.register("weathered_stone_stairs", BaseStoneStairs::new);
    public static final RegistryObject<Block> GRAY_ROOF_TILES = BLOCKS.register("gray_roof_tiles", RoofTiles::new);
    public static final RegistryObject<Block> GRAY_ROOF_TILE_STAIRS = BLOCKS.register("gray_roof_tile_stairs", RoofTiles::new);
    public static final RegistryObject<Block> GRAY_ROOF_TILE_EDGE = BLOCKS.register("gray_roof_tile_edge", RoofTiles::new);
    public static final RegistryObject<Block> YELLOW_ROOF_TILES = BLOCKS.register("yellow_roof_tiles", RoofTiles::new);
    public static final RegistryObject<Block> YELLOW_ROOF_TILE_STAIRS = BLOCKS.register("yellow_roof_tile_stairs", RoofTiles::new);
    public static final RegistryObject<Block> YELLOW_ROOF_TILE_EDGE = BLOCKS.register("yellow_roof_tile_edge", RoofTiles::new);
    public static final RegistryObject<Block> GREEN_ROOF_TILES = BLOCKS.register("green_roof_tiles", RoofTiles::new);
    public static final RegistryObject<Block> GREEN_ROOF_TILE_STAIRS = BLOCKS.register("green_roof_tile_stairs", RoofTiles::new);
    public static final RegistryObject<Block> GREEN_ROOF_TILE_EDGE = BLOCKS.register("green_roof_tile_edge", RoofTiles::new);
    public static final RegistryObject<Block> BLUE_ROOF_TILES = BLOCKS.register("blue_roof_tiles", RoofTiles::new);
    public static final RegistryObject<Block> BLUE_ROOF_TILE_STAIRS = BLOCKS.register("blue_roof_tile_stairs", RoofTiles::new);
    public static final RegistryObject<Block> BLUE_ROOF_TILE_EDGE = BLOCKS.register("blue_roof_tile_edge", RoofTiles::new);
    public static final RegistryObject<Block> OCTAGONAL_PALACE_LANTERN = BLOCKS.register("octagonal_palace_lantern", () -> new OffsetLantern(Material.WOOD));
    public static final RegistryObject<Block> SQUARE_PALACE_LANTERN = BLOCKS.register("square_palace_lantern", () -> new DiagonalLantern(Material.WOOD));
    public static final RegistryObject<Block> WHITE_SKY_LANTERN = BLOCKS.register("white_sky_lantern", () -> new Lantern(Material.BAMBOO));
    public static final RegistryObject<Block> RED_SKY_LANTERN = BLOCKS.register("red_sky_lantern", () -> new Lantern(Material.BAMBOO));
    public static final RegistryObject<Block> YELLOW_SKY_LANTERN = BLOCKS.register("yellow_sky_lantern", () -> new Lantern(Material.BAMBOO));

    public static final RegistryObject<Block> JADE_ORE = BLOCKS.register("jade_ore", BaseOreBlock::new);

    private static RegistryObject<Block> simpleBlock(String name, Material material) {
        return BLOCKS.register(name, () -> new Block(BlockBehaviour.Properties.of(material)));
    }
}
