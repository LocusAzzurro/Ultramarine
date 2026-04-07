package com.voxelutopia.ultramarine.datagen.recipe;

import com.voxelutopia.ultramarine.data.recipe.CompositeSmeltingRecipe;
import com.voxelutopia.ultramarine.data.registry.RecipeSerializerRegistry;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.criterion.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CompositeSmeltingRecipeBuilder implements RecipeBuilder {

    private final ItemStackTemplate result;
    private final Ingredient primaryIngredient;
    private final Ingredient secondaryIngredient;
    private final float experience;
    private final int cookingTime;
    private final Advancement.Builder advancementBuilder = Advancement.Builder.advancement();
    @Nullable
    private String group;
    private static final RecipeSerializer<CompositeSmeltingRecipe> SERIALIZER = RecipeSerializerRegistry.COMPOSITE_SMELTING_SERIALIZER.get();

    public CompositeSmeltingRecipeBuilder(ItemLike result, Ingredient primaryIngredient, Ingredient secondaryIngredient, float experience, int cookingTime) {
        this.result = new ItemStackTemplate(result.asItem());
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
    public ResourceKey<Recipe<?>> defaultId() {
        return RecipeBuilder.getDefaultRecipeId(this.result);
    }

    @Override
    public void save(RecipeOutput output, @NotNull ResourceKey<Recipe<?>> id) {
        Advancement.Builder builder = output.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                .rewards(AdvancementRewards.Builder.recipe(id))
                .requirements(AdvancementRequirements.Strategy.OR);
        Identifier recipeId = id.identifier();
        String safeGroup = this.group == null ? "" : this.group;
        output.accept(
                id,
                new CompositeSmeltingRecipe(safeGroup, this.primaryIngredient, this.secondaryIngredient, this.result, this.experience, this.cookingTime),
                builder.build(Identifier.fromNamespaceAndPath(recipeId.getNamespace(), "recipes/" + recipeId.getPath()))
        );
    }
}
