package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.world.block.menu.ContainerDecorativeBlockMenu;
import com.voxelutopia.ultramarine.world.block.menu.WoodworkingWorkbenchMenu;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MenuTypeRegistry {

    public static final DeferredRegister<ContainerType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, Ultramarine.MOD_ID);

    public static final RegistryObject<ContainerType<ContainerDecorativeBlockMenu>> CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X1 = MENU_TYPES.register("container_decorative_block_menu_generic_9x1",
            () -> IForgeContainerType.create((windowId, inv, data) -> ContainerDecorativeBlockMenu.genericOneRow(windowId, inv)));
    public static final RegistryObject<ContainerType<ContainerDecorativeBlockMenu>> CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X3 = MENU_TYPES.register("container_decorative_block_menu_generic_9x3",
            () -> IForgeContainerType.create((windowId, inv, data) -> ContainerDecorativeBlockMenu.genericThreeRows(windowId, inv)));
    public static final RegistryObject<ContainerType<ContainerDecorativeBlockMenu>> CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X6 = MENU_TYPES.register("container_decorative_block_menu_generic_9x6",
            () -> IForgeContainerType.create((windowId, inv, data) -> ContainerDecorativeBlockMenu.genericSixRows(windowId, inv)));
    public static final RegistryObject<ContainerType<ContainerDecorativeBlockMenu>> CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X3 = MENU_TYPES.register("container_decorative_block_menu_food_9x3",
            () -> IForgeContainerType.create((windowId, inv, data) -> ContainerDecorativeBlockMenu.foodThreeRows(windowId, inv)));
    public static final RegistryObject<ContainerType<ContainerDecorativeBlockMenu>> CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X6 = MENU_TYPES.register("container_decorative_block_menu_food_9x6",
            () -> IForgeContainerType.create((windowId, inv, data) -> ContainerDecorativeBlockMenu.foodSixRows(windowId, inv)));
    public static final RegistryObject<ContainerType<WoodworkingWorkbenchMenu>> WOODWORKING_WORKBENCH = MENU_TYPES.register("woodworking_workbench",
            () -> IForgeContainerType.create((windowId, inv, data) -> new WoodworkingWorkbenchMenu(windowId, inv)));

}
