package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import com.voxelutopia.ultramarine.world.block.state.StackableBlockType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class StackableHalfBlock extends BaseBlock{

    public static final EnumProperty<StackableBlockType> TYPE = ModBlockStateProperties.STACKABLE_BLOCK_TYPE;
    protected static final VoxelShape HALF = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);

    public StackableHalfBlock(BaseBlockProperty property){
        super(property);
        this.registerDefaultState(this.defaultBlockState().setValue(TYPE, StackableBlockType.SINGLE));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(TYPE);
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        StackableBlockType type = pState.getValue(TYPE);
        return switch (type) {
            case DOUBLE -> Shapes.block();
            case SINGLE -> HALF;
        };
    }

    public boolean useShapeForLightOcclusion(BlockState pState) {
        return false;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockPos blockpos = pContext.getClickedPos();
        BlockState blockstate = pContext.getLevel().getBlockState(blockpos);
        if (blockstate.is(this)) {
            return blockstate.setValue(TYPE, StackableBlockType.DOUBLE);
        }
        else return defaultBlockState().setValue(TYPE, StackableBlockType.SINGLE);
    }

    public boolean canBeReplaced(BlockState pState, BlockPlaceContext pUseContext) {
        ItemStack itemstack = pUseContext.getItemInHand();
        StackableBlockType type = pState.getValue(TYPE);
        return (type != StackableBlockType.DOUBLE && itemstack.is(this.asItem()));
    }






}
