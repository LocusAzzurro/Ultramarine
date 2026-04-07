package com.voxelutopia.ultramarine.client.integration.jei;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.client.screen.BrickKilnScreen;
import com.voxelutopia.ultramarine.client.screen.ChiselTableScreen;
import com.voxelutopia.ultramarine.data.recipe.ChiselTableRecipe;
import com.voxelutopia.ultramarine.data.recipe.CompositeSmeltingRecipe;
import com.voxelutopia.ultramarine.data.recipe.WoodworkingRecipe;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeTypeRegistry;
import com.voxelutopia.ultramarine.world.entity.TravellingMerchant;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;

import java.util.List;

@JeiPlugin
public class UltramarineJEIPlugin implements IModPlugin {

    public static final Identifier JEI_GUI_VANILLA = Identifier.fromNamespaceAndPath("jei", "textures/gui/gui_vanilla.png");
    private static final Logger LOGGER = Ultramarine.getLogger();

    public UltramarineJEIPlugin() {
        LOGGER.info("JEI Integration Loaded");
    }

    @Override
    public Identifier getPluginUid() {
        return Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(BrickKilnScreen.class, 78, 32, 28, 23, CompositeSmeltingRecipeCategory.COMPOSITE_SMELTING_RECIPE_TYPE);
        registration.addRecipeClickArea(ChiselTableScreen.class, 79, 24, 18, 30, ChiselTableRecipeCategory.CHISEL_TABLE_RECIPE_TYPE);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IJeiHelpers jeiHelpers = registration.getJeiHelpers();
        IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
        registration.addRecipeCategories(new WoodworkingRecipeCategory(guiHelper));
        registration.addRecipeCategories(new CompositeSmeltingRecipeCategory(guiHelper));
        registration.addRecipeCategories(new ChiselTableRecipeCategory(guiHelper));
        registration.addRecipeCategories(new TravellingMerchantCategory(guiHelper));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        var minecraft = Minecraft.getInstance();
        var server = minecraft.getSingleplayerServer();
        if (server == null) {
            return;
        }
        var recipeManager = server.getRecipeManager();

        List<WoodworkingRecipe> woodworkingRecipes = recipeManager.getRecipes().stream()
                .filter(holder -> holder.value().getType() == RecipeTypeRegistry.WOODWORKING.get())
                .map(holder -> (WoodworkingRecipe) holder.value())
                .toList();
        registration.addRecipes(WoodworkingRecipeCategory.WOODWORKING_RECIPE_TYPE, woodworkingRecipes);

        List<CompositeSmeltingRecipe> compositeSmeltingRecipes = recipeManager.getRecipes().stream()
                .filter(holder -> holder.value().getType() == RecipeTypeRegistry.COMPOSITE_SMELTING.get())
                .map(holder -> (CompositeSmeltingRecipe) holder.value())
                .toList();
        registration.addRecipes(CompositeSmeltingRecipeCategory.COMPOSITE_SMELTING_RECIPE_TYPE, compositeSmeltingRecipes);

        List<ChiselTableRecipe> chiselTableRecipes = recipeManager.getRecipes().stream()
                .filter(holder -> holder.value().getType() == RecipeTypeRegistry.CHISEL_TABLE.get())
                .map(holder -> (ChiselTableRecipe) holder.value())
                .toList();
        registration.addRecipes(ChiselTableRecipeCategory.CHISEL_TABLE_RECIPE_TYPE, chiselTableRecipes);

        List<TravellingMerchantWrapper> customWanderingTraderTrades = TravellingMerchant.getTradeOptions().stream().map(TravellingMerchantWrapper::new).toList();
        registration.addRecipes(TravellingMerchantCategory.CUSTOM_WANDERING_TRADER_WRAPPER_RECIPE_TYPE, customWanderingTraderTrades);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addCraftingStation(WoodworkingRecipeCategory.WOODWORKING_RECIPE_TYPE, new ItemStack(BlockRegistry.WOODWORKING_WORKBENCH.get()));
        registration.addCraftingStation(CompositeSmeltingRecipeCategory.COMPOSITE_SMELTING_RECIPE_TYPE, new ItemStack(BlockRegistry.BRICK_KILN.get()));
        registration.addCraftingStation(ChiselTableRecipeCategory.CHISEL_TABLE_RECIPE_TYPE, new ItemStack(BlockRegistry.CHISEL_TABLE.get()));
        registration.addCraftingStation(TravellingMerchantCategory.CUSTOM_WANDERING_TRADER_WRAPPER_RECIPE_TYPE, new ItemStack(BlockRegistry.TEAHOUSE_FLAG.get()));
    }
}
