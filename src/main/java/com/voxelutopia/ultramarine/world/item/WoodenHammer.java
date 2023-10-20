package com.voxelutopia.ultramarine.world.item;

import com.voxelutopia.ultramarine.data.CreativeTabDefinitions;
import com.voxelutopia.ultramarine.data.registry.SoundRegistry;
import com.voxelutopia.ultramarine.world.block.RailingBlock;
import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Optional;

public class WoodenHammer extends Item {

    public WoodenHammer() {
        super(new Item.Properties().tab(CreativeTabDefinitions.TOOLS).durability(100));
    }

    @Override
    public ActionResultType useOn(ItemUseContext pContext) {
        World level = pContext.getLevel();
        ItemStack item = pContext.getItemInHand();
        Optional<PlayerEntity> player = Optional.ofNullable(pContext.getPlayer());
        BlockPos blockpos = pContext.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        boolean success = false;
        if (blockstate.hasProperty(ModBlockStateProperties.SHIFTED)) {
            level.setBlock(blockpos, blockstate.setValue(ModBlockStateProperties.SHIFTED,
                    !blockstate.getValue(ModBlockStateProperties.SHIFTED)), 3);
            success = true;
        }
        if (blockstate.hasProperty(ModBlockStateProperties.CHIRAL_BLOCK_TYPE)) {
            level.setBlock(blockpos, blockstate.setValue(ModBlockStateProperties.CHIRAL_BLOCK_TYPE,
                    blockstate.getValue(ModBlockStateProperties.CHIRAL_BLOCK_TYPE).getOpposite()), 3);
            success = true;
        }
        if (blockstate.hasProperty(ModBlockStateProperties.LOCKED) && player.isPresent() && player.get().isCrouching()) {
            blockstate = blockstate.setValue(ModBlockStateProperties.LOCKED,
                    !blockstate.getValue(ModBlockStateProperties.LOCKED));
            if (blockstate.getBlock() instanceof RailingBlock) {
                blockstate = ((RailingBlock) blockstate.getBlock()).updatePole(blockstate);
            }
            level.setBlock(blockpos, blockstate, 3);
            success = true;
        }
        if (success) {
            player.ifPresent(player1 -> {
                item.hurtAndBreak(1, player1, p -> p.broadcastBreakEvent(pContext.getHand()));
                player1.awardStat(Stats.ITEM_USED.get(item.getItem()));
                level.playSound(player.get(), blockpos, SoundRegistry.WOOD_HAMMER.get(), SoundCategory.BLOCKS, 1, 0.75f);
            });
            return ActionResultType.sidedSuccess(level.isClientSide());
        }
        return super.useOn(pContext);
    }
}
