package com.Nephty.graphics.menus;

import com.Nephty.graphics.Button;
import com.Nephty.graphics.Image;
import com.Nephty.graphics.properties.ImageProperties;
import com.Nephty.main;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.util.ArrayList;

/**
 * A <code>Main</code> is a user interface and is the first UI displayed when the game is launched.
 * It contains a "Play" button that shows a "Campaign", "Tutorial" and "Freeplay" button. The first button
 * allows the user to play on the campaign levels, the second button shows the tutorial to the user and the third
 * button allows the user to play on the freeplay levels. It also contains the "Options" button that opens the options
 * menu and a "Quit" button that closes the game.
 */
@SuppressWarnings("IntegerDivisionInFloatingPointContext")
public class TitleScreen
        extends AbstractMenu {

    public final static Pane pane = new Pane();

    private final static float buttonWidth = 600F;
    private final static float buttonHeight = 120F;
    private final static float buttonX = (main.ORIGINAL_WIDTH / 2) - (buttonWidth / 2);
    private final static float buttonY = main.ORIGINAL_HEIGHT / 2 - 200;
    private final static float buttonSpacing = 140F;

    // 140 pixels of spacing between buttons
    public final static Button playButton = new Button(
            new ImageProperties(buttonX, buttonY, buttonWidth, buttonHeight),
            "titlescreen.buttons.playbutton");
    public final static Button optionsButton = new Button(
            new ImageProperties(buttonX, buttonY + buttonSpacing, buttonWidth, buttonHeight),
            "titlescreen.buttons.optionsbutton");
    public final static Button achievementsButton = new Button(
            new ImageProperties(buttonX, buttonY + 2 * buttonSpacing, buttonWidth, buttonHeight),
            "titlescreen.buttons.achievementsbutton");
    public final static Button statisticsButton = new Button(
            new ImageProperties(buttonX, buttonY + 3 * buttonSpacing, buttonWidth, buttonHeight),
            "titlescreen.buttons.statisticsbutton");
    public final static Button quitButton = new Button(
            new ImageProperties(buttonX, buttonY + 4 * buttonSpacing, buttonWidth, buttonHeight),
            "titlescreen.buttons.quitbutton");
    public final static Image background = new Image(new ImageProperties(0, 0, main.ORIGINAL_WIDTH, main.ORIGINAL_HEIGHT),
            "titlescreen.background");

    /**
     * Create a new <code>MainMenu</code> object and prepare its attributes
     */
    public TitleScreen() {
        super(pane, main.windowWidth, main.windowHeight, background);

        setImages();
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
    }

    /**
     * Prepare the images that will be contained in the title screen pane
     */
    private void setImages() {
        // TODO : this is a working version. The commented code is the issue.
        TitleScreen.pane.getChildren().add(TitleScreen.background);

        /*
        Media media = new Media(new File(FileGetter.directory("img").concat("Animated Titlescreen Background.mp4")).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        MediaView mediaView = new MediaView(mediaPlayer);

        TitleScreen.pane.getChildren().addAll(mediaView);
         */

        addAllWithOverlay(playButton.getWithOverlay(),
                optionsButton.getWithOverlay(),
                achievementsButton.getWithOverlay(),
                statisticsButton.getWithOverlay(),
                quitButton.getWithOverlay());
    }

    /**
     * For every <code>ArrayList</code> given in argument, add every <code>Node</code> contained in the
     * pane of the Titlescreen.
     * @param Element Multiple <code>ArrayList</code> containing the <code>Node</code> to add to the pane
     */
    @SafeVarargs
    private static void addAllWithOverlay(ArrayList<Node>... Element) {
        for (ArrayList<Node> arrayList : Element) {
            for (Node element : arrayList) {
                TitleScreen.pane.getChildren().add(element);
            }
        }
    }


    /**
     * Prepare the <code>EventHandlers</code> for the buttons and their overlays according to their respective function.
     */
    private void prepareButtonsActions() {
        playButton.overlay.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            // TODO : fill
        });
    }
}

