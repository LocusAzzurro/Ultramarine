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
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;

public class BaseHorizontalDirectionalSlab extends BaseSlab implements IWaterLoggable {

    protected final BaseBlockProperty property;
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    public static final EnumProperty<SlabType> TYPE = BlockStateProperties.SLAB_TYPE;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public BaseHorizontalDirectionalSlab(BaseBlock block) {
        this(block.getProperty());
    }

    public BaseHorizontalDirectionalSlab(BaseBlockProperty property) {
        super(property);
        this.property = property;
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(TYPE, SlabType.BOTTOM)
                .setValue(WATERLOGGED, false));
    }

    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        BlockPos blockpos = pContext.getClickedPos();
        BlockState blockstate = pContext.getLevel().getBlockState(blockpos);
        if (blockstate.is(this)) {
            return blockstate.setValue(TYPE, SlabType.DOUBLE).setValue(WATERLOGGED, Boolean.FALSE);
        } else {
            FluidState fluidstate = pContext.getLevel().getFluidState(blockpos);
            BlockState blockstate1 = this.defaultBlockState().setValue(TYPE, SlabType.BOTTOM).setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
            Direction direction = pContext.getHorizontalDirection();
            blockstate1 = blockstate1.setValue(FACING, direction);
            return !(pContext.getClickLocation().y - (double) blockpos.getY() > 0.5D) ? blockstate1 : blockstate1.setValue(TYPE, SlabType.TOP);
        }
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, TYPE, WATERLOGGED);
    }

    @Override
    public BaseBlockProperty getProperty() {
        return property;
    }
}
