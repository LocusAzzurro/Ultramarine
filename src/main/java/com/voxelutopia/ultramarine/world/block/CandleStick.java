package com.voxelutopia.ultramarine.world.block;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.Random;

public class CandleStick extends DecorativeBlock {

    private final Vector3d flameOffset;

    public CandleStick(Builder builder, Vector3d flameOffset) {
        super(builder);
        this.flameOffset = flameOffset;
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext pContext) {
        BlockState state = super.getStateForPlacement(pContext);
        return isLuminous() ? state.setValue(LIT, false) : state;
    }

    @Override
    public ActionResultType use(BlockState pState, World pLevel, BlockPos pPos, PlayerEntity pPlayer, Hand pHand, BlockRayTraceResult pHit) {
        ItemStack item = pPlayer.getItemInHand(pHand);
        if (item.getItem().equals(Items.FLINT_AND_STEEL) && pState.hasProperty(LIT) && !pState.getValue(LIT)) {
            item.hurtAndBreak(1, pPlayer, p -> p.broadcastBreakEvent(pHand));
            pLevel.setBlock(pPos, pState.setValue(LIT, true), 3);
            return ActionResultType.sidedSuccess(pLevel.isClientSide);
        }
        return ActionResultType.PASS;
    }

    @Override
    public void animateTick(BlockState pState, World pLevel, BlockPos pPos, Random pRandom) {
        super.animateTick(pState, pLevel, pPos, pRandom);
        if (!pState.hasProperty(LIT) || !pState.getValue(LIT)) return;
        if (pLevel.getGameTime() % (2 - pRandom.nextInt(1)) == 0) {
            pLevel.addParticle(ParticleTypes.FLAME,
                    pPos.getX() + flameOffset.x,
                    pPos.getY() + flameOffset.y,
                    pPos.getZ() + flameOffset.z,
                    0.0D, pRandom.nextDouble() * 0.01d, 0.0D);
        }
    }
}
