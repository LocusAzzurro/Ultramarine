package com.voxelutopia.ultramarine.world.item;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class BlueAndWhitePorcelainUpgradeSmithingTemplate extends SmithingTemplateItem {

    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
    private static final Component BLUE_AND_WHITE_PORCELAIN_UPGRADE_APPLIES_TO =
            Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Ultramarine.MOD_ID, "smithing_template.blue_and_white_porcelain_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component BLUE_AND_WHITE_PORCELAIN_UPGRADE_INGREDIENT =
            Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Ultramarine.MOD_ID, "smithing_template.blue_and_white_porcelain_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component BLUE_AND_WHITE_PORCELAIN_UPGRADE =
            Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation(Ultramarine.MOD_ID, "blue_and_white_porcelain_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component BLUE_AND_WHITE_PORCELAIN_UPGRADE_BASE_SLOT_DESCRIPTION =
            Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Ultramarine.MOD_ID, "smithing_template.blue_and_white_porcelain_upgrade.base_slot_description")));
    private static final Component BLUE_AND_WHITE_PORCELAIN_UPGRADE_ADDITIONS_SLOT_DESCRIPTION =
            Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Ultramarine.MOD_ID, "smithing_template.blue_and_white_porcelain_upgrade.additions_slot_description")));
    private static final ResourceLocation EMPTY_SLOT_PIECE =
            new ResourceLocation(Ultramarine.MOD_ID, "item/empty_slot_piece");
    private static final ResourceLocation EMPTY_SLOT_AXE = new ResourceLocation(ResourceLocation.DEFAULT_NAMESPACE, "item/empty_slot_axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD = new ResourceLocation(ResourceLocation.DEFAULT_NAMESPACE, "item/empty_slot_sword");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = new ResourceLocation(ResourceLocation.DEFAULT_NAMESPACE, "item/empty_slot_shovel");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = new ResourceLocation(ResourceLocation.DEFAULT_NAMESPACE, "item/empty_slot_pickaxe");


    public BlueAndWhitePorcelainUpgradeSmithingTemplate() {
        super(
                BLUE_AND_WHITE_PORCELAIN_UPGRADE_APPLIES_TO,
                BLUE_AND_WHITE_PORCELAIN_UPGRADE_INGREDIENT,
                BLUE_AND_WHITE_PORCELAIN_UPGRADE,
                BLUE_AND_WHITE_PORCELAIN_UPGRADE_BASE_SLOT_DESCRIPTION,
                BLUE_AND_WHITE_PORCELAIN_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                List.of(EMPTY_SLOT_SWORD, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_AXE, EMPTY_SLOT_SHOVEL),
                List.of(EMPTY_SLOT_PIECE)
        );
    }
}
