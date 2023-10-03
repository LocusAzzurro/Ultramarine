package com.voxelutopia.ultramarine.common.block;

import com.voxelutopia.ultramarine.init.registry.BlockRegistry;
import net.minecraft.world.level.block.StairBlock;

public class BaseStairs extends StairBlock implements BaseBlockPropertyHolder {

    private final BaseBlockProperty property;

    public BaseStairs() {
        this(BaseBlockProperty.STONE);
    }

    public BaseStairs(BaseBlock block){
        super(block.defaultBlockState(), block.getProperty().properties);
        this.property = block.getProperty();
    }

    public BaseStairs(BaseBlockProperty property){
        super(BlockRegistry.CYAN_BRICKS.defaultBlockState(), property.properties);
        this.property = property;
    }

    @Override
    public BaseBlockProperty getProperty() {
        return property;
    }
}
