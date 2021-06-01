package nl.bos.misc;

import org.junit.Assert;
import org.junit.Test;

public class DecimalToOctalConversionTest {
    @Test
    public void convert81Test() {
        //given
        int input = 81;
        int expected = 121;
        //when
        int actual = DecimalToOctalConversion.convert(input);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void convert10Test() {
        //given
        int input = 10;
        int expected = 12;
        //when
        int actual = DecimalToOctalConversion.convert(input);
        //then
        Assert.assertEquals(expected, actual);
    }
}