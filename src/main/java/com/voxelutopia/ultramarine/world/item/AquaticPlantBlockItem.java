package com.voxelutopia.ultramarine.world.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.world.World;

public class AquaticPlantBlockItem extends BlockItem {

    public AquaticPlantBlockItem(Block pBlock, Properties properties) {
        super(pBlock, properties);
    }

    @Override
    public ActionResultType useOn(ItemUseContext ctx) {
        return ActionResultType.PASS;
    }

    @Override
    public ActionResult<ItemStack> use(World pLevel, PlayerEntity pPlayer, Hand pHand) {
        BlockRayTraceResult result = getPlayerPOVHitResult(pLevel, pPlayer, RayTraceContext.FluidMode.SOURCE_ONLY);
        BlockRayTraceResult result1 = result.withPosition(result.getBlockPos().above());
        ActionResultType type = super.useOn(new ItemUseContext(pPlayer, pHand, result1));
        return new ActionResult<>(type, pPlayer.getItemInHand(pHand));
    }
}
