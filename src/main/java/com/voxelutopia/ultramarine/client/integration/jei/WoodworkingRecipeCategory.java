package com.voxelutopia.ultramarine.client.integration.jei;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.recipe.WoodworkingRecipe;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.jetbrains.annotations.NotNull;

public class WoodworkingRecipeCategory extends AbstractRecipeCategory<WoodworkingRecipe> {


    public static final Identifier UID = Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "woodworking");

    public static final IRecipeType<WoodworkingRecipe> WOODWORKING_RECIPE_TYPE =
            IRecipeType.create(UID, WoodworkingRecipe.class);

    public static final int WIDTH = 82;
    public static final int HEIGHT = 34;

    public WoodworkingRecipeCategory(IGuiHelper guiHelper) {
        super(WOODWORKING_RECIPE_TYPE, Component.translatable("gui.jei.category.woodworking"), guiHelper.createDrawableItemLike(BlockRegistry.WOODWORKING_WORKBENCH.get()), WIDTH, HEIGHT);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, WoodworkingRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addInputSlot(1, 9).setStandardSlotBackground().add(recipe.getIngredient());
        builder.addOutputSlot(61, 9)
                .setOutputSlotBackground()
                .add(recipe.getResultItem());
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, @NotNull WoodworkingRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addRecipeArrow().setPosition(26, 9);
    }

    @Override
    public void draw(@NotNull WoodworkingRecipe recipe, @NotNull IRecipeSlotsView recipeSlotsView, @NotNull GuiGraphicsExtractor stack, double mouseX, double mouseY) {
        super.draw(recipe, recipeSlotsView, stack, mouseX, mouseY);
    }
}
