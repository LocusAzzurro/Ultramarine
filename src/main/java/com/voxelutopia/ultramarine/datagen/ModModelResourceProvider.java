package com.voxelutopia.ultramarine.datagen;

import com.google.gson.JsonParser;
import com.voxelutopia.ultramarine.data.registry.BlockRegistry;
import com.voxelutopia.ultramarine.data.registry.ItemRegistry;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.Identifier;

/**
 * Validates the hand-authored model resources that replace the legacy Forge
 * model generators. The legacy output contains many custom state variants, so
 * replacing it with generic 26.1 model templates would change block behaviour.
 */
public final class ModModelResourceProvider implements DataProvider {
    private static final String ASSETS_ROOT = "assets/" + DataGenerators.MOD_ID + "/";

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        List<String> missing = new ArrayList<>();
        BlockRegistry.BLOCKS.getEntries().forEach(holder ->
                validate("blockstate", "blockstates", BuiltInRegistries.BLOCK.getKey(holder.get()), missing));
        ItemRegistry.ITEMS.getEntries().forEach(holder ->
                validate("item model", "models/item", BuiltInRegistries.ITEM.getKey(holder.get()), missing));

        if (!missing.isEmpty()) {
            throw new IllegalStateException("Missing or invalid Ultramarine model resources:\n - "
                    + String.join("\n - ", missing));
        }
        return CompletableFuture.completedFuture(null);
    }

    private static void validate(String type, String directory, Identifier id, List<String> missing) {
        String resource = ASSETS_ROOT + directory + "/" + id.getPath() + ".json";
        try (InputStream stream = ModModelResourceProvider.class.getClassLoader().getResourceAsStream(resource)) {
            if (stream == null) {
                missing.add(type + " for " + id + " (" + resource + ")");
                return;
            }
            JsonParser.parseReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
        } catch (IOException | RuntimeException exception) {
            missing.add(type + " for " + id + " (" + exception.getMessage() + ")");
        }
    }

    @Override
    public String getName() {
        return DataGenerators.MOD_ID + " Model Resources";
    }
}
