package com.voxelutopia.ultramarine.client.integration.jei;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.recipe.WoodworkingRecipe;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.library.util.RecipeUtil;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class WoodworkingRecipeCategory extends AbstractRecipeCategory<WoodworkingRecipe> implements IRecipeCategory<WoodworkingRecipe>{


    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(Ultramarine.MOD_ID, "woodworking");

    public static final RecipeType<WoodworkingRecipe> WOODWORKING_RECIPE_TYPE =
            new RecipeType<>(UID, WoodworkingRecipe.class);

    public static final int WIDTH = 82;
    public static final int HEIGHT = 34;

    public WoodworkingRecipeCategory(IGuiHelper guiHelper) {
        super(WOODWORKING_RECIPE_TYPE, Component.translatable("gui.jei.category.woodworking"), guiHelper.createDrawableItemLike(BlockRegistry.WOODWORKING_WORKBENCH.get()), WIDTH, HEIGHT);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, WoodworkingRecipe recipe, IFocusGroup focuses) {
        builder.addInputSlot(1, 9).setStandardSlotBackground().addIngredients(recipe.getIngredients().get(0));
        builder.addOutputSlot(61, 9).setOutputSlotBackground().addItemStack(RecipeUtil.getResultItem(recipe));
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, WoodworkingRecipe recipe, IFocusGroup focuses) {
        builder.addRecipeArrow().setPosition(26, 9);
    }

    @Override
    public void draw(WoodworkingRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics stack, double mouseX, double mouseY) {
        super.draw(recipe, recipeSlotsView, stack, mouseX, mouseY);
    }
}
