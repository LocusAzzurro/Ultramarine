package com.voxelutopia.ultramarine.common.block;

import net.minecraft.world.level.block.FenceBlock;

public class BaseFence extends FenceBlock implements BaseBlockPropertyHolder{

    private final BaseBlockProperty property;

    public BaseFence() {
        this(BaseBlockProperty.STONE);
    }

    public BaseFence(BaseBlock block){
        super(block.getProperty().properties);
        this.property = block.getProperty();
    }

    public BaseFence(BaseBlockProperty property){
        super(property.properties);
        this.property = property;
    }

    @Override
    public BaseBlockProperty getProperty() {
        return property;
    }
}
