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
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

public class SideAxialBlock extends BaseHorizontalDirectionalBlock implements AxialBlock, SimpleWaterloggedBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private final ShapeFunction shapeFunction;
    private final boolean hasCollision;

    public SideAxialBlock(BaseBlockProperty property, ShapeFunction shapeFunction, boolean hasCollision) {
        super(property);
        BlockState state = this.stateDefinition.any()
                .setValue(WATERLOGGED, Boolean.FALSE)
                .setValue(FACING, Direction.NORTH);
        this.registerDefaultState(state);
        this.shapeFunction = shapeFunction;
        this.hasCollision = hasCollision;
    }

    public SideAxialBlock(BaseBlockProperty property, int thickness, int height, boolean hasCollision) {
        this(property, ShapeFunction.cardinalRotations(new RawVoxelShape((16-thickness)/2f,0,0,16-(16-thickness)/2f,height,16)), hasCollision);
    }

    public SideAxialBlock(BaseBlockProperty property, int thickness) {
        this(property, thickness, 16, false);
    }

    public SideAxialBlock(BaseBlockProperty property, ShapeFunction shape) {
        this(property, shape, false);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return this.shapeFunction.apply(pState);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState state = this.defaultBlockState().setValue(WATERLOGGED, pContext.getLevel().getFluidState(pContext.getClickedPos()).getType() == Fluids.WATER);
        return state.setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(WATERLOGGED);
        pBuilder.add(FACING);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return hasCollision ? this.getShape(pState, pLevel, pPos, pContext) : Shapes.empty();
    }

}
