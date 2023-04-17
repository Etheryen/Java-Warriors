package wisniowa.tc;

public abstract class IdGen {
    private static int currId = 0;
    public static int getId() {
        currId++;
        return currId;
    }
}
