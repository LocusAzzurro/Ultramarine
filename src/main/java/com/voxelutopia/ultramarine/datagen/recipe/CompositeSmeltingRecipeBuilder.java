package com.voxelutopia.ultramarine.datagen.recipe;

import com.voxelutopia.ultramarine.data.recipe.CompositeSmeltingRecipe;
import com.voxelutopia.ultramarine.data.registry.RecipeSerializerRegistry;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CompositeSmeltingRecipeBuilder implements RecipeBuilder {

    private final Item result;
    private final Ingredient primaryIngredient;
    private final Ingredient secondaryIngredient;
    private final float experience;
    private final int cookingTime;
    private final Advancement.Builder advancementBuilder = Advancement.Builder.advancement();
    @Nullable
    private String group;
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
    public @NotNull RecipeBuilder unlockedBy(@NotNull String pCriterionName, @NotNull Criterion<?> pCriterionTrigger) {
        this.advancementBuilder.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public @NotNull RecipeBuilder group(@Nullable String pGroupName) {
        this.group = pGroupName;
        return this;
    }

    @Override
    public @NotNull Item getResult() {
        return this.result;
    }

    @Override
    public void save(RecipeOutput pFinishedRecipeConsumer, @NotNull ResourceLocation pRecipeId) {
        Advancement.Builder builder = pFinishedRecipeConsumer.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId))
                .rewards(AdvancementRewards.Builder.recipe(pRecipeId))
                .requirements(AdvancementRequirements.Strategy.OR);
        pFinishedRecipeConsumer.accept(pRecipeId, new CompositeSmeltingRecipe(this.group, this.primaryIngredient, this.secondaryIngredient, this.result.getDefaultInstance(), this.experience, this.cookingTime), builder.build(ResourceLocation.fromNamespaceAndPath(pRecipeId.getNamespace(), "recipes/" + pRecipeId.getPath())));
    }
}
