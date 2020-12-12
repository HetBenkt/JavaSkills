package nl.bos.kyu7;

import org.junit.Assert;
import org.junit.Test;

public class ResponsibleDrinkingTest {
    @Test
    public void drinkinTest1() {
        ResponsibleDrinking drinking = new ResponsibleDrinking();
        String expected = "1 glass of water";
        String actual = drinking.hydrate("1 beer");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void drinkinTest3() {
        ResponsibleDrinking drinking = new ResponsibleDrinking();
        String expected = "10 glasses of water";
        String actual = drinking.hydrate("1 shot, 5 beers, 2 shots, 1 glass of wine, 1 beer");
        Assert.assertEquals(expected, actual);
    }
}