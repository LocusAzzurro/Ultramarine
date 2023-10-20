package com.voxelutopia.ultramarine.data.registry;

import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.DSL;
import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.world.block.entity.BottleGourdBlockEntity;
import com.voxelutopia.ultramarine.world.block.entity.CenserBlockEntity;
import com.voxelutopia.ultramarine.world.block.entity.ContainerDecorativeBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.stream.Collectors;

public class BlockEntityRegistry {

    static Set<RegistryObject<Block>> CONTAINER_BLOCKS = ImmutableSet.of(
            BlockRegistry.GUNNY_SACK, BlockRegistry.FRUIT_BOX, BlockRegistry.WOODEN_CRATE, BlockRegistry.FOOD_HAMPER,
            BlockRegistry.OAK_CABINET, BlockRegistry.WARPED_CABINET, BlockRegistry.EBONY_CABINET);
    static Set<RegistryObject<Block>> CENSERS = ImmutableSet.of(BlockRegistry.BRONZE_CENSER, BlockRegistry.ROYAL_CENSER);
    public static final DeferredRegister<TileEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Ultramarine.MOD_ID);

    public static final RegistryObject<TileEntityType<ContainerDecorativeBlockEntity>>
            CONTAINER_DECORATIVE_BLOCK = BLOCK_ENTITIES.register(
            "container_decorative_block_entity", () -> TileEntityType.Builder
                    .of(ContainerDecorativeBlockEntity::new, CONTAINER_BLOCKS.stream().map(RegistryObject::get).collect(Collectors.toSet()).toArray(new Block[0])).build(DSL.remainderType()));
    public static final RegistryObject<TileEntityType<CenserBlockEntity>>
            CENSER = BLOCK_ENTITIES.register(
            "censer_block_entity", () -> TileEntityType.Builder
                    .of(CenserBlockEntity::new, CENSERS.stream().map(RegistryObject::get).collect(Collectors.toSet()).toArray(new Block[0])).build(DSL.remainderType()));
    public static final RegistryObject<TileEntityType<BottleGourdBlockEntity>>
            BOTTLE_GOURD = BLOCK_ENTITIES.register(
            "bottle_gourd_entity", () -> TileEntityType.Builder
                    .of(BottleGourdBlockEntity::new, BlockRegistry.BOTTLE_GOURD.get()).build(DSL.remainderType()));

}
