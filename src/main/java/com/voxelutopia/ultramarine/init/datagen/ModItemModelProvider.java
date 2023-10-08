package com.voxelutopia.ultramarine.init.datagen;

import com.voxelutopia.ultramarine.UltramarineDataGenerators;
import com.voxelutopia.ultramarine.common.block.BaseFence;
import com.voxelutopia.ultramarine.common.block.BaseWall;
import com.voxelutopia.ultramarine.init.registry.ModBlocks;
import com.voxelutopia.ultramarine.util.RegistryHelper;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ModItemModelProvider extends ItemModelProvider {

    private final static List<Block> NON_SIMPLE_BLOCKS = new ArrayList<>();
    private final static List<Item> NON_SIMPLE_ITEMS = new ArrayList<>();

    static {
        Registry.BLOCK.stream()
                .filter(blockRegistryObject -> (
                        blockRegistryObject instanceof BaseWall ||
                                blockRegistryObject instanceof BaseFence
                ))
                .forEach(NON_SIMPLE_BLOCKS::add);
    }

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, UltramarineDataGenerators.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        Registry.BLOCK.stream()
                .filter(blockRegistryObject -> !NON_SIMPLE_BLOCKS.contains(blockRegistryObject))
                .forEach(this::blockItem);
        wallInventory(RegistryHelper.getBlockRegistryName(ModBlocks.BLACK_BRICK_WALL).getPath(), blockLoc(ModBlocks.BLACK_BRICKS));
        wallInventory(RegistryHelper.getBlockRegistryName(ModBlocks.CYAN_BRICK_WALL).getPath(), blockLoc(ModBlocks.CYAN_BRICKS));
        wallInventory(RegistryHelper.getBlockRegistryName(ModBlocks.CYAN_FLOOR_TILE_WALL).getPath(), blockLoc(ModBlocks.CYAN_FLOOR_TILE));
        wallInventory(RegistryHelper.getBlockRegistryName(ModBlocks.LIGHT_CYAN_FLOOR_TILE_WALL).getPath(), blockLoc(ModBlocks.LIGHT_CYAN_FLOOR_TILE));
        wallInventory(RegistryHelper.getBlockRegistryName(ModBlocks.BROWNISH_RED_STONE_BRICK_WALL).getPath(), blockLoc(ModBlocks.BROWNISH_RED_STONE_BRICKS));
        wallInventory(RegistryHelper.getBlockRegistryName(ModBlocks.POLISHED_WEATHERED_STONE_WALL).getPath(), blockLoc(ModBlocks.POLISHED_WEATHERED_STONE));
        fenceInventory(RegistryHelper.getBlockRegistryName(ModBlocks.ROSEWOOD_FENCE).getPath(), blockLoc(ModBlocks.ROSEWOOD_PLANKS));
        Registry.ITEM.stream()
                .filter(blockRegistryObject -> !NON_SIMPLE_ITEMS.contains(blockRegistryObject))
                .filter(blockRegistryObject -> !(blockRegistryObject instanceof BlockItem))
                .forEach(this::generatedItem);

    }

    private ItemModelBuilder generatedItem(Item item) {
        return singleTexture(RegistryHelper.getItemRegistryName(item).getPath(), mcLoc("item/generated"), "layer0", modLoc("item/" + RegistryHelper.getItemRegistryName(item).getPath()));
    }

    private ItemModelBuilder blockItem(Block block) {
        return withExistingParent(RegistryHelper.getBlockRegistryName(block).getPath(), modLoc("block/" + RegistryHelper.getBlockRegistryName(block).getPath()));
    }

    private ResourceLocation blockLoc(Block block) {
        return modLoc("block/" + RegistryHelper.getBlockRegistryName(block).getPath());
    }

    @NotNull
    @Override
    public String getName() {
        return UltramarineDataGenerators.MOD_ID + " Item Models";
    }

}
