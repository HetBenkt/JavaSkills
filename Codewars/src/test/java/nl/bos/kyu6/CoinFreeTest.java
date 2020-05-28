package nl.bos.kyu6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinFreeTest {
    private final int[] coins1 = {1, 5, 10, 25};
    private final int[] coins2 = {1, 2, 5, 10, 20, 50};
    private final int[] coins3 = {8, 32, 1, 2};

    @Test
    public void basicTests() {
        assertEquals("75 is 25+25+25", 3, CoinFree.solve(75, coins1));
        assertEquals("123 is 25+25+25+25+10+10+1+1+1", 9, CoinFree.solve(123, coins1));
        assertEquals("75 is 50+20+5", 3, CoinFree.solve(75, coins2));
        assertEquals("123 is 50+50+20+2+1", 5, CoinFree.solve(123, coins2));
    }

    @Test
    public void advancedTests() {
        assertEquals(32207592, CoinFree.solve(1030642781, coins3));
    }
}