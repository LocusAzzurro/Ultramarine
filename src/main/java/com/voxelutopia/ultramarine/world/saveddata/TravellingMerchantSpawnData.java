package com.voxelutopia.ultramarine.world.saveddata;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;
import org.jetbrains.annotations.NotNull;

public class TravellingMerchantSpawnData extends SavedData {

    private static final String SPAWN_CHANCE_TAG = "TravellingMerchantSpawnChance";
    public static final String FILE_NAME = "travelling_merchant_spawn_data";
    private static final int BASE_SPAWN_CHANCE = 25;

    private int spawnChance;

    protected TravellingMerchantSpawnData(){
        this.spawnChance = BASE_SPAWN_CHANCE;
    }

    protected TravellingMerchantSpawnData(CompoundTag tag, HolderLookup.Provider lookupProvider){
        if (tag.contains(SPAWN_CHANCE_TAG)){
            this.spawnChance = Math.max(BASE_SPAWN_CHANCE, tag.getInt(SPAWN_CHANCE_TAG));
        }
    }

    public static TravellingMerchantSpawnData create(){
        return new TravellingMerchantSpawnData();
    }

    public static TravellingMerchantSpawnData load(CompoundTag tag, HolderLookup.Provider lookupProvider){
        return new TravellingMerchantSpawnData(tag, lookupProvider);
    }

    @Override
    public @NotNull CompoundTag save(CompoundTag tag, @NotNull HolderLookup.Provider registries) {
        tag.putInt(SPAWN_CHANCE_TAG, spawnChance);
        return tag;
    }

    public int getSpawnChance() {
        return spawnChance;
    }

    private void setSpawnChanceInternal(int spawnChance){
        this.spawnChance = spawnChance;
        setDirty();
    }

    public void setSpawnChance(int spawnChance){
        setSpawnChanceInternal(spawnChance);
    }

    public void increaseSpawnChance(){
        setSpawnChanceInternal(Math.min(getSpawnChance() + 25, 100));
    }

    public void resetSpawnChance(){
        setSpawnChanceInternal(BASE_SPAWN_CHANCE);
    }

}
