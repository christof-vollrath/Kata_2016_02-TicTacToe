import java.util.List;

public class TicTacToe {

    public static Player getWinner(Board board) {
        if (board.checkLines(Player.X)) return Player.X;
        if (board.checkLines(Player.O)) return Player.O;
        return null;
    }

    public static Move findWiningMove(Player mark, Board board) {
        List<Move> possibleMoves = board.getPossibleMoves();
        for (Move move: possibleMoves) {
            if (isWinningMove(move, mark, board)) return move;
        }
        return null;
    }

    public static boolean isWinningMove(Move move, Player mark, Board board) {
        Board nextBoard = new Board(board);
        nextBoard.set(move, mark);
        return (nextBoard.checkLines(mark));
    }
}
