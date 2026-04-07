package com.voxelutopia.ultramarine.world.block.entity;

import com.voxelutopia.ultramarine.data.registry.BlockEntityRegistry;
import com.voxelutopia.ultramarine.world.block.ContainerDecorativeBlock;
import com.voxelutopia.ultramarine.world.block.menu.ContainerDecorativeBlockMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jetbrains.annotations.NotNull;

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
    protected @NotNull NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(@NotNull NonNullList<ItemStack> pItemStacks) {
        this.items = pItemStacks;
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("container." + BuiltInRegistries.BLOCK.getKey(block).getPath());
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int pContainerId, @NotNull Inventory pInventory) {
        if (block instanceof ContainerDecorativeBlock container) {
            return container.getContainerType().createMenu(pContainerId, pInventory, this);
        }
        return ContainerDecorativeBlockMenu.genericThreeRows(pContainerId, pInventory, this);
    }

    @Override
    public int getContainerSize() {
        return rows * 9;
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        if (!this.trySaveLootTable(output)) {
            ContainerHelper.saveAllItems(output, this.items);
        }
        output.putInt("Rows", this.rows);

        if (this.block != null) {
            output.putString("BlockId", BuiltInRegistries.BLOCK.getKey(this.block).toString());
        }
    }


    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.rows = input.getIntOr("Rows", this.rows);
        this.block = input.getString("BlockId")
                .filter(s -> !s.isEmpty())
                .map(Identifier::parse)
                .flatMap(id -> BuiltInRegistries.BLOCK.get(id).map(Holder.Reference::value))
                .orElseGet(() -> this.level == null ? this.block : this.level.getBlockState(this.worldPosition).getBlock());
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(input)) {
            ContainerHelper.loadAllItems(input, this.items);
        }
    }
}
