package com.voxelutopia.ultramarine.data.registry;

import com.google.common.collect.ImmutableSet;
import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PoiTypeRegistry {

    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, Ultramarine.MOD_ID);

    public static final DeferredHolder<PoiType, PoiType> COOKING_POI = POI_TYPES.register("cooking_poi",
            () -> new PoiType(ImmutableSet.copyOf(BlockRegistry.FOOD_HAMPER.get().getStateDefinition().getPossibleStates()), 1, 1));
    public static final DeferredHolder<PoiType, PoiType> TRADE_POI = POI_TYPES.register("trade_poi",
            () -> new PoiType(ImmutableSet.copyOf(BlockRegistry.TEAHOUSE_FLAG.get().getStateDefinition().getPossibleStates()), 1, 5));

}
