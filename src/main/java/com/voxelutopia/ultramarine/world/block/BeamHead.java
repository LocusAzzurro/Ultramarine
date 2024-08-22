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
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BeamHead extends BaseHorizontalDirectionalBlock implements SimpleWaterloggedBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape SOUTH_SHAPE = Shapes.or(Block.box(4.0D, 2.0D, 0.0D, 12.0D, 14.0D, 8.0D),
            Block.box(4.0D, 6.0D, 8.0D, 12.0D, 14.0D, 10.0D));
    private static final VoxelShape EAST_SHAPE = Shapes.or(Block.box(0.0D, 2.0D, 4.0D, 8.0D, 14.0D, 12.0D),
            Block.box(8.0D, 6.0D, 4.0D, 10.0D, 14.0D, 12.0D));
    private static final VoxelShape NORTH_SHAPE = Shapes.or(Block.box(4.0D, 2.0D, 8.0D, 12.0D, 14.0D, 16.0D),
            Block.box(4.0D, 6.0D, 6.0D, 12.0D, 14.0D, 8.0D));
    private static final VoxelShape WEST_SHAPE = Shapes.or(Block.box(8.0D, 2.0D, 4.0D, 16.0D, 14.0D, 12.0D),
            Block.box(6.0D, 6.0D, 4.0D, 8.0D, 14.0D, 12.0D));

    public BeamHead(BaseBlockProperty property) {
        super(property.copy());
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)) {
            case NORTH -> NORTH_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            case EAST -> EAST_SHAPE;
            default -> Shapes.empty();
        };
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState()
                .setValue(FACING, pContext.getHorizontalDirection().getOpposite())
                .setValue(WATERLOGGED, pContext.getLevel().getFluidState(pContext.getClickedPos()).getType() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(WATERLOGGED);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Shapes.empty();
    }





}
