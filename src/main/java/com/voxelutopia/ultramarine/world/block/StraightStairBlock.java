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
import net.minecraft.state.properties.Half;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class StraightStairBlock extends BaseHorizontalDirectionalBlock implements IWaterLoggable {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<Half> HALF = BlockStateProperties.HALF;
    private static final VoxelShape BOTTOM_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    private static final VoxelShape TOP_AABB = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape EAST_SHAPE_BOTTOM = VoxelShapes.or(BOTTOM_AABB, Block.box(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D));
    private static final VoxelShape NORTH_SHAPE_BOTTOM = VoxelShapes.or(BOTTOM_AABB, Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D));
    private static final VoxelShape SOUTH_SHAPE_BOTTOM = VoxelShapes.or(BOTTOM_AABB, Block.box(0.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D));
    private static final VoxelShape WEST_SHAPE_BOTTOM = VoxelShapes.or(BOTTOM_AABB, Block.box(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 16.0D));
    private static final VoxelShape EAST_SHAPE_TOP = VoxelShapes.or(TOP_AABB, Block.box(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));
    private static final VoxelShape NORTH_SHAPE_TOP = VoxelShapes.or(TOP_AABB, Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D));
    private static final VoxelShape SOUTH_SHAPE_TOP = VoxelShapes.or(TOP_AABB, Block.box(0.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D));
    private static final VoxelShape WEST_SHAPE_TOP = VoxelShapes.or(TOP_AABB, Block.box(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 16.0D));

    public StraightStairBlock(BaseBlockProperty property) {
        super(property);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(HALF, Half.BOTTOM)
                .setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    public VoxelShape getShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        boolean bottom = pState.getValue(HALF) == Half.BOTTOM;
        switch (pState.getValue(FACING)) {
            case NORTH:
                return bottom ? NORTH_SHAPE_BOTTOM : NORTH_SHAPE_TOP;
            case SOUTH:
                return bottom ? SOUTH_SHAPE_BOTTOM : SOUTH_SHAPE_TOP;
            case WEST:
                return bottom ? WEST_SHAPE_BOTTOM : WEST_SHAPE_TOP;
            case EAST:
                return bottom ? EAST_SHAPE_BOTTOM : EAST_SHAPE_TOP;
            default:
                return VoxelShapes.empty();
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        Direction direction = pContext.getClickedFace();
        BlockPos blockpos = pContext.getClickedPos();
        FluidState fluidstate = pContext.getLevel().getFluidState(blockpos);
        return this.defaultBlockState()
                .setValue(FACING, pContext.getHorizontalDirection())
                .setValue(HALF, direction != Direction.DOWN && (direction == Direction.UP || !(pContext.getClickLocation().y - (double) blockpos.getY() > 0.5D)) ? Half.BOTTOM : Half.TOP)
                .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(WATERLOGGED, HALF);
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState pState) {
        return true;
    }

}
