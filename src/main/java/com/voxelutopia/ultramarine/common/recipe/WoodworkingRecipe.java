package com.voxelutopia.ultramarine.common.recipe;

import com.google.gson.JsonObject;
import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.init.registry.ModRecipeSerializers;
import com.voxelutopia.ultramarine.init.registry.ModRecipeTypes;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class WoodworkingRecipe extends SingleItemRecipe {


    protected final Ingredient ingredient;
    protected final ItemStack result;
    protected final ResourceLocation id;
    protected final String group;

    public WoodworkingRecipe(ResourceLocation pId, String pGroup, Ingredient pIngredient, ItemStack pResult) {
        super(ModRecipeTypes.WOODWORKING, ModRecipeSerializers.WOODWORKING_SERIALIZER, pId, pGroup, pIngredient, pResult);
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
    public @NotNull ItemStack assemble(Container container) {
        return result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public @NotNull ItemStack getResultItem() {
        return result.copy();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.WOODWORKING;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.WOODWORKING_SERIALIZER;
    }


    public static class Serializer implements RecipeSerializer<WoodworkingRecipe> {

        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Ultramarine.MOD_ID, "woodworking");

        protected Serializer() {
        }

        @Override
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
            ItemStack itemstack = new ItemStack(Registry.ITEM.get(new ResourceLocation(s1)), i);
            return new WoodworkingRecipe(pRecipeId, s, ingredient, itemstack);
        }

        @Override
        public @NotNull WoodworkingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            String s = pBuffer.readUtf();
            Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
            ItemStack itemstack = pBuffer.readItem();
            return new WoodworkingRecipe(pRecipeId, s, ingredient, itemstack);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, WoodworkingRecipe pRecipe) {
            pBuffer.writeUtf(pRecipe.group);
            pRecipe.ingredient.toNetwork(pBuffer);
            pBuffer.writeItem(pRecipe.result);
        }


    }

}
