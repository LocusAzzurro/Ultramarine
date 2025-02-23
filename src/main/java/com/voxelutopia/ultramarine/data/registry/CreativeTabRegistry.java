package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.ModCreativeTab;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;

import static com.voxelutopia.ultramarine.Ultramarine.MOD_ID;

@Mod.EventBusSubscriber(modid = Ultramarine.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabRegistry {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Ultramarine.MOD_ID);

    public static RegistryObject<CreativeModeTab> MATERIALS = CREATIVE_TABS.register("materials",
            () -> CreativeModeTab.builder()
                    .title(itemGroupName("materials"))
                    .icon(ItemRegistry.CYAN_BRICK.get()::getDefaultInstance)
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .displayItems((displayParameters, output) -> getItemsFromTab(ModCreativeTab.MATERIALS).forEach(output::accept))
                    .build());
    public static RegistryObject<CreativeModeTab> TOOLS = CREATIVE_TABS.register("tools",
            () -> CreativeModeTab.builder()
                    .title(itemGroupName("tools"))
                    .icon(ItemRegistry.WOODEN_MALLET.get()::getDefaultInstance)
                    .withTabsBefore(CreativeTabRegistry.MATERIALS.getKey())
                    .displayItems((displayParameters, output) -> getItemsFromTab(ModCreativeTab.TOOLS).forEach(output::accept))
                    .build());
    public static RegistryObject<CreativeModeTab> BUILDING_BLOCKS = CREATIVE_TABS.register("building_blocks",
            () -> CreativeModeTab.builder()
                    .title(itemGroupName("building_blocks"))
                    .icon(ItemRegistry.CYAN_BRICKS.get()::getDefaultInstance)
                    .withTabsBefore(CreativeTabRegistry.TOOLS.getKey())
                    .displayItems((displayParameters, output) -> getItemsFromTab(ModCreativeTab.BUILDING_BLOCKS).forEach(output::accept))
                    .build());
    public static RegistryObject<CreativeModeTab> DECORATIVE_BLOCKS = CREATIVE_TABS.register("decorative_blocks",
            () -> CreativeModeTab.builder()
                    .title(itemGroupName("decorative_blocks"))
                    .icon(ItemRegistry.CARVED_RED_PILLAR_BASE.get()::getDefaultInstance)
                    .withTabsBefore(CreativeTabRegistry.BUILDING_BLOCKS.getKey())
                    .displayItems((displayParameters, output) -> getItemsFromTab(ModCreativeTab.DECORATIVE_BLOCKS).forEach(output::accept))
                    .build());
    public static RegistryObject<CreativeModeTab> DECORATIONS = CREATIVE_TABS.register("decorations",
            () -> CreativeModeTab.builder()
                    .title(itemGroupName("decorations"))
                    .icon(ItemRegistry.LARGE_BLUE_AND_WHITE_PORCELAIN_VASE.get()::getDefaultInstance)
                    .withTabsBefore(CreativeTabRegistry.DECORATIVE_BLOCKS.getKey())
                    .displayItems((displayParameters, output) -> getItemsFromTab(ModCreativeTab.DECORATIONS).forEach(output::accept))
                    .build());
    public static RegistryObject<CreativeModeTab> FURNITURE = CREATIVE_TABS.register("furniture",
            () -> CreativeModeTab.builder()
                    .title(itemGroupName("furniture"))
                    .icon(ItemRegistry.OAK_CABINET.get()::getDefaultInstance)
                    .withTabsBefore(CreativeTabRegistry.DECORATIONS.getKey())
                    .displayItems((displayParameters, output) -> getItemsFromTab(ModCreativeTab.FURNITURE).forEach(output::accept))
                    .build());
    public static RegistryObject<CreativeModeTab> WINDOWS_AND_DOORS = CREATIVE_TABS.register("windows_and_doors",
            () -> CreativeModeTab.builder()
                    .title(itemGroupName("windows_and_doors"))
                    .icon(ItemRegistry.CARVED_WOODEN_DOOR.get()::getDefaultInstance)
                    .withTabsBefore(CreativeTabRegistry.FURNITURE.getKey())
                    .displayItems((displayParameters, output) -> getItemsFromTab(ModCreativeTab.WINDOWS_AND_DOORS).forEach(output::accept))
                    .build());
    public static RegistryObject<CreativeModeTab> LAMPS = CREATIVE_TABS.register("lamps",
            () -> CreativeModeTab.builder()
                    .title(itemGroupName("lamps"))
                    .icon(ItemRegistry.OCTAGONAL_PALACE_LANTERN.get()::getDefaultInstance)
                    .withTabsBefore(CreativeTabRegistry.WINDOWS_AND_DOORS.getKey())
                    .displayItems((displayParameters, output) -> getItemsFromTab(ModCreativeTab.LAMPS).forEach(output::accept))
                    .build());
    public static RegistryObject<CreativeModeTab> PLANTS = CREATIVE_TABS.register("plants",
            () -> CreativeModeTab.builder()
                    .title(itemGroupName("plants"))
                    .icon(ItemRegistry.MEDIUM_LOTUS.get()::getDefaultInstance)
                    .withTabsBefore(CreativeTabRegistry.LAMPS.getKey())
                    .displayItems((displayParameters, output) -> getItemsFromTab(ModCreativeTab.PLANTS).forEach(output::accept))
                    .build());


    @SubscribeEvent
    public static void buildCreativeTab(BuildCreativeModeTabContentsEvent event){

    }

    private static Component itemGroupName(String name){
        return Component.translatable("item_group." + MOD_ID + "." + name);
    }

    private static Collection<ItemStack> getItemsFromTab(ModCreativeTab tab){
        return ModCreativeTab.getItemsFromSet(tab).stream().map(RegistryObject::get).map(Item::getDefaultInstance).toList();
    }
}