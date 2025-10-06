package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.registry.BlockEntityRegistry;
import com.voxelutopia.ultramarine.world.block.entity.BottleGourdBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class BottleGourd extends DecorativeBlock implements EntityBlock {
    public static final VoxelShape GOURD = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 14.0D, 11.0D);

    public BottleGourd(Builder builder) {
        super(builder);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        var optionalBlockEntity = level.getBlockEntity(pos, BlockEntityRegistry.BOTTLE_GOURD.get());
        if (optionalBlockEntity.isEmpty()) {
            // It shouldn't happen!
            return InteractionResult.PASS;
        }

        var blockEntity = optionalBlockEntity.get();
        if (blockEntity.hasCharges()) {
            if (!level.isClientSide()) {
                for (var effectInstance : blockEntity.getPotion().getEffects()) {
                    if (effectInstance.getEffect().value().isInstantenous()) {
                        effectInstance.getEffect().value().applyInstantenousEffect(player, player, player, effectInstance.getAmplifier(), 1.0D);
                    } else {
                        player.addEffect(new MobEffectInstance(effectInstance));
                    }
                }
                blockEntity.shrinkCharge();
            } else {
                level.playSound(null, player, SoundEvents.GENERIC_DRINK, SoundSource.PLAYERS, 1.0f, 1.0f);
            }
            return InteractionResult.SUCCESS;
        }

        return super.useWithoutItem(state, level, pos, player, hitResult);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        var optionalBlockEntity = level.getBlockEntity(pos, BlockEntityRegistry.BOTTLE_GOURD.get());
        if (optionalBlockEntity.isEmpty()) {
            // It shouldn't happen!
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }

        var blockEntity = optionalBlockEntity.get();
        if (stack.is(Items.POTION) && stack.has(DataComponents.POTION_CONTENTS)) {
            var potion = Optional.ofNullable(stack.get(DataComponents.POTION_CONTENTS)).map(PotionContents::potion).flatMap(x -> x).orElse(Potions.WATER).value();
            if (blockEntity.canAddCharge(potion)) {
                if (!level.isClientSide()) {
                    if (!player.getAbilities().instabuild) {
                        stack.shrink(1);
                        ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(Items.GLASS_BOTTLE));
                    }
                    blockEntity.setPotion(potion);
                    blockEntity.addCharge();
                } else {
                    level.playSound(null, pos, SoundEvents.BREWING_STAND_BREW, SoundSource.PLAYERS, 1.0f, 1.0f);
                }
                return ItemInteractionResult.SUCCESS;
            } else {
                return ItemInteractionResult.FAIL;
            }
        }

        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    @Override
    public BlockState playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        BlockState state = super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
        pLevel.getBlockEntity(pPos, BlockEntityRegistry.BOTTLE_GOURD.get()).ifPresent(entity -> {
            if (entity.hasCharges() && !pLevel.isClientSide()) {
                int charges = entity.getCharges();
                List<MobEffectInstance> effects = entity.getPotion().getEffects();
                if (!effects.isEmpty()) {
                    AreaEffectCloud areaeffectcloud = new AreaEffectCloud(pLevel, pPos.getX(), pPos.getY(), pPos.getZ());
                    areaeffectcloud.setRadius(0.5F * charges);
                    areaeffectcloud.setRadiusOnUse(-0.5F);
                    areaeffectcloud.setWaitTime(10);
                    areaeffectcloud.setDuration(areaeffectcloud.getDuration() * charges / 2);
                    areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float) areaeffectcloud.getDuration());

                    for (MobEffectInstance mobeffectinstance : effects) {
                        areaeffectcloud.addEffect(new MobEffectInstance(mobeffectinstance));
                    }
                    pLevel.addFreshEntity(areaeffectcloud);
                }
            }
        });
        return state;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new BottleGourdBlockEntity(pPos, pState);
    }
}
