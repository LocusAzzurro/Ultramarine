package com.voxelutopia.ultramarine.world.block.entity;

import com.voxelutopia.ultramarine.data.registry.BlockEntityRegistry;
import com.voxelutopia.ultramarine.world.block.ContainerDecorativeBlock;
import com.voxelutopia.ultramarine.world.block.menu.ContainerDecorativeBlockMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerDecorativeBlockEntity extends RandomizableContainerBlockEntity {

    private NonNullList<ItemStack> items;
    private int rows = 3;
    private Block block;

    public ContainerDecorativeBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.CONTAINER_DECORATIVE_BLOCK.get(), pos, state);
    }
    public ContainerDecorativeBlockEntity(BlockPos pos, BlockState state, int rows) {
        this(pos, state);
        block = state.getBlock();
        this.rows = rows;
        this.items = NonNullList.withSize(rows * 9, ItemStack.EMPTY);
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> pItemStacks) {
        this.items = pItemStacks;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container." + ForgeRegistries.BLOCKS.getKey(block).getPath());
    }

    @Override
    protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
        if (block instanceof ContainerDecorativeBlock container){
            return container.getContainerType().createMenu(pContainerId, pInventory, this);
        }
        return ContainerDecorativeBlockMenu.genericThreeRows(pContainerId, pInventory, this);
    }

    @Override
    public int getContainerSize() {
        return rows * 9;
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        if (!this.trySaveLootTable(nbt)) {
            ContainerHelper.saveAllItems(nbt, this.items);
        }
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(nbt)) {
            ContainerHelper.loadAllItems(nbt, this.items);
        }
    }
}
