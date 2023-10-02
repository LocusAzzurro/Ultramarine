package com.voxelutopia.ultramarine.world.block;

import com.google.common.collect.ImmutableMap;
import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import java.util.Map;

public class RailingBlock extends Block implements BaseBlockPropertyHolder, IWaterLoggable {

    protected final BaseBlockProperty property;
    private final Map<BlockState, VoxelShape> shapeByIndex;
    private final Map<Direction, VoxelShape> shapeByPart;

    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    public static final BooleanProperty SHIFTED = ModBlockStateProperties.SHIFTED;
    public static final BooleanProperty POLE_LOCKED = ModBlockStateProperties.LOCKED;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private static final VoxelShape MARBLE_POLE = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 22.0D, 10.0D);
    private static final VoxelShape MARBLE_NORTH_SIDE = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 15.0D, 9.0D);
    private static final VoxelShape MARBLE_SOUTH_SIDE = Block.box(7.0D, 0.0D, 7.0D, 9.0D, 15.0D, 16.0D);
    private static final VoxelShape MARBLE_WEST_SIDE = Block.box(0.0D, 0.0D, 7.0D, 9.0D, 15.0D, 9.0D);
    private static final VoxelShape MARBLE_EAST_SIDE = Block.box(7.0D, 0.0D, 7.0D, 16.0D, 15.0D, 9.0D);

    public static final Map<Direction, VoxelShape> MARBLE_SHAPES = ImmutableMap.of(
            Direction.UP, MARBLE_POLE,
            Direction.NORTH, MARBLE_NORTH_SIDE,
            Direction.SOUTH, MARBLE_SOUTH_SIDE,
            Direction.WEST, MARBLE_WEST_SIDE,
            Direction.EAST, MARBLE_EAST_SIDE
    );

    private static final VoxelShape WOODEN_POLE = Block.box(7.0D, 0.0D, 7.0D, 9.0D, 14.0D, 9.0D);
    private static final VoxelShape WOODEN_NORTH_SIDE = Block.box(7.5D, 2.5D, 0.0D, 8.5D, 12.0D, 8.5D);
    private static final VoxelShape WOODEN_SOUTH_SIDE = Block.box(7.5D, 2.5D, 7.5D, 8.5D, 12.0D, 16.0D);
    private static final VoxelShape WOODEN_WEST_SIDE = Block.box(0.0D, 2.5D, 7.5D, 8.5D, 12.0D, 8.5D);
    private static final VoxelShape WOODEN_EAST_SIDE = Block.box(7.5D, 2.5D, 7.5D, 16.0D, 12.0D, 8.5D);

    public static final Map<Direction, VoxelShape> WOODEN_SHAPES = ImmutableMap.of(
            Direction.UP, WOODEN_POLE,
            Direction.NORTH, WOODEN_NORTH_SIDE,
            Direction.SOUTH, WOODEN_SOUTH_SIDE,
            Direction.WEST, WOODEN_WEST_SIDE,
            Direction.EAST, WOODEN_EAST_SIDE
    );

    public RailingBlock(BaseBlockProperty property, Map<Direction, VoxelShape> partShapes) {
        super(property.properties.noOcclusion());
        this.property = property;
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(UP, true)
                .setValue(NORTH, false)
                .setValue(SOUTH, false)
                .setValue(EAST, false)
                .setValue(WEST, false)
                .setValue(SHIFTED, false)
                .setValue(POLE_LOCKED, false)
                .setValue(WATERLOGGED, false));
        this.shapeByPart = partShapes;
        this.shapeByIndex = this.makeShapes();
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        World levelreader = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());
        BlockPos northSide = blockpos.north();
        BlockPos eastSide = blockpos.east();
        BlockPos southSide = blockpos.south();
        BlockPos westSide = blockpos.west();
        BlockState northState = levelreader.getBlockState(northSide);
        BlockState eastState = levelreader.getBlockState(eastSide);
        BlockState southState = levelreader.getBlockState(southSide);
        BlockState westState = levelreader.getBlockState(westSide);
        boolean north = this.connectsTo(northState, northState.isFaceSturdy(levelreader, northSide, Direction.SOUTH));
        boolean east = this.connectsTo(eastState, eastState.isFaceSturdy(levelreader, eastSide, Direction.WEST));
        boolean south = this.connectsTo(southState, southState.isFaceSturdy(levelreader, southSide, Direction.NORTH));
        boolean west = this.connectsTo(westState, westState.isFaceSturdy(levelreader, westSide, Direction.EAST));
        boolean up = !((east && west && !north && !south) || (!east && !west && north && south));
        BlockState waterState = this.defaultBlockState().setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
        return waterState.setValue(NORTH, north).setValue(SOUTH, south).setValue(EAST, east).setValue(SOUTH, south).setValue(UP, up);
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, IWorld pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        boolean north = pState.getValue(NORTH);
        boolean south = pState.getValue(SOUTH);
        boolean east = pState.getValue(EAST);
        boolean west = pState.getValue(WEST);
        if (pState.getValue(WATERLOGGED)) {
            pLevel.getLiquidTicks().scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }
        if (pFacing == Direction.DOWN || pFacing == Direction.UP) {
            return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
        }
        if (pFacing == Direction.NORTH) {
            north = connectsTo(pFacingState, pFacingState.isFaceSturdy(pLevel, pFacingPos, Direction.SOUTH));
        }
        if (pFacing == Direction.SOUTH) {
            south = connectsTo(pFacingState, pFacingState.isFaceSturdy(pLevel, pFacingPos, Direction.NORTH));
        }
        if (pFacing == Direction.EAST) {
            east = connectsTo(pFacingState, pFacingState.isFaceSturdy(pLevel, pFacingPos, Direction.WEST));
        }
        if (pFacing == Direction.WEST) {
            west = connectsTo(pFacingState, pFacingState.isFaceSturdy(pLevel, pFacingPos, Direction.EAST));
        }
        boolean up = pState.getValue(POLE_LOCKED) || !((east && west && !north && !south) || (!east && !west && north && south));
        return pState.setValue(NORTH, north).setValue(SOUTH, south).setValue(EAST, east).setValue(WEST, west).setValue(UP, up);
    }

    public BlockState updatePole(BlockState state) {
        boolean north = state.getValue(NORTH);
        boolean south = state.getValue(SOUTH);
        boolean east = state.getValue(EAST);
        boolean west = state.getValue(WEST);
        boolean up = state.getValue(POLE_LOCKED) || !((east && west && !north && !south) || (!east && !west && north && south));
        return state.setValue(UP, up);
    }

    private boolean connectsTo(BlockState pState, boolean pSideSolid) {
        return pState.is(this) || pState.getBlock() instanceof RailingSlant ||
                // isExceptionForConnection is called with a Block param in 1.16
                !isExceptionForConnection(pState.getBlock()) && pSideSolid;
    }

    @Override
    public VoxelShape getShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        return this.shapeByIndex.get(pState);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        return this.getShape(pState, pLevel, pPos, pContext);
    }

    private Map<BlockState, VoxelShape> makeShapes() {
        ImmutableMap.Builder<BlockState, VoxelShape> builder = ImmutableMap.builder();

        for (Boolean up : UP.getPossibleValues()) {
            for (Boolean east : EAST.getPossibleValues()) {
                for (Boolean north : NORTH.getPossibleValues()) {
                    for (Boolean west : WEST.getPossibleValues()) {
                        for (Boolean south : SOUTH.getPossibleValues()) {
                            VoxelShape shape = VoxelShapes.empty();
                            if (north) shape = VoxelShapes.or(shape, this.shapeByPart.get(Direction.NORTH));
                            if (south) shape = VoxelShapes.or(shape, this.shapeByPart.get(Direction.SOUTH));
                            if (east) shape = VoxelShapes.or(shape, this.shapeByPart.get(Direction.EAST));
                            if (west) shape = VoxelShapes.or(shape, this.shapeByPart.get(Direction.WEST));
                            if (up) shape = VoxelShapes.or(shape, this.shapeByPart.get(Direction.UP));
                            BlockState blockstate = this.defaultBlockState()
                                    .setValue(UP, up)
                                    .setValue(EAST, east)
                                    .setValue(WEST, west)
                                    .setValue(NORTH, north)
                                    .setValue(SOUTH, south);
                            for (Boolean shifted : SHIFTED.getPossibleValues()) {
                                for (Boolean locked : POLE_LOCKED.getPossibleValues()) {
                                    for (Boolean waterlogged : WATERLOGGED.getPossibleValues()) {
                                        blockstate = blockstate
                                                .setValue(SHIFTED, shifted)
                                                .setValue(POLE_LOCKED, locked)
                                                .setValue(WATERLOGGED, waterlogged);
                                        builder.put(blockstate, shape);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return builder.build();
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(UP, NORTH, SOUTH, EAST, WEST, SHIFTED, POLE_LOCKED, WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    public BlockRenderType getRenderShape(BlockState pState) {
        return BlockRenderType.MODEL;
    }

    @Override
    public boolean propagatesSkylightDown(BlockState pState, IBlockReader pReader, BlockPos pPos) {
        return !pState.getValue(WATERLOGGED);
    }

    @Override
    public BaseBlockProperty getProperty() {
        return this.property;
    }
}
