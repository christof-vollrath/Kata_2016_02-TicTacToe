import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.IsEqual.equalTo;

public class OptimalStrategyTest {
    Board board = new Board();

    @Test
    public void no_optimal_move_possible() {
        Move move = new OptimalStrategy().nextMove(Player.X, board);
        assertThat(move.getX(), equalTo(0));
        assertThat(move.getY(), equalTo(0));
    }

    @Test
    public void there_is_an_optimal_strategy_if_you_have_one_mark_advantage() {
        board.set(0, 0, Player.X);

        Move move = new OptimalStrategy().nextMove(Player.X, board);
        assertThat(move.getX(), equalTo(2));
        assertThat(move.getY(), equalTo(2));
    }

    @Test
    public void find_winning_move() {
        board.set(0, 0, Player.X);
        board.set(2, 2, Player.X);

        Move move = new OptimalStrategy().nextMove(Player.X, board);
        assertThat(move.getX(), equalTo(1));
        assertThat(move.getY(), equalTo(1));
    }

    @Test
    public void block_oponent_winning_move() {
        board.set(0, 0, Player.O);
        board.set(2, 2, Player.O);

        Move move = new OptimalStrategy().nextMove(Player.X, board);
        assertThat(move.getX(), equalTo(1));
        assertThat(move.getY(), equalTo(1));
    }

    @Test
    public void there_is_an_easy_optimal_strategy_if_you_have_two_marks_advantage() {
        board.set(0, 0, Player.X);
        board.set(1, 2, Player.X);

        Move move = new OptimalStrategy().nextMove(Player.X, board);
        assertThat(move.getX(), equalTo(0));
        assertThat(move.getY(), equalTo(2));
    }

    @Test
    public void lookAhead_should_find_wining_move() {
        board.set(0, 0, Player.O);
        board.set(2, 2, Player.O);

        Player mark = new OptimalStrategy().lookAhead(Player.O, board);
        assertThat(mark, equalTo(Player.O));
    }
}
