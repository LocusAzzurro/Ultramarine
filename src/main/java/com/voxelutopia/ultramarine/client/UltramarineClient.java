package com.voxelutopia.ultramarine.client;

import com.voxelutopia.ultramarine.client.event.ModClientRenderEventHandler;
import net.fabricmc.api.ClientModInitializer;

/**
 * Name: Ultramarine / UltramarineClient
 * Author: cnlimiter
 * CreateTime: 2023/10/3 11:00
 * Description:
 */

public class UltramarineClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModClientRenderEventHandler.onClientSetup();
    }
}
