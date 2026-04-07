package com.voxelutopia.ultramarine.data.network;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.data.recipe.WoodworkingRecipeAccess;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SelectableRecipe;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.item.crafting.display.SlotDisplay;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public record WoodworkingRecipesSyncPacket(List<Entry> entries) implements CustomPacketPayload {
    public static final Type<WoodworkingRecipesSyncPacket> TYPE = new Type<>(Identifier.fromNamespaceAndPath(Ultramarine.MOD_ID, "woodworking_recipes_sync"));

    public record Entry(Ingredient input, ItemStackTemplate result) {
        public static final StreamCodec<RegistryFriendlyByteBuf, Entry> STREAM_CODEC = StreamCodec.composite(
                Ingredient.CONTENTS_STREAM_CODEC, Entry::input,
                ItemStackTemplate.STREAM_CODEC, Entry::result,
                Entry::new
        );
    }

    public static final StreamCodec<RegistryFriendlyByteBuf, WoodworkingRecipesSyncPacket> STREAM_CODEC = StreamCodec.composite(
            Entry.STREAM_CODEC.apply(ByteBufCodecs.list()), WoodworkingRecipesSyncPacket::entries,
            WoodworkingRecipesSyncPacket::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static WoodworkingRecipesSyncPacket from(SelectableRecipe.SingleInputSet<StonecutterRecipe> recipes) {
        ArrayList<Entry> entries = new ArrayList<>();
        for (SelectableRecipe.SingleInputEntry<StonecutterRecipe> entry : recipes.entries()) {
            if (entry.recipe().optionDisplay() instanceof SlotDisplay.ItemStackSlotDisplay(ItemStackTemplate stack)) {
                entries.add(new Entry(entry.input(), stack));
            }
        }
        return new WoodworkingRecipesSyncPacket(entries);
    }

    public SelectableRecipe.SingleInputSet<StonecutterRecipe> asRecipeSet() {
        ArrayList<SelectableRecipe.SingleInputEntry<StonecutterRecipe>> rebuilt = new ArrayList<>(this.entries.size());
        for (Entry entry : this.entries) {
            rebuilt.add(new SelectableRecipe.SingleInputEntry<>(
                    entry.input(),
                    new SelectableRecipe<>(new SlotDisplay.ItemStackSlotDisplay(entry.result()), Optional.empty())
            ));
        }
        return new SelectableRecipe.SingleInputSet<>(rebuilt);
    }

    public static void handle(WoodworkingRecipesSyncPacket packet, IPayloadContext context) {
        ClientPacketListener connection = Minecraft.getInstance().getConnection();
        if (connection == null) {
            return;
        }

        if (connection.recipes() instanceof WoodworkingRecipeAccess access) {
            access.ultramarine$setWoodworkingRecipes(packet.asRecipeSet());
        }
    }
}
