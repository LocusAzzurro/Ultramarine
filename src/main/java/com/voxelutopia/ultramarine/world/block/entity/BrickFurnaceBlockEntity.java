package com.voxelutopia.ultramarine.world.block.entity;

import com.voxelutopia.ultramarine.data.recipe.CompositeSmeltingRecipe;
import com.voxelutopia.ultramarine.data.registry.BlockEntityRegistry;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
@SuppressWarnings("unused")
public class BrickFurnaceBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer {

    public static final int SLOT_INPUT_PRIMARY = 0;
    public static final int SLOT_INPUT_SECONDARY = 1;
    public static final int SLOT_FUEL = 2;
    public static final int SLOT_RESULT = 3;
    private static final int[] SLOTS_FOR_UP = new int[]{0, 1};
    private static final int[] SLOTS_FOR_DOWN = new int[]{3, 2};
    private static final int[] SLOTS_FOR_SIDES = new int[]{2};
    public static final int DATA_LIT_TIME = 0;
    public static final int DATA_LIT_DURATION = 1;
    public static final int DATA_COOKING_PROGRESS = 2;
    public static final int DATA_COOKING_TOTAL_TIME = 3;
    public static final int NUM_DATA_VALUES = 4;
    public static final int NUM_SLOTS = 4;
    public static final int BURN_TIME_STANDARD = 200;
    public static final int BURN_COOL_SPEED = 2;

    int litTime;
    int litDuration;
    int cookingProgress;
    int cookingTotalTime;

    private final ItemStackHandler itemHandler = new ItemStackHandler(4){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<ItemStackHandler> lazyItemHandler = LazyOptional.empty();

    LazyOptional<? extends IItemHandler>[] sideHandlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);

    protected final ContainerData dataAccess = new ContainerData() {
        public int get(int key) {
            return switch (key) {
                case DATA_LIT_TIME -> BrickFurnaceBlockEntity.this.litTime;
                case DATA_LIT_DURATION -> BrickFurnaceBlockEntity.this.litDuration;
                case DATA_COOKING_PROGRESS -> BrickFurnaceBlockEntity.this.cookingProgress;
                case DATA_COOKING_TOTAL_TIME -> BrickFurnaceBlockEntity.this.cookingTotalTime;
                default -> 0;
            };
        }

        public void set(int key, int value) {
            switch (key) {
                case DATA_LIT_TIME -> BrickFurnaceBlockEntity.this.litTime = value;
                case DATA_LIT_DURATION -> BrickFurnaceBlockEntity.this.litDuration = value;
                case DATA_COOKING_PROGRESS -> BrickFurnaceBlockEntity.this.cookingProgress = value;
                case DATA_COOKING_TOTAL_TIME -> BrickFurnaceBlockEntity.this.cookingTotalTime = value;
            }
        }

        public int getCount() {
            return 4;
        }
    };

    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();

    public BrickFurnaceBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntityRegistry.BRICK_FURNACE.get(), blockPos, blockState);
    }

    @Override
    protected Component getDefaultName() {
        return new TranslatableComponent("container.brick_furnace");
    }

    @Override
    protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
        return null;
        //TODO
    }

    @Override
    public int getContainerSize() {
        return NUM_SLOTS;
    }

    @Override
    public boolean isEmpty() {
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            if (!itemHandler.getStackInSlot(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getItem(int pIndex) {
        return itemHandler.getStackInSlot(pIndex);
    }

    @Override
    public ItemStack removeItem(int pIndex, int pCount) {
        return pIndex >= 0 && pIndex < itemHandler.getSlots() &&
                !itemHandler.getStackInSlot(pIndex).isEmpty() && pCount > 0 ? itemHandler.getStackInSlot(pIndex).split(pCount) : ItemStack.EMPTY;
    }

    @Override
    public ItemStack removeItemNoUpdate(int pIndex) {
        if (pIndex >= 0 && pIndex < itemHandler.getSlots()) {
            itemHandler.setStackInSlot(pIndex, ItemStack.EMPTY);
        }
        return ItemStack.EMPTY;
    }

    @Override
    public void setItem(int pIndex, ItemStack pStack) {
        itemHandler.setStackInSlot(pIndex, pStack);
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        if (this.level != null && this.level.getBlockEntity(this.worldPosition) != this) {
            return false;
        } else {
            return pPlayer.distanceToSqr((double)this.worldPosition.getX() + 0.5D, (double)this.worldPosition.getY() + 0.5D, (double)this.worldPosition.getZ() + 0.5D) <= 64.0D;
        }
    }

    @Override
    public void clearContent() {
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            itemHandler.setStackInSlot(i, ItemStack.EMPTY);
        }
    }

    @Override
    public int[] getSlotsForFace(Direction pSide) {
        if (pSide == Direction.DOWN) {
            return SLOTS_FOR_DOWN;
        } else {
            return pSide == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
        }
    }

    @Override
    public boolean canPlaceItemThroughFace(int pIndex, ItemStack pItemStack, @Nullable Direction pDirection) {
        return this.canPlaceItem(pIndex, pItemStack);
    }

    @Override
    public boolean canTakeItemThroughFace(int pIndex, ItemStack pStack, Direction pDirection) {
        if (pDirection == Direction.DOWN && pIndex == 1) {
            return pStack.is(Items.WATER_BUCKET) || pStack.is(Items.BUCKET);
        } else {
            return true;
        }
    }



    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
        if (!this.remove && facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            if (facing == Direction.UP)
                return sideHandlers[0].cast();
            else if (facing == Direction.DOWN)
                return sideHandlers[1].cast();
            else
                return sideHandlers[2].cast();
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        for (LazyOptional<? extends IItemHandler> sideHandler : sideHandlers) sideHandler.invalidate();
    }

    @Override
    public void reviveCaps() {
        super.reviveCaps();
        this.sideHandlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);
    }

}
