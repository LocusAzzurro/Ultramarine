package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import net.minecraft.world.level.block.StairBlock;

public class BaseStairs extends StairBlock implements BaseBlockPropertyHolder {

    private final BaseBlockProperty property;

    public BaseStairs() {
        this(BaseBlockProperty.stone());
    }

    public BaseStairs(BaseBlock block){
        super(block.defaultBlockState(), block.getProperty().properties());
        this.property = block.getProperty();
    }

    public BaseStairs(BaseBlockProperty property){
        super(BlockRegistry.CYAN_BRICKS.get().defaultBlockState(), property.properties());
        this.property = property;
    }

    @Override
    public BaseBlockProperty getProperty() {
        return property;
    }
}
