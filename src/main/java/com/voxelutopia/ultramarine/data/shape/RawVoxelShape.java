package com.voxelutopia.ultramarine.data.shape;

import com.mojang.math.Vector3f;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RawVoxelShape {

    private final Vector3f minP;
    private final Vector3f maxP;
    private final Vector3f XZcorner1;
    private final Vector3f XZcorner2;

    public RawVoxelShape(double minX, double minY, double minZ, double maxX, double maxY, double maxZ){
        this.minP = new Vector3f((float) minX, (float) minY, (float) minZ);
        this.maxP = new Vector3f((float) maxX, (float) maxY, (float) maxZ);
        this.XZcorner1 = new Vector3f((float) minX, (float) minY, (float) maxZ);
        this.XZcorner2 = new Vector3f((float) maxX, (float) minY, (float) minZ);
    }

    public RawVoxelShape rotateY(float degrees){
        minP.add(-8f, -8f, -8f);
        maxP.add(-8f, -8f, -8f);
        XZcorner1.add(-8f, -8f, -8f);
        XZcorner2.add(-8f, -8f, -8f);
        minP.transform(Vector3f.YP.rotationDegrees(degrees));
        maxP.transform(Vector3f.YP.rotationDegrees(degrees));
        XZcorner1.transform(Vector3f.YP.rotationDegrees(degrees));
        XZcorner2.transform(Vector3f.YP.rotationDegrees(degrees));
        minP.add(8f, 8f, 8f);
        maxP.add(8f, 8f, 8f);
        XZcorner1.add(8f, 8f, 8f);
        XZcorner2.add(8f, 8f, 8f);
        return this;
    }

    public RawVoxelShape copy(){
        return new RawVoxelShape(minP.x(), minP.y(), minP.z(), maxP.x(), maxP.y(), maxP.z());
    }

    public VoxelShape toVoxelShape(){
        Vector3f newMinP = new Vector3f(
                Math.min(Math.min(minP.x(), maxP.x()), Math.min(XZcorner1.x(), XZcorner2.x())),
                Math.min(Math.min(minP.y(), maxP.y()), Math.min(XZcorner1.y(), XZcorner2.y())),
                Math.min(Math.min(minP.z(), maxP.z()), Math.min(XZcorner1.z(), XZcorner2.z())));
        Vector3f newMaxP = new Vector3f(
                Math.max(Math.max(minP.x(), maxP.x()), Math.max(XZcorner1.x(), XZcorner2.x())),
                Math.max(Math.max(minP.y(), maxP.y()), Math.max(XZcorner1.y(), XZcorner2.y())),
                Math.max(Math.max(minP.z(), maxP.z()), Math.max(XZcorner1.z(), XZcorner2.z())));
        return Block.box(newMinP.x(), newMinP.y(), newMinP.z(), newMaxP.x(), newMaxP.y(), newMaxP.z());
    }



}
