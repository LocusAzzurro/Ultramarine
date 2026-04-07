package com.voxelutopia.ultramarine.data.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.voxelutopia.ultramarine.data.registry.RecipeSerializerRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeTypeRegistry;
import com.voxelutopia.ultramarine.world.block.menu.ChiselTableMenu;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public record ChiselTableRecipe(String group, Ingredient material, Ingredient template, List<Ingredient> colors,
                                ItemStackTemplate result) implements Recipe<ChiselTableRecipe.ChiselTableRecipeInput> {

    @Override
    public boolean matches(ChiselTableRecipeInput pContainer, @NotNull Level pLevel) {
        ItemStack usedMaterial = pContainer.getItem(ChiselTableMenu.SLOT_MATERIAL);
        ItemStack usedTemplate = pContainer.getItem(ChiselTableMenu.SLOT_TEMPLATE);
        List<ItemStack> usedColors = Arrays.asList(ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY);
        for (int i = 0, j = 2; j < pContainer.size(); i++, j++) {
            usedColors.set(i, pContainer.getItem(j));
        }
        usedColors = usedColors.stream().filter(item -> !item.isEmpty()).collect(Collectors.toList());
        return material.test(usedMaterial) && template.test(usedTemplate) && compareColors(this.colors, usedColors);
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull ChiselTableRecipe.ChiselTableRecipeInput pContainer) {
        return this.result.create();
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
    public PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.STONECUTTER;
    }

    @Override
    public @NotNull RecipeSerializer<ChiselTableRecipe> getSerializer() {
        return RecipeSerializerRegistry.CHISEL_TABLE_SERIALIZER.get();
    }

    @Override
    public @NotNull RecipeType<ChiselTableRecipe> getType() {
        return RecipeTypeRegistry.CHISEL_TABLE.get();
    }

    private static boolean compareColors(List<Ingredient> recipeColors, List<ItemStack> usedColors) {
        if (recipeColors.size() != usedColors.size()) return false;
        List<ItemStack> usedColorsReverse = new ArrayList<>(usedColors);
        Collections.reverse(usedColorsReverse);
        boolean fwd = true, rvs = true;
        for (int i = 0; i < recipeColors.size(); i++) {
            fwd = recipeColors.get(i).test(usedColors.get(i)) && fwd;
            rvs = recipeColors.get(i).test(usedColorsReverse.get(i)) && rvs;
        }
        return fwd || rvs;
    }

    public static final MapCodec<ChiselTableRecipe> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
            Codec.STRING.optionalFieldOf("group", "").forGetter(ChiselTableRecipe::group),
            Ingredient.CODEC.fieldOf("material").forGetter(ChiselTableRecipe::material),
            Ingredient.CODEC.fieldOf("template").forGetter(ChiselTableRecipe::template),
            Codec.list(Ingredient.CODEC).fieldOf("colors").forGetter(ChiselTableRecipe::colors),
            ItemStackTemplate.CODEC.fieldOf("result").forGetter(ChiselTableRecipe::result)
    ).apply(i, ChiselTableRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, ChiselTableRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8, ChiselTableRecipe::group,
                    Ingredient.CONTENTS_STREAM_CODEC, ChiselTableRecipe::material,
                    Ingredient.CONTENTS_STREAM_CODEC, ChiselTableRecipe::template,
                    ByteBufCodecs.<RegistryFriendlyByteBuf, Ingredient>list().apply(Ingredient.CONTENTS_STREAM_CODEC), ChiselTableRecipe::colors,
                    ItemStackTemplate.STREAM_CODEC, ChiselTableRecipe::result,
                    ChiselTableRecipe::new
            );

    public static final RecipeSerializer<ChiselTableRecipe> SERIALIZER = new RecipeSerializer<>(CODEC, STREAM_CODEC);

    public record ChiselTableRecipeInput(Container container) implements RecipeInput {
        @Override
        public ItemStack getItem(int slot) {
            return container.getItem(slot);
        }

        @Override
        public int size() {
            return container.getContainerSize();
        }
    }
}
