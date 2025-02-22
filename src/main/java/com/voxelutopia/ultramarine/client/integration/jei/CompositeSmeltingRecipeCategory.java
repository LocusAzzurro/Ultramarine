package com.voxelutopia.ultramarine.client.integration.jei;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.mojang.blaze3d.vertex.PoseStack;
import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.recipe.CompositeSmeltingRecipe;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.library.util.RecipeUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import static mezz.jei.api.recipe.RecipeIngredientRole.INPUT;
import static mezz.jei.api.recipe.RecipeIngredientRole.OUTPUT;

public class CompositeSmeltingRecipeCategory implements IRecipeCategory<CompositeSmeltingRecipe> {

    public static final ResourceLocation UID = new ResourceLocation(Ultramarine.MOD_ID, "composite_smelting");

    public static final RecipeType<CompositeSmeltingRecipe> COMPOSITE_SMELTING_RECIPE_TYPE =
            new RecipeType<>(UID, CompositeSmeltingRecipe.class);

    public static final ResourceLocation TEXTURE_GUI = new ResourceLocation(Ultramarine.MOD_ID, "textures/gui/brick_kiln.png");

    private final IDrawable background;
    private final int regularCookTime;
    private final IDrawable icon;
    private final Component localizedName;
    private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;
    protected final IDrawableStatic staticFlame;
    protected final IDrawableAnimated animatedFlame;

    public CompositeSmeltingRecipeCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createDrawable(TEXTURE_GUI, 45, 16, 92, 54);
        this.regularCookTime = 200;
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockRegistry.BRICK_KILN.get()));
        this.localizedName = Component.translatable("gui.jei.category.composite_smelting");
        this.cachedArrows = CacheBuilder.newBuilder()
                .maximumSize(25)
                .build(new CacheLoader<>() {
                    @Override
                    public IDrawableAnimated load(Integer cookTime) {
                        return guiHelper.drawableBuilder(UltramarinePlugin.JEI_GUI_VANILLA, 82, 128, 24, 17)
                                .buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
                    }
                });
        this.staticFlame = guiHelper.createDrawable(UltramarinePlugin.JEI_GUI_VANILLA, 82, 114, 14, 14);
        this.animatedFlame = guiHelper.createAnimatedDrawable(staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);
    }

    protected IDrawableAnimated getArrow(CompositeSmeltingRecipe recipe) {
        int cookTime = recipe.getCookingTime();
        if (cookTime <= 0) {
            cookTime = regularCookTime;
        }
        return this.cachedArrows.getUnchecked(cookTime);
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
    public void draw(CompositeSmeltingRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack poseStack, double mouseX, double mouseY) {
        animatedFlame.draw(poseStack, 11, 20);

        IDrawableAnimated arrow = getArrow(recipe);
        arrow.draw(poseStack, 34, 18);

        drawExperience(recipe, poseStack, 0);
        drawCookTime(recipe, poseStack, 45);
    }

    protected void drawExperience(CompositeSmeltingRecipe recipe, PoseStack poseStack, int y) {
        float experience = recipe.getExp();
        if (experience > 0) {
            var experienceString = Component.translatable("gui.jei.category.smelting.experience", experience);
            Minecraft minecraft = Minecraft.getInstance();
            Font fontRenderer = minecraft.font;
            int stringWidth = fontRenderer.width(experienceString);
            fontRenderer.draw(poseStack, experienceString, background.getWidth() - stringWidth, y, 0xFF808080);
        }
    }

    protected void drawCookTime(CompositeSmeltingRecipe recipe, PoseStack poseStack, int y) {
        int cookTime = recipe.getCookingTime();
        if (cookTime > 0) {
            int cookTimeSeconds = cookTime / 20;
            var timeString = Component.translatable("gui.jei.category.smelting.time.seconds", cookTimeSeconds);
            Minecraft minecraft = Minecraft.getInstance();
            Font fontRenderer = minecraft.font;
            int stringWidth = fontRenderer.width(timeString);
            fontRenderer.draw(poseStack, timeString, background.getWidth() - stringWidth, y, 0xFF808080);
        }
    }

    @Override
    public Component getTitle() {
        return localizedName;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CompositeSmeltingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(INPUT, 1, 1)
                .addIngredients(recipe.getPrimaryIngredient());

        builder.addSlot(INPUT, 21, 1)
                .addIngredients(recipe.getSecondaryIngredient());

        builder.addSlot(OUTPUT, 71, 19)
                .addItemStack(RecipeUtil.getResultItem(recipe));
    }

    @Override
    public RecipeType<CompositeSmeltingRecipe> getRecipeType() {
        return COMPOSITE_SMELTING_RECIPE_TYPE;
    }
}
