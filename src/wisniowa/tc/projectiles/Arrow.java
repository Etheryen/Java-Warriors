package wisniowa.tc.projectiles;

import wisniowa.tc.EffectsImages;
import wisniowa.tc.characters.Archer;

public class Arrow extends Projectile{
    private Archer attacker;
    private int targetX;
    private int targetY;
    public Arrow(int id, int x, int y, Archer attacker, int targetX, int targetY) {
        super(id, x, y);
        this.attacker = attacker;
        this.setBaseImage(EffectsImages.ARROW);
        this.targetX = targetX;
        this.targetY = targetY;
    }

    public Archer getAttacker() {
        return attacker;
    }
}
