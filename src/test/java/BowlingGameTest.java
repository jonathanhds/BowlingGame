import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingGameTest {

    private BowlingGame game;

    @Before
    public void setUp() {
        game = new BowlingGame();
    }

    @Test
    public void gutterGame() {
        // Given

        // When
        rollMany(20, 0);

        // Then
        assertEquals(0, game.score());
    }

    @Test
    public void allOnes() {
        // Given

        // When
        rollMany(20, 1);

        // Then
        assertEquals(20, game.score());
    }

    @Test
    public void oneSpare() {
        // Given

        // When
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollMany(17, 0);

        // Then
        assertEquals(16, game.score());
    }

    @Test
    public void oneStrike() {
        // Given

        // When
        game.roll(10);
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);

        // Then
        assertEquals(24, game.score());
    }

    @Test
    public void perfectGame() {
        // Given

        // When
        rollMany(12, 10);

        // Then
        assertEquals(300, game.score());
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }

}
