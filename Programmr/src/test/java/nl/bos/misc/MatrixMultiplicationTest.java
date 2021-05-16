package nl.bos.misc;

import org.junit.Assert;
import org.junit.Test;

public class MatrixMultiplicationTest {

    @Test
    public void multiplyMatrices1Test() {
        //given
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 1},
        };
        int[][] matrix2 = {
                {1, 2, 3},
                {3, 2, 1},
                {4, 5, 2},
        };
        int[][] expects = {
                {19, 21, 11},
                {43, 48, 29},
                {35, 35, 31},
        };
        //when
        int[][] actuals = MatrixMultiplication.multiplyMatrices(matrix1, matrix2);
        //then
        Assert.assertArrayEquals(expects, actuals);
    }

    @Test
    public void multiplyMatrices2Test() {
        //given
        int[][] matrix1 = {
                {4, 4, 4},
                {2, 2, 2},
                {3, 3, 3},
        };
        int[][] matrix2 = {
                {1, 4, 3},
                {3, 2, 4},
                {1, 2, 4},
        };
        int[][] expects = {
                {20, 32, 44},
                {10, 16, 22},
                {15, 24, 33},
        };
        //when
        int[][] actuals = MatrixMultiplication.multiplyMatrices(matrix1, matrix2);
        //then
        Assert.assertArrayEquals(expects, actuals);
    }

    @Test
    public void multiplyMatrices3Test() {
        //given
        int[][] matrix1 = {
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3},
        };
        int[][] matrix2 = {
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3},
        };
        int[][] expects = {
                {6, 6, 6},
                {12, 12, 12},
                {18, 18, 18},
        };
        //when
        int[][] actuals = MatrixMultiplication.multiplyMatrices(matrix1, matrix2);
        //then
        Assert.assertArrayEquals(expects, actuals);
    }

    @Test
    public void multiplyMatrices4Test() {
        //given
        int[][] matrix1 = {
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2},
        };
        int[][] matrix2 = {
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2},
        };
        int[][] expects = {
                {12, 12, 12},
                {12, 12, 12},
                {12, 12, 12},
        };
        //when
        int[][] actuals = MatrixMultiplication.multiplyMatrices(matrix1, matrix2);
        //then
        Assert.assertArrayEquals(expects, actuals);
    }
}