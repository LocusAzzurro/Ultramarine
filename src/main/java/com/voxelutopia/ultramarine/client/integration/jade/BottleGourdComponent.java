package com.voxelutopia.ultramarine.client.integration.jade;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.world.block.entity.BottleGourdBlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.phys.Vec2;
import net.minecraftforge.registries.ForgeRegistries;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.ui.IElementHelper;

public enum BottleGourdComponent implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    INSTANCE;

    public static final ResourceLocation BOTTLE_GOURD = new ResourceLocation(Ultramarine.MOD_ID, "bottle_gourd");

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        CompoundTag data = blockAccessor.getServerData();
        if (data.contains("Potion")) {
            int charges = data.getInt("Charges");
            Potion potion = Potion.byName(data.getString("Potion"));
            IElementHelper helper = IElementHelper.get();
            tooltip.add(helper.item(PotionUtils.setPotion(Items.POTION.getDefaultInstance(), potion), 0.6f).translate(new Vec2(-2, -2.5f)));
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
            compoundTag.putString("Potion", ForgeRegistries.POTIONS.getKey(potion).toString());
        }
    }

    @Override
    public ResourceLocation getUid() {
        return BOTTLE_GOURD;
    }
}
