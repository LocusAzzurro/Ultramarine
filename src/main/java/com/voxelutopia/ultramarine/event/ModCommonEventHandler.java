package com.voxelutopia.ultramarine.event;

import com.voxelutopia.ultramarine.data.ModBlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ModCommonEventHandler {

    @SubscribeEvent
    public static void breakSpeed(PlayerEvent.BreakSpeed event){
        BlockState state = event.getState();
        Player player = event.getPlayer();
        if (state.is(ModBlockTags.MINEABLE_WITH_SHEARS) &&
                player.getItemInHand(player.getUsedItemHand()).is(Tags.Items.SHEARS)){
            event.setNewSpeed(event.getOriginalSpeed() * 4);
        }
    }

}
