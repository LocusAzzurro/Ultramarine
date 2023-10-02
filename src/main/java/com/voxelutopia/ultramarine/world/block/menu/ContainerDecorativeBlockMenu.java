package com.voxelutopia.ultramarine.world.block.menu;

import com.voxelutopia.ultramarine.data.ContainerTypeReference;
import com.voxelutopia.ultramarine.data.registry.MenuTypeRegistry;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ContainerDecorativeBlockMenu extends Container {
    // TODO: Not sure this will work
    private static final int SLOTS_PER_ROW = 9;
    private final IInventory container;
    private final int containerRows;

    public ContainerDecorativeBlockMenu(ContainerType<?> menuType, int containerId, PlayerInventory inventory, ContainerTypeReference type) {
        this(menuType, containerId, inventory, new Inventory(9 * type.getRows()), type);
    }

    public static ContainerDecorativeBlockMenu genericOneRow(int pId, PlayerInventory pPlayer) {
        return new ContainerDecorativeBlockMenu(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X1.get(), pId, pPlayer, ContainerTypeReference.COMMON_SMALL);
    }

    public static ContainerDecorativeBlockMenu genericThreeRows(int pId, PlayerInventory pPlayer) {
        return new ContainerDecorativeBlockMenu(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X3.get(), pId, pPlayer, ContainerTypeReference.COMMON_REGULAR);
    }

    public static ContainerDecorativeBlockMenu genericSixRows(int pId, PlayerInventory pPlayer) {
        return new ContainerDecorativeBlockMenu(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X6.get(), pId, pPlayer, ContainerTypeReference.COMMON_LARGE);
    }

    public static ContainerDecorativeBlockMenu foodThreeRows(int pId, PlayerInventory pPlayer) {
        return new ContainerDecorativeBlockMenu(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X3.get(), pId, pPlayer, ContainerTypeReference.FOOD_REGULAR);
    }

    public static ContainerDecorativeBlockMenu foodSixRows(int pId, PlayerInventory pPlayer) {
        return new ContainerDecorativeBlockMenu(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X6.get(), pId, pPlayer, ContainerTypeReference.FOOD_LARGE);
    }

    public static ContainerDecorativeBlockMenu genericOneRow(int pId, PlayerInventory pPlayer, IInventory pBlockEntity) {
        return new ContainerDecorativeBlockMenu(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X1.get(), pId, pPlayer, pBlockEntity, ContainerTypeReference.COMMON_SMALL);
    }

    public static ContainerDecorativeBlockMenu genericThreeRows(int pId, PlayerInventory pPlayer, IInventory pBlockEntity) {
        return new ContainerDecorativeBlockMenu(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X3.get(), pId, pPlayer, pBlockEntity, ContainerTypeReference.COMMON_REGULAR);
    }

    public static ContainerDecorativeBlockMenu genericSixRows(int pId, PlayerInventory pPlayer, IInventory pBlockEntity) {
        return new ContainerDecorativeBlockMenu(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X6.get(), pId, pPlayer, pBlockEntity, ContainerTypeReference.COMMON_LARGE);
    }

    public static ContainerDecorativeBlockMenu foodThreeRows(int pId, PlayerInventory pPlayer, IInventory pBlockEntity) {
        return new ContainerDecorativeBlockMenu(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X3.get(), pId, pPlayer, pBlockEntity, ContainerTypeReference.FOOD_REGULAR);
    }

    public static ContainerDecorativeBlockMenu foodSixRows(int pId, PlayerInventory pPlayer, IInventory pBlockEntity) {
        return new ContainerDecorativeBlockMenu(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X6.get(), pId, pPlayer, pBlockEntity, ContainerTypeReference.FOOD_LARGE);
    }

    public ContainerDecorativeBlockMenu(ContainerType<?> menuType, int containerId, PlayerInventory inventory, IInventory container, ContainerTypeReference type) {
        super(menuType, containerId);
        int rows = type.getRows();
        checkContainerSize(inventory, rows * 9);
        this.container = container;
        this.containerRows = rows;
        container.startOpen(inventory.player);
        int i = (this.containerRows - 4) * 18;

        //Container
        for (int row1 = 0; row1 < this.containerRows; ++row1) {
            for (int col1 = 0; col1 < 9; ++col1) {
                this.addSlot(new FilteredSlot(inventory, col1 + row1 * 9, 8 + col1 * 18, 18 + row1 * 18, type));
            }
        }

        //Inventory
        for (int row2 = 0; row2 < 3; ++row2) {
            for (int col2 = 0; col2 < 9; ++col2) {
                this.addSlot(new Slot(inventory, col2 + row2 * 9 + 9, 8 + col2 * 18, 103 + row2 * 18 + i));
            }
        }

        //Hot-bar
        for (int slot = 0; slot < 9; ++slot) {
            this.addSlot(new Slot(inventory, slot, 8 + slot * 18, 161 + i));
        }

    }


    public int getRowCount() {
        return containerRows;
    }

    public ItemStack quickMoveStack(PlayerEntity pPlayer, int pIndex) {
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
    public boolean stillValid(PlayerEntity pPlayer) {
        return this.container.stillValid(pPlayer);
    }

    @Override
    public void removed(PlayerEntity pPlayer) {
        super.removed(pPlayer);
        this.container.stopOpen(pPlayer);
    }

    public static class FilteredSlot extends Slot {

        private final ContainerTypeReference containerType;

        public FilteredSlot(IInventory container, int pIndex, int pX, int pY, ContainerTypeReference containerType) {
            super(container, pIndex, pX, pY);
            this.containerType = containerType;
        }

        @Override
        public boolean mayPlace(ItemStack stack) {
            return containerType.check(stack);
        }
    }

}
