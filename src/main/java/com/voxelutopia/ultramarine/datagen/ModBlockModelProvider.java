package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.BlockRegistry;
import com.voxelutopia.ultramarine.data.ModBlockStateProperties;
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

        getVariantBuilder(BlockRegistry.GRAY_ROOF_TILES.get())
                .forAllStates(blockState -> {
                    if (!blockState.getValue(ModBlockStateProperties.SHIFTED)){
                        return ConfiguredModel.builder().modelFile(models().getExistingFile(modLoc("block/gray_roof_tiles")))
                                .rotationY((int) blockState.getValue(HORIZONTAL_FACING).toYRot()).build();
                    }
                    else return ConfiguredModel.builder().modelFile(models().getExistingFile(modLoc("block/gray_roof_tiles_shifted")))
                            .rotationY((int) blockState.getValue(HORIZONTAL_FACING).toYRot()).build();
                });


        existingModelBlock(BlockRegistry.OCTAGONAL_PALACE_LANTERN.get());
        getVariantBuilder(BlockRegistry.SQUARE_PALACE_LANTERN.get())
                .partialState().with(ModBlockStateProperties.DIAGONAL, false).modelForState()
                .modelFile(models().getExistingFile(modLoc("block/square_palace_lantern"))).addModel()
                .partialState().with(ModBlockStateProperties.DIAGONAL, true).modelForState()
                .modelFile(models().getExistingFile(modLoc("block/square_palace_lantern_diagonal"))).addModel();
        existingModelBlock(BlockRegistry.WHITE_SKY_LANTERN.get());
        existingModelBlock(BlockRegistry.RED_SKY_LANTERN.get());
        existingModelBlock(BlockRegistry.YELLOW_SKY_LANTERN.get());
    }

    private ResourceLocation blockLoc(Block block){
        return modLoc("block/" + block.getRegistryName().getPath());
    }

    private void existingModelBlock(Block block){
        simpleBlock(block, models().getExistingFile(modLoc("block/" + block.getRegistryName().getPath())));
    }

    @NotNull
    @Override
    public String getName() {
        return DataGenerators.MOD_ID + " Item Models";
    }
}
