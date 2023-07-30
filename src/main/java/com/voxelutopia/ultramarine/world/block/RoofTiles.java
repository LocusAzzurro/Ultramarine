package com.voxelutopia.ultramarine.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RoofTiles extends ShiftableBlock{

    public static final BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of()
            .requiresCorrectToolForDrops().strength(1.5F, 4.0F).sound(SoundType.DEEPSLATE_TILES);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public RoofTiles(){
        super(PROPERTIES);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(SHIFTED, Boolean.FALSE)
                .setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return super.getStateForPlacement(pContext).setValue(FACING, pContext.getHorizontalDirection());
    }


    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    }

    public enum RoofTileType implements ShiftedTileType{
        NORMAL("roof_tiles"), STAIRS("roof_tile_stairs"), EDGE("roof_tile_edge");

        String blockName;
        RoofTileType(String blockName){
            this.blockName = blockName;
        }

        @Override
        public String toString() {
            return blockName;
        }
    }


}
