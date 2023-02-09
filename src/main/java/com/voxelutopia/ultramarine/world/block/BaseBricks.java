package com.voxelutopia.ultramarine.world.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class BaseBricks extends Block {

    public static final BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of(Material.STONE);
    public BaseBricks(){
        super(PROPERTIES);
    }



}
