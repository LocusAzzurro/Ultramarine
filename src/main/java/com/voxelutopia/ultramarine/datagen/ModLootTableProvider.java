package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.world.block.BaseBlockProperty;
import com.voxelutopia.ultramarine.world.block.BaseBlockPropertyHolder;
import com.voxelutopia.ultramarine.world.block.ConsumableDecorativeBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ModLootTableProvider extends BaseLootTableProvider {

    public ModLootTableProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    private static final List<RegistryObject<Block>> NON_SIMPLE_BLOCKS = new ArrayList<>();
    private static final Logger LOGGER = Ultramarine.getLogger();

    static {
        BlockRegistry.BLOCKS.getEntries().stream()
                .filter(blockRegistryObject -> {
                    var block = blockRegistryObject.get();
                    if (block instanceof OreBlock || block instanceof SlabBlock){
                        return true;
                    }
                    if (block instanceof BaseBlockPropertyHolder baseBlock){
                        return baseBlock.getProperty().getMaterial() == BaseBlockProperty.BlockMaterial.PORCELAIN;
                    }
                    return false;
                })
                .forEach(NON_SIMPLE_BLOCKS::add);
    }
    @Override
    protected void addTables() {
        BlockRegistry.BLOCKS.getEntries().stream()
                .filter(blockRegistryObject -> !NON_SIMPLE_BLOCKS.contains(blockRegistryObject))
                .forEach(this::simple);
        ore(BlockRegistry.JADE_ORE, ItemRegistry.JADE);
        abundantOre(BlockRegistry.MAGNESITE_ORE, ItemRegistry.MAGNESITE);

        porcelain(BlockRegistry.BLUE_AND_WHITE_PORCELAIN_VASE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        porcelain(BlockRegistry.BIG_BLUE_AND_WHITE_PORCELAIN_VASE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
        porcelainPlate(BlockRegistry.PLATED_MOON_CAKES, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE, ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS);
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

    void porcelainPlate(RegistryObject<? extends Block> block, RegistryObject<? extends Item> piece, RegistryObject<? extends Item> shards){
        addLootTable(block.get(), createPorcelainDrop(block.getId().getPath(), ((ConsumableDecorativeBlock)block.get()).getPlate(), piece.get(), shards.get()));
    }

    void slab(RegistryObject<? extends Block> block, RegistryObject<? extends Item> item) {
        addLootTable(block.get(), createSlabDrop(block.getId().getPath(), (SlabBlock) block.get(), item.get()));
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
