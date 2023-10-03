package com.voxelutopia.ultramarine;

import com.voxelutopia.ultramarine.init.event.VillagerTradingManager;
import com.voxelutopia.ultramarine.init.handler.CommonEventHandler;
import com.voxelutopia.ultramarine.init.registry.*;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        BlockRegistry.registerModBlocks();
        ItemRegistry.registerModItems();
        BlockEntityRegistry.registerModBlockEntities();
        EntityTypeRegistry.registerModEntities();
        VillagerProfessionRegistry.registerModVillagerProfession();
        PoiTypeRegistry.registerModPOI();
        MenuTypeRegistry.registerModMenus();
        RecipeTypeRegistry.registerModRecipeTypes();
        RecipeSerializerRegistry.registerModRecipeSerializers();
        SoundRegistry.registerModSounds();
        VillagerTradingManager.loadTrades();


        CommonEventHandler.init();
    }

    public static Logger getLogger() {return LOGGER;}

}
