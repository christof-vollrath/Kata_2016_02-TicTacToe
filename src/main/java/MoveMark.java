public class MoveMark {
    private final TicTacToe.Mark mark;
    private final Move move;

    public MoveMark(TicTacToe.Mark mark, Move move) {
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

    public TicTacToe.Mark getMark() {
        return mark;
    }

    public Move getMove() {
        return move;
    }
}
