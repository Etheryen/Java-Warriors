package wisniowa.tc.characters;

public class Mag extends Player {
    private boolean duringTeleport;

    public Mag(String name, int x, int y) {
        super(name, x, y);
        duringTeleport = false;
    }

    public boolean isDuringTeleport() {
        return this.duringTeleport;
    }
    public void setDuringTeleport(boolean duringTeleport) {
        this.duringTeleport = duringTeleport;
    }

    public void basicAttack() {

    }
}
