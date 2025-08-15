package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.world.entity.SeatEntity;
import com.voxelutopia.ultramarine.world.entity.TravellingMerchant;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EntityTypeRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, Ultramarine.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<SeatEntity>> SEAT =
            register("seat", () -> EntityType.Builder
                    .<SeatEntity>of(SeatEntity::new, MobCategory.MISC).sized(0.1f, 0.1f).build("seat"));
    public static final DeferredHolder<EntityType<?>, EntityType<TravellingMerchant>> TRAVELLING_MERCHANT =
            register("travelling_merchant", () -> EntityType.Builder
                    .<TravellingMerchant>of(TravellingMerchant::new, MobCategory.CREATURE).sized(0.6f, 2.0f).build("travelling_merchant"));

    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String name, Supplier<EntityType<T>> type) {
        return ENTITIES.register(name, type);
    }
}
