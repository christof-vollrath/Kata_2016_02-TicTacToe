import java.util.List;

public class OptimalStrategy implements Strategy {

    @Override
    public Move nextMove(Player mark, Board board) {
        List<Move> possibleMoves = board.getPossibleMoves();
        if (possibleMoves.isEmpty()) return null;
        for (Move move: possibleMoves) {
            if (TicTacToe.isWinningMove(move, mark, board)) return move;
        }
        Player oponent = Game.switchPlayer(mark);
        Move neutralMove = null;
        for (Move move: possibleMoves) {
            Board nextState = new Board(board);
            nextState.set(move, mark);
            Player lookAheadResult = lookAhead(oponent, nextState);
            if (lookAheadResult == mark) return move;
//            if (lookAheadResult == null && neutralMove != null) neutralMove = move;
            if (lookAheadResult == null) neutralMove = move;
        }
        if (neutralMove != null) return neutralMove;
        return possibleMoves.get(0);
    }

    Player lookAhead(Player player, Board board) {
        List<Move> moves = board.getPossibleMoves();
        if (moves.isEmpty()) return null;
        Player otherPlayer = Game.switchPlayer(player);
        boolean otherPlayerWinsEveryLookAhead2 = true;
        for (Move move: moves) {
            Board nextState = new Board(board);
            nextState.set(move, player);
            if (nextState.checkLines(player)) return player;
            Player nextLookAheadWinner = lookAhead(otherPlayer, nextState);
            if (nextLookAheadWinner != otherPlayer) otherPlayerWinsEveryLookAhead2 = false;
        }
        return otherPlayerWinsEveryLookAhead2 ? otherPlayer : null;
    }
}
