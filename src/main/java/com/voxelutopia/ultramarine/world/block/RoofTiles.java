package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.util.RawVoxelShape;
import com.voxelutopia.ultramarine.world.block.state.ModBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Map;
import java.util.Random;

public class RoofTiles extends ShiftableBlock{

    public static final BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of(Material.STONE)
            .requiresCorrectToolForDrops().strength(1.5F, 4.0F).sound(SoundType.DEEPSLATE_TILES);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final IntegerProperty SNOW_LAYERS = ModBlockStateProperties.SNOW_LAYERS;
    public static final EnumProperty<SnowSide> SNOW_SIDE = ModBlockStateProperties.SNOW_SIDE;

    private static final VoxelShape BOTTOM_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
    private static final VoxelShape BOTTOM_AABB_SHIFTED = Block.box(0.0D, -8.0D, 0.0D, 16.0D, 0.0D, 16.0D);
    private static final RawVoxelShape NORTH_UPPER_RAW = new RawVoxelShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 8.0D);
    private static final VoxelShape NORTH_SHAPE = Shapes.or(BOTTOM_AABB, NORTH_UPPER_RAW.copy().toVoxelShape());
    private static final VoxelShape WEST_SHAPE = Shapes.or(BOTTOM_AABB, NORTH_UPPER_RAW.copy().rotateY(90).toVoxelShape());
    private static final VoxelShape SOUTH_SHAPE = Shapes.or(BOTTOM_AABB, NORTH_UPPER_RAW.copy().rotateY(180).toVoxelShape());
    private static final VoxelShape EAST_SHAPE = Shapes.or(BOTTOM_AABB, NORTH_UPPER_RAW.copy().rotateY(270).toVoxelShape());
    private static final VoxelShape EAST_SHAPE_SHIFTED = Shapes.or(BOTTOM_AABB_SHIFTED, Block.box(8.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D));
    private static final VoxelShape NORTH_SHAPE_SHIFTED = Shapes.or(BOTTOM_AABB_SHIFTED, Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 8.0D));
    private static final VoxelShape SOUTH_SHAPE_SHIFTED = Shapes.or(BOTTOM_AABB_SHIFTED, Block.box(0.0D, 0.0D, 8.0D, 16.0D, 8.0D, 16.0D));
    private static final VoxelShape WEST_SHAPE_SHIFTED = Shapes.or(BOTTOM_AABB_SHIFTED, Block.box(0.0D, 0.0D, 0.0D, 8.0D, 8.0D, 16.0D));

    private final DyeColor color;
    private final RoofTileType type;

    public RoofTiles(DyeColor color, RoofTileType type){
        super(PROPERTIES);
        this.color = color;
        this.type = type;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(SHIFTED, Boolean.FALSE)
                .setValue(WATERLOGGED, Boolean.FALSE)
                .setValue(SNOW_LAYERS, 0)
                .setValue(SNOW_SIDE, SnowSide.BOTH));
    }

    @Override
    public void handlePrecipitation(BlockState pState, Level pLevel, BlockPos pPos, Biome.Precipitation pPrecipitation) {
        if (pPrecipitation == Biome.Precipitation.SNOW) {
            tryPushSnow(pState, pLevel, pPos);
        }
    }

    private void tryPushSnow(BlockState pState, Level pLevel, BlockPos pPos) {
        Random random = pLevel.getRandom();
        SlopeAngle forwardAngle = checkForwardSlopeAngle(pLevel, pState, pPos);
        if (forwardAngle == SlopeAngle.HIGHER) {
            handleSnow(pState, pLevel, pPos);
            return;
        }
        else {
            BlockState blockForward = pLevel.getBlockState(pPos.relative(pState.getValue(FACING).getOpposite()));
            BlockState blockForwardBelow = pLevel.getBlockState(pPos.relative(pState.getValue(FACING).getOpposite()).below());
            if (forwardAngle == SlopeAngle.LEVEL && random.nextFloat() < 0.5f) {
                if (blockForward.getBlock() instanceof RoofTiles){
                    if (blockForward.getValue(SNOW_LAYERS) == 15 && random.nextFloat() > 0.9f){
                        tryPushSnow(blockForward, pLevel, pPos.relative(pState.getValue(FACING).getOpposite()));
                        return;
                    }
                }
            }
            if ((forwardAngle == SlopeAngle.LOWER && random.nextFloat() < 0.8f)){
                if (blockForward.getBlock() instanceof RoofTiles){
                    if (blockForward.getValue(SNOW_LAYERS) == 15 && random.nextFloat() > 0.9f){
                        tryPushSnow(blockForward, pLevel, pPos.relative(pState.getValue(FACING).getOpposite()));
                        return;
                    }
                }
                else if (blockForwardBelow.getBlock() instanceof RoofTiles){
                    if (blockForwardBelow.getValue(SNOW_LAYERS) == 15 && random.nextFloat() > 0.9f){
                        tryPushSnow(blockForwardBelow, pLevel, pPos.relative(pState.getValue(FACING).getOpposite()));
                        return;
                    }
                }
            }
        }
        handleSnow(pState, pLevel, pPos);
    }

    private void handleSnow(BlockState pState, Level pLevel, BlockPos pPos){
        if (!pLevel.isClientSide()) {
            int snow = pState.getValue(SNOW_LAYERS);
            snow++;
            BlockState newState = pState.setValue(SNOW_LAYERS, Math.min(15, snow));
            pLevel.setBlockAndUpdate(pPos, newState);
            updateSideSnow(newState, pLevel, pPos);
        }
    }

    private void removeSnow(BlockState pState, Level pLevel, BlockPos pPos){
        if (!pLevel.isClientSide()) {
            int snow = pState.getValue(SNOW_LAYERS);
            snow--;
            BlockState newState = pState.setValue(SNOW_LAYERS, Math.max(0, snow));
            pLevel.setBlockAndUpdate(pPos, newState);
            updateSideSnow(newState, pLevel, pPos);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack item = pPlayer.getItemInHand(pHand);
        if (item.is(Items.SNOWBALL)){
            handleSnow(pState, pLevel, pPos);
            if (!pPlayer.isCreative()) item.shrink(1);
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
        if (item.getItem() instanceof ShovelItem){
            removeSnow(pState, pLevel, pPos);
            if (!pPlayer.isCreative()) {
                item.hurtAndBreak(1, pPlayer, p -> p.broadcastBreakEvent(pHand));
            }
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
        return InteractionResult.PASS;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
        updateSideSnow(pState, pLevel, pPos);
        super.neighborChanged(pState, pLevel, pPos, pBlock, pFromPos, pIsMoving);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        updateSideSnow(pState, pLevel, pPos);
        updateNeighborSideSnow(pState, pLevel, pPos);
        super.onPlace(pState, pLevel, pPos, pOldState, pIsMoving);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        updateNeighborSideSnow(pState, pLevel, pPos);
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    private void updateNeighborSideSnow(BlockState pState, Level pLevel, BlockPos pPos){
        Direction direction = pState.getValue(FACING);
        BlockPos[] posToUpdate = getSideUpdatePosArray(pPos, direction);
        for (BlockPos pos : posToUpdate){
            Block block = pLevel.getBlockState(pos).getBlock();
            if (block instanceof RoofTiles) updateSideSnow(pLevel.getBlockState(pos), pLevel, pos);
        }
    }

    private BlockPos[] getSideUpdatePosArray(BlockPos pPos, Direction direction){
        return new BlockPos[]{
                pPos.relative(direction.getClockWise()), pPos.relative(direction.getCounterClockWise()),
                pPos.relative(direction.getClockWise()).above(), pPos.relative(direction.getCounterClockWise()).above(),
                pPos.relative(direction.getClockWise()).below(), pPos.relative(direction.getCounterClockWise()).below()
        };
    }

    private void updateSideSnow(BlockState pState, Level pLevel, BlockPos pPos){
        SnowSide currentSnowSide = pState.getValue(SNOW_SIDE);
        Direction direction = pState.getValue(FACING);
        //left == CCW right == CW
        BlockPos blockPosLeft = pPos.relative(direction.getCounterClockWise());
        BlockPos blockPosRight = pPos.relative(direction.getClockWise());
        SlopeAngle slopeLeft = checkSideSlopeAngle(pLevel, pState, pPos, pLevel.getBlockState(blockPosLeft), blockPosLeft);
        SlopeAngle slopeRight = checkSideSlopeAngle(pLevel, pState, pPos, pLevel.getBlockState(blockPosRight), blockPosRight);
        if (slopeLeft == SlopeAngle.LOWER) currentSnowSide = SnowSide.add(currentSnowSide, SnowSide.LEFT);
        else currentSnowSide = SnowSide.remove(currentSnowSide, SnowSide.LEFT);
        if (slopeRight == SlopeAngle.LOWER) currentSnowSide = SnowSide.add(currentSnowSide, SnowSide.RIGHT);
        else currentSnowSide = SnowSide.remove(currentSnowSide, SnowSide.RIGHT);
        BlockState newState = pState.setValue(SNOW_SIDE, currentSnowSide);
        pLevel.setBlockAndUpdate(pPos, newState);
    }

    //slope - other relative to self
    private SlopeAngle checkSideSlopeAngle(Level level, BlockState self, BlockPos selfPos, BlockState other, BlockPos otherPos){
        Boolean selfShifted = self.getValue(SHIFTED);
        RoofTileType type = ((RoofTiles) self.getBlock()).getType();
        if (type != RoofTileType.STAIRS){  // Normal tile and edge tile
            if (selfShifted) {
                Block blockAbove = level.getBlockState(otherPos.above()).getBlock();
                if (blockAbove instanceof RoofTiles) return SlopeAngle.HIGHER;
                Block blockLevel = other.getBlock();
                if (blockLevel instanceof RoofTiles tileLevel){
                    if (!other.getValue(SHIFTED)) return SlopeAngle.HIGHER;
                    return tileLevel.getType() == RoofTileType.STAIRS ? SlopeAngle.HIGHER : SlopeAngle.LEVEL;
                }
                if (!other.isAir()) return SlopeAngle.LEVEL; //todo need to check actual block shapes
            }
            else {
                BlockState blockAbove = level.getBlockState(otherPos.above());
                if (blockAbove.getBlock() instanceof RoofTiles && blockAbove.getValue(SHIFTED))
                    return SlopeAngle.HIGHER;
                Block blockLevel = other.getBlock();
                if (blockLevel instanceof RoofTiles tileLevel){
                    if (other.getValue(SHIFTED)) return SlopeAngle.LOWER;
                    else return tileLevel.getType() == RoofTileType.STAIRS ? SlopeAngle.HIGHER : SlopeAngle.LEVEL;
                }
                if (!other.isAir()) return SlopeAngle.HIGHER;
            }
            return SlopeAngle.LOWER;
        }
        else { // Stair tile
            if (selfShifted) {
                BlockState blockAbove = level.getBlockState(otherPos.above());
                if (!blockAbove.isAir()) return SlopeAngle.HIGHER;
                Block blockLevel = other.getBlock();
                if (blockLevel instanceof RoofTiles tileLevel){
                    if (tileLevel.getType() != RoofTileType.STAIRS) return SlopeAngle.LOWER;
                    return other.getValue(SHIFTED) ? SlopeAngle.LOWER : SlopeAngle.LEVEL;
                }
                if (!other.isAir()) return SlopeAngle.LEVEL; //todo need to check actual block shapes
                return SlopeAngle.LOWER;
            }
            else {
                Block blockLevel = other.getBlock();
                if (blockLevel instanceof RoofTiles tileLevel){
                    if (!other.getValue(SHIFTED)) return SlopeAngle.HIGHER;
                    else return tileLevel.getType() == RoofTileType.STAIRS ? SlopeAngle.LEVEL : SlopeAngle.LOWER;
                }
                if (!other.isAir()) return SlopeAngle.HIGHER;
            }
        }
        return SlopeAngle.LEVEL;
    }

    private SlopeAngle checkForwardSlopeAngle(Level level, BlockState self, BlockPos selfPos){
        Boolean selfShifted = self.getValue(SHIFTED);
        Direction direction = self.getValue(FACING);
        RoofTileType type = ((RoofTiles) self.getBlock()).getType();
        BlockState blockForward = level.getBlockState(selfPos.relative(direction.getOpposite()));
        if (type != RoofTileType.STAIRS) {
            if (selfShifted) {
                if (blockForward.getBlock() instanceof RoofTiles tileForward){
                    if (!blockForward.getValue(SHIFTED)) return SlopeAngle.HIGHER;
                    else return tileForward.getType() == RoofTileType.STAIRS ? SlopeAngle.HIGHER : SlopeAngle.LEVEL;
                }
                BlockState blockForwardBelow = level.getBlockState(selfPos.relative(direction.getOpposite()).above());
                if (blockForwardBelow.getBlock() instanceof RoofTiles && !blockForwardBelow.getValue(SHIFTED))
                    return SlopeAngle.LOWER;
            }
            else {
                BlockState blockForwardAbove = level.getBlockState(selfPos.relative(direction.getOpposite()).above());
                if (blockForwardAbove.getBlock() instanceof RoofTiles && blockForwardAbove.getValue(SHIFTED))
                    return SlopeAngle.HIGHER;
                if (blockForward.getBlock() instanceof RoofTiles tileForward){
                    if (tileForward.getType() == RoofTileType.STAIRS)
                        return blockForward.getValue(SHIFTED) ? SlopeAngle.LOWER : SlopeAngle.HIGHER;
                    else return blockForward.getValue(SHIFTED) ? SlopeAngle.LOWER : SlopeAngle.LEVEL;
                }
            }
        }
        else {
            if (selfShifted) {
                if (blockForward.getBlock() instanceof RoofTiles tileForward && tileForward.getType() != RoofTileType.STAIRS)
                    return SlopeAngle.LOWER;
                if (!blockForward.isAir()) return SlopeAngle.HIGHER;
                BlockState blockForwardBelow = level.getBlockState(selfPos.relative(direction.getOpposite()).above());
                if (blockForwardBelow.getBlock() instanceof RoofTiles tilesForwardBelow) {
                    if (blockForwardBelow.getValue(SHIFTED))
                        return tilesForwardBelow.getType() == RoofTileType.STAIRS ? SlopeAngle.LOWER : SlopeAngle.HIGHER;
                    else return SlopeAngle.LOWER;
                }
            }
            else {
                BlockState blockForwardAbove = level.getBlockState(selfPos.relative(direction.getOpposite()).above());
                if (blockForwardAbove.getBlock() instanceof RoofTiles && blockForwardAbove.getValue(SHIFTED))
                    return SlopeAngle.HIGHER;
                if (blockForward.getBlock() instanceof RoofTiles tileForward){
                    if (blockForward.getValue(SHIFTED))
                        return tileForward.getType() == RoofTileType.STAIRS ? SlopeAngle.HIGHER : SlopeAngle.LOWER;
                    else return SlopeAngle.LOWER;
                }
            }
        }
        return SlopeAngle.HIGHER;
    }

    public DyeColor getColor() {
        return color;
    }

    public RoofTileType getType() {
        return type;
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(FACING);
        pBuilder.add(SNOW_LAYERS);
        pBuilder.add(SNOW_SIDE);
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return super.getStateForPlacement(pContext).setValue(FACING, pContext.getHorizontalDirection());
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Boolean shifted = pState.getValue(SHIFTED);
        if (type != RoofTileType.STAIRS)
            return shifted ? Block.box(0.0D, -8.0D, 0.0D, 16.0D, 0.0D, 16.0D) : Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
        else {
            return switch (pState.getValue(FACING)) {
                case NORTH -> shifted ? NORTH_SHAPE_SHIFTED : NORTH_SHAPE;
                case SOUTH -> shifted ? SOUTH_SHAPE_SHIFTED : SOUTH_SHAPE;
                case WEST -> shifted ? WEST_SHAPE_SHIFTED : WEST_SHAPE;
                case EAST -> shifted ? EAST_SHAPE_SHIFTED : EAST_SHAPE;
                default -> Shapes.empty();
            };
        }
    }

    public enum RoofTileType implements ShiftedTileType{
        NORMAL("roof_tiles", Map.ofEntries(
                Map.entry(0, Pair.of(0, false)), Map.entry(1, Pair.of(1, false)), Map.entry(2, Pair.of(2, false)), Map.entry(3, Pair.of(2, false)),
                Map.entry(4, Pair.of(3, true)), Map.entry(5, Pair.of(4, true)), Map.entry(6, Pair.of(4, true)), Map.entry(7, Pair.of(5, true)),
                Map.entry(8, Pair.of(6, true)), Map.entry(9, Pair.of(7, true)), Map.entry(10, Pair.of(7, true)), Map.entry(11, Pair.of(8, true)),
                Map.entry(12, Pair.of(9, true)), Map.entry(13, Pair.of(10, true)), Map.entry(14, Pair.of(11, true)), Map.entry(15, Pair.of(11, true))
        ), 11),
        STAIRS("roof_tile_stairs", Map.ofEntries(
                Map.entry(0, Pair.of(0, false)), Map.entry(1, Pair.of(1, false)), Map.entry(2, Pair.of(1, false)), Map.entry(3, Pair.of(1, false)),
                Map.entry(4, Pair.of(1, false)), Map.entry(5, Pair.of(1, false)), Map.entry(6, Pair.of(2, false)), Map.entry(7, Pair.of(2, false)),
                Map.entry(8, Pair.of(2, false)), Map.entry(9, Pair.of(3, false)), Map.entry(10, Pair.of(3, false)), Map.entry(11, Pair.of(3, false)),
                Map.entry(12, Pair.of(4, false)), Map.entry(13, Pair.of(4, false)), Map.entry(14, Pair.of(4, false)), Map.entry(15, Pair.of(5, false))
        ), 5),
        EDGE("roof_tile_edge", Map.ofEntries(
                Map.entry(0, Pair.of(0, false)), Map.entry(1, Pair.of(1, true)), Map.entry(2, Pair.of(1, true)), Map.entry(3, Pair.of(1, true)),
                Map.entry(4, Pair.of(1, true)), Map.entry(5, Pair.of(1, true)), Map.entry(6, Pair.of(1, true)), Map.entry(7, Pair.of(2, true)),
                Map.entry(8, Pair.of(2, true)), Map.entry(9, Pair.of(2, true)), Map.entry(10, Pair.of(2, true)), Map.entry(11, Pair.of(2, true)),
                Map.entry(12, Pair.of(2, true)), Map.entry(13, Pair.of(3, true)), Map.entry(14, Pair.of(3, true)), Map.entry(15, Pair.of(3, true))
        ), 3),;

        // Right boolean in pair - true = use LR side snow / false = use the full stage texture

        final String blockName;
        final Map<Integer, Pair<Integer, Boolean>> snowStages;
        final Integer maxSnowStages;

        RoofTileType(String blockName, Map<Integer, Pair<Integer, Boolean>> snowStages, int maxSnowStages){
            this.blockName = blockName;
            this.snowStages = snowStages;
            this.maxSnowStages = maxSnowStages;
        }

        public Map<Integer, Pair<Integer, Boolean>> getSnowStages() {
            return snowStages;
        }

        public Integer getMaxSnowStages() {
            return maxSnowStages;
        }

        @Override
        public String toString() {
            return blockName;
        }
    }

    public enum SnowSide implements StringRepresentable {
        LEFT("left"), RIGHT("right"), NONE("none"), BOTH("both");

        final String name;
        SnowSide(String name){
            this.name = name;
        }

        public static SnowSide add(SnowSide current, SnowSide toAdd){
            if (toAdd == NONE) return current;
            if (current == LEFT || current == RIGHT){
                if (current == toAdd) return current;
                else return BOTH;
            }
            else if (current == NONE){
                return toAdd;
            }
            return current;
        }

        public static SnowSide remove(SnowSide current, SnowSide toRemove){
            if (toRemove == NONE) return current;
            if (current == LEFT || current == RIGHT){
                if (toRemove == BOTH || current == toRemove) return NONE;
                else return current;
            }
            else if (current == BOTH){
                if (toRemove == BOTH) return NONE;
                else return toRemove == LEFT ? RIGHT : LEFT;
            }
            return current;
        }

        @Override
        public String getSerializedName() {
            return name;
        }
    }

    private enum SlopeAngle{HIGHER, LOWER, LEVEL}


}
