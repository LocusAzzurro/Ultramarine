package com.voxelutopia.ultramarine;

import com.voxelutopia.ultramarine.data.loot.ModLootModifiers;
import com.voxelutopia.ultramarine.data.registry.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(Ultramarine.MOD_ID)
public class Ultramarine {

    public static final String MOD_ID = "ultramarine";
    private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public Ultramarine(IEventBus bus, ModContainer container) {
        BlockRegistry.BLOCKS.register(bus);
        ItemRegistry.ITEMS.register(bus);
        CreativeTabRegistry.CREATIVE_TABS.register(bus);
        BlockEntityRegistry.BLOCK_ENTITIES.register(bus);
        EntityTypeRegistry.ENTITIES.register(bus);
        VillagerProfessionRegistry.PROFESSIONS.register(bus);
        PoiTypeRegistry.POI_TYPES.register(bus);
        MenuTypeRegistry.MENU_TYPES.register(bus);
        RecipeTypeRegistry.RECIPE_TYPES.register(bus);
        RecipeSerializerRegistry.RECIPE_SERIALIZERS.register(bus);
        ModLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(bus);
        SoundRegistry.SOUND_EVENT.register(bus);

        bus.addListener(this::setup);
    }

    public static Logger getLogger() {
        return LOGGER;
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Ultramarine Mod Loading...");
    }

}
