package com.voxelutopia.ultramarine.datagen;

import java.util.stream.Stream;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static com.voxelutopia.ultramarine.datagen.DataGenerators.MOD_ID;

/**
 * Kept for source compatibility with older code; NeoForge 26.1 uses vanilla {@link ModelProvider}.
 * <p>
 * This is currently a no-op provider that avoids generating/validating models at build time.
 */
public final class ModItemModelProvider extends ModelProvider {
    public ModItemModelProvider(PackOutput output) {
        super(output, MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        // Intentionally no-op for now.
    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return Stream.empty();
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return Stream.empty();
    }
}

