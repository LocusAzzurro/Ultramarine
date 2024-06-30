package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LongTableBlock extends Block implements BaseBlockPropertyHolder {

    public static final EnumProperty<Direction.Axis> AXIS = EnumProperty.create("axis", Direction.Axis.class, Direction.Axis.X, Direction.Axis.Z);
    public static final BooleanProperty LEFT = ModBlockStateProperties.LEFT;
    public static final BooleanProperty RIGHT = ModBlockStateProperties.RIGHT;

    protected final BaseBlockProperty property;

    public LongTableBlock(BaseBlockProperty property) {
        super(property.properties);
        this.property = property;

        registerDefaultState(getStateDefinition().any()
                .setValue(AXIS, Direction.Axis.X)
                .setValue(LEFT, false)
                .setValue(RIGHT, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(AXIS, LEFT, RIGHT);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction.Axis axis = pContext.getHorizontalDirection().getClockWise().getAxis();
        return Objects.requireNonNull(super.getStateForPlacement(pContext))
                .setValue(AXIS, axis)
                .setValue(LEFT, false)
                .setValue(RIGHT, false);
    }

    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
        super.neighborChanged(pState, pLevel, pPos, pBlock, pFromPos, pIsMoving);
        update(pLevel, pPos, new HashSet<>());
    }

    private void update(Level level, BlockPos pos, Set<BlockPos> visited) {
        var toVisit = new ArrayList<BlockPos>();
        for (var x = -1; x <= 1; x++) {
            for (var z = -1; z<= 1; z++) {
                var neighbor = pos.offset(x, 0, z);
                toVisit.add(neighbor);
            }
        }

        for (var p : toVisit) {
            if (visited.contains(p)) {
                continue;
            }

            visited.add(p);
            if (!isTableBlock(level, p)) {
                continue;
            }

            updateState(level, p);
            update(level, p, visited);
        }
    }

    private void updateState(Level level, BlockPos pos) {
        if (!level.isLoaded(pos)) {
            return;
        }

        var state = level.getBlockState(pos);

        var east = pos.east();
        var west = pos.west();
        var isTableAtEast = isTableBlock(level, east);
        var isTableAtWest = isTableBlock(level, west);

        if (isTableAtEast || isTableAtWest) {
            state = state.setValue(AXIS, Direction.Axis.X)
                    .setValue(LEFT, isTableAtEast)
                    .setValue(RIGHT, isTableAtWest);
        } else {
            var north = pos.north();
            var south = pos.south();
            var isTableAtNorth = isTableBlock(level, north);
            var isTableAtSouth = isTableBlock(level, south);

            state = state.setValue(LEFT, isTableAtNorth)
                    .setValue(RIGHT, isTableAtSouth);

            if (isTableAtNorth || isTableAtSouth) {
                state = state.setValue(AXIS, Direction.Axis.Z);
            }
        }

        level.setBlock(pos, state, Block.UPDATE_ALL);
    }

    private boolean isTableBlock(Level level, BlockPos pos) {
        if (!level.isLoaded(pos)) {
            return false;
        }

        return level.getBlockState(pos).getBlock() == this;
    }

    @Override
    public BaseBlockProperty getProperty() {
        return property;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        // Todo: voxel shape for long table.
        return super.getShape(pState, pLevel, pPos, pContext);
    }
}
