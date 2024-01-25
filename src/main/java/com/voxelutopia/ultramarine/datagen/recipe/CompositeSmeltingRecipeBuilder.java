package com.voxelutopia.ultramarine.datagen.recipe;

import com.google.gson.JsonObject;
import com.voxelutopia.ultramarine.data.recipe.CompositeSmeltingRecipe;
import com.voxelutopia.ultramarine.data.registry.RecipeSerializerRegistry;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class CompositeSmeltingRecipeBuilder implements RecipeBuilder {

    private final Item result;
    private final Ingredient primaryIngredient;
    private final Ingredient secondaryIngredient;
    private final float experience;
    private final int cookingTime;
    private final Advancement.Builder advancementBuilder = Advancement.Builder.advancement();
    @Nullable private String group;
    private static final RecipeSerializer<CompositeSmeltingRecipe> SERIALIZER = RecipeSerializerRegistry.COMPOSITE_SMELTING_SERIALIZER.get();

    public CompositeSmeltingRecipeBuilder(ItemLike result, Ingredient primaryIngredient, Ingredient secondaryIngredient, float experience, int cookingTime) {
        this.result = result.asItem();
        this.primaryIngredient = primaryIngredient;
        this.secondaryIngredient = secondaryIngredient;
        this.experience = experience;
        this.cookingTime = cookingTime;
    }

    public static CompositeSmeltingRecipeBuilder compositeSmelting(Ingredient primaryIngredient, Ingredient secondaryIngredient, ItemLike pResult, float pExperience, int pCookingTime) {
        return new CompositeSmeltingRecipeBuilder(pResult, primaryIngredient, secondaryIngredient, pExperience, pCookingTime);
    }

    @Override
    public RecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancementBuilder.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String pGroupName) {
        this.group = pGroupName;
        return this;
    }

    @Override
    public Item getResult() {
        return this.result;
    }

    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
        this.advancementBuilder.parent(new ResourceLocation("recipes/root"))
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId)).rewards(AdvancementRewards.Builder.recipe(pRecipeId)).requirements(RequirementsStrategy.OR);
        pFinishedRecipeConsumer.accept(new Result(pRecipeId, this.group == null ? "" : this.group,
                this.primaryIngredient, this.secondaryIngredient, this.result, this.experience, this.cookingTime, this.advancementBuilder,
                new ResourceLocation(pRecipeId.getNamespace(), "recipes/" + this.result.getItemCategory().getRecipeFolderName() + "/" + pRecipeId.getPath())));
    }

    private static class Result implements FinishedRecipe{
        private final ResourceLocation id;
        private final String group;
        private final Ingredient primaryIngredient;
        private final Ingredient secondaryIngredient;
        private final Item result;
        private final float experience;
        private final int cookingTime;
        private final Advancement.Builder advancementBuilder;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation pId, String pGroup, Ingredient primaryIngredient, Ingredient secondaryIngredient, Item pResult,
                      float pExperience, int pCookingTime, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId) {
            this.id = pId;
            this.group = pGroup;
            this.primaryIngredient = primaryIngredient;
            this.secondaryIngredient = secondaryIngredient;
            this.result = pResult;
            this.experience = pExperience;
            this.cookingTime = pCookingTime;
            this.advancementBuilder = pAdvancement;
            this.advancementId = pAdvancementId;
        }

        @Override
        public void serializeRecipeData(JsonObject pJson) {
            if (!this.group.isEmpty()) {
                pJson.addProperty("group", this.group);
            }
            pJson.add("primary_ingredient", this.primaryIngredient.toJson());
            pJson.add("secondary_ingredient", this.secondaryIngredient.toJson());
            pJson.addProperty("result", Registry.ITEM.getKey(this.result).toString());
            pJson.addProperty("experience", this.experience);
            pJson.addProperty("cookingtime", this.cookingTime);
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return CompositeSmeltingRecipeBuilder.SERIALIZER;
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return this.advancementBuilder.serializeToJson();
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
