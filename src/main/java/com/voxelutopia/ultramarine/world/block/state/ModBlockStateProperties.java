package com.voxelutopia.ultramarine.world.block.state;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.*;

public class ModBlockStateProperties {

    public static final BooleanProperty DIAGONAL = BooleanProperty.create("diagonal");
    public static final BooleanProperty SHIFTED = BooleanProperty.create("shifted");
    public static final DirectionProperty HORIZONTAL_FACING_SHIFT = DirectionProperty.create("facing_shift", Direction.Plane.HORIZONTAL);
    public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 8);
    public static final EnumProperty<ChiralBlockType> CHIRAL_BLOCK_TYPE = EnumProperty.create("type", ChiralBlockType.class);

}
