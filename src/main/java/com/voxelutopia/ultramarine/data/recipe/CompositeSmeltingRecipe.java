package com.voxelutopia.ultramarine.data.recipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.registry.RecipeSerializerRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeTypeRegistry;
import com.voxelutopia.ultramarine.world.block.entity.BrickKilnBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class CompositeSmeltingRecipe implements Recipe<Container> {

    protected final ResourceLocation id;
    protected final String group;
    protected final Ingredient primaryIngredient;
    protected final Ingredient secondaryIngredient;
    protected final ItemStack result;
    protected final float experience;
    protected final int cookingTime;

    public CompositeSmeltingRecipe(ResourceLocation pId, String pGroup, Ingredient primaryIngredient, Ingredient secondaryIngredient, ItemStack pResult, float pExperience, int pCookingTime) {
        this.id = pId;
        this.group = pGroup;
        this.primaryIngredient = primaryIngredient;
        this.secondaryIngredient = secondaryIngredient;
        this.result = pResult;
        this.experience = pExperience;
        this.cookingTime = pCookingTime;
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        return this.primaryIngredient.test(pContainer.getItem(BrickKilnBlockEntity.SLOT_INPUT_PRIMARY)) &&
                this.secondaryIngredient.test(pContainer.getItem(BrickKilnBlockEntity.SLOT_INPUT_SECONDARY));
    }

    public boolean partialMatch(Container pContainer, Level pLevel) {
        return primaryIngredient.or(secondaryIngredient).test(pContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(Container pContainer) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    public Ingredient getPrimaryIngredient() {
        return primaryIngredient;
    }

    public Ingredient getSecondaryIngredient() {
        return secondaryIngredient;
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
    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializerRegistry.COMPOSITE_SMELTING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeTypeRegistry.COMPOSITE_SMELTING.get();
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public float getExp(){
        return experience;
    }

    public static class Serializer implements RecipeSerializer<CompositeSmeltingRecipe> {

        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Ultramarine.MOD_ID,"composite_smelting");
        private static final int defaultCookingTime = 200;

        protected Serializer() {}


        @Override
        public CompositeSmeltingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
            if (!pJson.has("result"))
                throw new JsonSyntaxException("Missing result, expected to find a string or object");

            String group = GsonHelper.getAsString(pJson, "group", "");
            Ingredient primaryIngredient = parseIngredient(pJson, "primary_ingredient");
            Ingredient secondaryIngredient = parseIngredient(pJson, "secondary_ingredient");

            ItemStack result;
            if (pJson.get("result").isJsonObject()) result = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "result"));
            else {
                String s1 = GsonHelper.getAsString(pJson, "result");
                ResourceLocation resourcelocation = new ResourceLocation(s1);
                result = new ItemStack(ForgeRegistries.ITEMS.getHolder(resourcelocation).orElseThrow(() -> new IllegalStateException("Item: " + s1 + " does not exist")));
            }
            float exp = GsonHelper.getAsFloat(pJson, "experience", 0.0F);
            int cookingTime = GsonHelper.getAsInt(pJson, "cookingtime", defaultCookingTime);
            return new CompositeSmeltingRecipe(pRecipeId, group, primaryIngredient, secondaryIngredient, result, exp, cookingTime);
        }

        @Nullable
        @Override
        public CompositeSmeltingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            String group = pBuffer.readUtf();
            Ingredient primary = Ingredient.fromNetwork(pBuffer);
            Ingredient secondary = Ingredient.fromNetwork(pBuffer);
            ItemStack result = pBuffer.readItem();
            float exp = pBuffer.readFloat();
            int cookingTime = pBuffer.readVarInt();
            return new CompositeSmeltingRecipe(pRecipeId, group, primary, secondary, result, exp, cookingTime);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, CompositeSmeltingRecipe pRecipe) {
            pBuffer.writeUtf(pRecipe.group);
            pRecipe.primaryIngredient.toNetwork(pBuffer);
            pRecipe.secondaryIngredient.toNetwork(pBuffer);
            pBuffer.writeItem(pRecipe.result);
            pBuffer.writeFloat(pRecipe.experience);
            pBuffer.writeVarInt(pRecipe.cookingTime);
        }

        private static Ingredient parseIngredient(JsonObject json, String member){
            JsonElement ingredientRaw = GsonHelper.isArrayNode(json, member) ? GsonHelper.getAsJsonArray(json, member) : GsonHelper.getAsJsonObject(json, member);
            return Ingredient.fromJson(ingredientRaw);
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
