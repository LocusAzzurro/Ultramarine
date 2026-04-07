package com.voxelutopia.ultramarine.mixin;

import com.voxelutopia.ultramarine.data.recipe.WoodworkingRecipeAccess;
import net.minecraft.client.multiplayer.ClientRecipeContainer;
import net.minecraft.world.item.crafting.SelectableRecipe;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ClientRecipeContainer.class)
public abstract class ClientRecipeContainerMixin implements WoodworkingRecipeAccess {
    @Unique
    private SelectableRecipe.SingleInputSet<StonecutterRecipe> ultramarine$woodworkingRecipes = SelectableRecipe.SingleInputSet.empty();

    @Override
    public SelectableRecipe.SingleInputSet<StonecutterRecipe> ultramarine$woodworkingRecipes() {
        return this.ultramarine$woodworkingRecipes;
    }

    @Override
    public void ultramarine$setWoodworkingRecipes(SelectableRecipe.SingleInputSet<StonecutterRecipe> recipes) {
        this.ultramarine$woodworkingRecipes = recipes;
    }
}
