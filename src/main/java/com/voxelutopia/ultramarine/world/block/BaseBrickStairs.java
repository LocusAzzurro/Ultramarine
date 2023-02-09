package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.BlockRegistry;
import net.minecraft.world.level.block.StairBlock;

public class BaseBrickStairs extends StairBlock {
    public BaseBrickStairs() {
        super(() -> BlockRegistry.CYAN_BRICKS.get().defaultBlockState(), BaseBricks.PROPERTIES);
    }
}
