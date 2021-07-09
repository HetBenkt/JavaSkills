package nl.bos.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PerfectSquarePatchTest {
    @Test
    public void test1() {
        assertArrayEquals(PerfectSquarePatch.squarePatch(3), new int[][]{
                {3, 3, 3},
                {3, 3, 3},
                {3, 3, 3}
        });
    }

    @Test
    public void test2() {
        assertArrayEquals(PerfectSquarePatch.squarePatch(2), new int[][]{
                {2, 2},
                {2, 2}
        });
    }

    @Test
    public void test3() {
        assertArrayEquals(PerfectSquarePatch.squarePatch(4), new int[][]{
                {4, 4, 4, 4},
                {4, 4, 4, 4},
                {4, 4, 4, 4},
                {4, 4, 4, 4}
        });
    }

    @Test
    public void test4() {
        assertArrayEquals(PerfectSquarePatch.squarePatch(6), new int[][]{
                {6, 6, 6, 6, 6, 6},
                {6, 6, 6, 6, 6, 6},
                {6, 6, 6, 6, 6, 6},
                {6, 6, 6, 6, 6, 6},
                {6, 6, 6, 6, 6, 6},
                {6, 6, 6, 6, 6, 6}
        });
    }

    @Test
    public void test5() {
        assertArrayEquals(PerfectSquarePatch.squarePatch(5), new int[][]{
                {5, 5, 5, 5, 5},
                {5, 5, 5, 5, 5},
                {5, 5, 5, 5, 5},
                {5, 5, 5, 5, 5},
                {5, 5, 5, 5, 5}
        });
    }

    @Test
    public void test6() {
        assertArrayEquals(PerfectSquarePatch.squarePatch(1), new int[][]{{1}});
    }

    @Test
    public void test7() {
        assertArrayEquals(PerfectSquarePatch.squarePatch(0), new int[][]{});
    }
}