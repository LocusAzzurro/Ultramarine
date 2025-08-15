package com.voxelutopia.ultramarine.data.loot;

import com.mojang.serialization.MapCodec;
import com.voxelutopia.ultramarine.Ultramarine;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModLootModifiers {

    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Ultramarine.MOD_ID);

    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<? extends IGlobalLootModifier>> REPLACE_TO_SINGLE_ITEM = LOOT_MODIFIER_SERIALIZERS.register("replace_to_single_item", ReplaceToSingleItemLootModifier.CODEC);

}
