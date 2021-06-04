package nl.bos.misc;

import org.junit.Assert;
import org.junit.Test;

public class NameSearchTest {

    @Test
    public void getSurNameTest() {
        //given
        String expected = "potter";
        //when
        String actual = NameSearch.getSurName("harry");
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getWrongSurNameTest() {
        //when
        String actual = NameSearch.getSurName("dummy2");
        //then
        Assert.assertNull(actual);
    }
}