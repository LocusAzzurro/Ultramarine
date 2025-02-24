package com.voxelutopia.ultramarine.client.integration.jei;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class TravellingMerchantCategory extends AbstractRecipeCategory<TravellingMerchantWrapper>  implements IRecipeCategory<TravellingMerchantWrapper> {

    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(Ultramarine.MOD_ID, "custom_wandering_trader");

    public static final RecipeType<TravellingMerchantWrapper> CUSTOM_WANDERING_TRADER_WRAPPER_RECIPE_TYPE =
            new RecipeType<>(UID, TravellingMerchantWrapper.class);

    public static final int WIDTH = 82;
    public static final int HEIGHT = 34;

    public TravellingMerchantCategory(IGuiHelper guiHelper) {
        super(CUSTOM_WANDERING_TRADER_WRAPPER_RECIPE_TYPE, Component.translatable("gui.jei.category.travelling_merchant"), guiHelper.createDrawableItemLike(BlockRegistry.TEAHOUSE_FLAG.get()), WIDTH, HEIGHT);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, TravellingMerchantWrapper recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 9).addItemStack(recipe.getInput());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 61, 9).addItemStack(recipe.getOutput());
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, TravellingMerchantWrapper recipe, IFocusGroup focuses) {
        builder.addRecipeArrow().setPosition(26, 9);
    }

    @Override
    public void draw(TravellingMerchantWrapper recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics stack, double mouseX, double mouseY) {
        super.draw(recipe, recipeSlotsView, stack, mouseX, mouseY);
    }
}
