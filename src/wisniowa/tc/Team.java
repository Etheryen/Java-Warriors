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

    public void addMemberAndSetActive(Player newMember) {
        Player[] newTeam = new Player[teamMembers.length + 1];
        for (int i = 0; i < this.teamMembers.length; i++) {
            newTeam[i] = this.teamMembers[i];
        }
        newTeam[teamMembers.length] = newMember;
        this.teamMembers = newTeam;
        this.activeMemberIndex = teamMembers.length - 1;
    }

    public void popMemberAndSetActive(Player player) {
        Player[] newTeam = new Player[teamMembers.length - 1];
        for (int i = 0; i < this.teamMembers.length - 1; i++) {
            newTeam[i] = this.teamMembers[i];
        }
        this.teamMembers = newTeam;
        for (int i = 0; i < this.teamMembers.length; i++) {
            if (this.teamMembers[i].equals(player)) {
                this.activeMemberIndex = i;
                return;
            }
        }
    }
}
