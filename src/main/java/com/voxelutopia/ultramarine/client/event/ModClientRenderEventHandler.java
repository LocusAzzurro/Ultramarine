package com.voxelutopia.ultramarine.client.event;

import com.voxelutopia.ultramarine.client.render.SeatEntityRenderer;
import com.voxelutopia.ultramarine.client.screen.BrickKilnScreen;
import com.voxelutopia.ultramarine.client.screen.ChiselTableScreen;
import com.voxelutopia.ultramarine.client.screen.ContainerDecorativeBlockScreen;
import com.voxelutopia.ultramarine.client.screen.WoodworkingWorkbenchScreen;
import com.voxelutopia.ultramarine.data.registry.EntityTypeRegistry;
import com.voxelutopia.ultramarine.data.registry.MenuTypeRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.WanderingTraderRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(Dist.CLIENT)
public class ModClientRenderEventHandler {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent e) {
        e.enqueueWork(() -> {
            EntityRenderers.register(EntityTypeRegistry.SEAT.get(), SeatEntityRenderer::new);
            EntityRenderers.register(EntityTypeRegistry.TRAVELLING_MERCHANT.get(), WanderingTraderRenderer::new);
        });
    }

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X1.get(), ContainerDecorativeBlockScreen::new);
        event.register(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X3.get(), ContainerDecorativeBlockScreen::new);
        event.register(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X6.get(), ContainerDecorativeBlockScreen::new);
        event.register(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X3.get(), ContainerDecorativeBlockScreen::new);
        event.register(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X6.get(), ContainerDecorativeBlockScreen::new);
        event.register(MenuTypeRegistry.WOODWORKING_WORKBENCH.get(), WoodworkingWorkbenchScreen::new);
        event.register(MenuTypeRegistry.BRICK_KILN.get(), BrickKilnScreen::new);
        event.register(MenuTypeRegistry.CHISEL_TABLE.get(), ChiselTableScreen::new);
    }
}
