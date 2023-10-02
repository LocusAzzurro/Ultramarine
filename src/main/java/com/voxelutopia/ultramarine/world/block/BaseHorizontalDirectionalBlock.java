package com.voxelutopia.ultramarine.world.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;

public class BaseHorizontalDirectionalBlock extends HorizontalBlock implements BaseBlockPropertyHolder {

    protected final BaseBlockProperty property;
    public static final DirectionProperty FACING = HorizontalBlock.FACING;

    public BaseHorizontalDirectionalBlock(BaseBlock block) {
        this(block.getProperty());
    }

    public BaseHorizontalDirectionalBlock(BaseBlockProperty property) {
        super(property.properties);
        this.property = property;
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection());
    }


    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Override
    public BaseBlockProperty getProperty() {
        return property;
    }
}
