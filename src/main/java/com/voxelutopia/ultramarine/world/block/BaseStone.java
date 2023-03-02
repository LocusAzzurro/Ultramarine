package com.voxelutopia.ultramarine.world.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class BaseStone extends Block {

    public static final BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of(Material.STONE)
            .strength(1.5F, 6.0F);
    public BaseStone(){
        super(PROPERTIES);
    }



}
