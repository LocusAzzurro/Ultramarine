package com.voxelutopia.ultramarine.world.block.state;

import com.voxelutopia.ultramarine.world.block.BaseBlockProperty;
import com.voxelutopia.ultramarine.world.block.DecorativeBlock;

public class HangingLantern extends DecorativeBlock {

    public HangingLantern() {
        super(DecorativeBlock.with(BaseBlockProperty.WOOD).directional().luminous());
    }



}
