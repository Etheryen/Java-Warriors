package wisniowa.tc;

import wisniowa.tc.characters.Archer;
import wisniowa.tc.characters.Player;
import wisniowa.tc.characters.Mag;
import wisniowa.tc.projectiles.Arrow;
import wisniowa.tc.projectiles.Projectile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {
    //public int x = 100;
    private final Team team;
    private ArrayList<Projectile> projectiles = new ArrayList<>();
    private final IdGen idGen = new IdGen();

    private Timer timer = new Timer(250, this);
    public GamePanel(Team team) {
        //System.out.println(team.getMembers().length);//2
        this.team = team;
        setFocusable(true);
        addKeyListener(new GameKeyListener());
        addMouseListener(new GameKeyListener());
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer){
            handleProjectiles();
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawString("hello world", x, 100);
        //g.drawString("WISNIOWA", x, 200);
        //Image img = new ImageIcon("static/images/warrior/1.png").getImage();
        //System.out.println(this.team.getMembers().length);//length of null?
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

        for (Projectile projectile : projectiles) {
            g.drawImage(projectile.getBaseImage(), projectile.getX(), projectile.getY(), this);
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
                case KeyEvent.VK_SPACE -> handlePlayerSwitch(player, playerClass);
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

    private void handlePlayerSwitch(Player player, String playerClass) {
        if (!playerClass.equals("Mag")) {
            team.switchActiveMember();
            return;
        }

        Mag mag = (Mag) player;
        if (!mag.isDuringTeleport()) {
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
        if (playerClass.equals("Archer")) {
            Archer archer = (Archer) player;
            archer.basicAttack();
            projectiles.add(new Arrow(
                    idGen.getId(),
                    archer.getX() + Constants.PLAYER_IMG_WIDTH / 2,
                    archer.getY() + Constants.PLAYER_IMG_HEIGHT / 2,
                    archer,
                    e.getX(),
                    e.getY()
            ));
            System.out.println(projectiles);
        }
    }

    private void handleProjectiles() {
        ArrayList<Projectile> outOfScreen = new ArrayList<>();
        for (Projectile projectile: projectiles) {
            if (projectile.getClass().getSimpleName().equals("Arrow")) {
                Arrow arrow = (Arrow) projectile;
                arrow.setNewPositionByX(arrow.getX() + arrow.getSpeed());
            }
            if (projectile.getX() > Constants.WINDOW_WIDTH || projectile.getY() > Constants.WINDOW_HEIGHT) {
                outOfScreen.add(projectile);
            }
        }
        projectiles.removeAll(outOfScreen);
    }
}
