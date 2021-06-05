package nl.bos.misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountOnesTest {

    @Test
    public void count1Test() {
        //given
        int minInput = 1;
        long maxInput = 11;
        long expected = 4;
        //when
        long actual = CountOnes.count(minInput, maxInput);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void count2Test() {
        //given
        int minInput = 11;
        long maxInput = 111;
        long expected = 34;
        //when
        long actual = CountOnes.count(minInput, maxInput);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void count3Test() {
        //given
        int minInput = 1;
        long maxInput = 99999;
        long expected = 50000;
        //when
        long actual = CountOnes.count(minInput, maxInput);
        //then
        assertEquals(expected, actual);
    }
}