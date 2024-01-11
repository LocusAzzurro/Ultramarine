package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.recipe.ChiselTableRecipe;
import com.voxelutopia.ultramarine.data.recipe.CompositeSmeltingRecipe;
import com.voxelutopia.ultramarine.data.recipe.WoodworkingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RecipeSerializerRegistry {

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Ultramarine.MOD_ID);

    public static final RegistryObject<RecipeSerializer<WoodworkingRecipe>> WOODWORKING_SERIALIZER =
            RECIPE_SERIALIZERS.register("woodworking", () -> WoodworkingRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<CompositeSmeltingRecipe>> COMPOSITE_SMELTING_SERIALIZER =
            RECIPE_SERIALIZERS.register("composite_smelting", () -> CompositeSmeltingRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<ChiselTableRecipe>> CHISEL_TABLE_SERIALIZER =
            RECIPE_SERIALIZERS.register("chisel_table", () -> ChiselTableRecipe.Serializer.INSTANCE);


}
