package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.data.BlockRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, DataGenerators.MOD_ID, existingFileHelper);
    }
    @Override
    protected void registerModels() {
        blockItem(BlockRegistry.CYAN_BRICKS.get());
        blockItem(BlockRegistry.CYAN_BRICK_SLAB.get());
        blockItem(BlockRegistry.CYAN_BRICK_STAIRS.get());
        blockItem(BlockRegistry.OCTAGONAL_PALACE_LANTERN.get());
    }

    private ItemModelBuilder generatedItem(Item item){
        return singleTexture(item.getRegistryName().getPath(), mcLoc("item/generated"), "layer0", modLoc("item/" + item.getRegistryName().getPath()));
    }

    private ItemModelBuilder blockItem(Block block){
        return withExistingParent(block.getRegistryName().getPath(), modLoc("block/" + block.getRegistryName().getPath()));
    }
    @NotNull
    @Override
    public String getName() {
        return DataGenerators.MOD_ID + " Item Models";
    }

}
