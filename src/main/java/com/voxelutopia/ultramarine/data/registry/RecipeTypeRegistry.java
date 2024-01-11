package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.recipe.ChiselTableRecipe;
import com.voxelutopia.ultramarine.data.recipe.CompositeSmeltingRecipe;
import com.voxelutopia.ultramarine.data.recipe.WoodworkingRecipe;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class RecipeTypeRegistry {

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registry.RECIPE_TYPE.key(), Ultramarine.MOD_ID);

    public static RegistryObject<RecipeType<WoodworkingRecipe>> WOODWORKING = register("woodworking");
    public static RegistryObject<RecipeType<CompositeSmeltingRecipe>> COMPOSITE_SMELTING = register("composite_smelting");
    public static RegistryObject<RecipeType<ChiselTableRecipe>> CHISEL_TABLE = register("chisel_table");

    private static <T extends Recipe<?>> RegistryObject<RecipeType<T>> register(String name) {
        return RECIPE_TYPES.register(name, () -> new RecipeType<>() {
            @Override
            public String toString() {
                return new ResourceLocation(Ultramarine.MOD_ID, name).toString();
            }
        });
    }

}
