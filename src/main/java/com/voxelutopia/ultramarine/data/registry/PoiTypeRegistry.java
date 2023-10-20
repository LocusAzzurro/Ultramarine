package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.lang.reflect.InvocationTargetException;

public class PoiTypeRegistry {

    public static final DeferredRegister<PointOfInterestType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, Ultramarine.MOD_ID);

    public static final RegistryObject<PointOfInterestType> COOKING_POI = POI_TYPES.register("cooking_poi",
            () -> new PointOfInterestType("cooking_poi", PointOfInterestType.getBlockStates(BlockRegistry.FOOD_HAMPER.get()), 1, 1));

    public static void registerPOI() {
        try {
            ObfuscationReflectionHelper.findMethod(PointOfInterestType.class, "registerBlockStates", PointOfInterestType.class).invoke(null, COOKING_POI.get());
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
