package nl.bos.games;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TowerOfHanoiTest {

    @Test
    public void test1() {
        assertEquals(7, TowerOfHanoi.towerHanoi(3));
    }

    @Test
    public void test2() {
        assertEquals(31, TowerOfHanoi.towerHanoi(5));
    }

    @Test
    public void test3() {
        assertEquals(255, TowerOfHanoi.towerHanoi(8));
    }

    @Test
    public void test4() {
        assertEquals(524287, TowerOfHanoi.towerHanoi(19));
    }

    @Test
    public void test5() {
        assertEquals(511, TowerOfHanoi.towerHanoi(9));
    }

    @Test
    public void test6() {
        assertEquals(8191, TowerOfHanoi.towerHanoi(13));
    }

    @Test
    public void test7() {
        assertEquals(0, TowerOfHanoi.towerHanoi(0));
    }
}