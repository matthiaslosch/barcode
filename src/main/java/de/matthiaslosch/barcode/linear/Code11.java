package de.matthiaslosch.barcode.linear;

import java.awt.image.BufferedImage;

public final class Code11 extends LinearCode {
    private enum Color {
        DARK,
        LIGHT
    }

    private Color currentColor = Color.DARK;
    private boolean hasStart;

    private int currentWidth = 0;

    private final int thicknessNarrow;
    private final int thicknessWide;

    public Code11(int height) {
        super(500, height, BufferedImage.TYPE_BYTE_BINARY);

        this.thicknessNarrow = 4;
        this.thicknessWide = 14;
    }

    // thicknessNarrow: Thickness of a narrow dark bar
    // thicknessWide: Thickness of a wide dark bar
    public Code11(int height, int thicknessNarrow, int thicknessWide) {
        super(500, height, BufferedImage.TYPE_BYTE_BINARY);

        this.thicknessNarrow = thicknessNarrow;
        this.thicknessWide = thicknessWide;
    }

    @Override
    public Code11 append(String str) {
        if (!hasStart) {
            append('*');
            hasStart = true;
        }

        for (char c : str.toCharArray()) {
            append(c);
        }

        return this;
    }

    @Override
    public BufferedImage create() {
        append('*');
        resize(currentWidth - (thicknessNarrow + 2), height);
        return image;
    }

    private void resizeIfNecessary() {
        final int GROWTH_FACTOR = 2;
        int maxSize = (thicknessWide + (thicknessWide + 2) + 2 * thicknessNarrow + 2 * (thicknessNarrow + 2)) * 2;
        if (width <= currentWidth + maxSize) {
            resize(width * GROWTH_FACTOR, height);
        }
    }

    private void append(char c) {
        resizeIfNecessary();

        switch (c) {
            case '0' -> {
                drawNarrowBar();
                drawNarrowBar();
                drawNarrowBar();
                drawNarrowBar();
                drawWideBar();
            }
            case '1' -> {
                drawWideBar();
                drawNarrowBar();
                drawNarrowBar();
                drawNarrowBar();
                drawWideBar();
            }
            case '2' -> {
                drawNarrowBar();
                drawWideBar();
                drawNarrowBar();
                drawNarrowBar();
                drawWideBar();
            }
            case '3' -> {
                drawWideBar();
                drawWideBar();
                drawNarrowBar();
                drawNarrowBar();
                drawNarrowBar();
            }
            case '4' -> {
                drawNarrowBar();
                drawNarrowBar();
                drawWideBar();
                drawNarrowBar();
                drawWideBar();
            }
            case '5' -> {
                drawWideBar();
                drawNarrowBar();
                drawWideBar();
                drawNarrowBar();
                drawNarrowBar();
            }
            case '6' -> {
                drawNarrowBar();
                drawWideBar();
                drawWideBar();
                drawNarrowBar();
                drawNarrowBar();
            }
            case '7' -> {
                drawNarrowBar();
                drawNarrowBar();
                drawNarrowBar();
                drawWideBar();
                drawWideBar();
            }
            case '8' -> {
                drawWideBar();
                drawNarrowBar();
                drawNarrowBar();
                drawWideBar();
                drawNarrowBar();
            }
            case '9' -> {
                drawWideBar();
                drawNarrowBar();
                drawNarrowBar();
                drawNarrowBar();
                drawNarrowBar();
            }
            case '-' -> {
                drawNarrowBar();
                drawNarrowBar();
                drawWideBar();
                drawNarrowBar();
                drawNarrowBar();
            }
            case '*' -> {
                drawNarrowBar();
                drawNarrowBar();
                drawWideBar();
                drawWideBar();
                drawNarrowBar();
            }
        }
        drawNarrowBar();
    }

    private void drawNarrowBar() {
        if (currentColor == Color.DARK) {
            graphics.fillRect(currentWidth, 0, thicknessNarrow, height);
            currentWidth += thicknessNarrow;
            currentColor = Color.LIGHT;
        } else {
            currentWidth += thicknessNarrow + 2;
            currentColor = Color.DARK;
        }
    }

    private void drawWideBar() {
        if (currentColor == Color.DARK) {
            graphics.fillRect(currentWidth, 0, thicknessWide, height);
            currentWidth += thicknessWide;
            currentColor = Color.LIGHT;
        } else {
            currentWidth += thicknessWide + 2;
            currentColor = Color.DARK;
        }
    }
}
