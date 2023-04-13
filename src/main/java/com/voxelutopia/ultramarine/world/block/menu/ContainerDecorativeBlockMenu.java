package com.voxelutopia.ultramarine.world.block.menu;

import com.voxelutopia.ultramarine.data.MenuTypeRegistry;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class ContainerDecorativeBlockMenu extends AbstractContainerMenu {

    private static final int SLOTS_PER_ROW = 9;
    private final Container container;
    private final int containerRows;

    public ContainerDecorativeBlockMenu(int containerId, Inventory inventory, int rows) {
        this(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X3.get(), containerId, inventory, new SimpleContainer(9 * rows), rows);
    }

    public static ContainerDecorativeBlockMenu threeRows(int pId, Inventory pPlayer, Container pBlockEntity) {
        return new ContainerDecorativeBlockMenu(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X3.get(), pId, pPlayer, pBlockEntity, 3);
    }

    public ContainerDecorativeBlockMenu(MenuType<?> menuType, int containerId, Inventory inventory, Container container, int rows) {
        super(menuType, containerId);
        checkContainerSize(container, rows * 9);
        this.container = container;
        this.containerRows = rows;
        container.startOpen(inventory.player);
        int i = (this.containerRows - 4) * 18;

        //Container
        for(int row1 = 0; row1 < this.containerRows; ++row1) {
            for(int col1 = 0; col1 < 9; ++col1) {
                this.addSlot(new Slot(container, col1 + row1 * 9, 8 + col1 * 18, 18 + row1 * 18));
            }
        }

        //Inventory
        for(int row2 = 0; row2 < 3; ++row2) {
            for(int col2 = 0; col2 < 9; ++col2) {
                this.addSlot(new Slot(inventory, col2 + row2 * 9 + 9, 8 + col2 * 18, 103 + row2 * 18 + i));
            }
        }

        //Hot-bar
        for(int slot = 0; slot < 9; ++slot) {
            this.addSlot(new Slot(inventory, slot, 8 + slot * 18, 161 + i));
        }

    }


    public int getRowCount(){
        return containerRows;
    }

    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (pIndex < this.containerRows * 9) {
                if (!this.moveItemStackTo(itemstack1, this.containerRows * 9, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, this.containerRows * 9, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }
    @Override
    public boolean stillValid(Player pPlayer) {
        return this.container.stillValid(pPlayer);
    }

    public void removed(Player pPlayer) {
        super.removed(pPlayer);
        this.container.stopOpen(pPlayer);
    }

    public Container getContainer() {
        return this.container;
    }
}
