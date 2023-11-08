package com.voxelutopia.ultramarine.world.block.menu;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.data.registry.MenuTypeRegistry;
import com.voxelutopia.ultramarine.world.block.entity.BrickFurnaceBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class BrickFurnaceMenu extends AbstractContainerMenu {

    public static final int SLOT_INPUT_PRIMARY = BrickFurnaceBlockEntity.SLOT_INPUT_PRIMARY; //0
    public static final int SLOT_INPUT_SECONDARY = BrickFurnaceBlockEntity.SLOT_INPUT_SECONDARY; //1
    public static final int SLOT_FUEL = BrickFurnaceBlockEntity.SLOT_FUEL; //2
    public static final int SLOT_RESULT = BrickFurnaceBlockEntity.SLOT_RESULT; //3
    private static final int INV_SLOT_START = 4;
    private static final int INV_SLOT_END = 31;
    private static final int USE_ROW_SLOT_START = 31;
    private static final int USE_ROW_SLOT_END = 40;
    private final BlockEntity blockEntity;
    private final Player playerEntity;
    private final IItemHandler storage;
    private final IItemHandler inventory;
    private final ContainerData data;

    public BrickFurnaceMenu(int pId, BlockPos pos, Inventory inventory) {
        this(pId, pos, inventory, new ItemStackHandler(4), new SimpleContainerData(4));
    }

    public BrickFurnaceMenu(int id, BlockPos pos, Inventory inventory, IItemHandler container, ContainerData containerData){
        super(MenuTypeRegistry.BRICK_FURNACE.get(), id);
        this.playerEntity = inventory.player;
        this.blockEntity = playerEntity.getCommandSenderWorld().getBlockEntity(pos);
        this.storage = container;
        this.inventory = new InvWrapper(inventory);
        this.data = containerData;

        this.addSlot(new IngredientSlot(storage, SLOT_INPUT_PRIMARY, 56 - 9, 17));
        this.addSlot(new IngredientSlot(storage, SLOT_INPUT_SECONDARY, 56 + 9, 17));
        this.addSlot(new FuelSlot(storage, SLOT_FUEL, 56, 53));
        this.addSlot(new OutputSlot(storage, SLOT_RESULT, 116, 35));

        for(int r = 0; r < 3; ++r) {
            for(int c = 0; c < 9; ++c) {
                this.addSlot(new SlotItemHandler(this.inventory, c + r * 9 + 9, 8 + c * 18, 84 + r * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new SlotItemHandler(this.inventory, k, 8 + k * 18, 142));
        }

        this.addDataSlots(this.data);
    }

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        return ItemStack.EMPTY;
        //TODO
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(blockEntity.getLevel(), blockEntity.getBlockPos()), playerEntity, BlockRegistry.BRICK_FURNACE.get());
    }

    static class OutputSlot extends SlotItemHandler {
        public OutputSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean mayPlace(@Nonnull ItemStack stack) {
            return false;
        }
    }

    static class IngredientSlot extends SlotItemHandler {
        public IngredientSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }
    }

    static class FuelSlot extends SlotItemHandler {
        public FuelSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean mayPlace(@Nonnull ItemStack stack) {
            return ForgeHooks.getBurnTime(stack, RecipeType.SMELTING) > 0;
        }
    }



}
