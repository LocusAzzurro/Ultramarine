package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.loot.ReplaceToSingleItemLootModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
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
                        LootTableIdCondition.builder(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_COMMON.location()).build(),
                        LootItemRandomChanceCondition.randomChance(0.2f).build()
                }, ModArchaeologyLootProvider.TRAIL_RUINS_COMMON.location()
        ));
        add("archy_trail_ruins_rare_modifier", new ReplaceToSingleItemLootModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_RARE.location()).build(),
                        LootItemRandomChanceCondition.randomChance(0.1f).build()
                }, ModArchaeologyLootProvider.TRAIL_RUINS_RARE.location()
        ));

        add("goat_fur_drop_modifier", new AddTableLootModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(vanillaEntityTable(EntityType.GOAT)).build()
                }, ModEntityExtraLootProvider.GOAT_EXTRA_DROP
        ));
        add("fox_fur_drop_modifier", new AddTableLootModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(vanillaEntityTable(EntityType.FOX)).build()
                }, ModEntityExtraLootProvider.FOX_EXTRA_DROP
        ));
        add("rabbit_fur_drop_modifier", new AddTableLootModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(vanillaEntityTable(EntityType.RABBIT)).build()
                }, ModEntityExtraLootProvider.RABBIT_EXTRA_DROP
        ));
    }

    private ResourceLocation vanillaEntityTable(EntityType<?> entityType){
        return entityType.getDefaultLootTable().location();
    }

}
