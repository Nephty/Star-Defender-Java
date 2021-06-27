package com.Nephty.graphics;

import com.Nephty.graphics.properties.ImageProperties;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import com.Nephty.body.FileGetter;
import com.Nephty.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * A <code>Image</code> is a <code>Rectangle</code> filled with an image found in the
 * <code>src\main\resources\img</code> directory. We can interact with it but no interface is implemented and
 * no initial method is available for interaction since this is not the purpose of the <code>Image</code>.
 * Its main role is simply to display an image from the files.
 */
public class Image
        extends Rectangle {

    private javafx.scene.image.Image image;
    public ImageProperties properties;

    /**
     * Create a new <code>Image</code> that can be interacted with. The buttons has an image that can be of any size to
     * make it fully customizable.
     * @param x The X position of the button in its container
     * @param y The Y position of the button in its container
     * @param fileName The name of the image file that will be used to display the button
     */
    public Image(int x, int y, String fileName) {
        super(x * main.WR, y * main.HR);

        try {
            FileInputStream inputStream = new FileInputStream(FileGetter.directory("img") + fileName);
            this.image = new javafx.scene.image.Image(inputStream);
            this.setFill(new ImagePattern(this.image));
            this.properties = new ImageProperties(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        } catch (FileNotFoundException e) {
            AlertBox.display("Fatal error", "A .png file could not be found. Check if no file is missing.\n" +
                    "Check if the names have not been changed or if any file has not been deleted.\n" +
                    "You can run the FileIntegrity checker for further information.\n Missing file : " + fileName + ".");
            System.exit(-1);
        }
    }

    /**
     * Create a new <code>Image</code> that can be interacted with. The buttons has an image that can be of any size to
     * make it fully customizable.
     * @param properties <code>ImageProperties</code> to use for the image.
     * @param fileName The name of the image file that will be used to display the button
     */
    public Image(ImageProperties properties, String fileName) {
        super(properties.x * main.WR, properties.y * main.HR);

        try {
            FileInputStream inputStream = new FileInputStream(FileGetter.directory("img") + fileName);
            this.image = new javafx.scene.image.Image(inputStream);
            this.setFill(new ImagePattern(this.image));
            this.properties = properties;
        } catch (FileNotFoundException e) {
            AlertBox.display("Fatal error", "A .png file could not be found. Check if no file is missing.\n" +
                    "Check if the names have not been changed or if any file has not been deleted.\n" +
                    "You can run the FileIntegrity checker for further information.\n Missing file : " + fileName + ".");
            System.exit(-1);
        }
    }
}
