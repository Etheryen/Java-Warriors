package wisniowa.tc;

import wisniowa.tc.characters.Archer;
import wisniowa.tc.characters.Warrior;

import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {
        Team team = new Team(
                new Warrior("Aragorn", 50, 50),
                new Archer("Legolas1", 200, 200),
                new Archer("Legolas2", 300, 300)
        );

        MainWindow mw = new MainWindow(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, team);
    }
}
