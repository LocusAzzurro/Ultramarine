package com.voxelutopia.ultramarine.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

public class CentralAxialBlock extends Block implements AxialBlock, SimpleWaterloggedBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    protected Map<Direction.Axis, VoxelShape> shapeByAxis;

    private final int thickness;
    private final boolean hasCollision;
    private final int height;

    public CentralAxialBlock(BaseBlockProperty property, int thickness, int height, boolean hasCollision) {
        super(property.properties);
        BlockState state = this.stateDefinition.any()
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
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction.Axis axis = pState.getValue(AXIS);
        return this.shapeByAxis.get(axis);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState state = this.defaultBlockState().setValue(WATERLOGGED, pContext.getLevel().getFluidState(pContext.getClickedPos()).getType() == Fluids.WATER);
        return state.setValue(AXIS, pContext.getHorizontalDirection().getClockWise().getAxis());
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(WATERLOGGED);
        pBuilder.add(AXIS);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Shapes.empty();
    }

    @Override
    public Direction.Axis getAxis(BlockState pState) {
        return pState.getValue(AXIS);
    }
}
