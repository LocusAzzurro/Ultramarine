package com.voxelutopia.ultramarine.event;

import com.voxelutopia.ultramarine.data.ModBlockTags;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.data.registry.VillagerProfessionRegistry;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CommonEventHandler {

    @SubscribeEvent
    public static void breakSpeed(PlayerEvent.BreakSpeed event){
        BlockState state = event.getState();
        Player player = event.getEntity();
        if (state.is(ModBlockTags.MINEABLE_WITH_SHEARS) &&
                player.getItemInHand(player.getUsedItemHand()).is(Tags.Items.SHEARS)){
            event.setNewSpeed(event.getOriginalSpeed() * 4);
        }
    }

    @SubscribeEvent
    public static void villagerTraders(VillagerTradesEvent event){
        VillagerProfession profession = event.getType();

        if (profession == VillagerProfessionRegistry.COOK.get()){
            var trades = event.getTrades();
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
