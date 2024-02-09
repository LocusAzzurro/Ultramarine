package com.voxelutopia.ultramarine.data.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.registry.RecipeSerializerRegistry;
import com.voxelutopia.ultramarine.data.registry.RecipeTypeRegistry;
import com.voxelutopia.ultramarine.world.block.menu.ChiselTableMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;

public class ChiselTableRecipe implements Recipe<Container> {

    protected final ResourceLocation id;
    protected final String group;
    protected final Ingredient material;
    protected final Ingredient template;
    protected final List<Ingredient> colors;
    protected final ItemStack result;

    public ChiselTableRecipe(ResourceLocation pId, String pGroup, Ingredient material, Ingredient template, Ingredient[] colors, ItemStack pResult) {
        this.id = pId;
        this.group = pGroup;
        this.material = material;
        this.template = template;
        this.colors = new ArrayList<>();
        this.colors.addAll(Arrays.asList(colors));
        this.result = pResult;
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        ItemStack usedMaterial = pContainer.getItem(ChiselTableMenu.SLOT_MATERIAL);
        ItemStack usedTemplate = pContainer.getItem(ChiselTableMenu.SLOT_TEMPLATE);
        List<ItemStack> usedColors = Arrays.asList(ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY);
        for (int i = 0, j = 2; j < pContainer.getContainerSize(); i++, j++){
            usedColors.set(i, pContainer.getItem(j));
        }
        usedColors = usedColors.stream().filter(item -> !item.isEmpty()).collect(Collectors.toList());
        return material.test(usedMaterial) && template.test(usedTemplate) && compareColors(this.colors, usedColors);
    }

    @Override
    public ItemStack assemble(Container pContainer) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
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

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializerRegistry.CHISEL_TABLE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeTypeRegistry.CHISEL_TABLE.get();
    }

    private static boolean compareColors(List<Ingredient> recipeColors, List<ItemStack> usedColors){
        if (recipeColors.size() != usedColors.size()) return false;
        List<ItemStack> usedColorsReverse = new ArrayList<>(usedColors);
        Collections.reverse(usedColorsReverse);
        boolean fwd = true, rvs = true;
        for (int i = 0; i < recipeColors.size(); i++){
            fwd = recipeColors.get(i).test(usedColors.get(i)) && fwd;
            rvs = recipeColors.get(i).test(usedColorsReverse.get(i)) && rvs;
        }
        return fwd || rvs;
    }

    public static class Serializer implements RecipeSerializer<ChiselTableRecipe>{

        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Ultramarine.MOD_ID,"chisel_table");

        protected Serializer() {}

        @Override
        public ChiselTableRecipe fromJson(ResourceLocation pRecipeId, JsonObject pJson) {
            if (!pJson.has("result"))
                throw new JsonSyntaxException("Missing result, expected to find a string or object");

            String group = GsonHelper.getAsString(pJson, "group", "");
            Ingredient material = parseIngredient(pJson, "material");
            Ingredient template = parseIngredient(pJson, "template");
            JsonArray colorsJson = GsonHelper.getAsJsonArray(pJson, "colors");
            Ingredient[] colors = new Ingredient[colorsJson.size()];
            for (int i = 0; i < colors.length; i++){
                colors[i] = Ingredient.fromJson(colorsJson.get(i));
            }

            ItemStack result;
            if (pJson.get("result").isJsonObject()) result = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pJson, "result"));
            else {
                String s1 = GsonHelper.getAsString(pJson, "result");
                ResourceLocation resourcelocation = new ResourceLocation(s1);
                result = new ItemStack(ForgeRegistries.ITEMS.getHolder(resourcelocation).orElseThrow(() -> new IllegalStateException("Item: " + s1 + " does not exist")));
            }

            return new ChiselTableRecipe(pRecipeId, group, material, template, colors, result);
        }

        @Nullable
        @Override
        public ChiselTableRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            String group = pBuffer.readUtf();
            Ingredient material = Ingredient.fromNetwork(pBuffer);
            Ingredient template = Ingredient.fromNetwork(pBuffer);
            Ingredient[] colors = new Ingredient[4];
            for (int i = 0; i < 4; i++){
                colors[i] = Ingredient.fromNetwork(pBuffer);
            }
            colors = Arrays.stream(colors).filter(i -> !i.isEmpty()).toList().toArray(new Ingredient[0]);
            ItemStack result = pBuffer.readItem();
            return new ChiselTableRecipe(pRecipeId, group, material, template, colors, result);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, ChiselTableRecipe pRecipe) {
            pBuffer.writeUtf(pRecipe.group);
            pRecipe.material.toNetwork(pBuffer);
            pRecipe.template.toNetwork(pBuffer);
            Ingredient[] colors = new Ingredient[4];
            for (int i = 0; i < 4; i++) {
                colors[i] = i < pRecipe.colors.size() ? pRecipe.colors.get(i) : Ingredient.EMPTY;
            }
            for (int i = 0; i < 4; i++) {
                colors[i].toNetwork(pBuffer);
            }
            pBuffer.writeItem(pRecipe.result);
        }

        private static Ingredient parseIngredient(JsonObject json, String member){
            JsonElement ingredientRaw = GsonHelper.isArrayNode(json, member) ? GsonHelper.getAsJsonArray(json, member) : GsonHelper.getAsJsonObject(json, member);
            return Ingredient.fromJson(ingredientRaw);
        }

        @Override
        public RecipeSerializer<?> setRegistryName(ResourceLocation name) {
            return INSTANCE;
        }

        @Nullable
        @Override
        public ResourceLocation getRegistryName() {
            return ID;
        }

        @Override
        public Class<RecipeSerializer<?>> getRegistryType() {
            return ChiselTableRecipe.Serializer.castClass(RecipeSerializer.class);
        }

        @SuppressWarnings("unchecked")
        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>)cls;
        }
    }

}
