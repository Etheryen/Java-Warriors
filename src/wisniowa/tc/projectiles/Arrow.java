package wisniowa.tc.projectiles;

import wisniowa.tc.EffectsImages;
import wisniowa.tc.characters.Archer;

public class Arrow extends Projectile {
    private Archer attacker;
    private int targetX, targetY, originalX, originalY;
    private int speed;
    public Arrow(int x, int y, Archer attacker, int targetX, int targetY) {
        super(x, y);
        this.attacker = attacker;
        this.targetX = targetX;
        this.targetY = targetY;
        this.originalX = x;
        this.originalY = y;
        this.speed = 10;
    }

    public Archer getAttacker() {
        return attacker;
    }

    public void setNewPosition() {
        int deltaX = targetX - originalX;
        int deltaY = targetY - originalY;
        double direction = Math.atan2(deltaY, deltaX);
        int xInc = (int) Math.round(speed * Math.cos(direction));
        int yInc = (int) Math.round(speed * Math.sin(direction));
        this.setX(this.getX() + xInc);
        this.setY(this.getY() + yInc);
    }

    public int getSpeed() {
        return speed;
    }
}
