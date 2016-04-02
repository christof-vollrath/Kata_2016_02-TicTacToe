import java.util.ArrayList;
import java.util.List;

public class Board {
    public static int SIZE = 3;

    public Board() {}

    public Board(Board board) {
        for (int y = 0; y < SIZE; y++)
            for (int x = 0; x < SIZE; x++)
                this.board[x][y] = board.board[x][y];
    }

    public boolean isFull() {
        for (int y = 0; y < SIZE; y++)
            for (int x = 0; x < SIZE; x++)
                if (board[x][y] == Player.EMPTY) return false;
        return true;
    }

    public List<Move> getPossibleMoves() {
        List<Move> result = new ArrayList<>(SIZE*SIZE); // Use max possible size
        for (int x = 0; x < SIZE; x++)
            for (int y = 0; y < SIZE; y++)
                if (board[x][y] == Player.EMPTY) result.add(new Move(x, y));
        return result;
    }

    public boolean checkLines(Player mark) {
        // x lines (horizontal)
        for (int y = 0; y < SIZE; y++)
            if (checkLine(0, y, 1, 0, mark)) return true;
        // y lines (vertical)
        for (int x = 0; x < SIZE; x++)
            if (checkLine(x, 0, 0, 1, mark)) return true;
        // Diagonals
        if (checkLine(0, 0, 1, 1, mark)) return true;
        if (checkLine(0, 2, 1, -1, mark)) return true;
        return false;
    }

    public boolean checkLine(int startX, int startY, int incX, int incY, Player mark) {
        int x = 0, y = 0;
        for (int i = 0; i < SIZE; i++) {
            if (board[x+startX][y+startY] != mark) return false;
            x += incX; y += incY;
        }
        return true;
    }

    Player[][] board = new Player[SIZE][SIZE];
    {
        for (int y = 0; y < SIZE; y++)
            for (int x = 0; x < SIZE; x++)
                board[x][y] = Player.EMPTY;
    }

    public void set(Move move, Player mark) {
        set(move.getX(), move.getY(), mark);
    }

    public void set(MoveMark moveMark) { set(moveMark.getMove(), moveMark.getMark()); }

    public void set(int x, int y, Player mark) {
        if (board[x][y] != Player.EMPTY) throw new IllegalStateException();
        board[x][y] = mark;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++)
                result.append(board[x][y].toString());
            result.append('\n');
        }
        return result.toString();
    }
}
