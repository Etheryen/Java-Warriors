package wisniowa.tc;

import wisniowa.tc.characters.Archer;
import wisniowa.tc.characters.Mag;
import wisniowa.tc.characters.Warrior;

import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {
        Team team = new Team(
                new Mag("Gandalf", 300, 300),
                new Archer("Legolas", 500, 500)
        );

        MainWindow mw = new MainWindow(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, team);
    }
}
