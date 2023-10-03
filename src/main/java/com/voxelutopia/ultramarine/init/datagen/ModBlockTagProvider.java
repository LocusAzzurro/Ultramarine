package com.voxelutopia.ultramarine.init.datagen;

import com.voxelutopia.ultramarine.UltramarineDataGenerators;
import com.voxelutopia.ultramarine.common.block.*;
import com.voxelutopia.ultramarine.init.registry.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        BuiltInRegistries.BLOCK.stream().filter(blockRegistryObject -> blockRegistryObject instanceof BaseBlockPropertyHolder)
                .forEach(blockRegistryObject -> {
                    BaseBlockProperty property = ((BaseBlockPropertyHolder) blockRegistryObject).getProperty();
                    tag(property.getMaterial().getTool()).add(blockRegistryObject);
                });
        BuiltInRegistries.BLOCK.stream().filter(blockRegistryObject -> blockRegistryObject instanceof RoofTiles)
                .forEach(blockRegistryObject -> tag(BlockTags.MINEABLE_WITH_PICKAXE).add(blockRegistryObject));
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.JADE_ORE)
                .add(ModBlocks.MAGNESITE_ORE)
                .add(ModBlocks.HEMATITE_ORE);
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.MAGNESITE_ORE)
                .add(ModBlocks.HEMATITE_ORE);
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.JADE_ORE);
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.OCTAGONAL_PALACE_LANTERN)
                .add(ModBlocks.SQUARE_PALACE_LANTERN)
                .add(ModBlocks.STANDING_LAMP)
                .add(ModBlocks.SMALL_STANDING_LAMP)
                .add(ModBlocks.WHITE_SKY_LANTERN)
                .add(ModBlocks.RED_SKY_LANTERN)
                .add(ModBlocks.YELLOW_SKY_LANTERN);
        tag(BlockTags.PLANKS)
                .add(ModBlocks.ROSEWOOD_PLANKS);
        BuiltInRegistries.BLOCK.stream().filter((blockRegistryObject -> blockRegistryObject instanceof BaseWall))
                .forEach(blockRegistryObject -> tag(BlockTags.WALLS).add(blockRegistryObject));
        BuiltInRegistries.BLOCK.stream().filter((blockRegistryObject -> blockRegistryObject instanceof BaseFence))
                .forEach(blockRegistryObject -> tag(BlockTags.FENCES).add(blockRegistryObject));
    }

    @Override
    public @NotNull FabricTagBuilder tag(TagKey<Block> tag) {
        return getOrCreateTagBuilder(tag);
    }

    @Override
    public String getName() {
        return UltramarineDataGenerators.MOD_ID + " Block Tags";
    }
}