package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.shape.ShapeFunction;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class WallSideBlock extends Block implements BaseBlockPropertyHolder, SimpleWaterloggedBlock, SideBlock {

    protected final BaseBlockProperty property;
    private final ShapeFunction shapeFunction;

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public WallSideBlock(BaseBlockProperty property, ShapeFunction shapeFunction) {
        super(property.copy().properties.noOcclusion().noCollission());
        this.property = property;
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false));
        this.shapeFunction = shapeFunction;
    }

    public WallSideBlock(BaseBlockProperty property, int sideThickness) {
        this(property, ShapeFunction.sideShape(sideThickness));
    }

    public WallSideBlock(BaseBlockProperty property) {
        this(property, 1);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return this.shapeFunction.apply(pState);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState state = this.defaultBlockState();
        FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());

        Direction direction = pContext.getClickedFace();
        if (direction.getAxis().isHorizontal()){
            return state.setValue(FACING, direction)
                    .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
        }
        return null;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRot) {
        return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    public BaseBlockProperty getProperty() {
        return this.property;
    }
}
