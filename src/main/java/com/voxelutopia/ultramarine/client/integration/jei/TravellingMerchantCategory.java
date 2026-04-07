package com.voxelutopia.ultramarine.client.integration.jei;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.jetbrains.annotations.NotNull;

public class TravellingMerchantCategory extends AbstractRecipeCategory<TravellingMerchantWrapper> {

    public static final Identifier UID = Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "custom_wandering_trader");

    public static final IRecipeType<TravellingMerchantWrapper> CUSTOM_WANDERING_TRADER_WRAPPER_RECIPE_TYPE =
            IRecipeType.create(UID, TravellingMerchantWrapper.class);

    public static final int WIDTH = 82;
    public static final int HEIGHT = 34;

    public TravellingMerchantCategory(IGuiHelper guiHelper) {
        super(CUSTOM_WANDERING_TRADER_WRAPPER_RECIPE_TYPE, Component.translatable("gui.jei.category.travelling_merchant"), guiHelper.createDrawableItemLike(BlockRegistry.TEAHOUSE_FLAG.get()), WIDTH, HEIGHT);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, TravellingMerchantWrapper recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 9).add(recipe.getInput());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 61, 9).add(recipe.getOutput());
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, @NotNull TravellingMerchantWrapper recipe, @NotNull IFocusGroup focuses) {
        builder.addRecipeArrow().setPosition(26, 9);
    }

    @Override
    public void draw(@NotNull TravellingMerchantWrapper recipe, @NotNull IRecipeSlotsView recipeSlotsView, @NotNull GuiGraphicsExtractor stack, double mouseX, double mouseY) {
        super.draw(recipe, recipeSlotsView, stack, mouseX, mouseY);
    }
}
