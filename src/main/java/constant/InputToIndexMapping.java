package constant;

public enum InputToIndexMapping {
    A("0"),
    B("1"),
    C("2"),
    D("3"),
    E("4"),
    F("5"),
    G("6"),
    H("7");

    private String index;

    InputToIndexMapping(String index) {
        this.index = index;
    }

    public String getIndex() {
        return this.index;
    }
}
