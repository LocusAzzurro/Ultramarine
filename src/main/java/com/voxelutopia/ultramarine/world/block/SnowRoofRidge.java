package com.voxelutopia.ultramarine.world.block;

import com.google.common.collect.ImmutableMap;
import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.Map;

public interface SnowRoofRidge {

    IntegerProperty SNOW_LAYERS = ModBlockStateProperties.SNOW_LAYERS;

    ImmutableMap<Integer, Integer> SNOW_STAGES = ImmutableMap.ofEntries(
            Map.entry(0, 0), Map.entry(1, 0), Map.entry(2, 1), Map.entry(3, 1),
            Map.entry(4, 1), Map.entry(5, 2), Map.entry(6, 2), Map.entry(7, 2),
            Map.entry(8, 3), Map.entry(9, 3), Map.entry(10, 3), Map.entry(11, 4),
            Map.entry(12, 4), Map.entry(13, 4), Map.entry(14, 5), Map.entry(15, 5));

    int MAX_SNOW_STAGES = 5;

    enum RoofRidgeType implements StringRepresentable {
        UPPER("roof_ridge_upper"), LOWER("roof_ridge_lower"), CONNECTION("roof_ridge_connection"), MAIN_CONNECTION("main_roof_ridge_connection");

        String name;

        RoofRidgeType(String name){
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return name;
        }
    }

}
