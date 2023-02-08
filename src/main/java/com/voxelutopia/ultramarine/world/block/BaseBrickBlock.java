package com.voxelutopia.ultramarine.world.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class BaseBrickBlock extends Block {

    public BaseBrickBlock(){
        super(BlockBehaviour.Properties.of(Material.STONE));
    }
}
