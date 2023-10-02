package com.voxelutopia.ultramarine.world.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoorHingeSide;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class OpeningBlock extends DecorativeBlock {

    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final EnumProperty<DoorHingeSide> HINGE = BlockStateProperties.DOOR_HINGE;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    protected static final VoxelShape NS_AABB = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 16.0D, 9.0D);
    protected static final VoxelShape EW_AABB = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 16.0D, 16.0D);
    public static ShapeFunction MIDDLE_AXIAL = (state, level, pos, context) -> (state.getValue(FACING) == Direction.NORTH) || (state.getValue(FACING) == Direction.SOUTH) ? NS_AABB : EW_AABB;

    public OpeningBlock(Builder builder) {
        super(builder);
    }

    @Override
    public ActionResultType use(BlockState pState, World pLevel, BlockPos pPos, PlayerEntity pPlayer, Hand pHand, BlockRayTraceResult pHit) {
        pState = pState.cycle(OPEN);
        pLevel.setBlock(pPos, pState, 10);
        pLevel.levelEvent(pPlayer, this.isOpen(pState) ? 1006 : 1012, pPos, 0);
        // Duplicate sound play
        return ActionResultType.sidedSuccess(pLevel.isClientSide);
    }

    public boolean isOpen(BlockState pState) {
        return pState.getValue(OPEN);
    }

    @Override
    public void neighborChanged(BlockState pState, World pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
        boolean signal = pLevel.hasNeighborSignal(pPos);
        if (!this.defaultBlockState().is(pBlock) && signal != pState.getValue(POWERED)) {
            if (signal != pState.getValue(OPEN)) {
                //this.playSound(pLevel, pPos, signal); //todo add sound
                pLevel.levelEvent(signal ? 1006 : 1012, pPos, 0);
            }
            pLevel.setBlock(pPos, pState.setValue(POWERED, signal).setValue(OPEN, signal), 2);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        BlockPos blockpos = pContext.getClickedPos();
        World level = pContext.getLevel();
        boolean signal = level.hasNeighborSignal(blockpos);
        return this.defaultBlockState()
                .setValue(FACING, pContext.getHorizontalDirection())
                .setValue(HINGE, this.getHinge(pContext))
                .setValue(POWERED, signal)
                .setValue(OPEN, signal);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(OPEN, HINGE, POWERED);
    }

    @Override
    public VoxelShape getShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        switch (pState.getValue(FACING)) {
            case WEST:
            case EAST:
                return EW_AABB;
            default:
                return NS_AABB;
        }
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        return pState.getValue(OPEN) ? VoxelShapes.empty() : getShape(pState, pLevel, pPos, pContext);
    }

    private DoorHingeSide getHinge(BlockItemUseContext pContext) {
        IBlockReader level = pContext.getLevel();
        BlockPos clickedPos = pContext.getClickedPos();
        Direction horizontalDirection = pContext.getHorizontalDirection();
        BlockPos above = clickedPos.above();
        Direction counterClockWise = horizontalDirection.getCounterClockWise();
        BlockPos relativeCCW = clickedPos.relative(counterClockWise);
        BlockState blockstateCCW = level.getBlockState(relativeCCW);
        BlockPos aboveCCW = above.relative(counterClockWise);
        BlockState blockstateAboveCCW = level.getBlockState(aboveCCW);
        Direction horizontalDirectionCW = horizontalDirection.getClockWise();
        BlockPos posHorizontalCW = clickedPos.relative(horizontalDirectionCW);
        BlockState blockstateHorizontalCW = level.getBlockState(posHorizontalCW);
        BlockPos aboveCW = above.relative(horizontalDirectionCW);
        BlockState blockstateAboveCW = level.getBlockState(aboveCW);
        int i = (blockstateCCW.isCollisionShapeFullBlock(level, relativeCCW) ? -1 : 0)
                + (blockstateAboveCCW.isCollisionShapeFullBlock(level, aboveCCW) ? -1 : 0)
                + (blockstateHorizontalCW.isCollisionShapeFullBlock(level, posHorizontalCW) ? 1 : 0)
                + (blockstateAboveCW.isCollisionShapeFullBlock(level, aboveCW) ? 1 : 0);
        boolean CCW = blockstateCCW.is(this);
        boolean CW = blockstateHorizontalCW.is(this);
        if ((!CCW || CW) && i <= 0) {
            if ((!CW || CCW) && i == 0) {
                int j = horizontalDirection.getStepX();
                int k = horizontalDirection.getStepZ();
                Vector3d vec3 = pContext.getClickLocation();
                double d0 = vec3.x - clickedPos.getX();
                double d1 = vec3.z - clickedPos.getZ();
                return (j >= 0 || !(d1 < 0.5D))
                        && (j <= 0 || !(d1 > 0.5D))
                        && (k >= 0 || !(d0 > 0.5D))
                        && (k <= 0 || !(d0 < 0.5D))
                        ? DoorHingeSide.LEFT : DoorHingeSide.RIGHT;
            } else {
                return DoorHingeSide.LEFT;
            }
        } else {
            return DoorHingeSide.RIGHT;
        }
    }

    @Override
    public boolean isDiagonallyPlaceable() {
        return false;
    }
}
