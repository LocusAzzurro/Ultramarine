package com.voxelutopia.ultramarine.world.block.menu;

import com.google.common.collect.Lists;
import com.voxelutopia.ultramarine.data.recipe.WoodworkingRecipe;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.data.registry.MenuTypeRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeTypeRegistry;
import com.voxelutopia.ultramarine.data.registry.SoundRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntReferenceHolder;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import java.util.List;

public class WoodworkingWorkbenchMenu extends Container {

    public static final int INPUT_SLOT = 0;
    public static final int RESULT_SLOT = 1;
    private static final int INV_SLOT_START = 2;
    private static final int INV_SLOT_END = 29;
    private static final int USE_ROW_SLOT_START = 29;
    private static final int USE_ROW_SLOT_END = 38;
    private final IWorldPosCallable access;
    private final IntReferenceHolder selectedRecipeIndex = IntReferenceHolder.standalone();
    private final World level;
    private List<WoodworkingRecipe> recipes = Lists.newArrayList();
    private ItemStack input = ItemStack.EMPTY;
    final Slot inputSlot;
    final Slot resultSlot;
    Runnable slotUpdateListener = () -> {
    };
    public final IInventory container = new Inventory(1) {
        public void setChanged() {
            super.setChanged();
            WoodworkingWorkbenchMenu.this.slotsChanged(this);
            WoodworkingWorkbenchMenu.this.slotUpdateListener.run();
        }
    };
    final CraftResultInventory resultContainer = new CraftResultInventory();
    private long lastSoundTime;

    public WoodworkingWorkbenchMenu(int pId, PlayerInventory inventory) {
        this(pId, inventory, IWorldPosCallable.NULL);
    }

    public WoodworkingWorkbenchMenu(int id, PlayerInventory inventory, final IWorldPosCallable levelAccess) {
        super(MenuTypeRegistry.WOODWORKING_WORKBENCH.get(), id);
        this.access = levelAccess;
        this.level = inventory.player.level;
        this.inputSlot = this.addSlot(new Slot(this.container, INPUT_SLOT, 20, 33));
        this.resultSlot = this.addSlot(new Slot(this.resultContainer, RESULT_SLOT, 143, 33) {
            public boolean mayPlace(ItemStack itemStack) {
                return false;
            }

            public ItemStack onTake(PlayerEntity player, ItemStack itemStack) {
                // TODO: Check
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
                        level.playSound(null, pos, SoundRegistry.WOODWORK.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
                        WoodworkingWorkbenchMenu.this.lastSoundTime = l;
                    }
                });
                return itemstack;
            }
        });

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; ++k) {
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

    @Override
    public boolean stillValid(PlayerEntity pPlayer) {
        return stillValid(this.access, pPlayer, BlockRegistry.WOODWORKING_WORKBENCH.get());
    }

    @Override
    public boolean clickMenuButton(PlayerEntity pPlayer, int pId) {
        if (this.isValidRecipeIndex(pId)) {
            this.selectedRecipeIndex.set(pId);
            this.setupResultSlot();
        }

        return true;
    }

    private boolean isValidRecipeIndex(int p_40335_) {
        return p_40335_ >= 0 && p_40335_ < this.recipes.size();
    }

    @Override
    public void slotsChanged(IInventory pInventory) {
        ItemStack itemstack = this.inputSlot.getItem();
        if (!itemstack.getItem().equals(this.input.getItem())) {
            this.input = itemstack.copy();
            this.setupRecipeList(pInventory, itemstack);
        }

    }

    private void setupRecipeList(IInventory pInventory, ItemStack pStack) {
        this.recipes.clear();
        this.selectedRecipeIndex.set(-1);
        this.resultSlot.set(ItemStack.EMPTY);
        if (!pStack.isEmpty()) {
            this.recipes = this.level.getRecipeManager().getRecipesFor(RecipeTypeRegistry.WOODWORKING, pInventory, this.level);
        }

    }

    void setupResultSlot() {
        if (!this.recipes.isEmpty() && this.isValidRecipeIndex(this.selectedRecipeIndex.get())) {
            WoodworkingRecipe woodworkingRecipe = this.recipes.get(this.selectedRecipeIndex.get());
            this.resultContainer.setRecipeUsed(woodworkingRecipe);
            this.resultSlot.set(woodworkingRecipe.assemble(this.container));
        } else {
            this.resultSlot.set(ItemStack.EMPTY);
        }

        this.broadcastChanges();
    }

    public ContainerType<?> getType() {
        return MenuTypeRegistry.WOODWORKING_WORKBENCH.get();
    }

    public void registerUpdateListener(Runnable pListener) {
        this.slotUpdateListener = pListener;
    }

    public boolean canTakeItemForPickAll(ItemStack pStack, Slot pSlot) {
        return pSlot.container != this.resultContainer && super.canTakeItemForPickAll(pStack, pSlot);
    }

    @Override
    public ItemStack quickMoveStack(PlayerEntity pPlayer, int pIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            Item item = itemstack1.getItem();
            itemstack = itemstack1.copy();
            if (pIndex == 1) {
                item.onCraftedBy(itemstack1, pPlayer.level, pPlayer);
                if (!this.moveItemStackTo(itemstack1, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (pIndex == 0) {
                if (!this.moveItemStackTo(itemstack1, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.level.getRecipeManager().getRecipeFor(RecipeTypeRegistry.WOODWORKING, new Inventory(itemstack1), this.level).isPresent()) {
                if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (pIndex >= 2 && pIndex < 29) {
                if (!this.moveItemStackTo(itemstack1, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (pIndex >= 29 && pIndex < 38 && !this.moveItemStackTo(itemstack1, 2, 29, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            }

            slot.setChanged();
            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(pPlayer, itemstack1);
            this.broadcastChanges();
        }

        return itemstack;
    }

    @Override
    public void removed(PlayerEntity pPlayer) {
        super.removed(pPlayer);
        this.resultContainer.removeItemNoUpdate(1);
        this.access.execute((w, p) -> {
            this.clearContainer(pPlayer, w, this.container);
        });
    }
}
