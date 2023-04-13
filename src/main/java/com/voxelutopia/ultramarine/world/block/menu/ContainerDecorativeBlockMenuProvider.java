package com.voxelutopia.ultramarine.world.block.menu;

import com.voxelutopia.ultramarine.world.block.entity.ContainerDecorativeBlockEntity;
import net.minecraft.world.entity.player.Inventory;

@FunctionalInterface
public interface ContainerDecorativeBlockMenuProvider<M extends ContainerDecorativeBlockMenu>
{
    M getMenu(int id, Inventory inventory, ContainerDecorativeBlockEntity blockEntity);
}
