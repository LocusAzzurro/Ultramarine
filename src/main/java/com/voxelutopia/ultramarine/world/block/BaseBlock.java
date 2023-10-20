package com.voxelutopia.ultramarine.world.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class BaseBlock extends Block implements BaseBlockPropertyHolder {

    protected final BaseBlockProperty property;

    public BaseBlock() {
        this(BaseBlockProperty.STONE);
    }

    public BaseBlock(BaseBlockProperty property) {
        super(property.copy().properties);
        this.property = property;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        return VoxelShapes.block();
    }

    public BaseBlockProperty getProperty() {
        return property;
    }


}
