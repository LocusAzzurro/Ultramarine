package com.voxelutopia.ultramarine.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class BrickFurnace extends Block implements EntityBlock, BaseBlockPropertyHolder {


    public BrickFurnace() {
        super(BaseBlockProperty.STONE.properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return null;
    }

    @Override
    public BaseBlockProperty getProperty() {
        return BaseBlockProperty.STONE;
    }
}
