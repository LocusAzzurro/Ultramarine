package com.voxelutopia.ultramarine.common.menu;

import com.voxelutopia.ultramarine.common.tile.ContainerDecorativeBlockEntity;
import net.minecraft.world.entity.player.Inventory;

@FunctionalInterface
public interface ContainerDecorativeBlockMenuProvider<M extends ContainerDecorativeBlockMenu> {
    M getMenu(int id, Inventory inventory, ContainerDecorativeBlockEntity blockEntity);
}
