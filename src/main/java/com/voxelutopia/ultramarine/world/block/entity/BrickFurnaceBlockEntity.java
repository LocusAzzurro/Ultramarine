package com.voxelutopia.ultramarine.world.block.entity;

import com.voxelutopia.ultramarine.data.registry.BlockEntityRegistry;
import com.voxelutopia.ultramarine.world.block.BrickFurnace;
import com.voxelutopia.ultramarine.world.block.menu.BrickFurnaceMenu;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
@SuppressWarnings("unused")
public class BrickFurnaceBlockEntity extends BlockEntity implements MenuProvider {

    public static final int SLOT_INPUT_PRIMARY = 0;
    public static final int SLOT_INPUT_SECONDARY = 1;
    public static final int SLOT_FUEL = 2;
    public static final int SLOT_RESULT = 3;
    public static final int DATA_LIT_TIME = 0;
    public static final int DATA_LIT_DURATION = 1;
    public static final int DATA_COOKING_PROGRESS = 2;
    public static final int DATA_COOKING_TOTAL_TIME = 3;
    public static final int NUM_DATA_VALUES = 4;
    public static final int NUM_SLOTS = 4;
    public static final int BURN_TIME_STANDARD = 200;
    public static final int BURN_COOL_SPEED = 2;

    private static final Component CONTAINER_TITLE = new TranslatableComponent("container.brick_furnace");

    int litTime;
    int litDuration;
    int cookingProgress;
    int cookingTotalTime;

    private final ItemStackHandler ingredientsHandler = new ItemStackHandler(2){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private final ItemStackHandler fuelHandler = new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return ForgeHooks.getBurnTime(stack, RecipeType.SMELTING) > 0;
        }
    };

    private final ItemStackHandler resultHandler = new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return false;
        }
    };

    private LazyOptional<ItemStackHandler> ingredientsLazyHandler = LazyOptional.empty();
    private LazyOptional<ItemStackHandler> fuelLazyHandler = LazyOptional.empty();
    private LazyOptional<ItemStackHandler> resultLazyHandler = LazyOptional.empty();

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

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, BrickFurnaceBlockEntity pBlockEntity){
        //TODO
    }

    @Override
    public Component getDisplayName() {
        return CONTAINER_TITLE;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new BrickFurnaceMenu(pContainerId, this.worldPosition, pInventory,
                wrapHandlers(), this.dataAccess);
    }

    private CombinedInvWrapper wrapHandlers(){
        return new CombinedInvWrapper(this.ingredientsHandler, this.fuelHandler, this.resultHandler);
    }

    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.litTime = pTag.getInt("BurnTime");
        this.cookingProgress = pTag.getInt("CookTime");
        this.cookingTotalTime = pTag.getInt("CookTimeTotal");

        ListTag itemListTag = pTag.getList("Items", 10);
        for(int i = 0; i < itemListTag.size(); ++i) {
            CompoundTag itemTag = itemListTag.getCompound(i);
            int j = itemTag.getByte("Slot") & 255;
            switch (j){
                case SLOT_INPUT_PRIMARY -> this.ingredientsHandler.setStackInSlot(0, ItemStack.of(itemTag));
                case SLOT_INPUT_SECONDARY -> this.ingredientsHandler.setStackInSlot(1, ItemStack.of(itemTag));
                case SLOT_FUEL -> this.fuelHandler.setStackInSlot(0, ItemStack.of(itemTag));
                case SLOT_RESULT -> this.resultHandler.setStackInSlot(0, ItemStack.of(itemTag));
            }
        }

        this.litDuration = ForgeHooks.getBurnTime(this.fuelHandler.getStackInSlot(0), RecipeType.SMELTING);

        CompoundTag recipesTag = pTag.getCompound("RecipesUsed");

        for(String s : recipesTag.getAllKeys()) {
            this.recipesUsed.put(new ResourceLocation(s), recipesTag.getInt(s));
        }

    }

    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.putInt("BurnTime", this.litTime);
        pTag.putInt("CookTime", this.cookingProgress);
        pTag.putInt("CookTimeTotal", this.cookingTotalTime);

        ListTag itemListTag = new ListTag();
        var items = this.wrapHandlers();
        for (int i = 0; i < items.getSlots(); i++){
            ItemStack item = items.getStackInSlot(i);
            if (!item.isEmpty()) {
                CompoundTag itemTag = new CompoundTag();
                itemTag.putByte("Slot", (byte)i);
                item.save(itemTag);
                itemListTag.add(itemTag);
            }
        }
        if (!itemListTag.isEmpty()) {
            pTag.put("Items", itemListTag);
        }

        CompoundTag recipesTag = new CompoundTag();
        this.recipesUsed.forEach((resourceLocation, count) -> recipesTag.putInt(resourceLocation.toString(), count));
        pTag.put("RecipesUsed", recipesTag);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        createLazyHandlers();
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
        if (!this.remove && facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            if (facing == Direction.UP){
                return ingredientsLazyHandler.cast();
            }
            else if (facing == Direction.DOWN){
                return resultLazyHandler.cast();
            }
            else {
                return fuelLazyHandler.cast();
            }
        }
        return super.getCapability(capability, facing);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        ingredientsLazyHandler.invalidate();
        resultLazyHandler.invalidate();
        fuelLazyHandler.invalidate();
    }

    @Override
    public void reviveCaps() {
        super.reviveCaps();
        createLazyHandlers();
    }

    private void createLazyHandlers() {
        this.ingredientsLazyHandler = LazyOptional.of(() -> ingredientsHandler);
        this.resultLazyHandler = LazyOptional.of(() -> resultHandler);
        this.fuelLazyHandler = LazyOptional.of(() -> fuelHandler);
    }

}
