package com.voxelutopia.ultramarine.world.block.menu;

import com.voxelutopia.ultramarine.world.block.entity.ContainerDecorativeBlockEntity;
import net.minecraft.entity.player.PlayerInventory;

@FunctionalInterface
public interface ContainerDecorativeBlockMenuProvider<M extends ContainerDecorativeBlockMenu> {
    M getMenu(int id, PlayerInventory inventory, ContainerDecorativeBlockEntity blockEntity);
}
