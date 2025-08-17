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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ChiselTableRecipe implements Recipe<RecipeInput> {
    protected final String group;
    protected final Ingredient material;
    protected final Ingredient template;
    protected final List<Ingredient> colors;
    protected final ItemStack result;

    public ChiselTableRecipe(String pGroup, Ingredient material, Ingredient template, List<Ingredient> colors, ItemStack pResult) {
        this.group = pGroup;
        this.material = material;
        this.template = template;
        this.colors = colors;
        this.result = pResult;
    }

    @Override
    public boolean matches(RecipeInput pContainer, Level pLevel) {
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
    public ItemStack assemble(RecipeInput pContainer, HolderLookup.Provider registryAccess) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registryAccess) {
        return result.copy();
    }

    public Ingredient getMaterial() {
        return material;
    }

    public Ingredient getTemplate() {
        return template;
    }

    public List<Ingredient> getColors() {
        return colors;
    }

    public ItemStack getResult() {
        return result;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializerRegistry.CHISEL_TABLE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
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

    public enum Serializer implements RecipeSerializer<ChiselTableRecipe> {
        INSTANCE;

        public static final MapCodec<ChiselTableRecipe> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
                Codec.STRING.optionalFieldOf("group", "").forGetter(ChiselTableRecipe::getGroup),
                Ingredient.CODEC.fieldOf("material").forGetter(ChiselTableRecipe::getMaterial),
                Ingredient.CODEC.fieldOf("template").forGetter(ChiselTableRecipe::getTemplate),
                Ingredient.LIST_CODEC.fieldOf("colors").forGetter(ChiselTableRecipe::getColors),
                ItemStack.CODEC.fieldOf("result").forGetter(ChiselTableRecipe::getResult)
        ).apply(i, ChiselTableRecipe::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, ChiselTableRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ByteBufCodecs.STRING_UTF8, ChiselTableRecipe::getGroup,
                        Ingredient.CONTENTS_STREAM_CODEC, ChiselTableRecipe::getMaterial,
                        Ingredient.CONTENTS_STREAM_CODEC, ChiselTableRecipe::getTemplate,
                        ByteBufCodecs.<RegistryFriendlyByteBuf, Ingredient>list().apply(Ingredient.CONTENTS_STREAM_CODEC), ChiselTableRecipe::getColors,
                        ItemStack.STREAM_CODEC, ChiselTableRecipe::getResult,
                        ChiselTableRecipe::new
                );

        @Override
        public MapCodec<ChiselTableRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, ChiselTableRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }

}
