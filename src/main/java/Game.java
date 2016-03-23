import java.util.LinkedList;
import java.util.List;

public class Game {
    private final TicTacToeDeterministicStrategy strategyX;
    private final TicTacToeDeterministicStrategy strategyO;
    TicTacToe ticTacToe = new TicTacToe();
    TicTacToe.Mark currentPlayer = TicTacToe.Mark.X;
    List<MoveMark> moves = new LinkedList<>();


    public Game(TicTacToeDeterministicStrategy strategyX, TicTacToeDeterministicStrategy strategyO) {
        this.strategyX = strategyX;
        this.strategyO = strategyO;
    }

    public void play() {
        for(;;) {
            MoveMark moveMark;
            if (currentPlayer == TicTacToe.Mark.X) {
                Move nextMove = strategyX.nextMove(ticTacToe);
                if (nextMove == null) return;
                moveMark = new MoveMark(TicTacToe.Mark.X, nextMove);
            } else {
                Move nextMove = strategyO.nextMove(ticTacToe);
                if (nextMove == null) return;
                moveMark = new MoveMark(TicTacToe.Mark.O, nextMove);
            }

            ticTacToe.set(moveMark);
            moves.add(moveMark);
            System.out.println(moveMark);
            System.out.println(ticTacToe);
            TicTacToe.Mark winner = ticTacToe.getWinner();
            if (winner != null) return;
            switchPlayer();
        }
    }

    public List<MoveMark> getMoves() {
        return moves;
    }

    public TicTacToe getEndPosition() {
        return ticTacToe;
    }

    void switchPlayer() {
        if (currentPlayer == TicTacToe.Mark.X) currentPlayer = TicTacToe.Mark.O;
        else currentPlayer = TicTacToe.Mark.X;
    }
}
