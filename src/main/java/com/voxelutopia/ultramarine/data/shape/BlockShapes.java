package com.voxelutopia.ultramarine.data.shape;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Function;

public class BlockShapes {

    public static final ShapeFunction S16_H1 = ShapeFunction.centeredSquare(16, 1);
    public static final ShapeFunction S16_H2 = ShapeFunction.centeredSquare(16, 2);
    public static final ShapeFunction S16_H4 = ShapeFunction.centeredSquare(16, 4);

}
