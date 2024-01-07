package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.world.block.entity.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;
import java.util.stream.Collectors;

public class BlockEntityRegistry {

    static Set<RegistryObject<Block>> CONTAINER_BLOCKS = Set.of(
            BlockRegistry.GUNNY_SACK, BlockRegistry.FRUIT_BOX, BlockRegistry.WOODEN_CRATE, BlockRegistry.FOOD_HAMPER,
            BlockRegistry.OAK_CABINET, BlockRegistry.WARPED_CABINET, BlockRegistry.EBONY_CABINET);
    static Set<RegistryObject<Block>> CENSERS = Set.of(BlockRegistry.BRONZE_CENSER, BlockRegistry.ROYAL_CENSER);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Ultramarine.MOD_ID);

    public static final RegistryObject<BlockEntityType<ContainerDecorativeBlockEntity>>
            CONTAINER_DECORATIVE_BLOCK = BLOCK_ENTITIES.register(
            "container_decorative_block_entity", () -> BlockEntityType.Builder
                    .of(ContainerDecorativeBlockEntity::new, CONTAINER_BLOCKS.stream().map(RegistryObject::get).collect(Collectors.toSet()).toArray(new Block[0])).build(null));
    public static final RegistryObject<BlockEntityType<CenserBlockEntity>>
            CENSER = BLOCK_ENTITIES.register(
            "censer_block_entity", () -> BlockEntityType.Builder
                    .of(CenserBlockEntity::new, CENSERS.stream().map(RegistryObject::get).collect(Collectors.toSet()).toArray(new Block[0])).build(null));
    public static final RegistryObject<BlockEntityType<BottleGourdBlockEntity>>
            BOTTLE_GOURD = BLOCK_ENTITIES.register(
            "bottle_gourd_entity", () -> BlockEntityType.Builder
                    .of(BottleGourdBlockEntity::new, BlockRegistry.BOTTLE_GOURD.get()).build(null));
    public static final RegistryObject<BlockEntityType<BrickKilnBlockEntity>>
            BRICK_KILN = BLOCK_ENTITIES.register(
            "brick_kiln_block_entity", () -> BlockEntityType.Builder
                    .of(BrickKilnBlockEntity::new, BlockRegistry.BRICK_KILN.get()).build(null));

}
