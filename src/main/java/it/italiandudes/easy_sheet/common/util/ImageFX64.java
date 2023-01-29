package it.italiandudes.easy_sheet.common.util;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

@SuppressWarnings("unused")
public final class ImageFX64 {
    public static Image base64ToImage(String base64image) {
        ByteArrayInputStream inStream = new ByteArrayInputStream(Base64.getDecoder().decode(base64image));
        BufferedImage rawImage;
        try {
            rawImage = ImageIO.read(inStream);
        }catch (IOException e){
            return null;
        }
        WritableImage writableImage = new WritableImage(rawImage.getWidth(), rawImage.getHeight());
        return SwingFXUtils.toFXImage(rawImage, writableImage);
    }
    public static String imageToBase64(Image fxImage) {
        BufferedImage rawImage = SwingFXUtils.fromFXImage(fxImage, null);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(rawImage, "png", outStream);
        }catch (IOException e){
            return null;
        }
        return Base64.getEncoder().encodeToString(outStream.toByteArray());
    }
    public static Image fileToImage(File filePointer) {
        return new Image(filePointer.toURI().toString());
    }
}
