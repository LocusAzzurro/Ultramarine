package com.voxelutopia.ultramarine.world.block.entity;

import com.google.common.collect.Lists;
import com.voxelutopia.ultramarine.data.recipe.CompositeSmeltingRecipe;
import com.voxelutopia.ultramarine.data.registry.BlockEntityRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeTypeRegistry;
import com.voxelutopia.ultramarine.world.block.menu.BrickKilnMenu;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.wrapper.CombinedInvWrapper;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import net.neoforged.neoforge.items.wrapper.RecipeWrapper;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Optional;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
@SuppressWarnings("unused")
public class BrickKilnBlockEntity extends BlockEntity implements MenuProvider {

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

    private static final Component CONTAINER_TITLE = Component.translatable("container.brick_kiln");

    int litTime;
    int litDuration;
    int cookingProgress;
    int cookingTotalTime;

    private final ItemStackHandler ingredientsHandler = new ItemStackHandler(2) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private final ItemStackHandler fuelHandler = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return Optional.ofNullable(stack.getItemHolder().getData(NeoForgeDataMaps.FURNACE_FUELS)).map(FurnaceFuel::burnTime).orElse(0) > 0;
        }
    };

    private final ItemStackHandler resultHandler = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return false;
        }
    };

    protected final ContainerData dataAccess = new ContainerData() {
        public int get(int key) {
            return switch (key) {
                case DATA_LIT_TIME -> BrickKilnBlockEntity.this.litTime;
                case DATA_LIT_DURATION -> BrickKilnBlockEntity.this.litDuration;
                case DATA_COOKING_PROGRESS -> BrickKilnBlockEntity.this.cookingProgress;
                case DATA_COOKING_TOTAL_TIME -> BrickKilnBlockEntity.this.cookingTotalTime;
                default -> 0;
            };
        }

        public void set(int key, int value) {
            switch (key) {
                case DATA_LIT_TIME -> BrickKilnBlockEntity.this.litTime = value;
                case DATA_LIT_DURATION -> BrickKilnBlockEntity.this.litDuration = value;
                case DATA_COOKING_PROGRESS -> BrickKilnBlockEntity.this.cookingProgress = value;
                case DATA_COOKING_TOTAL_TIME -> BrickKilnBlockEntity.this.cookingTotalTime = value;
            }
        }

        public int getCount() {
            return 4;
        }
    };

    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();

    public BrickKilnBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntityRegistry.BRICK_KILN.get(), blockPos, blockState);
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, BrickKilnBlockEntity pBlockEntity) {
        boolean lit = pBlockEntity.isLit();
        boolean changed = false;

        ItemStack fuelItem = pBlockEntity.fuelHandler.getStackInSlot(0);
        ItemStack primaryItem = pBlockEntity.ingredientsHandler.getStackInSlot(0);
        ItemStack secondaryItem = pBlockEntity.ingredientsHandler.getStackInSlot(1);
        ItemStack resultItem = pBlockEntity.resultHandler.getStackInSlot(0);
        RecipeHolder<CompositeSmeltingRecipe> recipe = pLevel.getRecipeManager().getRecipeFor(RecipeTypeRegistry.COMPOSITE_SMELTING.get(), wrapRecipe(pBlockEntity), pLevel).orElse(null);

        if (pBlockEntity.isLit()) {
            --pBlockEntity.litTime;
        }

        if (recipe != null) {
            pBlockEntity.cookingTotalTime = recipe.value().getCookingTime();
        }

        if (pBlockEntity.isLit() || !fuelItem.isEmpty() && (!primaryItem.isEmpty() && !secondaryItem.isEmpty())) {

            int maxStack = 64;
            if (!pBlockEntity.isLit() && recipe != null && pBlockEntity.canBurn(recipe.value(), fuelItem, primaryItem, secondaryItem, resultItem, maxStack)) {
                pBlockEntity.litTime = Optional.ofNullable(fuelItem.getItemHolder().getData(NeoForgeDataMaps.FURNACE_FUELS)).map(FurnaceFuel::burnTime).orElse(0);
                pBlockEntity.litDuration = pBlockEntity.litTime;
                if (pBlockEntity.isLit()) {
                    changed = true;
                    fuelItem.shrink(1);
                    pBlockEntity.fuelHandler.setStackInSlot(0, fuelItem);
                    //no lava buckets
                }
            }

            if (recipe != null && pBlockEntity.isLit() && pBlockEntity.canBurn(recipe.value(), fuelItem, primaryItem, secondaryItem, resultItem, maxStack)) {
                ++pBlockEntity.cookingProgress;
                if (pBlockEntity.cookingProgress == pBlockEntity.cookingTotalTime) {
                    pBlockEntity.cookingProgress = 0;
                    pBlockEntity.cookingTotalTime = getTotalCookTime(pLevel, pBlockEntity);
                    if (pBlockEntity.burn(recipe.value(), pBlockEntity, fuelItem, primaryItem, secondaryItem, resultItem, maxStack)) {
                        pBlockEntity.setRecipeUsed(recipe);
                    }

                    changed = true;
                }
            } else {
                pBlockEntity.cookingProgress = 0;
            }
        } else if (pBlockEntity.cookingProgress > 0) {
            pBlockEntity.cookingProgress = Mth.clamp(pBlockEntity.cookingProgress - 2, 0, pBlockEntity.cookingTotalTime);
        }

        if (lit != pBlockEntity.isLit()) {
            changed = true;
            pState = pState.setValue(AbstractFurnaceBlock.LIT, pBlockEntity.isLit());
            pLevel.setBlock(pPos, pState, 3);
        }

        if (changed) {
            setChanged(pLevel, pPos, pState);
        }
    }

    private boolean canBurn(@Nullable CompositeSmeltingRecipe pRecipe, ItemStack fuel, ItemStack primary, ItemStack secondary, ItemStack resultPrev, int maxStackSize) {
        if (!primary.isEmpty() && !secondary.isEmpty() && pRecipe != null) {
            ItemStack result = (pRecipe.assemble(new RecipeWrapper(new InvWrapper(new SimpleContainer(primary, secondary))), this.level.registryAccess()));
            if (result.isEmpty()) {
                return false;
            } else {
                if (resultPrev.isEmpty()) {
                    return true;
                } else if (!ItemStack.isSameItem(resultPrev, result)) {
                    return false;
                } else if (resultPrev.getCount() + result.getCount() <= maxStackSize && resultPrev.getCount() + result.getCount() <= resultPrev.getMaxStackSize()) { // Forge fix: make furnace respect stack sizes in furnace recipes
                    return true;
                } else {
                    return resultPrev.getCount() + result.getCount() <= result.getMaxStackSize(); // Forge fix: make furnace respect stack sizes in furnace recipes
                }
            }
        } else {
            return false;
        }
    }

    private boolean burn(CompositeSmeltingRecipe pRecipe, BrickKilnBlockEntity entity, ItemStack fuel, ItemStack primary, ItemStack secondary, ItemStack resultPrev, int maxStackSize) {
        if (this.canBurn(pRecipe, fuel, primary, secondary, resultPrev, maxStackSize)) {
            ItemStack newResult = (pRecipe.assemble(new RecipeWrapper(new InvWrapper(new SimpleContainer(primary, secondary))), level.registryAccess()));
            if (resultPrev.isEmpty()) {
                entity.resultHandler.setStackInSlot(0, newResult.copy());
            } else if (resultPrev.is(newResult.getItem())) {
                resultPrev.grow(newResult.getCount());
            }

            primary.shrink(1);
            secondary.shrink(1);
            entity.ingredientsHandler.setStackInSlot(0, primary);
            entity.ingredientsHandler.setStackInSlot(1, secondary);
            return true;
        } else {
            return false;
        }
    }

    private static int getTotalCookTime(Level pLevel, BrickKilnBlockEntity entity) {
        return pLevel.getRecipeManager().getRecipeFor(RecipeTypeRegistry.COMPOSITE_SMELTING.get(), wrapRecipe(entity), pLevel).map(RecipeHolder::value).map(CompositeSmeltingRecipe::getCookingTime).orElse(200);
    }

    public void setRecipeUsed(@Nullable RecipeHolder<?> pRecipe) {
        if (pRecipe != null) {
            ResourceLocation resourcelocation = pRecipe.id();
            this.recipesUsed.addTo(resourcelocation, 1);
        }

    }

    public void awardUsedRecipes(Player pPlayer) {
    }

    public void awardUsedRecipesAndPopExperience(ServerPlayer pPlayer) {
        if (!pPlayer.level().isClientSide()) {
            List<RecipeHolder<?>> list = this.getRecipesToAwardAndPopExperience((ServerLevel) pPlayer.level(), pPlayer.position());
            pPlayer.awardRecipes(list);
            this.recipesUsed.clear();
        }
    }

    public List<RecipeHolder<?>> getRecipesToAwardAndPopExperience(ServerLevel pLevel, Vec3 pos) {
        List<RecipeHolder<?>> list = Lists.newArrayList();

        for (Object2IntMap.Entry<ResourceLocation> entry : this.recipesUsed.object2IntEntrySet()) {
            pLevel.getRecipeManager().byKey(entry.getKey()).ifPresent((p_155023_) -> {
                list.add(p_155023_);
                createExperience(pLevel, pos, entry.getIntValue(), ((AbstractCookingRecipe) p_155023_.value()).getExperience());
            });
        }

        return list;
    }

    private static void createExperience(ServerLevel pLevel, Vec3 p_155000_, int p_155001_, float p_155002_) {
        int i = Mth.floor((float) p_155001_ * p_155002_);
        float f = Mth.frac((float) p_155001_ * p_155002_);
        if (f != 0.0F && Math.random() < (double) f) {
            ++i;
        }

        ExperienceOrb.award(pLevel, p_155000_, i);
    }

    private boolean isLit() {
        return this.litTime > 0;
    }

    @Override
    public Component getDisplayName() {
        return CONTAINER_TITLE;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new BrickKilnMenu(pContainerId, this.worldPosition, pInventory, this.wrapHandlers(), this.dataAccess);
    }

    public CombinedInvWrapper wrapHandlers() {
        return new CombinedInvWrapper(this.ingredientsHandler, this.fuelHandler, this.resultHandler);
    }

    private static RecipeWrapper wrapRecipe(BrickKilnBlockEntity entity) {
        return new RecipeWrapper(entity.ingredientsHandler);
    }

    @Override
    public void loadAdditional(CompoundTag pTag, HolderLookup.Provider provider) {
        super.loadAdditional(pTag, provider);
        this.litTime = pTag.getInt("BurnTime");
        this.cookingProgress = pTag.getInt("CookTime");
        this.cookingTotalTime = pTag.getInt("CookTimeTotal");

        ListTag itemListTag = pTag.getList("Items", 10);
        for (int i = 0; i < itemListTag.size(); ++i) {
            CompoundTag itemTag = itemListTag.getCompound(i);
            int j = itemTag.getByte("Slot") & 255;
            switch (j) {
                case SLOT_INPUT_PRIMARY ->
                        this.ingredientsHandler.setStackInSlot(0, ItemStack.parseOptional(provider, itemTag));
                case SLOT_INPUT_SECONDARY ->
                        this.ingredientsHandler.setStackInSlot(1, ItemStack.parseOptional(provider, itemTag));
                case SLOT_FUEL -> this.fuelHandler.setStackInSlot(0, ItemStack.parseOptional(provider, itemTag));
                case SLOT_RESULT -> this.resultHandler.setStackInSlot(0, ItemStack.parseOptional(provider, itemTag));
            }
        }

        this.litDuration = Optional.ofNullable(this.fuelHandler.getStackInSlot(0).getItemHolder().getData(NeoForgeDataMaps.FURNACE_FUELS)).map(FurnaceFuel::burnTime).orElse(0);

        CompoundTag recipesTag = pTag.getCompound("RecipesUsed");

        for (String s : recipesTag.getAllKeys()) {
            this.recipesUsed.put(ResourceLocation.withDefaultNamespace(s), recipesTag.getInt(s));
        }

    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider provider) {
        super.saveAdditional(pTag, provider);
        pTag.putInt("BurnTime", this.litTime);
        pTag.putInt("CookTime", this.cookingProgress);
        pTag.putInt("CookTimeTotal", this.cookingTotalTime);

        ListTag itemListTag = new ListTag();
        CombinedInvWrapper items = this.wrapHandlers();
        for (int i = 0; i < items.getSlots(); i++) {
            ItemStack item = items.getStackInSlot(i);
            if (!item.isEmpty()) {
                CompoundTag itemTag = new CompoundTag();
                itemTag.putByte("Slot", (byte) i);
                item.save(provider, itemTag);
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
}
