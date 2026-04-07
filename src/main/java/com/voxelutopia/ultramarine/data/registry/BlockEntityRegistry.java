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
            "container_decorative_block_entity",
            () -> new BlockEntityType<>(ContainerDecorativeBlockEntity::new, Set.of(getBlocks(CONTAINER_BLOCKS))));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CenserBlockEntity>>
            CENSER = BLOCK_ENTITIES.register(
            "censer_block_entity",
            () -> new BlockEntityType<>(CenserBlockEntity::new, Set.of(getBlocks(CENSERS))));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BottleGourdBlockEntity>>
            BOTTLE_GOURD = BLOCK_ENTITIES.register(
            "bottle_gourd_entity",
            () -> new BlockEntityType<>(BottleGourdBlockEntity::new, Set.of(BlockRegistry.BOTTLE_GOURD.get())));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BrickKilnBlockEntity>>
            BRICK_KILN = BLOCK_ENTITIES.register(
            "brick_kiln_block_entity",
            () -> new BlockEntityType<>(BrickKilnBlockEntity::new, Set.of(BlockRegistry.BRICK_KILN.get())));

    private static Block[] getBlocks(Set<DeferredHolder<Block, Block>> holders) {
        return holders.stream().map(DeferredHolder::get).toArray(Block[]::new);
    }
}
