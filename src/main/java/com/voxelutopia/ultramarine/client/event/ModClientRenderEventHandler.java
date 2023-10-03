package com.voxelutopia.ultramarine.client.event;

import com.voxelutopia.ultramarine.client.render.SeatEntityRenderer;
import com.voxelutopia.ultramarine.client.screen.ContainerDecorativeBlockScreen;
import com.voxelutopia.ultramarine.client.screen.WoodworkingWorkbenchScreen;
import com.voxelutopia.ultramarine.init.registry.ModEntityTypes;
import com.voxelutopia.ultramarine.init.registry.ModMenuTypes;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.WanderingTraderRenderer;

public class ModClientRenderEventHandler {

    public static void onClientSetup() {
        setRenderLayers();
        registerMenuScreens();
        registerEntityRenderers();
    }

    private static void setRenderLayers() {
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.ABACUS, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BRUSH_TOOLS, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BOTTLE_GOURD, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BLACK_IRON_FLOWERPOT, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BLUE_PORCELAIN_FLOWERPOT, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MEMORIAL_TABLET, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.KNOCKER, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.PORCELAIN_TEAPOT, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BRONZE_CENSER, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.ROYAL_CENSER, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.JADE_PENDANT, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.IMPERIAL_JADE_SEAL, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.TEAHOUSE_FLAG, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.PAPER, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LONG_HANGING_PAINTING, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.DAMAGED_LANDSCAPE_PAINTING, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.HANGING_PAINTING_FAN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SMALL_WOODEN_GUARDIAN_LION, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SMALL_STONE_GUARDIAN_LION, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SMALL_JADE_GUARDIAN_LION, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SMALL_YELLOW_GLAZED_GUARDIAN_LION, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SMALL_GREEN_GLAZED_GUARDIAN_LION, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.GUNNY_SACK, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.PLATED_MUNG_BEAN_CAKES, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.PLATED_FISH, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.WINE_POT, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.OCTAGONAL_PALACE_LANTERN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SQUARE_PALACE_LANTERN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.STANDING_LAMP, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SMALL_STANDING_LAMP, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.WHITE_SKY_LANTERN, RenderType.translucent());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.RED_SKY_LANTERN, RenderType.translucent());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.YELLOW_SKY_LANTERN, RenderType.translucent());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.STONE_LAMP, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.RED_WOODEN_RAILING, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.RED_WOODEN_RAILING_EDGE, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.WOODEN_RAILING, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.WOODEN_RAILING_VARIANT, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.YELLOW_CARVED_PATTERN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.CIRCULAR_YELLOW_CARVED_PATTERN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.YELLOW_CARVED_FANGXIN_EDGE_PATTERN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.YELLOW_CARVED_FANGXIN_PATTERN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LARGE_YELLOW_CARVED_PATTERN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MEDIUM_YELLOW_CARVED_PATTERN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.YELLOW_CARVED_ZHAOTOU_PATTERN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LONG_YELLOW_CARVED_ZHAOTOU_PATTERN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.FLAME_ARCH_WALL_PATTERN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.GOLDEN_DRAGON_FANGXIN_PATTERN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BLUE_FANGXIN_PATTERN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BLUE_FANGXIN_PATTERN_EDGE, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LIGHT_BLUE_SU_STYLE_CAIHUA, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.YELLOW_SU_STYLE_CAIHUA, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LIGHT_YELLOW_SU_STYLE_CAIHUA, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MEDIUM_SU_STYLE_CAIHUA, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LARGE_WHITE_SU_STYLE_CAIHUA, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LARGE_GREEN_SU_STYLE_CAIHUA, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LARGE_GRAY_SU_STYLE_CAIHUA, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.GREEN_FANGXIN_PATTERN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.GREEN_FANGXIN_PATTERN_EDGE, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.CARVED_ZHAOTOU_PATTERN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LONG_GILDED_DARK_OAK_QUETI, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LONG_GILDED_DARK_OAK_QUETI_EDGE, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.WOODEN_QUETI, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.TALL_WOODEN_QUETI_EDGE, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.WOODEN_QUETI_EDGE, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SHORT_GLAZED_QUETI, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LARGE_WOODEN_QUETI_EDGE, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.WOODEN_GUALUO, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LARGE_WOODEN_GUALUO, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LARGE_WOODEN_GUALUO_EDGE, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.THICK_CARVED_QUETI, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LARGE_BLUE_CURTAIN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MEDIUM_BLUE_CURTAIN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SMALL_BLUE_CURTAIN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.RED_CURTAIN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.RED_CURTAIN_CORNER, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.GLAZED_TILE_GRID_WINDOW, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.CARVED_WOODEN_DOOR, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SONG_WOODEN_DOOR, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SONG_WOODEN_WINDOW, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BAMBOO_CURTAIN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.RED_CANDLE, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.WARPED_CABINET, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.EBONY_CABINET, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LARGE_TEA_TABLE, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LARGE_LANDSCAPE_PAINTING_SCREEN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.CHESS_TABLE, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.HIGH_TABLE_WITH_WHITE_TOP, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.CENSER_TABLE, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.PORCELAIN_INLAID_GRAND_CHAIR, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.PORCELAIN_INLAID_TABLE, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.CHAIR_WITH_YELLOW_CUSHION, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.PAINTED_CHAIR, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SMALL_TABLE, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SMALL_EBONY_TABLE, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.OAK_BED, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.PAINTED_SCREEN, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LOTUS_BUD, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MEDIUM_LOTUS, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.TILTED_LOTUS_LEAF, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LARGE_LOTUS_LEAF, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SMALL_LOTUS_LEAF_CLUSTER, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MEDIUM_LOTUS_LEAF_CLUSTER, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SMALL_LOTUS_LEAF, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SMALL_DARK_GREEN_LOTUS_LEAF, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MEDIUM_LOTUS_LEAF, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SMALL_RED_IVY, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MEDIUM_RED_IVY, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LARGE_RED_IVY, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SMALL_YELLOW_IVY, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MEDIUM_YELLOW_IVY, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LARGE_YELLOW_IVY, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SMALL_GREEN_IVY, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MEDIUM_GREEN_IVY, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LARGE_GREEN_IVY, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SMALL_LEAF_PILE, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MEDIUM_LEAF_PILE, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LARGE_LEAF_PILE, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.RED_CORAL_BONSAI, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.TALL_BLUE_VASE_BONSAI, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.BAMBOO_BONSAI, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.RED_PLUM_BONSAI, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SMALL_GREETING_PINE_BONSAI, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.TALL_BLUE_AND_WHITE_PORCELAIN_BONSAI, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.GREEN_PORCELAIN_VASE_BONSAI, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LARGE_BONSAI, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MEDIUM_BONSAI, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SMALL_GREEN_PORCELAIN_VASE_BONSAI, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MEDIUM_WHITE_PORCELAIN_VASE_BONSAI, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LARGE_WHITE_PORCELAIN_VASE_BONSAI, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.LARGE_GREETING_PINE_BONSAI, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.SMALL_WHITE_PORCELAIN_VASE_BONSAI, RenderType.cutout());
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.MEDIUM_GREETING_PINE_BONSAI, RenderType.cutout());
//
//            ItemBlockRenderTypes.setRenderLayer(BlockRegistry.WOODWORKING_WORKBENCH, RenderType.cutout());
    }

    private static void registerMenuScreens() {
        MenuScreens.register(ModMenuTypes.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X1, ContainerDecorativeBlockScreen::new);
        MenuScreens.register(ModMenuTypes.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X3, ContainerDecorativeBlockScreen::new);
        MenuScreens.register(ModMenuTypes.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X6, ContainerDecorativeBlockScreen::new);
        MenuScreens.register(ModMenuTypes.CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X3, ContainerDecorativeBlockScreen::new);
        MenuScreens.register(ModMenuTypes.CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X6, ContainerDecorativeBlockScreen::new);
        MenuScreens.register(ModMenuTypes.WOODWORKING_WORKBENCH, WoodworkingWorkbenchScreen::new);
    }

    private static void registerEntityRenderers() {
        EntityRendererRegistry.register(ModEntityTypes.SEAT, SeatEntityRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.CUSTOM_WANDERING_TRADER, WanderingTraderRenderer::new);
    }
}
