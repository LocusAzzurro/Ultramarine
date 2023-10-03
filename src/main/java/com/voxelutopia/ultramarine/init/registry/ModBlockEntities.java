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

public class ModBlockEntities {

    public static BlockEntityType<ContainerDecorativeBlockEntity>
            CONTAINER_DECORATIVE_BLOCK;
    public static BlockEntityType<CenserBlockEntity>
            CENSER;
    public static BlockEntityType<BottleGourdBlockEntity>
            BOTTLE_GOURD;
    static Set<Block> CONTAINER_BLOCKS = Set.of(
            ModBlocks.GUNNY_SACK, ModBlocks.FRUIT_BOX, ModBlocks.WOODEN_CRATE, ModBlocks.FOOD_HAMPER,
            ModBlocks.OAK_CABINET, ModBlocks.WARPED_CABINET, ModBlocks.EBONY_CABINET);
    static Set<Block> CENSERS = Set.of(ModBlocks.BRONZE_CENSER, ModBlocks.ROYAL_CENSER);

    public static void registerModBlockEntities() {
        CONTAINER_DECORATIVE_BLOCK = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(Ultramarine.MOD_ID, "container_decorative_block_entity"),
                FabricBlockEntityTypeBuilder.create(ContainerDecorativeBlockEntity::new, new HashSet<>(CONTAINER_BLOCKS).toArray(new Block[0])).build(null));

        CENSER = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(Ultramarine.MOD_ID, "censer_block_entity"),
                FabricBlockEntityTypeBuilder.create(CenserBlockEntity::new, new HashSet<>(CENSERS).toArray(new Block[0])).build(null));

        BOTTLE_GOURD = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(Ultramarine.MOD_ID, "bottle_gourd_entity"),
                FabricBlockEntityTypeBuilder.create(BottleGourdBlockEntity::new, ModBlocks.BOTTLE_GOURD).build(null));

    }
}
