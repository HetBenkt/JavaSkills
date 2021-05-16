package nl.bos.misc;

import java.util.Scanner;

public class QuadrantOfAnAngle {

    public static void main(String[] args) {
        System.out.println("Type an integer angle (in degrees) and press Enter:");
        Scanner sc = new Scanner(System.in);
        int angle = sc.nextInt();

        int quadrant = calcQuadrant(angle);

        System.out.println("Quadrant is:");
        System.out.println(quadrant);
    }

    public static int calcQuadrant(int angle) {
        float calc = angle / 90F;
        return Math.ceil(calc) < 5 ? (int) Math.ceil(calc) : (int) Math.ceil(calc) - 4;
    }
}
