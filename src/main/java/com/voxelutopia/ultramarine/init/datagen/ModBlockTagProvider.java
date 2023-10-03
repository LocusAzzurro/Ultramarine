package com.voxelutopia.ultramarine.init.datagen;

import com.voxelutopia.ultramarine.UltramarineDataGenerators;
import com.voxelutopia.ultramarine.common.block.*;
import com.voxelutopia.ultramarine.init.registry.BlockRegistry;
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
                .add(BlockRegistry.JADE_ORE)
                .add(BlockRegistry.MAGNESITE_ORE)
                .add(BlockRegistry.HEMATITE_ORE);
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(BlockRegistry.MAGNESITE_ORE)
                .add(BlockRegistry.HEMATITE_ORE);
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockRegistry.JADE_ORE);
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(BlockRegistry.OCTAGONAL_PALACE_LANTERN)
                .add(BlockRegistry.SQUARE_PALACE_LANTERN)
                .add(BlockRegistry.STANDING_LAMP)
                .add(BlockRegistry.SMALL_STANDING_LAMP)
                .add(BlockRegistry.WHITE_SKY_LANTERN)
                .add(BlockRegistry.RED_SKY_LANTERN)
                .add(BlockRegistry.YELLOW_SKY_LANTERN);
        tag(BlockTags.PLANKS)
                .add(BlockRegistry.ROSEWOOD_PLANKS);
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