package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.world.block.menu.ContainerDecorativeBlockMenu;
import com.voxelutopia.ultramarine.world.block.menu.WoodworkingWorkbenchMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuTypeRegistry {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Ultramarine.MOD_ID);

    public static final RegistryObject<MenuType<ContainerDecorativeBlockMenu>> CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X1 = MENU_TYPES.register("container_decorative_block_menu_generic_9x1",
            () -> IForgeMenuType.create((windowId, inv, data) -> ContainerDecorativeBlockMenu.genericOneRow(windowId, inv)));
    public static final RegistryObject<MenuType<ContainerDecorativeBlockMenu>> CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X3 = MENU_TYPES.register("container_decorative_block_menu_generic_9x3",
            () -> IForgeMenuType.create((windowId, inv, data) -> ContainerDecorativeBlockMenu.genericThreeRows(windowId, inv)));
    public static final RegistryObject<MenuType<ContainerDecorativeBlockMenu>> CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X6 = MENU_TYPES.register("container_decorative_block_menu_generic_9x6",
            () -> IForgeMenuType.create((windowId, inv, data) -> ContainerDecorativeBlockMenu.genericSixRows(windowId, inv)));
    public static final RegistryObject<MenuType<ContainerDecorativeBlockMenu>> CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X3 = MENU_TYPES.register("container_decorative_block_menu_food_9x3",
            () -> IForgeMenuType.create((windowId, inv, data) -> ContainerDecorativeBlockMenu.foodThreeRows(windowId, inv)));
    public static final RegistryObject<MenuType<ContainerDecorativeBlockMenu>> CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X6 = MENU_TYPES.register("container_decorative_block_menu_food_9x6",
            () -> IForgeMenuType.create((windowId, inv, data) -> ContainerDecorativeBlockMenu.foodSixRows(windowId, inv)));
    public static final RegistryObject<MenuType<WoodworkingWorkbenchMenu>> WOODWORKING_WORKBENCH = MENU_TYPES.register("woodworking_workbench",
            () -> IForgeMenuType.create((windowId, inv, data) -> new WoodworkingWorkbenchMenu(windowId, inv)));

}
