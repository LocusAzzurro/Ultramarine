package com.voxelutopia.ultramarine;

import com.mojang.logging.LogUtils;
import com.voxelutopia.ultramarine.data.registry.*;
import net.fabricmc.api.ModInitializer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.LogManager;

public class Ultramarine implements ModInitializer {

    public static final String MOD_ID = "ultramarine";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static void error(String format, Object... data)
    {
        LOGGER.error(format, data);
    }

    public static void warn(String format, Object... data)
    {
        LOGGER.warn(format, data);
    }

    public static void info(String format, Object... data)
    {
        LOGGER.info(format, data);
    }

    @Override
    public void onInitialize() {

    }
    public Ultramarine() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BlockRegistry.BLOCKS.register(bus);
        ItemRegistry.ITEMS.register(bus);
        BlockEntityRegistry.BLOCK_ENTITIES.register(bus);
        EntityTypeRegistry.ENTITIES.register(bus);
        VillagerProfessionRegistry.PROFESSIONS.register(bus);
        PoiTypeRegistry.POI_TYPES.register(bus);
        MenuTypeRegistry.MENU_TYPES.register(bus);
        RecipeTypeRegistry.RECIPE_TYPES.register(bus);
        RecipeSerializerRegistry.RECIPE_SERIALIZERS.register(bus);
        SoundRegistry.SOUND_EVENT.register(bus);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static Logger getLogger() {return LOGGER;}

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Ultramarine Mod Loading...");
    }


}
