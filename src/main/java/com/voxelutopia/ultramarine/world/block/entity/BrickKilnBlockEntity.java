package com.voxelutopia.ultramarine.world.block.entity;

import com.google.common.collect.Lists;
import com.voxelutopia.ultramarine.data.recipe.CompositeSmeltingRecipe;
import com.voxelutopia.ultramarine.data.registry.BlockEntityRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeTypeRegistry;
import com.voxelutopia.ultramarine.world.block.menu.BrickKilnMenu;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.WorldlyContainerWrapper;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NullMarked;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Optional;

@NullMarked
@ParametersAreNonnullByDefault
@SuppressWarnings("unused")
public class BrickKilnBlockEntity extends BlockEntity implements MenuProvider, WorldlyContainer {

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

    private final NonNullList<ItemStack> items = NonNullList.withSize(NUM_SLOTS, ItemStack.EMPTY);

    public final ContainerData dataAccess = new ContainerData() {
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

    private final Object2IntOpenHashMap<ResourceKey<Recipe<?>>> recipesUsed = new Object2IntOpenHashMap<>();

    private static int getFuelBurnTime(ItemStack fuelStack) {
        if (fuelStack.isEmpty()) {
            return 0;
        }
        FurnaceFuel fuel = fuelStack.getItem().builtInRegistryHolder().getData(NeoForgeDataMaps.FURNACE_FUELS);
        return fuel != null ? fuel.burnTime() : 0;
    }

    public BrickKilnBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntityRegistry.BRICK_KILN.get(), blockPos, blockState);
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, BrickKilnBlockEntity pBlockEntity) {
        boolean lit = pBlockEntity.isLit();
        boolean changed = false;

        ItemStack fuelItem = pBlockEntity.getItem(SLOT_FUEL);
        ItemStack primaryItem = pBlockEntity.getItem(SLOT_INPUT_PRIMARY);
        ItemStack secondaryItem = pBlockEntity.getItem(SLOT_INPUT_SECONDARY);
        ItemStack resultItem = pBlockEntity.getItem(SLOT_RESULT);
        var input = new CompositeSmeltingRecipe.CompositeSmeltingRecipeInput(primaryItem, secondaryItem);
        RecipeHolder<CompositeSmeltingRecipe> recipe = ((ServerLevel) pLevel).recipeAccess().getRecipeFor(RecipeTypeRegistry.COMPOSITE_SMELTING.get(), input, pLevel).orElse(null);

        if (pBlockEntity.isLit()) {
            --pBlockEntity.litTime;
        }

        if (recipe != null) {
            pBlockEntity.cookingTotalTime = recipe.value().getCookingTime();
        }

        if (pBlockEntity.isLit() || !fuelItem.isEmpty() && (!primaryItem.isEmpty() && !secondaryItem.isEmpty())) {

            int maxStack = 64;
            if (!pBlockEntity.isLit() && recipe != null && pBlockEntity.canBurn(recipe.value(), fuelItem, primaryItem, secondaryItem, resultItem, maxStack)) {
                pBlockEntity.litTime = getFuelBurnTime(fuelItem);
                pBlockEntity.litDuration = pBlockEntity.litTime;
                if (pBlockEntity.isLit()) {
                    changed = true;
                    fuelItem.shrink(1);
                    pBlockEntity.setItem(SLOT_FUEL, fuelItem);
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
            ItemStack result = pRecipe.assemble(new CompositeSmeltingRecipe.CompositeSmeltingRecipeInput(primary, secondary));
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
            ItemStack newResult = pRecipe.assemble(new CompositeSmeltingRecipe.CompositeSmeltingRecipeInput(primary, secondary));
            if (resultPrev.isEmpty()) {
                entity.setItem(SLOT_RESULT, newResult.copy());
            } else if (resultPrev.is(newResult.getItem())) {
                resultPrev.grow(newResult.getCount());
                entity.setItem(SLOT_RESULT, resultPrev);
            }

            primary.shrink(1);
            secondary.shrink(1);
            entity.setItem(SLOT_INPUT_PRIMARY, primary);
            entity.setItem(SLOT_INPUT_SECONDARY, secondary);
            return true;
        } else {
            return false;
        }
    }

    private static int getTotalCookTime(Level pLevel, BrickKilnBlockEntity entity) {
        var input = new CompositeSmeltingRecipe.CompositeSmeltingRecipeInput(entity.getItem(SLOT_INPUT_PRIMARY), entity.getItem(SLOT_INPUT_SECONDARY));
        return ((ServerLevel) pLevel).recipeAccess()
                .getRecipeFor(RecipeTypeRegistry.COMPOSITE_SMELTING.get(), input, pLevel)
                .map(RecipeHolder::value)
                .map(CompositeSmeltingRecipe::getCookingTime)
                .orElse(200);
    }

    public void setRecipeUsed(@Nullable RecipeHolder<?> pRecipe) {
        if (pRecipe != null) {
            ResourceKey<net.minecraft.world.item.crafting.Recipe<?>> recipeKey = pRecipe.id();
            this.recipesUsed.addTo(recipeKey, 1);
        }

    }

    public void awardUsedRecipes(Player pPlayer) {
    }

    public void awardUsedRecipesAndPopExperience(ServerPlayer pPlayer) {
        if (!pPlayer.level().isClientSide()) {
            List<RecipeHolder<?>> list = this.getRecipesToAwardAndPopExperience(pPlayer.level(), pPlayer.position());
            pPlayer.awardRecipes(list);
            this.recipesUsed.clear();
        }
    }

    public List<RecipeHolder<?>> getRecipesToAwardAndPopExperience(ServerLevel pLevel, Vec3 pos) {
        List<RecipeHolder<?>> list = Lists.newArrayList();

        for (Object2IntMap.Entry<ResourceKey<Recipe<?>>> entry : this.recipesUsed.object2IntEntrySet()) {
            pLevel.recipeAccess().byKey(entry.getKey()).ifPresent((recipe) -> {
                list.add(recipe);
                createExperience(pLevel, pos, entry.getIntValue(), ((CompositeSmeltingRecipe) recipe.value()).getExp());
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
        return new BrickKilnMenu(pContainerId, this.worldPosition, pInventory, this, this.dataAccess);
    }

    public static ResourceHandler<ItemResource> getCapabilities(BrickKilnBlockEntity be, @Nullable Direction direction) {
        return new WorldlyContainerWrapper(be, direction);
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.litTime = input.getIntOr("BurnTime", 0);
        this.cookingProgress = input.getIntOr("CookTime", 0);
        this.cookingTotalTime = input.getIntOr("CookTimeTotal", 0);

        ContainerHelper.loadAllItems(input, this.items);
        this.litDuration = getFuelBurnTime(this.getItem(SLOT_FUEL));

        this.recipesUsed.clear();
        input.read("RecipesUsed", CompoundTag.CODEC).ifPresent(recipesUsedTag -> {
            for (String key : recipesUsedTag.keySet()) {
                Identifier identifier = Identifier.tryParse(key);
                if (identifier != null) {
                    this.recipesUsed.put(
                        ResourceKey.create(Registries.RECIPE, identifier),
                        recipesUsedTag.getIntOr(key, 0)
                    );
                }
            }
        });
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        output.putInt("BurnTime", this.litTime);
        output.putInt("CookTime", this.cookingProgress);
        output.putInt("CookTimeTotal", this.cookingTotalTime);

        ContainerHelper.saveAllItems(output, this.items, false);

        if (!this.recipesUsed.isEmpty()) {
            ValueOutput recipesTag = output.child("RecipesUsed");
            this.recipesUsed.forEach((recipeKey, count) -> recipesTag.putInt(recipeKey.identifier().toString(), count));
        }
    }

    public int getCookingProgress() {
        return this.cookingProgress;
    }

    public int getCookingTotalTime() {
        return this.cookingTotalTime;
    }

    @Override
    public int getContainerSize() {
        return this.items.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : this.items) {
            if (!stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getItem(int slot) {
        return slot >= 0 && slot < this.items.size() ? this.items.get(slot) : ItemStack.EMPTY;
    }

    @Override
    public ItemStack removeItem(int slot, int amount) {
        ItemStack removed = ContainerHelper.removeItem(this.items, slot, amount);
        if (!removed.isEmpty()) {
            this.setChanged();
        }
        return removed;
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        return ContainerHelper.takeItem(this.items, slot);
    }

    @Override
    public void setItem(int slot, ItemStack stack) {
        if (slot >= 0 && slot < this.items.size()) {
            this.items.set(slot, stack);
            this.setChanged();
        }
    }

    @Override
    public int getMaxStackSize() {
        return 64;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void clearContent() {
        this.items.replaceAll(ignored -> ItemStack.EMPTY);
    }

    @Override
    public boolean canPlaceItem(int slot, ItemStack stack) {
        if (slot == SLOT_RESULT) {
            return false;
        }
        if (slot == SLOT_FUEL) {
            return getFuelBurnTime(stack) > 0;
        }
        return true;
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        return switch (side) {
            case UP -> new int[]{SLOT_FUEL};
            case DOWN -> new int[]{SLOT_RESULT};
            default -> new int[]{SLOT_INPUT_PRIMARY, SLOT_INPUT_SECONDARY};
        };
    }

    @Override
    public boolean canPlaceItemThroughFace(int slot, ItemStack stack, @Nullable Direction side) {
        return this.canPlaceItem(slot, stack);
    }

    @Override
    public boolean canTakeItemThroughFace(int slot, ItemStack stack, Direction side) {
        return true;
    }
}
