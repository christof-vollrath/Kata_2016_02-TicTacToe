/** Just check if we can reach a line with one move */
public class SimpleStrategy extends DeterministicStrategy implements Strategy {

    public Move nextMove(Player mark, Board board) {
        Move move = TicTacToe.findWiningMove(mark, board);
        if (move != null) return move;
        return super.nextMove(mark, board);
    }

}
