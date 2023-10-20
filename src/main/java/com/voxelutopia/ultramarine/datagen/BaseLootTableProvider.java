package com.voxelutopia.ultramarine.datagen;

import com.google.common.collect.ImmutableSet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.world.block.StackableHalfBlock;
import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import com.voxelutopia.ultramarine.world.block.state.StackableBlockType;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.data.LootTableProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.MatchTool;
import net.minecraft.loot.conditions.RandomChance;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.loot.functions.ExplosionDecay;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import org.slf4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public abstract class BaseLootTableProvider extends LootTableProvider {

    private static final Logger LOGGER = Ultramarine.getLogger();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private static final ILootCondition.IBuilder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))));
    private static final Set<Item> EXPLOSION_RESISTANT = Stream.of(Blocks.BEDROCK).map(IItemProvider::asItem).collect(ImmutableSet.toImmutableSet());
    ;
    protected final Map<Block, LootTable.Builder> lootTables = new HashMap<>();
    private final DataGenerator generator;

    public BaseLootTableProvider(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
        this.generator = dataGeneratorIn;
    }

    protected abstract void addTables();

    protected LootTable.Builder createSimpleTable(String name, IItemProvider block) {
        LootPool.Builder builder = LootPool.lootPool()
                .name(name)
                .setRolls(ConstantRange.exactly(1))
                .add(ItemLootEntry.lootTableItem(block));
        return LootTable.lootTable().withPool(builder);
    }

    //todo add fortune modifier
    protected LootTable.Builder createSingleItemTable(String name, Block block, Item drops) {
        LootPool.Builder builder = LootPool.lootPool()
                .name(name)
                .setRolls(ConstantRange.exactly(1))
                .add(ItemLootEntry.lootTableItem(drops));
        return LootTable.lootTable().withPool(builder);
    }

    protected LootTable.Builder createSlabDrop(String name, SlabBlock block, Item item) {
        LootPool.Builder builder = LootPool.lootPool()
                .name(name)
                .add(ItemLootEntry.lootTableItem(item)
                        .when(BlockStateProperty
                                .hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder
                                        .properties()
                                        .hasProperty(SlabBlock.TYPE, SlabType.TOP))))
                .add(ItemLootEntry.lootTableItem(item)
                        .when(BlockStateProperty
                                .hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder
                                        .properties()
                                        .hasProperty(SlabBlock.TYPE, SlabType.BOTTOM))))
                .add(ItemLootEntry.lootTableItem(item)
                        .when(BlockStateProperty
                                .hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder
                                        .properties()
                                        .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))
                        .apply(SetCount.setCount(ConstantRange.exactly(2))));
        return LootTable.lootTable().withPool(builder);
    }

    protected LootTable.Builder createStackableHalfDrop(String name, StackableHalfBlock block, Item item) {
        LootPool.Builder builder = LootPool.lootPool()
                .name(name)
                .add(ItemLootEntry.lootTableItem(item)
                        .when(BlockStateProperty
                                .hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder
                                        .properties()
                                        .hasProperty(ModBlockStateProperties.STACKABLE_BLOCK_TYPE, StackableBlockType.SINGLE))))
                .add(ItemLootEntry.lootTableItem(item)
                        .when(BlockStateProperty
                                .hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder
                                        .properties()
                                        .hasProperty(ModBlockStateProperties.STACKABLE_BLOCK_TYPE, StackableBlockType.DOUBLE)))
                        .apply(SetCount.setCount(ConstantRange.exactly(2))));
        return LootTable.lootTable().withPool(builder);
    }

    protected static LootTable.Builder createAbundantOreDrop(String name, Block block, Item drop, float min, float max) {
        return createSilkTouchDispatchTable(block, name, applyExplosionDecay(block, ItemLootEntry.lootTableItem(drop)
                .apply(SetCount.setCount(RandomValueRange.between(min, max)))
                .apply(ApplyBonus.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected static LootTable.Builder createOreDrop(String name, Block block, Item drop) {
        return createSilkTouchDispatchTable(block, name, applyExplosionDecay(block, ItemLootEntry.lootTableItem(drop).apply(ApplyBonus.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }


    protected static LootTable.Builder createPorcelainDrop(String name, Block block, Item piece, Item shard) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().name(name)
                        .setRolls(ConstantRange.exactly(1))
                        .add(ItemLootEntry.lootTableItem(block).when(HAS_SILK_TOUCH)
                                .otherwise(ItemLootEntry.lootTableItem(piece).when(RandomChance.randomChance(0.01F)).apply(ApplyBonus.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 2)))
                                .otherwise(ItemLootEntry.lootTableItem(shard).apply(SetCount.setCount(BinomialRange.binomial(3, 0.5F))))));
    }

    protected static LootTable.Builder createSelfDropDispatchTable(Block pBlock, String name, ILootCondition.IBuilder pConditionBuilder, LootEntry.Builder<?> pAlternativeEntryBuilder) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().name(name)
                        .setRolls(ConstantRange.exactly(1))
                        .add(ItemLootEntry.lootTableItem(pBlock).when(pConditionBuilder)
                                .otherwise(pAlternativeEntryBuilder)));
    }

    protected static LootTable.Builder createSilkTouchDispatchTable(Block pBlock, String name, LootEntry.Builder<?> pAlternativeEntryBuilder) {
        return createSelfDropDispatchTable(pBlock, name, HAS_SILK_TOUCH, pAlternativeEntryBuilder);
    }

    protected static <T extends StandaloneLootEntry.Builder<T>> T applyExplosionDecay(IItemProvider pItem, StandaloneLootEntry.Builder<T> pFunction) {
        return (!EXPLOSION_RESISTANT.contains(pItem.asItem()) ? pFunction.apply(ExplosionDecay.explosionDecay()) : pFunction.unwrap());
    }

    @Override
    public void run(DirectoryCache cache) {

        addTables();

        Map<ResourceLocation, LootTable> tables = new HashMap<>();
        for (Map.Entry<Block, LootTable.Builder> entry : lootTables.entrySet()) {
            tables.put(entry.getKey().getLootTable(), entry.getValue().setParamSet(LootParameterSets.BLOCK).build());
        }
        writeTables(cache, tables);
    }

    private void writeTables(DirectoryCache cache, Map<ResourceLocation, LootTable> tables) {
        Path outputFolder = this.generator.getOutputFolder();
        tables.forEach((key, lootTable) -> {
            Path path = outputFolder.resolve("data/" + key.getNamespace() + "/loot_tables/" + key.getPath() + ".json");
            try {
                IDataProvider.save(GSON, cache, LootTableManager.serialize(lootTable), path);
            } catch (IOException e) {
                LOGGER.error("Couldn't write loot table {}", path, e);
            }
        });
    }

    @Override
    public String getName() {
        return DataGenerators.MOD_ID + " LootTables";
    }
}
