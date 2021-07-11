package nl.bos.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PerimeterOfTriangleTest {
    @Test
    public void test1() {
        int[][] arr = new int[3][2];
        arr[0][0] = 0;
        arr[0][1] = 0;
        arr[1][0] = 1;
        arr[1][1] = 0;
        arr[2][0] = 0;
        arr[2][1] = 1;
        assertEquals(3.42, PerimeterOfTriangle.perimeter(arr), 0.1);
    }

    @Test
    public void test2() {
        int[][] arr = new int[3][2];
        arr[0][0] = 15;
        arr[0][1] = 7;
        arr[1][0] = 5;
        arr[1][1] = 22;
        arr[2][0] = 11;
        arr[2][1] = 1;
        assertEquals(47.08, PerimeterOfTriangle.perimeter(arr), 0.1);
    }

    @Test
    public void test3() {
        int[][] arr = new int[3][2];
        arr[0][0] = 7;
        arr[0][1] = 6;
        arr[1][0] = 0;
        arr[1][1] = 11;
        arr[2][0] = 0;
        arr[2][1] = -3;
        assertEquals(34.00, PerimeterOfTriangle.perimeter(arr), 0.1);
    }

    @Test
    public void test4() {
        int[][] arr = new int[3][2];
        arr[0][0] = -10;
        arr[0][1] = -10;
        arr[1][0] = 10;
        arr[1][1] = 10;
        arr[2][0] = -10;
        arr[2][1] = 10;
        assertEquals(68.28, PerimeterOfTriangle.perimeter(arr), 0.1);
    }

    @Test
    public void test5() {
        int[][] arr = new int[3][2];
        arr[0][0] = 3;
        arr[0][1] = 4;
        arr[1][0] = 4;
        arr[1][1] = 3;
        arr[2][0] = 4;
        arr[2][1] = 5;
        assertEquals(4.82, PerimeterOfTriangle.perimeter(arr), 0.1);
    }

    @Test
    public void test6() {
        int[][] arr = new int[3][2];
        arr[0][0] = -10;
        arr[0][1] = -20;
        arr[1][0] = -30;
        arr[1][1] = -40;
        arr[2][0] = -50;
        arr[2][1] = -60;
        assertEquals(113.13, PerimeterOfTriangle.perimeter(arr), 0.1);
    }

    @Test
    public void test7() {
        int[][] arr = new int[3][2];
        arr[0][0] = 382;
        arr[0][1] = 894;
        arr[1][0] = 389;
        arr[1][1] = 312;
        arr[2][0] = 500;
        arr[2][1] = 993;
        assertEquals(1426.05, PerimeterOfTriangle.perimeter(arr), 0.1);
    }
}