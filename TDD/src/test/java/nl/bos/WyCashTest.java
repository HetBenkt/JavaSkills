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
        Money five = Money.getFranc(5);
        assertEquals(Money.getFranc(10), five.times(2));
        assertEquals(Money.getFranc(15), five.times(3));
    }

    @Test
    public void testEquality() {
        assertTrue(Money.getDollar(5).equals(Money.getDollar(5)));
        assertFalse(Money.getDollar(5).equals(Money.getDollar(6)));
        assertTrue(Money.getFranc(5).equals(Money.getFranc(5)));
    }

    @Test
    public void testCurrency() {
        assertEquals("USD", Money.getDollar(1).getCurrency());
        assertEquals("CHF", Money.getFranc(1).getCurrency());
    }

    @Test
    public void testDifferentClassEquality() {
        assertTrue(new Money(10, "CHF").equals(new Franc(10, "CHF")));
    }

    @Test
    public void testSimpleAddition() {
        Money five = Money.getDollar(5);
        IExpression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.getDollar(10), reduced);
    }

    @Test
    public void testPlusReturnsSum() {
        Money five = Money.getDollar(5);
        IExpression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.getAugend());
        assertEquals(five, sum.getAddend());
    }

    @Test
    public void testReduceSum() {
        IExpression sum = new Sum(Money.getDollar(3), Money.getDollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.getDollar(7), result);
    }

    @Test
    public void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.getDollar(1), "USD");
        assertEquals(Money.getDollar(1), result);
    }

    @Test
    public void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.getFranc(2), "USD");
        assertEquals(Money.getDollar(1), result);
    }

    @Test
    public void testArrayEquals() {
        assertEquals(new Object[]{"abc"}, new Object[]{"abc"});
    }

    @Test
    public void testIdentityRate() {
        assertEquals(1, new Bank().rate("USD", "USD"));
    }
}
