package wisniowa.tc;

import wisniowa.tc.characters.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    //public int x = 100;
    private Team team;
    public GamePanel(Team team) {
        //System.out.println(team.getMembers().length);//2
        this.team = team;
        setFocusable(true);
        addKeyListener(new GameKeyListener());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawString("hello world", x, 100);
        //g.drawString("WISNIOWA", x, 200);
        //Image img = new ImageIcon("static/images/warrior/1.png").getImage();
        //System.out.println(team.getMembers().length);//length of null?
        for (Player player : team.getMembers()) {
            g.drawImage(player.getBaseImage(), player.getX(), player.getY(), this);
        }
    }
    public class GameKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_RIGHT) {
                for (Player player : team.getMembers()) {
                    player.setX(player.getX() + 20);
                }
            } else {
                for (Player player : team.getMembers()) {
                    player.setX(player.getX() - 20);
                }
            }
            repaint();
        }
    }
}
