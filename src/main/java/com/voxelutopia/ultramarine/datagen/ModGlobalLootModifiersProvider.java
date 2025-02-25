package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.loot.ReplaceToSingleItemLootModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import static com.voxelutopia.ultramarine.datagen.DataGenerators.MOD_ID;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {

    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, MOD_ID);
    }

    @Override
    protected void start() {
        add("archy_trail_ruins_common_modifier", new ReplaceToSingleItemLootModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_COMMON).build(),
                        LootItemRandomChanceCondition.randomChance(0.2f).build()
                }, ModArchaeologyLootProvider.TRAIL_RUINS_COMMON
        ));
        add("archy_trail_ruins_rare_modifier", new ReplaceToSingleItemLootModifier(
                new LootItemCondition[]{
                        LootTableIdCondition.builder(BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_RARE).build(),
                        LootItemRandomChanceCondition.randomChance(0.1f).build()
                }, ModArchaeologyLootProvider.TRAIL_RUINS_RARE
        ));
    }
}
