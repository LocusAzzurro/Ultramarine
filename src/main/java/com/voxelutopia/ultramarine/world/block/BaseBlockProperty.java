package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.ModBlockTags;
import com.voxelutopia.ultramarine.data.registry.SoundRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public final class BaseBlockProperty {
    public static BaseBlockProperty STONE = new BaseBlockProperty(AbstractBlock.Properties.of(Material.STONE)
            .sound(SoundType.STONE)
            .strength(1.5F, 6.0F)
            .requiresCorrectToolForDrops()
            .harvestTool(ToolType.PICKAXE), BlockMaterial.STONE);
    public static BaseBlockProperty MARBLE = new BaseBlockProperty(AbstractBlock.Properties.of(Material.STONE)
            .sound(SoundType.STONE)
            .strength(1.8F, 7.0F)
            .requiresCorrectToolForDrops()
            .harvestTool(ToolType.PICKAXE), BlockMaterial.STONE);
    public static BaseBlockProperty TERRACOTTA = new BaseBlockProperty(AbstractBlock.Properties.of(Material.STONE)
            .sound(SoundType.STONE)
            .strength(1.2F, 4.0F)
            .requiresCorrectToolForDrops()
            .harvestTool(ToolType.PICKAXE), BlockMaterial.STONE);
    public static BaseBlockProperty IRON = new BaseBlockProperty(AbstractBlock.Properties.of(Material.METAL)
            .sound(SoundType.METAL)
            .strength(5.0F, 6.0F)
            .requiresCorrectToolForDrops()
            .harvestTool(ToolType.PICKAXE), BlockMaterial.METAL);
    public static BaseBlockProperty COPPER = new BaseBlockProperty(AbstractBlock.Properties.of(Material.METAL)
            .sound(SoundType.METAL)
            .strength(5.0F, 6.0F)
            .requiresCorrectToolForDrops()
            .harvestTool(ToolType.PICKAXE), BlockMaterial.METAL);
    public static BaseBlockProperty BRONZE = new BaseBlockProperty(AbstractBlock.Properties.of(Material.METAL)
            .sound(SoundType.METAL)
            .strength(5.5F, 6.5F)
            .requiresCorrectToolForDrops()
            .harvestTool(ToolType.PICKAXE), BlockMaterial.METAL);
    public static BaseBlockProperty TILE = new BaseBlockProperty(AbstractBlock.Properties.of(Material.STONE)
            .sound(SoundType.BONE_BLOCK)
            .strength(1.5F, 6.0F)
            .requiresCorrectToolForDrops()
            .harvestTool(ToolType.PICKAXE), BlockMaterial.STONE);
    public static BaseBlockProperty PORCELAIN = new BaseBlockProperty(AbstractBlock.Properties.of(Material.GLASS)
            .sound(SoundRegistry.PORCELAIN)
            .strength(1.0F, 1.0F)
            .harvestTool(ToolType.PICKAXE), BlockMaterial.PORCELAIN);
    public static BaseBlockProperty WOOD = new BaseBlockProperty(AbstractBlock.Properties.of(Material.WOOD)
            .sound(SoundType.WOOD)
            .strength(2.0F, 3.0F)
            .harvestTool(ToolType.AXE), BlockMaterial.WOOD);
    public static BaseBlockProperty BAMBOO_WOOD = new BaseBlockProperty(AbstractBlock.Properties.of(Material.WOOD)
            .sound(SoundRegistry.BAMBOO_WOOD)
            .strength(2.0F, 3.0F)
            .harvestTool(ToolType.AXE), BlockMaterial.WOOD);
    public static BaseBlockProperty BAMBOO = new BaseBlockProperty(AbstractBlock.Properties.of(Material.BAMBOO)
            .sound(SoundType.BAMBOO)
            .strength(1.5F, 2.5F)
            .harvestTool(ToolType.AXE), BlockMaterial.BAMBOO);
    public static BaseBlockProperty GLAZED = new BaseBlockProperty(AbstractBlock.Properties.of(Material.STONE)
            .sound(SoundType.GLASS)
            .strength(1.5F, 6.0F)
            .requiresCorrectToolForDrops()
            .harvestTool(ToolType.PICKAXE), BlockMaterial.STONE);
    public static BaseBlockProperty JADE = new BaseBlockProperty(AbstractBlock.Properties.of(Material.STONE)
            .sound(SoundType.GLASS)
            .strength(1.2F, 5.0F)
            .requiresCorrectToolForDrops()
            .harvestTool(ToolType.PICKAXE), BlockMaterial.STONE);
    public static BaseBlockProperty FLAX = new BaseBlockProperty(AbstractBlock.Properties.of(Material.WOOL)
            .sound(SoundRegistry.FLAX)
            .strength(1F, 2F)
            .harvestTool(ToolType.HOE), BlockMaterial.FLAX);
    public static BaseBlockProperty CROP = new BaseBlockProperty(AbstractBlock.Properties.of(Material.VEGETABLE)
            .sound(SoundType.CROP)
            .strength(1F, 1.5F)
            .harvestTool(ToolType.HOE), BlockMaterial.PLANT);
    public static BaseBlockProperty PLANT = new BaseBlockProperty(AbstractBlock.Properties.of(Material.VEGETABLE)
            .sound(SoundType.CROP)
            .strength(1F, 1.5F)
            .harvestTool(ToolType.HOE), BlockMaterial.PLANT);
    public static BaseBlockProperty LILY = new BaseBlockProperty(AbstractBlock.Properties.of(Material.VEGETABLE)
            .sound(SoundType.LILY_PAD)
            .strength(1F, 1.5F)
            .harvestTool(ToolType.HOE), BlockMaterial.PLANT);
    public static BaseBlockProperty SILK = new BaseBlockProperty(AbstractBlock.Properties.of(Material.CLOTH_DECORATION)
            .sound(SoundType.WOOL)
            .strength(1F, 2F), BlockMaterial.FABRIC);
    public static BaseBlockProperty PAPER = new BaseBlockProperty(AbstractBlock.Properties.of(Material.CLOTH_DECORATION)
            .sound(SoundType.WOOL)
            .strength(1F, 2F), BlockMaterial.PAPER);
    public static BaseBlockProperty DYE = new BaseBlockProperty(AbstractBlock.Properties.of(Material.CLOTH_DECORATION)
            .sound(SoundType.WOOL)
            .strength(1F, 1F), BlockMaterial.PAPER);

    final AbstractBlock.Properties properties;
    final BlockMaterial material;

    BaseBlockProperty(final AbstractBlock.Properties properties, final BlockMaterial material) {
        this.properties = properties;
        this.material = material;
    }

    public BlockMaterial getMaterial() {
        return material;
    }

    public BaseBlockProperty copy() {
        return new BaseBlockProperty(this.properties, this.material);
    }

    public enum BlockMaterial {
        STONE(null),
        METAL(null),
        WOOD(null),
        PORCELAIN(null),
        BAMBOO(null),
        FABRIC(ModBlockTags.MINEABLE_WITH_SHEARS),
        PAPER(ModBlockTags.MINEABLE_WITH_SHEARS),
        PLANT(null),
        FLAX(null);

        // TODO: Needs redo. 1.16.5 doesn't use Tag to define the tool for harvesting

        final ITag.INamedTag<Block> tool;

        @Nullable
        public ITag.INamedTag<Block> getTool() {
            return tool;
        }

        BlockMaterial(@Nullable ITag.INamedTag<Block> tool) {
            this.tool = tool;
        }
    }

}
