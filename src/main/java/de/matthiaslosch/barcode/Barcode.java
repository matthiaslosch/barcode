package de.matthiaslosch.barcode;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Barcode {
    protected BufferedImage image;
    protected Graphics2D graphics;

    protected int width;
    protected int height;

    public abstract BufferedImage create();

    protected void resize(int newWidth, int newHeight) {
        int oldWidth = width;
        int oldHeight = height;

        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, image.getType());
        graphics = resizedImage.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, newWidth, newHeight);
        graphics.setColor(Color.BLACK);
        graphics.drawImage(image, 0, 0, oldWidth, oldHeight, null);

        image = resizedImage;
        width = newWidth;
        height = newHeight;
    }
}
