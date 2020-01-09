package nl.bos;

import org.junit.Test;

import static org.junit.Assert.*;

public class WyCashTest {
    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        Dollar product = five.times(2);
        assertEquals(10, product.getAmount());
        product = five.times(3);
        assertEquals(15, product.getAmount());
    }

    @Test
    public void testEquality() {
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(7)));
    }
}
