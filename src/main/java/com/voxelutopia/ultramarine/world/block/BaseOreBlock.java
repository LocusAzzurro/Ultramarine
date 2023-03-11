package com.voxelutopia.ultramarine.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class BaseOreBlock extends OreBlock {

    private final UniformInt xpRange;
    public static final BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of(Material.STONE)
            .requiresCorrectToolForDrops().strength(3.0F, 3.0F);
    public BaseOreBlock(UniformInt xpRange) {
        super(PROPERTIES);
        this.xpRange = xpRange;
    }

    public BaseOreBlock() {
        this(UniformInt.of(0, 0));
    }

    public BaseOreBlock(int minXp, int maxXp) {
        this(UniformInt.of(minXp, maxXp));
    }

    @Override
    public int getExpDrop(BlockState state, net.minecraft.world.level.LevelReader reader, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? this.xpRange.sample(RANDOM) : 0;
    }
}
