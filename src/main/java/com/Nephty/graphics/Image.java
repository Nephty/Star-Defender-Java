package com.Nephty.graphics;

import com.Nephty.body.FileGetter;
import com.Nephty.body.FileMatcher;
import com.Nephty.graphics.properties.ImageProperties;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

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
    private String imageKey;
    private String fileName;

    /**
     * Create a new <code>Image</code> that can be interacted with. The buttons has an image that can be of any size to
     * make it fully customizable.
     * @param properties <code>ImageProperties</code> to use for the image.
     * @param key The key to use in the file matcher to get the proper texture
     */
    public Image(ImageProperties properties, String key) {
        super(properties.x, properties.y, properties.width, properties.height);
        try {
            this.properties = properties;
            setProperties();
            imageKey = key;
            fileName = FileMatcher.getFileName(imageKey);
            FileInputStream inputStream = new FileInputStream(FileGetter.directory("img") + fileName);
            image = new javafx.scene.image.Image(inputStream);
            this.setFill(new ImagePattern(this.image));
        } catch (FileNotFoundException e) {
            AlertBox.display("Fatal error", "A .png file could not be found. Check if no file is missing.\n" +
                    "Check if the names have not been changed or if any file has not been deleted.\n" +
                    "You can run the FileIntegrity checker for further information.\n Missing file : " + fileName + ".");
            System.exit(-1);
        }
    }

    public void setProperties() {
        setX(properties.x);
        setY(properties.y);
        setWidth(properties.width);
        setHeight(properties.height);
    }
}
