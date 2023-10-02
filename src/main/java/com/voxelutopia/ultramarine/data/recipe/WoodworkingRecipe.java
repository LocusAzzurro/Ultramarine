package com.voxelutopia.ultramarine.data.recipe;

import com.google.gson.JsonObject;
import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.registry.RecipeSerializerRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeTypeRegistry;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.SingleItemRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class WoodworkingRecipe extends SingleItemRecipe {

    protected final Ingredient ingredient;
    protected final ItemStack result;
    protected final ResourceLocation id;
    protected final String group;

    public WoodworkingRecipe(ResourceLocation pId, String pGroup, Ingredient pIngredient, ItemStack pResult) {
        super(RecipeTypeRegistry.WOODWORKING, RecipeSerializerRegistry.WOODWORKING_SERIALIZER.get(), pId, pGroup, pIngredient, pResult);
        this.id = pId;
        this.group = pGroup;
        this.ingredient = pIngredient;
        this.result = pResult;
    }

    @Override
    public boolean matches(IInventory pContainer, World pLevel) {
        return ingredient.test(pContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(IInventory pContainer) {
        return result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
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
    public IRecipeType<?> getType() {
        return RecipeTypeRegistry.WOODWORKING;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return RecipeSerializerRegistry.WOODWORKING_SERIALIZER.get();
    }


    public static class Serializer implements IRecipeSerializer<WoodworkingRecipe> {

        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Ultramarine.MOD_ID, "woodworking");

        protected Serializer() {
        }

        public WoodworkingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
            String s = JSONUtils.getAsString(pJson, "group", "");
            Ingredient ingredient;
            if (JSONUtils.isArrayNode(pJson, "ingredient")) {
                ingredient = Ingredient.fromJson(JSONUtils.getAsJsonArray(pJson, "ingredient"));
            } else {
                ingredient = Ingredient.fromJson(JSONUtils.getAsJsonObject(pJson, "ingredient"));
            }

            String s1 = JSONUtils.getAsString(pJson, "result");
            int i = JSONUtils.getAsInt(pJson, "count");
            ItemStack itemstack = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(s1)), i);
            return new WoodworkingRecipe(pRecipeId, s, ingredient, itemstack);
        }

        public WoodworkingRecipe fromNetwork(ResourceLocation pRecipeId, PacketBuffer pBuffer) {
            String s = pBuffer.readUtf();
            Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
            ItemStack itemstack = pBuffer.readItem();
            return new WoodworkingRecipe(pRecipeId, s, ingredient, itemstack);
        }

        public void toNetwork(PacketBuffer pBuffer, WoodworkingRecipe pRecipe) {
            pBuffer.writeUtf(pRecipe.group);
            pRecipe.ingredient.toNetwork(pBuffer);
            pBuffer.writeItem(pRecipe.result);
        }

        @Override
        public IRecipeSerializer<?> setRegistryName(ResourceLocation name) {
            return INSTANCE;
        }

        @Nullable
        @Override
        public ResourceLocation getRegistryName() {
            return ID;
        }

        @Override
        public Class<IRecipeSerializer<?>> getRegistryType() {
            return Serializer.castClass(IRecipeSerializer.class);
        }

        @SuppressWarnings("unchecked")
        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>) cls;
        }

    }

}
