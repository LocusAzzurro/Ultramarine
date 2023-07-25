package com.voxelutopia.ultramarine.world.block;

import com.google.common.collect.ImmutableMap;
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
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Arrays;
import java.util.Map;

public class SixFaceBlock extends Block implements BaseBlockPropertyHolder, SimpleWaterloggedBlock {

    protected final BaseBlockProperty property;
    private final Map<Direction, VoxelShape> shapeByDirection;

    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public SixFaceBlock(BaseBlockProperty property, int sideThickness) {
        super(property.properties.noOcclusion().noCollission());
        this.property = property;
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false));
        this.shapeByDirection = faceShapeByDirection(sideThickness);
    }

    public SixFaceBlock(BaseBlockProperty property) {
        this(property,  1);
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

    private Map<Direction, VoxelShape> faceShapeByDirection(int thickness){
        double t = thickness;
        ImmutableMap.Builder<Direction, VoxelShape> builder = ImmutableMap.builder();
        builder.put(Direction.UP, Block.box(0, 0, 0, 16, t, 16));
        builder.put(Direction.DOWN, Block.box(0, 16 - t, 0, 16, 16, 16));
        builder.put(Direction.NORTH, Block.box(0, 0, 16 - t, 16, 16, 16));
        builder.put(Direction.SOUTH, Block.box(0, 0, 0, 16, 16, t));
        builder.put(Direction.EAST, Block.box(0, 0, 0, t, 16, 16));
        builder.put(Direction.WEST, Block.box(16 - t, 0, 0, 16, 16, 16));
        return builder.build();
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, WATERLOGGED);
    }

    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    public BaseBlockProperty getProperty() {
        return this.property;
    }



}
