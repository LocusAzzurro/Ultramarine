package com.voxelutopia.ultramarine.datagen;

import com.voxelutopia.ultramarine.Ultramarine;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraftforge.common.data.ExistingFileHelper;
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

        BufferedImage existingTexture = ImageIO.read(getInputTexture("bamboo_mat"));
        BufferedImage overlay = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        BufferedImage combined = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        overlay.setRGB(1, 1, 0xffff00ff);
        Graphics graphics = combined.getGraphics();
        graphics.drawImage(existingTexture, 0, 0, null);
        graphics.drawImage(overlay, 0, 0, null);
        graphics.dispose();

        save(pCache, combined, getOutputPath("test"));
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
