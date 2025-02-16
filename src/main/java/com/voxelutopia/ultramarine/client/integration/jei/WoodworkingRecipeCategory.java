package com.voxelutopia.ultramarine.client.integration.jei;

import com.mojang.blaze3d.vertex.PoseStack;
import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.recipe.WoodworkingRecipe;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class WoodworkingRecipeCategory implements IRecipeCategory<WoodworkingRecipe> {


    public static final ResourceLocation UID = new ResourceLocation(Ultramarine.MOD_ID, "woodworking");

    public static final RecipeType<WoodworkingRecipe> WOODWORKING_RECIPE_TYPE =
            new RecipeType<>(UID, WoodworkingRecipe.class);

    public static final int WIDTH = 82;
    public static final int HEIGHT = 34;

    private final IDrawable background;
    private final IDrawable icon;
    private final Component localizedName;

    public WoodworkingRecipeCategory(IGuiHelper guiHelper) {
        background = guiHelper.createDrawable(UltramarinePlugin.JEI_GUI_VANILLA, 0, 220, WIDTH, HEIGHT);
        icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockRegistry.WOODWORKING_WORKBENCH.get()));
        localizedName = Component.translatable("gui.jei.category.woodworking");
    }

    @Override
    public Component getTitle() {
        return localizedName;
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public RecipeType<WoodworkingRecipe> getRecipeType() {
        return WOODWORKING_RECIPE_TYPE;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, WoodworkingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 9)
                .addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 61,  9)
                .addItemStack(recipe.getResultItem());
    }

    @Override
    public void draw(WoodworkingRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack stack, double mouseX, double mouseY) {
        IRecipeCategory.super.draw(recipe, recipeSlotsView, stack, mouseX, mouseY);
    }
}
