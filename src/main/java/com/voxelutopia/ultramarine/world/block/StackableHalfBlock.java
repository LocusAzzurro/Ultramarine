package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import com.voxelutopia.ultramarine.world.block.state.StackableBlockType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class StackableHalfBlock extends BaseBlock {

    public static final EnumProperty<StackableBlockType> TYPE = ModBlockStateProperties.STACKABLE_BLOCK_TYPE;
    protected static final VoxelShape HALF = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);

    public StackableHalfBlock(BaseBlockProperty property) {
        super(property);
        this.registerDefaultState(this.defaultBlockState().setValue(TYPE, StackableBlockType.SINGLE));
    }

    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(TYPE);
    }

    public VoxelShape getShape(BlockState pState, IBlockReader pLevel, BlockPos pPos, ISelectionContext pContext) {
        StackableBlockType type = pState.getValue(TYPE);
        switch (type) {
            case DOUBLE:
                return VoxelShapes.block();
            case SINGLE:
                return HALF;
        }
        ;
        return VoxelShapes.block();
    }

    public boolean useShapeForLightOcclusion(BlockState pState) {
        return false;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        BlockPos blockpos = pContext.getClickedPos();
        BlockState blockstate = pContext.getLevel().getBlockState(blockpos);
        if (blockstate.is(this)) {
            return blockstate.setValue(TYPE, StackableBlockType.DOUBLE);
        } else return defaultBlockState().setValue(TYPE, StackableBlockType.SINGLE);
    }

    public boolean canBeReplaced(BlockState pState, BlockItemUseContext pUseContext) {
        ItemStack itemstack = pUseContext.getItemInHand();
        StackableBlockType type = pState.getValue(TYPE);
        return (type != StackableBlockType.DOUBLE && itemstack.getItem().equals(this.asItem()));
    }


}
