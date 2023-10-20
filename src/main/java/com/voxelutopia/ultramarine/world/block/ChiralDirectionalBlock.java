package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.world.block.state.ChiralBlockType;
import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;

public class ChiralDirectionalBlock extends BaseDirectionalBlock implements BaseBlockPropertyHolder {

    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final EnumProperty<ChiralBlockType> TYPE = ModBlockStateProperties.CHIRAL_BLOCK_TYPE;
    private final BaseBlockProperty property;

    public ChiralDirectionalBlock(BaseBlockProperty property) {
        super(property);
        this.property = property;
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.UP).setValue(TYPE, ChiralBlockType.LEFT));
    }

    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        Direction direction = pContext.getNearestLookingDirection().getOpposite();
        return this.defaultBlockState().setValue(FACING, direction).setValue(TYPE, getChiralityFromDirection(direction));
    }

    private ChiralBlockType getChiralityFromDirection(Direction direction) {
        switch (direction) {
            case EAST:
            case SOUTH:
                return ChiralBlockType.BOTTOM;
            case UP:
                return ChiralBlockType.LEFT;
            case DOWN:
                return ChiralBlockType.RIGHT;
        }
        ;
        return ChiralBlockType.TOP;
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
        pBuilder.add(TYPE);
    }

    @Override
    public BaseBlockProperty getProperty() {
        return property;
    }
}
