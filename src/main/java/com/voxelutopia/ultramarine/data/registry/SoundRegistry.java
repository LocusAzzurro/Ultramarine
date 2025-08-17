package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SoundRegistry {
    public static final DeferredRegister<SoundEvent> SOUND_EVENT =
            DeferredRegister.create(Registries.SOUND_EVENT, Ultramarine.MOD_ID);

    private static DeferredHolder<SoundEvent, SoundEvent> register(String name) {
        return SOUND_EVENT.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(Ultramarine.MOD_ID, name)));
    }

    public static DeferredHolder<SoundEvent,SoundEvent> BAMBOO_WOOD_HIT = register("bamboo_wood_hit");
    public static DeferredHolder<SoundEvent,SoundEvent> BAMBOO_WOOD_FALL = register("bamboo_wood_fall");
    public static DeferredHolder<SoundEvent,SoundEvent> BAMBOO_WOOD_STEP = register("bamboo_wood_step");
    public static DeferredHolder<SoundEvent,SoundEvent> BAMBOO_WOOD_PLACE = register("bamboo_wood_place");
    public static DeferredHolder<SoundEvent,SoundEvent> BAMBOO_WOOD_BREAK = register("bamboo_wood_break");
    public static DeferredHolder<SoundEvent,SoundEvent> WOOD_HAMMER = register("wood_hammer");
    public static DeferredHolder<SoundEvent,SoundEvent> WOODWORK = register("woodwork");
    public static DeferredHolder<SoundEvent,SoundEvent> SACK_BREAK = register("sack_break");
    public static DeferredHolder<SoundEvent,SoundEvent> SACK_PLACE = register("sack_place");

    public static final DeferredSoundType BAMBOO_WOOD = new DeferredSoundType(1, 1,
            BAMBOO_WOOD_BREAK, BAMBOO_WOOD_STEP, BAMBOO_WOOD_PLACE, BAMBOO_WOOD_HIT, BAMBOO_WOOD_FALL);
    public static final DeferredSoundType PORCELAIN = new DeferredSoundType(1, 1,
            () -> SoundEvents.GLASS_BREAK, () -> SoundEvents.COPPER_STEP, () -> SoundEvents.COPPER_PLACE, () -> SoundEvents.COPPER_HIT, () -> SoundEvents.COPPER_FALL);
    public static final DeferredSoundType FLAX = new DeferredSoundType(0.35F, 1.2F,
            SACK_BREAK, () -> SoundEvents.WOOL_STEP, SACK_PLACE, () -> SoundEvents.WOOL_HIT, () -> SoundEvents.WOOL_FALL);
}
