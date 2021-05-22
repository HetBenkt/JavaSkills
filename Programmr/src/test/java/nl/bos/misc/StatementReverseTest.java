package nl.bos.misc;

import org.junit.Assert;
import org.junit.Test;

public class StatementReverseTest {

    @Test
    public void reverseTest() {
        //given
        String statement = "this is me";
        String expected = "me is this";

        //when
        String actual = StatementReverse.reverse(statement);

        //then
        Assert.assertEquals(expected, actual);
    }

}