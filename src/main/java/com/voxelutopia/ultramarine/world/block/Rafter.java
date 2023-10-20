package com.voxelutopia.ultramarine.world.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class Rafter extends ShiftableBlock {

    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;

    public Rafter(BaseBlockProperty property) {
        super(property.copy().properties.noOcclusion());
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(AXIS, Direction.Axis.X)
                .setValue(SHIFTED, Boolean.FALSE)
                .setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(AXIS);
    }

    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        return super.getStateForPlacement(pContext).setValue(AXIS, pContext.getHorizontalDirection().getAxis());
    }

    @Override
    public VoxelShape getShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        return Block.box(0.0D, 10.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        return VoxelShapes.empty();
    }

    @Override
    public BlockRenderType getRenderShape(BlockState pState) {
        return BlockRenderType.MODEL;
    }


}
