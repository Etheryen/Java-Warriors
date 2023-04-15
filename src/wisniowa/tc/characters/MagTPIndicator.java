package wisniowa.tc.characters;

public class MagTPIndicator extends Player {
    Mag teleportingMag;

    public Mag getTeleportingMag() {
        return teleportingMag;
    }

    public MagTPIndicator(String name, int x, int y, Mag teleportingMag) {
        super(name, x, y);
        this.teleportingMag = teleportingMag;
    }

    public void basicAttack() {

    }
}
