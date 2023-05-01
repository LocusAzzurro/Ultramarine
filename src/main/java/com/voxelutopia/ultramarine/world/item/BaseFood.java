package com.voxelutopia.ultramarine.world.item;

import com.voxelutopia.ultramarine.data.CreativeTabs;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class BaseFood extends Item {

    public BaseFood(FoodProperties food) {
        super(new Item.Properties().tab(CreativeTabs.MATERIALS)
                .food(food));
    }
}
