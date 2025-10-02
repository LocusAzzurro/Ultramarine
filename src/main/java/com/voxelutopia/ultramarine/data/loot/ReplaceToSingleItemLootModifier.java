package com.voxelutopia.ultramarine.data.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class ReplaceToSingleItemLootModifier extends LootModifier {

    public static final Supplier<MapCodec<ReplaceToSingleItemLootModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.mapCodec(inst -> codecStart(inst)
                    .and(Codec.STRING.fieldOf("loot_table").forGetter(m -> m.lootTable.toString()))
                    .apply(inst, ReplaceToSingleItemLootModifier::new)
            ));

    private final ResourceLocation lootTable;

    public ReplaceToSingleItemLootModifier(LootItemCondition[] conditionsIn, ResourceLocation lootTable) {
        super(conditionsIn);
        this.lootTable = lootTable;
    }

    private ReplaceToSingleItemLootModifier(LootItemCondition[] conditionsIn, String lootTablePath) {
        this(conditionsIn, ResourceLocation.tryParse(lootTablePath));
    }

    @Override
    @SuppressWarnings("deprecation")
    protected @NotNull ObjectArrayList<ItemStack> doApply(@NotNull ObjectArrayList<ItemStack> generatedLoot, @NotNull LootContext context) {
        for (LootItemCondition condition : this.conditions) {
            if (!condition.test(context)) return generatedLoot;
        }

        Optional<Holder.Reference<LootTable>> lootTable1 = context.getResolver().get(Registries.LOOT_TABLE, ResourceKey.create(Registries.LOOT_TABLE, this.lootTable));
        List<ItemStack> newLoot = new ArrayList<>();
        // Using the 'Raw' version so that the GLM will NOT be applied
        lootTable1.ifPresent(lootTableReference -> lootTableReference.value().getRandomItemsRaw(context, newLoot::add));
        if (newLoot.isEmpty()) return generatedLoot;

        generatedLoot.clear();
        ItemStack lootItem = newLoot.get(0);
        lootItem.setCount(1);
        generatedLoot.add(lootItem);
        return generatedLoot;
    }

    @Override
    public @NotNull MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
