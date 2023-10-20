package com.voxelutopia.ultramarine.world.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.RangedInteger;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class BaseOreBlock extends OreBlock {

    private final RangedInteger xpRange;
    public static final AbstractBlock.Properties PROPERTIES = AbstractBlock.Properties.of(Material.STONE)
            .requiresCorrectToolForDrops().strength(3.0F, 3.0F);

    public BaseOreBlock(RangedInteger xpRange) {
        super(PROPERTIES);
        this.xpRange = xpRange;
    }

    public BaseOreBlock() {
        this(RangedInteger.of(0, 0));
    }

    public BaseOreBlock(int minXp, int maxXp) {
        this(RangedInteger.of(minXp, maxXp));
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? this.xpRange.randomValue(RANDOM) : 0;
    }
}
