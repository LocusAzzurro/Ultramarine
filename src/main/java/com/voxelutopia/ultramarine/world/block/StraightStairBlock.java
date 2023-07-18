package com.voxelutopia.ultramarine.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.entity.Hopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StraightStairBlock extends BaseHorizontalDirectionalBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<Half> HALF = BlockStateProperties.HALF;
    private static final VoxelShape BOTTOM_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    private static final VoxelShape TOP_AABB = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    private static final VoxelShape EAST_SHAPE_BOTTOM = Shapes.or(BOTTOM_AABB, Block.box(8.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D));
    private static final VoxelShape NORTH_SHAPE_BOTTOM = Shapes.or(BOTTOM_AABB, Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D));
    private static final VoxelShape SOUTH_SHAPE_BOTTOM = Shapes.or(BOTTOM_AABB, Block.box(0.0D, 8.0D, 8.0D, 16.0D, 16.0D, 16.0D));
    private static final VoxelShape WEST_SHAPE_BOTTOM = Shapes.or(BOTTOM_AABB, Block.box(0.0D, 8.0D, 0.0D, 8.0D, 16.0D, 16.0D));
    private static final VoxelShape EAST_SHAPE_TOP = Shapes.or(TOP_AABB, Block.box(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));
    private static final VoxelShape NORTH_SHAPE_TOP = Shapes.or(TOP_AABB, Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D));
    private static final VoxelShape SOUTH_SHAPE_TOP = Shapes.or(TOP_AABB, Block.box(0.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D));
    private static final VoxelShape WEST_SHAPE_TOP = Shapes.or(TOP_AABB, Block.box(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 16.0D));

    public StraightStairBlock(BaseBlockProperty property) {
        super(property);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(HALF, Half.BOTTOM)
                .setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        boolean bottom = pState.getValue(HALF) == Half.BOTTOM;
        return switch (pState.getValue(FACING)) {
            case NORTH -> bottom ? NORTH_SHAPE_BOTTOM : NORTH_SHAPE_TOP;
            case SOUTH -> bottom ? SOUTH_SHAPE_BOTTOM : SOUTH_SHAPE_TOP;
            case WEST -> bottom ? WEST_SHAPE_BOTTOM : WEST_SHAPE_TOP;
            case EAST -> bottom ? EAST_SHAPE_BOTTOM : EAST_SHAPE_TOP;
            default -> Shapes.empty();
        };
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(WATERLOGGED, HALF);
    }

    public boolean useShapeForLightOcclusion(BlockState pState) {
        return true;
    }

}
