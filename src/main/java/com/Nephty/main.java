package com.Nephty;

import com.Nephty.audio.AudioPlayer;
import com.Nephty.body.JSONReader;
import com.Nephty.exceptions.JSONValueException;
import com.Nephty.graphics.AlertBox;
import com.Nephty.graphics.ConfirmBox;
import com.Nephty.graphics.Console;
import com.Nephty.graphics.menus.TitleScreen;
import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.*;

/**
 * The <code>Main</code> class is the class that will be executed when running the program.
 */
public class main extends Application {

    public static AudioPlayer musicPlayer;
    public static AudioPlayer soundEffectPlayer;

    Stage window;

    public static final String SEPARATOR = getFileDestination();

    static final int windowX = 0;
    static final int windowY = 0;
    public static float windowWidth = 0;
    public static float windowHeight = 0;

    public static final int ORIGINAL_WIDTH = 2560;
    public static final int ORIGINAL_HEIGHT = 1440;
    public static float WR, HR;
    static byte RESOLUTION_ID;

    public static boolean fullscreen = false;

    /**
     * The main method that will be ran when starting the game.
     * @param primaryStage The window that will contain almost all the content
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            window = primaryStage;

            prepareResolution(window);

            TitleScreen titleScreen = new TitleScreen();

            Console.prepare();

            window.setScene(titleScreen);

            window.show();

        } catch (Exception e2) {
            AlertBox.display("Fatal Error", "An error occurred while loading the game\n");
            e2.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * Read the data.json file and get the resolution ID written in the file.
     *
     * @return The resolution ID of the selected resolution
     */
    public static byte getResolutionID() {
        JSONReader JSONDataReader = new JSONReader("data.json");
        return JSONDataReader.getByte("resolution");
    }

    /**
     * Use the Toolkit abstract class to get the resolution of the screen as a <code>Dimension</code> object.
     *
     * @return The resolution of the screen. The first attribute is the width and the second attribute is the height
     */
    public static Dimension getScreenDimension() {
        return java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    }

    /**
     * Compute the width ratio according to the width of the selected resolution and the reference width.
     *
     * @param targetWidth The desired width
     * @return The ratio between the desired width and the reference width
     */
    public static float getWidthRatio(int targetWidth) {
        return (float) targetWidth / ORIGINAL_WIDTH;
    }

    /**
     * Compute the height ratio according to the height of the selected resolution and the reference height.
     *
     * @param targetHeight The desired height
     * @return The ratio between the desired height and the reference height
     */
    public static float getHeightRatio(int targetHeight) {
        return (float) targetHeight / ORIGINAL_HEIGHT;
    }

    /**
     * Create a Dimension object with the selected resolution, sets the width and height ratio, the fullscreen
     * variable according to the selected resolution, the width, the height and the position of the window,
     * as well as its title and fullscreen mode.
     *
     * @param window The window that will be prepared
     */
    public static void prepareResolution(Stage window) throws JSONValueException {
        // Available resolutions :
        // 0 : native resolution
        // 1 : 1280x720     HD
        // 2 : 1600x900
        // 3 : 1920x1080    FHD
        // 4 : 2560x1440    WQHD
        // 5 : 3840x2160    UHD-1 (almost 4K because 4K = 4096x2160)

        Dimension dimension;

        RESOLUTION_ID = getResolutionID();
        switch (RESOLUTION_ID) {
            case 0:
                dimension = getScreenDimension();
                fullscreen = true;
                break;
            case 1:
                dimension = new Dimension(1280, 720);
                break;
            case 2:
                dimension = new Dimension(1600, 900);
                break;
            case 3:
                dimension = new Dimension(1920, 1080);
                break;
            case 4:
                dimension = new Dimension(2560, 1440);
                break;
            case 5:
                dimension = new Dimension(3840, 2160);
                break;
            case 6:
                dimension = new Dimension(640, 360);
                break;
            default:
                throw new JSONValueException("Unexpected value was found in the data.json file" +
                        " with key \"resolution\" : " + RESOLUTION_ID);
        }

        WR = getWidthRatio(dimension.width);
        HR = getHeightRatio(dimension.height);

        windowWidth = dimension.width;
        windowHeight = dimension.height;
        window.setWidth(windowWidth);
        window.setHeight(windowHeight);
        window.setX(windowX);
        window.setY(windowY);
        //window.setResizable(false);
        window.setFullScreen(fullscreen);
        window.setTitle("Star Defender");
        window.setFullScreenExitHint("");
    }


    /**
     * Safely closes the program by prompting a warning to the user and asking confirmation.
     */
    private void closeProgram() {
        boolean closeReply = ConfirmBox.display("Warning", "You're about to exit the program. Are you sure ?");
        if (closeReply) {
            window.close();
        }
    }

    /**
     * Get the os of the user and return "/" or "\".
     * @return "/" if it's Linux/MacOS and "\" if it's Windows.
     */
    public static String getFileDestination(){
        String OS = System.getProperty("os.name");
        String res;
        if (OS.startsWith("Windows")){
            res = "\\";
        } else {
            res = "/";
        }
        return res;
    }

    /**
     * The very first method on the execution pile.
     * @param args args
     */
    public static void main(String[] args) {
        launch(args);
    }
}