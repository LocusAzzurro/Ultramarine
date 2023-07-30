package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.ModCreativeTab;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Ultramarine.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabRegistry {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Ultramarine.MOD_ID);

    public static RegistryObject<CreativeModeTab> BUILDING_BLOCKS = CREATIVE_TABS.register("building_blocks",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.ultramarine.building_blocks"))
                    .icon(ItemRegistry.CYAN_BRICKS.get()::getDefaultInstance)
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .displayItems((displayParameters, output) -> ModCreativeTab.itemSets.get(ModCreativeTab.BUILDING_BLOCKS).stream().map(RegistryObject::get).forEach(output::accept))
                    .build());
    public static RegistryObject<CreativeModeTab> DECORATIVE_BLOCKS = CREATIVE_TABS.register("decorative_blocks",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.ultramarine.decorative_blocks"))
                    .icon(ItemRegistry.CARVED_RED_PILLAR_BASE.get()::getDefaultInstance)
                    .withTabsBefore(CreativeTabRegistry.BUILDING_BLOCKS.getKey())
                    .displayItems((displayParameters, output) -> ModCreativeTab.itemSets.get(ModCreativeTab.DECORATIVE_BLOCKS).stream().map(RegistryObject::get).forEach(output::accept))
                    .build());
    public static RegistryObject<CreativeModeTab> DECORATIONS = CREATIVE_TABS.register("decorations",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.ultramarine.decorations"))
                    .icon(ItemRegistry.LARGE_BLUE_AND_WHITE_PORCELAIN_VASE.get()::getDefaultInstance)
                    .withTabsBefore(CreativeTabRegistry.DECORATIVE_BLOCKS.getKey())
                    .displayItems((displayParameters, output) -> ModCreativeTab.itemSets.get(ModCreativeTab.DECORATIONS).stream().map(RegistryObject::get).forEach(output::accept))
                    .build());
    public static RegistryObject<CreativeModeTab> FURNITURE = CREATIVE_TABS.register("furniture",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.ultramarine.furniture"))
                    .icon(ItemRegistry.OAK_CABINET.get()::getDefaultInstance)
                    .withTabsBefore(CreativeTabRegistry.DECORATIONS.getKey())
                    .displayItems((displayParameters, output) -> ModCreativeTab.itemSets.get(ModCreativeTab.FURNITURE).stream().map(RegistryObject::get).forEach(output::accept))
                    .build());
    public static RegistryObject<CreativeModeTab> WINDOWS_AND_DOORS = CREATIVE_TABS.register("windows_and_doors",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.ultramarine.windows_and_doors"))
                    .icon(ItemRegistry.CARVED_WOODEN_DOOR.get()::getDefaultInstance)
                    .withTabsBefore(CreativeTabRegistry.FURNITURE.getKey())
                    .displayItems((displayParameters, output) -> ModCreativeTab.itemSets.get(ModCreativeTab.WINDOWS_AND_DOORS).stream().map(RegistryObject::get).forEach(output::accept))
                    .build());
    public static RegistryObject<CreativeModeTab> LAMPS = CREATIVE_TABS.register("lamps",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.ultramarine.lamps"))
                    .icon(ItemRegistry.OCTAGONAL_PALACE_LANTERN.get()::getDefaultInstance)
                    .withTabsBefore(CreativeTabRegistry.WINDOWS_AND_DOORS.getKey())
                    .displayItems((displayParameters, output) -> ModCreativeTab.itemSets.get(ModCreativeTab.LAMPS).stream().map(RegistryObject::get).forEach(output::accept))
                    .build());

    public static RegistryObject<CreativeModeTab> MATERIALS = CREATIVE_TABS.register("materials",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.ultramarine.materials"))
                    .icon(ItemRegistry.CYAN_BRICK.get()::getDefaultInstance)
                    .withTabsBefore(CreativeTabRegistry.LAMPS.getKey())
                    .displayItems((displayParameters, output) -> ModCreativeTab.itemSets.get(ModCreativeTab.MATERIALS).stream().map(RegistryObject::get).forEach(output::accept))
                    .build());
    public static RegistryObject<CreativeModeTab> TOOLS = CREATIVE_TABS.register("tools",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.ultramarine.tools"))
                    .icon(ItemRegistry.WOODEN_HAMMER.get()::getDefaultInstance)
                    .withTabsBefore(CreativeTabRegistry.MATERIALS.getKey())
                    .displayItems((displayParameters, output) -> {
                        output.accept(ItemRegistry.WOODEN_HAMMER.get());
                        ModCreativeTab.itemSets.get(ModCreativeTab.TOOLS).stream().map(RegistryObject::get).forEach(output::accept);
                    })
                    .build());

    @SubscribeEvent
    public static void buildCreativeTab(BuildCreativeModeTabContentsEvent event){

    }
}