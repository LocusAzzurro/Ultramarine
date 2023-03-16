package com.voxelutopia.ultramarine.world.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class BaseBlock extends Block {

    public static final BlockBehaviour.Properties PROPERTIES = BlockBehaviour.Properties.of(Material.STONE)
            .strength(1.5F, 6.0F);

    private final BaseBlockProperty property;

    public BaseBlock(){
        this(BaseBlockProperty.STONE);
    }

    public BaseBlock(BaseBlockProperty property){
        super(property.properties);
        this.property = property;
    }

    public BaseBlockProperty getProperty(){
        return property;
    }


}
