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
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

public class SixSideBlock extends Block implements BaseBlockPropertyHolder, SimpleWaterloggedBlock, SideBlock {

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
        this(property,  1);
    }

    public SixSideBlock(BaseBlockProperty property, int sideThickness){
        this(property, sideThickness, false);
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return this.shapeByDirection.get(pState.getValue(FACING));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction face = pContext.getClickedFace();
        return this.defaultBlockState()
                .setValue(WATERLOGGED, pContext.getLevel().getFluidState(pContext.getClickedPos()).getType() == Fluids.WATER)
                .setValue(FACING, face);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, WATERLOGGED);
    }

    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return hasCollision ? this.getShape(pState, pLevel, pPos, pContext) : Shapes.empty();
    }

    @Override
    public BaseBlockProperty getProperty() {
        return this.property;
    }



}
