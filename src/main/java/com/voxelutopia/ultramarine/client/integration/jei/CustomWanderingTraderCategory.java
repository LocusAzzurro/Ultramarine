package com.voxelutopia.ultramarine.client.integration.jei;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.recipe.WoodworkingRecipe;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class CustomWanderingTraderCategory implements IRecipeCategory<CustomWanderingTraderWrapper> {

    public static final ResourceLocation UID = new ResourceLocation(Ultramarine.MOD_ID, "custom_wandering_trader");

    public static final RecipeType<CustomWanderingTraderWrapper> CUSTOM_WANDERING_TRADER_WRAPPER_RECIPE_TYPE =
            new RecipeType<>(UID, CustomWanderingTraderWrapper.class);

    public static final int WIDTH = 82;
    public static final int HEIGHT = 34;

    private final IDrawable background;
    private final IDrawable icon;
    private final Component localizedName;

    public CustomWanderingTraderCategory(IGuiHelper guiHelper) {
        background = guiHelper.createDrawable(UltramarinePlugin.JEI_GUI_VANILLA, 0, 220, WIDTH, HEIGHT);
        icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockRegistry.TEAHOUSE_FLAG.get()));
        localizedName = new TranslatableComponent("gui.jei.category.custom_wandering_trader");
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

    @SuppressWarnings("removal")
    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @SuppressWarnings("removal")
    @Override
    public Class<? extends CustomWanderingTraderWrapper> getRecipeClass() {
        return CustomWanderingTraderWrapper.class;
    }

    @Override
    public RecipeType<CustomWanderingTraderWrapper> getRecipeType() {
        return CUSTOM_WANDERING_TRADER_WRAPPER_RECIPE_TYPE;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CustomWanderingTraderWrapper recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 9).addItemStack(recipe.getInput());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 61, 9).addItemStack(recipe.getOutput());
    }
}
