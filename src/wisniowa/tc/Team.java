package wisniowa.tc;

import wisniowa.tc.characters.Player;

public class Team {
    private Player[] teamMembers;
    public Team(Player... teamMembers) {
        this.teamMembers = teamMembers;
    }

    public Player[] getMembers() {
        return teamMembers;
    }
}
