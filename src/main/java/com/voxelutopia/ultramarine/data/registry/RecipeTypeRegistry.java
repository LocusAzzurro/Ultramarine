package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.recipe.ChiselTableRecipe;
import com.voxelutopia.ultramarine.data.recipe.CompositeSmeltingRecipe;
import com.voxelutopia.ultramarine.data.recipe.WoodworkingRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RecipeTypeRegistry {

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, Ultramarine.MOD_ID);

    public static final DeferredHolder<RecipeType<?>, RecipeType<WoodworkingRecipe>> WOODWORKING = register("woodworking");
    public static final DeferredHolder<RecipeType<?>, RecipeType<CompositeSmeltingRecipe>> COMPOSITE_SMELTING = register("composite_smelting");
    public static final DeferredHolder<RecipeType<?>, RecipeType<ChiselTableRecipe>> CHISEL_TABLE = register("chisel_table");

    private static <T extends Recipe<?>> DeferredHolder<RecipeType<?>, RecipeType<T>> register(String name) {
        return RECIPE_TYPES.register(name, () -> new RecipeType<>() {
            @Override
            public String toString() {
                return ResourceLocation.fromNamespaceAndPath(Ultramarine.MOD_ID, name).toString();
            }
        });
    }

}
