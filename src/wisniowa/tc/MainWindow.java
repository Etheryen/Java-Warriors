package wisniowa.tc;
import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow(int width, int height, Team team) {
        setSize(width, height);
        setResizable(false);
        add(new GamePanel(team));
        setVisible(true);
    }
}
