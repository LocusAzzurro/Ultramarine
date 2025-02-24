package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.registry.BlockEntityRegistry;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.world.block.entity.BlockEntityHelper;
import com.voxelutopia.ultramarine.world.block.entity.CenserBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Censer extends DecorativeBlock implements EntityBlock {

    private final Vec3 smokeOffset;
    public Censer(Builder builder, Vec3 smokeOffset) {
        super(builder);
        this.smokeOffset = smokeOffset;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack item = pPlayer.getItemInHand(pHand);
        if (item.is(ItemRegistry.INCENSE.get())){
            if (!pPlayer.getAbilities().instabuild) {
                item.shrink(1);
            }
            pLevel.getBlockEntity(pPos, BlockEntityRegistry.CENSER.get()).ifPresent(entity -> entity.lightIncense(pLevel, pPos, pState));
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
        return InteractionResult.PASS;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CenserBlockEntity(pPos, pState);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
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

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return pLevel.isClientSide ? null : BlockEntityHelper.createTickerHelper(pBlockEntityType, (BlockEntityType<? extends CenserBlockEntity>) BlockEntityRegistry.CENSER.get(), CenserBlockEntity::tick);
    }

    @Override
    public @NotNull BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState state = super.getStateForPlacement(pContext);
        return isLuminous() ? state.setValue(LIT, false) : state;
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        if (isLuminous()) return state.getValue(LIT) ? 4 : 0;
        else return 0;
    }
}
