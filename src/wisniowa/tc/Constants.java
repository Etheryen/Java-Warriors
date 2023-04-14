package wisniowa.tc;

public abstract class Constants {
    public static final int WINDOW_HEIGHT = 600;
    public static final int WINDOW_WIDTH = 1000;
    public static final int PLAYER_IMG_HEIGHT = 80;
    public static final int PLAYER_IMG_WIDTH = 40;
    public static final int MAX_LEFT_POSITION = 0;
    public static final int MAX_RIGHT_POSITION = WINDOW_WIDTH - PLAYER_IMG_WIDTH;
    public static final int MAX_TOP_POSITION = 0;
    public static final int MAX_BOTTOM_POSITION = WINDOW_HEIGHT - PLAYER_IMG_HEIGHT;

    public static final int MS= 20; // movement speed

    public static final String STATIC_FOLDER = "static/";
    public static final String IMAGES_FOLDER = STATIC_FOLDER + "images/";
}
