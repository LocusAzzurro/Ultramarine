package com.voxelutopia.ultramarine.init.data;

import com.voxelutopia.ultramarine.common.menu.ContainerDecorativeBlockMenu;
import com.voxelutopia.ultramarine.common.menu.ContainerDecorativeBlockMenuProvider;
import com.voxelutopia.ultramarine.common.tile.ContainerDecorativeBlockEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

import java.util.function.Predicate;

public enum ContainerType {
    COMMON_REGULAR(3, i -> true, ContainerDecorativeBlockMenu::genericThreeRows),
    COMMON_SMALL(1, i -> true, ContainerDecorativeBlockMenu::genericOneRow),
    COMMON_LARGE(6, i -> true, ContainerDecorativeBlockMenu::genericSixRows),
    FOOD_REGULAR(3, ItemStack::isEdible, ContainerDecorativeBlockMenu::foodThreeRows),
    FOOD_LARGE(6, ItemStack::isEdible, ContainerDecorativeBlockMenu::foodSixRows);

    private final int rows;
    private final Predicate<ItemStack> filter;
    private final ContainerDecorativeBlockMenuProvider<ContainerDecorativeBlockMenu> menuProvider;

    ContainerType(int rows, Predicate<ItemStack> filter, ContainerDecorativeBlockMenuProvider<ContainerDecorativeBlockMenu> menuProvider) {
        this.rows = rows;
        this.filter = filter;
        this.menuProvider = menuProvider;
    }

    public boolean check(ItemStack item) {
        return this.filter.test(item);
    }

    public int getRows() {
        return rows;
    }

    public ContainerDecorativeBlockMenu createMenu(int pId, Inventory inv, ContainerDecorativeBlockEntity blockEntity) {
        return this.menuProvider.getMenu(pId, inv, blockEntity);
    }

}
