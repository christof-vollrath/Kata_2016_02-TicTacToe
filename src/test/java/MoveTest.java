import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class MoveTest {
    @Test
    public void identical_moves_should_be_equal() {
        Move move = new Move(0, 0);
        assertThat(move, equalTo(move));
    }

    @Test
    public void equal_moves_should_be_equal() {
        Move move1 = new Move(0, 1);
        Move move2 = new Move(0, 1);
        assertThat(move1, equalTo(move2));
    }

    @Test
    public void unequal_moves_should_be_unequal() {
        Move move1 = new Move(0, 1);
        Move move2 = new Move(1, 1);
        assertThat(move1, not(equalTo(move2)));
    }

    @Test
    public void set_should_find_objects() {
        Set<Move> moves = new HashSet<Move>() {{
                add(new Move(0, 0)); add(new Move(0, 1)); add(new Move(1, 2));
            }};
        assertThat(moves.contains(new Move(0, 0)), is(true));
        assertThat(moves.contains(new Move(0, 1)), is(true));
        assertThat(moves.contains(new Move(1, 2)), is(true));

        assertThat(moves.contains(new Move(2, 2)), not(true));
    }
}
