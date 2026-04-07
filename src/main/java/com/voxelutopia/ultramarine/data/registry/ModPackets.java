package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.network.WoodworkingRecipesSyncPacket;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;

@EventBusSubscriber(modid = Ultramarine.MOD_ID)
public class ModPackets {
    private static final String PROTOCOL_VERSION = "1";
    @SubscribeEvent
    public static void onRegisterPayloads(RegisterPayloadHandlersEvent event) {
        final var registrar = event.registrar(Ultramarine.MOD_ID).versioned(PROTOCOL_VERSION);
        registrar.playToClient(WoodworkingRecipesSyncPacket.TYPE, WoodworkingRecipesSyncPacket.STREAM_CODEC, WoodworkingRecipesSyncPacket::handle);
    }
}
