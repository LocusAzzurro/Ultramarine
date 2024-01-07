package com.voxelutopia.ultramarine.client.event;

import com.voxelutopia.ultramarine.client.render.SeatEntityRenderer;
import com.voxelutopia.ultramarine.client.screen.ContainerDecorativeBlockScreen;
import com.voxelutopia.ultramarine.client.screen.WoodworkingWorkbenchScreen;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.data.registry.EntityTypeRegistry;
import com.voxelutopia.ultramarine.data.registry.MenuTypeRegistry;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.WanderingTraderRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientRenderEventHandler {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent e) {
        setRenderLayers(e);
        registerMenuScreens(e);
        registerEntityRenderers(e);
    }

    private static void setRenderLayers(FMLClientSetupEvent e) {
        e.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(BlockRegistry.ABACUS.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.BRUSH_TOOLS.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.BOTTLE_GOURD.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.BLACK_IRON_FLOWERPOT.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.BLUE_PORCELAIN_FLOWERPOT.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.MEMORIAL_TABLET.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.KNOCKER.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.PORCELAIN_TEAPOT.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.BRONZE_CENSER.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.ROYAL_CENSER.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.JADE_PENDANT.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.IMPERIAL_JADE_SEAL.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.TEAHOUSE_FLAG.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.PAPER.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LONG_HANGING_PAINTING.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.DAMAGED_LANDSCAPE_PAINTING.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.HANGING_PAINTING_FAN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SMALL_WOODEN_GUARDIAN_LION.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SMALL_STONE_GUARDIAN_LION.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SMALL_JADE_GUARDIAN_LION.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SMALL_YELLOW_GLAZED_GUARDIAN_LION.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SMALL_GREEN_GLAZED_GUARDIAN_LION.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.GUNNY_SACK.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.PLATED_MUNG_BEAN_CAKES.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.PLATED_FISH.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.WINE_POT.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.OCTAGONAL_PALACE_LANTERN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SQUARE_PALACE_LANTERN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.STANDING_LAMP.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SMALL_STANDING_LAMP.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.WHITE_SKY_LANTERN.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(BlockRegistry.RED_SKY_LANTERN.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(BlockRegistry.YELLOW_SKY_LANTERN.get(), RenderType.translucent());
            RenderTypeLookup.setRenderLayer(BlockRegistry.STONE_LAMP.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.RED_WOODEN_RAILING.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.RED_WOODEN_RAILING_EDGE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.WOODEN_RAILING.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.WOODEN_RAILING_VARIANT.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.YELLOW_CARVED_PATTERN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.CIRCULAR_YELLOW_CARVED_PATTERN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.YELLOW_CARVED_FANGXIN_EDGE_PATTERN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.YELLOW_CARVED_FANGXIN_PATTERN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LARGE_YELLOW_CARVED_PATTERN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.MEDIUM_YELLOW_CARVED_PATTERN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.YELLOW_CARVED_ZHAOTOU_PATTERN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LONG_YELLOW_CARVED_ZHAOTOU_PATTERN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.FLAME_ARCH_WALL_PATTERN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.GOLDEN_DRAGON_FANGXIN_PATTERN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.BLUE_FANGXIN_PATTERN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.BLUE_FANGXIN_PATTERN_EDGE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LIGHT_BLUE_SU_STYLE_CAIHUA.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.YELLOW_SU_STYLE_CAIHUA.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LIGHT_YELLOW_SU_STYLE_CAIHUA.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.MEDIUM_SU_STYLE_CAIHUA.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LARGE_WHITE_SU_STYLE_CAIHUA.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LARGE_GREEN_SU_STYLE_CAIHUA.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LARGE_GRAY_SU_STYLE_CAIHUA.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.GREEN_FANGXIN_PATTERN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.GREEN_FANGXIN_PATTERN_EDGE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.CARVED_ZHAOTOU_PATTERN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LONG_GILDED_DARK_OAK_QUETI.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LONG_GILDED_DARK_OAK_QUETI_EDGE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.WOODEN_QUETI.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.TALL_WOODEN_QUETI_EDGE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.WOODEN_QUETI_EDGE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SHORT_GLAZED_QUETI.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LARGE_WOODEN_QUETI_EDGE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.WOODEN_GUALUO.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LARGE_WOODEN_GUALUO.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LARGE_WOODEN_GUALUO_EDGE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.THICK_CARVED_QUETI.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LARGE_BLUE_CURTAIN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.MEDIUM_BLUE_CURTAIN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SMALL_BLUE_CURTAIN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.RED_CURTAIN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.RED_CURTAIN_CORNER.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.GLAZED_TILE_GRID_WINDOW.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.CARVED_WOODEN_DOOR.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SONG_WOODEN_DOOR.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SONG_WOODEN_WINDOW.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.BAMBOO_CURTAIN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.RED_CANDLE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.WARPED_CABINET.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.EBONY_CABINET.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LARGE_TEA_TABLE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LARGE_LANDSCAPE_PAINTING_SCREEN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.CHESS_TABLE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.HIGH_TABLE_WITH_WHITE_TOP.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.CENSER_TABLE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.PORCELAIN_INLAID_GRAND_CHAIR.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.PORCELAIN_INLAID_TABLE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.CHAIR_WITH_YELLOW_CUSHION.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.PAINTED_CHAIR.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SMALL_TABLE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SMALL_EBONY_TABLE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.OAK_BED.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.PAINTED_SCREEN.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LOTUS_BUD.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.MEDIUM_LOTUS.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.TILTED_LOTUS_LEAF.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LARGE_LOTUS_LEAF.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SMALL_LOTUS_LEAF_CLUSTER.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.MEDIUM_LOTUS_LEAF_CLUSTER.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SMALL_LOTUS_LEAF.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SMALL_DARK_GREEN_LOTUS_LEAF.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.MEDIUM_LOTUS_LEAF.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SMALL_RED_IVY.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.MEDIUM_RED_IVY.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LARGE_RED_IVY.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SMALL_YELLOW_IVY.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.MEDIUM_YELLOW_IVY.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LARGE_YELLOW_IVY.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SMALL_GREEN_IVY.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.MEDIUM_GREEN_IVY.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LARGE_GREEN_IVY.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SMALL_LEAF_PILE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.MEDIUM_LEAF_PILE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LARGE_LEAF_PILE.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.RED_CORAL_BONSAI.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.TALL_BLUE_VASE_BONSAI.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.BAMBOO_BONSAI.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.RED_PLUM_BONSAI.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SMALL_GREETING_PINE_BONSAI.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.TALL_BLUE_AND_WHITE_PORCELAIN_BONSAI.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.GREEN_PORCELAIN_VASE_BONSAI.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LARGE_BONSAI.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.MEDIUM_BONSAI.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SMALL_GREEN_PORCELAIN_VASE_BONSAI.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.MEDIUM_WHITE_PORCELAIN_VASE_BONSAI.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LARGE_WHITE_PORCELAIN_VASE_BONSAI.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.LARGE_GREETING_PINE_BONSAI.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.SMALL_WHITE_PORCELAIN_VASE_BONSAI.get(), RenderType.cutout());
            RenderTypeLookup.setRenderLayer(BlockRegistry.MEDIUM_GREETING_PINE_BONSAI.get(), RenderType.cutout());

            RenderTypeLookup.setRenderLayer(BlockRegistry.WOODWORKING_WORKBENCH.get(), RenderType.cutout());
        });
    }

    private static void registerMenuScreens(FMLClientSetupEvent e) {
        e.enqueueWork(() -> {
            ScreenManager.register(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X1.get(), ContainerDecorativeBlockScreen::new);
            ScreenManager.register(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X3.get(), ContainerDecorativeBlockScreen::new);
            ScreenManager.register(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X6.get(), ContainerDecorativeBlockScreen::new);
            ScreenManager.register(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X3.get(), ContainerDecorativeBlockScreen::new);
            ScreenManager.register(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X6.get(), ContainerDecorativeBlockScreen::new);
            ScreenManager.register(MenuTypeRegistry.WOODWORKING_WORKBENCH.get(), WoodworkingWorkbenchScreen::new);
        });
    }

    private static void registerEntityRenderers(FMLClientSetupEvent e) {
        RenderingRegistry.registerEntityRenderingHandler(EntityTypeRegistry.SEAT.get(), SeatEntityRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTypeRegistry.CUSTOM_WANDERING_TRADER.get(), WanderingTraderRenderer::new);
    }
}
