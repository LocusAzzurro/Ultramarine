package com.voxelutopia.ultramarine.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class CandleStick extends DecorativeBlock{

    private final Vec3 flameOffset;
    public CandleStick(Builder builder, Vec3 flameOffset) {
        super(builder);
        this.flameOffset = flameOffset;
    }

    @Override
    public @NotNull BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState state = super.getStateForPlacement(pContext);
        return isLuminous() ? state.setValue(LIT, false) : state;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack item = pPlayer.getItemInHand(pHand);
        if (item.is(Items.FLINT_AND_STEEL) && pState.hasProperty(LIT) && !pState.getValue(LIT)){
            item.hurtAndBreak(1, pPlayer, p -> p.broadcastBreakEvent(pHand));
            pLevel.setBlock(pPos, pState.setValue(LIT, true), Block.UPDATE_ALL);
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
        return InteractionResult.PASS;
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
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
