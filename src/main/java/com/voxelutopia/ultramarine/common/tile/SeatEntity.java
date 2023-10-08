package com.voxelutopia.ultramarine.common.tile;

import com.voxelutopia.ultramarine.init.registry.ModEntityTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class SeatEntity extends Entity {

    private static final EntityDataAccessor<Integer> LIFE = SynchedEntityData.defineId(SeatEntity.class, EntityDataSerializers.INT);
    private final int MAX_LIFE = 20;
    private int life;

    public SeatEntity(EntityType<? extends SeatEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.life = 0;
    }

    public SeatEntity(Level level, Vec3 pos) {
        this(ModEntityTypes.SEAT, level);
        this.moveTo(pos);
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level.isClientSide) {
            if (this.getPassengers().isEmpty() || this.level.isEmptyBlock(this.blockPosition())) {
                this.life++;
            }
            if (this.life > MAX_LIFE) this.discard();
        }
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
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        pCompound.getInt("Life");
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putInt("Life", life);
    }

    @Override
    public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }
}