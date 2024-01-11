package com.voxelutopia.ultramarine.world.block.menu;

import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.data.registry.MenuTypeRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeTypeRegistry;
import com.voxelutopia.ultramarine.world.block.entity.BrickKilnBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class BrickKilnMenu extends AbstractContainerMenu {

    public static final int SLOT_INPUT_PRIMARY = BrickKilnBlockEntity.SLOT_INPUT_PRIMARY; //0
    public static final int SLOT_INPUT_SECONDARY = BrickKilnBlockEntity.SLOT_INPUT_SECONDARY; //1
    public static final int SLOT_FUEL = BrickKilnBlockEntity.SLOT_FUEL; //2
    public static final int SLOT_RESULT = BrickKilnBlockEntity.SLOT_RESULT; //3
    private static final int INV_SLOT_START = 4;
    private static final int INV_SLOT_END = 31;
    private static final int USE_ROW_SLOT_START = 31;
    private static final int USE_ROW_SLOT_END = 40;
    private final BlockEntity blockEntity;
    private final Player playerEntity;
    private final IItemHandler storage;
    private final IItemHandler inventory;
    private final ContainerData data;

    public BrickKilnMenu(int pId, BlockPos pos, Inventory inventory) {
        this(pId, pos, inventory, new ItemStackHandler(4), new SimpleContainerData(4));
    }

    public BrickKilnMenu(int id, BlockPos pos, Inventory inventory, IItemHandler container, ContainerData containerData){
        super(MenuTypeRegistry.BRICK_KILN.get(), id);
        this.playerEntity = inventory.player;
        this.blockEntity = playerEntity.getCommandSenderWorld().getBlockEntity(pos);
        this.storage = container;
        this.inventory = new InvWrapper(inventory);
        this.data = containerData;

        this.addSlot(new IngredientSlot(storage, SLOT_INPUT_PRIMARY, 46, 17));
        this.addSlot(new IngredientSlot(storage, SLOT_INPUT_SECONDARY, 66, 17));
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
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot.hasItem()) {
            ItemStack slotItem = slot.getItem();
            itemstack = slotItem.copy();
            if (pIndex == SLOT_RESULT) {
                if (!this.moveItemStackTo(slotItem, INV_SLOT_START, USE_ROW_SLOT_END, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(slotItem, itemstack);
            } else if (pIndex != SLOT_FUEL && pIndex != SLOT_INPUT_PRIMARY && pIndex != SLOT_INPUT_SECONDARY) {
                if (this.canProcess(slotItem)) {
                    if (!this.moveItemStackTo(slotItem, SLOT_INPUT_PRIMARY, SLOT_INPUT_SECONDARY + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (isFuel(slotItem)) {
                    if (!this.moveItemStackTo(slotItem, SLOT_FUEL, SLOT_FUEL + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (pIndex >= INV_SLOT_START && pIndex < INV_SLOT_END) {
                    if (!this.moveItemStackTo(slotItem, USE_ROW_SLOT_START, USE_ROW_SLOT_END, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (pIndex >= USE_ROW_SLOT_START && pIndex < USE_ROW_SLOT_END && !this.moveItemStackTo(slotItem, INV_SLOT_START, INV_SLOT_END, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(slotItem, INV_SLOT_START, USE_ROW_SLOT_END, false)) {
                return ItemStack.EMPTY;
            }

            if (slotItem.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (slotItem.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(pPlayer, slotItem);
        }

        return itemstack;
    }

    protected boolean canProcess(ItemStack item) {
        return blockEntity.getLevel().getRecipeManager().getAllRecipesFor(RecipeTypeRegistry.COMPOSITE_SMELTING.get()).stream()
                .anyMatch(recipe -> recipe.partialMatch(new SimpleContainer(item), blockEntity.getLevel()));
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(blockEntity.getLevel(), blockEntity.getBlockPos()), playerEntity, BlockRegistry.BRICK_KILN.get());
    }

    public boolean isLit() {
        return this.data.get(BrickKilnBlockEntity.DATA_LIT_TIME) > 0;
    }

    public int getBurnProgress() {
        int i = this.data.get(BrickKilnBlockEntity.DATA_COOKING_PROGRESS);
        int j = this.data.get(BrickKilnBlockEntity.DATA_COOKING_TOTAL_TIME);
        return j != 0 && i != 0 ? i * 24 / j : 0;
    }

    public int getLitProgress() {
        int i = this.data.get(BrickKilnBlockEntity.DATA_LIT_DURATION);
        if (i == 0) {
            i = 200;
        }

        return this.data.get(BrickKilnBlockEntity.DATA_LIT_TIME) * 13 / i;
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
            return isFuel(stack);
        }
    }

    private static boolean isFuel(@NotNull ItemStack stack) {
        return ForgeHooks.getBurnTime(stack, RecipeType.SMELTING) > 0;
    }


}
