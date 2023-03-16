package com.voxelutopia.ultramarine.world.block;

import net.minecraft.world.level.block.WallBlock;

public class BaseWall extends WallBlock {

    public BaseWall() {
        this(BaseBlockProperty.STONE);
    }

    public BaseWall(BaseBlock block){
        super(block.getProperty().properties);
    }

    public BaseWall(BaseBlockProperty property){
        super(property.properties);
    }
}
