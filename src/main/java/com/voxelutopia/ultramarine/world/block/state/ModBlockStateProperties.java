package com.voxelutopia.ultramarine.world.block.state;

import com.voxelutopia.ultramarine.world.block.RoofTiles;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class ModBlockStateProperties {

    public static final BooleanProperty DIAGONAL = BooleanProperty.create("diagonal");
    public static final BooleanProperty SHIFTED = BooleanProperty.create("shifted");
    public static final BooleanProperty LOCKED = BooleanProperty.create("locked");
    public static final DirectionProperty HORIZONTAL_FACING_SHIFT = DirectionProperty.create("facing_shift", Direction.Plane.HORIZONTAL);
    public static final DirectionProperty ON_FACE_DIRECTION = DirectionProperty.create("direction");
    public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 8);
    public static final IntegerProperty VARIANT = IntegerProperty.create("variant", 0, 7);
    public static final EnumProperty<ChiralBlockType> CHIRAL_BLOCK_TYPE = EnumProperty.create("type", ChiralBlockType.class);
    public static final EnumProperty<OrientableBlockType> ORIENTABLE_BLOCK_TYPE = EnumProperty.create("type", OrientableBlockType.class);
    public static final EnumProperty<StackableBlockType> STACKABLE_BLOCK_TYPE = EnumProperty.create("type", StackableBlockType.class);
    public static final IntegerProperty SNOW_LAYERS = IntegerProperty.create("snow_layers", 0, 15);
    public static final EnumProperty<RoofTiles.SnowSide> SNOW_SIDE = EnumProperty.create("snow_side", RoofTiles.SnowSide.class);
    public static final IntegerProperty LANTERNS = IntegerProperty.create("lanterns", 0, 3);
    public static final BooleanProperty LEFT = BooleanProperty.create("left");
    public static final BooleanProperty RIGHT = BooleanProperty.create("right");
}
