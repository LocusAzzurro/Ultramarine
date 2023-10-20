package com.voxelutopia.ultramarine.event;

import com.voxelutopia.ultramarine.data.ModBlockTags;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.data.registry.VillagerProfessionRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber
public class CommonEventHandler {

    @SubscribeEvent
    public static void breakSpeed(PlayerEvent.BreakSpeed event) {
        BlockState state = event.getState();
        PlayerEntity player = event.getPlayer();
        if (state.is(ModBlockTags.MINEABLE_WITH_SHEARS) &&
                Tags.Items.SHEARS.contains(player.getItemInHand(player.getUsedItemHand()).getItem())) {
            event.setNewSpeed(event.getOriginalSpeed() * 4);
        }
    }

    @SubscribeEvent
    public static void itemConversion(ItemExpireEvent event) {
        ItemEntity itemEntity = (ItemEntity) event.getEntity();
        ItemStack item = itemEntity.getItem();
        if (itemEntity.isInWater() && item.getItem().equals(ItemRegistry.FIRED_BRICK.get())) {
            itemEntity.setItem(new ItemStack(ItemRegistry.CYAN_BRICK.get(), item.getCount()));
            itemEntity.level.playSound(null, itemEntity, SoundEvents.LAVA_EXTINGUISH, SoundCategory.NEUTRAL, 0.5f, 1.0f);
            event.setExtraLife(6000);
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void villagerTraders(VillagerTradesEvent event) {
        VillagerProfession profession = event.getType();

        if (profession == VillagerProfessionRegistry.COOK.get()) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            trades.get(1).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(ItemRegistry.RAW_MEAT.get(), 5),
                    new ItemStack(Items.EMERALD, 2),
                    12, 2, 0.05f
            ));
            trades.get(1).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    new ItemStack(ItemRegistry.COOKED_MEAT.get(), 4),
                    12, 2, 0.05f
            ));
            trades.get(2).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ItemRegistry.GREASE.get(), 2),
                    16, 2, 0.05f
            ));
            trades.get(2).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ItemRegistry.FUR.get(), 2),
                    16, 2, 0.05f
            ));
            trades.get(3).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    new ItemStack(ItemRegistry.MUNG_BEAN_CAKE.get(), 4),
                    12, 3, 0.05f
            ));
            trades.get(3).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    new ItemStack(ItemRegistry.MOONCAKE.get(), 4),
                    12, 3, 0.05f
            ));
            trades.get(4).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(ItemRegistry.BAOZI.get(), 2),
                    8, 3, 0.05f
            ));
        }

    }

}
