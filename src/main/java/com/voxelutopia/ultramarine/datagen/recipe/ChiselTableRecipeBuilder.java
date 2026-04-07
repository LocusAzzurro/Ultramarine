package com.voxelutopia.ultramarine.datagen.recipe;

import com.voxelutopia.ultramarine.data.recipe.ChiselTableRecipe;
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
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ChiselTableRecipeBuilder implements RecipeBuilder {

    private final ItemStackTemplate result;
    private final Ingredient material;
    private final Ingredient template;
    protected final List<Ingredient> colors;
    private final Advancement.Builder advancementBuilder = Advancement.Builder.advancement();
    @Nullable
    private String group;

    public ChiselTableRecipeBuilder(ItemLike result, Ingredient material, Ingredient template, List<Ingredient> colors) {
        this.result = new ItemStackTemplate(result.asItem());
        this.material = material;
        this.template = template;
        this.colors = colors;
    }

    public static ChiselTableRecipeBuilder chiselTableRecipe(Ingredient material, Ingredient template, Ingredient[] colors, ItemLike result) {
        // Avoid calling Ingredient#isEmpty() during datagen because tag-based ingredients may be represented by
        // unbound holder sets when the tag isn't available in the lookup provider.
        List<Ingredient> colorList = Arrays.stream(colors).filter(Objects::nonNull).toList();
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
                new ChiselTableRecipe(safeGroup, this.material, this.template, this.colors, this.result),
                builder.build(Identifier.fromNamespaceAndPath(recipeId.getNamespace(), "recipes/" + recipeId.getPath()))
        );
    }
}
