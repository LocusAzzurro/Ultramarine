package com.voxelutopia.ultramarine.world.block;

import net.minecraft.world.level.block.SlabBlock;

public class BaseSlab extends SlabBlock implements BaseBlockPropertyHolder {

    private final BaseBlockProperty property;

    public BaseSlab() {
        this(BaseBlockProperty.STONE);
    }

    public BaseSlab(BaseBlock block){
        super(block.getProperty().properties);
        this.property = block.getProperty();
    }

    public BaseSlab(BaseBlockProperty property){
        super(property.properties);
        this.property = property;
    }

    @Override
    public BaseBlockProperty getProperty() {
        return property;
    }
}
