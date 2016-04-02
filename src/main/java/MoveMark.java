public class MoveMark {
    private final Player mark;
    private final Move move;

    public MoveMark(Player mark, Move move) {
        this.mark = mark;
        this.move = move;
    }

    @Override
    public String toString() {
        return "MoveMark{" +
                "mark=" + mark +
                ", move=" + move +
                '}';
    }

    public Player getMark() {
        return mark;
    }

    public Move getMove() {
        return move;
    }
}
