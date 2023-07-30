package com.voxelutopia.ultramarine.world.block;

import net.minecraft.world.level.block.Block;

public class BaseBlock extends Block implements BaseBlockPropertyHolder {

    protected final BaseBlockProperty property;

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
