package nl.bos.kyu8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EvenOrOddTest {
    @Test
    public void testEvenOrOdd() {
        EvenOrOdd evenOrOdd = new EvenOrOdd();
        assertEquals(evenOrOdd.evenOrOdd(6), "Even");
        assertEquals(evenOrOdd.evenOrOdd(7), "Odd");
    }
}
