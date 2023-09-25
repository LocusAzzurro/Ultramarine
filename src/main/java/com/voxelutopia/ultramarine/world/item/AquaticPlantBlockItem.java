package com.voxelutopia.ultramarine.world.item;

import com.voxelutopia.ultramarine.data.ModCreativeTab;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;

public class AquaticPlantBlockItem extends BlockItem {

    public AquaticPlantBlockItem(Block pBlock, Properties properties) {
        super(pBlock, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        return InteractionResult.PASS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        BlockHitResult blockhitresult = getPlayerPOVHitResult(pLevel, pPlayer, ClipContext.Fluid.SOURCE_ONLY);
        BlockHitResult blockhitresult1 = blockhitresult.withPosition(blockhitresult.getBlockPos().above());
        InteractionResult interactionresult = super.useOn(new UseOnContext(pPlayer, pHand, blockhitresult1));
        return new InteractionResultHolder<>(interactionresult, pPlayer.getItemInHand(pHand));
    }
}
