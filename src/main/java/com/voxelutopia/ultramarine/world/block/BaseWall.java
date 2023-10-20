package com.voxelutopia.ultramarine.world.block;

import net.minecraft.block.WallBlock;

public class BaseWall extends WallBlock implements BaseBlockPropertyHolder {

    private final BaseBlockProperty property;

    public BaseWall() {
        this(BaseBlockProperty.STONE);
    }

    public BaseWall(BaseBlock block) {
        super(block.getProperty().properties);
        this.property = block.getProperty();
    }

    public BaseWall(BaseBlockProperty property) {
        super(property.properties);
        this.property = property;
    }

    @Override
    public BaseBlockProperty getProperty() {
        return property;
    }
}
