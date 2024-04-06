package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.shape.RawVoxelShape;
import com.voxelutopia.ultramarine.data.shape.ShapeFunction;
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

    private final boolean hasCollision;
    private final ShapeFunction shapeFunction;

    public CentralAxialBlock(BaseBlockProperty property, ShapeFunction shapeFunction, boolean hasCollision) {
        super(property.properties);
        BlockState state = this.stateDefinition.any()
                .setValue(WATERLOGGED, Boolean.FALSE)
                .setValue(AXIS, Direction.Axis.X);
        this.registerDefaultState(state);
        this.shapeFunction = shapeFunction;
        this.hasCollision = hasCollision;
    }

    public CentralAxialBlock(BaseBlockProperty property, int thickness, int height, boolean hasCollision) {
        this(property, ShapeFunction.axialRotations(new RawVoxelShape(0,0,(16-thickness)/2f,16,height,16-(16-thickness)/2f)), hasCollision);
    }

    public CentralAxialBlock(BaseBlockProperty property, int thickness) {
        this(property, thickness, 16, false);
    }

    public CentralAxialBlock(BaseBlockProperty property, int thickness, int height) {
        this(property, thickness, height, true);
    }

    public CentralAxialBlock(BaseBlockProperty property, ShapeFunction shapeFunction){
        this(property, shapeFunction, false);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return shapeFunction.apply(pState);
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
        return this.hasCollision ? getShape(pState, pLevel, pPos, pContext) : Shapes.empty();
    }

}
