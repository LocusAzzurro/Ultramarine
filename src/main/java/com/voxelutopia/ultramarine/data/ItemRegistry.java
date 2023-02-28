package com.voxelutopia.ultramarine.data;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.world.item.WoodenHammer;
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

    public static final RegistryObject<Item> WOODEN_HAMMER = ITEMS.register("wooden_hammer", WoodenHammer::new);
    public static final RegistryObject<Item> GRAY_ROOF_TILES = fromBlock(BlockRegistry.GRAY_ROOF_TILES, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> GRAY_ROOF_TILE_STAIRS = fromBlock(BlockRegistry.GRAY_ROOF_TILE_STAIRS, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> GRAY_ROOF_TILE_EDGE = fromBlock(BlockRegistry.GRAY_ROOF_TILE_EDGE, CreativeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Item> OCTAGONAL_PALACE_LANTERN = fromBlock(BlockRegistry.OCTAGONAL_PALACE_LANTERN, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> SQUARE_PALACE_LANTERN = fromBlock(BlockRegistry.SQUARE_PALACE_LANTERN, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> WHITE_SKY_LANTERN = fromBlock(BlockRegistry.WHITE_SKY_LANTERN, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> RED_SKY_LANTERN = fromBlock(BlockRegistry.RED_SKY_LANTERN, CreativeTabs.LAMPS);
    public static final RegistryObject<Item> YELLOW_SKY_LANTERN = fromBlock(BlockRegistry.YELLOW_SKY_LANTERN, CreativeTabs.LAMPS);

    public static final RegistryObject<Item> CYAN_BRICK = simpleItem("cyan_brick", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> GRAY_ROOF_TILE = simpleItem("gray_roof_tile", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> YELLOW_ROOF_TILE = simpleItem("yellow_roof_tile", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> GREEN_ROOF_TILE = simpleItem("green_roof_tile", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> BLUE_ROOF_TILE = simpleItem("blue_roof_tile", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> CYAN_ROOF_TILE = simpleItem("cyan_roof_tile", CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> BLACK_ROOF_TILE = simpleItem("black_roof_tile", CreativeTabs.MATERIALS);

    public static final RegistryObject<Item> JADE_ORE = fromBlock(BlockRegistry.JADE_ORE, CreativeTabs.MATERIALS);
    public static final RegistryObject<Item> JADE = simpleItem("jade", CreativeTabs.MATERIALS);

    private static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block, CreativeModeTab tab) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    private static RegistryObject<Item> simpleItem(String name, CreativeModeTab tab) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().tab(tab)));
    }

}
