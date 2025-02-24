package com.voxelutopia.ultramarine.client.integration.jade;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec2;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.ui.IElement;
import snownee.jade.api.ui.IElementHelper;

public enum MalletToggleableComponentProvider implements IBlockComponentProvider {
    INSTANCE;

    public static final ResourceLocation MALLET_TOGGLEABLE = ResourceLocation.fromNamespaceAndPath(Ultramarine.MOD_ID, "mallet_toggleable");

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        IElementHelper elements = tooltip.getElementHelper();
        IElement icon = elements.item(ItemRegistry.WOODEN_MALLET.get().getDefaultInstance(), 0.5f).size(new Vec2(10, 10)).translate(new Vec2(0, -1));
        tooltip.add(icon);
        tooltip.append(Component.translatable("gui.jade.plugin_ultramarine.mallet_toggleable"));
    }

    @Override
    public ResourceLocation getUid() {
        return MALLET_TOGGLEABLE;
    }
}
