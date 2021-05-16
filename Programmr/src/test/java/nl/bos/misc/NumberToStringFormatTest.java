package nl.bos.misc;

import org.junit.Assert;
import org.junit.Test;

public class NumberToStringFormatTest {

    @Test
    public void numberToString1Test() {
        //given
        int num = 1;
        String expected = "one";
        //when
        String actual = NumberToStringFormat.numberToString(num);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void numberToString19Test() {
        //given
        int num = 19;
        String expected = "ninteen";
        //when
        String actual = NumberToStringFormat.numberToString(num);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void numberToString20Test() {
        //given
        int num = 20;
        String expected = "twenty";
        //when
        String actual = NumberToStringFormat.numberToString(num);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void numberToString21Test() {
        //given
        int num = 21;
        String expected = "twenty one";
        //when
        String actual = NumberToStringFormat.numberToString(num);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void numberToString90Test() {
        //given
        int num = 90;
        String expected = "ninty";
        //when
        String actual = NumberToStringFormat.numberToString(num);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void numberToString99Test() {
        //given
        int num = 99;
        String expected = "ninty nine";
        //when
        String actual = NumberToStringFormat.numberToString(num);
        //then
        Assert.assertEquals(expected, actual);
    }
}