package com.voxelutopia.ultramarine.data;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class ModBlockStateProperties {

    public static final BooleanProperty DIAGONAL = BooleanProperty.create("diagonal");
    public static final BooleanProperty SHIFTED = BooleanProperty.create("shifted");
    public static final DirectionProperty HORIZONTAL_FACING_SHIFT = DirectionProperty.create("facing_shift", Direction.Plane.HORIZONTAL);

}
