package com.voxelutopia.ultramarine.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BaseBlock extends Block implements BaseBlockPropertyHolder {

    protected final BaseBlockProperty property;

    public BaseBlock(){
        this(BaseBlockProperty.STONE);
    }

    public BaseBlock(BaseBlockProperty property){
        super(property.copy().properties);
        this.property = property;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Shapes.block();
    }

    public BaseBlockProperty getProperty(){
        return property;
    }


}
