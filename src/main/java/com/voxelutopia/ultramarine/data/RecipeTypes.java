package com.voxelutopia.ultramarine.data;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.recipe.WoodworkingRecipe;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.UpgradeRecipe;
import net.minecraft.world.level.Level;

import java.util.Optional;

public interface RecipeTypes<T extends Recipe<?>> {

    RecipeType<WoodworkingRecipe> WOODWORKING = register("woodworking");

    static <T extends Recipe<?>> RecipeType<T> register(final String pIdentifier) {
        return Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(Ultramarine.MOD_ID, pIdentifier), new RecipeType<T>() {
            public String toString() {
                return pIdentifier;
            }
        });
    }
    default <C extends Container> Optional<T> tryMatch(Recipe<C> pRecipe, Level pLevel, C pContainer) {
        return pRecipe.matches(pContainer, pLevel) ? Optional.of((T)pRecipe) : Optional.empty();
    }
}
