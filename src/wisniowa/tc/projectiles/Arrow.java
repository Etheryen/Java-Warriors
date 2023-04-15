package wisniowa.tc.projectiles;

import wisniowa.tc.EffectsImages;
import wisniowa.tc.characters.Archer;

public class Arrow extends Projectile {
    private Archer attacker;
    private int targetX, targetY, originalX, originalY, speed;
    public Arrow(int id, int x, int y, Archer attacker, int targetX, int targetY) {
        super(id, x, y);
        this.attacker = attacker;
        this.setBaseImage(EffectsImages.ARROW);
        this.targetX = targetX;
        this.targetY = targetY;
        this.originalX = x;
        this.originalY = y;
        this.speed = 40;
    }

    public Archer getAttacker() {
        return attacker;
    }

    public void setNewPositionByX(int x) {
        this.setX(x);
        int newY = originalY + ((targetY - originalY) / (targetX - originalX)) * (x - originalX); // calculate trajectory
        System.out.println(newY);
        this.setY(newY);
    }

    public int getSpeed() {
        return speed;
    }
}
