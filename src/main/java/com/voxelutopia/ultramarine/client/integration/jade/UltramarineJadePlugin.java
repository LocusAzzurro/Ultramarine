package com.voxelutopia.ultramarine.client.integration.jade;

import com.voxelutopia.ultramarine.world.block.*;
import com.voxelutopia.ultramarine.world.block.entity.BottleGourdBlockEntity;
import com.voxelutopia.ultramarine.world.block.entity.BrickKilnBlockEntity;
import com.voxelutopia.ultramarine.world.block.entity.CenserBlockEntity;
import net.minecraft.network.chat.Component;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class UltramarineJadePlugin implements IWailaPlugin {

    @Override
    public void register(IWailaCommonRegistration registration) {
        registration.registerBlockDataProvider(CenserDataProvider.INSTANCE, CenserBlockEntity.class);
        registration.registerBlockDataProvider(BrickKilnDataProvider.INSTANCE, BrickKilnBlockEntity.class);
        registration.registerBlockDataProvider(BottleGourdDataProvider.INSTANCE, BottleGourdBlockEntity.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {

        registration.registerBlockComponent(MalletToggleableComponentProvider.INSTANCE, ShiftableBlock.class);
        registration.registerBlockComponent(MalletToggleableComponentProvider.INSTANCE, ChiralDirectionalBlock.class);
        registration.registerBlockComponent(MalletToggleableComponentProvider.INSTANCE, RailingBlock.class);
        registration.registerBlockComponent(CenserComponent.INSTANCE, Censer.class);
        registration.registerBlockComponent(BrickKilnComponent.INSTANCE, BrickKiln.class);
        registration.registerBlockComponent(BottleGourdComponent.INSTANCE, BottleGourd.class);

        Component block = Component.translatable("config.jade.plugin_ultramarine.block");

        registration.setConfigCategoryOverride(MalletToggleableComponentProvider.MALLET_TOGGLEABLE, block);
        registration.setConfigCategoryOverride(CenserComponent.CENSER_BURN_TIME, block);
        registration.setConfigCategoryOverride(BrickKilnComponent.BRICK_KILN, block);
        registration.setConfigCategoryOverride(BottleGourdComponent.BOTTLE_GOURD, block);
    }
}

