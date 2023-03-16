package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.BlockRegistry;
import com.voxelutopia.ultramarine.data.ModBlockStateProperties;
import com.voxelutopia.ultramarine.world.block.RoofTiles;
import com.voxelutopia.ultramarine.world.block.ShiftedTileType;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.*;

public class ModBlockModelProvider extends BlockStateProvider {

    public ModBlockModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, DataGenerators.MOD_ID, existingFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        simpleBlock(BlockRegistry.CYAN_BRICKS.get());
        slabAndStairs(BlockRegistry.CYAN_BRICKS.get(), BlockRegistry.CYAN_BRICK_SLAB.get(), BlockRegistry.CYAN_BRICK_STAIRS.get());
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
        //</editor-fold>

        existingModelBlock(BlockRegistry.OCTAGONAL_PALACE_LANTERN.get());
        diagonallyPlaceableBlock(BlockRegistry.SQUARE_PALACE_LANTERN.get());
        diagonallyPlaceableBlock(BlockRegistry.SMALL_RED_LANTERN.get());
        diagonallyPlaceableBlock(BlockRegistry.STANDING_LAMP.get());
        diagonallyPlaceableBlock(BlockRegistry.SMALL_STANDING_LAMP.get());
        existingModelBlock(BlockRegistry.WHITE_SKY_LANTERN.get());
        existingModelBlock(BlockRegistry.RED_SKY_LANTERN.get());
        existingModelBlock(BlockRegistry.YELLOW_SKY_LANTERN.get());

        simpleBlock(BlockRegistry.JADE_ORE.get());
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
