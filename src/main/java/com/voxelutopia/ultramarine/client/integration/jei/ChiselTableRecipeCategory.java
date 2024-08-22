package com.voxelutopia.ultramarine.client.integration.jei;

import com.mojang.blaze3d.vertex.PoseStack;
import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.recipe.ChiselTableRecipe;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

import static mezz.jei.api.recipe.RecipeIngredientRole.INPUT;
import static mezz.jei.api.recipe.RecipeIngredientRole.OUTPUT;

public class ChiselTableRecipeCategory implements IRecipeCategory<ChiselTableRecipe> {

    public static final ResourceLocation UID = new ResourceLocation(Ultramarine.MOD_ID, "chisel_table");

    public static final RecipeType<ChiselTableRecipe> CHISEL_TABLE_RECIPE_TYPE =
            new RecipeType<>(UID, ChiselTableRecipe.class);

    public static final ResourceLocation TEXTURE_GUI = new ResourceLocation(Ultramarine.MOD_ID, "textures/gui/chisel_table.png");

    private final IDrawable background;
    private final IDrawable icon;
    private final Component localizedName;

    public ChiselTableRecipeCategory(IGuiHelper guiHelper){
        this.background = guiHelper.createDrawable(TEXTURE_GUI, 25, 24, 126, 45);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockRegistry.CHISEL_TABLE.get()));
        this.localizedName = new TranslatableComponent("gui.jei.category.chisel_table");
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ChiselTableRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(INPUT, 1, 1)
                .addIngredients(recipe.getMaterial());

        builder.addSlot(INPUT, 28, 1)
                .addIngredients(recipe.getTemplate());

        List<Ingredient> colors = recipe.getColors();

        for (int i = 0; i < colors.size(); i++){
            builder.addSlot(INPUT, 1 + 18 * i, 28).addIngredients(colors.get(i));
        }

        builder.addSlot(OUTPUT, 105, 10)
                .addItemStack(recipe.getResultItem());
    }

    @Override
    public void draw(ChiselTableRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack stack, double mouseX, double mouseY) {
        IRecipeCategory.super.draw(recipe, recipeSlotsView, stack, mouseX, mouseY);
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
    public Class<? extends ChiselTableRecipe> getRecipeClass() {
        return ChiselTableRecipe.class;
    }
}
