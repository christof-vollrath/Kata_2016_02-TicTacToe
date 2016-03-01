import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

public class TicTacToeTest {
    TicTacToe ticTacToe = new TicTacToe();

    @Test
    public void set_x() {
        ticTacToe.set(0, 0, TicTacToe.Mark.X);
        assertThat(ticTacToe.toString(), equalTo("x  \n   \n   \n"));
    }

    @Test
    public void set_o() {
        ticTacToe.set(1, 1, TicTacToe.Mark.O);
        assertThat(ticTacToe.toString(), equalTo("   \n o \n   \n"));
    }

    @Test(expected=IllegalStateException.class)
    public void can_not_set_a_mark_when_already_set() {
        ticTacToe.set(2, 2, TicTacToe.Mark.X);
        ticTacToe.set(2, 2, TicTacToe.Mark.O);
    }

    @Test
    public void isFull_empty_board() {
        assertFalse(ticTacToe.isFull());
    }

    @Test
    public void isFull_board_with_mark() {
        ticTacToe.set(0, 0, TicTacToe.Mark.X);
        assertFalse(ticTacToe.isFull());
    }

    @Test
    public void isFull_board_full() {
        ticTacToe.set(0, 0, TicTacToe.Mark.X);
        ticTacToe.set(0, 1, TicTacToe.Mark.X);
        ticTacToe.set(0, 2, TicTacToe.Mark.X);
        ticTacToe.set(1, 0, TicTacToe.Mark.X);
        ticTacToe.set(1, 1, TicTacToe.Mark.X);
        ticTacToe.set(1, 2, TicTacToe.Mark.X);
        ticTacToe.set(2, 0, TicTacToe.Mark.X);
        ticTacToe.set(2, 1, TicTacToe.Mark.X);
        ticTacToe.set(2, 2, TicTacToe.Mark.X);
        assertTrue(ticTacToe.isFull());
    }

    @Test
    public void checkLine_empty_board() {
        assertFalse(ticTacToe.checkLines(TicTacToe.Mark.X));
    }

    @Test
    public void checkLine_no_line() {
        ticTacToe.set(0, 0, TicTacToe.Mark.X);
        ticTacToe.set(1, 1, TicTacToe.Mark.X);
        ticTacToe.set(2, 0, TicTacToe.Mark.X);
        assertFalse(ticTacToe.checkLines(TicTacToe.Mark.X));
    }

    @Test
    public void checkLine_line_00_20() {
        ticTacToe.set(0, 0, TicTacToe.Mark.X);
        ticTacToe.set(1, 0, TicTacToe.Mark.X);
        ticTacToe.set(2, 0, TicTacToe.Mark.X);
        assertTrue(ticTacToe.checkLines(TicTacToe.Mark.X));
    }

    @Test
    public void checkLine_line_02_22() {
        ticTacToe.set(0, 2, TicTacToe.Mark.X);
        ticTacToe.set(1, 2, TicTacToe.Mark.X);
        ticTacToe.set(2, 2, TicTacToe.Mark.X);
        assertTrue(ticTacToe.checkLines(TicTacToe.Mark.X));
    }

    @Test
    public void checkLine_line_10_12() {
        ticTacToe.set(1, 0, TicTacToe.Mark.X);
        ticTacToe.set(1, 1, TicTacToe.Mark.X);
        ticTacToe.set(1, 2, TicTacToe.Mark.X);
        assertTrue(ticTacToe.checkLines(TicTacToe.Mark.X));
    }

    @Test
    public void checkLine_line_00_22() {
        ticTacToe.set(0, 0, TicTacToe.Mark.X);
        ticTacToe.set(1, 1, TicTacToe.Mark.X);
        ticTacToe.set(2, 2, TicTacToe.Mark.X);
        assertTrue(ticTacToe.checkLines(TicTacToe.Mark.X));
    }

}
