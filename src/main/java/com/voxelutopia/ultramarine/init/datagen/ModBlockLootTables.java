package com.voxelutopia.ultramarine.init.datagen;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.common.block.BaseBlockProperty;
import com.voxelutopia.ultramarine.common.block.BaseBlockPropertyHolder;
import com.voxelutopia.ultramarine.common.block.ConsumableDecorativeBlock;
import com.voxelutopia.ultramarine.common.block.StackableHalfBlock;
import com.voxelutopia.ultramarine.common.block.state.ModBlockStateProperties;
import com.voxelutopia.ultramarine.common.block.state.StackableBlockType;
import com.voxelutopia.ultramarine.init.registry.ModBlocks;
import com.voxelutopia.ultramarine.init.registry.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.BinomialDistributionGenerator;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Name: Ultramarine / BlockLootSubProvider
 * Author: cnlimiter
 * CreateTime: 2023/10/3 17:57
 * Description:
 */

public class ModBlockLootTables extends BlockLootSubProvider {
    private static final List<Block> NON_SIMPLE_BLOCKS = new ArrayList<>();
    private static final List<Class> NON_SIMPLE_BLOCK_CLASSES = List.of(DropExperienceBlock.class, SlabBlock.class, ConsumableDecorativeBlock.class, StackableHalfBlock.class);

    static {
        BuiltInRegistries.BLOCK.stream()
                .filter(blockRegistryObject -> {
                    for (Class clazz : NON_SIMPLE_BLOCK_CLASSES) {
                        if (clazz.isInstance(blockRegistryObject)) return true;
                    }
                    if (blockRegistryObject instanceof BaseBlockPropertyHolder baseBlock) {
                        return baseBlock.getProperty().getMaterial() == BaseBlockProperty.BlockMaterial.PORCELAIN;
                    }
                    return false;
                })
                .forEach(NON_SIMPLE_BLOCKS::add);
    }

    protected ModBlockLootTables() {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
    }

    protected static void createPorcelainDrop(Block block, Item piece, Item shard) {
        LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(block).when(HAS_SILK_TOUCH)
                                .otherwise(LootItem.lootTableItem(piece).when(LootItemRandomChanceCondition.randomChance(0.01F)).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 2)))
                                .otherwise(LootItem.lootTableItem(shard).apply(SetItemCountFunction.setCount(BinomialDistributionGenerator.binomial(3, 0.5F))))));
    }

    @Override
    public void generate() {
        BuiltInRegistries.BLOCK.stream()
                .filter(blockRegistryObject -> !NON_SIMPLE_BLOCKS.contains(blockRegistryObject))
                .forEach(this::createSimpleTable);
        createOreDrop(ModBlocks.JADE_ORE, ModItems.JADE);
        createOreDrop(ModBlocks.HEMATITE_ORE, ModItems.RAW_HEMATITE);
        createAbundantOreDrop(ModBlocks.MAGNESITE_ORE, ModItems.MAGNESITE, 1, 3);

        createPorcelainDrop(ModBlocks.BLUE_AND_WHITE_PORCELAIN_FLOWERPOT, ModItems.BLUE_AND_WHITE_PORCELAIN_PIECE, ModItems.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        //todo blue porcelain flowerpot
        createPorcelainDrop(ModBlocks.BLUE_AND_WHITE_PORCELAIN_VASE, ModItems.BLUE_AND_WHITE_PORCELAIN_PIECE, ModItems.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        createPorcelainDrop(ModBlocks.LARGE_BLUE_AND_WHITE_PORCELAIN_VASE, ModItems.BLUE_AND_WHITE_PORCELAIN_PIECE, ModItems.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        createPorcelainDrop(ModBlocks.SHORT_BLUE_AND_WHITE_PORCELAIN_POT, ModItems.BLUE_AND_WHITE_PORCELAIN_PIECE, ModItems.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        createPorcelainDrop(ModBlocks.TALL_BLUE_AND_WHITE_PORCELAIN_POT, ModItems.BLUE_AND_WHITE_PORCELAIN_PIECE, ModItems.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        createPorcelainDrop(ModBlocks.BLUE_AND_WHITE_PORCELAIN_BOWL, ModItems.BLUE_AND_WHITE_PORCELAIN_PIECE, ModItems.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        createPorcelainDrop(ModBlocks.WINE_POT, ModItems.BLUE_AND_WHITE_PORCELAIN_PIECE, ModItems.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        porcelainPlate(ModBlocks.PLATED_MOONCAKES, ModItems.BLUE_AND_WHITE_PORCELAIN_PIECE, ModItems.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        plateDrop(ModBlocks.PLATED_MUNG_BEAN_CAKES);
        plateDrop(ModBlocks.PLATED_HAM);
        plateDrop(ModBlocks.PLATED_FISH);
        slab(ModBlocks.CYAN_BRICK_SLAB, ModItems.CYAN_BRICK_SLAB);
        slab(ModBlocks.BLACK_BRICK_SLAB, ModItems.BLACK_BRICK_SLAB);
        slab(ModBlocks.BROWNISH_RED_STONE_BRICK_SLAB, ModItems.BROWNISH_RED_STONE_BRICK_SLAB);
        slab(ModBlocks.PALE_YELLOW_STONE_SLAB, ModItems.PALE_YELLOW_STONE_SLAB);
        slab(ModBlocks.VARIEGATED_ROCK_SLAB, ModItems.VARIEGATED_ROCK_SLAB);
        slab(ModBlocks.WEATHERED_STONE_SLAB, ModItems.WEATHERED_STONE_SLAB);
        slab(ModBlocks.POLISHED_WEATHERED_STONE_SLAB, ModItems.POLISHED_WEATHERED_STONE_SLAB);
        slab(ModBlocks.LIGHT_CYAN_FLOOR_TILE_SLAB, ModItems.LIGHT_CYAN_FLOOR_TILE_SLAB);
        slab(ModBlocks.CYAN_FLOOR_TILE_SLAB, ModItems.CYAN_FLOOR_TILE_SLAB);
        slab(ModBlocks.BAMBOO_MAT_SLAB, ModItems.BAMBOO_MAT_SLAB);
        stackableHalf(ModBlocks.CABBAGE_BASKET, ModItems.CABBAGE_BASKET);
    }

    void stackableHalf(Block block, Item item) {
        if (block instanceof StackableHalfBlock stackable)
            createStackableHalfDrop(stackable, item);
        else Ultramarine.warn("Stackable loot table was not added for block " + block.getDescriptionId());
    }

    void slab(Block block, Item item) {
        if (block instanceof SlabBlock slab)
            createSlabDrop(slab, item);
        else Ultramarine.warn("Slab loot table was not added for block " + block.getDescriptionId());
    }

    void porcelainPlate(Block block, Item piece, Item shards) {
        if (block instanceof ConsumableDecorativeBlock consumable && consumable.getPlate().getItem() instanceof BlockItem blockItem)
            createPorcelainDrop(blockItem.getBlock(), piece, shards);
        else Ultramarine.warn("Porcelain plate loot table was not added for block " + block.getDescriptionId());
    }

    void plateDrop(Block block) {
        if (block instanceof ConsumableDecorativeBlock consumable)
            createSimpleTable(consumable.getPlate().getItem());
        else Ultramarine.warn("Plate drop loot table was not added for block " + block.getDescriptionId());
    }

    protected void createStackableHalfDrop(StackableHalfBlock block, Item item) {
        var builder = LootPool.lootPool()
                .add(LootItem.lootTableItem(item)
                        .when(LootItemBlockStatePropertyCondition
                                .hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder
                                        .properties()
                                        .hasProperty(ModBlockStateProperties.STACKABLE_BLOCK_TYPE, StackableBlockType.SINGLE))))
                .add(LootItem.lootTableItem(item)
                        .when(LootItemBlockStatePropertyCondition
                                .hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder
                                        .properties()
                                        .hasProperty(ModBlockStateProperties.STACKABLE_BLOCK_TYPE, StackableBlockType.DOUBLE)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2))));
        LootTable.lootTable().withPool(builder);
    }

    protected void createSlabDrop(SlabBlock block, Item item) {
        var builder = LootPool.lootPool()
                .add(LootItem.lootTableItem(item)
                        .when(LootItemBlockStatePropertyCondition
                                .hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder
                                        .properties()
                                        .hasProperty(SlabBlock.TYPE, SlabType.TOP))))
                .add(LootItem.lootTableItem(item)
                        .when(LootItemBlockStatePropertyCondition
                                .hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder
                                        .properties()
                                        .hasProperty(SlabBlock.TYPE, SlabType.BOTTOM))))
                .add(LootItem.lootTableItem(item)
                        .when(LootItemBlockStatePropertyCondition
                                .hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder
                                        .properties()
                                        .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2))));
        LootTable.lootTable().withPool(builder);
    }

    protected void createSimpleTable(ItemLike block) {
        LootPool.Builder builder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(block));
        LootTable.lootTable().withPool(builder);
    }

    protected void createAbundantOreDrop(Block block, Item drop, float min, float max) {
        createSilkTouchDispatchTable(block, applyExplosionDecay(block, LootItem.lootTableItem(drop)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

}
