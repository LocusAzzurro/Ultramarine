package com.voxelutopia.ultramarine.util;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.jspecify.annotations.Nullable;

import java.util.Objects;
import java.util.function.Supplier;

public final class RegistryIdContext {
    private static final ThreadLocal<ResourceKey<Block>> CURRENT_BLOCK_ID = new ThreadLocal<>();

    private RegistryIdContext() {
    }

    public static <T> T withBlockId(ResourceKey<Block> blockId, Supplier<T> supplier) {
        Objects.requireNonNull(blockId, "blockId");
        Objects.requireNonNull(supplier, "supplier");

        ResourceKey<Block> previous = CURRENT_BLOCK_ID.get();
        CURRENT_BLOCK_ID.set(blockId);
        try {
            return supplier.get();
        } finally {
            if (previous != null) {
                CURRENT_BLOCK_ID.set(previous);
            } else {
                CURRENT_BLOCK_ID.remove();
            }
        }
    }

    @Nullable
    public static ResourceKey<Block> currentBlockId() {
        return CURRENT_BLOCK_ID.get();
    }

    public static BlockBehaviour.Properties applyCurrentBlockId(BlockBehaviour.Properties properties) {
        ResourceKey<Block> blockId = CURRENT_BLOCK_ID.get();
        if (blockId != null) {
            return properties.setId(blockId);
        }
        return properties;
    }
}

