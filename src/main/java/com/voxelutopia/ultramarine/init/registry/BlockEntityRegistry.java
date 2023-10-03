package com.voxelutopia.ultramarine.init.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.common.tile.BottleGourdBlockEntity;
import com.voxelutopia.ultramarine.common.tile.CenserBlockEntity;
import com.voxelutopia.ultramarine.common.tile.ContainerDecorativeBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.HashSet;
import java.util.Set;

public class BlockEntityRegistry {

    static Set<Block> CONTAINER_BLOCKS = Set.of(
            BlockRegistry.GUNNY_SACK, BlockRegistry.FRUIT_BOX, BlockRegistry.WOODEN_CRATE, BlockRegistry.FOOD_HAMPER,
            BlockRegistry.OAK_CABINET, BlockRegistry.WARPED_CABINET, BlockRegistry.EBONY_CABINET);
    static Set<Block> CENSERS = Set.of(BlockRegistry.BRONZE_CENSER, BlockRegistry.ROYAL_CENSER);

    public static BlockEntityType<ContainerDecorativeBlockEntity>
            CONTAINER_DECORATIVE_BLOCK;
    public static BlockEntityType<CenserBlockEntity>
            CENSER;
    public static BlockEntityType<BottleGourdBlockEntity>
            BOTTLE_GOURD;


    public static void registerModBlockEntities() {
        CONTAINER_DECORATIVE_BLOCK = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(Ultramarine.MOD_ID, "container_decorative_block_entity"),
                FabricBlockEntityTypeBuilder.create(ContainerDecorativeBlockEntity::new, new HashSet<>(CONTAINER_BLOCKS).toArray(new Block[0])).build(null));

        CENSER = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(Ultramarine.MOD_ID, "censer_block_entity"),
                FabricBlockEntityTypeBuilder.create(CenserBlockEntity::new, new HashSet<>(CENSERS).toArray(new Block[0])).build(null));

        BOTTLE_GOURD = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(Ultramarine.MOD_ID, "bottle_gourd_entity"),
                FabricBlockEntityTypeBuilder.create(BottleGourdBlockEntity::new, BlockRegistry.BOTTLE_GOURD).build(null));

    }
}
