package com.voxelutopia.ultramarine.world.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BaseOreBlock extends DropExperienceBlock {

    private final UniformInt xpRange;
    public static final BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of()
            .requiresCorrectToolForDrops().strength(3.0F, 3.0F);

    public BaseOreBlock(UniformInt xpRange) {
        super(xpRange, PROPERTIES);
        this.xpRange = xpRange;
    }

    public BaseOreBlock() {
        this(UniformInt.of(0, 0));
    }

    public BaseOreBlock(int minXp, int maxXp) {
        this(UniformInt.of(minXp, maxXp));
    }

}
