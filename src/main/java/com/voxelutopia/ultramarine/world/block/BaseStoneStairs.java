package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.BlockRegistry;
import net.minecraft.world.level.block.StairBlock;

public class BaseStoneStairs extends StairBlock {
    public BaseStoneStairs() {
        super(() -> BlockRegistry.CYAN_BRICKS.get().defaultBlockState(), BaseStone.PROPERTIES);
    }
}
