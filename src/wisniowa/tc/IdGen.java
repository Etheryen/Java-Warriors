package wisniowa.tc;

public class IdGen {
    private int currId;

    public IdGen() {
        this.currId = 0;
    }

    public int getId() {
        this.currId++;
        return currId;
    }
}
