package com.voxelutopia.ultramarine.init.registry;

import com.voxelutopia.ultramarine.common.menu.ContainerDecorativeBlockMenu;
import com.voxelutopia.ultramarine.common.menu.WoodworkingWorkbenchMenu;
import net.minecraft.core.Registry;
import net.minecraft.world.inventory.MenuType;

public class ModMenuTypes {

    public static MenuType<ContainerDecorativeBlockMenu> CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X1;
    public static MenuType<ContainerDecorativeBlockMenu> CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X3;
    public static MenuType<ContainerDecorativeBlockMenu> CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X6;
    public static MenuType<ContainerDecorativeBlockMenu> CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X3;
    public static MenuType<ContainerDecorativeBlockMenu> CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X6;
    public static MenuType<WoodworkingWorkbenchMenu> WOODWORKING_WORKBENCH;


    public static void registerModMenus() {
        CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X1 = Registry.register(Registry.MENU, "container_decorative_block_menu_generic_9x1", new MenuType<>(ContainerDecorativeBlockMenu::genericOneRow));
        CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X3 = Registry.register(Registry.MENU, "container_decorative_block_menu_generic_9x3", new MenuType<>(ContainerDecorativeBlockMenu::genericThreeRows));
        CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X6 = Registry.register(Registry.MENU, "container_decorative_block_menu_generic_9x6", new MenuType<>(ContainerDecorativeBlockMenu::genericSixRows));
        CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X3 = Registry.register(Registry.MENU, "container_decorative_block_menu_food_9x3", new MenuType<>(ContainerDecorativeBlockMenu::foodThreeRows));
        CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X6 = Registry.register(Registry.MENU, "container_decorative_block_menu_food_9x6", new MenuType<>(ContainerDecorativeBlockMenu::foodSixRows));
        WOODWORKING_WORKBENCH = Registry.register(Registry.MENU, "woodworking_workbench", new MenuType<>(WoodworkingWorkbenchMenu::new));
    }

}
