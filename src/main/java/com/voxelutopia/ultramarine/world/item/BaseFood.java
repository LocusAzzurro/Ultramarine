package com.voxelutopia.ultramarine.world.item;

import com.voxelutopia.ultramarine.data.CreativeTabDefinitions;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class BaseFood extends Item {

    public BaseFood(Food food) {
        super(new Item.Properties().tab(CreativeTabDefinitions.MATERIALS)
                .food(food));
    }
}
