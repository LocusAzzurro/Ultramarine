package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.util.RawVoxelShape;
import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class HangingLantern extends DecorativeBlock {

    public static final IntegerProperty LANTERNS = ModBlockStateProperties.LANTERNS;
    private static final RawVoxelShape POLE_NORTH_RAW = new RawVoxelShape(7, -16, 1, 9, 32, 3);
    private static final VoxelShape POLE_NORTH = POLE_NORTH_RAW.copy().toVoxelShape();
    private static final VoxelShape POLE_WEST = POLE_NORTH_RAW.copy().rotateY(90).toVoxelShape();
    private static final VoxelShape POLE_SOUTH = POLE_NORTH_RAW.copy().rotateY(180).toVoxelShape();
    private static final VoxelShape POLE_EAST = POLE_NORTH_RAW.copy().rotateY(270).toVoxelShape();

    public HangingLantern() {
        super(DecorativeBlock.with(BaseBlockProperty.WOOD).directional().luminous());
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(LANTERNS, 1));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)){
            case DOWN, UP, NORTH -> POLE_NORTH;
            case SOUTH -> POLE_SOUTH;
            case WEST -> POLE_WEST;
            case EAST -> POLE_EAST;
        };
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack item = pPlayer.getItemInHand(pHand);
        int lanterns = pState.getValue(LANTERNS);
        if (item.is(ItemRegistry.SMALL_RED_LANTERN.get()) && lanterns < 3){
            pLevel.setBlock(pPos, pState.setValue(LANTERNS, lanterns + 1), Block.UPDATE_ALL);
            if (!pPlayer.isCreative()) item.shrink(1);
            return InteractionResult.sidedSuccess(pLevel.isClientSide());
        }
        return InteractionResult.PASS;
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
}
