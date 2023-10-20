package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.ContainerTypeReference;
import com.voxelutopia.ultramarine.world.block.entity.ContainerDecorativeBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ContainerDecorativeBlock extends DecorativeBlock {

    protected final ContainerTypeReference containerType;
    protected final int rowCount;

    public ContainerDecorativeBlock(Builder builder) {
        super(builder);
        this.containerType = builder.containerType;
        this.rowCount = builder.rowCount;
    }

    public static Builder with(BaseBlockProperty property) {
        return new Builder(property);
    }

    @Override
    public void setPlacedBy(World worldIn, BlockPos posIn, BlockState stateIn, LivingEntity entityIn, ItemStack stackIn) {
        if (stackIn.hasCustomHoverName()) {
            TileEntity blockEntity = worldIn.getBlockEntity(posIn);
            if (blockEntity instanceof ContainerDecorativeBlockEntity) {
                ((ContainerDecorativeBlockEntity) blockEntity).setCustomName(stackIn.getHoverName());
            }
        }
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState pState) {
        return PushReaction.BLOCK;
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState stateIn) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState pState, World pLevel, BlockPos pPos) {
        return Container.getRedstoneSignalFromBlockEntity(pLevel.getBlockEntity(pPos));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new ContainerDecorativeBlockEntity(state, rowCount);
    }

    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayIn) {
        if (worldIn.isClientSide) {
            return ActionResultType.SUCCESS;
        } else {
            TileEntity blockEntity = worldIn.getBlockEntity(pos);
            if (blockEntity instanceof ContainerDecorativeBlockEntity) {
                player.openMenu((ContainerDecorativeBlockEntity) blockEntity);
            }
            return ActionResultType.CONSUME;
        }
    }

    @Override
    public void onRemove(BlockState pState, World levelIn, BlockPos pos, BlockState pNewState, boolean pIsMoving) {
        if (!pState.is(pNewState.getBlock())) {
            TileEntity blockEntity = levelIn.getBlockEntity(pos);
            if (blockEntity instanceof IInventory) {
                InventoryHelper.dropContents(levelIn, pos, (IInventory) blockEntity);
                levelIn.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(pState, levelIn, pos, pNewState, pIsMoving);
        }
    }

    public ContainerTypeReference getContainerType() {
        return this.containerType;
    }

    public static class Builder extends DecorativeBlock.Builder {

        private ContainerTypeReference containerType = ContainerTypeReference.COMMON_REGULAR;
        private int rowCount = 3;

        public Builder(BaseBlockProperty property) {
            super(property);
        }

        public Builder content(ContainerTypeReference type) {
            this.containerType = type;
            this.rowCount = type.getRows();
            return this;
        }

        public ContainerDecorativeBlock build() {
            return new ContainerDecorativeBlock(this);
        }
    }

}
