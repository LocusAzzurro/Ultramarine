package com.voxelutopia.ultramarine.data;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;

public final class ModToolMaterials {
    private ModToolMaterials() {
    }

    public static final ToolMaterial BLUE_AND_WHITE_PORCELAIN = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            16,
            14.0F,
            5.0F,
            24,
            ModItemTags.BLUE_AND_WHITE_PORCELAIN_REPAIR_MATERIALS
    );
}

