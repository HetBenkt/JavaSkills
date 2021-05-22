package nl.bos.misc;

import org.junit.Assert;
import org.junit.Test;

public class PrintRectangleTest {

    @Test
    public void buildRectTest() {
        //given
        int width = 10;
        int height = 5;
        String[][] expecteds = {
                {"*", "*", "*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", " ", " ", " ", " ", " ", " ", " ", " ", "*"},
                {"*", " ", " ", " ", " ", " ", " ", " ", " ", "*"},
                {"*", " ", " ", " ", " ", " ", " ", " ", " ", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*", "*", "*"}
        };
        //when
        String[][] actuals = PrintRectangle.buildRect(width, height);
        //then
        Assert.assertArrayEquals(expecteds, actuals);
    }
}