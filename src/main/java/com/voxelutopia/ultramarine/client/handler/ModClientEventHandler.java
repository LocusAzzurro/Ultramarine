package com.voxelutopia.ultramarine.client.handler;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.client.render.SeatEntityRenderer;
import com.voxelutopia.ultramarine.client.screen.ContainerDecorativeBlockScreen;
import com.voxelutopia.ultramarine.client.screen.WoodworkingWorkbenchScreen;
import com.voxelutopia.ultramarine.init.registry.ModBlocks;
import com.voxelutopia.ultramarine.init.registry.ModEntityTypes;
import com.voxelutopia.ultramarine.init.registry.ModMenuTypes;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.WanderingTraderRenderer;

public class ModClientEventHandler {

    public static void onClientSetup() {
        Ultramarine.LOGGER.info("Setup Client");
        setRenderTypes();
        registerMenuScreens();
        registerEntityRenderers();
    }

    private static void setRenderTypes() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ABACUS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BRUSH_TOOLS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BOTTLE_GOURD, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_IRON_FLOWERPOT, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_PORCELAIN_FLOWERPOT, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEMORIAL_TABLET, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KNOCKER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PORCELAIN_TEAPOT, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BRONZE_CENSER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ROYAL_CENSER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.JADE_PENDANT, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.IMPERIAL_JADE_SEAL, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TEAHOUSE_FLAG, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PAPER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LONG_HANGING_PAINTING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DAMAGED_LANDSCAPE_PAINTING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HANGING_PAINTING_FAN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_WOODEN_GUARDIAN_LION, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_STONE_GUARDIAN_LION, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_JADE_GUARDIAN_LION, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_YELLOW_GLAZED_GUARDIAN_LION, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_GREEN_GLAZED_GUARDIAN_LION, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GUNNY_SACK, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLATED_MUNG_BEAN_CAKES, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLATED_FISH, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WINE_POT, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OCTAGONAL_PALACE_LANTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SQUARE_PALACE_LANTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STANDING_LAMP, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_STANDING_LAMP, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_SKY_LANTERN, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_SKY_LANTERN, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOW_SKY_LANTERN, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STONE_LAMP, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_WOODEN_RAILING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_WOODEN_RAILING_EDGE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOODEN_RAILING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOODEN_RAILING_VARIANT, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOW_CARVED_PATTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CIRCULAR_YELLOW_CARVED_PATTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOW_CARVED_FANGXIN_EDGE_PATTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOW_CARVED_FANGXIN_PATTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_YELLOW_CARVED_PATTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_YELLOW_CARVED_PATTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOW_CARVED_ZHAOTOU_PATTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LONG_YELLOW_CARVED_ZHAOTOU_PATTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLAME_ARCH_WALL_PATTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GOLDEN_DRAGON_FANGXIN_PATTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_FANGXIN_PATTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_FANGXIN_PATTERN_EDGE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LIGHT_BLUE_SU_STYLE_CAIHUA, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOW_SU_STYLE_CAIHUA, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LIGHT_YELLOW_SU_STYLE_CAIHUA, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_SU_STYLE_CAIHUA, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_WHITE_SU_STYLE_CAIHUA, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_GREEN_SU_STYLE_CAIHUA, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_GRAY_SU_STYLE_CAIHUA, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GREEN_FANGXIN_PATTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GREEN_FANGXIN_PATTERN_EDGE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARVED_ZHAOTOU_PATTERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LONG_GILDED_DARK_OAK_QUETI, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LONG_GILDED_DARK_OAK_QUETI_EDGE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOODEN_QUETI, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TALL_WOODEN_QUETI_EDGE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOODEN_QUETI_EDGE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SHORT_GLAZED_QUETI, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_WOODEN_QUETI_EDGE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOODEN_GUALUO, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_WOODEN_GUALUO, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_WOODEN_GUALUO_EDGE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.THICK_CARVED_QUETI, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_BLUE_CURTAIN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_BLUE_CURTAIN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_BLUE_CURTAIN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_CURTAIN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_CURTAIN_CORNER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLAZED_TILE_GRID_WINDOW, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CARVED_WOODEN_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SONG_WOODEN_DOOR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SONG_WOODEN_WINDOW, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BAMBOO_CURTAIN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_CANDLE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WARPED_CABINET, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EBONY_CABINET, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_TEA_TABLE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_LANDSCAPE_PAINTING_SCREEN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHESS_TABLE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HIGH_TABLE_WITH_WHITE_TOP, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CENSER_TABLE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PORCELAIN_INLAID_GRAND_CHAIR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PORCELAIN_INLAID_TABLE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAIR_WITH_YELLOW_CUSHION, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PAINTED_CHAIR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_TABLE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_EBONY_TABLE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OAK_BED, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PAINTED_SCREEN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LOTUS_BUD, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_LOTUS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TILTED_LOTUS_LEAF, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_LOTUS_LEAF, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_LOTUS_LEAF_CLUSTER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_LOTUS_LEAF_CLUSTER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_LOTUS_LEAF, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_DARK_GREEN_LOTUS_LEAF, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_LOTUS_LEAF, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_RED_IVY, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_RED_IVY, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_RED_IVY, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_YELLOW_IVY, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_YELLOW_IVY, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_YELLOW_IVY, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_GREEN_IVY, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_GREEN_IVY, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_GREEN_IVY, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_LEAF_PILE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_LEAF_PILE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_LEAF_PILE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_CORAL_BONSAI, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TALL_BLUE_VASE_BONSAI, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BAMBOO_BONSAI, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_PLUM_BONSAI, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_GREETING_PINE_BONSAI, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TALL_BLUE_AND_WHITE_PORCELAIN_BONSAI, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GREEN_PORCELAIN_VASE_BONSAI, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_BONSAI, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_BONSAI, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_GREEN_PORCELAIN_VASE_BONSAI, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_WHITE_PORCELAIN_VASE_BONSAI, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_WHITE_PORCELAIN_VASE_BONSAI, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LARGE_GREETING_PINE_BONSAI, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_WHITE_PORCELAIN_VASE_BONSAI, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MEDIUM_GREETING_PINE_BONSAI, RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOODWORKING_WORKBENCH, RenderType.cutout());
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
