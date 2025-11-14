package com.voxelutopia.ultramarine.world.entity;

import com.google.common.collect.ImmutableList;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TravellingMerchant extends WanderingTrader {

    private static final List<MerchantOffer> TRADE_OPTIONS_SELL = new ArrayList<>();
    private static final List<MerchantOffer> TRADE_OPTIONS_BUY = new ArrayList<>();

    public TravellingMerchant(EntityType<? extends TravellingMerchant> entityType, Level level) {
        super(entityType, level);
        var sell = new ArrayList<>(TRADE_OPTIONS_SELL);
        Collections.shuffle(sell);
        var buy = new ArrayList<>(TRADE_OPTIONS_BUY);
        Collections.shuffle(buy);
        var offers = new MerchantOffers();
        offers.addAll(sell.subList(0, 4));
        offers.addAll(buy.subList(0, 2));
        this.offers = offers;
    }

    @Override
    public @NotNull MerchantOffers getOffers() {
        return offers;
    }

    public static AttributeSupplier.Builder setCustomAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20.0d)
                .add(Attributes.MOVEMENT_SPEED, 0.27d)
                .add(Attributes.FOLLOW_RANGE, 32d);
    }

    public static List<MerchantOffer> getTradeOptions() {
        return Stream.of(TRADE_OPTIONS_SELL, TRADE_OPTIONS_BUY).flatMap(Collection::stream).toList();
    }

    static {
        TRADE_OPTIONS_SELL.addAll(List.of(
                new MerchantOffer(new ItemCost(ItemRegistry.COPPER_CASH_COIN.get(), 10), new ItemStack(ItemRegistry.INCENSE.get()), 8, 5, 0.05f),
                new MerchantOffer(new ItemCost(ItemRegistry.COPPER_CASH_COIN.get(), 4), new ItemStack(ItemRegistry.XUAN_PAPER.get()), 20, 5, 0.05f),
                new MerchantOffer(new ItemCost(ItemRegistry.COPPER_CASH_COIN.get(), 6), new ItemStack(ItemRegistry.SILK.get()), 20, 5, 0.05f),
                new MerchantOffer(new ItemCost(ItemRegistry.COPPER_CASH_COIN.get(), 8), new ItemStack(Items.LAPIS_LAZULI), 10, 5, 0.05f),
                new MerchantOffer(new ItemCost(ItemRegistry.COPPER_CASH_COIN.get(), 8), new ItemStack(Items.PRISMARINE_SHARD), 10, 5, 0.05f),
                new MerchantOffer(new ItemCost(ItemRegistry.COPPER_CASH_COIN.get(), 15), new ItemStack(ItemRegistry.RED_SILK_FABRIC_ROLL.get()), 5, 5, 0.05f),
                new MerchantOffer(new ItemCost(ItemRegistry.COPPER_CASH_COIN.get(), 15), new ItemStack(ItemRegistry.GREEN_SILK_FABRIC_ROLL.get()), 5, 5, 0.05f),
                new MerchantOffer(new ItemCost(ItemRegistry.COPPER_CASH_COIN.get(), 15), new ItemStack(ItemRegistry.PURPLE_SILK_FABRIC_ROLL.get()), 5, 5, 0.05f),
                new MerchantOffer(new ItemCost(ItemRegistry.COPPER_CASH_COIN.get(), 20), new ItemStack(ItemRegistry.CLAY_DOLL_MALE.get()), 5, 5, 0.05f),
                new MerchantOffer(new ItemCost(ItemRegistry.COPPER_CASH_COIN.get(), 20), new ItemStack(ItemRegistry.CLAY_DOLL_FEMALE.get()), 5, 5, 0.05f),
                new MerchantOffer(new ItemCost(ItemRegistry.COPPER_CASH_COIN.get(), 30), new ItemStack(ItemRegistry.PAINTING_SCROLL.get()), 5, 5, 0.05f),
                new MerchantOffer(new ItemCost(ItemRegistry.COPPER_CASH_COIN.get(), 10), new ItemStack(ItemRegistry.CHINESE_HERBS_BAG.get()), 5, 5, 0.05f)
        ));
        TRADE_OPTIONS_BUY.addAll(List.of(
                new MerchantOffer(new ItemCost(Items.AMETHYST_SHARD), new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 6), 8, 5, 0.05f),
                new MerchantOffer(new ItemCost(Items.ENDER_PEARL), new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 3), 10, 5, 0.05f),
                new MerchantOffer(new ItemCost(Items.BOOK), new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 3), 5, 5, 0.05f),
                new MerchantOffer(new ItemCost(Items.NAUTILUS_SHELL), new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 20), 2, 5, 0.05f),
                new MerchantOffer(new ItemCost(ItemRegistry.POLISHED_EBONY_PLANK.get()), new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 4), 10, 5, 0.05f),
                new MerchantOffer(new ItemCost(ItemRegistry.POLISHED_ROSEWOOD_PLANK.get()), new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 4), 10, 5, 0.05f),
                new MerchantOffer(new ItemCost(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE.get()), new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 6), 8, 5, 0.05f),
                new MerchantOffer(new ItemCost(ItemRegistry.JADE.get()), new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 15), 2, 5, 0.05f)
        ));
    }
}
