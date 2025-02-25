package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.world.block.BaseFence;
import com.voxelutopia.ultramarine.world.block.BaseWall;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DiggerItem;
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
import java.util.Objects;

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
        ItemRegistry.ITEMS.getEntries().stream()
                .filter(itemRegistryObject -> itemRegistryObject.get() instanceof DiggerItem)
                .forEach(NON_SIMPLE_ITEMS::add);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DataGenerators.MOD_ID, existingFileHelper);
    }
    @Override
    protected void registerModels() {
        BlockRegistry.BLOCKS.getEntries().stream()
                .filter(blockRegistryObject -> !NON_SIMPLE_BLOCKS.contains(blockRegistryObject))
                .forEach(this::blockItem);
        wallInventory(name(BlockRegistry.BLACK_BRICK_WALL.get()), blockLoc(BlockRegistry.BLACK_BRICKS.get()));
        wallInventory(name(BlockRegistry.CYAN_BRICK_WALL.get()), blockLoc(BlockRegistry.CYAN_BRICKS.get()));
        wallInventory(name(BlockRegistry.CYAN_FLOOR_TILE_WALL.get()), blockLoc(BlockRegistry.CYAN_FLOOR_TILE.get()));
        wallInventory(name(BlockRegistry.LIGHT_CYAN_FLOOR_TILE_WALL.get()), blockLoc(BlockRegistry.LIGHT_CYAN_FLOOR_TILE.get()));
        wallInventory(name(BlockRegistry.BROWNISH_RED_STONE_BRICK_WALL.get()), blockLoc(BlockRegistry.BROWNISH_RED_STONE_BRICKS.get()));
        wallInventory(name(BlockRegistry.POLISHED_WEATHERED_STONE_WALL.get()), blockLoc(BlockRegistry.POLISHED_WEATHERED_STONE.get()));
        wallInventory(name(BlockRegistry.WHITE_AND_PINK_MIXED_BRICK_WALL.get()), blockLoc(BlockRegistry.WHITE_AND_PINK_MIXED_BRICKS.get()));
        wallInventory(name(BlockRegistry.GREEN_WEATHERED_BRICK_WALL.get()), blockLoc(BlockRegistry.GREEN_WEATHERED_BRICKS.get()));
        fenceInventory(name(BlockRegistry.ROSEWOOD_FENCE.get()), blockLoc(BlockRegistry.ROSEWOOD_PLANKS.get()));
        ItemRegistry.ITEMS.getEntries().stream()
                .filter(blockRegistryObject -> !NON_SIMPLE_ITEMS.contains(blockRegistryObject))
                .filter(blockRegistryObject -> !(blockRegistryObject.get() instanceof BlockItem))
                .forEach(this::generatedItem);
        handheldItem(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SWORD);
        handheldItem(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHOVEL);
        handheldItem(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PICKAXE);
        handheldItem(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_AXE);

    }

    private ItemModelBuilder generatedItem(RegistryObject<Item> item){
        return singleTexture(name(item.get()), mcLoc("item/generated"), "layer0", modLoc("item/" + name(item.get())));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item){
        return singleTexture(name(item.get()), mcLoc("item/handheld"), "layer0", modLoc("item/" + name(item.get())));
    }

    private ItemModelBuilder blockItem(RegistryObject<Block> block){
        return withExistingParent(name(block.get()), modLoc("block/" + name(block.get())));
    }

    private ResourceLocation blockLoc(Block block){
        return modLoc("block/" + name(block));
    }

    @NotNull
    @Override
    public String getName() {
        return DataGenerators.MOD_ID + " Item Models";
    }

    private static String name(Item item){
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
    }

    private static String name(Block block){
        return Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
    }

}
