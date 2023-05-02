package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class SoundRegistry {
    public static final DeferredRegister<SoundEvent> SOUND_EVENT =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Ultramarine.MOD_ID);
    private static RegistryObject<SoundEvent> register(String name){
        return SOUND_EVENT.register(name,()->new SoundEvent(new ResourceLocation(Ultramarine.MOD_ID,name)));
    }
    public static RegistryObject<SoundEvent> BAMBOO_WOOD_HIT = register("bamboo_wood_hit");
    public static RegistryObject<SoundEvent> BAMBOO_WOOD_FALL = register("bamboo_wood_fall");
    public static RegistryObject<SoundEvent> BAMBOO_WOOD_STEP = register("bamboo_wood_step");
    public static RegistryObject<SoundEvent> BAMBOO_WOOD_PLACE = register("bamboo_wood_place");
    public static RegistryObject<SoundEvent> BAMBOO_WOOD_BREAK = register("bamboo_wood_break");
    public static RegistryObject<SoundEvent> WOOD_HAMMER = register("wood_hammer");
    public static RegistryObject<SoundEvent> WOODWORK = register("woodwork");
    public static RegistryObject<SoundEvent> SACK_BREAK = register("sack_break");
    public static RegistryObject<SoundEvent> SACK_PLACE = register("sack_place");

    public static final ForgeSoundType BAMBOO_WOOD = new ForgeSoundType(1,1,
            BAMBOO_WOOD_BREAK,BAMBOO_WOOD_STEP,BAMBOO_WOOD_PLACE,BAMBOO_WOOD_HIT,BAMBOO_WOOD_FALL);
    public static final ForgeSoundType PORCELAIN = new ForgeSoundType(1,1,
            ()->SoundEvents.GLASS_BREAK,()->SoundEvents.COPPER_STEP,()->SoundEvents.COPPER_PLACE,()->SoundEvents.COPPER_HIT,()->SoundEvents.COPPER_FALL);
    public static final ForgeSoundType FLAX = new ForgeSoundType(0.35F,1.2F,
            SACK_BREAK,() -> SoundEvents.WOOL_STEP,SACK_PLACE,() -> SoundEvents.WOOL_HIT,() -> SoundEvents.WOOL_FALL);
}
