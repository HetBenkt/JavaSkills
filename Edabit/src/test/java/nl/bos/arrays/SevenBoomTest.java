package nl.bos.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SevenBoomTest {
    @Test
    public void test1() {
        assertEquals(SevenBoom.BOOM, SevenBoom.sevenBoom(new int[]{2, 6, 7, 9, 3}));
    }

    @Test
    public void test2() {
        assertEquals(SevenBoom.NO_SEVEN, SevenBoom.sevenBoom(new int[]{33, 68, 400, 5}));
    }

    @Test
    public void test3() {
        assertEquals(SevenBoom.NO_SEVEN, SevenBoom.sevenBoom(new int[]{86, 48, 100, 66}));
    }

    @Test
    public void test4() {
        assertEquals(SevenBoom.BOOM, SevenBoom.sevenBoom(new int[]{76, 55, 44, 32}));
    }

    @Test
    public void test5() {
        assertEquals(SevenBoom.BOOM, SevenBoom.sevenBoom(new int[]{35, 4, 9, 37}));
    }
}