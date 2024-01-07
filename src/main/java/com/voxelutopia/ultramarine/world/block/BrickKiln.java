package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.registry.BlockEntityRegistry;
import com.voxelutopia.ultramarine.world.block.entity.BlockEntityHelper;
import com.voxelutopia.ultramarine.world.block.entity.BrickKilnBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class BrickKiln extends Block implements EntityBlock, BaseBlockPropertyHolder {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public BrickKiln() {
        super(BaseBlockProperty.STONE.properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, Boolean.FALSE));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new BrickKilnBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return pLevel.isClientSide ? null :
                BlockEntityHelper.createTickerHelper(pBlockEntityType, (BlockEntityType<? extends BrickKilnBlockEntity>) BlockEntityRegistry.BRICK_KILN.get(), BrickKilnBlockEntity::serverTick);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof BrickKilnBlockEntity furnaceBlockEntity) {
                NetworkHooks.openGui((ServerPlayer) pPlayer, furnaceBlockEntity, pPos);
                return InteractionResult.CONSUME;
            }
        }
        return InteractionResult.PASS;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (!pState.is(pNewState.getBlock())) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof BrickKilnBlockEntity furnace) {
                if (pLevel instanceof ServerLevel) {

                    Containers.dropContents(pLevel, pPos, NonNullList.of(
                            furnace.wrapHandlers().getStackInSlot(0),
                            furnace.wrapHandlers().getStackInSlot(1),
                            furnace.wrapHandlers().getStackInSlot(2),
                            furnace.wrapHandlers().getStackInSlot(3)
                            ));
                    furnace.getRecipesToAwardAndPopExperience((ServerLevel)pLevel, Vec3.atCenterOf(pPos));
                }

                pLevel.updateNeighbourForOutputSignal(pPos, this);
            }

            super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(FACING);
        pBuilder.add(LIT);
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BaseBlockProperty getProperty() {
        return BaseBlockProperty.STONE;
    }
}
