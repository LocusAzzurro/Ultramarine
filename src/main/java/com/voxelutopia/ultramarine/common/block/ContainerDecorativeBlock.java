package com.voxelutopia.ultramarine.common.block;

import com.voxelutopia.ultramarine.common.tile.ContainerDecorativeBlockEntity;
import com.voxelutopia.ultramarine.init.data.ContainerType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ContainerDecorativeBlock extends DecorativeBlock implements EntityBlock {

    protected final ContainerType containerType;
    protected final int rowCount;

    public ContainerDecorativeBlock(Builder builder) {
        super(builder);
        this.containerType = builder.containerType;
        this.rowCount = builder.rowCount;
    }

    public static Builder with(BaseBlockProperty property){
        return new Builder(property);
    }

    @Override
    public void setPlacedBy(Level worldIn, BlockPos posIn, BlockState stateIn, LivingEntity entityIn, ItemStack stackIn) {
        if (stackIn.hasCustomHoverName()) {
            BlockEntity blockEntity = worldIn.getBlockEntity(posIn);
            if (blockEntity instanceof ContainerDecorativeBlockEntity containerBlockEntity) {
                containerBlockEntity.setCustomName(stackIn.getHoverName());
            }
        }
    }
    @Override
    public boolean hasAnalogOutputSignal(BlockState stateIn) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState pState, Level pLevel, BlockPos pPos) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(pLevel.getBlockEntity(pPos));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState state) {
        return new ContainerDecorativeBlockEntity(pPos, state, rowCount);
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand hand, BlockHitResult rayIn) {
        if (worldIn.isClientSide) {
            return InteractionResult.SUCCESS;
        }
        else {
            BlockEntity blockEntity = worldIn.getBlockEntity(pos);
            if (blockEntity instanceof ContainerDecorativeBlockEntity container) {
                player.openMenu(container);
            }
            return InteractionResult.CONSUME;
        }
    }

    @Override
    public void onRemove(BlockState pState, Level levelIn, BlockPos pos, BlockState pNewState, boolean pIsMoving) {
        if (!pState.is(pNewState.getBlock())) {
            BlockEntity blockEntity = levelIn.getBlockEntity(pos);
            if (blockEntity instanceof Container) {
                Containers.dropContents(levelIn, pos, (Container) blockEntity);
                levelIn.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(pState, levelIn, pos, pNewState, pIsMoving);
        }
    }

    public ContainerType getContainerType(){
        return this.containerType;
    }

    public static class Builder extends DecorativeBlock.Builder{

        private ContainerType containerType = ContainerType.COMMON_REGULAR;
        private int rowCount = 3;

        public Builder(BaseBlockProperty property) {
            super(property);
        }

        public Builder content(ContainerType type){
            this.containerType = type;
            this.rowCount = type.getRows();
            return this;
        }

        public ContainerDecorativeBlock build(){
            return new ContainerDecorativeBlock(this);
        }
    }

}
