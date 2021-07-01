package com.Nephty.graphics.properties;

import com.Nephty.main;

public class ImageProperties {
    public final double x, y, width, height;

    /**
     * Build an <code>ImageProperties</code> object.
     * @param x The x position as if placed on a reference display (2560x1440)
     * @param y The y position as if placed on a reference display
     * @param width The width of the image as if placed on a reference display
     * @param height The width of the image as if placed on a reference display
     */
    public ImageProperties(double x, double y, double width, double height) {
        this.x = x * main.WR;
        this.y = y * main.HR;
        this.width = width * main.WR;
        this.height = height * main.HR;
    }

    /**
     * Return a new <code>ImageProperties</code> object with the attributes of the original object upon which this
     * method is called. The x attribute will be replaced with the value given to the method.
     * @param x The new x value
     * @return The newly created <code>ImageProperties</code> object
     */
    public ImageProperties modifyX(double x) {
        return new ImageProperties(x / main.WR, y / main.HR, width / main.WR, height / main.HR);
    }

    /**
     * Return a new <code>ImageProperties</code> object with the attributes of the original object upon which this
     * method is called. The y attribute will be replaced with the value given to the method.
     * @param y The new y value
     * @return The newly created <code>ImageProperties</code> object
     */
    public ImageProperties modifyY(double y) {
        return new ImageProperties(x / main.WR, y / main.HR, width / main.WR, height / main.HR);
    }

    /**
     * Return a new <code>ImageProperties</code> object with the attributes of the original object upon which this
     * method is called. The width attribute will be replaced with the value given to the method.
     * @param width The new width value
     * @return The newly created <code>ImageProperties</code> object
     */
    public ImageProperties modifyWidth(double width) {
        return new ImageProperties(x / main.WR, y / main.HR, width / main.WR, height / main.HR);
    }

    /**
     * Return a new <code>ImageProperties</code> object with the attributes of the original object upon which this
     * method is called. The height attribute will be replaced with the value given to the method.
     * @param height The new height value
     * @return The newly created <code>ImageProperties</code> object
     */
    public ImageProperties modifyHeight(double height) {
        return new ImageProperties(x / main.WR, y / main.HR, width / main.WR, height / main.HR);
    }
}
