package nl.bos.misc;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class PascalTriangleTest {
    @Test
    public void buildTriangle4Test() {
        //given
        int input = 4;
        int width = input * 2;
        int height = input;
        String[][] expecteds = {
                {"_", "_", "_", "1", "_", "", "", ""},
                {"_", "_", "1", "_", "1", "_", "", ""},
                {"_", "1", "_", "2", "_", "1", "_", ""},
                {"1", "_", "3", "_", "3", "_", "1", "_"}
        };
        //when
        String[][] actuals = PascalTriangle.buildTriangle(width, height);
        //then
        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void buildTriangle5Test() {
        //given
        int input = 5;
        int width = input * 2;
        int height = input;
        String[][] expecteds = {
                {"_", "_", "_", "_", "1", "_", "", "", "", ""},
                {"_", "_", "_", "1", "_", "1", "_", "", "", ""},
                {"_", "_", "1", "_", "2", "_", "1", "_", "", ""},
                {"_", "1", "_", "3", "_", "3", "_", "1", "_", ""},
                {"1", "_", "4", "_", "6", "_", "4", "_", "1", "_"}
        };
        //when
        String[][] actuals = PascalTriangle.buildTriangle(width, height);
        //then
        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Ignore("Just to see if array size is correct!")
    @Test
    public void buildTriangleCleanTest() {
        //given
        int input = 2;
        int width = input * 2;
        int height = input;
        String[][] expecteds = {
                {"_", "_", "_", "_"},
                {"_", "_", "_", "_"}
        };
        //when
        String[][] actuals = PascalTriangle.buildTriangle(width, height);
        //then
        Assert.assertArrayEquals(expecteds, actuals);
    }
}