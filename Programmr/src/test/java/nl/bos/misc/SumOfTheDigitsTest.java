package nl.bos.misc;

import org.junit.Assert;
import org.junit.Test;

public class SumOfTheDigitsTest {

    @Test
    public void getLuckyNumber7Test() {
        //given
        int expected = 7;
        String date = "131083";
        //when
        int actual = SumOfTheDigits.getLuckyNumber(date);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLuckyNumber6Test() {
        //given
        int expected = 6;
        String date = "111111";
        //when
        int actual = SumOfTheDigits.getLuckyNumber(date);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = NumberFormatException.class)
    public void getLuckyNumberFailTest() {
        //given
        String date = "abc";
        //when
        SumOfTheDigits.getLuckyNumber(date);
    }
}