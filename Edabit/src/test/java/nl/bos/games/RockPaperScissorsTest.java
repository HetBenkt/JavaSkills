package nl.bos.games;

import org.junit.jupiter.api.Test;

import static nl.bos.games.RockPaperScissors.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RockPaperScissorsTest {

    @Test
    public void test1() {
        assertEquals(THE_WINNER_IS_P_1, RockPaperScissors.rps(ROCK, SCISSORS));
    }

    @Test
    public void test2() {
        assertEquals(THE_WINNER_IS_P_1, RockPaperScissors.rps(PAPER, ROCK));
    }

    @Test
    public void test3() {
        assertEquals(THE_WINNER_IS_P_1, RockPaperScissors.rps(SCISSORS, PAPER));
    }

    @Test
    public void test4() {
        assertEquals(THE_WINNER_IS_P_2, RockPaperScissors.rps(SCISSORS, ROCK));
    }

    @Test
    public void test5() {
        assertEquals(THE_WINNER_IS_P_2, RockPaperScissors.rps(ROCK, PAPER));
    }

    @Test
    public void test6() {
        assertEquals(THE_WINNER_IS_P_2, RockPaperScissors.rps(PAPER, SCISSORS));
    }

    @Test
    public void test7() {
        assertEquals(IT_S_A_DRAW, RockPaperScissors.rps(SCISSORS, SCISSORS));
    }

}