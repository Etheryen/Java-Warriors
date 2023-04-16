package wisniowa.tc.projectiles;

import wisniowa.tc.EffectsImages;
import wisniowa.tc.characters.Archer;

public class Arrow extends Projectile {
    private Archer attacker;
    private int targetX, targetY, originalX, originalY, speed, sinus;
    private boolean forwards;
    public Arrow(int id, int x, int y, Archer attacker, int targetX, int targetY) {
        super(id, x, y);
        this.attacker = attacker;
        this.setBaseImage(EffectsImages.ARROW);
        this.targetX = targetX;
        this.targetY = targetY;
        this.originalX = x;
        this.originalY = y;
        this.speed = 10;
        this.sinus = (targetY - originalY) / speed;
        this.forwards = targetX > originalX;
    }

    public Archer getAttacker() {
        return attacker;
    }

    public void setNewPosition() {
//        int newX =
//        this.setX(newX);
//        int newY = originalY + ((targetY - originalY) / (targetX - originalX)) * (newX - originalX);
//        this.setY(newY);
        System.out.println(sinus + " " + forwards);
    }

    public int getSpeed() {
        return speed;
    }
}
