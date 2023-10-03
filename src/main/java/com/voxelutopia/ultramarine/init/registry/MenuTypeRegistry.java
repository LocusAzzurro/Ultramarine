package com.voxelutopia.ultramarine.init.registry;

import com.voxelutopia.ultramarine.common.menu.ContainerDecorativeBlockMenu;
import com.voxelutopia.ultramarine.common.menu.WoodworkingWorkbenchMenu;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.MenuType;

public class MenuTypeRegistry {

    public static MenuType<ContainerDecorativeBlockMenu> CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X1;
    public static MenuType<ContainerDecorativeBlockMenu> CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X3;
    public static MenuType<ContainerDecorativeBlockMenu> CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X6;
    public static MenuType<ContainerDecorativeBlockMenu> CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X3;
    public static MenuType<ContainerDecorativeBlockMenu> CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X6;
    public static MenuType<WoodworkingWorkbenchMenu> WOODWORKING_WORKBENCH;


    public static void registerModMenus(){
        CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X1 = Registry.register(BuiltInRegistries.MENU, "container_decorative_block_menu_generic_9x1", new MenuType<>(ContainerDecorativeBlockMenu::genericOneRow, FeatureFlagSet.of()));
        CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X3 = Registry.register(BuiltInRegistries.MENU, "container_decorative_block_menu_generic_9x3", new MenuType<>(ContainerDecorativeBlockMenu::genericThreeRows, FeatureFlagSet.of()));
        CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X6 = Registry.register(BuiltInRegistries.MENU, "container_decorative_block_menu_generic_9x6", new MenuType<>(ContainerDecorativeBlockMenu::genericSixRows, FeatureFlagSet.of()));
        CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X3 = Registry.register(BuiltInRegistries.MENU, "container_decorative_block_menu_food_9x3", new MenuType<>(ContainerDecorativeBlockMenu::foodThreeRows, FeatureFlagSet.of()));
        CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X6 = Registry.register(BuiltInRegistries.MENU, "container_decorative_block_menu_food_9x6", new MenuType<>(ContainerDecorativeBlockMenu::foodSixRows, FeatureFlagSet.of()));
        WOODWORKING_WORKBENCH = Registry.register(BuiltInRegistries.MENU, "woodworking_workbench", new MenuType<>(WoodworkingWorkbenchMenu::new, FeatureFlagSet.of()));
    }

}
