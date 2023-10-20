package com.voxelutopia.ultramarine.client.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.voxelutopia.ultramarine.world.block.menu.ContainerDecorativeBlockMenu;
import net.minecraft.client.gui.IHasContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ContainerDecorativeBlockScreen extends ContainerScreen<ContainerDecorativeBlockMenu> implements IHasContainer<ContainerDecorativeBlockMenu> {

    private static final ResourceLocation CONTAINER_BACKGROUND = new ResourceLocation("textures/gui/container/generic_54.png");
    private final int containerRows;

    public ContainerDecorativeBlockScreen(ContainerDecorativeBlockMenu pMenu, PlayerInventory pPlayerInventory, ITextComponent pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.passEvents = false;
        this.containerRows = pMenu.getRowCount();
        this.imageHeight = 114 + this.containerRows * 18;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    public void render(MatrixStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pPoseStack, pMouseX, pMouseY);
    }

    protected void renderBg(MatrixStack pPoseStack, float pPartialTick, int pX, int pY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.getMinecraft().getTextureManager().bind(CONTAINER_BACKGROUND);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(pPoseStack, i, j, 0, 0, this.imageWidth, this.containerRows * 18 + 17);
        this.blit(pPoseStack, i, j + this.containerRows * 18 + 17, 0, 126, this.imageWidth, 96);
    }

}
