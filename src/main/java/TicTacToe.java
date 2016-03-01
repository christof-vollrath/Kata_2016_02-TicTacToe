public class TicTacToe {
    public int SIZE = 3;

    public boolean isFull() {
        for (int y = 0; y < SIZE; y++)
            for (int x = 0; x < SIZE; x++)
                if (board[x][y] == Mark.EMPTY) return false;
        return true;
    }

    public boolean checkLines(Mark mark) {
        // x lines
        for (int y = 0; y < SIZE; y++)
            if (checkLine(0, y, 1, 0, mark)) return true;
        // y lines
        for (int x = 0; x < SIZE; x++)
            if (checkLine(x, 0, 0, 1, mark)) return true;
        return false;
    }

    public boolean checkLine(int startX, int startY, int incX, int incY, Mark mark) {
        int x = 0, y = 0;
        for (int i = 0; i < SIZE; i++) {
            if (board[x+startX][y+startY] != mark) return false;
            x += incX; y += incY;
        }
        return true;
    }

    public enum Mark { EMPTY(" "), X("x"), O("o");
        private final String s;
        Mark(String s) { this.s = s;}
        @Override public String toString() { return s; }
    }
    Mark[][] board = new Mark[SIZE][SIZE];
    {
        for (int y = 0; y < SIZE; y++)
            for (int x = 0; x < SIZE; x++)
                board[x][y] = Mark.EMPTY;
    }

    public void set(int x, int y, Mark mark) {
        if (board[x][y] != Mark.EMPTY) throw new IllegalStateException();
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
