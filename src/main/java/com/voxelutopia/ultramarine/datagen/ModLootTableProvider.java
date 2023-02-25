package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.BlockRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModLootTableProvider extends BaseLootTableProvider {

    public ModLootTableProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void addTables() {
        simple(BlockRegistry.CYAN_BRICKS);
        simple(BlockRegistry.CYAN_BRICK_SLAB);
        simple(BlockRegistry.CYAN_BRICK_STAIRS);
        simple(BlockRegistry.OCTAGONAL_PALACE_LANTERN);
        simple(BlockRegistry.SQUARE_PALACE_LANTERN);
        simple(BlockRegistry.WHITE_SKY_LANTERN);
        simple(BlockRegistry.RED_SKY_LANTERN);
        simple(BlockRegistry.YELLOW_SKY_LANTERN);
    }

    void simple(RegistryObject<? extends Block> block) {
        lootTables.put(block.get(), createSimpleTable(block.getId().getPath(), block.get()));
    }

}
