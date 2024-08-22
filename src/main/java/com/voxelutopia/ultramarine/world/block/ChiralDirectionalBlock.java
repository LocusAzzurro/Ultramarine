package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.world.block.state.ChiralBlockType;
import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class ChiralDirectionalBlock extends BaseDirectionalBlock implements BaseBlockPropertyHolder{

    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final EnumProperty<ChiralBlockType> TYPE = ModBlockStateProperties.CHIRAL_BLOCK_TYPE;
    private final BaseBlockProperty property;
    public ChiralDirectionalBlock(BaseBlockProperty property) {
        super(property);
        this.property = property;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP).setValue(TYPE, ChiralBlockType.LEFT));
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction direction = pContext.getNearestLookingDirection().getOpposite();
        return this.defaultBlockState().setValue(FACING, direction).setValue(TYPE, getChiralityFromDirection(direction));
    }

    private ChiralBlockType getChiralityFromDirection(Direction direction){
        return switch (direction){
            case NORTH, WEST -> ChiralBlockType.TOP;
            case SOUTH, EAST -> ChiralBlockType.BOTTOM;
            case UP -> ChiralBlockType.LEFT;
            case DOWN -> ChiralBlockType.RIGHT;
        };
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
        pBuilder.add(TYPE);
    }
    @Override
    public BaseBlockProperty getProperty() {
        return property;
    }
}
