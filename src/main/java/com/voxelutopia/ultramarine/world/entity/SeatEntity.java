package com.voxelutopia.ultramarine.world.entity;

import com.voxelutopia.ultramarine.data.registry.EntityTypeRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class SeatEntity extends Entity {

    private final int MAX_LIFE = 20;
    private int life;

    private static final DataParameter<Integer> LIFE = EntityDataManager.defineId(SeatEntity.class, DataSerializers.INT);

    public SeatEntity(EntityType<? extends SeatEntity> pEntityType, World pLevel) {
        super(pEntityType, pLevel);
        this.life = 0;
    }

    public SeatEntity(World level, Vector3d pos) {
        this(EntityTypeRegistry.SEAT.get(), level);
        this.moveTo(pos);
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level().isClientSide) {
            if (this.getPassengers().isEmpty() || this.level().isEmptyBlock(this.blockPosition())) {
                this.life++;
            }
            if (this.life > MAX_LIFE) this.remove();
        }
    }

    private World level() {
        return this.level;
    }

    @Override
    public double getPassengersRidingOffset() {
        return 0.0;
    }

    @Override
    protected boolean canRide(Entity entity) {
        return true;
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(LIFE, 0);
    }

    @Override
    protected void readAdditionalSaveData(CompoundNBT pCompound) {
        pCompound.getInt("Life");
    }

    @Override
    protected void addAdditionalSaveData(CompoundNBT pCompound) {
        pCompound.putInt("Life", life);
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
