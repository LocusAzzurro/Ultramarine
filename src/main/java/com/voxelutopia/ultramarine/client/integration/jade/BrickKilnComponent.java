package com.voxelutopia.ultramarine.client.integration.jade;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.phys.Vec2;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.StreamServerDataProvider;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.ui.IElementHelper;
import snownee.jade.mixin.AbstractFurnaceBlockEntityAccess;

import java.util.List;

public enum BrickKilnComponent implements IBlockComponentProvider, StreamServerDataProvider<BlockAccessor, BrickKilnComponent.Data> {
    INSTANCE;

    public static final ResourceLocation BRICK_KILN = ResourceLocation.fromNamespaceAndPath(Ultramarine.MOD_ID, "brick_kiln");

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config) {
        BrickKilnComponent.Data data = this.decodeFromData(accessor).orElse(null);
        if (data != null) {
            IElementHelper helper = IElementHelper.get();
            tooltip.add(helper.item(data.inventory.get(0)));
            tooltip.append(helper.item(data.inventory.get(1)));
            tooltip.append(helper.spacer(4, 0));
            tooltip.append(helper.progress((float) data.progress / (float) data.total).translate(new Vec2(-2.0F, 0.0F)));
            tooltip.append(helper.item(data.inventory.get(2)));
        }
    }

    @Override
    public BrickKilnComponent.Data streamData(BlockAccessor accessor) {
        AbstractFurnaceBlockEntityAccess access = (AbstractFurnaceBlockEntityAccess) accessor.getBlockEntity();
        AbstractFurnaceBlockEntity furnace = (AbstractFurnaceBlockEntity) accessor.getBlockEntity();
        return new Data(access.getCookingProgress(), access.getCookingTotalTime(), List.of(furnace.getItem(0), furnace.getItem(1), furnace.getItem(2)));
    }

    @Override
    public ResourceLocation getUid() {
        return BRICK_KILN;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, BrickKilnComponent.Data> streamCodec() {
        return BrickKilnComponent.Data.STREAM_CODEC;
    }

    public record Data(int progress, int total, List<ItemStack> inventory) {
        public static final StreamCodec<RegistryFriendlyByteBuf, BrickKilnComponent.Data> STREAM_CODEC;

        static {
            STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT, BrickKilnComponent.Data::progress,
                    ByteBufCodecs.VAR_INT, BrickKilnComponent.Data::total,
                    ItemStack.OPTIONAL_LIST_STREAM_CODEC, BrickKilnComponent.Data::inventory,
                    BrickKilnComponent.Data::new);
        }
    }
}
