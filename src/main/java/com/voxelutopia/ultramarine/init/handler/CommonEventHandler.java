package com.voxelutopia.ultramarine.init.handler;

import com.voxelutopia.ultramarine.common.tile.CustomWanderingTrader;
import com.voxelutopia.ultramarine.init.data.ModBlockTags;
import com.voxelutopia.ultramarine.init.event.EntityEvents;
import com.voxelutopia.ultramarine.init.event.PlayerEvents;
import com.voxelutopia.ultramarine.init.registry.ModEntityTypes;
import com.voxelutopia.ultramarine.init.registry.ModItems;
import com.voxelutopia.ultramarine.init.registry.ModVillagerProfessions;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;

public class CommonEventHandler {

    public static void init() {
        breakSpeed();
        registerEntityAttributes();
        villagerTraders();
    }

    private static void breakSpeed() {
        PlayerEvents.BREAK_SPEED.register((player, state, pos, speed) -> {
            if (state.is(ModBlockTags.MINEABLE_WITH_SHEARS) &&
                    player.getItemInHand(player.getUsedItemHand()).is(Items.SHEARS)) {
                speed *= 4;
            }
            return speed;
        });

    }

    private static void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntityTypes.CUSTOM_WANDERING_TRADER, CustomWanderingTrader.setCustomAttributes());
    }

//    @SubscribeEvent
//    public static void itemConversion(ItemExpireEvent event){
//        Expire
//        ItemEntity itemEntity = (ItemEntity) event.getEntity();
//        ItemStack item = itemEntity.getItem();
//        if (itemEntity.isInWater() && item.is(ItemRegistry.FIRED_BRICK)){
//            itemEntity.setItem(new ItemStack(ItemRegistry.CYAN_BRICK, item.getCount()));
//            itemEntity.level.playSound(null, itemEntity, SoundEvents.LAVA_EXTINGUISH, SoundSource.NEUTRAL, 0.5f, 1.0f);
//            event.setExtraLife(6000);
//            event.setCanceled(true);
//        }
//    }

    private static void villagerTraders() {

        EntityEvents.VILLAGER_TRADE.register((trades, profession) -> {
            if (profession == ModVillagerProfessions.COOK) {
                trades.get(1).add(($1, $2) -> new MerchantOffer(
                        new ItemStack(ModItems.RAW_MEAT, 5),
                        new ItemStack(Items.EMERALD, 2),
                        12, 2, 0.05f
                ));
                trades.get(1).add(($1, $2) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 3),
                        new ItemStack(ModItems.COOKED_MEAT, 4),
                        12, 2, 0.05f
                ));
                trades.get(2).add(($1, $2) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        new ItemStack(ModItems.GREASE, 2),
                        16, 2, 0.05f
                ));
                trades.get(2).add(($1, $2) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 1),
                        new ItemStack(ModItems.FUR, 2),
                        16, 2, 0.05f
                ));
                trades.get(3).add(($1, $2) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 3),
                        new ItemStack(ModItems.MUNG_BEAN_CAKE, 4),
                        12, 3, 0.05f
                ));
                trades.get(3).add(($1, $2) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 3),
                        new ItemStack(ModItems.MOONCAKE, 4),
                        12, 3, 0.05f
                ));
                trades.get(4).add(($1, $2) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 5),
                        new ItemStack(ModItems.BAOZI, 2),
                        8, 3, 0.05f
                ));

            }
            return trades;
        });


    }

}
