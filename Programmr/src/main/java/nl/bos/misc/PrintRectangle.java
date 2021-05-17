package nl.bos.misc;

import java.util.Scanner;

public class PrintRectangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the height:");
        int height = scan.nextInt();
        System.out.println("Enter the width:");
        int width = scan.nextInt();

        String[][] rect = buildRect(width, height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(rect[i][j]);
            }
            System.out.println();
        }
    }

    public static String[][] buildRect(int width, int height) {
        String[][] rect = new String[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                rect[i][j] = " ";
                if (i == 0 || i == height - 1) {
                    rect[i][j] = "*";
                } else if (j == 0 || j == width - 1) {
                    rect[i][j] = "*";
                }
            }
        }
        return rect;
    }
}