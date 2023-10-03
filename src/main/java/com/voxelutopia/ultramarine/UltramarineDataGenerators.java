package com.voxelutopia.ultramarine;

import com.voxelutopia.ultramarine.init.datagen.*;
import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
public class UltramarineDataGenerators implements DataGeneratorEntrypoint {

    public static final String MOD_ID = Ultramarine.MOD_ID;

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack generator = fabricDataGenerator.createPack();
        ExistingFileHelper fh = ExistingFileHelper.withResourcesFromArg();
        generator.addProvider(ModBlockTagProvider::new);
        generator.addProvider(ModItemTagProvider::new);
        generator.addProvider(ModRecipeProvider::new);
        generator.addProvider((output, registriesFuture) -> new ModBlockModelProvider(output, fh));
        generator.addProvider((output, registriesFuture) -> new ModItemModelProvider(output, fh));
        generator.addProvider((output, registriesFuture) -> new ModLootTables(output));

    }
}
