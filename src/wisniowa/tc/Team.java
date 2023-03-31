package wisniowa.tc;

import wisniowa.tc.characters.Player;

public class Team {
    private Player[] teamMembers;
    private int activeMemberIndex;

    public Team(Player... teamMembers) {
        this.teamMembers = teamMembers;
        this.activeMemberIndex = 0;
    }

    public void switchActiveMember() {
        setActiveMemberIndex((activeMemberIndex + 1) % teamMembers.length);
    }

    public Player[] getMembers() {
        return teamMembers;
    }

    public Player getActiveMember() {
        return teamMembers[activeMemberIndex];
    }

    public void setActiveMemberIndex(int activeMemberIndex) {
        this.activeMemberIndex = activeMemberIndex;
    }
}
