package wisniowa.tc.projectiles;

import wisniowa.tc.Constants;
import wisniowa.tc.EffectsImages;
import wisniowa.tc.IdGen;
import wisniowa.tc.characters.Player;

import javax.swing.*;
import java.awt.*;

public class Projectile {
    private int id, x, y;
    private Image baseImage = EffectsImages.MISSING;

    public Projectile(int x, int y) {
        this.id = IdGen.getId();
        this.x = x;
        this.y = y;
        this.baseImage = new ImageIcon(Constants.IMAGES_FOLDER + "effects/" + this.getClass().getSimpleName() + ".png").getImage();
    }

    @Override
    public String toString() {
        return "Projectile{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", class=" + this.getClass().getSimpleName() +
                '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getBaseImage() {
        return this.baseImage;
    }
}
