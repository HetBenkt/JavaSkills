package nl.bos.misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumOfNaturalsDivisibleBy3And5Test {

    @Test
    public void sum1Test() {
        //given
        int input = 10;
        int expected = 23;
        //when
        int actual = SumOfNaturalsDivisibleBy3And5.sum(input);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void sum2Test() {
        //given
        int input = 20;
        int expected = 78;
        //when
        int actual = SumOfNaturalsDivisibleBy3And5.sum(input);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void sum3Test() {
        //given
        int input = 15;
        int expected = 45;
        //when
        int actual = SumOfNaturalsDivisibleBy3And5.sum(input);
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void sum4Test() {
        //given
        int input = 1000;
        int expected = 233168;
        //when
        int actual = SumOfNaturalsDivisibleBy3And5.sum(input);
        //then
        assertEquals(expected, actual);
    }
}