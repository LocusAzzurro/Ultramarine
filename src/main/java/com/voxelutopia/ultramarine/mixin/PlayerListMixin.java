package com.voxelutopia.ultramarine.mixin;

import com.voxelutopia.ultramarine.data.network.WoodworkingRecipesSyncPacket;
import com.voxelutopia.ultramarine.data.recipe.WoodworkingRecipeAccess;
import net.minecraft.network.Connection;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.CommonListenerCookie;
import net.minecraft.server.players.PlayerList;
import net.neoforged.neoforge.network.PacketDistributor;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(PlayerList.class)
public abstract class PlayerListMixin {
    @Shadow
    @Final
    private MinecraftServer server;

    @Shadow
    @Final
    private List<ServerPlayer> players;

    @Inject(method = "placeNewPlayer", at = @At("TAIL"))
    private void ultramarine$syncWoodworkingRecipesOnJoin(Connection connection, ServerPlayer player, CommonListenerCookie cookie, CallbackInfo ci) {
        this.ultramarine$sendWoodworkingRecipes(player);
    }

    @Inject(method = "reloadResources", at = @At("TAIL"))
    private void ultramarine$syncWoodworkingRecipesOnReload(CallbackInfo ci) {
        for (ServerPlayer player : this.players) {
            this.ultramarine$sendWoodworkingRecipes(player);
        }
    }

    @Unique
    private void ultramarine$sendWoodworkingRecipes(ServerPlayer player) {
        if (this.server.getRecipeManager() instanceof WoodworkingRecipeAccess access) {
            PacketDistributor.sendToPlayer(player, WoodworkingRecipesSyncPacket.from(access.ultramarine$woodworkingRecipes()));
        }
    }
}
