package com.voxelutopia.ultramarine.init.registry;

import com.voxelutopia.ultramarine.init.event.EntityEvents;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Name: Ultramarine / VillagerTradingManager
 * Author: cnlimiter
 * CreateTime: 2023/10/3 11:30
 * Description:
 */

public class ModVillagerTradings {
    private static final Map<VillagerProfession, Int2ObjectMap<VillagerTrades.ItemListing[]>> VANILLA_TRADES = new HashMap<>();
    private static final Int2ObjectMap<VillagerTrades.ItemListing[]> WANDERER_TRADES = new Int2ObjectOpenHashMap<>();

    static {
        VillagerTrades.TRADES.entrySet().forEach(e ->
        {
            Int2ObjectMap<VillagerTrades.ItemListing[]> copy = new Int2ObjectOpenHashMap<>();
            e.getValue().int2ObjectEntrySet().forEach(ent -> copy.put(ent.getIntKey(), Arrays.copyOf(ent.getValue(), ent.getValue().length)));
            VANILLA_TRADES.put(e.getKey(), copy);
        });
        VillagerTrades.WANDERING_TRADER_TRADES.int2ObjectEntrySet().forEach(e -> WANDERER_TRADES.put(e.getIntKey(), Arrays.copyOf(e.getValue(), e.getValue().length)));
    }

    public static void loadTrades() {
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            postWandererEvent();
            postVillagerEvents();
        });

    }

    /**
     * Posts the WandererTradesEvent.
     */
    private static void postWandererEvent() {
        List<VillagerTrades.ItemListing> generic = NonNullList.create();
        List<VillagerTrades.ItemListing> rare = NonNullList.create();
        generic.addAll(Arrays.asList(WANDERER_TRADES.get(1)));
        rare.addAll(Arrays.asList(WANDERER_TRADES.get(2)));
        //MinecraftForge.EVENT_BUS.post(new WandererTradesEvent(generic, rare));
        VillagerTrades.WANDERING_TRADER_TRADES.put(1, generic.toArray(new VillagerTrades.ItemListing[0]));
        VillagerTrades.WANDERING_TRADER_TRADES.put(2, rare.toArray(new VillagerTrades.ItemListing[0]));
    }

    /**
     * Posts a VillagerTradesEvent for each registered profession.
     */
    private static void postVillagerEvents() {
        for (VillagerProfession prof : BuiltInRegistries.VILLAGER_PROFESSION) {
            Int2ObjectMap<VillagerTrades.ItemListing[]> trades = VANILLA_TRADES.getOrDefault(prof, new Int2ObjectOpenHashMap<>());
            Int2ObjectMap<List<VillagerTrades.ItemListing>> mutableTrades = new Int2ObjectOpenHashMap<>();
            for (int i = 1; i < 6; i++) {
                mutableTrades.put(i, NonNullList.create());
            }
            trades.int2ObjectEntrySet().forEach(e ->
            {
                Arrays.stream(e.getValue()).forEach(mutableTrades.get(e.getIntKey())::add);
            });
            EntityEvents.VILLAGER_TRADE.invoker().modifyBreakSpeed(mutableTrades, prof);
            Int2ObjectMap<VillagerTrades.ItemListing[]> newTrades = new Int2ObjectOpenHashMap<>();
            mutableTrades.int2ObjectEntrySet().forEach(e -> newTrades.put(e.getIntKey(), e.getValue().toArray(new VillagerTrades.ItemListing[0])));
            VillagerTrades.TRADES.put(prof, newTrades);
        }
    }

}
