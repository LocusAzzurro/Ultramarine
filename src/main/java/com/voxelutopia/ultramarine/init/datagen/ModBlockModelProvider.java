package com.voxelutopia.ultramarine.init.datagen;

import com.voxelutopia.ultramarine.UltramarineDataGenerators;
import com.voxelutopia.ultramarine.common.block.*;
import com.voxelutopia.ultramarine.common.block.state.ChiralBlockType;
import com.voxelutopia.ultramarine.common.block.state.ModBlockStateProperties;
import com.voxelutopia.ultramarine.common.block.state.OrientableBlockType;
import com.voxelutopia.ultramarine.common.block.state.StackableBlockType;
import com.voxelutopia.ultramarine.init.registry.BlockRegistry;
import com.voxelutopia.ultramarine.util.RegistryHelper;
import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import io.github.fabricators_of_create.porting_lib.models.generators.ConfiguredModel;
import io.github.fabricators_of_create.porting_lib.models.generators.ModelFile;
import io.github.fabricators_of_create.porting_lib.models.generators.block.BlockStateProvider;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.SlabType;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;

import static com.voxelutopia.ultramarine.common.block.state.ModBlockStateProperties.ON_FACE_DIRECTION;
import static com.voxelutopia.ultramarine.common.block.state.ModBlockStateProperties.SHIFTED;
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
    private final Map<Block, Integer> ROTATED_DECO = Map.of(
            BlockRegistry.CARRIAGE, 90,
            BlockRegistry.WOODEN_POLES, 90,
            BlockRegistry.GOLDEN_GLAZED_ROOF_CHARM, -90,
            BlockRegistry.GREEN_GLAZED_ROOF_CHARM, -90
    );

    public ModBlockModelProvider(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, UltramarineDataGenerators.MOD_ID, existingFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        simpleBlock(BlockRegistry.CYAN_BRICKS);
        slabAndStairs(BlockRegistry.CYAN_BRICKS, BlockRegistry.CYAN_BRICK_SLAB, BlockRegistry.CYAN_BRICK_STAIRS);
        wall(BlockRegistry.CYAN_BRICKS, BlockRegistry.CYAN_BRICK_WALL);
        simpleBlock(BlockRegistry.BLACK_BRICKS);
        slabAndStairs(BlockRegistry.BLACK_BRICKS, BlockRegistry.BLACK_BRICK_SLAB, BlockRegistry.BLACK_BRICK_STAIRS);
        wall(BlockRegistry.BLACK_BRICKS, BlockRegistry.BLACK_BRICK_WALL);
        simpleBlock(BlockRegistry.BROWNISH_RED_STONE_BRICKS);
        slabAndStairs(BlockRegistry.BROWNISH_RED_STONE_BRICKS, BlockRegistry.BROWNISH_RED_STONE_BRICK_SLAB, BlockRegistry.BROWNISH_RED_STONE_BRICK_STAIRS);
        wall(BlockRegistry.BROWNISH_RED_STONE_BRICKS, BlockRegistry.BROWNISH_RED_STONE_BRICK_WALL);
        simpleBlock(BlockRegistry.PALE_YELLOW_STONE);
        slabAndStairs(BlockRegistry.PALE_YELLOW_STONE, BlockRegistry.PALE_YELLOW_STONE_SLAB, BlockRegistry.PALE_YELLOW_STONE_STAIRS);
        simpleBlock(BlockRegistry.VARIEGATED_ROCKS);
        slabAndStairs(BlockRegistry.VARIEGATED_ROCKS, BlockRegistry.VARIEGATED_ROCK_SLAB, BlockRegistry.VARIEGATED_ROCK_STAIRS);
        simpleBlock(BlockRegistry.WEATHERED_STONE);
        slabAndStairs(BlockRegistry.WEATHERED_STONE, BlockRegistry.WEATHERED_STONE_SLAB, BlockRegistry.WEATHERED_STONE_STAIRS);
        simpleBlock(BlockRegistry.POLISHED_WEATHERED_STONE);
        slabAndStairs(BlockRegistry.POLISHED_WEATHERED_STONE, BlockRegistry.POLISHED_WEATHERED_STONE_SLAB, BlockRegistry.POLISHED_WEATHERED_STONE_STAIRS);
        simpleBlock(BlockRegistry.LIGHT_CYAN_FLOOR_TILE);
        slabAndStairs(BlockRegistry.LIGHT_CYAN_FLOOR_TILE, BlockRegistry.LIGHT_CYAN_FLOOR_TILE_SLAB, BlockRegistry.LIGHT_CYAN_FLOOR_TILE_STAIRS);
        wall(BlockRegistry.LIGHT_CYAN_FLOOR_TILE, BlockRegistry.LIGHT_CYAN_FLOOR_TILE_WALL);
        simpleBlock(BlockRegistry.ROSEWOOD_PLANKS);
        slabAndStairs(BlockRegistry.ROSEWOOD_PLANKS, BlockRegistry.ROSEWOOD_SLAB, BlockRegistry.ROSEWOOD_STAIRS);
        fence(BlockRegistry.ROSEWOOD_PLANKS, BlockRegistry.ROSEWOOD_FENCE);
        simpleBlock(BlockRegistry.BAMBOO_MAT);
        slabAndStairs(BlockRegistry.BAMBOO_MAT, BlockRegistry.BAMBOO_MAT_SLAB, BlockRegistry.BAMBOO_MAT_STAIRS);
        wall(BlockRegistry.POLISHED_WEATHERED_STONE, BlockRegistry.POLISHED_WEATHERED_STONE_WALL);
        simpleBlock(BlockRegistry.CYAN_FLOOR_TILE);
        slabAndStairs(BlockRegistry.CYAN_FLOOR_TILE, BlockRegistry.CYAN_FLOOR_TILE_SLAB, BlockRegistry.CYAN_FLOOR_TILE_STAIRS);
        wall(BlockRegistry.CYAN_FLOOR_TILE, BlockRegistry.CYAN_FLOOR_TILE_WALL);
        simpleBlock(BlockRegistry.GREEN_GLAZED_TILES);
        slabAndStairs(BlockRegistry.GREEN_GLAZED_TILES, BlockRegistry.GREEN_GLAZED_TILE_SLAB, BlockRegistry.GREEN_GLAZED_TILE_STAIRS);
        simpleBlock(BlockRegistry.WHITE_AMD_PINK_MIXED_BRICKS);
        simpleBlock(BlockRegistry.WEATHERED_RED_STONE_TILE);
        simpleBlock(BlockRegistry.BLUE_AND_BLACK_TILE);
        simpleBlock(BlockRegistry.GREEN_WEATHERED_STONE);
        simpleBlock(BlockRegistry.GREEN_WEATHERED_BRICKS);
        simpleBlock(BlockRegistry.DARK_CYAN_FLOOR_TILE);
        horizontalBlock(BlockRegistry.LAYERED_CYAN_FLOOR_TILES, models().cubeAll(name(BlockRegistry.LAYERED_CYAN_FLOOR_TILES), modBlockLoc(BlockRegistry.LAYERED_CYAN_FLOOR_TILES)));
        horizontalBlock(BlockRegistry.VERTICAL_CYAN_FLOOR_TILES, models().cubeAll(name(BlockRegistry.VERTICAL_CYAN_FLOOR_TILES), modBlockLoc(BlockRegistry.VERTICAL_CYAN_FLOOR_TILES)));
        horizontalBlock(BlockRegistry.MIXED_CYAN_FLOOR_TILES, models().cubeAll(name(BlockRegistry.MIXED_CYAN_FLOOR_TILES), modBlockLoc(BlockRegistry.MIXED_CYAN_FLOOR_TILES)));
        simpleBlock(BlockRegistry.CHISELED_CYAN_FLOOR_TILE);
        simpleBlock(BlockRegistry.CUT_CYAN_FLOOR_TILES);

        simpleBlock(BlockRegistry.CARVED_RED_PILLAR);
        sideBottomTop(BlockRegistry.CARVED_RED_PILLAR_BASE);
        directionalSideEnd(BlockRegistry.CARVED_RED_PILLAR_HEAD, sideLoc(BlockRegistry.CARVED_RED_PILLAR_HEAD), modBlockLoc(BlockRegistry.CARVED_RED_PILLAR));
        chiralDirectionalBlock(BlockRegistry.CARVED_DARK_OAK_BEAM);
        chiralDirectionalBlock(BlockRegistry.CARVED_DARK_OAK_BEAM_EDGE);
        simpleBlock(BlockRegistry.GILDED_DARK_OAK);
        simpleBlock(BlockRegistry.CHISELED_GILDED_DARK_OAK);
        slabSideEnd(BlockRegistry.GILDED_DARK_OAK_SLAB, BlockRegistry.GILDED_DARK_OAK, sideLoc(BlockRegistry.GILDED_DARK_OAK_SLAB), blockLoc(BlockRegistry.GILDED_DARK_OAK));
        straightStairs(BlockRegistry.GILDED_DARK_OAK_STAIRS);
        horizontalBlockOffset(BlockRegistry.GILDED_DARK_OAK_BEAM_HEAD, 180);
        horizontalBlockNoOffset(BlockRegistry.GILDED_DARK_OAK_BRACKET);
        railingBlock(BlockRegistry.WHITE_MARBLE_RAILING);
        railingBlock(BlockRegistry.CARVED_WOODEN_RAILING);


        simpleBlock(BlockRegistry.RED_CARVED_WOOD);
        carvedWoodenSlab(BlockRegistry.RED_CARVED_WOODEN_SLAB, BlockRegistry.RED_CARVED_WOOD);
        straightStairs(BlockRegistry.RED_CARVED_WOODEN_STAIRS);
        simpleBlock(BlockRegistry.ORANGE_AND_BLUE_CARVED_WOOD);
        simpleBlock(BlockRegistry.ORANGE_AND_GREEN_CARVED_WOOD);
        simpleBlock(BlockRegistry.BLUE_CARVED_WOOD);
        carvedWoodenSlab(BlockRegistry.BLUE_CARVED_WOODEN_SLAB, BlockRegistry.BLUE_CARVED_WOOD);
        straightStairs(BlockRegistry.BLUE_CARVED_WOODEN_STAIRS);
        straightStairs(BlockRegistry.BLUE_CARVED_WOODEN_BRACKET_STAIRS);
        horizontalBlockNoOffset(BlockRegistry.BLUE_CARVED_WOODEN_BRACKET);
        simpleBlock(BlockRegistry.GREEN_AND_BLUE_CARVED_WOOD);
        simpleBlock(BlockRegistry.GREEN_CARVED_WOOD);
        carvedWoodenSlab(BlockRegistry.GREEN_CARVED_WOODEN_SLAB, BlockRegistry.GREEN_CARVED_WOOD);
        straightStairs(BlockRegistry.GREEN_CARVED_WOODEN_STAIRS);
        horizontalBlockNoOffset(BlockRegistry.GREEN_CARVED_WOODEN_BRACKET);
        simpleBlock(BlockRegistry.CYAN_CARVED_WOOD);
        carvedWoodenSlab(BlockRegistry.CYAN_CARVED_WOODEN_SLAB, BlockRegistry.CYAN_CARVED_WOOD);
        straightStairs(BlockRegistry.CYAN_CARVED_WOODEN_STAIRS);
        horizontalBlockNoOffset(BlockRegistry.CYAN_CARVED_WOODEN_BRACKET);
        simpleBlock(BlockRegistry.DARK_GREEN_AND_DARK_BLUE_CARVED_WOOD);
        simpleBlock(BlockRegistry.DARK_BLUE_AND_DARK_GREEN_CARVED_WOOD);
        simpleBlock(BlockRegistry.BLACK_WHITE_GREEN_CARVED_WOOD);
        simpleBlock(BlockRegistry.BLACK_WHITE_BLUE_CARVED_WOOD);
        simpleBlock(BlockRegistry.RED_AND_GREEN_CARVED_WOOD);
        simpleBlock(BlockRegistry.BLUE_AND_WHITE_CARVED_WOOD);
        simpleBlock(BlockRegistry.BLUE_WHITE_RED_CARVED_WOOD);
        simpleBlock(BlockRegistry.GREEN_WHITE_RED_CARVED_WOOD);
        simpleBlock(BlockRegistry.RED_AND_CYAN_CARVED_ARCHITRAVE);
        slabSideEndNoFull(BlockRegistry.RED_AND_CYAN_CARVED_ARCHITRAVE_SLAB, sideLoc(BlockRegistry.RED_AND_CYAN_CARVED_ARCHITRAVE_SLAB), endLoc(BlockRegistry.RED_AND_CYAN_CARVED_ARCHITRAVE_SLAB));
        simpleBlock(BlockRegistry.RED_AND_BLUE_CARVED_ARCHITRAVE);
        slabSideEndNoFull(BlockRegistry.RED_AND_BLUE_CARVED_ARCHITRAVE_SLAB, sideLoc(BlockRegistry.RED_AND_BLUE_CARVED_ARCHITRAVE_SLAB), endLoc(BlockRegistry.RED_AND_BLUE_CARVED_ARCHITRAVE_SLAB));
        slabSideEndNoFull(BlockRegistry.EMPTY_TUANHUA_SLAB, sideLoc(BlockRegistry.EMPTY_TUANHUA_SLAB), endLoc(BlockRegistry.EMPTY_TUANHUA_SLAB));
        slabSideEndNoFull(BlockRegistry.FULL_TUANHUA_SLAB, sideLoc(BlockRegistry.FULL_TUANHUA_SLAB), endLoc(BlockRegistry.EMPTY_TUANHUA_SLAB));
        slabSideEndNoFull(BlockRegistry.RED_AND_CYAN_TUANHUA_SLAB, sideLoc(BlockRegistry.RED_AND_CYAN_TUANHUA_SLAB), endLoc(BlockRegistry.RED_AND_CYAN_TUANHUA_SLAB));
        slabSideEndNoFull(BlockRegistry.RED_CARVED_ARCHITRAVE, sideLoc(BlockRegistry.RED_CARVED_ARCHITRAVE), mcLoc(BLOCK + "red_concrete_powder"));
        sideBottomTop(BlockRegistry.STRIPPED_DARK_OAK_PILLAR_BASE, sideLoc(BlockRegistry.STRIPPED_DARK_OAK_PILLAR_BASE), mcLoc(BLOCK + "smooth_stone"), mcLoc(BLOCK + "dark_oak_log_top"));
        sideBottomTop(BlockRegistry.SPRUCE_PILLAR_BASE, sideLoc(BlockRegistry.SPRUCE_PILLAR_BASE), mcLoc(BLOCK + "smooth_stone"), mcLoc(BLOCK + "spruce_log_top"));
        sideBottomTop(BlockRegistry.STONE_PILLAR_BASE, sideLoc(BlockRegistry.STONE_PILLAR_BASE), mcLoc(BLOCK + "chiseled_stone_bricks"), mcLoc(BLOCK + "chiseled_stone_bricks"));
        simpleBlock(BlockRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_1);
        simpleBlock(BlockRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_2);
        simpleBlock(BlockRegistry.BLUE_AND_YELLOW_CARVED_WOOD_VARIANT_3);
        simpleBlock(BlockRegistry.STONE_FLOWER_WINDOW);
        directionalSideBottomTop(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_1, sideLoc(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_1),
                bottomLoc(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_1), mcLoc(BLOCK + "dark_oak_log_top"));
        directionalSideEnd(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_2, sideLoc(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_2), endLoc(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_2));
        directionalSideEnd(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_3, sideLoc(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_3), mcLoc(BLOCK + "dark_oak_log_top"));
        directionalSideEnd(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_4, sideLoc(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_4), endLoc(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_4));
        directionalSideBottomTop(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_5, sideLoc(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_5),
                bottomLoc(BlockRegistry.GILDED_DARK_OAK_PILLAR_HEAD_VARIANT_5), mcLoc(BLOCK + "dark_oak_log_top"));
        directionalSideEnd(BlockRegistry.CYAN_AND_WHITE_PILLAR_BASE, sideLoc(BlockRegistry.CYAN_AND_WHITE_PILLAR_BASE), mcLoc(BLOCK + "red_terracotta"));
        directionalSideEnd(BlockRegistry.CYAN_AND_WHITE_PILLAR_HEAD, sideLoc(BlockRegistry.CYAN_AND_WHITE_PILLAR_HEAD), mcLoc(BLOCK + "red_terracotta"));
        simpleBlock(BlockRegistry.YELLOW_AND_GREEN_CARVED_WOOD);
        simpleBlock(BlockRegistry.BLACK_FLOOR_TILES, models().cubeAll(name(BlockRegistry.BLACK_FLOOR_TILES), modBlockLoc(BlockRegistry.BLACK_FLOOR_TILES)));
        horizontalBlock(BlockRegistry.BLACK_FLOOR_TILES_LITTLE_MOSSY, models().cube(name(BlockRegistry.BLACK_FLOOR_TILES_LITTLE_MOSSY),
                modLoc(BLOCK + "black_floor_tiles_little_moss_down"), modLoc(BLOCK + "black_floor_tiles_little_moss_down"),
                modLoc(BLOCK + "black_floor_tiles_little_moss_up"), modLoc(BLOCK + "black_floor_tiles_little_moss_up"),
                modLoc(BLOCK + "black_floor_tiles"), modLoc(BLOCK + "black_floor_tiles")
        ).texture("particle", modLoc(BLOCK + "black_floor_tiles")), 0);
        horizontalBlock(BlockRegistry.BLACK_FLOOR_TILES_MODERATE_MOSSY, models().cube(name(BlockRegistry.BLACK_FLOOR_TILES_MODERATE_MOSSY),
                modLoc(BLOCK + "black_floor_tiles_moderate_moss_right"), modLoc(BLOCK + "black_floor_tiles_moderate_moss_right"),
                modLoc(BLOCK + "black_floor_tiles"), modLoc(BLOCK + "black_floor_tiles"),
                modLoc(BLOCK + "black_floor_tiles_moderate_moss_up"), modLoc(BLOCK + "black_floor_tiles_moderate_moss_up")
        ).texture("particle", modLoc(BLOCK + "black_floor_tiles")), 0);
        horizontalBlock(BlockRegistry.BLACK_FLOOR_TILES_VERY_MOSSY, models().cube(name(BlockRegistry.BLACK_FLOOR_TILES_VERY_MOSSY),
                modLoc(BLOCK + "black_floor_tiles_big_moss_top_right"), modLoc(BLOCK + "black_floor_tiles_big_moss_bottom_right"),
                modLoc(BLOCK + "black_floor_tiles_big_moss_top_right"), modLoc(BLOCK + "black_floor_tiles_big_moss_top_right"),
                modLoc(BLOCK + "black_floor_tiles_big_moss_top_right"), modLoc(BLOCK + "black_floor_tiles_big_moss_top_left")
        ).texture("particle", modLoc(BLOCK + "black_floor_tiles")), 0);
        slabSideEndNoFull(BlockRegistry.WHITE_AND_RED_SLAB, sideLoc(BlockRegistry.WHITE_AND_RED_SLAB), endLoc(BlockRegistry.WHITE_AND_RED_SLAB));
        simpleBlock(BlockRegistry.YELLOW_GREEN_BLUE_CARVED_WOOD);
        horizontalBlock(BlockRegistry.BOOKSHELF, models().cube(name(BlockRegistry.BOOKSHELF),
                modLoc(BLOCK + "bookshelf_side"), modLoc(BLOCK + "bookshelf_side"),
                modLoc(BLOCK + "bookshelf_front"), modLoc(BLOCK + "bookshelf_back"),
                modLoc(BLOCK + "bookshelf_side"), modLoc(BLOCK + "bookshelf_side")
        ).texture("particle", modLoc(BLOCK + "bookshelf_side")), 0);
        horizontalBlock(BlockRegistry.BOOKSHELF_VARIANT, models().cube(name(BlockRegistry.BOOKSHELF_VARIANT),
                modLoc(BLOCK + "bookshelf_side"), modLoc(BLOCK + "bookshelf_side"),
                modLoc(BLOCK + "bookshelf_variant_front"), modLoc(BLOCK + "bookshelf_variant_back"),
                modLoc(BLOCK + "bookshelf_side"), modLoc(BLOCK + "bookshelf_side")
        ).texture("particle", modLoc(BLOCK + "bookshelf_side")), 0);


        directionalSideEnd(BlockRegistry.GREEN_FANGXIN, sideLoc(BlockRegistry.GREEN_FANGXIN), endLoc(BlockRegistry.GREEN_FANGXIN));
        directionalSideEnd(BlockRegistry.GREEN_FANGXIN_EDGE, sideLoc(BlockRegistry.GREEN_FANGXIN_EDGE), endLoc(BlockRegistry.GREEN_FANGXIN));
        chiralWSMirror(BlockRegistry.BLUE_FANGXIN_EDGE, mcLoc(BLOCK + "blue_concrete_powder")); //north face gold left = left / gold top & bottom
        directionalSideEnd(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE, sideLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE), endLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE));
        directionalSideEnd(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE_VARIANT, sideLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE_VARIANT), endLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE));
        directionalSideEnd(BlockRegistry.CYAN_BLUE_WHITE_FANGXIN_EDGE, sideLoc(BlockRegistry.CYAN_BLUE_WHITE_FANGXIN_EDGE), endLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE));
        directionalSideEnd(BlockRegistry.BLUE_AND_GREEN_FANGXIN_EDGE, sideLoc(BlockRegistry.BLUE_AND_GREEN_FANGXIN_EDGE), endLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE));
        directionalSideEnd(BlockRegistry.YELLOW_AND_GREEN_FANGXIN_EDGE, sideLoc(BlockRegistry.YELLOW_AND_GREEN_FANGXIN_EDGE), endLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE));
        directionalSideEnd(BlockRegistry.DARK_BLUE_FANGXIN_EDGE, sideLoc(BlockRegistry.DARK_BLUE_FANGXIN_EDGE), mcLoc(BLOCK + "blue_wool"));
        directionalSideEnd(BlockRegistry.BLUE_FANGXIN, sideLoc(BlockRegistry.BLUE_FANGXIN), mcLoc(BLOCK + "green_wool"));
        axisSideEnd(BlockRegistry.CYAN_AND_BLUE_FANGXIN, sideLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN), endLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE));
        axisSideEnd(BlockRegistry.CYAN_BLUE_WHITE_FANGXIN, sideLoc(BlockRegistry.CYAN_BLUE_WHITE_FANGXIN), endLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE));
        axisSideEnd(BlockRegistry.BLUE_AND_WHITE_FANGXIN, sideLoc(BlockRegistry.BLUE_AND_WHITE_FANGXIN), endLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE));
        axisSideEnd(BlockRegistry.GREEN_AND_DARK_BLUE_FANGXIN, sideLoc(BlockRegistry.GREEN_AND_DARK_BLUE_FANGXIN), endLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE));
        axisSideEnd(BlockRegistry.DARK_BLUE_FANGXIN, sideLoc(BlockRegistry.DARK_BLUE_FANGXIN), mcLoc(BLOCK + "blue_wool"));
        directionalSideBottomTop(BlockRegistry.BLUE_ZHAOTOU_EDGE, sideLoc(BlockRegistry.BLUE_ZHAOTOU_EDGE), mcLoc(BLOCK + "green_wool"), mcLoc(BLOCK + "blue_wool"));
        directionalSideBottomTop(BlockRegistry.GREEN_AND_BLUE_ZHAOTOU, sideLoc(BlockRegistry.GREEN_AND_BLUE_ZHAOTOU), mcLoc(BLOCK + "green_wool"), mcLoc(BLOCK + "blue_wool"));
        directionalSideBottomTop(BlockRegistry.BLUE_AND_GREEN_ZHAOTOU, sideLoc(BlockRegistry.BLUE_AND_GREEN_ZHAOTOU), mcLoc(BLOCK + "blue_wool"), mcLoc(BLOCK + "green_wool"));
        directionalSideEnd(BlockRegistry.blue_and_green_double_layered_zhaotou, sideLoc(BlockRegistry.blue_and_green_double_layered_zhaotou), endLoc(BlockRegistry.blue_and_green_double_layered_zhaotou));
        axisSideEnd(BlockRegistry.WHITE_AND_CYAN_FANGXIN, sideLoc(BlockRegistry.WHITE_AND_CYAN_FANGXIN), mcLoc(BLOCK + "blue_concrete_powder"));
        axisSideEnd(BlockRegistry.WHITE_AND_BLUE_FANGXIN, sideLoc(BlockRegistry.WHITE_AND_BLUE_FANGXIN), mcLoc(BLOCK + "blue_concrete_powder"));
        directionalSideEnd(BlockRegistry.WHITE_AND_CYAN_FANGXIN_EDGE, sideLoc(BlockRegistry.WHITE_AND_CYAN_FANGXIN_EDGE), mcLoc(BLOCK + "blue_concrete_powder"));
        directionalSideEnd(BlockRegistry.WHITE_AND_BLUE_FANGXIN_EDGE, sideLoc(BlockRegistry.WHITE_AND_BLUE_FANGXIN_EDGE), mcLoc(BLOCK + "blue_concrete_powder"));
        directionalSideEnd(BlockRegistry.CYAN_AND_RED_ZHAOTOU, sideLoc(BlockRegistry.CYAN_AND_RED_ZHAOTOU), mcLoc(BLOCK + "blue_concrete_powder"));
        directionalSideEnd(BlockRegistry.CYAN_AND_BLUE_ZHAOTOU, sideLoc(BlockRegistry.CYAN_AND_BLUE_ZHAOTOU), mcLoc(BLOCK + "blue_concrete_powder"));
        directionalSideEnd(BlockRegistry.RED_CYAN_BLUE_FANGXIN_EDGE, sideLoc(BlockRegistry.RED_CYAN_BLUE_FANGXIN_EDGE), mcLoc(BLOCK + "blue_concrete_powder"));
        directionalSideEnd(BlockRegistry.BLUE_CYAN_BLUE_FANGXIN_EDGE, sideLoc(BlockRegistry.BLUE_CYAN_BLUE_FANGXIN_EDGE), mcLoc(BLOCK + "blue_concrete_powder"));
        directionalSideEnd(BlockRegistry.BLUE_CYAN_RED_FANGXIN_EDGE, sideLoc(BlockRegistry.BLUE_CYAN_RED_FANGXIN_EDGE), mcLoc(BLOCK + "blue_concrete_powder"));
        chiralWSMirror(BlockRegistry.BLUE_CYAN_RED_FANGXIN, mcLoc(BLOCK + "blue_concrete_powder"));
        chiralWSMirror(BlockRegistry.RED_CYAN_BLUE_FANGXIN, mcLoc(BLOCK + "blue_concrete_powder"));
        chiralWSMirror(BlockRegistry.CYAN_BLUE_CYAN_FANGXIN, mcLoc(BLOCK + "blue_concrete_powder"));
        chiralWSMirror(BlockRegistry.RED_BLUE_RED_FANGXIN, mcLoc(BLOCK + "blue_concrete_powder"));
        directionalSideEnd(BlockRegistry.GRAY_BLACK_RED_ZHAOTOU, sideLoc(BlockRegistry.GRAY_BLACK_RED_ZHAOTOU), mcLoc(BLOCK + "blue_wool"));
        directionalSideEnd(BlockRegistry.BLUE_GREEN_RED_ZHAOTOU, sideLoc(BlockRegistry.BLUE_GREEN_RED_ZHAOTOU), mcLoc(BLOCK + "blue_wool"));
        directionalSideEnd(BlockRegistry.CYAN_AND_YELLOW_FANGXIN_EDGE, sideLoc(BlockRegistry.CYAN_AND_YELLOW_FANGXIN_EDGE), mcLoc(BLOCK + "blue_wool"));
        directionalSideBottomTop(BlockRegistry.GREEN_BLUE_BLACK_GUTOU, sideLoc(BlockRegistry.GREEN_BLUE_BLACK_GUTOU), mcLoc(BLOCK + "black_wool"), mcLoc(BLOCK + "white_wool"));
        directionalSideBottomTop(BlockRegistry.RED_AND_BLUE_ZHAOTOU, sideLoc(BlockRegistry.RED_AND_BLUE_ZHAOTOU), mcLoc(BLOCK + "red_wool"), mcLoc(BLOCK + "blue_wool"));
        directionalSideEnd(BlockRegistry.GREEN_AND_YELLOW_ZHAOTOU, sideLoc(BlockRegistry.GREEN_AND_YELLOW_ZHAOTOU), endLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE));
        directionalSideEnd(BlockRegistry.RED_GREEN_BLUE_ZHAOTOU, sideLoc(BlockRegistry.RED_GREEN_BLUE_ZHAOTOU), endLoc(BlockRegistry.CYAN_AND_BLUE_FANGXIN_EDGE));
        directionalSideEnd(BlockRegistry.BLUE_GREEN_YELLOW_GUTOU, sideLoc(BlockRegistry.BLUE_GREEN_YELLOW_GUTOU), mcLoc(BLOCK + "green_wool"));
        directionalSideEnd(BlockRegistry.WHITE_BLUE_GREEN_ZHAOTOU, sideLoc(BlockRegistry.WHITE_BLUE_GREEN_ZHAOTOU), endLoc(BlockRegistry.WHITE_BLUE_GREEN_ZHAOTOU));
        directionalSideEnd(BlockRegistry.CYAN_AND_WHITE_DECORATED_PILLAR, sideLoc(BlockRegistry.CYAN_AND_WHITE_DECORATED_PILLAR), mcLoc(BLOCK + "red_terracotta"));
        directionalSideEnd(BlockRegistry.BLUE_AND_YELLOW_GUTOU, sideLoc(BlockRegistry.BLUE_AND_YELLOW_GUTOU), mcLoc(BLOCK + "green_wool"));


        shiftedTiles(BlockRegistry.GRAY_ROOF_TILES, "gray", RoofTiles.RoofTileType.NORMAL);
        shiftedTiles(BlockRegistry.GRAY_ROOF_TILE_STAIRS, "gray", RoofTiles.RoofTileType.STAIRS);
        shiftedDirectionalBlock(BlockRegistry.GRAY_ROOF_TILE_EDGE);
        shiftedTiles(BlockRegistry.YELLOW_ROOF_TILES, "yellow", RoofTiles.RoofTileType.NORMAL);
        shiftedTiles(BlockRegistry.YELLOW_ROOF_TILE_STAIRS, "yellow", RoofTiles.RoofTileType.STAIRS);
        shiftedTiles(BlockRegistry.YELLOW_ROOF_TILE_EDGE, "yellow", RoofTiles.RoofTileType.EDGE);
        shiftedTiles(BlockRegistry.GREEN_ROOF_TILES, "green", RoofTiles.RoofTileType.NORMAL);
        shiftedTiles(BlockRegistry.GREEN_ROOF_TILE_STAIRS, "green", RoofTiles.RoofTileType.STAIRS);
        shiftedTiles(BlockRegistry.GREEN_ROOF_TILE_EDGE, "green", RoofTiles.RoofTileType.EDGE);
        shiftedTiles(BlockRegistry.BLUE_ROOF_TILES, "blue", RoofTiles.RoofTileType.NORMAL);
        shiftedTiles(BlockRegistry.BLUE_ROOF_TILE_STAIRS, "blue", RoofTiles.RoofTileType.STAIRS);
        shiftedTiles(BlockRegistry.BLUE_ROOF_TILE_EDGE, "blue", RoofTiles.RoofTileType.EDGE);
        shiftedTiles(BlockRegistry.CYAN_ROOF_TILES, "cyan", RoofTiles.RoofTileType.NORMAL);
        shiftedTiles(BlockRegistry.CYAN_ROOF_TILE_STAIRS, "cyan", RoofTiles.RoofTileType.STAIRS);
        shiftedTiles(BlockRegistry.CYAN_ROOF_TILE_EDGE, "cyan", RoofTiles.RoofTileType.EDGE);
        shiftedTiles(BlockRegistry.BLACK_ROOF_TILES, "black", RoofTiles.RoofTileType.NORMAL);
        shiftedTiles(BlockRegistry.BLACK_ROOF_TILE_STAIRS, "black", RoofTiles.RoofTileType.STAIRS);
        shiftedDirectionalBlock(BlockRegistry.BLACK_ROOF_TILE_EDGE);


        sideBottomTop(BlockRegistry.BLACK_ROOF_RIDGE_UPPER);
        sideBottomTop(BlockRegistry.BLACK_ROOF_RIDGE_LOWER, sideLoc(BlockRegistry.BLACK_ROOF_RIDGE_LOWER), bottomLoc(BlockRegistry.BLACK_ROOF_RIDGE_UPPER), bottomLoc(BlockRegistry.BLACK_ROOF_RIDGE_UPPER));
        axialFrontSideBottomTop(BlockRegistry.BLACK_ROOF_RIDGE_CONNECTION, frontLoc(BlockRegistry.BLACK_ROOF_RIDGE_CONNECTION), sideLoc(BlockRegistry.BLACK_ROOF_RIDGE_CONNECTION),
                bottomLoc(BlockRegistry.BLACK_ROOF_RIDGE_UPPER), topLoc(BlockRegistry.BLACK_ROOF_RIDGE_UPPER));
        horizontalFrontSideBottomTop(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_CONNECTION, frontLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_CONNECTION), sideLoc(BlockRegistry.BLACK_ROOF_RIDGE_CONNECTION),
                frontLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_CONNECTION), topLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_CONNECTION));
        slabSideBottomTopNoFull(BlockRegistry.BLACK_ROOF_RIDGE_UPPER_SLAB, sideLoc(BlockRegistry.BLACK_ROOF_RIDGE_UPPER_SLAB), bottomLoc(BlockRegistry.BLACK_ROOF_RIDGE_UPPER), topLoc(BlockRegistry.BLACK_ROOF_RIDGE_UPPER));
        directionalSlabFrontSideBottomTopNoFull(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB, frontLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB), sideLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB),
                bottomLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB), topLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB));
        roofRidgePanel(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_PANEL, frontLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB), sideLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB),
                bottomLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB), topLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB));
        roofRidgePlate(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_PLATE, frontLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB), sideLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB),
                bottomLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB), topLoc(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_SLAB));
        straightStairs(BlockRegistry.BLACK_MAIN_ROOF_RIDGE_STAIRS);

        sideBottomTop(BlockRegistry.YELLOW_ROOF_RIDGE_UPPER);
        sideBottomTop(BlockRegistry.YELLOW_ROOF_RIDGE_LOWER, sideLoc(BlockRegistry.YELLOW_ROOF_RIDGE_LOWER), bottomLoc(BlockRegistry.YELLOW_ROOF_RIDGE_UPPER), bottomLoc(BlockRegistry.YELLOW_ROOF_RIDGE_UPPER));
        axialFrontSideBottomTop(BlockRegistry.YELLOW_ROOF_RIDGE_CONNECTION, frontLoc(BlockRegistry.YELLOW_ROOF_RIDGE_CONNECTION), sideLoc(BlockRegistry.YELLOW_ROOF_RIDGE_CONNECTION),
                bottomLoc(BlockRegistry.YELLOW_ROOF_RIDGE_UPPER), topLoc(BlockRegistry.YELLOW_ROOF_RIDGE_UPPER));
        horizontalFrontSideBottomTop(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_CONNECTION, frontLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_CONNECTION), sideLoc(BlockRegistry.YELLOW_ROOF_RIDGE_CONNECTION),
                frontLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_CONNECTION), topLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_CONNECTION));
        slabSideBottomTopNoFull(BlockRegistry.YELLOW_ROOF_RIDGE_UPPER_SLAB, sideLoc(BlockRegistry.YELLOW_ROOF_RIDGE_UPPER_SLAB), bottomLoc(BlockRegistry.YELLOW_ROOF_RIDGE_UPPER), topLoc(BlockRegistry.YELLOW_ROOF_RIDGE_UPPER));
        directionalSlabFrontSideBottomTopNoFull(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB, frontLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB), sideLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB),
                bottomLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB), topLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB));
        roofRidgePanel(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_PANEL, frontLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB), sideLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB),
                bottomLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB), topLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB));
        roofRidgePlate(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_PLATE, frontLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB), sideLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB),
                bottomLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB), topLoc(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_SLAB));
        straightStairs(BlockRegistry.YELLOW_MAIN_ROOF_RIDGE_STAIRS);

        vegetableBasket((StackableHalfBlock) BlockRegistry.CABBAGE_BASKET);
        vegetableBasket((StackableHalfBlock) BlockRegistry.CELERY_BASKET);
        vegetableBasket((StackableHalfBlock) BlockRegistry.ORANGE_BASKET);
        vegetableBasket((StackableHalfBlock) BlockRegistry.APPLE_BASKET);
        vegetableBasket((StackableHalfBlock) BlockRegistry.EGGPLANT_BASKET);
        vegetableBasket((StackableHalfBlock) BlockRegistry.PEAR_BASKET);

        BuiltInRegistries.BLOCK.stream().filter(blockRegistryObject -> blockRegistryObject instanceof SideAxialBlock)
                .forEach(sideAxial -> {
                    SideAxialBlock block = (SideAxialBlock) sideAxial;
                    if (block instanceof RailingSlant) shiftedHorizontalBlockNoOffset(block);
                    else horizontalBlockOffset(sideAxial, 180);
                });

        BuiltInRegistries.BLOCK.stream().filter(blockRegistryObject -> blockRegistryObject instanceof CentralAxialBlock)
                .forEach(this::axisBlock);

        BuiltInRegistries.BLOCK.stream().filter(blockRegistryObject -> blockRegistryObject instanceof Rafter)
                .forEach(this::shiftedAxisBlock);

        BuiltInRegistries.BLOCK.stream().filter(blockRegistryObject -> blockRegistryObject instanceof RafterEnd)
                .forEach(rafterEnd -> shiftedDirectionalBlock(rafterEnd, 180));

        BuiltInRegistries.BLOCK.stream().filter(blockRegistryObject -> blockRegistryObject instanceof DecorativeBlock)
                .forEach(decorativeBlock -> {
                    DecorativeBlock block = (DecorativeBlock) decorativeBlock;
                    if (ROTATED_DECO.containsKey(decorativeBlock)) decorativeBlock(block, ROTATED_DECO.get(decorativeBlock));
                    else if (block instanceof ConsumableDecorativeBlock consumableDecorativeBlock) consumableDecorativeBlock(consumableDecorativeBlock);
                    else if (block instanceof Censer censer) censer(censer, 0);
                    else if (block instanceof OpeningBlock openingBlock) openingBlock(openingBlock);
                    else decorativeBlock(block);
                });

        BuiltInRegistries.BLOCK.stream().filter(blockRegistryObject -> blockRegistryObject instanceof SideBlock)
                .forEach(sideBlock -> {
                    SideBlock block = (SideBlock) sideBlock;
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

        horizontalBlock(BlockRegistry.WOODWORKING_WORKBENCH, models().getExistingFile(blockLoc(BlockRegistry.WOODWORKING_WORKBENCH)));
        simpleBlock(BlockRegistry.JADE_ORE);
        simpleBlock(BlockRegistry.MAGNESITE_ORE);
        simpleBlock(BlockRegistry.HEMATITE_ORE);
    }

    private ResourceLocation blockLoc(Block block){
        return modLoc(BLOCK + name(block));
    }

    private void existingModelBlock(Block block){
        simpleBlock(block, models().getExistingFile(modLoc(BLOCK + name(block))));
    }

    private void slabAndStairs(Block baseBlock, Block slabBlock, Block stairBlock){
        slabBlock((SlabBlock) slabBlock, RegistryHelper.getBlockRegistryName(baseBlock), blockLoc(baseBlock));
        stairsBlock((StairBlock) stairBlock, blockLoc(baseBlock));
    }

    private void wall(Block baseBlock, Block wallBlock){
        wallBlock((WallBlock)wallBlock, RegistryHelper.getBlockRegistryName(wallBlock).getPath(), blockLoc(baseBlock));
    }

    private void fence(Block baseBlock, Block fenceBlock){
        fenceBlock((FenceBlock)fenceBlock, RegistryHelper.getBlockRegistryName(fenceBlock).getPath(), blockLoc(baseBlock));
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
            String path = Objects.requireNonNull(RegistryHelper.getBlockRegistryName(block)).getPath();
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

    private void shiftedDirectionalBlock(Block block, int rotation) {
        getVariantBuilder(block).forAllStates(blockState -> {
            if (!blockState.getValue(ModBlockStateProperties.SHIFTED))
                return ConfiguredModel.builder().modelFile(models().getExistingFile(modLoc(BLOCK + RegistryHelper.getBlockRegistryName(block).getPath())))
                        .rotationY(rotation + (int) blockState.getValue(HORIZONTAL_FACING).toYRot()).build();
            else
                return ConfiguredModel.builder().modelFile(models().getExistingFile(modLoc(BLOCK + RegistryHelper.getBlockRegistryName(block).getPath() + "_shifted")))
                        .rotationY(rotation + (int) blockState.getValue(HORIZONTAL_FACING).toYRot()).build();
        });
    }

    private void shiftedDirectionalBlock(Block block) {
        shiftedDirectionalBlock(block, 0);
    }

    private void axisBlock(Block block) {
        getVariantBuilder(block).forAllStates(blockState -> {
            ConfiguredModel.Builder<?> builder;
            builder = ConfiguredModel.builder().modelFile(models().getExistingFile(modLoc(BLOCK + RegistryHelper.getBlockRegistryName(block).getPath())));
            if (blockState.getValue(HORIZONTAL_AXIS) == Direction.Axis.X)
                builder.rotationY(90);
            return builder.build();
        });
    }

    private void shiftedAxisBlock(Block block) {
        getVariantBuilder(block).forAllStates(blockState -> {
            ConfiguredModel.Builder<?> builder;
            if (!blockState.getValue(ModBlockStateProperties.SHIFTED)) {
                builder = ConfiguredModel.builder().modelFile(models().getExistingFile(modLoc(BLOCK + RegistryHelper.getBlockRegistryName(block).getPath())));
            }
            else {
                builder = ConfiguredModel.builder().modelFile(models().getExistingFile(modLoc(BLOCK + RegistryHelper.getBlockRegistryName(block).getPath() + "_shifted")));
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
            String blockPath = Objects.requireNonNull(RegistryHelper.getBlockRegistryName(block)).getPath();
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
            ResourceLocation resourceLocation = Objects.requireNonNull(RegistryHelper.getBlockRegistryName(block));
            String blockPath = resourceLocation.getPath() + "_" + bites;
            return getDecorativeBlockConfiguredModels(block, blockState, blockPath, modelFile, rotation);
        });
    }

    private void censer(Censer block, int rotation){
        getVariantBuilder(block).forAllStates(blockState -> {
            var modelFile = ConfiguredModel.builder();
            ResourceLocation resourceLocation = Objects.requireNonNull(RegistryHelper.getBlockRegistryName(block));
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
        String blockName = Objects.requireNonNull(RegistryHelper.getBlockRegistryName(block)).getPath();
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
        String blockName = Objects.requireNonNull(RegistryHelper.getBlockRegistryName(block)).getPath();
        sideBottomTop(block, modLoc(BLOCK + blockName + "_side"), modLoc(BLOCK + blockName + "_bottom"), modLoc(BLOCK + blockName + "_top"));
    }

    private void sideBottomTop(Block block, ResourceLocation side, ResourceLocation bottom, ResourceLocation top){
        String blockName = Objects.requireNonNull(RegistryHelper.getBlockRegistryName(block)).getPath();
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

    private void horizontalBlockOffset(Block block, int offset){
        horizontalBlock(block, models().getExistingFile(modLoc(BLOCK + name(block))), offset);
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
        String blockName = Objects.requireNonNull(RegistryHelper.getBlockRegistryName(block)).getPath();
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
        slabBlock((SlabBlock) block, RegistryHelper.getBlockRegistryName(full), side, end, end);
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
        slabBlock((SlabBlock) slab, RegistryHelper.getBlockRegistryName(full), sideLoc(slab), blockLoc(full), blockLoc(full));
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
        return Objects.requireNonNull(RegistryHelper.getBlockRegistryName(block)).getPath();
    }

    @NotNull
    @Override
    public String getName() {
        return UltramarineDataGenerators.MOD_ID + " Block Models";
    }
}
