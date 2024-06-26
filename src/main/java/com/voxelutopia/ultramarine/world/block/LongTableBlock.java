package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LongTableBlock extends Block implements BaseBlockPropertyHolder {

    protected final BaseBlockProperty property;

    public LongTableBlock(BaseBlockProperty property) {
        super(property.properties);
        this.property = property;

        registerDefaultState(getStateDefinition().any()
                .setValue(ModBlockStateProperties.NORTH_TO_SOUTH, false)
                .setValue(ModBlockStateProperties.LEFT, false)
                .setValue(ModBlockStateProperties.RIGHT, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(ModBlockStateProperties.NORTH_TO_SOUTH);
        pBuilder.add(ModBlockStateProperties.LEFT);
        pBuilder.add(ModBlockStateProperties.RIGHT);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return defaultBlockState()
                .setValue(ModBlockStateProperties.NORTH_TO_SOUTH, false)
                .setValue(ModBlockStateProperties.LEFT, false)
                .setValue(ModBlockStateProperties.RIGHT, false);
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

        var north = pos.north();
        var south = pos.south();
        var isTableAtNorth = isTableBlock(level, north);
        var isTableAtSouth = isTableBlock(level, south);

        if (isTableAtNorth || isTableAtSouth) {
            state = state.setValue(ModBlockStateProperties.NORTH_TO_SOUTH, true);

            state = state.setValue(ModBlockStateProperties.LEFT, isTableAtNorth);
            state = state.setValue(ModBlockStateProperties.RIGHT, isTableAtSouth);
        } else {
            state = state.setValue(ModBlockStateProperties.NORTH_TO_SOUTH, false);

            var east = pos.north();
            var west = pos.south();
            var isTableAtEast = isTableBlock(level, east);
            var isTableAtWest = isTableBlock(level, west);

            if (isTableAtEast || isTableAtWest) {
                state = state.setValue(ModBlockStateProperties.LEFT, isTableAtEast);
                state = state.setValue(ModBlockStateProperties.RIGHT, isTableAtWest);
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
}
