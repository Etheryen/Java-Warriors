package wisniowa.tc.characters;

import javax.swing.*;

public class Archer extends Player{
    public Archer(String name, int x, int y) {
        super(name, x, y);
        //this.baseImage = new ImageIcon("static/images/archer/1.png").getImage();
    }

    public Archer(String name, int x, int y, int goLeftKey, int goRightKey, int goUpKey, int goDownKey, int attackLeftKey, int attackRightKey) {
        super(name, x, y, goLeftKey, goRightKey, goUpKey, goDownKey, attackLeftKey, attackRightKey);
    }
}
