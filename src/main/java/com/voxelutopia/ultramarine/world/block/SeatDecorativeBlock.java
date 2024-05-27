package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.world.entity.SeatEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class SeatDecorativeBlock extends DecorativeBlock{

    private final Vec3 seatOffset;

    public SeatDecorativeBlock(Builder builder) {
        super(builder);
        this.seatOffset = builder.seatOffset;
    }

    public static Builder with(BaseBlockProperty property){
        return new Builder(property);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pState.is(this) && pLevel.getEntitiesOfClass(SeatEntity.class, new AABB(pPos)).isEmpty()){
            boolean ridingSuccess = false;
            if (!pLevel.isClientSide()){
                SeatEntity seat = new SeatEntity(pLevel, Vec3.atCenterOf(pPos).add(seatOffset));
                pLevel.addFreshEntity(seat);
                ridingSuccess = pPlayer.startRiding(seat);
            }
            return ridingSuccess ? InteractionResult.sidedSuccess(pLevel.isClientSide()) : InteractionResult.PASS;
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @SuppressWarnings("unused")
    public static class Builder extends DecorativeBlock.Builder{

        private Vec3 seatOffset = new Vec3(0.0, 0.5, 0.0);

        public Builder(BaseBlockProperty property) {
            super(property);
        }

        public Builder seatOffset(Vec3 offset){
            this.seatOffset = offset;
            return this;
        }

        public SeatDecorativeBlock build(){
            return new SeatDecorativeBlock(this);
        }
    }
}
