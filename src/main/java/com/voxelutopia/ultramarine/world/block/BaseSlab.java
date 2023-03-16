package com.voxelutopia.ultramarine.world.block;

import net.minecraft.world.level.block.SlabBlock;

public class BaseSlab extends SlabBlock {

    public BaseSlab() {
        this(BaseBlockProperty.STONE);
    }

    public BaseSlab(BaseBlock block){
        super(block.getProperty().properties);
    }

    public BaseSlab(BaseBlockProperty property){
        super(property.properties);
    }

}
