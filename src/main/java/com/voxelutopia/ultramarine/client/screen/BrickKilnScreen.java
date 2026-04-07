package com.voxelutopia.ultramarine.client.screen;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.world.block.menu.BrickKilnMenu;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class BrickKilnScreen extends AbstractContainerScreen<BrickKilnMenu> {

    private static final Identifier BACKGROUND = Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "textures/gui/brick_kiln.png");

    public BrickKilnScreen(BrickKilnMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractBackground(graphics, mouseX, mouseY, a);
        graphics.blit(
                RenderPipelines.GUI_TEXTURED,
                BACKGROUND,
                this.leftPos,
                this.topPos,
                0.0F,
                0.0F,
                this.imageWidth,
                this.imageHeight,
                256,
                256
        );
        if (this.menu.isLit()) {
            int k = this.menu.getLitProgress();
            graphics.blit(
                    RenderPipelines.GUI_TEXTURED,
                    BACKGROUND,
                    this.leftPos + 56,
                    this.topPos + 36 + 12 - k,
                    176.0F,
                    (float) (12 - k),
                    14,
                    k + 1,
                    256,
                    256
            );
        }

        int l = this.menu.getBurnProgress();
        graphics.blit(
                RenderPipelines.GUI_TEXTURED,
                BACKGROUND,
                this.leftPos + 79,
                this.topPos + 34,
                176.0F,
                14.0F,
                l + 1,
                16,
                256,
                256
        );
    }
}
