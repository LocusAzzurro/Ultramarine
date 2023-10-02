package com.voxelutopia.ultramarine.world.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.Map;

public class CentralAxialBlock extends Block implements AxialBlock, IWaterLoggable {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    protected Map<Direction.Axis, VoxelShape> shapeByAxis;

    private final int thickness;
    private final boolean hasCollision;
    private final int height;

    public CentralAxialBlock(BaseBlockProperty property, int thickness, int height, boolean hasCollision) {
        super(property.properties);
        BlockState state = this.getStateDefinition().any()
                .setValue(WATERLOGGED, Boolean.FALSE)
                .setValue(AXIS, Direction.Axis.X);
        this.registerDefaultState(state);
        this.thickness = thickness;
        this.shapeByAxis = this.makeAxialShapes(thickness, height);
        this.height = height;
        this.hasCollision = hasCollision;
    }

    public CentralAxialBlock(BaseBlockProperty property, int thickness) {
        this(property, thickness, 16, false);
    }

    public CentralAxialBlock(BaseBlockProperty property, int thickness, int height) {
        this(property, thickness, height, true);
    }

    @Override
    public VoxelShape getShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        Direction.Axis axis = pState.getValue(AXIS);
        return this.shapeByAxis.get(axis);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        BlockState state = this.defaultBlockState().setValue(WATERLOGGED, pContext.getLevel().getFluidState(pContext.getClickedPos()).getType() == Fluids.WATER);
        return state.setValue(AXIS, pContext.getHorizontalDirection().getClockWise().getAxis());
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(WATERLOGGED);
        pBuilder.add(AXIS);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        return this.hasCollision ? getShape(pState, pLevel, pPos, pContext) : VoxelShapes.empty();
    }

    @Override
    public Direction.Axis getAxis(BlockState pState) {
        return pState.getValue(AXIS);
    }
}
