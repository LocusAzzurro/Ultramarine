package com.voxelutopia.ultramarine.init.registry;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.npc.VillagerProfession;

public class ModVillagerProfessions {


    public static VillagerProfession COOK;


    public static void registerModVillagerProfession() {
        COOK = Registry.register(BuiltInRegistries.VILLAGER_PROFESSION, "cook", new VillagerProfession("cook", (holder) -> holder.is(BuiltInRegistries.POINT_OF_INTEREST_TYPE.getKey(ModPoiTypes.COOKING_POI)), (holder) -> holder.is(BuiltInRegistries.POINT_OF_INTEREST_TYPE.getKey(ModPoiTypes.COOKING_POI)), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_BUTCHER));
    }
}
