package com.voxelutopia.ultramarine.world.item;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class BlueAndWhitePorcelainUpgradeSmithingTemplate extends SmithingTemplateItem {

    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
    private static final Component BLUE_AND_WHITE_PORCELAIN_UPGRADE_APPLIES_TO =
            Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "smithing_template.blue_and_white_porcelain_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component BLUE_AND_WHITE_PORCELAIN_UPGRADE_INGREDIENT =
            Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "smithing_template.blue_and_white_porcelain_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component BLUE_AND_WHITE_PORCELAIN_UPGRADE_BASE_SLOT_DESCRIPTION =
            Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "smithing_template.blue_and_white_porcelain_upgrade.base_slot_description")));
    private static final Component BLUE_AND_WHITE_PORCELAIN_UPGRADE_ADDITIONS_SLOT_DESCRIPTION =
            Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "smithing_template.blue_and_white_porcelain_upgrade.additions_slot_description")));
    private static final Identifier EMPTY_SLOT_PIECE =
            Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "item/empty_slot_piece");
    private static final Identifier EMPTY_SLOT_AXE = Identifier.withDefaultNamespace("container/slot/axe");
    private static final Identifier EMPTY_SLOT_SWORD = Identifier.withDefaultNamespace("container/slot/sword");
    private static final Identifier EMPTY_SLOT_SHOVEL = Identifier.withDefaultNamespace("container/slot/shovel");
    private static final Identifier EMPTY_SLOT_PICKAXE = Identifier.withDefaultNamespace("container/slot/pickaxe");


    public BlueAndWhitePorcelainUpgradeSmithingTemplate(Item.Properties properties) {
        super(
                BLUE_AND_WHITE_PORCELAIN_UPGRADE_APPLIES_TO,
                BLUE_AND_WHITE_PORCELAIN_UPGRADE_INGREDIENT,
                BLUE_AND_WHITE_PORCELAIN_UPGRADE_BASE_SLOT_DESCRIPTION,
                BLUE_AND_WHITE_PORCELAIN_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
                List.of(EMPTY_SLOT_SWORD, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_AXE, EMPTY_SLOT_SHOVEL),
                List.of(EMPTY_SLOT_PIECE),
                properties
        );
    }
}