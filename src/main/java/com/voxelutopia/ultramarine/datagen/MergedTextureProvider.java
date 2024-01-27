package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.world.block.RoofTiles;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.lwjgl.system.CallbackI;
import org.slf4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class MergedTextureProvider implements DataProvider {

    private static final Logger LOGGER = Ultramarine.getLogger();
    private final DataGenerator generator;
    protected ExistingFileHelper fileHelper;

    public MergedTextureProvider(DataGenerator generator, ExistingFileHelper fileHelper){
        this.generator = generator;
        this.fileHelper = fileHelper;
    }

    @Override
    public void run(HashCache pCache) throws IOException {

        BufferedImage roofTileBase, snowLayer, combinedTexture;
        String[] roofTileColors = {"gray", "yellow", "green", "blue", "cyan", "black"};
        for (RoofTiles.RoofTileType type: RoofTiles.RoofTileType.values()){
            int maxSnowStages = type.getMaxSnowStages();
            for (String color : roofTileColors){
                for (int i = 1; i <= maxSnowStages; i++){
                    roofTileBase = ImageIO.read(getInputTexture(color + "_" + type));
                    snowLayer = ImageIO.read(getInputTexture(type + "_snow_stage_" + i));
                    combinedTexture = new BufferedImage(roofTileBase.getWidth(), roofTileBase.getHeight(), BufferedImage.TYPE_INT_ARGB);
                    Graphics graphics = combinedTexture.getGraphics();
                    graphics.drawImage(roofTileBase, 0, 0, null);
                    graphics.drawImage(snowLayer, 0, 0, null);
                    graphics.dispose();
                    save(pCache, combinedTexture, getOutputPath(color + "_" + type + "_snow_stage_" + i));
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Ultramarine Texture Merger";
    }

    static void save(HashCache pCache, BufferedImage texture, Path pPath) throws IOException {
        ByteArrayOutputStream imageByteArray = new ByteArrayOutputStream();
        ImageIO.write(texture, "png", imageByteArray);
        String sha = SHA1.hashBytes(imageByteArray.toByteArray()).toString();
        if (!Objects.equals(pCache.getHash(pPath), sha) || !Files.exists(pPath)) {
            Files.createDirectories(pPath.getParent());
            File file = new File(pPath.toUri());

            try {
                ImageIO.write(texture, "png", file);
            } catch (IOException exception) {
                LOGGER.warn("Cannot write " + texture);
                exception.printStackTrace();
            }
        }

        pCache.putNew(pPath, sha);
    }

    private Path getOutputPath(String textureName) {
        return generator.getOutputFolder().resolve("assets/" + DataGenerators.MOD_ID + "/textures/block/" + textureName + ".png");
    }

    private InputStream getInputTexture(String name){
        return getClass().getClassLoader().getResourceAsStream("assets/" + DataGenerators.MOD_ID + "/textures/block/" + name + ".png");
    }

}
