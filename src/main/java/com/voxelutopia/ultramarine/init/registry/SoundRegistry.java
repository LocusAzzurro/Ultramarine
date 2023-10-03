package com.voxelutopia.ultramarine.init.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.util.ForgeSoundType;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

public class SoundRegistry {
    public static SoundEvent BAMBOO_WOOD_HIT;
    public static SoundEvent BAMBOO_WOOD_FALL;
    public static SoundEvent BAMBOO_WOOD_STEP;
    public static SoundEvent BAMBOO_WOOD_PLACE;
    public static SoundEvent BAMBOO_WOOD_BREAK;
    public static SoundEvent WOOD_HAMMER;
    public static SoundEvent WOODWORK;
    public static SoundEvent SACK_BREAK;
    public static SoundEvent SACK_PLACE;

    public static ForgeSoundType BAMBOO_WOOD;
    public static ForgeSoundType PORCELAIN;
    public static ForgeSoundType FLAX;

    public static void registerModSounds(){
        BAMBOO_WOOD_HIT = register("bamboo_wood_hit");
        BAMBOO_WOOD_FALL = register("bamboo_wood_fall");
        BAMBOO_WOOD_STEP = register("bamboo_wood_step");
        BAMBOO_WOOD_PLACE = register("bamboo_wood_place");
        BAMBOO_WOOD_BREAK = register("bamboo_wood_break");
        WOOD_HAMMER = register("wood_hammer");
        WOODWORK = register("woodwork");
        SACK_BREAK = register("sack_break");
        SACK_PLACE = register("sack_place");

        BAMBOO_WOOD = new ForgeSoundType(1,1,
                BAMBOO_WOOD_BREAK,BAMBOO_WOOD_STEP,BAMBOO_WOOD_PLACE,BAMBOO_WOOD_HIT,BAMBOO_WOOD_FALL);
        PORCELAIN = new ForgeSoundType(1,1,
                SoundEvents.GLASS_BREAK,SoundEvents.COPPER_STEP,SoundEvents.COPPER_PLACE, SoundEvents.COPPER_HIT, SoundEvents.COPPER_FALL);
        FLAX = new ForgeSoundType(0.35F,1.2F,
                SACK_BREAK,SoundEvents.WOOL_STEP,SACK_PLACE, SoundEvents.WOOL_HIT,SoundEvents.WOOL_FALL);
    }


    private static SoundEvent register(String name){
        return Registry.register(BuiltInRegistries.SOUND_EVENT, name, SoundEvent.createVariableRangeEvent(new ResourceLocation(Ultramarine.MOD_ID,name)));
    }

}
