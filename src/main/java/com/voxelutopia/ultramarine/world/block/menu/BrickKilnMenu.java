package com.voxelutopia.ultramarine.world.block.menu;

import com.voxelutopia.ultramarine.data.recipe.CompositeSmeltingRecipe;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.data.registry.MenuTypeRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeTypeRegistry;
import com.voxelutopia.ultramarine.world.block.entity.BrickKilnBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;


public class BrickKilnMenu extends AbstractContainerMenu {

    public static final int SLOT_INPUT_PRIMARY = BrickKilnBlockEntity.SLOT_INPUT_PRIMARY; //0
    public static final int SLOT_INPUT_SECONDARY = BrickKilnBlockEntity.SLOT_INPUT_SECONDARY; //1
    public static final int SLOT_FUEL = BrickKilnBlockEntity.SLOT_FUEL; //2
    public static final int SLOT_RESULT = BrickKilnBlockEntity.SLOT_RESULT; //3
    private static final int INV_SLOT_START = 4;
    private static final int INV_SLOT_END = 31;
    private static final int USE_ROW_SLOT_START = 31;
    private static final int USE_ROW_SLOT_END = 40;

    private final ContainerLevelAccess access;
    private final Player player;
    private final Container storage;
    private final ContainerData data;

    public BrickKilnMenu(int pId, BlockPos pos, Inventory inventory) {
        this(pId, pos, inventory, getStorage(inventory.player.level(), pos), new SimpleContainerData(4));
    }

    public BrickKilnMenu(int id, BlockPos pos, Inventory inventory, Container container, ContainerData containerData) {
        super(MenuTypeRegistry.BRICK_KILN.get(), id);
        this.player = inventory.player;
        this.access = ContainerLevelAccess.create(this.player.level(), pos);
        this.storage = container;
        this.data = containerData;

        this.addSlot(new IngredientSlot(storage, SLOT_INPUT_PRIMARY, 46, 17));
        this.addSlot(new IngredientSlot(storage, SLOT_INPUT_SECONDARY, 66, 17));
        this.addSlot(new FuelSlot(storage, SLOT_FUEL, 56, 53, this.player.level()));
        this.addSlot(new OutputSlot(this.player, storage, SLOT_RESULT, 116, 35));

        for (int r = 0; r < 3; ++r) {
            for (int c = 0; c < 9; ++c) {
                this.addSlot(new Slot(inventory, c + r * 9 + 9, 8 + c * 18, 84 + r * 18));
            }
        }

        for (int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(inventory, k, 8 + k * 18, 142));
        }

        this.addDataSlots(this.data);
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player pPlayer, int pIndex) {
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
                } else if (isFuel(slotItem, pPlayer.level())) {
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
                slot.setByPlayer(ItemStack.EMPTY);
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
        if (!(this.player.level() instanceof ServerLevel serverLevel)) {
            return false;
        }
        var recipeManager = serverLevel.recipeAccess();
        return recipeManager.getRecipes().stream()
                .filter(holder -> holder.value().getType() == RecipeTypeRegistry.COMPOSITE_SMELTING.get())
                .anyMatch(holder -> ((CompositeSmeltingRecipe) holder.value()).partialMatch(new SingleRecipeInput(item)));
    }

    @Override
    public boolean stillValid(@NotNull Player pPlayer) {
        return stillValid(this.access, pPlayer, BlockRegistry.BRICK_KILN.get());
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

    static class OutputSlot extends Slot {

        private final Player player;
        private int removeCount;

        public OutputSlot(Player player, Container container, int index, int xPosition, int yPosition) {
            super(container, index, xPosition, yPosition);
            this.player = player;
        }

        @Override
        public boolean mayPlace(@NotNull ItemStack stack) {
            return false;
        }

        @Override
        public ItemStack remove(int amount) {
            if (this.hasItem()) {
                this.removeCount = this.removeCount + Math.min(amount, this.getItem().getCount());
            }
            return super.remove(amount);
        }

        @Override
        public void onTake(Player player, ItemStack stack) {
            this.checkTakeAchievements(stack);
            super.onTake(player, stack);
        }

        @Override
        protected void onQuickCraft(ItemStack stack, int amount) {
            this.removeCount += amount;
            this.checkTakeAchievements(stack);
        }

        @Override
        protected void checkTakeAchievements(ItemStack stack) {
            stack.onCraftedBy(this.player, this.removeCount);
            if (this.player instanceof ServerPlayer serverplayer && this.container instanceof BrickKilnBlockEntity kiln) {
                kiln.awardUsedRecipesAndPopExperience(serverplayer);
            }
            this.removeCount = 0;
        }
    }

    static class IngredientSlot extends Slot {
        public IngredientSlot(Container container, int index, int xPosition, int yPosition) {
            super(container, index, xPosition, yPosition);
        }
    }

    static class FuelSlot extends Slot {
        private final Level level;

        public FuelSlot(Container container, int index, int xPosition, int yPosition, Level level) {
            super(container, index, xPosition, yPosition);
            this.level = level;
        }

        @Override
        public boolean mayPlace(@NotNull ItemStack stack) {
            return BrickKilnMenu.isFuel(stack, this.level);
        }
    }

    private static boolean isFuel(ItemStack stack, Level level) {
        return level.fuelValues().isFuel(stack);
    }

    private static Container getStorage(Level level, BlockPos pos) {
        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof Container container) {
            return container;
        }
        return new SimpleContainer(BrickKilnBlockEntity.NUM_SLOTS);
    }
}
