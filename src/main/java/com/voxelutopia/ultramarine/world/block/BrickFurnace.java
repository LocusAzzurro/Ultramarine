package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.registry.BlockEntityRegistry;
import com.voxelutopia.ultramarine.world.block.entity.BlockEntityHelper;
import com.voxelutopia.ultramarine.world.block.entity.BrickFurnaceBlockEntity;
import com.voxelutopia.ultramarine.world.block.entity.CenserBlockEntity;
import com.voxelutopia.ultramarine.world.block.menu.BrickFurnaceMenu;
import com.voxelutopia.ultramarine.world.block.menu.WoodworkingWorkbenchMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class BrickFurnace extends Block implements EntityBlock, BaseBlockPropertyHolder {

    public BrickFurnace() {
        super(BaseBlockProperty.STONE.properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new BrickFurnaceBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return pLevel.isClientSide ? null :
                BlockEntityHelper.createTickerHelper(pBlockEntityType, (BlockEntityType<? extends BrickFurnaceBlockEntity>) BlockEntityRegistry.BRICK_FURNACE.get(), BrickFurnaceBlockEntity::serverTick);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof BrickFurnaceBlockEntity furnaceBlockEntity) {
                NetworkHooks.openGui((ServerPlayer) pPlayer, furnaceBlockEntity, pPos);
                return InteractionResult.CONSUME;
            }
        }
        return InteractionResult.PASS;
    }


    @Override
    public BaseBlockProperty getProperty() {
        return BaseBlockProperty.STONE;
    }
}
