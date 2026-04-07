package com.voxelutopia.ultramarine.client.integration.jade;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.ui.JadeUI;

public enum MalletToggleableComponentProvider implements IBlockComponentProvider {
    INSTANCE;

    public static final Identifier MALLET_TOGGLEABLE = Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "mallet_toggleable");

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        tooltip.add(JadeUI.item(ItemRegistry.WOODEN_MALLET.get().getDefaultInstance()));
        tooltip.append(JadeUI.text(Component.translatable("gui.jade.plugin_ultramarine.mallet_toggleable")));
    }

    @Override
    public Identifier getUid() {
        return MALLET_TOGGLEABLE;
    }
}
