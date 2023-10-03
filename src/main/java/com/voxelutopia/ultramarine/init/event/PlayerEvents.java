package com.voxelutopia.ultramarine.init.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Name: Ultramarine / PlayerEvents
 * Author: cnlimiter
 * CreateTime: 2023/10/3 11:16
 * Description:
 */

public class PlayerEvents {

    public static final Event<BreakSpeed> BREAK_SPEED = EventFactory.createArrayBacked(BreakSpeed.class, callbacks -> (player, state, pos, speed) -> {
        for(BreakSpeed callback : callbacks)
            speed = callback.modifyBreakSpeed(player, state, pos, speed);
        return speed;
    });

    @FunctionalInterface
    public interface BreakSpeed {
        float modifyBreakSpeed(Player player, BlockState state, BlockPos pos, float speed);
    }
}
