package com.voxelutopia.ultramarine.world.entity;

import com.google.common.collect.ImmutableList;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.merchant.villager.WanderingTraderEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.MerchantOffers;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomWanderingTrader extends WanderingTraderEntity {

    private static final List<MerchantOffer> TRADE_OPTIONS = new ArrayList<>();

    public CustomWanderingTrader(EntityType<? extends CustomWanderingTrader> entityType, World level) {
        super(entityType, level);
        ArrayList<MerchantOffer> trades = new ArrayList<>(TRADE_OPTIONS);
        Collections.shuffle(trades);
        MerchantOffers offers = new MerchantOffers();
        offers.addAll(trades.subList(0, 6));
        this.offers = offers;
    }

    @Override
    public MerchantOffers getOffers() {
        return offers;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20.0d)
                .add(Attributes.MOVEMENT_SPEED, 0.27d)
                .add(Attributes.FOLLOW_RANGE, 32d);
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    static {
        TRADE_OPTIONS.addAll(ImmutableList.of(
                new MerchantOffer(new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 10), new ItemStack(ItemRegistry.INCENSE.get()), 8, 5, 0.05f),
                new MerchantOffer(new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 4), new ItemStack(ItemRegistry.XUAN_PAPER.get()), 20, 5, 0.05f),
                new MerchantOffer(new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 8), new ItemStack(Items.LAPIS_LAZULI), 10, 5, 0.05f),
                new MerchantOffer(new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 8), new ItemStack(Items.PRISMARINE_SHARD), 10, 5, 0.05f),
                new MerchantOffer(new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 15), new ItemStack(ItemRegistry.RED_SILK_FABRIC_ROLL.get()), 5, 5, 0.05f),
                new MerchantOffer(new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 15), new ItemStack(ItemRegistry.GREEN_SILK_FABRIC_ROLL.get()), 5, 5, 0.05f),
                new MerchantOffer(new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 15), new ItemStack(ItemRegistry.PURPLE_SILK_FABRIC_ROLL.get()), 5, 5, 0.05f),
                //new MerchantOffer(new ItemStack(Items.AMETHYST_SHARD), new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 6), 8, 5, 0.05f),
                new MerchantOffer(new ItemStack(Items.ENDER_PEARL), new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 3), 10, 5, 0.05f),
                new MerchantOffer(new ItemStack(Items.BOOK), new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 3), 5, 5, 0.05f),
                new MerchantOffer(new ItemStack(Items.NAUTILUS_SHELL), new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 20), 2, 5, 0.05f),
                new MerchantOffer(new ItemStack(ItemRegistry.POLISHED_EBONY_PLANK.get()), new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 4), 10, 5, 0.05f),
                new MerchantOffer(new ItemStack(ItemRegistry.POLISHED_ROSEWOOD_PLANK.get()), new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 4), 10, 5, 0.05f),
                new MerchantOffer(new ItemStack(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_PIECE.get()), new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 6), 8, 5, 0.05f),
                new MerchantOffer(new ItemStack(ItemRegistry.JADE.get()), new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 15), 2, 5, 0.05f)
        ));
    }
}
