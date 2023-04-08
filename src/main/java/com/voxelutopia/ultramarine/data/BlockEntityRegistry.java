package com.voxelutopia.ultramarine.data;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.world.block.ContainerDecorativeBlock;
import com.voxelutopia.ultramarine.world.block.RoofTiles;
import com.voxelutopia.ultramarine.world.block.entity.ContainerDecorativeBlockEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BlockEntityRegistry {

    static Set<RegistryObject<Block>> CONTAINER_BLOCKS = Set.of(BlockRegistry.GUNNY_SACK);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Ultramarine.MOD_ID);

    public static final RegistryObject<BlockEntityType<ContainerDecorativeBlockEntity>>
            CONTAINER_DECORATIVE_BLOCK = BLOCK_ENTITIES.register(
            "container_decorative_block_entity", () -> BlockEntityType.Builder
                    .of(ContainerDecorativeBlockEntity::new, CONTAINER_BLOCKS.stream().map(RegistryObject::get).collect(Collectors.toSet()).toArray(new Block[0])).build(null));

}
