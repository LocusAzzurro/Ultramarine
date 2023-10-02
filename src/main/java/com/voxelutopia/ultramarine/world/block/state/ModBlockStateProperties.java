package com.voxelutopia.ultramarine.world.block.state;

import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.util.Direction;

public class ModBlockStateProperties {

    public static final BooleanProperty DIAGONAL = BooleanProperty.create("diagonal");
    public static final BooleanProperty SHIFTED = BooleanProperty.create("shifted");
    public static final BooleanProperty LOCKED = BooleanProperty.create("locked");
    public static final DirectionProperty HORIZONTAL_FACING_SHIFT = DirectionProperty.create("facing_shift", Direction.Plane.HORIZONTAL);
    public static final DirectionProperty ON_FACE_DIRECTION = DirectionProperty.create("direction", Direction.values());
    // Passing only one param will call DirectionProperty#create(String) in 1.18.2, but DirectionProperty#create(String, Direction...) in 1.16.5. Really frustrating :((
    public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 8);
    public static final IntegerProperty VARIANT = IntegerProperty.create("variant", 0, 7);
    public static final EnumProperty<ChiralBlockType> CHIRAL_BLOCK_TYPE = EnumProperty.create("type", ChiralBlockType.class);
    public static final EnumProperty<OrientableBlockType> ORIENTABLE_BLOCK_TYPE = EnumProperty.create("type", OrientableBlockType.class);
    public static final EnumProperty<StackableBlockType> STACKABLE_BLOCK_TYPE = EnumProperty.create("type", StackableBlockType.class);

}
