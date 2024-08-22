package com.voxelutopia.ultramarine.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BaseSlab extends SlabBlock implements BaseBlockPropertyHolder {

    private final BaseBlockProperty property;

    public BaseSlab() {
        this(BaseBlockProperty.STONE);
    }

    public BaseSlab(BaseBlock block){
        super(block.getProperty().properties);
        this.property = block.getProperty();
    }

    public BaseSlab(BaseBlockProperty property){
        super(property.properties);
        this.property = property;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return this.getShape(pState, pLevel, pPos, pContext);
    }

    @Override
    public BaseBlockProperty getProperty() {
        return property;
    }
}
