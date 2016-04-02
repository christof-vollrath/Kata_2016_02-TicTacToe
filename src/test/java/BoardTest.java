import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

public class BoardTest {
    Board board = new Board();

    @Test
    public void set_x() {
        board.set(0, 0, Player.X);
        assertThat(board.toString(), equalTo("x  \n   \n   \n"));
    }

    @Test
    public void set_o() {
        board.set(1, 1, Player.O);
        assertThat(board.toString(), equalTo("   \n o \n   \n"));
    }

    @Test(expected=IllegalStateException.class)
    public void can_not_set_a_mark_when_already_set() {
        board.set(2, 2, Player.X);
        board.set(2, 2, Player.O);
    }

    @Test
    public void isFull_empty_board() {
        assertFalse(board.isFull());
    }

    @Test
    public void isFull_board_with_mark() {
        board.set(0, 0, Player.X);
        assertFalse(board.isFull());
    }

    @Test
    public void isFull_board_full() {
        board.set(0, 0, Player.X);
        board.set(0, 1, Player.X);
        board.set(0, 2, Player.X);
        board.set(1, 0, Player.X);
        board.set(1, 1, Player.X);
        board.set(1, 2, Player.X);
        board.set(2, 0, Player.X);
        board.set(2, 1, Player.X);
        board.set(2, 2, Player.X);
        assertTrue(board.isFull());
    }

    @Test
    public void checkLine_empty_board() {
        assertFalse(board.checkLines(Player.X));
    }

    @Test
    public void checkLine_no_line() {
        board.set(0, 0, Player.X);
        board.set(1, 1, Player.X);
        board.set(2, 0, Player.X);
        assertFalse(board.checkLines(Player.X));
    }

    @Test
    public void checkLine_line_00_20() {
        board.set(0, 0, Player.X);
        board.set(1, 0, Player.X);
        board.set(2, 0, Player.X);
        assertTrue(board.checkLines(Player.X));
    }

    @Test
    public void checkLine_line_02_22() {
        board.set(0, 2, Player.X);
        board.set(1, 2, Player.X);
        board.set(2, 2, Player.X);
        assertTrue(board.checkLines(Player.X));
    }

    @Test
    public void checkLine_line_10_12() {
        board.set(1, 0, Player.X);
        board.set(1, 1, Player.X);
        board.set(1, 2, Player.X);
        assertTrue(board.checkLines(Player.X));
    }

    @Test
    public void checkLine_line_00_22() {
        board.set(0, 0, Player.X);
        board.set(1, 1, Player.X);
        board.set(2, 2, Player.X);
        assertTrue(board.checkLines(Player.X));
    }

    @Test
    public void checkLine_line_02_20() {
        board.set(0, 2, Player.X);
        board.set(1, 1, Player.X);
        board.set(2, 0, Player.X);
        assertTrue(board.checkLines(Player.X));
    }

    @Test
    public void getPossibleMoves_empty_board() {
        assertThat(board.getPossibleMoves(), containsInAnyOrder(
                new Move(0,0), new Move(1,0), new Move(2,0),
                new Move(0,1), new Move(1,1), new Move(2,1),
                new Move(0,2), new Move(1,2), new Move(2,2)
        ));
    }

    @Test
    public void getPossibleMoves_filled_board() {
        board.set(0, 2, Player.X);
        board.set(1, 1, Player.O);
        board.set(2, 0, Player.X);
        assertThat(board.getPossibleMoves(), containsInAnyOrder(
                new Move(0,0), new Move(1,0),
                new Move(0,1),                new Move(2,1),
                               new Move(1,2), new Move(2,2)
        ));
    }

    @Test
    public void getPossibleMoves_full_board() {
        board.set(0, 0, Player.X);
        board.set(1, 0, Player.X);
        board.set(2, 0, Player.X);
        board.set(0, 1, Player.O);
        board.set(1, 1, Player.O);
        board.set(2, 1, Player.O);
        board.set(0, 2, Player.X);
        board.set(1, 2, Player.X);
        board.set(2, 2, Player.X);
        assertThat(board.getPossibleMoves(), empty());
    }
}
