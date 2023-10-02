package com.voxelutopia.ultramarine.world.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;

public class BaseAxialBlock extends Block implements AxialBlock, BaseBlockPropertyHolder {

    protected final BaseBlockProperty property;
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;

    public BaseAxialBlock(BaseBlock block) {
        this(block.getProperty());
    }

    public BaseAxialBlock(BaseBlockProperty property) {
        super(property.properties);
        this.property = property;
        this.registerDefaultState(this.getStateDefinition().any().setValue(AXIS, Direction.Axis.X));
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AXIS);
    }

    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        return this.defaultBlockState().setValue(AXIS, pContext.getHorizontalDirection().getAxis());
    }

    @Override
    public BaseBlockProperty getProperty() {
        return property;
    }

    @Override
    public Direction.Axis getAxis(BlockState pState) {
        return pState.getValue(AXIS);
    }
}