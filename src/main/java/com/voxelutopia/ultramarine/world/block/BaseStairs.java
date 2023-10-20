package com.voxelutopia.ultramarine.world.block;

import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import net.minecraft.block.StairsBlock;

public class BaseStairs extends StairsBlock implements BaseBlockPropertyHolder {

    private final BaseBlockProperty property;

    public BaseStairs() {
        this(BaseBlockProperty.STONE);
    }

    public BaseStairs(BaseBlock block) {
        super(block::defaultBlockState, block.getProperty().properties);
        this.property = block.getProperty();
    }

    public BaseStairs(BaseBlockProperty property) {
        super(() -> BlockRegistry.CYAN_BRICKS.get().defaultBlockState(), property.properties);
        this.property = property;
    }

    @Override
    public BaseBlockProperty getProperty() {
        return property;
    }
}
