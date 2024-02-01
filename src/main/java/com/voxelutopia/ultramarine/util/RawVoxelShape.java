package com.voxelutopia.ultramarine.util;

import com.mojang.math.Matrix3f;
import com.mojang.math.Vector3f;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RawVoxelShape {

    private final Vector3f minP;
    private final Vector3f maxP;

    public RawVoxelShape(double minX, double minY, double minZ, double maxX, double maxY, double maxZ){
        this.minP = new Vector3f((float) minX, (float) minY, (float) minZ);
        this.maxP = new Vector3f((float) maxX, (float) maxY, (float) maxZ);
    }

    public RawVoxelShape rotateY(float degrees){
        minP.add(-8f, -8f, -8f);
        maxP.add(-8f, -8f, -8f);
        minP.transform(Vector3f.YP.rotationDegrees(degrees));
        maxP.transform(Vector3f.YP.rotationDegrees(degrees));
        minP.add(8f, 8f, 8f);
        maxP.add(8f, 8f, 8f);
        return this;
    }

    public RawVoxelShape copy(){
        return new RawVoxelShape(minP.x(), minP.y(), minP.z(), maxP.x(), maxP.y(), maxP.z());
    }

    public VoxelShape toVoxelShape(){
        Vector3f newMinP = new Vector3f(Math.min(minP.x(), maxP.x()), Math.min(minP.y(), maxP.y()), Math.min(minP.z(), maxP.z()));
        Vector3f newMaxP = new Vector3f(Math.max(minP.x(), maxP.x()), Math.max(minP.y(), maxP.y()), Math.max(minP.z(), maxP.z()));
        return Block.box(newMinP.x(), newMinP.y(), newMinP.z(), newMaxP.x(), newMaxP.y(), newMaxP.z());
    }

}
