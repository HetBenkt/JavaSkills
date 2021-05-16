package nl.bos.misc;

import org.junit.Assert;
import org.junit.Test;

public class QuadrantOfAnAngleTest {

    @Test
    public void calcQuadrant30Test() {
        //given
        int angle = 30;
        int expected = 1;
        //when
        int actual = QuadrantOfAnAngle.calcQuadrant(angle);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calcQuadrant100Test() {
        //given
        int angle = 100;
        int expected = 2;
        //when
        int actual = QuadrantOfAnAngle.calcQuadrant(angle);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calcQuadrant197Test() {
        //given
        int angle = 197;
        int expected = 3;
        //when
        int actual = QuadrantOfAnAngle.calcQuadrant(angle);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calcQuadrant361Test() {
        //given
        int angle = 361;
        int expected = 1;
        //when
        int actual = QuadrantOfAnAngle.calcQuadrant(angle);
        //then
        Assert.assertEquals(expected, actual);
    }
}