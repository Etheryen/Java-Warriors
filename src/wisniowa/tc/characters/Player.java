package wisniowa.tc.characters;
import wisniowa.tc.Constants;
import wisniowa.tc.EffectsImages;

import javax.swing.*;
import java.awt.*;

public abstract class Player {
    private String name;
    private int x, y;
    private int damage = 17, healthPoints = 100;
    protected Image baseImage = EffectsImages.MISSING;// default musi byc!!!!

    public Player(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        System.out.println("static/images/" + this.getClass().getSimpleName() + "/1.png");
        this.baseImage = new ImageIcon(Constants.IMAGES_FOLDER + this.getClass().getSimpleName() + "/1.png").getImage();
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getBaseImage() {
        return baseImage;
    }

    public void setX(int x) {
        if (x > Constants.MAX_RIGHT_POSITION) {
            this.x = Constants.MAX_RIGHT_POSITION;
            return;
        }
        if (x < Constants.MAX_LEFT_POSITION) {
            this.x = Constants.MAX_LEFT_POSITION;
            return;
        }
        this.x = x;
    }

    public void setY(int y) {
        if (y < Constants.MAX_TOP_POSITION) {
            this.y = Constants.MAX_TOP_POSITION;
            return;
        }
        if (y > Constants.MAX_BOTTOM_POSITION) {
            this.y = Constants.MAX_BOTTOM_POSITION;
            return;
        }
        this.y = y;
    }
}
