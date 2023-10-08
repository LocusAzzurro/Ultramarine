package com.voxelutopia.ultramarine;

import com.voxelutopia.ultramarine.init.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class UltramarineDataGenerators implements DataGeneratorEntrypoint {

    public static final String MOD_ID = Ultramarine.MOD_ID;

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        ExistingFileHelper fh = ExistingFileHelper.withResourcesFromArg();
        fabricDataGenerator.addProvider(ModBlockTagProvider::new);
        fabricDataGenerator.addProvider(ModItemTagProvider::new);
        fabricDataGenerator.addProvider(ModRecipeProvider::new);
        fabricDataGenerator.addProvider((output) -> new ModBlockModelProvider(output, fh));
        fabricDataGenerator.addProvider((output) -> new ModItemModelProvider(output, fh));
        fabricDataGenerator.addProvider(ModBlockLootTables::new);

    }
}
