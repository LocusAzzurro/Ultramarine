package com.voxelutopia.ultramarine.common.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class BaseFood extends Item {

    public BaseFood(FoodProperties food) {
        super(new Item.Properties()
                .food(food));
    }
}
