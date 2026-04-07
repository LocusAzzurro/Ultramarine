package com.voxelutopia.ultramarine.data;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoods {

    public static FoodProperties MOONCAKE;
    public static FoodProperties MUNG_BEAN_CAKE;
    public static FoodProperties RAW_MEAT;
    public static Consumable RAW_MEAT_CONSUMABLE;
    public static FoodProperties COOKED_MEAT;
    public static FoodProperties BAOZI;
    public static FoodProperties FISH;
    public static Consumable FISH_CONSUMABLE;

    public static void registerModFoods() {
        MOONCAKE = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.1F).build();
        MUNG_BEAN_CAKE = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.1F).build();
        RAW_MEAT = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.2F).build();
        RAW_MEAT_CONSUMABLE = Consumables.defaultFood()
                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HUNGER, 300, 0), 0.8F))
                .build();
        COOKED_MEAT = (new FoodProperties.Builder()).nutrition(4).saturationModifier(0.5F).build();
        BAOZI = (new FoodProperties.Builder()).nutrition(2).saturationModifier(1.0F).build();
        FISH = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.2F).build();
        FISH_CONSUMABLE = Consumables.defaultFood()
                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HUNGER, 300, 0), 0.6F))
                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.POISON, 200, 0), 0.4F))
                .build();
    }
}
