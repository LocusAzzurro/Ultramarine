package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.ModBlockStateProperties;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
@SuppressWarnings("deprecation")
public class DecorativeBlock extends HorizontalDirectionalBlock implements BaseBlockPropertyHolder, DiagonallyPlaceable{

    public static final VoxelShape FULL_BLOCK = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    public static final VoxelShape CUBE_14 = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    public static final VoxelShape FLAT_MEDIUM = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 2.0D, 14.0D);
    public static final VoxelShape LAMP = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);

    public static final DirectionProperty HORIZONTAL_FACING_SHIFT = ModBlockStateProperties.HORIZONTAL_FACING_SHIFT;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    private final BaseBlockProperty property;
    private final VoxelShape shape;
    private final boolean diagonallyPlaceable;
    private final boolean directional;
    private final boolean noCollision;
    private final boolean luminous;
    protected StateDefinition<Block, BlockState> stateDefinition;

    public DecorativeBlock(BaseBlockProperty property, VoxelShape shape, boolean directional, boolean diagonallyPlaceable, boolean luminous, boolean noCollision) {
        super(property.properties);
        this.property = property;
        this.shape = shape;
        this.directional = directional;
        this.diagonallyPlaceable = diagonallyPlaceable;
        this.luminous = luminous;
        this.noCollision = noCollision;

        var stateDefinationBuilder = new StateDefinition.Builder<Block, BlockState>(this);
        createBlockStateDefinition(stateDefinationBuilder);
        stateDefinition = stateDefinationBuilder.create(Block::defaultBlockState, BlockState::new);
        BlockState state = this.getStateDefinition().any();
        if (isDiagonallyPlaceable()) state = state.setValue(DIAGONAL, false);
        if (isDirectional()) state = state.setValue(FACING, Direction.NORTH);
        if (isDiagonallyPlaceable() && isDirectional()) state = state.setValue(HORIZONTAL_FACING_SHIFT, Direction.NORTH);
        if (isLuminous()) state = state.setValue(LIT, true);
        this.registerDefaultState(state);
    }

    public DecorativeBlock(BaseBlockProperty property, VoxelShape shape, boolean directional, boolean diagonallyPlaceable){
        this(property, shape, directional, diagonallyPlaceable,false, false);
    }

    public DecorativeBlock(Builder builder){
        this(builder.property, builder.shape, builder.directional, builder.diagonallyPlaceable, builder.luminous, builder.noCollision);
    }

    public static Builder with(BaseBlockProperty property){
        return new Builder(property);
    }

    @Override
    public @NotNull StateDefinition<Block, BlockState> getStateDefinition() {
        return stateDefinition;
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState state = setDiagonalStateForPlacement(this.defaultBlockState(), pContext);
        if (isDirectional() && isDiagonallyPlaceable()){
            var directions = getMainAndShiftedDirections(pContext);
            state = state.setValue(FACING, directions.getLeft()).setValue(HORIZONTAL_FACING_SHIFT, directions.getRight())
                    .setValue(DIAGONAL, getDiagonalState(pContext));
        }
        else if (isDirectional() && !isDiagonallyPlaceable()){
            state = state.setValue(FACING, pContext.getHorizontalDirection());
        }
        else if (!isDirectional() && isDiagonallyPlaceable()){
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
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return shape;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return noCollision ? Shapes.empty() : shape;
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

    public boolean isLuminous(){
        return luminous;
    }

    public boolean isDirectional(){
        return directional;
    }

    public static abstract class AbstractBuilder<T extends AbstractBuilder<T>>{
        public abstract T self();
    }
    public static class Builder extends AbstractBuilder<Builder>{

        private BaseBlockProperty property;
        private VoxelShape shape = CUBE_14;
        private boolean diagonallyPlaceable;
        private boolean directional;
        private boolean luminous;
        private boolean noCollision;

        public Builder(BaseBlockProperty property){
            this.property = property;
        }

        public Builder shaped(VoxelShape shape){
            this.shape = shape;
            return this;
        }

        public Builder diagonallyPlaceable(){
            this.diagonallyPlaceable = true;
            return this;
        }

        public Builder directional(){
            this.directional = true;
            return this;
        }

        public Builder luminous(){
            this.luminous = true;
            return this;
        }

        public Builder noCollision(){
            this.noCollision = true;
            return this;
        }

        public Builder noOcclusion(){
            this.property.properties = this.property.properties.noOcclusion();
            return this;
        }

        public DecorativeBlock build(){
            return new DecorativeBlock(this);
        }

        @Override
        public Builder self() {
            return this;
        }
    }


}
