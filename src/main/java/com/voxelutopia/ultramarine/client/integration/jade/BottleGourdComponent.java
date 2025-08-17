package com.voxelutopia.ultramarine.client.integration.jade;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.world.block.entity.BottleGourdBlockEntity;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.phys.Vec2;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.ui.IElementHelper;

import java.util.Optional;

public enum BottleGourdComponent implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    INSTANCE;

    public static final ResourceLocation BOTTLE_GOURD = ResourceLocation.fromNamespaceAndPath(Ultramarine.MOD_ID, "bottle_gourd");

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        CompoundTag data = blockAccessor.getServerData();
        if (data.contains("Potion")) {
            int charges = data.getInt("Charges");
            ResourceLocation location = ResourceLocation.tryParse(data.getString("Potion"));
            if (location == null) return;
            Optional<Holder.Reference<Potion>> potion = BuiltInRegistries.POTION.getHolder(location);
            if (potion.isEmpty()) return;
            IElementHelper helper = IElementHelper.get();
            ItemStack stack = new ItemStack(Items.POTION);
            stack.set(DataComponents.POTION_CONTENTS, new PotionContents(potion.get()));
            tooltip.add(helper.item(stack, 0.6f).translate(new Vec2(-2, -2.5f)));
            tooltip.append(Component.literal("× " + charges));
        }
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, BlockAccessor blockAccessor) {
        BottleGourdBlockEntity gourd = (BottleGourdBlockEntity) blockAccessor.getBlockEntity();
        if (gourd.hasCharges()) {
            int charges = gourd.getCharges();
            Potion potion = gourd.getPotion();
            compoundTag.putInt("Charges", charges);
            compoundTag.putString("Potion", BuiltInRegistries.POTION.getKey(potion).toString());
        }
    }

    @Override
    public ResourceLocation getUid() {
        return BOTTLE_GOURD;
    }
}
