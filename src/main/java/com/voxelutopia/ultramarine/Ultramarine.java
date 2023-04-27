package com.voxelutopia.ultramarine;

import com.mojang.logging.LogUtils;
import com.voxelutopia.ultramarine.data.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Ultramarine.MOD_ID)
public class Ultramarine {

    public static final String MOD_ID = "ultramarine";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Ultramarine() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BlockRegistry.BLOCKS.register(bus);
        ItemRegistry.ITEMS.register(bus);
        BlockEntityRegistry.BLOCK_ENTITIES.register(bus);
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
