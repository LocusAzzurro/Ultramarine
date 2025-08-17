package com.voxelutopia.ultramarine.world.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class BaseHorizontalDirectionalBlock extends HorizontalDirectionalBlock implements BaseBlockPropertyHolder {
    private static final MapCodec<BaseHorizontalDirectionalBlock> CODEC = simpleCodec(BaseHorizontalDirectionalBlock::new);
    protected final BaseBlockProperty property;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public BaseHorizontalDirectionalBlock(BaseBlock block){
        this(block.getProperty());
    }

    public BaseHorizontalDirectionalBlock(BaseBlockProperty property){
        super(property.properties);
        this.property = property;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    private BaseHorizontalDirectionalBlock(Properties properties) {
        this(new BaseBlockProperty(properties, BaseBlockProperty.BlockMaterial.STONE));
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection());
    }


    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Override
    public BaseBlockProperty getProperty() {
        return property;
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }
}
