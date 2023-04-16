package com.voxelutopia.ultramarine.data;

import com.voxelutopia.ultramarine.Ultramarine;
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


}
