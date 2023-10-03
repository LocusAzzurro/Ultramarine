package com.voxelutopia.ultramarine.common.block;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

public class BaseDirectionalBlock extends DirectionalBlock implements BaseBlockPropertyHolder {

    protected final BaseBlockProperty property;

    public BaseDirectionalBlock(BaseBlock block){
        this(block.getProperty());
    }

    public BaseDirectionalBlock(BaseBlockProperty property){
        super(property.properties);
        this.property = property;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP));
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getNearestLookingDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Override
    public BaseBlockProperty getProperty() {
        return property;
    }
}
