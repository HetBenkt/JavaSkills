package nl.bos.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindOddIntegerTest {
    @Test
    public void test1() {
        assertEquals(5, FindOddInteger.findOdd(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));
    }

    @Test
    public void test2() {
        assertEquals(-1, FindOddInteger.findOdd(new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5}));
    }

    @Test
    public void test3() {
        assertEquals(5, FindOddInteger.findOdd(new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5}));
    }

    @Test
    public void test4() {
        assertEquals(10, FindOddInteger.findOdd(new int[]{10}));
    }

    @Test
    public void test5() {
        assertEquals(10, FindOddInteger.findOdd(new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1}));
    }

    @Test
    public void test6() {
        assertEquals(1, FindOddInteger.findOdd(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10}));
    }
}