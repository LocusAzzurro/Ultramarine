package com.voxelutopia.ultramarine.world.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.Map;

public class WallSideBlock extends Block implements BaseBlockPropertyHolder, IWaterLoggable, SideBlock {

    protected final BaseBlockProperty property;
    private final Map<Direction, VoxelShape> shapeByDirection;

    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public WallSideBlock(BaseBlockProperty property, int sideThickness) {
        super(property.copy().properties.noOcclusion().noCollission());
        this.property = property;
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false));
        this.shapeByDirection = faceShapeByDirection(sideThickness);
    }

    public WallSideBlock(BaseBlockProperty property) {
        this(property, 1);
    }

    public VoxelShape getShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        return this.shapeByDirection.get(pState.getValue(FACING));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        BlockState state = this.defaultBlockState();
        FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());

        Direction direction = pContext.getClickedFace();
        if (direction.getAxis().isHorizontal()) {
            return state.setValue(FACING, direction)
                    .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
        }
        return null;
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
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
