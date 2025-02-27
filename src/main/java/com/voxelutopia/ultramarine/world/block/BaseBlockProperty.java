package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.ModBlockTags;
import com.voxelutopia.ultramarine.data.registry.SoundRegistry;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;

public final class BaseBlockProperty {
    public static BaseBlockProperty STONE = new BaseBlockProperty(BlockBehaviour.Properties.of()
            .sound(SoundType.STONE)
            .strength(1.5F, 6.0F)
            .requiresCorrectToolForDrops()
            .instrument(NoteBlockInstrument.BASEDRUM),
            BlockMaterial.STONE);
    public static BaseBlockProperty MARBLE = new BaseBlockProperty(BlockBehaviour.Properties.of()
            .sound(SoundType.STONE)
            .strength(1.8F, 7.0F)
            .requiresCorrectToolForDrops()
            .instrument(NoteBlockInstrument.BASEDRUM),
            BlockMaterial.STONE);
    public static BaseBlockProperty TERRACOTTA = new BaseBlockProperty(BlockBehaviour.Properties.of()
            .sound(SoundType.STONE)
            .strength(1.2F, 4.0F)
            .requiresCorrectToolForDrops()
            .instrument(NoteBlockInstrument.BASEDRUM),
            BlockMaterial.STONE);
    public static BaseBlockProperty IRON = new BaseBlockProperty(BlockBehaviour.Properties.of()
            .sound(SoundType.METAL)
            .strength(5.0F, 6.0F)
            .requiresCorrectToolForDrops()
            .instrument(NoteBlockInstrument.IRON_XYLOPHONE),
            BlockMaterial.METAL);
    public static BaseBlockProperty COPPER = new BaseBlockProperty(BlockBehaviour.Properties.of()
            .sound(SoundType.METAL)
            .strength(5.0F, 6.0F)
            .requiresCorrectToolForDrops(),
            BlockMaterial.METAL);
    public static BaseBlockProperty BRONZE = new BaseBlockProperty(BlockBehaviour.Properties.of()
            .sound(SoundType.METAL)
            .strength(5.5F, 6.5F)
            .requiresCorrectToolForDrops(),
            BlockMaterial.METAL);
    public static BaseBlockProperty TILE = new BaseBlockProperty(BlockBehaviour.Properties.of()
            .sound(SoundType.BONE_BLOCK)
            .strength(1.5F, 6.0F)
            .requiresCorrectToolForDrops()
            .instrument(NoteBlockInstrument.BASEDRUM),
            BlockMaterial.STONE);
    public static BaseBlockProperty PORCELAIN = new BaseBlockProperty(BlockBehaviour.Properties.of()
            .sound(SoundRegistry.PORCELAIN)
            .strength(1.0F, 1.0F)
            .instrument(NoteBlockInstrument.HAT),
            BlockMaterial.PORCELAIN);
    public static BaseBlockProperty WOOD = new BaseBlockProperty(BlockBehaviour.Properties.of()
            .sound(SoundType.WOOD)
            .strength(2.0F, 3.0F)
            .ignitedByLava()
            .instrument(NoteBlockInstrument.BASS),
            BlockMaterial.WOOD);
    public static BaseBlockProperty BAMBOO_WOOD = new BaseBlockProperty(BlockBehaviour.Properties.of()
            .sound(SoundRegistry.BAMBOO_WOOD)
            .strength(2.0F, 3.0F)
            .ignitedByLava()
            .instrument(NoteBlockInstrument.BASS),
            BlockMaterial.WOOD);
    public static BaseBlockProperty BAMBOO = new BaseBlockProperty(BlockBehaviour.Properties.of()
            .sound(SoundType.BAMBOO)
            .ignitedByLava()
            .instrument(NoteBlockInstrument.XYLOPHONE)
            .strength(1.5F, 2.5F),
            BlockMaterial.BAMBOO);
    public static BaseBlockProperty GLAZED = new BaseBlockProperty(BlockBehaviour.Properties.of()
            .sound(SoundType.GLASS)
            .strength(1.5F, 6.0F)
            .requiresCorrectToolForDrops()
            .instrument(NoteBlockInstrument.HAT),
            BlockMaterial.STONE);
    public static BaseBlockProperty JADE = new BaseBlockProperty(BlockBehaviour.Properties.of()
            .sound(SoundType.GLASS)
            .strength(1.2F, 5.0F)
            .requiresCorrectToolForDrops()
            .instrument(NoteBlockInstrument.BELL),
            BlockMaterial.STONE);
    public static BaseBlockProperty FLAX = new BaseBlockProperty(BlockBehaviour.Properties.of()
            .sound(SoundRegistry.FLAX)
            .strength(1F, 2F)
            .ignitedByLava()
            .instrument(NoteBlockInstrument.BANJO),
            BlockMaterial.FLAX);
    public static BaseBlockProperty CROP = new BaseBlockProperty(BlockBehaviour.Properties.of()
            .sound(SoundType.CROP)
            .strength(1F, 1.5F)
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY),
            BlockMaterial.PLANT);
    public static BaseBlockProperty PLANT = new BaseBlockProperty(BlockBehaviour.Properties.of()
            .sound(SoundType.CROP)
            .strength(1F, 1.5F)
            .ignitedByLava()
            .pushReaction(PushReaction.DESTROY),
            BlockMaterial.PLANT);
    public static BaseBlockProperty LILY = new BaseBlockProperty(BlockBehaviour.Properties.of()
            .sound(SoundType.LILY_PAD)
            .strength(1F, 1.5F)
            .instabreak(),
            BlockMaterial.PLANT);
    public static BaseBlockProperty SILK = new BaseBlockProperty(BlockBehaviour.Properties.of()
            .sound(SoundType.WOOL)
            .strength(1F, 2F)
            .ignitedByLava()
            .instrument(NoteBlockInstrument.GUITAR),
            BlockMaterial.FABRIC);
    public static BaseBlockProperty PAPER = new BaseBlockProperty(BlockBehaviour.Properties.of()
            .sound(SoundType.WOOL)
            .strength(1F, 2F)
            .ignitedByLava(),
            BlockMaterial.PAPER);
    public static BaseBlockProperty DYE = new BaseBlockProperty(BlockBehaviour.Properties.of()
            .sound(SoundType.WOOL)
            .strength(1F, 1F),
            BlockMaterial.PAPER);
    public static BaseBlockProperty ICE = new BaseBlockProperty(BlockBehaviour.Properties.of()
            .sound(SoundType.CROP)
            .strength(0.5F, 1.0F),
            BlockMaterial.ICE);

    //todo map colors

    final BlockBehaviour.Properties properties;
    final BlockMaterial material;

    BaseBlockProperty(final BlockBehaviour.Properties properties, final BlockMaterial material){
        this.properties = properties;
        this.material = material;
    }

    public BlockMaterial getMaterial(){
        return material;
    }

    public BaseBlockProperty copy(){
        BlockBehaviour.Properties properties1 = BlockBehaviour.Properties.copy(new BlockBehaviour(this.properties) {
            @Override
            public Item asItem() {
                return Items.AIR;
            }

            @Override
            protected Block asBlock() {
                return Blocks.AIR;
            }
        });
        return new BaseBlockProperty(properties1, this.material);
    }

    public enum BlockMaterial{
        STONE(BlockTags.MINEABLE_WITH_PICKAXE),
        METAL(BlockTags.MINEABLE_WITH_PICKAXE),
        ICE(BlockTags.MINEABLE_WITH_PICKAXE),
        WOOD(BlockTags.MINEABLE_WITH_AXE),
        PORCELAIN(BlockTags.MINEABLE_WITH_PICKAXE),
        BAMBOO(BlockTags.MINEABLE_WITH_AXE),
        FABRIC(ModBlockTags.MINEABLE_WITH_SHEARS),
        PAPER(ModBlockTags.MINEABLE_WITH_SHEARS),
        PLANT(BlockTags.MINEABLE_WITH_HOE),
        FLAX(BlockTags.MINEABLE_WITH_HOE);

        final TagKey<Block> tool;
        public TagKey<Block> getTool(){
            return tool;
        }
        BlockMaterial(TagKey<Block> tool){
            this.tool = tool;
        }
    }

}
