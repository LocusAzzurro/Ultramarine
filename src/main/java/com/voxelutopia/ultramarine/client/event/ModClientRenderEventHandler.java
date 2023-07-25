package com.voxelutopia.ultramarine.client.event;

import com.voxelutopia.ultramarine.client.render.SeatEntityRenderer;
import com.voxelutopia.ultramarine.client.screen.ContainerDecorativeBlockScreen;
import com.voxelutopia.ultramarine.client.screen.WoodworkingWorkbenchScreen;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.data.registry.EntityTypeRegistry;
import com.voxelutopia.ultramarine.data.registry.MenuTypeRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.WanderingTraderRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientRenderEventHandler {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent e){
        setRenderLayers(e);
        registerMenuScreens(e);
        registerEntityRenderers(e);
    }

    private static void setRenderLayers(FMLClientSetupEvent e) {
        e.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.ABACUS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BRUSH_TOOLS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BOTTLE_GOURD.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BLACK_IRON_FLOWERPOT.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BLUE_PORCELAIN_FLOWERPOT.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MEMORIAL_TABLET.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.KNOCKER.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BRONZE_CENSER.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.ROYAL_CENSER.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LONG_HANGING_PAINTING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.GUNNY_SACK.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.PLATED_MUNG_BEAN_CAKES.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.PLATED_FISH.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.OCTAGONAL_PALACE_LANTERN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SQUARE_PALACE_LANTERN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.STANDING_LAMP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SMALL_STANDING_LAMP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.WHITE_SKY_LANTERN.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.RED_SKY_LANTERN.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.YELLOW_SKY_LANTERN.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.STONE_LAMP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.RED_CURTAIN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.RED_CURTAIN_CORNER.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.CARVED_WOODEN_DOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SONG_WOODEN_DOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SONG_WOODEN_WINDOW.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.RED_CANDLE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.WARPED_CABINET.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.EBONY_CABINET.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.WOODWORKING_WORKBENCH.get(), RenderType.cutout());
        });
    }

    private static void registerMenuScreens(FMLClientSetupEvent e) {
        e.enqueueWork(() -> {
            MenuScreens.register(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X1.get(), ContainerDecorativeBlockScreen::new);
            MenuScreens.register(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X3.get(), ContainerDecorativeBlockScreen::new);
            MenuScreens.register(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X6.get(), ContainerDecorativeBlockScreen::new);
            MenuScreens.register(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X3.get(), ContainerDecorativeBlockScreen::new);
            MenuScreens.register(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X6.get(), ContainerDecorativeBlockScreen::new);
            MenuScreens.register(MenuTypeRegistry.WOODWORKING_WORKBENCH.get(), WoodworkingWorkbenchScreen::new);
        });
    }

    private static void registerEntityRenderers(FMLClientSetupEvent e){
        e.enqueueWork(() -> {
            EntityRenderers.register(EntityTypeRegistry.SEAT.get(), SeatEntityRenderer::new);
            EntityRenderers.register(EntityTypeRegistry.CUSTOM_WANDERING_TRADER.get(), WanderingTraderRenderer::new);
        });
    }
}
