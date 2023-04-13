package com.voxelutopia.ultramarine.data;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.world.block.menu.ContainerDecorativeBlockMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuTypeRegistry {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, Ultramarine.MOD_ID);

    public static final RegistryObject<MenuType<ContainerDecorativeBlockMenu>> CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X1 = MENU_TYPES.register("container_decorative_block_menu_generic_9x1",
            () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerDecorativeBlockMenu(windowId, inv, 1)));
    public static final RegistryObject<MenuType<ContainerDecorativeBlockMenu>> CONTAINER_DECORATIVE_BLOCK_MENU_GENERIC_9X3 = MENU_TYPES.register("container_decorative_block_menu_generic_9x3",
            () -> IForgeMenuType.create((windowId, inv, data) -> new ContainerDecorativeBlockMenu(windowId, inv, 3)));

}
