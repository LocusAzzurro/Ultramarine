package com.voxelutopia.ultramarine.data.registry;

import com.google.common.collect.ImmutableSet;
import com.voxelutopia.ultramarine.Ultramarine;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class VillagerProfessionRegistry {

    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(Registries.VILLAGER_PROFESSION, Ultramarine.MOD_ID);
    public static final Identifier id = Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "cook");

    public static final DeferredHolder<VillagerProfession, VillagerProfession> COOK = PROFESSIONS.register("cook",
            () -> new VillagerProfession(
                    Component.translatable("entity." + id.getNamespace() + ".villager." + id.getPath()),
                    (Holder<PoiType> holder) -> {
                        PoiTypeRegistry.COOKING_POI.get();
                        return holder.value() == PoiTypeRegistry.COOKING_POI.get();
                    },
                    (Holder<PoiType> holder) -> {
                        PoiTypeRegistry.COOKING_POI.get();
                        return holder.value() == PoiTypeRegistry.COOKING_POI.get();
                    },
                    ImmutableSet.of(),
                    ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_BUTCHER,
                    Int2ObjectMap.ofEntries(
                            Int2ObjectMap.entry(
                                    1,
                                    ResourceKey.create(Registries.TRADE_SET, Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "cook/level_1"))
                            ),
                            Int2ObjectMap.entry(
                                    2,
                                    ResourceKey.create(Registries.TRADE_SET, Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "cook/level_2"))
                            ),
                            Int2ObjectMap.entry(
                                    3,
                                    ResourceKey.create(Registries.TRADE_SET, Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "cook/level_3"))
                            ),
                            Int2ObjectMap.entry(
                                    4,
                                    ResourceKey.create(Registries.TRADE_SET, Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "cook/level_4"))
                            ),
                            Int2ObjectMap.entry(
                                    5,
                                    ResourceKey.create(Registries.TRADE_SET, Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "cook/level_5"))
                            )
                    )
            )
    );
}
