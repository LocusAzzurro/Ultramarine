package com.voxelutopia.ultramarine.data.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.voxelutopia.ultramarine.data.registry.RecipeSerializerRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeTypeRegistry;
import com.voxelutopia.ultramarine.world.block.entity.BrickKilnBlockEntity;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class CompositeSmeltingRecipe implements Recipe<CompositeSmeltingRecipe.CompositeSmeltingRecipeInput> {
    protected final String group;
    protected final Ingredient primaryIngredient;
    protected final Ingredient secondaryIngredient;
    protected final ItemStackTemplate result;
    protected final float experience;
    protected final int cookingTime;

    public CompositeSmeltingRecipe(
            String pGroup,
            Ingredient primaryIngredient,
            Ingredient secondaryIngredient,
            ItemStackTemplate pResult,
            float pExperience,
            int pCookingTime
    ) {
        this.group = pGroup;
        this.primaryIngredient = primaryIngredient;
        this.secondaryIngredient = secondaryIngredient;
        this.result = pResult;
        this.experience = pExperience;
        this.cookingTime = pCookingTime;
    }

    @Override
    public boolean matches(CompositeSmeltingRecipe.CompositeSmeltingRecipeInput pContainer, @NotNull Level pLevel) {
        return this.primaryIngredient.test(pContainer.getItem(BrickKilnBlockEntity.SLOT_INPUT_PRIMARY)) &&
                this.secondaryIngredient.test(pContainer.getItem(BrickKilnBlockEntity.SLOT_INPUT_SECONDARY));
    }

    public boolean partialMatch(RecipeInput pContainer) {
        return primaryIngredient.or(secondaryIngredient).test(pContainer.getItem(0));
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull CompositeSmeltingRecipe.CompositeSmeltingRecipeInput pContainer) {
        return this.result.create();
    }

    public Ingredient getPrimaryIngredient() {
        return primaryIngredient;
    }

    public Ingredient getSecondaryIngredient() {
        return secondaryIngredient;
    }

    public ItemStackTemplate getResult() {
        return result;
    }

    public @NotNull ItemStack getResultItem() {
        return result.create();
    }

    @Override
    public boolean showNotification() {
        return true;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String group() {
        return group;
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.FURNACE_MISC;
    }

    @Override
    public @NotNull RecipeSerializer<CompositeSmeltingRecipe> getSerializer() {
        return RecipeSerializerRegistry.COMPOSITE_SMELTING_SERIALIZER.get();
    }

    @Override
    public @NotNull RecipeType<CompositeSmeltingRecipe> getType() {
        return RecipeTypeRegistry.COMPOSITE_SMELTING.get();
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public float getExp() {
        return experience;
    }

    public static final MapCodec<CompositeSmeltingRecipe> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
            Codec.STRING.optionalFieldOf("group", "").forGetter(CompositeSmeltingRecipe::group),
            Ingredient.CODEC.fieldOf("primary_ingredient").forGetter(CompositeSmeltingRecipe::getPrimaryIngredient),
            Ingredient.CODEC.fieldOf("secondary_ingredient").forGetter(CompositeSmeltingRecipe::getSecondaryIngredient),
            ItemStackTemplate.CODEC.fieldOf("result").forGetter(CompositeSmeltingRecipe::getResult),
            Codec.FLOAT.optionalFieldOf("experience", 0f).forGetter(CompositeSmeltingRecipe::getExp),
            Codec.INT.optionalFieldOf("cookingtime", 200).forGetter(CompositeSmeltingRecipe::getCookingTime)
    ).apply(i, CompositeSmeltingRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, CompositeSmeltingRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8, CompositeSmeltingRecipe::group,
                    Ingredient.CONTENTS_STREAM_CODEC, CompositeSmeltingRecipe::getPrimaryIngredient,
                    Ingredient.CONTENTS_STREAM_CODEC, CompositeSmeltingRecipe::getSecondaryIngredient,
                    ItemStackTemplate.STREAM_CODEC, CompositeSmeltingRecipe::getResult,
                    ByteBufCodecs.FLOAT, CompositeSmeltingRecipe::getExp,
                    ByteBufCodecs.INT, CompositeSmeltingRecipe::getCookingTime,
                    CompositeSmeltingRecipe::new
            );

    public static final RecipeSerializer<CompositeSmeltingRecipe> SERIALIZER = new RecipeSerializer<>(CODEC, STREAM_CODEC);

    public record CompositeSmeltingRecipeInput(ItemStack primaryItem, ItemStack secondaryItem) implements RecipeInput {

        @Override
        public ItemStack getItem(int index) {
            return switch (index) {
                case 0 -> primaryItem;
                case 1 -> secondaryItem;
                default -> ItemStack.EMPTY;
            };
        }

        @Override
        public int size() {
            return 2;
        }

        @Override
        public boolean isEmpty() {
            return primaryItem.isEmpty() && secondaryItem.isEmpty();
        }
    }
}
