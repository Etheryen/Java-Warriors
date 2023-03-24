package wisniowa.tc.arenas;

import wisniowa.tc.Team;

public interface IArena {
    boolean open(Team team);
    void close();
}
