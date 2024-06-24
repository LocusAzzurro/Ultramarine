package com.voxelutopia.ultramarine.event;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.ModBlockTags;
import com.voxelutopia.ultramarine.data.registry.*;
import com.voxelutopia.ultramarine.world.block.DecorativeBlock;
import com.voxelutopia.ultramarine.world.block.SnowRoofRidge;
import com.voxelutopia.ultramarine.world.entity.TravellingMerchant;
import com.voxelutopia.ultramarine.world.feature.ModPlacedFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.storage.ServerLevelData;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

import java.util.List;
import java.util.Optional;

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
    public static void roofSnowFall(BlockEvent.NeighborNotifyEvent event){
        if (event.getState().is(Blocks.SNOW)){
            BlockState blockBelow = event.getWorld().getBlockState(event.getPos().below());
            if (blockBelow.getBlock() instanceof SnowRoofRidge ridge && blockBelow.getValue(SnowRoofRidge.SNOW_LAYERS) < 15){
                ridge.handleSnow(blockBelow, event.getWorld(), event.getPos().below());
                event.getWorld().setBlock(event.getPos(), Blocks.AIR.defaultBlockState(), 3);
                event.setCanceled(true);
            }
        }
    }

    //@SubscribeEvent
    public static void accelerateTraderTick(TickEvent.WorldTickEvent event){
        if (!event.world.isClientSide() && event.phase == TickEvent.Phase.START){
            ServerLevel world = (ServerLevel) event.world;
            ServerLevelData levelData = (ServerLevelData) world.getLevelData();
            if (world.getGameTime() % 600 == 0){
                levelData.setWanderingTraderSpawnChance(0);
                levelData.setWanderingTraderSpawnDelay(0);
                /*
                ServerPlayer player = world.getRandomPlayer();
                if (player != null){
                    EntityType.WANDERING_TRADER.spawn(world, (CompoundTag)null, (Component)null, (Player)null, player.blockPosition(), MobSpawnType.EVENT, false, false);
                }

                 */
            }
        }
    }

    @SubscribeEvent
    public static void travellingMerchantSpawnAttempt(TickEvent.WorldTickEvent event){
        if (event.world.isClientSide() || event.phase != TickEvent.Phase.START) return;
        ServerLevel world = (ServerLevel) event.world;
        ServerLevelData levelData = (ServerLevelData) world.getLevelData();
        if (!world.getGameRules().getBoolean(GameRules.RULE_DO_TRADER_SPAWNING) ||
                !world.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING) ||
                !world.getGameRules().getBoolean(GameRules.RULE_DAYLIGHT)) return;
        int wanderingTraderSpawnDelay = levelData.getWanderingTraderSpawnDelay();
        int wanderingTraderSpawnChance = levelData.getWanderingTraderSpawnChance();
        if (world.getDayTime() % 24000 == 0 && wanderingTraderSpawnDelay <= 0 && world.random.nextInt(100) > wanderingTraderSpawnChance){
            spawnTrader(world);
        }
    }

    //@SubscribeEvent
    public static void travellingMerchantSpawn(LivingSpawnEvent.SpecialSpawn event) {
        if (event.getWorld().isClientSide()) return;
        ServerLevel world = ((ServerLevelAccessor) event.getWorld()).getLevel();
        if (event.getEntityLiving().getType().equals(EntityType.WANDERING_TRADER) && event.getSpawnReason() == MobSpawnType.EVENT) {
            spawnTrader(world);
        }
    }

    private static void spawnTrader(ServerLevel world) {
        ServerPlayer player = world.getRandomPlayer();
        if (player == null) return;
        BlockPos blockpos = player.blockPosition();
        world.getPoiManager().find(PoiTypeRegistry.TRADE_POI.get().getPredicate(), (pos1) -> true, blockpos, 16, PoiManager.Occupancy.ANY).ifPresent(pos -> {
            BlockPos potentialSpawn = null;
            for (int i = 0; i < 10; ++i) {
                int x = pos.getX() + world.random.nextInt(4 * 2) - 4;
                int z = pos.getZ() + world.random.nextInt(4 * 2) - 4;
                int y = ((LevelReader) world).getHeight(Heightmap.Types.WORLD_SURFACE, x, z);
                BlockPos rolledPos = new BlockPos(x, y, z);
                if (NaturalSpawner.isSpawnPositionOk(SpawnPlacements.Type.ON_GROUND, world, rolledPos, EntityType.WANDERING_TRADER)) {
                    potentialSpawn = rolledPos;
                    break;
                }
            }
            if (potentialSpawn == null) return;

            boolean hasSpaceAtSpawn = true;
            for (BlockPos blockPos : BlockPos.betweenClosed(potentialSpawn, potentialSpawn.offset(1, 2, 1))) {
                if (!((BlockGetter) world).getBlockState(blockPos).getCollisionShape(world, blockPos).isEmpty()) {
                    hasSpaceAtSpawn = false; break;
                }
            }

            if (hasSpaceAtSpawn && !world.getBiome(pos).is(Biomes.THE_VOID)) {
                TravellingMerchant merchant = EntityTypeRegistry.TRAVELLING_MERCHANT.get().spawn(
                        world, null, null, null, potentialSpawn, MobSpawnType.EVENT, false, false);
                if (merchant == null) return;
                merchant.setDespawnDelay(24000);
                merchant.setWanderTarget(potentialSpawn);
                merchant.restrictTo(potentialSpawn, 8);
                }
        });
    }

    @SubscribeEvent
    public static void villagerTradesHandler(VillagerTradesEvent event){
        VillagerProfession profession = event.getType();
        var trades = event.getTrades();
        if (profession == VillagerProfession.MASON){
            trades.get(4).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(ItemRegistry.RAW_HEMATITE.get(), 2),
                    12, 10, 0.05f
            ));
            trades.get(4).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(ItemRegistry.MAGNESITE.get(), 2),
                    12, 10, 0.05f
            ));
            trades.get(5).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 10),
                    new ItemStack(ItemRegistry.JADE.get(), 1),
                    6, 20, 0.05f
            ));
        }

        if (profession == VillagerProfession.TOOLSMITH){
            trades.get(4).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    new ItemStack(ItemRegistry.BRONZE_INGOT.get(), 1),
                    12, 10, 0.05f
            ));
            trades.get(5).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 40),
                    new ItemStack(ItemRegistry.CARRIAGE.get(), 1),
                    1, 10, 0.05f
            ));
        }

        if (profession == VillagerProfession.FARMER){
            trades.get(3).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ItemRegistry.POLISHED_ROSEWOOD_PLANK.get(), 8),
                    12, 5, 0.05f
            ));
            trades.get(3).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ItemRegistry.POLISHED_EBONY_PLANK.get(), 8),
                    12, 5, 0.05f
            ));
        }

        if (profession == VillagerProfession.LIBRARIAN){
            trades.get(4).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 20),
                    new ItemStack(ItemRegistry.XUAN_PAPER.get(), 4),
                    10, 20, 0.05f
            ));
        }

        if (profession == VillagerProfession.CLERIC){
            trades.get(5).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 40),
                    new ItemStack(ItemRegistry.SUNDIAL.get(), 1),
                    1, 20, 0.05f
            ));
        }

        if (profession == VillagerProfessionRegistry.COOK.get()){
            trades.get(1).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(ItemRegistry.RAW_MEAT.get(), 10),
                    new ItemStack(Items.EMERALD, 1),
                    12, 2, 0.05f
            ));
            trades.get(1).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.PORKCHOP, 15),
                    new ItemStack(Items.EMERALD, 1),
                    12, 2, 0.05f
            ));
            trades.get(1).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.BEEF, 15),
                    new ItemStack(Items.EMERALD, 1),
                    12, 2, 0.05f
            ));
            trades.get(1).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.CHICKEN, 20),
                    new ItemStack(Items.EMERALD, 1),
                    12, 2, 0.05f
            ));
            trades.get(1).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    new ItemStack(ItemRegistry.COOKED_MEAT.get(), 4),
                    12, 2, 0.05f
            ));
            trades.get(2).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.MUTTON, 15),
                    new ItemStack(Items.EMERALD, 1),
                    12, 4, 0.05f
            ));
            trades.get(2).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.RABBIT, 15),
                    new ItemStack(Items.EMERALD, 1),
                    12, 4, 0.05f
            ));
            trades.get(2).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    new ItemStack(ItemRegistry.GREASE.get(), 2),
                    8, 5, 0.05f
            ));
            trades.get(2).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 6),
                    new ItemStack(ItemRegistry.FUR.get(), 2),
                    8, 5, 0.05f
            ));
            trades.get(3).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.DRIED_KELP, 40),
                    new ItemStack(Items.EMERALD, 2),
                    15, 8, 0.05f
            ));
            trades.get(3).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.SUGAR, 40),
                    new ItemStack(Items.EMERALD, 1),
                    20, 8, 0.05f
            ));
            trades.get(3).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EGG, 16),
                    new ItemStack(Items.EMERALD, 1),
                    20, 8, 0.05f
            ));
            trades.get(3).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ItemRegistry.MUNG_BEAN_CAKE.get(), 4),
                    12, 10, 0.05f
            ));
            trades.get(3).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ItemRegistry.MOONCAKE.get(), 4),
                    12, 10, 0.05f
            ));
            trades.get(4).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ItemRegistry.CABBAGE_BASKET.get(), 1),
                    3, 20, 0.05f
            ));
            trades.get(4).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ItemRegistry.CELERY_BASKET.get(), 1),
                    3, 20, 0.05f
            ));
            trades.get(4).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ItemRegistry.ORANGE_BASKET.get(), 1),
                    3, 20, 0.05f
            ));
            trades.get(4).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ItemRegistry.APPLE_BASKET.get(), 1),
                    3, 20, 0.05f
            ));
            trades.get(4).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ItemRegistry.EGGPLANT_BASKET.get(), 1),
                    3, 20, 0.05f
            ));
            trades.get(4).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 12),
                    new ItemStack(ItemRegistry.PEAR_BASKET.get(), 1),
                    3, 20, 0.05f
            ));
            trades.get(4).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(ItemRegistry.BAOZI.get(), 2),
                    6, 20, 0.05f
            ));
            trades.get(5).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 25),
                    new ItemStack(ItemRegistry.XIAOLONGBAO.get(), 1),
                    2, 30, 0.05f
            ));
            trades.get(5).add(($1, $2) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 40),
                    new ItemStack(ItemRegistry.BOTTLE_GOURD.get(), 1),
                    1, 30, 0.05f
            ));
        }

    }

    @SubscribeEvent
    public static void wanderingTraderHandler(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        rareTrades.add(($1, $2) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 6),
                new ItemStack(ItemRegistry.INCENSE.get(), 1),
                6, 30, 0.05f
        ));
        rareTrades.add(($1, $2) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 6),
                new ItemStack(ItemRegistry.SILK.get(), 1),
                8, 30, 0.05f
        ));
        rareTrades.add(($1, $2) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 10),
                new ItemStack(ItemRegistry.JADE.get(), 1),
                2, 30, 0.05f
        ));
        rareTrades.add(($1, $2) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 12),
                new ItemStack(ItemRegistry.PAINTING_SCROLL.get(), 1),
                1, 30, 0.05f
        ));
        rareTrades.add(($1, $2) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 20),
                new ItemStack(ItemRegistry.BLUE_AND_WHITE_PORCELAIN_VASE.get(), 1),
                1, 30, 0.05f
        ));
        //todo move some trades to special trader

    }

    @SubscribeEvent
    public static void oreGeneration(BiomeLoadingEvent event) {

        List<Holder<PlacedFeature>> undergroundOres = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        undergroundOres.add(ModPlacedFeatures.JADE_ORE_PLACED_FEATURE);
        undergroundOres.add(ModPlacedFeatures.MAGNESITE_ORE_PLACED_FEATURE);
        undergroundOres.add(ModPlacedFeatures.HEMATITE_ORE_PLACED_FEATURE);
        undergroundOres.add(ModPlacedFeatures.COBALT_ORE_PLACED_FEATURE);

    }
}
