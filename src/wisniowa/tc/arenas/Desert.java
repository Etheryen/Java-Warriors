package wisniowa.tc.arenas;

import wisniowa.tc.Team;

public class Desert implements IArena {
    boolean isOpened = false;
    @Override
    public boolean open(Team team) {
        if (team.getMembers().length > 0) {
            isOpened = true;
            System.out.println("Welcome players!");
        } else {
            isOpened = false;
            System.out.println("Not enough party members");
        }
        return isOpened;
    }

    @Override
    public void close() {
        isOpened = false;
    }
}
