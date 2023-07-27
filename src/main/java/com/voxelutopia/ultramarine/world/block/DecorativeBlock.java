package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Optional;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
@SuppressWarnings("deprecation")
public class DecorativeBlock extends HorizontalDirectionalBlock implements BaseBlockPropertyHolder, DiagonallyPlaceable {

    public static final VoxelShape FULL_BLOCK = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    public static final VoxelShape FULL_14 = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    public static final VoxelShape FULL_12 = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    public static final VoxelShape FULL_10 = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
    public static final VoxelShape FULL_8 = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
    public static final VoxelShape FULL_6 = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
    public static final VoxelShape FULL_4 = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);

    public static final VoxelShape HALF_BLOCK = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    public static final VoxelShape HALF_12 = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    public static final VoxelShape HALF_6 = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 8.0D, 11.0D);
    public static final VoxelShape QUARTER_16 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D);
    public static final VoxelShape QUARTER_12 = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 4.0D, 13.0D);
    public static final VoxelShape FLAT_16 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
    public static final VoxelShape DOUBLE_FLAT_14 = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 2.0D, 14.0D);

    public static final VoxelShape VASE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 14.0D, 13.0D);

    public static final DirectionProperty HORIZONTAL_FACING_SHIFT = ModBlockStateProperties.HORIZONTAL_FACING_SHIFT;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    private final BaseBlockProperty property;
    private final ShapeFunction shape;
    private final boolean diagonallyPlaceable;
    private final boolean directional;
    private final boolean noCollision;
    private final boolean luminous;
    private final boolean noFenceConnect;
    private final @Nullable Direction offsetDirection;
    protected StateDefinition<Block, BlockState> stateDefinition;

    public DecorativeBlock(BaseBlockProperty property, ShapeFunction shape,
                           boolean directional, boolean diagonallyPlaceable,
                           boolean luminous, boolean noCollision, boolean noFenceConnect,
                           @Nullable Direction offset) {
        super(property.properties);
        this.property = property;
        this.shape = shape;
        this.directional = directional;
        this.diagonallyPlaceable = diagonallyPlaceable;
        this.luminous = luminous;
        this.noCollision = noCollision;
        this.noFenceConnect = noFenceConnect;
        this.offsetDirection = offset;

        var stateDefinationBuilder = new StateDefinition.Builder<Block, BlockState>(this);
        createBlockStateDefinition(stateDefinationBuilder);
        stateDefinition = stateDefinationBuilder.create(Block::defaultBlockState, BlockState::new);
        BlockState state = this.getStateDefinition().any();
        if (isDiagonallyPlaceable()) state = state.setValue(DIAGONAL, false);
        if (isDirectional()) state = state.setValue(FACING, Direction.NORTH);
        if (isDiagonallyPlaceable() && isDirectional())
            state = state.setValue(HORIZONTAL_FACING_SHIFT, Direction.NORTH);
        if (isLuminous()) state = state.setValue(LIT, true);
        this.registerDefaultState(state);
    }

    public DecorativeBlock(Builder builder) {
        this(builder.property, builder.shape, builder.directional, builder.diagonallyPlaceable,
                builder.luminous, builder.noCollision, builder.noFenceConnect, builder.offset);
    }

    public static Builder with(BaseBlockProperty property) {
        return new Builder(property);
    }

    @Override
    public StateDefinition<Block, BlockState> getStateDefinition() {
        return stateDefinition;
    }

    @NotNull
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState state = setDiagonalStateForPlacement(this.defaultBlockState(), pContext);
        if (isDirectional() && isDiagonallyPlaceable()) {
            var directions = getMainAndShiftedDirections(pContext);
            state = state.setValue(FACING, directions.getLeft()).setValue(HORIZONTAL_FACING_SHIFT, directions.getRight())
                    .setValue(DIAGONAL, getDiagonalState(pContext));
        } else if (isDirectional() && !isDiagonallyPlaceable()) {
            state = state.setValue(FACING, pContext.getHorizontalDirection());
        } else if (!isDirectional() && isDiagonallyPlaceable()) {
            state = state.setValue(DIAGONAL, getDiagonalState(pContext));
        }
        if (isLuminous()) {
            state = state.setValue(LIT, true);
        }
        return state;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        if (isDirectional()) pBuilder.add(FACING);
        if (isDiagonallyPlaceable()) pBuilder.add(DIAGONAL);
        if (isDirectional() && isDiagonallyPlaceable()) pBuilder.add(HORIZONTAL_FACING_SHIFT);
        if (isLuminous()) pBuilder.add(LIT);
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        if (offsetDirection != null) {
            switch (offsetDirection) {
                case DOWN -> {
                    if (!pLevel.getBlockState(pPos.above()).isAir() && pLevel.getBlockState(pPos.below()).isAir()) {
                        pLevel.removeBlock(pPos, pIsMoving);
                        pLevel.setBlock(pPos.below(), pState, Block.UPDATE_ALL);
                    }
                }
                case UP -> {
                    if (!pLevel.getBlockState(pPos.below()).isAir() && pLevel.getBlockState(pPos.above()).isAir()) {
                        pLevel.removeBlock(pPos, pIsMoving);
                        pLevel.setBlock(pPos.above(), pState, Block.UPDATE_ALL);
                    }
                }
            }
        }
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return shape.getShape(pState, pLevel, pPos, pContext);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return noCollision ? Shapes.empty() : getShape(pState, pLevel, pPos, pContext);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        if (isLuminous()) return state.getValue(LIT) ? 14 : 0;
        else return 0;
    }

    @Override
    public BaseBlockProperty getProperty() {
        return property;
    }

    @Override
    public boolean isDiagonallyPlaceable() {
        return diagonallyPlaceable;
    }

    public boolean isLuminous() {
        return luminous;
    }

    public boolean isDirectional() {
        return directional;
    }

    public static abstract class AbstractBuilder<T extends AbstractBuilder<T>> {
        public abstract T self();
    }

    public static class Builder extends AbstractBuilder<Builder> {

        private final BaseBlockProperty property;
        private ShapeFunction shape = simpleShape(FULL_14);
        private boolean diagonallyPlaceable;
        private boolean directional;
        private boolean luminous;
        private boolean noCollision;
        private boolean noFenceConnect;
        private Direction offset = null;

        public Builder(BaseBlockProperty property) {
            this.property = property.copy();
        }

        public Builder shaped(VoxelShape shape) {
            return shaped(simpleShape(shape));
        }

        public Builder shaped(ShapeFunction shape) {
            this.shape = shape;
            return this;
        }

        public Builder diagonallyPlaceable() {
            this.diagonallyPlaceable = true;
            return this;
        }

        public Builder directional() {
            this.directional = true;
            return this;
        }

        public Builder luminous() {
            this.luminous = true;
            return this;
        }

        public Builder noCollision() {
            this.noCollision = true;
            return this;
        }

        public Builder noOcclusion() {
            this.property.properties = this.property.properties.noOcclusion();
            return this;
        }

        public Builder noFenceConnect() {
            noFenceConnect = true;
            return this;
        }

        public Builder placeOffset(Direction direction){
            offset = direction;
            return this;
        }

        public DecorativeBlock build() {
            return new DecorativeBlock(this);
        }

        @Override
        public Builder self() {
            return this;
        }
    }

    @FunctionalInterface
    public interface ShapeFunction{

        VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext);
    }

    protected static ShapeFunction simpleShape(VoxelShape shape){
        return ($1, $2, $3, $4) -> shape;
    }

    @Override
    public VoxelShape getBlockSupportShape(BlockState pState, BlockGetter pReader, BlockPos pPos) {
        return noFenceConnect ? FULL_14 : super.getBlockSupportShape(pState, pReader, pPos);
    }

    @Override
    public float getShadeBrightness(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return 1.0f;
    }
}
