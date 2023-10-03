package com.voxelutopia.ultramarine.common.tile;

import com.voxelutopia.ultramarine.init.registry.ModItems;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomWanderingTrader extends WanderingTrader {

    private static final List<MerchantOffer> TRADE_OPTIONS = new ArrayList<>();

    static {
        TRADE_OPTIONS.addAll(List.of(
                new MerchantOffer(new ItemStack(ModItems.COPPER_CASH_COIN, 10), new ItemStack(ModItems.INCENSE), 8, 5, 0.05f),
                new MerchantOffer(new ItemStack(ModItems.COPPER_CASH_COIN, 4), new ItemStack(ModItems.XUAN_PAPER), 20, 5, 0.05f),
                new MerchantOffer(new ItemStack(ModItems.COPPER_CASH_COIN, 8), new ItemStack(Items.LAPIS_LAZULI), 10, 5, 0.05f),
                new MerchantOffer(new ItemStack(ModItems.COPPER_CASH_COIN, 8), new ItemStack(Items.PRISMARINE_SHARD), 10, 5, 0.05f),
                new MerchantOffer(new ItemStack(ModItems.COPPER_CASH_COIN, 15), new ItemStack(ModItems.RED_SILK_FABRIC_ROLL), 5, 5, 0.05f),
                new MerchantOffer(new ItemStack(ModItems.COPPER_CASH_COIN, 15), new ItemStack(ModItems.GREEN_SILK_FABRIC_ROLL), 5, 5, 0.05f),
                new MerchantOffer(new ItemStack(ModItems.COPPER_CASH_COIN, 15), new ItemStack(ModItems.PURPLE_SILK_FABRIC_ROLL), 5, 5, 0.05f),
                new MerchantOffer(new ItemStack(Items.AMETHYST_SHARD), new ItemStack(ModItems.COPPER_CASH_COIN, 6), 8, 5, 0.05f),
                new MerchantOffer(new ItemStack(Items.ENDER_PEARL), new ItemStack(ModItems.COPPER_CASH_COIN, 3), 10, 5, 0.05f),
                new MerchantOffer(new ItemStack(Items.BOOK), new ItemStack(ModItems.COPPER_CASH_COIN, 3), 5, 5, 0.05f),
                new MerchantOffer(new ItemStack(Items.NAUTILUS_SHELL), new ItemStack(ModItems.COPPER_CASH_COIN, 20), 2, 5, 0.05f),
                new MerchantOffer(new ItemStack(ModItems.POLISHED_EBONY_PLANK), new ItemStack(ModItems.COPPER_CASH_COIN, 4), 10, 5, 0.05f),
                new MerchantOffer(new ItemStack(ModItems.POLISHED_ROSEWOOD_PLANK), new ItemStack(ModItems.COPPER_CASH_COIN, 4), 10, 5, 0.05f),
                new MerchantOffer(new ItemStack(ModItems.BLUE_AND_WHITE_PORCELAIN_PIECE), new ItemStack(ModItems.COPPER_CASH_COIN, 6), 8, 5, 0.05f),
                new MerchantOffer(new ItemStack(ModItems.JADE), new ItemStack(ModItems.COPPER_CASH_COIN, 15), 2, 5, 0.05f)
        ));
    }

    public CustomWanderingTrader(EntityType<? extends CustomWanderingTrader> entityType, Level level) {
        super(entityType, level);
        var trades = new ArrayList<>(TRADE_OPTIONS);
        Collections.shuffle(trades);
        var offers = new MerchantOffers();
        offers.addAll(trades.subList(0, 6));
        this.offers = offers;
    }

    public static AttributeSupplier.Builder setCustomAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20.0d)
                .add(Attributes.MOVEMENT_SPEED, 0.27d)
                .add(Attributes.FOLLOW_RANGE, 32d);
    }

    @Override
    public @NotNull MerchantOffers getOffers() {
        return offers;
    }

    @Override
    public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }
}
