package com.voxelutopia.ultramarine.datagen;

import com.google.common.collect.ImmutableSet;
import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.world.block.BaseBlockProperty;
import com.voxelutopia.ultramarine.world.block.BaseBlockPropertyHolder;
import com.voxelutopia.ultramarine.world.block.ConsumableDecorativeBlock;
import com.voxelutopia.ultramarine.world.block.StackableHalfBlock;
import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import com.voxelutopia.ultramarine.world.block.state.StackableBlockType;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.FunctionUserBuilder;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.BinomialDistributionGenerator;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.*;
import java.util.stream.Stream;

public class ModBlockLootProvider extends BlockLootSubProvider {

    private static final List<RegistryObject<Block>> NON_SIMPLE_BLOCKS = new ArrayList<>();
    private static final List<Class> NON_SIMPLE_BLOCK_CLASSES = List.of(DropExperienceBlock.class, SlabBlock.class, ConsumableDecorativeBlock.class, StackableHalfBlock.class);
    private static final Logger LOGGER = Ultramarine.getLogger();
    private static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
    private static final Set<Item> EXPLOSION_RESISTANT = Stream.of(Blocks.BEDROCK).map(ItemLike::asItem).collect(ImmutableSet.toImmutableSet());;
    protected final Map<Block, LootTable.Builder> lootTables = new HashMap<>();

    static {
        BlockRegistry.BLOCKS.getEntries().stream()
                .filter(blockRegistryObject -> {
                    var block = blockRegistryObject.get();
                    for (Class clazz : NON_SIMPLE_BLOCK_CLASSES){
                        if (clazz.isInstance(block)) return true;
                    }
                    if (block instanceof BaseBlockPropertyHolder baseBlock){
                        return baseBlock.getProperty().getMaterial() == BaseBlockProperty.BlockMaterial.PORCELAIN;
                    }
                    return false;
                })
                .forEach(NON_SIMPLE_BLOCKS::add);
    }
    public ModBlockLootProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        BlockRegistry.BLOCKS.getEntries().stream()
                .filter(blockRegistryObject -> !NON_SIMPLE_BLOCKS.contains(blockRegistryObject))
                .forEach(this::simple);
        ore(BlockRegistry.JADE_ORE, ItemRegistry.JADE);
        ore(BlockRegistry.HEMATITE_ORE, ItemRegistry.RAW_HEMATITE);
        abundantOre(BlockRegistry.MAGNESITE_ORE, ItemRegistry.MAGNESITE);

        porcelain(BlockRegistry.BLUE_AND_WHITE_PORCELAIN_FLOWERPOT, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        //todo blue porcelain flowerpot
        porcelain(BlockRegistry.BLUE_AND_WHITE_PORCELAIN_VASE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        porcelain(BlockRegistry.LARGE_BLUE_AND_WHITE_PORCELAIN_VASE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        porcelain(BlockRegistry.SHORT_BLUE_AND_WHITE_PORCELAIN_POT, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        porcelain(BlockRegistry.TALL_BLUE_AND_WHITE_PORCELAIN_POT, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        porcelain(BlockRegistry.BLUE_AND_WHITE_PORCELAIN_BOWL, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        porcelain(BlockRegistry.WINE_POT, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        porcelainPlate(BlockRegistry.PLATED_MOONCAKES, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        plateDrop(BlockRegistry.PLATED_MUNG_BEAN_CAKES);
        plateDrop(BlockRegistry.PLATED_HAM);
        plateDrop(BlockRegistry.PLATED_FISH);
        slab(BlockRegistry.CYAN_BRICK_SLAB, ItemRegistry.CYAN_BRICK_SLAB);
        slab(BlockRegistry.BLACK_BRICK_SLAB, ItemRegistry.BLACK_BRICK_SLAB);
        slab(BlockRegistry.BROWNISH_RED_STONE_BRICK_SLAB, ItemRegistry.BROWNISH_RED_STONE_BRICK_SLAB);
        slab(BlockRegistry.PALE_YELLOW_STONE_SLAB, ItemRegistry.PALE_YELLOW_STONE_SLAB);
        slab(BlockRegistry.VARIEGATED_ROCK_SLAB, ItemRegistry.VARIEGATED_ROCK_SLAB);
        slab(BlockRegistry.WEATHERED_STONE_SLAB, ItemRegistry.WEATHERED_STONE_SLAB);
        slab(BlockRegistry.POLISHED_WEATHERED_STONE_SLAB, ItemRegistry.POLISHED_WEATHERED_STONE_SLAB);
        slab(BlockRegistry.LIGHT_CYAN_FLOOR_TILE_SLAB, ItemRegistry.LIGHT_CYAN_FLOOR_TILE_SLAB);
        slab(BlockRegistry.CYAN_FLOOR_TILE_SLAB, ItemRegistry.CYAN_FLOOR_TILE_SLAB);
        slab(BlockRegistry.BAMBOO_MAT_SLAB, ItemRegistry.BAMBOO_MAT_SLAB);
        stackableHalf(BlockRegistry.CABBAGE_BASKET, ItemRegistry.CABBAGE_BASKET);
    }

    void simple(RegistryObject<? extends Block> block) {
        addLootTable(block.get(), createSimpleTable(block.getId().getPath(), block.get()));
    }

    void ore(RegistryObject<? extends Block> block, RegistryObject<? extends Item> item){
        addLootTable(block.get(), createOreDrop(block.getId().getPath(), block.get(), item.get()));
    }

    void abundantOre(RegistryObject<? extends Block> block, RegistryObject<? extends Item> item){
        addLootTable(block.get(), createAbundantOreDrop(block.getId().getPath(), block.get(), item.get(), 1, 3));
    }

    void porcelain(RegistryObject<? extends Block> block, RegistryObject<? extends Item> piece, RegistryObject<? extends Item> shards){
        addLootTable(block.get(), createPorcelainDrop(block.getId().getPath(), block.get(), piece.get(), shards.get()));
    }

    void porcelainPlate(RegistryObject<? extends Block> block, RegistryObject<? extends Item> piece, RegistryObject<? extends Item> shards) {
        if (block.get() instanceof ConsumableDecorativeBlock consumable && consumable.getPlate().getItem() instanceof BlockItem blockItem)
            addLootTable(block.get(), createPorcelainDrop(block.getId().getPath(), blockItem.getBlock(), piece.get(), shards.get()));
        else LOGGER.warn("Porcelain plate loot table was not added for block " + block.get().getDescriptionId());
    }


    void slab(RegistryObject<? extends Block> block, RegistryObject<? extends Item> item) {
        if (block.get() instanceof SlabBlock slab)
            addLootTable(block.get(), createSlabDrop(block.getId().getPath(), slab, item.get()));
        else LOGGER.warn("Slab loot table was not added for block " + block.get().getDescriptionId());
    }

    void stackableHalf(RegistryObject<? extends Block> block, RegistryObject<? extends Item> item) {
        if (block.get() instanceof StackableHalfBlock stackable)
            addLootTable(block.get(), createStackableHalfDrop(block.getId().getPath(), stackable, item.get()));
        else LOGGER.warn("Stackable loot table was not added for block " + block.get().getDescriptionId());
    }

    void plateDrop(RegistryObject<? extends Block> block) {
        if (block.get() instanceof ConsumableDecorativeBlock consumable)
            addLootTable(block.get(), createSimpleTable(block.getId().getPath(), consumable.getPlate().getItem()));
        else LOGGER.warn("Plate drop loot table was not added for block " + block.get().getDescriptionId());
    }

    /**
     * Substitute for adding loot tables to the put(Block, LootTable.Builder) call.
     * Adds check for duplicates, prefer calling this method for adding loot tables.
     * @param block same usage as #put
     * @param builder same usage as #put
     */
    void addLootTable(Block block, LootTable.Builder builder){
        if (lootTables.containsKey(block)){
            LOGGER.warn("Added duplicate loot table for block " + block.getDescriptionId());
        }
        lootTables.put(block, builder);
    }

    protected LootTable.Builder createSimpleTable(String name, ItemLike block) {
        LootPool.Builder builder = LootPool.lootPool()
                .name(name)
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(block));
        return LootTable.lootTable().withPool(builder);
    }

    //todo add fortune modifier
    protected LootTable.Builder createSingleItemTable(String name, Block block, Item drops) {
        LootPool.Builder builder = LootPool.lootPool()
                .name(name)
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(drops));
        return LootTable.lootTable().withPool(builder);
    }

    protected LootTable.Builder createSlabDrop(String name, SlabBlock block, Item item) {
        var builder = LootPool.lootPool()
                .name(name)
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
        return LootTable.lootTable().withPool(builder);
    }

    protected LootTable.Builder createStackableHalfDrop(String name, StackableHalfBlock block, Item item) {
        var builder = LootPool.lootPool()
                .name(name)
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
        return LootTable.lootTable().withPool(builder);
    }

    protected static LootTable.Builder createAbundantOreDrop(String name, Block block, Item drop, float min, float max) {
        return createSilkTouchDispatchTable(block, name, explosionDecay(block, LootItem.lootTableItem(drop)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected static LootTable.Builder createOreDrop(String name, Block block, Item drop) {
        return createSilkTouchDispatchTable(block, name, explosionDecay(block, LootItem.lootTableItem(drop).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }


    protected static LootTable.Builder createPorcelainDrop(String name, Block block, Item piece, Item shard) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().name(name)
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(block).when(HAS_SILK_TOUCH)
                                .otherwise(LootItem.lootTableItem(piece).when(LootItemRandomChanceCondition.randomChance(0.01F)).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 2)))
                                .otherwise(LootItem.lootTableItem(shard).apply(SetItemCountFunction.setCount(BinomialDistributionGenerator.binomial(3, 0.5F))))));
    }

    protected static LootTable.Builder createSelfDropDispatchTable(Block pBlock, String name, LootItemCondition.Builder pConditionBuilder, LootPoolEntryContainer.Builder<?> pAlternativeEntryBuilder) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().name(name)
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(pBlock).when(pConditionBuilder)
                                .otherwise(pAlternativeEntryBuilder)));
    }

    protected static LootTable.Builder createSilkTouchDispatchTable(Block pBlock, String name, LootPoolEntryContainer.Builder<?> pAlternativeEntryBuilder) {
        return createSelfDropDispatchTable(pBlock, name, HAS_SILK_TOUCH, pAlternativeEntryBuilder);
    }

    protected static <T extends FunctionUserBuilder<T>> T explosionDecay(ItemLike pItem, FunctionUserBuilder<T> pFunction) {
        return (!EXPLOSION_RESISTANT.contains(pItem.asItem()) ? pFunction.apply(ApplyExplosionDecay.explosionDecay()) : pFunction.unwrap());
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
