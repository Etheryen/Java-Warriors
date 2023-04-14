package wisniowa.tc.characters;
import wisniowa.tc.Constants;

import javax.swing.*;
import java.awt.*;

public abstract class Player {
    private String name;
    private int x, y, damage, healthPoints;// = 100;
    protected Image baseImage;// default musi byc!!!!
    private int goLeftKey;
    private int goRightKey;
    private int goUpKey;
    private int goDownKey;
    private int attackLeftKey;
    private int attackRightKey;
    private boolean duringTeleport;

    public Player(String name, int x, int y, int goLeftKey, int goRightKey, int goUpKey, int goDownKey, int attackLeftKey, int attackRightKey) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.goLeftKey = goLeftKey;
        this.goRightKey = goRightKey;
        this.goUpKey = goUpKey;
        this.goDownKey = goDownKey;
        this.attackLeftKey = attackLeftKey;
        this.attackRightKey = attackRightKey;
        this.baseImage = new ImageIcon(Constants.IMAGES_FOLDER + this.getClass().getSimpleName() + "/1.png").getImage();
    }

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

    public boolean isDuringTeleport(){return false;}
    public void setDuringTeleport(boolean duringTeleport){}

    public Mag getTeleportingMag() {
        return new Mag("placeholder", -999, -999);
    }
}
