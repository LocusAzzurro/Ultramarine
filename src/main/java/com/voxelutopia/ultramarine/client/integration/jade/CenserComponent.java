package com.voxelutopia.ultramarine.client.integration.jade;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public enum CenserComponent implements IBlockComponentProvider {
    INSTANCE;

    public static final Identifier CENSER_BURN_TIME = Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "censer_burn_time");

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        if (blockAccessor.getServerData().contains("BurnTime")) {
            int burnTime = blockAccessor.getServerData().getInt("BurnTime").orElse(0);
            if (burnTime > 0) {
                tooltip.add(Component.translatable("gui.jade.plugin_ultramarine.censer_burn_time", burnTime / 20));
            }
        }
    }

    @Override
    public Identifier getUid() {
        return CENSER_BURN_TIME;
    }
}
