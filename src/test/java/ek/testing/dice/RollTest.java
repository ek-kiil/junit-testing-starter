package ek.testing.dice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// Task 1: a unit test
class RollTest {

    @Test
    void theScoreIsTheSumOfTheTwoDice() {
        Roll roll = new Roll(3, 4);

        int score = roll.score();

        assertEquals(7, score);
    }

    @Test
    void aPairCountsDouble() {
        Roll roll = new Roll(4, 4);

        int score = roll.score();

        assertEquals(8, score);
    }
}
