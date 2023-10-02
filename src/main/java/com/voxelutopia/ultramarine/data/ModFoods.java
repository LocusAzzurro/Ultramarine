package com.voxelutopia.ultramarine.data;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ModFoods {

    public static final Food MOONCAKE = (new Food.Builder()).nutrition(2).saturationMod(0.1F).build();
    public static final Food MUNG_BEAN_CAKE = (new Food.Builder()).nutrition(2).saturationMod(0.1F).build();
    public static final Food RAW_MEAT = (new Food.Builder()).nutrition(2).saturationMod(0.2F)
            .effect(() -> new EffectInstance(Effects.HUNGER, 300, 0), 0.8F)
            .build();
    public static final Food COOKED_MEAT = (new Food.Builder()).nutrition(4).saturationMod(0.5F).build();
    public static final Food BAOZI = (new Food.Builder()).nutrition(2).saturationMod(1.0F).build();
    public static final Food FISH = (new Food.Builder()).nutrition(2).saturationMod(0.2F)
            .effect(() -> new EffectInstance(Effects.HUNGER, 300, 0), 0.6F)
            .effect(() -> new EffectInstance(Effects.POISON, 200, 0), 0.4F)
            .build();
}
