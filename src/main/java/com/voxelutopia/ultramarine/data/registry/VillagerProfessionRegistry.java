package com.voxelutopia.ultramarine.data.registry;

import com.google.common.collect.ImmutableSet;
import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VillagerProfessionRegistry {

    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, Ultramarine.MOD_ID);

    public static final RegistryObject<VillagerProfession> COOK = PROFESSIONS.register("cook",
            () -> new VillagerProfession("cook", PoiTypeRegistry.COOKING_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_BUTCHER));
}
