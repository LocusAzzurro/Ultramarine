package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.world.entity.CustomWanderingTrader;
import com.voxelutopia.ultramarine.world.entity.SeatEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class EntityTypeRegistry
{
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Ultramarine.MOD_ID);

    public static final RegistryObject<EntityType<SeatEntity>> SEAT =
            register("seat", () -> EntityType.Builder
                    .<SeatEntity>of(SeatEntity::new, MobCategory.MISC).sized(0.1f, 0.1f).build("seat"));
    public static final RegistryObject<EntityType<CustomWanderingTrader>> CUSTOM_WANDERING_TRADER =
            register("custom_wandering_trader", () -> EntityType.Builder
                    .<CustomWanderingTrader>of(CustomWanderingTrader::new, MobCategory.CREATURE).sized(0.6f, 2.0f).build("custom_wandering_trader"));

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, Supplier<EntityType<T>> type) {
        return ENTITIES.register(name, type);
    }
}
