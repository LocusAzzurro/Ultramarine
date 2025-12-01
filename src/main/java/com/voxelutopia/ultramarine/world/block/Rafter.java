package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.shape.RawVoxelShape;
import com.voxelutopia.ultramarine.data.shape.ShapeFunction;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Function;

public class Rafter extends ShiftableBlock {

    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    public static final Function<BlockState, VoxelShape> RAFTER_SHAPE = ShapeFunction.axialRotations(new RawVoxelShape(0.0D, 10.0D, 5.0D, 16.0D, 16.0D, 11.0D));
    public static final Function<BlockState, VoxelShape> RAFTER_SHAPE_SHIFTED = ShapeFunction.axialRotations(new RawVoxelShape(0.0D, 18.0D, 5.0D, 16.0D, 24.0D, 11.0D));

    public Rafter(BaseBlockProperty property){
        super(property.properties().noOcclusion());
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(AXIS, Direction.Axis.X)
                .setValue(SHIFTED, Boolean.FALSE)
                .setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(AXIS);
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return super.getStateForPlacement(pContext).setValue(AXIS, pContext.getHorizontalDirection().getAxis());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRot) {
        BlockState newState = pState;
        if (pRot == Rotation.CLOCKWISE_90 || pRot == Rotation.COUNTERCLOCKWISE_90){
            newState = switch (pState.getValue(AXIS)){
                case X -> pState.setValue(AXIS, Direction.Axis.Z);
                case Z -> pState.setValue(AXIS, Direction.Axis.X);
                default -> newState;
            };
        }
        return newState;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return pState.getValue(SHIFTED) ? RAFTER_SHAPE_SHIFTED.apply(pState) : RAFTER_SHAPE.apply(pState);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return getShape(pState, pLevel, pPos, pContext);
    }


}
