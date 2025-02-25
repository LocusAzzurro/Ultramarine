package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.function.BiConsumer;

import static com.voxelutopia.ultramarine.datagen.DataGenerators.MOD_ID;

public class ModArchaeologyLootProvider implements LootTableSubProvider {

    public static final ResourceLocation TRAIL_RUINS_COMMON = ResourceLocation.fromNamespaceAndPath(MOD_ID, "archaeology/trail_ruins_common");
    public static final ResourceLocation TRAIL_RUINS_RARE = ResourceLocation.fromNamespaceAndPath(MOD_ID, "archaeology/trail_ruins_rare");

    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> output) {
        output.accept(TRAIL_RUINS_COMMON, LootTable.lootTable().withPool(
                LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ItemRegistry.CYAN_BRICK.get()).setWeight(8))
                        .add(LootItem.lootTableItem(ItemRegistry.BLACK_BRICK.get()).setWeight(8))
                        .add(LootItem.lootTableItem(ItemRegistry.BROWNISH_RED_STONE_BRICK.get()).setWeight(8))
                        .add(LootItem.lootTableItem(ItemRegistry.POLISHED_ROSEWOOD_PLANK.get()).setWeight(8))
                        .add(LootItem.lootTableItem(ItemRegistry.POLISHED_EBONY_PLANK.get()).setWeight(8))
                        .add(LootItem.lootTableItem(ItemRegistry.GRAY_ROOF_TILE.get()).setWeight(4))
                        .add(LootItem.lootTableItem(ItemRegistry.YELLOW_ROOF_TILE.get()).setWeight(4))
                        .add(LootItem.lootTableItem(ItemRegistry.GREEN_ROOF_TILE.get()).setWeight(4))
                        .add(LootItem.lootTableItem(ItemRegistry.BLUE_ROOF_TILE.get()).setWeight(4))
                        .add(LootItem.lootTableItem(ItemRegistry.CYAN_ROOF_TILE.get()).setWeight(4))
                        .add(LootItem.lootTableItem(ItemRegistry.BLACK_ROOF_TILE.get()).setWeight(4))
                        .add(LootItem.lootTableItem(ItemRegistry.BRONZE_INGOT.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ItemRegistry.COPPER_CASH_COIN.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ItemRegistry.SILK.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ItemRegistry.MAGNESITE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_SHARDS.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ItemRegistry.PORCELAIN_PIECE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ItemRegistry.SMALL_WHITE_PORCELAIN_VASE.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ItemRegistry.MEDIUM_WHITE_PORCELAIN_VASE.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ItemRegistry.LARGE_WHITE_PORCELAIN_VASE.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ItemRegistry.SMALL_GREEN_PORCELAIN_VASE.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ItemRegistry.MEDIUM_GREEN_PORCELAIN_VASE.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ItemRegistry.TALL_BLUE_PORCELAIN_VASE.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ItemRegistry.BLACK_PORCELAIN_PLATE.get()).setWeight(1))
        ));
        output.accept(TRAIL_RUINS_RARE, LootTable.lootTable().withPool(
                LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE.get()).setWeight(20))
                        .add(LootItem.lootTableItem(ItemRegistry.RAW_HEMATITE.get()).setWeight(20))
                        .add(LootItem.lootTableItem(ItemRegistry.RAW_COBALT.get()).setWeight(20))
                        .add(LootItem.lootTableItem(ItemRegistry.TALL_BLUE_AND_WHITE_PORCELAIN_VASE.get()).setWeight(10))
                        .add(LootItem.lootTableItem(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PLATE.get()).setWeight(10))
                        .add(LootItem.lootTableItem(ItemRegistry.CLAY_DOLL_MALE.get()).setWeight(10))
                        .add(LootItem.lootTableItem(ItemRegistry.CLAY_DOLL_FEMALE.get()).setWeight(10))
                        .add(LootItem.lootTableItem(ItemRegistry.BAMBOO_SLIPS.get()).setWeight(10))
                        .add(LootItem.lootTableItem(ItemRegistry.BOOK_STACK.get()).setWeight(10))
                        .add(LootItem.lootTableItem(ItemRegistry.BLUE_BOOK.get()).setWeight(10))
                        .add(LootItem.lootTableItem(ItemRegistry.JADE.get()).setWeight(5))
                        .add(LootItem.lootTableItem(ItemRegistry.PAINTING_SCROLL.get()).setWeight(5))
                        .add(LootItem.lootTableItem(ItemRegistry.BRONZE_CENSER.get()).setWeight(5))
                        .add(LootItem.lootTableItem(ItemRegistry.KNIFE.get()).setWeight(5))
                        .add(LootItem.lootTableItem(ItemRegistry.BOTTLE_GOURD.get()).setWeight(5))
                        .add(LootItem.lootTableItem(ItemRegistry.JADE_PENDANT.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_VASE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ItemRegistry.LARGE_BLUE_AND_WHITE_PORCELAIN_VASE.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ItemRegistry.SHORT_BLUE_AND_WHITE_PORCELAIN_POT.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ItemRegistry.TALL_BLUE_AND_WHITE_PORCELAIN_POT.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_BOWL.get()).setWeight(2))
                        .add(LootItem.lootTableItem(ItemRegistry.IMPERIAL_JADE_SEAL.get()).setWeight(1))
                        .add(LootItem.lootTableItem(ItemRegistry.BRONZE_DING.get()).setWeight(1))
        ));
    }
}
