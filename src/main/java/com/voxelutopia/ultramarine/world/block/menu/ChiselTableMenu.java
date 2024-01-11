package com.voxelutopia.ultramarine.world.block.menu;

import com.voxelutopia.ultramarine.data.ModItemTags;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.data.registry.MenuTypeRegistry;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.UpgradeRecipe;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.Nonnull;
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

    private static final Predicate<ItemStack> IS_LOG = i -> i.is(ItemTags.LOGS);
    private static final Predicate<ItemStack> IS_TEMPLATE = i -> i.is(ModItemTags.POLISHED_PLANKS); //todo change to template
    private static final Predicate<ItemStack> IS_COLOR = i -> i.is(ModItemTags.FORGE_DYES); //todo change to powder

    private final ContainerLevelAccess access;
    private final Player player;
    private final ItemStackHandler crafting = new ItemStackHandler(6);
    private final ItemStackHandler result = new ItemStackHandler(1);
    private final IItemHandler inventory;

    public ChiselTableMenu(int id, Inventory inventory){
        this(id, inventory, ContainerLevelAccess.NULL);
    }

    public ChiselTableMenu(int id, Inventory inventory, ContainerLevelAccess access) {
        super(MenuTypeRegistry.CHISEL_TABLE.get(), id);
        this.inventory = new InvWrapper(inventory);
        this.access = access;
        this.player = inventory.player;

        this.addSlot(new MaterialSlot(crafting, SLOT_MATERIAL, 26, 25));
        this.addSlot(new TemplateSlot(crafting, SLOT_TEMPLATE, 53, 25));
        for (int i = SLOT_COLOR_START, j = 0; i < SLOT_COLOR_END; i++, j++){
            this.addSlot(new DyeSlot(crafting, i, 26 + j * 18,52));
        }
        this.addSlot(new OutputSlot(result, 0, 130, 34));

        for(int r = 0; r < 3; ++r) {
            for(int c = 0; c < 9; ++c) {
                this.addSlot(new SlotItemHandler(this.inventory, c + r * 9 + 9, 8 + c * 18, 84 + r * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new SlotItemHandler(this.inventory, k, 8 + k * 18, 142));
        }
    }

    public void slotsChanged(SlotItemHandler slot) {
        this.broadcastChanges();
        if (slot.getSlotIndex() < SLOT_RESULT){
            this.createResult();
        }
    }

    public void createResult() {

        //List<UpgradeRecipe> list = this.access.getRecipeManager().getRecipesFor(RecipeType.SMITHING, this.inputSlots, this.level);
        if (this.crafting.getStackInSlot(SLOT_COLOR_START).is(Items.BLUE_DYE))
            this.result.setStackInSlot(0, Items.DIAMOND.getDefaultInstance());
        //todo temp
    }

    protected void onTake(Player player, ItemStack itemStack){
        for (int i = 0; i < SLOT_COLOR_END; i++){
            if (i == SLOT_TEMPLATE) continue;
            ItemStack item = crafting.getStackInSlot(i);
            item.shrink(1);
            crafting.setStackInSlot(i, item);
        }
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
            } else if (pIndex > SLOT_RESULT) { // inv slots
                if (IS_LOG.test(slotItem)){
                    if (!this.moveItemStackTo(slotItem, SLOT_MATERIAL, SLOT_MATERIAL + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (IS_TEMPLATE.test(slotItem)){
                    if (!this.moveItemStackTo(slotItem, SLOT_TEMPLATE, SLOT_TEMPLATE + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (IS_COLOR.test(slotItem)){
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
        }
        return itemstack;
    }

    public boolean canTakeItemForPickAll(ItemStack pStack, Slot pSlot) {
        return ((SlotItemHandler)pSlot).getItemHandler() != this.result && super.canTakeItemForPickAll(pStack, pSlot);
    }

    public void removed(Player pPlayer) {
        super.removed(pPlayer);
        this.access.execute((level, blockPos) -> this.clearContainer(pPlayer, this.wrapIngredients()));
    }

    private Container wrapIngredients(){
        var container = new SimpleContainer(6);
        for (int i = 0; i < 6; i++){
            container.setItem(i, this.crafting.getStackInSlot(i));
        }
        return container;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(this.access, pPlayer, BlockRegistry.CHISEL_TABLE.get());
    }

    class OutputSlot extends SlotItemHandler {

        public OutputSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean mayPlace(@Nonnull ItemStack stack) {
            return false;
        }

        @Override
        public void onTake(Player pPlayer, ItemStack pStack) {
            ChiselTableMenu.this.onTake(pPlayer, pStack);
        }
    }

    class IngredientSlot extends SlotItemHandler{

        public IngredientSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public void setChanged() {
            super.setChanged();
            ChiselTableMenu.this.slotsChanged(this);
        }
    }

    class TemplateSlot extends IngredientSlot {

        public TemplateSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean mayPlace(@Nonnull ItemStack stack) {
            return IS_TEMPLATE.test(stack);
        }


    }

    class MaterialSlot extends IngredientSlot {

        public MaterialSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean mayPlace(@Nonnull ItemStack stack) {
            return IS_LOG.test(stack);
        }

    }

    class DyeSlot extends IngredientSlot {

        public DyeSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean mayPlace(@Nonnull ItemStack stack) {
            return IS_COLOR.test(stack);
        }

    }
}
