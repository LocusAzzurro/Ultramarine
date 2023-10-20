package com.voxelutopia.ultramarine.world.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;

public class BaseDirectionalBlock extends DirectionalBlock implements BaseBlockPropertyHolder {

    protected final BaseBlockProperty property;

    public BaseDirectionalBlock(BaseBlock block) {
        this(block.getProperty());
    }

    public BaseDirectionalBlock(BaseBlockProperty property) {
        super(property.properties);
        this.property = property;
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.UP));
    }

    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getNearestLookingDirection().getOpposite());
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Override
    public BaseBlockProperty getProperty() {
        return property;
    }
}
