package nl.bos.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsecutiveNumbersTest {
    @Test
    public void test1() {
        assertEquals(true, ConsecutiveNumbers.cons(new int[]{5, 1, 4, 3, 2}));
    }

    @Test
    public void test2() {
        assertEquals(true, ConsecutiveNumbers.cons(new int[]{55, 59, 58, 56, 57}));
    }

    @Test
    public void test3() {
        assertEquals(true, ConsecutiveNumbers.cons(new int[]{-3, -2, -1, 1, 0}));
    }

    @Test
    public void test4() {
        assertEquals(false, ConsecutiveNumbers.cons(new int[]{5, 1, 4, 3, 2, 8}));
    }

    @Test
    public void test5() {
        assertEquals(false, ConsecutiveNumbers.cons(new int[]{5, 6, 7, 8, 9, 9}));
    }

    @Test
    public void test6() {
        assertEquals(false, ConsecutiveNumbers.cons(new int[]{5, 3}));
    }
}