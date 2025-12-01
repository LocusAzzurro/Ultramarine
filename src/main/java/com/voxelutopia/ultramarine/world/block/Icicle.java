package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.shape.RawVoxelShape;
import com.voxelutopia.ultramarine.data.shape.ShapeFunction;
import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class Icicle extends WallSideBlock{

    public static final IntegerProperty VARIANT = ModBlockStateProperties.VARIANT;
    private final int numVariants;
    private final ShapeFunction shapeFunction;

    public Icicle(int numVariants, ShapeFunction shapeFunction) {
        super(BaseBlockProperty.ice());
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(VARIANT, 0));
        this.numVariants = numVariants;
        this.shapeFunction = shapeFunction;
    }

    public Icicle(int numVariants){
        this(numVariants, ShapeFunction.cardinalRotations(new RawVoxelShape(0,0,15,16,16,16)));
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        int variant = pLevel.random.nextInt(3);
        BlockState newState = pState.setValue(VARIANT, variant);
        pLevel.setBlockAndUpdate(pPos, newState);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return shapeFunction.apply(pState);
    }

    public int getNumVariants() {
        return numVariants;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState state = super.getStateForPlacement(pContext);
        if (state == null) return null;
        return state.setValue(VARIANT, 0);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(VARIANT);
    }

}
