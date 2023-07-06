package com.voxelutopia.ultramarine.world.entity;

import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import net.minecraft.network.protocol.Packet;
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
import net.minecraftforge.network.NetworkHooks;

import java.util.List;

public class CustomWanderingTrader extends WanderingTrader {

    public CustomWanderingTrader(EntityType<? extends CustomWanderingTrader> entityType, Level level) {
        super(entityType, level);
        MerchantOffers merchantOffers = new MerchantOffers();
        merchantOffers.add(new MerchantOffer(new ItemStack(ItemRegistry.COPPER_CASH_COIN.get(), 10), new ItemStack(ItemRegistry.INCENSE.get()), 5, 5, 1.0f));
        this.offers = merchantOffers;
    }

    @Override
    public MerchantOffers getOffers() {
        return offers;
    }

    public static AttributeSupplier.Builder setCustomAttributes(){
        return LivingEntity.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20.0d)
                .add(Attributes.MOVEMENT_SPEED, 0.27d)
                .add(Attributes.FOLLOW_RANGE, 32d);
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}
