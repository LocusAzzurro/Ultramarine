package com.voxelutopia.ultramarine.world.block;

import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.util.Direction;

public class BasePillarBlock extends RotatedPillarBlock implements BaseBlockPropertyHolder {

    protected final BaseBlockProperty property;

    public BasePillarBlock(BaseBlock block) {
        this(block.getProperty());
    }

    public BasePillarBlock(BaseBlockProperty property) {
        super(property.properties);
        this.property = property;
        this.registerDefaultState(this.getStateDefinition().any().setValue(AXIS, Direction.Axis.Y));
    }

    @Override
    public BaseBlockProperty getProperty() {
        return property;
    }
}
