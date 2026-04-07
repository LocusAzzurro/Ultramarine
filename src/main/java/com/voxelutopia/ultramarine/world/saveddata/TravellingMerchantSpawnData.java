package com.voxelutopia.ultramarine.world.saveddata;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.util.datafix.DataFixTypes;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.saveddata.SavedDataType;
import org.jetbrains.annotations.NotNull;

public class TravellingMerchantSpawnData extends SavedData {
    private static final int BASE_SPAWN_CHANCE = 25;

    public static final Codec<TravellingMerchantSpawnData> CODEC = RecordCodecBuilder.create(
            i -> i.group(
                    Codec.INT.optionalFieldOf("spawn_chance", BASE_SPAWN_CHANCE).forGetter(data -> data.spawnChance)
            ).apply(i, TravellingMerchantSpawnData::new)
    );

    public static final SavedDataType<TravellingMerchantSpawnData> TYPE = new SavedDataType<>(
            Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "travelling_merchant_spawn_data"),
            TravellingMerchantSpawnData::new,
            CODEC,
            DataFixTypes.SAVED_DATA_WANDERING_TRADER
    );

    private int spawnChance;

    public TravellingMerchantSpawnData() {
        this(BASE_SPAWN_CHANCE);
    }

    public TravellingMerchantSpawnData(int spawnChance) {
        this.spawnChance = Math.max(BASE_SPAWN_CHANCE, spawnChance);
    }

    public int getSpawnChance() {
        return spawnChance;
    }

    private void setSpawnChanceInternal(int spawnChance) {
        int clamped = Math.max(BASE_SPAWN_CHANCE, Math.min(spawnChance, 100));
        if (this.spawnChance != clamped) {
            this.spawnChance = clamped;
            this.setDirty(true);
        }
    }

    public void setSpawnChance(int spawnChance) {
        setSpawnChanceInternal(spawnChance);
    }

    public void increaseSpawnChance() {
        setSpawnChanceInternal(getSpawnChance() + 25);
    }

    public void resetSpawnChance() {
        setSpawnChanceInternal(BASE_SPAWN_CHANCE);
    }
}

