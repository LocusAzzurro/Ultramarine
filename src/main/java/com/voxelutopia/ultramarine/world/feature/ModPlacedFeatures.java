package com.voxelutopia.ultramarine.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacedFeatures {

    public static final Holder<PlacedFeature> JADE_ORE_PLACED_FEATURE = PlacementUtils.register("jade_ore",
            ModConfiguredFeatures.JADE_ORE, ModOrePlacement.commonOrePlacement(7,
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))
            ));

    public static final Holder<PlacedFeature> MAGNESITE_ORE_PLACED_FEATURE = PlacementUtils.register("magnesite_ore",
            ModConfiguredFeatures.MAGNESITE_ORE, ModOrePlacement.commonOrePlacement(4,
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-40), VerticalAnchor.aboveBottom(60))
            ));

    public static final Holder<PlacedFeature> HEMATITE_ORE_PLACED_FEATURE = PlacementUtils.register("hematite_ore",
            ModConfiguredFeatures.HEMATITE_ORE, ModOrePlacement.commonOrePlacement(10,
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-24), VerticalAnchor.aboveBottom(56))
            ));

    public static final Holder<PlacedFeature> COBALT_ORE_PLACED_FEATURE = PlacementUtils.register("cobalt_ore",
            ModConfiguredFeatures.COBALT_ORE, ModOrePlacement.commonOrePlacement(8,
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(32))
            ));

}
