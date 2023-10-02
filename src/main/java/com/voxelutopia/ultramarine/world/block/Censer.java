package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.world.block.entity.CenserBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class Censer extends DecorativeBlock {

    private final Vector3d smokeOffset;

    public Censer(Builder builder, Vector3d smokeOffset) {
        super(builder);
        this.smokeOffset = smokeOffset;
    }

    @Override
    public ActionResultType use(BlockState pState, World pLevel, BlockPos pPos, PlayerEntity pPlayer, Hand pHand, BlockRayTraceResult pHit) {
        ItemStack item = pPlayer.getItemInHand(pHand);
        if (item.getItem().equals(ItemRegistry.INCENSE.get())) {
            if (!pPlayer.abilities.instabuild) {
                item.shrink(1);
            }
            TileEntity e = pLevel.getBlockEntity(pPos);
            if (e instanceof CenserBlockEntity) {
                ((CenserBlockEntity) e).lightIncense(pLevel, pPos, pState);
            }
            return ActionResultType.sidedSuccess(pLevel.isClientSide);
        }
        return ActionResultType.PASS;
    }


    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new CenserBlockEntity();
    }

    @Override
    public void animateTick(BlockState pState, World pLevel, BlockPos pPos, Random pRandom) {
        super.animateTick(pState, pLevel, pPos, pRandom);
        if (!pState.hasProperty(LIT) || !pState.getValue(LIT)) return;
        if (pLevel.getGameTime() % (3 - pRandom.nextInt(1)) == 0) {
            for (int i = 0; i < 5; i++) {
                pLevel.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                        pPos.getX() + smokeOffset.x + pRandom.nextFloat() * 0.4f - 0.2,
                        pPos.getY() + smokeOffset.y + pRandom.nextFloat() * 0.1f,
                        pPos.getZ() + smokeOffset.z + pRandom.nextFloat() * 0.4f - 0.2,
                        0.0D, pRandom.nextDouble() * 0.01d, 0.0D);
            }
        }
    }

    //@Nullable
    //@Override
    //public <T extends TileEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, TileEntityType<T> pBlockEntityType) {
    //    return pLevel.isClientSide ? null : BlockEntityHelper.createTickerHelper(pBlockEntityType, (TileEntityType<? extends CenserBlockEntity>) BlockEntityRegistry.CENSER.get(), CenserBlockEntity::tick);
    //}

    // Defined in TileEntity

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        BlockState state = super.getStateForPlacement(pContext);
        return isLuminous() ? state.setValue(LIT, false) : state;
    }

    @Override
    public int getLightValue(BlockState state, IBlockReader level, BlockPos pos) {
        if (isLuminous()) return state.getValue(LIT) ? 4 : 0;
        else return 0;
    }
}
