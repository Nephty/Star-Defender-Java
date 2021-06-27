package com.Nephty.graphics;

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
     * @param x The X position of the button in its container
     * @param y The Y position of the button in its container
     * @param fileName The name of the image file that will be used to display the button
     */
    public Button(int x, int y, String fileName) {
        super(x, y, fileName);

        this.overlay = new Image(x, y, "button overlay.png");
        this.overlay.setVisible(false);

        this.setOnMouseEntered(e -> this.overlay.setVisible(true));
        this.overlay.setOnMouseExited(e -> this.overlay.setVisible(false));
    }

    /**
     * Create a new Button that can be interacted with. The buttons has an image that can be of any size to
     * make it fully customizable.
     * @param x The X position of the button in its container
     * @param y The Y position of the button in its container
     * @param fileName The name of the image file that will be used to display the button
     * @param small A byte that can be 0 or 1. If it's 0, the constructor creates a small button.
     *              If it's 1, the constructor creates a slightly larger button, but not a regular one.
     */
    public Button(int x, int y, String fileName, byte small) {
        super(x, y, fileName);

        String localFileName = "button overlay.png";

        if (small == 0) {
            localFileName = "small overlay.png";
        } else if (small == 1) {
            localFileName = "small larger overlay.png";
        }

        this.overlay = new Image(x, y, localFileName);
        this.overlay.setVisible(false);

        this.setOnMouseEntered(e -> this.overlay.setVisible(true));
        this.overlay.setOnMouseExited(e -> this.overlay.setVisible(false));
    }
}
