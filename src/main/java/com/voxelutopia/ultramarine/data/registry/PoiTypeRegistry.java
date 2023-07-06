package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class PoiTypeRegistry {

    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, Ultramarine.MOD_ID);

    public static final RegistryObject<PoiType> COOKING_POI = POI_TYPES.register("cooking_poi",
            () -> new PoiType("cooking_poi", PoiType.getBlockStates(BlockRegistry.FOOD_HAMPER.get()), 1, 1));

    public static void registerPOI (){
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, COOKING_POI.get());
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }



}
