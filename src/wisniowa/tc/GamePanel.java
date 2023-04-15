package wisniowa.tc;

import wisniowa.tc.characters.MagTPIndicator;
import wisniowa.tc.characters.Player;
import wisniowa.tc.characters.Mag;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel {
    //public int x = 100;
    private Team team;
    public GamePanel(Team team) {
        //System.out.println(team.getMembers().length);//2
        this.team = team;
        setFocusable(true);
        addKeyListener(new GameKeyListener());
        addMouseListener(new GameKeyListener());
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
            String playerName = player.getName();
            if (player.getClass().getSimpleName().equals("Mag")) {
                Mag mag = (Mag) player;
                if (mag.isDuringTeleport()) {
                    playerName = "PRESS M1 TO TP";
                }
            }
            g.drawString(playerName, player.getX(), player.getY() + Constants.PLAYER_IMG_HEIGHT + 15);
            if (player == team.getActiveMember()) {
                g.drawImage(EffectsImages.ACTIVE_MEMBER, player.getX(), player.getY(), this);
            }
        }
    }

    public class GameKeyListener extends KeyAdapter implements MouseListener {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);

            Player player = team.getActiveMember();
            String playerClass = player.getClass().getSimpleName();
            int key = e.getKeyCode();

            switch (key) {
                case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> player.setX(player.getX() + Constants.MS);
                case KeyEvent.VK_LEFT, KeyEvent.VK_A -> player.setX(player.getX() - Constants.MS);
                case KeyEvent.VK_UP, KeyEvent.VK_W -> player.setY(player.getY() - Constants.MS);
                case KeyEvent.VK_DOWN, KeyEvent.VK_S -> player.setY(player.getY() + Constants.MS);
                case KeyEvent.VK_SPACE -> handlePlayerSwitch(playerClass);
                case KeyEvent.VK_F -> handleSpecialAbility(player);
            }
            repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            Player player = team.getActiveMember();
            String playerClass = player.getClass().getSimpleName();

            switch (e.getButton()) {
                case 1 -> handleM1(player, playerClass, e);
            }
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent arg0) { }

        @Override
        public void mouseExited(MouseEvent arg0) { }

        @Override
        public void mousePressed(MouseEvent arg0) { }

        @Override
        public void mouseReleased(MouseEvent arg0) { }
    }

    private void handleSpecialAbility(Player player) {
        player.specialAbility();
    }

    private void handlePlayerSwitch(String playerClass) {
        if (!playerClass.equals("MagTPIndicator")) {
            team.switchActiveMember();
        }
    }

    private void handleM1(Player player, String playerClass, MouseEvent e) {
        if (playerClass.equals("Mag")) {
            Mag mag = (Mag) player;
            if (mag.isDuringTeleport()) {
                mag.finishTeleport(e.getX(), e.getY());
            }
        }
        else player.basicAttack();
        repaint();
    }
}
