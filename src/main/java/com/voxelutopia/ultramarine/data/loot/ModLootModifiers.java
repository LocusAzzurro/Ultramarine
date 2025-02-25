package com.voxelutopia.ultramarine.data.loot;

import com.mojang.serialization.Codec;
import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {

    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Ultramarine.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> REPLACE_TO_SINGLE_ITEM = LOOT_MODIFIER_SERIALIZERS.register("replace_to_single_item", ReplaceToSingleItemLootModifier.CODEC);

}
