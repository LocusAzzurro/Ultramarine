package com.voxelutopia.ultramarine.world.item;

import com.voxelutopia.ultramarine.data.CreativeTabs;
import com.voxelutopia.ultramarine.data.ModBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public class WoodenHammer extends Item {

    public WoodenHammer() {
        super(new Item.Properties().tab(CreativeTabs.BUILDING_BLOCKS).durability(100));
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        ItemStack item = pContext.getItemInHand();
        var player = Optional.ofNullable(pContext.getPlayer());
        BlockPos blockpos = pContext.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        if (blockstate.hasProperty(ModBlockStateProperties.SHIFTED)){
            level.setBlock(blockpos, blockstate.setValue(ModBlockStateProperties.SHIFTED,
                    !blockstate.getValue(ModBlockStateProperties.SHIFTED)), Block.UPDATE_ALL);
            player.ifPresent(player1 -> {
                item.hurtAndBreak(1, player1, p -> p.broadcastBreakEvent(pContext.getHand()));
                player1.awardStat(Stats.ITEM_USED.get(item.getItem()));
            });
            return InteractionResult.sidedSuccess(level.isClientSide());
        }
        return super.useOn(pContext);
    }


}
