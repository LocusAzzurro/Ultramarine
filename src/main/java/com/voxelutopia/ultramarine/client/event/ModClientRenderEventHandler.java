package com.voxelutopia.ultramarine.client.event;

import com.voxelutopia.ultramarine.client.screen.ContainerDecorativeBlockScreen;
import com.voxelutopia.ultramarine.client.screen.WoodworkingWorkbenchScreen;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.data.registry.MenuTypeRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientRenderEventHandler {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent e){

        e.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.ABACUS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BOTTLE_GOURD.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.GUNNY_SACK.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.OCTAGONAL_PALACE_LANTERN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SQUARE_PALACE_LANTERN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.STANDING_LAMP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SMALL_STANDING_LAMP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.WHITE_SKY_LANTERN.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.RED_SKY_LANTERN.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.YELLOW_SKY_LANTERN.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.WOODWORKING_WORKBENCH.get(), RenderType.cutout());

            MenuScreens.register(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X1.get(), ContainerDecorativeBlockScreen::new);
            MenuScreens.register(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X3.get(), ContainerDecorativeBlockScreen::new);
            MenuScreens.register(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X3.get(), ContainerDecorativeBlockScreen::new);
            MenuScreens.register(MenuTypeRegistry.WOODWORKING_WORKBENCH.get(), WoodworkingWorkbenchScreen::new);
        });
    }

}
