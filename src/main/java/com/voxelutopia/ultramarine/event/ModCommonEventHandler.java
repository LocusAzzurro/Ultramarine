package com.voxelutopia.ultramarine.event;

import com.voxelutopia.ultramarine.data.ModCreativeTab;
import com.voxelutopia.ultramarine.data.registry.EntityTypeRegistry;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.data.registry.PoiTypeRegistry;
import com.voxelutopia.ultramarine.world.entity.TravellingMerchant;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;

import static com.voxelutopia.ultramarine.Ultramarine.MOD_ID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCommonEventHandler {

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent e){
        e.put(EntityTypeRegistry.TRAVELLING_MERCHANT.get(), TravellingMerchant.setCustomAttributes().build());
    }

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent e){
        //e.enqueueWork(PoiTypeRegistry::registerPOI); //todo check registry
    }

}
