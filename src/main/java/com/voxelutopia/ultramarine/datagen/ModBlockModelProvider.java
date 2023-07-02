package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.world.block.state.ChiralBlockType;
import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import com.voxelutopia.ultramarine.world.block.*;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.*;

@SuppressWarnings("unused")
public class ModBlockModelProvider extends BlockStateProvider {

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

    public ModBlockModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, DataGenerators.MOD_ID, existingFileHelper);
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

        chiralDirectionalBlock(BlockRegistry.ENGRAVED_DARK_OAK_BEAM_EDGE.get());

        //<editor-fold desc="Roof Tiles">
        shiftedDirectionalBlock(BlockRegistry.GRAY_ROOF_TILES.get(), "gray", RoofTiles.RoofTileType.NORMAL);
        shiftedDirectionalBlock(BlockRegistry.GRAY_ROOF_TILE_STAIRS.get(), "gray", RoofTiles.RoofTileType.STAIRS);
        shiftedBlock(BlockRegistry.GRAY_ROOF_TILE_EDGE.get());
        shiftedDirectionalBlock(BlockRegistry.YELLOW_ROOF_TILES.get(), "yellow", RoofTiles.RoofTileType.NORMAL);
        shiftedDirectionalBlock(BlockRegistry.YELLOW_ROOF_TILE_STAIRS.get(), "yellow", RoofTiles.RoofTileType.STAIRS);
        shiftedDirectionalBlock(BlockRegistry.YELLOW_ROOF_TILE_EDGE.get(), "yellow", RoofTiles.RoofTileType.EDGE);
        shiftedDirectionalBlock(BlockRegistry.GREEN_ROOF_TILES.get(), "green", RoofTiles.RoofTileType.NORMAL);
        shiftedDirectionalBlock(BlockRegistry.GREEN_ROOF_TILE_STAIRS.get(), "green", RoofTiles.RoofTileType.STAIRS);
        shiftedDirectionalBlock(BlockRegistry.GREEN_ROOF_TILE_EDGE.get(), "green", RoofTiles.RoofTileType.EDGE);
        shiftedDirectionalBlock(BlockRegistry.BLUE_ROOF_TILES.get(), "blue", RoofTiles.RoofTileType.NORMAL);
        shiftedDirectionalBlock(BlockRegistry.BLUE_ROOF_TILE_STAIRS.get(), "blue", RoofTiles.RoofTileType.STAIRS);
        shiftedDirectionalBlock(BlockRegistry.BLUE_ROOF_TILE_EDGE.get(), "blue", RoofTiles.RoofTileType.EDGE);
        shiftedDirectionalBlock(BlockRegistry.CYAN_ROOF_TILES.get(), "cyan", RoofTiles.RoofTileType.NORMAL);
        shiftedDirectionalBlock(BlockRegistry.CYAN_ROOF_TILE_STAIRS.get(), "cyan", RoofTiles.RoofTileType.STAIRS);
        shiftedDirectionalBlock(BlockRegistry.CYAN_ROOF_TILE_EDGE.get(), "cyan", RoofTiles.RoofTileType.EDGE);
        shiftedDirectionalBlock(BlockRegistry.BLACK_ROOF_TILES.get(), "black", RoofTiles.RoofTileType.NORMAL);
        shiftedDirectionalBlock(BlockRegistry.BLACK_ROOF_TILE_STAIRS.get(), "black", RoofTiles.RoofTileType.STAIRS);
        shiftedBlock(BlockRegistry.BLACK_ROOF_TILE_EDGE.get());
        //</editor-fold>

        var decorativeBlocks = new ArrayList<>(BlockRegistry.BLOCKS.getEntries().stream()
                .filter(blockRegistryObject -> blockRegistryObject.get() instanceof DecorativeBlock).toList());

        var consumables = decorativeBlocks.stream().filter(blockRegistryObject -> blockRegistryObject.get() instanceof ConsumableDecorativeBlock).toList();
        consumables.forEach(blockRegistryObject -> consumableDecorativeBlock((ConsumableDecorativeBlock) blockRegistryObject.get()));
        decorativeBlocks.removeAll(consumables);

        var censers = decorativeBlocks.stream().filter(blockRegistryObject -> blockRegistryObject.get() instanceof Censer).toList();
        censers.forEach(blockRegistryObject -> censer((Censer) blockRegistryObject.get(), 0));
        decorativeBlocks.removeAll(censers);

        decorativeBlocks.forEach(blockRegistryObject -> decorativeBlock((DecorativeBlock) blockRegistryObject.get()));

        horizontalBlock(BlockRegistry.WOODWORKING_WORKBENCH.get(), models().getExistingFile(blockLoc(BlockRegistry.WOODWORKING_WORKBENCH.get())));
        simpleBlock(BlockRegistry.JADE_ORE.get());
        simpleBlock(BlockRegistry.MAGNESITE_ORE.get());
    }

    private ResourceLocation blockLoc(Block block){
        return modLoc("block/" + block.getRegistryName().getPath());
    }

    private void existingModelBlock(Block block){
        simpleBlock(block, models().getExistingFile(modLoc("block/" + block.getRegistryName().getPath())));
    }

    private void slabAndStairs(Block baseBlock, Block slabBlock, Block stairBlock){
        slabBlock((SlabBlock) slabBlock, baseBlock.getRegistryName(), blockLoc(baseBlock));
        stairsBlock((StairBlock) stairBlock, blockLoc(baseBlock));
    }

    private void wall(Block baseBlock, Block wallBlock){
        wallBlock((WallBlock)wallBlock, wallBlock.getRegistryName().getPath(), blockLoc(baseBlock));
    }

    private void fence(Block baseBlock, Block fenceBlock){
        fenceBlock((FenceBlock)fenceBlock, fenceBlock.getRegistryName().getPath(), blockLoc(baseBlock));
    }

    public void chiralDirectionalBlock(Block block) {
        directionalBlock(block, state -> {
            String path = Objects.requireNonNull(block.getRegistryName()).getPath();
            if (state.hasProperty(ModBlockStateProperties.CHIRAL_BLOCK_TYPE)){
                ChiralBlockType chiralBlockType = state.getValue(ModBlockStateProperties.CHIRAL_BLOCK_TYPE);
                if (chiralBlockType == ChiralBlockType.LEFT || chiralBlockType == ChiralBlockType.TOP){
                    return models().getExistingFile(modLoc("block/" + path));
                }
                else return models().getExistingFile(modLoc("block/" + path + "_mirrored"));
            }
            return models().getExistingFile(modLoc("block/" + path));
        });
    }

    private void shiftedDirectionalBlock(Block block, String color, ShiftedTileType type) {
        models().withExistingParent(modLoc("block/" + color + "_" + type).getPath(), modLoc("block/" + type))
                .texture("1", blockLoc(block)).texture("particle", mcLoc("block/" + color + "_concrete"));
        models().withExistingParent(modLoc("block/" + color + "_" + type + "_shifted").getPath(), modLoc("block/" + type + "_shifted"))
                .texture("1", blockLoc(block)).texture("particle", mcLoc("block/" + color + "_concrete"));;
        shiftedBlock(block);
    }

    private void shiftedBlock(Block block) {
        getVariantBuilder(block).forAllStates(blockState -> {
            if (!blockState.getValue(ModBlockStateProperties.SHIFTED))
                return ConfiguredModel.builder().modelFile(models().getExistingFile(modLoc("block/" + block.getRegistryName().getPath())))
                        .rotationY((int) blockState.getValue(HORIZONTAL_FACING).toYRot()).build();
            else
                return ConfiguredModel.builder().modelFile(models().getExistingFile(modLoc("block/" + block.getRegistryName().getPath() + "_shifted")))
                        .rotationY((int) blockState.getValue(HORIZONTAL_FACING).toYRot()).build();
        });
    }

    private void decorativeBlock(DecorativeBlock block){
        decorativeBlock(block, 0);
    }

    private void decorativeBlock(DecorativeBlock block, int rotation){
        getVariantBuilder(block).forAllStates(blockState -> {
            var modelFile = ConfiguredModel.builder();
            String blockPath = Objects.requireNonNull(block.getRegistryName()).getPath();
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
            ResourceLocation resourceLocation = Objects.requireNonNull(block.getRegistryName());
            String blockPath = resourceLocation.getPath() + "_" + bites;
            return getDecorativeBlockConfiguredModels(block, blockState, blockPath, modelFile, rotation);
        });
    }

    private void censer(Censer block, int rotation){
        getVariantBuilder(block).forAllStates(blockState -> {
            var modelFile = ConfiguredModel.builder();
            ResourceLocation resourceLocation = Objects.requireNonNull(block.getRegistryName());
            String blockPath = blockState.getValue(LIT) ? "lit_" + resourceLocation.getPath() : resourceLocation.getPath();
            return getDecorativeBlockConfiguredModels(block, blockState, blockPath, modelFile, rotation);
        });
    }

    private ConfiguredModel[] getDecorativeBlockConfiguredModels(DecorativeBlock block, BlockState blockState, String blockPath, ConfiguredModel.Builder<?> modelFile, int rotation) {
        if (!block.isDirectional() && !block.isDiagonallyPlaceable()){
            return modelFile.modelFile(models().getExistingFile(modLoc("block/" + blockPath))).build();
        }
        else if (!block.isDirectional() && block.isDiagonallyPlaceable()){
            if (blockState.getValue(ModBlockStateProperties.DIAGONAL))
                modelFile.modelFile(models().getExistingFile(modLoc("block/" + blockPath + "_diagonal")));
            else
                modelFile.modelFile(models().getExistingFile(modLoc("block/" + blockPath)));
            return modelFile.build();
        }
        else if (block.isDirectional() && !block.isDiagonallyPlaceable()){
            modelFile.modelFile(models().getExistingFile(modLoc("block/" + blockPath)));
            return modelFile.rotationY((int) blockState.getValue(HORIZONTAL_FACING).toYRot() + rotation).build();
        }
        else {
            if (!blockState.getValue(ModBlockStateProperties.DIAGONAL)){
                modelFile.modelFile(models().getExistingFile(modLoc("block/" + blockPath)));
                return modelFile.rotationY((int) blockState.getValue(HORIZONTAL_FACING).toYRot() + rotation).build();
            }
            else {
                modelFile.modelFile(models().getExistingFile(modLoc("block/" + blockPath + "_diagonal")));
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
                .modelFile(models().getExistingFile(modLoc("block/" + block.getRegistryName().getPath() + "_diagonal"))).addModel();
    }


    @NotNull
    @Override
    public String getName() {
        return DataGenerators.MOD_ID + " Item Models";
    }
}
