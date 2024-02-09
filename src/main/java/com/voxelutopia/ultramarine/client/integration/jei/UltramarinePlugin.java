package com.voxelutopia.ultramarine.client.integration.jei;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.recipe.ChiselTableRecipe;
import com.voxelutopia.ultramarine.data.recipe.CompositeSmeltingRecipe;
import com.voxelutopia.ultramarine.data.recipe.WoodworkingRecipe;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeTypeRegistry;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class UltramarinePlugin implements IModPlugin {

    public static final ResourceLocation JEI_GUI_VANILLA = new ResourceLocation("jei", "textures/gui/gui_vanilla.png");
    private static final Logger LOGGER = Ultramarine.getLogger();

    public UltramarinePlugin(){
        LOGGER.info("JEI Integration Loaded");
    }

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Ultramarine.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IJeiHelpers jeiHelpers = registration.getJeiHelpers();
        IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
        registration.addRecipeCategories(new WoodworkingRecipeCategory(guiHelper));
        registration.addRecipeCategories(new CompositeSmeltingRecipeCategory(guiHelper));
        registration.addRecipeCategories(new ChiselTableRecipeCategory(guiHelper));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        Objects.requireNonNull(Minecraft.getInstance().level);
        var recipeManager = Minecraft.getInstance().level.getRecipeManager();
        List<WoodworkingRecipe> woodworkingRecipes = recipeManager.getAllRecipesFor(RecipeTypeRegistry.WOODWORKING.get());
        registration.addRecipes(WoodworkingRecipeCategory.WOODWORKING_RECIPE_TYPE, woodworkingRecipes);
        List<CompositeSmeltingRecipe> compositeSmeltingRecipes = recipeManager.getAllRecipesFor(RecipeTypeRegistry.COMPOSITE_SMELTING.get());
        registration.addRecipes(CompositeSmeltingRecipeCategory.COMPOSITE_SMELTING_RECIPE_TYPE, compositeSmeltingRecipes);
        List<ChiselTableRecipe> chiselTableRecipes = recipeManager.getAllRecipesFor(RecipeTypeRegistry.CHISEL_TABLE.get());
        registration.addRecipes(ChiselTableRecipeCategory.CHISEL_TABLE_RECIPE_TYPE, chiselTableRecipes);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.WOODWORKING_WORKBENCH.get()), WoodworkingRecipeCategory.WOODWORKING_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.BRICK_KILN.get()), CompositeSmeltingRecipeCategory.COMPOSITE_SMELTING_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(BlockRegistry.CHISEL_TABLE.get()), ChiselTableRecipeCategory.CHISEL_TABLE_RECIPE_TYPE);
    }

}
