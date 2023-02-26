package com.voxelutopia.ultramarine.data;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.world.block.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Ultramarine.MOD_ID);
    public static final RegistryObject<Block> CYAN_BRICKS = BLOCKS.register("cyan_bricks", BaseBricks::new);
    public static final RegistryObject<Block> CYAN_BRICK_SLAB = BLOCKS.register("cyan_brick_slab", BaseBrickSlab::new);
    public static final RegistryObject<Block> CYAN_BRICK_STAIRS = BLOCKS.register("cyan_brick_stairs", BaseBrickStairs::new);
    public static final RegistryObject<Block> GRAY_ROOF_TILES = BLOCKS.register("gray_roof_tiles", RoofTiles::new);
    public static final RegistryObject<Block> OCTAGONAL_PALACE_LANTERN = BLOCKS.register("octagonal_palace_lantern", () -> new OffsetLantern(Material.WOOD));
    public static final RegistryObject<Block> SQUARE_PALACE_LANTERN = BLOCKS.register("square_palace_lantern", () -> new DiagonalLantern(Material.WOOD));
    public static final RegistryObject<Block> WHITE_SKY_LANTERN = BLOCKS.register("white_sky_lantern", () -> new Lantern(Material.BAMBOO));
    public static final RegistryObject<Block> RED_SKY_LANTERN = BLOCKS.register("red_sky_lantern", () -> new Lantern(Material.BAMBOO));
    public static final RegistryObject<Block> YELLOW_SKY_LANTERN = BLOCKS.register("yellow_sky_lantern", () -> new Lantern(Material.BAMBOO));

}
