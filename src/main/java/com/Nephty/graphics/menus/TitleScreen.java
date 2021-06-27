package com.Nephty.graphics.menus;

import com.Nephty.graphics.Button;
import com.Nephty.graphics.Image;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;

/**
 * A <code>Main</code> is a user interface and is the first UI displayed when the game is launched.
 * It contains a "Play" button that shows a "Campaign", "Tutorial" and "Freeplay" button. The first button
 * allows the user to play on the campaign levels, the second button shows the tutorial to the user and the third
 * button allows the user to play on the freeplay levels. It also contains the "Options" button that opens the options
 * menu and a "Quit" button that closes the game.
 */
public class TitleScreen
        extends AbstractMenu {

    private Button playButton, optionsButton, quitButton;
    private Image background;
    private static Stage window;

    /**
     * Create a new <code>MainMenu</code> object and prepare its attributes
     * @param parent The main <code>Pane</code> that we will be using to store the content. This pane should (but it's not
     *                mandatory) be the size of the window in order to be able to display content anywhere on
     *                the said window.
     * @param width The width of the menu (preferably the size of the window)
     * @param height The height of the menu (preferably the size of the window)
     * @param window_ The window containing everything
     * @param background The background that will be displayed for the menu
     */
    public TitleScreen(Parent parent, double width, double height, Stage window_, Image background) {
        super(parent, width, height, background);
        window = window_;
        this.background = background;
        setButtons();
        prepareButtonsActions();
    }

    /**
     * Prepare the "Play", "Options", "Quit" buttons.
     * The <code>EventHandlers</code> are not set here.
     */
    private void setButtons() {
        Dimension dimension = resolutionIDToDimension();

        if (dimension.width == getScreenDimension().width) {
            fullscreen = true;
        }

        this.playButton = new Button(
                ((ORIGINAL_WIDTH/2)-(480/2)),
                ((ORIGINAL_HEIGHT/2)+25-96-25),
                "play button.png");
        this.optionsButton = new Button(
                ((ORIGINAL_WIDTH/2)-(480/2)),
                ((ORIGINAL_HEIGHT/2)+25),
                "options button.png");
        this.quitButton = new Button(
                ((ORIGINAL_WIDTH/2)-(480/2)),
                ((ORIGINAL_HEIGHT/2)+25+96+25+96+25),
                "quit button.png");
    }


    /**
     * Prepare the <code>EventHandlers</code> for the buttons and their overlays according to their respective function.
     */
    private void prepareButtonsActions() {
        this.playButton.overlay.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            // TODO : fill
        });
    }
}

