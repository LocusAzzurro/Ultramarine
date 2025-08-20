package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.world.block.entity.BottleGourdBlockEntity;
import com.voxelutopia.ultramarine.world.block.entity.BrickKilnBlockEntity;
import com.voxelutopia.ultramarine.world.block.entity.CenserBlockEntity;
import com.voxelutopia.ultramarine.world.block.entity.ContainerDecorativeBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Set;
import java.util.stream.Collectors;

public class BlockEntityRegistry {

    static Set<DeferredHolder<Block, Block>> CONTAINER_BLOCKS = Set.of(
            BlockRegistry.SACK, BlockRegistry.GUNNY_SACK, BlockRegistry.FRUIT_BOX, BlockRegistry.WOODEN_CRATE, BlockRegistry.FOOD_HAMPER,
            BlockRegistry.OAK_CABINET, BlockRegistry.WARPED_CABINET, BlockRegistry.EBONY_CABINET,
            BlockRegistry.BAMBOO_TEA_BASKET, BlockRegistry.EMPTY_BAMBOO_TEA_BASKET);
    static Set<DeferredHolder<Block, Block>> CENSERS = Set.of(BlockRegistry.BRONZE_CENSER, BlockRegistry.ROYAL_CENSER);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Ultramarine.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ContainerDecorativeBlockEntity>>
            CONTAINER_DECORATIVE_BLOCK = BLOCK_ENTITIES.register(
            "container_decorative_block_entity", () -> BlockEntityType.Builder
                    .of(ContainerDecorativeBlockEntity::new, CONTAINER_BLOCKS.stream().map(DeferredHolder::get).collect(Collectors.toSet()).toArray(new Block[0])).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CenserBlockEntity>>
            CENSER = BLOCK_ENTITIES.register(
            "censer_block_entity", () -> BlockEntityType.Builder
                    .of(CenserBlockEntity::new, CENSERS.stream().map(DeferredHolder::get).collect(Collectors.toSet()).toArray(new Block[0])).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BottleGourdBlockEntity>>
            BOTTLE_GOURD = BLOCK_ENTITIES.register(
            "bottle_gourd_entity", () -> BlockEntityType.Builder
                    .of(BottleGourdBlockEntity::new, BlockRegistry.BOTTLE_GOURD.get()).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BrickKilnBlockEntity>>
            BRICK_KILN = BLOCK_ENTITIES.register(
            "brick_kiln_block_entity", () -> BlockEntityType.Builder
                    .of(BrickKilnBlockEntity::new, BlockRegistry.BRICK_KILN.get()).build(null));

}
