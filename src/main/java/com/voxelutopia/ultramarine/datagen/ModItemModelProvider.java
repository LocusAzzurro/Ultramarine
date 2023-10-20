package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.world.block.BaseFence;
import com.voxelutopia.ultramarine.world.block.BaseWall;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class ModItemModelProvider extends ItemModelProvider {

    private final static List<RegistryObject<Block>> NON_SIMPLE_BLOCKS = new ArrayList<>();
    private final static List<RegistryObject<Item>> NON_SIMPLE_ITEMS = new ArrayList<>();

    static {
        BlockRegistry.BLOCKS.getEntries().stream()
                .filter(blockRegistryObject -> (
                        blockRegistryObject.get() instanceof BaseWall ||
                                blockRegistryObject.get() instanceof BaseFence
                ))
                .forEach(NON_SIMPLE_BLOCKS::add);
    }

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, DataGenerators.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        BlockRegistry.BLOCKS.getEntries().stream()
                .filter(blockRegistryObject -> !NON_SIMPLE_BLOCKS.contains(blockRegistryObject))
                .forEach(this::blockItem);
        wallInventory(BlockRegistry.BLACK_BRICK_WALL.get().getRegistryName().getPath(), blockLoc(BlockRegistry.BLACK_BRICKS.get()));
        wallInventory(BlockRegistry.CYAN_BRICK_WALL.get().getRegistryName().getPath(), blockLoc(BlockRegistry.CYAN_BRICKS.get()));
        wallInventory(BlockRegistry.CYAN_FLOOR_TILE_WALL.get().getRegistryName().getPath(), blockLoc(BlockRegistry.CYAN_FLOOR_TILE.get()));
        wallInventory(BlockRegistry.LIGHT_CYAN_FLOOR_TILE_WALL.get().getRegistryName().getPath(), blockLoc(BlockRegistry.LIGHT_CYAN_FLOOR_TILE.get()));
        wallInventory(BlockRegistry.BROWNISH_RED_STONE_BRICK_WALL.get().getRegistryName().getPath(), blockLoc(BlockRegistry.BROWNISH_RED_STONE_BRICKS.get()));
        wallInventory(BlockRegistry.POLISHED_WEATHERED_STONE_WALL.get().getRegistryName().getPath(), blockLoc(BlockRegistry.POLISHED_WEATHERED_STONE.get()));
        fenceInventory(BlockRegistry.ROSEWOOD_FENCE.get().getRegistryName().getPath(), blockLoc(BlockRegistry.ROSEWOOD_PLANKS.get()));
        ItemRegistry.ITEMS.getEntries().stream()
                .filter(blockRegistryObject -> !NON_SIMPLE_ITEMS.contains(blockRegistryObject))
                .filter(blockRegistryObject -> !(blockRegistryObject.get() instanceof BlockItem))
                .forEach(this::generatedItem);

    }

    private ItemModelBuilder generatedItem(RegistryObject<Item> item) {
        return singleTexture(item.get().getRegistryName().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/" + item.get().getRegistryName().getPath()));
    }

    private ItemModelBuilder blockItem(RegistryObject<Block> block) {
        return withExistingParent(block.get().getRegistryName().getPath(), modLoc("block/" + block.get().getRegistryName().getPath()));
    }

    private ResourceLocation blockLoc(Block block) {
        return modLoc("block/" + block.getRegistryName().getPath());
    }

    @Override
    public String getName() {
        return DataGenerators.MOD_ID + " Item Models";
    }

}
