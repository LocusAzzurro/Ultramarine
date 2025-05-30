package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.shape.ShapeFunction;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
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

public class SixSideBlock extends Block implements BaseBlockPropertyHolder, SimpleWaterloggedBlock, SideBlock {

    protected final BaseBlockProperty property;
    protected final ShapeFunction shapeFunction;
    private final boolean hasCollision;

    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public SixSideBlock(BaseBlockProperty property, ShapeFunction shapeFunction, boolean hasCollision) {
        super(property.copy().properties.noOcclusion().noCollission());
        this.property = property;
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false));
        this.shapeFunction = shapeFunction;
        this.hasCollision = hasCollision;
    }

    public SixSideBlock(BaseBlockProperty property, int sideThickness, boolean hasCollision) {
        this(property, ShapeFunction.sixSideShape(sideThickness), hasCollision);
    }

    public SixSideBlock(BaseBlockProperty property) {
        this(property,  1);
    }

    public SixSideBlock(BaseBlockProperty property, ShapeFunction shapeFunction) {
        this(property, shapeFunction, false);
    }

    public SixSideBlock(BaseBlockProperty property, int sideThickness){
        this(property, sideThickness, false);
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return this.shapeFunction.apply(pState);
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
    public BlockState rotate(BlockState pState, Rotation pRot) {
        BlockState newState = pState;
        Direction facing = pState.getValue(FACING);
        if (facing.getAxis().isHorizontal()){
            newState = newState.setValue(FACING, pRot.rotate(facing));
        }
        return newState;
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        BlockState newState = pState;
        Direction facing = pState.getValue(FACING);
        if (facing.getAxis().isHorizontal()){
            newState = newState.rotate(pMirror.getRotation(facing));
        }
        return newState;
    }

    @Override
    public BaseBlockProperty getProperty() {
        return this.property;
    }



}
