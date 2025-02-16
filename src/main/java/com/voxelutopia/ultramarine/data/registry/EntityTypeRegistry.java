package com.voxelutopia.ultramarine.data.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.world.entity.SeatEntity;
import com.voxelutopia.ultramarine.world.entity.TravellingMerchant;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class EntityTypeRegistry
{
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Ultramarine.MOD_ID);

    public static final RegistryObject<EntityType<SeatEntity>> SEAT =
            register("seat", () -> EntityType.Builder
                    .<SeatEntity>of(SeatEntity::new, MobCategory.MISC).sized(0.1f, 0.1f).build("seat"));
    public static final RegistryObject<EntityType<TravellingMerchant>> TRAVELLING_MERCHANT =
            register("travelling_merchant", () -> EntityType.Builder
                    .<TravellingMerchant>of(TravellingMerchant::new, MobCategory.CREATURE).sized(0.6f, 2.0f).build("travelling_merchant"));

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, Supplier<EntityType<T>> type) {
        return ENTITIES.register(name, type);
    }
}
