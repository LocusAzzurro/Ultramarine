package com.voxelutopia.ultramarine.datagen.recipe;

import com.voxelutopia.ultramarine.data.recipe.ChiselTableRecipe;
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
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class ChiselTableRecipeBuilder implements RecipeBuilder {

    private final Item result;
    private final Ingredient material;
    private final Ingredient template;
    protected final List<Ingredient> colors;
    private final Advancement.Builder advancementBuilder = Advancement.Builder.advancement();
    @Nullable
    private String group;

    public ChiselTableRecipeBuilder(ItemLike result, Ingredient material, Ingredient template, List<Ingredient> colors) {
        this.result = result.asItem();
        this.material = material;
        this.template = template;
        this.colors = colors;
    }

    public static ChiselTableRecipeBuilder chiselTableRecipe(Ingredient material, Ingredient template, Ingredient[] colors, ItemLike result) {
        List<Ingredient> colorList = Arrays.stream(colors).filter(i -> !i.isEmpty()).toList();
        return new ChiselTableRecipeBuilder(result, material, template, colorList);
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
        pFinishedRecipeConsumer.accept(pRecipeId, new ChiselTableRecipe(this.group, this.material, this.template, this.colors, this.result.getDefaultInstance()), builder.build(ResourceLocation.fromNamespaceAndPath(pRecipeId.getNamespace(), "recipes/" + pRecipeId.getPath())));
    }
}
