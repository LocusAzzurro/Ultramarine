package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.world.block.menu.BrickKilnMenu;
import com.voxelutopia.ultramarine.world.block.menu.ChiselTableMenu;
import com.voxelutopia.ultramarine.world.block.menu.ContainerDecorativeBlockMenu;
import com.voxelutopia.ultramarine.world.block.menu.WoodworkingWorkbenchMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MenuTypeRegistry {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, Ultramarine.MOD_ID);

    public static final DeferredHolder<MenuType<?>,MenuType<ContainerDecorativeBlockMenu>> CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X1 = MENU_TYPES.register("container_decorative_block_menu_generic_9x1",
            () -> IMenuTypeExtension.create((windowId, inv, data) -> ContainerDecorativeBlockMenu.genericOneRow(windowId, inv)));
    public static final DeferredHolder<MenuType<?>,MenuType<ContainerDecorativeBlockMenu>> CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X3 = MENU_TYPES.register("container_decorative_block_menu_generic_9x3",
            () -> IMenuTypeExtension.create((windowId, inv, data) -> ContainerDecorativeBlockMenu.genericThreeRows(windowId, inv)));
    public static final DeferredHolder<MenuType<?>,MenuType<ContainerDecorativeBlockMenu>> CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X6 = MENU_TYPES.register("container_decorative_block_menu_generic_9x6",
            () -> IMenuTypeExtension.create((windowId, inv, data) -> ContainerDecorativeBlockMenu.genericSixRows(windowId, inv)));
    public static final DeferredHolder<MenuType<?>,MenuType<ContainerDecorativeBlockMenu>> CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X3 = MENU_TYPES.register("container_decorative_block_menu_food_9x3",
            () -> IMenuTypeExtension.create((windowId, inv, data) -> ContainerDecorativeBlockMenu.foodThreeRows(windowId, inv)));
    public static final DeferredHolder<MenuType<?>,MenuType<ContainerDecorativeBlockMenu>> CONTAINER_DECORATIVE_BLOCK_MENU_FOOD_9X6 = MENU_TYPES.register("container_decorative_block_menu_food_9x6",
            () -> IMenuTypeExtension.create((windowId, inv, data) -> ContainerDecorativeBlockMenu.foodSixRows(windowId, inv)));
    public static final DeferredHolder<MenuType<?>,MenuType<WoodworkingWorkbenchMenu>> WOODWORKING_WORKBENCH = MENU_TYPES.register("woodworking_workbench",
            () -> IMenuTypeExtension.create((windowId, inv, data) -> new WoodworkingWorkbenchMenu(windowId, inv)));
    public static final DeferredHolder<MenuType<?>,MenuType<BrickKilnMenu>> BRICK_KILN = MENU_TYPES.register("brick_kiln",
            () -> IMenuTypeExtension.create((windowId, inv, data) -> new BrickKilnMenu(windowId, data.readBlockPos(), inv)));
    public static final DeferredHolder<MenuType<?>,MenuType<ChiselTableMenu>> CHISEL_TABLE = MENU_TYPES.register("chisel_table",
            () -> IMenuTypeExtension.create((windowId, inv, data) -> new ChiselTableMenu(windowId, inv)));

}
