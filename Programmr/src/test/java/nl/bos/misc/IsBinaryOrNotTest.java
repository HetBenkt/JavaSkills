package nl.bos.misc;

import org.junit.Assert;
import org.junit.Test;

public class IsBinaryOrNotTest {

    @Test
    public void isBinaryTest() {
        //given
        int input = 1000100;
        //when
        boolean isBinary = IsBinaryOrNot.isBinary(input);
        //then
        Assert.assertTrue(isBinary);
    }

    @Test
    public void isNotBinaryTest() {
        //given
        int input = 1040400;
        //when
        boolean isBinary = IsBinaryOrNot.isBinary(input);
        //then
        Assert.assertFalse(isBinary);
    }
}