public enum Player {
    EMPTY(" "), X("x"), O("o");
    private final String s;

    Player(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}
