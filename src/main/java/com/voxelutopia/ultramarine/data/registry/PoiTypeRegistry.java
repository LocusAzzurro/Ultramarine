package com.voxelutopia.ultramarine.data.registry;

import com.google.common.collect.ImmutableSet;
import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PoiTypeRegistry {

    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, Ultramarine.MOD_ID);

    public static final RegistryObject<PoiType> COOKING_POI = POI_TYPES.register("cooking_poi",
            () -> new PoiType(ImmutableSet.copyOf(BlockRegistry.FOOD_HAMPER.get().getStateDefinition().getPossibleStates()), 1, 1));
    public static final RegistryObject<PoiType> TRADE_POI = POI_TYPES.register("trade_poi",
            () -> new PoiType(ImmutableSet.copyOf(BlockRegistry.TEAHOUSE_FLAG.get().getStateDefinition().getPossibleStates()), 1, 5));

}
