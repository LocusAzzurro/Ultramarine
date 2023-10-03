package com.voxelutopia.ultramarine.init.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.common.recipe.WoodworkingRecipe;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;

public class RecipeTypeRegistry {


    public static RecipeType<WoodworkingRecipe> WOODWORKING;
    static class Type implements RecipeType<WoodworkingRecipe> {
        public final static Type INSTANCE = new Type();
    }

    public static void registerModRecipeTypes() {
        WOODWORKING = Registry.register(BuiltInRegistries.RECIPE_TYPE, new ResourceLocation(Ultramarine.MOD_ID, "woodworking"),
                Type.INSTANCE);
    }

}
