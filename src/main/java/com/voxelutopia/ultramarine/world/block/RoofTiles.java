package com.voxelutopia.ultramarine.world.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class RoofTiles extends ShiftableBlock {

    public static final AbstractBlock.Properties PROPERTIES = AbstractBlock.Properties.of(Material.STONE)
            .requiresCorrectToolForDrops().strength(1.5F, 4.0F).sound(SoundType.STONE); // Deepslate was not introduced in 1.16
    public static final DirectionProperty FACING = HorizontalBlock.FACING;

    public RoofTiles() {
        super(PROPERTIES);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(SHIFTED, Boolean.FALSE)
                .setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(FACING);
    }

    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        return super.getStateForPlacement(pContext).setValue(FACING, pContext.getHorizontalDirection());
    }


    @Override
    public VoxelShape getShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        return Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    }

    public enum RoofTileType implements ShiftedTileType {
        NORMAL("roof_tiles"), STAIRS("roof_tile_stairs"), EDGE("roof_tile_edge");

        String blockName;

        RoofTileType(String blockName) {
            this.blockName = blockName;
        }

        @Override
        public String toString() {
            return blockName;
        }
    }


}
