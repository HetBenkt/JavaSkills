package nl.bos.games;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpleCircleCollisionDetectionTest {
    @Test
    public void test1() {
        assertTrue(SimpleCircleCollisionDetection.isCircleCollision(new int[]{10, 0, 0}, new int[]{10, 10, 10}));
    }

    @Test
    public void test2() {
        assertTrue(SimpleCircleCollisionDetection.isCircleCollision(new int[]{10, 0, 0}, new int[]{5, 0, 0}));
    }

    @Test
    public void test3() {
        assertTrue(SimpleCircleCollisionDetection.isCircleCollision(new int[]{1, 0, 0}, new int[]{1, 0, 0}));
    }

    @Test
    public void test4() {
        assertFalse(SimpleCircleCollisionDetection.isCircleCollision(new int[]{5, 0, 0}, new int[]{5, 10, 10}));
    }

    @Test
    public void test5() {
        assertFalse(SimpleCircleCollisionDetection.isCircleCollision(new int[]{1, 0, 0}, new int[]{1, 10, 10}));
    }

    @Test
    public void test6() {
        assertTrue(SimpleCircleCollisionDetection.isCircleCollision(new int[]{5, 3, 2}, new int[]{4, 11, 2}));
    }
}