import java.util.LinkedList;
import java.util.List;

public class Game {
    private final Strategy strategyX;
    private final Strategy strategyO;
    Board board = new Board();
    Player currentPlayer = Player.X;
    List<MoveMark> moves = new LinkedList<>();


    public Game(Strategy strategyX, Strategy strategyO) {
        this.strategyX = strategyX;
        this.strategyO = strategyO;
    }

    public void play() {
        for(;;) {
            MoveMark moveMark;
            if (currentPlayer == Player.X) {
                Move nextMove = strategyX.nextMove(currentPlayer, board);
                if (nextMove == null) return;
                moveMark = new MoveMark(Player.X, nextMove);
            } else {
                Move nextMove = strategyO.nextMove(currentPlayer, board);
                if (nextMove == null) return;
                moveMark = new MoveMark(Player.O, nextMove);
            }

            board.set(moveMark);
            moves.add(moveMark);
            System.out.println(moveMark);
            System.out.println(board);
            Player winner = TicTacToe.getWinner(board);
            if (winner != null) return;
            currentPlayer = switchPlayer(currentPlayer);
        }
    }

    public List<MoveMark> getMoves() {
        return moves;
    }

    public Board getEndPosition() {
        return board;
    }

    public static Player switchPlayer(Player mark) {
        if (mark == Player.X) return Player.O;
        else return Player.X;
    }
}
