package com.voxelutopia.ultramarine.data.shape;

public class BlockShapes {

    public static final ShapeFunction S16_H1 = ShapeFunction.centeredSquare(16, 1);
    public static final ShapeFunction S16_H2 = ShapeFunction.centeredSquare(16, 2);
    public static final ShapeFunction S16_H4 = ShapeFunction.centeredSquare(16, 4);
    public static final ShapeFunction S16_H8 = ShapeFunction.centeredSquare(16, 8);
    public static final ShapeFunction S16_H16 = ShapeFunction.centeredSquare(16, 16);

    public static final ShapeFunction BACKWARD_3B_L = ShapeFunction.or(ShapeFunction.cardinalRotations(new RawVoxelShape(0,0,0,16,16,32)), ShapeFunction.cardinalRotations(new RawVoxelShape(0,16,0,16,32,16)));

}
