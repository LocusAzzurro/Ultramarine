package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.recipe.WoodworkingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipeSerializerRegistry {

    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Ultramarine.MOD_ID);

    public static final RegistryObject<IRecipeSerializer<WoodworkingRecipe>> WOODWORKING_SERIALIZER =
            RECIPE_SERIALIZERS.register("woodworking", () -> WoodworkingRecipe.Serializer.INSTANCE);


}
