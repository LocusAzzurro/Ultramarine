package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.BlockRegistry;
import com.voxelutopia.ultramarine.world.block.RoofTiles;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Collectors;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, DataGenerators.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockRegistry.CYAN_BRICKS.get())
                .add(BlockRegistry.CYAN_BRICK_SLAB.get())
                .add(BlockRegistry.CYAN_BRICK_STAIRS.get())
                .add(BlockRegistry.JADE_ORE.get());
        BlockRegistry.BLOCKS.getEntries().stream().filter((blockRegistryObject -> blockRegistryObject.get() instanceof RoofTiles))
                        .forEach(blockRegistryObject -> tag(BlockTags.MINEABLE_WITH_PICKAXE).add(blockRegistryObject.get()));
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockRegistry.JADE_ORE.get());
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(BlockRegistry.OCTAGONAL_PALACE_LANTERN.get())
                .add(BlockRegistry.SQUARE_PALACE_LANTERN.get())
                .add(BlockRegistry.WHITE_SKY_LANTERN.get())
                .add(BlockRegistry.RED_SKY_LANTERN.get())
                .add(BlockRegistry.YELLOW_SKY_LANTERN.get());
    }

    @Override
    public String getName() {
        return DataGenerators.MOD_ID + " Block Tags";
    }
}