package constant;

public enum ColIndexMapping {
    A("1"),
    B("2"),
    C("3"),
    D("4"),
    E("5"),
    F("6"),
    G("7"),
    H("8");

    private String index;

    ColIndexMapping(String index) {
        this.index = index;
    }

    public String getIndex() {
        return this.index;
    }
}
