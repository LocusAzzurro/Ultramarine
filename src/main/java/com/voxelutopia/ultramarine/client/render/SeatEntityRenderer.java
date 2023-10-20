package com.voxelutopia.ultramarine.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.voxelutopia.ultramarine.world.entity.SeatEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class SeatEntityRenderer<T extends SeatEntity> extends EntityRenderer<T> {

    public SeatEntityRenderer(EntityRendererManager context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(T pEntity) {
        return null;
    }

    @Override
    public void render(T p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {

    }
}
