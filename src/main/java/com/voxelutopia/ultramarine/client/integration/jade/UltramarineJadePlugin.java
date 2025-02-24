package com.voxelutopia.ultramarine.client.integration.jade;

import com.voxelutopia.ultramarine.world.block.*;
import com.voxelutopia.ultramarine.world.block.entity.BottleGourdBlockEntity;
import com.voxelutopia.ultramarine.world.block.entity.BrickKilnBlockEntity;
import com.voxelutopia.ultramarine.world.block.entity.CenserBlockEntity;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class UltramarineJadePlugin implements IWailaPlugin {

    @Override
    public void register(IWailaCommonRegistration registration) {
        registration.registerBlockDataProvider(CenserComponent.INSTANCE, CenserBlockEntity.class);
        registration.registerBlockDataProvider(BrickKilnComponent.INSTANCE, BrickKilnBlockEntity.class);
        registration.registerBlockDataProvider(BottleGourdComponent.INSTANCE, BottleGourdBlockEntity.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(MalletToggleableComponentProvider.INSTANCE, ShiftableBlock.class);
        registration.registerBlockComponent(MalletToggleableComponentProvider.INSTANCE, ChiralDirectionalBlock.class);
        registration.registerBlockComponent(MalletToggleableComponentProvider.INSTANCE, RailingBlock.class);
        registration.registerBlockComponent(CenserComponent.INSTANCE, Censer.class);
        registration.registerBlockComponent(BrickKilnComponent.INSTANCE, BrickKiln.class);
        registration.registerBlockComponent(BottleGourdComponent.INSTANCE, BottleGourd.class);
    }
}
