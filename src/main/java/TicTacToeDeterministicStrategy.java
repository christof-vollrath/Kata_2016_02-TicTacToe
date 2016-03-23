import java.util.List;

public class TicTacToeDeterministicStrategy {

    public Move nextMove(TicTacToe ticTacToe) {
        List<Move> possibleMoves = ticTacToe.getPossibleMoves();
        if (possibleMoves.isEmpty()) return null;
        return possibleMoves.get(0);
    }
}
