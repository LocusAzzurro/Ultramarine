package com.voxelutopia.ultramarine.data.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.voxelutopia.ultramarine.data.registry.RecipeSerializerRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeTypeRegistry;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import org.jetbrains.annotations.NotNull;

public class WoodworkingRecipe extends SingleItemRecipe {

    protected final String group;

    public WoodworkingRecipe(Recipe.CommonInfo commonInfo, String group, Ingredient ingredient, ItemStackTemplate result) {
        super(commonInfo, ingredient, result);
        this.group = group;
    }

    @Override
    public String group() {
        return group;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.STONECUTTER;
    }

    @Override
    public @NotNull RecipeType<WoodworkingRecipe> getType() {
        return RecipeTypeRegistry.WOODWORKING.get();
    }

    @Override
    public @NotNull RecipeSerializer<WoodworkingRecipe> getSerializer() {
        return RecipeSerializerRegistry.WOODWORKING_SERIALIZER.get();
    }

    public Ingredient getIngredient() {
        return this.input();
    }

    public ItemStackTemplate getResult() {
        return this.result();
    }

    public ItemStack getResultItem() {
        return this.result().create();
    }

    public static final MapCodec<WoodworkingRecipe> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
            Recipe.CommonInfo.MAP_CODEC.forGetter(o -> o.commonInfo),
            Codec.STRING.optionalFieldOf("group", "").forGetter(WoodworkingRecipe::group),
            Ingredient.CODEC.fieldOf("ingredient").forGetter(WoodworkingRecipe::getIngredient),
            ItemStackTemplate.CODEC.fieldOf("result").forGetter(WoodworkingRecipe::getResult)
    ).apply(i, WoodworkingRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, WoodworkingRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    Recipe.CommonInfo.STREAM_CODEC, o -> o.commonInfo,
                    ByteBufCodecs.STRING_UTF8, WoodworkingRecipe::group,
                    Ingredient.CONTENTS_STREAM_CODEC, WoodworkingRecipe::getIngredient,
                    ItemStackTemplate.STREAM_CODEC, WoodworkingRecipe::getResult,
                    WoodworkingRecipe::new
            );

    public static final RecipeSerializer<WoodworkingRecipe> SERIALIZER = new RecipeSerializer<>(CODEC, STREAM_CODEC);

}
