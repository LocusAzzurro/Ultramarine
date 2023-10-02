package com.voxelutopia.ultramarine.world.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class BaseSlab extends SlabBlock implements BaseBlockPropertyHolder {

    private final BaseBlockProperty property;

    public BaseSlab() {
        this(BaseBlockProperty.STONE);
    }

    public BaseSlab(BaseBlock block) {
        super(block.getProperty().properties);
        this.property = block.getProperty();
    }

    public BaseSlab(BaseBlockProperty property) {
        super(property.properties);
        this.property = property;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        return this.getShape(pState, pLevel, pPos, pContext);
    }

    @Override
    public BaseBlockProperty getProperty() {
        return property;
    }
}
