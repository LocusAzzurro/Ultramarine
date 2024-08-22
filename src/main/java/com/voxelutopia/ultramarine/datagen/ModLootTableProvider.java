package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.world.block.BaseBlockProperty;
import com.voxelutopia.ultramarine.world.block.BaseBlockPropertyHolder;
import com.voxelutopia.ultramarine.world.block.ConsumableDecorativeBlock;
import com.voxelutopia.ultramarine.world.block.StackableHalfBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ModLootTableProvider extends BaseLootTableProvider {

    public ModLootTableProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    private static final List<RegistryObject<Block>> NON_SIMPLE_BLOCKS = new ArrayList<>();
    private static final List<Class<? extends Block>> NON_SIMPLE_BLOCK_CLASSES = List.of(
            OreBlock.class, SlabBlock.class, ConsumableDecorativeBlock.class, StackableHalfBlock.class);
    private static final Logger LOGGER = Ultramarine.getLogger();

    static {
        BlockRegistry.BLOCKS.getEntries().stream()
                .filter(blockRegistryObject -> {
                    var block = blockRegistryObject.get();
                    for (var clazz : NON_SIMPLE_BLOCK_CLASSES){
                        if (clazz.isInstance(block)) return true;
                    }
                    if (block instanceof BaseBlockPropertyHolder baseBlock){
                        return baseBlock.getProperty().getMaterial() == BaseBlockProperty.BlockMaterial.PORCELAIN;
                    }
                    return false;
                })
                .forEach(NON_SIMPLE_BLOCKS::add);
        NON_SIMPLE_BLOCKS.addAll(List.of(
                BlockRegistry.PAINTING_SCROLL
        ));
    }
    @Override
    protected void addTables() {
        BlockRegistry.BLOCKS.getEntries().stream()
                .filter(blockRegistryObject -> !NON_SIMPLE_BLOCKS.contains(blockRegistryObject))
                .forEach(this::simple);
        ore(BlockRegistry.JADE_ORE, ItemRegistry.JADE);
        ore(BlockRegistry.DEEPSLATE_JADE_ORE, ItemRegistry.JADE);
        ore(BlockRegistry.HEMATITE_ORE, ItemRegistry.RAW_HEMATITE);
        ore(BlockRegistry.DEEPSLATE_HEMATITE_ORE, ItemRegistry.RAW_HEMATITE);
        abundantOre(BlockRegistry.MAGNESITE_ORE, ItemRegistry.MAGNESITE);
        abundantOre(BlockRegistry.DEEPSLATE_MAGNESITE_ORE, ItemRegistry.MAGNESITE);
        ore(BlockRegistry.NETHER_COBALT_ORE, ItemRegistry.RAW_COBALT);

        porcelainWithShards(BlockRegistry.BLUE_AND_WHITE_PORCELAIN_VASE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        porcelainWithShards(BlockRegistry.LARGE_BLUE_AND_WHITE_PORCELAIN_VASE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        porcelainWithShards(BlockRegistry.SHORT_BLUE_AND_WHITE_PORCELAIN_POT, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        porcelainWithShards(BlockRegistry.TALL_BLUE_AND_WHITE_PORCELAIN_POT, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        porcelainWithShards(BlockRegistry.BLUE_AND_WHITE_PORCELAIN_BOWL, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        porcelain(BlockRegistry.PORCELAIN_TEAPOT, ItemRegistry.PORCELAIN_PIECE);
        porcelainWithShards(BlockRegistry.BLUE_AND_WHITE_PORCELAIN_FLOWERPOT, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        porcelain(BlockRegistry.BLUE_PORCELAIN_FLOWERPOT, ItemRegistry.PORCELAIN_PIECE);
        porcelainWithShards(BlockRegistry.WINE_POT, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        porcelainPlateWithShards(BlockRegistry.PLATED_MOONCAKES, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        porcelainPlate(BlockRegistry.PLATED_MUNG_BEAN_CAKES, ItemRegistry.PORCELAIN_PIECE);
        plateDrop(BlockRegistry.PLATED_HAM);
        plateDrop(BlockRegistry.PLATED_FISH);
        plateDrop(BlockRegistry.XIAOLONGBAO);

        porcelain(BlockRegistry.SMALL_WHITE_PORCELAIN_VASE_BONSAI, ItemRegistry.PORCELAIN_PIECE);
        porcelain(BlockRegistry.MEDIUM_WHITE_PORCELAIN_VASE_BONSAI, ItemRegistry.PORCELAIN_PIECE);
        porcelain(BlockRegistry.LARGE_WHITE_PORCELAIN_VASE_BONSAI, ItemRegistry.PORCELAIN_PIECE);
        porcelain(BlockRegistry.SMALL_GREEN_PORCELAIN_VASE_BONSAI, ItemRegistry.PORCELAIN_PIECE);
        porcelain(BlockRegistry.GREEN_PORCELAIN_VASE_BONSAI, ItemRegistry.PORCELAIN_PIECE);
        porcelain(BlockRegistry.TALL_BLUE_VASE_BONSAI, ItemRegistry.PORCELAIN_PIECE);
        porcelainWithShards(BlockRegistry.TALL_BLUE_AND_WHITE_PORCELAIN_BONSAI, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);

        addLootTable(BlockRegistry.PAINTING_SCROLL.get(), LootTable.lootTable()
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

    void porcelain(RegistryObject<? extends Block> block, RegistryObject<? extends Item> piece){
        addLootTable(block.get(), createPorcelainDrop(block.getId().getPath(), block.get(), piece.get()));
    }

    void porcelainWithShards(RegistryObject<? extends Block> block, RegistryObject<? extends Item> piece, RegistryObject<? extends Item> shards){
        addLootTable(block.get(), createPorcelainDropWithShard(block.getId().getPath(), block.get(), piece.get(), shards.get()));
    }

    void porcelainPlate(RegistryObject<? extends Block> block, RegistryObject<? extends Item> piece) {
        if (block.get() instanceof ConsumableDecorativeBlock consumable)
            addLootTable(block.get(), createPorcelainDrop(block.getId().getPath(), consumable.getPlate().getItem(), piece.get()));
        else LOGGER.warn("Porcelain plate loot table was not added for block " + block.get().getDescriptionId());
    }

    void porcelainPlateWithShards(RegistryObject<? extends Block> block, RegistryObject<? extends Item> piece, RegistryObject<? extends Item> shards) {
        if (block.get() instanceof ConsumableDecorativeBlock consumable)
            addLootTable(block.get(), createPorcelainDropWithShard(block.getId().getPath(), consumable.getPlate().getItem(), piece.get(), shards.get()));
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

}
