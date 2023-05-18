package com.voxelutopia.ultramarine.data;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static final FoodProperties MOONCAKE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties MUNG_BEAN_CAKE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties FISH = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 300, 0), 0.6F)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 200, 0), 0.4F)
            .build();
}
