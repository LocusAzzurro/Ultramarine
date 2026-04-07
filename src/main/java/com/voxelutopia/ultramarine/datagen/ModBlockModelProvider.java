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
 * NeoForge 26.1 switches model generation to vanilla {@link ModelProvider}.
 * <p>
 * The previous Forge-style generator API (BlockStateProvider/ModelFile/ConfiguredModel/ExistingFileHelper)
 * has been removed/reshuffled, so this provider is currently a no-op placeholder that keeps datagen
 * compiling and runnable on 26.1.
 */
public final class ModBlockModelProvider extends ModelProvider {
    public ModBlockModelProvider(PackOutput output) {
        super(output, MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        // Intentionally no-op for now.
        // Existing JSON resources in src/main/resources (and/or src/generated/resources) are used at runtime.
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

