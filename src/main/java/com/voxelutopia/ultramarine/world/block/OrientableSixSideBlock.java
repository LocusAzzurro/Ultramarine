package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;

import java.util.Arrays;

public class OrientableSixSideBlock extends SixSideBlock implements SideBlock {

    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final DirectionProperty DIRECTION = ModBlockStateProperties.ON_FACE_DIRECTION;


    public OrientableSixSideBlock(BaseBlockProperty property, int sideThickness) {
        super(property, sideThickness);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(DIRECTION, Direction.EAST)
                .setValue(WATERLOGGED, false));
    }

    public OrientableSixSideBlock(BaseBlockProperty property) {
        this(property, 1);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        Direction face = pContext.getClickedFace();
        Direction direction = Arrays.stream(pContext.getNearestLookingDirections()).filter(dir -> dir != face && dir != face.getOpposite()).findFirst().orElse(Direction.EAST);
        return this.defaultBlockState()
                .setValue(WATERLOGGED, pContext.getLevel().getFluidState(pContext.getClickedPos()).getType() == Fluids.WATER)
                .setValue(FACING, face).setValue(DIRECTION, direction);
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
        pBuilder.add(DIRECTION);
        pBuilder.add(WATERLOGGED);
    }
}
