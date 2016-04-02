import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/** Tries to reach a line but without anticipating the other player */
public class BetterStrategy extends SimpleStrategy implements Strategy {

    public Move nextMove(Player mark, Board board) {
        List<Move> moves = findMoves(mark, board, 3);
        if (moves != null) return moves.get(0);
        return super.nextMove(mark, board);
    }

    private List<Move> findMoves(Player mark, Board board, int searchDepth) {
        if (searchDepth == 0) return Collections.emptyList();
        List<Move> result = new LinkedList<>();
        List<Move> possibleMoves = board.getPossibleMoves();
        List<Move> goodMoves = null;
        for (Move move: possibleMoves) {
            Board tmpBoard = new Board(board);
            tmpBoard.set(move, mark);
            if (tmpBoard.checkLines(mark)) {
                result.add(move);
                return result;
            } else {
                List<Move> additionalMoves = findMoves(mark, tmpBoard, searchDepth - 1);
                if (goodMoves == null || additionalMoves.size() + 1 < goodMoves.size()) {
                    goodMoves = new LinkedList<>();
                    goodMoves.add(move);
                    goodMoves.addAll(additionalMoves);
                }
            }
        }
        return goodMoves;
    }

}
