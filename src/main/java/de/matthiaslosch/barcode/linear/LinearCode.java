package de.matthiaslosch.barcode.linear;

import de.matthiaslosch.barcode.Barcode;

import java.awt.image.BufferedImage;

public abstract class LinearCode extends Barcode {
    protected LinearCode(int width, int height, int type) {
        this.width = width;
        this.height = height;

        image = new BufferedImage(width, height, type);
        graphics = image.createGraphics();
        graphics.setColor(java.awt.Color.WHITE);
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(java.awt.Color.BLACK);
    }

    public abstract LinearCode append(String str);
}
