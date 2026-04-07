package com.voxelutopia.ultramarine.mixin;

import com.voxelutopia.ultramarine.data.recipe.WoodworkingRecipe;
import com.voxelutopia.ultramarine.data.recipe.WoodworkingRecipeAccess;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Optional;

@Mixin(RecipeManager.class)
public abstract class RecipeManagerMixin implements WoodworkingRecipeAccess {
    @Shadow
    private RecipeMap recipes;
    @Unique
    private SelectableRecipe.SingleInputSet<StonecutterRecipe> ultramarine$woodworkingRecipes = SelectableRecipe.SingleInputSet.empty();

    @Inject(method = "finalizeRecipeLoading", at = @At("TAIL"))
    private void ultramarine$appendWoodworkingRecipes(FeatureFlagSet enabledFlags, CallbackInfo ci) {
        ArrayList<SelectableRecipe.SingleInputEntry<StonecutterRecipe>> woodworking = new ArrayList<>();

        for (RecipeHolder<?> recipeHolder : this.recipes.values()) {
            if (!(recipeHolder.value() instanceof WoodworkingRecipe woodworkingRecipe)) {
                continue;
            }

            if (!woodworkingRecipe.getIngredient().items().allMatch(i -> i.value().isEnabled(enabledFlags))) {
                continue;
            }

            var resultTemplate = woodworkingRecipe.getResult();
            if (!resultTemplate.item().value().isEnabled(enabledFlags)) {
                continue;
            }
            SelectableRecipe.SingleInputEntry<StonecutterRecipe> entry =
                    new SelectableRecipe.SingleInputEntry<>(
                            woodworkingRecipe.getIngredient(),
                            new SelectableRecipe<>(new SlotDisplay.ItemStackSlotDisplay(resultTemplate), Optional.empty())
                    );

            woodworking.add(entry);
        }
        this.ultramarine$woodworkingRecipes = new SelectableRecipe.SingleInputSet<>(woodworking);
    }

    @Override
    public SelectableRecipe.SingleInputSet<StonecutterRecipe> ultramarine$woodworkingRecipes() {
        return this.ultramarine$woodworkingRecipes;
    }

    @Override
    public void ultramarine$setWoodworkingRecipes(SelectableRecipe.SingleInputSet<StonecutterRecipe> recipes) {
        this.ultramarine$woodworkingRecipes = recipes;
    }
}
