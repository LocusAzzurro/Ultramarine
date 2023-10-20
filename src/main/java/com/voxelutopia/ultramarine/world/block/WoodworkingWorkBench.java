package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.world.block.menu.WoodworkingWorkbenchMenu;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class WoodworkingWorkBench extends Block {

    private static final ITextComponent CONTAINER_TITLE = new TranslationTextComponent("container.woodworking_workbench");
    public static final DirectionProperty FACING = HorizontalBlock.FACING;

    public WoodworkingWorkBench() {
        super(BaseBlockProperty.WOOD.properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public ActionResultType use(BlockState pState, World pLevel, BlockPos pPos, PlayerEntity pPlayer, Hand pHand, BlockRayTraceResult pHit) {
        if (pLevel.isClientSide) {
            return ActionResultType.SUCCESS;
        } else {
            pPlayer.openMenu(pState.getMenuProvider(pLevel, pPos));
            return ActionResultType.CONSUME;
        }
    }

    @Nullable
    @Override
    public INamedContainerProvider getMenuProvider(BlockState pState, World pLevel, BlockPos pPos) {
        return new SimpleNamedContainerProvider((id, inventory, player)
                -> new WoodworkingWorkbenchMenu(id, inventory, IWorldPosCallable.create(pLevel, pPos)), CONTAINER_TITLE);
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState pState) {
        return true;
    }

    @Override
    public BlockRenderType getRenderShape(BlockState pState) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }
}
