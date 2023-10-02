package com.voxelutopia.ultramarine.world.block.entity;

import com.voxelutopia.ultramarine.data.registry.BlockEntityRegistry;
import com.voxelutopia.ultramarine.world.block.ContainerDecorativeBlock;
import com.voxelutopia.ultramarine.world.block.menu.ContainerDecorativeBlockMenu;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ContainerDecorativeBlockEntity extends LockableLootTileEntity {

    private NonNullList<ItemStack> items;
    private int rows = 3;
    private Block block;

    public ContainerDecorativeBlockEntity() {
        super(BlockEntityRegistry.CONTAINER_DECORATIVE_BLOCK.get());
    }

    public ContainerDecorativeBlockEntity(BlockState state, int rows) {
        this();
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
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container." + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath());
    }

    @Override
    protected Container createMenu(int pContainerId, PlayerInventory pInventory) {
        if (block instanceof ContainerDecorativeBlock) {
            return ((ContainerDecorativeBlock) block).getContainerType().createMenu(pContainerId, pInventory, this);
        }
        return ContainerDecorativeBlockMenu.genericThreeRows(pContainerId, pInventory, this);
    }

    @Override
    public int getContainerSize() {
        return rows * 9;
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        super.save(nbt);
        if (!this.trySaveLootTable(nbt)) {
            ItemStackHelper.saveAllItems(nbt, this.items);
        }
        return nbt;
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(nbt)) {
            ItemStackHelper.loadAllItems(nbt, this.items);
        }
    }
}
