package wisniowa.tc.characters;

import javax.swing.*;

public class Warrior extends Player {
    public Warrior(String name, int x, int y) {
        super(name, x, y);
        //this.baseImage = new ImageIcon("static/images/warrior/1.png").getImage();
    }

    public Warrior(String name, int x, int y, int goLeftKey, int goRightKey, int goUpKey, int goDownKey, int attackLeftKey, int attackRightKey) {
        super(name, x, y, goLeftKey, goRightKey, goUpKey, goDownKey, attackLeftKey, attackRightKey);
    }
}
