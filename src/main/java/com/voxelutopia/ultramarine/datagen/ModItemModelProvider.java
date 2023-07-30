package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.world.block.BaseFence;
import com.voxelutopia.ultramarine.world.block.BaseWall;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        wallInventory(ForgeRegistries.BLOCKS.getKey(BlockRegistry.BLACK_BRICK_WALL.get()).getPath(), blockLoc(BlockRegistry.BLACK_BRICKS.get()));
        wallInventory(ForgeRegistries.BLOCKS.getKey(BlockRegistry.CYAN_BRICK_WALL.get()).getPath(), blockLoc(BlockRegistry.CYAN_BRICKS.get()));
        wallInventory(ForgeRegistries.BLOCKS.getKey(BlockRegistry.CYAN_FLOOR_TILE_WALL.get()).getPath(), blockLoc(BlockRegistry.CYAN_FLOOR_TILE.get()));
        wallInventory(ForgeRegistries.BLOCKS.getKey(BlockRegistry.LIGHT_CYAN_FLOOR_TILE_WALL.get()).getPath(), blockLoc(BlockRegistry.LIGHT_CYAN_FLOOR_TILE.get()));
        wallInventory(ForgeRegistries.BLOCKS.getKey(BlockRegistry.BROWNISH_RED_STONE_BRICK_WALL.get()).getPath(), blockLoc(BlockRegistry.BROWNISH_RED_STONE_BRICKS.get()));
        wallInventory(ForgeRegistries.BLOCKS.getKey(BlockRegistry.POLISHED_WEATHERED_STONE_WALL.get()).getPath(), blockLoc(BlockRegistry.POLISHED_WEATHERED_STONE.get()));
        fenceInventory(ForgeRegistries.BLOCKS.getKey(BlockRegistry.ROSEWOOD_FENCE.get()).getPath(), blockLoc(BlockRegistry.ROSEWOOD_PLANKS.get()));
        ItemRegistry.ITEMS.getEntries().stream()
                .filter(blockRegistryObject -> !NON_SIMPLE_ITEMS.contains(blockRegistryObject))
                .filter(blockRegistryObject -> !(blockRegistryObject.get() instanceof BlockItem))
                .forEach(this::generatedItem);

    }

    private ItemModelBuilder generatedItem(RegistryObject<Item> item){
        return singleTexture(ForgeRegistries.ITEMS.getKey(item.get()).getPath(),
                mcLoc("item/generated"), "layer0", modLoc("item/" + ForgeRegistries.ITEMS.getKey(item.get()).getPath()));
    }

    private ItemModelBuilder blockItem(RegistryObject<Block> block){
        //System.out.println(ForgeRegistries.BLOCKS.getKey(block.get()));
        return withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
        //return withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get())));
    }

    private ResourceLocation blockLoc(Block block){
        return modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath());
    }

    @NotNull
    @Override
    public String getName() {
        return DataGenerators.MOD_ID + " Item Models";
    }

}
