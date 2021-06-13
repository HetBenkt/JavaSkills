package nl.bos.games;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RockPaperScissorsTest {

    @Test
    public void test1() {
        assertEquals("Player 1 wins", RockPaperScissors.rps("rock", "scissors"));
    }

    @Test
    public void test2() {
        assertEquals("Player 1 wins", RockPaperScissors.rps("paper", "rock"));
    }

    @Test
    public void test3() {
        assertEquals("Player 1 wins", RockPaperScissors.rps("scissors", "paper"));
    }

    @Test
    public void test4() {
        assertEquals("Player 2 wins", RockPaperScissors.rps("scissors", "rock"));
    }

    @Test
    public void test5() {
        assertEquals("Player 2 wins", RockPaperScissors.rps("rock", "paper"));
    }

    @Test
    public void test6() {
        assertEquals("Player 2 wins", RockPaperScissors.rps("paper", "scissors"));
    }

    @Test
    public void test7() {
        assertEquals("TIE", RockPaperScissors.rps("scissors", "scissors"));
    }

}