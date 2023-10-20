package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.recipe.WoodworkingRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class RecipeTypeRegistry {
    public static IRecipeType<WoodworkingRecipe> WOODWORKING;

    public static void init() {
        WOODWORKING = Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(Ultramarine.MOD_ID, "woodworking"), new IRecipeType<WoodworkingRecipe>() {
            @Override
            public String toString() {
                return new ResourceLocation(Ultramarine.MOD_ID, "woodworking").toString();
            }
        });
    }

}
