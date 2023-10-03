package com.voxelutopia.ultramarine.init.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static FoodProperties MOONCAKE;
    public static FoodProperties MUNG_BEAN_CAKE;
    public static FoodProperties RAW_MEAT;
    public static FoodProperties COOKED_MEAT;
    public static FoodProperties BAOZI;
    public static FoodProperties FISH;

    public static void registerModFoods(){
        MOONCAKE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).build();
        MUNG_BEAN_CAKE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).build();
        RAW_MEAT = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F)
                .effect(new MobEffectInstance(MobEffects.HUNGER, 300, 0), 0.8F)
                .build();
        COOKED_MEAT = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.5F).build();
        BAOZI = (new FoodProperties.Builder()).nutrition(2).saturationMod(1.0F).build();
        FISH = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F)
                .effect(new MobEffectInstance(MobEffects.HUNGER, 300, 0), 0.6F)
                .effect(new MobEffectInstance(MobEffects.POISON, 200, 0), 0.4F)
                .build();
    }
}
