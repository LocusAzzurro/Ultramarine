package com.voxelutopia.ultramarine.data;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Ultramarine.MOD_ID);
    public static final RegistryObject<Item> CYAN_BRICKS = fromBlock(BlockRegistry.CYAN_BRICKS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CYAN_BRICK_SLAB = fromBlock(BlockRegistry.CYAN_BRICK_SLAB, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> CYAN_BRICK_STAIRS = fromBlock(BlockRegistry.CYAN_BRICK_STAIRS, CreativeTabs.BUILDING_BLOCKS);

    public static final RegistryObject<Item> GRAY_ROOF_TILES = fromBlock(BlockRegistry.GRAY_ROOF_TILES, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> OCTAGONAL_PALACE_LANTERN = fromBlock(BlockRegistry.OCTAGONAL_PALACE_LANTERN, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> SQUARE_PALACE_LANTERN = fromBlock(BlockRegistry.SQUARE_PALACE_LANTERN, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> WHITE_SKY_LANTERN = fromBlock(BlockRegistry.WHITE_SKY_LANTERN, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> RED_SKY_LANTERN = fromBlock(BlockRegistry.RED_SKY_LANTERN, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> YELLOW_SKY_LANTERN = fromBlock(BlockRegistry.YELLOW_SKY_LANTERN, CreativeTabs.LAMPS);

    public static final RegistryObject<Item> CYAN_BRICK = simpleItem("cyan_brick", CreativeTabs.MATERIALS);

    private static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block, CreativeModeTab tab) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    private static RegistryObject<Item> simpleItem(String name, CreativeModeTab tab) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().tab(tab)));
    }

}
