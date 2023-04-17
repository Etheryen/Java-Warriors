package wisniowa.tc.characters;

import wisniowa.tc.Constants;

public class Mag extends Player {
    private boolean duringTeleport;

    public Mag(String name, int x, int y) {
        super(name, x, y);
        this.duringTeleport = false;
    }

    public boolean isDuringTeleport() {
        return this.duringTeleport;
    }
    public void startTeleport() {
        this.duringTeleport = true;
    }
    public void finishTeleport(int x, int y) {
        this.setX(x - Constants.PLAYER_IMG_WIDTH / 2);
        this.setY(y - Constants.PLAYER_IMG_HEIGHT / 2);
        this.duringTeleport = false;
    }
}
