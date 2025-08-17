package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.data.shape.RawVoxelShape;
import com.voxelutopia.ultramarine.data.shape.ShapeFunction;
import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class HangingLantern extends DecorativeBlock {

    public static final IntegerProperty LANTERNS = ModBlockStateProperties.LANTERNS;
    private static final RawVoxelShape POLE_NORTH_RAW = new RawVoxelShape(7, -16, 1, 9, 32, 3);
    private static final RawVoxelShape POLE_HANGING_X_RAW = new RawVoxelShape(0, 28, 7, 16, 30, 9);
    private static final VoxelShape HANGING_INTERACTION = Block.box(4, -8, 4, 12, 24, 12);
    private static final VoxelShape POLE_NORTH = POLE_NORTH_RAW.copy().toVoxelShape();
    private static final VoxelShape POLE_WEST = POLE_NORTH_RAW.copy().rotateY(90).toVoxelShape();
    private static final VoxelShape POLE_SOUTH = POLE_NORTH_RAW.copy().rotateY(180).toVoxelShape();
    private static final VoxelShape POLE_EAST = POLE_NORTH_RAW.copy().rotateY(270).toVoxelShape();
    private static final VoxelShape POLE_HANGING_X = POLE_HANGING_X_RAW.copy().toVoxelShape();
    private static final VoxelShape POLE_HANGING_Z = POLE_HANGING_X_RAW.copy().rotateY(90).toVoxelShape();
    private static final VoxelShape HANGING_INTERACTION_X = Shapes.or(HANGING_INTERACTION, POLE_HANGING_X);
    private static final VoxelShape HANGING_INTERACTION_Z = Shapes.or(HANGING_INTERACTION, POLE_HANGING_Z);
    public static final ShapeFunction POLE_ONLY = ShapeFunction.cardinalRotations(new RawVoxelShape(7, 0, 1, 9, 32, 3));

    private final HangingLanternType type;

    public HangingLantern(HangingLanternType type) {
        super(DecorativeBlock.with(BaseBlockProperty.WOOD).directional().luminous());
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(LANTERNS, 1));
        this.type = type;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch (this.type){
            case POLE -> {
                return switch (pState.getValue(FACING)){
                    case DOWN, UP, NORTH -> POLE_NORTH;
                    case SOUTH -> POLE_SOUTH;
                    case WEST -> POLE_WEST;
                    case EAST -> POLE_EAST;
                };
            }
            case HANGING -> {
                return switch (pState.getValue(FACING)){
                    case DOWN, UP, NORTH, SOUTH -> POLE_HANGING_X;
                    case EAST, WEST -> POLE_HANGING_Z;
                };
            }
        }
        return Shapes.empty();
    }

    @Override
    public VoxelShape getInteractionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        switch (this.type){
            case POLE -> getShape(pState, pLevel, pPos, CollisionContext.empty());
            case HANGING -> {
                return switch (pState.getValue(FACING)){
                    case DOWN, UP, NORTH, SOUTH -> HANGING_INTERACTION_X;
                    case EAST, WEST -> HANGING_INTERACTION_Z;
                };
            }
        }
        return super.getInteractionShape(pState, pLevel, pPos);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        int lanterns = pState.getValue(LANTERNS);
        if (stack.is(ItemRegistry.SMALL_RED_LANTERN.get()) && lanterns < 3){
            pLevel.setBlock(pPos, pState.setValue(LANTERNS, lanterns + 1), Block.UPDATE_ALL);
            if (!pPlayer.isCreative()) stack.shrink(1);
            return ItemInteractionResult.sidedSuccess(pLevel.isClientSide());
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    public @NotNull BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState state = super.getStateForPlacement(pContext);
        return state.setValue(LIT, true).setValue(LANTERNS, 1);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(LANTERNS);
    }

    public enum HangingLanternType{
        POLE, HANGING;

    }

}
