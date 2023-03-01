package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.BlockRegistry;
import com.voxelutopia.ultramarine.data.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, DataGenerators.MOD_ID, existingFileHelper);
    }
    @Override
    protected void registerModels() {
        blockItem(BlockRegistry.CYAN_BRICKS.get());
        blockItem(BlockRegistry.CYAN_BRICK_SLAB.get());
        blockItem(BlockRegistry.CYAN_BRICK_STAIRS.get());

        generatedItem(ItemRegistry.WOODEN_HAMMER.get());
        blockItem(BlockRegistry.GRAY_ROOF_TILES.get());
        blockItem(BlockRegistry.GRAY_ROOF_TILE_STAIRS.get());
        blockItem(BlockRegistry.GRAY_ROOF_TILE_EDGE.get());
        blockItem(BlockRegistry.YELLOW_ROOF_TILES.get());
        blockItem(BlockRegistry.YELLOW_ROOF_TILE_STAIRS.get());
        blockItem(BlockRegistry.YELLOW_ROOF_TILE_EDGE.get());
        blockItem(BlockRegistry.GREEN_ROOF_TILES.get());
        blockItem(BlockRegistry.GREEN_ROOF_TILE_STAIRS.get());
        blockItem(BlockRegistry.GREEN_ROOF_TILE_EDGE.get());

        blockItem(BlockRegistry.OCTAGONAL_PALACE_LANTERN.get());
        blockItem(BlockRegistry.SQUARE_PALACE_LANTERN.get());
        blockItem(BlockRegistry.WHITE_SKY_LANTERN.get());
        blockItem(BlockRegistry.RED_SKY_LANTERN.get());
        blockItem(BlockRegistry.YELLOW_SKY_LANTERN.get());

        generatedItem(ItemRegistry.CYAN_BRICK.get());
        generatedItem(ItemRegistry.GRAY_ROOF_TILE.get());
        generatedItem(ItemRegistry.YELLOW_ROOF_TILE.get());
        generatedItem(ItemRegistry.GREEN_ROOF_TILE.get());
        generatedItem(ItemRegistry.BLUE_ROOF_TILE.get());
        generatedItem(ItemRegistry.CYAN_ROOF_TILE.get());
        generatedItem(ItemRegistry.BLACK_ROOF_TILE.get());

        blockItem(BlockRegistry.JADE_ORE.get());
        generatedItem(ItemRegistry.JADE.get());
    }

    private ItemModelBuilder generatedItem(Item item){
        return singleTexture(item.getRegistryName().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/" + item.getRegistryName().getPath()));
    }

    private ItemModelBuilder blockItem(Block block){
        return withExistingParent(block.getRegistryName().getPath(), modLoc("block/" + block.getRegistryName().getPath()));
    }
    @NotNull
    @Override
    public String getName() {
        return DataGenerators.MOD_ID + " Item Models";
    }

}
