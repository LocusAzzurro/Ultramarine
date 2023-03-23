package com.voxelutopia.ultramarine.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class DecorativeBlock extends HorizontalDirectionalBlock implements BaseBlockPropertyHolder, DiagonallyPlaceable{

    public static final VoxelShape CUBE_14 = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    public static final VoxelShape FLAT_MEDIUM = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 2.0D, 14.0D);

    private final BaseBlockProperty property;
    private final VoxelShape shape;
    private final boolean diagonallyPlaceable;
    private final boolean directional;
    private final boolean noCollision;
    protected StateDefinition<Block, BlockState> stateDefinition;

    public DecorativeBlock(BaseBlockProperty property, VoxelShape shape, boolean directional, boolean diagonallyPlaceable, boolean noCollision) {
        super(property.properties);
        this.property = property;
        this.shape = shape;
        this.directional = directional;
        this.diagonallyPlaceable = diagonallyPlaceable;
        this.noCollision = noCollision;

        var stateDefinationBuilder = new StateDefinition.Builder<Block, BlockState>(this);
        createBlockStateDefinition(stateDefinationBuilder);
        stateDefinition = stateDefinationBuilder.create(Block::defaultBlockState, BlockState::new);
        BlockState state = this.getStateDefinition().any();
        if (isDiagonallyPlaceable()) state = state.setValue(DIAGONAL, false);
        if (isDirectional()) state = state.setValue(FACING, Direction.NORTH);
        this.registerDefaultState(state);
    }

    public DecorativeBlock(BaseBlockProperty property, VoxelShape shape, boolean directional, boolean diagonallyPlaceable){
        this(property, shape, directional, diagonallyPlaceable, false);
    }

    @Override
    public @NotNull StateDefinition<Block, BlockState> getStateDefinition() {
        return stateDefinition;
    }

    //TODO remake angle check for placement around 45 degrees
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState state = setDiagonalStateForPlacement(this.defaultBlockState(), pContext);
        return !isDirectional() ? state : state.setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        defineDiagonalProperty(pBuilder);
        if (isDirectional()) pBuilder.add(FACING);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return shape;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return noCollision ? Shapes.empty() : shape;
    }

    @Override
    public BaseBlockProperty getProperty() {
        return property;
    }

    @Override
    public boolean isDiagonallyPlaceable() {
        return diagonallyPlaceable;
    }

    public boolean isDirectional(){
        return directional;
    }
}
