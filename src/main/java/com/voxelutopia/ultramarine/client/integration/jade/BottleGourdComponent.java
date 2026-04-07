package com.voxelutopia.ultramarine.client.integration.jade;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.world.block.entity.BottleGourdBlockEntity;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.theme.IThemeHelper;
import snownee.jade.api.ui.JadeUI;

public enum BottleGourdComponent implements IBlockComponentProvider {
    INSTANCE;

    public static final Identifier BOTTLE_GOURD = Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "bottle_gourd");

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor blockAccessor, IPluginConfig config) {

        CompoundTag data = blockAccessor.getServerData();
        if (data.contains("BottleGourd")) {
            data.getCompound("BottleGourd").ifPresent(tag -> {
                int charges = tag.getInt("Charges").orElse(0);
                String potionString = tag.getString("Potion").orElse("");
                if (potionString.isEmpty()) {
                    return;
                }
                Identifier potionId = Identifier.parse(potionString);

                ItemStack potionStack = new ItemStack(Items.POTION);
                var potionHolder = BuiltInRegistries.POTION.get(potionId).orElseThrow();

                potionStack.set(DataComponents.POTION_CONTENTS,
                        new PotionContents(potionHolder));

                Component potionName = potionStack.getHoverName();

                IThemeHelper themeHelper = IThemeHelper.get();

                tooltip.add(JadeUI.smallItem(potionStack));

                tooltip.append(potionName);
                tooltip.append(JadeUI.spacer(5, 0));
                tooltip.append(themeHelper.info(charges + "/" + BottleGourdBlockEntity.MAX_CHARGE));
            });
        }
    }

    @Override
    public Identifier getUid() {
        return BOTTLE_GOURD;
    }
}
