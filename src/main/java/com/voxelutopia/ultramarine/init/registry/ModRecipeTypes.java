package com.voxelutopia.ultramarine.init.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.common.recipe.WoodworkingRecipe;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;

public class ModRecipeTypes {


    public static RecipeType<WoodworkingRecipe> WOODWORKING;

    public static void registerModRecipeTypes() {
        WOODWORKING = Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(Ultramarine.MOD_ID, "woodworking"),
                Type.INSTANCE);
    }

    static class Type implements RecipeType<WoodworkingRecipe> {
        public final static Type INSTANCE = new Type();
    }

}
