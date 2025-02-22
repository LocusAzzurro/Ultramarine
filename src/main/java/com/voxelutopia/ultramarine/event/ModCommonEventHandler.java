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
import net.minecraftforge.event.CreativeModeTabEvent;
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
    public void buildContents(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(MOD_ID, "materials"), builder ->
                builder.title(itemGroupName("materials"))
                        .icon(() -> ItemRegistry.CYAN_BRICK.get().getDefaultInstance())
                        .displayItems((parameters, output) -> output.acceptAll(getItemsFromTab(ModCreativeTab.MATERIALS)))
                        .build()
        );
        event.registerCreativeModeTab(new ResourceLocation(MOD_ID, "tools"), builder ->
                builder.title(itemGroupName("tools"))
                        .icon(() -> ItemRegistry.WOODEN_MALLET.get().getDefaultInstance())
                        .displayItems((parameters, output) -> output.acceptAll(getItemsFromTab(ModCreativeTab.TOOLS)))
                        .build()
        );
        event.registerCreativeModeTab(new ResourceLocation(MOD_ID, "building_blocks"), builder ->
                builder.title(itemGroupName("building_blocks"))
                        .icon(() -> ItemRegistry.CYAN_BRICKS.get().getDefaultInstance())
                        .displayItems((parameters, output) -> output.acceptAll(getItemsFromTab(ModCreativeTab.BUILDING_BLOCKS)))
                        .build()
        );
        event.registerCreativeModeTab(new ResourceLocation(MOD_ID, "decorative_blocks"), builder ->
                builder.title(itemGroupName("decorative_blocks"))
                        .icon(() -> ItemRegistry.CARVED_RED_PILLAR_BASE.get().getDefaultInstance())
                        .displayItems((parameters, output) -> output.acceptAll(getItemsFromTab(ModCreativeTab.DECORATIVE_BLOCKS)))
                        .build()
        );
        event.registerCreativeModeTab(new ResourceLocation(MOD_ID, "decorations"), builder ->
                builder.title(itemGroupName("decorations"))
                        .icon(() -> ItemRegistry.OAK_CABINET.get().getDefaultInstance())
                        .displayItems((parameters, output) -> output.acceptAll(getItemsFromTab(ModCreativeTab.FURNITURE)))
                        .build()
        );
        event.registerCreativeModeTab(new ResourceLocation(MOD_ID, "furniture"), builder ->
                builder.title(itemGroupName("furniture"))
                        .icon(() -> ItemRegistry.CYAN_BRICK.get().getDefaultInstance())
                        .displayItems((parameters, output) -> output.acceptAll(getItemsFromTab(ModCreativeTab.MATERIALS)))
                        .build()
        );
        event.registerCreativeModeTab(new ResourceLocation(MOD_ID, "windows_and_doors"), builder ->
                builder.title(itemGroupName("windows_and_doors"))
                        .icon(() -> ItemRegistry.CARVED_WOODEN_DOOR.get().getDefaultInstance())
                        .displayItems((parameters, output) -> output.acceptAll(getItemsFromTab(ModCreativeTab.WINDOWS_AND_DOORS)))
                        .build()
        );
        event.registerCreativeModeTab(new ResourceLocation(MOD_ID, "plants"), builder ->
                builder.title(itemGroupName("plants"))
                        .icon(() -> ItemRegistry.MEDIUM_LOTUS.get().getDefaultInstance())
                        .displayItems((parameters, output) -> output.acceptAll(getItemsFromTab(ModCreativeTab.PLANTS)))
                        .build()
        );
        event.registerCreativeModeTab(new ResourceLocation(MOD_ID, "lamps"), builder ->
                builder.title(itemGroupName("lamps"))
                        .icon(() -> ItemRegistry.OCTAGONAL_PALACE_LANTERN.get().getDefaultInstance())
                        .displayItems((parameters, output) -> output.acceptAll(getItemsFromTab(ModCreativeTab.LAMPS))).build()
        );

    }

    private static Component itemGroupName(String name){
        return Component.translatable("item_group." + MOD_ID + "." + name);
    }

    private static Collection<ItemStack> getItemsFromTab(ModCreativeTab tab){
        return ModCreativeTab.getItemsFromSet(tab).stream().map(RegistryObject::get).map(Item::getDefaultInstance).toList();
    }

    @SubscribeEvent
    public static void registerEntityAttributes(EntityAttributeCreationEvent e){
        e.put(EntityTypeRegistry.TRAVELLING_MERCHANT.get(), TravellingMerchant.setCustomAttributes().build());
    }

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent e){
        //e.enqueueWork(PoiTypeRegistry::registerPOI); //todo check registry
    }

}
