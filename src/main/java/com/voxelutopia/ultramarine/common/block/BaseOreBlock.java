package com.voxelutopia.ultramarine.common.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class BaseOreBlock extends DropExperienceBlock {

    public static final BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of(Material.STONE)
            .requiresCorrectToolForDrops().strength(3.0F, 3.0F);

    public BaseOreBlock(UniformInt xpRange) {
        super(PROPERTIES, xpRange);
    }

    public BaseOreBlock() {
        this(UniformInt.of(0, 0));
    }

    public BaseOreBlock(int minXp, int maxXp) {
        this(UniformInt.of(minXp, maxXp));
    }

}
