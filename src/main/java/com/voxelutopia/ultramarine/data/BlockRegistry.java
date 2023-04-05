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
    public static final RegistryObject<Block> BAMBOO_MAT = BLOCKS.register("bamboo_mat", () -> new BaseBlock(BaseBlockProperty.WOOD));
    public static final RegistryObject<Block> BAMBOO_MAT_SLAB = BLOCKS.register("bamboo_mat_slab", () -> new BaseSlab((BaseBlock) BAMBOO_MAT.get()));
    public static final RegistryObject<Block> BAMBOO_MAT_STAIRS = BLOCKS.register("bamboo_mat_stairs", () -> new BaseStairs((BaseBlock) BAMBOO_MAT.get()));


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

    public static final RegistryObject<Block> ABACUS = BLOCKS.register("abacus",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FLAT_MEDIUM).directional().diagonallyPlaceable().noCollision().build());
    public static final RegistryObject<Block> BOTTLE_GOURD = BLOCKS.register("bottle_gourd", BottleGourd::new);
    public static final RegistryObject<Block> BLUE_AND_WHITE_PORCELAIN_VASE = BLOCKS.register("blue_and_white_porcelain_vase",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.VASE).diagonallyPlaceable().build());
    public static final RegistryObject<Block> BIG_BLUE_AND_WHITE_PORCELAIN_VASE = BLOCKS.register("big_blue_and_white_porcelain_vase",
            () -> DecorativeBlock.with(BaseBlockProperty.PORCELAIN).shaped(DecorativeBlock.CUBE_14).directional().build());
    public static final RegistryObject<Block> OCTAGONAL_PALACE_LANTERN = BLOCKS.register("octagonal_palace_lantern",
            () -> OffsetDecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_BLOCK).luminous().noOcclusion().build());
    public static final RegistryObject<Block> SQUARE_PALACE_LANTERN = BLOCKS.register("square_palace_lantern",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_BLOCK).diagonallyPlaceable().luminous().noOcclusion().build());
    public static final RegistryObject<Block> SMALL_RED_LANTERN = BLOCKS.register("small_red_lantern",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.FULL_BLOCK).diagonallyPlaceable().luminous().build());
    public static final RegistryObject<Block> STANDING_LAMP = BLOCKS.register("standing_lamp",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.LAMP).diagonallyPlaceable().luminous().noOcclusion().build());
    public static final RegistryObject<Block> SMALL_STANDING_LAMP = BLOCKS.register("small_standing_lamp",
            () -> DecorativeBlock.with(BaseBlockProperty.WOOD).shaped(DecorativeBlock.LAMP).diagonallyPlaceable().luminous().build());
    public static final RegistryObject<Block> WHITE_SKY_LANTERN = BLOCKS.register("white_sky_lantern",
            () -> DecorativeBlock.with(BaseBlockProperty.BAMBOO).luminous().build());
    public static final RegistryObject<Block> RED_SKY_LANTERN = BLOCKS.register("red_sky_lantern",
            () -> DecorativeBlock.with(BaseBlockProperty.BAMBOO).luminous().build());
    public static final RegistryObject<Block> YELLOW_SKY_LANTERN = BLOCKS.register("yellow_sky_lantern",
            () -> DecorativeBlock.with(BaseBlockProperty.BAMBOO).luminous().build());

    public static final RegistryObject<Block> JADE_ORE = BLOCKS.register("jade_ore",() -> new BaseOreBlock(2, 5));

    private static RegistryObject<Block> simpleBlock(String name, Material material) {
        return BLOCKS.register(name, () -> new Block(BlockBehaviour.Properties.of(material)));
    }
}
