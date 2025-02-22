package com.voxelutopia.ultramarine.world.block.menu;

import com.google.common.collect.Lists;
import com.voxelutopia.ultramarine.data.recipe.WoodworkingRecipe;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.data.registry.MenuTypeRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeTypeRegistry;
import com.voxelutopia.ultramarine.data.registry.SoundRegistry;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class WoodworkingWorkbenchMenu extends AbstractContainerMenu {

    public static final int INPUT_SLOT = 0;
    public static final int RESULT_SLOT = 1;
    private static final int INV_SLOT_START = 2;
    private static final int INV_SLOT_END = 29;
    private static final int USE_ROW_SLOT_START = 29;
    private static final int USE_ROW_SLOT_END = 38;
    private final ContainerLevelAccess access;
    private final DataSlot selectedRecipeIndex = DataSlot.standalone();
    private final Level level;
    private List<WoodworkingRecipe> recipes = Lists.newArrayList();
    private ItemStack input = ItemStack.EMPTY;
    final Slot inputSlot;
    final Slot resultSlot;
    Runnable slotUpdateListener = () -> {
    };
    public final Container container = new SimpleContainer(1) {
        public void setChanged() {
            super.setChanged();
            WoodworkingWorkbenchMenu.this.slotsChanged(this);
            WoodworkingWorkbenchMenu.this.slotUpdateListener.run();
        }
    };
    final ResultContainer resultContainer = new ResultContainer();
    private long lastSoundTime;

    public WoodworkingWorkbenchMenu(int pId, Inventory inventory) {
        this(pId, inventory, ContainerLevelAccess.NULL);
    }

    public WoodworkingWorkbenchMenu(int id, Inventory inventory, final ContainerLevelAccess levelAccess) {
        super(MenuTypeRegistry.WOODWORKING_WORKBENCH.get(), id);
        this.access = levelAccess;
        this.level = inventory.player.level;
        this.inputSlot = this.addSlot(new Slot(this.container, INPUT_SLOT, 20, 33));
        this.resultSlot = this.addSlot(new Slot(this.resultContainer, RESULT_SLOT, 143, 33) {
            public boolean mayPlace(ItemStack itemStack) {
                return false;
            }

            public void onTake(Player player, ItemStack itemStack) {
                itemStack.onCraftedBy(player.level, player, itemStack.getCount());
                WoodworkingWorkbenchMenu.this.resultContainer.awardUsedRecipes(player);
                ItemStack itemstack = WoodworkingWorkbenchMenu.this.inputSlot.remove(1);
                if (!itemstack.isEmpty()) {
                    WoodworkingWorkbenchMenu.this.setupResultSlot();
                }
                super.onTake(player, itemStack);
                levelAccess.execute((level, pos) -> {
                    long l = level.getGameTime();
                    if (WoodworkingWorkbenchMenu.this.lastSoundTime != l) {
                        level.playSound((Player) null, pos, SoundRegistry.WOODWORK.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
                        WoodworkingWorkbenchMenu.this.lastSoundTime = l;
                    }
                });
            }
        });

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(inventory, k, 8 + k * 18, 142));
        }

        this.addDataSlot(this.selectedRecipeIndex);
    }

    public int getSelectedRecipeIndex() {
        return this.selectedRecipeIndex.get();
    }

    public List<WoodworkingRecipe> getRecipes() {
        return this.recipes;
    }

    public int getNumRecipes() {
        return this.recipes.size();
    }

    public boolean hasInputItem() {
        return this.inputSlot.hasItem() && !this.recipes.isEmpty();
    }

    public boolean stillValid(Player pPlayer) {
        return stillValid(this.access, pPlayer, BlockRegistry.WOODWORKING_WORKBENCH.get());
    }

    public boolean clickMenuButton(Player pPlayer, int pId) {
        if (this.isValidRecipeIndex(pId)) {
            this.selectedRecipeIndex.set(pId);
            this.setupResultSlot();
        }

        return true;
    }

    private boolean isValidRecipeIndex(int p_40335_) {
        return p_40335_ >= 0 && p_40335_ < this.recipes.size();
    }

    public void slotsChanged(Container pInventory) {
        ItemStack itemstack = this.inputSlot.getItem();
        if (!itemstack.is(this.input.getItem())) {
            this.input = itemstack.copy();
            this.setupRecipeList(pInventory, itemstack);
        }

    }

    private void setupRecipeList(Container pInventory, ItemStack pStack) {
        this.recipes.clear();
        this.selectedRecipeIndex.set(-1);
        this.resultSlot.set(ItemStack.EMPTY);
        if (!pStack.isEmpty()) {
            this.recipes = this.level.getRecipeManager().getRecipesFor(RecipeTypeRegistry.WOODWORKING.get(), pInventory, this.level);
        }

    }

    void setupResultSlot() {
        if (!this.recipes.isEmpty() && this.isValidRecipeIndex(this.selectedRecipeIndex.get())) {
            WoodworkingRecipe woodworkingRecipe = this.recipes.get(this.selectedRecipeIndex.get());
            this.resultContainer.setRecipeUsed(woodworkingRecipe);
            this.resultSlot.set(woodworkingRecipe.assemble(this.container, level.registryAccess()));
        } else {
            this.resultSlot.set(ItemStack.EMPTY);
        }

        this.broadcastChanges();
    }

    public MenuType<?> getType() {
        return MenuTypeRegistry.WOODWORKING_WORKBENCH.get();
    }

    public void registerUpdateListener(Runnable pListener) {
        this.slotUpdateListener = pListener;
    }

    public boolean canTakeItemForPickAll(ItemStack pStack, Slot pSlot) {
        return pSlot.container != this.resultContainer && super.canTakeItemForPickAll(pStack, pSlot);
    }

    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot.hasItem()) {
            ItemStack slotItem = slot.getItem();
            Item item = slotItem.getItem();
            itemstack = slotItem.copy();
            if (pIndex == 1) {
                item.onCraftedBy(slotItem, pPlayer.level, pPlayer);
                if (!this.moveItemStackTo(slotItem, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(slotItem, itemstack);
            } else if (pIndex == 0) {
                if (!this.moveItemStackTo(slotItem, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.level.getRecipeManager().getRecipeFor(RecipeTypeRegistry.WOODWORKING.get(), new SimpleContainer(slotItem), this.level).isPresent()) {
                if (!this.moveItemStackTo(slotItem, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (pIndex >= 2 && pIndex < 29) {
                if (!this.moveItemStackTo(slotItem, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (pIndex >= 29 && pIndex < 38 && !this.moveItemStackTo(slotItem, 2, 29, false)) {
                return ItemStack.EMPTY;
            }

            if (slotItem.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            }

            slot.setChanged();
            if (slotItem.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(pPlayer, slotItem);
            this.broadcastChanges();
        }

        return itemstack;
    }

    public void removed(Player pPlayer) {
        super.removed(pPlayer);
        this.resultContainer.removeItemNoUpdate(1);
        this.access.execute((p_40313_, p_40314_) -> {
            this.clearContainer(pPlayer, this.container);
        });
    }
}
