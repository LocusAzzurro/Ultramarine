package com.voxelutopia.ultramarine.event;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.ModBlockTags;
import com.voxelutopia.ultramarine.data.registry.*;
import com.voxelutopia.ultramarine.world.block.DecorativeBlock;
import com.voxelutopia.ultramarine.world.block.SnowRoofRidge;
import com.voxelutopia.ultramarine.world.entity.TravellingMerchant;
import com.voxelutopia.ultramarine.world.saveddata.TravellingMerchantSpawnData;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.item.ItemExpireEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import org.slf4j.Logger;

@EventBusSubscriber
public class CommonEventHandler {

    private static final Logger LOGGER = Ultramarine.getLogger();

    @SubscribeEvent
    public static void breakSpeed(PlayerEvent.BreakSpeed event) {
        BlockState state = event.getState();
        Player player = event.getEntity();
        if (state.is(ModBlockTags.MINEABLE_WITH_SHEARS) &&
                player.getItemInHand(player.getUsedItemHand()).is(Tags.Items.TOOLS_SHEAR)) {
            event.setNewSpeed(event.getOriginalSpeed() * 4);
        }
    }

    @SubscribeEvent(receiveCanceled = true)
    public static void itemConversion(ItemExpireEvent event) {
        ItemEntity itemEntity = event.getEntity();
        ItemStack item = itemEntity.getItem();
        if (itemEntity.isInWater() && item.is(ItemRegistry.FIRED_BRICK.get())) {
            itemEntity.setItem(new ItemStack(ItemRegistry.CYAN_BRICK.get(), item.getCount()));
            itemEntity.level().playSound(null, itemEntity, SoundEvents.LAVA_EXTINGUISH, SoundSource.NEUTRAL, 0.5f, 1.0f);
            event.setExtraLife(6000);
//            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void chiselTableMultiblockPlace(BlockEvent.EntityPlaceEvent event) {
        BlockState placedBlock = event.getPlacedBlock();
        if (!placedBlock.is(BlockRegistry.BRUSH_AND_INKSTONE.get())) return;
        BlockPos pos = event.getPos();
        BlockState blockBelow = event.getLevel().getBlockState(pos.below());
        if (blockBelow.is(BlockRegistry.PORCELAIN_INLAID_TABLE.get()))
            event.getLevel().setBlock(pos, BlockRegistry.CHISEL_TABLE.get().defaultBlockState().setValue(DecorativeBlock.FACING, placedBlock.getValue(DecorativeBlock.FACING)), 3);
    }

    @SubscribeEvent
    public static void chiselTableMultiblockBreak(BlockEvent.BreakEvent event) {
        BlockState block = event.getState();
        BlockPos pos = event.getPos();
        if (block.is(BlockRegistry.PORCELAIN_INLAID_TABLE.get()) && event.getLevel().getBlockState(pos.above()).is(BlockRegistry.CHISEL_TABLE.get()))
            event.getLevel().setBlock(pos.above(), BlockRegistry.BRUSH_AND_INKSTONE.get().defaultBlockState().setValue(DecorativeBlock.FACING, block.getValue(DecorativeBlock.FACING)), 3);
    }

    @SubscribeEvent
    public static void roofSnowFall(BlockEvent.NeighborNotifyEvent event) {
        if (event.getState().is(Blocks.SNOW)) {
            BlockState blockBelow = event.getLevel().getBlockState(event.getPos().below());
            if (blockBelow.getBlock() instanceof SnowRoofRidge ridge && blockBelow.getValue(SnowRoofRidge.SNOW_LAYERS) < 15) {
                ridge.handleSnow(blockBelow, event.getLevel(), event.getPos().below());
                event.getLevel().setBlock(event.getPos(), Blocks.AIR.defaultBlockState(), 3);
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void travellingMerchantSpawnAttempt(LevelTickEvent.Pre event) {
        if (event.getLevel().isClientSide()) return;
        ServerLevel world = (ServerLevel) event.getLevel();
        if (event.getLevel().dimension() != Level.OVERWORLD || world.getOverworldClockTime() % 24000 != 0) return;
        if (!world.getGameRules().get(GameRules.SPAWN_WANDERING_TRADERS) ||
                !world.getGameRules().get(GameRules.SPAWN_MOBS) ||
                !world.getGameRules().get(GameRules.ADVANCE_TIME)) return;
        TravellingMerchantSpawnData spawnData = world.getDataStorage()
                .computeIfAbsent(TravellingMerchantSpawnData.TYPE);
        int spawnRoll = world.getRandom().nextInt(100);
        if (spawnRoll < spawnData.getSpawnChance()){
            spawnTrader(world);
            spawnData.resetSpawnChance();
        }
        else spawnData.increaseSpawnChance();
    }

    @SuppressWarnings("ConstantConditions")
    private static void spawnTrader(ServerLevel world) {
        ServerPlayer player = world.getRandomPlayer();
        if (player == null) return;
        BlockPos blockpos = player.blockPosition();
        world.getPoiManager().find((poi) -> poi.is(PoiTypeRegistry.TRADE_POI.getKey()), (pos1) -> true, blockpos, 32, PoiManager.Occupancy.ANY).ifPresent(pos -> {
            BlockPos potentialSpawn = null;
            for (int i = 0; i < 10; ++i) {
                int x = pos.getX() + world.getRandom().nextInt(4 * 2) - 4;
                int z = pos.getZ() + world.getRandom().nextInt(4 * 2) - 4;
                int y = world.getHeight(Heightmap.Types.WORLD_SURFACE, x, z);
                BlockPos rolledPos = new BlockPos(x, y, z);
                if (NaturalSpawner.isValidEmptySpawnBlock(world, rolledPos, world.getBlockState(rolledPos), world.getFluidState(rolledPos), EntityType.WANDERING_TRADER)) {
                    potentialSpawn = rolledPos;
                    break;
                }
            }
            if (potentialSpawn == null) return;

            boolean hasSpaceAtSpawn = true;
            for (BlockPos blockPos : BlockPos.betweenClosed(potentialSpawn, potentialSpawn.offset(1, 2, 1))) {
                if (!world.getBlockState(blockPos).getCollisionShape(world, blockPos).isEmpty()) {
                    hasSpaceAtSpawn = false;
                    break;
                }
            }

            if (hasSpaceAtSpawn && !world.getBiome(pos).is(Biomes.THE_VOID)) {
                TravellingMerchant merchant = EntityTypeRegistry.TRAVELLING_MERCHANT.get().spawn(world, potentialSpawn, EntitySpawnReason.EVENT);
                if (merchant == null) return;
                merchant.setDespawnDelay(12000);
                merchant.setWanderTarget(potentialSpawn);
                merchant.setHomeTo(potentialSpawn, 8);
            }
        });
    }
}
