package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.loot.ReplaceToSingleItemLootModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

import static com.voxelutopia.ultramarine.datagen.DataGenerators.MOD_ID;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {

    public ModGlobalLootModifiersProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MOD_ID);
    }

    @Override
    protected void start() {
        add("archy_trail_ruins_common_modifier", new ReplaceToSingleItemLootModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_COMMON.identifier()).build(),
                        LootItemRandomChanceCondition.randomChance(0.2f).build()
                }, 1000, ModArchaeologyLootProvider.TRAIL_RUINS_COMMON.identifier().toString()
        ));
        add("archy_trail_ruins_rare_modifier", new ReplaceToSingleItemLootModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_RARE.identifier()).build(),
                        LootItemRandomChanceCondition.randomChance(0.1f).build()
                }, 1000, ModArchaeologyLootProvider.TRAIL_RUINS_RARE.identifier().toString()
        ));

        addEntityExtraLoot("goat_fur_drop_modifier", EntityType.GOAT, ModEntityExtraLootProvider.GOAT_EXTRA_DROP);
        addEntityExtraLoot("fox_fur_drop_modifier", EntityType.FOX, ModEntityExtraLootProvider.FOX_EXTRA_DROP);
        addEntityExtraLoot("rabbit_fur_drop_modifier", EntityType.RABBIT, ModEntityExtraLootProvider.RABBIT_EXTRA_DROP);
        addEntityExtraLoot("hoglin_raw_meat_drop_modifier", EntityType.HOGLIN, ModEntityExtraLootProvider.HOGLIN_EXTRA_DROP);
        addEntityExtraLoot("ravager_raw_meat_drop_modifier", EntityType.RAVAGER, ModEntityExtraLootProvider.RAVAGER_EXTRA_DROP);
    }

    private void addEntityExtraLoot(String name, EntityType<?> entityType, ResourceKey<net.minecraft.world.level.storage.loot.LootTable> table) {
        add(name, new AddTableLootModifier(
                new LootItemCondition[]{LootTableIdCondition.builder(entityType.getDefaultLootTable().orElseThrow().identifier()).build()},
                1000,
                table
        ));
    }
}
