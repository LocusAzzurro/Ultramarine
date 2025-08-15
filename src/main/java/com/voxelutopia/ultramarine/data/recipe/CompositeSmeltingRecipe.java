package com.voxelutopia.ultramarine.data.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.voxelutopia.ultramarine.data.registry.RecipeSerializerRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeTypeRegistry;
import com.voxelutopia.ultramarine.world.block.entity.BrickKilnBlockEntity;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class CompositeSmeltingRecipe implements Recipe<RecipeInput> {
    protected final String group;
    protected final Ingredient primaryIngredient;
    protected final Ingredient secondaryIngredient;
    protected final ItemStack result;
    protected final float experience;
    protected final int cookingTime;

    public CompositeSmeltingRecipe(String pGroup, Ingredient primaryIngredient, Ingredient secondaryIngredient, ItemStack pResult, float pExperience, int pCookingTime) {
        this.group = pGroup;
        this.primaryIngredient = primaryIngredient;
        this.secondaryIngredient = secondaryIngredient;
        this.result = pResult;
        this.experience = pExperience;
        this.cookingTime = pCookingTime;
    }

    @Override
    public boolean matches(RecipeInput pContainer, Level pLevel) {
        return this.primaryIngredient.test(pContainer.getItem(BrickKilnBlockEntity.SLOT_INPUT_PRIMARY)) &&
                this.secondaryIngredient.test(pContainer.getItem(BrickKilnBlockEntity.SLOT_INPUT_SECONDARY));
    }

    public boolean partialMatch(RecipeInput pContainer) {
        return primaryIngredient.or(secondaryIngredient).test(pContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(RecipeInput pContainer, HolderLookup.Provider provider) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    public Ingredient getPrimaryIngredient() {
        return primaryIngredient;
    }

    public Ingredient getSecondaryIngredient() {
        return secondaryIngredient;
    }

    public ItemStack getResult() {
        return result;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return result.copy();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializerRegistry.COMPOSITE_SMELTING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeTypeRegistry.COMPOSITE_SMELTING.get();
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public float getExp() {
        return experience;
    }

    public enum Serializer implements RecipeSerializer<CompositeSmeltingRecipe> {
        INSTANCE;
        public static final MapCodec<CompositeSmeltingRecipe> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
                Codec.STRING.optionalFieldOf("group", "").forGetter(CompositeSmeltingRecipe::getGroup),
                Ingredient.CODEC.fieldOf("primary_ingredient").forGetter(CompositeSmeltingRecipe::getPrimaryIngredient),
                Ingredient.CODEC.fieldOf("secondary_ingredient").forGetter(CompositeSmeltingRecipe::getSecondaryIngredient),
                ItemStack.CODEC.fieldOf("result").forGetter(CompositeSmeltingRecipe::getResult),
                Codec.FLOAT.optionalFieldOf("experience", 0f).forGetter(CompositeSmeltingRecipe::getExp),
                Codec.INT.optionalFieldOf("cookingtime", 200).forGetter(CompositeSmeltingRecipe::getCookingTime)
        ).apply(i, CompositeSmeltingRecipe::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, CompositeSmeltingRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ByteBufCodecs.STRING_UTF8, CompositeSmeltingRecipe::getGroup,
                        Ingredient.CONTENTS_STREAM_CODEC, CompositeSmeltingRecipe::getPrimaryIngredient,
                        Ingredient.CONTENTS_STREAM_CODEC, CompositeSmeltingRecipe::getSecondaryIngredient,
                        ItemStack.STREAM_CODEC, CompositeSmeltingRecipe::getResult,
                        ByteBufCodecs.FLOAT, CompositeSmeltingRecipe::getExp,
                        ByteBufCodecs.INT, CompositeSmeltingRecipe::getCookingTime,
                        CompositeSmeltingRecipe::new
                );

        @Override
        public MapCodec<CompositeSmeltingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, CompositeSmeltingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
