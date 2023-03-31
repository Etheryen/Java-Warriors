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
            g.drawString(player.getName(), player.getX(), player.getY() + Constants.PLAYER_IMG_HEIGHT + 15);
            if (player == team.getActiveMember()) {
                g.drawImage(EffectsImages.ACTIVE_MEMBER, player.getX(), player.getY(), this);
            }
        }
    }
    public class GameKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            Player player;
            super.keyPressed(e);
            int key = e.getKeyCode();

            switch (key) {
                case KeyEvent.VK_RIGHT:
                    player = team.getActiveMember();
                    player.setX(player.getX() + 20);
                    break;
                case KeyEvent.VK_LEFT:
                    player = team.getActiveMember();
                    player.setX(player.getX() - 20);
                    break;
                case KeyEvent.VK_UP:
                    player = team.getActiveMember();
                    player.setY(player.getY() - 20);
                    break;
                case KeyEvent.VK_DOWN:
                    player = team.getActiveMember();
                    player.setY(player.getY() + 20);
                    break;
                case KeyEvent.VK_SPACE:
                    team.switchActiveMember();
                    break;
            }
            repaint();
        }
    }
}
