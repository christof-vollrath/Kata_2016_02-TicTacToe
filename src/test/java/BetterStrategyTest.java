import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class BetterStrategyTest {
    Board board = new Board();

    @Test
    public void when_yet_no_line_can_be_created_go_for_it() {
        board.set(0, 0, Player.X);
        board.set(0, 1, Player.O);

        Move move = new BetterStrategy().nextMove(Player.X, board);
        assertThat(move.getX(), equalTo(1));
        assertThat(move.getY(), equalTo(0));
    }

    @Test
    public void creat_a_line_if_possible() {
        board.set(1, 0, Player.X);
        board.set(1, 2, Player.X);
        board.set(0, 0, Player.O);
        board.set(0, 1, Player.O);

        Move move = new BetterStrategy().nextMove(Player.X, board);
        assertThat(move.getX(), equalTo(1));
        assertThat(move.getY(), equalTo(1));
    }
}
