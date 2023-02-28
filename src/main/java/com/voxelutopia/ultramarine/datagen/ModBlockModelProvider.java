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
        slabBlock((SlabBlock) BlockRegistry.CYAN_BRICK_SLAB.get(), BlockRegistry.CYAN_BRICKS.get().getRegistryName(), blockLoc(BlockRegistry.CYAN_BRICKS.get()));
        stairsBlock((StairBlock) BlockRegistry.CYAN_BRICK_STAIRS.get(), blockLoc(BlockRegistry.CYAN_BRICKS.get()));

        /*
        getVariantBuilder(BlockRegistry.GRAY_ROOF_TILES.get())
                .forAllStates(blockState -> {
                    if (!blockState.getValue(ModBlockStateProperties.SHIFTED)){
                        return ConfiguredModel.builder().modelFile(models().getExistingFile(modLoc("block/gray_roof_tiles")))
                                .rotationY((int) blockState.getValue(HORIZONTAL_FACING).toYRot()).build();
                    }
                    else return ConfiguredModel.builder().modelFile(models().getExistingFile(modLoc("block/gray_roof_tiles_shifted")))
                            .rotationY((int) blockState.getValue(HORIZONTAL_FACING).toYRot()).build();
                });

         */
        shiftedDirectionalBlock(BlockRegistry.GRAY_ROOF_TILES.get(), "gray", RoofTiles.RoofTileType.NORMAL);
        shiftedDirectionalBlock(BlockRegistry.GRAY_ROOF_TILE_STAIRS.get(), "gray", RoofTiles.RoofTileType.STAIRS);
        shiftedDirectionalBlock(BlockRegistry.GRAY_ROOF_TILE_EDGE.get(), "gray", RoofTiles.RoofTileType.EDGE);

        existingModelBlock(BlockRegistry.OCTAGONAL_PALACE_LANTERN.get());
        getVariantBuilder(BlockRegistry.SQUARE_PALACE_LANTERN.get())
                .partialState().with(ModBlockStateProperties.DIAGONAL, false).modelForState()
                .modelFile(models().getExistingFile(modLoc("block/square_palace_lantern"))).addModel()
                .partialState().with(ModBlockStateProperties.DIAGONAL, true).modelForState()
                .modelFile(models().getExistingFile(modLoc("block/square_palace_lantern_diagonal"))).addModel();
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

    private void shiftedDirectionalBlock(Block block, String color, ShiftedTileType type) {
        models().withExistingParent(modLoc("block/" + color + "_" + type).getPath(), modLoc("block/" + type))
                .texture("1", blockLoc(block)).texture("particle", mcLoc("block/" + color + "_concrete"));
        models().withExistingParent(modLoc("block/" + color + "_" + type + "_shifted").getPath(), modLoc("block/" + type + "_shifted"))
                .texture("1", blockLoc(block)).texture("particle", mcLoc("block/" + color + "_concrete"));;
        getVariantBuilder(block).forAllStates(blockState -> {
            if (!blockState.getValue(ModBlockStateProperties.SHIFTED))
                return ConfiguredModel.builder().modelFile(models().getExistingFile(modLoc("block/" + block.getRegistryName().getPath())))
                        .rotationY((int) blockState.getValue(HORIZONTAL_FACING).toYRot()).build();
            else
                return ConfiguredModel.builder().modelFile(models().getExistingFile(modLoc("block/" + block.getRegistryName().getPath() + "_shifted")))
                        .rotationY((int) blockState.getValue(HORIZONTAL_FACING).toYRot()).build();
        });
    }

    @NotNull
    @Override
    public String getName() {
        return DataGenerators.MOD_ID + " Item Models";
    }
}
