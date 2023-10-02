package com.voxelutopia.ultramarine.world.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class BeamHead extends BaseHorizontalDirectionalBlock implements IWaterLoggable {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape SOUTH_SHAPE = VoxelShapes.or(Block.box(4.0D, 2.0D, 0.0D, 12.0D, 14.0D, 8.0D),
            Block.box(4.0D, 6.0D, 8.0D, 12.0D, 14.0D, 10.0D));
    private static final VoxelShape EAST_SHAPE = VoxelShapes.or(Block.box(0.0D, 2.0D, 4.0D, 8.0D, 14.0D, 12.0D),
            Block.box(8.0D, 6.0D, 4.0D, 10.0D, 14.0D, 12.0D));
    private static final VoxelShape NORTH_SHAPE = VoxelShapes.or(Block.box(4.0D, 2.0D, 8.0D, 12.0D, 14.0D, 16.0D),
            Block.box(4.0D, 6.0D, 6.0D, 12.0D, 14.0D, 8.0D));
    private static final VoxelShape WEST_SHAPE = VoxelShapes.or(Block.box(8.0D, 2.0D, 4.0D, 16.0D, 14.0D, 12.0D),
            Block.box(6.0D, 6.0D, 4.0D, 8.0D, 14.0D, 12.0D));

    public BeamHead(BaseBlockProperty property) {
        super(property.copy());
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    public VoxelShape getShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        switch (pState.getValue(FACING)) {
            case NORTH:
                return NORTH_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            case EAST:
                return EAST_SHAPE;
            default:
                return VoxelShapes.empty();
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        return this.defaultBlockState()
                .setValue(FACING, pContext.getHorizontalDirection().getOpposite())
                .setValue(WATERLOGGED, pContext.getLevel().getFluidState(pContext.getClickedPos()).getType() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(WATERLOGGED);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        return VoxelShapes.empty();
    }


}
