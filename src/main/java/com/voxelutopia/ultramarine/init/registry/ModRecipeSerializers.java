package com.voxelutopia.ultramarine.init.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.common.recipe.WoodworkingRecipe;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ModRecipeSerializers {

    public static RecipeSerializer<WoodworkingRecipe> WOODWORKING_SERIALIZER;


    public static void registerModRecipeSerializers() {
        WOODWORKING_SERIALIZER = Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, new ResourceLocation(Ultramarine.MOD_ID, "woodworking"),
                WoodworkingRecipe.Serializer.INSTANCE);
    }

}
