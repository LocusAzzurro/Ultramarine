package com.voxelutopia.ultramarine.world.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;

public class BaseFood extends Item {

    public BaseFood(Item.Properties properties, FoodProperties food) {
        super(properties.food(food, Consumables.DEFAULT_FOOD));
    }

    public BaseFood(Item.Properties properties, FoodProperties food, Consumable consumable) {
        super(properties.food(food, consumable));
    }
}
