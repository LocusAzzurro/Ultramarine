package com.voxelutopia.ultramarine.event;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.ModBlockTags;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import com.voxelutopia.ultramarine.data.registry.VillagerProfessionRegistry;
import com.voxelutopia.ultramarine.world.block.ChiselTableMedium;
import com.voxelutopia.ultramarine.world.block.DecorativeBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod.EventBusSubscriber
public class CommonEventHandler {

    private static final Logger LOGGER = Ultramarine.getLogger();

    @SubscribeEvent
    public static void breakSpeed(PlayerEvent.BreakSpeed event){
        BlockState state = event.getState();
        Player player = event.getPlayer();
        if (state.is(ModBlockTags.MINEABLE_WITH_SHEARS) &&
                player.getItemInHand(player.getUsedItemHand()).is(Tags.Items.SHEARS)){
            event.setNewSpeed(event.getOriginalSpeed() * 4);
        }
    }

    @SubscribeEvent
    public static void itemConversion(ItemExpireEvent event){
        ItemEntity itemEntity = (ItemEntity) event.getEntity();
        ItemStack item = itemEntity.getItem();
        if (itemEntity.isInWater() && item.is(ItemRegistry.FIRED_BRICK.get())){
            itemEntity.setItem(new ItemStack(ItemRegistry.CYAN_BRICK.get(), item.getCount()));
            itemEntity.level.playSound(null, itemEntity, SoundEvents.LAVA_EXTINGUISH, SoundSource.NEUTRAL, 0.5f, 1.0f);
            event.setExtraLife(6000);
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void chiselTableMultiblock(BlockEvent event){
        if (event instanceof BlockEvent.EntityPlaceEvent placeEvent){
            BlockState placedBlock = placeEvent.getPlacedBlock();
            if (!placedBlock.is(BlockRegistry.BRUSH_AND_INKSTONE.get())) return;
            BlockPos pos = placeEvent.getPos();
            BlockState blockBelow = placeEvent.getWorld().getBlockState(pos.below());
            if (blockBelow.is(BlockRegistry.PORCELAIN_INLAID_TABLE.get())) {
                placeEvent.getWorld().setBlock(pos,
                        BlockRegistry.CHISEL_TABLE.get().defaultBlockState().setValue(DecorativeBlock.FACING, placedBlock.getValue(DecorativeBlock.FACING)), 3);
            }
        }
        if (event instanceof BlockEvent.BreakEvent breakEvent){
            BlockState block = breakEvent.getState();
            BlockPos pos = breakEvent.getPos();
            if (block.is(BlockRegistry.PORCELAIN_INLAID_TABLE.get()) && breakEvent.getWorld().getBlockState(pos.above()).is(BlockRegistry.CHISEL_TABLE.get())){
                breakEvent.getWorld().setBlock(pos.above(),
                        BlockRegistry.BRUSH_AND_INKSTONE.get().defaultBlockState().setValue(DecorativeBlock.FACING, block.getValue(DecorativeBlock.FACING)), 3);
            }
        }
    }

    @SubscribeEvent
    public static void snowFallTest(BlockEvent.NeighborNotifyEvent event){
        if (event.getState().is(Blocks.SNOW)){
            LOGGER.info("Snowfall Event: " + event.getPos());
        }
    }


    @SubscribeEvent
    public static void villagerTraders(VillagerTradesEvent event){
        VillagerProfession profession = event.getType();

        if (profession == VillagerProfessionRegistry.COOK.get()){
            var trades = event.getTrades();
            trades.get(1).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(ItemRegistry.RAW_MEAT.get(), 5),
                    new ItemStack(Items.EMERALD, 2),
                    12, 2, 0.05f
            ));
            trades.get(1).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    new ItemStack(ItemRegistry.COOKED_MEAT.get(), 4),
                    12, 2, 0.05f
            ));
            trades.get(2).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ItemRegistry.GREASE.get(), 2),
                    16, 2, 0.05f
            ));
            trades.get(2).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ItemRegistry.FUR.get(), 2),
                    16, 2, 0.05f
            ));
            trades.get(3).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    new ItemStack(ItemRegistry.MUNG_BEAN_CAKE.get(), 4),
                    12, 3, 0.05f
            ));
            trades.get(3).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    new ItemStack(ItemRegistry.MOONCAKE.get(), 4),
                    12, 3, 0.05f
            ));
            trades.get(4).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(ItemRegistry.BAOZI.get(), 2),
                    8, 3, 0.05f
            ));
        }

    }

}
