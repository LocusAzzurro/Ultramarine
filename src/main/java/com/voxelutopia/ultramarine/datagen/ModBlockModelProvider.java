package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.world.block.state.ChiralBlockType;
import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import com.voxelutopia.ultramarine.world.block.*;
import com.voxelutopia.ultramarine.world.block.state.OrientableBlockType;
import com.voxelutopia.ultramarine.world.block.state.StackableBlockType;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;

import static com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties.*;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.*;

@SuppressWarnings("unused")
public class ModBlockModelProvider extends BlockStateProvider {

    public static final String BLOCK = "block/";
    private final Map<Pair<Direction, Direction>, Integer> rotations = Map.of(
            Pair.of(Direction.NORTH, Direction.EAST), 0,
            Pair.of(Direction.EAST, Direction.NORTH), 0,
            Pair.of(Direction.EAST, Direction.SOUTH), 90,
            Pair.of(Direction.SOUTH, Direction.EAST), 90,
            Pair.of(Direction.SOUTH, Direction.WEST), 180,
            Pair.of(Direction.WEST, Direction.SOUTH), 180,
            Pair.of(Direction.WEST, Direction.NORTH), 270,
            Pair.of(Direction.NORTH, Direction.WEST), 270
    );
    private final Map<RegistryObject<Block>, Integer> ROTATED_DECO = Map.of(
            BlockRegistry.CARRIAGE, 90,
            BlockRegistry.WOODEN_POLES, 90,
            BlockRegistry.GOLDEN_GLAZED_ROOF_CHARM, -90,
            BlockRegistry.GREEN_GLAZED_ROOF_CHARM, -90
    );

    public ModBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DataGenerators.MOD_ID, existingFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        simpleBlock(BlockRegistry.CYAN_BRICKS.get());
        slabAndStairs(BlockRegistry.CYAN_BRICKS.get(), BlockRegistry.CYAN_BRICK_SLAB.get(), BlockRegistry.CYAN_BRICK_STAIRS.get());
        wall(BlockRegistry.CYAN_BRICKS.get(), BlockRegistry.CYAN_BRICK_WALL.get());
        simpleBlock(BlockRegistry.BLACK_BRICKS.get());
        slabAndStairs(BlockRegistry.BLACK_BRICKS.get(), BlockRegistry.BLACK_BRICK_SLAB.get(), BlockRegistry.BLACK_BRICK_STAIRS.get());
        wall(BlockRegistry.BLACK_BRICKS.get(), BlockRegistry.BLACK_BRICK_WALL.get());
        simpleBlock(BlockRegistry.BROWNISH_RED_STONE_BRICKS.get());
        slabAndStairs(BlockRegistry.BROWNISH_RED_STONE_BRICKS.get(), BlockRegistry.BROWNISH_RED_STONE_BRICK_SLAB.get(), BlockRegistry.BROWNISH_RED_STONE_BRICK_STAIRS.get());
        wall(BlockRegistry.BROWNISH_RED_STONE_BRICKS.get(), BlockRegistry.BROWNISH_RED_STONE_BRICK_WALL.get());
        simpleBlock(BlockRegistry.PALE_YELLOW_STONE.get());
        slabAndStairs(BlockRegistry.PALE_YELLOW_STONE.get(), BlockRegistry.PALE_YELLOW_STONE_SLAB.get(), BlockRegistry.PALE_YELLOW_STONE_STAIRS.get());
        simpleBlock(BlockRegistry.VARIEGATED_ROCKS.get());
        slabAndStairs(BlockRegistry.VARIEGATED_ROCKS.get(), BlockRegistry.VARIEGATED_ROCK_SLAB.get(), BlockRegistry.VARIEGATED_ROCK_STAIRS.get());
        simpleBlock(BlockRegistry.WEATHERED_STONE.get());
        slabAndStairs(BlockRegistry.WEATHERED_STONE.get(), BlockRegistry.WEATHERED_STONE_SLAB.get(), BlockRegistry.WEATHERED_STONE_STAIRS.get());
        simpleBlock(BlockRegistry.POLISHED_WEATHERED_STONE.get());
        slabAndStairs(BlockRegistry.POLISHED_WEATHERED_STONE.get(), BlockRegistry.POLISHED_WEATHERED_STONE_SLAB.get(), BlockRegistry.POLISHED_WEATHERED_STONE_STAIRS.get());
        simpleBlock(BlockRegistry.LIGHT_CYAN_FLOOR_TILE.get());
        slabAndStairs(BlockRegistry.LIGHT_CYAN_FLOOR_TILE.get(), BlockRegistry.LIGHT_CYAN_FLOOR_TILE_SLAB.get(), BlockRegistry.LIGHT_CYAN_FLOOR_TILE_STAIRS.get());
        wall(BlockRegistry.LIGHT_CYAN_FLOOR_TILE.get(), BlockRegistry.LIGHT_CYAN_FLOOR_TILE_WALL.get());
        simpleBlock(BlockRegistry.ROSEWOOD_PLANKS.get());
        slabAndStairs(BlockRegistry.ROSEWOOD_PLANKS.get(), BlockRegistry.ROSEWOOD_SLAB.get(), BlockRegistry.ROSEWOOD_STAIRS.get());
        fence(BlockRegistry.ROSEWOOD_PLANKS.get(), BlockRegistry.ROSEWOOD_FENCE.get());
        simpleBlock(BlockRegistry.BAMBOO_MAT.get());
        slabAndStairs(BlockRegistry.BAMBOO_MAT.get(), BlockRegistry.BAMBOO_MAT_SLAB.get(), BlockRegistry.BAMBOO_MAT_STAIRS.get());
        wall(BlockRegistry.POLISHED_WEATHERED_STONE.get(), BlockRegistry.POLISHED_WEATHERED_STONE_WALL.get());
        simpleBlock(BlockRegistry.CYAN_FLOOR_TILE.get());
        slabAndStairs(BlockRegistry.CYAN_FLOOR_TILE.get(), BlockRegistry.CYAN_FLOOR_TILE_SLAB.get(), BlockRegistry.CYAN_FLOOR_TILE_STAIRS.get());
        wall(BlockRegistry.CYAN_FLOOR_TILE.get(), BlockRegistry.CYAN_FLOOR_TILE_WALL.get());
        simpleBlock(BlockRegistry.GREEN_GLAZED_TILES.get());
        slabAndStairs(BlockRegistry.GREEN_GLAZED_TILES.get(), BlockRegistry.GREEN_GLAZED_TILE_SLAB.get(), BlockRegistry.GREEN_GLAZED_TILE_STAIRS.get());
        simpleBlock(BlockRegistry.WHITE_AMD_PINK_MIXED_BRICKS.get());
        simpleBlock(BlockRegistry.WEATHERED_RED_STONE_TILE.get());
        simpleBlock(BlockRegistry.BLUE_AND_BLACK_TILE.get());
        simpleBlock(BlockRegistry.GREEN_WEATHERED_STONE.get());
        simpleBlock(BlockRegistry.GREEN_WEATHERED_BRICKS.get());
        simpleBlock(BlockRegistry.DARK_CYAN_FLOOR_TILE.get());
        horizontalBlock(BlockRegistry.LAYERED_CYAN_FLOOR_TILES.get(), models().cubeAll(name(BlockRegistry.LAYERED_CYAN_FLOOR_TILES.get()), modBlockLoc(BlockRegistry.LAYERED_CYAN_FLOOR_TILES.get())));
        horizontalBlock(BlockRegistry.VERTICAL_CYAN_FLOOR_TILES.get(), models().cubeAll(name(BlockRegistry.VERTICAL_CYAN_FLOOR_TILES.get()), modBlockLoc(BlockRegistry.VERTICAL_CYAN_FLOOR_TILES.get())));
        horizontalBlock(BlockRegistry.MIXED_CYAN_FLOOR_TILES.get(), models().cubeAll(name(BlockRegistry.MIXED_CYAN_FLOOR_TILES.get()), modBlockLoc(BlockRegistry.MIXED_CYAN_FLOOR_TILES.get())));
        simpleBlock(BlockRegistry.CHISELED_CYAN_FLOOR_TILE.get());
        simpleBlock(BlockRegistry.CUT_CYAN_FLOOR_TILES.get());

        simpleBlock(BlockRegistry.CARVED_RED_PILLAR.get());
        sideBottomTop(BlockRegistry.CARVED_RED_PILLAR_BASE.get());
        directionalSideEnd(BlockRegistry.CARVED_RED_PILLAR_HEAD.get(), sideLoc(BlockRegistry.CARVED_RED_PILLAR_HEAD.get()), modBlockLoc(BlockRegistry.CARVED_RED_PILLAR.get()));
        chiralDirectionalBlock(BlockRegistry.ENGRAVED_DARK_OAK_BEAM.get());
        chiralDirectionalBlock(BlockRegistry.ENGRAVED_DARK_OAK_BEAM_EDGE.get());
        simpleBlock(BlockRegistry.GILDED_DARK_OAK.get());
        simpleBlock(BlockRegistry.CHISELED_GILDED_DARK_OAK.get());
        slabSideEnd(BlockRegistry.GILDED_DARK_OAK_SLAB.get(), BlockRegistry.GILDED_DARK_OAK.get(), sideLoc(BlockRegistry.GILDED_DARK_OAK_SLAB.get()), blockLoc(BlockRegistry.GILDED_DARK_OAK.get()));
        straightStairs(BlockRegistry.GILDED_DARK_OAK_STAIRS.get());
        horizontalBlockNoOffset(BlockRegistry.GILDED_DARK_OAK_BEAM_HEAD.get());
        horizontalBlockNoOffset(BlockRegistry.GILDED_DARK_OAK_BRACKET.get());
        railingBlock(BlockRegistry.WHITE_MARBLE_RAILING.get());
        railingBlock(BlockRegistry.CARVED_WOODEN_RAILING.get());


        simpleBlock(BlockRegistry.RED_CARVED_WOOD.get());
        carvedWoodenSlab(BlockRegistry.RED_CARVED_WOODEN_SLAB.get(), BlockRegistry.RED_CARVED_WOOD.get());
        straightStairs(BlockRegistry.RED_CARVED_WOODEN_STAIRS.get());
        simpleBlock(BlockRegistry.ORANGE_AND_BLUE_CARVED_WOOD.get());
        simpleBlock(BlockRegistry.ORANGE_AND_GREEN_CARVED_WOOD.get());
        simpleBlock(BlockRegistry.BLUE_CARVED_WOOD.get());
        carvedWoodenSlab(BlockRegistry.BLUE_CARVED_WOODEN_SLAB.get(), BlockRegistry.BLUE_CARVED_WOOD.get());
        straightStairs(BlockRegistry.BLUE_CARVED_WOODEN_STAIRS.get());
        straightStairs(BlockRegistry.BLUE_CARVED_WOODEN_BRACKET_STAIRS.get());
        horizontalBlockNoOffset(BlockRegistry.BLUE_CARVED_WOODEN_BRACKET.get());
        simpleBlock(BlockRegistry.GREEN_AND_BLUE_CARVED_WOOD.get());
        simpleBlock(BlockRegistry.GREEN_CARVED_WOOD.get());
        carvedWoodenSlab(BlockRegistry.GREEN_CARVED_WOODEN_SLAB.get(), BlockRegistry.GREEN_CARVED_WOOD.get());
        straightStairs(BlockRegistry.GREEN_CARVED_WOODEN_STAIRS.get());
        horizontalBlockNoOffset(BlockRegistry.GREEN_CARVED_WOODEN_BRACKET.get());
        simpleBlock(BlockRegistry.CYAN_CARVED_WOOD.get());
        carvedWoodenSlab(BlockRegistry.CYAN_CARVED_WOODEN_SLAB.get(), BlockRegistry.CYAN_CARVED_WOOD.get());
        straightStairs(BlockRegistry.CYAN_CARVED_WOODEN_STAIRS.get());
        horizontalBlockNoOffset(BlockRegistry.CYAN_CARVED_WOODEN_BRACKET.get());
        simpleBlock(BlockRegistry.DARK_GREEN_AND_DARK_BLUE_CARVED_WOOD.get());
        simpleBlock(BlockRegistry.DARK_BLUE_AND_DARK_GREEN_CARVED_WOOD.get());
        simpleBlock(BlockRegistry.BLACK_WHITE_GREEN_CARVED_WOOD.get());
        simpleBlock(BlockRegistry.BLACK_WHITE_BLUE_CARVED_WOOD.get());
        simpleBlock(BlockRegistry.RED_AND_GREEN_CARVED_WOOD.get());
        simpleBlock(BlockRegistry.BLUE_AND_WHITE_CARVED_WOOD.get());
        simpleBlock(BlockRegistry.BLUE_WHITE_RED_CARVED_WOOD.get());
        simpleBlock(BlockRegistry.GREEN_WHITE_RED_CARVED_WOOD.get());
        simpleBlock(BlockRegistry.RED_AND_CYAN_CARVED_ARCHITRAVE.get());
        slabSideEndNoFull(BlockRegistry.RED_AND_CYAN_CARVED_ARCHITRAVE_SLAB.get(), sideLoc(BlockRegistry.RED_AND_CYAN_CARVED_ARCHITRAVE_SLAB.get()), endLoc(BlockRegistry.RED_AND_CYAN_CARVED_ARCHITRAVE_SLAB.get()));
        simpleBlock(BlockRegistry.RED_AND_BLUE_CARVED_ARCHITRAVE.get());
        slabSideEndNoFull(BlockRegistry.RED_AND_BLUE_CARVED_ARCHITRAVE_SLAB.get(), sideLoc(BlockRegistry.RED_AND_BLUE_CARVED_ARCHITRAVE_SLAB.get()), endLoc(BlockRegistry.RED_AND_BLUE_CARVED_ARCHITRAVE_SLAB.get()));
        slabSideEndNoFull(BlockRegistry.EMPTY_TUANHUA_SLAB.get(), sideLoc(BlockRegistry.EMPTY_TUANHUA_SLAB.get()), endLoc(BlockRegistry.EMPTY_TUANHUA_SLAB.get()));
        slabSideEndNoFull(BlockRegistry.FULL_TUANHUA_SLAB.get(), sideLoc(BlockRegistry.FULL_TUANHUA_SLAB.get()), endLoc(BlockRegistry.EMPTY_TUANHUA_SLAB.get()));
        slabSideEndNoFull(BlockRegistry.RED_AND_CYAN_TUANHUA_SLAB.get(), sideLoc(BlockRegistry.RED_AND_CYAN_TUANHUA_SLAB.get()), endLoc(BlockRegistry.RED_AND_CYAN_TUANHUA_SLAB.get()));
        slabSideEndNoFull(BlockRegistry.RED_CARVED_ARCHITRAVE.get(), sideLoc(BlockRegistry.RED_CARVED_ARCHITRAVE.get()), mcLoc(BLOCK + "red_concrete_powder"));
        sideBottomTop(BlockRegistry.STRIPPED_DARK_OAK_PILLAR_BASE.get(), sideLoc(BlockRegistry.STRIPPED_DARK_OAK_PILLAR_BASE.get()), mcLoc(BLOCK + "smooth_stone"), mcLoc(BLOCK + "dark_oak_log_top"));
        sideBottomTop(BlockRegistry.SPRUCE_PILLAR_BASE.get(), sideLoc(BlockRegistry.SPRUCE_PILLAR_BASE.get()), mcLoc(BLOCK + "smooth_stone"), mcLoc(BLOCK + "spruce_log_top"));
        sideBottomTop(BlockRegistry.STONE_PILLAR_BASE.get(), sideLoc(BlockRegistry.STONE_PILLAR_BASE.get()), mcLoc(BLOCK + "chiseled_stone_bricks"), mcLoc(BLOCK + "chiseled_stone_bricks"));
        simpleBlock(BlockRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1.get());
        simpleBlock(BlockRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2.get());
        simpleBlock(BlockRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3.get());
        simpleBlock(BlockRegistry.STONE_FLOWER_WINDOW.get());
        directionalSideBottomTop(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_1.get(), sideLoc(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_1.get()),
                bottomLoc(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_1.get()), mcLoc(BLOCK + "dark_oak_log_top"));
        directionalSideEnd(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_2.get(), sideLoc(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_2.get()), endLoc(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_2.get()));
        directionalSideEnd(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_3.get(), sideLoc(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_3.get()), mcLoc(BLOCK + "dark_oak_log_top"));
        directionalSideEnd(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_4.get(), sideLoc(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_4.get()), endLoc(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_4.get()));
        directionalSideBottomTop(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_5.get(), sideLoc(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_5.get()),
                bottomLoc(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_5.get()), mcLoc(BLOCK + "dark_oak_log_top"));
        directionalSideEnd(BlockRegistry.CYAN_AND_WHITE_PILLAR_BASE.get(), sideLoc(BlockRegistry.CYAN_AND_WHITE_PILLAR_BASE.get()), mcLoc(BLOCK + "red_terracotta"));
        directionalSideEnd(BlockRegistry.CYAN_AND_WHITE_PILLAR_HEAD.get(), sideLoc(BlockRegistry.CYAN_AND_WHITE_PILLAR_HEAD.get()), mcLoc(BLOCK + "red_terracotta"));
        simpleBlock(BlockRegistry.YELLOW_AND_GREEN_CARVED_WOOD.get());
        simpleBlock(BlockRegistry.BLACK_FLOOR_TILES.get(), models().cubeAll(name(BlockRegistry.BLACK_FLOOR_TILES.get()), modBlockLoc(BlockRegistry.BLACK_FLOOR_TILES.get())));
        horizontalBlock(BlockRegistry.BLACK_FLOOR_TILES_LITTLE_MOSSY.get(), models().cube(name(BlockRegistry.BLACK_FLOOR_TILES_LITTLE_MOSSY.get()),
                modLoc(BLOCK + "black_floor_tiles_little_moss_down"), modLoc(BLOCK + "black_floor_tiles_little_moss_down"),
                modLoc(BLOCK + "black_floor_tiles_little_moss_up"), modLoc(BLOCK + "black_floor_tiles_little_moss_up"),
                modLoc(BLOCK + "black_floor_tiles"), modLoc(BLOCK + "black_floor_tiles")
        ).texture("particle", modLoc(BLOCK + "black_floor_tiles")), 0);
        horizontalBlock(BlockRegistry.BLACK_FLOOR_TILES_MODERATE_MOSSY.get(), models().cube(name(BlockRegistry.BLACK_FLOOR_TILES_MODERATE_MOSSY.get()),
                modLoc(BLOCK + "black_floor_tiles_moderate_moss_right"), modLoc(BLOCK + "black_floor_tiles_moderate_moss_right"),
                modLoc(BLOCK + "black_floor_tiles"), modLoc(BLOCK + "black_floor_tiles"),
                modLoc(BLOCK + "black_floor_tiles_moderate_moss_up"), modLoc(BLOCK + "black_floor_tiles_moderate_moss_up")
        ).texture("particle", modLoc(BLOCK + "black_floor_tiles")), 0);
        horizontalBlock(BlockRegistry.BLACK_FLOOR_TILES_VERY_MOSSY.get(), models().cube(name(BlockRegistry.BLACK_FLOOR_TILES_VERY_MOSSY.get()),
                modLoc(BLOCK + "black_floor_tiles_big_moss_top_right"), modLoc(BLOCK + "black_floor_tiles_big_moss_bottom_right"),
                modLoc(BLOCK + "black_floor_tiles_big_moss_top_right"), modLoc(BLOCK + "black_floor_tiles_big_moss_top_right"),
                modLoc(BLOCK + "black_floor_tiles_big_moss_top_right"), modLoc(BLOCK + "black_floor_tiles_big_moss_top_left")
        ).texture("particle", modLoc(BLOCK + "black_floor_tiles")), 0);
        slabSideEndNoFull(BlockRegistry.WHITE_AND_RED_SLAB.get(), sideLoc(BlockRegistry.WHITE_AND_RED_SLAB.get()), endLoc(BlockRegistry.WHITE_AND_RED_SLAB.get()));
        simpleBlock(BlockRegistry.YELLOW_GREEN_BLUE_CARVED_WOOD.get());
        horizontalBlock(BlockRegistry.BOOKSHELF.get(), models().cube(name(BlockRegistry.BOOKSHELF.get()),
                modLoc(BLOCK + "bookshelf_side"), modLoc(BLOCK + "bookshelf_side"),
                modLoc(BLOCK + "bookshelf_front"), modLoc(BLOCK + "bookshelf_back"),
                modLoc(BLOCK + "bookshelf_side"), modLoc(BLOCK + "bookshelf_side")
        ).texture("particle", modLoc(BLOCK + "bookshelf_side")), 0);
        horizontalBlock(BlockRegistry.BOOKSHELF_VARIANT.get(), models().cube(name(BlockRegistry.BOOKSHELF_VARIANT.get()),
                modLoc(BLOCK + "bookshelf_side"), modLoc(BLOCK + "bookshelf_side"),
                modLoc(BLOCK + "bookshelf_variant_front"), modLoc(BLOCK + "bookshelf_variant_back"),
                modLoc(BLOCK + "bookshelf_side"), modLoc(BLOCK + "bookshelf_side")
        ).texture("particle", modLoc(BLOCK + "bookshelf_side")), 0);


        directionalSideEnd(BlockRegistry.GREEN_FANGXIN.get(), sideLoc(BlockRegistry.GREEN_FANGXIN.get()), endLoc(BlockRegistry.GREEN_FANGXIN.get()));
        directionalSideEnd(BlockRegistry.GREEN_FANGXIN_EDGE.get(), sideLoc(BlockRegistry.GREEN_FANGXIN_EDGE.get()), endLoc(BlockRegistry.GREEN_FANGXIN.get()));
        chiralWSMirror(BlockRegistry.BLUE_FANGXIN_EDGE.get(), mcLoc(BLOCK + "blue_concrete_powder")); //north face gold left = left / gold top & bottom
        directionalSideEnd(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE.get(), sideLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE.get()), endLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE.get()));
        directionalSideEnd(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE_VARIANT.get(), sideLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE_VARIANT.get()), endLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE.get()));
        directionalSideEnd(BlockRegistry.CYAN_BLUE_WHITE_FANGXIN_EDGE.get(), sideLoc(BlockRegistry.CYAN_BLUE_WHITE_FANGXIN_EDGE.get()), endLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE.get()));
        directionalSideEnd(BlockRegistry.BLUE_AND_GREEN_FANGXIN_EDGE.get(), sideLoc(BlockRegistry.BLUE_AND_GREEN_FANGXIN_EDGE.get()), endLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE.get()));
        directionalSideEnd(BlockRegistry.YELLOW_AND_GREEN_FANGXIN_EDGE.get(), sideLoc(BlockRegistry.YELLOW_AND_GREEN_FANGXIN_EDGE.get()), endLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE.get()));
        directionalSideEnd(BlockRegistry.DARK_BLUE_FANGXIN_EDGE.get(), sideLoc(BlockRegistry.DARK_BLUE_FANGXIN_EDGE.get()), mcLoc(BLOCK + "blue_wool"));
        directionalSideEnd(BlockRegistry.BLUE_FANGXIN.get(), sideLoc(BlockRegistry.BLUE_FANGXIN.get()), mcLoc(BLOCK + "green_wool"));
        axisSideEnd(BlockRegistry.CYAN_AND_BLUE_FANGXIN.get(), sideLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN.get()), endLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE.get()));
        axisSideEnd(BlockRegistry.CYAN_BLUE_WHITE_FANGXIN.get(), sideLoc(BlockRegistry.CYAN_BLUE_WHITE_FANGXIN.get()), endLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE.get()));
        axisSideEnd(BlockRegistry.BLUE_AND_WHITE_FANGXIN.get(), sideLoc(BlockRegistry.BLUE_AND_WHITE_FANGXIN.get()), endLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE.get()));
        axisSideEnd(BlockRegistry.GREEN_AND_DARK_BLUE_FANGXIN.get(), sideLoc(BlockRegistry.GREEN_AND_DARK_BLUE_FANGXIN.get()), endLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE.get()));
        axisSideEnd(BlockRegistry.DARK_BLUE_FANGXIN.get(), sideLoc(BlockRegistry.DARK_BLUE_FANGXIN.get()), mcLoc(BLOCK + "blue_wool"));
        directionalSideBottomTop(BlockRegistry.BLUE_ZHAOTOU_EDGE.get(), sideLoc(BlockRegistry.BLUE_ZHAOTOU_EDGE.get()), mcLoc(BLOCK + "green_wool"), mcLoc(BLOCK + "blue_wool"));
        directionalSideBottomTop(BlockRegistry.GREEN_AND_BLUE_ZHAOTOU.get(), sideLoc(BlockRegistry.GREEN_AND_BLUE_ZHAOTOU.get()), mcLoc(BLOCK + "green_wool"), mcLoc(BLOCK + "blue_wool"));
        directionalSideBottomTop(BlockRegistry.BLUE_AND_GREEN_ZHAOTOU.get(), sideLoc(BlockRegistry.BLUE_AND_GREEN_ZHAOTOU.get()), mcLoc(BLOCK + "blue_wool"), mcLoc(BLOCK + "green_wool"));
        directionalSideEnd(BlockRegistry.BLUE_AND_GREEN_DOUBLE_LAYER_ZHAOTOU.get(), sideLoc(BlockRegistry.BLUE_AND_GREEN_DOUBLE_LAYER_ZHAOTOU.get()), endLoc(BlockRegistry.BLUE_AND_GREEN_DOUBLE_LAYER_ZHAOTOU.get()));
        axisSideEnd(BlockRegistry.WHITE_AND_CYAN_FANGXIN.get(), sideLoc(BlockRegistry.WHITE_AND_CYAN_FANGXIN.get()), mcLoc(BLOCK + "blue_concrete_powder"));
        axisSideEnd(BlockRegistry.WHITE_AND_BLUE_FANGXIN.get(), sideLoc(BlockRegistry.WHITE_AND_BLUE_FANGXIN.get()), mcLoc(BLOCK + "blue_concrete_powder"));
        directionalSideEnd(BlockRegistry.WHITE_AND_CYAN_FANGXIN_EDGE.get(), sideLoc(BlockRegistry.WHITE_AND_CYAN_FANGXIN_EDGE.get()), mcLoc(BLOCK + "blue_concrete_powder"));
        directionalSideEnd(BlockRegistry.WHITE_AND_BLUE_FANGXIN_EDGE.get(), sideLoc(BlockRegistry.WHITE_AND_BLUE_FANGXIN_EDGE.get()), mcLoc(BLOCK + "blue_concrete_powder"));
        directionalSideEnd(BlockRegistry.CYAN_AND_RED_ZHAOTOU.get(), sideLoc(BlockRegistry.CYAN_AND_RED_ZHAOTOU.get()), mcLoc(BLOCK + "blue_concrete_powder"));
        directionalSideEnd(BlockRegistry.CYAN_AND_BLUE_ZHAOTOU.get(), sideLoc(BlockRegistry.CYAN_AND_BLUE_ZHAOTOU.get()), mcLoc(BLOCK + "blue_concrete_powder"));
        directionalSideEnd(BlockRegistry.RED_CYAN_BLUE_FANGXIN_EDGE.get(), sideLoc(BlockRegistry.RED_CYAN_BLUE_FANGXIN_EDGE.get()), mcLoc(BLOCK + "blue_concrete_powder"));
        directionalSideEnd(BlockRegistry.BLUE_CYAN_BLUE_FANGXIN_EDGE.get(), sideLoc(BlockRegistry.BLUE_CYAN_BLUE_FANGXIN_EDGE.get()), mcLoc(BLOCK + "blue_concrete_powder"));
        directionalSideEnd(BlockRegistry.BLUE_CYAN_RED_FANGXIN_EDGE.get(), sideLoc(BlockRegistry.BLUE_CYAN_RED_FANGXIN_EDGE.get()), mcLoc(BLOCK + "blue_concrete_powder"));
        chiralWSMirror(BlockRegistry.BLUE_CYAN_RED_FANGXIN.get(), mcLoc(BLOCK + "blue_concrete_powder"));
        chiralWSMirror(BlockRegistry.RED_CYAN_BLUE_FANGXIN.get(), mcLoc(BLOCK + "blue_concrete_powder"));
        chiralWSMirror(BlockRegistry.CYAN_BLUE_CYAN_FANGXIN.get(), mcLoc(BLOCK + "blue_concrete_powder"));
        chiralWSMirror(BlockRegistry.RED_BLUE_RED_FANGXIN.get(), mcLoc(BLOCK + "blue_concrete_powder"));
        directionalSideEnd(BlockRegistry.GRAY_BLACK_RED_ZHAOTOU.get(), sideLoc(BlockRegistry.GRAY_BLACK_RED_ZHAOTOU.get()), mcLoc(BLOCK + "blue_wool"));
        directionalSideEnd(BlockRegistry.BLUE_GREEN_RED_ZHAOTOU.get(), sideLoc(BlockRegistry.BLUE_GREEN_RED_ZHAOTOU.get()), mcLoc(BLOCK + "blue_wool"));
        directionalSideEnd(BlockRegistry.CYAN_AND_YELLOW_FANGXIN_EDGE.get(), sideLoc(BlockRegistry.CYAN_AND_YELLOW_FANGXIN_EDGE.get()), mcLoc(BLOCK + "blue_wool"));
        directionalSideBottomTop(BlockRegistry.GUTOU.get(), sideLoc(BlockRegistry.GUTOU.get()), mcLoc(BLOCK + "black_wool"), mcLoc(BLOCK + "white_wool"));
        directionalSideBottomTop(BlockRegistry.RED_AND_BLUE_ZHAOTOU.get(), sideLoc(BlockRegistry.RED_AND_BLUE_ZHAOTOU.get()), mcLoc(BLOCK + "red_wool"), mcLoc(BLOCK + "blue_wool"));
        directionalSideEnd(BlockRegistry.GREEN_AND_YELLOW_ZHAOTOU.get(), sideLoc(BlockRegistry.GREEN_AND_YELLOW_ZHAOTOU.get()), endLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE.get()));
        directionalSideEnd(BlockRegistry.RED_GREEN_BLUE_ZHAOTOU.get(), sideLoc(BlockRegistry.RED_GREEN_BLUE_ZHAOTOU.get()), endLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE.get()));
        directionalSideEnd(BlockRegistry.BLUE_GREEN_YELLOW_GUTOU.get(), sideLoc(BlockRegistry.BLUE_GREEN_YELLOW_GUTOU.get()), mcLoc(BLOCK + "green_wool"));
        directionalSideEnd(BlockRegistry.WHITE_BLUE_GREEN_ZHAOTOU.get(), sideLoc(BlockRegistry.WHITE_BLUE_GREEN_ZHAOTOU.get()), endLoc(BlockRegistry.WHITE_BLUE_GREEN_ZHAOTOU.get()));
        directionalSideEnd(BlockRegistry.CYAN_AND_WHITE_DECORATED_PILLAR.get(), sideLoc(BlockRegistry.CYAN_AND_WHITE_DECORATED_PILLAR.get()), mcLoc(BLOCK + "red_terracotta"));
        directionalSideEnd(BlockRegistry.GREEN_BLUE_BLACK_GUTOU.get(), sideLoc(BlockRegistry.GREEN_BLUE_BLACK_GUTOU.get()), mcLoc(BLOCK + "green_wool"));


        shiftedTiles(BlockRegistry.GRAY_ROOF_TILES.get(), "gray", RoofTiles.RoofTileType.NORMAL);
        shiftedTiles(BlockRegistry.GRAY_ROOF_TILE_STAIRS.get(), "gray", RoofTiles.RoofTileType.STAIRS);
        shiftedDirectionalBlock(BlockRegistry.GRAY_ROOF_TILE_EDGE.get());
        shiftedTiles(BlockRegistry.YELLOW_ROOF_TILES.get(), "yellow", RoofTiles.RoofTileType.NORMAL);
        shiftedTiles(BlockRegistry.YELLOW_ROOF_TILE_STAIRS.get(), "yellow", RoofTiles.RoofTileType.STAIRS);
        shiftedTiles(BlockRegistry.YELLOW_ROOF_TILE_EDGE.get(), "yellow", RoofTiles.RoofTileType.EDGE);
        shiftedTiles(BlockRegistry.GREEN_ROOF_TILES.get(), "green", RoofTiles.RoofTileType.NORMAL);
        shiftedTiles(BlockRegistry.GREEN_ROOF_TILE_STAIRS.get(), "green", RoofTiles.RoofTileType.STAIRS);
        shiftedTiles(BlockRegistry.GREEN_ROOF_TILE_EDGE.get(), "green", RoofTiles.RoofTileType.EDGE);
        shiftedTiles(BlockRegistry.BLUE_ROOF_TILES.get(), "blue", RoofTiles.RoofTileType.NORMAL);
        shiftedTiles(BlockRegistry.BLUE_ROOF_TILE_STAIRS.get(), "blue", RoofTiles.RoofTileType.STAIRS);
        shiftedTiles(BlockRegistry.BLUE_ROOF_TILE_EDGE.get(), "blue", RoofTiles.RoofTileType.EDGE);
        shiftedTiles(BlockRegistry.CYAN_ROOF_TILES.get(), "cyan", RoofTiles.RoofTileType.NORMAL);
        shiftedTiles(BlockRegistry.CYAN_ROOF_TILE_STAIRS.get(), "cyan", RoofTiles.RoofTileType.STAIRS);
        shiftedTiles(BlockRegistry.CYAN_ROOF_TILE_EDGE.get(), "cyan", RoofTiles.RoofTileType.EDGE);
        shiftedTiles(BlockRegistry.BLACK_ROOF_TILES.get(), "black", RoofTiles.RoofTileType.NORMAL);
        shiftedTiles(BlockRegistry.BLACK_ROOF_TILE_STAIRS.get(), "black", RoofTiles.RoofTileType.STAIRS);
        shiftedDirectionalBlock(BlockRegistry.BLACK_ROOF_TILE_EDGE.get());


        sideBottomTop(BlockRegistry.BLACK_ROOF_RIDGE_UPPER.get());
        sideBottomTop(BlockRegistry.BLACK_ROOF_RIDGE_LOWER.get(), sideLoc(BlockRegistry.BLACK_ROOF_RIDGE_LOWER.get()), bottomLoc(BlockRegistry.BLACK_ROOF_RIDGE_UPPER.get()), bottomLoc(BlockRegistry.BLACK_ROOF_RIDGE_UPPER.get()));
        axialFrontSideBottomTop(BlockRegistry.BLACK_ROOF_RIDGE_CONNECTION.get(), frontLoc(BlockRegistry.BLACK_ROOF_RIDGE_CONNECTION.get()), sideLoc(BlockRegistry.BLACK_ROOF_RIDGE_CONNECTION.get()),
                bottomLoc(BlockRegistry.BLACK_ROOF_RIDGE_UPPER.get()), topLoc(BlockRegistry.BLACK_ROOF_RIDGE_UPPER.get()));
        horizontalFrontSideBottomTop(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_CONNECTION.get(), frontLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_CONNECTION.get()), sideLoc(BlockRegistry.BLACK_ROOF_RIDGE_CONNECTION.get()),
                frontLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_CONNECTION.get()), topLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_CONNECTION.get()));
        slabSideBottomTopNoFull(BlockRegistry.BLACK_ROOF_RIDGE_UPPER_SLAB.get(), sideLoc(BlockRegistry.BLACK_ROOF_RIDGE_UPPER_SLAB.get()), bottomLoc(BlockRegistry.BLACK_ROOF_RIDGE_UPPER.get()), topLoc(BlockRegistry.BLACK_ROOF_RIDGE_UPPER.get()));
        directionalSlabFrontSideBottomTopNoFull(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB.get(), frontLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB.get()), sideLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB.get()),
                bottomLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB.get()), topLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB.get()));
        roofRidgePanel(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_PANEL.get(), frontLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB.get()), sideLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB.get()),
                bottomLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB.get()), topLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB.get()));
        roofRidgePlate(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_PLATE.get(), frontLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB.get()), sideLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB.get()),
                bottomLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB.get()), topLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB.get()));
        straightStairs(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_STAIRS.get());

        sideBottomTop(BlockRegistry.YELLOW_ROOF_RIDGE_UPPER.get());
        sideBottomTop(BlockRegistry.YELLOW_ROOF_RIDGE_LOWER.get(), sideLoc(BlockRegistry.YELLOW_ROOF_RIDGE_LOWER.get()), bottomLoc(BlockRegistry.YELLOW_ROOF_RIDGE_UPPER.get()), bottomLoc(BlockRegistry.YELLOW_ROOF_RIDGE_UPPER.get()));
        axialFrontSideBottomTop(BlockRegistry.YELLOW_ROOF_RIDGE_CONNECTION.get(), frontLoc(BlockRegistry.YELLOW_ROOF_RIDGE_CONNECTION.get()), sideLoc(BlockRegistry.YELLOW_ROOF_RIDGE_CONNECTION.get()),
                bottomLoc(BlockRegistry.YELLOW_ROOF_RIDGE_UPPER.get()), topLoc(BlockRegistry.YELLOW_ROOF_RIDGE_UPPER.get()));
        horizontalFrontSideBottomTop(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_CONNECTION.get(), frontLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_CONNECTION.get()), sideLoc(BlockRegistry.YELLOW_ROOF_RIDGE_CONNECTION.get()),
                frontLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_CONNECTION.get()), topLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_CONNECTION.get()));
        slabSideBottomTopNoFull(BlockRegistry.YELLOW_ROOF_RIDGE_UPPER_SLAB.get(), sideLoc(BlockRegistry.YELLOW_ROOF_RIDGE_UPPER_SLAB.get()), bottomLoc(BlockRegistry.YELLOW_ROOF_RIDGE_UPPER.get()), topLoc(BlockRegistry.YELLOW_ROOF_RIDGE_UPPER.get()));
        directionalSlabFrontSideBottomTopNoFull(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB.get(), frontLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB.get()), sideLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB.get()),
                bottomLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB.get()), topLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB.get()));
        roofRidgePanel(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_PANEL.get(), frontLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB.get()), sideLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB.get()),
                bottomLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB.get()), topLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB.get()));
        roofRidgePlate(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_PLATE.get(), frontLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB.get()), sideLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB.get()),
                bottomLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB.get()), topLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB.get()));
        straightStairs(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_STAIRS.get());

        vegetableBasket((StackableHalfBlock) BlockRegistry.CABBAGE_BASKET.get());
        vegetableBasket((StackableHalfBlock) BlockRegistry.CELERY_BASKET.get());
        vegetableBasket((StackableHalfBlock) BlockRegistry.ORANGE_BASKET.get());
        vegetableBasket((StackableHalfBlock) BlockRegistry.APPLE_BASKET.get());
        vegetableBasket((StackableHalfBlock) BlockRegistry.EGGPLANT_BASKET.get());
        vegetableBasket((StackableHalfBlock) BlockRegistry.PEAR_BASKET.get());

        BlockRegistry.BLOCKS.getEntries().stream().filter(blockRegistryObject -> blockRegistryObject.get() instanceof SideAxialBlock)
                .forEach(sideAxial -> {
                    SideAxialBlock block = (SideAxialBlock) sideAxial.get();
                    if (block instanceof RailingSlant) shiftedHorizontalBlockNoOffset(block);
                    else horizontalBlockNoOffset(sideAxial.get());
                });

        BlockRegistry.BLOCKS.getEntries().stream().filter(blockRegistryObject -> blockRegistryObject.get() instanceof CentralAxialBlock)
                .forEach(centralAxial -> axisBlock(centralAxial.get()));

        BlockRegistry.BLOCKS.getEntries().stream().filter(blockRegistryObject -> blockRegistryObject.get() instanceof Rafter)
                .forEach(rafter -> shiftedAxisBlock(rafter.get()));

        BlockRegistry.BLOCKS.getEntries().stream().filter(blockRegistryObject -> blockRegistryObject.get() instanceof RafterEnd)
                .forEach(rafterEnd -> shiftedDirectionalBlock(rafterEnd.get()));

        BlockRegistry.BLOCKS.getEntries().stream().filter(blockRegistryObject -> blockRegistryObject.get() instanceof DecorativeBlock)
                .forEach(decorativeBlock -> {
                    DecorativeBlock block = (DecorativeBlock) decorativeBlock.get();
                    if (ROTATED_DECO.containsKey(decorativeBlock)) decorativeBlock(block, ROTATED_DECO.get(decorativeBlock));
                    else if (block instanceof ConsumableDecorativeBlock consumableDecorativeBlock) consumableDecorativeBlock(consumableDecorativeBlock);
                    else if (block instanceof Censer censer) censer(censer, 0);
                    else if (block instanceof OpeningBlock openingBlock) openingBlock(openingBlock);
                    else decorativeBlock(block);
                });

        BlockRegistry.BLOCKS.getEntries().stream().filter(blockRegistryObject -> blockRegistryObject.get() instanceof SideBlock)
                .forEach(sideBlock -> {
                    SideBlock block = (SideBlock) sideBlock.get();
                    if (block instanceof WallSideBlock wallSideBlock){
                        if (block instanceof OrientableWallSideBlock orientableWallSideBlock)
                            orientableWallSideBlock(orientableWallSideBlock);
                        else wallSideBlock(wallSideBlock);
                    }
                    else if (block instanceof SixSideBlock sixSideBlock){
                        if (block instanceof OrientableSixSideBlock orientableSixFaceBlock)
                            orientableSixSideBlock(orientableSixFaceBlock);
                        else sixSideBlock(sixSideBlock);
                    }
                });

        horizontalBlock(BlockRegistry.WOODWORKING_WORKBENCH.get(), models().getExistingFile(blockLoc(BlockRegistry.WOODWORKING_WORKBENCH.get())));
        simpleBlock(BlockRegistry.JADE_ORE.get());
        simpleBlock(BlockRegistry.MAGNESITE_ORE.get());
        simpleBlock(BlockRegistry.HEMATITE_ORE.get());
    }

    private ResourceLocation blockLoc(Block block){
        return modLoc(BLOCK + name(block));
    }

    private void existingModelBlock(Block block){
        simpleBlock(block, models().getExistingFile(modLoc(BLOCK + name(block))));
    }

    private void slabAndStairs(Block baseBlock, Block slabBlock, Block stairBlock){
        slabBlock((SlabBlock) slabBlock, ForgeRegistries.BLOCKS.getKey(baseBlock), blockLoc(baseBlock));
        stairsBlock((StairBlock) stairBlock, blockLoc(baseBlock));
    }

    private void wall(Block baseBlock, Block wallBlock){
        wallBlock((WallBlock)wallBlock, name(wallBlock), blockLoc(baseBlock));
    }

    private void fence(Block baseBlock, Block fenceBlock){
        fenceBlock((FenceBlock)fenceBlock, name(fenceBlock), blockLoc(baseBlock));
    }

    private void wallSideBlock(Block block){
        getVariantBuilder(block).forAllStates(blockState -> ConfiguredModel.builder().modelFile(models().getExistingFile(modLoc(BLOCK + name(block))))
                .rotationY((int) blockState.getValue(HORIZONTAL_FACING).toYRot()).build());
    }
    private void sixSideBlock(Block block){
        getVariantBuilder(block).forAllStates(blockState -> {
            ConfiguredModel.Builder<?> model = ConfiguredModel.builder().modelFile(models().getExistingFile(modLoc(BLOCK + name(block))));
            Direction direction = blockState.getValue(FACING);
            if (direction == Direction.UP)
                model.rotationX(90);
            else if (direction == Direction.DOWN)
                model.rotationX(-90);
            else
                model.rotationY((int) direction.toYRot());
            return model.build();
        });
    }

    private void orientableWallSideBlock(Block block){
        getVariantBuilder(block).forAllStates(blockState -> {
            ResourceLocation model = blockState.getValue(OrientableWallSideBlock.TYPE) == OrientableBlockType.LEFT ?
                    modLoc(BLOCK + name(block) + "_left") : modLoc(BLOCK + name(block) + "_right");
            return ConfiguredModel.builder().modelFile(models().getExistingFile(model))
                    .rotationY((int) blockState.getValue(HORIZONTAL_FACING).toYRot()).build();
        });
    }

    private void orientableSixSideBlock(Block block){
        getVariantBuilder(block).forAllStates(blockState -> {
            ConfiguredModel.Builder<?> modelBuilder = ConfiguredModel.builder();
            Direction faceDir = blockState.getValue(FACING);
            Direction direction = blockState.getValue(ON_FACE_DIRECTION);
            if (faceDir.getAxis().isVertical()){ //top or down
                modelBuilder.modelFile(models().getExistingFile(modLoc(BLOCK + name(block) + "_top")));
                if (faceDir == Direction.DOWN)
                    modelBuilder.rotationY((int) direction.toYRot() + 180);
                else if (faceDir == Direction.UP)
                    modelBuilder.rotationX(180).rotationY((int) direction.toYRot());
            }
            else { //horizontal side
                StringBuilder suffix = new StringBuilder();
                suffix.append("_side");
                if (direction.getAxis().isVertical())
                    suffix.append("_").append(direction.getName());
                else {
                    //left = CCW right = CW
                    if (direction == faceDir.getClockWise()) suffix.append("_left");
                    else if (direction == faceDir.getCounterClockWise()) suffix.append("_right");
                    else suffix.append("_up");
                }
                modelBuilder.modelFile(models().getExistingFile(modLoc(BLOCK + name(block) + suffix)));
                modelBuilder.rotationY((int) faceDir.toYRot());
            }
            return modelBuilder.build();
        });
    }

    //TODO use chiralWS
    public void chiralDirectionalBlock(Block block) {
        directionalBlock(block, state -> {
            String path = name(block);
            if (state.hasProperty(ModBlockStateProperties.CHIRAL_BLOCK_TYPE)){
                ChiralBlockType chiralBlockType = state.getValue(ModBlockStateProperties.CHIRAL_BLOCK_TYPE);
                if (chiralBlockType == ChiralBlockType.LEFT || chiralBlockType == ChiralBlockType.TOP){
                    return models().getExistingFile(modLoc(BLOCK + path));
                }
                else return models().getExistingFile(modLoc(BLOCK + path + "_mirrored"));
            }
            return models().getExistingFile(modLoc(BLOCK + path));
        });
    }

    private void shiftedTiles(Block block, String color, ShiftedTileType type) {
        models().withExistingParent(modLoc(BLOCK + color + "_" + type).getPath(), modLoc(BLOCK + type))
                .texture("1", blockLoc(block)).texture("particle", mcLoc(BLOCK + color + "_concrete"));
        models().withExistingParent(modLoc(BLOCK + color + "_" + type + "_shifted").getPath(), modLoc(BLOCK + type + "_shifted"))
                .texture("1", blockLoc(block)).texture("particle", mcLoc(BLOCK + color + "_concrete"));
        shiftedDirectionalBlock(block);
    }

    private void shiftedDirectionalBlock(Block block) {
        getVariantBuilder(block).forAllStates(blockState -> {
            if (!blockState.getValue(ModBlockStateProperties.SHIFTED))
                return ConfiguredModel.builder().modelFile(models().getExistingFile(modLoc(BLOCK + name(block))))
                        .rotationY((int) blockState.getValue(HORIZONTAL_FACING).toYRot()).build();
            else
                return ConfiguredModel.builder().modelFile(models().getExistingFile(modLoc(BLOCK + name(block) + "_shifted")))
                        .rotationY((int) blockState.getValue(HORIZONTAL_FACING).toYRot()).build();
        });
    }

    private void axisBlock(Block block) {
        getVariantBuilder(block).forAllStates(blockState -> {
            ConfiguredModel.Builder<?> builder;
            builder = ConfiguredModel.builder().modelFile(models().getExistingFile(modLoc(BLOCK + name(block))));
            if (blockState.getValue(HORIZONTAL_AXIS) == Direction.Axis.X)
                builder.rotationY(90);
            return builder.build();
        });
    }

    private void shiftedAxisBlock(Block block) {
        getVariantBuilder(block).forAllStates(blockState -> {
            ConfiguredModel.Builder<?> builder;
            if (!blockState.getValue(ModBlockStateProperties.SHIFTED)) {
                builder = ConfiguredModel.builder().modelFile(models().getExistingFile(modLoc(BLOCK + name(block))));
            }
            else {
                builder = ConfiguredModel.builder().modelFile(models().getExistingFile(modLoc(BLOCK + name(block) + "_shifted")));
            }
            if (blockState.getValue(HORIZONTAL_AXIS) == Direction.Axis.X)
                builder.rotationY(90);
            return builder.build();
        });
    }

    private void decorativeBlock(DecorativeBlock block){
        decorativeBlock(block, 0);
    }

    private void decorativeBlock(DecorativeBlock block, int rotation){
        getVariantBuilder(block).forAllStates(blockState -> {
            var modelFile = ConfiguredModel.builder();
            String blockPath = name(block);
            return getDecorativeBlockConfiguredModels(block, blockState, blockPath, modelFile, rotation);
        });
    }

    private void consumableDecorativeBlock(ConsumableDecorativeBlock block){
        consumableDecorativeBlock(block, 0);
    }

    private void consumableDecorativeBlock(ConsumableDecorativeBlock block, int rotation){
        getVariantBuilder(block).forAllStates(blockState -> {
            var modelFile = ConfiguredModel.builder();
            int bites = blockState.getValue(ModBlockStateProperties.BITES);
            bites = Math.min(bites, block.getMaxBites());
            ResourceLocation resourceLocation = ForgeRegistries.BLOCKS.getKey(block);
            String blockPath = resourceLocation.getPath() + "_" + bites;
            return getDecorativeBlockConfiguredModels(block, blockState, blockPath, modelFile, rotation);
        });
    }

    private void censer(Censer block, int rotation){
        getVariantBuilder(block).forAllStates(blockState -> {
            var modelFile = ConfiguredModel.builder();
            ResourceLocation resourceLocation = ForgeRegistries.BLOCKS.getKey(block);
            String blockPath = blockState.getValue(LIT) ? "lit_" + resourceLocation.getPath() : resourceLocation.getPath();
            return getDecorativeBlockConfiguredModels(block, blockState, blockPath, modelFile, rotation);
        });
    }

    private void openingBlock(OpeningBlock block){
        getVariantBuilder(block).forAllStates(blockState -> {
            var modelFile = ConfiguredModel.builder();
            String blockName = name(block);
            String blockPath;
            if (blockState.getValue(OPEN)){
                if (blockState.getValue(DOOR_HINGE) == DoorHingeSide.LEFT)
                    blockPath = blockName + "_open_left";
                else blockPath = blockName + "_open_right";
            }
            else {
                blockPath = blockName;
            }
            return getDecorativeBlockConfiguredModels(block, blockState, blockPath, modelFile, 0);
        });
    }

    private void vegetableBasket(StackableHalfBlock block){
        String blockName = name(block);
        getVariantBuilder(block).forAllStates(blockState -> {
            StackableBlockType type = blockState.getValue(ModBlockStateProperties.STACKABLE_BLOCK_TYPE);
            switch (type){
                case SINGLE -> {
                    return ConfiguredModel.builder().modelFile(models().slab(blockLoc(block).getPath(),
                            modLoc("block/vegetable_basket_side"), modLoc("block/vegetable_basket_bottom"), modLoc(BLOCK + blockName + "_top"))).build();
                }
                case DOUBLE -> {
                    return ConfiguredModel.builder().modelFile(models().cubeBottomTop(modLoc(BLOCK + blockName + "_double").getPath(),
                            modLoc("block/vegetable_basket_side"), modLoc("block/vegetable_basket_bottom"), modLoc(BLOCK + blockName + "_top"))).build();
                }
            }
            return new ConfiguredModel[0];
        });
    }

    private void sideBottomTop(Block block){
        String blockName = name(block);
        sideBottomTop(block, modLoc(BLOCK + blockName + "_side"), modLoc(BLOCK + blockName + "_bottom"), modLoc(BLOCK + blockName + "_top"));
    }

    private void sideBottomTop(Block block, ResourceLocation side, ResourceLocation bottom, ResourceLocation top){
        String blockName = name(block);
        var model = models().cubeBottomTop(blockName, side, bottom, top);
        simpleBlock(block, model);
    }

    private void axialFrontSideBottomTop(Block block, ResourceLocation front, ResourceLocation side, ResourceLocation bottom, ResourceLocation top){
        var model = models().cube(name(block), bottom, top, front, front, side, side).texture("particle", side);
        getVariantBuilder(block)
                .partialState().with(HORIZONTAL_AXIS, Direction.Axis.Z)
                .modelForState().modelFile(model).addModel()
                .partialState().with(HORIZONTAL_AXIS, Direction.Axis.X)
                .modelForState().modelFile(model).rotationY(90).addModel();
    }

    private void horizontalFrontSideBottomTop(Block block, ResourceLocation front, ResourceLocation side, ResourceLocation bottom, ResourceLocation top){
        var model = models().cube(name(block), bottom, top, front, front, side, side).texture("particle", side);
        horizontalBlock(block, model, 0);
    }

    private void chiralWSMirror(Block block, ResourceLocation end){
        directionalBlock(block, state -> {
            String path = name(block);
            if (state.hasProperty(ModBlockStateProperties.CHIRAL_BLOCK_TYPE)){
                ChiralBlockType chiralBlockType = state.getValue(ModBlockStateProperties.CHIRAL_BLOCK_TYPE);
                if (chiralBlockType == ChiralBlockType.LEFT || chiralBlockType == ChiralBlockType.TOP){
                    return models().cube(path, end, end, sideLoc(block), sideMirroredLoc(block), sideLoc(block), sideMirroredLoc(block))
                            .texture("particle", sideLoc(block));
                }
                else return models().cube(path + "_mirrored", end, end, sideMirroredLoc(block), sideLoc(block), sideMirroredLoc(block), sideLoc(block))
                        .texture("particle", sideLoc(block));
            }
            return models().getExistingFile(modLoc(BLOCK + path));
        });
    }

    private void straightStairs(Block block){
        getVariantBuilder(block).forAllStatesExcept(blockState -> ConfiguredModel.builder()
                .modelFile(models().getExistingFile(modLoc(BLOCK + name(block))))
                .rotationX(blockState.getValue(HALF) == Half.BOTTOM ? 0 : 180)
                .rotationY((int) blockState.getValue(HORIZONTAL_FACING).getClockWise().toYRot() - 90 + (blockState.getValue(HALF) == Half.BOTTOM ? 0 : 180))
                .build(), WATERLOGGED);
    }

    private void horizontalBlockNoOffset(Block block){
        horizontalBlock(block, models().getExistingFile(modLoc(BLOCK + name(block))), 0);
    }

    private void shiftedHorizontalBlockNoOffset(Block block){
        horizontalBlock(block, state -> {
            Boolean shifted = state.getValue(SHIFTED);
            return shifted ? models().getExistingFile(modLoc(BLOCK + name(block))) : models().getExistingFile(modLoc(BLOCK + name(block) + "_shifted"));
        });
    }

    private void directionalSideBottomTop(Block block, ResourceLocation side, ResourceLocation bottom, ResourceLocation top){
        String blockName = name(block);
        var model = models().cubeBottomTop(blockName, side, bottom, top);
        directionalBlock(block, model);
    }

    private void directionalSideEnd(Block block, ResourceLocation side, ResourceLocation end){
        String blockName = name(block);
        var model = models().cubeBottomTop(blockName, side, end, end);
        directionalBlock(block, model);
    }

    private void directionalBottomTop(Block block, ResourceLocation side, ResourceLocation bottom, ResourceLocation top){
        String blockName = name(block);
        var model = models().cubeBottomTop(blockName, side, bottom, top);
        directionalBlock(block, model);
    }

    private void axisSideEnd(Block block, ResourceLocation side, ResourceLocation end){
        axisBlock((RotatedPillarBlock) block, side, end);
    }

    private void slabSideEnd(Block block, Block full, ResourceLocation side, ResourceLocation end){
        slabBlock((SlabBlock) block, ForgeRegistries.BLOCKS.getKey(full), side, end, end);
    }

    private void slabSideEndNoFull(Block block, ResourceLocation side, ResourceLocation end){
        slabBlock((SlabBlock)block,
                models().slab(name(block), side, end, end),
                models().slabTop(name(block) + "_top", side, end, end),
                models().cubeBottomTop(name(block) + "double", side, end, end));
    }

    private void slabSideBottomTopNoFull(Block block, ResourceLocation side, ResourceLocation bottom, ResourceLocation top){
        slabBlock((SlabBlock)block,
                models().slab(name(block), side, bottom, top),
                models().slabTop(name(block) + "_top", side, bottom, top),
                models().cubeBottomTop(name(block) + "double", side, bottom, top));
    }

    private void directionalSlabFrontSideBottomTopNoFull(Block block, ResourceLocation front, ResourceLocation side, ResourceLocation bottom, ResourceLocation top){
        getVariantBuilder(block).forAllStatesExcept(state -> {
            var builder = ConfiguredModel.builder();
            Direction direction = state.getValue(HORIZONTAL_FACING);
            SlabType type = state.getValue(SLAB_TYPE);
            switch (type) {
                case TOP -> builder.modelFile(models().withExistingParent(name(block) + "_top", modLoc(BLOCK + "roof_slab_top"))
                        .texture("front", front).texture("side", side).texture("top", top).texture("bottom", bottom).texture("particle", front));
                case BOTTOM -> builder.modelFile(models().withExistingParent(name(block), modLoc(BLOCK + "roof_slab"))
                        .texture("front", front).texture("side", side).texture("top", top).texture("bottom", bottom).texture("particle", front));
                case DOUBLE -> builder.modelFile(models().cube(name(block) + "_double", bottom, top, front, front, side, side).texture("particle", front));
            }
            builder.rotationY((int)direction.toYRot());
            return builder.build();
        }, WATERLOGGED);
    }

    private void roofRidgePanel(Block block, ResourceLocation front, ResourceLocation side, ResourceLocation bottom, ResourceLocation top){
        getVariantBuilder(block).forAllStatesExcept(state -> {
            var builder = ConfiguredModel.builder();
            Direction direction = state.getValue(HORIZONTAL_FACING);
            builder.modelFile(models().withExistingParent(name(block), modLoc(BLOCK + "roof_panel"))
                    .texture("front", front).texture("side", side).texture("bottom", bottom).texture("top", top));
            builder.rotationY((int)direction.toYRot());
            return builder.build();
        }, WATERLOGGED);
    }

    private void roofRidgePlate(Block block, ResourceLocation front, ResourceLocation side, ResourceLocation bottom, ResourceLocation top){
        getVariantBuilder(block).forAllStatesExcept(state -> {
            var builder = ConfiguredModel.builder();
            Direction direction = state.getValue(HORIZONTAL_FACING);
            builder.modelFile(models().withExistingParent(name(block), modLoc(BLOCK + "roof_plate"))
                    .texture("front", front).texture("side", side).texture("bottom", bottom).texture("top", top));
            builder.rotationY((int)direction.toYRot());
            return builder.build();
        }, WATERLOGGED);
    }

    private void carvedWoodenSlab(Block slab, Block full){
        slabBlock((SlabBlock) slab, ForgeRegistries.BLOCKS.getKey(full), sideLoc(slab), blockLoc(full), blockLoc(full));
    }

    private ResourceLocation modBlockLoc(Block block){
        return modLoc(BLOCK + name(block));
    }

    private ResourceLocation sideLoc(Block block){
        return modLoc(BLOCK + name(block) + "_side");
    }

    private ResourceLocation frontLoc(Block block){
        return modLoc(BLOCK + name(block) + "_front");
    }

    private ResourceLocation bottomLoc(Block block){
        return modLoc(BLOCK + name(block) + "_bottom");
    }

    private ResourceLocation topLoc(Block block){
        return modLoc(BLOCK + name(block) + "_top");
    }

    private ResourceLocation sideMirroredLoc(Block block){
        return modLoc(BLOCK + name(block) + "_side_mirrored");
    }

    private ResourceLocation endLoc(Block block){
        return modLoc(BLOCK + name(block) + "_end");
    }

    private void railingBlock(Block block){
        ModelFile.ExistingModelFile sideModel = models().getExistingFile(modLoc(BLOCK + name(block) + "_side"));
        ModelFile.ExistingModelFile panelModel = models().getExistingFile(modLoc(BLOCK + name(block) + "_panel"));
        ModelFile.ExistingModelFile sideModelShift = models().getExistingFile(modLoc(BLOCK + name(block) + "_side_shifted"));
        ModelFile.ExistingModelFile panelModelShift = models().getExistingFile(modLoc(BLOCK + name(block) + "_panel_shifted"));
        getMultipartBuilder(block)
            .part()
            .modelFile(models().getExistingFile(modLoc(BLOCK + name(block) + "_pole")))
            .addModel()
            .condition(RailingBlock.SHIFTED, false)
            .condition(RailingBlock.UP, true)
            .end()
            .part()
            .modelFile(sideModel)
            .addModel()
            .condition(RailingBlock.SHIFTED, false)
            .condition(RailingBlock.UP, true)
            .condition(RailingBlock.NORTH, true)
            .end()
            .part()
            .modelFile(sideModel)
            .rotationY(90)
            .addModel()
            .condition(RailingBlock.SHIFTED, false)
            .condition(RailingBlock.UP, true)
            .condition(RailingBlock.EAST, true)
            .end()
            .part()
            .modelFile(sideModel)
            .rotationY(180)
            .addModel()
            .condition(RailingBlock.SHIFTED, false)
            .condition(RailingBlock.UP, true)
            .condition(RailingBlock.SOUTH, true)
            .end()
            .part()
            .modelFile(sideModel)
            .rotationY(270)
            .addModel()
            .condition(RailingBlock.SHIFTED, false)
            .condition(RailingBlock.UP, true)
            .condition(RailingBlock.WEST, true)
            .end()
            .part()
            .modelFile(panelModel)
            .addModel()
            .condition(RailingBlock.SHIFTED, false)
            .condition(RailingBlock.UP, false)
            .condition(RailingBlock.WEST, true)
            .condition(RailingBlock.EAST, true)
            .end()
            .part()
            .modelFile(panelModel)
            .rotationY(90)
            .addModel()
            .condition(RailingBlock.SHIFTED, false)
            .condition(RailingBlock.UP, false)
            .condition(RailingBlock.NORTH, true)
            .condition(RailingBlock.SOUTH, true)
            .end()

            //SHIFTED

            .part()
            .modelFile(models().getExistingFile(modLoc(BLOCK + name(block) + "_pole_shifted")))
            .addModel()
            .condition(RailingBlock.SHIFTED, true)
            .condition(RailingBlock.UP, true)
            .end()
            .part()
            .modelFile(sideModelShift)
            .addModel()
            .condition(RailingBlock.SHIFTED, true)
            .condition(RailingBlock.UP, true)
            .condition(RailingBlock.NORTH, true)
            .end()
            .part()
            .modelFile(sideModelShift)
            .rotationY(90)
            .addModel()
            .condition(RailingBlock.SHIFTED, true)
            .condition(RailingBlock.UP, true)
            .condition(RailingBlock.EAST, true)
            .end()
            .part()
            .modelFile(sideModelShift)
            .rotationY(180)
            .addModel()
            .condition(RailingBlock.SHIFTED, true)
            .condition(RailingBlock.UP, true)
            .condition(RailingBlock.SOUTH, true)
            .end()
            .part()
            .modelFile(sideModelShift)
            .rotationY(270)
            .addModel()
            .condition(RailingBlock.SHIFTED, true)
            .condition(RailingBlock.UP, true)
            .condition(RailingBlock.WEST, true)
            .end()
            .part()
            .modelFile(panelModelShift)
            .addModel()
            .condition(RailingBlock.SHIFTED, true)
            .condition(RailingBlock.UP, false)
            .condition(RailingBlock.WEST, true)
            .condition(RailingBlock.EAST, true)
            .end()
            .part()
            .modelFile(panelModelShift)
            .rotationY(90)
            .addModel()
            .condition(RailingBlock.SHIFTED, true)
            .condition(RailingBlock.UP, false)
            .condition(RailingBlock.NORTH, true)
            .condition(RailingBlock.SOUTH, true)
            .end()
    ;
    }

    private ConfiguredModel[] getDecorativeBlockConfiguredModels(DecorativeBlock block, BlockState blockState, String blockPath, ConfiguredModel.Builder<?> modelFile, int rotation) {
        if (!block.isDirectional() && !block.isDiagonallyPlaceable()){
            return modelFile.modelFile(models().getExistingFile(modLoc(BLOCK + blockPath))).build();
        }
        else if (!block.isDirectional() && block.isDiagonallyPlaceable()){
            if (blockState.getValue(ModBlockStateProperties.DIAGONAL))
                modelFile.modelFile(models().getExistingFile(modLoc(BLOCK + blockPath + "_diagonal")));
            else
                modelFile.modelFile(models().getExistingFile(modLoc(BLOCK + blockPath)));
            return modelFile.build();
        }
        else if (block.isDirectional() && !block.isDiagonallyPlaceable()){
            modelFile.modelFile(models().getExistingFile(modLoc(BLOCK + blockPath)));
            return modelFile.rotationY((int) blockState.getValue(HORIZONTAL_FACING).toYRot() + rotation).build();
        }
        else {
            if (!blockState.getValue(ModBlockStateProperties.DIAGONAL)){
                modelFile.modelFile(models().getExistingFile(modLoc(BLOCK + blockPath)));
                return modelFile.rotationY((int) blockState.getValue(HORIZONTAL_FACING).toYRot() + rotation).build();
            }
            else {
                modelFile.modelFile(models().getExistingFile(modLoc(BLOCK + blockPath + "_diagonal")));
                var directions = Pair.of(blockState.getValue(HORIZONTAL_FACING), blockState.getValue(ModBlockStateProperties.HORIZONTAL_FACING_SHIFT));
                int deg = 0;
                if (rotations.containsKey(directions)) deg = rotations.get(directions);
                return modelFile.rotationY(deg - 90).build();
            }
        }
    }

    private void diagonallyPlaceableBlock(Block block){
        getVariantBuilder(block)
                .partialState().with(ModBlockStateProperties.DIAGONAL, false).modelForState()
                .modelFile(models().getExistingFile(blockLoc(block))).addModel()
                .partialState().with(ModBlockStateProperties.DIAGONAL, true).modelForState()
                .modelFile(models().getExistingFile(modLoc(BLOCK + name(block) + "_diagonal"))).addModel();
    }

    private String name(Block block) {
        return Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
    }

}
