import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SimpleStrategyTest {
    Board board = new Board();

    @Test
    public void when_no_line_can_be_created_place_to_next_free_position() {
        Move move = new SimpleStrategy().nextMove(Player.X, board);
        assertThat(move.getX(), equalTo(0));
        assertThat(move.getY(), equalTo(0));
    }

    @Test
    public void creat_a_line_if_possible() {
        board.set(1, 0, Player.X);
        board.set(1, 2, Player.X);
        board.set(0, 0, Player.O);
        board.set(0, 1, Player.O);

        Move move = new SimpleStrategy().nextMove(Player.X, board);
        assertThat(move.getX(), equalTo(1));
        assertThat(move.getY(), equalTo(1));
    }
}
