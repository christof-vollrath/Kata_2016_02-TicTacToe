/** Just check if the oponent can reach a line with one move and block it*/
public class DefensiveStrategy extends DeterministicStrategy implements Strategy {

    public Move nextMove(Player mark, Board board) {
        Player oponent = Game.switchPlayer(mark);
        Move move = TicTacToe.findWiningMove(oponent, board);
        if (move != null) return move;
        return super.nextMove(mark, board);
    }

}
