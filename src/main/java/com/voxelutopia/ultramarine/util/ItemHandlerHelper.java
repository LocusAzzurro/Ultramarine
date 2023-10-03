package com.voxelutopia.ultramarine.util;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/**
 * Name: Ultramarine / ItemHandlerHelper
 * Author: cnlimiter
 * CreateTime: 2023/10/3 10:01
 * Description:
 */

public class ItemHandlerHelper {
    public static void giveItemToPlayer(Player player, @NotNull ItemStack stack) {
        giveItemToPlayer(player, stack, -1);
    }

    public static void giveItemToPlayer(Player player, @NotNull ItemStack stack, int preferredSlot) {
        if (stack.isEmpty()) return;

        Inventory inventory = player.getInventory();
        Level level = player.level();

        // try adding it into the inventory
        ItemStack remainder = stack;
        // insert into preferred slot first
        if (preferredSlot >= 0 && preferredSlot < inventory.getMaxStackSize()) {
            inventory.add(preferredSlot, stack);
        }
        // then into the inventory in general
        if (!remainder.isEmpty()) {
            inventory.add(remainder);
        }

        // play sound if something got picked up
        if (remainder.isEmpty() || remainder.getCount() != stack.getCount()) {
            level.playSound(null, player.getX(), player.getY() + 0.5, player.getZ(),
                    SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2F, ((level.random.nextFloat() - level.random.nextFloat()) * 0.7F + 1.0F) * 2.0F);
        }

        // drop remaining itemstack into the level
        if (inventory.getContainerSize() >= inventory.getMaxStackSize() && !remainder.isEmpty() && !level.isClientSide) {
            ItemEntity entityitem = new ItemEntity(level, player.getX(), player.getY() + 0.5, player.getZ(), remainder);
            entityitem.setPickUpDelay(40);
            entityitem.setDeltaMovement(entityitem.getDeltaMovement().multiply(0, 1, 0));

            level.addFreshEntity(entityitem);
        }

    }
}
