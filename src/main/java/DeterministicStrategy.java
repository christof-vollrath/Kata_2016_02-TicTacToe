import java.util.List;

/** Just place mark on the next free position */
public class DeterministicStrategy implements Strategy {

    public Move nextMove(Player mark, Board board) {
        List<Move> possibleMoves = board.getPossibleMoves();
        if (possibleMoves.isEmpty()) return null;
        return possibleMoves.get(0);
    }
}
