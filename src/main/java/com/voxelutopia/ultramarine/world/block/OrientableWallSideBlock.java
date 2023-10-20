package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import com.voxelutopia.ultramarine.world.block.state.OrientableBlockType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;

import javax.annotation.Nullable;

public class OrientableWallSideBlock extends WallSideBlock implements SideBlock {

    public static final EnumProperty<OrientableBlockType> TYPE = ModBlockStateProperties.ORIENTABLE_BLOCK_TYPE;

    public OrientableWallSideBlock(BaseBlockProperty property) {
        super(property);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(TYPE, OrientableBlockType.LEFT)
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        BlockState state = this.defaultBlockState();
        FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());

        Direction faceDir = pContext.getClickedFace();
        Direction[] lookDirs = pContext.getNearestLookingDirections();
        if (faceDir.getAxis().isHorizontal()) {
            state = state.setValue(FACING, faceDir)
                    .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
            for (Direction dir : lookDirs) {
                if (dir.getAxis().isHorizontal() && dir != faceDir && dir != faceDir.getOpposite()) {
                    if (dir == faceDir.getOpposite().getClockWise())
                        state = state.setValue(TYPE, OrientableBlockType.LEFT);
                    if (dir == faceDir.getOpposite().getCounterClockWise())
                        state = state.setValue(TYPE, OrientableBlockType.RIGHT);
                }
            }
            return state;
        }
        return null;
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(TYPE);
    }
}
