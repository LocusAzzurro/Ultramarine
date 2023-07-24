package com.voxelutopia.ultramarine.world.block;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

public class BaseAxisBlock extends RotatedPillarBlock implements BaseBlockPropertyHolder {

    protected final BaseBlockProperty property;

    public BaseAxisBlock(BaseBlock block){
        this(block.getProperty());
    }

    public BaseAxisBlock(BaseBlockProperty property){
        super(property.properties);
        this.property = property;
        this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.Y));
    }

    @Override
    public BaseBlockProperty getProperty() {
        return property;
    }
}
