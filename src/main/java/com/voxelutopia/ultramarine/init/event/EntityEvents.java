package com.voxelutopia.ultramarine.init.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;

import java.util.List;

/**
 * Name: Ultramarine / EntityEvents
 * Author: cnlimiter
 * CreateTime: 2023/10/3 11:26
 * Description:
 */

public class EntityEvents {
    public static final Event<VillagerTrade> VILLAGER_TRADE = EventFactory.createArrayBacked(VillagerTrade.class, callbacks -> (trades, type) -> {
        for (VillagerTrade callback : callbacks)
            trades = callback.modifyBreakSpeed(trades, type);
        return trades;
    });

    @FunctionalInterface
    public interface VillagerTrade {
        Int2ObjectMap<List<VillagerTrades.ItemListing>> modifyBreakSpeed(Int2ObjectMap<List<VillagerTrades.ItemListing>> trades, VillagerProfession type);
    }

}
