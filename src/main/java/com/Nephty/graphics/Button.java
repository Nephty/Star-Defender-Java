package com.Nephty.graphics;

import com.Nephty.graphics.properties.ImageProperties;
import javafx.scene.Node;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A <code>Button</code> is a <code>Image</code> filled with an image found in the
 *  <code>src\main\resources\img</code> directory. We can interact with it but no interface is implemented and
 *  no initial method is available for interaction. The difference with a <code>Image</code> is that the
 *  <code>Button</code> gets an overlay according to its size and the overlay is set up when creating a new
 *  <code>Button</code>. Warning : if we want to add a method to click on the button, we must add a new
 *  <code>EventHandler</code> on the overlay because it will be displayed on top of the <code>Button</code>.
 */
public class Button extends Image {

    public Image overlay;

    /**
     * Create a new <code>Button</code> that can be interacted with. The buttons has an image that can be of any size to
     * make it fully customizable.
     * @param properties The <code>ImageProperties</code> of the button
     * @param key The key to use in the file matcher to get the proper texture
     */
    public Button(ImageProperties properties, String key) {
        super(properties, key);

        this.overlay = new Image(properties, "buttonoverlay");
        this.overlay.setVisible(false);

        this.setOnMouseEntered(e -> this.overlay.setVisible(true));
        this.overlay.setOnMouseExited(e -> this.overlay.setVisible(false));
    }

    /**
     * Create a new Button that can be interacted with. The buttons has an image that can be of any size to
     * make it fully customizable.
     * @param properties The <code>ImageProperties</code> of the button
     * @param key The key to use in the file matcher to get the proper texture
     * @param size A byte that can be 0 or 1. If it's 0, the constructor creates a small button.
     *              If it's 1, the constructor creates a slightly larger button than the small one.
     */
    public Button(ImageProperties properties, String key, byte size) {
        super(properties, key);

        // TODO : change this to file matcher key
        String localFileName = "button overlay.png";

        if (size == 0) {
            // TODO : change this to file matcher key
            localFileName = "small overlay.png";
        } else if (size == 1) {
            // TODO : change this to file matcher key
            localFileName = "small larger overlay.png";
        }

        this.overlay = new Image(properties, localFileName);
        this.overlay.setVisible(false);

        this.setOnMouseEntered(e -> this.overlay.setVisible(true));
        this.overlay.setOnMouseExited(e -> this.overlay.setVisible(false));
    }

    /**
     * Easier adding of the image and its overlay to a <code>Pane</code>.
     * @return The image and its overlay as an <code>ArrayList</code> of <code>Node</code>
     */
    public ArrayList<Node> getWithOverlay() {
        return new ArrayList<>(Arrays.asList(this, this.overlay));
    }
}
