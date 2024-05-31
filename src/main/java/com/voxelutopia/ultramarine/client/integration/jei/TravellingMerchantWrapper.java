package com.voxelutopia.ultramarine.client.integration.jei;

import mezz.jei.api.recipe.category.extensions.IRecipeCategoryExtension;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;

public class TravellingMerchantWrapper implements IRecipeCategoryExtension {

    private ItemStack input;
    private ItemStack output;

    public TravellingMerchantWrapper(MerchantOffer offer){
        this.input = offer.getBaseCostA();
        this.output = offer.getResult();
    }

    public ItemStack getInput() {
        return input;
    }

    public ItemStack getOutput() {
        return output;
    }
}
