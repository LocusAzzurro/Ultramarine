package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.shape.BlockShapes;
import com.voxelutopia.ultramarine.world.block.menu.ChiselTableMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;

public class ChiselTableMedium extends DecorativeBlock implements BaseBlockPropertyHolder {

    private static final Component CONTAINER_TITLE = Component.translatable("container.chisel_table");

    public ChiselTableMedium() {
        super(DecorativeBlock.with(BaseBlockProperty.PAPER).shaped(BlockShapes.S16_H4).directional().noCollision().noOcclusion());
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            NetworkHooks.openScreen((ServerPlayer) pPlayer, this.getMenuProvider(pState, pLevel, pPos), pPos);
            return InteractionResult.CONSUME;
        }
    }

    public MenuProvider getMenuProvider(BlockState pState, Level pLevel, BlockPos pPos) {
        return new SimpleMenuProvider((containerId, inventory, player) ->
                new ChiselTableMenu(containerId, inventory, ContainerLevelAccess.create(pLevel, pPos)), CONTAINER_TITLE);
    }

    @Override
    public BaseBlockProperty getProperty() {
        return BaseBlockProperty.WOOD;
    }
}
