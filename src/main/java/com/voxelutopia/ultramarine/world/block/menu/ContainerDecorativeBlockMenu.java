package com.voxelutopia.ultramarine.world.block.menu;

import com.voxelutopia.ultramarine.data.ContainerType;
import com.voxelutopia.ultramarine.data.registry.MenuTypeRegistry;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ContainerDecorativeBlockMenu extends AbstractContainerMenu {

    private static final int SLOTS_PER_ROW = 9;
    private final Container container;
    private final int containerRows;

    public ContainerDecorativeBlockMenu(MenuType<?> menuType, int containerId, Inventory inventory, ContainerType type) {
        this(menuType, containerId, inventory, new SimpleContainer(9 * type.getRows()), type);
    }

    public static ContainerDecorativeBlockMenu genericOneRow(int pId, Inventory pPlayer) {
        return new ContainerDecorativeBlockMenu(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X1.get(), pId, pPlayer, ContainerType.COMMON_SMALL);
    }

    public static ContainerDecorativeBlockMenu genericThreeRows(int pId, Inventory pPlayer) {
        return new ContainerDecorativeBlockMenu(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X3.get(), pId, pPlayer, ContainerType.COMMON_REGULAR);
    }

    public static ContainerDecorativeBlockMenu genericSixRows(int pId, Inventory pPlayer) {
        return new ContainerDecorativeBlockMenu(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X6.get(), pId, pPlayer, ContainerType.COMMON_LARGE);
    }

    public static ContainerDecorativeBlockMenu foodThreeRows(int pId, Inventory pPlayer) {
        return new ContainerDecorativeBlockMenu(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X3.get(), pId, pPlayer, ContainerType.FOOD_REGULAR);
    }

    public static ContainerDecorativeBlockMenu foodSixRows(int pId, Inventory pPlayer) {
        return new ContainerDecorativeBlockMenu(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X6.get(), pId, pPlayer, ContainerType.FOOD_LARGE);
    }

    public static ContainerDecorativeBlockMenu genericOneRow(int pId, Inventory pPlayer , Container pBlockEntity) {
        return new ContainerDecorativeBlockMenu(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X1.get(), pId, pPlayer, pBlockEntity, ContainerType.COMMON_SMALL);
    }

    public static ContainerDecorativeBlockMenu genericThreeRows(int pId, Inventory pPlayer, Container pBlockEntity) {
        return new ContainerDecorativeBlockMenu(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X3.get(), pId, pPlayer, pBlockEntity, ContainerType.COMMON_REGULAR);
    }

    public static ContainerDecorativeBlockMenu genericSixRows(int pId, Inventory pPlayer, Container pBlockEntity) {
        return new ContainerDecorativeBlockMenu(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X6.get(), pId, pPlayer, pBlockEntity, ContainerType.COMMON_LARGE);
    }

    public static ContainerDecorativeBlockMenu foodThreeRows(int pId, Inventory pPlayer, Container pBlockEntity) {
        return new ContainerDecorativeBlockMenu(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X3.get(), pId, pPlayer, pBlockEntity, ContainerType.FOOD_REGULAR);
    }

    public static ContainerDecorativeBlockMenu foodSixRows(int pId, Inventory pPlayer, Container pBlockEntity) {
        return new ContainerDecorativeBlockMenu(MenuTypeRegistry.CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X6.get(), pId, pPlayer, pBlockEntity, ContainerType.FOOD_LARGE);
    }

    public ContainerDecorativeBlockMenu(MenuType<?> menuType, int containerId, Inventory inventory, Container container, ContainerType type) {
        super(menuType, containerId);
        int rows = type.getRows();
        checkContainerSize(container, rows * 9);
        this.container = container;
        this.containerRows = rows;
        container.startOpen(inventory.player);
        int i = (this.containerRows - 4) * 18;

        //Container
        for(int row1 = 0; row1 < this.containerRows; ++row1) {
            for(int col1 = 0; col1 < 9; ++col1) {
                this.addSlot(new FilteredSlot(container, col1 + row1 * 9, 8 + col1 * 18, 18 + row1 * 18, type));
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

    public static class FilteredSlot extends Slot {

        private final ContainerType containerType;

        public FilteredSlot(Container container, int pIndex, int pX, int pY, ContainerType containerType) {
            super(container, pIndex, pX, pY);
            this.containerType = containerType;
        }

        @Override
        public boolean mayPlace(@NotNull ItemStack stack) {
            return containerType.check(stack);
        }
    }

}
