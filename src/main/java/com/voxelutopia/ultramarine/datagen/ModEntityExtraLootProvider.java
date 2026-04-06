package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

import static com.voxelutopia.ultramarine.datagen.DataGenerators.MOD_ID;

public class ModEntityExtraLootProvider implements LootTableSubProvider {

    public static final ResourceKey<LootTable> GOAT_EXTRA_DROP = entityTable(EntityType.GOAT);
    public static final ResourceKey<LootTable> FOX_EXTRA_DROP = entityTable(EntityType.FOX);
    public static final ResourceKey<LootTable> RABBIT_EXTRA_DROP = entityTable(EntityType.RABBIT);

    public static final ResourceKey<LootTable> HOGLIN_EXTRA_DROP = entityTable(EntityType.HOGLIN);
    public static final ResourceKey<LootTable> RAVAGER_EXTRA_DROP = entityTable(EntityType.RAVAGER);

    public ModEntityExtraLootProvider(HolderLookup.Provider provider) {
    }



    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
        output.accept(GOAT_EXTRA_DROP, LootTable.lootTable().withPool(
                LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ItemRegistry.FUR.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                        .when(LootItemRandomChanceCondition.randomChance(0.8f))
        ));
        output.accept(FOX_EXTRA_DROP, LootTable.lootTable().withPool(
                LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ItemRegistry.FUR.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                        .when(LootItemRandomChanceCondition.randomChance(0.6f))
        ));
        output.accept(RABBIT_EXTRA_DROP, LootTable.lootTable().withPool(
                LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ItemRegistry.FUR.get()))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                        .when(LootItemRandomChanceCondition.randomChance(0.8f))
        ));

        output.accept(HOGLIN_EXTRA_DROP, LootTable.lootTable().withPool(
                LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ItemRegistry.RAW_MEAT.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                        .when(LootItemRandomChanceCondition.randomChance(0.8f))
        ));
        output.accept(RAVAGER_EXTRA_DROP, LootTable.lootTable().withPool(
                LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ItemRegistry.RAW_MEAT.get()))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 2)))
                        .when(LootItemRandomChanceCondition.randomChance(0.8f))
        ));
    }

    static ResourceKey<LootTable> entityTable(EntityType<?> entityType){
        return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(MOD_ID, entityType.getDefaultLootTable().location().getPath()));
    }
}
