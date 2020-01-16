package nl.bos;

import org.junit.Test;

import static org.junit.Assert.*;

public class WyCashTest {
    @Test
    public void testDollarMultiplication() {
        Money five = Money.getDollar(5);
        assertEquals(Money.getDollar(10), five.times(2));
        assertEquals(Money.getDollar(15), five.times(3));
    }

    @Test
    public void testFrancMultiplication() {
        Franc five = Money.getFranc(5);
        assertEquals(Money.getFranc(10), five.times(2));
        assertEquals(Money.getFranc(15), five.times(3));
    }

    @Test
    public void testEquality() {
        assertTrue(Money.getDollar(5).equals(Money.getDollar(5)));
        assertFalse(Money.getDollar(5).equals(Money.getDollar(6)));
        assertTrue(Money.getFranc(5).equals(Money.getFranc(5)));
        assertFalse(Money.getFranc(5).equals(Money.getFranc(6)));
        assertFalse(Money.getFranc(5).equals(Money.getDollar(5)));
    }

    @Test
    public void testCurrency() {
        assertEquals("USD", Money.getDollar(1).getCurrency());
        assertEquals("CHF", Money.getFranc(1).getCurrency());
    }
}
