package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.Ultramarine;
import com.voxelutopia.ultramarine.world.block.RoofTiles;
import com.voxelutopia.ultramarine.world.block.SnowRoofRidge;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.apache.commons.lang3.tuple.Pair;
import org.lwjgl.system.CallbackI;
import org.slf4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.List;

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

        roofTilesTextureMerge(pCache);
        roofRidgeTextureMerge(pCache);

    }

    private void roofRidgeTextureMerge(HashCache pCache) throws IOException {
        BufferedImage roofRidgeSideBase, snowLayer, combinedTexture;
        String[] roofRidgeColors = {"black", "yellow"};
        String[] roofRidgeSideTypes = {
                "roof_ridge_upper_side",
                "roof_ridge_lower_side",
                "roof_ridge_connection_front",
                "roof_ridge_connection_side",
                "main_roof_ridge_connection_front"};
        int maxSnowStages = SnowRoofRidge.MAX_SNOW_STAGES;

        for (String color : roofRidgeColors){
            for (String type : roofRidgeSideTypes){
                for (int stage = 1; stage <= maxSnowStages; stage++){

                    roofRidgeSideBase = ImageIO.read(getInputTexture(color + "_" + type));
                    snowLayer = ImageIO.read(getInputTexture("roof_ridge_side_snow_stage_" + stage));
                    combinedTexture = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

                    Graphics graphics = combinedTexture.getGraphics();
                    graphics.drawImage(roofRidgeSideBase, 0, 0, null);
                    graphics.drawImage(snowLayer, 0, 0, null);

                    save(pCache, combinedTexture, getOutputPath(color + "_" + type + "_snow_stage_" + stage));
                    graphics.dispose();
                }
            }
        }
    }

    private void roofTilesTextureMerge(HashCache pCache) throws IOException {
        BufferedImage roofTileBase, snowLayer, snowSideUp, snowSideLeft, snowSideRight, combinedTexture;
        String[] roofTileColors = {"gray", "yellow", "green", "blue", "cyan", "black"};
        for (RoofTiles.RoofTileType type: RoofTiles.RoofTileType.values()){
            Map<Integer, Pair<Integer, Boolean>> snowStages = type.getSnowStages();
            boolean usesSideSnow;
            int layerSnowStage, snowStageCounter;
            for (String color : roofTileColors){
                snowStageCounter = 0;
                for (int layer = 1; layer <= 15; layer++){
                    layerSnowStage = snowStages.get(layer).getLeft();
                    usesSideSnow = snowStages.get(layer).getRight();
                    if (layerSnowStage > snowStageCounter){
                        snowStageCounter = layerSnowStage;
                        roofTileBase = ImageIO.read(getInputTexture(color + "_" + type));
                        Graphics graphics;

                        //full layer for no side state and "both" state
                        snowLayer = ImageIO.read(getInputTexture(type + "_snow_stage_" + snowStageCounter));
                        combinedTexture = new BufferedImage(roofTileBase.getWidth(), roofTileBase.getHeight(), BufferedImage.TYPE_INT_ARGB);
                        graphics = combinedTexture.getGraphics();
                        graphics.drawImage(roofTileBase, 0, 0, null);
                        graphics.drawImage(snowLayer, 0, 0, null);

                        save(pCache, combinedTexture, getOutputPath(color + "_" + type + "_snow_stage_" + snowStageCounter));

                        if (usesSideSnow){
                            snowSideLeft = ImageIO.read(getInputTexture(type + "_snow_stage_" + snowStageCounter + "_l"));
                            snowSideRight = ImageIO.read(getInputTexture(type + "_snow_stage_" + snowStageCounter + "_r"));
                            snowSideUp = ImageIO.read(getInputTexture(type + "_snow_stage_" + snowStageCounter + "_u"));

                            combinedTexture = new BufferedImage(roofTileBase.getWidth(), roofTileBase.getHeight(), BufferedImage.TYPE_INT_ARGB);
                            graphics = combinedTexture.getGraphics();
                            graphics.drawImage(roofTileBase, 0, 0, null);
                            graphics.drawImage(snowSideUp, 0, 0, null);
                            save(pCache, combinedTexture, getOutputPath(color + "_" + type + "_snow_stage_" + snowStageCounter + "_none"));

                            combinedTexture = new BufferedImage(roofTileBase.getWidth(), roofTileBase.getHeight(), BufferedImage.TYPE_INT_ARGB);
                            graphics = combinedTexture.getGraphics();
                            graphics.drawImage(roofTileBase, 0, 0, null);
                            graphics.drawImage(snowSideUp, 0, 0, null);
                            graphics.drawImage(snowSideLeft, 0, 0, null);
                            save(pCache, combinedTexture, getOutputPath(color + "_" + type + "_snow_stage_" + snowStageCounter + "_left"));

                            combinedTexture = new BufferedImage(roofTileBase.getWidth(), roofTileBase.getHeight(), BufferedImage.TYPE_INT_ARGB);
                            graphics = combinedTexture.getGraphics();
                            graphics.drawImage(roofTileBase, 0, 0, null);
                            graphics.drawImage(snowSideUp, 0, 0, null);
                            graphics.drawImage(snowSideRight, 0, 0, null);
                            save(pCache, combinedTexture, getOutputPath(color + "_" + type + "_snow_stage_" + snowStageCounter + "_right"));

                        }
                        graphics.dispose();
                    }

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
