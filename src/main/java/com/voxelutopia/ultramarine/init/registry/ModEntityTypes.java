package com.voxelutopia.ultramarine.init.registry;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.common.tile.CustomWanderingTrader;
import com.voxelutopia.ultramarine.common.tile.SeatEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntityTypes {
    public static EntityType<SeatEntity> SEAT;
    public static EntityType<CustomWanderingTrader> CUSTOM_WANDERING_TRADER;

    public static void registerModEntities() {
        SEAT =

                Registry.register(
                        BuiltInRegistries.ENTITY_TYPE,
                        new ResourceLocation(Ultramarine.MOD_ID, "seat"),
                        FabricEntityTypeBuilder.<SeatEntity>create(MobCategory.MISC, SeatEntity::new)
                                .dimensions(EntityDimensions.fixed(0.1F, 0.1F))
                                .trackRangeBlocks(64).trackedUpdateRate(20)
                                .build()
                );

        CUSTOM_WANDERING_TRADER =

                Registry.register(
                        BuiltInRegistries.ENTITY_TYPE,
                        new ResourceLocation(Ultramarine.MOD_ID, "custom_wandering_trader"),
                        FabricEntityTypeBuilder.create(MobCategory.MISC, CustomWanderingTrader::new)

                                .dimensions(EntityDimensions.fixed(0.6F, 0.2F))
                                .trackRangeBlocks(64).trackedUpdateRate(20)
                                .build()
                );
    }


}
