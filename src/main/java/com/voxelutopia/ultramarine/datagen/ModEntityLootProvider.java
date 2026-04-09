package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.registry.EntityTypeRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootTable;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public class ModEntityLootProvider extends EntityLootSubProvider {



    public ModEntityLootProvider(HolderLookup.Provider registries) {
        super(FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    public void generate() {
        this.add(EntityTypeRegistry.TRAVELLING_MERCHANT.get(), LootTable.lootTable());
    }

    @Override
    @NotNull
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return EntityTypeRegistry.ENTITIES.getEntries().stream().map(DeferredHolder::get);
    }
}
