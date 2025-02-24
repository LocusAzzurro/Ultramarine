package com.voxelutopia.ultramarine.client.integration.jade;

import com.voxelutopia.ultramarine.world.block.Censer;
import com.voxelutopia.ultramarine.world.block.ChiralDirectionalBlock;
import com.voxelutopia.ultramarine.world.block.RailingBlock;
import com.voxelutopia.ultramarine.world.block.ShiftableBlock;
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
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(MalletToggleableComponentProvider.INSTANCE, ShiftableBlock.class);
        registration.registerBlockComponent(MalletToggleableComponentProvider.INSTANCE, ChiralDirectionalBlock.class);
        registration.registerBlockComponent(MalletToggleableComponentProvider.INSTANCE, RailingBlock.class);
        registration.registerBlockComponent(CenserComponent.INSTANCE, Censer.class);
    }
}
