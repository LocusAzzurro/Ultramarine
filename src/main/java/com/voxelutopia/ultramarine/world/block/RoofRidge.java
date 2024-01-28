package com.voxelutopia.ultramarine.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

public class RoofRidge extends BaseBlock implements SnowRoofRidge{

    private final DyeColor color;
    private final RoofRidgeType type;

    public RoofRidge(DyeColor color, RoofRidgeType type){
        super(BaseBlockProperty.STONE);
        this.type = type;
        this.color = color;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(SNOW_LAYERS, 0));
    }

    @Override
    public void handlePrecipitation(BlockState pState, Level pLevel, BlockPos pPos, Biome.Precipitation pPrecipitation) {
        //todo
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(SNOW_LAYERS);
    }

    public DyeColor getColor() {
        return color;
    }

    public RoofRidgeType getType() {
        return type;
    }
}
