package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.BlockRegistry;
import net.minecraft.world.level.block.StairBlock;

public class BaseStairs extends StairBlock {

    public BaseStairs() {
        this(BaseBlockProperty.STONE);
    }

    public BaseStairs(BaseBlock block){
        super(block::defaultBlockState, block.getProperty().properties);
    }

    public BaseStairs(BaseBlockProperty property){
        super(() -> BlockRegistry.CYAN_BRICKS.get().defaultBlockState(), property.properties);
    }
}
