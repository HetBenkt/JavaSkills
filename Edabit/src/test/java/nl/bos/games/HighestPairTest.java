package nl.bos.games;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HighestPairTest {

    @Test
    public void test1() {
        assertEquals("A", HighestPair.highestPair(new String[]{"K", "K", "A", "A", "3"}));
    }

    @Test
    public void test2() {
        assertEquals("", HighestPair.highestPair(new String[]{"A", "K", "Q", "J", "10"}));
    }

    @Test
    public void test3() {
        assertEquals("K", HighestPair.highestPair(new String[]{"A", "K", "K", "K", "Q"}));
    }

    @Test
    public void test4() {
        assertEquals("K", HighestPair.highestPair(new String[]{"A", "K", "K", "K", "Q"}));
    }

    @Test
    public void test5() {
        assertEquals("Q", HighestPair.highestPair(new String[]{"A", "K", "Q", "Q", "5"}));
    }
}