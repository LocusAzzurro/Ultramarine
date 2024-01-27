package com.voxelutopia.ultramarine.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

public class RoofTiles extends ShiftableBlock{

    public static final BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of(Material.STONE)
            .requiresCorrectToolForDrops().strength(1.5F, 4.0F).sound(SoundType.DEEPSLATE_TILES);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final IntegerProperty SNOW_LAYERS = IntegerProperty.create("snow_layers", 0, 15);

    public RoofTiles(){
        super(PROPERTIES);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(SHIFTED, Boolean.FALSE)
                .setValue(WATERLOGGED, Boolean.FALSE)
                .setValue(SNOW_LAYERS, 0));
    }

    @Override
    public void handlePrecipitation(BlockState pState, Level pLevel, BlockPos pPos, Biome.Precipitation pPrecipitation) {
        if (pPrecipitation == Biome.Precipitation.SNOW) {
            int snow = pState.getValue(SNOW_LAYERS);
            pLevel.setBlockAndUpdate(pPos, pState.setValue(SNOW_LAYERS, Math.min(15, snow + 1)));
        }
        super.handlePrecipitation(pState, pLevel, pPos, pPrecipitation);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(FACING);
        pBuilder.add(SNOW_LAYERS);
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return super.getStateForPlacement(pContext).setValue(FACING, pContext.getHorizontalDirection());
    }


    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    }

    public enum RoofTileType implements ShiftedTileType{
        NORMAL("roof_tiles", Map.ofEntries(
                Map.entry(0, Pair.of(0, false)), Map.entry(1, Pair.of(1, false)), Map.entry(2, Pair.of(2, false)), Map.entry(3, Pair.of(2, false)),
                Map.entry(4, Pair.of(3, true)), Map.entry(5, Pair.of(4, true)), Map.entry(6, Pair.of(4, true)), Map.entry(7, Pair.of(5, true)),
                Map.entry(8, Pair.of(6, true)), Map.entry(9, Pair.of(7, true)), Map.entry(10, Pair.of(7, true)), Map.entry(11, Pair.of(8, true)),
                Map.entry(12, Pair.of(9, true)), Map.entry(13, Pair.of(10, true)), Map.entry(14, Pair.of(11, true)), Map.entry(15, Pair.of(11, true))
        ), 11),
        STAIRS("roof_tile_stairs", Map.ofEntries(
                Map.entry(0, Pair.of(0, false)), Map.entry(1, Pair.of(1, false)), Map.entry(2, Pair.of(1, false)), Map.entry(3, Pair.of(1, false)),
                Map.entry(4, Pair.of(1, false)), Map.entry(5, Pair.of(1, false)), Map.entry(6, Pair.of(2, true)), Map.entry(7, Pair.of(2, true)),
                Map.entry(8, Pair.of(2, true)), Map.entry(9, Pair.of(3, true)), Map.entry(10, Pair.of(3, true)), Map.entry(11, Pair.of(3, true)),
                Map.entry(12, Pair.of(4, true)), Map.entry(13, Pair.of(4, true)), Map.entry(14, Pair.of(4, true)), Map.entry(15, Pair.of(5, true))
        ), 5),
        EDGE("roof_tile_edge", Map.ofEntries(
                Map.entry(0, Pair.of(0, false)), Map.entry(1, Pair.of(1, true)), Map.entry(2, Pair.of(1, true)), Map.entry(3, Pair.of(1, true)),
                Map.entry(4, Pair.of(1, true)), Map.entry(5, Pair.of(1, true)), Map.entry(6, Pair.of(1, true)), Map.entry(7, Pair.of(2, true)),
                Map.entry(8, Pair.of(2, true)), Map.entry(9, Pair.of(2, true)), Map.entry(10, Pair.of(2, true)), Map.entry(11, Pair.of(2, true)),
                Map.entry(12, Pair.of(2, true)), Map.entry(13, Pair.of(3, true)), Map.entry(14, Pair.of(3, true)), Map.entry(15, Pair.of(3, true))
        ), 3),;

        String blockName;
        Map<Integer, Pair<Integer, Boolean>> snowStages;
        Integer maxSnowStages;

        RoofTileType(String blockName, Map<Integer, Pair<Integer, Boolean>> snowStages, int maxSnowStages){
            this.blockName = blockName;
            this.snowStages = snowStages;
            this.maxSnowStages = maxSnowStages;
        }

        public Map<Integer, Pair<Integer, Boolean>> getSnowStages() {
            return snowStages;
        }

        public Integer getMaxSnowStages() {
            return maxSnowStages;
        }

        @Override
        public String toString() {
            return blockName;
        }
    }


}
