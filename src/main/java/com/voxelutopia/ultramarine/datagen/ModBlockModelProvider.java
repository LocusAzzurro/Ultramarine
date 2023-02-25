package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.BlockRegistry;
import com.voxelutopia.ultramarine.data.ModBlockStateProperties;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class ModBlockModelProvider extends BlockStateProvider {

    public ModBlockModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, DataGenerators.MOD_ID, existingFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        simpleBlock(BlockRegistry.CYAN_BRICKS.get());
        slabBlock((SlabBlock) BlockRegistry.CYAN_BRICK_SLAB.get(), BlockRegistry.CYAN_BRICKS.get().getRegistryName(), blockLoc(BlockRegistry.CYAN_BRICKS.get()));
        stairsBlock((StairBlock) BlockRegistry.CYAN_BRICK_STAIRS.get(), blockLoc(BlockRegistry.CYAN_BRICKS.get()));

        simpleBlock(BlockRegistry.OCTAGONAL_PALACE_LANTERN.get(), models().getExistingFile(modLoc("block/octagonal_palace_lantern")));
        getVariantBuilder(BlockRegistry.SQUARE_PALACE_LANTERN.get())
                .partialState().with(ModBlockStateProperties.DIAGONAL, false).modelForState()
                .modelFile(models().getExistingFile(modLoc("block/square_palace_lantern"))).addModel()
                .partialState().with(ModBlockStateProperties.DIAGONAL, true).modelForState()
                .modelFile(models().getExistingFile(modLoc("block/square_palace_lantern_diagonal"))).addModel();
    }

    private ResourceLocation blockLoc(Block block){
        return modLoc("block/" + block.getRegistryName().getPath());
    }
    @NotNull
    @Override
    public String getName() {
        return DataGenerators.MOD_ID + " Item Models";
    }
}
