package com.voxelutopia.ultramarine.data.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.voxelutopia.ultramarine.data.registry.RecipeSerializerRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeTypeRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class WoodworkingRecipe extends SingleItemRecipe {

    protected final Ingredient ingredient;
    protected final ItemStack result;
    protected final String group;

    public WoodworkingRecipe(String pGroup, Ingredient pIngredient, ItemStack pResult) {
        super(RecipeTypeRegistry.WOODWORKING.get(), RecipeSerializerRegistry.WOODWORKING_SERIALIZER.get(), pGroup, pIngredient, pResult);
        this.group = pGroup;
        this.ingredient = pIngredient;
        this.result = pResult;
    }

    @Override
    public boolean matches(SingleRecipeInput pContainer, @NotNull Level pLevel) {
        return ingredient.test(pContainer.getItem(0));
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull SingleRecipeInput pContainer, HolderLookup.@NotNull Provider provider) {
        return result.copy();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public ItemStack getResult() {
        return result;
    }

    @Override
    public @NotNull ItemStack getResultItem(HolderLookup.@NotNull Provider provider) {
        return result.copy();
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return RecipeTypeRegistry.WOODWORKING.get();
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return RecipeSerializerRegistry.WOODWORKING_SERIALIZER.get();
    }

    public enum Serializer implements RecipeSerializer<WoodworkingRecipe> {
        INSTANCE;
        public static final MapCodec<WoodworkingRecipe> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
                Codec.STRING.optionalFieldOf("group", "").forGetter(WoodworkingRecipe::getGroup),
                Ingredient.CODEC.fieldOf("ingredient").forGetter(WoodworkingRecipe::getIngredient),
                ItemStack.CODEC.fieldOf("result").forGetter(WoodworkingRecipe::getResult)
        ).apply(i, WoodworkingRecipe::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, WoodworkingRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ByteBufCodecs.STRING_UTF8, WoodworkingRecipe::getGroup,
                        Ingredient.CONTENTS_STREAM_CODEC, WoodworkingRecipe::getIngredient,
                        ItemStack.STREAM_CODEC, WoodworkingRecipe::getResult,
                        WoodworkingRecipe::new
                );

        @Override
        public @NotNull MapCodec<WoodworkingRecipe> codec() {
            return CODEC;
        }

        @Override
        public @NotNull StreamCodec<RegistryFriendlyByteBuf, WoodworkingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }

}
