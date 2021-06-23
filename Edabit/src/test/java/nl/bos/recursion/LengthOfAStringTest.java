package nl.bos.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LengthOfAStringTest {
    @Test
    public void test1() {
        assertEquals(8, LengthOfAString.length("shipment"));
    }

    @Test
    public void test2() {
        assertEquals(5, LengthOfAString.length("apple"));
    }

    @Test
    public void test3() {
        assertEquals(4, LengthOfAString.length("make"));
    }

    @Test
    public void test4() {
        assertEquals(1, LengthOfAString.length("a"));
    }

    @Test
    public void test5() {
        assertEquals(0, LengthOfAString.length(""));
    }
}