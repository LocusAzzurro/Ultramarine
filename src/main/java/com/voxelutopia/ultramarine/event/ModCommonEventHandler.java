package com.voxelutopia.ultramarine.event;

import com.voxelutopia.ultramarine.data.registry.EntityTypeRegistry;
import com.voxelutopia.ultramarine.world.entity.TravellingMerchant;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCommonEventHandler {

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent e){
        e.put(EntityTypeRegistry.TRAVELLING_MERCHANT.get(), TravellingMerchant.setCustomAttributes().build());
    }

}
