package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.recipe.ChiselTableRecipe;
import com.voxelutopia.ultramarine.data.recipe.CompositeSmeltingRecipe;
import com.voxelutopia.ultramarine.data.recipe.WoodworkingRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RecipeSerializerRegistry {

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, Ultramarine.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<WoodworkingRecipe>> WOODWORKING_SERIALIZER =
            RECIPE_SERIALIZERS.register("woodworking", () -> WoodworkingRecipe.Serializer.INSTANCE);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<CompositeSmeltingRecipe>> COMPOSITE_SMELTING_SERIALIZER =
            RECIPE_SERIALIZERS.register("composite_smelting", () -> CompositeSmeltingRecipe.Serializer.INSTANCE);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ChiselTableRecipe>> CHISEL_TABLE_SERIALIZER =
            RECIPE_SERIALIZERS.register("chisel_table", () -> ChiselTableRecipe.Serializer.INSTANCE);


}
