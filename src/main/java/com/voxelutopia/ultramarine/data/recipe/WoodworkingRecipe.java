package com.voxelutopia.ultramarine.data.recipe;

import com.google.gson.JsonObject;
import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.registry.RecipeSerializerRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeTypeRegistry;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class WoodworkingRecipe extends SingleItemRecipe {

    protected final Ingredient ingredient;
    protected final ItemStack result;
    protected final ResourceLocation id;
    protected final String group;
    public WoodworkingRecipe(ResourceLocation pId, String pGroup, Ingredient pIngredient, ItemStack pResult) {
        super(RecipeTypeRegistry.WOODWORKING.get(), RecipeSerializerRegistry.WOODWORKING_SERIALIZER.get(), pId, pGroup, pIngredient, pResult);
        this.id = pId;
        this.group = pGroup;
        this.ingredient = pIngredient;
        this.result = pResult;
    }
    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        return ingredient.test(pContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(Container pContainer) {
        return result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return result.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeTypeRegistry.WOODWORKING.get();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializerRegistry.WOODWORKING_SERIALIZER.get();
    }


    public static class Serializer implements RecipeSerializer<WoodworkingRecipe> {

        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Ultramarine.MOD_ID,"woodworking");
        protected Serializer() {}

        public WoodworkingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
            String s = GsonHelper.getAsString(pJson, "group", "");
            Ingredient ingredient;
            if (GsonHelper.isArrayNode(pJson, "ingredient")) {
                ingredient = Ingredient.fromJson(GsonHelper.getAsJsonArray(pJson, "ingredient"));
            } else {
                ingredient = Ingredient.fromJson(GsonHelper.getAsJsonObject(pJson, "ingredient"));
            }

            String s1 = GsonHelper.getAsString(pJson, "result");
            int i = GsonHelper.getAsInt(pJson, "count");
            ItemStack itemstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(s1)), i);
            return new WoodworkingRecipe(pRecipeId, s, ingredient, itemstack);
        }

        public WoodworkingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            String s = pBuffer.readUtf();
            Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
            ItemStack itemstack = pBuffer.readItem();
            return new WoodworkingRecipe(pRecipeId, s, ingredient, itemstack);
        }

        public void toNetwork(FriendlyByteBuf pBuffer, WoodworkingRecipe pRecipe) {
            pBuffer.writeUtf(pRecipe.group);
            pRecipe.ingredient.toNetwork(pBuffer);
            pBuffer.writeItem(pRecipe.result);
        }

        @Override
        public RecipeSerializer<?> setRegistryName(ResourceLocation name) {
            return INSTANCE;
        }

        @Nullable
        @Override
        public ResourceLocation getRegistryName() {
            return ID;
        }

        @Override
        public Class<RecipeSerializer<?>> getRegistryType() {
            return Serializer.castClass(RecipeSerializer.class);
        }

        @SuppressWarnings("unchecked")
        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>)cls;
        }

    }

}
