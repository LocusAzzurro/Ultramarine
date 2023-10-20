package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.world.entity.SeatEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class SeatDecorativeBlock extends DecorativeBlock {

    private final Vector3d seatOffset;

    public SeatDecorativeBlock(Builder builder) {
        super(builder);
        this.seatOffset = builder.seatOffset;
    }

    public static Builder with(BaseBlockProperty property) {
        return new Builder(property);
    }

    @Override
    public ActionResultType use(BlockState pState, World pLevel, BlockPos pPos, PlayerEntity pPlayer, Hand pHand, BlockRayTraceResult pHit) {
        if (pState.is(this) && pLevel.getEntitiesOfClass(SeatEntity.class, new AxisAlignedBB(pPos)).isEmpty()) {
            SeatEntity seat = new SeatEntity(pLevel, Vector3d.atCenterOf(pPos).add(seatOffset));
            pLevel.addFreshEntity(seat);
            return pPlayer.startRiding(seat) ? ActionResultType.sidedSuccess(pLevel.isClientSide()) : ActionResultType.PASS;
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @SuppressWarnings("unused")
    public static class Builder extends DecorativeBlock.Builder {

        private Vector3d seatOffset = new Vector3d(0.0, 0.5, 0.0);

        public Builder(BaseBlockProperty property) {
            super(property);
        }

        public Builder seatOffset(Vector3d offset) {
            this.seatOffset = offset;
            return this;
        }

        public SeatDecorativeBlock build() {
            return new SeatDecorativeBlock(this);
        }
    }
}
