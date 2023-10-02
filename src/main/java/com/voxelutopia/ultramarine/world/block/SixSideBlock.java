package com.voxelutopia.ultramarine.world.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.Map;

public class SixSideBlock extends Block implements BaseBlockPropertyHolder, IWaterLoggable, SideBlock {

    protected final BaseBlockProperty property;
    private final Map<Direction, VoxelShape> shapeByDirection;
    private final boolean hasCollision;

    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public SixSideBlock(BaseBlockProperty property, int sideThickness, boolean hasCollision) {
        super(property.copy().properties.noOcclusion().noCollission());
        this.property = property;
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false));
        this.shapeByDirection = faceShapeByDirection(sideThickness);
        this.hasCollision = hasCollision;
    }

    public SixSideBlock(BaseBlockProperty property) {
        this(property, 1);
    }

    public SixSideBlock(BaseBlockProperty property, int sideThickness) {
        this(property, sideThickness, false);
    }

    public VoxelShape getShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        return this.shapeByDirection.get(pState.getValue(FACING));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        Direction face = pContext.getClickedFace();
        return this.defaultBlockState()
                .setValue(WATERLOGGED, pContext.getLevel().getFluidState(pContext.getClickedPos()).getType() == Fluids.WATER)
                .setValue(FACING, face);
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, WATERLOGGED);
    }

    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        return hasCollision ? this.getShape(pState, pLevel, pPos, pContext) : VoxelShapes.empty();
    }

    @Override
    public BaseBlockProperty getProperty() {
        return this.property;
    }


}
