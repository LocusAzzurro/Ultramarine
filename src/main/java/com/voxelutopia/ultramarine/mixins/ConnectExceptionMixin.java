package com.voxelutopia.ultramarine.mixins;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(Block.class)
public class ConnectExceptionMixin {
    @Inject(at=@At("HEAD"),method="isExceptionForConnection",cancellable=true)
    private static void isExceptionForConnection(BlockState pState, CallbackInfoReturnable<Boolean> cbi) {
        if (Objects.requireNonNull(pState.getBlock().getRegistryName()).toString().equals("ultramarine:octagonal_palace_lantern") || pState.getBlock().getRegistryName().toString().equals("ultramarine:square_palace_lantern") || pState.getBlock().getRegistryName().toString().equals("ultramarine:woodworking_workbench") || pState.getBlock().getRegistryName().toString().equals("ultramarine:small_red_lantern")) {
            cbi.setReturnValue(true);
        }
    }
}
