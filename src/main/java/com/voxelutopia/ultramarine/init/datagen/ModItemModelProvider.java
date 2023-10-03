package com.voxelutopia.ultramarine.init.datagen;

import com.voxelutopia.ultramarine.UltramarineDataGenerators;
import com.voxelutopia.ultramarine.common.block.BaseFence;
import com.voxelutopia.ultramarine.common.block.BaseWall;
import com.voxelutopia.ultramarine.init.registry.BlockRegistry;
import com.voxelutopia.ultramarine.util.RegistryHelper;
import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import io.github.fabricators_of_create.porting_lib.models.generators.item.ItemModelBuilder;
import io.github.fabricators_of_create.porting_lib.models.generators.item.ItemModelProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ModItemModelProvider extends ItemModelProvider {

    private final static List<Block> NON_SIMPLE_BLOCKS = new ArrayList<>();
    private final static List<Item> NON_SIMPLE_ITEMS = new ArrayList<>();

    static {
        BuiltInRegistries.BLOCK.stream()
                .filter(blockRegistryObject -> (
                        blockRegistryObject  instanceof BaseWall ||
                        blockRegistryObject  instanceof BaseFence
                ))
                .forEach(NON_SIMPLE_BLOCKS::add);
    }

    public ModItemModelProvider(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, UltramarineDataGenerators.MOD_ID, existingFileHelper);
    }
    @Override
    protected void registerModels() {
        BuiltInRegistries.BLOCK.stream()
                .filter(blockRegistryObject -> !NON_SIMPLE_BLOCKS.contains(blockRegistryObject))
                .forEach(this::blockItem);
        wallInventory(RegistryHelper.getBlockRegistryName(BlockRegistry.BLACK_BRICK_WALL).getPath(), blockLoc(BlockRegistry.BLACK_BRICKS));
        wallInventory(RegistryHelper.getBlockRegistryName(BlockRegistry.CYAN_BRICK_WALL).getPath(), blockLoc(BlockRegistry.CYAN_BRICKS));
        wallInventory(RegistryHelper.getBlockRegistryName(BlockRegistry.CYAN_FLOOR_TILE_WALL).getPath(), blockLoc(BlockRegistry.CYAN_FLOOR_TILE));
        wallInventory(RegistryHelper.getBlockRegistryName(BlockRegistry.LIGHT_CYAN_FLOOR_TILE_WALL).getPath(), blockLoc(BlockRegistry.LIGHT_CYAN_FLOOR_TILE));
        wallInventory(RegistryHelper.getBlockRegistryName(BlockRegistry.BROWNISH_RED_STONE_BRICK_WALL).getPath(), blockLoc(BlockRegistry.BROWNISH_RED_STONE_BRICKS));
        wallInventory(RegistryHelper.getBlockRegistryName(BlockRegistry.POLISHED_WEATHERED_STONE_WALL).getPath(), blockLoc(BlockRegistry.POLISHED_WEATHERED_STONE));
        fenceInventory(RegistryHelper.getBlockRegistryName(BlockRegistry.ROSEWOOD_FENCE).getPath(), blockLoc(BlockRegistry.ROSEWOOD_PLANKS));
        BuiltInRegistries.ITEM.stream()
                .filter(blockRegistryObject -> !NON_SIMPLE_ITEMS.contains(blockRegistryObject))
                .filter(blockRegistryObject -> !(blockRegistryObject instanceof BlockItem))
                .forEach(this::generatedItem);

    }

    private ItemModelBuilder generatedItem(Item item){
        return singleTexture(RegistryHelper.getItemRegistryName(item).getPath(), mcLoc("item/generated"), "layer0", modLoc("item/" + RegistryHelper.getItemRegistryName(item).getPath()));
    }

    private ItemModelBuilder blockItem(Block block){
        return withExistingParent(RegistryHelper.getBlockRegistryName(block).getPath(), modLoc("block/" + RegistryHelper.getBlockRegistryName(block).getPath()));
    }

    private ResourceLocation blockLoc(Block block){
        return modLoc("block/" + RegistryHelper.getBlockRegistryName(block).getPath());
    }

    @NotNull
    @Override
    public String getName() {
        return UltramarineDataGenerators.MOD_ID + " Item Models";
    }

}
