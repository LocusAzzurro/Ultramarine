package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.shape.ShapeFunction;
import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Fluids;

import java.util.Arrays;

public class OrientableSixSideBlock extends SixSideBlock implements SideBlock{

    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final DirectionProperty DIRECTION = ModBlockStateProperties.ON_FACE_DIRECTION;

    public OrientableSixSideBlock(BaseBlockProperty property, ShapeFunction shapeFunction) {
        super(property, shapeFunction);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(DIRECTION, Direction.EAST)
                .setValue(WATERLOGGED, false));
    }

    public OrientableSixSideBlock(BaseBlockProperty property, int sideThickness) {
        this(property, ShapeFunction.sixSideShape(sideThickness));
    }

    public OrientableSixSideBlock(BaseBlockProperty property) {
        this(property, 1);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction face = pContext.getClickedFace();
        Direction direction = Arrays.stream(pContext.getNearestLookingDirections()).filter(dir -> dir != face && dir != face.getOpposite()).findFirst().orElse(Direction.EAST);
        return this.defaultBlockState()
                .setValue(WATERLOGGED, pContext.getLevel().getFluidState(pContext.getClickedPos()).getType() == Fluids.WATER)
                .setValue(FACING, face).setValue(DIRECTION, direction);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, DIRECTION, WATERLOGGED);
    }



}
