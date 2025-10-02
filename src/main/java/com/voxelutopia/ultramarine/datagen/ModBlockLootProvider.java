package com.voxelutopia.ultramarine.datagen;

import com.google.common.collect.ImmutableSet;
import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.world.block.*;
import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import com.voxelutopia.ultramarine.world.block.state.StackableBlockType;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
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
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.BinomialDistributionGenerator;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.util.*;
import java.util.stream.Stream;

public class ModBlockLootProvider extends BlockLootSubProvider {

    static final Logger LOGGER = Ultramarine.getLogger();
    static final LootItemCondition.Builder HAS_SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));
    static final Set<Item> EXPLOSION_RESISTANT = Stream.of(Blocks.BEDROCK).map(ItemLike::asItem).collect(ImmutableSet.toImmutableSet());

    protected final Map<Block, LootTable.Builder> lootTables = new HashMap<>();
    protected final HolderLookup.Provider registries;

    public ModBlockLootProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
        this.registries = provider;
    }

    private static final List<DeferredHolder<Block, Block>> NON_SIMPLE_BLOCKS = new ArrayList<>();
    private static final List<Class<? extends Block>> NON_SIMPLE_BLOCK_CLASSES = List.of(
            DropExperienceBlock.class, SlabBlock.class, ConsumableDecorativeBlock.class, StackableHalfBlock.class);

    static {
        BlockRegistry.BLOCKS.getEntries().stream()
                .filter(blockRegistryObject -> {
                    Block block = blockRegistryObject.get();
                    for (Class<? extends Block> clazz : NON_SIMPLE_BLOCK_CLASSES) {
                        if (clazz.isInstance(block)) return true;
                    }
                    if (block instanceof BaseBlockPropertyHolder baseBlock) {
                        return baseBlock.getProperty().getMaterial() == BaseBlockProperty.BlockMaterial.PORCELAIN;
                    }
                    return false;
                })
                .forEach(x -> NON_SIMPLE_BLOCKS.add((DeferredHolder<Block, Block>) x));
        NON_SIMPLE_BLOCKS.add(
                BlockRegistry.PAINTING_SCROLL
        );
    }

    @Override
    protected void generate() {
        BlockRegistry.BLOCKS.getEntries().stream()
                .filter(blockRegistryObject -> !NON_SIMPLE_BLOCKS.contains(blockRegistryObject))
                .forEach(this::simple);
        BlockRegistry.BLOCKS.getEntries().stream()
                .filter(blockRegistryObject -> blockRegistryObject.get() instanceof BaseSlab)
                .forEach(blockRegistryObject -> this.slab(blockRegistryObject.get(), blockRegistryObject.get().asItem()));
        BlockRegistry.BLOCKS.getEntries().stream()
                .filter(blockRegistryObject -> blockRegistryObject.get() instanceof StackableHalfBlock)
                .forEach(blockRegistryObject -> this.stackableHalf(blockRegistryObject.get(), blockRegistryObject.get().asItem()));
        this.ore(BlockRegistry.JADE_ORE, ItemRegistry.JADE);
        this.ore(BlockRegistry.DEEPSLATE_JADE_ORE, ItemRegistry.JADE);
        this.ore(BlockRegistry.HEMATITE_ORE, ItemRegistry.RAW_HEMATITE);
        this.ore(BlockRegistry.DEEPSLATE_HEMATITE_ORE, ItemRegistry.RAW_HEMATITE);
        this.abundantOre(BlockRegistry.MAGNESITE_ORE, ItemRegistry.MAGNESITE);
        this.abundantOre(BlockRegistry.DEEPSLATE_MAGNESITE_ORE, ItemRegistry.MAGNESITE);
        this.ore(BlockRegistry.NETHER_COBALT_ORE, ItemRegistry.RAW_COBALT);

        this.porcelainWithShards(BlockRegistry.BLUE_AND_WHITE_PORCELAIN_VASE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        this.porcelainWithShards(BlockRegistry.LARGE_BLUE_AND_WHITE_PORCELAIN_VASE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        this.porcelainWithShards(BlockRegistry.SHORT_BLUE_AND_WHITE_PORCELAIN_POT, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        this.porcelainWithShards(BlockRegistry.TALL_BLUE_AND_WHITE_PORCELAIN_POT, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        this.porcelainWithShards(BlockRegistry.BLUE_AND_WHITE_PORCELAIN_BOWL, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        this.porcelain(BlockRegistry.PORCELAIN_TEAPOT, ItemRegistry.PORCELAIN_PIECE);
        this.porcelainWithShards(BlockRegistry.BLUE_AND_WHITE_PORCELAIN_FLOWERPOT, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        this.porcelain(BlockRegistry.BLUE_PORCELAIN_FLOWERPOT, ItemRegistry.PORCELAIN_PIECE);
        this.porcelainWithShards(BlockRegistry.WINE_POT, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        this.porcelainPlateWithShards(BlockRegistry.PLATED_MOONCAKES, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        this.porcelainPlate(BlockRegistry.PLATED_MUNG_BEAN_CAKES, ItemRegistry.PORCELAIN_PIECE);
        this.plateDrop(BlockRegistry.PLATED_HAM);
        this.plateDrop(BlockRegistry.PLATED_FISH);
        this.plateDrop(BlockRegistry.SCATTERED_CARROTS);
        this.plateDrop(BlockRegistry.XIAOLONGBAO);

        this.porcelain(BlockRegistry.SMALL_WHITE_PORCELAIN_VASE_BONSAI, ItemRegistry.PORCELAIN_PIECE);
        this.porcelain(BlockRegistry.MEDIUM_WHITE_PORCELAIN_VASE_BONSAI, ItemRegistry.PORCELAIN_PIECE);
        this.porcelain(BlockRegistry.LARGE_WHITE_PORCELAIN_VASE_BONSAI, ItemRegistry.PORCELAIN_PIECE);
        this.porcelain(BlockRegistry.SMALL_GREEN_PORCELAIN_VASE_BONSAI, ItemRegistry.PORCELAIN_PIECE);
        this.porcelain(BlockRegistry.GREEN_PORCELAIN_VASE_BONSAI, ItemRegistry.PORCELAIN_PIECE);
        this.porcelain(BlockRegistry.TALL_BLUE_VASE_BONSAI, ItemRegistry.PORCELAIN_PIECE);
        this.porcelainWithShards(BlockRegistry.TALL_BLUE_AND_WHITE_PORCELAIN_BONSAI, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);

        this.addLootTable(BlockRegistry.PAINTING_SCROLL.get(), LootTable.lootTable()
                .withPool(LootPool.lootPool().name("painting_scroll").setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(ItemRegistry.PAINTING_SCROLL.get()).when(HAS_SHEARS.invert())
                                .otherwise(LootItem.lootTableItem(Items.DIAMOND)
                                        .append(LootItem.lootTableItem(ItemRegistry.LONG_HANGING_PAINTING.get()))
                                        .append(LootItem.lootTableItem(ItemRegistry.WHITE_LANDSCAPE_PAINTING.get()))
                                        .append(LootItem.lootTableItem(ItemRegistry.HORIZONTAL_OLD_LANDSCAPE_PAINTING.get()))
                                        .append(LootItem.lootTableItem(ItemRegistry.HORIZONTAL_CALLIGRAPHY.get()))
                                        .append(LootItem.lootTableItem(ItemRegistry.HORIZONTAL_LANDSCAPE_PAINTING.get()))
                                        .append(LootItem.lootTableItem(ItemRegistry.LONG_YELLOW_HANGING_PAINTING.get()))
                                        .append(LootItem.lootTableItem(ItemRegistry.PORTRAIT.get()))
                                        .append(LootItem.lootTableItem(ItemRegistry.HANGING_PAINTING_FAN.get()))
                                        .append(LootItem.lootTableItem(ItemRegistry.SINCERE_CALLIGRAPHY.get()))
                                ))));
    }

    void simple(DeferredHolder<Block, ? extends Block> block) {
        this.addLootTable(block.get(), this.createSimpleTable(block.getId().getPath(), block.get()));
    }

    void ore(DeferredHolder<Block, ? extends Block> block, DeferredHolder<Item, ? extends Item> item) {
        this.addLootTable(block.get(), this.createOreDrop(block.getId().getPath(), block.get(), item.get()));
    }

    void abundantOre(DeferredHolder<Block, ? extends Block> block, DeferredHolder<Item, ? extends Item> item) {
        this.addLootTable(block.get(), this.createAbundantOreDrop(block.getId().getPath(), block.get(), item.get(), 1, 3));
    }

    void porcelain(DeferredHolder<Block, ? extends Block> block, DeferredHolder<Item, ? extends Item> piece) {
        this.addLootTable(block.get(), createPorcelainDrop(block.getId().getPath(), block.get(), piece.get()));
    }

    void porcelainWithShards(DeferredHolder<Block, ? extends Block> block, DeferredHolder<Item, ? extends Item> piece, DeferredHolder<Item, ? extends Item> shards) {
        this.addLootTable(block.get(), createPorcelainDropWithShard(block.getId().getPath(), block.get(), piece.get(), shards.get()));
    }

    void porcelainPlate(DeferredHolder<Block, ? extends Block> block, DeferredHolder<Item, ? extends Item> piece) {
        if (block.get() instanceof ConsumableDecorativeBlock consumable)
            this.addLootTable(block.get(), createPorcelainDrop(block.getId().getPath(), consumable.getPlate().getItem(), piece.get()));
        else LOGGER.warn("Porcelain plate loot table was not added for block {}", block.get().getDescriptionId());
    }

    void porcelainPlateWithShards(DeferredHolder<Block, ? extends Block> block, DeferredHolder<Item, ? extends Item> piece, DeferredHolder<Item, ? extends Item> shards) {
        if (block.get() instanceof ConsumableDecorativeBlock consumable)
            this.addLootTable(block.get(), createPorcelainDropWithShard(block.getId().getPath(), consumable.getPlate().getItem(), piece.get(), shards.get()));
        else LOGGER.warn("Porcelain plate loot table was not added for block {}", block.get().getDescriptionId());
    }

    void slab(Block block, Item item) {
        if (block instanceof SlabBlock slab)
            this.addLootTable(block, this.createSlabDrop(name(block), slab, item));
        else LOGGER.warn("Slab loot table was not added for block {}", block.getDescriptionId());
    }

    void stackableHalf(Block block, Item item) {
        if (block instanceof StackableHalfBlock stackable)
            this.addLootTable(block, this.createStackableHalfDrop(name(block), stackable, item));
        else LOGGER.warn("Stackable loot table was not added for block {}", block.getDescriptionId());
    }

    void plateDrop(DeferredHolder<Block, ? extends Block> block) {
        if (block.get() instanceof ConsumableDecorativeBlock consumable)
            this.addLootTable(block.get(), this.createSimpleTable(block.getId().getPath(), consumable.getPlate().getItem()));
        else LOGGER.warn("Plate drop loot table was not added for block {}", block.get().getDescriptionId());
    }

    protected LootTable.Builder createSimpleTable(String name, ItemLike block) {
        LootPool.Builder builder = LootPool.lootPool()
                .name(name)
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(block));
        return LootTable.lootTable().withPool(builder);
    }

    protected LootTable.Builder createSingleItemTable(String name, Block block, Item drops) {
        LootPool.Builder builder = LootPool.lootPool()
                .name(name)
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(drops));
        return LootTable.lootTable().withPool(builder);
    }

    protected LootTable.Builder createSlabDrop(String name, SlabBlock block, Item item) {
        LootPool.Builder builder = LootPool.lootPool()
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
        LootPool.Builder builder = LootPool.lootPool()
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

    protected LootTable.Builder createAbundantOreDrop(String name, Block block, Item drop, float min, float max) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return createSilkTouchDispatchTable(block, name, this.applyExplosionDecay(block, LootItem.lootTableItem(drop)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    protected LootTable.Builder createOreDrop(String name, Block block, Item drop) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return createSilkTouchDispatchTable(block, name, this.applyExplosionDecay(block, LootItem.lootTableItem(drop).apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    protected LootTable.Builder createPorcelainDropWithShard(String name, ItemLike block, ItemLike piece, ItemLike shard) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().name(name)
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(block).when(this.hasSilkTouch())
                                .otherwise(LootItem.lootTableItem(piece).when(LootItemRandomChanceCondition.randomChance(0.01F)).apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE), 2)))
                                .otherwise(LootItem.lootTableItem(shard).apply(SetItemCountFunction.setCount(BinomialDistributionGenerator.binomial(3, 0.5F))))));
    }

    protected LootTable.Builder createPorcelainDrop(String name, ItemLike block, ItemLike piece) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().name(name)
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(block).when(this.hasSilkTouch())
                                .otherwise(LootItem.lootTableItem(piece).when(LootItemRandomChanceCondition.randomChance(0.2F)).apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE), 2)))));
    }

    protected LootTable.Builder createSelfDropDispatchTable(Block pBlock, String name, LootItemCondition.Builder pConditionBuilder, LootPoolEntryContainer.Builder<?> pAlternativeEntryBuilder) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().name(name)
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(pBlock).when(pConditionBuilder)
                                .otherwise(pAlternativeEntryBuilder)));
    }

    protected LootTable.Builder createSilkTouchDispatchTable(Block pBlock, String name, LootPoolEntryContainer.Builder<?> pAlternativeEntryBuilder) {
        return createSelfDropDispatchTable(pBlock, name, this.hasSilkTouch(), pAlternativeEntryBuilder);
    }

    /**
     * Substitute for adding loot tables to the put(Block, LootTable.Builder) call.
     * Adds check for duplicates, prefer calling this method for adding loot tables.
     *
     * @param block   same usage as #put
     * @param builder same usage as #put
     */
    void addLootTable(Block block, LootTable.Builder builder) {
        if (this.lootTables.containsKey(block)) {
            LOGGER.warn("Added duplicate loot table for block {}", block.getDescriptionId());
        }
        this.lootTables.put(block, builder);
        this.add(block, builder);
    }

    private static String name(Block block) {
        return Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(block)).getPath();
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream().map(x -> (Block) x.get())::iterator;
    }
}
