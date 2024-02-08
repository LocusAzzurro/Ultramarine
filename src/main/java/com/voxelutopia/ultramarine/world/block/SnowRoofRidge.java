package com.voxelutopia.ultramarine.world.block;

import com.google.common.collect.ImmutableMap;
import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Map;

public interface SnowRoofRidge {

    IntegerProperty SNOW_LAYERS = ModBlockStateProperties.SNOW_LAYERS;

    ImmutableMap<Integer, Integer> SNOW_STAGES = ImmutableMap.ofEntries(
            Map.entry(0, 0), Map.entry(1, 0), Map.entry(2, 1), Map.entry(3, 1),
            Map.entry(4, 1), Map.entry(5, 2), Map.entry(6, 2), Map.entry(7, 2),
            Map.entry(8, 3), Map.entry(9, 3), Map.entry(10, 3), Map.entry(11, 4),
            Map.entry(12, 4), Map.entry(13, 4), Map.entry(14, 5), Map.entry(15, 5));

    int MAX_SNOW_STAGES = 5;

    default void handleSnow(BlockState pState, Level pLevel, BlockPos pPos){
        if (!pLevel.isClientSide()) {
            int snow = pState.getValue(SNOW_LAYERS);
            snow++;
            BlockState newState = pState.setValue(SNOW_LAYERS, Math.min(15, snow));
            pLevel.setBlockAndUpdate(pPos, newState);
        }
    }

    default void handleSnow(BlockState pState, LevelAccessor pLevel, BlockPos pPos){
        if (!pLevel.isClientSide()) {
            int snow = pState.getValue(SNOW_LAYERS);
            snow++;
            BlockState newState = pState.setValue(SNOW_LAYERS, Math.min(15, snow));
            pLevel.setBlock(pPos, newState, 3);
        }
    }

    default void removeSnow(BlockState pState, Level pLevel, BlockPos pPos){
        if (!pLevel.isClientSide()) {
            int snow = pState.getValue(SNOW_LAYERS);
            snow--;
            BlockState newState = pState.setValue(SNOW_LAYERS, Math.max(0, snow));
            pLevel.setBlockAndUpdate(pPos, newState);
        }
    }

    default InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack item = pPlayer.getItemInHand(pHand);
        if (item.is(Items.SNOWBALL)){
            handleSnow(pState, pLevel, pPos);
            if (!pPlayer.isCreative()) item.shrink(1);
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
        if (item.getItem() instanceof ShovelItem){
            removeSnow(pState, pLevel, pPos);
            if (!pPlayer.isCreative()) {
                item.hurtAndBreak(1, pPlayer, p -> p.broadcastBreakEvent(pHand));
            }
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
        return InteractionResult.PASS;
    }

    DyeColor getColor();

    RoofRidgeType getType();

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
