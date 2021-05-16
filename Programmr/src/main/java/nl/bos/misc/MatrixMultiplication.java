package nl.bos.misc;

import java.util.Scanner;

public class MatrixMultiplication {

    public static void main(String[] args) {
        int[][] matrix1 = new int[3][3];
        int[][] matrix2 = new int[3][3];

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Matrix 1st [" + i + "][" + j + "]:");
                matrix1[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Matrix 2nd [" + i + "][" + j + "]:");
                matrix2[i][j] = scan.nextInt();
            }
        }

        int[][] matrixMultiplied = multiplyMatrices(matrix1, matrix2);

        System.out.println("Multiply of both matrix:");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrixMultiplied[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] matrixMultiplied = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    matrixMultiplied[i][j] += (matrix1[i][k] * matrix2[k][j]);
                }
            }
        }

        return matrixMultiplied;
    }
}