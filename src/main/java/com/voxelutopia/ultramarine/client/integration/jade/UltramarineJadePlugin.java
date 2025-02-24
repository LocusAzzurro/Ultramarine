package com.voxelutopia.ultramarine.client.integration.jade;

import com.voxelutopia.ultramarine.world.block.ChiralDirectionalBlock;
import com.voxelutopia.ultramarine.world.block.RailingBlock;
import com.voxelutopia.ultramarine.world.block.ShiftableBlock;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class UltramarineJadePlugin implements IWailaPlugin {

    @Override
    public void register(IWailaCommonRegistration registration) {
        IWailaPlugin.super.register(registration);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(MalletToggleableComponentProvider.INSTANCE, ShiftableBlock.class);
        registration.registerBlockComponent(MalletToggleableComponentProvider.INSTANCE, ChiralDirectionalBlock.class);
        registration.registerBlockComponent(MalletToggleableComponentProvider.INSTANCE, RailingBlock.class);
    }
}
