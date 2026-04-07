package com.voxelutopia.ultramarine.mixin;

import com.voxelutopia.ultramarine.data.recipe.WoodworkingRecipeAccess;
import net.minecraft.world.item.crafting.RecipeAccess;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(RecipeAccess.class)
public interface RecipeAccessMixin extends WoodworkingRecipeAccess {
}
