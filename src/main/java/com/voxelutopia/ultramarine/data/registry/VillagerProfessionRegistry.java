package com.voxelutopia.ultramarine.data.registry;

import com.google.common.collect.ImmutableSet;
import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class VillagerProfessionRegistry {

    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(Registries.VILLAGER_PROFESSION, Ultramarine.MOD_ID);

    public static final DeferredHolder<VillagerProfession, VillagerProfession> COOK = PROFESSIONS.register("cook",
            () -> new VillagerProfession("cook",
                    poi -> poi.is(PoiTypeRegistry.COOKING_POI.getKey()),
                    poi -> poi.is(PoiTypeRegistry.COOKING_POI.getKey()),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_BUTCHER));
}
