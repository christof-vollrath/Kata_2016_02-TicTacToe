import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TicTacToeTest {

    @Test
    public void playDeterministicGame() {
        System.out.println("Deterministic strategy <-> Deterministic strategy");
        Strategy strategyX = new DeterministicStrategy();
        Strategy strategyO = new DeterministicStrategy();
        Game game = new Game(strategyX, strategyO);
        game.play();
        List<MoveMark> moves = game.getMoves();
        assertThat(moves.size(), equalTo(7));
        Player winner = TicTacToe.getWinner(game.getEndPosition());
        assertThat(winner, equalTo(Player.X));
    }

    @Test
    public void playDeterministicVersusBetter() {
        System.out.println("Deterministic strategy <-> Better strategy");
        Strategy strategyX = new SimpleStrategy();
        Strategy strategyO = new BetterStrategy();
        Game game = new Game(strategyX, strategyO);
        game.play();
        List<MoveMark> moves = game.getMoves();
        assertThat(moves.size(), equalTo(6));
        Player winner = TicTacToe.getWinner(game.getEndPosition());
        assertThat(winner, equalTo(Player.O));
    }

    @Test
    public void playSimpleVersusSimple() {
        System.out.println("Simple strategy <-> Simple strategy");
        Strategy strategyX = new SimpleStrategy();
        Strategy strategyO = new SimpleStrategy();
        Game game = new Game(strategyX, strategyO);
        game.play();
        List<MoveMark> moves = game.getMoves();
        assertThat(moves.size(), equalTo(7));
        Player winner = TicTacToe.getWinner(game.getEndPosition());
        assertThat(winner, equalTo(Player.X));
    }

    @Test
    public void playSimpleVersusDefensive() {
        System.out.println("Simple strategy <-> Defensive strategy");
        Strategy strategyX = new SimpleStrategy();
        Strategy strategyO = new DefensiveStrategy();
        Game game = new Game(strategyX, strategyO);
        game.play();
        List<MoveMark> moves = game.getMoves();
        assertThat(moves.size(), equalTo(7));
        Player winner = TicTacToe.getWinner(game.getEndPosition());
        assertThat(winner, equalTo(Player.X));
    }

    @Test
    public void playOptimalVersusOptimal() {
        System.out.println("Optimal strategy <-> Optimal strategy");
        Strategy strategyX = new OptimalStrategy();
        Strategy strategyO = new OptimalStrategy();
        Game game = new Game(strategyX, strategyO);
        game.play();
        List<MoveMark> moves = game.getMoves();
        assertThat(moves.size(), equalTo(7));
        Player winner = TicTacToe.getWinner(game.getEndPosition());
        assertThat(winner, equalTo(Player.X));
    }
}
