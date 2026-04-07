package com.voxelutopia.ultramarine.world.block.menu;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.ModItemTags;
import com.voxelutopia.ultramarine.data.recipe.ChiselTableRecipe;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.data.registry.MenuTypeRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeTypeRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Predicate;

public class ChiselTableMenu extends AbstractContainerMenu {

    public static final int SLOT_MATERIAL = 0;
    public static final int SLOT_TEMPLATE = 1;
    public static final int SLOT_COLOR_START = 2;
    public static final int SLOT_COLOR_END = 6;
    public static final int SLOT_RESULT = 6;
    private static final int INV_SLOT_START = 7;
    private static final int INV_SLOT_END = 34;
    private static final int USE_ROW_SLOT_START = 34;
    private static final int USE_ROW_SLOT_END = 43;

    private static final Predicate<ItemStack> IS_MATERIAL = i -> i.is(ItemTags.LOGS) || i.is(ModItemTags.POLISHED_PLANKS) || i.is(ItemTags.WOOL);
    private static final Predicate<ItemStack> IS_TEMPLATE = i -> i.is(ModItemTags.CHISEL_TEMPLATES);
    private static final Predicate<ItemStack> IS_COLOR = i -> i.is(ModItemTags.COMMON_DYES) || i.is(ModItemTags.DYE_POWDER);

    private final ContainerLevelAccess access;
    private final Player player;
    private final SimpleContainer crafting = new SimpleContainer(6) {
        @Override
        public void setChanged() {
            super.setChanged();
            ChiselTableMenu.this.slotsChanged();
        }
    };
    private final SimpleContainer result = new SimpleContainer(1);
    private final Inventory inventory;

    public ChiselTableMenu(int id, Inventory inventory) {
        this(id, inventory, ContainerLevelAccess.NULL);
    }

    public ChiselTableMenu(int id, Inventory inventory, ContainerLevelAccess access) {
        super(MenuTypeRegistry.CHISEL_TABLE.get(), id);
        this.inventory = inventory;
        this.access = access;
        this.player = inventory.player;

        this.addSlot(new MaterialSlot(crafting, SLOT_MATERIAL, 26, 25));
        this.addSlot(new TemplateSlot(crafting, SLOT_TEMPLATE, 53, 25));
        for (int i = SLOT_COLOR_START, j = 0; i < SLOT_COLOR_END; i++, j++) {
            this.addSlot(new DyeSlot(crafting, i, 26 + j * 18, 52));
        }
        this.addSlot(new OutputSlot(result, 0, 130, 34));

        for (int r = 0; r < 3; ++r) {
            for (int c = 0; c < 9; ++c) {
                this.addSlot(new Slot(this.inventory, c + r * 9 + 9, 8 + c * 18, 84 + r * 18));
            }
        }

        for (int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(this.inventory, k, 8 + k * 18, 142));
        }

        this.createResult();
    }

    private void slotsChanged() {
        this.broadcastChanges();
        this.createResult();
    }

    public void createResult() {
        Level level = player.level();
        if (!(level instanceof ServerLevel serverLevel)) {
            return;
        }

        var input = new ChiselTableRecipe.ChiselTableRecipeInput(this.crafting);
        var recipeManager = serverLevel.recipeAccess();
        @SuppressWarnings("unchecked")
        List<RecipeHolder<ChiselTableRecipe>> matchingRecipes = recipeManager.getRecipes().stream()
                .filter(holder -> holder.value().getType() == RecipeTypeRegistry.CHISEL_TABLE.get())
                .map(holder -> (RecipeHolder<ChiselTableRecipe>) holder)
                .filter(holder -> holder.value().matches(input, serverLevel))
                .toList();

        if (matchingRecipes.size() > 1) {
            Ultramarine.getLogger().warn("Duplicate chisel table recipe: ");
            matchingRecipes.forEach(recipe -> Ultramarine.getLogger().warn(recipe.id().toString()));
        }
        if (matchingRecipes.isEmpty()) {
            this.result.setItem(0, ItemStack.EMPTY);
        } else {
            ChiselTableRecipe recipe = matchingRecipes.getFirst().value();
            ItemStack resultItemStack = recipe.assemble(input);
            this.result.setItem(0, resultItemStack);
        }
    }

    protected void onTake(Player player, ItemStack itemStack, Slot slot) {
        for (int i = 0; i < SLOT_COLOR_END; i++) {
            ItemStack item = crafting.getItem(i);
            if (i != SLOT_TEMPLATE) {
                item.shrink(1);
            }
            crafting.setItem(i, item);
        }
        this.slotsChanged();
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player pPlayer, int pIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);

        if (slot.hasItem()) {
            ItemStack slotItem = slot.getItem();
            itemstack = slotItem.copy();
            if (pIndex == SLOT_RESULT) {
                slotItem.getItem().onCraftedBy(slotItem, pPlayer);
                if (!this.moveItemStackTo(slotItem, INV_SLOT_START, USE_ROW_SLOT_END, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(slotItem, itemstack);
            } else if (pIndex > SLOT_RESULT) { // inv slots
                if (IS_MATERIAL.test(slotItem)) {
                    if (!this.moveItemStackTo(slotItem, SLOT_MATERIAL, SLOT_MATERIAL + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (IS_TEMPLATE.test(slotItem)) {
                    if (!this.moveItemStackTo(slotItem, SLOT_TEMPLATE, SLOT_TEMPLATE + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (IS_COLOR.test(slotItem)) {
                    if (!this.moveItemStackTo(slotItem, SLOT_COLOR_START, SLOT_COLOR_END, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (pIndex < INV_SLOT_END) {
                    if (!this.moveItemStackTo(slotItem, USE_ROW_SLOT_START, USE_ROW_SLOT_END, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (pIndex < USE_ROW_SLOT_END && !this.moveItemStackTo(slotItem, INV_SLOT_START, INV_SLOT_END, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(slotItem, INV_SLOT_START, USE_ROW_SLOT_END, false)) {
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

    public boolean canTakeItemForPickAll(@NotNull ItemStack pStack, @NotNull Slot pSlot) {
        return pSlot.container != this.result && super.canTakeItemForPickAll(pStack, pSlot);
    }

    public void removed(@NotNull Player pPlayer) {
        super.removed(pPlayer);
        this.access.execute((_, _) -> this.clearContainer(pPlayer, this.crafting));
    }

    @Override
    public boolean stillValid(@NotNull Player pPlayer) {
        return stillValid(this.access, pPlayer, BlockRegistry.CHISEL_TABLE.get());
    }

    class OutputSlot extends Slot {

        public OutputSlot(Container container, int index, int xPosition, int yPosition) {
            super(container, index, xPosition, yPosition);
        }

        @Override
        public boolean mayPlace(@NotNull ItemStack stack) {
            return false;
        }

        @Override
        public void onTake(@NotNull Player pPlayer, @NotNull ItemStack pStack) {
            super.onTake(pPlayer, pStack);
            ChiselTableMenu.this.onTake(pPlayer, pStack, this);
        }

        @Override
        public void setChanged() {
            super.setChanged();
            ChiselTableMenu.this.slotsChanged();
        }

        @Override
        public void onQuickCraft(@NotNull ItemStack oldStackIn, @NotNull ItemStack newStackIn) {
            int i = newStackIn.getCount() - oldStackIn.getCount();
            if (i > 0) {
                this.onQuickCraft(newStackIn, i);
            }
        }
    }

    class IngredientSlot extends Slot {

        public IngredientSlot(Container container, int index, int xPosition, int yPosition) {
            super(container, index, xPosition, yPosition);
        }

        @Override
        public void setChanged() {
            super.setChanged();
            ChiselTableMenu.this.slotsChanged();
        }
    }

    class TemplateSlot extends IngredientSlot {

        public TemplateSlot(Container container, int index, int xPosition, int yPosition) {
            super(container, index, xPosition, yPosition);
        }

        @Override
        public boolean mayPlace(@NotNull ItemStack stack) {
            return IS_TEMPLATE.test(stack);
        }


    }

    class MaterialSlot extends IngredientSlot {

        public MaterialSlot(Container container, int index, int xPosition, int yPosition) {
            super(container, index, xPosition, yPosition);
        }

        @Override
        public boolean mayPlace(@NotNull ItemStack stack) {
            return IS_MATERIAL.test(stack);
        }

    }

    class DyeSlot extends IngredientSlot {

        public DyeSlot(Container container, int index, int xPosition, int yPosition) {
            super(container, index, xPosition, yPosition);
        }

        @Override
        public boolean mayPlace(@NotNull ItemStack stack) {
            return IS_COLOR.test(stack);
        }

    }
}
