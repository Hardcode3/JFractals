package org.jfractals.ui;

public final class FractalExportSettings {
    private int widthPx = 1920;
    private int heightPx = 1080;
    private int aspectRatioWidth = 16;
    private int aspectRatioHeight = 9;

    public int getWidthPx() {
        return widthPx;
    }
    public void setWidthPx(int newWidthPx) {
        widthPx= newWidthPx;
        int gcd = greatestCommonDivisor(widthPx, heightPx);
        aspectRatioWidth = widthPx / gcd;
        aspectRatioHeight = heightPx / gcd;
    }

    public int getHeightPx() {
        return heightPx;
    }
    public void setHeightPx(int newHeightPx) {
        heightPx = newHeightPx;
        int gcd = greatestCommonDivisor(widthPx, heightPx);
        aspectRatioWidth = widthPx / gcd;
        aspectRatioHeight = heightPx / gcd;
    }

    public int getAspectRatioWidth() {
        return aspectRatioWidth;
    }
    public void setAspectRatioWidth(int newAspectRatioWidth) {
        aspectRatioWidth = newAspectRatioWidth;
        widthPx = aspectRatioWidth / aspectRatioHeight / heightPx;
    }

    public int getAspectRatioHeight() {
        return aspectRatioHeight;
    }
    public void setAspectRatioHeight(int newAspectRatioHeight) {
        aspectRatioHeight = newAspectRatioHeight;
        heightPx = aspectRatioWidth / aspectRatioHeight / widthPx;
    }

    private static int greatestCommonDivisor(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return Math.abs(a);
    }
}
