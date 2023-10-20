package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.world.block.entity.BottleGourdBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class BottleGourd extends DecorativeBlock {

    public static final VoxelShape GOURD = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 14.0D, 11.0D);


    public BottleGourd(Builder builder) {
        super(builder);
    }

    @Override
    public ActionResultType use(BlockState pState, World pLevel, BlockPos pPos, PlayerEntity pPlayer, Hand pHand, BlockRayTraceResult pHit) {
        ItemStack item = pPlayer.getItemInHand(pHand);
        TileEntity tile = pLevel.getBlockEntity(pPos);
        BottleGourdBlockEntity blockEntity;
        if (tile instanceof BottleGourdBlockEntity) {
            blockEntity = (BottleGourdBlockEntity) tile;
        } else return ActionResultType.PASS;

        if (item.getItem().equals(Items.POTION)) {
            Potion potion = PotionUtils.getPotion(item);
            if (blockEntity.addPotionCharge(potion)) {
                if (!pLevel.isClientSide()) {
                    if (!pPlayer.abilities.instabuild) {
                        item.shrink(1);
                        ItemHandlerHelper.giveItemToPlayer(pPlayer, new ItemStack(Items.GLASS_BOTTLE));
                    }
                }
                pLevel.playSound(null, pPos, SoundEvents.BREWING_STAND_BREW, SoundCategory.PLAYERS, 1.0f, 1.0f);
                return ActionResultType.sidedSuccess(pLevel.isClientSide);
            }
        } else if (blockEntity.hasCharges()) {
            Optional<Potion> potion1 = blockEntity.takePotionCharge();
            if (potion1.isPresent()) {
                if (!pLevel.isClientSide()) {
                    for (EffectInstance effectInstance : potion1.get().getEffects()) {
                        if (effectInstance.getEffect().isInstantenous()) {
                            effectInstance.getEffect().applyInstantenousEffect(pPlayer, pPlayer, pPlayer, effectInstance.getAmplifier(), 1.0D);
                        } else {
                            pPlayer.addEffect(new EffectInstance(effectInstance));
                        }
                    }
                }
                pLevel.playSound(null, pPlayer, SoundEvents.GENERIC_DRINK, SoundCategory.PLAYERS, 1.0f, 1.0f);
                return ActionResultType.sidedSuccess(pLevel.isClientSide);
            } else return ActionResultType.PASS;
        }
        return ActionResultType.PASS;
    }

    @Override
    public void playerWillDestroy(World pLevel, BlockPos pPos, BlockState pState, PlayerEntity pPlayer) {
        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
        TileEntity t = pLevel.getBlockEntity(pPos);
        if (t instanceof BottleGourdBlockEntity) {
            BottleGourdBlockEntity entity = (BottleGourdBlockEntity) t;
            if (entity.hasCharges() && !pLevel.isClientSide()) {
                int charges = entity.getCharges();
                List<EffectInstance> effects = entity.getPotion().getEffects();
                if (!effects.isEmpty()) {
                    AreaEffectCloudEntity cloud = new AreaEffectCloudEntity(pLevel, pPos.getX(), pPos.getY(), pPos.getZ());
                    cloud.setRadius(0.5F * charges);
                    cloud.setRadiusOnUse(-0.5F);
                    cloud.setWaitTime(10);
                    cloud.setDuration(cloud.getDuration() * charges / 2);
                    cloud.setRadiusPerTick(-cloud.getRadius() / (float) cloud.getDuration());

                    for (EffectInstance instance : effects) {
                        cloud.addEffect(new EffectInstance(instance));
                    }
                    pLevel.addFreshEntity(cloud);
                }
            }
        }
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new BottleGourdBlockEntity();
    }
}
