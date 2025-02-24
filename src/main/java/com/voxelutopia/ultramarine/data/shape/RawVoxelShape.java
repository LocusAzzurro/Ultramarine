package com.voxelutopia.ultramarine.data.shape;

import org.joml.Vector3f;
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

    public RawVoxelShape(){
        this(0,0,0,16,16,16);
    }

    public RawVoxelShape rotateY(float degrees){
        float radians = (float) Math.toRadians(degrees);
        Vector3f t = new Vector3f(8f);
        minP.sub(t).rotateY(radians).add(t);
        maxP.sub(t).rotateY(radians).add(t);
        XZcorner1.sub(t).rotateY(radians).add(t);
        XZcorner2.sub(t).rotateY(radians).add(t);
        return this;
    }

    public RawVoxelShape rotateZ(float degrees){
        float radians = (float) Math.toRadians(degrees);
        Vector3f t = new Vector3f(8f);
        minP.sub(t).rotateZ(radians).add(t);
        maxP.sub(t).rotateZ(radians).add(t);
        XZcorner1.sub(t).rotateZ(radians).add(t);
        XZcorner2.sub(t).rotateZ(radians).add(t);
        return this;
    }

    public RawVoxelShape mirrorZ(){
        minP.mul(-1, 1, 1).add(16, 0, 0);
        maxP.mul(-1, 1, 1).add(16, 0, 0);
        XZcorner1.mul(-1, 1, 1).add(16, 0, 0);
        XZcorner2.mul(-1, 1, 1).add(16, 0, 0);
        return this;
    }

    public RawVoxelShape mirrorY(){
        minP.mul(1, -1, 1).add(0, 16, 0);
        maxP.mul(1, -1, 1).add(0, 16, 0);
        XZcorner1.mul(1, -1, 1).add(0, 16, 0);
        XZcorner2.mul(1, -1, 1).add(0, 16, 0);
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
