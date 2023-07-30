package com.voxelutopia.ultramarine.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class OpeningBlock extends DecorativeBlock{

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
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
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        pState = pState.cycle(OPEN);
        pLevel.setBlock(pPos, pState, 10);
        pLevel.levelEvent(pPlayer, pState.getValue(OPEN) ? 1006 : 1012, pPos, 0);
        pLevel.gameEvent(pPlayer, this.isOpen(pState) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pPos);
        return InteractionResult.sidedSuccess(pLevel.isClientSide);
    }

    public boolean isOpen(BlockState pState) {
        return pState.getValue(OPEN);
    }

    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
        boolean signal = pLevel.hasNeighborSignal(pPos);
        if (!this.defaultBlockState().is(pBlock) && signal != pState.getValue(POWERED)) {
            if (signal != pState.getValue(OPEN)) {
                //this.playSound(pLevel, pPos, signal); //todo add sound
                pLevel.gameEvent(null, signal ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pPos);
            }
            pLevel.setBlock(pPos, pState.setValue(POWERED, signal).setValue(OPEN, signal), 2);
        }

    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockPos blockpos = pContext.getClickedPos();
        Level level = pContext.getLevel();
        boolean signal = level.hasNeighborSignal(blockpos);
        return this.defaultBlockState()
                .setValue(FACING, pContext.getHorizontalDirection())
                .setValue(HINGE, this.getHinge(pContext))
                .setValue(POWERED, signal)
                .setValue(OPEN, signal);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(OPEN, HINGE, POWERED);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)) {
            case EAST, WEST -> EW_AABB;
            default -> NS_AABB;
        };
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return pState.getValue(OPEN) ? Shapes.empty() : getShape(pState, pLevel, pPos, pContext);
    }

    private DoorHingeSide getHinge(BlockPlaceContext pContext) {
        BlockGetter level = pContext.getLevel();
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
                Vec3 vec3 = pContext.getClickLocation();
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
