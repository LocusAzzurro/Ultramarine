package com.voxelutopia.ultramarine.client.integration.jei;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.recipe.ChiselTableRecipe;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

import static mezz.jei.api.recipe.RecipeIngredientRole.INPUT;
import static mezz.jei.api.recipe.RecipeIngredientRole.OUTPUT;

public class ChiselTableRecipeCategory implements IRecipeCategory<ChiselTableRecipe> {

    public static final Identifier UID = Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "chisel_table");

    public static final IRecipeType<ChiselTableRecipe> CHISEL_TABLE_RECIPE_TYPE =
            IRecipeType.create(UID, ChiselTableRecipe.class);

    public static final Identifier TEXTURE_GUI = Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "textures/gui/chisel_table.png");

    private final IDrawable background;
    private final IDrawable icon;
    private final Component localizedName;

    public ChiselTableRecipeCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createDrawable(TEXTURE_GUI, 25, 24, 126, 45);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockRegistry.CHISEL_TABLE.get()));
        this.localizedName = Component.translatable("gui.jei.category.chisel_table");
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ChiselTableRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(INPUT, 1, 1)
                .add(recipe.material());

        builder.addSlot(INPUT, 28, 1)
                .add(recipe.template());

        List<Ingredient> colors = recipe.colors();

        for (int i = 0; i < colors.size(); i++) {
            builder.addSlot(INPUT, 1 + 18 * i, 28).add(colors.get(i));
        }

        builder.addSlot(OUTPUT, 105, 10)
                .add(recipe.getResultItem());
    }

    @Override
    public void draw(ChiselTableRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphicsExtractor guiGraphics, double mouseX, double mouseY) {
        background.draw(guiGraphics);
    }

    @Override
    public IRecipeType<ChiselTableRecipe> getRecipeType() {
        return CHISEL_TABLE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return localizedName;
    }

    @Override
    public int getWidth() {
        return background.getWidth();
    }

    @Override
    public int getHeight() {
        return background.getHeight();
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

}
