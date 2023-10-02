package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.world.block.BaseBlockProperty;
import com.voxelutopia.ultramarine.world.block.BaseBlockPropertyHolder;
import com.voxelutopia.ultramarine.world.block.BaseFence;
import com.voxelutopia.ultramarine.world.block.BaseWall;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(DataGenerator pGenerator, ExistingFileHelper existingFileHelper) {
        super(pGenerator, DataGenerators.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        BlockRegistry.BLOCKS.getEntries().stream().filter(blockRegistryObject -> blockRegistryObject.get() instanceof BaseBlockPropertyHolder)
                .forEach(blockRegistryObject -> {
                    Block block = blockRegistryObject.get();
                    BaseBlockProperty property = ((BaseBlockPropertyHolder) block).getProperty();
                    ITag.INamedTag<Block> t = property.getMaterial().getTool();
                    if (t != null) tag(t).add(block);
                });
        //BlockRegistry.BLOCKS.getEntries().stream().filter(blockRegistryObject -> blockRegistryObject.get() instanceof RoofTiles)
        //        .forEach(blockRegistryObject -> tag(BlockTags.MINEABLE_WITH_PICKAXE).add(blockRegistryObject.get()));
        //tag(BlockTags.MINEABLE_WITH_PICKAXE)
        //        .add(BlockRegistry.JADE_ORE.get())
        //        .add(BlockRegistry.MAGNESITE_ORE.get())
        //        .add(BlockRegistry.HEMATITE_ORE.get());
        //tag(BlockTags.NEEDS_STONE_TOOL)
        //        .add(BlockRegistry.MAGNESITE_ORE.get())
        //        .add(BlockRegistry.HEMATITE_ORE.get());
        //tag(BlockTags.NEEDS_IRON_TOOL)
        //        .add(BlockRegistry.JADE_ORE.get());
        //tag(BlockTags.MINEABLE_WITH_AXE)
        //        .add(BlockRegistry.OCTAGONAL_PALACE_LANTERN.get())
        //        .add(BlockRegistry.SQUARE_PALACE_LANTERN.get())
        //        .add(BlockRegistry.STANDING_LAMP.get())
        //        .add(BlockRegistry.SMALL_STANDING_LAMP.get())
        //        .add(BlockRegistry.WHITE_SKY_LANTERN.get())
        //        .add(BlockRegistry.RED_SKY_LANTERN.get())
        //        .add(BlockRegistry.YELLOW_SKY_LANTERN.get());
        tag(BlockTags.PLANKS)
                .add(BlockRegistry.ROSEWOOD_PLANKS.get());
        BlockRegistry.BLOCKS.getEntries().stream().filter((blockRegistryObject -> blockRegistryObject.get() instanceof BaseWall))
                .forEach(blockRegistryObject -> tag(BlockTags.WALLS).add(blockRegistryObject.get()));
        BlockRegistry.BLOCKS.getEntries().stream().filter((blockRegistryObject -> blockRegistryObject.get() instanceof BaseFence))
                .forEach(blockRegistryObject -> tag(BlockTags.FENCES).add(blockRegistryObject.get()));
    }

    @Override
    public String getName() {
        return DataGenerators.MOD_ID + " Block Tags";
    }
}